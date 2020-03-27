package divinerpg.utils;

import net.minecraft.item.Item;

public class TooltipLocalizer {
    protected static final String USES = "tooltip.uses", INFINITEUSES = "tooltip.uses.infinite",
            ARCANA = "tooltip.arcana", ARCANAREGEN = "tooltip.arcana.regen", MELEEDAM = "tooltip.damage.melee",
            RANGEDDAM = "tooltip.damage.ranged", RANGEDNMELEE = "tooltip.damage.both",
            ARCANADAM = "tooltip.damage.arcana", DAMAGEREDUCTION = "tooltip.damage.reduction", AMMO = "tooltip.ammo",
            INFINITEAMMO = "tooltip.ammo.infinite", EXPLOSIVESHOTS = "tooltip.shots.explosive",
            HOMINGSHOTS = "tooltip.shots.homing", FULLSETPERKS = "tooltip.fullset", NOPROT = "tooltip.noprotection",
            EFFICIENCY = "tooltip.efficiency", CANTBLOCK = "tooltip.noblock", POISON = "tooltip.effect.poisons",
            BURNS = "tooltip.effect.burns", SLOWS = "tooltip.effect.slows", 
                    SINGLEUSE = "tooltip.uses.single";

    public static String ammo(Item ammo) {
        return TooltipHelper.localize(AMMO).replace("|item|",
                TooltipHelper.localize(ammo.getUnlocalizedName() + ".name"));
    }

    /**
     * Writes ammo with color indicating if ammo is present
     * 
     * @param ammo
     *            - ammo for cannon
     * @param isPresent
     *            - if present print green else - red
     * @return
     */
    public static String ammo(Item ammo, boolean isPresent) {
        return TooltipHelper.localize(AMMO).replace("|item|",
                (isPresent ? Utils.GREEN : Utils.RED) +
                        TooltipHelper.localize(ammo.getUnlocalizedName() + ".name"));
    }

    public static String arcanaConsumed(int ar) {
        return TooltipHelper.localize(ARCANA).replace("#", String.valueOf(ar));
    }

    public static String arcanaConsumed(float ar) {
        return TooltipHelper.localize(ARCANA).replace("#", String.valueOf(ar));
    }

    public static String arcanaConsumed(String dam) {
        return TooltipHelper.localize(ARCANA).replace("#", dam);
    }

    public static String arcanaDam(double dam) {
        return TooltipHelper.localize(ARCANADAM).replace("#", String.valueOf(dam));
    }

    public static String arcanaRegen(int ar) {
        return TooltipHelper.localize(ARCANAREGEN).replace("#", String.valueOf(ar));
    }

    public static String bowDam(String dam) {
        return TooltipHelper.localize(RANGEDDAM).replace("#", dam);
    }

    public static String burn(int seconds) {
        return TooltipHelper.localize(BURNS).replace("|seconds|", String.valueOf(seconds));
    }

    public static String cantBlock() {
        return TooltipHelper.localize(CANTBLOCK);
    }

    public static String damageReduction(double reduct, double fullReduct) {
        return TooltipHelper.localize(DAMAGEREDUCTION).replace("|percent|", reduct + "%").replace("|percentFull|",
                fullReduct + "%");
    }

    public static String efficiency(double eff) {
        return TooltipHelper.localize(EFFICIENCY).replace("#", String.valueOf(eff));
    }

    public static String explosiveShots() {
        return TooltipHelper.localize(EXPLOSIVESHOTS);
    }

    public static String fullsetPerks() {
        return TooltipHelper.localize(FULLSETPERKS);
    }

    public static String homingShots() {
        return TooltipHelper.localize(HOMINGSHOTS);
    }

    public static String infiniteAmmo() {
        return TooltipHelper.localize(INFINITEAMMO);
    }

    public static String infiniteUses() {
        return TooltipHelper.localize(INFINITEUSES);
    }

    public static String singleUse() {
        return TooltipHelper.localize(SINGLEUSE);
    }

    public static String meleeDam(double dam) {
        return TooltipHelper.localize(MELEEDAM).replace("#", String.valueOf(dam));
    }

    public static String noProtection() {
        return TooltipHelper.localize(NOPROT);
    }

    public static String poison(float seconds) {
        return TooltipHelper.localize(POISON).replace("|seconds|", String.valueOf(seconds));
    }

    public static String rangedAndMelee(double dam) {
        return TooltipHelper.localize(RANGEDNMELEE).replace("#", String.valueOf(dam));
    }

    public static String rangedDam(double dam) {
        return TooltipHelper.localize(RANGEDDAM).replace("#", String.valueOf(dam));
    }

    public static String slow(double seconds) {
        return TooltipHelper.localize(SLOWS).replace("|seconds|", String.valueOf(seconds));
    }

    public static String usesRemaining(int uses) {
        return TooltipHelper.localize(USES).replace("#", String.valueOf(uses));
    }
}