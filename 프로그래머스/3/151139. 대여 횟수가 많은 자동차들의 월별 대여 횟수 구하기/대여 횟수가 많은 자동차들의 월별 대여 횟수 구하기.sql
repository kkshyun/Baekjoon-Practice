SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
where CAR_ID in (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
      WHERE DATE_FORMAT(START_DATE,'%Y-%m')<'2022-11' AND DATE_FORMAT(START_DATE,'%Y-%m')>='2022-08'
     GROUP BY CAR_ID
     HAVING COUNT(*) >= 5)AND (DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10')
GROUP BY MONTH, CAR_ID
HAVING COUNT(*) != 0
ORDER BY MONTH, CAR_ID DESC
