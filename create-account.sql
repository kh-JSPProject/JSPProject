ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER memo IDENTIFIED BY memo1234;

GRANT RESOURCE, CONNECT TO memo;

ALTER USER memo DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;