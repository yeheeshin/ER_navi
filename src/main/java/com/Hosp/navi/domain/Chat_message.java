package com.Hosp.navi.domain;

import java.time.LocalDateTime;

public class Chat_message {
    private Long message_id;

    private String message_text;
    private LocalDateTime send_at;

    // 채팅방 외래키
    // 유저 외래키
    private Long chat_room;
    private Long user;
}
