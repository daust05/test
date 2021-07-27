package com.backend.controller;

import com.backend.service.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{userId}/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping({"", "/"})
    public ResponseEntity teacher(){
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/{courseName}")
    public ResponseEntity makeClass(@PathVariable("userId") String userId,
                                    @PathVariable("courseName") String courseName){
        teacherService.makeClass(userId, courseName);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
