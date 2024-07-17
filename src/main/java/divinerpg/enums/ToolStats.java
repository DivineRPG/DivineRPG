package divinerpg.enums;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import static divinerpg.enums.ToolStats.SwordSpecial.*;
import static divinerpg.registries.ItemRegistry.*;
import static net.minecraft.tags.BlockTags.*;

public enum ToolStats implements Tier {
    APALACHIA_BLADE(INCORRECT_FOR_NETHERITE_TOOL, 2540, -2.4F, 25, 22, apalachia_gem.get()),
    AQUATON(INCORRECT_FOR_IRON_TOOL, 992, -2.4F, 6.5F, 10, aquatic_ingot.get()),
    AQUATOOTH_MAUL(INCORRECT_FOR_IRON_TOOL, 1524, -2.7F, 10.5F, 10, liopleurodon_teeth.get()),
    AQUATOOTH_SWORD(INCORRECT_FOR_IRON_TOOL, 1245, -2.4F, 7.5F, 10, liopleurodon_teeth.get()),
    AQUA_DAGGER(INCORRECT_FOR_IRON_TOOL, 535, -2, 3.5F, 12, aquatic_ingot.get()),
    AQUA_MAUL(INCORRECT_FOR_IRON_TOOL, 1058, -2.7F, 9.2F, 10, aquatic_ingot.get()),
    AQUA_TRIDENT(INCORRECT_FOR_IRON_TOOL, 843, -2.4F, 6, 10, aquatic_ingot.get()),
    ARCANITE_BLADE(INCORRECT_FOR_NETHERITE_TOOL, 2048, -2.4F, 6, 15, arcanium.get(), ARCANA_DAMAGE, 8, 0),
    ARCANIUM_SABER(INCORRECT_FOR_DIAMOND_TOOL, -2.4F, 5, ARCANA_DAMAGE, 7, 0),
    ARLEMITE_STABBER(INCORRECT_FOR_DIAMOND_TOOL, 1535, -2.4F, 5, 10, arlemite_ingot.get()),
    BEDROCK_MAUL(INCORRECT_FOR_NETHERITE_TOOL, -2.7F, 11.5F),
    BEDROCK_SWORD(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 8),
    BLOODGEM_SWORD(INCORRECT_FOR_DIAMOND_TOOL, -2.4F, 5.2F),
    BOWHEAD_ANCHOR(INCORRECT_FOR_IRON_TOOL, 768, -3, 8, 15, whale_fin.get()),
    CORRUPTED_MAUL(INCORRECT_FOR_NETHERITE_TOOL, 2948, -2.7F, 11.1F, 15, corrupted_stone.get()),
    CRABCLAW_MAUL(INCORRECT_FOR_IRON_TOOL, 1025, -2.7F, 6.1F, 13, crab_claw.get()),
    CRAB_ANCHOR(INCORRECT_FOR_IRON_TOOL, 384, -3, 6, 15, crab_claw.get()),
    CYCLOPSIAN_SWORD(INCORRECT_FOR_IRON_TOOL, 300, -2.4F, 4, 14, cyclops_eye.get()),
    DEATH_BRINGER(INCORRECT_FOR_NETHERITE_TOOL, 1545, -2.4F, 7.3F, 15, corrupted_stone.get()),
    DIVINE_SWORD(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 13),
    DUAL_CLAW(INCORRECT_FOR_IRON_TOOL, 822, -2.3F, 5.2F, 10, crab_claw.get()),
    EDEN_BLADE(INCORRECT_FOR_NETHERITE_TOOL, 2124, -2.4F, 17, 22, eden_gem.get()),
    ENDERICE(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 13, SLOW, 1, 3),
    ENDER_SWORD(INCORRECT_FOR_NETHERITE_TOOL, 2556, -2.4F, 12, 10, ender_stone.get()),
    FLAMING_FURY(INCORRECT_FOR_NETHERITE_TOOL, 3025, -2.3F, 10, 16, molten_stone.get(), FLAME, 0, 15),
    FROSSIVENCE(INCORRECT_FOR_WOODEN_TOOL, 270, -2.4F, -1, 0, snowflake.get(), HEAL, 0, 0),
    FROSTKING_SWORD(INCORRECT_FOR_DIAMOND_TOOL, 1521, -2.4F, 6.5F, 13, snowflake.get()),
    FROST_SWORD(INCORRECT_FOR_DIAMOND_TOOL, 1226, -2.4F, 5.1F, 10, ice_stone.get(), SLOW, 1, 3),
    FROZEN_MAUL(INCORRECT_FOR_NETHERITE_TOOL, -2.7F, 12.5F, SLOW, 1, 3),
    FURY_MAUL(INCORRECT_FOR_NETHERITE_TOOL, 3127, -2.8F, 14, 15, Items.DIAMOND),
    GLACIAL_BLADE(INCORRECT_FOR_DIAMOND_TOOL, 1232, -2.3F, 11, 13, snowflake.get(), SLOW, 4, 2),
    GLACIER_SWORD(INCORRECT_FOR_DIAMOND_TOOL, 1021, -2.6F, 7, 13, snowflake.get(), SLOW, 1, 3),
    HALITE_BLADE(INCORRECT_FOR_NETHERITE_TOOL, 3187, -2.4F, 34, 22, mortum_gem.get()),
    ICICLE_BANE(INCORRECT_FOR_DIAMOND_TOOL, 1622, -2.5F, 6, 13, snowflake.get(), SLOW, 1, 3),
    ICICLE_DAGGER(INCORRECT_FOR_NETHERITE_TOOL, 4, -2, 20, 13, null),
    ICINE_SWORD(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 14, SLOW, 1, 3),
    INFERNO_SWORD(INCORRECT_FOR_IRON_TOOL, -2.4F, 5.2F, FLAME, 0, 12),
    JUNGLE_KNIFE(INCORRECT_FOR_DIAMOND_TOOL, 1292, -2.4F, 5.2F, 10, jungle_stone.get(), POISON, 1, 3),
    JUNGLE_RAPIER(INCORRECT_FOR_DIAMOND_TOOL, 1425, -2.4F, 6, 12, jungle_stone.get(), POISON, 1, 4),
    LIOPLEURODON_ANCHOR(INCORRECT_FOR_IRON_TOOL, 960, -3, 9, 15, liopleurodon_teeth.get()),
    LIVICIA_SWORD(INCORRECT_FOR_NETHERITE_TOOL, 3223, -2.4F, 15.5F, 16, shadow_stone.get()),
    MASSIVENCE(INCORRECT_FOR_WOODEN_TOOL, 60, -2.4F, -1, 0, bloodgem.get(), HEAL, 0, 0),
    MOLTEN_SWORD(INCORRECT_FOR_DIAMOND_TOOL, 1297, -2.4F, 5.4F, 10, molten_stone.get(), FLAME, 0, 5),
    MORTUM_BLADE(INCORRECT_FOR_NETHERITE_TOOL, 2922, -2.4F, 31, 22, mortum_gem.get()),
    OCEAN_KNIFE(INCORRECT_FOR_IRON_TOOL, 678, -2.4F, 5.4F, 10, aquatic_ingot.get()),
    PALAVENCE(INCORRECT_FOR_WOODEN_TOOL, 60, -2.4F, -1, 0, realmite_ingot.get(), HEAL, 0, 0),
    POISON_SABER(INCORRECT_FOR_DIAMOND_TOOL, 1315, -2.4F, 6.5F, 15, jungle_stone.get(), POISON, 1, 5),
    REALMITE_SWORD(INCORRECT_FOR_IRON_TOOL, 325, -2.4F, 4.5F, 14, realmite_ingot.get()),
    RUPEE_RAPIER(INCORRECT_FOR_DIAMOND_TOOL, 1634, -2.4F, 5.5F, 14, rupee_ingot.get()),
    SABEAR_SABRE(INCORRECT_FOR_IRON_TOOL, 982, -2.3F, 4.4F, 15, sabear_tooth.get()),
    SANDSLASH(INCORRECT_FOR_NETHERITE_TOOL, 100, -2.4F, 16, 15, divine_stone.get()),
    SCORCHING_SWORD(INCORRECT_FOR_NETHERITE_TOOL, 1212, -2.4F, 6.2F, 15, purple_blaze.get()),
    SHADOW_SABER(INCORRECT_FOR_DIAMOND_TOOL, -2.2F, 10, SPEED, 1, 5),
    SHARK_ANCHOR(INCORRECT_FOR_IRON_TOOL, 576, -3, 7, 15, shark_fin.get()),
    SHARK_SWORD(INCORRECT_FOR_IRON_TOOL, 627, -2.4F, 5.5F, 10, aquatic_ingot.get()),
    SKYTHERN_BLADE(INCORRECT_FOR_NETHERITE_TOOL, 2783, -2.4F, 29, 22, skythern_gem.get()),
    SLIME_SWORD(INCORRECT_FOR_IRON_TOOL, 739, -2.6F, 6.5F, 10, Items.DIAMOND),
    SNOWSLASH(INCORRECT_FOR_NETHERITE_TOOL, 150, -2.4F, 17, 15, snowflake.get(), SLOW, 1, 3),
    SOULFIRE_SWORD(INCORRECT_FOR_NETHERITE_TOOL, 1623, -2.4F, 7, 15, soulfire_stone.get()),
    STORM_SWORD(INCORRECT_FOR_DIAMOND_TOOL, -2.4F, 5, LIGHTNING, 0, 0),
    TERRAN_DAGGER(INCORRECT_FOR_DIAMOND_TOOL, 425, -2, 3.4F, 12, terran_stone.get()),
    TERRAN_KNIFE(INCORRECT_FOR_DIAMOND_TOOL, 1257, -2.4F, 5.1F, 10, terran_stone.get()),
    TERRAN_MAUL(INCORRECT_FOR_DIAMOND_TOOL, 1476, -2.7F, 7.4F, 10, terran_stone.get()),
    WILDWOOD_BLADE(INCORRECT_FOR_NETHERITE_TOOL, 2342, -2.4F, 21, 22, wildwood_gem.get()),

    //Dream Tools
    DREAM_SHOVEL(INCORRECT_FOR_NETHERITE_TOOL, 513, 8, 4, 5, null),
    DREAM_PICKAXE(INCORRECT_FOR_NETHERITE_TOOL, 513, 8, 3.5F, 5, null),
    DREAM_AXE(INCORRECT_FOR_NETHERITE_TOOL, 513, 8, 8, 5, null),

    //Shickaxes
    APALACHIA_SHICKAXE(INCORRECT_FOR_NETHERITE_TOOL, 3540, 25, 12, 22, apalachia_chunk.get()),
    ARLEMITE_SHICKAXE(INCORRECT_FOR_DIAMOND_TOOL, 2535, 8, 3.2F, 10, arlemite_ingot.get()),
    CORRUPTED_SHICKAXE(INCORRECT_FOR_NETHERITE_TOOL, 3065, 10, 5, 15, corrupted_stone.get()),
    DIVINE_SHICKAXE(INCORRECT_FOR_NETHERITE_TOOL, 13, 7),
    EDEN_SHICKAXE(INCORRECT_FOR_NETHERITE_TOOL, 3124, 15, 9, 22, eden_chunk.get()),
    HALITE_SHICKAXE(INCORRECT_FOR_NETHERITE_TOOL, 40, 16),
    MORTUM_SHICKAXE(INCORRECT_FOR_NETHERITE_TOOL, 3922, 35, 15, 22, mortum_chunk.get()),
    RUPEE_SHICKAXE(INCORRECT_FOR_DIAMOND_TOOL, 2634, 8, 3.5F, 14, rupee_ingot.get()),
    SKYTHERN_SHICKAXE(INCORRECT_FOR_NETHERITE_TOOL, 3783, 30, 14, 22, skythern_chunk.get()),
    TERRAN_SHICKAXE(INCORRECT_FOR_DIAMOND_TOOL, 2586, 8, 3.3F, 10, terran_stone.get()),
    WILDWOOD_SHICKAXE(INCORRECT_FOR_NETHERITE_TOOL, 3342, 20, 11, 22, wildwood_chunk.get()),

    //Axes
    APALACHIA_AXE(INCORRECT_FOR_NETHERITE_TOOL, 2540, 25, 29, 22, apalachia_gem.get()),
    ARLEMITE_AXE(INCORRECT_FOR_DIAMOND_TOOL, 1535, 8, 8, 10, arlemite_ingot.get()),
    BEDROCK_AXE(INCORRECT_FOR_NETHERITE_TOOL, 11, 11),
    CORRUPTED_AXE(INCORRECT_FOR_NETHERITE_TOOL, 2065, 10, 10.3F, 15, corrupted_stone.get()),
    DIVINE_AXE(INCORRECT_FOR_NETHERITE_TOOL, 13, 16.5F),
    EDEN_AXE(INCORRECT_FOR_NETHERITE_TOOL, 2124, 15, 21, 22, eden_gem.get()),
    MORTUM_AXE(INCORRECT_FOR_NETHERITE_TOOL, 2922, 35, 36, 22, mortum_gem.get()),
    REALMITE_AXE(INCORRECT_FOR_IRON_TOOL, 325, 7, 8, 14, realmite_ingot.get()),
    RUPEE_AXE(INCORRECT_FOR_DIAMOND_TOOL, 1634, 8, 8.5F, 14, rupee_ingot.get()),
    SKYTHERN_AXE(INCORRECT_FOR_NETHERITE_TOOL, 2783, 30, 34, 22, skythern_gem.get()),
    TERRAN_AXE(INCORRECT_FOR_DIAMOND_TOOL, 1586, 8, 8.2F, 10, terran_stone.get()),
    WILDWOOD_AXE(INCORRECT_FOR_NETHERITE_TOOL, 2342, 20, 25, 22, wildwood_gem.get()),

    //Pickaxes
    APALACHIA_PICKAXE(INCORRECT_FOR_NETHERITE_TOOL, 2540, 25, 10, 22, apalachia_gem.get()),
    ARLEMITE_PICKAXE(INCORRECT_FOR_DIAMOND_TOOL, 1535, 8, 4, 10, arlemite_ingot.get()),
    BEDROCK_PICKAXE(INCORRECT_FOR_NETHERITE_TOOL, 11, 6),
    CORRUPTED_PICKAXE(INCORRECT_FOR_NETHERITE_TOOL, 2065, 10, 5.5F, 15, corrupted_stone.get()),
    DIVINE_PICKAXE(INCORRECT_FOR_NETHERITE_TOOL, 13, 7),
    EDEN_PICKAXE(INCORRECT_FOR_NETHERITE_TOOL, 2124, 15, 8, 22, eden_gem.get()),
    MORTUM_PICKAXE(INCORRECT_FOR_NETHERITE_TOOL, 2922, 35, 12, 22, mortum_gem.get()),
    REALMITE_PICKAXE(INCORRECT_FOR_IRON_TOOL, 325, 7, 3.5F, 14, realmite_ingot.get()),
    OXDRITE_PICKAXE(INCORRECT_FOR_IRON_TOOL, 347, 7, 3.5F, 14, oxdrite_ingot.get()),
    RUPEE_PICKAXE(INCORRECT_FOR_DIAMOND_TOOL, 1634, 8, 4.5F, 14, rupee_ingot.get()),
    SKYTHERN_PICKAXE(INCORRECT_FOR_NETHERITE_TOOL, 2783, 30, 11, 22, skythern_gem.get()),
    TERRAN_PICKAXE(INCORRECT_FOR_DIAMOND_TOOL, 1586, 8, 4.1F, 10, terran_stone.get()),
    WILDWOOD_PICKAXE(INCORRECT_FOR_NETHERITE_TOOL, 2342, 20, 9, 22, wildwood_gem.get()),

    //Shovels
    APALACHIA_SHOVEL(INCORRECT_FOR_NETHERITE_TOOL, 2540, 25, 10.5F, 22, apalachia_gem.get()),
    ARLEMITE_SHOVEL(INCORRECT_FOR_DIAMOND_TOOL, 1535, 8, 4.5F, 10, arlemite_ingot.get()),
    BEDROCK_SHOVEL(INCORRECT_FOR_NETHERITE_TOOL, 11, 6.5F),
    CORRUPTED_SHOVEL(INCORRECT_FOR_NETHERITE_TOOL, 2065, 10, 6, 15, corrupted_stone.get()),
    DIVINE_SHOVEL(INCORRECT_FOR_NETHERITE_TOOL, 13, 7.5F),
    EDEN_SHOVEL(INCORRECT_FOR_NETHERITE_TOOL, 2124, 15, 8.5F, 22, eden_gem.get()),
    MORTUM_SHOVEL(INCORRECT_FOR_NETHERITE_TOOL, 2922, 35, 12.5F, 22, mortum_gem.get()),
    REALMITE_SHOVEL(INCORRECT_FOR_IRON_TOOL, 325, 7, 4, 14, realmite_ingot.get()),
    RUPEE_SHOVEL(INCORRECT_FOR_DIAMOND_TOOL, 1634, 8, 5, 14, rupee_ingot.get()),
    SKYTHERN_SHOVEL(INCORRECT_FOR_NETHERITE_TOOL, 2783, 30, 11.5F, 22, skythern_gem.get()),
    TERRAN_SHOVEL(INCORRECT_FOR_DIAMOND_TOOL, 1586, 8, 4.7F, 10, terran_stone.get()),
    WILDWOOD_SHOVEL(INCORRECT_FOR_NETHERITE_TOOL, 2342, 20, 9.5F, 22, wildwood_gem.get()),

    //Hoes
    APALACHIA_HOE(INCORRECT_FOR_NETHERITE_TOOL, 2540, 25, 2, 22, apalachia_gem.get()),
    ARLEMITE_HOE(INCORRECT_FOR_DIAMOND_TOOL, 1535, 8, 0, 10, arlemite_ingot.get()),
    BEDROCK_HOE(INCORRECT_FOR_NETHERITE_TOOL, 11, .5F),
    CORRUPTED_HOE(INCORRECT_FOR_NETHERITE_TOOL, 2065, 10, .5F, 15, corrupted_stone.get()),
    DIVINE_HOE(INCORRECT_FOR_NETHERITE_TOOL, 13, 1),
    EDEN_HOE(INCORRECT_FOR_NETHERITE_TOOL, 2124, 15, 2, 22, eden_gem.get()),
    MORTUM_HOE(INCORRECT_FOR_NETHERITE_TOOL, 2922, 35, 2, 22, mortum_gem.get()),
    REALMITE_HOE(INCORRECT_FOR_IRON_TOOL, 325, 7, 0, 14, realmite_ingot.get()),
    RUPEE_HOE(INCORRECT_FOR_DIAMOND_TOOL, 1634, 8, 0, 14, rupee_ingot.get()),
    SKYTHERN_HOE(INCORRECT_FOR_NETHERITE_TOOL, 2783, 30, 2, 22, skythern_gem.get()),
    TERRAN_HOE(INCORRECT_FOR_DIAMOND_TOOL, 1586, 8, 0, 10, terran_stone.get()),
    WILDWOOD_HOE(INCORRECT_FOR_NETHERITE_TOOL, 2342, 20, 2, 22, wildwood_gem.get()),

    //Vethea
    //Hammers
    TEAKER_HAMMER(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 4),
    AMTHIRMIS_HAMMER(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 6),
    DARVEN_HAMMER(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 10),
    CERMILE_HAMMER(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 13),
    PARDIMAL_HAMMER(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 17),
    QUADROTIC_HAMMER(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 22),
    KAROS_HAMMER(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 26),
    HELIOSIS_HAMMER(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 31),
    ARKSIANE_HAMMER(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 37),
    EVERLIGHT(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 40),
    KAROS_ROCKMAUL(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 42),

    //Backswords
    TEAKER_BACKSWORD(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 2),
    AMTHIRMIS_BACKSWORD(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 4),
    DARVEN_BACKSWORD(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 7),
    CERMILE_BACKSWORD(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 11),
    PARDIMAL_BACKSWORD(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 14),
    QUADROTIC_BACKSWORD(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 18),
    KAROS_BACKSWORD(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 20),
    HELIOSIS_BACKSWORD(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 27),
    ARKSIANE_BACKSWORD(INCORRECT_FOR_NETHERITE_TOOL, -2.4F, 35),

    //Claws
    TEAKER_CLAW(INCORRECT_FOR_NETHERITE_TOOL, -2, 1),
    AMTHIRMIS_CLAW(INCORRECT_FOR_NETHERITE_TOOL, -2, 3),
    DARVEN_CLAW(INCORRECT_FOR_NETHERITE_TOOL, -2, 5),
    CERMILE_CLAW(INCORRECT_FOR_NETHERITE_TOOL, -2, 6),
    PARDIMAL_CLAW(INCORRECT_FOR_NETHERITE_TOOL, -2, 10),
    QUADROTIC_CLAW(INCORRECT_FOR_NETHERITE_TOOL, -2, 12),
    KAROS_CLAW(INCORRECT_FOR_NETHERITE_TOOL, -2, 17),
    HELIOSIS_CLAW(INCORRECT_FOR_NETHERITE_TOOL, -2, 24),
    ARKSIANE_CLAW(INCORRECT_FOR_NETHERITE_TOOL, -2, 33),
    EVERBRIGHT(INCORRECT_FOR_NETHERITE_TOOL, -2, 40);

    private final Ingredient repairMaterial;
    private final SwordSpecial swordSpecial;
    public int effectPower, effectSec;
    private final float attackDamage;
    private final float efficiency;
    private final int enchantability;
    private final TagKey<Block> incorrectBlocksForDrops;
    private final int maxUses;
    //No specials
    ToolStats(TagKey<Block> harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Item repairMaterialIn) {
        incorrectBlocksForDrops = harvestLevelIn;
        maxUses = maxUsesIn;
        efficiency = efficiencyIn;
        attackDamage = attackDamageIn;
        enchantability = enchantabilityIn;
        repairMaterial = repairMaterialIn == null ? Ingredient.EMPTY : Ingredient.of(repairMaterialIn);
        swordSpecial = NONE;
    }
    //No specials, unbreakable
    ToolStats(TagKey<Block> harvestLevel, float efficiency, float attackDamage) {
        this(harvestLevel, 0, efficiency, attackDamage, 0, null);
    }
    //Specials, power, seconds
    ToolStats(TagKey<Block> harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Item repairMaterialIn, SwordSpecial special, int power, int seconds) {
        incorrectBlocksForDrops = harvestLevelIn;
        maxUses = maxUsesIn;
        efficiency = efficiencyIn;
        attackDamage = attackDamageIn;
        enchantability = enchantabilityIn;
        repairMaterial = repairMaterialIn == null ? Ingredient.EMPTY : Ingredient.of(repairMaterialIn);
        swordSpecial = special;
        effectPower = power;
        effectSec = seconds;
    }
    //Specials, power, seconds, unbreakable
    ToolStats(TagKey<Block> harvestLevel, float efficiency, float attackDamage, SwordSpecial special, int power, int seconds) {
        this(harvestLevel, 0, efficiency, attackDamage, 0, null, special, power, seconds);
    }
    @Override public int getUses() {return maxUses;}
    @Override public float getSpeed() {return efficiency;}
    @Override public float getAttackDamageBonus() {return attackDamage;}
    @Override public TagKey<Block> getIncorrectBlocksForDrops() {return this.incorrectBlocksForDrops;}
    @Override public int getEnchantmentValue() {return enchantability;}
    @Override public Ingredient getRepairIngredient() {return repairMaterial;}
    public SwordSpecial getSwordSpecial() {return swordSpecial;}
    public enum SwordSpecial {NONE, FLAME, WITHER, EXPLODE, SLOW, NAUSEA, BLIND, POISON, LIGHTNING, HEAL, SPEED, ARCANA_DAMAGE}
}