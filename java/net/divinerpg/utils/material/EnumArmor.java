package net.divinerpg.utils.material;

import net.divinerpg.utils.Util;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public enum EnumArmor {

    ANGELIC(Util.addArmorMaterial("Angelic", 0, 10), "angelic", true, 50),
    DIVINE(Util.addArmorMaterial("Divine", 0, 10), "divine", true, 75),
    BEDROCK(Util.addArmorMaterial("Bedrock", 0, 10), "bedrock", true, 75),
    REALMITE(Util.addArmorMaterial("Realmite", 5000, 10), "realmite", false, 33),
    ELITE_REALMITE(Util.addArmorMaterial("Elite Realmite", 0, 10), "eliteRealmite", true, 50),
    ARLEMITE(Util.addArmorMaterial("Arlemite", 0, 22), "arlemite", true, 50),
    RUPEE(Util.addArmorMaterial("Rupee", 0, 10), "rupee", true, 50),
    KRAKEN(Util.addArmorMaterial("Kraken", 5000, 10), "kraken", false, 30),
    COSTUMES(Util.addArmorMaterial("Costumes", 0, 22), "costumes", true, 0),
    INFERNO(Util.addArmorMaterial("Inferno", 0, 10), "inferno", true, 60),
    AQUATIC(Util.addArmorMaterial("Aquastrive", 0, 10), "aquastrive", true, 55),
    SHADOW(Util.addArmorMaterial("Shadow", 0, 10), "shadow", true, 60),
    NETHERITE(Util.addArmorMaterial("Netherite", 0, 10), "netherite", true, 50),
    ENDER(Util.addArmorMaterial("Ender", 0, 10), "ender", true, 65),
    EDEN(Util.addArmorMaterial("Eden", 0, 10), "eden", true, 60),
    WILD(Util.addArmorMaterial("Wild", 0, 10), "wildwood", true, 65),
    APALACHIA(Util.addArmorMaterial("Apalachia", 0, 10), "apalachia", true, 72),
    SKYTHERN(Util.addArmorMaterial("Skythern", 0, 10), "skythern", true, 75),
    MORTUM(Util.addArmorMaterial("Mortum", 0, 10), "mortum", true, 80),
    HALITE(Util.addArmorMaterial("Halite", 0, 12), "halite", true, 83),
    SANTA(Util.addArmorMaterial("Santa", 0, 10), "santa", true, 0),
    KORMA(Util.addArmorMaterial("Korma", 0, 22), "korma", true, 45),
    DIAMOND(Util.addArmorMaterial("Diamond", 3000, 10), "diamond", false, 45),
    IRON(Util.addArmorMaterial("Iron", 2000, 12), "iron", false, 27),
    GOLD(Util.addArmorMaterial("Gold", 1000, 10), "gold", false, 18),
    LEATHER(Util.addArmorMaterial("Leather", 500, 22), "leather", false, 10);

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
