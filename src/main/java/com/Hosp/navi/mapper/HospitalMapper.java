package com.Hosp.navi.mapper;

import com.Hosp.navi.domain.Hospital;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HospitalMapper {
    // 병원 정보 전체 저장
    void saveAll(Hospital hospital);

    // 첫번째, api로 검색해서 병원 저장
    void saveFirst(Hospital hospital);
}
