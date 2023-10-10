-- 코드를 입력하세요
SELECT m.MEMBER_NAME, r.REVIEW_TEXT, DATE_FORMAT(r.REVIEW_DATE, '%Y-%m-%d') REVIEW_DATE from MEMBER_PROFILE m
INNER JOIN REST_REVIEW r on m.member_id = r.member_id
where m.member_id = (
    select member_id from REST_REVIEW
    group by member_id
    order by COUNT(REVIEW_ID) desc
    limit 1
)
order by r.review_date, r.review_text