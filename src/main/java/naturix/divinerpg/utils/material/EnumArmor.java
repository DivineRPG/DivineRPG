package naturix.divinerpg.utils.material;

import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public enum EnumArmor {
    ANGELIC("Angelic", "angelic", 0, 10, 30),
    DIVINE("Divine", "divine", 10000, 10, ModItems.divineStone, 78),
    BEDROCK("Bedrock", "bedrock", 10000, 10, Item.getItemFromBlock(Blocks.BEDROCK), 78),
    REALMITE("Realmite", "realmite", 5000, 10, ModItems.realmiteIngot, 50),
    ELITE_REALMITE("Elite Realmite", "elite_realmite", 0, 10, 65),
    ARLEMITE("Arlemite", "arlemite", 0, 22, 50),
    RUPEE("Rupee", "rupee", 0, 10, 50),
    RUPEE_YELLOW("Rupee", "yellow_rupee", 0, 10, 50),
    RUPEE_RED("Rupee", "red_rupee", 0, 10, 50),
    RUPEE_GREEN("Rupee", "green_rupee", 0, 10, 50),
    RUPEE_GRAY("Rupee", "gray_rupee", 0, 10, 50),
    RUPEE_BLUE("Rupee", "blue_rupee", 0, 10, 50),
    KRAKEN("Kraken", "kraken", 5000, 10, ModItems.krakenSkin, 45),
    WITHER_REAPER("Wither Reaper", "wither_reaper", 0, 22, 0),
    SKELEMAN("Skeleman", "skeleman", 0, 22, 0),
    JACKOMAN("Jack O Man", "jack_o_man", 0, 22, 0),
    INFERNO("Inferno", "inferno", 6500, 10, 73),
    AQUATIC("Aquastrive", "aquastrive", 0, 10, 70),
    SHADOW("Shadow", "shadow", 0, 10, 75),
    NETHERITE("Netherite", "netherite", 5000, 10, ModItems.netheriteIngot, 70),
    ENDER("Ender", "ender", 7500, 10, ModItems.enderStone, 73),
    ENDER_YELLOW("Ender", "yellow_ender", 7500, 10, ModItems.enderStone, 73),
    ENDER_RED("Ender", "red_ender", 7500, 10, ModItems.enderStone, 73),
    ENDER_GREEN("Ender", "green_ender", 7500, 10, ModItems.enderStone, 73),
    ENDER_GRAY("Ender", "gray_ender", 7500, 10, ModItems.enderStone, 73),
    ENDER_BLUE("Ender", "blue_ender", 7500, 10, ModItems.enderStone, 73),
    JUNGLE("Jungle", "jungle", 5000, 10, ModItems.jungleStone, 65),
    FROZEN("Frozen", "frozen", 3000, 10, ModItems.iceStone, 65),
    CORRUPTED("Corrupted", "corrupted", 5000, 10, ModItems.corruptedStone, 68),
    TERRAN("Terran", "terran", 3000, 10, ModItems.terranStone, 68),
    EDEN("Eden", "eden", 0, 10, 72),
    WILD("Wild", "wildwood", 0, 10, 74),
    APALACHIA("Apalachia", "apalachia", 0, 10, 76),
    SKYTHERN("Skythern", "skythern", 0, 10, 78),
    MORTUM("Mortum", "mortum", 0, 10, 80),
    HALITE("Halite", "halite", 0, 12, 83),
    SANTA("Santa", "santa", 0, 10, 0, true),
    KORMA("Korma", "korma", 0, 22, 78),
    VEMOS("Vemos", "vemos", 0, 22, 65),
    DIAMOND("Diamond", "diamond", 3000, 10, 55),
    IRON("Iron", "iron", 2000, 12, 30),
    GOLD("Golden", "golden", 1000, 10, 22),
    
    DEGRADED("Degraded", "degraded", 0, 0, 17),
    FINISHED("Finished", "finished", 0, 0, 33),
    GLISTENING("Glistening", "glistening", 0, 0, 50),
    DEMONIZED("Demonized", "demonized", 0, 0, 60),
    TORMENTED("Tormented", "tormented", 0, 0, 77);

    private ArmorMaterial armorMaterial;
    private String type;
    private boolean undamageable;
    private int damageReduction;
    private boolean clothing;

    private EnumArmor(String name, String textureName, int durability, int enchantability, int damageReduction) {
        this(name, textureName, durability, enchantability, damageReduction, false);
    }

    private EnumArmor(String name, String textureName, int durability, int enchantability, Item repair, int damageReduction) {
        this.armorMaterial = EnumHelper.addArmorMaterial(name, Reference.MODID + ":" + textureName,
                (int) Math.round(durability / 13.75), new int[] {0, 0, 0, 0}, enchantability,
                SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f);
        this.armorMaterial.setRepairItem(new ItemStack(repair, 1));
        this.type = textureName;
        this.undamageable = (durability == 0);
        this.damageReduction = damageReduction;
        this.clothing = false;
    }

    private EnumArmor(String name, String textureName, int durability, int enchantability, int damageReduction, boolean clothing) {
        this.armorMaterial = EnumHelper.addArmorMaterial(name, Reference.MODID + ":" + textureName,
                (int) Math.round(durability / 13.75), new int[] {0, 0, 0, 0}, enchantability,
                SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f);
        this.type = textureName;
        this.undamageable = (durability == 0);
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
