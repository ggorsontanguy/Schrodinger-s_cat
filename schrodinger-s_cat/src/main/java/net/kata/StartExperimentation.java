package net.kata;

import java.util.function.BiFunction;

public class StartExperimentation {

	static BiFunction<Cat,RadioactiveIsotope , SchrodingertCatBox> start = (cat, atom) -> {
	       return new SchrodingertCatBox(cat,atom);
	    };

	public SchrodingertCatBox start (Cat cat, RadioactiveIsotope atom) {
		return start.apply(cat, atom);
	}
	
}
