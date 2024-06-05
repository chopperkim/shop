package kr.ac.hnu.shop.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
// suite test (종합 테스트)
@DataJpaTest
class ItemRepositoryTest {
    @Autowired
    private ItemRepository repository;

    // unit test (단위 테스트)
    @Test
    void createItemTest() {
        Item item = new Item();
        item.setName("테스트 상품");
        item.setPrice(10000);
        item.setDescription("테스트 상품 상세 설명");
        item.setQuantity(100);
        item.setStatus("Selling");
        item.setRegisterDate(LocalDateTime.now());
        Item savedItem = repository.save(item);
        assertEquals(1, savedItem.getId());
        System.out.println("savedItem = " + savedItem);
    }

    private void createItemList() {
        for (int i = 1; i <= 10; i++) {
            Item item = new Item();
            item.setName("테스트 상품" + i);
            item.setPrice(10000 + i);
            item.setDescription("테스트 상품 상세 설명" + i);
            item.setQuantity(100 + i);
            item.setStatus("Selling");
            item.setRegisterDate(LocalDateTime.now());
            repository.save(item);
        }
    }
    @Test
    @DisplayName("상품명 조회 테스트")
    void findByNameTest() {
        createItemList();
        List<Item> itemList = repository.findByNameIsContainingIgnoreCase("상품1");
        assertEquals(2, itemList.size());
    }

    @Test
    @DisplayName("상품명과 상품상세설명에 대한 or 테스트")
    void findByNameOrDescriptionTest() {
        createItemList();
        List<Item> itemList = repository.findByNameOrDescription("테스트 상품1", "테스트 상품 상세 설명7");
        itemList.forEach(System.out::println);
        assertEquals(2, itemList.size());
    }

    @Test
    @DisplayName("가격 LessThan 테스트")
    void findByPriceLessThanTest() {
        createItemList();
        List<Item> itemList = repository.findByPriceLessThan(10005);
        itemList.forEach(System.out::println);
        assertEquals(4, itemList.size());
    }

    @Test
    @DisplayName("가격 LessThan, 가격 내림차순 테스트")
    void findByPriceGreaterThanOrderByPriceDescTest() {
        createItemList();
        List<Item> itemList = repository.findByPriceGreaterThanOrderByPriceDesc(10005);
        itemList.forEach(System.out::println);
        assertEquals(5, itemList.size());
    }


}
