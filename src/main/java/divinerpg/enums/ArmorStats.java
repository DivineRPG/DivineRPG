package divinerpg.enums;

import divinerpg.DivineRPG;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

import static net.minecraft.sounds.SoundEvents.*;

public enum ArmorStats implements ArmorMaterial {
    ANGELIC(3, 8, 6, 3, 2, 0, 35, 10, ARMOR_EQUIP_DIAMOND, Ingredient.of(ItemTags.create(new ResourceLocation("forge:gems/shadow")))),
    REALMITE(2, 6, 6, 2, 0, 0, 16, 9, ARMOR_EQUIP_IRON, Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/realmite")))),
    SKELEMAN(2, 7, 6, 3, 0, 0, 21, 9, ARMOR_EQUIP_GENERIC, Ingredient.of(Items.BONE)),
    ARLEMITE(3, 7, 6, 3, 1.5F, 0, 32, 10, ARMOR_EQUIP_IRON, Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/arlemite")))),
    JACK_O_MAN(2, 7, 6, 3, 0, 0, 21, 9, ARMOR_EQUIP_GENERIC, Ingredient.of(Blocks.PUMPKIN)),
    RUPEE(3, 8, 6, 3, 2, .02F, 35, 11, ARMOR_EQUIP_GOLD, Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/rupee")))),
    RED_RUPEE(3, 8, 6, 3, 2, .02F, 35, 11, ARMOR_EQUIP_GOLD, Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/rupee")))),
    YELLOW_RUPEE(3, 8, 6, 3, 2, .02F, 35, 11, ARMOR_EQUIP_GOLD, Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/rupee")))),
    GREEN_RUPEE(3, 8, 6, 3, 2, .02F, 35, 11, ARMOR_EQUIP_GOLD, Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/rupee")))),
    BLUE_RUPEE(3, 8, 6, 3, 2, .02F, 35, 11, ARMOR_EQUIP_GOLD, Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/rupee")))),
    GRAY_RUPEE(3, 8, 6, 3, 2, .02F, 35, 11, ARMOR_EQUIP_GOLD, Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/rupee")))),
    AQUASTRIVE(2, 7, 6, 2, 0, 0, 18, 9, ARMOR_EQUIP_IRON, Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/aquatic")))),
    KRAKEN(2, 7, 6, 3, 0, 0, 20, 9, ARMOR_EQUIP_TURTLE, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "kraken_skin")))),
    WITHER_REAPER(2, 7, 6, 3, 0, 0, 21, 9, ARMOR_EQUIP_CHAIN, Ingredient.of(Items.BONE)),
    INFERNO(3, 8, 6, 3, 2, 0, 34, 10, ARMOR_EQUIP_DIAMOND, Ingredient.of(ItemTags.create(new ResourceLocation("forge:gems/molten")))),
    CORRUPTED(3, 9, 7, 3, 3, .05F, 40, 15, ARMOR_EQUIP_DIAMOND, Ingredient.of(ItemTags.create(new ResourceLocation("forge:gems/corrupted")))),
    JUNGLE(3, 8, 6, 3, 2, 0, 33, 10, ARMOR_EQUIP_DIAMOND, Ingredient.of(ItemTags.create(new ResourceLocation("forge:gems/jungle")))),
    TERRAN(3, 8, 6, 3, 2, 0, 34, 10, ARMOR_EQUIP_DIAMOND, Ingredient.of(ItemTags.create(new ResourceLocation("forge:gems/terran")))),
    ENDER(4, 7, 9, 3, 3, .12F, -1, 0, ARMOR_EQUIP_DIAMOND),
    RED_ENDER(4, 7, 9, 3, 3, .12F, -1, 0, ARMOR_EQUIP_DIAMOND),
    YELLOW_ENDER(4, 7, 9, 3, 3, .12F, -1, 0, ARMOR_EQUIP_DIAMOND),
    GREEN_ENDER(4, 7, 9, 3, 3, .12F, -1, 0, ARMOR_EQUIP_DIAMOND),
    BLUE_ENDER(4, 7, 9, 3, 3, .12F, -1, 0, ARMOR_EQUIP_DIAMOND),
    GRAY_ENDER(4, 7, 9, 3, 3, .12F, -1, 0, ARMOR_EQUIP_DIAMOND),
    FROZEN(3, 8, 6, 3, 2, 0, 33, 10, ARMOR_EQUIP_DIAMOND, Ingredient.of(ItemTags.create(new ResourceLocation("forge:gems/ice")))),
    TORRIDITE(3, 8, 6, 3, 2, 0, 34, 10, ARMOR_EQUIP_NETHERITE, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "torridite_chunk")))),
    SENG_FUR(2, 7, 6, 2, 0, 0, 17, 15, ARMOR_EQUIP_LEATHER, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "seng_fur")))),
    SANTA(2, 7, 6, 2, 0, 0, 17, 15, ARMOR_EQUIP_LEATHER, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "seng_fur")))),
    SHADOW(3, 8, 6, 3, 2, 0, 35, 10, ARMOR_EQUIP_DIAMOND, Ingredient.of(ItemTags.create(new ResourceLocation("forge:gems/shadow")))),
    VEMOS(4, 9, 7, 3, 3, .12F, 43, 15, ARMOR_EQUIP_NETHERITE, Ingredient.of(ItemTags.create(new ResourceLocation("forge:gems/arcanium")))),
    ELITE_REALMITE( 3, 9, 7, 3, 3, .1F, 39, 16, ARMOR_EQUIP_NETHERITE, Ingredient.of(ItemTags.create(new ResourceLocation("forge:storage_blocks/realmite")))),
    BEDROCK(4, 9, 7, 3, 3, .12F, -1, 0, ARMOR_EQUIP_NETHERITE),
    DIVINE(4, 9, 7, 4, 3, .13F, -1, 0, ARMOR_EQUIP_DIAMOND),
    EDEN(4, 9, 8, 4, 3, .14F, 45, 20, ARMOR_EQUIP_GOLD, Ingredient.of(ItemTags.create(new ResourceLocation("forge:gems/eden")))),
    KORMA(4, 9, 7, 3, 3, .12F, 41, 15, ARMOR_EQUIP_NETHERITE, Ingredient.of(ItemTags.create(new ResourceLocation("forge:gems/arcanium")))),
    WILDWOOD(5, 9, 8, 4, 3.5F, .15F, 46, 21, ARMOR_EQUIP_DIAMOND, Ingredient.of(ItemTags.create(new ResourceLocation("forge:gems/wildwood")))),
    APALACHIA(5, 9, 8, 5, 3.5F, .16F, 47, 22, ARMOR_EQUIP_DIAMOND, Ingredient.of(ItemTags.create(new ResourceLocation("forge:gems/apalachia")))),
    SKYTHERN(5, 9, 8, 5, 4, .18F, 48, 23, ARMOR_EQUIP_DIAMOND, Ingredient.of(ItemTags.create(new ResourceLocation("forge:gems/skythern")))),
    MORTUM(5, 10, 8, 5, 4, .19F, 49, 24, ARMOR_EQUIP_DIAMOND, Ingredient.of(ItemTags.create(new ResourceLocation("forge:gems/mortum")))),
    HALITE(5, 10, 8, 5, 4.5F, .2F, 50, 25, ARMOR_EQUIP_DIAMOND, Ingredient.of(ItemTags.create(new ResourceLocation("forge:gems/mortum")))),
    AWAKENED_HALITE(5, 10, 9, 5, 4.5F, .21F, 51, 26, ARMOR_EQUIP_NETHERITE, Ingredient.of(ItemTags.create(new ResourceLocation("forge:gems/arcanium")))),

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
    ArmorStats(int headArmor, int chestArmor, int legsArmor, int feetArmor, float toughness, float resistance, int durability, int enchantability, SoundEvent equipSound) {
        this(null, null, headArmor, chestArmor, legsArmor, feetArmor, toughness, resistance, durability, enchantability, equipSound, null);
    }
    ArmorStats(int headArmor, int chestArmor, int legsArmor, int feetArmor, float toughness, float resistance, int durability, int enchantability, SoundEvent equipSound, @Nullable Ingredient repairIngredient) {
        this(null, null, headArmor, chestArmor, legsArmor, feetArmor, toughness, resistance, durability, enchantability, equipSound, repairIngredient);
    }
    ArmorStats(@Nullable String customTextureLocation, @Nullable String name, int headArmor, int chestArmor, int legsArmor, int feetArmor, float toughness, float resistance, int durability, int enchantability, @Nullable SoundEvent equipSound, @Nullable Ingredient repairIngredient) {
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
        this.repairIngredient = repairIngredient == null ? Ingredient.EMPTY : repairIngredient;
    }
    public String getTextureLocation() {return textureLocation;}
    @Override public int getDurabilityForType(ArmorItem.Type type) {
        if(type == ArmorItem.Type.HELMET) {
            return durability * 11;
        } else if(type == ArmorItem.Type.CHESTPLATE) {
            return durability * 16;
        } else if(type == ArmorItem.Type.LEGGINGS) {
            return durability * 15;
        } else return durability * 13;
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