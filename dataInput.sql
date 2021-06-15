
SELECT * FROM PRODUCT;
SELECT * FROM PRODUCT_IMG;
SELECT * FROM COMMU;
SELECT * FROM COMMENT;
SELECT * FROM BOARDLIKE;
SELECT * FROM COLOR;


-- PRODUCT 상품
INSERT INTO PRODUCT (PRODNUM, CATEGORY, SUBCATEGORY, PRODNAME, COLOR, PRODOPTION, INFO, WEIGHT, ORIPRICE, PRICE, QUANTITY, RDATE, DELIVERYCOST, FILENAME, READCOUNT)
VALUES(PRODSEQ.NEXTVAL, '책장', '책장', 'LERBERG 레르베리', 'white', null, '유행을 타지 않는 클래식한 느낌의 튼튼한 선반유닛으로 모든 크기의 물건을 보관할 수 있는 여러 개의 오픈 선반이 있어요.', 5, 8700, null, 100, SYSDATE, 3500, 'bookcase1.png', 0)

-- PRODUCT_IMG 상품이미지
INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 1, '세탁방법: 깨끗한 천으로 물기를 닦아주세요.', 'bk1-blackImg.png');

-- COLOR 상품색상
INSERT INTO COLOR(COLORSEQ, PRODNUM, COLOR, COLORFILENAME)
VALUES(COLORSEQ.NEXTVAL, 1, 'black', 'bookcase1-black.png');
-----------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO PRODUCT (PRODNUM, CATEGORY, SUBCATEGORY, PRODNAME, COLOR, PRODOPTION, INFO, WEIGHT, ORIPRICE, PRICE, QUANTITY, RDATE, DELIVERYCOST, FILENAME, READCOUNT)
VALUES(PRODSEQ.NEXTVAL, '책장', '책장', 'LERBERG 레르베리', 'white', null, '유행을 타지 않는 클래식한 느낌의 튼튼한 선반유닛으로 모든 크기의 물건을 보관할 수 있는 여러 개의 오픈 선반이 있어요.', 5, 8700, null, 100, SYSDATE, 3500, 'bookcase1.png', 0)

-- PRODUCT_IMG 상품이미지
INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 1, 상품소개, 파일명);

-- COLOR 상품색상
INSERT INTO COLOR(COLORSEQ, PRODNUM, COLOR, COLORFILENAME)
VALUES(COLORSEQ, 상품번호, 컬러, 컬러이미지);
-----------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO PRODUCT (PRODNUM, CATEGORY, SUBCATEGORY, PRODNAME, COLOR, PRODOPTION, INFO, WEIGHT, ORIPRICE, PRICE, QUANTITY, RDATE, DELIVERYCOST, FILENAME, READCOUNT)
VALUES(PRODSEQ.NEXTVAL, '책장', '책장', 'LERBERG 레르베리', 'white', null, '유행을 타지 않는 클래식한 느낌의 튼튼한 선반유닛으로 모든 크기의 물건을 보관할 수 있는 여러 개의 오픈 선반이 있어요.', 5, 8700, null, 100, SYSDATE, 3500, 'bookcase1.png', 0)

-- PRODUCT_IMG 상품이미지
INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 1, 상품소개, 파일명);

-- COLOR 상품색상
INSERT INTO COLOR(COLORSEQ, PRODNUM, COLOR, COLORFILENAME)
VALUES(COLORSEQ, 상품번호, 컬러, 컬러이미지);
-----------------------------------------------------------------------------------------------------------------------------------------------------------------













-- COMMUNITY 커뮤니티
INSERT INTO COMMU(CMNUM, ID, IMAGE1, IMAGE2, TITLE, CONTENT, READCOUNT, CMLIKE, COMMUDEL)
VALUES(CMMUSEQ.NEXTVAL, 아이디, 이미지1, 이미지2, 제목, 내용, 0, 0, 0)

-- COMMENT 댓글
INSERT INTO COMMENT(CTNUM, CMNUM, ID, WDATE, CONTENT, DEL)
VALUES(CTNUMSEQ.NEXTVAL, 글번호, 아이디, SYSDATE, 내용, 0)

-- LIKE 좋아요
INSERT INTO BOARDLIKE(LIKENUM, CMNUM, ID)
VALUES(LNUM.NEXTVAL, 글번호, 아이디)


