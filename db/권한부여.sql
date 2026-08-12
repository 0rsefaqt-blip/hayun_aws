# 권한부여 
# 권한부여를 위한 것
# 1. 계정 
# 계정 만들기 
create user 'asdasd'@'%' identified by 'asdasd'; 
# 2. DB
create database tt;

# 권한부여 
grant all privileges on tt.* to 'asdasd'@'%';