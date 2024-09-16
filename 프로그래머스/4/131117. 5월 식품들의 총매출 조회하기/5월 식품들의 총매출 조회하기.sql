# -- 코드를 입력하세요
# SELECT p.product_id, p.product_name, sum(p.price*o.amount) total_sales from food_product p
# inner join food_order o on p.product_id = o.product_id
# where date_format(o.PRODUCE_DATE, '%Y-%m') = '2022-05'
# group by product_id
# order by total_sales desc, p.product_id

# select p.product_id, p.product_name, sum(p.price * o.amount) total_sales from food_product p
# inner join food_order o on p.product_id = o.product_id
# where date_format(o.produce_date, '%Y-%m') = '2022-05'
# group by product_id
# order by total_sales desc, p.product_id;

# select p.product_id, p.product_name, sum(p.price*o.amount) sales from FOOD_PRODUCT p inner join FOOD_ORDER o
# on p.product_id = o.product_id where date_format(produce_date, '%Y-%m') = '2022-05'
# group by p.product_id
# order by sales desc, p.product_id;

select p.product_id, p.product_name, sum(p.price * o.AMOUNT) TOTAL_SALES from
FOOD_PRODUCT p INNER JOIN FOOD_ORDER o on p.product_id = o.product_id
where DATE_FORMAT(o.produce_date, '%Y-%m') = '2022-05'
group by product_id
order by TOTAL_SALES desc, p.product_id








