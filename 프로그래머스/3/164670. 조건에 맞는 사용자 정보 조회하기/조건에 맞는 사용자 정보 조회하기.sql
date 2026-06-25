-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, concat(CITY,' ',STREET_ADDRESS1,' ',STREET_ADDRESS2) as '전체주소', concat(substring(TLNO,1,3),'-',substring(TLNO,4,4),'-',substring(TLNO,8,4))as '전화번호'
from USED_GOODS_USER
where user_id in (select writer_id from USED_GOODS_BOARD group by writer_id having count(*) >= 3)
order by USER_ID desc