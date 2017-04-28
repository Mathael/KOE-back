package com.angularproject;

import com.angularproject.util.Utils;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilTests {

	@Test
	public void shouldReturnRandomIntegerBetweenMinAndMaxIncluded() {
		final int rnd = Utils.getRandomNumberInRange(0, 10);
		final int rnd2 = Utils.getRandomNumberInRange(0, 10);
		final int rnd3 = Utils.getRandomNumberInRange(0, 10);
		final int rnd4 = Utils.getRandomNumberInRange(0, 10);
		final int rnd5 = Utils.getRandomNumberInRange(0, 10);

		Assertions.assertThat(rnd).isNotNull();
		Assertions.assertThat(rnd).isBetween(0, 10);

		Assertions.assertThat(rnd2).isNotNull();
		Assertions.assertThat(rnd2).isBetween(0, 10);

		Assertions.assertThat(rnd3).isNotNull();
		Assertions.assertThat(rnd3).isBetween(0, 10);

		Assertions.assertThat(rnd4).isNotNull();
		Assertions.assertThat(rnd4).isBetween(0, 10);

		Assertions.assertThat(rnd5).isNotNull();
		Assertions.assertThat(rnd5).isBetween(0, 10);
	}
}
