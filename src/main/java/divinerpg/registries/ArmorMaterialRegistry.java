package divinerpg.registries;

import divinerpg.DivineRPG;
import net.minecraft.core.Holder;
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
        REALMITE = register(2, 6, 6, 2, 0, 0, 9, ARMOR_EQUIP_IRON, realmite_ingot),
        SENG_FUR = register(2, 7, 6, 2, 0, 0, 15, ARMOR_EQUIP_LEATHER, seng_fur),
        SANTA = register(2, 7, 6, 2, 0, 0, 15, ARMOR_EQUIP_LEATHER, seng_fur),
        AQUASTRIVE = register(2, 7, 6, 2, 0, 0, 9, ARMOR_EQUIP_IRON, aquatic_ingot),
        KRAKEN = register(2, 7, 6, 3, 0, 0, 9, ARMOR_EQUIP_TURTLE, kraken_skin),
        JACK_O_MAN = register(2, 7, 6, 3, 0, 0, 9, ARMOR_EQUIP_GENERIC, () -> Ingredient.of(Items.PUMPKIN)),
        SKELEMAN = register(2, 7, 6, 3, 0, 0, 9, ARMOR_EQUIP_GENERIC, () -> Ingredient.of(Items.BONE)),
        WITHER_REAPER = register(2, 7, 6, 3, 0, 0, 9, ARMOR_EQUIP_CHAIN, () -> Ingredient.of(Items.BONE)),
        ARLEMITE = register(3, 7, 6, 3, 1.5F, 0, 10, ARMOR_EQUIP_IRON, arlemite_ingot),
        FROZEN = register(3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_DIAMOND, ice_stone),
        JUNGLE = register(3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_DIAMOND, jungle_stone),
        INFERNO = register(3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_DIAMOND, molten_stone),
        TORRIDITE = register(3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_NETHERITE, torridite_chunk),
        TERRAN = register(3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_DIAMOND, terran_stone),
        ANGELIC = register(3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_DIAMOND, shadow_stone),
        SHADOW = register(3, 8, 6, 3, 2, 0, 10, ARMOR_EQUIP_DIAMOND, shadow_stone),
        RUPEE = register(3, 8, 6, 3, 2, .02F, 11, ARMOR_EQUIP_GOLD, rupee_ingot),
        RED_RUPEE = register(3, 8, 6, 3, 2, .02F, 11, ARMOR_EQUIP_GOLD, rupee_ingot),
        YELLOW_RUPEE = register(3, 8, 6, 3, 2, .02F, 11, ARMOR_EQUIP_GOLD, rupee_ingot),
        GREEN_RUPEE = register(3, 8, 6, 3, 2, .02F, 11, ARMOR_EQUIP_GOLD, rupee_ingot),
        BLUE_RUPEE = register(3, 8, 6, 3, 2, .02F, 11, ARMOR_EQUIP_GOLD, rupee_ingot),
        GRAY_RUPEE = register(3, 8, 6, 3, 2, .02F, 11, ARMOR_EQUIP_GOLD, rupee_ingot),
        ELITE_REALMITE = register(3, 9, 7, 3, 3, .1F, 16, ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(BlockRegistry.realmiteBlock.asItem())),
        CORRUPTED = register(3, 9, 7, 3, 3, .05F, 15, ARMOR_EQUIP_DIAMOND, corrupted_stone),
        BEDROCK = register(4, 9, 7, 3, 3, .12F, ARMOR_EQUIP_NETHERITE),
        KORMA = register(4, 9, 7, 3, 3, .12F, 15, ARMOR_EQUIP_NETHERITE, arcanium),
        VEMOS = register(4, 9, 7, 3, 3, .12F, 15, ARMOR_EQUIP_NETHERITE, arcanium),
        ENDER = register(4, 7, 9, 3, 3, .12F, ARMOR_EQUIP_DIAMOND),
        RED_ENDER = register(4, 7, 9, 3, 3, .12F, ARMOR_EQUIP_DIAMOND),
        YELLOW_ENDER = register(4, 7, 9, 3, 3, .12F, ARMOR_EQUIP_DIAMOND),
        GREEN_ENDER = register(4, 7, 9, 3, 3, .12F, ARMOR_EQUIP_DIAMOND),
        BLUE_ENDER = register(4, 7, 9, 3, 3, .12F, ARMOR_EQUIP_DIAMOND),
        GRAY_ENDER = register(4, 7, 9, 3, 3, .12F, ARMOR_EQUIP_DIAMOND),
        DIVINE = register(4, 9, 7, 4, 3, .13F, ARMOR_EQUIP_DIAMOND),
        EDEN = register(4, 9, 8, 4, 3, .14F, 20, ARMOR_EQUIP_GOLD, eden_gem),
        WILDWOOD = register(5, 9, 8, 4, 3.5F, .15F, 21, ARMOR_EQUIP_DIAMOND, wildwood_gem),
        APALACHIA = register(5, 9, 8, 5, 3.5F, .16F, 22, ARMOR_EQUIP_DIAMOND, apalachia_gem),
        SKYTHERN = register(5, 9, 8, 5, 4, .18F, 23, ARMOR_EQUIP_DIAMOND, skythern_gem),
        MORTUM = register(5, 10, 8, 5, 4, .19F, 24, ARMOR_EQUIP_DIAMOND, mortum_gem),
        HALITE = register(5, 10, 8, 5, 4.5F, .2F, 25, ARMOR_EQUIP_DIAMOND, mortum_gem),
        AWAKENED_HALITE = register(5, 10, 9, 5, 4.5F, .21F, 26, ARMOR_EQUIP_NETHERITE, arcanium),

        DEGRADED = register(3, 5, 4, 2, 2, 0, 15, ARMOR_EQUIP_IRON),
        FINISHED = register(3, 6, 5, 3, 3, 0, 15, ARMOR_EQUIP_IRON),
        GLISTENING = register(4, 7, 6, 3, 4, 0, 15, ARMOR_EQUIP_IRON),
        DEMONIZED = register(4, 7, 6, 3, 5, 0, 15, ARMOR_EQUIP_IRON),
        TORMENTED = register(4, 7, 6, 3, 6, 0, 15, ARMOR_EQUIP_IRON);
    private static Holder<ArmorMaterial> register(int helmetArmor, int chestplateArmor, int leggingsArmor, int bootsArmor, float toughness, float knockbackResistance, Holder<SoundEvent> equipSound) {
        return register(helmetArmor, chestplateArmor, leggingsArmor, bootsArmor, toughness, knockbackResistance, 0, equipSound, () -> Ingredient.EMPTY);
    }
    private static Holder<ArmorMaterial> register(int helmetArmor, int chestplateArmor, int leggingsArmor, int bootsArmor, float toughness, float knockbackResistance, int enchantability, Holder<SoundEvent> equipSound) {
        return register(helmetArmor, chestplateArmor, leggingsArmor, bootsArmor, toughness, knockbackResistance, enchantability, equipSound, () -> Ingredient.EMPTY);
    }
    private static Holder<ArmorMaterial> register(int helmetArmor, int chestplateArmor, int leggingsArmor, int bootsArmor, float toughness, float knockbackResistance, int enchantability, Holder<SoundEvent> equipSound, Supplier<Ingredient> ing) {
    	EnumMap<ArmorItem.Type, Integer> enummap = new EnumMap<>(ArmorItem.Type.class);
        enummap.put(HELMET, helmetArmor);
        enummap.put(CHESTPLATE, chestplateArmor);
        enummap.put(LEGGINGS, leggingsArmor);
        enummap.put(BOOTS, bootsArmor);
        String name = ArmorMaterialRegistry.ARMOR_MATERIALS.getRegistryKey().toString();
        List<ArmorMaterial.Layer> layer = List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, name)));
        return ARMOR_MATERIALS.register(name, ()-> new ArmorMaterial(enummap, enchantability, equipSound, ing, layer, toughness, knockbackResistance));
    }
    private static Holder<ArmorMaterial> register(int helmetArmor, int chestplateArmor, int leggingsArmor, int bootsArmor, float toughness, float knockbackResistance, int enchantability, Holder<SoundEvent> equipSound, DeferredItem<Item> repair) {
        return register(helmetArmor, chestplateArmor, leggingsArmor, bootsArmor, toughness, knockbackResistance, enchantability, equipSound, () -> Ingredient.of(repair.get()));
    }
}