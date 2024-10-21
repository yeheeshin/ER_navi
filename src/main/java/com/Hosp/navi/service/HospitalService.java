package com.Hosp.navi.service;

import com.Hosp.navi.domain.Hospital;
import com.Hosp.navi.dto.HospitalApi;
import com.Hosp.navi.mapper.HospitalMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class HospitalService {
    private final HospitalMapper hospitalMapper;

    // 병원 정보 저장
    public void saveFirst(Hospital hospital) {
        List<Hospital> idList = hospitalMapper.findUUId(hospital.getHospital_uuid());

        if (idList == null || idList.isEmpty()) {  // null이거나 비어있으면 저장
            hospitalMapper.saveFirst(hospital);
        }

    }

}