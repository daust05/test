package com.backend.repository;

import com.backend.model.Member;
import com.backend.model.Teach;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Component
public class TeachMemoryRepository implements TeachRepository{

    private static List<Teach> store = new ArrayList<>();

    @Override
    public Teach save(Teach teach) {
        store.add(teach);
        return teach;
    }

    @Override
    public Optional<Teach> findOneByMember(Member member) {
        String id = member.getUserId();
        return store.stream()
                .filter(teach -> teach.getUserId().equals(id))
                .findAny();
    }

    @Override
    public List<Teach> findAllByMemberId(String memberId) {
        return store.stream()
                .filter(teach -> teach.getUserId().equals(memberId))
                .toList();
    }

    @Override
    public List<Teach> findAllByClassId(Long classId) {
        return store.stream()
                .filter(teach -> teach.getClassId().equals(classId))
                .toList();
    }

    @Override
    public void clearRepository() {
        store.clear();
    }
}
