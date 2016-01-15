package net.kata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import net.kata.atom.RadioactiveIsotope;

public class CatTest {

	@Test
	public final void cat_should_not_equals_to_other_thing() {
		// GIVEN
		Cat given = new Cat();
		assertEquals(given.toString(), "Cat [cri=Miaou!]");

		// WHEN
		boolean when = given.equals(new RadioactiveIsotope());

		// THEN
		assertFalse(when);
	}

	@Test
	public void should_cat_be_compare_in_set() {
		// GIVEN
		Cat cat = new Cat();
		Cat cat2 = new Cat();
		
		//WHEN
		Set<Cat> when = new HashSet<>(Arrays.asList(cat,cat2));
		
		//THEN
		assertThat(when.size()).isEqualTo(1);
	}
}
