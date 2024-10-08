package com.gbsb.tripmate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "place")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Place {
    @Id
    private Long placeId;

    private String addressName; // 지번 주소

    private String roadAddressName; // 도로명 주소

    private String placeName;

    private String phone;

    private String placeUrl;

    private double x;

    private double y;
}
