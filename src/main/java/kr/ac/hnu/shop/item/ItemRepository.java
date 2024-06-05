package kr.ac.hnu.shop.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    // select * from item where name = '상품' and description = '테스트'
    // select * from item where name like '상품' and description like '%테스트%'
    // 쿼리 메소드(Query Method)
    // find + (엔티티 이름) + By + 변수이름
    List<Item> findByName(String name);
    List<Item> findByNameIsContainingIgnoreCase(String name);
    // 상품(Item)을 상품명(name)과 상품 상세설명(description)을 or 조건을 이용해서 조회
    // select * from item where name = ? or description = ?
    List<Item> findByNameOrDescription(String name, String description);

    // price 파라미터로 넘어온 값보다 작은 상품 데이터 조회
    // select * from item where price < ?
    List<Item> findByPriceLessThan(int price);

    // price 파라미터로 넘어온 값보다 큰 상품 데이터를 조회, 단 상품 가격이 높은 순으로 조회
    // 상품가격이 높은 상품이 위에 배치, 낮은 상품은 아래쪽에 배치 => 내림차순(desc)
    // 오름차순(asc)
    // select * from item where price > ? order by price desc
    List<Item> findByPriceGreaterThanOrderByPriceDesc(int price);

    // @Query을 이용한 JPQL(java persistence query language)
    // 파라미터로 넘어온 값이 상품 상세 설명에 포함되어 있는 상품을 조회, 단 상품 가격이 높은 순으로 조회
    @Query("")
    List<Item> findByDescription(String description);
}
