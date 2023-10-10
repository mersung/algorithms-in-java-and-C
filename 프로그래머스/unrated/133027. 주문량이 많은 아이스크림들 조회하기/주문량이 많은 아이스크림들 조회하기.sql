-- 코드를 입력하세요
SELECT f.FLAVOR from FIRST_HALF f INNER JOIN JULY j
on f.flavor = j.flavor
group by flavor
order by (f.TOTAL_ORDER + SUM(j.TOTAL_ORDER)) desc
limit 3

# select * from FIRST_HALF UNION select * from JULY;
