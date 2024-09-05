-- 코드를 입력하세요
# SELECT B.CATEGORY, SUM(S.SALES) as TOTAL_SALES
# from BOOK B INNER JOIN BOOK_SALES S
# on B.BOOK_ID = S.BOOK_ID
# where DATE_FORMAT(S.SALES_DATE, '%Y-%m') = '2022-01' 
# GROUP BY B.CATEGORY
# ORDER BY B.CATEGORY

# select b.category, sum(s.sales) from book b
# inner join book_sales s on b.book_id = s.book_id
# where date_format(s.sales_date, '%Y-%m') = '2022-01'
# group by b.category
# order by b.category;

select category, sum(s.SALES) from Book B Inner join
BOOK_SALES S on B.Book_Id = S.BOOK_ID
where Date_format(s.sales_Date, '%Y-%m') = '2022-01'
group by category
order by category;

select category, SUM(SALES) from BOOK_SALES S INNER JOIN BOOK B
on s.book_id = b.book_id
where DATE_FORMAT(SALES_DATE, '%Y-%m') = '2022-01'
group by category
order by category









