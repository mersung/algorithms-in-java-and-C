-- 코드를 입력하세요
SELECT p.product_id, p.product_name, p.price*sum(o.amount) total_sales from food_product p
inner join food_order o on p.product_id = o.product_id
where date_format(o.PRODUCE_DATE, '%Y-%m') = '2022-05'
group by product_id
order by total_sales desc, p.product_id
