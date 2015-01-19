package dk.muj.derius.swordfighting;

import com.massivecraft.massivecore.MassivePlugin;

import dk.muj.derius.swordfighting.entity.MConfColl;

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
		super.preEnable();
	
		MConfColl.get().init();
			
		SwordfightingSkill.get().register();
		FastHit.get().register();
		
		super.postEnable();
	}
}
