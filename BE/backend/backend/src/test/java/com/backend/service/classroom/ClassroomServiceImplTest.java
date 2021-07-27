package com.backend.service.classroom;

import com.backend.AppConfig;
import com.backend.model.Classroom;
import com.backend.model.Teach;
import com.backend.repository.TeachRepository;
import com.backend.repository.classroom.ClassroomRepository;
import com.backend.service.teacher.TeacherService;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ClassroomServiceImplTest {

    private ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @BeforeEach
    @AfterEach
    public void testEach(){
        TeachRepository teachRepository = ac.getBean(TeachRepository.class);
        teachRepository.clearRepository();
    }

    @Test
    @DisplayName("유저아이디로 teaching class 검색")
    public void findByUserId(){
        TeacherService teacherService = ac.getBean(TeacherService.class);
        ClassroomService classroomService = ac.getBean(ClassroomService.class);
        ClassroomRepository classroomRepository = ac.getBean(ClassroomRepository.class);

        teacherService.makeClass("test","testclass");
        teacherService.makeClass("test","testclass2");
        teacherService.makeClass("wrong","wrongclass");

        List<Classroom> classrooms = classroomService.findAllClassByMemberId("test");

        assertThat(classrooms.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Id로 반이름 조회")
    public void getClassName(){
        TeacherService teacherService = ac.getBean(TeacherService.class);
        ClassroomService classroomService = ac.getBean(ClassroomService.class);

        Teach teach = teacherService.makeClass("teacher", "Math");
        Long classId = teach.getClassId();
        String className = classroomService.getClassNameById(classId);

        assertThat(className).isEqualTo("Math");
    }
}