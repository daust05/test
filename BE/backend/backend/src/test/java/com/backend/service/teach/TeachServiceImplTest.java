package com.backend.service.teach;

import com.backend.AppConfig;
import com.backend.model.Take;
import com.backend.model.Teach;
import com.backend.repository.take.TakeRepository;
import com.backend.service.teacher.TeacherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class TeacherServiceImplTest {

    private ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    private TeacherService teacherService;

    @BeforeEach
    public void beforeEach(){
        teacherService = ac.getBean(TeacherService.class);
    }

    @Test
    @DisplayName("makeClass")
    public void makeClass(){
        Teach teach = teacherService.makeClass("test","test");

        System.out.println("teach.getClassId() = " + teach.getClassId());
        assertThat(teach.getUserId()).isEqualTo("test");
    }

    @Test
    @DisplayName("makeClass ClassId 증가 테스트")
    public void incrementClassId(){
        Teach teach = teacherService.makeClass("test1","test");
        Teach teach2 = teacherService.makeClass("test2","test");

        assertThat(teach2.getClassId()).isEqualTo(1L);
    }

    @Test
    @DisplayName("학생 삭제 테스트")
    public void deleteStudent(){
        TakeRepository takeRepository = ac.getBean(TakeRepository.class);
        Long classId = 0L;

        teacherService.makeClass("teacher","testClass");
        takeRepository.save(new Take("test",classId));
        assertThat(teacherService.getAllStudent(classId).size()).isEqualTo(1);

        teacherService.deleteStudent("test",classId);
        teacherService.getAllStudent(classId).stream().forEach(id-> System.out.println("id = " + id));
        assertThat(teacherService.getAllStudent(classId).size()).isEqualTo(0);
    }

}