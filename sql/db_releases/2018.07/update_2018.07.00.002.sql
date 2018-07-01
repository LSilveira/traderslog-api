/*Traders Log Database Script
Creator:      Luis Silveira
Description:  #2 Company CRUD
Script Type:  Create database structure
*/

-------------------------------------------------------------------------------
- TL_COMPANY :: CREATE
-------------------------------------------------------------------------------
CREATE TABLE TL_COMPANY(
    ID INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Company unique ID',
    NAME VARCHAR2(100) NOT NULL COMMENT 'Company name',
    DESCRIPTION VARCHAR2(300) COMMENT 'Company description',
    SIZE VARCHAR2(25) NOT NULL COMMENT 'Company size',
    URL VARCHAR2(300)  COMMENT 'Company website'
);

-------------------------------------------------------------------------------
- TL_INDUSTRY :: CREATE
-------------------------------------------------------------------------------
CREATE TABLE TL_INDUSTRY(
    ID INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Industry unique ID',
    NAME VARCHAR2(100) NOT NULL COMMENT 'Industry name',
    DESCRIPTION VARCHAR2(300) COMMENT 'Industry description',
    SIZE VARCHAR2(25) NOT NULL COMMENT 'Industry size'
);

-------------------------------------------------------------------------------
- TL_COMPANY_INDUSTRY_MAPPINGS :: CREATE
-------------------------------------------------------------------------------
CREATE TABLE TL_COMPANY_INDUSTRY_MAPPINGS(
    COMPANY_ID INT COMMENT 'Company ID',
    INDUSTRY_ID INT COMMENT 'INDUSTRY ID',
    CONSTRAINT FK_COMPANY FOREIGN KEY (COMPANY_ID) REFERENCES TL_COMPANY(ID),
    CONSTRAINT FK_INDUSTRY FOREIGN KEY (INDUSTRY_ID) REFERENCES TL_INDUSTRY(ID),
    PRIMARY KEY (COMPANY_ID, INDUSTRY_ID)
);

-------------------------------------------------------------------------------
- TL_VERSION :: INSERT
-------------------------------------------------------------------------------
INSERT INTO TL_VERSION(VERSION, DESCRIPTION) VALUES('2018.07.00.002', 'Create database structure');