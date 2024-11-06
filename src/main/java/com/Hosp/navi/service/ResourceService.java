package com.Hosp.navi.service;

import com.Hosp.navi.domain.Hospital;
import com.Hosp.navi.domain.Resources;
import com.Hosp.navi.mapper.HospitalMapper;
import com.Hosp.navi.mapper.ResourceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ResourceService {
    private final ResourceMapper resourceMapper;
    private final HospitalMapper hospitalMapper;

    // 병원 자원 정보 저장
    public void saveResource(Resources resource) {
        Hospital idList = hospitalMapper.findById(resource.getHospital());

        if (idList != null) {
            resourceMapper.save(resource);
        }

    }

}