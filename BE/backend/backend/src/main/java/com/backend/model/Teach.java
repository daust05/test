package com.backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Teach {
    private Long classId;
    private String userId;

    public Teach(Long classId, String memberId) {
        this.classId = classId;
        this.userId = memberId;
    }
}
