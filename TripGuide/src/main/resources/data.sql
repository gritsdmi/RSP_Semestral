-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO PUBLIC.USER(ID, USERNAME, EMAIL, PASSWORD,FULL_NAME, ACTIVE) VALUES
(1, 'tourist', 'tourist@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','tourist tourist',  true),
(2, 'delegate' , 'delegate@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','delegate delegate', true),
(3, 'admin', 'admin@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','admin admin', true),
(4, 'tourist1', 'tourist1@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','tourist tourist',  true);


INSERT INTO PUBLIC.USERS_ROLES(USERID, ROLES) VALUES
(1, 'TOURIST'),
(2, 'DELEGATE'),
(3, 'ADMIN'),
(4, 'TOURIST');

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

INSERT INTO HOTEL(ID, BREAKFAST_TIME_FROM ,BREAKFAST_TIME_TO, DINNER_TIME_FROM, DINNER_TIME_TO,ADDRESS, EMAIL, "NAME", PHONE_NUMBER, STARS, WEB, DESTINATION_ID) VALUES
(1, TIME '9:30:00.0',TIME '12:30:00.0', TIME '13:30:00.0', TIME '15:30:00.0', 'Steet 1', 'email@gmail.com', 'Hotel name', '777 777 777', 5, 'www.hotel.com', 1),
(2, TIME '9:30:00.0',TIME '12:30:00.0', TIME '13:30:00.0', TIME '15:30:00.0', 'Steet 2', 'email2@gmail.com', 'Hotel name 2', '111 111 111', 4, 'www.hotel2.com', 2),
(3, TIME '9:30:00.0',TIME '12:30:00.0', TIME '13:30:00.0', TIME '15:30:00.0', 'Steet 3', 'email3@gmail.com', 'Hotel name 3', '333 333 333', 4, 'www.hotel3.com', 2);

INSERT INTO TOUR(ID, COUNTRY, CITY, DATE_TIME_FROM, DATE_TIME_TIL, DEPARTURE_FROM, DEPARTURE_DATE_TIME,  ARRIVAL_DATE_TIME, DESCRIPTION, TOUR_TYPE,TRANSFER_TYPE, DELEGATE_ID, HOTEL_ID) VALUES
(1, 'Indonesia', 'Bali', '2020-04-2T12:30:00', '2020-04-10T13:30:00', 'Airport', '2020-04-01T00:00:00','2020-04-02T11:00:00', 'Tour in Bali 1', 'BEACH', 'PLANE', 2, 2),
(2, 'France', 'Paris', '2020-04-12T12:30:00', '2020-04-16T13:30:00', 'Airport', '2020-04-11T00:00:00','2020-04-12T11:00:00', 'Tour in France 2', 'BEACH', 'BUS', 2, 2),
(3, 'Ukraine', 'Uzhhorod', '2020-04-15T12:30:00', '2020-04-28T13:30:00', 'Airport', '2020-04-14T00:00:00','2020-04-15T11:00:00', 'Tour in France 3', 'BEACH', 'PLANE', 2, 3),
(4, 'France', 'Paris', '2020-04-4T12:30:00', '2020-04-17T13:30:00', 'Airport', '2020-05-01T14:00:00','2020-05-01T14:00:00', 'Tour in France 1', 'BEACH', 'PLANE', 2, 3),
(5, 'Indonesia', 'Bali', '2020-04-5T12:30:00', '2020-04-17T13:30:00', 'Airport', '2020-05-01T14:00:00','2020-05-01T14:00:00', 'Tour in Bali 2', 'BEACH', 'PLANE', 2, 2),
(6, 'Indonesia', 'Bali', '2020-04-6T12:30:00', '2020-04-17T13:30:00', 'Airport', '2020-05-01T14:00:00','2020-05-01T14:00:00','Tour in Bali 3', 'BEACH', 'PLANE', 2, 2),
(7, 'Indonesia', 'Bali', '2020-04-7T12:30:00', '2020-04-17T13:30:00', 'Airport', '2020-04-07T06:00:00','2020-04-07T11:00:00', 'Tour in Bali 4', 'BEACH', 'PLANE', 2, 1);

INSERT INTO PUBLIC.TOUR_USERS VALUES (1,1),(2,1),(3,1);

INSERT INTO EXCURSION (ID, DATE_TIME_FROM, DATE_TIME_TILL, ARRIVAL_DATE_TIME, DEPARTURE_DATE_TIME, DESCRIPTION, "NAME", PRICE, TRANSFER_NEEDED) VALUES
(1,'2020-04-3T13:30:00','2020-04-3T20:30:00', '2020-04-03T12:30:00','2020-04-03T10:30:00',  'Get the best views in Bali with an early-morning hike up Mount Batur volcano with breakfast included. An unforgettable sunrise awaits you at the top.','Sunrise Mount Batur Hike with Breakfast', 100, true),
(2,'2020-04-5T7:30:00','2020-04-5T21:30:00', '2020-04-05T6:00:00','2020-04-05T5:00:00', 'Watch the sunrise from the top of Mount Batur on an early morning hike up Bali''s most emblematic mountain. Experience the stunning views from the active volcano near the village of Kintamani, and learn more about the region from a local private guide.', 'Mount Batur Sunrise Hike and Natural Hot Spring', 100, false),
(3,'2020-04-22T13:30:00','2020-04-28T13:30:00', '2020-04-01T13:00:00','2020-04-07T20:00:00', 'Take a private tour of Bali''s most iconic sights that you always see on postcards and Instagram! Snap photos and experience the beauty in the North. ', 'Northern Charm: Lake Bratan, Handara Gate, Waterfall & Swing', 100, false),
(4,'2020-04-22T13:30:00','2020-04-28T13:30:00', '2020-04-01T13:00:00','2020-04-07T20:00:00',  'Experience Bali according to your interests on a customizable full-day tour, and choose what you want to see and do with a licensed guide. Marvel at the rice terraces surrounding Ubud, or take part in water sports activities.', 'Best of Bali: Private Customized Full-Day Tour', 100, false);

INSERT INTO EXCURSION_TOURS VALUES (1, 1),(2,1),(3,3),(4,2);

INSERT INTO MESSAGE (ID, TEXT, TOUR_ID, CREATEDAT) VALUES
(1, 'Hi, Im your delegate!', 2, '2020-04-22T13:30:00'),
(2, 'asasas', 2, '2020-04-22T13:30:00');

INSERT INTO EVENT (ID, REGULAR, START, END, TITLE, TYPE, TOUR_ID) VALUES
(1, false, '2020-04-22T13:30:00','2020-04-28T13:30:00', 'Title', 'INCIDENT', 2 );