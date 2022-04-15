package com.fz.demoschool.teacherservice.controller;

import com.fz.demoschool.teacherservice.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/ping")
    public String ping() {
        return "This is a message from teacher microservice";
    }

}
