package net.kata;

import java.util.function.BiFunction;

import net.kata.atom.RadioactiveIsotope;

public interface Experimentation {
	
	static  SchrodingertCatBox start(Cat cat, RadioactiveIsotope atom) {
		BiFunction<Cat, RadioactiveIsotope, SchrodingertCatBox>  start = ((c,a) -> {return new SchrodingertCatBox(c, a);});
		return start.apply(cat,atom);
	}
	
}
