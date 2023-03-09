create table  Operator
(
Operator_Id char(10) primary key,
Operator_Name varchar(20),
Password char(10),
User_Phonenumber varchar(20),

)

drop table operator

Insert Into operator values('B000000016','nishu','9140971886','nishu@1234')


select*from operator



create table Product
(
Product_id int primary key,
Product_name varchar(50) not null,
Price int not null,
OpeningStock int
)


Delete From Orderss where
Order_Id=2;

Insert Into product values(05,'Washing Machine',8000,20)


select*from product



create table Customers
(
CustomerId int primary key,
CustomerName varchar(50) not null,
HomeAddress varchar(50) not null,
City varchar(30) not null,
Mobileno char(10)
)

drop table customers
Insert Into customers values(05,'Buttler','Melbourne','Australia','3399076589')


select*from customers


create table Orderitem
(
Item_Id int primary key,
Product_Id int references Product(Product_Id),
Price int not null,
Order_Date date not null
)

drop table orderitem

alter table orderitem
add constraint unq_order_date unique 
(order_date)



Insert Into orderitem values(5,05,600,'2021-09-05')



update orderitem
set item_id=18
WHERE product_id=5;



select*from orderitem




create table Orderss
(
Order_Id int primary key,
CustomerId int references Customers(CustomerId),
PaymentMode varchar(20)  check (paymentmode in ('Cash','Credit Card','Debit Card')),
Total_Amount int,
Balance_Amount int,
Order_Date date  references Orderitem(order_date),
Order_Deliveydate datetime  not null,
)

drop table orderss


Insert Into orderss values(10,5,'Debit Card',600,'2021-09-05')



Alter table orderss
drop column Total_Amount ;

Alter table orderss
add  Total_Amount int;



Alter table orderss
add  order_date date  references orderitem(order_date);


update orderss
set order_Deliverydate='2021-09-20'
WHERE order_id=10;


   
select*from orderss


 
create table Orderdetailss
(
Order_Id int references Orderss(Order_Id),
Product_Id int  references Product(Product_Id),
QtySold numeric(10,2) not null check(QtySold>0),
SalesPrice smallmoney not null check (SalesPrice>0)
)

drop table orderdetailss


insert into Orderdetailss
 values(10,5,45,400)


select*from orderdetailss



---views---


select c.customername, ora.order_id, ora.order_date, ora.order_Deliverydate,ora.total_amount,
Datediff(dd,ora.order_Deliverydate, Getdate())- Datediff(dd,ora.order_date, Getdate()) as [TurnAroundTime_To_DeliveryOrder] from
orderss ora join customers c
on ora.customerid=c.customerid



---trigger---


create trigger trg_PriceOnInsert
on orderdetailss
for insert
as 
begin
   declare @SalesPrice smallmoney
   select @SalesPrice = salesprice from inserted --10000

   declare @Product_Id int
   select @Product_Id = product_id from inserted --1

   declare @Price int
   select @Price = Price from Product where Product_Id = @Product_Id --select stdprice from product where productid = 1
   --18000

   declare @difference money

   set @difference = (@SalesPrice - @Price) / @Price -- (10000 - 18000) / 18000 = -.44
   
   if abs(@difference) > 10
   begin
      print 'The discount or surplus can not be more than 20 percent of standard price' 
	  rollback
   end
end

