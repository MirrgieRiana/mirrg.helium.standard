package mirrg.helium.standard.hydrogen.struct;

import java.io.Serializable;

public class Tuple4<X, Y, Z, W> implements Serializable
{

	private static final long serialVersionUID = -3660672742737490205L;

	private X x;
	private Y y;
	private Z z;
	private W w;

	public Tuple4(X x, Y y, Z z, W w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	public X getX()
	{
		return x;
	}

	public Y getY()
	{
		return y;
	}

	public Z getZ()
	{
		return z;
	}

	public W getW()
	{
		return w;
	}

	@Override
	public String toString()
	{
		return "Tuple4 [x=" + x + ", y=" + y + ", z=" + z + ", w=" + w + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((w == null) ? 0 : w.hashCode());
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		result = prime * result + ((z == null) ? 0 : z.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Tuple4<?, ?, ?, ?> other = (Tuple4<?, ?, ?, ?>) obj;
		if (w == null) {
			if (other.w != null) return false;
		} else if (!w.equals(other.w)) return false;
		if (x == null) {
			if (other.x != null) return false;
		} else if (!x.equals(other.x)) return false;
		if (y == null) {
			if (other.y != null) return false;
		} else if (!y.equals(other.y)) return false;
		if (z == null) {
			if (other.z != null) return false;
		} else if (!z.equals(other.z)) return false;
		return true;
	}

}
