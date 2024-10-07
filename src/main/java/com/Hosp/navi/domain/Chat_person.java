package com.Hosp.navi.domain;

import java.time.LocalDateTime;

public class Chat_person {
    private Long chat_person_id;

    private LocalDateTime joined_at;

    // 채팅방 외래키
    // 유저 외래키
    private Long chat_room;
    private Long user;
}
