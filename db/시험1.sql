DROP DATABASE IF EXISTS mall;
CREATE DATABASE mall;
USE mall;

DROP USER IF EXISTS 'mall_admin'@'%';
create user 'mall_admin'@'%' identified by '1234'; 
grant all privileges on mall.* to 'mall_admin'@'%';

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
    `m_id` INT PRIMARY KEY,
    `m_name` VARCHAR(20) NOT NULL,
    `m_point` INT DEFAULT 0 NULL
);

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
    `p_id` INT PRIMARY KEY,
    `p_name` VARCHAR(50) NOT NULL UNIQUE,
    `p_price` INT NOT NULL,
    `p_stock` INT NOT NULL
);

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
    `o_id` INT PRIMARY KEY AUTO_INCREMENT,
    `m_id` INT NOT NULL,
    `p_id` INT NOT NULL,
    `o_qty` INT NOT NULL,
    `o_date` DATETIME NOT NULL
);

ALTER TABLE `orders` ADD CONSTRAINT `FK_member_TO_orders_1` FOREIGN KEY (
    `m_id`
)
REFERENCES `member` (
    `m_id`
);

ALTER TABLE `orders` ADD CONSTRAINT `FK_product_TO_orders_1` FOREIGN KEY (
    `p_id`
)
REFERENCES `product` (
    `p_id`
);

insert into member values(1, '홍길동', 1000), (2, '김철수', 500); 
insert into product  values(101, '노트북', 1500000, 10), (102, '마우스', 30000, 50); 

select * from member;
select * from product;

# 트랜잭션 시작 
START TRANSACTION;
/*
정규화, 트랙잭션, 동시성 제어, 회복문 발생 시 결제와 재고 처리는 동시에 완결되어야 합니다. 
다음 과정을 하나의 트랜잭션으로 처리하는 쿼리를 작성하고, 작업이 잘 되었는지 조회하는 쿼리를 작성하세요.
*/
# - 조건: 1번 회원이 101번 상품을 2개 주문함
insert into orders(m_id, p_id, o_qty, o_date) values(1, 101, 2, curdate());

# - product 테이블: 101번 상품 재고 2개 감소
update product
set p_stock = p_stock -2
where p_id = 101;

# - member 테이블: 1번 회원 포인트 100점 증가
update member 
set m_point = m_point +100
where m_id = 1;

# - orders 테이블: 주문 내역 추가 (1번 회원, 101번 상품, 수량 2, 오늘 날짜)

# - 1번 회원이 주문한 상품명을 조회(JOIN 이용)
select * from orders join product using(p_id) where m_id = 1; 

COMMIT;

CREATE VIEW v_member_public AS
SELECT m_id, m_name
FROM member;

SELECT * FROM v_member_public;
