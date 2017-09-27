create table t_product_col(
	id uniqueidentifier primary key default newid(),
	customer_id	uniqueidentifier foreign key references t_customer(id),
	product_id uniqueidentifier foreign key references t_product(id),
	created_time datetime
)