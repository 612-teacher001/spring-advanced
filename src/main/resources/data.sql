/* 商品カテゴリマスタ */
INSERT INTO m_categories (name) VALUES ('本');
INSERT INTO m_categories (name) VALUES ('DVD');
INSERT INTO m_categories (name) VALUES ('ゲーム');

/* 権限マスタ */
INSERT INTO m_roles (name) VALUES ('管理者');
INSERT INTO m_roles (name) VALUES ('利用者');

/* 都道府県コードマスタ */
INSERT INTO m_prefectures VALUES ('01', '北海道');
INSERT INTO m_prefectures VALUES ('02', '青森県');
INSERT INTO m_prefectures VALUES ('03', '岩手県');
INSERT INTO m_prefectures VALUES ('04', '宮城県');
INSERT INTO m_prefectures VALUES ('05', '秋田県');
INSERT INTO m_prefectures VALUES ('06', '山形県');
INSERT INTO m_prefectures VALUES ('07', '福島県');
INSERT INTO m_prefectures VALUES ('08', '茨城県');
INSERT INTO m_prefectures VALUES ('09', '栃木県');
INSERT INTO m_prefectures VALUES ('10', '群馬県');
INSERT INTO m_prefectures VALUES ('11', '埼玉県');
INSERT INTO m_prefectures VALUES ('12', '千葉県');
INSERT INTO m_prefectures VALUES ('13', '東京都');
INSERT INTO m_prefectures VALUES ('14', '神奈川県');
INSERT INTO m_prefectures VALUES ('15', '新潟県');
INSERT INTO m_prefectures VALUES ('16', '富山県');
INSERT INTO m_prefectures VALUES ('17', '石川県');
INSERT INTO m_prefectures VALUES ('18', '福井県');
INSERT INTO m_prefectures VALUES ('19', '山梨県');
INSERT INTO m_prefectures VALUES ('20', '長野県');
INSERT INTO m_prefectures VALUES ('21', '岐阜県');
INSERT INTO m_prefectures VALUES ('22', '静岡県');
INSERT INTO m_prefectures VALUES ('23', '愛知県');
INSERT INTO m_prefectures VALUES ('24', '三重県');
INSERT INTO m_prefectures VALUES ('25', '滋賀県');
INSERT INTO m_prefectures VALUES ('26', '京都府');
INSERT INTO m_prefectures VALUES ('27', '大阪府');
INSERT INTO m_prefectures VALUES ('28', '兵庫県');
INSERT INTO m_prefectures VALUES ('29', '奈良県');
INSERT INTO m_prefectures VALUES ('30', '和歌山県');
INSERT INTO m_prefectures VALUES ('31', '鳥取県');
INSERT INTO m_prefectures VALUES ('32', '島根県');
INSERT INTO m_prefectures VALUES ('33', '岡山県');
INSERT INTO m_prefectures VALUES ('34', '広島県');
INSERT INTO m_prefectures VALUES ('35', '山口県');
INSERT INTO m_prefectures VALUES ('36', '徳島県');
INSERT INTO m_prefectures VALUES ('37', '香川県');
INSERT INTO m_prefectures VALUES ('38', '愛媛県');
INSERT INTO m_prefectures VALUES ('39', '高知県');
INSERT INTO m_prefectures VALUES ('40', '福岡県');
INSERT INTO m_prefectures VALUES ('41', '佐賀県');
INSERT INTO m_prefectures VALUES ('42', '長崎県');
INSERT INTO m_prefectures VALUES ('43', '熊本県');
INSERT INTO m_prefectures VALUES ('44', '大分県');
INSERT INTO m_prefectures VALUES ('45', '宮崎県');
INSERT INTO m_prefectures VALUES ('46', '鹿児島県');
INSERT INTO m_prefectures VALUES ('47', '沖縄県');

/* 商品マスタ */
INSERT INTO items(category_code, name, price) VALUES(1, 'Javaの基本', 2500);
INSERT INTO items(category_code, name, price) VALUES(1, 'MLB Fun', 980);
INSERT INTO items(category_code, name, price) VALUES(1, '料理BOOK!', 1200);
INSERT INTO items(category_code, name, price) VALUES(2, 'なつかしのアニメシリーズ', 2000);
INSERT INTO items(category_code, name, price) VALUES(2, 'The Racer', 1000);
INSERT INTO items(category_code, name, price) VALUES(2, 'Space Wars 3', 1800);
INSERT INTO items(category_code, name, price) VALUES(3, 'パズルゲーム', 780);
INSERT INTO items(category_code, name, price) VALUES(3, 'Invader Fighter', 3400);
INSERT INTO items(category_code, name, price) VALUES(3, 'Play the BasketBall', 2200);

/* 利用者マスタ */
INSERT INTO users (role, name, prefecture, address, phone, email, birthday, password) VALUES
	(1, '管理者のグダぽよ', '13', '東京都千代田区霞が関1-1-1', '090-1234-5678', 'admin@example.com', '1970-03-29', 'himitu'),
	(2, 'タイムリープ中な一般利用者', '12', '千葉県市川市八幡の藪1-1-1', '090-2255-47295', 'user@example.com', '1985-06-06', 'himitu'),
	(1, '佐藤健', '13', '東京都新宿区西新宿2-8-1', '03-1234-5678', 'sato.takeshi@example.com', '1985-03-12', 'password123'),
	(2, '鈴木葵', '27', '大阪府大阪市北区梅田1-1-1', '06-9876-5432', 'suzuki.aoi@example.com', '1990-07-22', 'password123'),
	(2, '高橋翔', '13', '東京都港区芝公園4-2-8', '03-2345-6789', 'takahashi.sho@example.com', '1988-12-05', 'password123'),
	(1, '田中陽菜', '23', '愛知県名古屋市中村区名駅3-28-12', '052-123-4567', 'tanaka.hina@example.com', '1995-06-18', 'password123'),
	(2, '伊藤亮', '40', '福岡県福岡市中央区天神1-4-1', '092-345-6789', 'ito.ryo@example.com', '1982-11-30', 'password123'),
	(1, '渡辺真央', '27', '大阪府堺市堺区南花田口町1-1-10', '072-876-5432', 'watanabe.mao@example.com', '1993-04-09', 'password123'),
	(2, '山本蓮', '13', '東京都世田谷区三軒茶屋2-15-10', '03-3456-7890', 'yamamoto.ren@example.com', '1987-09-15', 'password123'),
	(2, '中村彩', '14', '神奈川県横浜市中区桜木町1-1-1', '045-123-4567', 'nakamura.aya@example.com', '1991-05-21', 'password123'),
	(1, '小林大輔', '27', '大阪府吹田市江坂町1-23-45', '06-5678-1234', 'kobayashi.daisuke@example.com', '1989-01-10', 'password123'),
	(2, '加藤美咲', '40', '福岡県久留米市東町2-5-3', '0942-345-6789', 'kato.misaki@example.com', '1994-08-25', 'password123'),
	(1, '吉田翔太', '11', '埼玉県さいたま市大宮区桜木町2-3-5', '048-123-4567', 'yoshida.shota@example.com', '1986-02-28', 'password123'),
	(2, '松本優香', '13', '東京都中野区中野4-10-2', '03-4567-8901', 'matsumoto.yuka@example.com', '1992-10-12', 'password123'),
	(1, '井上悠真', '22', '静岡県静岡市葵区紺屋町17-1', '054-123-4567', 'inoue.yuma@example.com', '1983-07-03', 'password123'),
	(2, '木村奈々', '27', '大阪府堺市北区中百舌鳥町2-35', '072-234-5678', 'kimura.nana@example.com', '1996-12-16', 'password123'),
	(1, '斉藤隼人', '28', '兵庫県神戸市中央区三宮町1-4-10', '078-123-4567', 'saito.hayato@example.com', '1984-11-05', 'password123'),
	(2, '森川紗英', '40', '福岡県北九州市小倉北区京町3-1-1', '093-345-6789', 'morikawa.sae@example.com', '1990-03-19', 'password123'),
	(1, '福田陽介', '13', '東京都豊島区池袋2-2-1', '03-5678-9012', 'fukuda.yosuke@example.com', '1985-09-27', 'password123'),
	(2, '橋本恵', '23', '愛知県豊橋市駅前大通2-10', '0532-123-4567', 'hashimoto.mei@example.com', '1993-06-02', 'password123'),
	(1, '村上健太', '14', '神奈川県川崎市川崎区砂子1-4-1', '044-234-5678', 'murakami.kenta@example.com', '1987-08-14', 'password123'),
	(2, '石田莉子', '27', '大阪府枚方市岡東町12-3', '072-345-6789', 'ishida.riko@example.com', '1995-01-22', 'password123');
