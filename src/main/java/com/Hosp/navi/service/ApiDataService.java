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
public class ApiDataService {

    private final HospitalMapper hospitalMapper;

    @Value("${callBackUrl}/getEgytListInfoInqire")
    private String apiUrl;

    @Value("${serviceKey}")
    private String serviceKey;

    // 병원 정보 가져오기&저장
    public void callApiHospital() throws IOException {
        String Q0 = "서울특별시";

        // url 생성
        StringBuilder urlBuilder = new StringBuilder(apiUrl);
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
        urlBuilder.append("&" + URLEncoder.encode("Q0", "UTF-8") + "=" + URLEncoder.encode(Q0, "UTF-8"));

        // url로 연결
        URL url = new URL(urlBuilder.toString());
        System.out.println("url = " + url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }

        rd.close();
        conn.disconnect();

        String xml = sb.toString();
        Map<String, HospitalApi> result = new HashMap<>();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(HospitalApi.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            HospitalApi apiResponse = (HospitalApi) unmarshaller.unmarshal(new StringReader(xml));
            result.put("response", apiResponse);

            if(apiResponse.getBody() != null && apiResponse.getBody().getItems() != null){
                List<HospitalApi.Body.Items.Item> itemList = apiResponse.getBody().getItems().getItem();
                List<Hospital> hospitals = itemList.stream()
                        .map(this::convertToHospital)
                        .collect(Collectors.toList());

                for(Hospital hospital : hospitals){
                    hospitalMapper.saveFirst(hospital);
                }
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }






    public Hospital convertToHospital(HospitalApi.Body.Items.Item response) {
        Hospital hospital = new Hospital();

        hospital.setHospital_uuid(response.getHpid());
        hospital.setHos_name(response.getDutyName());
        hospital.setHos_number(response.getDutyTel1());
        hospital.setEr_number(response.getDutyTel3());

        hospital.setLatitude(response.getWgs84Lat());
        hospital.setLongitude(response.getWgs84Lon());

        return hospital;
    }


}