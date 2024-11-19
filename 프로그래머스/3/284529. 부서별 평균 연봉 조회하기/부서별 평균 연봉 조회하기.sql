# select D.DEPT_ID, D.DEPT_NAME_EN, ROUND(AVG(H.SAL), 0) AVG_SAL from HR_DEPARTMENT D INNER JOIN  HR_EMPLOYEES H
# on D.DEPT_ID = H.DEPT_ID 
# group by D.DEPT_ID
# order by AVG_SAL desc;


select d.dept_id, d.dept_name_en, ROUND(avg(e.sal), 0) AVG_SAL from
hr_department d inner join hr_employees e on d.dept_id = e.dept_id
group by dept_id
order by avg_sal desc









