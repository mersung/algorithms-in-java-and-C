# -- 코드를 입력하세요
# SELECT CAR_TYPE, COUNT(*) as CARS from CAR_RENTAL_COMPANY_CAR
# where OPTIONS LIKE '%통풍시트%' or OPTIONS LIKE '%열선시트%' or OPTIONS LIKE '%가죽시트'
# GROUP BY CAR_TYPE
# order by CAr_TYPE




# select car_type, count(*) as cars from car_rental_company_car
# where options LIKE '%통풍시트%' or options LIKE '%열선시트%' or options LIKE '%가죽시트%'
# group by car_type
# order by car_type

# select car_type, count(*) as cars from CAR_RENTAL_COMPANY_CAR
# where OPTIONS LIKE '%통풍시트%'
# or OPTIONS LIKE '%열선시트%'
# or OPTIONS LIKE '%가죽시트%'
# group by car_type
# order by car_type

select CAR_TYPE, COUNT(*) from CAR_RENTAL_COMPANY_CAR cars
where OPTIONS LIKE '%통풍시트%'
or OPTIONS LIKE '%열선시트%'
or OPTIONS LIKE '%가죽시트%'
group by car_type 
order by CAR_TYPE;










