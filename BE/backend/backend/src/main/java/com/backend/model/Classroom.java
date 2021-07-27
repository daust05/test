package com.backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Classroom {
    private Long classId;
    private String courseName;

    public Classroom(){}
    public Classroom(Long classId, String courseName) {
        this.classId = classId;
        this.courseName = courseName;
    }
}
