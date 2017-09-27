create table t_designer_case(
	id uniqueidentifier primary key default newid(),
	designer_id	uniqueidentifier foreign key references t_designer(id),
	name varchar(100) not null,
	plot_name varchar(100) not null,
	style varchar(20) not null,
	image_1	varchar(500),
	image_2	varchar(500),	
	image_3	varchar(500),	
	image_4	varchar(500),	
	image_5	varchar(500),	
	des	varchar(500),
	created_time	datetime,
	status	char(1) default 'Y'
)