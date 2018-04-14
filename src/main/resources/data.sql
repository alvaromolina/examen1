delete from post_category;
delete from post;
INSERT INTO post_category(id, name) VALUES (1000, 'Deportes');
INSERT INTO post_category(id, name) VALUES (1001, 'Noticias');

INSERT INTO post(id, text, post_category_id) VALUES (2000, 'Post 1', 1000);
INSERT INTO post(id, text, post_category_id) VALUES (2002, 'Post 2', 1001);