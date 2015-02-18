package dk.muj.derius.swordfighting;

import org.bukkit.Material;

import dk.muj.derius.api.Skill;
import dk.muj.derius.entity.skill.DeriusSkill;

public class SwordfightingSkill extends DeriusSkill implements Skill
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static SwordfightingSkill i = new SwordfightingSkill();
	public static SwordfightingSkill get() { return i; }
	
	public SwordfightingSkill()
	{
		// Skill properties
		this.setName("Swordfighting");
		
		this.setDesc("Makes you better at fighting with swords.");
		
		this.addEarnExpDescs("Fight players or mobs!");
		
		this.setIcon(Material.IRON_SWORD);
		
		// Config
		this.writeConfig("pvpExpModifier", 1.5);
		this.writeConfig("damagePerLevels", 0.5);
		this.writeConfig("levelsPerDamageIncrease", 100);
		
	}
	
	@Override
	public String getId()
	{
		return "derius:swordfighting";
		
	}
	
	// -------------------------------------------- //
	// CONFIG GETTERS
	// -------------------------------------------- //
	
	public static double getPvpExpModifier()
	{
		return get().readConfig("pvpExpModifier", double.class);
	}
	
	public static double getAmountPerIncrease()
	{
		return get().readConfig("damagePerLevels", double.class);
	}
	
	public static int getLevelsPerDamageIncrease()
	{
		return get().readConfig("levelsPerDamageIncrease", int.class);
	}

}
