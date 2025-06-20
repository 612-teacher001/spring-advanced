DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS m_prefectures;
DROP TABLE IF EXISTS m_roles;
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS m_categories;

/**********************************/
/* テーブル名: 商品カテゴリマスタ */
/**********************************/
CREATE TABLE m_categories(
		code SERIAL,
		name VARCHAR(10) NOT NULL
);

/**********************************/
/* テーブル名: 商品マスタ */
/**********************************/
CREATE TABLE items(
		id SERIAL,
		category_code INTEGER NOT NULL,
		name VARCHAR(100) NOT NULL,
		price INTEGER
);

/**********************************/
/* テーブル名: 権限マスタ */
/**********************************/
CREATE TABLE m_roles(
		id SERIAL,
		name VARCHAR(10) NOT NULL
);

/**********************************/
/* テーブル名: 都道府県マスタ */
/**********************************/
CREATE TABLE m_prefectures(
		code CHARACTER(2) NOT NULL,
		name VARCHAR(4) NOT NULL
);

/**********************************/
/* テーブル名: 利用者マスタ */
/**********************************/
CREATE TABLE users(
		id SERIAL,
		role INTEGER NOT NULL DEFAULT 2,
		name VARCHAR(100) NOT NULL,
		prefecture CHARACTER(2),
		address VARCHAR(255),
		phone VARCHAR(14) NOT NULL,
		email VARCHAR(255) NOT NULL,
		birthday DATE,
		password VARCHAR(255) NOT NULL
);


ALTER TABLE m_categories ADD CONSTRAINT IDX_m_categories_PK PRIMARY KEY (code);

ALTER TABLE items ADD CONSTRAINT IDX_items_PK PRIMARY KEY (id);
ALTER TABLE items ADD CONSTRAINT IDX_items_FK0 FOREIGN KEY (category_code) REFERENCES m_categories (code);

ALTER TABLE m_roles ADD CONSTRAINT IDX_m_roles_PK PRIMARY KEY (id);

ALTER TABLE m_prefectures ADD CONSTRAINT IDX_m_prefectures_PK PRIMARY KEY (code);

ALTER TABLE users ADD CONSTRAINT IDX_users_PK PRIMARY KEY (id);
ALTER TABLE users ADD CONSTRAINT IDX_users_FK0 FOREIGN KEY (role) REFERENCES m_roles (id);
ALTER TABLE users ADD CONSTRAINT IDX_users_FK1 FOREIGN KEY (prefecture) REFERENCES m_prefectures (code);



