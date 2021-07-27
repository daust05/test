package com.backend.repository;

import com.backend.AppConfig;
import com.backend.model.Teach;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeachMemoryRepositoryTest {

    @Test
    @DisplayName("유저아이디로 모두 검색")
    public void findAll(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        TeachMemoryRepository bean = ac.getBean(TeachMemoryRepository.class);
        bean.save(new Teach(0L, "member"));
        bean.save(new Teach(1L, "member"));

        List<Teach> teaches = bean.findAllByMemberId("member");
        Assertions.assertThat(teaches.size()).isEqualTo(2);
    }
}