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
    RUPEE_YELLOW(Util.addArmorMaterial("Rupee", 0, 10), "yellowRupee", true, 50),
    RUPEE_RED(Util.addArmorMaterial("Rupee", 0, 10), "redRupee", true, 50),
    RUPEE_GREEN(Util.addArmorMaterial("Rupee", 0, 10), "greenRupee", true, 50),
    RUPEE_GRAY(Util.addArmorMaterial("Rupee", 0, 10), "grayRupee", true, 50),
    RUPEE_BLUE(Util.addArmorMaterial("Rupee", 0, 10), "blueRupee", true, 50),
    KRAKEN(Util.addArmorMaterial("Kraken", 5000, 10), "kraken", false, 30),
    WITHER_REAPER(Util.addArmorMaterial("Wither Reaper", 0, 22), "witherReaper", true, 0),
    SKELEMAN(Util.addArmorMaterial("Skeleman", 0, 22), "skeleman", true, 0),
    JACKOMAN(Util.addArmorMaterial("Jack O Man", 0, 22), "jackOMan", true, 0),
    INFERNO(Util.addArmorMaterial("Inferno", 0, 10), "inferno", true, 60),
    AQUATIC(Util.addArmorMaterial("Aquastrive", 0, 10), "aquastrive", true, 55),
    SHADOW(Util.addArmorMaterial("Shadow", 0, 10), "shadow", true, 60),
    NETHERITE(Util.addArmorMaterial("Netherite", 5000, 10), "netherite", false, 50),
    ENDER(Util.addArmorMaterial("Ender", 0, 10), "ender", true, 65),
    JUNGLE(Util.addArmorMaterial("Jungle", 0, 10), "jungle", true, 55),
    FROZEN(Util.addArmorMaterial("Frozen", 5000, 10), "frozen", false, 50),
    CORRUPTED(Util.addArmorMaterial("Corrupted", 5000, 10), "corrupted", false, 55),
    EDEN(Util.addArmorMaterial("Eden", 0, 10), "eden", true, 60),
    WILD(Util.addArmorMaterial("Wild", 0, 10), "wildwood", true, 65),
    APALACHIA(Util.addArmorMaterial("Apalachia", 0, 10), "apalachia", true, 72),
    SKYTHERN(Util.addArmorMaterial("Skythern", 0, 10), "skythern", true, 75),
    MORTUM(Util.addArmorMaterial("Mortum", 0, 10), "mortum", true, 80),
    HALITE(Util.addArmorMaterial("Halite", 0, 12), "halite", true, 83),
    SANTA(Util.addArmorMaterial("Santa", 0, 10), "santa", true, 0),
    KORMA(Util.addArmorMaterial("Korma", 0, 22), "korma", true, 45),
    VEMOS(Util.addArmorMaterial("Vemos", 0, 22), "vemos", true, 45),
    DIAMOND(Util.addArmorMaterial("Diamond", 3000, 10), "diamond", false, 45),
    IRON(Util.addArmorMaterial("Iron", 2000, 12), "iron", false, 27),
    GOLD(Util.addArmorMaterial("Gold", 1000, 10), "gold", false, 18),
    LEATHER(Util.addArmorMaterial("Leather", 500, 22), "leather", false, 10),
    
    DEGRADED(Util.addArmorMaterial("Degraded", 0, 0), "degraded", true, 17),
    FINISHED(Util.addArmorMaterial("Finished", 0, 0), "finished", true, 33),
    GLISTENING(Util.addArmorMaterial("Glistening", 0, 0), "glistening", true, 50),
    DEMONIZED(Util.addArmorMaterial("Demonized", 0, 0), "demonized", true, 60),
    TORMENTED(Util.addArmorMaterial("Tormented", 0, 0), "tormented", true, 77);
    
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
