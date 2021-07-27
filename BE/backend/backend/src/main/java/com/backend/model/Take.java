package com.backend.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Take {
    private final String studentId;
    private final Long classId;
}
