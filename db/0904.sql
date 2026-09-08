create user 'abc123'@'%' identified by 'abc123';

grant all privileges on community.* to 'abc123'@'%';

flush privileges;