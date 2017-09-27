create table t_customer(
	id uniqueidentifier primary key default newid(),
	email varchar(100) unique,
	[password] varchar(200),
	name varchar(100) not null,
	phone varchar(11) not null,
	plot_name	varchar(100),
	address	varchar(100),
	created_time datetime,
	last_login_time	datetime,
	status	char(1) default 'Y'
)