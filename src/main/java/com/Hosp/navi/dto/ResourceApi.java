package com.Hosp.navi.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "response")
public class ResourceApi {

    private Header header;
    private Body body;

    @Getter
    @Setter
    @XmlRootElement(name = "header")
    public static class Header {
        private String resultCode;
        private String resultMsg;
    }

    @Getter
    @Setter
    @XmlRootElement(name = "body")
    public static class Body {
        private Items items;
        private String numOfRows;
        private String pageNo;
        private String totalCount;

        @Getter
        @Setter
        @XmlRootElement(name = "items")
        public static class Items {
            private List<Item> item;

            @Getter
            @Setter
            @XmlRootElement(name = "item")
            public static class Item {

                private String hpid;

                // 기타
                private int hvoc; // 수술실
                private int HVS22;

                private int hv39; // 외상전용 수술실
                private int HVS23;

                private int hv42; // 분만실
                private int HVS26;

                private int hv43; // 화상전용처치실
                private int HVS36;

                // 중환자실
                private int hvcc; // 신경과
                private int HVS11;

                private int hvncc; // 신생아
                private int HVS08;

                private int hvccc; // 흉부외과
                private int HVS16;

                private int hvicc; // 일반
                private int HVS17;

                private int hv2; // 내과
                private int HVS06;

                private int hv3; // 외과
                private int HVS07;

                private int hv6; // 신경외과
                private int HVS12;

                private int hv8; // 화상
                private int HVS13;

                private int hv9; // 외상
                private int HVS14;

                private int hv32; // 소아
                private int HVS09;

                private int hv34; // 심장내과
                private int HVS15;

                // 일반
                private int hvgc; // 일반
                private int HVS38;

                private int hv38; // 외상전용
                private int HVS21;

                private int hv40; // 정신과 폐쇄병동
                private int HVS24;

                // 응급
                private int hv31; // 중환자실
                private int HVS05;

                private int hv33; // 소아중환자실
                private int HVS10;

                private int hv36; // 입원실
                private int HVS19;

                private int hv37; // 소아입원실
                private int HVS20;

                // 가용여부 (장비)
                private String hvctayn; // CT
                private int HVS27;

                private String hvmriayn; // MRI
                private int HVS28;

                private String hvangioayn; // 혈관촬영기
                private int HVS29;

                private String hvventiayn; // 인공호흡기
                private int HVS30;

                private String hvventisoyn; // 인공호흡기 조산아가용
                private int HVS31;

                private String hvincuayn; // 인큐베이터
                private int HVS32;

                private String hvcrrtayn; // CRRT
                private int HVS33;

                private String hvecmoayn; // ecmo
                private int HVS34;

                private String hvoxyayn; // 고압산소치료기
                private int HVS37;

                private String hvhypoayn; // 중심체온조절유도기
                private int HVS35;

                private String hvamyn; // 구급차

            }
        }
    }

}
