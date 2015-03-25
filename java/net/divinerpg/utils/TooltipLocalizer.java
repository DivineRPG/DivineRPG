package net.divinerpg.utils;

import net.minecraft.item.Item;
import net.minecraft.util.StatCollector;

public class TooltipLocalizer {

    protected static final String USES = "tooltip.uses",
            INFINITEUSES = "tooltip.infiniteUses",
            ARCANA = "tooltip.arcana",
            MELEEDAM = "tooltip.meleeDam",
            RANGEDDAM = "tooltip.rangedDam",
            ARCANADAM = "tooltip.arcanaDam",
            INFINITEAMMO = "tooltip.infiniteAmmo",
            AMMO = "tooltip.ammo",
            RANGEDNMELEE = "tooltip.rangedAndMeleeDam",
            ARCANAREGEN = "tooltip.regensArcana",
            EXPLOSIVESHOTS = "tooltip.explosiveProjectiles",
            HOMINGSHOTS = "tooltip.homingProjectiles",
            FULLSETPERKS = "tooltip.fullSetPerks",
            DAMAGEREDUCTION = "tooltip.damageReduction",
            NOPROT = "tooltip.noProtection",
            VETHEAN = "tooltip.vethean",
            EFFICIENCY = "tooltip.efficiency",
            CANTBLOCK = "tooltip.cannotBlock";

    public static String usesRemaining(int uses) {
        return StatCollector.translateToLocal(USES).replace("#", String.valueOf(uses));
    }

    public static String arcanaConsumed(int ar) {
        return StatCollector.translateToLocal(ARCANA).replace("#", String.valueOf(ar));
    }

    public static String meleeDam(double dam) {
        return StatCollector.translateToLocal(MELEEDAM).replace("#", String.valueOf(dam));
    }

    public static String rangedDam(double dam) {
        return StatCollector.translateToLocal(RANGEDDAM).replace("#", String.valueOf(dam));
    }
    
    public static String bowDam(String dam) {
        return StatCollector.translateToLocal(RANGEDDAM).replace("#", dam);
    }

    public static String arcanaDam(double dam) {
        return StatCollector.translateToLocal(ARCANADAM).replace("#", String.valueOf(dam));
    }

    public static String ammo(Item ammo) {
        return StatCollector.translateToLocal(AMMO).replace("|item|", StatCollector.translateToLocal(ammo.getUnlocalizedName() + ".name"));
    }

    public static String infiniteAmmo() {
        return StatCollector.translateToLocal(INFINITEAMMO);
    }

    public static String infiniteUses() {
        return StatCollector.translateToLocal(INFINITEUSES);
    }

    public static String rangedAndMelee(double dam) {
        return StatCollector.translateToLocal(RANGEDNMELEE).replace("#", String.valueOf(dam));
    }

    public static String arcanaRegen(int ar) {
        return StatCollector.translateToLocal(ARCANAREGEN).replace("#", String.valueOf(ar));
    }
    
    public static String explosiveShots() {
        return StatCollector.translateToLocal(EXPLOSIVESHOTS);
    }
    
    public static String homingShots() {
        return StatCollector.translateToLocal(HOMINGSHOTS);
    }
    
    public static String damageReduction(double reduct, double fullReduct) {
        return StatCollector.translateToLocal(DAMAGEREDUCTION).replace("|percent|", reduct + "%").replace("|percentFull|", fullReduct + "%");
    }
    
    public static String fullsetPerks() {
        return StatCollector.translateToLocal(FULLSETPERKS);
    }
    
    public static String noProtection() {
        return StatCollector.translateToLocal(NOPROT);
    }
    
    public static String vethean() {
        return Util.GREEN + StatCollector.translateToLocal(VETHEAN);
    }
    
    public static String cantBlock() {
        return StatCollector.translateToLocal(CANTBLOCK);
    }
    
    public static String efficiency(double eff) {
        return StatCollector.translateToLocal(EFFICIENCY).replace("#", String.valueOf(eff));
    }
}
