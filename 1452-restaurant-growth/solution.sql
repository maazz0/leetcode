--make other tables
with daily_amount as (
    select visited_on ,
    sum(amount) as amount
    from customer
    group by visited_on
), t as(
    select visited_on,
    sum(amount) over (order by visited_on rows between 6 preceding and current row) as amount, --sum by previous 6 and current
    row_number() over(order by visited_on) as rn --write the row number 
    from daily_amount
)
select
    visited_on ,
    amount ,
    round(amount/7.0,2) as average_amount
from t
where rn >6    
