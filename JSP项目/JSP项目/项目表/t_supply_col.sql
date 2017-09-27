create table t_supply_col(
	id uniqueidentifier primary key default newid(),
	customer_id	uniqueidentifier foreign key references t_customer(id),
	supply_id uniqueidentifier foreign key references t_supply(id),
	created_time datetime
)