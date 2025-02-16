SELECT C.CAR_ID, C.CAR_TYPE, ROUND((C.DAILY_FEE * 30 * (1-(SUBSTRING_INDEX(P.DISCOUNT_RATE,'%',1))/100))) AS FEE
FROM CAR_RENTAL_COMPANY_CAR C LEFT JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H
ON C.CAR_ID = H.CAR_ID
AND H.START_DATE <= '2022-12-01' AND H.END_DATE >= '2022-11-01' 
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P
ON C.CAR_TYPE = P.CAR_TYPE
WHERE C.CAR_TYPE IN ('세단','SUV') AND P.DURATION_TYPE ='30일 이상' AND H.CAR_ID IS NULL
GROUP BY C.CAR_ID
HAVING FEE >=500000 AND FEE <2000000
ORDER BY 3 DESC, 2, 1 DESC;
