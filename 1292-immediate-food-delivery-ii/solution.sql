select 
    round(
        sum(
            case when order_date=customer_pref_delivery_date 
            and order_date=(
                select min(order_date) 
                from delivery d1 
                where d1.customer_id =d2.customer_id) then 1 else 0 end) * 100.0 
        / count(distinct(customer_id)):: numeric ,
        2 ) as immediate_percentage
    from delivery d2
        

