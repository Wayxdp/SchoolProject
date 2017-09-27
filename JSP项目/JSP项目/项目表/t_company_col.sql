create table t_company_col(
	id uniqueidentifier primary key default newid(),
	customer_id	uniqueidentifier foreign key references t_customer(id),
	company_id	uniqueidentifier foreign key references t_company(id),
	created_time datetime
)