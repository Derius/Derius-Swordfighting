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
		this.writeConfig("damagePerStep", 0.5);
		this.writeConfig("levelsPerDamageStep", 100);
		this.writeConfig("swiftHitStaminaUsage", 25.0);
		
		this.writeConfig("isSpeedbuffEnabled", true);
		this.writeConfig("baseSpeedTicks", 100);
		this.writeConfig("speedSecondsPerStep", 0.25);
		this.writeConfig("speedLevelPerStep", 0.25);
		this.writeConfig("levelsPerSpeedStep", 50);
		this.writeConfig("maxSpeedLevel", 5);
		
		this.writeConfig("isCripplingdebuffEnabled", true);
		this.writeConfig("baseCripplingTicks", 100);
		this.writeConfig("cripplingSecondsPerStep", 0.25);
		this.writeConfig("cripplingLevelPerStep", 0.1);
		this.writeConfig("levelsPerCripplingStep", 50);
		this.writeConfig("maxCripplingLevel", 5);
		
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
		return get().readConfig("pvpExpModifier", Double.class);
	}
	
	public static double getAmountPerStep()
	{
		return get().readConfig("damagePerStep", Double.class);
	}
	
	public static int getLevelsPerDamageStep()
	{
		return get().readConfig("levelsPerDamageStep", Integer.class);
	}
	
	public static double getSwiftHitStaminaUsage()
	{
		return get().readConfig("swiftHitStaminaUsage", Double.class);
	}
	
	// Swiftness
	public static boolean isSpeedbuffEnabled()
	{
		return get().readConfig("isSpeedbuffEnabled", Boolean.class);
	}
	
	public static int getBaseSpeedDuration()
	{
		return get().readConfig("baseSpeedTicks", Integer.class);
	}
	
	public static double getSpeedSecondsPerStep()
	{
		return get().readConfig("speedSecondsPerStep", Double.class);
	}
	
	public static double getSpeedLevelPerStep()
	{
		return get().readConfig("speedLevelPerStep", Double.class);
	}
	
	public static int getLevelsPerSpeedStep()
	{
		return get().readConfig("levelsPerSpeedStep", Integer.class);
	}
	
	public static int getMaxSpeedLevel()
	{
		return get().readConfig("maxSpeedLevel", Integer.class);
	}
	
	// Crippling
	public static boolean isCripplingdebuffEnabled()
	{
		return get().readConfig("isCripplingdebuffEnabled", Boolean.class);
	}
	
	public static int getBaseCripplingDuration()
	{
		return get().readConfig("baseCripplingTicks", Integer.class);
	}
	
	public static double getCripplingSecondsPerStep()
	{
		return get().readConfig("cripplingSecondsPerStep", Double.class);
	}
	
	public static double getCripplingLevelPerStep()
	{
		return get().readConfig("cripplingLevelPerStep", Double.class);
	}
	
	public static int getLevelsPerCripplingStep()
	{
		return get().readConfig("levelsPerCripplingStep", Integer.class);
	}
	
	public static int getMaxCripplingLevel()
	{
		return get().readConfig("maxCripplingLevel", Integer.class);
	}

}
