package kr.ac.hnu.shop.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/members/new")
    public String newMember() {
        return "member/memberForm";
    }
}
