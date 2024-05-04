package divinerpg.enums;

import divinerpg.DivineRPG;
import divinerpg.registries.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import javax.annotation.Nullable;

import static net.minecraft.sounds.SoundEvents.*;

public enum ArmorStats implements ArmorMaterial {
    ANGELIC(3, 8, 6, 3, 2, 0, 35, 10, ARMOR_EQUIP_DIAMOND, ItemRegistry.shadow_stone.get()),
    REALMITE(2, 6, 6, 2, 0, 0, 16, 9, ARMOR_EQUIP_IRON, ItemRegistry.realmite_ingot.get()),
    SKELEMAN(2, 7, 6, 3, 0, 0, 21, 9, ARMOR_EQUIP_GENERIC, Items.BONE),
    ARLEMITE(3, 7, 6, 3, 1.5F, 0, 32, 10, ARMOR_EQUIP_IRON, ItemRegistry.arlemite_ingot.get()),
    JACK_O_MAN(2, 7, 6, 3, 0, 0, 21, 9, ARMOR_EQUIP_GENERIC, Blocks.PUMPKIN.asItem()),
    RUPEE(3, 8, 6, 3, 2, .02F, 35, 11, ARMOR_EQUIP_GOLD, ItemRegistry.rupee_ingot.get()),
    RED_RUPEE(3, 8, 6, 3, 2, .02F, 35, 11, ARMOR_EQUIP_GOLD, ItemRegistry.rupee_ingot.get()),
    YELLOW_RUPEE(3, 8, 6, 3, 2, .02F, 35, 11, ARMOR_EQUIP_GOLD, ItemRegistry.rupee_ingot.get()),
    GREEN_RUPEE(3, 8, 6, 3, 2, .02F, 35, 11, ARMOR_EQUIP_GOLD, ItemRegistry.rupee_ingot.get()),
    BLUE_RUPEE(3, 8, 6, 3, 2, .02F, 35, 11, ARMOR_EQUIP_GOLD, ItemRegistry.rupee_ingot.get()),
    GRAY_RUPEE(3, 8, 6, 3, 2, .02F, 35, 11, ARMOR_EQUIP_GOLD, ItemRegistry.rupee_ingot.get()),
    AQUASTRIVE(2, 7, 6, 2, 0, 0, 18, 9, ARMOR_EQUIP_IRON, ItemRegistry.aquatic_ingot.get()),
    KRAKEN(2, 7, 6, 3, 0, 0, 20, 9, ARMOR_EQUIP_TURTLE, ItemRegistry.kraken_skin.get()),
    WITHER_REAPER(2, 7, 6, 3, 0, 0, 21, 9, ARMOR_EQUIP_CHAIN, Items.BONE),
    INFERNO(3, 8, 6, 3, 2, 0, 34, 10, ARMOR_EQUIP_DIAMOND, ItemRegistry.molten_stone.get()),
    CORRUPTED(3, 9, 7, 3, 3, .05F, 40, 15, ARMOR_EQUIP_DIAMOND, ItemRegistry.corrupted_stone.get()),
    JUNGLE(3, 8, 6, 3, 2, 0, 33, 10, ARMOR_EQUIP_DIAMOND, ItemRegistry.jungle_stone.get()),
    TERRAN(3, 8, 6, 3, 2, 0, 34, 10, ARMOR_EQUIP_DIAMOND, ItemRegistry.terran_stone.get()),
    ENDER(4, 7, 9, 3, 3, .12F, ARMOR_EQUIP_DIAMOND),
    RED_ENDER(4, 7, 9, 3, 3, .12F, ARMOR_EQUIP_DIAMOND),
    YELLOW_ENDER(4, 7, 9, 3, 3, .12F, ARMOR_EQUIP_DIAMOND),
    GREEN_ENDER(4, 7, 9, 3, 3, .12F, ARMOR_EQUIP_DIAMOND),
    BLUE_ENDER(4, 7, 9, 3, 3, .12F, ARMOR_EQUIP_DIAMOND),
    GRAY_ENDER(4, 7, 9, 3, 3, .12F, ARMOR_EQUIP_DIAMOND),
    FROZEN(3, 8, 6, 3, 2, 0, 33, 10, ARMOR_EQUIP_DIAMOND, ItemRegistry.ice_stone.get()),
    TORRIDITE(3, 8, 6, 3, 2, 0, 34, 10, ARMOR_EQUIP_NETHERITE, ItemRegistry.torridite_chunk.get()),
    SENG_FUR(2, 7, 6, 2, 0, 0, 17, 15, ARMOR_EQUIP_LEATHER, ItemRegistry.seng_fur.get()),
    SANTA(2, 7, 6, 2, 0, 0, 17, 15, ARMOR_EQUIP_LEATHER, ItemRegistry.seng_fur.get()),
    SHADOW(3, 8, 6, 3, 2, 0, 35, 10, ARMOR_EQUIP_DIAMOND, ItemRegistry.shadow_stone.get()),
    VEMOS(4, 9, 7, 3, 3, .12F, 43, 15, ARMOR_EQUIP_NETHERITE, ItemRegistry.arcanium.get()),
    ELITE_REALMITE( 3, 9, 7, 3, 3, .1F, 39, 16, ARMOR_EQUIP_NETHERITE, BlockRegistry.realmiteBlock.get().asItem()),
    BEDROCK(4, 9, 7, 3, 3, .12F, ARMOR_EQUIP_NETHERITE),
    DIVINE(4, 9, 7, 4, 3, .13F, ARMOR_EQUIP_DIAMOND),
    EDEN(4, 9, 8, 4, 3, .14F, 45, 20, ARMOR_EQUIP_GOLD, ItemRegistry.eden_gem.get()),
    KORMA(4, 9, 7, 3, 3, .12F, 41, 15, ARMOR_EQUIP_NETHERITE, ItemRegistry.arcanium.get()),
    WILDWOOD(5, 9, 8, 4, 3.5F, .15F, 46, 21, ARMOR_EQUIP_DIAMOND, ItemRegistry.wildwood_gem.get()),
    APALACHIA(5, 9, 8, 5, 3.5F, .16F, 47, 22, ARMOR_EQUIP_DIAMOND, ItemRegistry.apalachia_gem.get()),
    SKYTHERN(5, 9, 8, 5, 4, .18F, 48, 23, ARMOR_EQUIP_DIAMOND, ItemRegistry.skythern_gem.get()),
    MORTUM(5, 10, 8, 5, 4, .19F, 49, 24, ARMOR_EQUIP_DIAMOND, ItemRegistry.mortum_gem.get()),
    HALITE(5, 10, 8, 5, 4.5F, .2F, 50, 25, ARMOR_EQUIP_DIAMOND, ItemRegistry.mortum_gem.get()),
    AWAKENED_HALITE(5, 10, 9, 5, 4.5F, .21F, 51, 26, ARMOR_EQUIP_NETHERITE, ItemRegistry.arcanium.get()),

    DEGRADED(3, 5, 4, 2, 2, 0, 25, 15, ARMOR_EQUIP_IRON),
    FINISHED(3, 6, 5, 3, 3, 0, 30, 15, ARMOR_EQUIP_IRON),
    GLISTENING( 4, 7, 6, 3, 4, 0, 35, 15, ARMOR_EQUIP_IRON),
    DEMONIZED(4, 7, 6, 3, 5, 0, 40, 15, ARMOR_EQUIP_IRON),
    TORMENTED(4, 7, 6, 3, 6, 0, 45, 15, ARMOR_EQUIP_IRON);

    final String textureLocation, name;
    final SoundEvent equipSound;
    final Ingredient repairIngredient;
    final int headArmor, chestArmor, legsArmor, feetArmor, durability, enchantability;
    final float toughness, knockbackResistance;
    ArmorStats(int headArmor, int chestArmor, int legsArmor, int feetArmor, float toughness, float resistance, SoundEvent equipSound) {
        this(null, null, headArmor, chestArmor, legsArmor, feetArmor, toughness, resistance, 0, 0, equipSound, null);
    }
    ArmorStats(int headArmor, int chestArmor, int legsArmor, int feetArmor, float toughness, float resistance, int durability, int enchantability, SoundEvent equipSound) {
        this(null, null, headArmor, chestArmor, legsArmor, feetArmor, toughness, resistance, durability, enchantability, equipSound, null);
    }
    ArmorStats(int headArmor, int chestArmor, int legsArmor, int feetArmor, float toughness, float resistance, int durability, int enchantability, SoundEvent equipSound, @Nullable Item repairIngredient) {
        this(null, null, headArmor, chestArmor, legsArmor, feetArmor, toughness, resistance, durability, enchantability, equipSound, repairIngredient);
    }
    ArmorStats(@Nullable String customTextureLocation, @Nullable String name, int headArmor, int chestArmor, int legsArmor, int feetArmor, float toughness, float resistance, int durability, int enchantability, @Nullable SoundEvent equipSound, @Nullable Item repairIngredient) {
        String nonnullName = name == null ? toString().toLowerCase() : name;
        textureLocation = customTextureLocation == null ? "drpg_" + nonnullName + "armor" : customTextureLocation;
        this.name = DivineRPG.MODID + ":" + nonnullName;
        this.headArmor = headArmor;
        this.chestArmor = chestArmor;
        this.legsArmor = legsArmor;
        this.feetArmor = feetArmor;
        this.toughness = toughness;
        knockbackResistance = resistance;
        this.durability = durability;
        this.enchantability = enchantability;
        this.equipSound = equipSound == null ? ARMOR_EQUIP_GENERIC : equipSound;
        this.repairIngredient = repairIngredient == null ? Ingredient.EMPTY : Ingredient.of(repairIngredient);
    }
    public String getTextureLocation() {return textureLocation;}
    @Override public int getDurabilityForType(ArmorItem.Type type) {
        if(type == ArmorItem.Type.HELMET) return durability * 11;
        else if(type == ArmorItem.Type.CHESTPLATE) return durability * 16;
        else if(type == ArmorItem.Type.LEGGINGS) return durability * 15;
        else return durability * 13;
    }
    @Override public int getEnchantmentValue() {return enchantability;}
    @Override public SoundEvent getEquipSound() {return equipSound;}
    @Override public Ingredient getRepairIngredient() {return repairIngredient;}
    @Override public String getName() {return name;}
    @Override public float getToughness() {return toughness;}
    @Override public float getKnockbackResistance() {return knockbackResistance;}
    @Override public int getDefenseForType(ArmorItem.Type type) {
        return switch(type) {
            case HELMET -> headArmor;
            case CHESTPLATE -> chestArmor;
            case LEGGINGS -> legsArmor;
            default -> feetArmor;
        };
    }
}