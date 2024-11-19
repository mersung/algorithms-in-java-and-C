# (select DATE_FORMAT(SALES_DATE, '%Y-%m-%d') SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
# from ONLINE_SALE where DATE_FORMAT(SALES_DATE, '%Y-%m') = '2022-03')

# UNION

# (select DATE_FORMAT(SALES_DATE, '%Y-%m-%d') SALES_DATE, PRODUCT_ID, NULL as USER_ID, SALES_AMOUNT
# from OFFLINE_SALE where DATE_FORMAT(SALES_DATE, '%Y-%m') = '2022-03'
# )
# order by SALES_DATE, PRODUCT_ID, USER_ID


# (select date_format(SALES_DATE, '%Y-%m-%d') sales_date, PRODUCT_ID, USER_ID, SALES_AMOUNT FROM ONLINE_SALE 
# WHERE DATE_FORMAT(SALES_DATE, '%Y-%m') = '2022-03')

# UNION 

# (select date_format(SALES_DATE,'%Y-%m-%d'), PRODUCT_ID, null, SALES_AMOUNT from offline_sale
# where date_format(sales_date, '%Y-%m') = '2022-03')

# order by sales_date, product_id, user_id


# (select DATE_FORMAT(SALES_DATE, '%Y-%m-%d') sales_date, PRODUCT_ID, USER_ID, SALES_AMOUNT
# from ONLINE_SALE where DATE_FORMAT(SALES_DATE, '%Y-%m') = '2022-03') 
# UNION ALL
# (select  DATE_FORMAT(SALES_DATE, '%Y-%m-%d') sales_date, PRODUCT_ID, NULL, SALES_AMOUNT
# from OFFLINE_SALE where DATE_FORMAT(SALES_DATE, '%Y-%m') = '2022-03') 
# order by SALES_DATE, PRODUCT_ID, USER_ID;


# (select DATE_FORMAT(SALES_DATE, '%Y-%m-%d') SALES_DATE, PRODUCT_ID, user_id, SALES_AMOUNT
# from ONLINE_SALE
# where DATE_FORMAT(SALES_DATE, '%Y-%m') = '2022-03')
# UNION ALL
# (select DATE_FORMAT(SALES_DATE, '%Y-%m-%d') SALES_DATE, PRODUCT_ID, NULL, SALES_AMOUNT
# from OFFLINE_SALE
# where DATE_FORMAT(SALES_DATE, '%Y-%m') = '2022-03')

# order by SALES_DATE, PRODUCT_ID, user_id;

(select date_format(sales_date, '%Y-%m-%d') sales_date, product_id, user_id, sales_amount from ONLINE_SALE
where date_format(sales_date, '%Y-%m') = '2022-03')
UNION ALL
(select  date_format(sales_date, '%Y-%m-%d') sales_date, product_id, NULL, sales_amount from OFFLINE_SALE
where date_format(sales_date, '%Y-%m') = '2022-03')
order by sales_date, product_id, user_id