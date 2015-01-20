package dk.muj.derius.swordfighting;

import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.massivecraft.massivecore.util.Txt;

import dk.muj.derius.ability.Ability;
import dk.muj.derius.ability.AbilityType;
import dk.muj.derius.entity.MPlayer;
import dk.muj.derius.skill.Skill;
import dk.muj.derius.swordfighting.entity.MConf;

public class SwordTraining extends Ability
{
	private static SwordTraining i = new SwordTraining();
	public static SwordTraining get() { return i; }
	
	// -------------------------------------------- //
	// DESCRIPTION
	// -------------------------------------------- //
	
	public SwordTraining()
	{
		this.setName("Sword Training");
		
		this.setDescription("Your level increases your damage.");
		
		this.setType(AbilityType.PASSIVE);
	}
	
	// -------------------------------------------- //
	// SKILL & ID
	// -------------------------------------------- //
	
	@Override
	public int getId()
	{
		return MConf.get().getSwordTrainingId;
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
	public Object onActivate(MPlayer p, Object other)
	{
		if ( ! (other instanceof EntityDamageByEntityEvent)) return null;
		EntityDamageByEntityEvent event = (EntityDamageByEntityEvent) other;
		
		double damage = event.getDamage();
		int playerLevel = p.getLvl(SwordfightingSkill.get());
		double modifier = MConf.get().getDamagePerLevels();
		int perLevel = MConf.get().getLevelsPerDamageIncrease();
		damage = damage + (playerLevel / perLevel * modifier);
		
		event.setDamage(damage);
		return null;
	}

	@Override
	public void onDeactivate(MPlayer p, Object other)
	{
		// Nothing to do here
	}

	// -------------------------------------------- //
	// Level description
	// -------------------------------------------- //
	
	// TODO: Change to bonusdamage
	@Override
	public String getLvlDescription(int lvl)
	{
		return Txt.parse("Your bonus damage for sowrds is %s.", 5);
	}
}
