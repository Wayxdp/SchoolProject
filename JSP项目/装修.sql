create database Animo_Home_Decoration
go 

use Animo_Home_Decoration;

go

/**װ�޹�˾��t_company**/
create table t_company
(
	id uniqueidentifier primary key default newid(),
	email varchar(100) unique,
	password varchar(200),
	name varchar(100) not null,
	principal varchar(10) not null,
	logo varchar(500) default('company_def.png'),
	address varchar(100) not null,   /**��ַ**/
	phone varchar(11) not null,
	tel varchar(11),
	open_date datetime not null,
	longitude float,/**����**/
	latitude float,/**γ��**/
	des varchar(500),/**��˾����**/ 
	created_time datetime,
	checked char(1) default('N') check (checked='N' or checked = 'Y'),
	checked_time datetime,
	last_login_time datetime,
	status char(1) default('Y') check (status='N' or status = 'Y'),
);

/**�����̱�**/

create table t_supply
(
	id uniqueidentifier primary key default newid(),
	email varchar(100) unique,
	password varchar(200),
	name varchar(100) not null,
	principal varchar(10) not null,
	logo varchar(500) default('company_def.png'),
	address varchar(100) not null,   /**��ַ**/
	phone varchar(11) not null,
	tel varchar(11),
	open_date datetime not null,
	longitude float,/**����**/
	latitude float,/**γ��**/
	des varchar(500),/**��˾����**/
	created_time datetime,
	checked char(1) default('N') check (checked='N' or checked = 'Y'),
	checked_time datetime,
	last_login_time datetime,
	status char(1) default('Y') check (status='N' or status = 'Y'),
);
/**���ʦ��t_designer**/
create table t_designer
(
	id uniqueidentifier primary key default newid(),
	email varchar(100) unique,
	password varchar(200),
	name varchar(100) not null,
	headicon varchar(500) default('designer_def'),
	phone varchar(11) not null,
	address varchar(100) not null,   /**��ַ**/
	experience varchar(50),
	style varchar(100),
	des varchar(500),
	created_time datetime,
	checked char(1) default('N') check (checked='N' or checked = 'Y'),
	checked_time datetime,
	last_login_time datetime,
	status char(1) default('Y') check (status='N' or status = 'Y'),
);

/**װ�޹�˾������**/

create table t_company_case
(
	id uniqueidentifier primary key default newid(),
	company_id uniqueidentifier foreign key references t_company(id),
	name varchar(100) not null,/**��������**/
	plot_name varchar(100) not null,/**С������**/
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

/**���ʦ���б�**/

create table t_designer_case
(
	caseid uniqueidentifier primary key default newid(),
	designer_id uniqueidentifier foreign key references t_designer(id),
	casename varchar(100) not null,/**��������**/
	plot_name varchar(100) not null,/**С������**/
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
/**װ�޹�˾���t_company_activity**/

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

/**�����̻��t_supply_activity***/

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

/**���ı�t_product***/
create table t_product
(
	id uniqueidentifier primary key default newid(),
	supply_id uniqueidentifier foreign key references t_supply(id),
	name varchar(100) not null,
	price float not null,
	sale_price float not null,/*���ۺ�**/
	image varchar(500),
	des varchar(500) not null,
	created_time datetime,
	status char(1) default('Y') check (status='N' or status = 'Y'),
);

/**�û���**/

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

/**װ�޹�˾�ղر�t_company_col**/
create table t_company_col
(
	id uniqueidentifier primary key default newid(),
	customer_id uniqueidentifier foreign key references t_customer(id),
	company_id uniqueidentifier foreign key references t_company(id), 
	created_time datetime,
);
/**�������ղر�t_supply_col**/

create table t_supply_col
(
	id uniqueidentifier primary key default newid(),
	customer_id uniqueidentifier foreign key references t_customer(id),
	supply_id uniqueidentifier foreign key references t_supply(id), 
	created_time datetime,
);

/**���ʦ�ղر�t_designer_col**/
create table t_designer_col
(
	id uniqueidentifier primary key default newid(),
	customer_id uniqueidentifier foreign key references t_customer(id),
	designer_id uniqueidentifier foreign key references t_designer(id), 
	created_time datetime,
);
/**�����ղر�t_product_col**/
create table t_product_col
(
	id uniqueidentifier primary key default newid(),
	customer_id uniqueidentifier foreign key references t_customer(id),
	product_id uniqueidentifier foreign key references t_product(id), 
	created_time datetime,
);

/**װ�޹�˾�����ղر�t_company_case_col**/
create table t_company_case_col
(
	id uniqueidentifier primary key default newid(),
	customer_id uniqueidentifier foreign key references t_customer(id),
	company_id uniqueidentifier foreign key references t_company_case(id), 
	created_time datetime,
);

/**���ʦ�����ղر�t_designer_case_col**/
/**?????????????****/

create table t_designer_case_col
(
	id uniqueidentifier primary key default newid(),
	customer_id uniqueidentifier foreign key references t_customer(id),
	company_id uniqueidentifier foreign key references t_designer_case(caseid), 
	created_time datetime
);
/**���ʦ��ԤԼ��t_appointment**/
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

/** ������ԤԼ��*/
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

/** װ�޹�˾ԤԼ��*/
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

/**���ʦ�û���ѯ��t_appointment**/
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
/**װ�޹�˾�û���ѯ��t_appointment**/
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
/**�������û���ѯ��t_appointment**/
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

/**����Ա��t_admin**/
create table t_admin
(
	id uniqueidentifier primary key default newid(),
	email varchar(100) unique,
	password varchar(200),
	name varchar(100) not null,
	phone varchar(11) not null,
	role varchar(10),  /**��ɫ**/
	created_time datetime,
	last_login_time datetime,
	status char(1) default('Y') check (status='N' or status = 'Y'),
);