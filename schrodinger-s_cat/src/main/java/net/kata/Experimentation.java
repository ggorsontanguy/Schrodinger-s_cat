package net.kata;

import java.util.function.BiFunction;

@FunctionalInterface
public interface Experimentation extends BiFunction<Cat,RadioactiveIsotope , SchrodingertCatBox> {
	
	static Experimentation start(Cat cat, RadioactiveIsotope atom) {
		return (c, a) -> new SchrodingertCatBox(c, a);
	}
}
