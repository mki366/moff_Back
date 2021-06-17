
--멤버테이블 드랍
DROP TABLE ALL_MEMBER
CASCADE CONSTRAINTS;
--멤버테이블 시퀀스 드랍
DROP SEQUENCE MEMNUMSEQ;


--멤버테이블 생성
CREATE TABLE ALL_MEMBER
(
    MEMNUM          NUMBER          NOT NULL,    --회원번호
    ID           VARCHAR2(50)    NULL,        --회원아이디
    PWD          VARCHAR2(50)    NULL,        --회원비밀번호
    NAME         VARCHAR2(20)    NOT NULL,    --본명
    NICKNAME     VARCHAR2(20) NOT NULL,      --닉네임
    EMAIL        VARCHAR2(30)  NOT  NULL,     --이메일주소
    ADDRESS      VARCHAR2(500)  NOT  NULL,  --주소
    PHONE        VARCHAR2(50)          NULL,        --전화번호
    BDATE        VARCHAR2(30)   NOT NULL,     --생년월일(배달원일시 만 19세 미만X)
    JDATE        DATE            NULL,        --회원가입일
    MEMDEL       NUMBER          DEFAULT 0 NULL,        --회원탈퇴유무
    MEMPOINT     NUMBER          DEFAULT 0 NULL,        --포인트 칼럼생성
    MEMBERTYPE   NUMBER          NULL,        -- 0 번은 회원, 1번은 배달원, 2번은 관리자
    DELIVERYADMI     NUMBER          NULL,   --배달원일시승인여부 칼럼생성
    LICENSE      VARCHAR2(400)        NULL,        --운전면허증사진
    BANK         VARCHAR2(400)        NULL,        --통장사본사진
    CARNUM       VARCHAR2(400)        NULL,        --차번호판
    CONSTRAINT MEMBER_PK PRIMARY KEY (ID)
);

UPDATE ALL_MEMBER SET MEMDEL = 0
WHERE MEMDEL IS NULL

	SELECT *
	FROM ALL_MEMBER
	WHERE ID='test060801' AND PWD='test060801!' AND MEMDEL=0



ALTER TABLE ALL_MEMBER MODIFY PHONE VARCHAR2(50);
--멤버시퀀스 생성
CREATE SEQUENCE MEMNUMSEQ
START WITH 1
INCREMENT BY 1;

INSERT INTO ALL_MEMBER(
	MEMNUM, ID, PWD, NAME, NICKNAME,
	 EMAIL, ADDRESS, PHONE,BDATE, JDATE,
	  MEMBERTYPE, LICENSE, BANK, CARNUM)
	  
	VALUES(MEMNUMSEQ.NEXTVAL, 'dd88ddd55d', 'dsdsdsds', '이필승', '아녕하세요',
	 'sdkskjdn@naver.com','강원도 원주','01028883498', '1987/5/22', SYSDATE,
	  0, '운전면허증사진','통장사본사진', '차량신고증사진')

	  
	  --연령대
	SELECT BDATE
     , NVL(COUNT(*),0) cnt
  FROM (SELECT CASE WHEN               age < 20 THEN '20세미만'
                    WHEN age >= 20 AND age < 30 THEN '20세이상 ~ 30세미만'
                    WHEN age >= 30 AND age < 40 THEN '30세이상 ~ 40세미만'
                    WHEN age >= 40 AND age < 50 THEN '40세이상 ~ 50세미만'
                    WHEN age >= 50 AND age < 60 THEN '50세이상 ~ 60세미만'
                    WHEN age >= 60              THEN '60세이상'
                END BDATE
          FROM (SELECT TRUNC((TO_CHAR(SYSDATE, 'YYYY') - SUBSTR(BDATE,1,4))) age
                  FROM ALL_MEMBER
                )
        )
 GROUP BY BDATE
 ORDER BY BDATE

---------------------------------------------
--상품테이블
--상품테이블 드랍
DROP TABLE PRODUCT
CASCADE CONSTRAINTS;
--상품테이블 시퀀스 드랍
DROP SEQUENCE PRODSEQ;
--상품테이블 생성
CREATE TABLE PRODUCT
(
    PRODNUM          NUMBER          NOT NULL,    --상품번호
    CATEGORY     VARCHAR2(50)    NULL,        --상품분류
    SUBCATEGORY  VARCHAR2(50)    NULL,        --상품세분류
    PRODNAME         VARCHAR2(50)    NOT NULL,     --상품이름
    COLOR        VARCHAR2(20)    NULL,         --상품색상
    PRODOPTION       VARCHAR2(50)    NULL,         --상품옵션
    INFO        VARCHAR2(400)    NOT  NULL,   --상품정보
    WEIGHT       NUMBER          NOT  NULL,   --상품무게
    ORIPRICE     NUMBER          NOT  NULL,    --상품정가
    PRICE        NUMBER          NULL,         --상품판매가격
    QUANTITY      NUMBER          NULL,         --상품재고(수량)
    RDATE         DATE            NULL,         --상품등록일
    DELIVERYCOST      NUMBER          NULL,         --배송비
   	FILENAME	VARCHAR(50)		NOT NULL, --대표사진
   	READCOUNT 		NUMBER  		NOT NULL,	 --조회수

    CONSTRAINT PRODUCT_PK PRIMARY KEY (PRODNUM)
);

--ALTER TABLE PRODUCT ADD FILENAME  VARCHAR(50) NOT NULL;
--정윤언니주문 칼럼명 변경 P_INFOR -> P_INFO
--ALTER TABLE PRODUCT
--RENAME COLUMN P_INFOR TO P_INFO;

--전체 출력
''



SELECT * FROM PRODUCT;

commit;

--배송비 변경

UPDATE PRODUCT SET DELIVERYCOST=50000
WHERE PRODNUM=3 AND 
--상품넣기 예시 1
INSERT INTO PRODUCT(PRODNUM, CATEGORY, SUBCATEGORY, PRODNAME, 
						COLOR, PRODOPTION, INFO, WEIGHT, ORIPRICE,PRICE, QUANTITY, RDATE, DELIVERYCOST, FILENAME)
VALUES(PRODSEQ.NEXTVAL, '편한의자','이쁜의자', '핫한의자','핫핑크', '옵션없음','핫하다', 10, 30000, 30000, 3, SYSDATE,2500, '핫핑크.PNG')

INSERT INTO PRODUCT(PRODNUM, CATEGORY, SUBCATEGORY, PRODNAME, 
						COLOR, PRODOPTION, INFO, WEIGHT, ORIPRICE,PRICE, QUANTITY, RDATE, DELIVERYCOST, FILENAME)
VALUES(PRODSEQ.NEXTVAL, '의자','이쁜의자', '기깔란책상','핫핑크', '옵션없음','핫하다', 10, 30000, 30000, 3, SYSDATE,2500, '핫핑크.PNG')


--상품시퀀스 생성
CREATE SEQUENCE PRODSEQ
START WITH 1
INCREMENT BY 1;

---------------------------------------------------
--상품이미지테이블
--상품이미지테이블 드랍

DROP TABLE PRODUCT_IMG
CASCADE CONSTRAINTS;
--상품이미지테이블 시퀀스 드랍
DROP SEQUENCE PINUM_SEQ;

--파일이름 칼럼 변경
CREATE TABLE PRODUCT_IMG
(
    PINUM   		NUMBER   		NOT NULL,    	--이미지번호
    PRODNUM    		NUMBER   		NOT NULL,    	--상품번호
    INFO        	VARCHAR2(1000)  NULL,     		--상품이미지정보
    IMG_FILENAME    VARCHAR2(20)  	NOT NULL,    	--이미지파일명
    
    CONSTRAINT PRODUCT_IMG_FK  FOREIGN KEY (PRODNUM)
    REFERENCES PRODUCT(PRODNUM)
    
);


--상품이미지시퀀스 생성
CREATE SEQUENCE PINUM_SEQ
START WITH 1
INCREMENT BY 1;
---------------------------------------------------------
--주문(구매)테이블

--주문(구매)테이블 드랍

DROP TABLE ORDER_BUY
CASCADE CONSTRAINTS;
--주문(구매) 시퀀스 드랍
DROP SEQUENCE OBNUM_SEQ;

CREATE TABLE ORDER_BUY
(
    OBNUM      NUMBER          NOT NULL,    --주문번호
    ID         VARCHAR2(50)    NOT NULL,     --구매자아이디
    NAME       VARCHAR2(50)    NOT NULL,     --구매자이름
    QUANTITY   NUMBER        NOT  NULL,   --총구매수량
    PRICE      NUMBER        NOT  NULL,         --상품판매가격
    OBNAME     VARCHAR2(50)  NOT  NULL,         --수령자이름
    OBPHONE    VARCHAR2(50)        NOT  NULL,         --수령자전화번호
    OBADDRESS  VARCHAR2(500)       NOT  NULL,         --배송주소
    OBMES      VARCHAR2(400)    NULL,         --배송전달메세지
    OBWAY      VARCHAR2(50)  NOT  NULL,         --결제방법
    OBCARDN    VARCHAR2(50)   NULL,      --결제카드회사이름
    OBDATE     DATE            NULL,   --주문(구매)일시
    OBTAKEBACK   NUMBER   NULL,          --반품여부 반품 안할시 0
    OBEXCHANGE   NUMBER   NULL,          --교환여부 반품 안할시 0
    DELIVERYCOST  NUMBER NULL, --총 배송비
    CONSTRAINT ORDER_BUY_PK PRIMARY KEY (OBNUM)
    
);

ALTER TABLE ORDER_BUY ADD DELIVERYCOST  NUMBER NULL;
--데이터 변환
UPDATE ORDER_BUY SET OBPHONE='010-2888-3498'
WHERE OBNAME='곽태민';





--상품 디테일 테이블 추가로 인해 PRODNAME,PRODNUM 삭제
--ALTER TABLE ORDER_BUY DROP COLUMN PRODNUM;
--ALTER TABLE ORDER_BUY DROP COLUMN PRODNAME;

--주문 예시 쿼리
INSERT INTO ORDER_BUY(OBNUM, ID, NAME, QUANTITY, PRICE, OBNAME, OBPHONE,OBADDRESS,
						OBMES, OBWAY, OBCARDN, OBDATE, OBTAKEBACK, OBEXCHANGE)
						VALUES(OBNUM_SEQ.NEXTVAL, 'test0608','이다솜', 3, 90000, '이다솜','010-9507-4414','서울특별시 합정동 12-6 3동 202호',
						'배송전 문자좀 부탁드려요', '무통장입금','신한은행',SYSDATE, 0,0)


--전체주문테이블, 배송상태체크 테이블 조인
SELECT OBNUM, 
        NAME,
        QUANTITY,
        PRICE, 
        OBNAME, 
        OBPHONE, 
        OBADDRESS,
        OBDATE,
        STA,
        DID,
        DNAME
FROM(SELECT ROW_NUMBER()OVER(ORDER BY a.OBNUM ASC) AS RNUM,a.OBNUM, a.NAME, a.QUANTITY, a.PRICE, a.OBNAME, a.OBPHONE, a.OBADDRESS,
	a.OBDATE, b.STATUS AS STA, b.ID AS DID, b.NAME AS DNAME
FROM ORDER_BUY a , DELIVERY_CHECK b
WHERE a.OBNUM = b.OBNUM	
ORDER BY a.OBNUM ASC)
WHERE RNUM BETWEEN 1 AND 13
------------------------------------			
						
--
 SELECT a.OBNUM, a.NAME, a.QUANTITY, a.PRICE, a.OBNAME, a.OBPHONE, a.OBADDRESS,
	a.OBDATE, b.STATUS, b.ID, b.NAME
	FROM ORDER_BUY a , DELIVERY_CHECK b
	WHERE a.OBNUM = b.OBNUM


--구매자아이디 외래키생성
ALTER TABLE ORDER_BUY
ADD CONSTRAINT M_ID_FK FOREIGN KEY(ID)
REFERENCES ALL_MEMBER(ID);

--주문(구매)시퀀스 생성
CREATE SEQUENCE OBNUM_SEQ
START WITH 1
INCREMENT BY 1;
-----------------------------------------------------
--주문 상세 테이블

--주문 상세 테이블 드랍

DROP TABLE ORDER_DETAIL
CASCADE CONSTRAINTS;
--주문(상세) 시퀀스 드랍
DROP SEQUENCE ODNUM_SEQ;

CREATE TABLE ORDER_DETAIL
(
    ODNUM   NUMBER          NOT NULL,    --주문상세번호
    OBNUM    NUMBER          NOT NULL,    --주문번호
    PRODNUM  NUMBER          NOT NULL,     --상품번호 
    PRODNAME   VARCHAR2(50)    NOT NULL,     --상품이름
    QUANTITY   NUMBER          NULL,   --구매수량
  	PRICE        NUMBER          NULL,         --상품판매가격
  	COLOR         VARCHAR2(50)   NOT NULL,
    PRODOPTION      VARCHAR2(50)    NULL,
    FILENAME      VARCHAR2(50)   NOT NULL,

    WEIGHT       NUMBER            NULL,   --상품무게
    OBTAKEBACK   NUMBER   NULL,          --반품여부 반품 안할시 0-> 1
    OBEXCHANGE   NUMBER   NULL,
      REASON      VARCHAR2(50)  NULL,      --사유
    EXCOLORSEQ NUMBER NULL 	--교환 할, COLOR SEQ
);

INSERT INTO ORDER_DETAIL(ODNUM, OBNUM, PRODNUM, PRODNAME, QUANTITY , PRICE,COLOR, PRODOPTION, FILENAME, WEIGHT)
VALUES(ODNUM_SEQ.NEXTVAL, 22, 2, '편한의자', 3, 30000,'red',' ','filename', 10 );

INSERT INTO ORDER_DETAIL(ODNUM, OBNUM, PRODNUM, PRODNAME, QUANTITY,  PRICE,COLOR, PRODOPTION,FILENAME, WEIGHT)
VALUES(ODNUM_SEQ.NEXTVAL, 12, 1, '핫한의자', 2, 30000,'red',' ','filename',10);

INSERT INTO ORDER_DETAIL(ODNUM, OBNUM, PRODNUM, PRODNAME, QUANTITY, PRICE,COLOR, PRODOPTION,FILENAME, WEIGHT)
VALUES(ODNUM_SEQ.NEXTVAL, 12, 3, '기깔란책상', 2, 30000,'red',' ','filename', 10);

--주문번호에대한 주문디테일.상품정보 불러오기
SELECT a.PRODNUM, a.PRODNAME, a.QUANTITY, a.PRICE, a.DELIVERYCOST, a.WEIGHT
FROM ORDER_DETAIL a, ORDER_BUY b
WHERE a.OBNUM = b.OBNUM AND b.OBNUM=12




--상품번호 외래키생성
ALTER TABLE ORDER_DETAIL
ADD CONSTRAINT ORDER_DETAIL_FK FOREIGN KEY(PRODNUM)
REFERENCES PRODUCT(PRODNUM);
--구매번호 외래키생성
ALTER TABLE ORDER_DETAIL
ADD CONSTRAINT ORDER_DETAIL_FK2 FOREIGN KEY(OBNUM)
REFERENCES ORDER_BUY(OBNUM);


--주문(상세)시퀀스 생성
CREATE SEQUENCE ODNUM_SEQ
START WITH 1
INCREMENT BY 1;



--------------------------------------------------

--관리자 연령별 상품 구매 제일 많은 순
SELECT  d.BDATE, MAX(NCT), c.PRODNUM, c.prodname
FROM(SELECT CASE WHEN               age < 20 THEN '20세미만'
                    WHEN age >= 20 AND age < 30 THEN '20세이상 ~ 30세미만'
                    WHEN age >= 30 AND age < 40 THEN '30세이상 ~ 40세미만'
                    WHEN age >= 40 AND age < 50 THEN '40세이상 ~ 50세미만'
                    WHEN age >= 50 AND age < 60 THEN '50세이상 ~ 60세미만'
                    WHEN age >= 60              THEN '60세이상'
                END BDATE
          FROM (SELECT TRUNC((TO_CHAR(SYSDATE, 'YYYY') - SUBSTR(BDATE,1,4))) age, b.obnum
                  FROM ALL_MEMBER a, order_buy b
                  where a.id = b.id
                )
         ) d, ( SELECT COUNT(PRODNUM) as NCT , PRODNUM, PRODNAME  FROM ORDER_DETAIL  GROUP BY PRODNUM, PRODNAME) c
        
         
GROUP BY  d.BDATE, c.nct, c.PRODNUM, c.prodname
ORDER BY  d.BDATE ASC



-------------------------------------------------
--배송테이블(배송현황)

--배송테이블

--배송테이블 드랍

DROP TABLE DELIVERY_CHECK
CASCADE CONSTRAINTS;
--배송테이블 시퀀스 드랍
DROP SEQUENCE DCNUM_SEQ;

CREATE TABLE DELIVERY_CHECK
(
    DCNUM   NUMBER   NOT NULL,    --배송번호
    OBNUM    NUMBER   NOT NULL,    --주문번호F
    MEMID 	VARCHAR2(20)  NOT NULL,  --회원아이디
    STATUS    VARCHAR2(400)    NULL,    --배송상태
    ID       VARCHAR2(20)      NULL,    --배송라이더 아이디
    NAME     VARCHAR2(20)    NULL,    --배송라이더 이름
    PHONE    VARCHAR2(20)  NULL, --배송원 전화번호
    CHECKDATE DATE NULL --배송상태변경때마다 그정보에 대한 날짜 갱신
);

ALTER TABLE DELIVERY_CHECK ADD MEMID  VARCHAR2(20)  NULL;
--ALTER TABLE DELIVERY_CHECK MODIFY PHONE VARCHAR2(20);




INSERT INTO DELIVERY_CHECK(DCNUM,OBNUM, STATUS)
VALUES(DCNUM_SEQ.NEXTVAL, 10, '배송전')

INSERT INTO DELIVERY_CHECK(DCNUM,OBNUM, STATUS)
VALUES(DCNUM_SEQ.NEXTVAL, 13, '배송완료')


--주문번호 외래키생성
ALTER TABLE DELIVERY_CHECK
ADD CONSTRAINT OB_NUM_FK FOREIGN KEY(OBNUM)
REFERENCES ORDER_BUY(OBNUM);
--배송라이더아이디 외래키생성
ALTER TABLE DELIVERY_CHECK
ADD CONSTRAINT D_ID_FK FOREIGN KEY(ID)
REFERENCES ALL_MEMBER(ID);



--배송테이블(배송현황) 생성
CREATE SEQUENCE DCNUM_SEQ
START WITH 1
INCREMENT BY 1;

--------------------------------------------------
--리뷰테이블



--리뷰테이블 드랍

DROP TABLE REVIEW
CASCADE CONSTRAINTS;
--리뷰테이블 시퀀스 드랍
DROP SEQUENCE RNUMSEQ;

CREATE TABLE REVIEW(
    RNUM      NUMBER         NOT NULL,    --리뷰번호
    ID       VARCHAR2(50)      NOT NULL,    --회원아이디 
    PRODNUM NUMBER         NOT NULL,    --상품번호 
    STAR      NUMBER        NOT NULL ,   --별점 
    CONTENT VARCHAR2(1000)    NOT NULL,      --내용
    RDATE   DATE         NOT NULL,    --작성날짜
    IMAGE    VARCHAR2(100)   NULL,
    DEL      NUMBER         NULL
);
--회원아이디 외래키생성
ALTER TABLE REVIEW
ADD CONSTRAINT RE_M_ID_FK FOREIGN KEY(ID)
REFERENCES ALL_MEMBER(ID);
--상품번호 외래키생성
ALTER TABLE REVIEW
ADD CONSTRAINT RE_P_NUM_FK FOREIGN KEY(PRODNUM)
REFERENCES PRODUCT(PRODNUM);



—리뷰시퀀스 생성
CREATE SEQUENCE RNUMSEQ
START WITH 1
INCREMENT BY 1;

--------------------------------------------------------
— 컬러테이블 드랍
DROP TABLE COLOR
CASCADE CONSTRAINTS;

— 컬러테이블 시퀀스 드랍
DROP SEQUENCE COLORSEQ;

CREATE TABLE COLOR(
	COLORSEQ 	NUMBER			NOT NULL,
	PRODNUM		NUMBER			NOT NULL,
	COLOR		VARCHAR2(50)	NOT NULL,
	COLORFILENAME VARCHAR2(50)	NOT NULL,
	
	
	CONSTRAINT COLORSEQ PRIMARY KEY (COLORSEQ)
	
);

— 상품번호 외래키 생성
ALTER TABLE COLOR
ADD CONSTRAINT COLOR_FK FOREIGN KEY(PRODNUM)
REFERENCES PRODUCT(PRODNUM);

— 컬러시퀀스 생성
CREATE SEQUENCE COLORSEQ
START WITH 1
INCREMENT BY 1;

SELECT * FROM COLOR;


---------------------------------------------------------
--장바구니테이블

--장바구니테이블 드랍

DROP TABLE CART
CASCADE CONSTRAINTS;
--장바구니테이블 시퀀스 드랍
DROP SEQUENCE CNUMSEQ;


--컬러 컬럼 추가
CREATE TABLE CART
(
    CNUM   NUMBER         NOT NULL,    --장바구니&위시리스트번호
    ID   	 VARCHAR2(50)   NOT NULL,    --회원아이디 
    PRODNUM   NUMBER         NOT NULL,    --상품번호
    PRODNAME  VARCHAR2(50)   NOT   NULL ,   --상품이름 
    QUANTITY NUMBER   NOT  NULL,    --상품개수
    COLOR		VARCHAR2(50)	NOT NULL,	 --상품컬러
    CARTORWISH NUMBER  DEFAULT 0 NULL --장바구니&위시리스트구분
   
);
--회원아이디 외래키생성
ALTER TABLE CART
ADD CONSTRAINT CART_FK FOREIGN KEY(ID)
REFERENCES ALL_MEMBER(ID);

--상품번호 외래키생성
ALTER TABLE CART
ADD CONSTRAINT CART_FK2 FOREIGN KEY(PRODNUM)
REFERENCES PRODUCT(PRODNUM);


--장바구니시퀀스 생성
CREATE SEQUENCE CNUMSEQ
START WITH 1
INCREMENT BY 1;


----------------------------------------------
--커뮤니티 테이블

--커뮤니티 드랍

DROP TABLE COMMU
CASCADE CONSTRAINTS;
--커뮤니티 시퀀스 드랍
DROP SEQUENCE CMMUSEQ;

CREATE TABLE COMMU
(
    CMNUM   	NUMBER        	PRIMARY KEY,    --커뮤니티번호
    ID   		VARCHAR2(50)   	NOT NULL,    --회원아이디 
    IMAGE1   	VARCHAR2(2000)   	NULL,    --이미지등록1
    IMAGE2   	VARCHAR2(2000)   	NULL ,   --이미지등록2
    TITLE 		VARCHAR2(100) 	NOT NULL,    --제목
    CONTENT 	VARCHAR2(4000) 	NOT NULL,  --내용
    WDATE 		DATE 			NOT NULL, --작성날짜
    READCOUNT 	NUMBER  		NOT NULL, --조회수
    CMLIKE 		NUMBER 			NULL, --좋아요
  	COMMUDEL    NUMBER          NULL 
    
);
--회원아이디 외래키생성
ALTER TABLE COMMU
ADD CONSTRAINT COMMU_FK FOREIGN KEY(ID)
REFERENCES ALL_MEMBER(ID);


—커뮤니티시퀀스 생성
CREATE SEQUENCE CMMUSEQ
START WITH 1
INCREMENT BY 1;

SELECT * FROM commu;

----------------------------------------------
--댓글 테이블

--댓글 드랍

DROP TABLE ALL_COMMENT
CASCADE CONSTRAINTS;
--댓글 시퀀스 드랍
DROP SEQUENCE CTNUMSEQ;

CREATE TABLE ALL_COMMENT
(

	CTNUM NUMBER(8) PRIMARY KEY, --댓글번호
	CMNUM NUMBER(8) NOT NULL,  --커뮤니티 글번호
	ID VARCHAR2(50) NOT NULL, --회원 아이디
	WDATE DATE NOT NULL,  --댓글 작성일자
	CONTENT VARCHAR2(4000) NOT NULL , --댓글내용
	DEL		NUMBER			NULL


);
--회원아이디 외래키생성
ALTER TABLE ALL_COMMENT
ADD CONSTRAINT COMMENT_FK FOREIGN KEY(ID)
REFERENCES ALL_MEMBER(ID);

--커뮤니티 글 번호 외래키생성
ALTER TABLE ALL_COMMENT
ADD CONSTRAINT COMMENT_FK2 FOREIGN KEY(CMNUM)
REFERENCES COMMU(CMNUM);


--댓글시퀀스 생성
CREATE SEQUENCE CTNUMSEQ
START WITH 1
INCREMENT BY 1;


----------------------------------------------
--고객센터 테이블

--고객센터 드랍

DROP TABLE CS
CASCADE CONSTRAINTS;
--고객센터 시퀀스 드랍
DROP SEQUENCE CSNUMSEQ;

--CUSTOMER_SERVICES
CREATE TABLE CS
(
    CSNUM   NUMBER         NOT NULL,    --고객문의번호
    ID    VARCHAR2(50)   NOT NULL,    --회원아이디 
    REF   NUMBER  NOT NULL,    --글 그룹번호
    STEP   NUMBER NOT  NULL ,   --글 행번호
    DEPTH NUMBER NOT   NULL,    --글 깊이
    TITLE VARCHAR2(4000) NOT    NULL,  --제목
    CONTENT VARCHAR2(4000) NOT    NULL,  --내용
    WDATE DATE NOT NULL, --작성날짜
    CSDEL VARCHAR2(4000)     NULL,  --삭제여부
    READCOUNT   NUMBER  NOT NULL, --글 조회수
    CATEGORY VARCHAR2(50) NULL --카테고리
    
);
--회원아이디 외래키생성
ALTER TABLE CS
ADD CONSTRAINT CUSTOMER_S_FK FOREIGN KEY(ID)
REFERENCES ALL_MEMBER(ID);




--고객센터시퀀스 생성
CREATE SEQUENCE CSNUMSEQ
START WITH 1
INCREMENT BY 1;
------------------------------------------------------



--바이백서비스테이블



--바이백서비스테이블 드랍

DROP TABLE BUY_BACK
CASCADE CONSTRAINTS;
--바이백서비스테이블 시퀀스 드랍
DROP SEQUENCE BNUMSEQ;

SELECT * FROM BUY_BACK;


CREATE TABLE BUY_BACK
(
    BNUM            NUMBER         NOT NULL,    --바이백 신청 번호
    ID              VARCHAR2(50)   NOT NULL,    --회원아이디 
    CATEGORY        VARCHAR2(50)   NOT NULL,       --카테고리 선택
    SUBCATEGORY     VARCHAR2(50)   NOT   NULL ,        --서브 카테고리 선택
    PRODNUM         NUMBER         NOT    NULL,    --제품 고르기 (상품선택)
    PRICE           NUMBER         NOT    NULL, --제품 가격
    CONDITION       NUMBER   NOT NULL,  --제품 상태 (거의 새것 원가의:50%, 좋음 원가의:40%, 보통 원가의:30%)
    BDATE    VARCHAR2(50)   NOT  NULL,  --뽀이 방문날자
    BADDRESS VARCHAR2(100)  NOT   NULL,  --뽀이 방문위치
    BRESULT  VARCHAR2(20)     NULL,  --신청결과(진행절차) --여기서부턴 뽀이가 등록해서확인
    BID       VARCHAR2(20)    NULL,    --배정 배송라이더 아이디
    BNAME       VARCHAR2(20)    NULL,    --배정 배송라이더 이름
    BPHONE VARCHAR2(50) NULL --배정 배송라이더 전화번호
);

INSERT INTO BUY_BACK(BNUM,
  		 ID,
  		 CATEGORY,
  		 SUBCATEGORY,
  		 PRODNUM, 
  		 PRICE,
  		 CONDITION,
  		 BDATE,
  		 BADDRESS,
  		 BRESULT,
  		 BID,
  		 BNAME,
  		 BPHONE)
  		 VALUES(BNUMSEQ.NEXTVAL, 'sbi789','의자','이쁜의자', 1, 30000, 30, '2021-06-26','일산 식사동 5동 1205호',' ', ' ', ' ',''  )


  SELECT NVL(COUNT(*),0)
  FROM BUY_BACK a, ALL_MEMBER b
  WHERE a.ID = b.ID  AND 1=1
  AND a.BDATE LIKE '%'||2021-06||'%'		 
  		 

--보이 전화번호 데이터 타입 바꾸기
ALTER TABLE BUY_BACK MODIFY BPHONE VARCHAR2(50); 

--회원아이디 외래키생성
ALTER TABLE BUY_BACK
ADD CONSTRAINT BUY_BACK_FK FOREIGN KEY(ID)
REFERENCES ALL_MEMBER(ID);

--상품 외래키생성
ALTER TABLE BUY_BACK
ADD CONSTRAINT BUY_BACK_FK2 FOREIGN KEY(PRODNUM)
REFERENCES PRODUCT(PRODNUM);



--바이백시퀀스 생성
CREATE SEQUENCE BNUMSEQ
START WITH 1
INCREMENT BY 1;


------------------------------------------------------
--인테리어 테이블
--Interior

--바이백서비스테이블
--expert_users


--바이백서비스테이블 드랍

DROP TABLE EXPERT_USERS
CASCADE CONSTRAINTS;
--바이백서비스테이블 시퀀스 드랍
DROP SEQUENCE EXPERT_SEQ;

SELECT * FROM EXPERT_USERS;


CREATE TABLE EXPERT_USERS
(
    ENUM            NUMBER         NOT NULL,    --업체 신청 번호
    ID           VARCHAR2(50)   	NOT NULL,    --아이디 
    PWD          VARCHAR2(50)  	 NOT NULL,       --비밀번호
    NAME     VARCHAR2(50)   NOT   NULL ,        --이름
    NICKNAME     VARCHAR2(50)   NOT   NULL ,        --닉네임
    EMAIL        VARCHAR2(50)   NOT    NULL,    --이메일
    ADDRESS      VARCHAR2(100)  NOT    NULL, --주소
    BDATE        VARCHAR2(100)   NOT NULL,  --생년월일  
    PHONE    	VARCHAR2(50)   NOT  NULL,  -- 핸드폰번호
    
    EXPERTYPE  NUMBER NULL, --프리랜서 1 개인사업자 2 법인사업자 3
    IDCARD 			VARCHAR2(400)    NULL,  --신분증사진(프리랜서일경우)
    REGISTRATION  	VARCHAR2(400)     NULL,  --사업자등록증사진(개인사업자, 법인사업자)
    REGISNAME       VARCHAR2(50)    NULL,    --등록상호
    REGINUMBER       VARCHAR2(50)    NULL,    --사업자번호
    CEONAME 		VARCHAR2(50) NULL, --대표자명
    REGADDRESS		VARCHAR2(200) NULL, --사업장주소
    
    
    PART 	NUMBER NULL,			--시공분야 종합인테리어 1 , 도배 타일만 2
    EXPERTINFO      VARCHAR2(100) NULL, --업체소개
    IMAGE			 VARCHAR2(400) NULL,
    IMAGEDETAIL1	  VARCHAR2(400) NULL,
    IMAGEDETAIL2	  VARCHAR2(400) NULL,
    IMAGEDETAIL3	  VARCHAR2(400) NULL,
    RECENTCON NUMBER NULL,
    REVIEW  NUMBER NULL
    
);
--칼럼 데이터 변경
ALTER TABLE EXPERT_USERS MODIFY REGADDRESS VARCHAR2(200);
ALTER TABLE EXPERT_USERS ADD REVIEW  NUMBER NULL; --최근계약갯수

UPDATE EXPERT_USERS SET REGADDRESS = '서울특별시 양천구 신월동 962-10'
WHERE ENUM = 9


UPDATE EXPERT_USERS SET RECENTCON = 200
WHERE ENUM = 10

SELECT ENUM,      ID,      PWD,      NAME,      NICKNAME,            EMAIL,      ADDRESS,      BDATE,      PHONE,      EXPERTYPE,            IDCARD,      REGISTRATION,      REGISNAME,      REGINUMBER,      CEONAME,            REGADDRESS,      PART,      EXPERTINFO,      IMAGE,      IMAGEDETAIL1,      IMAGEDETAIL2,      IMAGEDETAIL3,      RECENTCON     FROM(SELECT ROW_NUMBER()OVER(ORDER BY ENUM DESC) AS RNUM,       ENUM,      ID,      PWD,      NAME,      NICKNAME,            EMAIL,      ADDRESS,      BDATE,      PHONE,      EXPERTYPE,            IDCARD,      REGISTRATION,      REGISNAME,      REGINUMBER,      CEONAME,            REGADDRESS,      PART,      EXPERTINFO,      IMAGE,      IMAGEDETAIL1,      IMAGEDETAIL2,      IMAGEDETAIL3,      RECENTCON           
FROM EXPERT_USERS     
WHERE 1=1                                    
ORDER BY ENUM DESC)                 
WHERE RNUM BETWEEN 1 AND 8
ORDER BY REGISNAME ASC



--시공업체 생성
CREATE SEQUENCE EXPERT_SEQ
START WITH 1
INCREMENT BY 1;

UPDATE EXPERT_USERS
SET REGISNAME='더큐디자인'
WHERE REGISNAME='더큐디자인스튜디오'



----
  select TO_CHAR(jdate, 'YYYYMM') as month,
 count(*) as count ,id
 from all_member 
 where jdate >='20210101' and jdate <=  to_char(sysdate + 1,'YYYYMMDD')
 GROUP BY to_char(jdate, 'YYYYMM'), id
----------------------------------------------

  SELECT BDATE 
     , NVL(COUNT(*), 0) as cnt
  FROM (SELECT CASE WHEN               age  < 20 THEN 'map1'
                    WHEN age >= 20 AND age  < 30 THEN 'map2'
                    WHEN age >= 30 AND age < 40 THEN 'map3'
                    WHEN age >= 40 AND age  <  50 THEN 'map4'
                    WHEN age >= 50 AND age  <  60 THEN 'map5'
                    WHEN age >= 60              THEN 'map6'
                END BDATE
          FROM (SELECT TRUNC((TO_CHAR(SYSDATE, 'YYYY') - SUBSTR(BDATE,1,4))) age
                  FROM ALL_MEMBER
                )
        )
 GROUP BY BDATE
 ORDER BY BDATE
 
 
    
SELECT BDATE
     , COUNT(*) cnt
  FROM (SELECT CASE WHEN               age < 20 THEN '20세미만'
                    WHEN age >= 20 AND age < 30 THEN '20세이상 ~ 30세미만'
                    WHEN age >= 30 AND age < 40 THEN '30세이상 ~ 40세미만'
                    WHEN age >= 40 AND age < 50 THEN '40세이상 ~ 50세미만'
                    WHEN age >= 50 AND age < 60 THEN '50세이상 ~ 60세미만'
                    WHEN age >= 60              THEN '60세이상'
                END BDATE
          FROM (SELECT TRUNC((TO_CHAR(SYSDATE, 'YYYY') - SUBSTR(BDATE,1,4))) age
                  FROM ALL_MEMBER
                )
        ) 
 GROUP BY BDATE
 ORDER BY BDATE
 
 
 DELETE FROM ALL_MEMBER
 WHERE ID='eyJhbGciOi'
 
 UPDATE ALL_MEMBER
 SET BDATE='0'
 WHERE ID='tGDTlX_Dg-';
 --------------------------------------------
--채팅 테이블

--채팅테이블 드랍

DROP TABLE CHAT
CASCADE CONSTRAINTS;
--고객센터 시퀀스 드랍
DROP SEQUENCE CHATSEQ;

--CUSTOMER_SERVICES
CREATE TABLE CHAT
(
    ROOMNUM   NUMBER         NOT NULL,    --채팅방번호
    SENDER    VARCHAR2(50)   NOT NULL,    --보낸이 
    CONTENT   NUMBER  NOT NULL,    --  보낸내용
    WDATE   NUMBER NOT  NULL, 	-- 보낸날짜
    SENDTYPE NUMBER NULL
  
    
);
--회원아이디 외래키생성
ALTER TABLE CHAT
ADD CONSTRAINT CHAT_FK FOREIGN KEY(SENDER)
REFERENCES ALL_MEMBER(ID);




--고객센터시퀀스 생성
CREATE SEQUENCE CSNUMSEQ
START WITH 1
INCREMENT BY 1;
------------------------------------------------------

----------------------------------------------
----- 좋아요 테이블

-- 테이블 드랍
DROP TABLE BOARDLIKE
CASCADE CONSTRAINTS;
-- 테이블 시퀀스 드랍
DROP SEQUENCE LNUM;

CREATE TABLE BOARDLIKE(
	LIKENUM	NUMBER			NOT NULL,		-- 좋아요seq
	CMNUM	NUMBER			NOT NULL,		-- 커뮤eq
	ID		VARCHAR2(50)	NOT NULL,		-- 멤버ID
	CONSTRAINT BOARDLIKE_PK PRIMARY KEY(LIKENUM)
);


-- 커뮤seq 외래키생성
ALTER TABLE BOARDLIKE
ADD CONSTRAINT BOARDLIKE_FK FOREIGN KEY(CMNUM)
REFERENCES COMMU(CMNUM);

-- 멤버seq 외래키생성
ALTER TABLE BOARDLIKE
ADD CONSTRAINT BOARDLIKE_FK2 FOREIGN KEY(ID)
REFERENCES ALL_MEMBER(ID);

-- 좋아요seq 생성
CREATE SEQUENCE LNUM
START WITH 1
INCREMENT BY 1;

---------------------------------------------
--채팅 방을 저장
DROP TABLE CHATROOM
CASCADE CONSTRAINTS;

SELECT * FROM CHATROOM;

CREATE TABLE CHATROOM(
	EXPERTNUM	NUMBER			NOT NULL,		-- 업체 번호
	ROOMNUM		NUMBER			NOT NULL,		-- 방번호
	ID		VARCHAR2(50)	NULL,		--보낸이
	MES		 VARCHAR2(50) NULL,	--메세지
	MESTYPE NUMBER NULL
	
);
---------------------------------------------