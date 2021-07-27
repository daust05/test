package com.backend.service.management;

import com.backend.AppConfig;
import com.backend.model.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ManagementTest {

    private ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("반 관리 - ID로 학생 조회하기")
    public void findStudentByClassId(){
        Member member = new Member();
        member.setUserId("id1");
        member.setName("t1");

        Member member1 = new Member();
        member1.setUserId("id2");
        member1.setName("t2");
    }
}
