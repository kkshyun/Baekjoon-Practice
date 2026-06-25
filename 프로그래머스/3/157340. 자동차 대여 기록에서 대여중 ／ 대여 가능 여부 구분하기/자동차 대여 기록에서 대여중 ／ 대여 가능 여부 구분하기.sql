-- 코드를 입력하세요
select total.CAR_ID,
CASE 
           WHEN avail.CAR_ID IS NULL THEN '대여 가능'
           ELSE '대여중'
       END AS AVAILABILITY
from (select distinct car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY) as total left join 
(SELECT distinct CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE DATE_FORMAT(START_DATE,'%Y-%m-%d') <= '2022-10-16' and DATE_FORMAT(END_DATE,'%Y-%m-%d') >= '2022-10-16') as avail
on total.car_id = avail.car_id
order by total.CAR_ID desc
