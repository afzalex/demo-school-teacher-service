package com.fz.demoschool.teacherservice.controller;

import com.fz.demoschool.core.TeacherModel;
import com.fz.demoschool.teacherservice.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    private static final Map<Integer, List<TeacherModel>> teacherListMap =  Map.of(
            1, List.of(
                    TeacherModel.builder().uuid(UUID.randomUUID().toString()).name("T1").build(),
                    TeacherModel.builder().uuid(UUID.randomUUID().toString()).name("T2").build(),
                    TeacherModel.builder().uuid(UUID.randomUUID().toString()).name("T3").build()
            ),
            2, List.of(
                    TeacherModel.builder().uuid(UUID.randomUUID().toString()).name("T21").build(),
                    TeacherModel.builder().uuid(UUID.randomUUID().toString()).name("T22").build()
            ),
            3, List.of(
                    TeacherModel.builder().uuid(UUID.randomUUID().toString()).name("T31").build(),
                    TeacherModel.builder().uuid(UUID.randomUUID().toString()).name("T32").build(),
                    TeacherModel.builder().uuid(UUID.randomUUID().toString()).name("T33").build(),
                    TeacherModel.builder().uuid(UUID.randomUUID().toString()).name("T34").build()
            )
    );

    @GetMapping("/ping")
    public String ping() {
        return "This is a message from teacher microservice";
    }

    @GetMapping("/{schoolId}")
    public List<TeacherModel> getTeacherList(@PathVariable("schoolId") Integer schoolId) {
        return teacherListMap.get(schoolId);
    }

}
