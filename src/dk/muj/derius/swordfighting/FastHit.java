package dk.muj.derius.swordfighting;

import java.util.Optional;

import dk.muj.derius.ability.Ability;
import dk.muj.derius.ability.AbilityType;
import dk.muj.derius.entity.MPlayer;
import dk.muj.derius.skill.Skill;
import dk.muj.derius.swordfighting.entity.MConf;

public class FastHit extends Ability
{
	private static FastHit i = new FastHit();
	public static FastHit get() { return i; }
	
	// -------------------------------------------- //
	// DESCRIPTION
	// -------------------------------------------- //
	
	public FastHit()
	{
		this.setName("Doubledrop and replace");
		
		this.setDescription("gives doubledrop and sometimes replants it");
		
		this.setType(AbilityType.PASSIVE);
	}
	
	// -------------------------------------------- //
	// SKILL & ID
	// -------------------------------------------- //
	
	@Override
	public int getId()
	{
		return MConf.get().getFasthitId;
	}
	
	@Override
	public Skill getSkill()
	{
		return SwordfightingSkill.get();
	}

	// -------------------------------------------- //
	// ABILITY ACTIVATION
	// -------------------------------------------- //
	@Override
	public Optional<Object> onActivate(MPlayer p, Object other)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onDeactivate(MPlayer p, Object other)
	{
		// TODO Auto-generated method stub
	}
	
	// -------------------------------------------- //
	// Level description
	// -------------------------------------------- //
	
	@Override
	public String getLvlDescription(int lvl)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
