DROP TABLE IF EXISTS restaurant cascade;
DROP TABLE IF EXISTS users cascade;
DROP TABLE IF EXISTS votestory cascade;
DROP TABLE IF EXISTS restaurant_dish cascade;
DROP TABLE IF EXISTS user_roles cascade;

CREATE TABLE users
(
  id                        bigserial             PRIMARY KEY,
  name                      VARCHAR                  NOT NULL,
  email                     VARCHAR                  NOT NULL,
  password                  VARCHAR(60)              NOT NULL,
  register_date             TIMESTAMP DEFAULT now()  NOT NULL,
  enabled                   BOOL DEFAULT TRUE        NOT NULL,
  isVote                    BOOL DEFAULT FALSE       NOT NULL,
  canVote                   BOOL DEFAULT TRUE        NOT NULL,
  accountNonExpired         BOOL DEFAULT TRUE        NOT NULL,
  accountNonLocked          BOOL DEFAULT TRUE        NOT NULL,
  credentialsNonExpired     BOOL DEFAULT TRUE        NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);
CREATE TABLE restaurant
(
  id          bigserial PRIMARY KEY,
  name        VARCHAR  NOT NULL,
  );
  CREATE TABLE dish
(
  id          bigserial PRIMARY KEY,
  name        VARCHAR  NOT NULL,
  price       INTEGER,
  restaurant_id INTEGER NOT NULL
  );
CREATE TABLE votestory
(
  id              BIGINT auto_increment primary key,
  user_id         BIGINT NOT NULL,
  restaurant_id   BIGINT NOT NULL,
  vote_date       TIMESTAMP DEFAULT now() NOT NULL
  );

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);



