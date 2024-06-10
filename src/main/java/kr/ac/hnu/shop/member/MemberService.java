package kr.ac.hnu.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;

    public Member saveMember(Member member) {
        validateDuplicateMember(member);
        return repository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        Member findMember = repository.findByEmail(member.getEmail());
        if (findMember == null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

}
