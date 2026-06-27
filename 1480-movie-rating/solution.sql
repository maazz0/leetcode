(
select u.name  as results
from users u join movierating m on u.user_id = m.user_id
group by m.user_id ,u.name
order by count(*) desc , u.name
limit 1
)
union all 
(
select mv.title as results
from movies mv join movieRating m on m.movie_id= mv.movie_id
where created_at between '2020-02-01' and '2020-02-29'
group by m.movie_id , mv.title
order by avg(rating) desc , mv.title
limit 1
);
