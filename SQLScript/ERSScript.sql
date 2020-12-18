drop schema if exists ers cascade;
create schema ers;
set schema 'ers';

create table ers_user_roles(
	ers_user_role_id serial primary key,
	user_role text
);
create table ers_reimbursement_status(
	reimb_status_id serial primary key,
	reimb_status text
);

create table ers_reimbursement_type(
	reimb_type_id serial primary key,
	reimb_type text
);
create table ers_users(
	ers_users_id serial primary key,
	ers_username text,
	ers_password text,
	user_first_name text,
	user_last_name text,
	user_email text,
	user_role_id int4,
	user_roles_fk int4 unique not null references ers_user_roles(ers_user_role_id)
);
create table ers_reimbursement(
	reimb_id serial primary key,
	reimb_amount int4 not null,
	reimb_submitted timestamp not null,
	reimb_resolved timestamp not null,
	reimb_description text not null,
	reimb_receipt bytea not null,
	reimb_author int4 not null,
	reimb_resolver int4 not null,
	reimb_status_id int4 not null,
	reimb_type_id int4 not null,
	--need to add fk below here
	ers_reimbursement_status_fk int4 unique not null references ers_reimbursement_status(reimb_status_id),
	ers_reimbursement_type_fk int4 unique not null references ers_reimbursement_type(reimb_type_id)
);

select * from ers_reimbursement;
select * from ers_reimbursement_status;
select * from ers_reimbursement_type;
select * from ers_user_roles;
select * from ers_users;