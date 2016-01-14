package net.kata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.util.function.BiFunction;

import org.junit.Test;


public class SchrodingertCatBoxTest {


	@Test
	public final void may_kill_the_cat_when_open_the_box() {
		//GIVEN
		SchrodingertCatBox given = Experimentation.start(new Cat(), new RadioactiveIsotope());
		assertThat(given).isNotNull();
		
		
	}

}
