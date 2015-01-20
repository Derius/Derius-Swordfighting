package dk.muj.derius.swordfighting.entity;

import com.massivecraft.massivecore.store.Entity;

public class MConf extends Entity<MConf>
{
	// -------------------------------------------- //
	// META
	// -------------------------------------------- //
	
	protected static transient MConf i;
	public static MConf get() { return i; }
	
	// -------------------------------------------- //
	// ID DEFINITION
	// -------------------------------------------- //
	
	/* 
	 * Note: skillId and abilityId are not related,
	 * but we use the tenners to define the skillId and all the values in between as the abilityId's.
	 */
	 
	/**
	 * The Id of the skill, there is only one of these in each skill.
	 */
	public int getSkillId = 50;
	
	/**
	 * The Id of the passive Ability. Each ability has it's own Id
	 */
	public int getSwordTrainingId = 51;
	
	/**
	 * The Id of the fast hit Ability. Each ability has it's own Id
	 */
	public int getFasthitId = 52;

	private double pvpExpModifier = 1.5;
	public double getPvpExpModifier() { return pvpExpModifier; }
	
	private double damagePerLevels = 0.5;
	public double getDamagePerLevels() { return damagePerLevels; }
	
	private int levelsPerDamageIncrease = 100;
	public int getLevelsPerDamageIncrease() { return levelsPerDamageIncrease; }




	
	// -------------------------------------------- //
	// ABILITY REQUIREMENTS
	// -------------------------------------------- //
	


}
