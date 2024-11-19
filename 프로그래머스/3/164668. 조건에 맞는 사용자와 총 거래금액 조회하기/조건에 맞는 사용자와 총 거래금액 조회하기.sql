-- 코드를 입력하세요
# SELECT U.USER_ID, U.NICKNAME, SUM(F.PRICE) as TOTAL_SALES from USED_GOODS_USER U 
# INNER JOIN USED_GOODS_BOARD F ON F.WRITER_ID = U.USER_ID
# WHERE F.STATUS = 'DONE'
# GROUP BY U.USER_ID
# HAVING SUM(F.PRICE) >= 700000
# order by SUM(F.PRICE);



# select u.user_id, u.nickname, sum(price) from used_goods_user u inner join
# used_goods_board b on u.user_id = b.writer_id
# where b.status = 'done'
# group by u.user_id
# having sum(b.price) >= 700000
# order by sum(b.price)

# select user_id, nickname, sum(price) from used_goods_board b 
# inner join used_goods_user u on b.writer_id = u.user_id
# where status = 'DONE'
# group by u.user_id
# having sum(price) >= 700000
# order by sum(price);

# select USER_ID, NICKNAME, SUM(PRICE) from USED_GOODS_BOARD b
# INNER JOIN USED_GOODS_USER u on b.WRITER_ID = u.USER_ID
# where b.status = 'DONE'
# group by u.user_ID
# having SUM(PRICE) >= 700000
# order by SUM(PRICE);

select user_id, nickname, sum(price) total_sales from 
used_goods_board b inner join used_goods_user u
on b.writer_id = u.user_id
where status = 'DONE'
group by user_id
having total_sales >= 700000
order by total_sales 









