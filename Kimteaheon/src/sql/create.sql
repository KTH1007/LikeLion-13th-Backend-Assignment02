use review;

create table users (
	id integer auto_increment primary key,  -- 기본키
    name varchar(50) not null, -- 이름은 반드시 입력
    email varchar(100) not null unique -- 로그인한 사용자의 email이므로 반드시하고 unique 해야 함
);

create table reviews(
	id integer auto_increment primary key, -- 기본키
    rating Integer not null, -- 상품 평점을 남겨야 하므로 필수값
    content text, -- 리뷰 내용
    user_id integer,
    foreign key (user_id) references users(id)
);