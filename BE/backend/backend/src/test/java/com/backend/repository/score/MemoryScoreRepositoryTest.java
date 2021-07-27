package com.backend.repository.score;

import com.backend.AppConfig;
import com.backend.model.Score;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryScoreRepositoryTest {
    private ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    private MemoryScoreRepository scoreRepository = ac.getBean(MemoryScoreRepository.class);

    @BeforeEach
    @AfterEach
    public void eachTest(){
        scoreRepository.clear();
    }

    @Test
    public void saveTest(){
        Score score = new Score(0L, "user");
        Score score1 = new Score(1L, "user");

        scoreRepository.save(score);
        List<Score> user = scoreRepository.getAllScoreByStudentId("user");
        Assertions.assertThat(user.size()).isEqualTo(1);

        scoreRepository.save(score1);
        List<Score> user1 = scoreRepository.getAllScoreByStudentId("user");
        Assertions.assertThat(user1.size()).isEqualTo(2);
    }

}