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

    // 주소(우편번호 1, 2, 주소)
    private String zipcode1;
    private String zipcode2;
    private String address;

    // 위도
    private double latitude;
    // 경도
    private double longitude;

}
