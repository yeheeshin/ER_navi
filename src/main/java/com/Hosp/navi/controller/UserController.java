package com.Hosp.navi.controller;

import com.Hosp.navi.domain.User;
import com.Hosp.navi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<String> joinUser(@RequestBody User user){
        boolean isJoin = userService.save(user);

        if (!isJoin) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 사용 중인 이메일입니다.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입이 성공적으로 완료되었습니다.");
    }
}
