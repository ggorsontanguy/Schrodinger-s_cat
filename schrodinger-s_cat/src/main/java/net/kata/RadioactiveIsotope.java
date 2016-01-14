package net.kata;

public class RadioactiveIsotope {
	
	private boolean desintegre = false;

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
	
	

}
