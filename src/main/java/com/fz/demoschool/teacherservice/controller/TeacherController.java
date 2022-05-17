package com.fz.demoschool.teacherservice.controller;

import com.fz.demoschool.core.dto.TeacherDto;
import com.fz.demoschool.teacherservice.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class TeacherController {

    private static final String SERVICE_UUID = UUID.randomUUID().toString();
    private final TeacherService teacherService;

    private static final Map<Integer, List<TeacherDto>> teacherListMap =  Map.of(
            1, List.of(
                    TeacherDto.builder().uuid(UUID.randomUUID().toString()).name("T11").schoolId(1).build(),
                    TeacherDto.builder().uuid(UUID.randomUUID().toString()).name("T12").schoolId(1).build(),
                    TeacherDto.builder().uuid(UUID.randomUUID().toString()).name("T13").schoolId(1).build()
            ),
            2, List.of(
                    TeacherDto.builder().uuid(UUID.randomUUID().toString()).name("T21").schoolId(2).build(),
                    TeacherDto.builder().uuid(UUID.randomUUID().toString()).name("T22").schoolId(2).build()
            ),
            3, List.of(
                    TeacherDto.builder().uuid(UUID.randomUUID().toString()).name("T34").schoolId(3).build(),
                    TeacherDto.builder().uuid(UUID.randomUUID().toString()).name("T31").schoolId(3).build(),
                    TeacherDto.builder().uuid(UUID.randomUUID().toString()).name("T32").schoolId(3).build(),
                    TeacherDto.builder().uuid(UUID.randomUUID().toString()).name("T33").schoolId(3).build()
            )
    );

    @GetMapping("/ping")
    public String ping() {
        log.info("{} : Ping is working properly in Teacher Service.", SERVICE_UUID);
        return String.format("%s : Ping is working properly in Teacher Service", SERVICE_UUID);
    }

    @GetMapping("/{schoolId}")
    public List<TeacherDto> getTeacherList(@PathVariable("schoolId") Integer schoolId) {
        return teacherListMap.get(schoolId);
    }

}
