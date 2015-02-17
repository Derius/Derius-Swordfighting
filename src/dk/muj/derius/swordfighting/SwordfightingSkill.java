package dk.muj.derius.swordfighting;

import java.util.ArrayList;
import java.util.List;

import com.massivecraft.massivecore.util.MUtil;

import dk.muj.derius.api.Ability;
import dk.muj.derius.api.Skill;
import dk.muj.derius.entity.skill.DeriusSkill;
import dk.muj.derius.swordfighting.entity.MConf;
import dk.muj.derius.util.Listener;

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
		
		// Listener
		Listener.registerPlayerAttackKeys(SwordfightingListener.get(), MUtil.SWORD_MATERIALS);
		Listener.registerTools(MUtil.SWORD_MATERIALS);
		
	}
	
	@Override
	public String getId()
	{
		return MConf.get().getSkillId;
		
	}

	@Override
	public List<Ability> getActiveAbilities()
	{
		List<Ability> activeAbilities = new ArrayList<Ability>();

		activeAbilities.add(SwiftHit.get());
		
		return activeAbilities;
	}

	@Override
	public List<Ability> getPassiveAbilities()
	{
		List<Ability> passiveAbilities = new ArrayList<Ability>();
		
		passiveAbilities.add(SwordTraining.get());
		
		return passiveAbilities;
	}

}
