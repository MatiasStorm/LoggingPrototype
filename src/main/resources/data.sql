
CREATE TABLE `log` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    origin varchar(255),
    description varchar(255),
    order_number int,
    time_stamp TIMESTAMP DEFAULT NOW()
);

CREATE TABLE `error_log` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    origin varchar(255),
    description varchar(255),
    order_number int,
    time_stamp TIMESTAMP DEFAULT NOW()
);
