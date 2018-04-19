delete from post_category;
delete from post;
delete from comment;
delete from user;


INSERT INTO post_category(id, name) VALUES (1000, 'Deportes');
INSERT INTO post_category(id, name) VALUES (1001, 'Noticias');

INSERT INTO user(id, name) VALUES (1000, 'Juan');
INSERT INTO user(id, name) VALUES (1001, 'Pedro');

INSERT INTO post(id, text, post_category_id, show_post) VALUES (2000, 'Post 1', 1000, 1);
INSERT INTO post(id, text, post_category_id, show_post) VALUES (2002, 'Post 2', 1001, 1);


INSERT INTO comment(id, text, post_id,  user_id) VALUES (2000, 'Post 1', 2000, 1000);
INSERT INTO comment(id, text, post_id, user_id) VALUES (2002, 'Post 2', 2001, 1001);