create table t_admin(
	id uniqueidentifier primary key default newid(),
	email varchar(100) unique,
	password varchar(200),
	phone varchar(11) not null,
	[role] varchar(10),
	created_time datetime,
	last_login_time	datetime,
	status	char(1) default 'Y'
)