-- 코드를 입력하세요
SELECT i.animal_id, i.animal_type, i.name from animal_ins i INNER JOIN
animal_outs o on i.animal_id = o.animal_id 
where (i.sex_upon_intake = 'Intact Male' or i.sex_upon_intake = 'Intact Female')
and (o.SEX_UPON_OUTCOME = 'Spayed Female' or o.SEX_UPON_OUTCOME = 'Neutered Male')