package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lombok.Data;


class ItemControllerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@ParameterizedTest
	@MethodSource("dataProvider")
	@DisplayName("基本的な２条件の組み合わせ例")
	void test(Price target, String expected) {
		String actual = "";
		if (target.getMin() == null && target.getMax() != null) {
			actual = "上限が決まっている";
		} else if (target.getMin() != null && target.getMax() != null) {
			actual = "上限下限が決まっている";
		} else if (target.getMin() != null && target.getMax() == null ) {
			actual = "下限が決まっている";
		} else if (target.getMin() == null && target.getMax() == null) {
			actual = "上限下限が決まっていない";
		}
		assertThat(actual, is(expected));
	}

	static Stream<Arguments> dataProvider() {
		// setup
		List<Price> target = new ArrayList<>();
		List<String> expected = new ArrayList<String>();
		
		// Test01: Price(null, 5)のときは「上限が決まっている」
		target.add(new Price(null, 5));
		expected.add("上限が決まっている");
		// Test02: Price(1,5)のとき「上限加減が決まっている」
		target.add(new Price(1, 5));
		expected.add("上限下限が決まっている");
		// Test03: Price(1, null)のときは「下限が決まっている」
		target.add(new Price(1, null));
		expected.add("下限が決まっている");
		// Test04: Price(null, null)のときは「上限加減が決まっていない」
		target.add(new Price(null, null));
		expected.add("上限下限が決まっていない");
		
		// テストパラメータの返却
		int size = target.size();
		return Stream.of(
				  Arguments.of(target.get(0), expected.get(0))
				, Arguments.of(target.get(1), expected.get(1))
				, Arguments.of(target.get(2), expected.get(2))
				, Arguments.of(target.get(size - 1), expected.get(size - 1))
			   );
	}
	
}

@Data
class Price {
	private Integer min;
	private Integer max;
	public Price()  {}
	public Price(Integer min, Integer max) {
		this.min = min;
		this.max = max;
	}
	
	public Price(int min, int max) {
		this(Integer.valueOf(min), Integer.valueOf(max));
	}
	
}


