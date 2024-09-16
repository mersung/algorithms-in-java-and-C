-- 코드를 입력하세요
# SELECT f.FLAVOR from FIRST_HALF f INNER JOIN JULY j
# on f.flavor = j.flavor
# group by flavor
# order by SUM(f.TOTAL_ORDER + j.TOTAL_ORDER) desc
# limit 3

# select * from FIRST_HALF UNION select * from JULY;

# select h.flavor from first_half h 
# inner join july j on h.flavor = j.flavor
# group by h.flavor
# order by (h.total_order + j.total_order) desc
# limit 3;



select h.flavor from first_half h inner join july j 
on h.flavor = j.flavor
group by h.flavor
order by sum(h.total_order)+sum(j.total_order) desc
limit 3;









