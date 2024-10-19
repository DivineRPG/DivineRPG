package divinerpg.registries;

import divinerpg.DivineRPG;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.*;
import java.util.function.Supplier;

import static divinerpg.registries.ItemRegistry.*;
import static net.minecraft.sounds.SoundEvents.*;
import static net.minecraft.world.item.ArmorItem.Type.*;

public class ArmorMaterialRegistry {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, DivineRPG.MODID);
    public static final Holder<ArmorMaterial>
        REALMITE = register("realmite", 2, 6, 6, 2, 0, 0, 9, ARMOR_EQUIP_IRON, realmite_ingot),
        SENG_FUR = register("seng_fur", 2, 7, 6, 2, 0, 0, 15, ARMOR_EQUIP_LEATHER, seng_fur),
        SANTA = register("santa", 2, 7, 6, 2, 0, 0, 15, ARMOR_EQUIP_LEATHER, seng_fur),
        AQUASTRIVE = register("aquastrive", 2, 7, 6, 2, 0, 0, 9, ARMOR_EQUIP_IRON, aquatic_ingot),
        KRAKEN = register("kraken", 2, 7, 6, 3, 0, 0, 9, ARMOR_EQUIP_TURTLE, kraken_skin),
        JACK_O_MAN = register("jack_o_man", 2, 7, 6, 3, 0, 0, 9, ARMOR_EQUIP_GENERIC, () -> Ingredient.of(Items.PUMPKIN)),
        SKELEMAN = register("skeleman", 2, 7, 6, 3, 0, 0, 9, ARMOR_EQUIP_GENERIC, () -> Ingredient.of(Items.BONE)),
        WITHER_REAPER = register("wither_reaper", 2, 7, 6, 3, 0, 0, 9, ARMOR_EQUIP_CHAIN, () -> Ingredient.of(Items.BONE)),
        ARLEMITE = register("arlemite", 3, 7, 6, 3, 1.5F, 0, 10, ARMOR_EQUIP_IRON, arlemite_ingot),
        FROZEN = register("frozen", 3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_DIAMOND, ice_stone),
        JUNGLE = register("jungle", 3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_DIAMOND, jungle_stone),
        INFERNO = register("inferno", 3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_DIAMOND, molten_stone),
        TORRIDITE = register("torridite", 3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_NETHERITE, torridite_chunk),
        TERRAN = register("terran", 3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_DIAMOND, terran_stone),
        ANGELIC = register("angelic", 3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_DIAMOND, shadow_stone),
        SHADOW = register("shadow", 3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_DIAMOND, shadow_stone),
        RUPEE = register("rupee", 3, 8, 6, 3, 2, .02F, 11, ARMOR_EQUIP_GOLD, rupee_ingot),
        RED_RUPEE = register("red_rupee", 3, 8, 6, 3, 2, .02F, 11, ARMOR_EQUIP_GOLD, rupee_ingot),
        YELLOW_RUPEE = register("yellow_rupee", 3, 8, 6, 3, 2, .02F, 11, ARMOR_EQUIP_GOLD, rupee_ingot),
        GREEN_RUPEE = register("green_rupee", 3, 8, 6, 3, 2, .02F, 11, ARMOR_EQUIP_GOLD, rupee_ingot),
        BLUE_RUPEE = register("blue_rupee", 3, 8, 6, 3, 2, .02F, 11, ARMOR_EQUIP_GOLD, rupee_ingot),
        GRAY_RUPEE = register("gray_rupee", 3, 8, 6, 3, 2, .02F, 11, ARMOR_EQUIP_GOLD, rupee_ingot),
        ELITE_REALMITE = register("elite_realmite", 3, 9, 7, 3, 3, .1F, 16, ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(BlockRegistry.realmiteBlock.asItem())),
        CORRUPTED = register("corrupted", 3, 9, 7, 3, 3, .05F, 15, ARMOR_EQUIP_DIAMOND, corrupted_stone),
        BEDROCK = register("bedrock", 4, 9, 7, 3, 3, .12F, ARMOR_EQUIP_NETHERITE),
        KORMA = register("korma", 4, 9, 7, 3, 3, .12F, 15, ARMOR_EQUIP_NETHERITE, arcanium),
        VEMOS = register("vemos", 4, 9, 7, 3, 3, .12F, 15, ARMOR_EQUIP_NETHERITE, arcanium),
        ENDER = register("ender", 4, 7, 9, 3, 3, .12F, ARMOR_EQUIP_DIAMOND),
        RED_ENDER = register("red_ender", 4, 7, 9, 3, 3, .12F, ARMOR_EQUIP_DIAMOND),
        YELLOW_ENDER = register("yellow_ender", 4, 7, 9, 3, 3, .12F, ARMOR_EQUIP_DIAMOND),
        GREEN_ENDER = register("green_ender", 4, 7, 9, 3, 3, .12F, ARMOR_EQUIP_DIAMOND),
        BLUE_ENDER = register("blue_ender", 4, 7, 9, 3, 3, .12F, ARMOR_EQUIP_DIAMOND),
        GRAY_ENDER = register("gray_ender", 4, 7, 9, 3, 3, .12F, ARMOR_EQUIP_DIAMOND),
        DIVINE = register("divine", 4, 9, 7, 4, 3, .13F, ARMOR_EQUIP_DIAMOND),
        EDEN = register("eden", 4, 9, 8, 4, 3, .14F, 20, ARMOR_EQUIP_GOLD, eden_gem),
        WILDWOOD = register("wildwood", 5, 9, 8, 4, 3.5F, .15F, 21, ARMOR_EQUIP_DIAMOND, wildwood_gem),
        APALACHIA = register("apalachia", 5, 9, 8, 5, 3.5F, .16F, 22, ARMOR_EQUIP_DIAMOND, apalachia_gem),
        SKYTHERN = register("skythern", 5, 9, 8, 5, 4, .18F, 23, ARMOR_EQUIP_DIAMOND, skythern_gem),
        MORTUM = register("mortum", 5, 10, 8, 5, 4, .19F, 24, ARMOR_EQUIP_DIAMOND, mortum_gem),
        HALITE = register("halite", 5, 10, 8, 5, 4.5F, .2F, 25, ARMOR_EQUIP_DIAMOND, mortum_gem),
        AWAKENED_HALITE = register("awakened_halite", 5, 10, 9, 5, 4.5F, .21F, 26, ARMOR_EQUIP_NETHERITE, arcanium),

        DEGRADED = register("degraded", 3, 5, 4, 2, 2, 0, 15, ARMOR_EQUIP_IRON),
        FINISHED = register("finished", 3, 6, 5, 3, 3, 0, 15, ARMOR_EQUIP_IRON),
        GLISTENING = register("glistening", 4, 7, 6, 3, 4, 0, 15, ARMOR_EQUIP_IRON),
        DEMONIZED = register("demonized", 4, 7, 6, 3, 5, 0, 15, ARMOR_EQUIP_IRON),
        TORMENTED = register("tormented", 4, 7, 6, 3, 6, 0, 15, ARMOR_EQUIP_IRON);
    private static Holder<ArmorMaterial> register(String name, int helmetArmor, int chestplateArmor, int leggingsArmor, int bootsArmor, float toughness, float knockbackResistance, Holder<SoundEvent> equipSound) {
        return register(name, helmetArmor, chestplateArmor, leggingsArmor, bootsArmor, toughness, knockbackResistance, 0, equipSound, () -> Ingredient.EMPTY);
    }
    private static Holder<ArmorMaterial> register(String name, int helmetArmor, int chestplateArmor, int leggingsArmor, int bootsArmor, float toughness, float knockbackResistance, int enchantability, Holder<SoundEvent> equipSound) {
        return register(name, helmetArmor, chestplateArmor, leggingsArmor, bootsArmor, toughness, knockbackResistance, enchantability, equipSound, () -> Ingredient.EMPTY);
    }
    private static Holder<ArmorMaterial> register(String name, int helmetArmor, int chestplateArmor, int leggingsArmor, int bootsArmor, float toughness, float knockbackResistance, int enchantability, Holder<SoundEvent> equipSound, Supplier<Ingredient> ing) {
    	EnumMap<ArmorItem.Type, Integer> enummap = new EnumMap<>(ArmorItem.Type.class);
        enummap.put(HELMET, helmetArmor);
        enummap.put(CHESTPLATE, chestplateArmor);
        enummap.put(LEGGINGS, leggingsArmor);
        enummap.put(BOOTS, bootsArmor);
        return ARMOR_MATERIALS.register(name, ()-> new ArmorMaterial(enummap, enchantability, equipSound, ing, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, name))), toughness, knockbackResistance));
    }
    private static Holder<ArmorMaterial> register(String name, int helmetArmor, int chestplateArmor, int leggingsArmor, int bootsArmor, float toughness, float knockbackResistance, int enchantability, Holder<SoundEvent> equipSound, DeferredItem<Item> repair) {
        return register(name, helmetArmor, chestplateArmor, leggingsArmor, bootsArmor, toughness, knockbackResistance, enchantability, equipSound, () -> Ingredient.of(repair.get()));
    }
}