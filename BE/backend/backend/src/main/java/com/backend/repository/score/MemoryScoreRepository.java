package com.backend.repository.score;

import com.backend.model.Score;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryScoreRepository implements ScoreRepository{

    private Map<Long, Score> store = new HashMap<>();
    private Long sequence = 0L;

    @Override
    public Score save(Score score) {
        score.setScoreId(sequence++);
        store.put(score.getScoreId(), score);
        return score;
    }

    @Override
    public List<Score> getAllScoreByStudentId(String studentId) {
        return store.values().stream()
                .filter(score -> score.getMemberId().equals(studentId))
                .toList();
    }

    @Override
    public List<Score> getAllScoreByQuizId(Long quizId) {
        return store.values().stream()
                .filter(score -> score.getQuizId().equals(quizId))
                .toList();
    }

    @Override
    public Optional<Score> getOneScore(String studentId, Long quizId) {
        return store.values().stream()
                .filter(score -> score.getMemberId().equals(studentId)
                        && score.getQuizId().equals(quizId))
                .findAny();
    }

    public void clear(){
        store.clear();
    }
}
