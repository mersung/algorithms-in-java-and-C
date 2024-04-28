# -- 코드를 입력하세요
# SELECT order_id, product_id, date_format(out_date, '%Y-%m-%d'), 
# case 
# when date_format(out_date, '%Y-%m-%d') <= '2022-05-01' then '출고완료'
# when date_format(out_date, '%Y-%m-%d') > '2022-05-01' then '출고대기'
# else '출고미정'
# end 
# as 출고여부
# from food_order
# order by order_id

# # SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE, '%Y-%m-%d'),
# #     CASE WHEN DATE_FORMAT(OUT_DATE,'%m-%d') <= '05-01' THEN '출고완료'
# #          WHEN DATE_FORMAT(OUT_DATE,'%m-%d') > '05-01' THEN '출고대기'
# #          ELSE '출고미정'
# #          END AS '출고여부'
# # FROM FOOD_ORDER
# # ORDER BY ORDER_ID ASC;

# select order_id, product_id, date_format(out_date, '%Y-%m-%d'), 
# case when out_date <= '2022-05-01' then '출고완료'
#     when out_date > '2022-05-01' then '출고대기'
#     else '출고미정'
#     end
#     as '출고여부'
# from food_order
# order by order_id











select ORDER_ID, PRODUCT_ID, date_format(OUT_DATE, '%Y-%m-%d'), 
CASE WHEN DATE_FORMAT(OUT_DATE, '%Y-%m-%d')  <= '2022-05-01' then '출고완료'
WHEN DATE_FORMAT(OUT_DATE, '%Y-%m-%d') > '2022-05-01' then '출고대기'
else '출고미정'
end 출고여부
from FOOD_ORDER
order by ORDER_ID;