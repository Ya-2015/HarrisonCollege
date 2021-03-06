--------------------------------------------------------
--  File created - Tuesday-November-17-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table HCLASS
--------------------------------------------------------

  CREATE TABLE "TESTUSERDB"."HCLASS" 
   (	"CLASSNUM" NUMBER, 
	"CRN" VARCHAR2(20 BYTE), 
	"COURSECODE" NUMBER, 
	"INSTRUCTORNUM" NUMBER, 
	"ROOMID" NUMBER, 
	"SCHEDULECODE" NUMBER, 
	"SEMESTERCODE" NUMBER, 
	"ENROLLMENTHOLD" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HCLASSROOM
--------------------------------------------------------

  CREATE TABLE "TESTUSERDB"."HCLASSROOM" 
   (	"ROOMID" NUMBER, 
	"BLDGNAME" VARCHAR2(50 BYTE), 
	"ROOMNUMBER" VARCHAR2(20 BYTE), 
	"MAXCAPACITY" NUMBER, 
	"STATUSCODE" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HCOURSE
--------------------------------------------------------

  CREATE TABLE "TESTUSERDB"."HCOURSE" 
   (	"COURSECODE" NUMBER, 
	"SUBJECTCODE" VARCHAR2(20 BYTE), 
	"COURSENAME" VARCHAR2(50 BYTE), 
	"DESCRIPTION" VARCHAR2(200 BYTE), 
	"CREDITS" NUMBER, 
	"DEPARTCODE" NUMBER, 
	"STATUSCODE" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HDEPARTMENT
--------------------------------------------------------

  CREATE TABLE "TESTUSERDB"."HDEPARTMENT" 
   (	"CODE" NUMBER, 
	"DEPARTNAME" VARCHAR2(50 BYTE), 
	"STATUSCODE" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HENROLLMENT
--------------------------------------------------------

  CREATE TABLE "TESTUSERDB"."HENROLLMENT" 
   (	"ENROLLMENTNUM" NUMBER, 
	"CLASSNUM" NUMBER, 
	"STUDENTNUM" NUMBER, 
	"GRADE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HINSTRUCTOR
--------------------------------------------------------

  CREATE TABLE "TESTUSERDB"."HINSTRUCTOR" 
   (	"INSTRUCTORNUM" NUMBER, 
	"INSTRUCTORNAME" VARCHAR2(50 BYTE), 
	"DEPARTCODE" NUMBER, 
	"OFFICELOCATION" VARCHAR2(50 BYTE), 
	"NETID" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HMAJOR
--------------------------------------------------------

  CREATE TABLE "TESTUSERDB"."HMAJOR" 
   (	"MAJORCODE" NUMBER, 
	"MAJORNAME" VARCHAR2(50 BYTE), 
	"DEPARTCODE" NUMBER, 
	"STATUSCODE" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HSCHEDULE
--------------------------------------------------------

  CREATE TABLE "TESTUSERDB"."HSCHEDULE" 
   (	"SCHEDULECODE" NUMBER, 
	"DOW1" VARCHAR2(20 BYTE), 
	"DOW2" VARCHAR2(20 BYTE), 
	"HOUR12" NUMBER, 
	"MINUTES60" NUMBER, 
	"AMPM" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HSEMESTER
--------------------------------------------------------

  CREATE TABLE "TESTUSERDB"."HSEMESTER" 
   (	"SEMESTERCODE" NUMBER, 
	"HYEAR" NUMBER, 
	"SEMESTER" VARCHAR2(10 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HSTUDENT
--------------------------------------------------------

  CREATE TABLE "TESTUSERDB"."HSTUDENT" 
   (	"STUDENTNUM" NUMBER, 
	"STUDENTNAME" VARCHAR2(50 BYTE), 
	"MAJORCODE" NUMBER, 
	"YEAROFENTRY" NUMBER, 
	"NETID" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HUSER
--------------------------------------------------------

  CREATE TABLE "TESTUSERDB"."HUSER" 
   (	"NETID" VARCHAR2(50 BYTE), 
	"USERPWD" VARCHAR2(50 BYTE), 
	"USERTYPE" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into TESTUSERDB.HCLASS
SET DEFINE OFF;
Insert into TESTUSERDB.HCLASS (CLASSNUM,CRN,COURSECODE,INSTRUCTORNUM,ROOMID,SCHEDULECODE,SEMESTERCODE,ENROLLMENTHOLD) values (1,'10101',1,1,1,1,1,0);
Insert into TESTUSERDB.HCLASS (CLASSNUM,CRN,COURSECODE,INSTRUCTORNUM,ROOMID,SCHEDULECODE,SEMESTERCODE,ENROLLMENTHOLD) values (2,'10102',1,1,2,2,1,10);
Insert into TESTUSERDB.HCLASS (CLASSNUM,CRN,COURSECODE,INSTRUCTORNUM,ROOMID,SCHEDULECODE,SEMESTERCODE,ENROLLMENTHOLD) values (3,'10101',1,2,3,1,2,0);
Insert into TESTUSERDB.HCLASS (CLASSNUM,CRN,COURSECODE,INSTRUCTORNUM,ROOMID,SCHEDULECODE,SEMESTERCODE,ENROLLMENTHOLD) values (4,'10403',4,3,3,3,1,0);
REM INSERTING into TESTUSERDB.HCLASSROOM
SET DEFINE OFF;
Insert into TESTUSERDB.HCLASSROOM (ROOMID,BLDGNAME,ROOMNUMBER,MAXCAPACITY,STATUSCODE) values (4,null,null,null,null);
Insert into TESTUSERDB.HCLASSROOM (ROOMID,BLDGNAME,ROOMNUMBER,MAXCAPACITY,STATUSCODE) values (1,'MC','HU331',20,1);
Insert into TESTUSERDB.HCLASSROOM (ROOMID,BLDGNAME,ROOMNUMBER,MAXCAPACITY,STATUSCODE) values (2,'MC','420',10,1);
Insert into TESTUSERDB.HCLASSROOM (ROOMID,BLDGNAME,ROOMNUMBER,MAXCAPACITY,STATUSCODE) values (3,'BU','113',45,1);
REM INSERTING into TESTUSERDB.HCOURSE
SET DEFINE OFF;
Insert into TESTUSERDB.HCOURSE (COURSECODE,SUBJECTCODE,COURSENAME,DESCRIPTION,CREDITS,DEPARTCODE,STATUSCODE) values (1,'prg 101','java basic',null,4,1,1);
Insert into TESTUSERDB.HCOURSE (COURSECODE,SUBJECTCODE,COURSENAME,DESCRIPTION,CREDITS,DEPARTCODE,STATUSCODE) values (2,'prg 101','java advanced',null,3,1,1);
Insert into TESTUSERDB.HCOURSE (COURSECODE,SUBJECTCODE,COURSENAME,DESCRIPTION,CREDITS,DEPARTCODE,STATUSCODE) values (3,'mth','advanced math',null,4,4,1);
Insert into TESTUSERDB.HCOURSE (COURSECODE,SUBJECTCODE,COURSENAME,DESCRIPTION,CREDITS,DEPARTCODE,STATUSCODE) values (4,'ds','big data',null,4,3,1);
Insert into TESTUSERDB.HCOURSE (COURSECODE,SUBJECTCODE,COURSENAME,DESCRIPTION,CREDITS,DEPARTCODE,STATUSCODE) values (5,'engi','eletronic circuit design',null,3,2,1);
REM INSERTING into TESTUSERDB.HDEPARTMENT
SET DEFINE OFF;
Insert into TESTUSERDB.HDEPARTMENT (CODE,DEPARTNAME,STATUSCODE) values (9,'art',1);
Insert into TESTUSERDB.HDEPARTMENT (CODE,DEPARTNAME,STATUSCODE) values (1,'computer science',1);
Insert into TESTUSERDB.HDEPARTMENT (CODE,DEPARTNAME,STATUSCODE) values (2,'engineering',1);
Insert into TESTUSERDB.HDEPARTMENT (CODE,DEPARTNAME,STATUSCODE) values (3,'data science',1);
Insert into TESTUSERDB.HDEPARTMENT (CODE,DEPARTNAME,STATUSCODE) values (4,'math',1);
REM INSERTING into TESTUSERDB.HENROLLMENT
SET DEFINE OFF;
Insert into TESTUSERDB.HENROLLMENT (ENROLLMENTNUM,CLASSNUM,STUDENTNUM,GRADE) values (5,1,1,null);
Insert into TESTUSERDB.HENROLLMENT (ENROLLMENTNUM,CLASSNUM,STUDENTNUM,GRADE) values (6,4,1,null);
Insert into TESTUSERDB.HENROLLMENT (ENROLLMENTNUM,CLASSNUM,STUDENTNUM,GRADE) values (7,1,2,null);
Insert into TESTUSERDB.HENROLLMENT (ENROLLMENTNUM,CLASSNUM,STUDENTNUM,GRADE) values (8,1,3,null);
REM INSERTING into TESTUSERDB.HINSTRUCTOR
SET DEFINE OFF;
Insert into TESTUSERDB.HINSTRUCTOR (INSTRUCTORNUM,INSTRUCTORNAME,DEPARTCODE,OFFICELOCATION,NETID) values (1,'dave wolf',1,'HU332','davewolf001');
Insert into TESTUSERDB.HINSTRUCTOR (INSTRUCTORNUM,INSTRUCTORNAME,DEPARTCODE,OFFICELOCATION,NETID) values (2,'nelson lee',2,'HB331','nelsonlee002');
Insert into TESTUSERDB.HINSTRUCTOR (INSTRUCTORNUM,INSTRUCTORNAME,DEPARTCODE,OFFICELOCATION,NETID) values (3,'alton henley',3,'HN333','altonhenley003');
REM INSERTING into TESTUSERDB.HMAJOR
SET DEFINE OFF;
Insert into TESTUSERDB.HMAJOR (MAJORCODE,MAJORNAME,DEPARTCODE,STATUSCODE) values (1,'Computer Science',1,1);
Insert into TESTUSERDB.HMAJOR (MAJORCODE,MAJORNAME,DEPARTCODE,STATUSCODE) values (2,'Electronic Engineering',2,1);
Insert into TESTUSERDB.HMAJOR (MAJORCODE,MAJORNAME,DEPARTCODE,STATUSCODE) values (3,'Data Science',3,1);
Insert into TESTUSERDB.HMAJOR (MAJORCODE,MAJORNAME,DEPARTCODE,STATUSCODE) values (4,'Math',4,1);
REM INSERTING into TESTUSERDB.HSCHEDULE
SET DEFINE OFF;
Insert into TESTUSERDB.HSCHEDULE (SCHEDULECODE,DOW1,DOW2,HOUR12,MINUTES60,AMPM) values (1,'mon','wed',8,0,'am');
Insert into TESTUSERDB.HSCHEDULE (SCHEDULECODE,DOW1,DOW2,HOUR12,MINUTES60,AMPM) values (2,'tue',null,2,30,'pm');
Insert into TESTUSERDB.HSCHEDULE (SCHEDULECODE,DOW1,DOW2,HOUR12,MINUTES60,AMPM) values (3,'thu',null,10,30,'am');
REM INSERTING into TESTUSERDB.HSEMESTER
SET DEFINE OFF;
Insert into TESTUSERDB.HSEMESTER (SEMESTERCODE,HYEAR,SEMESTER) values (1,2015,'fall');
Insert into TESTUSERDB.HSEMESTER (SEMESTERCODE,HYEAR,SEMESTER) values (2,2015,'spring');
Insert into TESTUSERDB.HSEMESTER (SEMESTERCODE,HYEAR,SEMESTER) values (3,2014,'fall');
Insert into TESTUSERDB.HSEMESTER (SEMESTERCODE,HYEAR,SEMESTER) values (4,2014,'spring');
REM INSERTING into TESTUSERDB.HSTUDENT
SET DEFINE OFF;
Insert into TESTUSERDB.HSTUDENT (STUDENTNUM,STUDENTNAME,MAJORCODE,YEAROFENTRY,NETID) values (1,'ya Liu',1,2015,'yaliu001');
Insert into TESTUSERDB.HSTUDENT (STUDENTNUM,STUDENTNAME,MAJORCODE,YEAROFENTRY,NETID) values (2,'zheyi ma',2,2015,'zheyima002');
Insert into TESTUSERDB.HSTUDENT (STUDENTNUM,STUDENTNAME,MAJORCODE,YEAROFENTRY,NETID) values (3,'Kunal Chugh',3,2014,'francislin003');
REM INSERTING into TESTUSERDB.HUSER
SET DEFINE OFF;
Insert into TESTUSERDB.HUSER (NETID,USERPWD,USERTYPE) values ('yaliu001','111',1);
Insert into TESTUSERDB.HUSER (NETID,USERPWD,USERTYPE) values ('davewolf001','111',2);
Insert into TESTUSERDB.HUSER (NETID,USERPWD,USERTYPE) values ('admin001','111',4);
Insert into TESTUSERDB.HUSER (NETID,USERPWD,USERTYPE) values ('advisor001','111',3);
--------------------------------------------------------
--  DDL for Index HCLASS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTUSERDB"."HCLASS_PK" ON "TESTUSERDB"."HCLASS" ("CLASSNUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index HCLASSROOM_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTUSERDB"."HCLASSROOM_PK" ON "TESTUSERDB"."HCLASSROOM" ("ROOMID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index HCOURSE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTUSERDB"."HCOURSE_PK" ON "TESTUSERDB"."HCOURSE" ("COURSECODE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index HDEPARTMENT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTUSERDB"."HDEPARTMENT_PK" ON "TESTUSERDB"."HDEPARTMENT" ("CODE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index HENROLLMENT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTUSERDB"."HENROLLMENT_PK" ON "TESTUSERDB"."HENROLLMENT" ("ENROLLMENTNUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index HINSTRUCTOR_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTUSERDB"."HINSTRUCTOR_PK" ON "TESTUSERDB"."HINSTRUCTOR" ("INSTRUCTORNUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index HMAJOR_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTUSERDB"."HMAJOR_PK" ON "TESTUSERDB"."HMAJOR" ("MAJORCODE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index HSCHEDULE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTUSERDB"."HSCHEDULE_PK" ON "TESTUSERDB"."HSCHEDULE" ("SCHEDULECODE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index HSEMESTER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTUSERDB"."HSEMESTER_PK" ON "TESTUSERDB"."HSEMESTER" ("SEMESTERCODE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index HSTUDENT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTUSERDB"."HSTUDENT_PK" ON "TESTUSERDB"."HSTUDENT" ("STUDENTNUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index HUSER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTUSERDB"."HUSER_PK" ON "TESTUSERDB"."HUSER" ("NETID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table HCLASS
--------------------------------------------------------

  ALTER TABLE "TESTUSERDB"."HCLASS" ADD CONSTRAINT "HCLASS_PK" PRIMARY KEY ("CLASSNUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "TESTUSERDB"."HCLASS" MODIFY ("CLASSNUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table HCLASSROOM
--------------------------------------------------------

  ALTER TABLE "TESTUSERDB"."HCLASSROOM" ADD CONSTRAINT "HCLASSROOM_PK" PRIMARY KEY ("ROOMID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "TESTUSERDB"."HCLASSROOM" MODIFY ("ROOMID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table HCOURSE
--------------------------------------------------------

  ALTER TABLE "TESTUSERDB"."HCOURSE" ADD CONSTRAINT "HCOURSE_PK" PRIMARY KEY ("COURSECODE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "TESTUSERDB"."HCOURSE" MODIFY ("COURSECODE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table HDEPARTMENT
--------------------------------------------------------

  ALTER TABLE "TESTUSERDB"."HDEPARTMENT" ADD CONSTRAINT "HDEPARTMENT_PK" PRIMARY KEY ("CODE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "TESTUSERDB"."HDEPARTMENT" MODIFY ("CODE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table HENROLLMENT
--------------------------------------------------------

  ALTER TABLE "TESTUSERDB"."HENROLLMENT" ADD CONSTRAINT "HENROLLMENT_PK" PRIMARY KEY ("ENROLLMENTNUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "TESTUSERDB"."HENROLLMENT" MODIFY ("ENROLLMENTNUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table HINSTRUCTOR
--------------------------------------------------------

  ALTER TABLE "TESTUSERDB"."HINSTRUCTOR" ADD CONSTRAINT "HINSTRUCTOR_PK" PRIMARY KEY ("INSTRUCTORNUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "TESTUSERDB"."HINSTRUCTOR" MODIFY ("INSTRUCTORNUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table HMAJOR
--------------------------------------------------------

  ALTER TABLE "TESTUSERDB"."HMAJOR" ADD CONSTRAINT "HMAJOR_PK" PRIMARY KEY ("MAJORCODE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "TESTUSERDB"."HMAJOR" MODIFY ("MAJORCODE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table HSCHEDULE
--------------------------------------------------------

  ALTER TABLE "TESTUSERDB"."HSCHEDULE" ADD CONSTRAINT "HSCHEDULE_PK" PRIMARY KEY ("SCHEDULECODE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "TESTUSERDB"."HSCHEDULE" MODIFY ("SCHEDULECODE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table HSEMESTER
--------------------------------------------------------

  ALTER TABLE "TESTUSERDB"."HSEMESTER" ADD CONSTRAINT "HSEMESTER_PK" PRIMARY KEY ("SEMESTERCODE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "TESTUSERDB"."HSEMESTER" MODIFY ("SEMESTERCODE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table HSTUDENT
--------------------------------------------------------

  ALTER TABLE "TESTUSERDB"."HSTUDENT" ADD CONSTRAINT "HSTUDENT_PK" PRIMARY KEY ("STUDENTNUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "TESTUSERDB"."HSTUDENT" MODIFY ("STUDENTNUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table HUSER
--------------------------------------------------------

  ALTER TABLE "TESTUSERDB"."HUSER" ADD CONSTRAINT "HUSER_PK" PRIMARY KEY ("NETID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "TESTUSERDB"."HUSER" MODIFY ("NETID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table HCLASS
--------------------------------------------------------

  ALTER TABLE "TESTUSERDB"."HCLASS" ADD CONSTRAINT "HCLASS_FK1" FOREIGN KEY ("COURSECODE")
	  REFERENCES "TESTUSERDB"."HCOURSE" ("COURSECODE") ENABLE;
  ALTER TABLE "TESTUSERDB"."HCLASS" ADD CONSTRAINT "HCLASS_FK2" FOREIGN KEY ("INSTRUCTORNUM")
	  REFERENCES "TESTUSERDB"."HINSTRUCTOR" ("INSTRUCTORNUM") ENABLE;
  ALTER TABLE "TESTUSERDB"."HCLASS" ADD CONSTRAINT "HCLASS_FK3" FOREIGN KEY ("ROOMID")
	  REFERENCES "TESTUSERDB"."HCLASSROOM" ("ROOMID") ENABLE;
  ALTER TABLE "TESTUSERDB"."HCLASS" ADD CONSTRAINT "HCLASS_FK4" FOREIGN KEY ("SCHEDULECODE")
	  REFERENCES "TESTUSERDB"."HSCHEDULE" ("SCHEDULECODE") ENABLE;
  ALTER TABLE "TESTUSERDB"."HCLASS" ADD CONSTRAINT "HCLASS_FK5" FOREIGN KEY ("SEMESTERCODE")
	  REFERENCES "TESTUSERDB"."HSEMESTER" ("SEMESTERCODE") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table HCOURSE
--------------------------------------------------------

  ALTER TABLE "TESTUSERDB"."HCOURSE" ADD CONSTRAINT "HCOURSE_FK1" FOREIGN KEY ("DEPARTCODE")
	  REFERENCES "TESTUSERDB"."HDEPARTMENT" ("CODE") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table HENROLLMENT
--------------------------------------------------------

  ALTER TABLE "TESTUSERDB"."HENROLLMENT" ADD CONSTRAINT "HENROLLMENT_FK1" FOREIGN KEY ("CLASSNUM")
	  REFERENCES "TESTUSERDB"."HCLASS" ("CLASSNUM") ENABLE;
  ALTER TABLE "TESTUSERDB"."HENROLLMENT" ADD CONSTRAINT "HENROLLMENT_FK2" FOREIGN KEY ("STUDENTNUM")
	  REFERENCES "TESTUSERDB"."HSTUDENT" ("STUDENTNUM") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table HINSTRUCTOR
--------------------------------------------------------

  ALTER TABLE "TESTUSERDB"."HINSTRUCTOR" ADD CONSTRAINT "HINSTRUCTOR_FK1" FOREIGN KEY ("DEPARTCODE")
	  REFERENCES "TESTUSERDB"."HDEPARTMENT" ("CODE") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table HMAJOR
--------------------------------------------------------

  ALTER TABLE "TESTUSERDB"."HMAJOR" ADD CONSTRAINT "HMAJOR_FK1" FOREIGN KEY ("DEPARTCODE")
	  REFERENCES "TESTUSERDB"."HDEPARTMENT" ("CODE") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table HSTUDENT
--------------------------------------------------------

  ALTER TABLE "TESTUSERDB"."HSTUDENT" ADD CONSTRAINT "HSTUDENT_FK1" FOREIGN KEY ("MAJORCODE")
	  REFERENCES "TESTUSERDB"."HMAJOR" ("MAJORCODE") ENABLE;
--------------------------------------------------------
--  DDL for Trigger HCLASS_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TESTUSERDB"."HCLASS_TRG" 
BEFORE INSERT ON HCLASS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.CLASSNUM IS NULL THEN
      SELECT HCLASS_SEQ.NEXTVAL INTO :NEW.CLASSNUM FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "TESTUSERDB"."HCLASS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger HCLASSROOM_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TESTUSERDB"."HCLASSROOM_TRG" 
BEFORE INSERT ON HCLASSROOM 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ROOMID IS NULL THEN
      SELECT HCLASSROOM_SEQ1.NEXTVAL INTO :NEW.ROOMID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "TESTUSERDB"."HCLASSROOM_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger HCOURSE_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TESTUSERDB"."HCOURSE_TRG" 
BEFORE INSERT ON HCOURSE 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.COURSECODE IS NULL THEN
      SELECT HCOURSE_SEQ.NEXTVAL INTO :NEW.COURSECODE FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "TESTUSERDB"."HCOURSE_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger HDEPARTMENT_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TESTUSERDB"."HDEPARTMENT_TRG" 
BEFORE INSERT ON HDEPARTMENT 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.CODE IS NULL THEN
      SELECT HDEPARTMENT_SEQ.NEXTVAL INTO :NEW.CODE FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "TESTUSERDB"."HDEPARTMENT_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger HDEPARTMENT_TRG1
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TESTUSERDB"."HDEPARTMENT_TRG1" 
BEFORE INSERT ON HDEPARTMENT 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    NULL;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "TESTUSERDB"."HDEPARTMENT_TRG1" ENABLE;
--------------------------------------------------------
--  DDL for Trigger HENROLLMENT_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TESTUSERDB"."HENROLLMENT_TRG" 
BEFORE INSERT ON HENROLLMENT 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ENROLLMENTNUM IS NULL THEN
      SELECT HENROLLMENT_SEQ.NEXTVAL INTO :NEW.ENROLLMENTNUM FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "TESTUSERDB"."HENROLLMENT_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger HINSTRUCTOR_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TESTUSERDB"."HINSTRUCTOR_TRG" 
BEFORE INSERT ON HINSTRUCTOR 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.INSTRUCTORNUM IS NULL THEN
      SELECT HINSTRUCTOR_SEQ.NEXTVAL INTO :NEW.INSTRUCTORNUM FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "TESTUSERDB"."HINSTRUCTOR_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger HMAJOR_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TESTUSERDB"."HMAJOR_TRG" 
BEFORE INSERT ON HMAJOR 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.MAJORCODE IS NULL THEN
      SELECT HMAJOR_SEQ.NEXTVAL INTO :NEW.MAJORCODE FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "TESTUSERDB"."HMAJOR_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger HSCHEDULE_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TESTUSERDB"."HSCHEDULE_TRG" 
BEFORE INSERT ON HSCHEDULE 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.SCHEDULECODE IS NULL THEN
      SELECT HSCHEDULE_SEQ.NEXTVAL INTO :NEW.SCHEDULECODE FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "TESTUSERDB"."HSCHEDULE_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger HSEMESTER_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TESTUSERDB"."HSEMESTER_TRG" 
BEFORE INSERT ON HSEMESTER 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.SEMESTERCODE IS NULL THEN
      SELECT HSEMESTER_SEQ1.NEXTVAL INTO :NEW.SEMESTERCODE FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "TESTUSERDB"."HSEMESTER_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger HSTUDENT_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TESTUSERDB"."HSTUDENT_TRG" 
BEFORE INSERT ON HSTUDENT 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.STUDENTNUM IS NULL THEN
      SELECT HSTUDENT_SEQ.NEXTVAL INTO :NEW.STUDENTNUM FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "TESTUSERDB"."HSTUDENT_TRG" ENABLE;
