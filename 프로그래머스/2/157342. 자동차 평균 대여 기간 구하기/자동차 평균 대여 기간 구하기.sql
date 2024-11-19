# -- 코드를 입력하세요
# SELECT car_id, ROUND(AVG(DATEDIFF(END_DATE,START_DATE)+1),1)  average_duration from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# group by car_id
# having average_duration >= 7
# order by average_duration desc, car_id desc


# select car_id, ROUND(AVG(DATEDIFF(END_DATE,START_DATE)+1), 1) as AVERAGE_DURATION
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# group by car_ID
# having(average_duration) >= 7
# order by average_duration desc, car_id desc

# SELECT CAR_ID, ROUND(AVG(DATEDIFF(END_DATE, START_DATE)+1), 1) AVERAGE_DURATION 
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# GROUP BY CAR_ID
# HAVING AVERAGE_DURATION >= 7
# ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC;

# select car_id, ROUND(AVG(DATEDIFF(END_DATE, START_DATE) + 1), 1) AVERAGE_DURATION
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# group by car_id
# having AVERAGE_DURATION >= 7
# order by AVERAGE_DURATION DESC, CAR_ID DESC

select car_id, ROUND(avg(DATEDIFF(end_date, start_date))+1, 1) average_duration
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
having average_duration >= 7
order by average_duration desc, car_id desc








