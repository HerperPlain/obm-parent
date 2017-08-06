INSERT  INTO  sys_user(user_id, create_time, create_user, email, enable, head_pic, last_login_ip, last_login_time, nickname, passwd, show_order, update_time, update_user, username)
VALUES (date_format(sysdate(),'%Y%m%d%h%m%s%f'),sysdate(),null, 'hpsgts@live.com',1,null,null,null,'Herper','000000',1,sysdate(),null,'admin')
