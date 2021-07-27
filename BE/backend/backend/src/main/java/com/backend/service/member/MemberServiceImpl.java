package com.backend.service.member;

import com.backend.model.Member;
import com.backend.repository.MemberRepository;

import java.util.Optional;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public String join(Member member) {
        memberRepository.save(member);
        return member.getUserId();
    }

    @Override
    public Optional<Member> findOne(String id) {
        return memberRepository.findById(id);
    }
}
