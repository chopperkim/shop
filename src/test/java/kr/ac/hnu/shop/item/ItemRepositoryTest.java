package kr.ac.hnu.shop.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

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

}