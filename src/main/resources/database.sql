CREATE DATABASE ERS_DB;

create table employees (
	eID        serial primary key,
	firstName  varchar(25),
	lastName   varchar(30),
	email      varchar(50) unique,
	password   varchar(50),
	role       integer null
);

create table reimbursements (
	rID           serial primary key,
	empReimJoinID integer references employees(eID),
	amount        numeric(6,2) null,
	submitted     DATE,
	approved      DATE,
	description   varchar(200),
	status        integer null,
	type          integer null,
	message       varchar(200) null
);

insert into reimbursements values (default, 1, 1600, "2021-04-23", "2021-04-29", "I would like reimbursement for my big lunch.", 1, 2, null);
insert into reimbursements values (default, 1, 142.43, "2021-02-16", "2021-09-10", "I would like reimbursement for my big dinner.", 1, 2, null);
insert into reimbursements values (default, 1, 12.89, "2021-06-15", "2021-07-18", "I would like reimbursement for my big snack.", 1, 2, null);
insert into reimbursements values (default, 2, 300, "2021-03-21", "2021-03-29", "I would like reimbursement for my car.", 1, 3, null);
insert into reimbursements values (default, 4, 23.66, "2021-08-19", "2021-09-19", "I would like reimbursement for my nap.", 1, 4, null);
insert into reimbursements values (default, 4, 44.35, "2021-01-12", "2021-01-15", "I would like reimbursement for my toaster.", 1, 4, null);
insert into reimbursements values (default, 4, 9.21, "2021-05-10", "2021-05-11", "I would like reimbursement for my shoes.", 1, 3, null);

insert into employees (firstName, lastName, email, password, role) values ('George', 'Washington', 'george.washington@pres.gov', 'gw123456', 0);
insert into employees (firstName, lastName, email, password, role) values ('Thom', 'Washingtoney', 'Thom.Washingtoneyy@pres.gov', 'tw123456', 0);
insert into employees (firstName, lastName, email, password, role) values ('BossFeldman', 'Washingtone', 'BossFeldman.Washingtonee@pres.gov', 'bfw123456', 1);
insert into employees (firstName, lastName, email, password, role) values ('Jerry', 'Fudd', 'Jerry.Fudd@pres.gov', 'jf123456', 0);
insert into employees (firstName, lastName, email, password, role) values ('BossBossy', 'Washingtonbossy', 'BossBossy.Washingtonbossy@pres.gov', 'bbbww123456', 1);
