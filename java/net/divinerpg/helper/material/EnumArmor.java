package net.divinerpg.helper.material;

import net.divinerpg.helper.Util;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public enum EnumArmor {

    ANGELIC(Util.addArmorMaterial("Angelic", 0, new int[] { 3, 4, 3, 2 }, 10), "angelic", true, 50),
    DIVINE(Util.addArmorMaterial("Divine", 0, new int[] { 9, 9, 9, 8 }, 10), "divine", true, 75),
    BEDROCK(Util.addArmorMaterial("Bedrock", 0, new int[] { 9, 9, 9, 8 }, 10), "bedrock", true, 75),
    REALMITE(Util.addArmorMaterial("Realmite", 5000, new int[] { 2, 2, 2, 2 }, 10), "realmite", false, 33),
    ELITE_REALMITE(Util.addArmorMaterial("Elite Realmite", 0, new int[] { 4, 4, 4, 3 }, 10), "eliteRealmite", true, 50),
    ARLEMITE(Util.addArmorMaterial("Arlemite", 0, new int[] { 3, 4, 3, 2 }, 22), "arlemite", true, 50),
    RUPEE(Util.addArmorMaterial("Rupee", 0, new int[] { 9, 9, 9, 8 }, 10), "rupee", true, 50),
    KRAKEN(Util.addArmorMaterial("Kraken", 5000, new int[] { 2, 4, 2, 2 }, 10), "kraken", false, 30),
    COSTUMES(Util.addArmorMaterial("Costumes", 0, new int[] { 0, 0, 0, 0 }, 22), "costumes", true, 0),
    INFERNO(Util.addArmorMaterial("Inferno", 0, new int[] { 2, 6, 5, 2 }, 10), "inferno", true, 60),
    AQUATIC(Util.addArmorMaterial("Aquastrive", 0, new int[] { 6, 7, 6, 6 }, 10), "aquastrive", true, 55),
    SHADOW(Util.addArmorMaterial("Shadow", 0, new int[] { 3, 4, 3, 2 }, 10), "shadow", true, 60),
    NETHERITE(Util.addArmorMaterial("Netherite", 0, new int[] { 2, 4, 3, 2 }, 10), "netherite", true, 50),
    ENDER(Util.addArmorMaterial("Ender", 0, new int[] { 7, 7, 6, 6 }, 10), "ender", true, 65),
    EDEN(Util.addArmorMaterial("Eden", 0, new int[] { 3, 4, 3, 2 }, 10), "eden", true, 60),
    WILD(Util.addArmorMaterial("Wild", 0, new int[] { 3, 4, 3, 2 }, 10), "wildwood", true, 65),
    APALACHIA(Util.addArmorMaterial("Apalachia", 0, new int[] { 3, 4, 3, 2 }, 10), "apalachia", true, 72),
    SKYTHERN(Util.addArmorMaterial("Skythern", 0, new int[] { 3, 4, 3, 2 }, 10), "skythern", true, 75),
    MORTUM(Util.addArmorMaterial("Mortum", 0, new int[] { 3, 4, 3, 2 }, 10), "mortum", true, 80),
    HALITE(Util.addArmorMaterial("Halite", 0, new int[] { 4, 5, 4, 3 }, 12), "halite", true, 83),
    SANTA(Util.addArmorMaterial("Santa", 0, new int[] { 1, 1, 1, 1 }, 10), "santa", true, 0),
    KORMA(Util.addArmorMaterial("Korma", 0, new int[] { 9, 9, 9, 9 }, 22), "korma", true, 45);

    private ArmorMaterial armorMaterial;
    private String        type;
    private boolean       undamageable;
    private int           damageReduction;

    private EnumArmor(ArmorMaterial armorMaterial, String type, boolean undamageable, int damageReduction) {
        this.armorMaterial = armorMaterial;
        this.type = type;
        this.undamageable = undamageable;
        this.damageReduction = damageReduction;
    }

    public ArmorMaterial getArmorMaterial() {
        return armorMaterial;
    }

    public String getType() {
        return type;
    }

    public boolean isUndamageable() {
        return undamageable;
    }

    public int getDamageReduction() {
        return damageReduction;
    }

}
