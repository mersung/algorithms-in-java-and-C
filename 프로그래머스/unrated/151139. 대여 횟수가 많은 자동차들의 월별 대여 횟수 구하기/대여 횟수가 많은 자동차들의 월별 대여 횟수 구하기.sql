-- 코드를 입력하세요
SELECT month(start_date) MONTH, car_id, count(car_id) as records
from car_rental_company_rental_history
where car_id in ( -- 8월 ~ 10월까지 총 5번 이상 빌린 car_id만 가져오는 것
    select car_id from car_rental_company_rental_history
    where START_DATE between '2022-08-01' and '2022-10-31'
    group by car_id
    Having count(CAR_ID) >= 5
)
and START_DATE between '2022-08-01' and '2022-10-31' -- 위에서 car_id만 가져왔으므로, 8,9,10 날짜 다시 지정해줘야함
group by MONTH, car_id -- Month별로 car_id별로 출력
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