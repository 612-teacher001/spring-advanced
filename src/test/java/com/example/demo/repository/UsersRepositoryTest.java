package com.example.demo.repository;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.User;
import com.example.demo.factory.UserFactory;

@SpringBootTest
@Transactional
class UsersRepositoryTest {

	/** テスト対象クラス */
	@Autowired
	UserRepository sut;
	
	/** テスト補助変数 */
	List<User> expected = new ArrayList<User>();
	
	@BeforeEach
	void setUp() throws Exception {
		expected.add(UserFactory.create(1, 1, "管理者のグダぽよ", "13", "東京都千代田区霞が関1-1-1", "090-1234-5678", "admin@example.com", "1970-03-29", "himitu"));
		expected.add(UserFactory.create(2, 2, "タイムリープ中な一般利用者", "12", "千葉県市川市八幡の藪1-1-1", "090-2255-47295", "user@example.com", "1985-06-06", "himitu"));
		expected.add(UserFactory.create(3, 1, "佐藤健", "13", "東京都新宿区西新宿2-8-1", "03-1234-5678", "sato.takeshi@example.com", "1985-03-12", "password123"));
		expected.add(UserFactory.create(4, 2, "鈴木葵", "27", "大阪府大阪市北区梅田1-1-1", "06-9876-5432", "suzuki.aoi@example.com", "1990-07-22", "password123"));
		expected.add(UserFactory.create(5, 2, "高橋翔", "13", "東京都港区芝公園4-2-8", "03-2345-6789", "takahashi.sho@example.com", "1988-12-05", "password123"));
		expected.add(UserFactory.create(6, 1, "田中陽菜", "23", "愛知県名古屋市中村区名駅3-28-12", "052-123-4567", "tanaka.hina@example.com", "1995-06-18", "password123"));
		expected.add(UserFactory.create(7, 2, "伊藤亮", "40", "福岡県福岡市中央区天神1-4-1", "092-345-6789", "ito.ryo@example.com", "1982-11-30", "password123"));
		expected.add(UserFactory.create(8, 1, "渡辺真央", "27", "大阪府堺市堺区南花田口町1-1-10", "072-876-5432", "watanabe.mao@example.com", "1993-04-09", "password123"));
		expected.add(UserFactory.create(9, 2, "山本蓮", "13", "東京都世田谷区三軒茶屋2-15-10", "03-3456-7890", "yamamoto.ren@example.com", "1987-09-15", "password123"));
		expected.add(UserFactory.create(10, 2, "中村彩", "14", "神奈川県横浜市中区桜木町1-1-1", "045-123-4567", "nakamura.aya@example.com", "1991-05-21", "password123"));

		expected.add(UserFactory.create(11, 1, "小林大輔", "27", "大阪府吹田市江坂町1-23-45", "06-5678-1234", "kobayashi.daisuke@example.com", "1989-01-10", "password123"));
		expected.add(UserFactory.create(12, 2, "加藤美咲", "40", "福岡県久留米市東町2-5-3", "0942-345-6789", "kato.misaki@example.com", "1994-08-25", "password123"));
		expected.add(UserFactory.create(13, 1, "吉田翔太", "11", "埼玉県さいたま市大宮区桜木町2-3-5", "048-123-4567", "yoshida.shota@example.com", "1986-02-28", "password123"));
		expected.add(UserFactory.create(14, 2, "松本優香", "13", "東京都中野区中野4-10-2", "03-4567-8901", "matsumoto.yuka@example.com", "1992-10-12", "password123"));
		expected.add(UserFactory.create(15, 1, "井上悠真", "22", "静岡県静岡市葵区紺屋町17-1", "054-123-4567", "inoue.yuma@example.com", "1983-07-03", "password123"));
		expected.add(UserFactory.create(16, 2, "木村奈々", "27", "大阪府堺市北区中百舌鳥町2-35", "072-234-5678", "kimura.nana@example.com", "1996-12-16", "password123"));
		expected.add(UserFactory.create(17, 1, "斉藤隼人", "28", "兵庫県神戸市中央区三宮町1-4-10", "078-123-4567", "saito.hayato@example.com", "1984-11-05", "password123"));
		expected.add(UserFactory.create(18, 2, "森川紗英", "40", "福岡県北九州市小倉北区京町3-1-1", "093-345-6789", "morikawa.sae@example.com", "1990-03-19", "password123"));
		expected.add(UserFactory.create(19, 1, "福田陽介", "13", "東京都豊島区池袋2-2-1", "03-5678-9012", "fukuda.yosuke@example.com", "1985-09-27", "password123"));
		expected.add(UserFactory.create(20, 2, "橋本恵", "23", "愛知県豊橋市駅前大通2-10", "0532-123-4567", "hashimoto.mei@example.com", "1993-06-02", "password123"));
		
		expected.add(UserFactory.create(21, 1, "村上健太", "14", "神奈川県川崎市川崎区砂子1-4-1", "044-234-5678", "murakami.kenta@example.com", "1987-08-14", "password123"));
		expected.add(UserFactory.create(22, 2, "石田莉子", "27", "大阪府枚方市岡東町12-3", "072-345-6789", "ishida.riko@example.com", "1995-01-22", "password123"));
	}

	@ParameterizedTest
	@MethodSource("dataProvider")
	@DisplayName("Test: ページネーションのテスト")
	void test(Integer limit, Integer  offset) {
		// execute
		PageRequest pageRequest = PageRequest.of(offset, limit, Sort.by("id").ascending());
		Page<User> page = sut.findAll(pageRequest);
		List<User> actual = page.stream()
							    .collect(Collectors.toList());
		// verify
		for (int i = 0 * limit; i < actual.size(); i++) {
			User actualUser = actual.get(i);
			User expectedUser = expected.get(offset * limit + i);
			assertThat(actualUser.getId(), is(expectedUser.getId()));
			assertThat(actualUser.getRole().getId(), is(expectedUser.getRole().getId()));
			assertThat(actualUser.getName(), is(expectedUser.getName()));
			assertThat(actualUser.getPrefecture().getCode(), is(expectedUser.getPrefecture().getCode()));
			assertThat(actualUser.getAddress(), is(expectedUser.getAddress()));
			assertThat(actualUser.getPhone(), is(expectedUser.getPhone()));
			assertThat(actualUser.getEmail(), is(expectedUser.getEmail()));
			assertThat(actualUser.getBirthday().toString(), is(expectedUser.getBirthday().toString()));
			assertThat(actualUser.getPassword(), is(expectedUser.getPassword()));
		}
	}
	
	static Stream<Arguments> dataProvider() {
		// setup
		List<Integer> limit = new ArrayList<Integer>();
		List<Integer> offset = new ArrayList<Integer>();
		// Test01: 1件目から10件目を取得する
		limit.add(10);
		offset.add(0);
		// Test02: 11件目から20件目を取得する
		limit.add(10);
		offset.add(1);
		// Test03: 21件目から22件目を取得する
		limit.add(10);
		offset.add(2);
		// Test04: 1件目から6件分を取得する
		limit.add(6);
		offset.add(0);
		// Test05: 14件目から4件分を取得する
		limit.add(4);
		offset.add(3);
		// テストパラメータの返却
		return Stream.of(
				  Arguments.of(limit.get(0), offset.get(0))
				, Arguments.of(limit.get(1), offset.get(1))
				, Arguments.of(limit.get(2), offset.get(2))
				, Arguments.of(limit.get(3), offset.get(3))
				, Arguments.of(limit.get(limit.size() - 1), offset.get(offset.size() - 1))
			   );
	}

	
}

