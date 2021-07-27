package com.backend.service.student;

import com.backend.AppConfig;
import com.backend.model.Classroom;
import com.backend.model.Take;
import com.backend.repository.classroom.ClassroomRepository;
import com.backend.repository.take.TakeRepository;
import com.backend.service.teacher.TeacherService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

    private final ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("학생 교실에 참여")
    public void joinClass(){
        StudentService studentService = ac.getBean(StudentService.class);
        TakeRepository takeRepository = ac.getBean(TakeRepository.class);

        studentService.joinClass("test",0L);
        List<Take> takeList = takeRepository.getAllByStudentId("test");
        assertThat(takeList.size()).isEqualTo(1);

        studentService.joinClass("test",1L);
        List<Take> takeList2 = takeRepository.getAllByStudentId("test");
        assertThat(takeList2.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("학생이 참여한 모든 교실 불러오기")
    public void findAllClass(){
        StudentService studentService = ac.getBean(StudentService.class);
        ClassroomRepository classroomRepository = ac.getBean(ClassroomRepository.class);

        Classroom classroom1 = new Classroom(0L,"t1");
        Classroom classroom2 = new Classroom(1L,"t1");
        classroomRepository.save(classroom1);
        classroomRepository.save(classroom2);

        studentService.joinClass("test",0L);
        List<Classroom> test = studentService.getAllClass("test");
        assertThat(test.size()).isEqualTo(1);

        studentService.joinClass("test",1L);
        List<Classroom> test1 = studentService.getAllClass("test");
        assertThat(test1.size()).isEqualTo(2);

        studentService.joinClass("test1",1L);
        List<Classroom> test2 = studentService.getAllClass("test");
        assertThat(test2.size()).isEqualTo(2);
    }
}