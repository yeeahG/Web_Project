--client insert 주문자 저장 (손님사장구분번호, id, pw, 이름, 닉네임, 연락처, 주소)
insert into client values(0, 'admin', 'admin', '김사장', '피자사장', '010-1111-2222', '서울시 K PIZZA가게');
insert into client values(1, 'yeji_k', 'yeji0909', '김예지', '피자lover', '010-0909-0909', '서울시 송파구');
insert into client values(1, 'hyeono', 'son1234', '손현오', '피자한입만', '010-1234-5678', '서울시 강남구');
insert into client values(1, 'cheol_jun', 'ban11', '반철준', '배고파', '010-1122-3344', '서울시 용산구');
insert into client values(1, 'you_jini', '12345', '이유진', '유지니', '010-1234-1234', '서울시 관악구');
insert into client values(1, 'minimini', '0987', '박정민', '뭘로하지', '010-3453-1211', '서울시 동대문구');
insert into client values(1, 'id', '1234', '김혜지', '닉네임','010-1211-1211', '서울시 중구');

--menu insert 메뉴 저장 (음식id, 음식이름, 종류, 사이즈, 가격)
insert into menu values('pizza1', 'k 고구마 pizza', 'pizza', 18000);
insert into menu values('pizza2', 'k 치즈 pizza', 'pizza', 20000);
insert into menu values('pizza3', 'k 쉬림프 pizza', 'pizza', 24000);
insert into menu values('pizza4', '불고기 pizza', 'pizza', 22000);
insert into menu values('pizza5', '핫 치킨 pizza', 'pizza', 20000);
insert into menu values('pizza6', '갈비 pizza', 'pizza', 23000);
insert into menu values('pizza7', 'K 세트', 'pizza', 30000);
insert into menu values('pizza8', '반반 세트', 'pizza', 25000);

--추가주문으로만 가능한 음식
insert into menu values('drink1', '콜라', 'drink', 2000);
insert into menu values('drink2', '사이다', 'drink', 2000);
insert into menu values('side1', '갈릭소스', 'side', 2000);
insert into menu values('side2', '핫소스', 'side', 2000);
insert into menu values('side3', '오븐 파스타', 'side', 5000);
insert into menu values('side4', '감자튀김', 'side', 4000);


--order list 주문 내역 (시퀀스, 주문이름, 손님id, 피자id, 수량, 추가주문음식id, 수량, 총가격, 추가메세지)
insert into order_list values(order_list_id_seq.nextval, '주문1', 'yeji_k', 'pizza1,pizza2', 2, 'drink1,side1', 2, 42000, '문 앞에 놓아주세요');
insert into order_list values(order_list_id_seq.nextval, '주문2', 'you_jini', 'pizza7', 1, 'drink2', 1, 32000, ' ');
insert into order_list values(order_list_id_seq.nextval, '주문3', 'sonhyeono', 'pizza5', 1, 'side2', 1, 22000, '벨X');
insert into order_list values(order_list_id_seq.nextval, '주문4', 'minimini', 'pizza3', 1, 'drink1', 2, 26000, '빨리 와주세요');
insert into order_list values(order_list_id_seq.nextval, '주문5', 'cheol_jun', 'pizza2', 1, 'side1', 2, 24000, ' ');


commit;

