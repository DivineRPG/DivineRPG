package net.divinerpg.registries;

import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.EnumMap;

import static net.divinerpg.DivineRPG.MODID;

public class ArmorMaterialRegistry {

    public static final ArmorMaterial REALMITE = registerArmorMaterial("realmite", 2, createDefenseMap(2, 6, 6, 2, 0), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, TagRegistry.REPAIR_REALMITE);
    public static final ArmorMaterial SENG_FUR = registerArmorMaterial("seng_fur", 2, createDefenseMap(2, 6, 7, 2, 0), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, TagRegistry.REPAIR_SENG_FUR);
    public static final ArmorMaterial SANTA = registerArmorMaterial("santa", 2, createDefenseMap(2, 6, 7, 2, 0), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, TagRegistry.REPAIR_SANTA);
    public static final ArmorMaterial AQUASTRIVE = registerArmorMaterial("aquastrive", 2, createDefenseMap(2, 6, 7, 2, 0), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, TagRegistry.REPAIR_AQUATIC);
    public static final ArmorMaterial KRAKEN = registerArmorMaterial("kraken", 2, createDefenseMap(3, 6, 7, 3, 0), 9, SoundEvents.ARMOR_EQUIP_TURTLE, 0.0F, 0.0F, TagRegistry.REPAIR_KRAKEN);
    public static final ArmorMaterial JACK_O_MAN = registerArmorMaterial("jack_o_man", 2, createDefenseMap(3, 6, 7, 3, 0), 9, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, 0.0F, TagRegistry.REPAIR_JACK_O_MAN);
    public static final ArmorMaterial SKELEMAN = registerArmorMaterial("skeleman", 2, createDefenseMap(3, 6, 7, 3, 0), 9, Holder.direct(SoundEvents.SKELETON_STEP), 0.0F, 0.0F, TagRegistry.REPAIR_SKELEMAN);
    public static final ArmorMaterial WITHER_REAPER = registerArmorMaterial("wither_reaper", 2, createDefenseMap(3, 6, 7, 3, 0), 9, SoundEvents.ARMOR_EQUIP_CHAIN, 0.0F, 0.0F, TagRegistry.REPAIR_WITHER_REAPER);
    public static final ArmorMaterial ARLEMITE = registerArmorMaterial("arlemite", 3, createDefenseMap(3, 6, 7, 3, 0), 10, SoundEvents.ARMOR_EQUIP_IRON, 1.5F, 0.0F, TagRegistry.REPAIR_ARLEMITE);
    public static final ArmorMaterial FROZEN = registerArmorMaterial("frozen", 3, createDefenseMap(3, 6, 8, 3, 0), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, TagRegistry.REPAIR_ICE);
    public static final ArmorMaterial JUNGLE = registerArmorMaterial("jungle", 3, createDefenseMap(3, 6, 8, 3, 0), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, TagRegistry.REPAIR_JUNGLE);
    public static final ArmorMaterial INFERNO = registerArmorMaterial("inferno", 3, createDefenseMap(3, 6, 8, 3, 0), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, TagRegistry.REPAIR_MOLTEN);
    public static final ArmorMaterial TORRIDITE = registerArmorMaterial("torridite", 3, createDefenseMap(3, 6, 8, 3, 0), 10, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.0F, 0.0F, TagRegistry.REPAIR_TORRIDITE);
    public static final ArmorMaterial TERRAN = registerArmorMaterial("terran", 3, createDefenseMap(3, 6, 8, 3, 0), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, TagRegistry.REPAIR_TERRAN);
    public static final ArmorMaterial ANGELIC = registerArmorMaterial("angelic", 3, createDefenseMap(3, 6, 8, 3, 0), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, TagRegistry.REPAIR_ANGELIC);
    public static final ArmorMaterial SHADOW = registerArmorMaterial("shadow", 3, createDefenseMap(3, 6, 8, 3, 0), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, TagRegistry.REPAIR_SHADOW);
    public static final ArmorMaterial RUPEE = registerArmorMaterial("rupee", 3, createDefenseMap(3, 6, 8, 3, 0), 11, SoundEvents.ARMOR_EQUIP_GOLD, 2.0F, 0.02F, TagRegistry.REPAIR_RUPEE);
    public static final ArmorMaterial RED_RUPEE = registerArmorMaterial("red_rupee", 3, createDefenseMap(3, 6, 8, 3, 0), 11, SoundEvents.ARMOR_EQUIP_GOLD, 2.0F, 0.02F, TagRegistry.REPAIR_RUPEE);
    public static final ArmorMaterial YELLOW_RUPEE = registerArmorMaterial("yellow_rupee", 3, createDefenseMap(3, 6, 8, 3, 0), 11, SoundEvents.ARMOR_EQUIP_GOLD, 2.0F, 0.02F, TagRegistry.REPAIR_RUPEE);
    public static final ArmorMaterial GREEN_RUPEE = registerArmorMaterial("green_rupee", 3, createDefenseMap(3, 6, 8, 3, 0), 11, SoundEvents.ARMOR_EQUIP_GOLD, 2.0F, 0.02F, TagRegistry.REPAIR_RUPEE);
    public static final ArmorMaterial BLUE_RUPEE = registerArmorMaterial("blue_rupee", 3, createDefenseMap(3, 6, 8, 3, 0), 11, SoundEvents.ARMOR_EQUIP_GOLD, 2.0F, 0.02F, TagRegistry.REPAIR_RUPEE);
    public static final ArmorMaterial GRAY_RUPEE = registerArmorMaterial("gray_rupee", 3, createDefenseMap(3, 6, 8, 3, 0), 11, SoundEvents.ARMOR_EQUIP_GOLD, 2.0F, 0.02F, TagRegistry.REPAIR_RUPEE);
    public static final ArmorMaterial ELITE_REALMITE = registerArmorMaterial("elite_realmite", 3, createDefenseMap(3, 7, 9, 3, 0), 16, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, TagRegistry.REPAIR_EXP_REALMITE);
    public static final ArmorMaterial CORRUPTED = registerArmorMaterial("corrupted", 3, createDefenseMap(3, 7, 9, 3, 0), 15, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.0F, 0.05F, TagRegistry.REPAIR_CORRUPTED);
    public static final ArmorMaterial BEDROCK = registerArmorMaterial("bedrock", 4, createDefenseMap(3, 7, 9, 3, 0), 5, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.12F, TagRegistry.REPAIR_BEDROCK);
    public static final ArmorMaterial KORMA = registerArmorMaterial("korma", 4, createDefenseMap(3, 7, 9, 3, 0), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.12F, TagRegistry.REPAIR_KORMA);
    public static final ArmorMaterial VEMOS = registerArmorMaterial("vemos", 4, createDefenseMap(3, 7, 9, 3, 0), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.12F, TagRegistry.REPAIR_VEMOS);
    public static final ArmorMaterial ENDER = registerArmorMaterial("ender", 4, createDefenseMap(3, 9, 7, 4, 0), 5, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.0F, 0.12F, TagRegistry.REPAIR_ENDER);
    public static final ArmorMaterial RED_ENDER = registerArmorMaterial("red_ender", 4, createDefenseMap(3, 9, 7, 4, 0), 5, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.0F, 0.12F, TagRegistry.REPAIR_ENDER);
    public static final ArmorMaterial YELLOW_ENDER = registerArmorMaterial("yellow_ender", 4, createDefenseMap(3, 9, 7, 4, 0), 5, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.0F, 0.12F, TagRegistry.REPAIR_ENDER);
    public static final ArmorMaterial GREEN_ENDER = registerArmorMaterial("green_ender", 4, createDefenseMap(3, 9, 7, 4, 0), 5, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.0F, 0.12F, TagRegistry.REPAIR_ENDER);
    public static final ArmorMaterial BLUE_ENDER = registerArmorMaterial("blue_ender", 4, createDefenseMap(3, 9, 7, 4, 0), 5, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.0F, 0.12F, TagRegistry.REPAIR_ENDER);
    public static final ArmorMaterial GRAY_ENDER = registerArmorMaterial("gray_ender", 4, createDefenseMap(3, 9, 7, 4, 0), 5, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.0F, 0.12F, TagRegistry.REPAIR_ENDER);
    public static final ArmorMaterial DIVINE = registerArmorMaterial("divine", 4, createDefenseMap(4, 7, 9, 4, 0), 5, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.0F, 0.13F, TagRegistry.REPAIR_DIVINE);
    public static final ArmorMaterial EDEN = registerArmorMaterial("eden", 4, createDefenseMap(4, 8, 9, 4, 0), 20, SoundEvents.ARMOR_EQUIP_GOLD, 3.0F, 0.14F, TagRegistry.REPAIR_EDEN);
    public static final ArmorMaterial WILDWOOD = registerArmorMaterial("wildwood", 5, createDefenseMap(4, 8, 9, 5, 0), 21, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.5F, 0.15F, TagRegistry.REPAIR_WILDWOOD);
    public static final ArmorMaterial APALACHIA = registerArmorMaterial("apalachia", 5, createDefenseMap(5, 8, 9, 5, 0), 22, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.5F, 0.16F, TagRegistry.REPAIR_APALACHIA);
    public static final ArmorMaterial SKYTHERN = registerArmorMaterial("skythern", 5, createDefenseMap(5, 8, 9, 5, 0), 23, SoundEvents.ARMOR_EQUIP_DIAMOND, 4.0F, 0.18F, TagRegistry.REPAIR_SKYTHERN);
    public static final ArmorMaterial MORTUM = registerArmorMaterial("mortum", 5, createDefenseMap(5, 8, 10, 5, 0), 24, SoundEvents.ARMOR_EQUIP_DIAMOND, 4.0F, 0.19F, TagRegistry.REPAIR_MORTUM);
    public static final ArmorMaterial HALITE = registerArmorMaterial("halite", 5, createDefenseMap(5, 8, 10, 5, 0), 25, SoundEvents.ARMOR_EQUIP_DIAMOND, 4.5F, 0.2F, TagRegistry.REPAIR_HALITE);
    public static final ArmorMaterial AWAKENED_HALITE = registerArmorMaterial("awakened_halite", 5, createDefenseMap(5, 9, 10, 5, 0), 26, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.5F, 0.21F, TagRegistry.REPAIR_AWAKENED_HALITE);
    public static final ArmorMaterial DEGRADED = registerArmorMaterial("degraded", 3, createDefenseMap(2, 4, 5, 3, 0), 15, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.0F, TagRegistry.REPAIR_DEGRADED);
    public static final ArmorMaterial FINISHED = registerArmorMaterial("finished", 3, createDefenseMap(3, 5, 6, 3, 0), 15, SoundEvents.ARMOR_EQUIP_IRON, 3.0F, 0.0F, TagRegistry.REPAIR_FINISHED);
    public static final ArmorMaterial GLISTENING = registerArmorMaterial("glistening", 4, createDefenseMap(3, 6, 7, 4, 0), 15, SoundEvents.ARMOR_EQUIP_IRON, 4.0F, 0.0F, TagRegistry.REPAIR_GLISTENING);
    public static final ArmorMaterial DEMONIZED = registerArmorMaterial("demonized", 4, createDefenseMap(3, 6, 7, 4, 0), 15, SoundEvents.ARMOR_EQUIP_IRON, 5.0F, 0.0F, TagRegistry.REPAIR_DEMONIZED);
    public static final ArmorMaterial TORMENTED = registerArmorMaterial("tormented", 4, createDefenseMap(3, 6, 7, 4, 0), 15, SoundEvents.ARMOR_EQUIP_IRON, 6.0F, 0.0F, TagRegistry.REPAIR_TORMENTED);

    static ResourceKey<EquipmentAsset> createId(String name) {
        return ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(MODID, name));
    }

    static EnumMap<ArmorType, Integer> createDefenseMap(int boots, int leggings, int chestplate, int helmet, int body) {
        EnumMap<ArmorType, Integer> defenseMap = new EnumMap<>(ArmorType.class);
        defenseMap.put(ArmorType.BOOTS, boots);
        defenseMap.put(ArmorType.LEGGINGS, leggings);
        defenseMap.put(ArmorType.CHESTPLATE, chestplate);
        defenseMap.put(ArmorType.HELMET, helmet);
        defenseMap.put(ArmorType.BODY, body);
        return defenseMap;
    }

    private static ArmorMaterial registerArmorMaterial(String name, int durability, EnumMap<ArmorType, Integer> defenseMap, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, TagKey<Item> repairIngredient) {
        return createArmorMaterial(durability, defenseMap, enchantmentValue, equipSound, toughness, knockbackResistance, repairIngredient, createId(name));
    }

    private static ArmorMaterial createArmorMaterial(int durability, EnumMap<ArmorType, Integer> defenseMap, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, TagKey<Item> repairIngredient, ResourceKey<EquipmentAsset> assetKey) {
        EnumMap<ArmorType, Integer> mappedDefense = new EnumMap<>(ArmorType.class);
        for (ArmorType type : ArmorType.values()) {
            mappedDefense.put(type, defenseMap.get(type));
        }
        return new ArmorMaterial(durability, mappedDefense, enchantmentValue, equipSound, toughness, knockbackResistance, repairIngredient, assetKey);
    }
}