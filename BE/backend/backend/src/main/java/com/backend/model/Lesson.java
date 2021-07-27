package com.backend.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class Lesson {
    private final Long classId;
    private final Long lessonId;
    private final Long weekNum;
}
