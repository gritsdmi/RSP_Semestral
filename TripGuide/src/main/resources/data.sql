-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO PUBLIC.USER(ID, USERNAME, EMAIL, PASSWORD,FULL_NAME, ACTIVE) VALUES
(1, 'tourist', 'tourist@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','tourist tourist',  true),
(2, 'tourist2', 'tourist1@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','tourist tourist',  true),
(3, 'delegate' , 'delegate@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','delegate delegate', true),
(4, 'admin', 'admin@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','admin admin', true);

INSERT INTO PUBLIC.USERS_ROLES(USERID, ROLES) VALUES
(1, 'TOURIST'),
(2, 'TOURIST'),
(3, 'DELEGATE'),
(4, 'ADMIN');

INSERT INTO DESTINATION(ID, COUNTRY, "NAME") VALUES
(1, 'Indonesia', 'Bali'),
(2, 'Indonesia', 'Lombok'),
(3, 'Turkey', 'Belek'),
(4, 'Turkey', 'Istanbul'),
(5, 'Ukraine', 'Lviv'),
(6, 'Ukraine', 'Uzhhorod'),
(7, 'USA', 'San Francisco'),
(8, 'USA', 'New York'),
(9, 'France', 'Paris'),
(10, 'France', 'Marseille'),
(11, 'Thailand', 'Phuket'),
(12, 'Thailand', 'Krabi'),
(13, 'Greece', 'Mykonos'),
(14, 'Greece', 'Athens'),
(15, 'Czech Republic', 'Brno');

INSERT INTO LOCAL_ATTRACTION(ID, NAME, DESCRIPTION, ADDRESS, FREE, DESTINATION_ID) VALUES
(1, 'Bali ZOO', 'If your idea of an awesome holiday is getting up close with animals, you’ll want to make a stop at Bali Zoo – the first zoological park on the island. ', 'Singapadu, Sukawati, Gianyar, Bali 80582', TRUE, 1),
(2, 'Narmada Water Park', 'Pristine beaches, majestic waterfalls, and exotic dive sites are staple attractions while snorkelling, scuba diving, and swimming are the most popular activities.', 'West Nusa Tenggara Province, Indonesia', TRUE, 2),
(3, 'Hadrian Castle Gate', 'Is a triumphal arch which was built in the name of the Roman emperor Hadrian. It is the only remaining entrance gate in the walls that surround the city and harbor.', ' Barbaros, 07100 Muratpaşa, Turkey', TRUE, 3),
(4, 'Hagia Sophia', ' Former Greek Orthodox Christian patriarchal cathedral, later an Ottoman imperial mosque and now a museum (Ayasofya Müzesi) in Istanbul, Turkey.', 'Sultan Ahmet, Ayasofya Meydanı No:1, 34122 Fatih/İstanbul, Turecko', TRUE, 4),
(5, 'The Lviv Theatre of Opera and Ballet', 'One of the legends says that the architect attempted suicide the following year, because he had realized that the underground waters of the river Plotva were washing away the foundation of the theatre.', 'Svobody Ave, 28, L’viv, Lviv Oblast, Ukraine', TRUE, 5),
(6, 'Town Hall', 'The Market Square is part of the historic center of Lviv, which is included in the UNESCO World Heritage List. The main attraction of the square is Town Hall, constructed in the 14th century', 'Rynok Square, 1, L’viv, Lviv Oblast, Ukraine', TRUE, 5),
(7, 'Armenian Quarter', 'One of the oldest neighbourhoods in the city is the Armenian Quarter. The northern part of the city became a haven for Armenians in the 13th century.', 'Virmens’ka St, 7, L’viv, Lviv Oblast, Ukraine', TRUE, 5),
(8, 'Uzhhorod Castle', 'The first mention of the Uzhhorod Castle dates back to the tenth century. Thus, the historical fortress and bastion are the main tourist destinations of the city. ', 'Kapitul’na Street, 33, Uzhhorod, Ukraine', TRUE, 6),
(9, 'Golden Gate Bridge', 'The Golden Gate Bridge is a California icon gracing San Francisco Bay. It is the most photographed site in the city, with the orange structure backed by blue water, or in many cases, peaking through low lying cloud.', 'Golden Gate Bridge, San Francisco, CA, USA', TRUE, 7),
(10, 'Alcatraz Island', 'The historic and notorious Alcatraz penitentiary, located on Alcatraz Island in San Francisco Bay, is one of America''s most infamous prisons. It operated for almost thirty years, closing in 1963 and re-opening as a tourist attraction in 1973.', 'San Francisco, CA 94133, USA', FALSE , 7),
(11, 'Fisherman''s Wharf', 'Fisherman''s Wharf is one of San Francisco''s most popular tourist areas. If this is your first visit to the city and you only have a day or two to see the sights, Fisherman''s Wharf is one of the best places to visit', 'San Francisco, CA 94133, USA', FALSE , 7),
(12, 'Chinatown', 'You may have been to Chinatown in other cities, but San Francisco''s Chinatown is a whole other realm. It is both the largest Chinatown outside of Asia and the oldest of its kind in North America.', 'San Francisco, CA 94133, USA', FALSE , 7),
(13, 'Empire State Building', 'It''s practically impossible to imagine the sparkling New York skyline without the iconic Empire State Building.', '350 Fifth Ave, New York, 10118', TRUE , 8),
(14, 'Eiffel Tower', 'The iconic tower was designed by Alexandre-Gustave Eiffel for the Paris Exhibition of 1889, which marked the centenary of the French Revolution.', 'Champ de Mars, 5 Avenue Anatole France, 75007 Paris', TRUE , 9),
(15, 'Basilique Notre-Dame de la Garde', 'In a breathtaking hilltop location, this spectacular church stands on the summit of Marseille as its most important landmark, visible from afar.', 'Rue Fort du Sanctuaire, Marseilles', TRUE , 10),
(16, 'Phuket Big Buddha', ' Is a seated Maravija Buddha statue in Phuket, Thailand', 'Karon, Mueang Phuket District, Phuket', TRUE , 11),
(17, 'Wat Tham Sua (Tiger Cave)', 'Part of a temple complex where monks live and worship within a maze of natural caves surrounded by lush jungle.', '35 Krabi Noi, Mueang Krabi District, Krabi', TRUE , 12),
(18, 'Matogianni Street', 'A north to south street through Mykonos Town, with little alleys darting off it, Matogianni Street is where it all happens.', 'Mattheou Andronikou, Mikonos', TRUE , 13),
(19, 'The Acropolis', 'Few sights in the world compare to Athens'' Acropolis, with its Parthenon temple perched high on a rocky crag keeping watch over centuries of civilization.', 'Athens 105 58', TRUE , 14),
(20, 'The Cathedral of St. Peter and Paul', 'Perched atop Petrov Hill in the very heart of Brno, the Cathedral of St. Peter and Paul (Rímskokatolická farnost u katedrály sv. Petra a Pavla v Brne) is hard to miss.', 'Petrov 9, 602 00 Brno 2', TRUE , 15);

INSERT INTO HOTEL(ID, BREAKFAST_TIME_FROM ,BREAKFAST_TIME_TO, DINNER_TIME_FROM, DINNER_TIME_TO,ADDRESS, EMAIL, "NAME", PHONE_NUMBER, STARS, WEB, DESTINATION_ID) VALUES
(1, TIME '9:30:00.0',TIME '12:30:00.0', TIME '13:30:00.0', TIME '15:30:00.0', 'Street 1', 'email@gmail.com', 'Hotel name1', '111 111 111', 4, 'www.hotel1.com', 1),
(2, TIME '9:30:00.0',TIME '12:30:00.0', TIME '13:30:00.0', TIME '15:30:00.0', 'Street 2', 'email1@gmail.com', 'Hotel name 2', '222 222 222', 4, 'www.hotel2.com', 2),
(3, TIME '9:30:00.0',TIME '12:30:00.0', TIME '13:30:00.0', TIME '15:30:00.0', 'Street 3', 'email2@gmail.com', 'Hotel name 3', '333 333 333', 4, 'www.hotel3.com', 3),
(4, TIME '9:30:00.0',TIME '12:30:00.0', TIME '13:30:00.0', TIME '15:30:00.0', 'Street 4', 'email3@gmail.com', 'Hotel name 4', '444 444 444', 4, 'www.hotel4.com', 4),
(5, TIME '9:00:00.0',TIME '11:00:00.0', TIME '16:00:00.0', TIME '18:00:00.0', 'Street 5', 'email4@gmail.com', 'Hotel name 5', '555 555 555', 5, 'www.hotel5.com', 5),
(6, TIME '9:30:00.0',TIME '11:30:00.0', TIME '16:30:00.0', TIME '18:30:00.0', 'Street 6', 'email5@gmail.com', 'Hotel name 6', '666 666 666', 5, 'www.hotel6.com', 5),
(7, TIME '10:00:00.0',TIME '12:00:00.0', TIME '17:00:00.0', TIME '19:00:00.0', 'Street 7', 'email6@gmail.com', 'Hotel name 7', '777 777 777', 5, 'www.hotel7.com', 5),
(8, TIME '9:30:00.0',TIME '12:30:00.0', TIME '13:30:00.0', TIME '15:30:00.0', 'Street 8', 'email7@gmail.com', 'Hotel name 8', '888 888 888', 5, 'www.hotel8.com', 6),
(9, TIME '9:30:00.0',TIME '12:30:00.0', TIME '13:30:00.0', TIME '15:30:00.0', 'Street 9', 'email8@gmail.com', 'Hotel name 9', '999 999 999', 4, 'www.hotel9.com', 7),
(10, TIME '9:30:00.0',TIME '12:30:00.0', TIME '13:30:00.0', TIME '15:30:00.0', 'Street 10', 'email9@gmail.com', 'Hotel name 10', '111 222 333', 4, 'www.hotel10.com', 7),
(11, TIME '9:30:00.0',TIME '12:30:00.0', TIME '13:30:00.0', TIME '15:30:00.0', 'Street 11', 'email10@gmail.com', 'Hotel name 11', '222 333 444', 4, 'www.hotel11.com', 7),
(12, TIME '9:30:00.0',TIME '12:30:00.0', TIME '13:30:00.0', TIME '15:30:00.0', 'Street 12', 'email11@gmail.com', 'Hotel name 12', '333 444 555', 4, 'www.hotel12.com', 7),
(13, TIME '9:30:00.0',TIME '12:30:00.0', TIME '13:30:00.0', TIME '15:30:00.0', 'Street 13', 'email12@gmail.com', 'Hotel name 13', '444 555 666', 4, 'www.hotel13.com', 8),
(14, TIME '9:30:00.0',TIME '12:30:00.0', TIME '13:30:00.0', TIME '15:30:00.0', 'Street 14', 'email13@gmail.com', 'Hotel name 14', '555 666 777', 4, 'www.hotel14.com', 9),
(15, TIME '9:30:00.0',TIME '12:30:00.0', TIME '13:30:00.0', TIME '15:30:00.0', 'Street 15', 'email14@gmail.com', 'Hotel name 15', '666 777 888', 4, 'www.hotel15.com', 10),
(16, TIME '9:30:00.0',TIME '12:30:00.0', TIME '13:30:00.0', TIME '15:30:00.0', 'Street 16', 'email15@gmail.com', 'Hotel name 16', '777 888 999', 4, 'www.hotel16.com', 11),
(17, TIME '9:30:00.0',TIME '12:30:00.0', TIME '13:30:00.0', TIME '15:30:00.0', 'Street 17', 'email16@gmail.com', 'Hotel name 17', '888 999 000', 4, 'www.hotel17.com', 12),
(18, TIME '9:30:00.0',TIME '12:30:00.0', TIME '13:30:00.0', TIME '15:30:00.0', 'Street 18', 'email17@gmail.com', 'Hotel name 18', '999 000 111', 4, 'www.hotel18.com', 13),
(19, TIME '9:30:00.0',TIME '12:30:00.0', TIME '13:30:00.0', TIME '15:30:00.0', 'Street 19', 'email18@gmail.com', 'Hotel name 19', '000 111 222', 4, 'www.hotel19.com', 14),
(20, TIME '9:30:00.0',TIME '12:30:00.0', TIME '13:30:00.0', TIME '15:30:00.0', 'Street 21', 'email20@gmail.com', 'Hotel name 21', '987 654 321', 4, 'www.hotel21.com', 15);

INSERT INTO TOUR(ID, COUNTRY, CITY, DATE_TIME_FROM, DATE_TIME_TIL, DEPARTURE_FROM, DEPARTURE_DATE_TIME,  ARRIVAL_DATE_TIME, DESCRIPTION, TOUR_TYPE,TRANSFER_TYPE, DELEGATE_ID, HOTEL_ID) VALUES
(1, 'Indonesia', 'Bali', '2020-04-1T12:30:00', '2020-04-5T13:30:00', 'Airport', '2020-04-01T01:00:00','2020-04-01T11:00:00', 'Tour in Bali', 'BEACH', 'PLANE', 3, 1),
(2, 'Indonesia', 'Lombok', '2020-05-6T12:30:00', '2020-05-10T13:30:00', 'Airport', '2020-05-6T01:00:00','2020-05-6T11:00:00', 'Tour in Lombok', 'BEACH', 'BUS', 3, 2),
(3, 'Turkey', 'Belek', '2020-05-25T10:30:00', '2020-05-10T13:30:00', 'Airport', '2020-05-25T01:00:00','2020-05-25T09:00:00', 'Tour in Belek', 'BEACH', 'PLANE', 3, 3),
(4, 'Turkey', 'Istanbul', '2020-05-14T10:30:00', '2020-05-17T13:30:00', 'Airport', '2020-05-14T01:00:00','2020-05-14T09:00:00', 'Tour in Istanbul', 'BEACH', 'PLANE', 3, 4),
(5, 'Ukraine', 'Lviv', '2020-05-1T12:30:00', '2020-05-10T13:30:00', 'Airport', '2020-05-01T07:00:00','2020-05-01T10:00:00', 'First Tour in Lviv', 'SIGHTSEEING', 'PLANE', 3, 5),
(6, 'Ukraine', 'Lviv', '2020-05-11T12:30:00', '2020-05-20T13:30:00', 'Airport', '2020-05-11T07:00:00','2020-05-11T10:00:00','Second Tour in Lviv', 'SIGHTSEEING', 'PLANE', 3, 6),
(7, 'Ukraine', 'Lviv', '2020-05-21T12:30:00', '2020-06-1T13:30:00', 'Airport', '2020-05-21T07:00:00','2020-05-21T10:00:00','Third Tour in Lviv', 'SIGHTSEEING', 'PLANE', 3, 7),
(8, 'Ukraine', 'Uzhhorod', '2020-06-2T12:30:00', '2020-06-12T13:30:00', 'Airport', '2020-06-02T10:00:00','2020-06-02T12:00:00','Tour in Uzhhorod', 'SIGHTSEEING', 'PLANE', 3, 8),
(9, 'USA', 'San Francisco', '2020-05-20T12:30:00', '2020-05-27T13:30:00', 'Airport', '2020-05-19T12:00:00','2020-05-20T12:00:00','First Tour in San Francisco', 'BEACH', 'PLANE', 3, 9),
(10, 'USA', 'San Francisco', '2020-06-2T12:30:00', '2020-06-12T13:30:00', 'Airport', '2020-06-01T12:00:00','2020-06-02T12:00:00','Second Tour in San Francisco', 'BEACH', 'PLANE', 3, 10),
(11, 'USA', 'San Francisco', '2020-06-13T12:30:00', '2020-06-22T13:30:00', 'Airport', '2020-06-12T12:00:00','2020-06-13T12:00:00','Third Tour in San Francisco', 'BEACH', 'PLANE', 3, 11),
(12, 'USA', 'San Francisco', '2020-06-23T12:30:00', '2020-06-30T13:30:00', 'Airport', '2020-06-22T12:00:00','2020-06-23T12:00:00','Fourth Tour in San Francisco', 'BEACH', 'PLANE', 3, 12),
(13, 'USA', 'New York', '2020-06-6T12:30:00', '2020-06-17T13:30:00', 'Airport', '2020-06-06T00:00:00','2020-06-06T12:00:00','Tour in New York', 'SPORT', 'PLANE', 3, 13),
(14, 'France', 'Paris', '2020-06-3T12:30:00', '2020-06-15T13:30:00', 'Airport', '2020-06-03T07:00:00','2020-06-03T10:00:00','Tour in Paris', 'SIGHTSEEING', 'PLANE', 3, 14),
(15, 'France', 'Marseille', '2020-06-26T12:30:00', '2020-06-22T13:30:00', 'Airport', '2020-06-26T07:00:00','2020-06-26T11:00:00','Tour in Marseille', 'SIGHTSEEING', 'PLANE', 3, 15),
(16, 'Thailand', 'Phuket', '2020-05-6T12:30:00', '2020-05-17T13:30:00', 'Airport', '2020-05-06T01:00:00','2020-05-06T12:00:00','Tour in Phuket', 'BEACH', 'PLANE', 3, 16),
(17, 'Thailand', 'Krabi', '2020-05-6T12:30:00', '2020-05-17T13:30:00', 'Airport', '2020-05-06T00:00:00','2020-05-06T12:00:00','Tour in Krabi', 'BEACH', 'PLANE', 3, 17),
(18, 'Greece', 'Mykonos', '2020-05-6T12:30:00', '2020-05-17T13:30:00', 'Airport', '2020-05-06T08:00:00','2020-05-06T11:00:00','Tour in Mykonos', 'FAMILY', 'PLANE', 3, 18),
(19, 'Greece', 'Athens', '2020-05-6T12:30:00', '2020-05-17T13:30:00', 'Airport', '2020-05-06T10:00:00','2020-05-06T12:30:00','Tour in Athens', 'FAMILY', 'PLANE', 3, 19),
(20, 'Czech Republic', 'Brno', '2020-05-7T12:30:00', '2020-05-17T13:30:00', 'Airport', '2020-05-07T09:00:00','2020-05-07T10:00:00', 'Tour in Brno', 'SIGHTSEEING', 'PLANE', 3, 20);

INSERT INTO TOUR_USERS VALUES (1,1);

INSERT INTO EXCURSION (ID, DATE_TIME_FROM, DATE_TIME_TILL, ARRIVAL_DATE_TIME, DEPARTURE_DATE_TIME, DESCRIPTION, "NAME", PRICE, TRANSFER_NEEDED) VALUES
(1,'2020-04-3T13:30:00','2020-04-3T20:30:00', '2020-04-03T12:30:00','2020-04-03T22:30:00',  'Get the best views in Bali with an early-morning hike up Mount Batur volcano with breakfast included. An unforgettable sunrise awaits you at the top.','Sunrise Mount Batur Hike with Breakfast', 100, true),
(2,'2020-04-4T7:30:00','2020-04-4T21:30:00', '2020-04-04T6:00:00','2020-04-04T23:00:00', 'Watch the sunrise from the top of Mount Batur on an early morning hike up Bali''s most emblematic mountain. Experience the stunning views from the active volcano near the village of Kintamani, and learn more about the region from a local private guide.', 'Mount Batur Sunrise Hike and Natural Hot Spring', 100, false),
(3,'2020-04-2T13:30:00','2020-04-2T19:30:00', '2020-04-02T13:00:00','2020-04-02T22:00:00', 'Take a private tour of Bali''s most iconic sights that you always see on postcards and Instagram! Snap photos and experience the beauty in the North. ', 'Northern Charm: Lake Bratan, Handara Gate, Waterfall & Swing', 100, false),
(4,'2020-04-2T13:30:00','2020-04-2T19:30:00', '2020-04-02T13:00:00','2020-04-02T22:00:00',  'Experience Bali according to your interests on a customizable full-day tour, and choose what you want to see and do with a licensed guide. Marvel at the rice terraces surrounding Ubud, or take part in water sports activities.', 'Best of Bali: Private Customized Full-Day Tour', 100, false),

(5,'2020-05-7T12:30:00','2020-05-7T19:30:00', '2020-05-7T11:30:00','2020-05-07T20:00:00',  'Get the best views in Lombok', 'Lombok with Breakfast', 100, false),
(6,'2020-05-26T10:30:00','2020-05-26T19:30:00', '2020-05-26T09:30:00','2020-05-26T20:30:00',  'Get the best views in Belek', 'Belek with Breakfast', 100, false),
(7,'2020-05-15T10:30:00','2020-05-15T17:30:00', '2020-05-15T09:30:00','2020-05-15T18:30:00',  'Get the best views in Istanbul', 'Istanbul with Breakfast', 100, false),
(8,'2020-05-2T12:30:00','2020-05-2T16:30:00', '2020-05-2T11:30:00','2020-05-1T17:30:00',  'Take a private tour of Lviv''s most iconic sights that you always see on postcards and Instagram!', 'Best of Lviv', 100, false);

INSERT INTO EXCURSION_TOURS VALUES (1,1),(2,1),(3,1),(4,1),(5,2),(6,3),(7,4),(8,5);