create table t_supply_activity(
	id uniqueidentifier primary key default newid(),
	supply_id uniqueidentifier foreign key references t_supply(id),
	name varchar(100) not null,
	[image] varchar(500),
	des	varchar(500) not null,
	created_time datetime,
	status	char(1) default 'Y'
)