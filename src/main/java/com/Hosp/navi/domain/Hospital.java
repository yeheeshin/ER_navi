package com.Hosp.navi.domain;

import com.Hosp.navi.dto.HospitalApi;
import lombok.Data;

@Data
public class Hospital {
    private Long hospital_id;

    // api 에서 제공하는 pk
    private String hospital_uuid;
    private String hos_name;
    private String hos_number;
    private String er_number;

    private String hos_address;

    // 위도
    private double latitude;
    // 경도
    private double longitude;

}
