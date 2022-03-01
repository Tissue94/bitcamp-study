/* union 과 union all */

/* select 결과 합치기
   union : 중복 값 자동 제거, 같은 데이터(중복되는 데이터)를 하나로 본다 */
select distinct bank from stnt
union
select distinct bank from tcher;

/* union all: 중복 값 제거 안함*/
select distinct bank from stnt
union all
select distinct bank from tcher;

/* 차집합
mysql은 차집합 문법을 지원하지 않는다.
따라서 다음과 같이 기존의 SQL문법을 사용해서
where 절의 조건으로 처리해야 한다.
*/
select distinct bank
from stnt
where not bank in (select distinct bank from tcher);

/* 교집합
mysql은 차집합 문법을 지원하지 않는다.
따라서 다음과 같이 기존의 SQL문법을 사용해서
where 절의 조건으로 처리해야 한다.
*/
select distinct bank
from stnt
where bank in (select distinct bank from tcher);
