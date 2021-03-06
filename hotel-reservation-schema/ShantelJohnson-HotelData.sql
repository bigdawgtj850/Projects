USE Hotel;

INSERT INTO Amenity (AmenityType) VALUES 
    ('Microwave'),
    ('Refrigerator'),
    ('Oven');
 
INSERT INTO Room (RoomId, RoomType, ADA_Access, BaseRate, RoomTypeId) VALUES
    (201,'Double',0,199.99,2),
    (202,'Double',1,174.99,2),
    (203,'Double',0,199.99,2),
    (204,'Double',1,174.99,2),
    (205,'Single',0,174.99,1),
    (206,'Single',1,149.99,1),
    (207,'Single',0,174.99,1),
    (208,'Single',1,149.99,1),
    (301,'Double',0,199.99,2),
    (302,'Double',1,174.99,2),
    (303,'Double',0,199.99,2),
    (304,'Double',1,174.99,2),
    (305,'Single',0,174.99,1),
    (306,'Single',1,149.99,1),
    (307,'Single',0,174.99,1),
    (308,'Single',1,149.99,1),
    (401,'Suite',1,399.99,3),
    (402,'Suite',1,399.99,3);
    
INSERT INTO RoomAmenity (RoomId, AmenityId) VALUES
    (201,1),
    (202,2),
    (203,1),
    (204,2),
    (205,1),
    (205,2),
    (206,1),
    (206,2),
    (207,1),
    (207,2),
    (208,1),
    (208,2),
    (301,1),
    (302,2),
    (303,1),
    (304,2),
    (305,1),
    (305,2),
    (306,1),
    (306,2),
    (307,1),
    (307,2),
    (308,1),
    (308,2),
    (401,1),
    (401,2),
    (401,3),
    (402,1),
    (402,2),
    (402,3);
    
INSERT INTO RoomType (RoomTypeId, StandardOccupancy, MaxOccupancy, ExtraPerson, HasJacuzzi) VALUES
	(null,2,4,10.00,1),
    (null,2,4,10.00,0),
    (null,2,4,10.00,1),
    (null,2,4,10.00,0),
    (null,2,2,0.00,1),
    (null,2,2,0.00,0),
    (null,2,2,0.00,1),
    (null,2,2,0.00,0),
    (null,2,4,10.00,1),
    (null,2,4,10.00,0),
    (null,2,4,10.00,1),
    (null,2,4,10.00,0),
    (null,2,2,0.00,1),
    (null,2,2,0.00,0),
    (null,2,2,0.00,1),
    (null,2,2,0.00,0),
    (null,3,8,20.00,0),
    (null,3,8,20.00,0);
    
INSERT INTO Guest (FirstName, LastName, Address, City, State, Zip, Phone) VALUES
    ('Shantel','Johnson','1010 Hollywood Blvd', 'Los Angeles', 'CA', 90211,'2135555555'),
    ('Mack','Simmer','379 Old Shore Street','Council Bluffs','IA',51501,'2915530508'),
    ('Bettyann','Seery','750 Wintergreen Dr.','Wasilla','AK',99654,'4782779632'),
    ('Duane','Cullison','9662 Foxrun Lane','Harlingen','TX',78552,'3084940198'),
    ('Karie','Yang','9378 W. Augusta Ave.','West Deptford','NJ',8096,'2147300298'),
    ('Aurore','Lipton','762 Wild Rose Street','Saginaw','MI',48601,'3775070974'),
    ('Zachery','Luechtefield','7 Poplar Dr.','Arvada','CO',80003,'8144852615'),
    ('Jeremiah','Pendergrass','70 Oakwood St.','Zion','IL',60099,'2794910960'),
    ('Walter','Holaway','7556 Arrowhead St.','Cumberland','RI',2864,'4463966785'),
    ('Wilfred','Vise','77 West Surrey Street','Oswego','NY',13126,'8347271001'),
    ('Maritza','Tilton','939 Linda Rd.','Burke','VA',22015,'4463516860'),
    ('Joleen','Tison','87 Queen St.','Drexel Hill','PA',19026,'2318932755');
    
INSERT INTO Reservation (Adults, Children, CheckIn, CheckOut, Total) VALUES
    (1,0,'2023-02-02 00:00:00','2023-02-04 00:00:00',299.98),
    (2,1,'2023-02-05 00:00:00','2023-02-10 00:00:00',999.95),
    (2,0,'2023-02-22 00:00:00','2023-02-24 00:00:00',349.98),
    (2,2,'2023-03-06 00:00:00','2023-03-07 00:00:00',199.99),
    (1,1,'2023-03-17 00:00:00','2023-03-20 00:00:00',524.97),
    (3,0,'2023-03-18 00:00:00','2023-03-23 00:00:00',924.95),
    (2,2,'2023-03-29 00:00:00','2023-03-31 00:00:00',349.98),
    (2,0,'2023-03-31 00:00:00','2023-04-05 00:00:00',874.95),
    (1,0,'2023-04-09 00:00:00','2023-04-13 00:00:00',799.96),
    (1,1,'2023-04-23 00:00:00','2023-04-24 00:00:00',174.99),
    (2,4,'2023-05-30 00:00:00','2023-06-02 00:00:00',1199.97),
    (2,0,'2023-06-10 00:00:00','2023-06-14 00:00:00',599.96),
    (1,0,'2023-06-10 00:00:00','2023-06-14 00:00:00',599.96),
    (3,0,'2023-06-17 00:00:00','2023-06-18 00:00:00',184.99),
    (2,0,'2023-06-28 00:00:00','2023-07-02 00:00:00',699.96),
    (3,1,'2023-07-13 00:00:00','2023-07-14 00:00:00',184.99),
    (4,2,'2023-07-18 00:00:00','2023-07-21 00:00:00',1259.97),
    (2,1,'2023-07-28 00:00:00','2023-07-29 00:00:00',199.99),
    (1,0,'2023-08-30 00:00:00','2023-09-01 00:00:00',349.98),
    (2,0,'2023-09-16 00:00:00','2023-09-17 00:00:00',149.99),
    (2,2,'2023-09-13 00:00:00','2023-09-15 00:00:00',399.98),
    (2,2,'2023-11-22 00:00:00','2023-11-25 00:00:00',1199.97),
    (2,0,'2023-11-22 00:00:00','2023-11-25 00:00:00',449.97),
    (2,2,'2023-11-22 00:00:00','2023-11-25 00:00:00',599.97),
    (2,0,'2023-12-24 00:00:00','2023-12-28 00:00:00',699.96);
    
INSERT INTO ReservationRoom (RoomId, ReservationId) VALUES
    (308,1),
    (203,2),
    (305,3),
    (201,4),
    (307,5),
    (302,6),
    (202,7),
    (304,8),
    (301,9),
    (207,10),
    (401,11),
    (206,12),
    (208,13),
    (304,14),
    (205,15),
    (204,16),
    (401,17),
    (303,18),
    (305,19),
    (208,20),
    (203,21),
    (401,22),
    (206,23),
    (301,24),
    (302,25);
    
INSERT INTO GuestReservation (GuestId, ReservationId) VALUES
    (2,1),
    (3,2),
    (4,3),
    (5,4),
    (1,5),
    (6,6),
    (7,7),
    (8,8),
    (9,9),
    (10,10),
    (11,11),
    (12,12),
    (12,13),
    (6,14),
    (1,15),
    (9,16),
    (10,17),
    (3,18),
    (3,19),
    (2,20),
    (5,21),
    (4,22),
    (2,23),
    (2,24),
    (11,25);
    
/* Removing Jeremiah Pendergrass and his reservations */
    DELETE FROM Guest WHERE GuestId = 8;
    DELETE FROM ReservationRoom WHERE ReservationId = 8;
	DELETE FROM Reservation WHERE ReservationId = 8;