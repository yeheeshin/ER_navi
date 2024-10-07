package com.Hosp.navi.domain;

import lombok.Data;

@Data
public class Transfer_want {
    private Long want_id;

    // 환자 전원 외래키
    // 병상 자원 외래키
    private Long patient;
    private Long resource;
}
