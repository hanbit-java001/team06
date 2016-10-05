-- DROP TABLE PHOTO CASCADE CONSTRAINTS;
CREATE TABLE PHOTO
(
   PHOTO_ID			INT NOT NULL,
   PHOTO_NAME	VARCHAR2 (100) NOT NULL,
   PHOTO_DATE		VARCHAR2 (20),
   PHOTO_RES1		VARCHAR2 (4),
   PHOTO_RES2		VARCHAR2 (4),
   PHOTO_PATH		VARCHAR2 (400),
   MEMBER_ID      INT NOT NULL,
   PRIMARY KEY (PHOTO_ID),
   CONSTRAINT U_PHOTO_NAME UNIQUE (PHOTO_NAME),
   CONSTRAINT FK_PHOTO_MEMBER FOREIGN KEY(MEMBER_ID) 
   REFERENCES MEMBER(MEMBER_ID)
   )
   /
   
-- ALTER TABLE PHOTO DROP CONSTRAINT FK_PHOTO_MEMBER
/
-- ALTER TABLE PHOTO ADD 
-- CONSTRAINT FK_PHOTO_MEMBER FOREIGN KEY(MEMBER_ID) 
-- REFERENCES MEMBER(MEMBER_ID)
/

-- DROP SEQUENCE SEQ_PHOTO
/
CREATE SEQUENCE SEQ_PHOTO
INCREMENT BY 1  
START WITH 1 
NOMAXVALUE 
MINVALUE 1
CACHE 10
/