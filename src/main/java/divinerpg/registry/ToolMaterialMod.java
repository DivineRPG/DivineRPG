package divinerpg.registry;

import divinerpg.api.Reference;
import divinerpg.registry.ModItems;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ToolMaterialMod {

    /**
     * All damage values are for the base material, which are increased depending on the type of tool.
     * To create a new one, take the total amount of damage done in one hit and modify it as follows:
     *
     * Swords: add 4
     * Shovels: add 2.5
     * Pickaxes: add 2
     * Shickaxe: add 2
     * Axes: add 1 (the massively increased values of vanilla axes are hardcoded in the axe class)
     *
     * It should be noted that the base attack damage is 1 (i.e. fist damage) and the values above are already modified to account for that.
     * For instance, Apalachia Blade's material has 25 damage in its constructor, so the actual damage done is 29.
     * The base damage is 1, and the damage added by the blade is 25 + 3 = 28.
     */
    //Swords
    public static final ToolMaterial APALACHIA_BLADE = EnumHelper.addToolMaterial("drpg_apalachia_blade", 4, 2000, 4.0F, 25.0F, 22).setRepairItem(makeRepairStack("apalachia_gem"));
    public static final ToolMaterial AQUA_DAGGER = EnumHelper.addToolMaterial("drpg_aqua_dagger", 4, 2000, 4.0F, 6.0F, 15).setRepairItem(makeRepairStack("aquatic_ingot"));
    public static final ToolMaterial AQUA_MAUL = EnumHelper.addToolMaterial("drpg_aqua_maul", 4, 4000, 4.0F, 14.0F, 10).setRepairItem(makeRepairStack("aquatic_ingot"));
    public static final ToolMaterial AQUA_TRIDENT = EnumHelper.addToolMaterial("drpg_aqua_trident", 4, 7000, 4.0F, 10.0F, 15).setRepairItem(makeRepairStack("aquatic_ingot"));
    public static final ToolMaterial AQUATON = EnumHelper.addToolMaterial("drpg_aquaton", 4, 5000, 4.0F, 12.0F, 15).setRepairItem(makeRepairStack("aquatic_ingot"));
    public static final ToolMaterial AQUATOOTH_MAUL = EnumHelper.addToolMaterial("drpg_aquatooth_maul", 4, 3500, 4.0F, 14.0F, 10).setRepairItem(makeRepairStack("liopleurodon_skull"));
    public static final ToolMaterial AQUATOOTH_SWORD = EnumHelper.addToolMaterial("drpg_aquatooth_sword", 4, 3500, 4.0F, 11.0F, 10).setRepairItem(makeRepairStack("liopleurodon_skull"));
    public static final ToolMaterial ARCANITE_BLADE = EnumHelper.addToolMaterial("drpg_arcanite_blade", 4, 7000, 4.0F, 30.0F, 15);
    public static final ToolMaterial ARCANIUM_SABER = EnumHelper.addToolMaterial("drpg_arcanium_saber", 4, -1, 4.0F, 18.0F, 22);
    public static final ToolMaterial ARLEMITE_STABBER = EnumHelper.addToolMaterial("drpg_arlemite_stabber", 4, 4000, 4.0F, 8.0F, 10).setRepairItem(makeRepairStack("arlemite_ingot"));
    public static final ToolMaterial BEDROCK_SWORD = EnumHelper.addToolMaterial("drpg_bedrock_sword", 4, 14000, 4.0F, 10.0F, 2).setRepairItem(makeRepairStack("bedrock_chunk"));
    public static final ToolMaterial BEDROCK_MAUL = EnumHelper.addToolMaterial("drpg_bedrock_maul", 4, -1, 4.0F, 10.0F, 22);
    public static final ToolMaterial BLOODGEM_SWORD = EnumHelper.addToolMaterial("drpg_bloodgem_sword", 4, -1, 4.0F, 5.0F, 15);
    public static final ToolMaterial BLUEFIRE_SWORD = EnumHelper.addToolMaterial("drpg_bluefire_sword", 4, 3000, 4.0F, 16, 15).setRepairItem(makeRepairStack("bluefire_stone"));
    public static final ToolMaterial CORRUPTED_MAUL = EnumHelper.addToolMaterial("drpg_corrupted_maul", 4, 6000, 4.0F, 9.0F, 15).setRepairItem(makeRepairStack("corrupted_stone"));
    public static final ToolMaterial CRABCLAW_MAUL = EnumHelper.addToolMaterial("drpg_crabclaw_maul", 4, 4000, 4.0F, 7.0F, 15).setRepairItem(makeRepairStack("crab_claw"));
    public static final ToolMaterial CYCLOPSIAN_SWORD = EnumHelper.addToolMaterial("drpg_cyclopsian_sword", 4, 1000, 4.0F, 2.0F, 10).setRepairItem(makeRepairStack("cyclops_eye"));
    public static final ToolMaterial DEATH_BRINGER = EnumHelper.addToolMaterial("drpg_death_bringer", 4, 6000, 4.0F, 8.0F, 15).setRepairItem(makeRepairStack("corrupted_stone"));
    public static final ToolMaterial DIVINE_SWORD = EnumHelper.addToolMaterial("drpg_divine_sword", 4, -1, 4.0F, 15.0F, 22);
    public static final ToolMaterial DUAL_CLAW = EnumHelper.addToolMaterial("drpg_dual_claw", 4, 4000, 4.0F, 8.0F, 15).setRepairItem(makeRepairStack("crab_claw"));
    public static final ToolMaterial EDEN_BLADE = EnumHelper.addToolMaterial("drpg_eden_blade", 4, 2000, 4.0F, 20.0F, 22).setRepairItem(makeRepairStack("eden_gem"));
    public static final ToolMaterial ENDER_SWORD = EnumHelper.addToolMaterial("drpg_ender_sword", 4, -1, 4.0F, 12.0F, 16);
    public static final ToolMaterial ENDERICE = EnumHelper.addToolMaterial("drpg_enderice", 4, -1, 4.0F, 15.0F, 15);
    public static final ToolMaterial FLAMING_FURY = EnumHelper.addToolMaterial("drpg_flaming_fury", 4, 6000, 4.0F, 22.0F, 15).setRepairItem(makeRepairStack("molten_stone"));
    public static final ToolMaterial FROSSIVENCE = EnumHelper.addToolMaterial("drpg_frossivence", 4, 270, 4.0F, -3.0F, 0).setRepairItem(makeRepairStack("snowflake"));
    public static final ToolMaterial FROST_SWORD = EnumHelper.addToolMaterial("drpg_frost_sword", 4, 5000, 4.0F, 6.0F, 15).setRepairItem(makeRepairStack("ice_stone"));
    public static final ToolMaterial FROSTKING_SWORD = EnumHelper.addToolMaterial("drpg_frostking_sword", 4, 6000, 4.0F, 12.0F, 15).setRepairItem(makeRepairStack("snowflake"));
    public static final ToolMaterial FROZEN_MAUL = EnumHelper.addToolMaterial("drpg_frozen_maul", 4, -1, 4.0F, 13.0F, 15);
    public static final ToolMaterial FURY_MAUL = EnumHelper.addToolMaterial("drpg_fury_maul", 4, 4000, 4.0F, 14.0F, 15).setRepairItem(makeRepairStack("bedrock_chunk"));
    public static final ToolMaterial GLACIER_SWORD = EnumHelper.addToolMaterial("drpg_glacier_sword", 4, 1000, 4.0F, 14.0F, 15).setRepairItem(makeRepairStack("snowflake"));
    public static final ToolMaterial HALITE_BLADE = EnumHelper.addToolMaterial("drpg_halite_blade", 4, 2000, 4.0F, 32.0F, 22).setRepairItem(makeRepairStack("mortum_gem"));
    public static final ToolMaterial ICICLE_BANE = EnumHelper.addToolMaterial("drpg_icicle_bane", 4, -1, 4.0F, 10.0F, 15);
    public static final ToolMaterial ICINE_SWORD = EnumHelper.addToolMaterial("drpg_icine_sword", 4, -1, 4.0F, 18.0F, 15);
    public static final ToolMaterial INFERNO_SWORD = EnumHelper.addToolMaterial("drpg_inferno_sword", 4, -1, 4.0F, 8.0F, 22);
    public static final ToolMaterial JUNGLE_KNIFE = EnumHelper.addToolMaterial("drpg_jungle_knife", 4, 2000, 4.0F, 8.0F, 10).setRepairItem(makeRepairStack("jungle_stone"));
    public static final ToolMaterial JUNGLE_RAPIER = EnumHelper.addToolMaterial("drpg_jungle_rapier", 4, 1200, 4.0F, 12.0F, 10).setRepairItem(makeRepairStack("jungle_stone"));
    public static final ToolMaterial LIVICIA_SWORD = EnumHelper.addToolMaterial("drpg_livicia_sword", 4, 10000, 4.0F, 22.0F, 22).setRepairItem(makeRepairStack("shadow_stone"));
    public static final ToolMaterial MOLTEN_SWORD = EnumHelper.addToolMaterial("drpg_molten_sword", 4, 5000, 4.0F, 6.0F, 15).setRepairItem(makeRepairStack("molten_stone"));
    public static final ToolMaterial MORTUM_BLADE = EnumHelper.addToolMaterial("drpg_mortum_blade", 4, 2000, 4.0F, 29.0F, 22).setRepairItem(makeRepairStack("mortum_gem"));
    public static final ToolMaterial OCEAN_KNIFE = EnumHelper.addToolMaterial("drpg_ocean_knife", 4, 2000, 4.0F, 10.0F, 10).setRepairItem(makeRepairStack("aquatic_ingot"));
    public static final ToolMaterial PALAVENCE = EnumHelper.addToolMaterial("drpg_palavence", 4, 60, 4.0F, -3.0F, 0).setRepairItem(makeRepairStack("realmite_ingot"));
    public static final ToolMaterial POISON_SABER = EnumHelper.addToolMaterial("drpg_poison_saber", 4, 5000, 4.0F, 12.0F, 15).setRepairItem(makeRepairStack("jungle_stone"));
    public static final ToolMaterial REALMITE_SWORD = EnumHelper.addToolMaterial("drpg_realmite_sword", 4, 4000, 4.0F, 2.0F, 10).setRepairItem(makeRepairStack("realmite_ingot"));
    public static final ToolMaterial RUPEE_RAPIER = EnumHelper.addToolMaterial("drpg_rupee_rapier", 4, 2500, 4.0F, 8.0F, 15).setRepairItem(makeRepairStack("rupee_ingot"));
    public static final ToolMaterial SANDSLASH = EnumHelper.addToolMaterial("drpg_sandslash", 4, 100, 4.0F, 17.0F, 22).setRepairItem(makeRepairStack("shadow_bar"));
    public static final ToolMaterial SCORCHING_SWORD = EnumHelper.addToolMaterial("drpg_scorching_sword", 4, 500, 4.0F, 16.0F, 15).setRepairItem(makeRepairStack("purple_blaze"));
    public static final ToolMaterial SHADOW_SABER = EnumHelper.addToolMaterial("drpg_shadow_saber", 4, -1, 4.0F, 16.0F, 22);
    public static final ToolMaterial SHARK_SWORD = EnumHelper.addToolMaterial("drpg_shark_sword",4, 2000, 4.0F, 10.0F, 15).setRepairItem(makeRepairStack("aquatic_ingot"));
    public static final ToolMaterial SKYTHERN_BLADE = EnumHelper.addToolMaterial("drpg_skythern_blade", 4, 2000, 4.0F, 27.0F, 22).setRepairItem(makeRepairStack("skythern_gem"));
    public static final ToolMaterial SLIME_SWORD = EnumHelper.addToolMaterial("drpg_slime_sword", 4, 1000, 4.0F, 7.0F, 22).setRepairItem(makeRepairStack(Items.DIAMOND));
    public static final ToolMaterial SNOWSLASH = EnumHelper.addToolMaterial("drpg_snowslash", 4, 150, 4.0F, 21.0F, 15).setRepairItem(makeRepairStack("snowflake"));
    public static final ToolMaterial STORM_SWORD = EnumHelper.addToolMaterial("drpg_storm_sword", 4, -1, 4.0F, 1.0F, 22);
    public static final ToolMaterial TERRAN_DAGGER = EnumHelper.addToolMaterial("drpg_terran_dagger", 4, 350, 4.0F, 9.0F, 10).setRepairItem(makeRepairStack("terran_stone"));
    public static final ToolMaterial TERRAN_KNIFE = EnumHelper.addToolMaterial("drpg_terran_knife", 4, 750, 4.0F, 8.0F, 10).setRepairItem(makeRepairStack("terran_stone"));
    public static final ToolMaterial TERRAN_MAUL = EnumHelper.addToolMaterial("drpg_terran_maul", 4, 1200, 4.0F, 11.0F, 10).setRepairItem(makeRepairStack("terran_stone"));
    public static final ToolMaterial WILDWOOD_BLADE = EnumHelper.addToolMaterial("drpg_wildwood_blade", 4, 2000, 4.0F, 22.0F, 22).setRepairItem(makeRepairStack("wildwood_gem"));

    // Shickaxes
    public static final ToolMaterial ARLEMITE_SHICKAXE = EnumHelper.addToolMaterial("drpg_arlemite_shickaxe", 5, 12000, 13.0F, 8.0F, 15).setRepairItem(makeRepairStack("arlemite_ingot"));
    public static final ToolMaterial DIVINE_SHICKAXE = EnumHelper.addToolMaterial("drpg_divine_shickaxe", 7, -1, 20.0F, 10.0F, 10);
    public static final ToolMaterial RUPEE_SHICKAXE = EnumHelper.addToolMaterial("drpg_rupee_shickaxe", 4, -1, 16.0F, 9.0F, 15);

    // Axes
    public static final ToolMaterial APALACHIA_AXE = EnumHelper.addToolMaterial("drpg_apalachia_axe", 8, 6000, 40.0F, 9.0F, 22).setRepairItem(makeRepairStack("apalachia_gem"));
    public static final ToolMaterial ARLEMITE_AXE = EnumHelper.addToolMaterial("drpg_arlemite_axe", 5, 3000, 13.0F, 7.0F, 10).setRepairItem(makeRepairStack("arlemite_ingot"));
    public static final ToolMaterial BEDROCK_AXE = EnumHelper.addToolMaterial("drpg_bedrock_axe", 5, -1, 20.0F, 6.0F, 10);
    public static final ToolMaterial CORRUPTED_AXE = EnumHelper.addToolMaterial("drpg_corrupted_axe", 3, 6000, 16.0F, 7.0F, 10).setRepairItem(makeRepairStack("corrupted_stone"));
    public static final ToolMaterial DIVINE_AXE = EnumHelper.addToolMaterial("drpg_divine_axe", 7, 35000, 20.0F, 8.0F, 10).setRepairItem(makeRepairStack("divine_stone"));
    public static final ToolMaterial EDEN_AXE = EnumHelper.addToolMaterial("drpg_eden_axe", 6, 6000, 20.0F, 7.0F, 22).setRepairItem(makeRepairStack("eden_gem"));
    public static final ToolMaterial MORTUM_AXE = EnumHelper.addToolMaterial("drpg_mortum_axe", 10, 6000, 55.0F, 11.0F, 22).setRepairItem(makeRepairStack("mortum_gem"));
    public static final ToolMaterial REALMITE_AXE = EnumHelper.addToolMaterial("drpg_realmite_axe", 3, 4000, 12.0F, 6.0F, 10).setRepairItem(makeRepairStack("realmite_ingot"));
    public static final ToolMaterial RUPEE_AXE = EnumHelper.addToolMaterial("drpg_rupee_axe", 4, 2500, 16.0F, 7.0F, 10).setRepairItem(makeRepairStack("rupee_ingot"));
    public static final ToolMaterial SKYTHERN_AXE = EnumHelper.addToolMaterial("drpg_skythern_axe", 9, 6000, 48.0F, 10.0F, 22).setRepairItem(makeRepairStack("skythern_gem"));
    public static final ToolMaterial WILDWOOD_AXE = EnumHelper.addToolMaterial("drpg_wildwood_axe", 7, 6000, 28.0F, 8.0F, 22).setRepairItem(makeRepairStack("wildwood_gem"));

    // Pickaxes
    public static final ToolMaterial APALACHIA_PICKAXE = EnumHelper.addToolMaterial("drpg_apalachia_pickaxe", 8, 6000, 40.0F, 7.0F, 22).setRepairItem(makeRepairStack("apalachia_gem"));
    public static final ToolMaterial ARLEMITE_PICKAXE = EnumHelper.addToolMaterial("drpg_arlemite_pickaxe", 5, 3000, 13.0F, 5.0F, 10).setRepairItem(makeRepairStack("arlemite_ingot"));
    public static final ToolMaterial BEDROCK_PICKAXE = EnumHelper.addToolMaterial("drpg_bedrock_pickaxe", 5, -1, 9.0F, 4.0F, 10);
    public static final ToolMaterial CORRUPTED_PICKAXE = EnumHelper.addToolMaterial("drpg_corrupted_pickaxe", 3, 6000, 16.0F, 5.0F, 10).setRepairItem(makeRepairStack("corrupted_stone"));
    public static final ToolMaterial DIVINE_PICKAXE = EnumHelper.addToolMaterial("drpg_divine_pickaxe", 7, 35000, 20.0F, 6.0F, 10).setRepairItem(makeRepairStack("divine_stone"));
    public static final ToolMaterial EDEN_PICKAXE = EnumHelper.addToolMaterial("drpg_eden_pickaxe", 6, 6000, 20.0F, 5.0F, 22).setRepairItem(makeRepairStack("eden_gem"));
    public static final ToolMaterial MORTUM_PICKAXE = EnumHelper.addToolMaterial("drpg_mortum_pickaxe", 10, 6000, 55.0F, 9.0F, 22).setRepairItem(makeRepairStack("mortum_gem"));
    public static final ToolMaterial REALMITE_PICKAXE = EnumHelper.addToolMaterial("drpg_realmite_pickaxe", 3, 4000, 12.0F, 4.0F, 10).setRepairItem(makeRepairStack("realmite_ingot"));
    public static final ToolMaterial RUPEE_PICKAXE = EnumHelper.addToolMaterial("drpg_rupee_pickaxe", 4, 2500, 16.0F, 5.0F, 22).setRepairItem(makeRepairStack("rupee_ingot"));
    public static final ToolMaterial SKYTHERN_PICKAXE = EnumHelper.addToolMaterial("drpg_skythern_pickaxe", 9, 6000, 48.0F, 8.0F, 22).setRepairItem(makeRepairStack("skythern_gem"));
    public static final ToolMaterial WILDWOOD_PICKAXE = EnumHelper.addToolMaterial("drpg_wildwood_pickaxe", 7, 6000, 28.0F, 6.0F, 22).setRepairItem(makeRepairStack("wildwood_gem"));

    // Shovels
    public static final ToolMaterial APALACHIA_SHOVEL = EnumHelper.addToolMaterial("drpg_apalachia_shovel", 8, 6000, 40.0F, 7.0F, 22).setRepairItem(makeRepairStack("apalachia_gem"));
    public static final ToolMaterial ARLEMITE_SHOVEL = EnumHelper.addToolMaterial("drpg_arlemite_shovel", 5, 3000, 13.0F, 5.0F, 10).setRepairItem(makeRepairStack("arlemite_ingot"));
    public static final ToolMaterial BEDROCK_SHOVEL = EnumHelper.addToolMaterial("drpg_bedrock_shovel", 5, -1, 9.0F, 4.0F, 10);
    public static final ToolMaterial CORRUPTED_SHOVEL = EnumHelper.addToolMaterial("drpg_corrupted_shovel", 3, 6000, 16.0F, 5.0F, 10).setRepairItem(makeRepairStack("corrupted_stone"));
    public static final ToolMaterial DIVINE_SHOVEL = EnumHelper.addToolMaterial("drpg_divine_shovel", 7, 35000, 20.0F, 6.0F, 10).setRepairItem(makeRepairStack("divine_stone"));
    public static final ToolMaterial EDEN_SHOVEL = EnumHelper.addToolMaterial("drpg_eden_shovel", 6, 6000, 20.0F, 5.0F, 22).setRepairItem(makeRepairStack("eden_gem"));
    public static final ToolMaterial MORTUM_SHOVEL = EnumHelper.addToolMaterial("drpg_mortum_shovel", 10, 6000, 55.0F, 9.0F, 22).setRepairItem(makeRepairStack("mortum_gem"));
    public static final ToolMaterial REALMITE_SHOVEL = EnumHelper.addToolMaterial("drpg_realmite_shovel", 3, 4000, 12.0F, 4.0F, 10).setRepairItem(makeRepairStack("realmite_ingot"));
    public static final ToolMaterial RUPEE_SHOVEL = EnumHelper.addToolMaterial("drpg_rupee_shovel", 4, 2500, 16.0F, 5.0F, 22).setRepairItem(makeRepairStack("rupee_ingot"));
    public static final ToolMaterial SKYTHERN_SHOVEL = EnumHelper.addToolMaterial("drpg_skythern_shovel", 9, 6000, 48.0F, 8.0F, 22).setRepairItem(makeRepairStack("skythern_gem"));
    public static final ToolMaterial WILDWOOD_SHOVEL = EnumHelper.addToolMaterial("drpg_wildwood_shovel", 7, 6000, 28.0F, 6.0F, 22).setRepairItem(makeRepairStack("wildwood_gem"));

    //VETHEA
    //Hammers
    public static final ToolMaterial TEAKER_HAMMER = EnumHelper.addToolMaterial("drpg_teaker_hammer", 4, -1, 4.0F, 2.0F, 0);
    public static final ToolMaterial AMTHIRMIS_HAMMER = EnumHelper.addToolMaterial("drpg_amthirmis_hammer", 4, -1, 4.0F, 4.0F, 0);
    public static final ToolMaterial DARVEN_HAMMER = EnumHelper.addToolMaterial("drpg_darven_hammer", 4, -1, 4.0F, 8.0F, 0);
    public static final ToolMaterial CERMILE_HAMMER = EnumHelper.addToolMaterial("drpg_cermile_hammer", 4, -1, 4.0F, 11.0F, 0);
    public static final ToolMaterial PARDIMAL_HAMMER = EnumHelper.addToolMaterial("drpg_pardimal_hammer", 4, -1, 4.0F, 15.0F, 0);
    public static final ToolMaterial QUADROTIC_HAMMER = EnumHelper.addToolMaterial("drpg_quadrotic_hammer", 4, -1, 4.0F, 20.0F, 0);
    public static final ToolMaterial KAROS_HAMMER = EnumHelper.addToolMaterial("drpg_karos_hammer", 4, -1, 4.0F, 22.0F, 0);
    public static final ToolMaterial HELIOSIS_HAMMER = EnumHelper.addToolMaterial("drpg_heliosis_hammer", 4, -1, 4.0F, 29.0F, 0);
    public static final ToolMaterial ARKSIANE_HAMMER = EnumHelper.addToolMaterial("drpg_arksiane_hammer", 4, -1, 4.0F, 35.0F, 0);
    public static final ToolMaterial EVERLIGHT  = EnumHelper.addToolMaterial("drpg_everlight", 4, -1, 4.0F, 40.0F, 0);
    public static final ToolMaterial KAROS_ROCKMAUL = EnumHelper.addToolMaterial("drpg_karos_rockmaul", 4, -1, 4.0F, 42.0F, 0);

    //Backswords
    public static final ToolMaterial TEAKER_BACKSWORD = EnumHelper.addToolMaterial("drpg_teaker_backsword", 4, -1, 4.0F, 0.0F, 0);
    public static final ToolMaterial AMTHIRMIS_BACKSWORD = EnumHelper.addToolMaterial("drpg_amthirmis_backsword", 4, -1, 4.0F, 2.0F, 0);
    public static final ToolMaterial DARVEN_BACKSWORD = EnumHelper.addToolMaterial("drpg_darven_backsword", 4, -1, 4.0F, 5.0F, 0);
    public static final ToolMaterial CERMILE_BACKSWORD = EnumHelper.addToolMaterial("drpg_cermile_backsword", 4, -1, 4.0F, 9.0F, 0);
    public static final ToolMaterial PARDIMAL_BACKSWORD = EnumHelper.addToolMaterial("drpg_pardimal_backsword", 4, -1, 4.0F, 12.0F, 0);
    public static final ToolMaterial QUADROTIC_BACKSWORD = EnumHelper.addToolMaterial("drpg_quadrotic_backsword", 4, -1, 4.0F, 16.0F, 0);
    public static final ToolMaterial KAROS_BACKSWORD = EnumHelper.addToolMaterial("drpg_karos_backsword", 4, -1, 4.0F, 18.0F, 0);
    public static final ToolMaterial HELIOSIS_BACKSWORD = EnumHelper.addToolMaterial("drpg_heliosis_backsword", 4, -1, 4.0F, 25.0F, 0);
    public static final ToolMaterial ARKSIANE_BACKSWORD = EnumHelper.addToolMaterial("drpg_arksiane_backsword", 4, -1, 4.0F, 33.0F, 0);

    //Claws
    public static final ToolMaterial TEAKER_CLAW = EnumHelper.addToolMaterial("drpg_teaker_claw", 4, -1, 4.0F, -1.0F, 0);
    public static final ToolMaterial AMTHIRMIS_CLAW = EnumHelper.addToolMaterial("drpg_amthirmis_claw", 4, -1, 4.0F, 1.0F, 0);
    public static final ToolMaterial DARVEN_CLAW = EnumHelper.addToolMaterial("drpg_darven_claw", 4, -1, 4.0F, 3.0F, 0);
    public static final ToolMaterial CERMILE_CLAW = EnumHelper.addToolMaterial("drpg_cermile_claw", 4, -1, 4.0F, 4.0F, 0);
    public static final ToolMaterial PARDIMAL_CLAW = EnumHelper.addToolMaterial("drpg_pardimal_claw", 4, -1, 4.0F, 8.0F, 0);
    public static final ToolMaterial QUADROTIC_CLAW = EnumHelper.addToolMaterial("drpg_quadrotic_claw", 4, -1, 4.0F, 10.0F, 0);
    public static final ToolMaterial KAROS_CLAW = EnumHelper.addToolMaterial("drpg_karos_claw", 4, -1, 4.0F, 15.0F, 0);
    public static final ToolMaterial HELIOSIS_CLAW = EnumHelper.addToolMaterial("drpg_heliosis_claw", 4, -1, 4.0F, 22.0F, 0);
    public static final ToolMaterial ARKSIANE_CLAW = EnumHelper.addToolMaterial("drpg_arksiane_claw", 4, -1, 4.0F, 31.0F, 0);
    public static final ToolMaterial EVERBRIGHT = EnumHelper.addToolMaterial("drpg_everbright", 4, -1, 4.0F, 38.0F, 0);

    //Tools
    public static final ToolMaterial DREAM_SHOVEL = EnumHelper.addToolMaterial("drpg_dream_shovel", 3, 500, 13.0F, 3, 1);
    public static final ToolMaterial DREAM_PICKAXE = EnumHelper.addToolMaterial("drpg_dream_pickaxe", 3, 500, 13.0F, 4, 1);
    public static final ToolMaterial DREAM_AXE = EnumHelper.addToolMaterial("drpg_dream_axe", 3, 500, 13.0F, 5, 1);

    //Armor materials
    public static final ArmorMaterial ANGELIC_ARMOR = EnumHelper.addArmorMaterial("drpg_angelic_armor", Reference.MODID + ":angelic", 18, new int[] {3, 4, 4, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0F);
    public static final ArmorMaterial APALACHIA_ARMOR = EnumHelper.addArmorMaterial("drpg_apalachia_armor", Reference.MODID + ":apalachia", 36, new int[] {5, 5, 7, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3F);
    public static final ArmorMaterial AQUASTRIVE_ARMOR = EnumHelper.addArmorMaterial("drpg_aquastrive_armor", Reference.MODID + ":aquastrive", 28, new int[] {4, 5, 6, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F);
    public static final ArmorMaterial ARLEMITE_ARMOR = EnumHelper.addArmorMaterial("drpg_arlemite_armor", Reference.MODID + ":arlemite", 30, new int[] {3, 5, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4F);
    public static final ArmorMaterial AWAKENED_HALITE_ARMOR = EnumHelper.addArmorMaterial("drpg_awakened_halite_armor", Reference.MODID + ":awakened_halite", 42, new int[] {5, 7, 8, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F);
    public static final ArmorMaterial BEDROCK_ARMOR = EnumHelper.addArmorMaterial("drpg_bedrock_armor", Reference.MODID + ":bedrock", 45, new int[] {5, 6, 8, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 5F);
    public static final ArmorMaterial CORRUPTED_ARMOR = EnumHelper.addArmorMaterial("drpg_corrupted_armor", Reference.MODID + ":corrupted", 40, new int[] {4, 6, 8, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3F);
    public static final ArmorMaterial DIVINE_ARMOR = EnumHelper.addArmorMaterial("drpg_divine_armor", Reference.MODID + ":divine", 40, new int[] {5, 6, 8, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4F);
    public static final ArmorMaterial EDEN_ARMOR = EnumHelper.addArmorMaterial("drpg_eden_armor", Reference.MODID + ":eden", 32, new int[] {3, 5, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3F);
    public static final ArmorMaterial ELITE_REALMITE_ARMOR = EnumHelper.addArmorMaterial("drpg_elite_realmite_armor", Reference.MODID + ":elite_realmite", 38, new int[] {4, 6, 7, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3F);
    public static final ArmorMaterial ENDER_ARMOR = EnumHelper.addArmorMaterial("drpg_ender_armor", Reference.MODID + ":ender", 36, new int[] {5, 6, 7, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F);
    public static final ArmorMaterial RED_ENDER_ARMOR = EnumHelper.addArmorMaterial("drpg_red_ender_armor", Reference.MODID + ":red_ender", 36, new int[] {5, 6, 7, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F);
    public static final ArmorMaterial YELLOW_ENDER_ARMOR = EnumHelper.addArmorMaterial("drpg_yellow_ender_armor", Reference.MODID + ":yellow_ender", 36, new int[] {5, 6, 7, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F);
    public static final ArmorMaterial GREEN_ENDER_ARMOR = EnumHelper.addArmorMaterial("drpg_green_ender_armor", Reference.MODID + ":green_ender", 36, new int[] {5, 6, 7, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F);
    public static final ArmorMaterial GRAY_ENDER_ARMOR = EnumHelper.addArmorMaterial("drpg_gray_ender_armor", Reference.MODID + ":gray_ender", 36, new int[] {5, 6, 7, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F);
    public static final ArmorMaterial BLUE_ENDER_ARMOR = EnumHelper.addArmorMaterial("drpg_blue_ender_armor", Reference.MODID + ":blue_ender", 36, new int[] {5, 6, 7, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F);
    public static final ArmorMaterial FROZEN_ARMOR = EnumHelper.addArmorMaterial("drpg_frozen_armor", Reference.MODID + ":frozen", 29, new int[] {3, 5, 7, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1F);
    public static final ArmorMaterial HALITE_ARMOR = EnumHelper.addArmorMaterial("drpg_halite_armor", Reference.MODID + ":halite", 42, new int[] {5, 7, 8, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4F);
    public static final ArmorMaterial INFERNO_ARMOR = EnumHelper.addArmorMaterial("drpg_inferno_armor", Reference.MODID + ":inferno", 20, new int[] {4, 7, 7, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1F);
    public static final ArmorMaterial JACK_O_MAN_ARMOR = EnumHelper.addArmorMaterial("drpg_jack_o_man_armor", Reference.MODID + ":jack_o_man", 24, new int[] {3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F);
    public static final ArmorMaterial JUNGLE_ARMOR = EnumHelper.addArmorMaterial("drpg_jungle_armor", Reference.MODID + ":jungle", 29, new int[] {3, 5, 7, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1F);
    public static final ArmorMaterial KORMA_ARMOR = EnumHelper.addArmorMaterial("drpg_korma_armor", Reference.MODID + ":korma", 36, new int[] {4, 7, 8, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4F);
    public static final ArmorMaterial KRAKEN_ARMOR = EnumHelper.addArmorMaterial("drpg_kraken_armor", Reference.MODID + ":kraken", 26, new int[] {3, 5, 6, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1F);
    public static final ArmorMaterial MORTUM_ARMOR = EnumHelper.addArmorMaterial("drpg_mortum_armor", Reference.MODID + ":mortum", 38, new int[] {4, 6, 9, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4F);
    public static final ArmorMaterial NETHERITE_ARMOR = EnumHelper.addArmorMaterial("drpg_netherite_armor", Reference.MODID + ":netherite", 34, new int[] {4, 5, 6, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3F);
    public static final ArmorMaterial REALMITE_ARMOR = EnumHelper.addArmorMaterial("drpg_realmite_armor", Reference.MODID + ":realmite", 23, new int[] {2, 5, 6, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0F);
    public static final ArmorMaterial RUPEE_ARMOR = EnumHelper.addArmorMaterial("drpg_rupee_armor", Reference.MODID + ":rupee", 35, new int[] {4, 6, 8, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F);
    public static final ArmorMaterial RED_RUPEE_ARMOR = EnumHelper.addArmorMaterial("drpg_red_rupee_armor", Reference.MODID + ":red_rupee", 35, new int[] {4, 6, 8, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F);
    public static final ArmorMaterial YELLOW_RUPEE_ARMOR = EnumHelper.addArmorMaterial("drpg_yellow_rupee_armor", Reference.MODID + ":yellow_rupee", 35, new int[] {4, 6, 8, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F);
    public static final ArmorMaterial GREEN_RUPEE_ARMOR = EnumHelper.addArmorMaterial("drpg_green_rupee_armor", Reference.MODID + ":green_rupee", 35, new int[] {4, 6, 8, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F);
    public static final ArmorMaterial GRAY_RUPEE_ARMOR = EnumHelper.addArmorMaterial("drpg_gray_rupee_armor", Reference.MODID + ":gray_rupee", 35, new int[] {4, 6, 8, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F);
    public static final ArmorMaterial BLUE_RUPEE_ARMOR = EnumHelper.addArmorMaterial("drpg_blue_rupee_armor", Reference.MODID + ":blue_rupee", 35, new int[] {4, 6, 8, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F);
    public static final ArmorMaterial SANTA_ARMOR = EnumHelper.addArmorMaterial("drpg_santa_armor", Reference.MODID + ":santa", 18, new int[] {3, 4, 5, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0F);
    public static final ArmorMaterial SHADOW_ARMOR = EnumHelper.addArmorMaterial("drpg_shadow_armor", Reference.MODID + ":shadow", 27, new int[] {4, 6, 8, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3F);
    public static final ArmorMaterial SKELEMAN_ARMOR = EnumHelper.addArmorMaterial("drpg_skeleman_armor", Reference.MODID + ":skeleman", 24, new int[] {3, 5, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1F);
    public static final ArmorMaterial SKYTHERN_ARMOR = EnumHelper.addArmorMaterial("drpg_skythern_armor", Reference.MODID + ":skythern", 36, new int[] {4, 6, 8, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3F);
    public static final ArmorMaterial TERRAN_ARMOR = EnumHelper.addArmorMaterial("drpg_terran_armor", Reference.MODID + ":terran", 29, new int[] {3, 5, 7, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1F);
    public static final ArmorMaterial VEMOS_ARMOR = EnumHelper.addArmorMaterial("drpg_vemos_armor", Reference.MODID + ":vemos", 28, new int[] {4, 5, 6, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3F);
    public static final ArmorMaterial WILDWOOD_ARMOR = EnumHelper.addArmorMaterial("drpg_wildwood_armor", Reference.MODID + ":wildwood", 34, new int[] {4, 5, 7, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3F);
    public static final ArmorMaterial WITHER_REAPER_ARMOR = EnumHelper.addArmorMaterial("drpg_wither_reaper_armor", Reference.MODID + ":wither_reaper", 34, new int[] {3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F);

    public static final ArmorMaterial DEGRADED_ARMOR = EnumHelper.addArmorMaterial("drpg_degraded_armor", Reference.MODID + ":degraded", 25, new int[] {2, 4, 5, 3},  10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F);
    public static final ArmorMaterial FINISHED_ARMOR = EnumHelper.addArmorMaterial("drpg_finished_armor", Reference.MODID + ":finished", 30, new int[] {3, 5, 6, 3},  10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3F);
    public static final ArmorMaterial GLISTENING_ARMOR = EnumHelper.addArmorMaterial("drpg_glistening_armor", Reference.MODID + ":glistening", 35, new int[] {3, 6, 7, 4},  10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3F);
    public static final ArmorMaterial DEMONIZED_ARMOR = EnumHelper.addArmorMaterial("drpg_demonized_armor", Reference.MODID + ":demonized", 40, new int[] {4, 7, 8, 4},  10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4F);
    public static final ArmorMaterial TORMENTED_ARMOR = EnumHelper.addArmorMaterial("drpg_tormented_armor", Reference.MODID + ":tormented", 45, new int[] {4, 8, 9, 5},  10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4F);

    private static ItemStack makeRepairStack(String itemName) {
        return new ItemStack(ModItems.getItemFromMap(itemName));
    }

    private static ItemStack makeRepairStack(Item item) {
        return new ItemStack(item);
    }
}
