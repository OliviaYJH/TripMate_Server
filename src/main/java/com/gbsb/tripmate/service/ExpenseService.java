package com.gbsb.tripmate.service;

import com.gbsb.tripmate.dto.ExpenseCreateRequest;
import com.gbsb.tripmate.dto.ExpenseUpdateRequest;
import com.gbsb.tripmate.entity.Expense;
import com.gbsb.tripmate.entity.Meeting;
import com.gbsb.tripmate.entity.User;
import com.gbsb.tripmate.enums.ErrorCode;
import com.gbsb.tripmate.exception.MeetingException;
import com.gbsb.tripmate.repository.ExpenseRepository;
import com.gbsb.tripmate.repository.MeetingMemberRepository;
import com.gbsb.tripmate.repository.MeetingRepository;
import com.gbsb.tripmate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final MeetingRepository meetingRepository;
    private final UserRepository userRepository;
    private final MeetingMemberRepository meetingMemberRepository;

    public Expense createExpense(Long userId, ExpenseCreateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new MeetingException(ErrorCode.USER_NOT_FOUND));
        Meeting meeting = meetingRepository.findById(request.getMeetingId())
                .orElseThrow(() -> new MeetingException(ErrorCode.MEETING_NOT_FOUND));

        Expense expense = Expense.builder()
                .meeting(meeting)
                .createdBy(user)
                .expenseDescription(request.getExpenseDescription())
                .expenseAmount(request.getExpenseAmount())
                .expenseDate(request.getExpenseDate())
                .isGroupExpense(request.getIsGroupExpense())
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .isDeleted(false)
                .build();

        return expenseRepository.save(expense);
    }

    public Expense updateExpense(Long userId, Long expenseId, ExpenseUpdateRequest request) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new MeetingException(ErrorCode.INVALID_REQUEST));

        if (!expense.getCreatedBy().getId().equals(userId)) {
            throw new MeetingException(ErrorCode.NO_MODIFICATION_PERMISSION);
        }

        expense.setExpenseDescription(request.getExpenseDescription());
        expense.setExpenseAmount(request.getExpenseAmount());
        expense.setExpenseDate(request.getExpenseDate());
        expense.setIsGroupExpense(request.getIsGroupExpense());
        expense.setModifiedDate(LocalDateTime.now());

        return expenseRepository.save(expense);
    }

    public void toggleDeleteExpense(Long userId, Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new MeetingException(ErrorCode.INVALID_REQUEST));

        Meeting meeting = expense.getMeeting();
        if (!meeting.getMeetingLeader().getId().equals(userId)) {
            throw new MeetingException(ErrorCode.INVALID_REQUEST);
        }

        expense.setIsDeleted(!expense.getIsDeleted());
        expense.setModifiedDate(LocalDateTime.now());
        expenseRepository.save(expense);
    }

    public List<Expense> getExpensesByMeeting(Long meetingId) {
        return expenseRepository.findByMeetingMeetingIdAndIsDeletedFalse(meetingId);
    }

    public Float calculatePerPersonExpense(Long meetingId) {
        meetingRepository.findById(meetingId)
                .orElseThrow(() -> new MeetingException(ErrorCode.MEETING_NOT_FOUND));

        List<Expense> groupExpenses = expenseRepository.findByMeetingMeetingIdAndIsGroupExpenseAndIsDeletedFalse(meetingId, true);
        Float totalGroupExpense = groupExpenses.stream()
                .map(Expense::getExpenseAmount)
                .reduce(0f, Float::sum);

        int memberCount = meetingMemberRepository.countMembersByGroupId(meetingId);

        if (memberCount == 0) {
            throw new MeetingException(ErrorCode.INVALID_REQUEST);
        }

        return totalGroupExpense / memberCount;
    }
}
