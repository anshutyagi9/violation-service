DROP TABLE IF EXISTS owner;

CREATE TABLE owner (
  id INT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  vehicle_Number VARCHAR(250) NOT NULL,
  email_Address VARCHAR(250) NOT NULL
);

INSERT INTO owner (id, name, vehicle_Number, email_Address) VALUES
  ('101', 'Anshu', 'UP149876', 'anshutyagi9@gmail.com'),
  ('102', 'Prakshi', 'UP149875', 'prakshi91@gmail.com'),
  ('103', 'Prashant', 'UP149874', 'prshnt301@gmail.com'),
  ('104', 'Vasu', 'UP149873', 'ibhardwaj3@gmail.com');

DROP TABLE IF EXISTS vehicle;

CREATE TABLE vehicle (
  vehicle_Number VARCHAR(250) PRIMARY KEY,
  purchased_Date DATE NOT NULL,
  color VARCHAR(250) NOT NULL,
  owner_id INT NOT NULL
);

INSERT INTO vehicle (vehicle_Number, purchased_Date, owner_id, color) VALUES
  ('UP149876','2021-05-01','101', 'red'),
  ('UP149875','2020-05-01','102', 'white'),
  ('UP149874','2020-08-01','103', 'blue'),
  ('UP149873','2020-10-01','104', 'black');

CREATE TABLE VIOLATION (
  id INT AUTO_INCREMENT PRIMARY KEY,
  vehicle_Number VARCHAR(250) NOT NULL,
  violation_Type VARCHAR(250) NOT NULL,
  violation_Date DATE NOT NULL,
  penalty_Amount Float Not null
);
