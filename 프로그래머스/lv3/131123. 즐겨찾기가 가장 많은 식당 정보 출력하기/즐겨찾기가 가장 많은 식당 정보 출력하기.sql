-- 코드를 입력하세요
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES  from REST_INFO
WHERE (FOOD_TYPE, FAVORITES) IN( 
    SELECT FOOD_TYPE, MAX(FAVORITES) FROM REST_INFO -- MAX() 는 진짜 딱 MAX만 나옴, 나머지 열과 관계 없는.
    GROUP BY FOOD_TYPE
)
ORDER BY FOOD_TYPE DESC;

-- 집계함수를 사용한 열은 집계함수를 사용한 열과 나머지 열의 관계를 설정하지 않으므로,
-- MAX(FAVORITES) 과 REST_ID, REST_NAME을 맞춰주지 않기 때문에 서브쿼리나 IN을 사용한다.