package divinerpg.utils;

import divinerpg.registry.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ToolMaterialMod {

    public static final ToolMaterial APALACHIA_BLADE = EnumHelper.addToolMaterial("drpg_apalachia_blade", 4, 2000, 4.0F, 29.0F, 22);
    public static final ToolMaterial AQUA_DAGGER = EnumHelper.addToolMaterial("drpg_aqua_dagger", 4, 2000, 4.0F, 10.0F, 15);
    public static final ToolMaterial AQUA_MAUL = EnumHelper.addToolMaterial("drpg_aqua_maul", 4, 4000, 4.0F, 18.0F, 10);
    public static final ToolMaterial AQUA_TRIDENT = EnumHelper.addToolMaterial("drpg_aqua_trident", 4, 7000, 4.0F, 14.0F, 15);
    public static final ToolMaterial AQUATON = EnumHelper.addToolMaterial("drpg_aquaton", 4, 5000, 4.0F, 16.0F, 15);
    public static final ToolMaterial AQUATOOTH_MAUL = EnumHelper.addToolMaterial("drpg_aquatooth_maul", 4, 3500, 4.0F, 18.0F, 10);
    public static final ToolMaterial AQUATOOTH_SWORD = EnumHelper.addToolMaterial("drpg_aquatooth_sword", 4, 3500, 4.0F, 15.0F, 10);
    public static final ToolMaterial ARCANITE_BLADE = EnumHelper.addToolMaterial("drpg_arcanite_blade", 4, 7000, 4.0F, 34.0F, 15);
    public static final ToolMaterial ARLEMITE_STABBER = EnumHelper.addToolMaterial("drpg_arlemite_stabber", 4, 4000, 4.0F, 12.0F, 10);
    public static final ToolMaterial BEDROCK_SWORD = EnumHelper.addToolMaterial("drpg_bedrock_sword", 4, 14000, 4.0F, 14.0F, 2);
    public static final ToolMaterial BEDROCK_MAUL = EnumHelper.addToolMaterial("drpg_bedrock_maul", 4, -1, 4.0F, 14.0F, 22);
    public static final ToolMaterial BLOODGEM_SWORD = EnumHelper.addToolMaterial("drpg_bloodgem_sword", 4, -1, 4.0F, 9.0F, 15);
    public static final ToolMaterial BLUEFIRE_SWORD = EnumHelper.addToolMaterial("drpg_bluefire_sword", 4, 3000, 4.0F, 20, 15);
    public static final ToolMaterial CORRUPTED_MAUL = EnumHelper.addToolMaterial("drpg_corrupted_maul", 4, 6000, 4.0F, 13.0F, 15);
    public static final ToolMaterial CRABCLAW_MAUL = EnumHelper.addToolMaterial("drpg_crabclaw_maul", 4, 4000, 4.0F, 11.0F, 15);
    public static final ToolMaterial CYCLOPSIAN_SWORD = EnumHelper.addToolMaterial("drpg_cyclopsian_sword", 4, 1000, 4.0F, 6.0F, 10);
    public static final ToolMaterial DEATH_BRINGER = EnumHelper.addToolMaterial("drpg_death_bringer", 4, 6000, 4.0F, 12.0F, 15);
    public static final ToolMaterial DIVINE_SWORD = EnumHelper.addToolMaterial("drpg_divine_sword", 4, -1, 4.0F, 19.0F, 22);
    public static final ToolMaterial DUAL_CLAW = EnumHelper.addToolMaterial("drpg_dual_claw", 4, 4000, 4.0F, 12.0F, 15);
    public static final ToolMaterial EDEN_BLADE = EnumHelper.addToolMaterial("drpg_eden_blade", 4, 2000, 4.0F, 24.0F, 22);
    public static final ToolMaterial ENDER_SWORD = EnumHelper.addToolMaterial("drpg_ender_sword", 4, -1, 4.0F, 16.0F, 16);
    public static final ToolMaterial ENDERICE = EnumHelper.addToolMaterial("drpg_enderice", 4, -1, 4.0F, 19.0F, 15);
    public static final ToolMaterial FLAMING_FURY = EnumHelper.addToolMaterial("drpg_flaming_fury", 4, 6000, 4.0F, 26.0F, 15);
    public static final ToolMaterial FROSSIVENCE = EnumHelper.addToolMaterial("drpg_frossivence", 4, 270, 4.0F, 1.0F, 0);
    public static final ToolMaterial FROST_SWORD = EnumHelper.addToolMaterial("drpg_frost_sword", 4, 5000, 4.0F, 10.0F, 15);
    public static final ToolMaterial FROSTKING_SWORD = EnumHelper.addToolMaterial("drpg_frossivence", 4, 6000, 4.0F, 16.0F, 15);
    public static final ToolMaterial FROZEN_MAUL = EnumHelper.addToolMaterial("drpg_frossivence", 4, -1, 4.0F, 17.0F, 15);
    public static final ToolMaterial FURY_MAUL = EnumHelper.addToolMaterial("drpg_fury_maul", 4, 4000, 4.0F, 18.0F, 15);
    public static final ToolMaterial GLACIER_SWORD = EnumHelper.addToolMaterial("drpg_glacier_sword", 4, 1000, 4.0F, 18.0F, 15);
    public static final ToolMaterial HALITE_BLADE = EnumHelper.addToolMaterial("drpg_halite_blade", 4, 2000, 4.0F, 36.0F, 22);
    public static final ToolMaterial ICICLE_BANE = EnumHelper.addToolMaterial("drpg_icicle_bane", 4, -1, 4.0F, 14.0F, 15);


    public static ToolMaterial Icine = addMeleeMaterial("icine", 22, 15);
    public static ToolMaterial Inferno = addMeleeMaterial("inferno", 12, 22);
    public static ToolMaterial JungleKnife = addMeleeMaterial("jungle_knife", 2000, 12, 10, ModItems.jungleStone);
    public static ToolMaterial JungleRapier = addMeleeMaterial("jungle_rapier", 1200, 16, 10, ModItems.jungleStone);
    public static ToolMaterial LiviciaSword = addMeleeMaterial("livicia_sword", 10000, 26, 22, ModItems.shadowStone);
    public static ToolMaterial Molten = addMeleeMaterial("molten", 5000, 10, 15, ModItems.moltenStone);
    public static ToolMaterial Mortum = addMeleeMaterial("mortum", 2000, 33, 22, ModItems.mortumGem);
    public static ToolMaterial OceanKnife = addMeleeMaterial("ocean_knife", 2000, 14, 10, ModItems.aquaticIngot);
    public static ToolMaterial Palavence = addMeleeMaterial("palavence", 60, 1, 0, null);
    public static ToolMaterial PoisonSaber = addMeleeMaterial("poison_saber", 5000, 16, 15, ModItems.jungleStone);
    public static ToolMaterial Realmite = addMeleeMaterial("realmite", 4000, 6, 10, ModItems.realmiteIngot);
    public static ToolMaterial Rupee = addMeleeMaterial("rupee", 2500, 12, 15, ModItems.rupeeIngot);
    public static ToolMaterial Saber = addMeleeMaterial("saber", 22, 22);
    public static ToolMaterial Sandslash = addMeleeMaterial("sandslash", 100, 21, 22, ModItems.shadowBar);
    public static ToolMaterial Scorching = addMeleeMaterial("scorching", 500, 20, 15, ModItems.purpleBlaze);
    public static ToolMaterial ShadowSaber = addMeleeMaterial("shadow_saber", 20, 22);
    public static ToolMaterial Shark = addMeleeMaterial("shark", 2000, 14, 15, ModItems.aquaticIngot);
    public static ToolMaterial Skythern = addMeleeMaterial("skythern", 2000, 31, 22, ModItems.skythernGem);
    public static ToolMaterial Slime = addMeleeMaterial("slime", 1000, 11, 22, Items.DIAMOND_SWORD);
    public static ToolMaterial Snowslash = addMeleeMaterial("snowslash", 150, 25, 15, ModItems.snowflake);
    public static ToolMaterial Storm = addMeleeMaterial("storm", 5, 22);
    public static ToolMaterial TerranDagger = addMeleeMaterial("terran_dagger", 350, 13, 10, ModItems.terranStone);
    public static ToolMaterial TerranKnife = addMeleeMaterial("terran_knife", 750, 12, 10, ModItems.terranStone);
    public static ToolMaterial TerranMaul = addMeleeMaterial("terran_maul", 1200, 15, 10, ModItems.terranStone);
    public static ToolMaterial Wildwood = addMeleeMaterial("wildwood", 2000, 26, 22, ModItems.wildwoodGem);

    // Shickaxes
    public static ToolMaterial ArlemiteShick = addShickMaterial("arlemite_shick", 6, 12000, 13.0F, 8, 15,
            ModItems.arlemiteIngot);
    public static ToolMaterial DivineShick = addShickMaterial("divine_shick", 8, 20.0F, 9, 10);
    public static ToolMaterial RupeeShick = addShickMaterial("rupee_shick", 6, 16.0F, 8, 15);

    // Axes
    public static ToolMaterial ApalachiaAxe = addAxeMaterial("apalachia_axe", 100, 6000, 40.0F, 9, 22, ModItems.apalachiaGem);
    public static ToolMaterial ArlemiteAxe = addAxeMaterial("arlemite_axe", 3, 3000, 13.0F, 7, 10,
            ModItems.arlemiteIngot);
    public static ToolMaterial BedrockAxe = addAxeMaterial("bedrock_axe", 3, 20.0F, 6, 10);
    public static ToolMaterial CorruptedAxe = addAxeMaterial("corrupted_axe", 3, 6000, 16.0F, 7, 10,
            ModItems.corruptedStone);
    public static ToolMaterial CyclopsAxe = addAxeMaterial("cyclops_axe", 0, 1000, 8.0F, 6, 10, ModItems.cyclopsEye);
    public static ToolMaterial DivineAxe = addAxeMaterial("divine_axe", 8, 35000, 20.0F, 8, 10, ModItems.divineStone);
    public static ToolMaterial EdenAxe = addAxeMaterial("eden_axe", 100, 6000, 20.0F, 7, 22, ModItems.edenGem);
    public static ToolMaterial MortumAxe = addAxeMaterial("mortum_axe", 100, 6000, 55.0F, 11, 22, ModItems.mortumGem);
    public static ToolMaterial RealmiteAxe = addAxeMaterial("realmite_axe", 3, 4000, 12.0F, 6, 10,
            ModItems.realmiteIngot);
    public static ToolMaterial RupeeAxe = addAxeMaterial("rupee_axe", 6, 2500, 16.0F, 7, 0, ModItems.rupeeIngot);
    public static ToolMaterial SkythernAxe = addAxeMaterial("skythern_axe", 100, 6000, 48.0F, 10, 22, ModItems.skythernGem);
    public static ToolMaterial WildwoodAxe = addAxeMaterial("wildwood_axe", 100, 6000, 28.0F, 8, 22, ModItems.wildwoodGem);

    // Picks
    public static ToolMaterial ApalachiaPick = addPickMaterial("apalachia_pick", 100, 6000, 40.0F, 7, 22, ModItems.apalachiaGem);
    public static ToolMaterial ArlemitePick = addPickMaterial("arlemite_pick", 3, 3000, 13.0F, 5, 10,
            ModItems.arlemiteIngot);
    public static ToolMaterial BedrockPick = addPickMaterial("bedrock_pick", 3, 9.0F, 4, 10);
    public static ToolMaterial CorruptedPick = addPickMaterial("corrupted_pick", 3, 6000, 16.0F, 5, 10,
            ModItems.corruptedStone);
    public static ToolMaterial CyclopsPick = addPickMaterial("cyclops_pick", 0, 1000, 8.0F, 4, 10, ModItems.cyclopsEye);
    public static ToolMaterial DivinePick = addPickMaterial("divine_pick", 8, 35000, 20.0F, 6, 10,
            ModItems.divineStone);
    public static ToolMaterial EdenPick = addPickMaterial("eden_pick", 100, 6000, 20.0F, 5, 22, ModItems.edenGem);
    public static ToolMaterial MortumPick = addPickMaterial("mortum_pick", 100, 6000, 55.0F, 9, 22, ModItems.mortumGem);
    public static ToolMaterial RealmitePick = addPickMaterial("realmite_pick", 3, 4000, 12.0F, 4, 10,
            ModItems.realmiteIngot);
    public static ToolMaterial RupeePick = addPickMaterial("rupee_pick", 6, 2500, 16.0F, 5, 0, ModItems.rupeeIngot);
    public static ToolMaterial SkythernPick = addPickMaterial("skythern_pick", 100, 6000, 48.0F, 8, 22, ModItems.skythernGem);
    public static ToolMaterial WildwoodPick = addPickMaterial("wildwood_pick", 100, 6000, 28.0F, 6, 22, ModItems.wildwoodGem);

    // Shovels
    public static ToolMaterial ApalachiaShovel = addShovelMaterial("apalachia_shovel", 100, 6000, 40.0F, 7, 22, ModItems.apalachiaGem);
    public static ToolMaterial ArlemiteShovel = addShovelMaterial("arlemite_shovel", 3, 3000, 13.0F, 5, 10,
            ModItems.arlemiteIngot);
    public static ToolMaterial BedrockShovel = addShovelMaterial("bedrock_shovel", 3, 20.0F, 4, 10);
    public static ToolMaterial CorruptedShovel = addShovelMaterial("corrupted_shovel", 3, 6000, 16.0F, 5, 10,
            ModItems.corruptedStone);
    public static ToolMaterial CyclopsShovel = addShovelMaterial("cyclops_shovel", 0, 1000, 8.0F, 4, 10,
            ModItems.cyclopsEye);
    public static ToolMaterial DivineShovel = addShovelMaterial("divine_shovel", 8, 35000, 20.0F, 6, 10,
            ModItems.divineStone);
    public static ToolMaterial EdenShovel = addShovelMaterial("eden_shovel", 100, 6000, 20.0F, 5, 22, ModItems.edenGem);
    public static ToolMaterial MortumShovel = addShovelMaterial("mortum_shovel", 100, 6000, 55.0F, 9, 22, ModItems.mortumGem);
    public static ToolMaterial RealmiteShovel = addShovelMaterial("realmite_shovel", 3, 4000, 12.0F, 4, 10,
            ModItems.realmiteIngot);
    public static ToolMaterial RupeeShovel = addShovelMaterial("rupee_shovel", 6, 2500, 16.0F, 5, 0,
            ModItems.rupeeIngot);
    public static ToolMaterial SkythernShovel = addShovelMaterial("skythern_shovel", 100, 6000, 48.0F, 8, 22, ModItems.skythernGem);
    public static ToolMaterial WildwoodShovel = addShovelMaterial("wildwood_shovel", 100, 6000, 28.0F, 6, 22, ModItems.wildwoodGem);

    //VETHEA

    //Hammers
    public static ToolMaterial TeakerHammer = addMeleeMaterial("teaker_hammer", 6, 0);
    public static ToolMaterial AmthirmisHammer = addMeleeMaterial("amthirmis_hammer", 8, 0);
    public static ToolMaterial DarvenHammer = addMeleeMaterial("darven_hammer", 12, 0);
    public static ToolMaterial CermileHammer = addMeleeMaterial("cermile_hammer", 15, 0);
    public static ToolMaterial PardimalHammer = addMeleeMaterial("pardimal_hammer", 19, 0);
    public static ToolMaterial QuadroticHammer = addMeleeMaterial("quadrotic_hammer", 24, 0);
    public static ToolMaterial KarosHammer = addMeleeMaterial("karos_hammer", 26, 0);
    public static ToolMaterial HeliosisHammer = addMeleeMaterial("heliosis_hammer", 33, 0);
    public static ToolMaterial ArksianeHammer = addMeleeMaterial("arksiane_hammer", 39, 0);
    public static ToolMaterial Everlight = addMeleeMaterial("everlight", 44, 0);
    public static ToolMaterial KarosRockmaul = addMeleeMaterial("karos_rockmaul", 46, 0);

    //Backswords
    public static ToolMaterial TeakerSword = addMeleeMaterial("teaker_backsword", 4, 0);
    public static ToolMaterial AmthirmisSword = addMeleeMaterial("amthirmis_backsword", 6, 0);
    public static ToolMaterial DarvenSword = addMeleeMaterial("darven_backsword", 9, 0);
    public static ToolMaterial CermileSword = addMeleeMaterial("cermile_backsword", 13, 0);
    public static ToolMaterial PardimalSword = addMeleeMaterial("pardimal_backsword", 16, 0);
    public static ToolMaterial QuadroticSword = addMeleeMaterial("quadrotic_backsword", 20, 0);
    public static ToolMaterial KarosSword = addMeleeMaterial("karos_backsword", 22, 0);
    public static ToolMaterial HeliosisSword = addMeleeMaterial("heliosis_backsword", 29, 0);
    public static ToolMaterial ArksianeSword = addMeleeMaterial("arksiane_backsword", 37, 0);

    //Claws
    public static ToolMaterial TeakerClaw = addMeleeMaterial("teaker_claw", 3, 0);
    public static ToolMaterial AmthirmisClaw = addMeleeMaterial("amthirmis_claw", 5, 0);
    public static ToolMaterial DarvenClaw = addMeleeMaterial("darven_claw", 7, 0);
    public static ToolMaterial CermileClaw = addMeleeMaterial("cermile_claw", 8, 0);
    public static ToolMaterial PardimalClaw = addMeleeMaterial("pardimal_claw", 12, 0);
    public static ToolMaterial QuadroticClaw = addMeleeMaterial("quadrotic_claw", 14, 0);
    public static ToolMaterial KarosClaw = addMeleeMaterial("karos_claw", 19, 0);
    public static ToolMaterial HeliosisClaw = addMeleeMaterial("heliosis_claw", 26, 0);
    public static ToolMaterial ArksianeClaw = addMeleeMaterial("arksiane_claw", 35, 0);
    public static ToolMaterial Everbright = addMeleeMaterial("everbright", 42, 0);

    //Tools
    public static ToolMaterial DreamShovel = EnumHelper.addToolMaterial("dream_shovel", 3, 500, 13.0F, 4, 1);
    public static ToolMaterial DreamPick = EnumHelper.addToolMaterial("dream_pick", 3, 500, 13.0F, 5, 1);
    public static ToolMaterial DreamAxe = EnumHelper.addToolMaterial("dream_axe", 3, 500, 13.0F, 6, 1);

    /*


    public static ToolMaterial Apalachia = addMeleeMaterial("apalachia", 2000, 29, 22, ModItems.apalachiaGem);
    public static ToolMaterial AquaDagger = addMeleeMaterial("aqua_dagger", 2000, 10, 15, ModItems.aquaticIngot);
    public static ToolMaterial AquaMaul = addMeleeMaterial("aquatic_maul", 4000, 18, 10, ModItems.aquaticIngot);
    public static ToolMaterial AquaTrident = addMeleeMaterial("aqua_trident", 7000, 14, 15, ModItems.aquaticIngot);
    public static ToolMaterial Aquaton = addMeleeMaterial("aquaton", 5000, 16, 15, ModItems.aquaticIngot);
    public static ToolMaterial AquatoothMaul = addMeleeMaterial("aquatooth_maul", 3500, 18, 10,
            ModItems.liopleurodonSkull);
    public static ToolMaterial AquatoothSword = addMeleeMaterial("aquatooth_sword", 3500, 15, 10,
            ModItems.liopleurodonSkull);
    public static ToolMaterial ArcaniteBlade = addMeleeMaterial("arcanite_blade", 7000, 34, 15, null);
    public static ToolMaterial Arlemite = addMeleeMaterial("arlemite", 4000, 12, 10, ModItems.arlemiteIngot);
    public static ToolMaterial Bedrock = addMeleeMaterial("bedrock", 14000, 14, 22,
            Item.getItemFromBlock(Blocks.BEDROCK));
    public static ToolMaterial BedrockMaul = addMeleeMaterial("bedrock_maul", 14, 22);
    public static ToolMaterial Bloodgem = addMeleeMaterial("bloodgem", 9, 15);
    public static ToolMaterial Bluefire = addMeleeMaterial("bluefire", 3000, 20, 15, ModItems.shadowBar);
    public static ToolMaterial CorruptedMaul = addMeleeMaterial("corrupted_maul", 6000, 13, 15,
            ModItems.corruptedStone);
    public static ToolMaterial CrabclawMaul = addMeleeMaterial("crabclaw_maul", 4000, 11, 15, ModItems.crabClaw);
    public static ToolMaterial Cyclops = addMeleeMaterial("cyclops", 1000, 6, 10, ModItems.cyclopsEye);
    public static ToolMaterial DeathBringer = addMeleeMaterial("death_bringer", 6000, 12, 15, ModItems.corruptedStone);



    public static ToolMaterial Divine = addMeleeMaterial("divine", 19, 22);
    public static ToolMaterial DualClaw = addMeleeMaterial("dual_claw", 4000, 12, 15, ModItems.crabClaw);
    public static ToolMaterial Eden = addMeleeMaterial("eden", 2000, 24, 22, ModItems.edenGem);
    public static ToolMaterial Ender = addMeleeMaterial("ender", 16, 16);
    public static ToolMaterial Enderice = addMeleeMaterial("enderice", 19, 15);
    public static ToolMaterial FlamingFury = addMeleeMaterial("flaming_fury", 6000, 26, 15, ModItems.moltenStone);
    public static ToolMaterial Frossivence = addMeleeMaterial("frossivence", 270, 1, 0, ModItems.snowflake);
    public static ToolMaterial Frost = addMeleeMaterial("frost", 5000, 10, 15, ModItems.iceStone);
    public static ToolMaterial Frostking = addMeleeMaterial("frostking", 6000, 16, 15, ModItems.snowflake);
    public static ToolMaterial FrozenMaul = addMeleeMaterial("frozen_maul", 17, 15);
    public static ToolMaterial FuryMaul = addMeleeMaterial("fury_maul", 4000, 18, 15,
            Item.getItemFromBlock(Blocks.BEDROCK));
    public static ToolMaterial Glacier = addMeleeMaterial("glacier", 1000, 18, 15, ModItems.snowflake);
    public static ToolMaterial Halite = addMeleeMaterial("halite", 2000, 36, 22, ModItems.mortumGem);
    public static ToolMaterial IcicleBane = addMeleeMaterial("icicle_bane", 14, 15);
     */
    public static ToolMaterial addMeleeMaterial(String name, int maxUses, float damage, int enchantability,
                                                Item repair) {
        return EnumHelper.addToolMaterial(name, 0, maxUses, 0, damage - 5, enchantability)
                .setRepairItem(new ItemStack(repair, 1));
    }

    public static ToolMaterial addMeleeMaterial(String name, float damage, int enchantability) {
        return EnumHelper.addToolMaterial(name, 0, -1, 0, damage - 5, enchantability);
    }

    public static ToolMaterial addAxeMaterial(String name, int harvestLevel, int maxUses, float efficiency,
                                              float damage, int enchantability, Item repair) {
        return EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damage - 4, enchantability)
                .setRepairItem(new ItemStack(repair, 1));
    }

    public static ToolMaterial addAxeMaterial(String name, int harvestLevel, float efficiency, float damage,
                                              int enchantability) {
        return EnumHelper.addToolMaterial(name, harvestLevel, -1, efficiency, damage - 4, enchantability);
    }

    public static ToolMaterial addPickMaterial(String name, int harvestLevel, int maxUses, float efficiency,
                                               float damage, int enchantability, Item repair) {
        return EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damage - 3, enchantability)
                .setRepairItem(new ItemStack(repair, 1));
    }

    public static ToolMaterial addPickMaterial(String name, int harvestLevel, float efficiency, float damage,
                                               int enchantability) {
        return EnumHelper.addToolMaterial(name, harvestLevel, -1, efficiency, damage - 3, enchantability);
    }

    public static ToolMaterial addShovelMaterial(String name, int harvestLevel, int maxUses, float efficiency,
                                                 float damage, int enchantability, Item repair) {
        return EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damage - 2, enchantability)
                .setRepairItem(new ItemStack(repair, 1));
    }

    public static ToolMaterial addShovelMaterial(String name, int harvestLevel, float efficiency, float damage,
                                                 int enchantability) {
        return EnumHelper.addToolMaterial(name, harvestLevel, -1, efficiency, damage - 2, enchantability);
    }

    public static ToolMaterial addShickMaterial(String name, int harvestLevel, int maxUses, float efficiency,
                                                float damage, int enchantability, Item repair) {
        return EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damage - 1, enchantability)
                .setRepairItem(new ItemStack(repair, 1));
    }

    public static ToolMaterial addShickMaterial(String name, int harvestLevel, float efficiency, float damage,
                                                int enchantability) {
        return EnumHelper.addToolMaterial(name, harvestLevel, -1, efficiency, damage - 1, enchantability);
    }
}
