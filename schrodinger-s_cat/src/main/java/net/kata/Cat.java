package net.kata;

public class Cat {

	private final String cri = "Miaou!";

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cri == null) ? 0 : cri.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Cat))
			return false;
		Cat other = (Cat) obj;
		if (cri == null) {
			if (other.cri != null)
				return false;
		} else if (!cri.equals(other.cri))
			return false;
		return true;
	}
	
	
	
}
