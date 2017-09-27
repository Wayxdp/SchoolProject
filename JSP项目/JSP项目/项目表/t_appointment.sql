create table t_appointment(
	id uniqueidentifier primary key default newid(),
	[user_id] uniqueidentifier,	
	company_id uniqueidentifier,	
	name varchar(50) not null,
	phone varchar(11) not null,
	plot_name varchar(100) not null,
	area float not null,
	way	varchar(10),
	budget varchar(20),
	created_time datetime
)