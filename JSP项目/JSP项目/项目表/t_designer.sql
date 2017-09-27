create table t_designer(
	id uniqueidentifier primary key default newid(),
	email varchar(100) unique,
	password varchar(200),
	name varchar(100) not null,
	headicon varchar(500) default 'head.png',
	phone varchar(11) not null,
	address	varchar(100),	
	experience varchar(50),
	style varchar(100),
	[des] varchar(500),
	created_time datetime,
	checked	char(1) default 'N',
	checked_time datetime,
	last_login_time	datetime,
	status	char(1) default 'Y'
)