/*Traders Log Database Script
Creator:      Luis Silveira
Description:  #1 DB Base structure
Script Type:  Create database structure
*/

-------------------------------------------------------------------------------
- TL_VERSION :: CREATE
-------------------------------------------------------------------------------
CREATE TABLE TL_VERSION(
    VERSION VARCHAR2(20) PRIMARY KEY COMMENT 'Script version',
    DATE_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT 'Script creation date',
    DESCRIPTION VARCHAR2(255) COMMENT 'Script description'
);

-------------------------------------------------------------------------------
- TL_VERSION :: INSERT
-------------------------------------------------------------------------------
INSERT INTO TL_VERSION(VERSION, DESCRIPTION) VALUES('2018.07.00.001', 'Create database structure');