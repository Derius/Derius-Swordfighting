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
	// public int getNoviceId = 51; // currently none
	
	/**
	 * The Id of the fast hit Ability. Each ability has it's own Id
	 */
	public int getFasthitId = 52;
	
	// -------------------------------------------- //
	// ABILITY REQUIREMENTS
	// -------------------------------------------- //
	


}
