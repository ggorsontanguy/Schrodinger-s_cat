package net.kata.atom;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

import net.kata.Cat;
import net.kata.SchrodingertCatBox;

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
	public void shouldBoxNotBeEqualsWhenComposantsAreNotEquals() {
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
	public void shouldRadioactiveIsotopeNotBeEqualsWhenOneNullOrOtherClass() {

		// GIVEN
		RadioactiveIsotope radioactiveIsotope = new RadioactiveIsotope();
		assertThat(radioactiveIsotope.toString()).isEqualTo("RadioactiveIsotope [desintegre=false]");

		assertThat(radioactiveIsotope).isNotNull();
		assertThat(radioactiveIsotope).isNotEqualTo(new Cat());
	}

	@Test
	public void shouldBoxBeCompareInSetWhenRadioIsotopeAreDifferent() {
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
	public void shouldTwoRadioactiveIsotopeBeEqualsWhenSameState() {
		// GIVEN
		RadioactiveIsotope obj2 = new RadioactiveIsotope();
		RadioactiveIsotope radioactiveIsotope = new RadioactiveIsotope();

		// WHEN
		boolean when = radioactiveIsotope.equals(obj2);

		// THEN
		assertThat(when).isTrue();
	}
}
