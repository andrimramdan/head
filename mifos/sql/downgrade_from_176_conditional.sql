/*Added for financials*/
/* The table GLCODE will contain the different glcodes supported by the MFI, used in financial transactions - Configuration */
INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(1,'10000');
/* The table COA will contain the different Chart Of Accounts supported by MFI, like assets etc linked to a corrosponding glcode - Configuration */
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID) 
VALUES(1,'ASSETS',1);
/* The table COAHIERARCHY will contain the Chart of account linkages, like cash balance is under assets etc - Configuration */
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(1,null);
/* The table COA_IDMPPER will be used internally by the system, it is used to denote the associaton of a coa with the internal id used by the system for that COA */
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(1,1,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(2,'11000');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID) 
VALUES(2,'Cash and bank balances',2);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(2,1);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(2,2,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(3,'11100');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID) 
VALUES(3,'Petty Cash Accounts',3);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID)
VALUES(3,2);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(3,3,'');
 
INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(4,'11101');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(4,'Cash 1',4);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID)
VALUES(4,3);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(4,4,'');
 
INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(5,'11102');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID) 
VALUES(5,'Cash 2',5);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(5,3);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(5,5,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(6,'11200');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID) 
VALUES(6,'Bank Balances',6);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID)
VALUES(6,2);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(6,6,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(7,'11201');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID) 
VALUES(7,'Bank Account 1',7);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(7,6);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION) 
VALUES(7,7,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(8,'11202');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(8,'Bank Account 2',8);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(8,6);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION) 
VALUES(8,8,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(9,'13000');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(9,'Loan Portfolio',9);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID)
VALUES(9,1);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(9,9,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(10,'13100');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID) 
VALUES(10,'Loans and Advances',10);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(10,9);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(10,10,'');



INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(11,'13101');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID) 
VALUES(11,'Loans to clients',11);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(11,10);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(11,11,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE)
VALUES(32,'1501');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(32,'IGLoan',32);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID)
VALUES(32,10);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(32,32,'');


INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE)
VALUES(33,'1502');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(33,'ManagedICICI-IGLoan',33);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID)
VALUES(33,10);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(33,33,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE)
VALUES(34,'1503');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(34,'SPLoan',34);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID)
VALUES(34,10);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(34,34,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE)
VALUES(35,'1504');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(35,'ManagedICICI-SPLoan',35);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID)
VALUES(35,10);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(35,35,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE)
VALUES(36,'1505');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(36,'WFLoan',36);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID)
VALUES(36,10);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(36,36,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE)
VALUES(37,'1506');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(37,'Managed WFLoan',37);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID)
VALUES(37,10);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(37,37,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE)
VALUES(38,'1507');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(38,'Emergency Loans',38);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID)
VALUES(38,10);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(38,38,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE)
VALUES(39,'1508');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(39,'Special  Loans',39);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID)
VALUES(39,10);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(39,39,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE)
VALUES(40,'1509');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(40,'Micro Enterprises Loans',40);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID)
VALUES(40,10);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(40,40,'');


INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(12,'13200');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID) 
VALUES(12,'Loan Loss Provisions',12);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(12,9);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(12,12,'');

 
INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE)
VALUES(13,'13201');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID) 
VALUES(13,'Write-offs',13);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(13,12);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(13,13,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(14,'20000');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID) 
VALUES(14,'LIABILITIES',14);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID)
VALUES(14,null);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION) 
VALUES(14,14,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(15,'22000');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID) 
VALUES(15,'Interest Payable',15);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(15,14);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(15,15,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(16,'22100');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(16,'Interest payable on clients savings',16);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(16,15);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(16,16,'');
 
INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(17,'22101');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID) 
VALUES(17,'Interest on mandatory savings',17);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(17,16);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION) 
VALUES(17,17,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(18,'30000');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(18,'INCOME',18);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID)
VALUES(18,null);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(18,18,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(19,'31000');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(19,'Direct Income',19);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID)
VALUES(19,18);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION) 
VALUES(19,19,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(20,'31100');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID) 
VALUES(20,'Interest income from loans',20);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(20,19);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION) 
VALUES(20,20,'');


INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(21,'31101');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID) 
VALUES(21,'Interest on loans',21);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID)
VALUES(21,20);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(21,21,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(45,'5001');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID) 
VALUES(45,'Interest',45);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID)
VALUES(45,20);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(45,45,'');

 
INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(22,'31102');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(22,'Penalty',22);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(22,20);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(22,22,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(23,'31300');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(23,'Income from micro credit & lending activities',23);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID)
VALUES(23,19);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(23,23,'');



INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE)
VALUES(24,'31301');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(24,'Fees',24);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(24,23);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(24,24,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE)
VALUES(46,'5201');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(46,'Processing Fees',46);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(46,23);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(46,46,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE)
VALUES(47,'5202');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(47,'Annual Subscription Fee',47);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(47,23);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(47,47,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE)
VALUES(48,'5203');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(48,'Emergency Loan Documentation Fee',48);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(48,23);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(48,48,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE)
VALUES(49,'5204');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(49,'Sale of Publication',49);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(49,23);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(49,49,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE)
VALUES(50,'5205');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(50,'Fines & Penalties',50);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(50,23);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(50,50,'');

INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE)
VALUES(51,'6201');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID)
VALUES(51,'Miscelleneous Income',51);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID) 
VALUES(51,23);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(51,51,'');


INSERT INTO GL_CODE(GLCODE_ID,GLCODE_VALUE) 
VALUES(25,'31401');
INSERT INTO COA(COA_ID,COA_NAME,GLCODE_ID) 
VALUES(25,'Income from 999 Account', 25);
INSERT INTO COAHIERARCHY(COA_ID,PARENT_COAID)
VALUES(25,18);
INSERT INTO COA_IDMAPPER(CONSTANT_ID,COA_ID,DESCRIPTION)
VALUES(25,25,null);

INSERT INTO GL_CODE VALUES(26,'23000');
INSERT INTO COA VALUES(26,'Clients Deposits' ,26);
INSERT INTO COAHIERARCHY VALUES(26,14);
INSERT INTO COA_IDMAPPER VALUES(26,26,'');

INSERT INTO GL_CODE VALUES(27,'23100');
INSERT INTO COA VALUES(27,'Clients Deposits',27);
INSERT INTO COAHIERARCHY VALUES(27,26);
INSERT INTO COA_IDMAPPER VALUES(27,27,'');



INSERT INTO GL_CODE VALUES(28,'23101');
INSERT INTO COA VALUES(28,'Savings accounts',28);
INSERT INTO COAHIERARCHY VALUES(28,27);
INSERT INTO COA_IDMAPPER VALUES(28,28,'');

INSERT INTO GL_CODE VALUES(41,'4601');
INSERT INTO COA VALUES(41,'Emergency Fund',41);
INSERT INTO COAHIERARCHY VALUES(41,27);
INSERT INTO COA_IDMAPPER VALUES(41,41,'');


INSERT INTO GL_CODE VALUES(42,'4602');
INSERT INTO COA VALUES(42,'Margin Money-1',42);
INSERT INTO COAHIERARCHY VALUES(42,27);
INSERT INTO COA_IDMAPPER VALUES(42,42,'');


INSERT INTO GL_CODE VALUES(43,'4603');
INSERT INTO COA VALUES(43,'Margin Money-2',43);
INSERT INTO COAHIERARCHY VALUES(43,27);
INSERT INTO COA_IDMAPPER VALUES(43,43,'');


INSERT INTO GL_CODE VALUES(44,'4606');
INSERT INTO COA VALUES(44,'Village Development Fund',44);
INSERT INTO COAHIERARCHY VALUES(44,27);
INSERT INTO COA_IDMAPPER VALUES(44,44,'');


INSERT INTO GL_CODE VALUES(29,'24000');
INSERT INTO COA VALUES(29,'Mandatory Savings',29);
INSERT INTO COAHIERARCHY VALUES(29,14);
INSERT INTO COA_IDMAPPER VALUES(29,29,'');

INSERT INTO GL_CODE VALUES(30,'24100');
INSERT INTO COA VALUES(30,'Mandatory Savings',30);
INSERT INTO COAHIERARCHY VALUES(30,29);
INSERT INTO COA_IDMAPPER VALUES(30,30,'');

INSERT INTO GL_CODE VALUES(31,'24101');
INSERT INTO COA VALUES(31,'Mandatory Savings Accounts',31);
INSERT INTO COAHIERARCHY VALUES(31,30);
INSERT INTO COA_IDMAPPER VALUES(31,31,'');


INSERT INTO GL_CODE VALUES(53,'40000');
INSERT INTO COA VALUES(53,'EXPENDITURE',53);
INSERT INTO COAHIERARCHY VALUES(53,null);
INSERT INTO COA_IDMAPPER VALUES(53,53,'');

INSERT INTO GL_CODE VALUES(54,'41000');
INSERT INTO COA VALUES(54,'Direct Expenditure',54);
INSERT INTO COAHIERARCHY VALUES(54,53);
INSERT INTO COA_IDMAPPER VALUES(54,54,'');


INSERT INTO GL_CODE VALUES(55,'41100');
INSERT INTO COA VALUES(55,'Cost of Funds',55);
INSERT INTO COAHIERARCHY VALUES(55,54);
INSERT INTO COA_IDMAPPER VALUES(55,55,'');


INSERT INTO GL_CODE VALUES(56,'41101');
INSERT INTO COA VALUES(56,'Interest on clients voluntary savings',56);
INSERT INTO COAHIERARCHY VALUES(56,55);
INSERT INTO COA_IDMAPPER VALUES(56,56,'');


INSERT INTO GL_CODE VALUES(57,'41102');
INSERT INTO COA VALUES(57,'Interest on clients mandatory savings',57);
INSERT INTO COAHIERARCHY VALUES(57,55);
INSERT INTO COA_IDMAPPER VALUES(57,57,'');

UPDATE DATABASE_VERSION SET DATABASE_VERSION = 175 WHERE DATABASE_VERSION = 176;
