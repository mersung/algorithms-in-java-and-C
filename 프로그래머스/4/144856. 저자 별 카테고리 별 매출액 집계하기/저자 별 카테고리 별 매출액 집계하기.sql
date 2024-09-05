-- 2022년 1월에 저자별로 카테고리별 매출액을 구해서 리스트 출력
# SELECT A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, sum(B.PRICE*S.SALES) 
# FROM BOOK B INNER JOIN AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID
# INNER JOIN BOOK_SALES S ON B.BOOK_ID = S.BOOK_ID
# WHERE DATE_FORMAT(S.SALES_DATE, '%Y-%m') = '2022-01' 
# GROUP BY A.AUTHOR_ID, B.CATEGORY
# ORDER BY A.AUTHOR_ID, B.CATEGORY DESC

# select a.author_id, a.author_name, b.category, sum(b.price*s.sales) from book b 
# inner join book_sales s on b.book_id = s.book_id inner join author a
# on a.author_id = b.author_id
# where date_format(s.sales_date, '%Y-%m') = '2022-01'
# group by a.author_id, b.category
# order by a.author_id, b.category desc;

# select a.author_id, a.author_name, b.category, sum(s.sales*b.price)
# from book b inner join author a on b.author_id = a.author_id
# inner join book_sales s on b.book_id = s.book_id
# where date_format(sales_date, '%Y-%m') = '2022-01'
# group by a.author_id, b.category
# order by a.author_id, b.category desc;

# select A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, (SUM(S.SALES*B.PRICE)) AS TOTAL_SALES
# FROM AUTHOR A INNER JOIN BOOK B ON A.AUTHOR_ID = B.AUTHOR_ID 
# INNER JOIN BOOK_SALES S ON S.BOOK_ID = B.BOOK_ID
# WHERE DATE_FORMAT(S.SALES_DATE, '%Y-%m') = '2022-01'
# group by A.author_id, b.category
# order by a.author_id, B.category desc;

SELECT A.AUTHOR_ID, A.AUTHOR_NAME , CATEGORY, SUM(SALES*PRICE) SALES FROM BOOK B
INNER JOIN AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID INNER JOIN BOOK_SALES S
ON B.BOOK_ID = S.BOOK_ID
WHERE DATE_FORMAT(SALES_DATE, '%Y-%m') = '2022-01'
GROUP BY A.AUTHOR_ID, CATEGORY
ORDER BY A.AUTHOR_ID, CATEGORY DESC









