-- DROP TABLE HASHTAG CASCADE CONSTRAINTS;
CREATE TABLE HASHTAG
(
   HASHTAG_ID			INT NOT NULL,
   HASHTAG_WORD	VARCHAR2 (100) NOT NULL
-- , PRIMARY KEY (HASHTAG_ID)
   )
   /

-- DROP SEQUENCE SEQ_HASHTAG
/
CREATE SEQUENCE SEQ_HASHTAG
INCREMENT BY 1  
START WITH 1 
NOMAXVALUE 
MINVALUE 1
CACHE 10
/