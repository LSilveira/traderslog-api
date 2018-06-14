/*Traders Log Database Script
Creator:      Luis Silveira
Description:  #2 Company CRUD
Script Type:  Create database structure
*/

-------------------------------------------------------------------------------
- TL_COMPANY :: CREATE
-------------------------------------------------------------------------------
CREATE TABLE TL_COMPANY(
    ID INT PRIMARY KEY,
    NAME VARCHAR2(100) NOT NULL,
    DESCRIPTION VARCHAR2(300),
    SIZE VARCHAR2(25) NOT NULL,
    URL VARCHAR2(300)
);

-------------------------------------------------------------------------------
- TL_COMPANY_CATEGORY :: CREATE
-------------------------------------------------------------------------------
CREATE TABLE TL_COMPANY_CATEGORY(
    ID INT PRIMARY KEY,
    NAME VARCHAR2(100) NOT NULL,
    DESCRIPTION VARCHAR2(300)
);

-------------------------------------------------------------------------------
- TL_VERSION :: INSERT
-------------------------------------------------------------------------------
INSERT INTO TL_VERSION(VERSION, DESCRIPTION) VALUES('2018.07.00.002', 'Create database structure');