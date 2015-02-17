package dk.muj.derius.swordfighting;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.massivecraft.massivecore.collections.WorldExceptionSet;

import dk.muj.derius.api.Ability;
import dk.muj.derius.api.DPlayer;
import dk.muj.derius.api.Skill;
import dk.muj.derius.entity.ability.DeriusAbility;
import dk.muj.derius.swordfighting.entity.MConf;

public class SwiftHit extends DeriusAbility implements Ability
{
	private static SwiftHit i = new SwiftHit();
	public static SwiftHit get() { return i; }
	
	// -------------------------------------------- //
	// DESCRIPTION
	// -------------------------------------------- //
	
	public SwiftHit()
	{
		this.setName("Swift Hit");
		
		this.setDesc("A swift hit that makes them weaker.");
		
		this.setType(AbilityType.ACTIVE);
	}
	
	// -------------------------------------------- //
	// SKILL & ID
	// -------------------------------------------- //
	
	@Override
	public String getId()
	{
		return MConf.get().getSwiftHitId;
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
	public Object onActivate(DPlayer dplayer, Object other)
	{
		if ( ! (other instanceof EntityDamageByEntityEvent)) return null;
		EntityDamageByEntityEvent event = (EntityDamageByEntityEvent) other;
		
		Entity entity = event.getEntity();
		if ( !(entity instanceof LivingEntity)) return null;
		LivingEntity opponent = (LivingEntity) entity;
		
		opponent.getActivePotionEffects();
		//opponent.addPotionEffect();
		// Apply lore to the sword
		// Apply sharpness to sword
		// apply speedeffect to player
		return other;
	}

	@Override
	public void onDeactivate(DPlayer dplayer, Object other)
	{
		// remove lore
		// remove sharpness from sword
		// remove potioneffect from player
		// apply damage to sword
		// send a message that it cuts the player if the sword breaks
	}
	
	// -------------------------------------------- //
	// Level description
	// -------------------------------------------- //
	
	@Override
	public String getLvlDescriptionMsg(int lvl)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setWorldsEarn(WorldExceptionSet worldsUse)
	{
		// TODO Auto-generated method stub
		
	}
}
