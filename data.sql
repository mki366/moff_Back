SELECT * FROM PRODUCT;
SELECT * FROM PRODUCT_IMG;
SELECT * FROM COMMU;
SELECT * FROM COMMENT;
SELECT * FROM BOARDLIKE;
SELECT * FROM COLOR;
SELECT * FROM BOARDLIKE;
SELECT * FROM cart;

 
 -- 결제  
INSERT INTO ORDER_BUY(OBNUM, ID, NAME, QUANTITY, PRICE, OBNAME, OBPHONE, OBADDRESS, OBMES, OBWAY, OBCARDN, OBDATE, OBTAKEBACK, OBEXCHANGE, DELIVERYCOST)
VALUES (OBNUM_SEQ.NEXTVAL, 'zzz', '이다솜', 1, 8700, 'LERBERG 레르베리', '010-9507-4414', '서울특별시 합정동 12-6 3동 202호', '배송전 문자좀 부탁드려요', '무통장입금', '신한은행', SYSDATE, 0, 0, 2500)

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
VALUES(PRODSEQ.NEXTVAL, '침대', '수납형침대', 'MALM 말름', 'brown', '없음', '침대 아래에 커다란 서랍 2개가 있어 충분한 수납 공간이 깔끔하게 숨겨져 있습니다. 이불, 베개, 침구 보관에 적합합니다.', 32, 210000, 190000, 100, SYSDATE, 10000, 'bed1.png', 0)

-- PRODUCT_IMG 상품이미지
INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 21, '높은침대프레임+수납상자2, 화이트스테인 참나무 무늬목/뢴세트150x200 cm', 'bed1-2.png');

-- COLOR 상품색상
INSERT INTO COLOR(COLORSEQ, PRODNUM, COLOR, COLORFILENAME)
VALUES(COLORSEQ, 상품번호, 컬러, 컬러이미지);
-----------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO PRODUCT (PRODNUM, CATEGORY, SUBCATEGORY, PRODNAME, COLOR, PRODOPTION, INFO, WEIGHT, ORIPRICE, PRICE, QUANTITY, RDATE, DELIVERYCOST, FILENAME, READCOUNT)
VALUES(PRODSEQ.NEXTVAL, '침대', '싱글/슈퍼싱글침대', 'SLATTUM 슬라툼', 'black', '없음', '부드러운 직조 패브릭으로 씌워져 있어 침실에 아늑한 느낌을 더해줍니다. 침대헤드는 늦은 밤 독서를 즐길 때 편안한 등받이가 되어줍니다. 더 좋은 점은 모든 것이 단일 패키지로 제공된다는 점입니다.', 28, 139000, 110000, 50, SYSDATE, 10000, 'bed2.png', 0)

-- PRODUCT_IMG 상품이미지
INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 22, '쿠션형 침대프레임, 크니사 라이트그레이120x200 cm', 'bed2-3.png');

-- COLOR 상품색상
INSERT INTO COLOR(COLORSEQ, PRODNUM, COLOR, COLORFILENAME)
VALUES(COLORSEQ.NEXTVAL, 22, 'gray', 'bed2-gray.png');
-----------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO PRODUCT (PRODNUM, CATEGORY, SUBCATEGORY, PRODNAME, COLOR, PRODOPTION, INFO, WEIGHT, ORIPRICE, PRICE, QUANTITY, RDATE, DELIVERYCOST, FILENAME, READCOUNT)
VALUES(PRODSEQ.NEXTVAL, '침대', '매트리스', 'VATNESTRÖM 바트네스트룀', 'brown', '없음', '천연 라텍스와 코코넛 섬유, 면, 양모 등의 천연 소재를 사용하여 편안하고 쾌적하며 침대 온도가 일정하게 유지됩니다.', 21, 710000, null, 50, SYSDATE, 10000, 'mat2.png', 0)

SELECT * FROM PRODUCT ORDER BY PRODNUM DESC;

-- PRODUCT_IMG 상품이미지
INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 24, '포켓스프링매트리스, 매우 단단함/내추럴120x200 cm', 'mat2-3.png');

-- COLOR 상품색상
INSERT INTO COLOR(COLORSEQ, PRODNUM, COLOR, COLORFILENAME)
VALUES(COLORSEQ.NEXTVAL, 24, 'gray', 'bed2-gray.png');
-----------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO PRODUCT (PRODNUM, CATEGORY, SUBCATEGORY, PRODNAME, COLOR, PRODOPTION, INFO, WEIGHT, ORIPRICE, PRICE, QUANTITY, RDATE, DELIVERYCOST, FILENAME, READCOUNT)
VALUES(PRODSEQ.NEXTVAL, '침대', '기타', 'SUNDVIK 순드비크(유아용침대)', 'white', '없음', '침대 베이스의 통기성이 뛰어나고 공기 순환이 잘 되기 때문에 아기가 쾌적한 환경에서 잘 수 있습니다.', 11, 110000, null, 80, SYSDATE, 10000, 'bed6.png', 0)

SELECT * FROM PRODUCT ORDER BY PRODNUM DESC;

-- PRODUCT_IMG 상품이미지
INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 28, '유아용침대, 화이트60x120 cm', 'bed6-3.png');

-----------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO PRODUCT (PRODNUM, CATEGORY, SUBCATEGORY, PRODNAME, COLOR, PRODOPTION, INFO, WEIGHT, ORIPRICE, PRICE, QUANTITY, RDATE, DELIVERYCOST, FILENAME, READCOUNT)
VALUES(PRODSEQ.NEXTVAL, '침대', '수납형침대', 'HEMNES 헴네스', 'gray', '없음', '데이베드는 두 개의 매트리스(80x200)를 사용해 결합해야 합니다. 데이베드를 싱글침대로 사용할 때는 서로 겹쳐서 놓고 더블침대로 사용할 때는 서로 나란히 놓습니다.', 32, 270000, 237000, 180, SYSDATE, 10000, 'bed5.png', 0)

SELECT * FROM PRODUCT ORDER BY PRODNUM DESC;

-- PRODUCT_IMG 상품이미지
INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 27, '데이베드프레임+서랍3, 그레이80x200 cm', 'bed5-3.png');

-- COLOR 상품색상
INSERT INTO COLOR(COLORSEQ, PRODNUM, COLOR, COLORFILENAME)
VALUES(COLORSEQ.NEXTVAL, 26, 'green', 'bed4-green.png');
-----------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO PRODUCT (PRODNUM, CATEGORY, SUBCATEGORY, PRODNAME, COLOR, PRODOPTION, INFO, WEIGHT, ORIPRICE, PRICE, QUANTITY, RDATE, DELIVERYCOST, FILENAME, READCOUNT)
VALUES(PRODSEQ.NEXTVAL, '쇼파', '패브릭쇼파', 'GRÖNLID 그뢴리드', 'red', '없음', '몸을 푹 파묻으면 따스하게 감싸주는 느낌으로 밤에는 아늑하게 낮에는 느긋하게 기분 좋은 시간을 보낼 수 있습니다. 크기가 매우 넉넉하고 푹신하며 등받이쿠션을 옮길 수 있어 편리한 소파입니다. 크기와 모양이 다양하게 제공되고 편안함을 느끼게 해주는 모든 요소를 갖추고 있습니다.', 51, 799000, 741000, 40, SYSDATE, 30000, 'sofa1.png', 0)

SELECT * FROM PRODUCT ORDER BY PRODNUM DESC;

-- PRODUCT_IMG 상품이미지
INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 29, '커버는 분리하여 물세탁이 가능하기 때문에 오랫동안 깨끗하게 사용할 수 있습니다.', 'sofa1-3.png');

-- COLOR 상품색상
INSERT INTO COLOR(COLORSEQ, PRODNUM, COLOR, COLORFILENAME)
VALUES(COLORSEQ.NEXTVAL, 29, 'green', 'sofa1-green.png');

-----------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO PRODUCT (PRODNUM, CATEGORY, SUBCATEGORY, PRODNAME, COLOR, PRODOPTION, INFO, WEIGHT, ORIPRICE, PRICE, QUANTITY, RDATE, DELIVERYCOST, FILENAME, READCOUNT)
VALUES(PRODSEQ.NEXTVAL, '쇼파', '천연/인조가죽쇼파', 'GRÖNLID 그뢴리드', 'brown', '없음', 'GRÖNLID/그뢴리드 소파는 쿠션 상단 한 층을 섬유볼로 채운 넉넉한 크기의 시트쿠션과 편안한 등받이쿠션을 충분히 갖추어 푹신하고 기분 좋게 앉을 수 있습니다.', 57, 1849000, 1710000, 10, SYSDATE, 50000, 'sofa4.png', 0)

SELECT * FROM PRODUCT ORDER BY PRODNUM DESC;

-- PRODUCT_IMG 상품이미지
INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 31, '긴의자는 좌우 어디에든 놓을 수 있고 언제든지 위치를 바꿀 수 있습니다.', 'sofa4-3.png');

-- COLOR 상품색상
INSERT INTO COLOR(COLORSEQ, PRODNUM, COLOR, COLORFILENAME)
VALUES(COLORSEQ.NEXTVAL, 29, 'green', 'sofa1-green.png');

-----------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO PRODUCT (PRODNUM, CATEGORY, SUBCATEGORY, PRODNAME, COLOR, PRODOPTION, INFO, WEIGHT, ORIPRICE, PRICE, QUANTITY, RDATE, DELIVERYCOST, FILENAME, READCOUNT)
VALUES(PRODSEQ.NEXTVAL, '쇼파', '천연/인조가죽쇼파', 'VIMLE 빔레', 'orange', '없음', '오래도록 사용할 수 있는 부드럽고 아늑한 소파입니다. 고탄성폼을 넣어 제작한 시트쿠션이 몸을 편안하게 지지해주고, 복원력 또한 탁월합니다.', 47, 880000, null, 50, SYSDATE, 20000, 'sofa5.png', 0)

SELECT * FROM PRODUCT ORDER BY PRODNUM DESC;

-- PRODUCT_IMG 상품이미지
INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 32, ' 등받이 부분이 확장되어 목을 안정적으로 받쳐주기 때문에 더욱 편안하게 앉을 수 있습니다.', 'sofa5-2.png');

-- COLOR 상품색상
INSERT INTO COLOR(COLORSEQ, PRODNUM, COLOR, COLORFILENAME)
VALUES(COLORSEQ.NEXTVAL, 32, 'black', 'sofa5-black.png');

-----------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO PRODUCT (PRODNUM, CATEGORY, SUBCATEGORY, PRODNAME, COLOR, PRODOPTION, INFO, WEIGHT, ORIPRICE, PRICE, QUANTITY, RDATE, DELIVERYCOST, FILENAME, READCOUNT)
VALUES(PRODSEQ.NEXTVAL, '책장', '책장', 'LACK 라크', 'brown', '없음', '벽 공간을 최대한 활용해보세요. 공간은 적게 차지하고 다양한 물건을 수납할 수 있습니다.', 14, 69700, 65000, 150, SYSDATE, 0, 'bookcase2.png', 0)

SELECT * FROM PRODUCT ORDER BY PRODNUM DESC;

-- PRODUCT_IMG 상품이미지
INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 49, '벽선반유닛, 화이트30x190 cm', 'bookcase2-2.png');

-- COLOR 상품색상
INSERT INTO COLOR(COLORSEQ, PRODNUM, COLOR, COLORFILENAME)
VALUES(COLORSEQ.NEXTVAL, 49, 'black', 'bookcase2-black.png');

-----------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO PRODUCT (PRODNUM, CATEGORY, SUBCATEGORY, PRODNAME, COLOR, PRODOPTION, INFO, WEIGHT, ORIPRICE, PRICE, QUANTITY, RDATE, DELIVERYCOST, FILENAME, READCOUNT)
VALUES(PRODSEQ.NEXTVAL, '책장', '수납선반/유닛', 'IVAR 이바르', 'ivory', '없음', '무가공 원목은 내구성이 뛰어난 천연소재로 오일이나 왁스를 칠하면 내구성이 높아지고 관리도 편해집니다.', 2, 37000, null, 250, SYSDATE, 0, 'bk4.png', 0)

SELECT * FROM PRODUCT ORDER BY PRODNUM DESC;

-- PRODUCT_IMG 상품이미지
INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 50, '선반유닛+선반/서랍/레일174x50x124 cm', 'bk4-3.png');

-- COLOR 상품색상
INSERT INTO COLOR(COLORSEQ, PRODNUM, COLOR, COLORFILENAME)
VALUES(COLORSEQ.NEXTVAL, 50, 'green', 'bk4-green.png');

-----------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO PRODUCT (PRODNUM, CATEGORY, SUBCATEGORY, PRODNAME, COLOR, PRODOPTION, INFO, WEIGHT, ORIPRICE, PRICE, QUANTITY, RDATE, DELIVERYCOST, FILENAME, READCOUNT)
VALUES(PRODSEQ.NEXTVAL, '책장', '수납선반/유닛', 'OMAR 오마르', 'gray', '없음', 'OMAR/오마르 선반을 달면 평범한 팬트리도 전문 주방의 분위기가 느껴집니다. 그러나 주방에서만 근사한 것이 아니라 집안 어디에 설치해도 똑같이 잘 어울리는 제품입니다. 섹션을 추가하여 선반을 원하는 높이로 조정할 수 있습니다.', 1, 45000, null, 70, SYSDATE, 0, 'bk5.png', 0)

SELECT * FROM PRODUCT ORDER BY PRODNUM DESC;

-- PRODUCT_IMG 상품이미지
INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 51, 'OMAR 오마르 수납시스템은 조립이 간편하고, 어떤 물건을 보관하든 한눈에 확인하고 꺼낼 수 있어요.', 'bk5-2.png');

INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 51, '다리받침의 높이를 조절할 수 있어서 고르지 않은 바닥에도 안정적으로 세울 수 있습니다.', 'bk5-1.png');

INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 51, '선반섹션2211x36x94 cm', 'bk5-3.png');

-- COLOR 상품색상
INSERT INTO COLOR(COLORSEQ, PRODNUM, COLOR, COLORFILENAME)
VALUES(COLORSEQ.NEXTVAL, 51, 'green', 'bk4-green.png');

-----------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO PRODUCT (PRODNUM, CATEGORY, SUBCATEGORY, PRODNAME, COLOR, PRODOPTION, INFO, WEIGHT, ORIPRICE, PRICE, QUANTITY, RDATE, DELIVERYCOST, FILENAME, READCOUNT)
VALUES(PRODSEQ.NEXTVAL, '식탁/책상', '식탁', 'RÅVA 로바', 'brown', '없음', 'RÅVAROR 로바로르 테이블은 대부분의 스타일과 의자에 어울리는 자연스럽고 따스한 느낌을 줍니다. 높이와 폭 또는 가로 길이가 모두 같아서 조립과 분해, 재조립, 조합이 쉽습니다.', 22, 120000, 99000, 10, SYSDATE, 0, 'd5.png', 0)

SELECT * FROM PRODUCT ORDER BY PRODNUM DESC;

-- PRODUCT_IMG 상품이미지
INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 83, '각각의 다리에 하나의 부속품만 사용하므로 조립과 분해, 재조립이 간편합니다.', 'd5-1.png');

INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 83, '참나무 베니어 소재의 테이블 표면과 참나무 원목 소재의 다리가 실내에 따스하고 자연스러운 느낌을 더해 줍니다.', 'd5-2.png');

INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 83, '식탁, 참나무무늬목130x78 cm', 'd5-3.png');

-- COLOR 상품색상
INSERT INTO COLOR(COLORSEQ, PRODNUM, COLOR, COLORFILENAME)
VALUES(COLORSEQ.NEXTVAL, 64, 'brown', 'd4-brown.png');

-----------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO PRODUCT (PRODNUM, CATEGORY, SUBCATEGORY, PRODNAME, COLOR, PRODOPTION, INFO, WEIGHT, ORIPRICE, PRICE, QUANTITY, RDATE, DELIVERYCOST, FILENAME, READCOUNT)
VALUES(PRODSEQ.NEXTVAL, '의자', '식탁의자', 'VOXLÖV 복슬뢰브', 'brown', '없음', '의자는 가정용으로 적합 판정을 받았으며 EN 12520 및 EN 1022의 내구성과 안전성 기준에 부합하는 제품입니다.', 7, 49000, 32000, 50, SYSDATE, 0, 'c6.png', 0)

SELECT * FROM PRODUCT ORDER BY PRODNUM DESC;

-- PRODUCT_IMG 상품이미지
INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 115, '대나무는 천연 섬유이며 시간이 지나면 색이 변할 수도 있습니다.', 'c6-1.png');

INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 115, '실내에서만 사용하세요.', 'c6-2.png');

INSERT INTO PRODUCT_IMG(PINUM, PRODNUM, INFO, IMG_FILENAME)
VALUES(PINUM_SEQ.NEXTVAL, 115, '의자/라이트 대나무, 57x11 cm', 'c6-3.png');

-- COLOR 상품색상
INSERT INTO COLOR(COLORSEQ, PRODNUM, COLOR, COLORFILENAME)
VALUES(COLORSEQ.NEXTVAL, 110, 'black', 'c3-black.png');

INSERT INTO COLOR(COLORSEQ, PRODNUM, COLOR, COLORFILENAME)
VALUES(COLORSEQ.NEXTVAL, 110, 'blue', 'c3-blue.png');

INSERT INTO COLOR(COLORSEQ, PRODNUM, COLOR, COLORFILENAME)
VALUES(COLORSEQ.NEXTVAL, 108, 'green', 'c3-green.png');

INSERT INTO COLOR(COLORSEQ, PRODNUM, COLOR, COLORFILENAME)
VALUES(COLORSEQ.NEXTVAL, 108, 'pink', 'c3-pink.png');
-----------------------------------------------------------------------------------------------------------------------------------------------------------------

select * from PRODUCT_IMG where prodnum=104;
select * from color where prodnum=107;

delete from color where colorseq=66 and colorseq=66;
delete from product_img where pinum=106;
delete from product where prodnum=99;



UPDATE ALL_MEMBER
SET MEMBERTYPE=2
WHERE ID='admin';

select *
from all_member
where id='admin'





-- COMMUNITY 커뮤니티
INSERT INTO COMMU(CMNUM, ID, IMAGE1, IMAGE2, TITLE, CONTENT, READCOUNT, CMLIKE, COMMUDEL)
VALUES(CMMUSEQ.NEXTVAL, 아이디, 이미지1, 이미지2, 제목, 내용, 0, 0, 0)

-- COMMENT 댓글
INSERT INTO COMMENT(CTNUM, CMNUM, ID, WDATE, CONTENT, DEL)
VALUES(CTNUMSEQ.NEXTVAL, 글번호, 아이디, SYSDATE, 내용, 0)

-- LIKE 좋아요
INSERT INTO BOARDLIKE(LIKENUM, CMNUM, ID)
VALUES(LNUM.NEXTVAL, 글번호, 아이디)