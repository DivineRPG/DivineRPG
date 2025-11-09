package divinerpg.registries;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.*;
import java.util.function.Supplier;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.TagRegistry.*;
import static net.minecraft.sounds.SoundEvents.*;
import static net.minecraft.world.item.ArmorItem.Type.*;

public class ArmorMaterialRegistry {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, MODID);
    public static final Holder<ArmorMaterial>
        REALMITE = register("realmite", 2, 6, 6, 2, 0, 0, 9, ARMOR_EQUIP_IRON, REPAIRS_EQUIPMENT_REALMITE),
        SENG_FUR = register("seng_fur", 2, 7, 6, 2, 0, 0, 15, ARMOR_EQUIP_LEATHER, REPAIRS_EQUIPMENT_SENG_FUR),
        SANTA = register("santa", 2, 7, 6, 2, 0, 0, 15, ARMOR_EQUIP_LEATHER, REPAIRS_EQUIPMENT_SANTA),
        AQUASTRIVE = register("aquastrive", 2, 7, 6, 2, 0, 0, 9, ARMOR_EQUIP_IRON, REPAIRS_EQUIPMENT_AQUATIC),
        KRAKEN = register("kraken", 2, 7, 6, 3, 0, 0, 9, ARMOR_EQUIP_TURTLE, REPAIRS_EQUIPMENT_KRAKEN),
        JACK_O_MAN = register("jack_o_man", 2, 7, 6, 3, 0, 0, 9, ARMOR_EQUIP_GENERIC, REPAIRS_EQUIPMENT_JACK_O_MAN),
        SKELEMAN = register("skeleman", 2, 7, 6, 3, 0, 0, 9, Holder.direct(SKELETON_STEP), REPAIRS_EQUIPMENT_SKELEMAN),
        WITHER_REAPER = register("wither_reaper", 2, 7, 6, 3, 0, 0, 9, ARMOR_EQUIP_CHAIN, REPAIRS_EQUIPMENT_WITHER_REAPER),
        ARLEMITE = register("arlemite", 3, 7, 6, 3, 1.5F, 0, 10, ARMOR_EQUIP_IRON, REPAIRS_EQUIPMENT_ARLEMITE),
        FROZEN = register("frozen", 3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_DIAMOND, REPAIRS_EQUIPMENT_ICE),
        JUNGLE = register("jungle", 3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_DIAMOND, REPAIRS_EQUIPMENT_JUNGLE),
        INFERNO = register("inferno", 3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_DIAMOND, REPAIRS_EQUIPMENT_MOLTEN),
        TORRIDITE = register("torridite", 3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_NETHERITE, REPAIRS_EQUIPMENT_EXPENSIVE_TORRIDITE),
        TERRAN = register("terran", 3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_DIAMOND, REPAIRS_EQUIPMENT_TERRAN),
        ANGELIC = register("angelic", 3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_DIAMOND, REPAIRS_EQUIPMENT_ANGELIC),
        SHADOW = register("shadow", 3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_DIAMOND, REPAIRS_EQUIPMENT_SHADOW),
        RUPEE = register("rupee", 3, 8, 6, 3, 2, .02F, 11, ARMOR_EQUIP_GOLD, REPAIRS_EQUIPMENT_RUPEE),
        RED_RUPEE = register("red_rupee", 3, 8, 6, 3, 2, .02F, 11, ARMOR_EQUIP_GOLD, REPAIRS_EQUIPMENT_RUPEE),
        YELLOW_RUPEE = register("yellow_rupee", 3, 8, 6, 3, 2, .02F, 11, ARMOR_EQUIP_GOLD, REPAIRS_EQUIPMENT_RUPEE),
        GREEN_RUPEE = register("green_rupee", 3, 8, 6, 3, 2, .02F, 11, ARMOR_EQUIP_GOLD, REPAIRS_EQUIPMENT_RUPEE),
        BLUE_RUPEE = register("blue_rupee", 3, 8, 6, 3, 2, .02F, 11, ARMOR_EQUIP_GOLD, REPAIRS_EQUIPMENT_RUPEE),
        GRAY_RUPEE = register("gray_rupee", 3, 8, 6, 3, 2, .02F, 11, ARMOR_EQUIP_GOLD, REPAIRS_EQUIPMENT_RUPEE),
        ELITE_REALMITE = register("elite_realmite", 3, 9, 7, 3, 3, .1F, 16, ARMOR_EQUIP_NETHERITE, REPAIRS_EQUIPMENT_EXPENSIVE_REALMITE),
        CORRUPTED = register("corrupted", 3, 9, 7, 3, 3, .05F, 15, ARMOR_EQUIP_DIAMOND, REPAIRS_EQUIPMENT_CORRUPTED),
        BEDROCK = register("bedrock", 4, 9, 7, 3, 3, .12F, 5, ARMOR_EQUIP_NETHERITE, REPAIRS_EQUIPMENT_BEDROCK),
        KORMA = register("korma", 4, 9, 7, 3, 3, .12F, 15, ARMOR_EQUIP_NETHERITE, REPAIRS_EQUIPMENT_KORMA),
        VEMOS = register("vemos", 4, 9, 7, 3, 3, .12F, 15, ARMOR_EQUIP_NETHERITE, REPAIRS_EQUIPMENT_VEMOS),
        ENDER = register("ender", 4, 7, 9, 3, 3, .12F, 5, ARMOR_EQUIP_DIAMOND, REPAIRS_EQUIPMENT_ENDER),
        RED_ENDER = register("red_ender", 4, 7, 9, 3, 3, .12F, 5, ARMOR_EQUIP_DIAMOND, REPAIRS_EQUIPMENT_ENDER),
        YELLOW_ENDER = register("yellow_ender", 4, 7, 9, 3, 3, .12F, 5, ARMOR_EQUIP_DIAMOND, REPAIRS_EQUIPMENT_ENDER),
        GREEN_ENDER = register("green_ender", 4, 7, 9, 3, 3, .12F, 5, ARMOR_EQUIP_DIAMOND, REPAIRS_EQUIPMENT_ENDER),
        BLUE_ENDER = register("blue_ender", 4, 7, 9, 3, 3, .12F, 5, ARMOR_EQUIP_DIAMOND, REPAIRS_EQUIPMENT_ENDER),
        GRAY_ENDER = register("gray_ender", 4, 7, 9, 3, 3, .12F, 5, ARMOR_EQUIP_DIAMOND, REPAIRS_EQUIPMENT_ENDER),
        DIVINE = register("divine", 4, 9, 7, 4, 3, .13F, 5, ARMOR_EQUIP_DIAMOND, REPAIRS_EQUIPMENT_DIVINE),
        EDEN = register("eden", 4, 9, 8, 4, 3, .14F, 20, ARMOR_EQUIP_GOLD, REPAIRS_EQUIPMENT_EDEN),
        WILDWOOD = register("wildwood", 5, 9, 8, 4, 3.5F, .15F, 21, ARMOR_EQUIP_DIAMOND, REPAIRS_EQUIPMENT_WILDWOOD),
        APALACHIA = register("apalachia", 5, 9, 8, 5, 3.5F, .16F, 22, ARMOR_EQUIP_DIAMOND, REPAIRS_EQUIPMENT_APALACHIA),
        SKYTHERN = register("skythern", 5, 9, 8, 5, 4, .18F, 23, ARMOR_EQUIP_DIAMOND, REPAIRS_EQUIPMENT_SKYTHERN),
        MORTUM = register("mortum", 5, 10, 8, 5, 4, .19F, 24, ARMOR_EQUIP_DIAMOND, REPAIRS_EQUIPMENT_MORTUM),
        HALITE = register("halite", 5, 10, 8, 5, 4.5F, .2F, 25, ARMOR_EQUIP_DIAMOND, REPAIRS_EQUIPMENT_HALITE),
        AWAKENED_HALITE = register("awakened_halite", 5, 10, 9, 5, 4.5F, .21F, 26, ARMOR_EQUIP_NETHERITE, REPAIRS_EQUIPMENT_AWAKENED_HALITE),

        DEGRADED = register("degraded", 3, 5, 4, 2, 2, 0, 15, ARMOR_EQUIP_IRON, REPAIRS_EQUIPMENT_DEGRADED),
        FINISHED = register("finished", 3, 6, 5, 3, 3, 0, 15, ARMOR_EQUIP_IRON, REPAIRS_EQUIPMENT_FINISHED),
        GLISTENING = register("glistening", 4, 7, 6, 3, 4, 0, 15, ARMOR_EQUIP_IRON, REPAIRS_EQUIPMENT_GLISTENING),
        DEMONIZED = register("demonized", 4, 7, 6, 3, 5, 0, 15, ARMOR_EQUIP_IRON, REPAIRS_EQUIPMENT_DEMONIZED),
        TORMENTED = register("tormented", 4, 7, 6, 3, 6, 0, 15, ARMOR_EQUIP_IRON, REPAIRS_EQUIPMENT_TORMENTED);
    //Base
    private static Holder<ArmorMaterial> register(String name, int helmetArmor, int chestplateArmor, int leggingsArmor, int bootsArmor, float toughness, float knockbackResistance, int enchantability, Holder<SoundEvent> equipSound, Supplier<Ingredient> ing) {
        EnumMap<ArmorItem.Type, Integer> enummap = new EnumMap<>(ArmorItem.Type.class);
        enummap.put(HELMET, helmetArmor);
        enummap.put(CHESTPLATE, chestplateArmor);
        enummap.put(LEGGINGS, leggingsArmor);
        enummap.put(BOOTS, bootsArmor);
        return ARMOR_MATERIALS.register(name, ()-> new ArmorMaterial(enummap, enchantability, equipSound, ing, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MODID, name))), toughness, knockbackResistance));
    }
    private static Holder<ArmorMaterial> register(String name, int helmetArmor, int chestplateArmor, int leggingsArmor, int bootsArmor, float toughness, float knockbackResistance, int enchantability, Holder<SoundEvent> equipSound, TagKey<Item> repair) {
        return register(name, helmetArmor, chestplateArmor, leggingsArmor, bootsArmor, toughness, knockbackResistance, enchantability, equipSound, () -> Ingredient.of(repair));
    }
}