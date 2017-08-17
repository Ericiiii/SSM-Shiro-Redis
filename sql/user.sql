create table user
(
	id int auto_increment
		primary key,
	username varchar(20) not null,
	password varchar(20) null,
	email varchar(100) null,
	createTime datetime null,
	lastLoginTime datetime null,
	status int null
)
;