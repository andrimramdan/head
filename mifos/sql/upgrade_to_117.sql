
INSERT INTO REPORT(REPORT_ID,REPORT_CATEGORY_ID,REPORT_NAME,REPORT_IDENTIFIER) VALUES(28,6,'Detailed Aging of Portfolio at Risk','test.rptdesign');

INSERT INTO report_jasper_map(REPORT_ID,REPORT_CATEGORY_ID,REPORT_NAME,REPORT_IDENTIFIER, REPORT_JASPER) VALUES 
(28,6,'Loan Status Report',NULL,'report/test.rptdesign');

update DATABASE_VERSION set DATABASE_VERSION = 117 where DATABASE_VERSION = 116;
