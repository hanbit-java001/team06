CREATE TABLE PHOTO
(
   IMAGE_ID        NUMBER (*, 0) PRIMARY KEY,
   IMAGE_NAME      VARCHAR2 (100) UNIQUE,
   IMAGE_REGDATE   VARCHAR2 (20),
   IMAGE_RES1      VARCHAR2 (4),
   IMAGE_RES2      VARCHAR2 (4),
   IMAGE_TN_URL    VARCHAR2 (400),
   IMAGE_URL       VARCHAR2 (400)
)
NOCACHE
LOGGING;