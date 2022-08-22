DROP TABLE IF EXISTS users;

CREATE TABLE `users` (
	`user_id` int AUTO_INCREMENT PRIMARY KEY,
	`user_name` varchar(100) NOT NULL,
	`email` varchar(100) NOT NULL,
	`level` int,
	`status` varchar(100) NOT NULL
);

INSERT INTO `users` (`user_name`, `email`, `level`, `status`)
	VALUES ('Dave', 'dave@mail.com', 10, 'ACTIVE');
INSERT INTO `users` (`user_name`, `email`, `level`, `status`)
	VALUES ('Jason', 'jason@mail.com', 10, 'ACTIVE');
INSERT INTO `users` (`user_name`, `email`, `level`, `status`)
	VALUES ('James', 'james@mail.com', 8, 'INACTIVE');
INSERT INTO `users` (`user_name`, `email`, `level`, `status`)
	VALUES ('Kim', 'kim@mail.com', 5, 'ACTIVE');
INSERT INTO `users` (`user_name`, `email`, `level`, `status`)
	VALUES ('Chuck', 'chuck@mail.com', 1, 'INVITED');