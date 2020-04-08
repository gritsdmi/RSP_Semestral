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
(3, 'Indonesia', 'Sumatra'),
(4, 'USA', 'San Francisco'),
(5, 'France', 'Paris'),
(6, 'Thailand', 'Phuket'),
(7, 'Greece', 'Mykonos'),
(8, 'Thailand', 'Pattaya'),
(9, 'Turkey', 'Kemer');

INSERT INTO LOCAL_ATTRACTION(ID, NAME, DESCRIPTION, ADDRESS, FREE, DESTINATION_ID) VALUES
(1, 'Golden Gate Bridge', 'The Golden Gate Bridge is a California icon gracing San Francisco Bay. It is the most photographed site in the city, with the orange structure backed by blue water, or in many cases, peaking through low lying cloud.', 'Golden Gate Bridge, San Francisco, CA, USA', TRUE, 4),
(2, 'Alcatraz Island', 'The historic and notorious Alcatraz penitentiary, located on Alcatraz Island in San Francisco Bay, is one of America''s most infamous prisons. It operated for almost thirty years, closing in 1963 and re-opening as a tourist attraction in 1973.', 'San Francisco, CA 94133, USA', FALSE , 4),
(3, 'Fisherman''s Wharf', 'Fisherman''s Wharf is one of San Francisco''s most popular tourist areas. If this is your first visit to the city and you only have a day or two to see the sights, Fisherman''s Wharf is one of the best places to visit', 'San Francisco, CA 94133, USA', FALSE , 4),
(4, 'Chinatown', 'You may have been to Chinatown in other cities, but San Francisco''s Chinatown is a whole other realm. It is both the largest Chinatown outside of Asia and the oldest of its kind in North America.', 'San Francisco, CA 94133, USA', FALSE , 4);

INSERT INTO HOTEL(ID, BREAKFAST_TIME, DINNER_TIME,ADDRESS, EMAIL, "NAME", PHONE_NUMBER, STARS, WEB, DESTINATION_ID) VALUES
(1, TIME '17:30:00.0',TIME '17:30:00.0', 'Steet 1', 'email@gmail.com', 'Hotel name', '777 777 777', 5, 'www.hotel.com', 1),
(2, TIME '17:30:00.0',TIME '17:30:00.0', 'Steet 2', 'email2@gmail.com', 'Hotel name 2', '111 111 111', 4, 'www.hotel2.com', 2),
(3, TIME '17:30:00.0',TIME '17:30:00.0', 'Steet 3', 'email3@gmail.com', 'Hotel name 3', '333 333 333', 4, 'www.hotel3.com', 2);

INSERT INTO TOUR(ID, DATE_FROM, DAT_TIL, DEPARTURE_FROM, DEPARTURE_TIME_END, DEPARTURE_TIME_START, DESCRIPTION, TOUR_TYPE,TRANSFER_TYPE, DELEGATE_ID, HOTEL_ID) VALUES
(1, '2020-10-10', '2020-10-20', 'Airport', '2020-10-20', '2020-10-20', 'Bali tour', 'BEACH', 'PLANE', 2, 1),
(2, '2021-11-11', '2021-11-21', 'Airport', '2021-11-21', '2021-11-21', 'Tour in Turkey2', 'BEACH', 'BUS', 2, 2),
(3, '2023-01-01', '2020-01-20', 'Airport', '2023-01-01', '2023-01-01', 'Tour in Turkey3', 'BEACH', 'PLANE', 2, 3);

INSERT INTO PUBLIC.USER(ID, USERNAME, EMAIL, PASSWORD, FULL_NAME, ACTIVE, TOUR_ID) VALUES
(4, 'tourist1', 'tourist1@test.com' , '12345','tourist tourist',  true, 1);

INSERT INTO PUBLIC.USERS_ROLES(USERID, ROLES) VALUES
(4, 'TOURIST');

INSERT INTO EXCURSION (ID, ARRIVAL_TIME, DATE_FROM, DATE_TILL, DEPARTURE_TIME, DESCRIPTION, NAME, PRICE, TRANSFER_NEEDED) VALUES
(1, '2020-10-10', '2020-10-10', '2020-10-10', '2020-10-10', 'Get the best views in Bali with an early-morning hike up Mount Batur volcano with breakfast included. An unforgettable sunrise awaits you at the top.','Sunrise Mount Batur Hike with Breakfast', 100, true),
(2, null, '2020-10-10', '2020-10-10', null, 'Watch the sunrise from the top of Mount Batur on an early morning hike up Bali''s most emblematic mountain. Experience the stunning views from the active volcano near the village of Kintamani, and learn more about the region from a local private guide.', 'Mount Batur Sunrise Hike and Natural Hot Spring', 100, false),
(3, null, '2020-10-10', '2020-10-10', null, 'Take a private tour of Bali''s most iconic sights that you always see on postcards and Instagram! Snap photos and experience the beauty in the North. ', 'Northern Charm: Lake Bratan, Handara Gate, Waterfall & Swing', 100, false),
(4, null, '2020-10-10', '2020-10-10', null, 'Experience Bali according to your interests on a customizable full-day tour, and choose what you want to see and do with a licensed guide. Marvel at the rice terraces surrounding Ubud, or take part in water sports activities.', 'Best of Bali: Private Customized Full-Day Tour', 100, false);

INSERT into EXCURSION_TOURS VALUES (1, 1),(2,1),(3,1),(4,1);