package com.backend.repository.take;

import com.backend.model.Take;

import java.util.List;
import java.util.Optional;

public interface TakeRepository {
    Take save(Take take);

    Take delete(Take take);

    Optional<Take> getOne(String studentId, Long classId);

    List<Take> getAllByClassId(Long classId);

    List<Take> getAllByStudentId(String studentId);
}
