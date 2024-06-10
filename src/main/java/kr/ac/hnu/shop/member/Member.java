package kr.ac.hnu.shop.member;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String address;
    @Enumerated(EnumType.STRING)
    private Role role; // GUEST, USER, ADMIN enumeration
    @CreatedDate
    private LocalDateTime registerDate;

    public static Member createMember(MemberFormDTO dto, PasswordEncoder passwordEncoder) {
        Member member = new Member();
        member.name = dto.getName();
        member.email = dto.getEmail();
        member.password = passwordEncoder.encode(dto.getPassword());
        member.address = dto.getAddress();
        member.role = Role.USER;
        return member;
    }
}
