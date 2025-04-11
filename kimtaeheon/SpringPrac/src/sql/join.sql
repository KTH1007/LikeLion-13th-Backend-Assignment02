use review;

select users.id as userId, users.name, users.email, reviews.rating, reviews.content
from users join reviews
on users.id = reviews.user_id;