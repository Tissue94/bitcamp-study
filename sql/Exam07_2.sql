/* order by */

/* 기본 인덱스 컬럼을 기준으로 정렬한다.*/
select rno, loc, name
from room;

/* 이름의 오름 차순(ascending)으로 정렬하기 */
select rno, loc, name
from room
order by name asc; /* order by 절*/

/* asc는 생략 가능하다. */
select rno, loc, name
from room
order by name;

/* 이름의 내림 차순(desceding)으로 정렬하기 */
select rno, loc, name
from room
order by name desc;

/* 이름은 오름차순, 지점명도 오름차순으로 정렬하기*/
select rno, loc, name
from room
order by name asc, loc asc;
/* 같은 이름일 경우 지점명으로 정렬 이름이 먼저 정렬되고 이름이 같은 경우 지점명이 정렬된다. */

/* 이름은 오름차순, 지점명은 내림차순으로 정렬하기*/
select rno, loc, name
from room
order by name asc, loc desc;

/* 지점명은 오름차순으로, 이름은 오름차순  정렬하기*/
select rno, loc, name
from room
order by loc asc, name asc;
