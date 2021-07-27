package com.backend.repository.take;

import com.backend.model.Take;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MemoryTakeRepository implements TakeRepository {

    private List<Take> store = new ArrayList<>();

    @Override
    public Take save(Take take) {
        store.add(take);
        return take;
    }

    @Override
    public Take delete(Take take) {
        store.remove(take);
        return take;
    }

    @Override
    public Optional<Take> getOne(String studentId, Long classId) {
        return store.stream()
                .filter(take -> take.getStudentId().equals(studentId)&&
                                take.getClassId().equals(classId))
                .findAny();
    }

    @Override
    public List<Take> getAllByClassId(Long classId) {
        return store.stream()
                .filter(take -> take.getClassId().equals(classId))
                .toList();
    }

    @Override
    public List<Take> getAllByStudentId(String studentId) {
        return store.stream()
                .filter(take -> take.getStudentId().equals(studentId))
                .toList();
    }
}
