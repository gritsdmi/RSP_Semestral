INSERT INTO PUBLIC.USER(ID, USERNAME, EMAIL, PASSWORD,FULL_NAME, ACTIVE) VALUES
(1, 'tourist', 'tourist@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','tourist tourist',  true),
(2, 'delegate' , 'delegate@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','delegate delegate', true),
(3, 'admin', 'admin@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','admin admin', true);


INSERT INTO PUBLIC.USERS_ROLES(USERID, ROLES) VALUES
(1, 'TOURIST'),
(2, 'DELEGATE'),
(3, 'ADMIN');

INSERT INTO DESTINATION(ID, COUNTRY, "NAME") VALUES
(1, 'Indonesia', 'Bali'),
(2, 'Turkey', 'Belek'),
(3, 'Indonesia', 'Nulla pretium tincidunt'),
(4, 'USA', 'San Francisco'),
(5, 'France', 'Paris'),
(6, 'Phi Phi Island', 'Nulla pretium tincidunt'),
(7, 'Mykonos', 'Nulla pretium tincidunt'),
(8, 'Phi Phi Island', 'Nulla pretium tincidunt'),
(9, 'Turkey', 'Kemer');

INSERT INTO HOTEL(ID, BREAKFAST_TIME, DINNER_TIME,ADDRESS, EMAIL, "NAME", PHONE_NUMBER, STARS, WEB, DESTINATION_ID) VALUES
(1, TIME '17:30:00.0',TIME '17:30:00.0', 'Steet 1', 'email@gmail.com', 'Hotel name', '777 777 777', 5, 'www.hotel.com', 1),
(2, TIME '17:30:00.0',TIME '17:30:00.0', 'Steet 2', 'email2@gmail.com', 'Hotel name 2', '111 111 111', 4, 'www.hotel2.com', 2),
(3, TIME '17:30:00.0',TIME '17:30:00.0', 'Steet 3', 'email3@gmail.com', 'Hotel name 3', '333 333 333', 4, 'www.hotel3.com', 2);

INSERT INTO TOUR(ID, COUNTRY, CITY, DATE_FROM, DAT_TIL, DEPARTURE_FROM, DEPARTURE_TIME_END, DEPARTURE_TIME_START, DESCRIPTION, TOUR_TYPE,TRANSFER_TYPE, DELEGATE_ID, HOTEL_ID) VALUES
(1, 'Indonesia', 'Bali', '2020-10-10', '2020-10-20', 'Airport', '2020-10-20', '2020-10-20', 'Tour in Bali 1', 'BEACH', 'PLANE', 2, 1),
(2, 'France', 'Paris', '2021-11-11', '2021-11-21', 'Airport', '2021-11-21', '2021-11-21', 'Tour in France 2', 'BEACH', 'BUS', 2, 2),
(3, 'France', 'Paris', '2023-01-01', '2020-01-20', 'Airport', '2023-01-01', '2023-01-01', 'Tour in France 3', 'BEACH', 'PLANE', 2, 3),
(4, 'France', 'Paris', '2023-01-01', '2020-01-20', 'Airport', '2023-01-01', '2023-01-01', 'Tour in France 1', 'BEACH', 'PLANE', 2, 3),
(5, 'Indonesia', 'Bali', '2020-10-12', '2020-10-22', 'Airport', '2020-10-22', '2020-10-22', 'Tour in Bali 2', 'BEACH', 'PLANE', 2, 1),
(6, 'Indonesia', 'Bali', '2020-11-11', '2020-11-21', 'Airport', '2020-11-21', '2020-11-21', 'Tour in Bali 3', 'BEACH', 'PLANE', 2, 1),
(7, 'Indonesia', 'Bali', '2020-12-02', '2020-12-12', 'Airport', '2020-12-12', '2020-12-12', 'Tour in Bali 4', 'BEACH', 'PLANE', 2, 1);

INSERT INTO PUBLIC.USER(ID, USERNAME, EMAIL, PASSWORD, FULL_NAME, ACTIVE, TOUR_ID) VALUES
(4, 'tourist1', 'tourist1@test.com' , '12345','tourist tourist',  true, 1);

INSERT INTO PUBLIC.USERS_ROLES(USERID, ROLES) VALUES
(4, 'TOURIST');