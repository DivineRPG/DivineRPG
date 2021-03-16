package divinerpg.util;

import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;

import java.util.function.*;

public enum DivineToolMaterials implements IItemTier {

    APALACHIA_BLADE(4, 2000, 4.0F, 25.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.apalachiaGem);
    }),
    AQUA_DAGGER(4, 2000, 4.0F, 6.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.aquaticIngot);
    }),
    AQUA_MAUL(4, 4000, 4.0F, 14.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.aquaticIngot);
    }),
    AQUA_TRIDENT(4, 7000, 4.0F, 10.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.aquaticIngot);
    }),
    AQUATON(4, 5000, 4.0F, 12.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.aquaticIngot);
    }),
    AQUATOOTH_MAUL(4, 3500, 4.0F, 14.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.liopleurodonTeeth);
    }),
    AQUATOOTH_SWORD(4, 3500, 4.0F, 11.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.liopleurodonTeeth);
    }),
    ARCANITE_BLADE(4, 7000, 4.0F, 30.0F, 15, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    ARCANIUM_SABER(4, -1, 4.0F, 18.0F, 22, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    ARLEMITE_STABBER(4, 4000, 4.0F, 8.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.arlemiteIngot);
    }),
    BEDROCK_SWORD(4, 14000, 4.0F, 10.0F, 2, () -> {
        return Ingredient.of(ItemRegistry.bedrockChunk);
    }),
    BEDROCK_MAUL(4, -1, 4.0F, 10.0F, 22, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    BLOODGEM_SWORD(4, -1, 4.0F, 5.0F, 15, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    BLUEFIRE_SWORD(4, 3000, 4.0F, 16.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.bluefireStone);
    }),
    CORRUPTED_MAUL(4, 6000, 4.0F, 9.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.corruptedStone);
    }),
    CRABCLAW_MAUL(4, 4000, 4.0F, 7.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.crabClaw);
    }),
    CYCLOPSIAN_SWORD(4, 1000, 4.0F, 2.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.cyclopsEye);
    }),
    DEATH_BRINGER(4, 6000, 4.0F, 8.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.corruptedStone);
    }),
    DIVINE_SWORD(4, -1, 4.0F, 15.0F, 22, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    DUAL_CLAW(4, 4000, 4.0F, 8.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.crabClaw);
    }),
    EDEN_BLADE(4, 2000, 4.0F, 20.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.edenGem);
    }),
    ENDER_SWORD(4, -1, 4.0F, 12.0F, 16, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    ENDERICE(4, -1, 4.0F, 15.0F, 15, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    FLAMING_FURY(4, 6000, 4.0F, 22.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.moltenStone);
    }),
    FROSSIVENCE(4, 270, 4.0F, -3.0F, 0, () -> {
        return Ingredient.of(ItemRegistry.snowflake);
    }),
    FROST_SWORD(4, 5000, 4.0F, 6.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.iceStone);
    }),
    FROSTKING_SWORD(4, 6000, 4.0F, 12.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.snowflake);
    }),
    FROZEN_MAUL(4, -1, 4.0F, 13.0F, 15, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    FURY_MAUL(4, 4000, 4.0F, 14.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.bedrockChunk);
    }),
    GLACIER_SWORD(4, 1000, 4.0F, 14.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.snowflake);
    }),
    HALITE_BLADE(4, 2000, 4.0F, 32.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.mortumGem);
    }),
    ICICLE_BANE(4, -1, 4.0F, 10.0F, 15, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    ICINE_SWORD(4, -1, 4.0F, 10.0F, 18, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    INFERNO_SWORD(4, -1, 4.0F, 8.0F, 22, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    JUNGLE_KNIFE(4, 2000, 4.0F, 8.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.jungleStone);
    }),
    JUNGLE_RAPIER(4, 1200, 4.0F, 12.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.jungleStone);
    }),
    LIVICIA_SWORD(4, 10000, 4.0F, 22.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.shadowStone);
    }),
    MOLTEN_SWORD(4, 5000, 4.0F, 6.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.moltenStone);
    }),
    MORTUM_BLADE(4, 2000, 4.0F, 29.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.mortumGem);
    }),
    OCEAN_KNIFE(4, 2000, 4.0F, 10.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.aquaticIngot);
    }),
    PALAVENCE(4, 60, 4.0F, -3.0F, 0, () -> {
        return Ingredient.of(ItemRegistry.realmiteIngot);
    }),
    POISON_SABER(4, 5000, 4.0F, 12.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.jungleStone);
    }),
    REALMITE_SWORD(4, 4000, 4.0F, 2.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.realmiteIngot);
    }),
    RUPEE_RAPIER(4, 2500, 4.0F, 8.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.rupeeIngot);
    }),
    SANDSLASH(4, 100, 4.0F, 17.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.shadowBar);
    }),
    SCORCHING_SWORD(4, 500, 4.0F, 16.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.purpleBlaze);
    }),
    SHADOW_SABER(4, -1, 4.0F, 16.0F, 22, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    SHARK_SWORD(4, 2000, 4.0F, 10.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.aquaticIngot);
    }),
    SKYTHERN_BLADE(4, 2000, 4.0F, 27.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.skythernGem);
    }),
    SLIME_SWORD(4, 1000, 4.0F, 7.0F, 22, () -> {
        return Ingredient.of(Items.DIAMOND);
    }),
    SNOWSLASH(4, 150, 4.0F, 21.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.snowflake);
    }),
    STORM_SWORD(4, -1, 4.0F, 1.0F, 22, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    TERRAN_DAGGER(4, 350, 4.0F, 7.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.terranStone);
    }),
    TERRAN_KNIFE(4, 750, 4.0F, 9.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.terranStone);
    }),
    TERRAN_MAUL(4, 1200, 4.0F, 11.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.terranStone);
    }),
    WILDWOOD_BLADE(4, 2000, 4.0F, 22.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.wildwoodGem);
    }),

    //DREAM
    DREAM_SHOVEL(3, 500, 13.0F, 3F, 1, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    DREAM_PICKAXE(3, 500, 13.0F, 4F, 1, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    DREAM_AXE(3, 500, 13.0F, 5F, 1, () -> {
        return Ingredient.of(Blocks.AIR);
    }),

    //SHICKAXES
    ARLEMITE_SHICKAXE(5, 12000, 13.0F, 8.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.arlemiteIngot);
    }),
    DIVINE_SHICKAXE(7, -1, 20.0F, 10.0F, 10, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    RUPEE_SHICKAXE(4, -1, 16.0F, 9.0F, 15, () -> {
        return Ingredient.of(Blocks.AIR);
    }),

    //AXES
    APALACHIA_AXE(8, 6000, 40.0F, 9.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.apalachiaGem);
    }),
    ARLEMITE_AXE(5, 3000, 13.0F, 7.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.arlemiteIngot);
    }),
    BEDROCK_AXE(5, -1, 20.0F, 6.0F, 10, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    CORRUPTED_AXE(3, 6000, 16.0F, 7.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.corruptedStone);
    }),
    DIVINE_AXE(7, 35000, 20.0F, 8.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.divineStone);
    }),
    EDEN_AXE(6, 6000, 20.0F, 7.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.edenGem);
    }),
    MORTUM_AXE(10, 6000, 55.0F, 11.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.mortumGem);
    }),
    REALMITE_AXE(3, 4000, 12.0F, 6.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.realmiteIngot);
    }),
    RUPEE_AXE(4, 2500, 16.0F, 7.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.rupeeIngot);
    }),
    SKYTHERN_AXE(9, 6000, 48.0F, 10.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.skythernGem);
    }),
    WILDWOOD_AXE(7, 6000, 28.0F, 8.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.wildwoodGem);
    }),

    //Pickaxes
    APALACHIA_PICKAXE(8, 6000, 40.0F, 7.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.apalachiaGem);
    }),
    ARLEMITE_PICKAXE(5, 3000, 13.0F, 5.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.arlemiteIngot);
    }),
    BEDROCK_PICKAXE(5, -1, 20.0F, 4.0F, 10, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    CORRUPTED_PICKAXE(3, 6000, 16.0F, 5.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.corruptedStone);
    }),
    DIVINE_PICKAXE(7, 35000, 20.0F, 6.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.divineStone);
    }),
    EDEN_PICKAXE(6, 6000, 20.0F, 5.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.edenGem);
    }),
    MORTUM_PICKAXE(10, 6000, 55.0F, 9.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.mortumGem);
    }),
    REALMITE_PICKAXE(3, 4000, 12.0F, 4.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.realmiteIngot);
    }),
    RUPEE_PICKAXE(4, 2500, 16.0F, 5.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.rupeeIngot);
    }),
    SKYTHERN_PICKAXE(9, 6000, 48.0F, 8.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.skythernGem);
    }),
    WILDWOOD_PICKAXE(7, 6000, 28.0F, 6.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.wildwoodGem);
    }),

    //Shovels
    APALACHIA_SHOVEL(8, 6000, 40.0F, 7.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.apalachiaGem);
    }),
    ARLEMITE_SHOVEL(5, 3000, 13.0F, 5.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.arlemiteIngot);
    }),
    BEDROCK_SHOVEL(5, -1, 20.0F, 4.0F, 10, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    CORRUPTED_SHOVEL(3, 6000, 16.0F, 5.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.corruptedStone);
    }),
    DIVINE_SHOVEL(7, 35000, 20.0F, 6.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.divineStone);
    }),
    EDEN_SHOVEL(6, 6000, 20.0F, 5.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.edenGem);
    }),
    MORTUM_SHOVEL(10, 6000, 55.0F, 9.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.mortumGem);
    }),
    REALMITE_SHOVEL(3, 4000, 12.0F, 4.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.realmiteIngot);
    }),
    RUPEE_SHOVEL(4, 2500, 16.0F, 5.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.rupeeIngot);
    }),
    SKYTHERN_SHOVEL(9, 6000, 48.0F, 8.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.skythernGem);
    }),
    WILDWOOD_SHOVEL(7, 6000, 28.0F, 6.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.wildwoodGem);
    });

//    //VETHEA
//    //Hammers
//    public static final ToolMaterial TEAKER_HAMMER = EnumHelper.addToolMaterial("drpg_teaker_hammer", 4, -1, 4.0F, 2.0F, 0);
//    public static final ToolMaterial AMTHIRMIS_HAMMER = EnumHelper.addToolMaterial("drpg_amthirmis_hammer", 4, -1, 4.0F, 4.0F, 0);
//    public static final ToolMaterial DARVEN_HAMMER = EnumHelper.addToolMaterial("drpg_darven_hammer", 4, -1, 4.0F, 8.0F, 0);
//    public static final ToolMaterial CERMILE_HAMMER = EnumHelper.addToolMaterial("drpg_cermile_hammer", 4, -1, 4.0F, 11.0F, 0);
//    public static final ToolMaterial PARDIMAL_HAMMER = EnumHelper.addToolMaterial("drpg_pardimal_hammer", 4, -1, 4.0F, 15.0F, 0);
//    public static final ToolMaterial QUADROTIC_HAMMER = EnumHelper.addToolMaterial("drpg_quadrotic_hammer", 4, -1, 4.0F, 20.0F, 0);
//    public static final ToolMaterial KAROS_HAMMER = EnumHelper.addToolMaterial("drpg_karos_hammer", 4, -1, 4.0F, 22.0F, 0);
//    public static final ToolMaterial HELIOSIS_HAMMER = EnumHelper.addToolMaterial("drpg_heliosis_hammer", 4, -1, 4.0F, 29.0F, 0);
//    public static final ToolMaterial ARKSIANE_HAMMER = EnumHelper.addToolMaterial("drpg_arksiane_hammer", 4, -1, 4.0F, 35.0F, 0);
//    public static final ToolMaterial EVERLIGHT  = EnumHelper.addToolMaterial("drpg_everlight", 4, -1, 4.0F, 40.0F, 0);
//    public static final ToolMaterial KAROS_ROCKMAUL = EnumHelper.addToolMaterial("drpg_karos_rockmaul", 4, -1, 4.0F, 42.0F, 0);
//
//    //Backswords
//    public static final ToolMaterial TEAKER_BACKSWORD = EnumHelper.addToolMaterial("drpg_teaker_backsword", 4, -1, 4.0F, 0.0F, 0);
//    public static final ToolMaterial AMTHIRMIS_BACKSWORD = EnumHelper.addToolMaterial("drpg_amthirmis_backsword", 4, -1, 4.0F, 2.0F, 0);
//    public static final ToolMaterial DARVEN_BACKSWORD = EnumHelper.addToolMaterial("drpg_darven_backsword", 4, -1, 4.0F, 5.0F, 0);
//    public static final ToolMaterial CERMILE_BACKSWORD = EnumHelper.addToolMaterial("drpg_cermile_backsword", 4, -1, 4.0F, 9.0F, 0);
//    public static final ToolMaterial PARDIMAL_BACKSWORD = EnumHelper.addToolMaterial("drpg_pardimal_backsword", 4, -1, 4.0F, 12.0F, 0);
//    public static final ToolMaterial QUADROTIC_BACKSWORD = EnumHelper.addToolMaterial("drpg_quadrotic_backsword", 4, -1, 4.0F, 16.0F, 0);
//    public static final ToolMaterial KAROS_BACKSWORD = EnumHelper.addToolMaterial("drpg_karos_backsword", 4, -1, 4.0F, 18.0F, 0);
//    public static final ToolMaterial HELIOSIS_BACKSWORD = EnumHelper.addToolMaterial("drpg_heliosis_backsword", 4, -1, 4.0F, 25.0F, 0);
//    public static final ToolMaterial ARKSIANE_BACKSWORD = EnumHelper.addToolMaterial("drpg_arksiane_backsword", 4, -1, 4.0F, 33.0F, 0);
//
//    //Claws
//    public static final ToolMaterial TEAKER_CLAW = EnumHelper.addToolMaterial("drpg_teaker_claw", 4, -1, 4.0F, -1.0F, 0);
//    public static final ToolMaterial AMTHIRMIS_CLAW = EnumHelper.addToolMaterial("drpg_amthirmis_claw", 4, -1, 4.0F, 1.0F, 0);
//    public static final ToolMaterial DARVEN_CLAW = EnumHelper.addToolMaterial("drpg_darven_claw", 4, -1, 4.0F, 3.0F, 0);
//    public static final ToolMaterial CERMILE_CLAW = EnumHelper.addToolMaterial("drpg_cermile_claw", 4, -1, 4.0F, 4.0F, 0);
//    public static final ToolMaterial PARDIMAL_CLAW = EnumHelper.addToolMaterial("drpg_pardimal_claw", 4, -1, 4.0F, 8.0F, 0);
//    public static final ToolMaterial QUADROTIC_CLAW = EnumHelper.addToolMaterial("drpg_quadrotic_claw", 4, -1, 4.0F, 10.0F, 0);
//    public static final ToolMaterial KAROS_CLAW = EnumHelper.addToolMaterial("drpg_karos_claw", 4, -1, 4.0F, 15.0F, 0);
//    public static final ToolMaterial HELIOSIS_CLAW = EnumHelper.addToolMaterial("drpg_heliosis_claw", 4, -1, 4.0F, 22.0F, 0);
//    public static final ToolMaterial ARKSIANE_CLAW = EnumHelper.addToolMaterial("drpg_arksiane_claw", 4, -1, 4.0F, 31.0F, 0);
//    public static final ToolMaterial EVERBRIGHT = EnumHelper.addToolMaterial("drpg_everbright", 4, -1, 4.0F, 38.0F, 0);


    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    DivineToolMaterials(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = repairMaterialIn;
    }

    @Override
    public int getUses() {
        return this.maxUses;
    }

    @Override
    public float getSpeed() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    @Override
    public int getLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        if(repairMaterial != null) {
            return repairMaterial.get();
        }
        else{return null;}
    }

}