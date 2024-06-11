package kr.ac.hnu.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;

    // Transactional: 하나의 일 단위 => 실패시 원상복구
    @Transactional
    public Member saveMember(Member member) {
        validateDuplicateMember(member);
        return repository.save(member);
    }
    private void validateDuplicateMember(Member member) {
        Member findMember = repository.findByEmail(member.getEmail());
        if (findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
