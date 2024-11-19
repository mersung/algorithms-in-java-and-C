-- 코드를 입력하세요
# SELECT month(start_date) MONTH, car_id, count(car_id) as records
# from car_rental_company_rental_history
# where car_id in ( -- 8월 ~ 10월까지 총 5번 이상 빌린 car_id만 가져오는 것
#     select car_id from car_rental_company_rental_history
#     where START_DATE between '2022-08-01' and '2022-10-31'
#     group by car_id
#     Having count(CAR_ID) >= 5
# )
# and START_DATE between '2022-08-01' and '2022-10-31' -- 위에서 car_id만 가져왔으므로, 8,9,10 날짜 다시 지정해줘야함
# group by MONTH, car_id -- Month별로 car_id별로 출력
# order by MONTH, car_ID desc




# SELECT MONTH(START_DATE) MONTH, CAR_ID, COUNT(HISTORY_ID) RECORDS FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE CAR_ID IN (
#     SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#     WHERE DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10'
#     GROUP BY CAR_ID
#     HAVING COUNT(CAR_ID) >= 5
# )
# AND START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
# GROUP BY MONTH, CAR_ID
# ORDER BY MONTH, CAR_ID DESC

# select MONTH(START_DATE) month, car_id, count(*) from car_rental_company_rental_history
# where car_id in (select car_id from car_rental_company_rental_history
#                 where date_format(start_date, '%Y-%m') between '2022-08' and '2022-10'
#                 group by car_id
#                 having count(*) >= 5
#                )
# and date_format(start_date, '%Y-%m') between '2022-08' and '2022-10'
# group by month, car_id
# order by month, car_id desc

# select DATE_FORMAT(START_DATE, '%m') MONTH, CAR_ID, COUNT(*) RECORDS from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
# where car_id IN -- 이렇게 해야, 8,9,10월 세 달 합해서 카운트를 센게 5개 이상인 car_id만 뽑아옴, 서브쿼리 안 썼으면 각 달마다, 차 ID 별로 카운트 세서 각 달마다 5이상을 뽑게됨
# (select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY  
# where DATE_FORMAT(START_DATE, '%Y-%m') between '2022-08' and '2022-10'
# group by car_id Having COUNT(*) >=5) 
# and DATE_FORMAT(START_DATE, '%Y-%m') Between '2022-08' and '2022-10'
# group by MONTH, CAR_ID
# order by MONTH, CAR_ID DESC;


# select MONTH(START_DATE) MONTH, car_id, COUNT(*) RECORDS FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY WHERE CAR_ID IN
# (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#     WHERE DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10'
#     GROUP BY CAR_ID
#     HAVING(COUNT(*)) >= 5
# )
# AND DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10'
# GROUP BY MONTH, CAR_ID
# ORDER BY MONTH, CAR_ID DESC


select date_format(start_date, '%m') month, car_id, count(*)
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where car_id in(
    select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where date_format(start_date, '%Y-%m') between '2022-08' and '2022-10'
    group by car_id
    having count(*) >= 5
)
and date_format(start_date, '%m') between '08' and '10'
group by month, car_id
order by month, car_id desc












