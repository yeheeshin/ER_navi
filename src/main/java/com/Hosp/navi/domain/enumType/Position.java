package com.Hosp.navi.domain.enumType;

public enum Position {
    INTERN("인턴"),
    RESIDENT("레지던트"),
    SPECIALIST("전문의"),
    FELLOW("펠로우"),
    PROFESSOR("교수"),
    DEPARTMENT_HEAD("과장"),
    HOSPITAL_DIRECTOR("병원장");

    private final String koreanName;

    Position(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }
}
