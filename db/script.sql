create table accounts(
id serial primary key,
balance DOUBLE PRECISION,
status text,
is_active boolean
);

insert  into accounts (balance,status,is_active)
values(99.99, 'opened', true );

update accounts set balance = 50.50;

delete from accounts;