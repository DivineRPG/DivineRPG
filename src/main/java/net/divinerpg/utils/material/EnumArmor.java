package net.divinerpg.utils.material;

import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public enum EnumArmor {

    ANGELIC(Util.addArmorMaterial("Angelic", 0, 10), "angelic", true, 30),
    DIVINE(Util.addArmorMaterial("Divine", 10000, 10, VanillaItemsOther.divineStone), "divine", false, 78),
    BEDROCK(Util.addArmorMaterial("Bedrock", 10000, 10, Item.getItemFromBlock(Blocks.bedrock)), "bedrock", false, 78),
    REALMITE(Util.addArmorMaterial("Realmite", 5000, 10, VanillaItemsOther.realmiteIngot), "realmite", false, 50),
    ELITE_REALMITE(Util.addArmorMaterial("Elite Realmite", 0, 10), "eliteRealmite", true, 65),
    ARLEMITE(Util.addArmorMaterial("Arlemite", 0, 22), "arlemite", true, 50),
    RUPEE(Util.addArmorMaterial("Rupee", 0, 10), "rupee", true, 50),
    RUPEE_YELLOW(Util.addArmorMaterial("Rupee", 0, 10), "yellowRupee", true, 50),
    RUPEE_RED(Util.addArmorMaterial("Rupee", 0, 10), "redRupee", true, 50),
    RUPEE_GREEN(Util.addArmorMaterial("Rupee", 0, 10), "greenRupee", true, 50),
    RUPEE_GRAY(Util.addArmorMaterial("Rupee", 0, 10), "grayRupee", true, 50),
    RUPEE_BLUE(Util.addArmorMaterial("Rupee", 0, 10), "blueRupee", true, 50),
    KRAKEN(Util.addArmorMaterial("Kraken", 5000, 10, VanillaItemsOther.krakenSkin), "kraken", false, 45),
    WITHER_REAPER(Util.addArmorMaterial("Wither Reaper", 0, 22), "witherReaper", true, 0),
    SKELEMAN(Util.addArmorMaterial("Skeleman", 0, 22), "skeleman", true, 0),
    JACKOMAN(Util.addArmorMaterial("Jack O Man", 0, 22), "jackOMan", true, 0),
    INFERNO(Util.addArmorMaterial("Inferno", 6500, 10), "inferno", true, 73),
    AQUATIC(Util.addArmorMaterial("Aquastrive", 0, 10), "aquastrive", true, 70),
    SHADOW(Util.addArmorMaterial("Shadow", 0, 10), "shadow", true, 75),
    NETHERITE(Util.addArmorMaterial("Netherite", 5000, 10, VanillaItemsOther.netheriteIngot), "netherite", false, 70),
    ENDER(Util.addArmorMaterial("Ender", 7500, 10, VanillaItemsOther.enderStone), "ender", false, 73),
    ENDER_YELLOW(Util.addArmorMaterial("Ender", 7500, 10, VanillaItemsOther.enderStone), "yellowEnder", false, 73),
    ENDER_RED(Util.addArmorMaterial("Ender", 7500, 10, VanillaItemsOther.enderStone), "redEnder", false, 73),
    ENDER_GREEN(Util.addArmorMaterial("Ender", 7500, 10, VanillaItemsOther.enderStone), "greenEnder", false, 73),
    ENDER_GRAY(Util.addArmorMaterial("Ender", 7500, 10, VanillaItemsOther.enderStone), "grayEnder", false, 73),
    ENDER_BLUE(Util.addArmorMaterial("Ender", 7500, 10, VanillaItemsOther.enderStone), "blueEnder", false, 73),
    JUNGLE(Util.addArmorMaterial("Jungle", 5000, 10, VanillaItemsOther.jungleStone), "jungle", false, 65),
    FROZEN(Util.addArmorMaterial("Frozen", 3000, 10, IceikaItems.iceStone), "frozen", false, 65),
    CORRUPTED(Util.addArmorMaterial("Corrupted", 5000, 10, VanillaItemsOther.corruptedStone), "corrupted", false, 68),
    TERRAN(Util.addArmorMaterial("Terran", 3000, 10, VanillaItemsOther.terranStone), "terran", false, 68),
    EDEN(Util.addArmorMaterial("Eden", 0, 10), "eden", true, 72),
    WILD(Util.addArmorMaterial("Wild", 0, 10), "wildwood", true, 74),
    APALACHIA(Util.addArmorMaterial("Apalachia", 0, 10), "apalachia", true, 76),
    SKYTHERN(Util.addArmorMaterial("Skythern", 0, 10), "skythern", true, 78),
    MORTUM(Util.addArmorMaterial("Mortum", 0, 10), "mortum", true, 80),
    HALITE(Util.addArmorMaterial("Halite", 0, 12), "halite", true, 83),
    SANTA(Util.addArmorMaterial("Santa", 0, 10), "santa", true, 0, true),
    KORMA(Util.addArmorMaterial("Korma", 0, 22), "korma", true, 78),
    VEMOS(Util.addArmorMaterial("Vemos", 0, 22), "vemos", true, 65),
    DIAMOND(Util.addArmorMaterial("Diamond", 3000, 10), "diamond", false, 55),
    IRON(Util.addArmorMaterial("Iron", 2000, 12), "iron", false, 30),
    GOLD(Util.addArmorMaterial("Gold", 1000, 10), "gold", false, 22),
    
    DEGRADED(Util.addArmorMaterial("Degraded", 0, 0), "degraded", true, 17),
    FINISHED(Util.addArmorMaterial("Finished", 0, 0), "finished", true, 33),
    GLISTENING(Util.addArmorMaterial("Glistening", 0, 0), "glistening", true, 50),
    DEMONIZED(Util.addArmorMaterial("Demonized", 0, 0), "demonized", true, 60),
    TORMENTED(Util.addArmorMaterial("Tormented", 0, 0), "tormented", true, 77);
    
    private ArmorMaterial armorMaterial;
    private String        type;
    private boolean       undamageable;
    private int           damageReduction;
    private boolean       clothing;

    private EnumArmor(ArmorMaterial armorMaterial, String type, boolean undamageable, int damageReduction) {
        this.armorMaterial = armorMaterial;
        this.type = type;
        this.undamageable = undamageable;
        this.damageReduction = damageReduction;
        this.clothing = false;
    }
    
    private EnumArmor(ArmorMaterial armorMaterial, String type, boolean undamageable, int damageReduction, boolean clothing) {
        this.armorMaterial = armorMaterial;
        this.type = type;
        this.undamageable = undamageable;
        this.damageReduction = damageReduction;
        this.clothing = clothing;
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
    
    public boolean isClothing() {
        return clothing;
    }
}
