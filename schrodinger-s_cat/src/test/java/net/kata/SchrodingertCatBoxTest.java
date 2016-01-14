package net.kata;

import static org.assertj.core.api.Assertions.*;

import java.util.function.BiFunction;

import org.junit.Test;

public class SchrodingertCatBoxTest {


	@Test
	public final void may_kill_the_cat_when_open_the_box() {
		//GIVEN
		
		BiFunction<Cat, RadioactiveIsotope, SchrodingertCatBox>  start = ((c,a) -> {return new SchrodingertCatBox(c, a);});
		
		SchrodingertCatBox given = start.apply(new Cat(), new RadioactiveIsotope());
		assertThat(given).isNotNull().isEqualTo(Experimentation.start(new Cat(), new RadioactiveIsotope()));
		
		
	}

}
