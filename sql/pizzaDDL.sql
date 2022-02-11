-- 사용자(고객) 정보
DROP TABLE client cascade constraint;

-- 메뉴 정보
DROP TABLE menu cascade constraint;

-- 주문 내역
DROP TABLE order_list cascade constraint;
DROP SEQUENCE order_list_id_seq;


--client insert 주문자 저장 (손님사장구분번호, id, pw, 이름, 닉네임, 연락처, 주소)
CREATE table client (
       sort_no              NUMBER(5) NOT NULL,  
       client_id          	VARCHAR2(20)  PRIMARY KEY,
       password         	VARCHAR2(20) NOT NULL,
       name               	VARCHAR2(20) NOT NULL,
       nickname             VARCHAR2(20) NOT NULL,
       contact             VARCHAR2(20) NOT NULL,
       address             VARCHAR2(30) NOT NULL
);


--menu insert 메뉴 저장 (음식id, 음식이름, 종류, 사이즈, 가격)
CREATE table menu (
       food_id          	VARCHAR2(20) PRIMARY KEY,
       food_name          	VARCHAR2(20) NOT NULL,
       sort		            VARCHAR2(20) NOT NULL,
       price		        NUMBER(5) NOT NULL
);


--order list 주문 내역 (시퀀스, 주문이름, 손님id, 피자id, 수량, 추가주문음식id, 수량, 총가격, 추가메세지)
CREATE SEQUENCE order_list_id_seq;
CREATE table order_list (
       order_list_id        NUMBER(5)  PRIMARY KEY,
       order_list_name      VARCHAR2(20) NOT NULL,
       client_id            VARCHAR2(20) NOT NULL,
       food_id	         	VARCHAR2(20) NOT NULL,
       food_quantity        NUMBER(1) 	NOT NULL,
       food_id2	         	VARCHAR2(20) NOT NULL,
       food2_quantity       NUMBER(2) 	NOT NULL,
       total_price 			NUMBER(7) NOT NULL,
       message              VARCHAR2(30) NOT NULL
);


ALTER TABLE order_list  ADD FOREIGN KEY (client_id) REFERENCES client  (client_id);
ALTER TABLE order_list ADD FOREIGN KEY (food_id)  REFERENCES menu  (food_id);

