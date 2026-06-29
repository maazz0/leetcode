select d.name as Department , e.name as Employee , Salary
from department d join (
    select * , dense_rank() over(partition by departmentid order by salary desc) as rnk from employee ) e 
    on d.id = e.departmentId
where e.rnk < 4 

