package com.Hosp.navi.service.api;

import com.Hosp.navi.dto.ResourceApi;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ApiFieldMappings {

    // 필드명에 따른 section, location 매핑 설정
    public static Map<String, String[]> getFieldToTypeMap() {
        Map<String, String[]> fieldToTypeMap = new HashMap<>();

        fieldToTypeMap.put("hvoc", new String[]{"기타", "수술실"});
        fieldToTypeMap.put("HVS22", new String[]{"기타", "수술실_기준"});
        fieldToTypeMap.put("hv39", new String[]{"기타", "외상전용 수술실"});
        fieldToTypeMap.put("HVS23", new String[]{"기타", "외상전용 수술실_기준"});
        fieldToTypeMap.put("hv42", new String[]{"기타", "분만실"});
        fieldToTypeMap.put("HVS26", new String[]{"기타", "분만실_기준"});
        fieldToTypeMap.put("hv43", new String[]{"기타", "화상전용처치실"});
        fieldToTypeMap.put("HVS36", new String[]{"기타", "화상전용처치실_기준"});


        fieldToTypeMap.put("hvcc", new String[]{"중환자실", "신경과"});
        fieldToTypeMap.put("HVS11", new String[]{"중환자실", "신경과_기준"});
        fieldToTypeMap.put("hvncc", new String[]{"중환자실", "신생아"});
        fieldToTypeMap.put("HVS08", new String[]{"중환자실", "신생아_기준"});
        fieldToTypeMap.put("hvccc", new String[]{"중환자실", "흉부외과"});
        fieldToTypeMap.put("HVS16", new String[]{"중환자실", "흉부외과_기준"});
        fieldToTypeMap.put("hvicc", new String[]{"중환자실", "일반"});
        fieldToTypeMap.put("HVS17", new String[]{"중환자실", "일반_기준"});
        fieldToTypeMap.put("hv2", new String[]{"중환자실", "내과"});
        fieldToTypeMap.put("HVS06", new String[]{"중환자실", "내과_기준"});
        fieldToTypeMap.put("hv3", new String[]{"중환자실", "외과"});
        fieldToTypeMap.put("HVS07", new String[]{"중환자실", "외과_기준"});
        fieldToTypeMap.put("hv6", new String[]{"중환자실", "신경외과"});
        fieldToTypeMap.put("HVS12", new String[]{"중환자실", "신경외과_기준"});
        fieldToTypeMap.put("hv8", new String[]{"중환자실", "화상"});
        fieldToTypeMap.put("HVS13", new String[]{"중환자실", "화상_기준"});
        fieldToTypeMap.put("hv9", new String[]{"중환자실", "외상"});
        fieldToTypeMap.put("HVS14", new String[]{"중환자실", "외상_기준"});
        fieldToTypeMap.put("hv32", new String[]{"중환자실", "소아"});
        fieldToTypeMap.put("HVS09", new String[]{"중환자실", "소아_기준"});
        fieldToTypeMap.put("hv34", new String[]{"중환자실", "심장내과"});
        fieldToTypeMap.put("HVS15", new String[]{"중환자실", "심장내과_기준"});


        fieldToTypeMap.put("hvgc", new String[]{"일반", "일반"});
        fieldToTypeMap.put("HVS38", new String[]{"일반", "일반_기준"});
        fieldToTypeMap.put("hv38", new String[]{"일반", "외상전용"});
        fieldToTypeMap.put("HVS21", new String[]{"일반", "외상전용_기준"});
        fieldToTypeMap.put("hv40", new String[]{"일반", "정신과 폐쇄병동"});
        fieldToTypeMap.put("HVS24", new String[]{"일반", "정신과 폐쇄병동_기준"});


        fieldToTypeMap.put("hv31", new String[]{"응급", "중환자실"});
        fieldToTypeMap.put("HVS05", new String[]{"응급", "중환자실_기준"});
        fieldToTypeMap.put("hv33", new String[]{"응급", "소아 중환자실"});
        fieldToTypeMap.put("HVS10", new String[]{"응급", "소아 중환자실_기준"});
        fieldToTypeMap.put("hv36", new String[]{"응급", "입원실"});
        fieldToTypeMap.put("HVS19", new String[]{"응급", "입원실_기준"});
        fieldToTypeMap.put("hv37", new String[]{"응급", "소아 입원실"});
        fieldToTypeMap.put("HVS20", new String[]{"응급", "소아 입원실_기준"});


        fieldToTypeMap.put("hvctayn", new String[]{"장비", "CT"});
        fieldToTypeMap.put("HVS27", new String[]{"장비", "CT_기준"});
        fieldToTypeMap.put("hvmriayn", new String[]{"장비", "MRI"});
        fieldToTypeMap.put("HVS28", new String[]{"장비", "MRI_기준"});
        fieldToTypeMap.put("hvangioayn", new String[]{"장비", "혈관 촬영기"});
        fieldToTypeMap.put("HVS29", new String[]{"장비", "혈관 촬영기_기준"});
        fieldToTypeMap.put("hvventiayn", new String[]{"장비", "인공호흡기"});
        fieldToTypeMap.put("HVS30", new String[]{"장비", "인공호흡기_기준"});
        fieldToTypeMap.put("hvventisoyn", new String[]{"장비", "인공호흡기 조산아가용"});
        fieldToTypeMap.put("HVS31", new String[]{"장비", "인공호흡기 조산아가용_기준"});
        fieldToTypeMap.put("hvincuayn", new String[]{"장비", "인큐베이터"});
        fieldToTypeMap.put("HVS32", new String[]{"장비", "인큐베이터_기준"});
        fieldToTypeMap.put("hvcrrtayn", new String[]{"장비", "CRRT"});
        fieldToTypeMap.put("HVS33", new String[]{"장비", "CRRT_기준"});
        fieldToTypeMap.put("hvecmoayn", new String[]{"장비", "ECMO"});
        fieldToTypeMap.put("HVS34", new String[]{"장비", "ECMO_기준"});
        fieldToTypeMap.put("hvoxyayn", new String[]{"장비", "고압산소치료기"});
        fieldToTypeMap.put("HVS37", new String[]{"장비", "고압산소치료기_기준"});
        fieldToTypeMap.put("hvhypoayn", new String[]{"장비", "중심체온조절유도기"});
        fieldToTypeMap.put("HVS35", new String[]{"장비", "중심체온조절유도기_기준"});
        fieldToTypeMap.put("hvamyn", new String[]{"장비", "구급차"});

        return fieldToTypeMap;
    }

    // 각 필드의 getter 메서드 매핑
    public static Map<String, Function<ResourceApi.Body.Items.Item, Object>> getFieldGetters() {
        Map<String, Function<ResourceApi.Body.Items.Item, Object>> fieldGetters = new HashMap<>();

        fieldGetters.put("hvoc", ResourceApi.Body.Items.Item::getHvoc);
        fieldGetters.put("HVS22", ResourceApi.Body.Items.Item::getHVS22);
        fieldGetters.put("hv39", ResourceApi.Body.Items.Item::getHv39);
        fieldGetters.put("HVS23", ResourceApi.Body.Items.Item::getHVS23);
        fieldGetters.put("hv42", ResourceApi.Body.Items.Item::getHv42);
        fieldGetters.put("HVS26", ResourceApi.Body.Items.Item::getHVS26);
        fieldGetters.put("hv43", ResourceApi.Body.Items.Item::getHv43);
        fieldGetters.put("HVS36", ResourceApi.Body.Items.Item::getHVS36);


        fieldGetters.put("hvcc", ResourceApi.Body.Items.Item::getHvcc);
        fieldGetters.put("HVS11", ResourceApi.Body.Items.Item::getHVS11);
        fieldGetters.put("hvncc", ResourceApi.Body.Items.Item::getHvncc);
        fieldGetters.put("HVS08", ResourceApi.Body.Items.Item::getHVS08);
        fieldGetters.put("hvccc", ResourceApi.Body.Items.Item::getHvccc);
        fieldGetters.put("HVS16", ResourceApi.Body.Items.Item::getHVS16);
        fieldGetters.put("hvicc", ResourceApi.Body.Items.Item::getHvicc);
        fieldGetters.put("HVS17", ResourceApi.Body.Items.Item::getHVS17);
        fieldGetters.put("hv2", ResourceApi.Body.Items.Item::getHv2);
        fieldGetters.put("HVS06", ResourceApi.Body.Items.Item::getHVS06);
        fieldGetters.put("hv3", ResourceApi.Body.Items.Item::getHv3);
        fieldGetters.put("HVS07", ResourceApi.Body.Items.Item::getHVS07);
        fieldGetters.put("hv6", ResourceApi.Body.Items.Item::getHv6);
        fieldGetters.put("HVS12", ResourceApi.Body.Items.Item::getHVS12);
        fieldGetters.put("hv8", ResourceApi.Body.Items.Item::getHv8);
        fieldGetters.put("HVS13", ResourceApi.Body.Items.Item::getHVS13);
        fieldGetters.put("hv9", ResourceApi.Body.Items.Item::getHv9);
        fieldGetters.put("HVS14", ResourceApi.Body.Items.Item::getHVS14);
        fieldGetters.put("hv32", ResourceApi.Body.Items.Item::getHv32);
        fieldGetters.put("HVS09", ResourceApi.Body.Items.Item::getHVS09);
        fieldGetters.put("hv34", ResourceApi.Body.Items.Item::getHv34);
        fieldGetters.put("HVS15", ResourceApi.Body.Items.Item::getHVS15);


        fieldGetters.put("hvgc", ResourceApi.Body.Items.Item::getHvgc);
        fieldGetters.put("HVS38", ResourceApi.Body.Items.Item::getHVS38);
        fieldGetters.put("hv38", ResourceApi.Body.Items.Item::getHv38);
        fieldGetters.put("HVS21", ResourceApi.Body.Items.Item::getHVS21);
        fieldGetters.put("hv40", ResourceApi.Body.Items.Item::getHv40);
        fieldGetters.put("HVS24", ResourceApi.Body.Items.Item::getHVS24);


        fieldGetters.put("hv31", ResourceApi.Body.Items.Item::getHv31);
        fieldGetters.put("HVS05", ResourceApi.Body.Items.Item::getHVS05);
        fieldGetters.put("hv33", ResourceApi.Body.Items.Item::getHv33);
        fieldGetters.put("HVS10", ResourceApi.Body.Items.Item::getHVS10);
        fieldGetters.put("hv36", ResourceApi.Body.Items.Item::getHv36);
        fieldGetters.put("HVS19", ResourceApi.Body.Items.Item::getHVS19);
        fieldGetters.put("hv37", ResourceApi.Body.Items.Item::getHv37);
        fieldGetters.put("HVS20", ResourceApi.Body.Items.Item::getHVS20);


        fieldGetters.put("hvctayn", ResourceApi.Body.Items.Item::getHvctayn);
        fieldGetters.put("HVS27", ResourceApi.Body.Items.Item::getHVS27);
        fieldGetters.put("hvmriayn", ResourceApi.Body.Items.Item::getHvmriayn);
        fieldGetters.put("HVS28", ResourceApi.Body.Items.Item::getHVS28);
        fieldGetters.put("hvangioayn", ResourceApi.Body.Items.Item::getHvangioayn);
        fieldGetters.put("HVS29", ResourceApi.Body.Items.Item::getHVS29);
        fieldGetters.put("hvventiayn", ResourceApi.Body.Items.Item::getHvventiayn);
        fieldGetters.put("HVS30", ResourceApi.Body.Items.Item::getHVS30);
        fieldGetters.put("hvventisoyn", ResourceApi.Body.Items.Item::getHvventisoyn);
        fieldGetters.put("HVS31", ResourceApi.Body.Items.Item::getHVS31);
        fieldGetters.put("hvincuayn", ResourceApi.Body.Items.Item::getHvincuayn);
        fieldGetters.put("HVS32", ResourceApi.Body.Items.Item::getHVS32);
        fieldGetters.put("hvcrrtayn", ResourceApi.Body.Items.Item::getHvcrrtayn);
        fieldGetters.put("HVS33", ResourceApi.Body.Items.Item::getHVS33);
        fieldGetters.put("hvecmoayn", ResourceApi.Body.Items.Item::getHvecmoayn);
        fieldGetters.put("HVS34", ResourceApi.Body.Items.Item::getHVS34);
        fieldGetters.put("hvoxyayn", ResourceApi.Body.Items.Item::getHvoxyayn);
        fieldGetters.put("HVS37", ResourceApi.Body.Items.Item::getHVS37);
        fieldGetters.put("hvhypoayn", ResourceApi.Body.Items.Item::getHvhypoayn);
        fieldGetters.put("HVS35", ResourceApi.Body.Items.Item::getHVS35);
        fieldGetters.put("hvamyn", ResourceApi.Body.Items.Item::getHvamyn);

        return fieldGetters;
    }
}
