package dk.muj.derius.swordfighting;

import com.massivecraft.massivecore.MassivePlugin;

public class DeriusSwordfighting extends MassivePlugin
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static DeriusSwordfighting i;
	public static DeriusSwordfighting get() { return i; }
	public DeriusSwordfighting() { i = this; }
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void onEnable()
	{
		if ( ! super.preEnable()) return;
			
		SwordfightingSkill.get().register();
		SwiftHit.get().register();
		Training.get().register();
		
		SwordfightingListener.get();
		
		super.postEnable();
	}
}
