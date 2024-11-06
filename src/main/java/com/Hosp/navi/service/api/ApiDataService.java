package com.Hosp.navi.service.api;

import com.Hosp.navi.domain.Hospital;
import com.Hosp.navi.dto.HospitalApi;
import com.Hosp.navi.service.HospitalService;
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
import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
@RequiredArgsConstructor
public class ApiDataService {

    private final HospitalService hospitalService;

    @Value("${callBackUrl}/getEgytListInfoInqire")
    private String apiUrl;

    @Value("${serviceKey}")
    private String serviceKey;

    // 병원 정보 가져오기&저장
    public void callApiHospital() throws IOException {
        String Q0 = "서울특별시";
        int numOfRows = 10;  // 첫 번째 요청은 기본값 10으로 설정
        int totalCount = 0;  // totalCount 값을 저장하기 위한 변수

        // 첫 번째 API 요청: totalCount 확인을 위한 요청
        totalCount = requestApiAndGetTotalCount(Q0, numOfRows);

        // 두 번째 요청: totalCount 값을 바탕으로 전체 데이터 가져오기
        if (totalCount > 0) {
            numOfRows = totalCount;  // numOfRows를 totalCount 값으로 설정
            requestAndSaveHospitals(Q0, numOfRows);  // 데이터를 저장하는 메서드 호출
        }
    }

    // 첫 번째 API 요청을 통해 totalCount를 확인하는 메서드
    public int requestApiAndGetTotalCount(String Q0, int numOfRows) throws IOException {
        StringBuilder urlBuilder = new StringBuilder(apiUrl);
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
        urlBuilder.append("&" + URLEncoder.encode("Q0", "UTF-8") + "=" + URLEncoder.encode(Q0, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + numOfRows);  // 첫 번째 요청 시 numOfRows 추가

        URL url = new URL(urlBuilder.toString());
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
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(HospitalApi.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            HospitalApi apiResponse = (HospitalApi) unmarshaller.unmarshal(new StringReader(xml));

            if (apiResponse.getBody() != null && apiResponse.getBody().getTotalCount() != null) {
                return Integer.parseInt(apiResponse.getBody().getTotalCount());  // totalCount 반환
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return 0;  // 오류가 발생하거나 totalCount를 찾지 못하면 0 반환
    }

    // 두 번째 요청: totalCount에 맞춰 전체 데이터를 가져와 저장
    public void requestAndSaveHospitals(String Q0, int numOfRows) throws IOException {
        StringBuilder urlBuilder = new StringBuilder(apiUrl);
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
        urlBuilder.append("&" + URLEncoder.encode("Q0", "UTF-8") + "=" + URLEncoder.encode(Q0, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + numOfRows);  // totalCount에 맞춰 numOfRows 설정

        URL url = new URL(urlBuilder.toString());
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
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(HospitalApi.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            HospitalApi apiResponse = (HospitalApi) unmarshaller.unmarshal(new StringReader(xml));

            if (apiResponse.getBody() != null && apiResponse.getBody().getItems() != null) {
                List<HospitalApi.Body.Items.Item> itemList = apiResponse.getBody().getItems().getItem();
                List<Hospital> hospitals = itemList.stream()
                        .map(this::convertToHospital)
                        .collect(Collectors.toList());

                for (Hospital hospital : hospitals) {
                    hospitalService.saveFirst(hospital);  // 병원 정보 저장
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
        hospital.setHos_address(response.getDutyAddr());
        hospital.setHos_number(response.getDutyTel1());
        hospital.setEr_number(response.getDutyTel3());
        hospital.setLatitude(response.getWgs84Lat());
        hospital.setLongitude(response.getWgs84Lon());
        return hospital;
    }
}
