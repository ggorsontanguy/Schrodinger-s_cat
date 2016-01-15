# Schrodinger-s_cat
Functionnal Intepretation of Schrödinger's cat paradox

[Schrödinger's cat (Wikipedia)](https://en.wikipedia.org/wiki/Schr%C3%B6dinger%27s_cat)

```java
	@Test
	public final void should_kill_the_cat_when_open_the_box() {
		// GIVEN
		SchrodingertCatBox given = Experimentation.start(new Cat(), new RadioactiveIsotope());
		assertThat(given).isNotNull();
		assertThat(given.toString()).isEqualTo("SchrodingertCatBox [cat=Cat [cri=Miaou!], radioactiveIsotope=RadioactiveIsotope [desintegre=false]]");
		Optional<Cat> liveCat = given.openTheBox();
		assertNotNull(liveCat);
		assertTrue(liveCat.isPresent());

		// WHEN
		SchrodingertCatBox when = given;
		int count = 0;
		while(when.openTheBox().isPresent()) {
			when = Time.pass(when);
			count++;
		}
		
		//THEN
		Optional<Cat> deadCat = when.openTheBox();
		assertFalse(deadCat.isPresent());
		assertThat(count).isGreaterThan(0);
	}
```
