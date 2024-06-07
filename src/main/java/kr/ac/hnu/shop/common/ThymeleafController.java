package kr.ac.hnu.shop.common;

import kr.ac.hnu.shop.item.ItemDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/thymeleaf")
@Controller
public class ThymeleafController {
//    @RequestMapping(value = "/thymeleaf/ex01", method = RequestMethod.GET)
    @GetMapping("/ex01")
    public String ex01(Model model) {
        // Model: 응답 페이지에 데이터를 전달하는 객체
        model.addAttribute("data", "타임리프 예제입니다.");
        return "thymeleaf/ex01";
    }
    @GetMapping("/ex02")
    public String ex02(Model model) {
        // 데이터 전달 객체(Data Transfer Object)
//        ItemDTO item = new ItemDTO("테스트 상품", 10000, "테스트 상품 상세 설명", LocalDateTime.now());
//        item.setName("테스트 상품");
//        item.setDescription("테스트 상품 상세 설명");
//        item.setPrice(10000);
//        item.setRegisterDate(LocalDateTime.now());
        // Builder pattern
        ItemDTO item = ItemDTO.builder()
                .name("테스트 상품")
                .price(10000)
                .description("테스트 상품 상세 설명")
                .registerDate(LocalDateTime.now())
                .build();
        model.addAttribute("item", item);
        return "thymeleaf/ex02";
    }

    @GetMapping("/ex03")
    public String ex03() {
        return "thymeleaf/ex03";
    }

    @GetMapping("/ex04")
    public String ex04() {
        return "thymeleaf/ex04";
    }

    @GetMapping("/ex05")
    public String ex05() {
        return "thymeleaf/ex05";
    }

    @GetMapping("/ex06")
    public String ex06(String name, int age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "thymeleaf/ex06";
    }

    @GetMapping("/ex07")
    public String ex07() {
        return "thymeleaf/ex07";
    }

    // @ModelAttribute
    // 부착 위치: 파라미터, 메소드
    // 내부적으로 model.addAttribute("items", list);
    @ModelAttribute("items")
    public List<ItemDTO> items() {
        List<ItemDTO> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            ItemDTO item = ItemDTO.builder()
                    .name("테스트 상품" + i)
                    .price(10000 * i)
                    .description("테스트 상품 상세 설명" + i)
                    .registerDate(LocalDateTime.now())
                    .build();
            list.add(item);
        }
        return list;
    }

}
