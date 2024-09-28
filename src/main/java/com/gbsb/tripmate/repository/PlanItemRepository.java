package com.gbsb.tripmate.repository;

import com.gbsb.tripmate.entity.TravelPlan;
import com.gbsb.tripmate.entity.PlanItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanItemRepository extends JpaRepository<PlanItem, Long> {
    List<PlanItem> findByTravelPlanOrderByStartTimeAsc(TravelPlan travelPlan);
    List<PlanItem> findAllByTravelPlanOrderByItemOrderAsc(TravelPlan travelPlan);
}
