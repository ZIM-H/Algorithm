-- 코드를 작성해주세요
select dept_id, d.dept_name_en, info.avg_sal
from (select dept_name_en, round(avg(sal), 0) avg_sal
    from hr_department d JOIN hr_employees e ON d.dept_id = e.dept_id
    group by dept_name_en) info join hr_department d on info.dept_name_en = d.dept_name_en
order by 3 desc;