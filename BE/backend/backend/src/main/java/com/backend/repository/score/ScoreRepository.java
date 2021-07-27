package com.backend.repository.score;

import com.backend.model.Score;

import java.util.List;
import java.util.Optional;

public interface ScoreRepository {
    Score save(Score score);
    List<Score> getAllScoreByStudentId(String studentId);
    List<Score> getAllScoreByQuizId(Long quizId);
    Optional<Score> getOneScore(String studentId, Long quizId);
}
