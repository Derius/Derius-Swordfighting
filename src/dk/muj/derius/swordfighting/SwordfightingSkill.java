package dk.muj.derius.swordfighting;

import dk.muj.derius.skill.Skill;
import dk.muj.derius.swordfighting.entity.MConf;

public class SwordfightingSkill extends Skill
{
	
	private static SwordfightingSkill i = new SwordfightingSkill();
	public static SwordfightingSkill get() { return i; }
	
	// -------------------------------------------- //
	// DESCRIPTION
	// -------------------------------------------- //
	
	public SwordfightingSkill()
	{
		this.setName("Swordfighting");
		
		this.setDescription("Makes you better at fighting with swords.");
		
		this.addEarnExpDesc("Fight players or mobs!");
	}
	@Override
	public int getId()
	{
		return MConf.get().getSkillId;
	}

}
