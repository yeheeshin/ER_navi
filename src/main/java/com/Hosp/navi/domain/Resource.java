package com.Hosp.navi.domain;

import java.time.LocalDateTime;

public class Resource {
    private Long resource_id;

    private String re_type;
    private int re_count;
    private int available_units;
    private boolean available_status;
    private LocalDateTime last_updated;

    // 병원 외래키
    private Long hospital;

}
