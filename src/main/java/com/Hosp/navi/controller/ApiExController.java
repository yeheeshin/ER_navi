package com.Hosp.navi.controller;

import com.Hosp.navi.service.ApiDataService;
import com.Hosp.navi.service.ApiResourceService;
import com.Hosp.navi.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiExController {
    private final ApiDataService apiDataService;
    private final ApiResourceService apiResourceService;
    private final HospitalService hospitalService;

    @GetMapping("/getAll")
    public String getData() throws IOException {
        apiDataService.callApiHospital();
        System.out.println("지나감?");

        return "성공";
    }

    @GetMapping("/getRe")
    public String getRData() throws IOException {
        apiResourceService.callApiResource();
        System.out.println("지나감?!!!!");

        return "성공";
    }
}
