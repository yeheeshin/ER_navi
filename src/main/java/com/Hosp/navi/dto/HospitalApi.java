package com.Hosp.navi.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "response")
public class HospitalApi {

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

                // 기관 고유 id
                private String hpid;

                // 병원 이름
                private String dutyName;

                // 병원 주소
                private String dutyAddr;

                // 번호
                private String dutyTel1;
                private String dutyTel3;

                // 경도, 위도
                private double wgs84Lon;
                private double wgs84Lat;
            }
        }
    }

}
