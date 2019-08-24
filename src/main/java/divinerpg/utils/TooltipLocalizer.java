package divinerpg.utils;

import net.minecraft.item.Item;
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

	public static String ammo(Item ammo) {
		return I18n.translateToLocal(AMMO).replace("|item|",
		        I18n.translateToLocal(ammo.getUnlocalizedName() + ".name"));
	}

	/**
	 * Writes ammo with color indicating if ammo is present
	 * @param ammo - ammo for cannon
	 * @param isPresent - if present print green else - red
	 * @return
	 */
	public static String ammo(Item ammo, boolean isPresent) {
		return I18n.translateToLocal(AMMO).replace("|item|", (isPresent ? Utils.GREEN : Utils.RED) +
				I18n.translateToLocal( ammo.getUnlocalizedName() + ".name"));
	}

	public static String arcanaConsumed(int ar) {
		return I18n.translateToLocal(ARCANA).replace("#", String.valueOf(ar));
	}

	public static String arcanaConsumed(float ar) {
		return I18n.translateToLocal(ARCANA).replace("#", String.valueOf(ar));
	}

	public static String arcanaDam(double dam) {
		return I18n.translateToLocal(ARCANADAM).replace("#", String.valueOf(dam));
	}

	public static String arcanaRegen(int ar) {
		return I18n.translateToLocal(ARCANAREGEN).replace("#", String.valueOf(ar));
	}

	public static String bowDam(String dam) {
		return I18n.translateToLocal(RANGEDDAM).replace("#", dam);
	}

	public static String burn(int seconds) {
		return I18n.translateToLocal(BURNS).replace("|seconds|", String.valueOf(seconds));
	}

	public static String cantBlock() {
		return I18n.translateToLocal(CANTBLOCK);
	}

	public static String damageReduction(double reduct, double fullReduct) {
		return I18n.translateToLocal(DAMAGEREDUCTION).replace("|percent|", reduct + "%").replace("|percentFull|",
		        fullReduct + "%");
	}

	public static String efficiency(double eff) {
		return I18n.translateToLocal(EFFICIENCY).replace("#", String.valueOf(eff));
	}

	public static String explosiveShots() {
		return I18n.translateToLocal(EXPLOSIVESHOTS);
	}

	public static String fullsetPerks() {
		return I18n.translateToLocal(FULLSETPERKS);
	}

	public static String homingShots() {
		return I18n.translateToLocal(HOMINGSHOTS);
	}

	public static String infiniteAmmo() {
		return I18n.translateToLocal(INFINITEAMMO);
	}

	public static String infiniteUses() {
		return I18n.translateToLocal(INFINITEUSES);
	}

	public static String meleeDam(double dam) {
		return I18n.translateToLocal(MELEEDAM).replace("#", String.valueOf(dam));
	}

	public static String noProtection() {
		return I18n.translateToLocal(NOPROT);
	}

	public static String poison(float seconds) {
		return I18n.translateToLocal(POISON).replace("|seconds|", String.valueOf(seconds));
	}

	public static String rangedAndMelee(double dam) {
		return I18n.translateToLocal(RANGEDNMELEE).replace("#", String.valueOf(dam));
	}

	public static String rangedDam(double dam) {
		return I18n.translateToLocal(RANGEDDAM).replace("#", String.valueOf(dam));
	}

	public static String slow(double seconds) {
		return I18n.translateToLocal(SLOWS).replace("|seconds|", String.valueOf(seconds));
	}

	public static String usesRemaining(int uses) {
		return I18n.translateToLocal(USES).replace("#", String.valueOf(uses));
	}

	public static String vethean() {
		return Utils.GREEN + I18n.translateToLocal(VETHEAN);
	}
}