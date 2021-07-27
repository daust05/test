package com.backend.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Quiz {
    private final Long quizId;
    private final Long classId;
    private final Long lessonId;
}
