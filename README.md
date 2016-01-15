# Schrödinger's cat
Functionnal Intepretation of Schrödinger's cat paradox

### More info
[Schrödinger's cat (Wikipedia)](https://en.wikipedia.org/wiki/Schr%C3%B6dinger%27s_cat)

## Focus on the interessant test
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

### Test Coverage

| Element                         | Coverage | Covered Instructions | Missed Instructions | Total Instructions |
|---------------------------------|----------|----------------------|---------------------|--------------------|
| Schrodinger-s_cat               | 100,0 %  | 796                  | 0                   | 796                |
| schrodinger-s_cat/src/main/java | 100,0 %  | 277                  | 0                   | 277                |
| net.kata                        | 100,0 %  | 181                  | 0                   | 181                |
| Cat.java                        | 100,0 %  | 37                   | 0                   | 37                 |
| Experimentation.java            | 100,0 %  | 14                   | 0                   | 14                 |
| SchrodingertCatBox.java         | 100,0 %  | 127                  | 0                   | 127                |
| Time.java                       | 100,0 %  | 3                    | 0                   | 3                  |
| net.kata.atom                   | 100,0 %  | 96                   | 0                   | 96                 |
| schrodinger-s_cat/src/test/java | 100,0 %  | 519                  | 0                   | 519                |
| net.kata                        | 100,0 %  | 238                  | 0                   | 238                |
| CatTest.java                    | 100,0 %  | 50                   | 0                   | 50                 |
| SchrodingertCatBoxTest.java     | 100,0 %  | 188                  | 0                   | 188                |
| net.kata.atom                   | 100,0 %  | 281                  | 0                   | 281                |
| RadioactiveIsotopeTest.java     | 100,0 %  | 281                  | 0                   | 281                |

Coverage generated with [Coverage for Eclipse](http://eclemma.org/)

Table generated with http://www.tablesgenerator.com/markdown_tables
