package dk.muj.derius.swordfighting;

import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.massivecraft.massivecore.util.Txt;

import dk.muj.derius.api.Ability;
import dk.muj.derius.api.DPlayer;
import dk.muj.derius.api.Skill;
import dk.muj.derius.entity.ability.DeriusAbility;

public class Training extends DeriusAbility implements Ability
{
	private static Training i = new Training();
	public static Training get() { return i; }
	
	// -------------------------------------------- //
	// DESCRIPTION
	// -------------------------------------------- //
	
	public Training()
	{
		this.setName("Sword Training");
		
		this.setDesc("The higher your level is, the more damage you deal.");
		
		this.setType(AbilityType.PASSIVE);
	}
	
	// -------------------------------------------- //
	// SKILL & ID
	// -------------------------------------------- //
	
	@Override
	public String getId()
	{
		return "derius:swordfighting:training";
	}
	
	@Override
	public Skill getSkill()
	{
		return SwordfightingSkill.get();
	}

	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //

	@Override
	public Object onActivate(DPlayer dplayer, Object other)
	{
		if ( ! (other instanceof EntityDamageByEntityEvent)) return null;
		EntityDamageByEntityEvent event = (EntityDamageByEntityEvent) other;
		
		double damage = event.getDamage();
		
		damage += getBonusDamage(dplayer.getLvl(getSkill()));
		
		event.setDamage(damage);
		return null;
	}

	@Override
	public void onDeactivate(DPlayer dplayer, Object other)
	{
		// Nothing to do here
	}

	// -------------------------------------------- //
	// Level description
	// -------------------------------------------- //

	@Override
	public String getLvlDescriptionMsg(int lvl)
	{
		return Txt.parse("Your bonus damage for swords is %s.", getBonusDamage(lvl));
	}
	
	private double getBonusDamage(int level)
	{
		return (level / SwordfightingSkill.getLevelsPerDamageStep()) * SwordfightingSkill.getAmountPerStep();
	}

}
