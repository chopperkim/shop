package kr.ac.hnu.shop.item;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
//@Data 제외된 것: hashcode() equals()
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;
    private int quantity;
    private String description;
    private String status;
    private LocalDateTime registerDate;
    private LocalDateTime modifiedDate;
}
