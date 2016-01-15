package net.kata;

import net.kata.atom.RadioactiveIsotope;

public final class SchrodingertCatBox {
	
	private Cat cat;
	private RadioactiveIsotope radioactiveIsotope;
	
	public SchrodingertCatBox(Cat cat, RadioactiveIsotope radioactiveIsotope) {
		super();
		this.cat = cat;
		this.radioactiveIsotope = radioactiveIsotope;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cat == null) ? 0 : cat.hashCode());
		result = prime * result + ((radioactiveIsotope == null) ? 0 : radioactiveIsotope.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SchrodingertCatBox))
			return false;
		SchrodingertCatBox other = (SchrodingertCatBox) obj;
		if (cat == null) {
			if (other.cat != null)
				return false;
		} else if (!cat.equals(other.cat))
			return false;
		if (radioactiveIsotope == null) {
			if (other.radioactiveIsotope != null)
				return false;
		} else if (!radioactiveIsotope.equals(other.radioactiveIsotope))
			return false;
		return true;
	}

	public SchrodingertCatBox passTime() {
		return new SchrodingertCatBox(cat, radioactiveIsotope.passTime());
	}

}
