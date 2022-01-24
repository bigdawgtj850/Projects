USE tashdevclass;

INSERT IGNORE INTO User (UserId, UserName)
VALUES (1, 'Natasha Kinder'),
(2, 'Jack Smith'),
(3, 'Robert West');

INSERT IGNORE INTO Post (PostId, Title, Category, Address, ZipCode, Preview, EventInfo, Date, UserId)
VALUES (1, 'Birthday Party', 'Celebration', 'Tonys Restaurant', '12345', 'Celebrate', 'Come at Noon!', '2021-02-13', 1);

INSERT IGNORE INTO Post (PostId, Title, Category, Address, ZipCode, Preview, EventInfo, Date, UserId)
VALUES (2, 'Learn to Ride', 'Other', 'My House', '60563', 'Horse Riding Lessons', 'Must bring own horse', '2021-03-15', 2),
(3, 'Homemade Italian', 'Educational', 'Culinary Kitchen', '48520', 'Cooking Class', 'Come hungry!', '2021-02-28', 3),
(4, 'Company Picnic', 'Outdoor', 'Greenway Park', '96321', 'Spring Company Picnic', 'Starts at 3PM', '2021-04-30', 1);