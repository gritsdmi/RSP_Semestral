INSERT INTO PUBLIC.USER(ID, USERNAME, EMAIL, PASSWORD,FULL_NAME, ACTIVE) VALUES
(1,'tourist', 'tourist@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','tourist tourist',  true),
(2,'delegate' , 'delegate@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','delegate delegate', true),
(3,'admin', 'admin@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','admin admin', true);


INSERT INTO PUBLIC.USERS_ROLES(USERID, ROLES) VALUES
(1, 'TOURIST'),
(2, 'DELEGATE'),
(3, 'ADMIN');

INSERT INTO DESTINATION(ID, COUNTRY, "NAME") VALUES
(1,'Turkey', 'Belek'),
(2,'Turkey', 'Kemer');

INSERT INTO HOTEL(ID,BREAKFAST_TIME, DINNER_TIME, ADDRESS, EMAIL, "NAME", PHONE_NUMBER, STARS, WEB, DESTINATION_ID) VALUES
(1, TIME '17:30:00.0',TIME '17:30:00.0', 'Steet 1', 'email@gmail.com', 'Hotel name', '777 777 777', 5, 'www.hotel.com', 1),
(2, TIME '17:30:00.0',TIME '17:30:00.0', 'Steet 2', 'email2@gmail.com', 'Hotel name 2', '111 111 111', 4, 'www.hotel2.com', 2),
(3, TIME '17:30:00.0',TIME '17:30:00.0', 'Steet 3', 'email3@gmail.com', 'Hotel name 3', '333 333 333', 4, 'www.hotel3.com', 2);

INSERT INTO TOUR(ID, DATE_FROM, DAT_TIL, DEPARTURE_FROM, DEPARTURE_TIME_END, DEPARTURE_TIME_START, DESCRIPTION, TOUR_TYPE,TRANSFER_TYPE, DELEGATE_ID, HOTEL_ID) VALUES
(1, '2020-10-10', '2020-10-20', 'Airport', '2020-10-20', '2020-10-20', 'Tour in Turkey', 'BEACH', 'PLANE', 2, 1),
(2, '2021-11-11', '2021-11-21', 'Airport', '2021-11-21', '2021-11-21', 'Tour in Turkey2', 'BEACH', 'BUS', 2, 2),
(3, '2023-01-01', '2020-01-20', 'Airport', '2023-01-01', '2023-01-01', 'Tour in Turkey3', 'BEACH', 'PLANE', 2, 3);

INSERT INTO PUBLIC.USER(ID, USERNAME, EMAIL, PASSWORD, FULL_NAME, ACTIVE, TOUR_ID) VALUES
(4, 'tourist1', 'tourist1@test.com' , '12345','tourist tourist',  true, 1);

INSERT INTO PUBLIC.USERS_ROLES(USERID, ROLES) VALUES
(4, 'TOURIST');