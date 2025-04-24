package com.example.todocalendar.calendar;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable  // 이 클래스가 다른 엔티티에 임베디드 객체로 사용될 것임을 표시
public class Location {

    private String venue;  // 장소명
    private String address;  // 주소
    private String city;  // 도시
    private String state;  // 주 또는 지역
    private String country;  // 국가
}
