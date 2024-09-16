-- 코드를 입력하세요
# SELECT m.MEMBER_NAME, r.REVIEW_TEXT, DATE_FORMAT(r.REVIEW_DATE, '%Y-%m-%d') REVIEW_DATE from MEMBER_PROFILE m
# INNER JOIN REST_REVIEW r on m.member_id = r.member_id
# where m.member_id = (
#     select member_id from REST_REVIEW
#     group by member_id
#     order by COUNT(REVIEW_ID) desc
#     limit 1
# )
# order by r.review_date, r.review_text




# select m.member_name, r.review_text, date_format(r.review_date, '%Y-%m-%d') from member_profile m inner join
# rest_review r on m.member_id = r.member_id
# where m.member_id =(
#     select member_id from rest_review
#     group by member_id
#     order by count(review_text) desc
#     limit 1
# )
# order by r.review_date, r.review_text

# select p.member_name, r.review_text, date_format(r.review_date, '%Y-%m-%d') 
# from member_profile p inner join rest_review r on p.member_id = r.member_id
# where p.member_id = (
#     select member_id from rest_review
#     group by member_id
#     order by count(*) desc
#     limit 1
# )
# order by r.review_date, review_text

select p.member_name, r.review_text, DATE_FORMAT(r.review_date, '%Y-%m-%d') as rDate from MEMBER_PROFILE p INNER JOIN REST_REVIEW r
on p.member_id = r.member_id
where p.member_id = (select member_id from REST_REVIEW 
group by member_id
order by COUNT(REVIEW_ID) desc
limit 1)
order by rDate, r.review_text