package divinerpg.enums;

import divinerpg.DivineRPG;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;

public enum ToolStats implements Tier {

    APALACHIA_BLADE(4, 2000, -2.4F, 27F, 22, "apalachia_gem"),
    AQUA_DAGGER(4, 2000, -1.6F, 8F, 15, "aquatic_ingot"),
    AQUA_MAUL(4, 4000, -2.4F, 16F, 10, "aquatic_ingot"),
    AQUA_TRIDENT(4, 7000, -2.6F, 12F, 15, "aquatic_ingot"),
    AQUATON(4, 5000, -2.4F, 14F, 15, "aquatic_ingot"),
    AQUATOOTH_MAUL(4, 3500, -2.4F, 16F, 10, "liopleurodon_teeth"),
    AQUATOOTH_SWORD(4, 3500, -2.4F, 13F, 10, "liopleurodon_teeth"),
    ARCANITE_BLADE(4, 7000, -1.4F, 30F, 15),
    ARCANIUM_SABER(4, -1, -2.4F, 18F, 22),
    ARLEMITE_STABBER(4, 4000, -2.4F, 10F, 10, "arlemite_ingot"),
    BEDROCK_SWORD(4, 14000, -2.6F, 12F, 2, "bedrock_chunk"),
    BEDROCK_MAUL(4, -1, -2.4F, 12F, 22),
    BLOODGEM_SWORD(4, -1, -2F, 7F, 15),
    SOULFIRE_SWORD(4, 3000, -1.6F, 18F, 15, "soulfire_stone"),
    CORRUPTED_MAUL(4, 6000, -2.4F, 11F, 15, "corrupted_stone"),
    CRABCLAW_MAUL(4, 4000, -2.4F, 9F, 15, "crab_claw"),
    CYCLOPSIAN_SWORD(4, 1000, -2.6F, 4F, 10, "cyclops_eye"),
    DEATH_BRINGER(4, 6000, -1.6F, 10F, 15, "corrupted_stone"),
    DIVINE_SWORD(4, -1, -1.4F, 17F, 22),
    DUAL_CLAW(4, 4000, -2.4F, 10F, 15, "crab_claw"),
    EDEN_BLADE(4, 2000, -2F, 22F, 22, "eden_gem"),
    ENDER_SWORD(4, -1, -1.7F, 14F, 16),
    ENDERICE(4, -1, -2.4F, 17F, 15),
    FLAMING_FURY(4, 6000, -1.8F, 24F, 15, "molten_stone"),
    FROSSIVENCE(4, 270, -2.2F, -1F, 0, "snowflake"),
    FROST_SWORD(4, 5000, -2.4F, 8F, 15, "ice_stone"),
    FROSTKING_SWORD(4, 6000, -2.4F, 14F, 15, "snowflake"),
    FROZEN_MAUL(4, -1, -2.4F, 15F, 15),
    FURY_MAUL(4, 4000, -1.5F, 16F, 15, "bedrock_chunk"),
    GLACIER_SWORD(4, 1000, -2.4F, 16F, 15, "snowflake"),
    HALITE_BLADE(4, 2000, -0.8F, 34F, 22, "mortum_gem"),
    ICICLE_BANE(4, -1, -2.4F, 12F, 15),
    ICINE_SWORD(4, -1, -2.7F, 20F, 18),
    INFERNO_SWORD(4, -1, -2F, 10F, 22),
    JUNGLE_KNIFE(4, 2000, -2.4F, 10F, 10, "jungle_stone"),
    JUNGLE_RAPIER(4, 1200, -2.6F, 14F, 10, "jungle_stone"),
    LIVICIA_SWORD(4, 10000, -2F, 24F, 22, "shadow_stone"),
    MOLTEN_SWORD(4, 5000, -1.6F, 8F, 15, "molten_stone"),
    MORTUM_BLADE(4, 2000, -1.5F, 31F, 22, "mortum_gem"),
    OCEAN_KNIFE(4, 2000, -2.4F, 12F, 10, "aquatic_ingot"),
    PALAVENCE(4, 60, -2.4F, -1F, 0, "realmite_ingot"),
    POISON_SABER(4, 5000, -1.7F, 14F, 15, "jungle_stone"),
    REALMITE_SWORD(4, 4000, -2.4F, 4F, 10, "realmite_ingot"),
    RUPEE_RAPIER(4, 2500, -2.4F, 10F, 15, "rupee_ingot"),
    SANDSLASH(4, 100, -2.4F, 19F, 22, "shadow_bar"),
    SCORCHING_SWORD(4, 500, -1.5F, 18F, 15, "purple_blaze"),
    SHADOW_SABER(4, -1, -1.5F, 18F, 22),
    SHARK_SWORD(4, 2000, -2.4F, 12F, 15, "aquatic_ingot"),
    SKYTHERN_BLADE(4, 2000, -1.7F, 29F, 22, "skythern_gem"),
    SLIME_SWORD(4, 1000, -2.8F, 9F, 22, Items.DIAMOND),
    SNOWSLASH(4, 150, -2.5F, 23F, 15, "snowflake"),
    STORM_SWORD(4, -1, -0.8F, 3F, 22),
    TERRAN_DAGGER(4, 350, -1.4F, 9F, 10, "terran_stone"),
    TERRAN_KNIFE(4, 750, -2.4F, 11F, 10, "terran_stone"),
    TERRAN_MAUL(4, 1200, -2.4F, 13F, 10, "terran_stone"),
    WILDWOOD_BLADE(4, 2000, -1.9F, 24F, 22, "wildwood_gem"),

    //DREAM
    DREAM_SHOVEL(3, 500, 13F, 3F, 1),
    DREAM_PICKAXE(3, 500, 13F, 4F, 1),
    DREAM_AXE(3, 500, 13F, 5F, 1),

    //SHICKAXES
    APALACHIA_SHICKAXE(8, 17000, 40F, 11F, 27, "apalachia_chunk"),
    ARLEMITE_SHICKAXE(5, 12000, 13F, 10F, 15, "arlemite_ingot"),
    CORRUPTED_SHICKAXE(3, 12000, 16F, 5F, 10, "corrupted_stone"),
    DIVINE_SHICKAXE(7, 87500, 20F, 10F, 15, "divine_stone"),
    EDEN_SHICKAXE(6, 15000, 20F, 10F, 27, "eden_chunk"),
    HALITE_SHICKAXE(11, -1, 60F, 17F, 30),
    MORTUM_SHICKAXE(10, 19000, 55F, 14F, 27, "mortum_chunk"),
    RUPEE_SHICKAXE(4, 15000, 16F, 10F, 15, "rupee_ingot"),
    SKYTHERN_SHICKAXE(9, 18000, 48F, 13F, 27, "skythern_chunk"),
    TERRAN_SHICKAXE(5, 20000, 18F, 10F, 18, "terran_stone"),
    WILDWOOD_SHICKAXE(7, 16000, 28F, 11F, 27, "wildwood_chunk"),

    //AXES
    APALACHIA_AXE(8, 6000, 40F, 28F, 22, "apalachia_gem"),
    ARLEMITE_AXE(5, 3000, 13F, 11F, 10, "arlemite_ingot"),
    BEDROCK_AXE(5, -1, 20F, 13F, 10),
    CORRUPTED_AXE(3, 6000, 16F, 12F, 10, "corrupted_stone"),
    DIVINE_AXE(7, 35000, 20F, 18F, 10, "divine_stone"),
    EDEN_AXE(6, 6000, 20F, 23F, 22, "eden_gem"),
    MORTUM_AXE(10, 6000, 55F, 32F, 22, "mortum_gem"),
    REALMITE_AXE(3, 4000, 12F, 6F, 10, "realmite_ingot"),
    RUPEE_AXE(4, 2500, 16F, 11F, 10, "rupee_ingot"),
    SKYTHERN_AXE(9, 6000, 48F, 30F, 22, "skythern_gem"),
    TERRAN_AXE(5, 6000, 18F, 10F, 12, "terran_stone"),
    WILDWOOD_AXE(7, 6000, 28F, 25F, 22, "wildwood_gem"),

    //Pickaxes
    APALACHIA_PICKAXE(8, 6000, 40F, 7F, 22, "apalachia_gem"),
    ARLEMITE_PICKAXE(5, 3000, 13F, 5F, 10, "arlemite_ingot"),
    BEDROCK_PICKAXE(5, -1, 20F, 4F, 10),
    CORRUPTED_PICKAXE(3, 6000, 16F, 5F, 10, "corrupted_stone"),
    DIVINE_PICKAXE(7, 35000, 20F, 6F, 10, "divine_stone"),
    EDEN_PICKAXE(6, 6000, 20F, 5F, 22, "eden_gem"),
    MORTUM_PICKAXE(10, 6000, 55F, 9F, 22, "mortum_gem"),
    REALMITE_PICKAXE(3, 4000, 12F, 4F, 10, "realmite_ingot"),
    RUPEE_PICKAXE(4, 2500, 16F, 5F, 10, "rupee_ingot"),
    SKYTHERN_PICKAXE(9, 6000, 48F, 8F, 22, "skythern_gem"),
    TERRAN_PICKAXE(5, 6000, 18F, 6F, 12, "terran_stone"),
    WILDWOOD_PICKAXE(7, 6000, 28F, 6F, 22, "wildwood_gem"),

    //Shovels
    APALACHIA_SHOVEL(8, 6000, 40F, 7F, 22, "apalachia_gem"),
    ARLEMITE_SHOVEL(5, 3000, 13F, 5F, 10, "arlemite_ingot"),
    BEDROCK_SHOVEL(5, -1, 20F, 4F, 10),
    CORRUPTED_SHOVEL(3, 6000, 16F, 5F, 10, "corrupted_stone"),
    DIVINE_SHOVEL(7, 35000, 20F, 6F, 10, "divine_stone"),
    EDEN_SHOVEL(6, 6000, 20F, 5F, 22, "eden_gem"),
    MORTUM_SHOVEL(10, 6000, 55F, 9F, 22, "mortum_gem"),
    REALMITE_SHOVEL(3, 4000, 12F, 4F, 10, "realmite_ingot"),
    RUPEE_SHOVEL(4, 2500, 16F, 5F, 10, "rupee_ingot"),
    SKYTHERN_SHOVEL(9, 6000, 48F, 8F, 22, "skythern_gem"),
    TERRAN_SHOVEL(5, 6000, 18F, 6F, 12, "terran_stone"),
    WILDWOOD_SHOVEL(7, 6000, 28F, 6F, 22, "wildwood_gem"),
    //VETHEA
    //Hammers
    TEAKER_HAMMER(4, -1, -2.4F, 4F, 0),
    AMTHIRMIS_HAMMER(4, -1, -2.4F, 6F, 0),
    DARVEN_HAMMER(4, -1, -2.4F, 10F, 0),
    CERMILE_HAMMER(4, -1, -2.4F, 13F, 0),
    PARDIMAL_HAMMER(4, -1, -2.4F, 17F, 0),
    QUADROTIC_HAMMER(4, -1, -2.4F, 22F, 0),
    KAROS_HAMMER(4, -1, -2.4F, 26F, 0),
    HELIOSIS_HAMMER(4, -1, -2.4F, 31F, 0),
    ARKSIANE_HAMMER(4, -1, -2.4F, 37F, 0),
    EVERLIGHT(4, -1, -2.4F, 40F, 0),
    KAROS_ROCKMAUL(4, -1, -2.4F, 42F, 0),
    //Backswords
    TEAKER_BACKSWORD(4, -1, -2.4F, 2F, 0),
    AMTHIRMIS_BACKSWORD(4, -1, -2.4F, 4F, 0),
    DARVEN_BACKSWORD(4, -1, -2.4F, 7F, 0),
    CERMILE_BACKSWORD(4, -1, -2.4F, 11F, 0),
    PARDIMAL_BACKSWORD(4, -1, -2.4F, 14F, 0),
    QUADROTIC_BACKSWORD(4, -1, -2.4F, 18F, 0),
    KAROS_BACKSWORD(4, -1, -2.4F, 20F, 0),
    HELIOSIS_BACKSWORD(4, -1, -2.4F, 27F, 0),
    ARKSIANE_BACKSWORD(4, -1, -2.4F, 35F, 0),

    //Claws
    TEAKER_CLAW(4, -1, -2F, 1F, 0),
    AMTHIRMIS_CLAW(4, -1, -2F, 3F, 0),
    DARVEN_CLAW(4, -1, -2F, 5F, 0),
    CERMILE_CLAW(4, -1, -2F, 6F, 0),
    PARDIMAL_CLAW(4, -1, -2F, 10F, 0),
    QUADROTIC_CLAW(4, -1, -2F, 12F, 0),
    KAROS_CLAW(4, -1, -2F, 17F, 0),
    HELIOSIS_CLAW(4, -1, -2F, 24F, 0),
    ARKSIANE_CLAW(4, -1, -2F, 33F, 0),
    EVERBRIGHT(4, -1, -2F, 40F, 0);

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private Ingredient repairMaterial;

    ToolStats(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability) {
        this(harvestLevel, maxUses, efficiency, attackDamage, enchantability, Items.AIR);
    }
    ToolStats(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, String repairMaterial) {
        this(harvestLevel, maxUses, efficiency, attackDamage, enchantability, ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, repairMaterial)));
    }
    private ToolStats(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn,
                                Item repairMaterialIn)
    {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = Ingredient.of(repairMaterialIn);
    }

    @Override
    public int getUses() {
        return maxUses;
    }

    @Override
    public float getSpeed() {
        return efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamage;
    }

    @Override
    public int getLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairMaterial;
    }
}