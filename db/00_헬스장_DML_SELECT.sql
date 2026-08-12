# 헬스장에 등록된 회원 목록을 조회 
select * from user;

# 헬스장에 등록된 회원 수를 조회 
select count(*) from user;

# 헬스장에 등록된 프로그램를 조회 
select * from program;
# 모닝요가를 수강신청한 인원수를 조회
#1
SELECT title, COUNT(course.user_id) AS 신청인원수
FROM course
JOIN program
    ON course.program_id = program.id
WHERE program.title = '모닝 요가';

#2
SELECT 
    COUNT(*)
FROM
    course
        JOIN
    program ON course.program_id = program.id
WHERE
    program_id = 1;
  
#3
SELECT 
    COUNT(*) AS 모닝요가수강인원
FROM
    course
WHERE
    program_id IN (SELECT 
            id
        FROM
            program
        WHERE
            title = '모닝 요가');
            
#4
SELECT 
    course.*
FROM
    course
WHERE
    program_id IN (SELECT 
            id
        FROM
            program
        WHERE
            title = '모닝 요가'); 
            
# 프로그램별 수강인원을 조회
select title, count(user_id) from course join program on course.program_id = program.id group by program.id;



SELECT 
    program.*, name, CONCAT(COUNT(course.program_id), '명') as 수강인원
FROM
    program 
        LEFT JOIN
    course ON program_id = program.id
    join trainer on program.trainer_id = trainer.id
GROUP BY program.id;

# 사물함을 조회 
select * from locker;

# 사물함이 사용중이면 O, 아니면 X로 조회 
# if(조건, 참, 거짓)
# where 컬럼 = null : X 
# where 컬럼 is null : O 

#1
select id, if(user_id is null, 'X', 'O') as 사용여부 from locker order by id; 

#2
SELECT 
    id 라커번호, 
    IF(user_id IS NULL, 'X', 'O') as '사용여부'
FROM
    locker
ORDER BY id;

# 라커를 이용중인 회원명을 조회 
#1
select user.name from locker join user on locker.user_id = user.id where user_id is not null;
#2
select locker.id, ifnull(user.name,'비어있음') as 사용자명 from locker left join user on locker.user_id = user.id order by locker.id;

#3
select locker.id 
	as 라커번호, 
		ifnull(user.name, '비어 있음') as 사용자명 
    from locker 
    left join user  
    on locker.user_id = user.id order by id;
    
# 프로그램별 현재 출석 인원수를 조회
#1 
SELECT 
    title, COUNT(state)
FROM
    attendance
        RIGHT JOIN
    program ON program_id = program.id
        AND date = CURDATE()
GROUP BY program.id;
#2
SELECT 
    program.*, COUNT(date) as 출석인원수
FROM
    (SELECT 
        *
    FROM
        attendance
    WHERE
        date = CURDATE()) att
        RIGHT JOIN
    program ON program_id = program.id
GROUP BY program.id;
