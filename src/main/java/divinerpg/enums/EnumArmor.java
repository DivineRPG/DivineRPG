package divinerpg.enums;

import divinerpg.api.Reference;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public enum EnumArmor {
    ANGELIC("Angelic", "angelic", 2000, 10, ModItems.bluefireStone, 30),
    DIVINE("Divine", "divine", 10000, 10, ModItems.divineStone, 78),
    BEDROCK("Bedrock", "bedrock", 12000, 10, ModItems.bedrockChunk, 78),
    REALMITE("Realmite", "realmite", 2000, 10, ModItems.realmiteIngot, 50),
    ELITE_REALMITE("Elite Realmite", "elite_realmite", 5000, 10, Item.getItemFromBlock(ModBlocks.realmiteBlock), 65),
    ARLEMITE("Arlemite", "arlemite", 3000, 22, ModItems.arlemiteIngot, 50),
    RUPEE("Rupee", "rupee", 2000, 10, ModItems.rupeeIngot, 50),
    RUPEE_YELLOW("Rupee", "yellow_rupee", 2000, 10, ModItems.rupeeIngot, 50),
    RUPEE_RED("Rupee", "red_rupee", 2000, 10, ModItems.rupeeIngot, 50),
    RUPEE_GREEN("Rupee", "green_rupee", 2000, 10, ModItems.rupeeIngot, 50),
    RUPEE_GRAY("Rupee", "gray_rupee", 2000, 10, ModItems.rupeeIngot, 50),
    RUPEE_BLUE("Rupee", "blue_rupee", 2000, 10, ModItems.rupeeIngot, 50),
    KRAKEN("Kraken", "kraken", 5000, 10, ModItems.krakenSkin, 45),
    WITHER_REAPER("Wither Reaper", "wither_reaper", 0, 22, 0),
    SKELEMAN("Skeleman", "skeleman", 0, 22, 0),
    JACKOMAN("Jack O Man", "jack_o_man", 0, 22, 0),
    INFERNO("Inferno", "inferno", 6500, 10, ModItems.moltenStone, 73),
    AQUATIC("Aquastrive", "aquastrive", 7000, 10, ModItems.aquaticIngot, 70),
    SHADOW("Shadow", "shadow", 6500, 10, ModItems.shadowStone, 75),
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
    EDEN("Eden", "eden", 2000, 10, ModItems.edenChunk, 72),
    WILD("Wild", "wildwood", 2200, 10, ModItems.wildwoodChunk, 74),
    APALACHIA("Apalachia", "apalachia", 2400, 10, ModItems.apalachiaChunk, 76),
    SKYTHERN("Skythern", "skythern", 2600, 10, ModItems.skythernChunk, 78),
    MORTUM("Mortum", "mortum", 2800, 10, ModItems.mortumChunk, 80),
    HALITE("Halite", "halite", 4000, 12, 83),
    AWAKEN_HALITE("Awaken Halite", "awakened_halite", 2000, 24, 87),
    SANTA("Santa", "santa", 9000, 10, ModItems.snowflake, 0, true, false),
    KORMA("Korma", "korma", 0, 22, 78),
    VEMOS("Vemos", "vemos", 0, 22, 65),

//    DIAMOND("Diamond", "diamond", 3000, 10, 55, false, true),
//    IRON("Iron", "iron", 2000, 12, 30, false, true),
//    GOLD("Gold", "gold", 1000, 10, 22, false, true),

    DEGRADED("Degraded", "degraded", 0, 0, 17),
    FINISHED("Finished", "finished", 0, 0, 33),
    GLISTENING("Glistening", "glistening", 0, 0, 50),
    DEMONIZED("Demonized", "demonized", 0, 0, 60),
    TORMENTED("Tormented", "tormented", 0, 0, 77);

    private ArmorMaterial armorMaterial;
    private String type;
    private boolean undamageable;
    private int damageReduction;
    private boolean override;

    EnumArmor(String name, String textureName, int durability, int enchantability, int damageReduction) {
        this(name, textureName, durability, enchantability, null, damageReduction, false, false);
    }

    EnumArmor(String name, String textureName, int durability, int enchantability, Item repair,
              int damageReduction) {
        this(name, textureName, durability, enchantability, repair, damageReduction, false, false);
    }

    EnumArmor(String name, String textureName, int durability, int enchantability, Item repair,
              int damageReduction, boolean clothing, boolean override) {
        this.armorMaterial = EnumHelper.addArmorMaterial(name,
                (override ? "minecraft:" : (Reference.MODID + ":")) + textureName, (int) Math.round(durability / 13.75),
                new int[]{0, 0, 0, 0}, enchantability,
                clothing ? SoundEvents.ITEM_ARMOR_EQUIP_LEATHER : SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f);
        if (repair != null) {
            this.armorMaterial.setRepairItem(new ItemStack(repair, 1));
        }
        this.type = textureName;
        this.undamageable = (durability == 0);
        this.damageReduction = damageReduction;
        this.override = override;
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

    public boolean isOverriden() {
        return override;
    }
}
