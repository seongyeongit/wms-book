package com.sh.order.model.dao;

import com.sh.book.model.dao.BookMapper;
import com.sh.order.model.dto.OrderDto;
import com.sh.order.model.dto.OrderItemDto;
import com.sh.order.model.dto.Status;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static com.sh.common.MyBatisTemplate.getSqlSession;
import static org.junit.jupiter.api.Assertions.*;

class OrderMapperTest {

    SqlSession sqlSession;
    OrderMapper orderMapper;

    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.orderMapper = this.sqlSession.getMapper(OrderMapper.class);
    }

    @AfterEach
    void tearDown() {
        this.sqlSession.commit();
        this.sqlSession.close();
    }

    @DisplayName("한건의 주문을 등록")
    @Test
    void insertOrder() {
        // Given: 주문 정보를 생성
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderName("홍길동");
        orderDto.setOrderAddress("서울시 강동구 풍납동 1234-56");
        orderDto.setOrderDate(new Timestamp(System.currentTimeMillis()));
        orderDto.setStatus(Status.ORDER_CONFIRMING);

        // When: 주문을 데이터베이스에 삽입
        int result = orderMapper.insertOrder(orderDto);

        // Then: 삽입 결과 확인
        assertEquals(1, result, "주문 삽입 결과는 1이어야 합니다.");
        assertNotNull(orderDto.getOrderId(), "주문 ID는 null이 아니어야 합니다.");

    }
    @DisplayName("한건의 주문아이템을 등록")
    @Test
    void insertOrderItem() {
        // Given: 주문 정보를 생성 및 삽입
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderName("윤인성");
        orderDto.setOrderAddress("대구 수성구");
        orderDto.setOrderDate(new Timestamp(System.currentTimeMillis()));
        orderDto.setStatus(Status.ORDER_CONFIRMING);
        orderMapper.insertOrder(orderDto);

        // Given: 주문 아이템 정보를 생성
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setOrderId(orderDto.getOrderId()); // 삽입된 주문의 ID를 설정
        orderItemDto.setBookId(1); // 예: 도서번호 1번
        orderItemDto.setQuantity(3); // 예: 수량 3권

        // When: 주문 아이템을 데이터베이스에 삽입
        int result = orderMapper.insertOrderItem(orderItemDto);

        // Then: 삽입 결과 확인
        assertEquals(1, result, "주문 아이템 삽입 결과는 1이어야 합니다.");
        assertNotEquals(0, orderItemDto.getOrderItemId(), "주문 아이템 ID는 0이 아니어야 합니다.");


    }
}