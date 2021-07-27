package com.backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Score {
    private final Long quizId;
    private final String memberId;

    private Long scoreId;
    private double score;

    public Score(Long quizId, String memberId) {
        this.quizId = quizId;
        this.memberId = memberId;
    }
}
