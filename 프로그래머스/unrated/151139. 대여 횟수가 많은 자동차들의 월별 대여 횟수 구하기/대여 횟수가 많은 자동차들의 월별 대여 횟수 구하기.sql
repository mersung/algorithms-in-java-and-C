-- 코드를 입력하세요
SELECT month(start_date) MONTH, car_id, count(car_id) as records
from car_rental_company_rental_history
where car_id in (
    select car_id from car_rental_company_rental_history
    where START_DATE between '2022-08-01' and '2022-10-31'
    group by car_id
    Having count(CAR_ID) >= 5
)
and START_DATE between '2022-08-01' and '2022-10-31'
group by MONTH, car_id
order by MONTH, car_ID desc








-- 코드를 입력하세요
# select month(start_date), car_id, count(car_id) records
# from car_rental_company_rental_history
# where car_id in (
#                 SELECT car_id
#                 from car_rental_company_rental_history
#                 where start_date between '2022-08-01' and '2022-10-31'
#                 group by 1
#                 having count(car_id) >= 5
#                 )
# and start_date between '2022-08-01' and '2022-10-31'
# group by 1, 2
# order by 1, 2 desc