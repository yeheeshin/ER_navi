package com.Hosp.navi.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Resources {
    private Long resource_id;

    private String section_type;
    private String field_name;
    private int available_units;
    private String available_status;
    private LocalDateTime last_update;

    // 병원 외래키
    private Long hospital;

}
