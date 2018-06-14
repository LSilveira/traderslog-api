/*Traders Log Database Script
Creator:      Luis Silveira
Description:  #3 Financial Asset CRUD
Script Type:  Create database structure
*/

-------------------------------------------------------------------------------
- TL_FINANCIAL_ASSET :: CREATE
-------------------------------------------------------------------------------
CREATE TABLE TL_FINANCIAL_ASSET(
    ID INT PRIMARY KEY,
    NAME VARCHAR2(50) NOT NULL,
    SYMBOL VARCHAR2(10) NOT NULL,
    DESCRIPTION VARCHAR2(300),
    SIZE VARCHAR2(25) NOT NULL,
    REMOVED TINYINT(1) NOT NULL DEFAULT '0'
);

-------------------------------------------------------------------------------
- TL_VERSION :: INSERT
-------------------------------------------------------------------------------
INSERT INTO TL_VERSION(VERSION, DESCRIPTION) VALUES('2018.07.00.003', 'Create database structure');