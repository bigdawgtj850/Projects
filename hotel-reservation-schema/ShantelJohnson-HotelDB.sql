DROP DATABASE IF EXISTS Hotel;

CREATE DATABASE Hotel;

USE Hotel;

CREATE TABLE Room(
	RoomId INT PRIMARY KEY NOT NULL,
    RoomType VARCHAR(10) NOT NULL,
    ADA_Access TINYINT(1) NOT NULL,
    BaseRate DECIMAL(5,2) NOT NULL,
    FOREIGN KEY fk_Room_RoomTypeId (RoomTypeId)
		REFERENCES RoomType(RoomTypeId)
);

CREATE TABLE RoomType(
	RoomTypeId INT PRIMARY KEY NOT NULL,
    StandardOccupany INT NOT NULL,
    MaxOccupany INT NOT NULL,
    ExtraPerson DECIMAL(5,2),
    HasJacuzzi TINYINT(1) NOT NULL
);

CREATE TABLE Amenity (
    AmenityId INT PRIMARY KEY AUTO_INCREMENT,
    AmenityType VARCHAR(30)
);

CREATE TABLE RoomAmenity (
    RoomId INT NOT NULL,
    AmenityId INT NOT NULL,
    PRIMARY KEY pk_RoomAmenity (RoomId, AmenityId),
	FOREIGN KEY fk_RoomAmenity_Room (RoomId)
		REFERENCES Room(RoomId),
	FOREIGN KEY fk_RoomAmenity_Amenity (AmenityId)
		REFERENCES Amenity(AmenityId)
);

CREATE TABLE Reservation (
	ReservationId INT PRIMARY KEY AUTO_INCREMENT,
    Adults INT NOT NULL,
    Children INT NOT NULL,
    CheckIn DATE,
    CheckOut DATE,
    Total DECIMAL(8,2) NOT NULL
);

CREATE TABLE Guest (
	GuestId INT PRIMARY KEY AUTO_INCREMENT,
    FirstName varchar(50) NOT NULL,
    LastName varchar(50) NOT NULL,
    Address varchar(100),
    City varchar(50),
    State char(2),
    Zip char(5),
    Phone char(10)
);

CREATE TABLE ReservationRoom(
	RoomId INT,
    ReservationId INT,
    PRIMARY KEY pk_ReservationRoom (RoomId, ReservationId),
    FOREIGN KEY fk_ReservationRoom_Room (RoomId)
		REFERENCES Room (RoomId),
	FOREIGN KEY fk_ReservationRoom_Reservation (ReservationId)
		REFERENCES Reservation (ReservationId)
);

CREATE TABLE GuestReservation (
	GuestId INT,
    ReservationId INT,
    PRIMARY KEY pk_GuestReservation (GuestId, ReservationId),
    FOREIGN KEY fk_GuestReservation_Guest (GuestId)
		REFERENCES Guest (GuestId),
	FOREIGN KEY fk_GuestReservation_Reservation (ReservationId)
		REFERENCES Reservation (ReservationId)
);