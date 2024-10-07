package com.Hosp.navi.domain;

import com.Hosp.navi.domain.enumType.Notice_type;

import java.time.LocalDateTime;

public class Notice {
    private Long notice_id;

    private Notice_type notice_type;
    private String message_text;
    private LocalDateTime notice_time;


    // user 외래키
    // 병원 외래키
    private Long hospital;
    private Long notice_user;


    // 추후 기록이 필요하다고 느껴지면 알림 기록 테이블 추가
}
