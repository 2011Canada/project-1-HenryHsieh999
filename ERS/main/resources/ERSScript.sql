drop schema if exists ers cascade;
create schema ers;
set schema 'ers';

create table ers_user_roles(
	ers_user_role_id serial primary key,
	user_role text
);



create table ers_users(
	ers_users_id serial primary key,
	ers_username text,
	ers_password text,
	user_first_name text,
	user_last_name text,
	user_email text,
	user_roles_fk int4 unique not null references ers_user_roles(ers_user_role_id)
);

--drop table ers_reimbursement;
create table ers_reimbursement(
	reimb_id serial primary key,
	reimb_amount numeric(10,2) not null,
	reimb_submitted timestamp,
	reimb_resolved timestamp,
	reimb_status text,
	reimb_type text,
	--need to add fk below here
	ers_reimb_author int4 not null references ers_user_roles(ers_user_role_id)
);

--insert employee data
insert into ers_user_roles (user_role) values ('employee');
insert into ers_users (ers_username, ers_password,user_first_name,user_last_name,user_email, user_roles_fk) values ('mtv', 'cat5', 'Tavi', 'Melody', 'mtv@gmail.com', 1);
insert into ers_user_roles (user_role) values ('employee');
insert into ers_users (ers_username, ers_password,user_first_name,user_last_name,user_email, user_roles_fk) values ('laser', 'beam3', 'Cloud', 'Muramana', 'cm@gmail.com', 2);
insert into ers_user_roles (user_role) values ('employee');
insert into ers_users (ers_username, ers_password,user_first_name,user_last_name,user_email, user_roles_fk) values ('ender', 'truelight9', 'Storm', 'Shadow', 'ss@gmail.com', 3);
--insert manager data
insert into ers_user_roles (user_role) values ('manager');
insert into ers_users (ers_username, ers_password,user_first_name,user_last_name,user_email, user_roles_fk) values ('super', 'pword', 'Super', 'User', 'su@gmail.com', 4);
--insert reimbursement data
--insert into ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, )

--enhanced select statements for db queries
select * from ers_user_roles eur left join ers_users eu on eur.ers_user_role_id = eu.user_roles_fk;
select * from ers_users eu left join ers_reimbursement er on eu.ers_users_id = er.ers_reimb_author;
select * from ers_reimbursement where ers_reimb_author = 1;
--login query
select * from ers_users where ers_username = 'mtv' and ers_password = 'cat5';
select * from ers_user_roles eur left join ers_users eu on eur.ers_user_role_id = eu.user_roles_fk where ers_username = 'mtv' and ers_password = 'cat5';
select * from ers_users where ers_username = 'ender';
--find User ID by ers_user_role_id
select * from ers_user_roles eur left join ers_users eu on eur.ers_user_role_id = eu.user_roles_fk where ers_user_role_id = 2;
--find User ID by ers_username
select * from ers_user_roles eur left join ers_users eu on eur.ers_user_role_id = eu.user_roles_fk where ers_username = 'ender'; 
--reimbursement query
insert into ers_reimbursement (reimb_amount, reimb_submitted, reimb_status, reimb_type, ers_reimb_author) values (500.15, CURRENT_TIMESTAMP, 'pending', 'lodging', 1);
insert into ers_reimbursement (reimb_amount, reimb_submitted, reimb_status, reimb_type, ers_reimb_author) values (1241.15, CURRENT_TIMESTAMP, 'pending', 'lodging', 1);
--select * from ers_reimbursement er 

--simple select statements to check tables 
select * from ers_reimbursement;
select * from ers_user_roles;
select * from ers_users;