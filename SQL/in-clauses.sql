select avg(amount) from payments;

select * from payments
where amount > (select avg(amount) from payments)
order by amount desc;


-- the following 2 statements are the same
select * 
from employees e 
where e.office_id IN ( 1,2,3);

select * 
from employees e
where e.office_id = 1 or e.office_id = 2 or e.office_id = 3;

-- the in statement can be used with a subquery
select id from offices where city like '%o%';
select * from employees where office_id IN (1,2,5,7);
select * from employees where office_id IN (select id from offices where city like '%o%');


-- show the top 10 most popular products
select * 
from products p, 
	( select p.id, sum(od.quantity_ordered) as total_ordered
	from products p, orderdetails od
	where od.product_id = p.id
	group by p.id
	order by total_ordered desc
	limit 10 ) popular
where p.id = popular.id;


-- she me any orders that have happened after the lasted payment for each customer
select * from payments;




select * from customers;
update customers set contact_lastname = 'Another last name' where id = 103;
commit;
rollback;


select * from employees;

-- I want to see all of the offices that have someone with the first name L
select * from employees where firstname like 'L%';
select * from offices where id in ( select office_id from employees where firstname like 'L%' );

-- 1) Think of mroe examples for IN
-- 2) Left join examples

-- know that you need to use is when checking for null
-- this will work
select * from offices where state is null;
-- this will not produce any results
select * from offices where state = null;


-- 
SELECT *
    FROM products p, orderdetails od
WHERE p.id = od.product_id and od.product_id is null;

select * From productlines;
select * from orders;

select e.id, o.id
from employees e, offices o
where e.office_id = o.id;


-- new comment 


-- 1) I want to see a list of customer names and the order number for any orders that have made an order that has an order_date greater than the maximum payment date - 
-- will require a sub query to get the max(payment_date) from the payments table which can be used in the where clause to find orders with an order_date after the max(payment_date)
select *
from customers;
select max(payment_date)
from payments;
select *
from orders;
select c.contact_firstname, o.id,o.order_date
from customers c, orders o
where c.id = o.customer_id
and o.order_date > (select max(payment_date) from payments );

select c.customer_name,o.id
 from customers c,orders o
 where c.id=o.customer_id 
 and o.order_date>(select max(p.payment_date) from payments p where p.customer_id=o.customer_id);

-- 2) I want to see all the employees that are working in an office where the state is not null;
select *
from offices;
select *
from employees;
SELECT e.id, e.firstname, o.state
FROM employees e, offices o
WHERE e.office_id = o.id
  AND o.state IS not NULL;


-- 3) I want to all of the products that are not ground vehicles.   Hint -  where not in a select statement from product line
select * from products where productline_id in (select id from productlines where product_line in ('planes', 'Ships') );
 
 select p.*, pl.product_line 
from products p, productlines pl
where p.productline_id = pl.id  
and pl.id in (3,4,5) -- '3', 'Planes' '4', 'Ships' '5', 'Trains'
order by product_line, p.product_name;


-- 3a) I want to see a unique list of the order status
select distinct status from orders;


-- 4) use an IN statement with a sub query - I want to see the list of products that have been ordered but not yet shipped.
--    - the orders table has a status column that contins the order status 

select * from orders where status in ('In process', 'On hold'); 

-- 5) The product name, and quantity ordered for all orders that are on holed or in process
select p.product_name, od.quantity_ordered
from  products p , orders o , orderdetails od
where  p.id = od.product_id 
and o.id=od.order_id 
and o.status in ('in process', 'on hold');

-- 6) I want to see a list of all employess that do not have a customer!!!!  use a where not in ( select employee_id from customer where .... )
select * from employees where id not in ( select sales_rep_employee_id from customers);




select empl.* 
from employees empl  
where empl.id not in (select distinct c2.sales_rep_employee_id from customers c2 where c2.sales_rep_employee_id=empl.id);


-- 6a) I want to see the employee name and each of their customer names.   IF the employee does not have any customers then show null for the customer name ... this is a left join
--    order this by the employee first name asc    you will see the employee name repeated many times for each customer they have .. but if the employee has no customers it should print NULL in
--    the second column.

select e.id,e.firstname,e.lastname,c.customer_name
 from employees e 
 LEFT JOIN customers c ON c.sales_rep_employee_id = e.id
  order by e.id;
  
  
  
  select e.id,e.firstname,e.lastname,c.customer_name
  from employees e, customers c 
  where c.sales_rep_employee_id = e.id
  order by e.id;


