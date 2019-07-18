insert into clients (client_name, email) VALUES ( 'name1',  'name1@email.com' );
insert into clients (client_name, email) VALUES ( 'name2',  'name2@email.com' );

insert into currency (code) VALUES ('USD');
insert into currency (code) VALUES ('EUR');

insert into accounts (client_id, currency_id, balance) VALUES ( 1,  1, 10.00 );
insert into accounts (client_id, currency_id, balance) VALUES ( 2,  1, 10.00 );

insert into transfers (account_from_id, account_to_id, amount, transfer_date, is_finished) VALUES (1, 2, 10, CURRENT_DATE, 1);