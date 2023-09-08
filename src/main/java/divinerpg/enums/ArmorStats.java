package divinerpg.enums;

import divinerpg.DivineRPG;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

import static net.minecraft.sounds.SoundEvents.*;

public enum ArmorStats implements ArmorMaterial {
    ANGELIC(		3, 5, 4, 2, 0F, 200, 15),
    REALMITE(		3, 6, 5, 2, 0F, 350, 10, ARMOR_EQUIP_IRON, Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/realmite")))),
    SKELEMAN(		4, 6, 5, 3, 1F, 240, 12),
    ARLEMITE(		4, 6, 5, 3, 1.5F, 650, 10, ARMOR_EQUIP_IRON, Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/arlemite")))),
    JACK_O_MAN(		4, 6, 5, 4, 2F, 260, 12),
    RUPEE(			4, 7, 5, 4, 2F, 750, 10, ARMOR_EQUIP_IRON, Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/rupee")))),
    AQUASTRIVE(		4, 6, 5, 4, 2.5F, 1200, 10, Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/aquatic")))),
    KRAKEN(			4, 7, 5, 4, 2.5F, 280, 10, ARMOR_EQUIP_TURTLE, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "kraken_skin")))),
    WITHER_REAPER(	4, 7, 5, 4, 2.5F, 850, 12, ARMOR_EQUIP_CHAIN),
    INFERNO(		4, 7, 5, 4, 2.5F, 450, 10, ARMOR_EQUIP_DIAMOND, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "molten_stone")))),
    CORRUPTED(		4, 7, 5, 4, 2.5F, 420, 12, ARMOR_EQUIP_NETHERITE, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "corrupted_stone")))),
    JUNGLE(			4, 7, 5, 4, 2.5F, 310, 10, ARMOR_EQUIP_DIAMOND, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "jungle_stone")))),
    TERRAN(			4, 7, 5, 4, 2.5F, 310, 12, ARMOR_EQUIP_DIAMOND, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "terran_stone")))),
    ENDER(			4, 7, 5, 4, 2.5F, 380, 10, ARMOR_EQUIP_DIAMOND, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "ender_stone")))),
    FROZEN(			4, 7, 5, 4, 2.5F, 450, 10, ARMOR_EQUIP_DIAMOND, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "ice_stone")))),
    TORRIDITE(		4, 7, 5, 4, 3F, 360, 10, ARMOR_EQUIP_NETHERITE, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "torridite_chunk")))),
    SHADOW(			4, 7, 5, 4, 3F, 280, 12, ARMOR_EQUIP_GOLD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "shadow_stone")))),
    VEMOS(			4, 7, 5, 4, 3F, 300, 12),
    ELITE_REALMITE( 4, 7, 5, 4, 3F, 950, 12, ARMOR_EQUIP_GOLD, Ingredient.of(ItemTags.create(new ResourceLocation("forge:storage_blocks/realmite")))),
    BEDROCK(		4, 7, 5, 4, 3F, 4000, 10, ARMOR_EQUIP_NETHERITE, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "bedrock_chunk")))),
    DIVINE(			4, 7, 5, 4, 3.5F, 620, 15, ARMOR_EQUIP_DIAMOND, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_stone")))),
    EDEN(			4, 7, 5, 4, 4F, 950, 12, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_chunk")))),
    KORMA(			4, 7, 5, 4, 4.5F, 380, 15),
    WILDWOOD(		4, 7, 5, 4, 5F, 1050, 12, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_chunk")))),
    APALACHIA(		4, 7, 5, 4, 6F, 1250, 12, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_chunk")))),
    SKYTHERN(		4, 7, 5, 4, 7F, 1350, 12, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_chunk")))),
    MORTUM(			4, 7, 5, 4, 8F, 1600, 12, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_chunk")))),
    HALITE(			4, 7, 5, 4, 8.5F, 1800, 12, ARMOR_EQUIP_DIAMOND),
    AWAKENED_HALITE(4, 7, 5, 4, 9F, 3000, 15, ARMOR_EQUIP_NETHERITE),

    DEGRADED(	3, 5, 4, 2, 2F, 250, 15),
    FINISHED(	3, 6, 5, 3, 3F, 300, 15),
    GLISTENING( 4, 7, 6, 3, 4F, 350, 15),
    DEMONIZED(	4, 7, 6, 3, 5F, 400, 15),
    TORMENTED(	4, 7, 6, 3, 6F, 450, 15),
    SENG_FUR(	4, 6, 5, 3, 5F, 380, 19, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "seng_fur"))));

    final String textureLocation, name;
    final SoundEvent equipSound;
    final Ingredient repairIngredient;
    final int headArmor, chestArmor, legsArmor, feetArmor, durability, enchantability;
    final float toughness;
    ArmorStats(int headArmor, int chestArmor, int legsArmor, int feetArmor, float toughness, int durability, int enchantability) {
        this(null, null, headArmor, chestArmor, legsArmor, feetArmor, toughness, durability, enchantability, null, null);
    }
    ArmorStats(int headArmor, int chestArmor, int legsArmor, int feetArmor, float toughness, int durability, int enchantability, @Nullable SoundEvent equipSound) {
        this(null, null, headArmor, chestArmor, legsArmor, feetArmor, toughness, durability, enchantability, equipSound, null);
    }
    ArmorStats(int headArmor, int chestArmor, int legsArmor, int feetArmor, float toughness, int durability, int enchantability, @Nullable Ingredient repairIngredient) {
        this(null, null, headArmor, chestArmor, legsArmor, feetArmor, toughness, durability, enchantability, null, repairIngredient);
    }
    ArmorStats(int headArmor, int chestArmor, int legsArmor, int feetArmor, float toughness, int durability, int enchantability, @Nullable SoundEvent equipSound, @Nullable Ingredient repairIngredient) {
        this(null, null, headArmor, chestArmor, legsArmor, feetArmor, toughness, durability, enchantability, equipSound, repairIngredient);
    }
    ArmorStats(@Nullable String customTextureLocation, @Nullable String name, int headArmor, int chestArmor, int legsArmor, int feetArmor, float toughness, int durability, int enchantability, @Nullable SoundEvent equipSound, @Nullable Ingredient repairIngredient) {
        String nonnullName = name == null ? toString().toLowerCase() : name;
        this.textureLocation = customTextureLocation == null ? "drpg_" + nonnullName + "armor" : customTextureLocation;
        this.name = DivineRPG.MODID + ":" + nonnullName;
        this.headArmor = headArmor;
        this.chestArmor = chestArmor;
        this.legsArmor = legsArmor;
        this.feetArmor = feetArmor;
        this.toughness = toughness;
        this.durability = durability;
        this.enchantability = enchantability;
        this.equipSound = equipSound == null ? ARMOR_EQUIP_GENERIC : equipSound;
        this.repairIngredient = repairIngredient == null ? Ingredient.EMPTY : repairIngredient;

    }
    public String getTextureLocation() {return textureLocation;}


    @Override public int getDurabilityForType(ArmorItem.Type type) {return durability;}
    @Override public int getEnchantmentValue() {return enchantability;}
    @Override public SoundEvent getEquipSound() {return equipSound;}
    @Override public Ingredient getRepairIngredient() {return repairIngredient;}
    @Override public String getName() {return name;}
    @Override public float getToughness() {return toughness;}
    @Override public float getKnockbackResistance() {return 0;}
    @Override public int getDefenseForType(ArmorItem.Type type) {
        return switch(type) {
            case HELMET -> headArmor;
            case CHESTPLATE -> chestArmor;
            case LEGGINGS -> legsArmor;
            default -> feetArmor;
        };
    }
}