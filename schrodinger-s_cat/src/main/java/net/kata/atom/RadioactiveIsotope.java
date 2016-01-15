package net.kata.atom;

import java.util.Random;

public class RadioactiveIsotope {

	private boolean desintegre = false;
	private static Random RANDOM = new Random();

	public RadioactiveIsotope() {
		super();
	}

	RadioactiveIsotope(boolean desintegre) {
		this.desintegre = desintegre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (desintegre ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RadioactiveIsotope))
			return false;
		RadioactiveIsotope other = (RadioactiveIsotope) obj;
		if (desintegre != other.desintegre)
			return false;
		return true;
	}

	public RadioactiveIsotope passTime() {
		return RadioactiveIsotope.mayDesintegrate(RANDOM);
	}

	@Override
	public String toString() {
		return "RadioactiveIsotope [desintegre=" + desintegre + "]";
	}

	static RadioactiveIsotope mayDesintegrate(Random random) {
		int nextInt = random.nextInt(2);
		return nextInt == 0 ? new RadioactiveIsotope(false) : new RadioactiveIsotope(true);
	}

	public boolean isDesintegre() {
		return desintegre;
	}

}
