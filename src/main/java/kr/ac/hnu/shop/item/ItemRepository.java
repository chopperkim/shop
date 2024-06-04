package kr.ac.hnu.shop.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    // select * from item where name = '상품' and description = '테스트'
    // select * from item where name like '상품' and description like '%테스트%'
    // 쿼리 메소드(Query Method)
    // find + (엔티티 이름) + By + 변수이름
    List<Item> findByName(String name);
    List<Item> findByNameIsContainingIgnoreCase(String name);
}
