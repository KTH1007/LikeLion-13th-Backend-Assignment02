use review;

insert into users (name, email) values
('이름1', 'email1@email.com'),
('이름2', 'email2@email.com'),
('이름3', 'email3@email.com');


insert into reviews (rating, content, user_id) values
(1, '별로', 1),
(3, '보통', 2),
(5, '좋음', 3);
