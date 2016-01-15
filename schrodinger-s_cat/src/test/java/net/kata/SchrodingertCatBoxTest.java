package net.kata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import net.kata.atom.RadioactiveIsotope;

public class SchrodingertCatBoxTest {

	@Test
	public final void may_kill_the_cat_when_open_the_box() {
		// GIVEN
		SchrodingertCatBox given = Experimentation.start(new Cat(), new RadioactiveIsotope());
		assertThat(given).isNotNull();

		// WHEN
		Time.pass(given);

	}

	@Test
	public void should_box_be_equals_when_composants_are_equals() {
		// GIVEN
		Cat cat = new Cat();
		RadioactiveIsotope radioactiveIsotope = new RadioactiveIsotope();
		SchrodingertCatBox schrodingertCatBox1 = new SchrodingertCatBox(cat, radioactiveIsotope);
		assertThat(schrodingertCatBox1).isEqualTo(schrodingertCatBox1);
		SchrodingertCatBox schrodingertCatBox2 = new SchrodingertCatBox(cat, radioactiveIsotope);

		// WHEN
		boolean when = schrodingertCatBox1.equals(schrodingertCatBox2);

		// THEN
		assertThat(when).isTrue();
	}

	@Test
	public void should_box_not_be_equals_when_one_null_or_otherClass() {
		SchrodingertCatBox schrodingertCatBox1 = new SchrodingertCatBox(null, null);

		assertFalse(schrodingertCatBox1.equals(null));
		assertFalse(schrodingertCatBox1.equals(new Cat()));
		
		assertThat(schrodingertCatBox1).isNotEqualTo(new SchrodingertCatBox(new Cat(), null));
		assertThat(schrodingertCatBox1).isNotEqualTo(new SchrodingertCatBox(null, new RadioactiveIsotope()));
	}

	@Test
	public void should_box_be_compare_in_set() {
		// GIVEN
		Cat cat = new Cat();
		RadioactiveIsotope radioactiveIsotope = new RadioactiveIsotope();
		SchrodingertCatBox schrodingertCatBox1 = new SchrodingertCatBox(cat, radioactiveIsotope);

		// WHEN
		Set<SchrodingertCatBox> when = new HashSet<>(Arrays.asList(schrodingertCatBox1, schrodingertCatBox1));

		// THEN
		assertThat(when.size()).isEqualTo(1);

		// WHEN
		when = new HashSet<>(Arrays.asList(schrodingertCatBox1, new SchrodingertCatBox(null, radioactiveIsotope)));

		// THEN
		assertThat(when.size()).isEqualTo(2);
	}

}
