
use semo;
show databases;
CREATE TABLE custmer (
    cuid VARCHAR(6),
    cname VARCHAR(32),
    phonenumber VARCHAR(10),
    socialacc VARCHAR(100),
    address varchar(100),
    PRIMARY KEY (cuid)
);
drop table Product;
CREATE TABLE Product(
		Pid int auto_increment not null,
        name varchar(32),
        image blob,
        primary key (Pid)
);
ALTER TABLE Product AUTO_INCREMENT=1000;

drop table sticker;
select * from sticker;
create table sticker(
		Pid int,
		size char,
		price double,
        primary key (Pid),
		foreign key (Pid) references Product(Pid)
);
Insert into Product ( Name, image) values('Prog',LOAD_FILE('C:\\Users\\yazid\\Desktop\\353974-PBME5S-833.png'));

drop table Mug;
create table Mug(
		Pid int,
		isMageic boolean,
		price double,
        primary key (Pid),
		foreign key (Pid) references Product(Pid)
);
select * from Mug;

drop table Pin;
create table Pin(
		Pid int,
		size char,
        price double,
        primary key (Pid),
		foreign key (Pid) references Product(Pid)
);
drop table notebook;
CREATE TABLE NoteBook (
    Pid INT,
    numberofpage int,
    price double,
    primary key (Pid),
    FOREIGN KEY (Pid)
        REFERENCES Product (Pid)
);
drop table  orderline;
create table orderline(
		ol int auto_increment,
        pid int,
        quantity int,
         price double,
        primary key (ol,pid),
        foreign key (pid) references product(pid));
select * from orderline;
create table orderC(
		cuid varchar(6),
        ol int,
        totleprice double,
        primary key (cuid,ol),
        foreign key (cuid) references custmer(cuid),
        foreign key (ol) references orderline(ol)
);

select s.pid,p.name,s.size,s.price,p.image from product p , sticker s  where s.pid=p.pid And s.pid>=1000 order by s.pid , s.size desc;
select s.price from product p , sticker s  where s.pid=p.pid And s.pid >=1000 And p.name ='K'order by s.pid , s.size desc;

select pn.pid,p.name,pn.size,pn.price,p.image from product p , pin pn   where pn.pid=p.pid And pn.pid >=1000 order by pn.pid , pn.size desc;



select * from product order by pid;
select * from sticker order by pid;
select * from mug order by pid;
select * from phonecase order by pid;
select * from notebook order by pid;

	
CREATE TABLE admin (
    username VARCHAR(15),
    password VARCHAR(13),
    PRIMARY KEY (username)
);


-- /// insert values in Admin Table ///
insert into admin (username,password) values ('admin','root');
insert into admin (username,password) values ('root','root1234');
update admin a set a.password='root1234' where a.username='root';
insert into admin (username,password) values ('yazid','admin');
insert into admin (username,password) values ('ansam','root1234');
-- //////////
show tables;
select * from admin ;
select * from custmer;
select * from product;


select DISTINCT name from product p , sticker s where s.pid=p.pid AND p.pid>=1000;
select DISTINCT p.pid from product p , sticker s where p.pid=s.pid AND p.name='cat';
-- insert Defulte valuse for Stickers
insert into product (pid,name) value (1,'StickerSmall');
insert into sticker (pid,size,price) values(1,'S',1.0);
insert into product (pid,name) value (2,'StickerMeduim');
insert into sticker (pid,size,price) values(2,'M',2.0);
insert into product (pid,name) value (3,'StickerLarge');
insert into sticker (pid,size,price) values(3,'L',3.0);
--  done
-- insert Defulte valuse for Pin
insert into product (pid,name) value (4,'PinSmall');
insert into pin (pid,size,price) values(4,'S',6.0);
insert into product (pid,name) value (5,'PinMeduim');
insert into pin (pid,size,price) values(5,'M',8.0);
insert into product (pid,name) value (6,'PinLarge');
insert into pin (pid,size,price) values(6,'L',10.0);
--  done
insert into product (pid,name) value (7,'MugMagic');
insert into Mug (pid,isMageic,price) values(7,true,25.0);
insert into product (pid,name) value (8,'MugNormal');
insert into Mug (pid,isMageic,price) values(8,false,15.0);
-- done
insert into product (pid,name) value (9,'notebook40');
insert into notebook (pid,numberofpage,price)values(9,40,15);
insert into product (pid,name) value (10,'notebook80');
insert into notebook (pid,numberofpage,price)values(10,80,20);


-- ////////////
select * from custmer c where c.cname like "%j%" or c.address like "%j%" or c.socialacc like "%j%";
select cuid,cname,phonenumber,socialacc,address from custmer order by cuid;
SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = "semo" AND TABLE_NAME = "orderline";

SELECT COUNT(DISTINCT c.cname) FROM custmer c;
SELECT COUNT(pid) FROM product where pid >= 1000;
SELECT COUNT( p.name) FROM product p,sticker s where s.pid=p.pid And s.pid >=1000;
