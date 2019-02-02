package naturix.divinerpg.utils;

import net.minecraft.util.text.translation.I18n;

public class TooltipLocalizer {
	protected static final String USES = "tooltip.uses", INFINITEUSES = "tooltip.uses.infinite",
	        ARCANA = "tooltip.arcana", ARCANAREGEN = "tooltip.arcana.regen", MELEEDAM = "tooltip.damage.melee",
	        RANGEDDAM = "tooltip.damage.ranged", RANGEDNMELEE = "tooltip.damage.both",
	        ARCANADAM = "tooltip.damage.arcana", DAMAGEREDUCTION = "tooltip.damage.reduction", AMMO = "tooltip.ammo",
	        INFINITEAMMO = "tooltip.ammo.infinite", EXPLOSIVESHOTS = "tooltip.shots.explosive",
	        HOMINGSHOTS = "tooltip.shots.homing", FULLSETPERKS = "tooltip.fullset", NOPROT = "tooltip.noprotection",
	        VETHEAN = "tooltip.vethean", EFFICIENCY = "tooltip.efficiency", CANTBLOCK = "tooltip.noblock",
	        POISON = "tooltip.effect.poisons", BURNS = "tooltip.effect.burns", SLOWS = "tooltip.effect.slows";

	public static String rangedDam(double dam) {
		return I18n.translateToLocal(RANGEDDAM).replace("#", String.valueOf(dam));
	}
}
