create database adventurexp;
use adventurexp;
-- Opret tabel for Kunder
CREATE TABLE Kunder (
id INT AUTO_INCREMENT PRIMARY KEY,
navn VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL,
telefon_nummer varchar(50) not null
);

CREATE TABLE medarbejder (
id INT AUTO_INCREMENT PRIMARY KEY,
navn VARCHAR(255) NOT NULL,
kode VARCHAR(255) NOT NULL
);


-- Opret tabel for Aktiviteter
CREATE TABLE Aktiviteter (
id INT AUTO_INCREMENT PRIMARY KEY,
navn VARCHAR(100) NOT NULL,
instruktør_id INT NOT NULL,
picture_url VARCHAR(255),
beskrivelse TEXT,
age_limit VARCHAR(50),
FOREIGN KEY (instruktør_id) REFERENCES medarbejder(id)
);

-- Opret tabel for Bookinger
CREATE TABLE Bookinger (
id INT AUTO_INCREMENT PRIMARY KEY,
aktivitet_id INT NOT NULL,
kunde_id INT NOT NULL,
dato DATETIME NOT NULL,
tid TIME NOT NULL,
antal_deltagere INT NOT NULL,
FOREIGN KEY (aktivitet_id) REFERENCES Aktiviteter(id),
FOREIGN KEY (kunde_id) REFERENCES Kunder(id)
);
-- insert medarbejder
INSERT INTO medarbejder (navn, kode) VALUES ('khalid', 'khalid');
INSERT INTO medarbejder (navn, kode) VALUES ('ali', 'ali');
INSERT INTO medarbejder (navn, kode) VALUES ('yusuf', 'yusuf');
INSERT INTO medarbejder (navn, kode) VALUES ('Mohamed', 'Mohamed');
INSERT INTO medarbejder (navn, kode) VALUES ('oskar', 'oskar');

-- Insert Paintball Activity
INSERT INTO Aktiviteter (navn, instruktør_id, picture_url, beskrivelse, age_limit)
VALUES ('Paintball', 1,
        'https://super7spaintball.com/wp-content/uploads/2023/05/slidebg_002.jpg',
        'A thrilling team-based game where players eliminate opponents by hitting them with paintballs.',
        '12+');

-- Insert Gokart Activity
INSERT INTO Aktiviteter (navn, instruktør_id, picture_url, beskrivelse, age_limit)
VALUES ('Gokart', 2,
        'https://actionhouse.dk/wp-content/uploads/2015/02/header_gokart-e1424087434508-1024x468.jpg',
        'Race against friends and test your driving skills in high-speed karts.', '8+');

-- Insert Minigolf Activity
INSERT INTO Aktiviteter (navn, instruktør_id, picture_url, beskrivelse, age_limit)
VALUES ('Minigolf', 3,
        'https://bigkahunas.com/destin/wp-content/uploads/sites/11/2023/11/Big-Kahunas-Destin-Water-Park-226.jpg',
        'A fun miniature golf course suitable for all ages.', 'All ages');

-- Insert Sumowrestling Activity
INSERT INTO Aktiviteter (navn, instruktør_id, picture_url, beskrivelse, age_limit)
VALUES ('Sumowrestling', 4,
        'https://bouncycastlenetwork-res.cloudinary.com/image/upload/f_auto,q_auto,c_limit,w_900/f6b751d098ec0110eeb288b3eea4aae1',
        'Participants wear inflatable sumo suits and compete to push each other out of the ring.',
        '15+');