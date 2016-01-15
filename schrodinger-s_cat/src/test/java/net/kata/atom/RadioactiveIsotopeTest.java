package net.kata.atom;

import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

import net.kata.Cat;
import net.kata.SchrodingertCatBox;
import net.kata.atom.RadioactiveIsotope;

public class RadioactiveIsotopeTest {

	@Test
	public final void shouldReturnTwoStateRadioisotope() {
		// GIVEN
		final Random given = new Random(1000);

		// WHEN
		RadioactiveIsotope when = RadioactiveIsotope.mayDesintegrate(given);
		assertThat(when).isNotNull();

		// WHEN
		when = new RadioactiveIsotope();
		assertThat(when.isDesintegre()).isFalse();
		
		int count = 0;
		while (!when.isDesintegre()) {
			when = when.passTime();
			count++;
		}
		
		//THEN
		assertThat(when.isDesintegre()).isTrue();
		assertThat(count).isBetween(1, 10);
		
		// WHEN
				when = new RadioactiveIsotope(true);
				assertThat(when.isDesintegre()).isTrue();
				
				 count = 0;
				while (when.isDesintegre()) {
					when = when.passTime();
					count++;
				}
				
				//THEN
				assertThat(when.isDesintegre()).isFalse();
				assertThat(count).isBetween(1, 10);
	}

	@Test
	public void should_box_not_be_equals_when_composants_are_not_equals() {
		// GIVEN
		Cat cat = new Cat();
		Cat cat2 = null;

		RadioactiveIsotope radioactiveIsotope = new RadioactiveIsotope();
		SchrodingertCatBox schrodingertCatBox1 = new SchrodingertCatBox(cat, radioactiveIsotope);
		SchrodingertCatBox schrodingertCatBox2 = new SchrodingertCatBox(cat2, new RadioactiveIsotope(true));

		// WHEN
		boolean when = schrodingertCatBox1.equals(schrodingertCatBox2);

		// THEN
		assertThat(when).isFalse();

		// GIVEN
		schrodingertCatBox1 = new SchrodingertCatBox(cat, null);
		schrodingertCatBox2 = new SchrodingertCatBox(cat2, new RadioactiveIsotope(true));

		// WHEN
		when = schrodingertCatBox1.equals(schrodingertCatBox2);

		// THEN
		assertThat(when).isFalse();

		// GIVEN
		schrodingertCatBox1 = new SchrodingertCatBox(cat, radioactiveIsotope);
		schrodingertCatBox2 = new SchrodingertCatBox(cat, new RadioactiveIsotope(true));

		// WHEN
		when = schrodingertCatBox1.equals(schrodingertCatBox2);

		// THEN
		assertThat(when).isFalse();

	}

	@Test
	public void should_RadioactiveIsotope_not_be_equals_when_one_null_or_otherClass() {

		// GIVEN
		RadioactiveIsotope radioactiveIsotope = new RadioactiveIsotope();
		assertThat(radioactiveIsotope.toString()).isEqualTo("RadioactiveIsotope [desintegre=false]");

		assertFalse(radioactiveIsotope.equals(null));
		assertFalse(radioactiveIsotope.equals(new Cat()));
	}

	@Test
	public void should_box_be_compare_in_set_when_RadioIsotope_are_different() {
		// GIVEN
		Cat cat = new Cat();
		RadioactiveIsotope radioactiveIsotope = new RadioactiveIsotope();
		SchrodingertCatBox schrodingertCatBox1 = new SchrodingertCatBox(cat, radioactiveIsotope);
		SchrodingertCatBox schrodingertCatBox2 = new SchrodingertCatBox(cat, new RadioactiveIsotope(true));
		SchrodingertCatBox schrodingertCatBox3 = new SchrodingertCatBox(cat, null);

		// WHEN
		Set<SchrodingertCatBox> when = new HashSet<>(Arrays.asList(schrodingertCatBox1, schrodingertCatBox2));

		// THEN
		assertThat(when.size()).isEqualTo(2);

		// WHEN
		when = new HashSet<>(Arrays.asList(schrodingertCatBox1, schrodingertCatBox2));

		// THEN
		assertThat(when.size()).isEqualTo(2);
		
		//WHEN
		when.add(schrodingertCatBox3);
		assertThat(when.size()).isEqualTo(3);
	}

	@Test
	public void should_two_RadioactiveIsotope_be_equals_when_same_state() {
		// GIVEN
		RadioactiveIsotope obj2 = new RadioactiveIsotope();
		RadioactiveIsotope radioactiveIsotope = new RadioactiveIsotope();

		// WHEN
		boolean when = radioactiveIsotope.equals(obj2);

		// THEN
		assertThat(when).isTrue();
	}
}
