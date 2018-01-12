DELETE FROM votestory;
DELETE FROM restaurant;
DELETE FROM users;

DELETE FROM user_roles;

INSERT INTO votestory (user_id, restaurant_id) VALUES

  (1,3),(1,2);
INSERT INTO restaurant (name) VALUES

  ('testingRestoran'),('restobar');
INSERT INTO dish (name,price, restaurant_id) VALUES

  ('testingDish',120,1),('restoDish',45,2);
INSERT INTO users (name, email, password) VALUES

  ('testingUser','asd@tgh.ru','12345678'),
  ('testingUser2','adfdf@tgh.com','12345678');

