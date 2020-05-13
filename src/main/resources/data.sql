INSERT INTO 
	TBL_OWNERS (first_name, last_name, email, phone_number)
VALUES
  	('Oguz', 'Talan', 'hoguztalan@gmail.com','555555555'),
  	('Test', 'User', 'xyz@email.com','555555555');

/*INSERT INTO
	TBL_APPOINTMENTS (appointment_date, appointment_time, description, priority,animal_name,animal_type)
VALUES
  	(2020-05-10, 	2020-05-13 10:10:00, 'kırık ayak','Orta','Tekir','Kedi');*/

INSERT into users values ('user1','{bcrypt}$2a$10$RrWOUpSsr0Lc6LvRXMFjnufBwfZMKyNtO08pCQf67bctm//m7Zkwm',true );
INSERT into users values ('user2','{bcrypt}$2a$10$reprOQDwwZxaAhzrfNplP.nCTb/ncFcO/vUA4/H.QYnHst9zKSFK.',true );
INSERT into users values ('user3','{bcrypt}$2a$10$/gdMuZ31FXJ1WxsaSP4EwOKcn5VydUAHxiuKpE2jot4CVT.d22bI2',true );
INSERT into users values ('manager','{bcrypt}$2a$10$VKJZJVDnEBDIR2uijeQt4.BhD3drrR2DCxv9eRpBPApOOweNy3NtO',true );



insert into authorities values('user1','ROLE_USER');
insert into authorities values('user2','ROLE_USER');
insert into authorities values('user2','ROLE_EDITOR');
insert into authorities values('user3','ROLE_USER');
insert into authorities values('user3','ROLE_EDITOR');
insert into authorities values('user3','ROLE_ADMIN');