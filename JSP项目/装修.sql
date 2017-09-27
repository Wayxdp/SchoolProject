create database Animo_Home_Decoration
go 

use Animo_Home_Decoration;

go

/**装修公司表t_company**/
create table t_company
(
	id uniqueidentifier primary key default newid(),
	email varchar(100) unique,
	password varchar(200),
	name varchar(100) not null,
	principal varchar(10) not null,
	logo varchar(500) default('company_def.png'),
	address varchar(100) not null,   /**地址**/
	phone varchar(11) not null,
	tel varchar(11),
	open_date datetime not null,
	longitude float,/**经度**/
	latitude float,/**纬度**/
	des varchar(500),/**公司描述**/ 
	created_time datetime,
	checked char(1) default('N') check (checked='N' or checked = 'Y'),
	checked_time datetime,
	last_login_time datetime,
	status char(1) default('Y') check (status='N' or status = 'Y'),
);

/**建材商表**/

create table t_supply
(
	id uniqueidentifier primary key default newid(),
	email varchar(100) unique,
	password varchar(200),
	name varchar(100) not null,
	principal varchar(10) not null,
	logo varchar(500) default('company_def.png'),
	address varchar(100) not null,   /**地址**/
	phone varchar(11) not null,
	tel varchar(11),
	open_date datetime not null,
	longitude float,/**经度**/
	latitude float,/**纬度**/
	des varchar(500),/**公司描述**/
	created_time datetime,
	checked char(1) default('N') check (checked='N' or checked = 'Y'),
	checked_time datetime,
	last_login_time datetime,
	status char(1) default('Y') check (status='N' or status = 'Y'),
);
/**设计师表t_designer**/
create table t_designer
(
	id uniqueidentifier primary key default newid(),
	email varchar(100) unique,
	password varchar(200),
	name varchar(100) not null,
	headicon varchar(500) default('designer_def'),
	phone varchar(11) not null,
	address varchar(100) not null,   /**地址**/
	experience varchar(50),
	style varchar(100),
	des varchar(500),
	created_time datetime,
	checked char(1) default('N') check (checked='N' or checked = 'Y'),
	checked_time datetime,
	last_login_time datetime,
	status char(1) default('Y') check (status='N' or status = 'Y'),
);

/**装修公司案例表**/

create table t_company_case
(
	id uniqueidentifier primary key default newid(),
	company_id uniqueidentifier foreign key references t_company(id),
	name varchar(100) not null,/**案列名称**/
	plot_name varchar(100) not null,/**小区名称**/
	style varchar(20) not null,
	image_1 varchar(500),
	image_2 varchar(500),
	image_3 varchar(500),
	image_4 varchar(500),
	image_5 varchar(500),
	des varchar(500),
	created_time datetime,
	status char(1) default('Y') check (status='N' or status = 'Y'),
);

/**设计师案列表**/

create table t_designer_case
(
	caseid uniqueidentifier primary key default newid(),
	designer_id uniqueidentifier foreign key references t_designer(id),
	casename varchar(100) not null,/**案列名称**/
	plot_name varchar(100) not null,/**小区名称**/
	style varchar(20) not null,
	image_1 varchar(500),
	image_2 varchar(500),
	image_3 varchar(500),
	image_4 varchar(500),
	image_5 varchar(500),
	des varchar(500),
	created_time datetime,
	status char(1) default('Y') check (status='N' or status = 'Y'),
);
/**装修公司活动表t_company_activity**/

create table t_company_activity
(
	id uniqueidentifier primary key default newid(),
	company_id uniqueidentifier foreign key references t_company(id),
	name varchar(100) not null,
	image varchar(500),
	des varchar(500) not null,
	created_time datetime,
	status char(1) default('Y') check (status='N' or status = 'Y'),
);

/**建材商活动表t_supply_activity***/

create table t_supply_activity
(
	id uniqueidentifier primary key default newid(),
	supply_id uniqueidentifier foreign key references t_supply(id),
	name varchar(100) not null,
	image varchar(500),
	des varchar(500) not null,
	created_time datetime,
	status char(1) default('Y') check (status='N' or status = 'Y'),
);

/**建材表t_product***/
create table t_product
(
	id uniqueidentifier primary key default newid(),
	supply_id uniqueidentifier foreign key references t_supply(id),
	name varchar(100) not null,
	price float not null,
	sale_price float not null,/*打折后**/
	image varchar(500),
	des varchar(500) not null,
	created_time datetime,
	status char(1) default('Y') check (status='N' or status = 'Y'),
);

/**用户表**/

create table t_customer
(
	id uniqueidentifier primary key default newid(),
	email varchar(100) unique,
	password varchar(200),
	name varchar(100) not null,
	phone varchar(11) not null,
	plot_name varchar(100),
	address varchar(100) not null, 
	created_time datetime,
	last_login_time datetime,
	status char(1) default('Y') check (status='N' or status = 'Y'),
);

/**装修公司收藏表t_company_col**/
create table t_company_col
(
	id uniqueidentifier primary key default newid(),
	customer_id uniqueidentifier foreign key references t_customer(id),
	company_id uniqueidentifier foreign key references t_company(id), 
	created_time datetime,
);
/**建材商收藏表t_supply_col**/

create table t_supply_col
(
	id uniqueidentifier primary key default newid(),
	customer_id uniqueidentifier foreign key references t_customer(id),
	supply_id uniqueidentifier foreign key references t_supply(id), 
	created_time datetime,
);

/**设计师收藏表t_designer_col**/
create table t_designer_col
(
	id uniqueidentifier primary key default newid(),
	customer_id uniqueidentifier foreign key references t_customer(id),
	designer_id uniqueidentifier foreign key references t_designer(id), 
	created_time datetime,
);
/**建材收藏表t_product_col**/
create table t_product_col
(
	id uniqueidentifier primary key default newid(),
	customer_id uniqueidentifier foreign key references t_customer(id),
	product_id uniqueidentifier foreign key references t_product(id), 
	created_time datetime,
);

/**装修公司案例收藏表t_company_case_col**/
create table t_company_case_col
(
	id uniqueidentifier primary key default newid(),
	customer_id uniqueidentifier foreign key references t_customer(id),
	company_id uniqueidentifier foreign key references t_company_case(id), 
	created_time datetime,
);

/**设计师案例收藏表t_designer_case_col**/
/**?????????????****/

create table t_designer_case_col
(
	id uniqueidentifier primary key default newid(),
	customer_id uniqueidentifier foreign key references t_customer(id),
	company_id uniqueidentifier foreign key references t_designer_case(caseid), 
	created_time datetime
);
/**设计师表预约表t_appointment**/
create table t_designer_appointment
(
	id uniqueidentifier primary key default newid(),
	user_id uniqueidentifier  foreign key references t_customer(id),
	designer_id uniqueidentifier foreign key references t_designer(id),
	name varchar(50) not null,
	phone varchar(11) not null,
	plot_name varchar(100) not null,
	area float not null,
	way varchar(10) check(way='harf' or way='whole'),
	budget varchar(20),
	created_time datetime,
);

/** 建材商预约表*/
create table t_supply_appointment
(
	id uniqueidentifier primary key default newid(),
	user_id uniqueidentifier  foreign key references t_customer(id),
	designer_id uniqueidentifier foreign key references t_supply(id),
	name varchar(50) not null,
	phone varchar(11) not null,
	plot_name varchar(100) not null,
	area float not null,
	way varchar(10) check(way='harf' or way='whole'),
	budget varchar(20),
	created_time datetime,
);

/** 装修公司预约表*/
create table t_company_appointment
(
	id uniqueidentifier primary key default newid(),
	user_id uniqueidentifier  foreign key references t_customer(id),
	designer_id uniqueidentifier foreign key references t_company(id),
	name varchar(50) not null,
	phone varchar(11) not null,
	plot_name varchar(100) not null,
	area float not null,
	way varchar(10) check(way='harf' or way='whole'),
	budget varchar(20),
	created_time datetime,
);

/**设计师用户咨询表t_appointment**/
create table t_designer_userconsult
(
	id uniqueidentifier primary key default newid(),
	designer_id uniqueidentifier foreign key references t_designer(id),
	name varchar(50) not null,
	phone varchar(11) not null,
	leave_word varchar(500)not null,
	email varchar(100),
	qq varchar(11),
	created_time datetime,
);
/**装修公司用户咨询表t_appointment**/
create table t_company_userconsult
(
	id uniqueidentifier primary key default newid(),
	compnay_id uniqueidentifier foreign key references t_company(id),
	name varchar(50) not null,
	phone varchar(11) not null,
	leave_word varchar(500)not null,
	email varchar(100),
	qq varchar(11),
	created_time datetime,
);
/**建材商用户咨询表t_appointment**/
create table t_supply_userconsult
(
	id uniqueidentifier primary key default newid(),
	supply_id uniqueidentifier foreign key references t_supply(id),
	name varchar(50) not null,
	phone varchar(11) not null,
	leave_word varchar(500)not null,
	email varchar(100),
	qq varchar(11),
	created_time datetime,
);

/**管理员表t_admin**/
create table t_admin
(
	id uniqueidentifier primary key default newid(),
	email varchar(100) unique,
	password varchar(200),
	name varchar(100) not null,
	phone varchar(11) not null,
	role varchar(10),  /**角色**/
	created_time datetime,
	last_login_time datetime,
	status char(1) default('Y') check (status='N' or status = 'Y'),
);