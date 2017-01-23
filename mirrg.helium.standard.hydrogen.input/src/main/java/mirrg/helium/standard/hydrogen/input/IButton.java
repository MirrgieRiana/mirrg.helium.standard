package mirrg.helium.standard.hydrogen.input;

public interface IButton
{

	public default boolean isPressing()
	{
		return getState() > 0;
	}

	public default boolean isReleasing()
	{
		return getState() < 0;
	}

	public default boolean isPressing(int interval)
	{
		return isPressing() && (getState() - 1) % interval == 0;
	}

	public default boolean isReleasing(int interval)
	{
		return isReleasing() && (-getState() - 1) % interval == 0;
	}

	public int getState();

}
