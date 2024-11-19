-- 코드를 입력하세요
# SELECT * from ANIMAL_OUTS O LEFT OUTER JOIN ANIMAL_INS I
# on I.ANIMAL_ID = O.ANIMAL_ID 
# where I.ANIMAL_ID is null
# order by O.ANIMAL_ID

# SELECT ANIMAL_OUTS.ANIMAL_ID, ANIMAL_OUTS.NAME FROM ANIMAL_OUTS
# LEFT JOIN ANIMAL_INS ON ANIMAL_OUTS.ANIMAL_ID = ANIMAL_INS.ANIMAL_ID
# WHERE ANIMAL_INS.ANIMAL_ID IS NULL
# ORDER BY ANIMAL_ID

# select o.animal_id, o.name from animal_outs o left outer join
# animal_ins i on i.animal_id = o.animal_id
# where i.animal_id is null
# order by i.animal_id;

select o.animal_id, o.name from 
animal_outs o left outer join animal_ins i on o.animal_id = i.animal_id
where i.animal_ID is null
order by o.animal_id










