package com.Hosp.navi.domain;

import com.Hosp.navi.domain.enumType.Transfer_status;

import java.time.LocalDateTime;

public class Patient_transfer {
    private Long transfer_id;

    private String reason;

    private LocalDateTime request_time;
    private LocalDateTime accept_time;

    private LocalDateTime transfer_start_time;
    private LocalDateTime transfer_end_time;

    private Transfer_status transfer_status;

    private String comments;

    // 요청 병원 외래키
    // 수락 병원 외래키
    private Long request_hospital;
    private Long accept_hospital;
}
