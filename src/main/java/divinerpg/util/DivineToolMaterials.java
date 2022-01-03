package divinerpg.util;

import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;

import java.util.function.*;

public enum DivineToolMaterials implements IItemTier {

    APALACHIA_BLADE(4, 2000, -0.8F, 25.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.apalachiaGem);
    }),
    AQUA_DAGGER(4, 2000, -1.4F, 6.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.aquaticIngot);
    }),
    AQUA_MAUL(4, 4000, -1.4F, 14.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.aquaticIngot);
    }),
    AQUA_TRIDENT(4, 7000, -1.6F, 10.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.aquaticIngot);
    }),
    AQUATON(4, 5000, -1.4F, 12.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.aquaticIngot);
    }),
    AQUATOOTH_MAUL(4, 3500, -1.4F, 14.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.liopleurodonTeeth);
    }),
    AQUATOOTH_SWORD(4, 3500, 0.8F, 11.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.liopleurodonTeeth);
    }),
    ARCANITE_BLADE(4, 7000, 0.0F, 30.0F, 15, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    ARCANIUM_SABER(4, -1, -1.4F, 18.0F, 22, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    ARLEMITE_STABBER(4, 4000, -0.4F, 8.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.arlemiteIngot);
    }),
    BEDROCK_SWORD(4, 14000, -1.6F, 10.0F, 2, () -> {
        return Ingredient.of(ItemRegistry.bedrockChunk);
    }),
    BEDROCK_MAUL(4, -1, -1.4F, 10.0F, 22, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    BLOODGEM_SWORD(4, -1, -0.6F, 5.0F, 15, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    BLUEFIRE_SWORD(4, 3000, -0.2F, 16.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.bluefireStone);
    }),
    CORRUPTED_MAUL(4, 6000, -1.4F, 9.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.corruptedStone);
    }),
    CRABCLAW_MAUL(4, 4000, -1.4F, 7.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.crabClaw);
    }),
    CYCLOPSIAN_SWORD(4, 1000, -1.6F, 2.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.cyclopsEye);
    }),
    DEATH_BRINGER(4, 6000, 0.2F, 8.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.corruptedStone);
    }),
    DIVINE_SWORD(4, -1, 0.3F, 15.0F, 22, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    DUAL_CLAW(4, 4000, -1.4F, 8.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.crabClaw);
    }),
    EDEN_BLADE(4, 2000, -1.0F, 20.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.edenGem);
    }),
    ENDER_SWORD(4, -1, -0.7F, 12.0F, 16, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    ENDERICE(4, -1, -1.4F, 15.0F, 15, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    FLAMING_FURY(4, 6000, -0.4F, 22.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.moltenStone);
    }),
    FROSSIVENCE(4, 270, -1.9F, -3.0F, 0, () -> {
        return Ingredient.of(ItemRegistry.snowflake);
    }),
    FROST_SWORD(4, 5000, -1.4F, 6.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.iceStone);
    }),
    FROSTKING_SWORD(4, 6000, -1.4F, 12.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.snowflake);
    }),
    FROZEN_MAUL(4, -1, -1.4F, 13.0F, 15, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    FURY_MAUL(4, 4000, -0.1F, 14.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.bedrockChunk);
    }),
    GLACIER_SWORD(4, 1000, -1.4F, 14.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.snowflake);
    }),
    HALITE_BLADE(4, 2000, 1.0F, 32.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.mortumGem);
    }),
    ICICLE_BANE(4, -1, -1.4F, 10.0F, 15, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    ICINE_SWORD(4, -1, -1.4F, 10.0F, 18, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    INFERNO_SWORD(4, -1, -0.2F, 8.0F, 22, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    JUNGLE_KNIFE(4, 2000, -1.6F, 8.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.jungleStone);
    }),
    JUNGLE_RAPIER(4, 1200, -1.8F, 12.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.jungleStone);
    }),
    LIVICIA_SWORD(4, 10000, -1.0F, 22.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.shadowStone);
    }),
    MOLTEN_SWORD(4, 5000, -0.4F, 6.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.moltenStone);
    }),
    MORTUM_BLADE(4, 2000, -0.5F, 29.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.mortumGem);
    }),
    OCEAN_KNIFE(4, 2000, -1.4F, 10.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.aquaticIngot);
    }),
    PALAVENCE(4, 60, -1.4F, -3.0F, 0, () -> {
        return Ingredient.of(ItemRegistry.realmiteIngot);
    }),
    POISON_SABER(4, 5000, -0.7F, 12.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.jungleStone);
    }),
    REALMITE_SWORD(4, 4000, -1.4F, 2.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.realmiteIngot);
    }),
    RUPEE_RAPIER(4, 2500, -1.4F, 8.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.rupeeIngot);
    }),
    SANDSLASH(4, 100, -1.4F, 17.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.shadowBar);
    }),
    SCORCHING_SWORD(4, 500, -0.5F, 16.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.purpleBlaze);
    }),
    SHADOW_SABER(4, -1, -0.5F, 16.0F, 22, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    SHARK_SWORD(4, 2000, -1.4F, 10.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.aquaticIngot);
    }),
    SKYTHERN_BLADE(4, 2000, -0.7F, 27.0F, 22, () -> {
        return Ingredient.of(ItemRegistry.skythernGem);
    }),
    SLIME_SWORD(4, 1000, -1.8F, 7.0F, 22, () -> {
        return Ingredient.of(Items.DIAMOND);
    }),
    SNOWSLASH(4, 150, -1.9F, 21.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.snowflake);
    }),
    STORM_SWORD(4, -1, 1.4F, 1.0F, 22, () -> {
        return Ingredient.of(Blocks.AIR);
    }),
    TERRAN_DAGGER(4, 350, -1.4F, 7.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.terranStone);
    }),
    TERRAN_KNIFE(4, 750, -1.4F, 9.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.terranStone);
    }),
    TERRAN_MAUL(4, 1200, -1.4F, 11.0F, 10, () -> {
        return Ingredient.of(ItemRegistry.terranStone);
    }),
    WILDWOOD_BLADE(4, 2000, -0.9F, 22.0F, 22, () -> {
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
    APALACHIA_SHICKAXE(8, 15000, 40.0F, 11.0F, 27, () -> {
        return Ingredient.of(ItemRegistry.apalachiaChunk);
    }),
    ARLEMITE_SHICKAXE(5, 12000, 13.0F, 10.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.arlemiteIngot);
    }),
    DIVINE_SHICKAXE(7, 87500, 20.0F, 10.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.divineStone);
    }),
    EDEN_SHICKAXE(6, 15000, 20.0F, 10.0F, 27, () -> {
        return Ingredient.of(ItemRegistry.edenChunk);
    }),
    HALITE_SHICKAXE(11, -1, 60.0F, 17.0F, 30, () -> {
    	return Ingredient.of(Blocks.AIR);
    }),
    MORTUM_SHICKAXE(10, 15000, 55.0F, 14.0F, 27, () -> {
        return Ingredient.of(ItemRegistry.mortumChunk);
    }),
    RUPEE_SHICKAXE(4, 20000, 16.0F, 10.0F, 15, () -> {
        return Ingredient.of(ItemRegistry.rupeeIngot);
    }),
    SKYTHERN_SHICKAXE(9, 15000, 48.0F, 13.0F, 27, () -> {
        return Ingredient.of(ItemRegistry.skythernChunk);
    }),
    WILDWOOD_SHICKAXE(7, 15000, 28.0F, 11.0F, 27, () -> {
        return Ingredient.of(ItemRegistry.wildwoodChunk);
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
    }),
//    //VETHEA
//    //Hammers
    TEAKER_HAMMER(4, -1, 4.0F, 2.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    AMTHIRMIS_HAMMER(4, -1, 4.0F, 4.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    DARVEN_HAMMER(4, -1, 4.0F, 8.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    CERMILE_HAMMER(4, -1, 4.0F, 11.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    PARDIMAL_HAMMER(4, -1, 4.0F, 15.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    QUADROTIC_HAMMER(4, -1, 4.0F, 20.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    KAROS_HAMMER(4, -1, 4.0F, 22.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    HELIOSIS_HAMMER(4, -1, 4.0F, 29.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    ARKSIANE_HAMMER(4, -1, 4.0F, 35.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    EVERLIGHT(4, -1, 4.0F, 40.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    KAROS_ROCKMAUL(4, -1, 4.0F, 42.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    //    //Backswords
    TEAKER_BACKSWORD(4, -1, 4.0F, 0.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    AMTHIRMIS_BACKSWORD(4, -1, 4.0F, 2.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    DARVEN_BACKSWORD(4, -1, 4.0F, 5.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    CERMILE_BACKSWORD(4, -1, 4.0F, 9.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    PARDIMAL_BACKSWORD(4, -1, 4.0F, 12.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    QUADROTIC_BACKSWORD(4, -1, 4.0F, 0.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    KAROS_BACKSWORD(4, -1, 4.0F, 0.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    HELIOSIS_BACKSWORD(4, -1, 4.0F, 0.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    ARKSIANE_BACKSWORD(4, -1, 4.0F, 0.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),

//    //Claws
    TEAKER_CLAW(4, -1, 4.0F, -1.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    AMTHIRMIS_CLAW(4, -1, 4.0F, 1.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    DARVEN_CLAW(4, -1, 4.0F, 3.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    CERMILE_CLAW(4, -1, 4.0F, 4.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    PARDIMAL_CLAW(4, -1, 4.0F, 8.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    QUADROTIC_CLAW(4, -1, 4.0F, 10.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    KAROS_CLAW(4, -1, 4.0F, 15.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    HELIOSIS_CLAW(4, -1, 4.0F, 22.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    ARKSIANE_CLAW(4, -1, 4.0F, 31.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    }),
    EVERBRIGHT(4, -1, 4.0F, 38.0F, 0, () -> {
        return Ingredient.of(Items.AIR);
    });

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