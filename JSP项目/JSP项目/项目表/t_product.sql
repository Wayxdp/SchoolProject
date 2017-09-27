create table t_product(
	id uniqueidentifier primary key default newid(),
	supply_id uniqueidentifier foreign key references t_supply(id),
	name varchar(100) not null,
	price float not null,
	sale_price float not null,
	image varchar(500) not null,
	des	varchar(500),	
	created_time datetime,
	status	char(1) default 'Y'
)