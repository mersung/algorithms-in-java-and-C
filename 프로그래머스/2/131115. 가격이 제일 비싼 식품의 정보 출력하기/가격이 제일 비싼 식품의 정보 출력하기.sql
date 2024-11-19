# select PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE from FOOD_PRODUCT
# where PRICE = (select max(price) from FOOD_PRODUCT)
# -- 집계함수는 다른 열과의 관계를 표시하지 않으므로, where 절에서 조건을 달아줘야함.
# -- PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY는 1번부터 쭉 출력되는데, MAX(PRICE)를 해버리면 
# -- MAX(PRICE) 한 열만 출력되고 나머지 열과의 관계는 X
# -- GROUP BY를 쓰는 경우, 그 열과는 상관관계가 존재함. 나머지 열은 아니므로 where절로 group by와 집계함수 열과 나머지 열 상관관계를 만들어줘야함.


# select product_id, product_name, product_cd, category, price from food_product
# where price = (
#     select max(price) from food_product
# )
-- 이렇게 해버리면, max(price) 집계함수 열과의 상관관계가 없이, 첫 번째 행만 출력됨, where로 나머지 열과의 상관관계를 맞춰줘야함


# select * from food_product
# where price = (select MAX(price) from food_product)


# select * from food_product
# order by price desc
# Limit 1;

# select * from FOOD_PRODUCT
# order by PRICE DESC
# limit 1;



# select *
# from FOOD_PRODUCT
# where PRICE = (select MAX(PRICE) from FOOD_PRODUCT)

# select product_id, product_name, product_cd, category, price from FOOD_PRODUCT
# where price = (select MAX(price) from FOOD_PRODUCT)



select product_id, product_name, product_cd, category, price
from food_product
order by price desc
limit 1;








