package net.kata;

import org.junit.Test;

public class SchrodingertCatBoxTest {

	@Test
	public final void may_kill_the_cat_when_open_the_box() {
		//GIVEN
		SchrodingertCatBox given = Experimentation.start(new Cat(), new RadioactiveIsotope()).apply(new Cat(), new RadioactiveIsotope());
		
	}

}