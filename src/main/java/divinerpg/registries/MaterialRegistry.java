package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.util.DivineArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvents;

public class MaterialRegistry {
    public static final DivineArmorMaterials ANGELIC_ARMOR = new DivineArmorMaterials("drpg_angelic_armor", DivineRPG.MODID + ":angelic", 20, new int[]{3, 4, 4, 3}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 0F, null);
    public static final DivineArmorMaterials APALACHIA_ARMOR = new DivineArmorMaterials("drpg_apalachia_armor", DivineRPG.MODID + ":apalachia", 38, new int[]{5, 5, 7, 5}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 3F, Ingredient.of(ItemRegistry.apalachiaChunk));
    public static final DivineArmorMaterials AQUASTRIVE_ARMOR = new DivineArmorMaterials("drpg_aquastrive_armor", DivineRPG.MODID + ":aquastrive", 30, new int[]{4, 5, 6, 3}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 2F, Ingredient.of(ItemRegistry.aquaticIngot));
    public static final DivineArmorMaterials ARLEMITE_ARMOR = new DivineArmorMaterials("drpg_arlemite_armor", DivineRPG.MODID + ":arlemite", 31, new int[]{3, 5, 7, 3}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 4F, Ingredient.of(ItemRegistry.arlemiteIngot));
    public static final DivineArmorMaterials AWAKENED_HALITE_ARMOR = new DivineArmorMaterials("drpg_awakened_halite_armor", DivineRPG.MODID + ":awakened_halite", 44, new int[]{5, 7, 8, 5}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 4F, null);
    public static final DivineArmorMaterials BEDROCK_ARMOR = new DivineArmorMaterials("drpg_bedrock_armor", DivineRPG.MODID + ":bedrock", 47, new int[]{5, 6, 8, 5}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 5F, Ingredient.of(ItemRegistry.bedrockChunk));
    public static final DivineArmorMaterials CORRUPTED_ARMOR = new DivineArmorMaterials("drpg_corrupted_armor", DivineRPG.MODID + ":corrupted", 42, new int[]{4, 6, 8, 5}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 3F, Ingredient.of(ItemRegistry.corruptedStone));
    public static final DivineArmorMaterials DIVINE_ARMOR = new DivineArmorMaterials("drpg_divine_armor", DivineRPG.MODID + ":divine", 42, new int[]{5, 6, 8, 4}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 4F, Ingredient.of(ItemRegistry.divineStone));
    public static final DivineArmorMaterials EDEN_ARMOR = new DivineArmorMaterials("drpg_eden_armor", DivineRPG.MODID + ":eden", 34, new int[]{3, 5, 7, 3}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 3F, Ingredient.of(ItemRegistry.edenChunk));
    public static final DivineArmorMaterials ELITE_REALMITE_ARMOR = new DivineArmorMaterials("drpg_elite_realmite_armor", DivineRPG.MODID + ":elite_realmite", 40, new int[]{4, 6, 7, 4}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 3F, Ingredient.of(Item.byBlock(BlockRegistry.realmiteBlock)));
    public static final DivineArmorMaterials ENDER_ARMOR = new DivineArmorMaterials("drpg_ender_armor", DivineRPG.MODID + ":ender", 38, new int[]{5, 6, 7, 5}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 2F, Ingredient.of(ItemRegistry.enderStone));
    public static final DivineArmorMaterials RED_ENDER_ARMOR = new DivineArmorMaterials("drpg_red_ender_armor", DivineRPG.MODID + ":red_ender", 38, new int[]{5, 6, 7, 5}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 2F, Ingredient.of(ItemRegistry.enderStone));
    public static final DivineArmorMaterials YELLOW_ENDER_ARMOR = new DivineArmorMaterials("drpg_yellow_ender_armor", DivineRPG.MODID + ":yellow_ender", 38, new int[]{5, 6, 7, 5}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 2F, Ingredient.of(ItemRegistry.enderStone));
    public static final DivineArmorMaterials GREEN_ENDER_ARMOR = new DivineArmorMaterials("drpg_green_ender_armor", DivineRPG.MODID + ":green_ender", 38, new int[]{5, 6, 7, 5}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 2F, Ingredient.of(ItemRegistry.enderStone));
    public static final DivineArmorMaterials GRAY_ENDER_ARMOR = new DivineArmorMaterials("drpg_gray_ender_armor", DivineRPG.MODID + ":gray_ender", 38, new int[]{5, 6, 7, 5}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 2F, Ingredient.of(ItemRegistry.enderStone));
    public static final DivineArmorMaterials BLUE_ENDER_ARMOR = new DivineArmorMaterials("drpg_blue_ender_armor", DivineRPG.MODID + ":blue_ender", 38, new int[]{5, 6, 7, 5}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 2F, Ingredient.of(ItemRegistry.enderStone));
    public static final DivineArmorMaterials FROZEN_ARMOR = new DivineArmorMaterials("drpg_frozen_armor", DivineRPG.MODID + ":frozen", 31, new int[]{3, 5, 7, 4}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 1F, Ingredient.of(ItemRegistry.iceStone));
    public static final DivineArmorMaterials HALITE_ARMOR = new DivineArmorMaterials("drpg_halite_armor", DivineRPG.MODID + ":halite", 44, new int[]{5, 7, 8, 5}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 4F, Ingredient.of(ItemRegistry.mortumChunk));
    public static final DivineArmorMaterials INFERNO_ARMOR = new DivineArmorMaterials("drpg_inferno_armor", DivineRPG.MODID + ":inferno", 22, new int[]{4, 7, 7, 4}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 1F, Ingredient.of(ItemRegistry.moltenStone));
    public static final DivineArmorMaterials JACK_O_MAN_ARMOR = new DivineArmorMaterials("drpg_jack_o_man_armor", DivineRPG.MODID + ":jack_o_man", 26, new int[]{3, 6, 8, 3}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 2F, null);
    public static final DivineArmorMaterials JUNGLE_ARMOR = new DivineArmorMaterials("drpg_jungle_armor", DivineRPG.MODID + ":jungle", 31, new int[]{3, 5, 7, 4}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 1F, Ingredient.of(ItemRegistry.jungleStone));
    public static final DivineArmorMaterials KORMA_ARMOR = new DivineArmorMaterials("drpg_korma_armor", DivineRPG.MODID + ":korma", 38, new int[]{4, 7, 8, 4}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 4F, null);
    public static final DivineArmorMaterials KRAKEN_ARMOR = new DivineArmorMaterials("drpg_kraken_armor", DivineRPG.MODID + ":kraken", 28, new int[]{3, 5, 6, 3}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 1F, Ingredient.of(ItemRegistry.krakenSkin));
    public static final DivineArmorMaterials MORTUM_ARMOR = new DivineArmorMaterials("drpg_mortum_armor", DivineRPG.MODID + ":mortum", 40, new int[]{4, 6, 9, 5}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 4F, Ingredient.of(ItemRegistry.mortumChunk));
    public static final DivineArmorMaterials TORRIDITE_ARMOR = new DivineArmorMaterials("drpg_torridite_armor", DivineRPG.MODID + ":torridite", 36, new int[]{4, 5, 6, 4}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 3F, Ingredient.of(ItemRegistry.torriditeIngot));
    public static final DivineArmorMaterials REALMITE_ARMOR = new DivineArmorMaterials("drpg_realmite_armor", DivineRPG.MODID + ":realmite", 24, new int[]{2, 5, 6, 3}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 0F, Ingredient.of(ItemRegistry.realmiteIngot));
    public static final DivineArmorMaterials RUPEE_ARMOR = new DivineArmorMaterials("drpg_rupee_armor", DivineRPG.MODID + ":rupee", 35, new int[]{4, 6, 8, 4}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 2F, Ingredient.of(ItemRegistry.rupeeIngot));
    public static final DivineArmorMaterials RED_RUPEE_ARMOR = new DivineArmorMaterials("drpg_red_rupee_armor", DivineRPG.MODID + ":red_rupee", 35, new int[]{4, 6, 8, 4}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 2F, Ingredient.of(ItemRegistry.rupeeIngot));
    public static final DivineArmorMaterials YELLOW_RUPEE_ARMOR = new DivineArmorMaterials("drpg_yellow_rupee_armor", DivineRPG.MODID + ":yellow_rupee", 35, new int[]{4, 6, 8, 4}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 2F, Ingredient.of(ItemRegistry.rupeeIngot));
    public static final DivineArmorMaterials GREEN_RUPEE_ARMOR = new DivineArmorMaterials("drpg_green_rupee_armor", DivineRPG.MODID + ":green_rupee", 35, new int[]{4, 6, 8, 4}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 2F, Ingredient.of(ItemRegistry.rupeeIngot));
    public static final DivineArmorMaterials GRAY_RUPEE_ARMOR = new DivineArmorMaterials("drpg_gray_rupee_armor", DivineRPG.MODID + ":gray_rupee", 35, new int[]{4, 6, 8, 4}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 2F, Ingredient.of(ItemRegistry.rupeeIngot));
    public static final DivineArmorMaterials BLUE_RUPEE_ARMOR = new DivineArmorMaterials("drpg_blue_rupee_armor", DivineRPG.MODID + ":blue_rupee", 35, new int[]{4, 6, 8, 4}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 2F, Ingredient.of(ItemRegistry.rupeeIngot));
    public static final DivineArmorMaterials SANTA_ARMOR = new DivineArmorMaterials("drpg_santa_armor", DivineRPG.MODID + ":santa", 20, new int[]{3, 4, 5, 3}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 0F, null);
    public static final DivineArmorMaterials SHADOW_ARMOR = new DivineArmorMaterials("drpg_shadow_armor", DivineRPG.MODID + ":shadow", 28, new int[]{4, 6, 8, 4}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 3F, Ingredient.of(ItemRegistry.shadowBar));
    public static final DivineArmorMaterials SKELEMAN_ARMOR = new DivineArmorMaterials("drpg_skeleman_armor", DivineRPG.MODID + ":skeleman", 24, new int[]{3, 5, 7, 3}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 1F, null);
    public static final DivineArmorMaterials SKYTHERN_ARMOR = new DivineArmorMaterials("drpg_skythern_armor", DivineRPG.MODID + ":skythern", 38, new int[]{4, 6, 8, 5}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 3F, Ingredient.of(ItemRegistry.skythernChunk));
    public static final DivineArmorMaterials TERRAN_ARMOR = new DivineArmorMaterials("drpg_terran_armor", DivineRPG.MODID + ":terran", 31, new int[]{3, 5, 7, 4}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 1F, Ingredient.of(ItemRegistry.terranStone));
    public static final DivineArmorMaterials VEMOS_ARMOR = new DivineArmorMaterials("drpg_vemos_armor", DivineRPG.MODID + ":vemos", 30, new int[]{4, 5, 6, 5}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 3F, null);
    public static final DivineArmorMaterials WILDWOOD_ARMOR = new DivineArmorMaterials("drpg_wildwood_armor", DivineRPG.MODID + ":wildwood", 36, new int[]{4, 5, 7, 4}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 3F, Ingredient.of(ItemRegistry.wildwoodChunk));
    public static final DivineArmorMaterials WITHER_REAPER_ARMOR = new DivineArmorMaterials("drpg_wither_reaper_armor", DivineRPG.MODID + ":wither_reaper", 36, new int[]{3, 6, 8, 3}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 2F, null);

    public static final DivineArmorMaterials DEGRADED_ARMOR = new DivineArmorMaterials("drpg_degraded_armor", DivineRPG.MODID + ":degraded", 25, new int[]{2, 4, 5, 3}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 2F, null);
    public static final DivineArmorMaterials FINISHED_ARMOR = new DivineArmorMaterials("drpg_finished_armor", DivineRPG.MODID + ":finished", 30, new int[]{3, 5, 6, 3}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 3F, null);
    public static final DivineArmorMaterials GLISTENING_ARMOR = new DivineArmorMaterials("drpg_glistening_armor", DivineRPG.MODID + ":glistening", 35, new int[]{3, 6, 7, 4}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 3F, null);
    public static final DivineArmorMaterials DEMONIZED_ARMOR = new DivineArmorMaterials("drpg_demonized_armor", DivineRPG.MODID + ":demonized", 40, new int[]{4, 7, 8, 4}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 4F, null);
    public static final DivineArmorMaterials TORMENTED_ARMOR = new DivineArmorMaterials("drpg_tormented_armor", DivineRPG.MODID + ":tormented", 45, new int[]{4, 8, 9, 5}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 4F, null);

}
