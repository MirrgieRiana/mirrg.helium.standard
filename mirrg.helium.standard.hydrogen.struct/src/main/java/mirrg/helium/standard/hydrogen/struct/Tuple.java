package mirrg.helium.standard.hydrogen.struct;

import java.io.Serializable;

public class Tuple<X, Y> implements Serializable
{

	private static final long serialVersionUID = 3499078220999926072L;

	private X x;
	private Y y;

	public Tuple(X x, Y y)
	{
		this.x = x;
		this.y = y;
	}

	public X getX()
	{
		return x;
	}

	public Y getY()
	{
		return y;
	}

	@Override
	public String toString()
	{
		return "Tuple [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Tuple<?, ?> other = (Tuple<?, ?>) obj;
		if (x == null) {
			if (other.x != null) return false;
		} else if (!x.equals(other.x)) return false;
		if (y == null) {
			if (other.y != null) return false;
		} else if (!y.equals(other.y)) return false;
		return true;
	}

}