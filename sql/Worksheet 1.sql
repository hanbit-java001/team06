SELECT SEQ_PHOTO.CURRVAL FROM DUAL;
----------------------------------------------------------
SELECT * FROM PHOTO;
----------------------------------------------------------
INSERT INTO PHOTO (IMAGE_ID, IMAGE_NAME,IMAGE_REGDATE)
 VALUES (SEQ_PHOTO.NEXTVAL, 'aaa2.jpg', TO_CHAR(SYSDATE,'YYYYMMDDHH24MISS'));
----------------------------------------------------------
COMMIT;
