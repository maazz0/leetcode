-- Write your PostgreSQL query statement below
select c.category , count(t.category) as accounts_count
from (
    VALUES
        ('Low Salary'),
        ('Average Salary'),
        ('High Salary')
    ) AS c(category) left join(
    select (
        case 
        when income < 20000 then 'Low Salary' 
        when income between 20000 and 50000 then 'Average Salary' 
        else 'High Salary'end) as category
        from accounts) as t
        on c.category = t.category 
    group by c.category
