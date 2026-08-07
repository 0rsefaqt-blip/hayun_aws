# 쇼핑몰에 가입된 회원을 조회
use shoppingmall;
select * from user where authority = 'USER';
# Error Code: 1046. No database selected Select the default DB to be used by double-clicking its name in the SCHEMAS list in the sidebar.

# 모든 제품을 조회 
select * from product;
# 분류가 acc인 제품을 조회
select * from product where ca_code = 'ACC';
# 분류가 악세서리인 제품을 조회
select product.* # * 앞의 product.는 테이블을 합치지않고 프로덕트의 테이블만 보겠다는 의미 
from product 
join category
on product.ca_code = category.code #컬럼명이 동일한 것이 없으면 .앞에를 생략 가능 
where category.name = '악세서리';

# abc123 회원이 장바구니에 담은 제품의 제품명과 수량을 조회
SELECT 
    *
FROM
    cart
        JOIN
	#기본키와 외래키의 이름이 같은 경우 product using(code)로 쓸수있음
    product ON cart.code = product.code 
WHERE
    id = 'abc123'; 
    
# 검색어를 목걸이로 검색했을 때 결과를 조회
select * from product where name like '%목걸이%' ;

# 제품별 판매 수량(판매된 제품만)을 조회
# 제품명, 제품코드, 가격, 판매 수량 조회
# group by 이용
SELECT 
    code as 제품코드, # as는 이름을 어떻게 보이게 할지 code => 제품코드 
    name as 제품명,
    SUM(buy.amount) as 판매량, 
    SUM(product.price * buy.amount) as 판매액 
FROM
    buy
        JOIN
    product USING (code)
GROUP BY code;

# 회원별 제품 구매 횟수 
# 회원아이디, 제품구매횟수
SELECT 
    id as 회원아이디, 
    count(*) as 제품구매횟수 #count(*)은 행을 세는것  
FROM
    buy
GROUP BY id;

# abc123회원이 장바구니를 조회 (쿼리를 이용한 예제)
# cart 테이블에 샘플 데이터가 10만개라고 가정
# product 테이블은 샘플 데이터가 1만개라고 가정
# 회원은 1000명이라고 가정
# 앞에서 했던 쿼리 => 10만개 행에 제품 1만개를 join 
select product.* from cart join product using(code)
where id = 'abc123';

# 서브쿼리 이용
SELECT 
    product.*
FROM
    (SELECT 
        *
    FROM
        cart
    WHERE
        id = 'abc123') AS c
        JOIN
    product USING (code);


