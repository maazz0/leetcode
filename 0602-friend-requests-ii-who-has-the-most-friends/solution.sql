-- Write your PostgreSQL query statement below
with m as (
    (
    select requester_id AS id 
    from RequestAccepted
    )
union all 
    (
    select accepter_id as id 
    from RequestAccepted
    )
), cnt as (
        select id , count(*) as num
        from m
        group by id
)
select id , num
from (
    select *,
    rank() over(order by num desc) as r
    from cnt
)
where r=1;
