package kr.ac.hnu.shop.item;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

// Data Transfer Object => DTO
// Hyper Text Transfer Protocol => HTTP, http
// ItemDto: item + dto => pascal case 첫 글자는 대문자로 시작하고 연결되는 문자는 대문자로
@Data
@Builder
public class ItemDTO {
    private Long id;
    private String name;
    private int price;
    private int quantity;
    private String description;
    private String status;
    private LocalDateTime registerDate;
    private LocalDateTime modifiedDate;
}
