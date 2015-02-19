package dk.muj.derius.swordfighting;

import java.util.Optional;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.massivecraft.massivecore.util.MUtil;

import dk.muj.derius.api.DPlayer;
import dk.muj.derius.util.AbilityUtil;
import dk.muj.derius.util.Listener;

public class SwordfightingListener implements Listener
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //

	private static SwordfightingListener i = new SwordfightingListener();
	public static SwordfightingListener get() { return i; }
	
	private SwordfightingListener()
	{
		i = this;
		Listener.registerPlayerAttackKeys(SwordfightingListener.get(), MUtil.SWORD_MATERIALS);
		Listener.registerTools(MUtil.SWORD_MATERIALS);
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void onPlayerAttack(DPlayer attacker, EntityDamageByEntityEvent event)
	{	
		if ( ! attacker.isPlayer()) return;
		if (event.isCancelled()) return;
		
		// Are we handling pvp?
		boolean pve = event.getEntity() instanceof  Player ? true : false;
		
		if ( ! attacker.getPreparedTool().equals(Optional.empty()) && MUtil.SWORD_MATERIALS.contains(attacker.getPreparedTool().get()))
		{
			AbilityUtil.activateAbility(attacker, SwiftHit.get(), event, false);
		}
		
		AbilityUtil.activateAbility(attacker, Training.get(), event, false);
		
		// Give Exp
		double damage = event.getDamage();
		long exp = (long) (pve ? damage : damage * SwordfightingSkill.getPvpExpModifier());
		
		attacker.addExp(SwordfightingSkill.get(), exp);
		
		return;
	}
	
}
