insert into clients (client_name, email) VALUES ( 'name1',  'name1@email.com' );
insert into clients (client_name, email) VALUES ( 'name2',  'name2@email.com' );

insert into currency (code) VALUES ('USD');
insert into currency (code) VALUES ('EUR');

insert into accounts (client_id, currency_id, balance) VALUES ( 1,  1, 10.00 );