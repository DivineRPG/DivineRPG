package divinerpg.enums;

import divinerpg.DivineRPG;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;

public enum ToolStats implements Tier {
    APALACHIA_BLADE(4, 2540, -2.4F, 25, 22, "apalachia_gem"),
    AQUA_DAGGER(2, 535, -2, 3.5F, 12, "aquatic_ingot"),
    AQUA_MAUL(2, 1058, -2.7F, 9.2F, 10, "aquatic_ingot"),
    AQUA_TRIDENT(2, 843, -2.4F, 6, 10, "aquatic_ingot"),
    AQUATON(2, 992, -2.4F, 6.5F, 10, "aquatic_ingot"),
    AQUATOOTH_MAUL(2, 1524, -2.7F, 10.5F, 10, "liopleurodon_teeth"),
    AQUATOOTH_SWORD(2, 1245, -2.4F, 7.5F, 10, "liopleurodon_teeth"),
    ARCANITE_BLADE(4, 2048, -2.4F, 13, 15, "arcanium"),
    ARCANIUM_SABER(3, -2.4F, 12),
    ARLEMITE_STABBER(3, 1535, -2.4F, 5, 10, "arlemite_ingot"),
    BEDROCK_SWORD(4, -2.4F, 8),
    BEDROCK_MAUL(4, -2.7F, 11.5F),
    BLOODGEM_SWORD(3, -2.4F, 5.2F),
    SOULFIRE_SWORD(4, 1623, -2.4F, 7, 15, "soulfire_stone"),
    CORRUPTED_MAUL(4, 2948, -2.7F, 11.1F, 15, "corrupted_stone"),
    CRABCLAW_MAUL(2, 1025, -2.7F, 6.1F, 13, "crab_claw"),
    CYCLOPSIAN_SWORD(2, 300, -2.4F, 4, 14, "cyclops_eye"),
    DEATH_BRINGER(4, 1545, -2.4F, 7.3F, 15, "corrupted_stone"),
    DIVINE_SWORD(4, -2.4F, 13),
    DUAL_CLAW(2, 822, -2.3F, 5.2F, 10, "crab_claw"),
    EDEN_BLADE(4, 2124, -2.4F, 17, 22, "eden_gem"),
    ENDER_SWORD(4, 2556, -2.4F, 12, 10, "ender_stone"),
    ENDERICE(4, -2.4F, 13),
    FLAMING_FURY(4, 3025, -2.3F, 10, 16, "molten_stone"),
    FROSSIVENCE(0, 270, -2.4F, -1, 0, "snowflake"),
    FROST_SWORD(3, 1226, -2.4F, 5.1F, 10, "ice_stone"),
    FROSTKING_SWORD(3, 1521, -2.4F, 6.5F, 13, "snowflake"),
    FROZEN_MAUL(4, -2.7F, 12.5F),
    FURY_MAUL(4, 3127, -2.8F, 14, 15, Items.DIAMOND),
    GLACIER_SWORD(3, 1021, -2.6F, 7, 13, "snowflake"),
    GLACIAL_BLADE(3, 1232, -2.3F, 11, 13, "snowflake"),
    HALITE_BLADE(4, 3187, -2.4F, 34, 22, "mortum_gem"),
    ICICLE_BANE(3, 1622, -2.5F, 6, 13, "snowflake"),
    ICICLE_DAGGER(4, 4, -2, 20, 13),
    ICINE_SWORD(4, -2.4F, 14),
    INFERNO_SWORD(2, -2.4F, 5.2F),
    JUNGLE_KNIFE(3, 1292, -2.4F, 5.2F, 10, "jungle_stone"),
    JUNGLE_RAPIER(3, 1425, -2.4F, 6, 12, "jungle_stone"),
    LIVICIA_SWORD(4, 3223, -2.4F, 15.5F, 15, "shadow_stone"),
    MOLTEN_SWORD(3, 1297, -2.4F, 5.4F, 10, "molten_stone"),
    MORTUM_BLADE(4, 2922, -2.4F, 31, 22, "mortum_gem"),
    OCEAN_KNIFE(2, 678, -2.4F, 5.4F, 10, "aquatic_ingot"),
    PALAVENCE(0, 60, -2.4F, -1, 0, "realmite_ingot"),
    POISON_SABER(3, 1315, -2.4F, 6.5F, 15, "jungle_stone"),
    REALMITE_SWORD(2, 325, -2.4F, 4.5F, 14, "realmite_ingot"),
    RUPEE_RAPIER(3, 1634, -2.4F, 5.5F, 14, "rupee_ingot"),
    SANDSLASH(4, 100, -2.4F, 16, 15, "divine_stone"),
    SCORCHING_SWORD(4, 1212, -2.4F, 6.2F, 15, "purple_blaze"),
    SHADOW_SABER(3, -2.2F, 10),
    SHARK_SWORD(2, 627, -2.4F, 5.5F, 10, "aquatic_ingot"),
    SKYTHERN_BLADE(4, 2783, -2.4F, 29, 22, "skythern_gem"),
    SLIME_SWORD(2, 739, -2.6F, 6.5F, 10, Items.DIAMOND),
    SNOWSLASH(4, 150, -2.4F, 17, 15, "snowflake"),
    STORM_SWORD(3, -2.4F, 5),
    TERRAN_DAGGER(3, 425, -2, 3.4F, 12, "terran_stone"),
    TERRAN_KNIFE(3, 1257, -2.4F, 5.1F, 10, "terran_stone"),
    TERRAN_MAUL(3, 1476, -2.7F, 7.4F, 10, "terran_stone"),
    WILDWOOD_BLADE(4, 2342, -2.4F, 21, 22, "wildwood_gem"),
    SABEAR_SABRE(2, 982, -2.3F, 4.4F, 15, "sabear_tooth"),

    //DREAM
    DREAM_SHOVEL(4, 513, 8, 4, 5),
    DREAM_PICKAXE(4, 513, 8, 3.5F, 5),
    DREAM_AXE(4, 513, 8, 8, 5),

    //SHICKAXES
    APALACHIA_SHICKAXE(4, 3540, 25, 12, 22, "apalachia_chunk"),
    ARLEMITE_SHICKAXE(3, 2535, 8, 3.2F, 10, "arlemite_ingot"),
    CORRUPTED_SHICKAXE(4, 3065, 10, 5, 15, "corrupted_stone"),
    DIVINE_SHICKAXE(4, 13, 7),
    EDEN_SHICKAXE(4, 3124, 15, 9, 22, "eden_chunk"),
    HALITE_SHICKAXE(4, 40, 16),
    MORTUM_SHICKAXE(4, 3922, 35, 15, 22, "mortum_chunk"),
    RUPEE_SHICKAXE(3, 2634, 8, 3.5F, 14, "rupee_ingot"),
    SKYTHERN_SHICKAXE(4, 3783, 30, 14, 22, "skythern_chunk"),
    TERRAN_SHICKAXE(3, 2586, 8, 3.3F, 10, "terran_stone"),
    WILDWOOD_SHICKAXE(4, 3342, 20, 11, 22, "wildwood_chunk"),

    //AXES
    APALACHIA_AXE(4, 2540, 25, 29, 22, "apalachia_gem"),
    ARLEMITE_AXE(3, 1535, 8, 8, 10, "arlemite_ingot"),
    BEDROCK_AXE(4, 11, 11),
    CORRUPTED_AXE(4, 2065, 10, 10.3F, 15, "corrupted_stone"),
    DIVINE_AXE(4, 13, 16.5F),
    EDEN_AXE(4, 2124, 15, 21, 22, "eden_gem"),
    MORTUM_AXE(4, 2922, 35, 36, 22, "mortum_gem"),
    REALMITE_AXE(2, 325, 7, 8, 14, "realmite_ingot"),
    RUPEE_AXE(3, 1634, 8, 8.5F, 14, "rupee_ingot"),
    SKYTHERN_AXE(4, 2783, 30, 34, 22, "skythern_gem"),
    TERRAN_AXE(3, 1586, 8, 8.2F, 10, "terran_stone"),
    WILDWOOD_AXE(4, 2342, 20, 25, 22, "wildwood_gem"),

    //Pickaxes
    APALACHIA_PICKAXE(4, 2540, 25, 10, 22, "apalachia_gem"),
    ARLEMITE_PICKAXE(3, 1535, 8, 4, 10, "arlemite_ingot"),
    BEDROCK_PICKAXE(4, 11, 6),
    CORRUPTED_PICKAXE(4, 2065, 10, 5.5F, 15, "corrupted_stone"),
    DIVINE_PICKAXE(4, 13, 7),
    EDEN_PICKAXE(4, 2124, 15, 8, 22, "eden_gem"),
    MORTUM_PICKAXE(4, 2922, 35, 12, 22, "mortum_gem"),
    REALMITE_PICKAXE(2, 325, 7, 3.5F, 14, "realmite_ingot"),
    OXDRITE_PICKAXE(2, 347, 7, 3.5F, 14, "oxdrite_ingot"),
    RUPEE_PICKAXE(3, 1634, 8, 4.5F, 14, "rupee_ingot"),
    SKYTHERN_PICKAXE(4, 2783, 30, 11, 22, "skythern_gem"),
    TERRAN_PICKAXE(3, 1586, 8, 4.1F, 10, "terran_stone"),
    WILDWOOD_PICKAXE(4, 2342, 20, 9, 22, "wildwood_gem"),

    //Shovels
    APALACHIA_SHOVEL(4, 2540, 25, 10.5F, 22, "apalachia_gem"),
    ARLEMITE_SHOVEL(3, 1535, 8, 4.5F, 10, "arlemite_ingot"),
    BEDROCK_SHOVEL(4, 11, 6.5F),
    CORRUPTED_SHOVEL(4, 2065, 10, 6, 15, "corrupted_stone"),
    DIVINE_SHOVEL(4, 13, 7.5F),
    EDEN_SHOVEL(4, 2124, 15, 8.5F, 22, "eden_gem"),
    MORTUM_SHOVEL(4, 2922, 35, 12.5F, 22, "mortum_gem"),
    REALMITE_SHOVEL(2, 325, 7, 4, 14, "realmite_ingot"),
    RUPEE_SHOVEL(3, 1634, 8, 5, 14, "rupee_ingot"),
    SKYTHERN_SHOVEL(4, 2783, 30, 11.5F, 22, "skythern_gem"),
    TERRAN_SHOVEL(3, 1586, 8, 4.7F, 10, "terran_stone"),
    WILDWOOD_SHOVEL(4, 2342, 20, 9.5F, 22, "wildwood_gem"),

    //Hoes
    APALACHIA_HOE(4, 2540, 25, 2, 22, "apalachia_gem"),
    ARLEMITE_HOE(3, 1535, 8, 0, 10, "arlemite_ingot"),
    BEDROCK_HOE(4, 11, .5F),
    CORRUPTED_HOE(4, 2065, 10, .5F, 15, "corrupted_stone"),
    DIVINE_HOE(4, 13, 1),
    EDEN_HOE(4, 2124, 15, 2, 22, "eden_gem"),
    MORTUM_HOE(4, 2922, 35, 2, 22, "mortum_gem"),
    REALMITE_HOE(2, 325, 7, 0, 14, "realmite_ingot"),
    RUPEE_HOE(3, 1634, 8, 0, 14, "rupee_ingot"),
    SKYTHERN_HOE(4, 2783, 30, 2, 22, "skythern_gem"),
    TERRAN_HOE(3, 1586, 8, 0, 10, "terran_stone"),
    WILDWOOD_HOE(4, 2342, 20, 2, 22, "wildwood_gem"),

    //Vethea
    //Hammers
    TEAKER_HAMMER(4, -2.4F, 4),
    AMTHIRMIS_HAMMER(4, -2.4F, 6),
    DARVEN_HAMMER(4, -2.4F, 10),
    CERMILE_HAMMER(4, -2.4F, 13),
    PARDIMAL_HAMMER(4, -2.4F, 17),
    QUADROTIC_HAMMER(4, -2.4F, 22),
    KAROS_HAMMER(4, -2.4F, 26),
    HELIOSIS_HAMMER(4, -2.4F, 31),
    ARKSIANE_HAMMER(4, -2.4F, 37),
    EVERLIGHT(4, -2.4F, 40),
    KAROS_ROCKMAUL(4, -2.4F, 42),

    //Backswords
    TEAKER_BACKSWORD(4, -2.4F, 2),
    AMTHIRMIS_BACKSWORD(4, -2.4F, 4),
    DARVEN_BACKSWORD(4, -2.4F, 7),
    CERMILE_BACKSWORD(4, -2.4F, 11),
    PARDIMAL_BACKSWORD(4, -2.4F, 14),
    QUADROTIC_BACKSWORD(4, -2.4F, 18),
    KAROS_BACKSWORD(4, -2.4F, 20),
    HELIOSIS_BACKSWORD(4, -2.4F, 27),
    ARKSIANE_BACKSWORD(4, -2.4F, 35),

    //Claws
    TEAKER_CLAW(4, -2, 1),
    AMTHIRMIS_CLAW(4, -2, 3),
    DARVEN_CLAW(4, -2, 5),
    CERMILE_CLAW(4, -2, 6),
    PARDIMAL_CLAW(4, -2, 10),
    QUADROTIC_CLAW(4, -2, 12),
    KAROS_CLAW(4, -2, 17),
    HELIOSIS_CLAW(4, -2, 24),
    ARKSIANE_CLAW(4, -2, 33),
    EVERBRIGHT(4, -2, 40);

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Ingredient repairMaterial;
    ToolStats(int harvestLevel, float efficiency, float attackDamage) {this(harvestLevel, 0, efficiency, attackDamage, 0, Items.AIR);}
    ToolStats(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability) {this(harvestLevel, maxUses, efficiency, attackDamage, enchantability, Items.AIR);}
    ToolStats(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, String repairMaterial) {this(harvestLevel, maxUses, efficiency, attackDamage, enchantability, ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, repairMaterial)));}
    ToolStats(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Item repairMaterialIn) {
        harvestLevel = harvestLevelIn;
        maxUses = maxUsesIn;
        efficiency = efficiencyIn;
        attackDamage = attackDamageIn;
        enchantability = enchantabilityIn;
        repairMaterial = Ingredient.of(repairMaterialIn);
    }
    @Override public int getUses() {return maxUses;}
    @Override public float getSpeed() {return efficiency;}
    @Override public float getAttackDamageBonus() {return attackDamage;}
    @Override public int getLevel() {return harvestLevel;}
    @Override public int getEnchantmentValue() {return enchantability;}
    @Override public Ingredient getRepairIngredient() {return repairMaterial;}
}