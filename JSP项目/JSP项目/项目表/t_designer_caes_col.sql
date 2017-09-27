create table t_designer_caes_col(
	id uniqueidentifier primary key default newid(),
	customer_id	uniqueidentifier foreign key references t_customer(id),
	case_id	uniqueidentifier foreign key references t_company_case(id),
	created_time datetime
)