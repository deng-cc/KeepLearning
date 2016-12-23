create table TUser  (
   uname              varchar2(20)                    not null,
   pwd                varchar2(20),
   account            number(6,2),
   role               char(1),
   constraint PK_TUSER primary key (uname)
);

create table TBook  (
   isbn               varchar2(20)                    not null,
   bname              varchar2(50),
   press              varchar2(50),
   price              number(5,2),
   pdate              date,
   pic                blob,
   bkcount            number(7),
   constraint PK_TBOOK primary key (isbn)
);


create table TBuyRecord  (
   buyid              number(9)                       not null,
   uname              varchar2(20),
   buytime            date,
   allmoney           number(6,2),
   constraint PK_TBUYRECORD primary key (buyid)
);

alter table TBuyRecord
   add constraint FK_TBUYRECO_REFERENCE_TUSER foreign key (uname)
      references TUser (uname);


create table TBuyDetail  (
   autoid             number(9)                       not null,
   isbn               varchar2(20),
   buyid              number(9),
   bcount             number(3),
   constraint PK_TBUYDETAIL primary key (autoid)
);

alter table TBuyDetail
   add constraint FK_TBUYDETA_REFERENCE_TBOOK foreign key (isbn)
      references TBook (isbn);

alter table TBuyDetail
   add constraint FK_TBUYDETA_REFERENCE_TBUYRECO foreign key (buyid)
      references TBuyRecord (buyid);



insert into tuser(uname,pwd,account,role) values('admin','123',1000,1);
insert into tuser(uname,pwd,account,role) values('tom','abc',1000,0);

insert into  tbook values('s001','飘','外文出版社',32.8,to_date('2004-11-27', 'yyyy-mm-dd'),null,100);
insert into  tbook values('s002','设计模式','清华出版社',36.5,to_date('2003-06-20', 'yyyy-mm-dd'),null,100);
insert into  tbook values('s003','战争与和平','机械出版社',45,to_date('2013-07-10', 'yyyy-mm-dd'),null,100);






