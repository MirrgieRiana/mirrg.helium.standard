package mirrg.helium.standard.hydrogen.event;

import mirrg.helium.standard.hydrogen.event.api.INitrogenEventManager;

public class HNitrogenEvent
{

	public static INitrogenEventManager createInstance()
	{
		return new NitrogenEventManagerImpl();
	}

}
