create table t_designer_col(
	id uniqueidentifier primary key default newid(),
	customer_id	uniqueidentifier foreign key references t_customer(id),
	designer_id uniqueidentifier foreign key references t_designer(id),
	created_time datetime
)