package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.enums.ArmorInfo;
import divinerpg.objects.items.base.ItemDivineArmor;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Objects;

import static divinerpg.utils.LocalizeUtils.getArmorAbility;

/**
 * Created to ensure that armors are registered after items, due to requiring item instances for their repair materials.
 * Any armors must go here.
 */
@Mod.EventBusSubscriber
@ObjectHolder("divinerpg")
public class ModArmor {

    // Vanilla dimension armor
    @ObjectHolder("angelic_helmet")
    public static final Item angelicHelmet = null;
    @ObjectHolder("angelic_chestplate")
    public static final Item angelicChestplate = null;
    @ObjectHolder("angelic_leggings")
    public static final Item angelicLeggings = null;
    @ObjectHolder("angelic_boots")
    public static final Item angelicBoots = null;

    @ObjectHolder("aquastrive_helmet")
    public static final Item aquastriveHelmet = null;
    @ObjectHolder("aquastrive_chestplate")
    public static final Item aquastriveChestplate = null;
    @ObjectHolder("aquastrive_leggings")
    public static final Item aquastriveLeggings = null;
    @ObjectHolder("aquastrive_boots")
    public static final Item aquastriveBoots = null;

    @ObjectHolder("arlemite_helmet")
    public static final Item arlemiteHelmet = null;
    @ObjectHolder("arlemite_chestplate")
    public static final Item arlemiteChestplate = null;
    @ObjectHolder("arlemite_leggings")
    public static final Item arlemiteLeggings = null;
    @ObjectHolder("arlemite_boots")
    public static final Item arlemiteBoots = null;

    @ObjectHolder("bedrock_helmet")
    public static final Item bedrockHelmet = null;
    @ObjectHolder("bedrock_chestplate")
    public static final Item bedrockChestplate = null;
    @ObjectHolder("bedrock_leggings")
    public static final Item bedrockLeggings = null;
    @ObjectHolder("bedrock_boots")
    public static final Item bedrockBoots = null;

    @ObjectHolder("corrupted_helmet")
    public static final Item corruptedHelmet = null;
    @ObjectHolder("corrupted_chestplate")
    public static final Item corruptedChestplate = null;
    @ObjectHolder("corrupted_leggings")
    public static final Item corruptedLeggings = null;
    @ObjectHolder("corrupted_boots")
    public static final Item corruptedBoots = null;

    @ObjectHolder("divine_helmet")
    public static final Item divineHelmet = null;
    @ObjectHolder("divine_chestplate")
    public static final Item divineChestplate = null;
    @ObjectHolder("divine_leggings")
    public static final Item divineLeggings = null;
    @ObjectHolder("divine_boots")
    public static final Item divineBoots = null;

    @ObjectHolder("elite_realmite_helmet")
    public static final Item eliteRealmiteHelmet = null;
    @ObjectHolder("elite_realmite_chestplate")
    public static final Item eliteRealmiteChestplate = null;
    @ObjectHolder("elite_realmite_leggings")
    public static final Item eliteRealmiteLeggings = null;
    @ObjectHolder("elite_realmite_boots")
    public static final Item eliteRealmiteBoots = null;

    @ObjectHolder("ender_helmet")
    public static final Item enderHelmet = null;
    @ObjectHolder("ender_chestplate")
    public static final Item enderChestplate = null;
    @ObjectHolder("ender_leggings")
    public static final Item enderLeggings = null;
    @ObjectHolder("ender_boots")
    public static final Item enderBoots = null;


    @ObjectHolder("blue_ender_helmet")
    public static final Item blueEnderHelmet = null;
    @ObjectHolder("blue_ender_chestplate")
    public static final Item blueEnderChestplate = null;
    @ObjectHolder("blue_ender_leggings")
    public static final Item blueEnderLeggings = null;
    @ObjectHolder("blue_ender_boots")
    public static final Item blueEnderBoots = null;

    @ObjectHolder("gray_ender_helmet")
    public static final Item grayEnderHelmet = null;
    @ObjectHolder("gray_ender_chestplate")
    public static final Item grayEnderChestplate = null;
    @ObjectHolder("gray_ender_leggings")
    public static final Item grayEnderLeggings = null;
    @ObjectHolder("gray_ender_boots")
    public static final Item grayEnderBoots = null;

    @ObjectHolder("green_ender_helmet")
    public static final Item greenEnderHelmet = null;
    @ObjectHolder("green_ender_chestplate")
    public static final Item greenEnderChestplate = null;
    @ObjectHolder("green_ender_leggings")
    public static final Item greenEnderLeggings = null;
    @ObjectHolder("green_ender_boots")
    public static final Item greenEnderBoots = null;

    @ObjectHolder("red_ender_helmet")
    public static final Item redEnderHelmet = null;
    @ObjectHolder("red_ender_chestplate")
    public static final Item redEnderChestplate = null;
    @ObjectHolder("red_ender_leggings")
    public static final Item redEnderLeggings = null;
    @ObjectHolder("red_ender_boots")
    public static final Item redEnderBoots = null;

    @ObjectHolder("yellow_ender_helmet")
    public static final Item yellowEnderHelmet = null;
    @ObjectHolder("yellow_ender_chestplate")
    public static final Item yellowEnderChestplate = null;
    @ObjectHolder("yellow_ender_leggings")
    public static final Item yellowEnderLeggings = null;
    @ObjectHolder("yellow_ender_boots")
    public static final Item yellowEnderBoots = null;

    @ObjectHolder("frozen_helmet")
    public static final Item frozenHelmet = null;
    @ObjectHolder("frozen_chestplate")
    public static final Item frozenChestplate = null;
    @ObjectHolder("frozen_leggings")
    public static final Item frozenLeggings = null;
    @ObjectHolder("frozen_boots")
    public static final Item frozenBoots = null;

    @ObjectHolder("inferno_helmet")
    public static final Item infernoHelmet = null;
    @ObjectHolder("inferno_chestplate")
    public static final Item infernoChestplate = null;
    @ObjectHolder("inferno_leggings")
    public static final Item infernoLeggings = null;
    @ObjectHolder("inferno_boots")
    public static final Item infernoBoots = null;

    @ObjectHolder("jack_o_man_helmet")
    public static final Item jackOManHelmet = null;
    @ObjectHolder("jack_o_man_chestplate")
    public static final Item jackOManChestplate = null;
    @ObjectHolder("jack_o_man_leggings")
    public static final Item jackOManLeggings = null;
    @ObjectHolder("jack_o_man_boots")
    public static final Item jackOManBoots = null;

    @ObjectHolder("jungle_helmet")
    public static final Item jungleHelmet = null;
    @ObjectHolder("jungle_chestplate")
    public static final Item jungleChestplate = null;
    @ObjectHolder("jungle_leggings")
    public static final Item jungleLeggings = null;
    @ObjectHolder("jungle_boots")
    public static final Item jungleBoots = null;

    @ObjectHolder("kraken_helmet")
    public static final Item krakenHelmet = null;
    @ObjectHolder("kraken_chestplate")
    public static final Item krakenChestplate = null;
    @ObjectHolder("kraken_leggings")
    public static final Item krakenLeggings = null;
    @ObjectHolder("kraken_boots")
    public static final Item krakenBoots = null;

    @ObjectHolder("netherite_helmet")
    public static final Item netheriteHelmet = null;
    @ObjectHolder("netherite_chestplate")
    public static final Item netheriteChestplate = null;
    @ObjectHolder("netherite_leggings")
    public static final Item netheriteLeggings = null;
    @ObjectHolder("netherite_boots")
    public static final Item netheriteBoots = null;

    @ObjectHolder("realmite_helmet")
    public static final Item realmiteHelmet = null;
    @ObjectHolder("realmite_chestplate")
    public static final Item realmiteChestplate = null;
    @ObjectHolder("realmite_leggings")
    public static final Item realmiteLeggings = null;
    @ObjectHolder("realmite_boots")
    public static final Item realmiteBoots = null;

    @ObjectHolder("rupee_helmet")
    public static final Item rupeeHelmet = null;
    @ObjectHolder("rupee_chestplate")
    public static final Item rupeeChestplate = null;
    @ObjectHolder("rupee_leggings")
    public static final Item rupeeLeggings = null;
    @ObjectHolder("rupee_boots")
    public static final Item rupeeBoots = null;

    @ObjectHolder("blue_rupee_helmet")
    public static final Item blueRupeeHelmet = null;
    @ObjectHolder("blue_rupee_chestplate")
    public static final Item blueRupeeChestplate = null;
    @ObjectHolder("blue_rupee_leggings")
    public static final Item blueRupeeLeggings = null;
    @ObjectHolder("blue_rupee_boots")
    public static final Item blueRupeeBoots = null;

    @ObjectHolder("green_rupee_helmet")
    public static final Item greenRupeeHelmet = null;
    @ObjectHolder("green_rupee_chestplate")
    public static final Item greenRupeeChestplate = null;
    @ObjectHolder("green_rupee_leggings")
    public static final Item greenRupeeLeggings = null;
    @ObjectHolder("green_rupee_boots")
    public static final Item greenRupeeBoots = null;

    @ObjectHolder("gray_rupee_helmet")
    public static final Item grayRupeeHelmet = null;
    @ObjectHolder("gray_rupee_chestplate")
    public static final Item grayRupeeChestplate = null;
    @ObjectHolder("gray_rupee_leggings")
    public static final Item grayRupeeLeggings = null;
    @ObjectHolder("gray_rupee_boots")
    public static final Item grayRupeeBoots = null;

    @ObjectHolder("red_rupee_helmet")
    public static final Item redRupeeHelmet = null;
    @ObjectHolder("red_rupee_chestplate")
    public static final Item redRupeeChestplate = null;
    @ObjectHolder("red_rupee_leggings")
    public static final Item redRupeeLeggings = null;
    @ObjectHolder("red_rupee_boots")
    public static final Item redRupeeBoots = null;

    @ObjectHolder("yellow_rupee_helmet")
    public static final Item yellowRupeeHelmet = null;
    @ObjectHolder("yellow_rupee_chestplate")
    public static final Item yellowRupeeChestplate = null;
    @ObjectHolder("yellow_rupee_leggings")
    public static final Item yellowRupeeLeggings = null;
    @ObjectHolder("yellow_rupee_boots")
    public static final Item yellowRupeeBoots = null;

    @ObjectHolder("shadow_helmet")
    public static final Item shadowHelmet = null;
    @ObjectHolder("shadow_chestplate")
    public static final Item shadowChestplate = null;
    @ObjectHolder("shadow_leggings")
    public static final Item shadowLeggings = null;
    @ObjectHolder("shadow_boots")
    public static final Item shadowBoots = null;

    @ObjectHolder("skeleman_helmet")
    public static final Item skelemanHelmet = null;
    @ObjectHolder("skeleman_chestplate")
    public static final Item skelemanChestplate = null;
    @ObjectHolder("skeleman_leggings")
    public static final Item skelemanLeggings = null;
    @ObjectHolder("skeleman_boots")
    public static final Item skelemanBoots = null;

    @ObjectHolder("terran_helmet")
    public static final Item terranHelmet = null;
    @ObjectHolder("terran_chestplate")
    public static final Item terranChestplate = null;
    @ObjectHolder("terran_leggings")
    public static final Item terranLeggings = null;
    @ObjectHolder("terran_boots")
    public static final Item terranBoots = null;

    @ObjectHolder("wither_reaper_helmet")
    public static final Item witherReaperHelmet = null;
    @ObjectHolder("wither_reaper_chestplate")
    public static final Item witherReaperChestplate = null;
    @ObjectHolder("wither_reaper_leggings")
    public static final Item witherReaperLeggings = null;
    @ObjectHolder("wither_reaper_boots")
    public static final Item witherReaperBoots = null;

    // Iceika dimension armor
    @ObjectHolder("santa_helmet")
    public static final Item santaHelmet = null;
    @ObjectHolder("santa_chestplate")
    public static final Item santaChestplate = null;
    @ObjectHolder("santa_leggings")
    public static final Item santaLeggings = null;
    @ObjectHolder("santa_boots")
    public static final Item santaBoots = null;

    // Twilight armor
    @ObjectHolder("eden_helmet")
    public static final Item edenHelmet = null;
    @ObjectHolder("eden_chestplate")
    public static final Item edenChestplate = null;
    @ObjectHolder("eden_leggings")
    public static final Item edenLeggings = null;
    @ObjectHolder("eden_boots")
    public static final Item edenBoots = null;

    @ObjectHolder("wildwood_helmet")
    public static final Item wildwoodHelmet = null;
    @ObjectHolder("wildwood_chestplate")
    public static final Item wildwoodChestplate = null;
    @ObjectHolder("wildwood_leggings")
    public static final Item wildwoodLeggings = null;
    @ObjectHolder("wildwood_boots")
    public static final Item wildwoodBoots = null;

    @ObjectHolder("apalachia_helmet")
    public static final Item apalachiaHelmet = null;
    @ObjectHolder("apalachia_chestplate")
    public static final Item apalachiaChestplate = null;
    @ObjectHolder("apalachia_leggings")
    public static final Item apalachiaLeggings = null;
    @ObjectHolder("apalachia_boots")
    public static final Item apalachiaBoots = null;

    @ObjectHolder("skythern_helmet")
    public static final Item skythernHelmet = null;
    @ObjectHolder("skythern_chestplate")
    public static final Item skythernChestplate = null;
    @ObjectHolder("skythern_leggings")
    public static final Item skythernLeggings = null;
    @ObjectHolder("skythern_boots")
    public static final Item skythernBoots = null;

    @ObjectHolder("mortum_helmet")
    public static final Item mortumHelmet = null;
    @ObjectHolder("mortum_chestplate")
    public static final Item mortumChestplate = null;
    @ObjectHolder("mortum_leggings")
    public static final Item mortumLeggings = null;
    @ObjectHolder("mortum_boots")
    public static final Item mortumBoots = null;

    @ObjectHolder("halite_helmet")
    public static final Item haliteHelmet = null;
    @ObjectHolder("halite_chestplate")
    public static final Item haliteChestplate = null;
    @ObjectHolder("halite_leggings")
    public static final Item haliteLeggings = null;
    @ObjectHolder("halite_boots")
    public static final Item haliteBoots = null;

    @ObjectHolder("awakened_halite_helmet")
    public static final Item awakened_haliteHelmet = null;
    @ObjectHolder("awakened_halite_chestplate")
    public static final Item awakened_haliteChestplate = null;
    @ObjectHolder("awakened_halite_leggings")
    public static final Item awakened_haliteLeggings = null;
    @ObjectHolder("awakened_halite_boots")
    public static final Item awakened_haliteBoots = null;

//    @ObjectHolder("king_helmet")
//    public static final Item king_helmet = null;
//    @ObjectHolder("king_chestplate")
//    public static final Item king_chestplate = null;
//    @ObjectHolder("king_leggings")
//    public static final Item king_leggings = null;
//    @ObjectHolder("king_boots")
//    public static final Item king_boots = null;

    // Arcana armor sets
    @ObjectHolder("korma_helmet")
    public static final Item kormaHelmet = null;
    @ObjectHolder("korma_chestplate")
    public static final Item kormaChestplate = null;
    @ObjectHolder("korma_leggings")
    public static final Item kormaLeggings = null;
    @ObjectHolder("korma_boots")
    public static final Item kormaBoots = null;

    @ObjectHolder("vemos_helmet")
    public static final Item vemosHelmet = null;
    @ObjectHolder("vemos_chestplate")
    public static final Item vemosChestplate = null;
    @ObjectHolder("vemos_leggings")
    public static final Item vemosLeggings = null;
    @ObjectHolder("vemos_boots")
    public static final Item vemosBoots = null;

    // Vethea armor sets
    @ObjectHolder("degraded_helmet")
    public static final Item degradedHelmet = null;
    @ObjectHolder("degraded_hood")
    public static final Item degradedHood = null;
    @ObjectHolder("degraded_mask")
    public static final Item degradedMask = null;
    @ObjectHolder("degraded_chestplate")
    public static final Item degradedChestplate = null;
    @ObjectHolder("degraded_leggings")
    public static final Item degradedLeggings = null;
    @ObjectHolder("degraded_boots")
    public static final Item degradedBoots = null;

    @ObjectHolder("finished_helmet")
    public static final Item finishedHelmet = null;
    @ObjectHolder("finished_hood")
    public static final Item finishedHood = null;
    @ObjectHolder("finished_mask")
    public static final Item finishedMask = null;
    @ObjectHolder("finished_chestplate")
    public static final Item finishedChestplate = null;
    @ObjectHolder("finished_leggings")
    public static final Item finishedLeggings = null;
    @ObjectHolder("finished_boots")
    public static final Item finishedBoots = null;

    @ObjectHolder("glistening_helmet")
    public static final Item glisteningHelmet = null;
    @ObjectHolder("glistening_hood")
    public static final Item glisteningHood = null;
    @ObjectHolder("glistening_mask")
    public static final Item glisteningMask = null;
    @ObjectHolder("glistening_chestplate")
    public static final Item glisteningChestplate = null;
    @ObjectHolder("glistening_leggings")
    public static final Item glisteningLeggings = null;
    @ObjectHolder("glistening_boots")
    public static final Item glisteningBoots = null;

    @ObjectHolder("demonized_helmet")
    public static final Item demonizedHelmet = null;
    @ObjectHolder("demonized_hood")
    public static final Item demonizedHood = null;
    @ObjectHolder("demonized_mask")
    public static final Item demonizedMask = null;
    @ObjectHolder("demonized_chestplate")
    public static final Item demonizedChestplate = null;
    @ObjectHolder("demonized_leggings")
    public static final Item demonizedLeggings = null;
    @ObjectHolder("demonized_boots")
    public static final Item demonizedBoots = null;

    @ObjectHolder("tormented_helmet")
    public static final Item tormentedHelmet = null;
    @ObjectHolder("tormented_hood")
    public static final Item tormentedHood = null;
    @ObjectHolder("tormented_mask")
    public static final Item tormentedMask = null;
    @ObjectHolder("tormented_chestplate")
    public static final Item tormentedChestplate = null;
    @ObjectHolder("tormented_leggings")
    public static final Item tormentedLeggings = null;
    @ObjectHolder("tormented_boots")
    public static final Item tormentedBoots = null;

    // Armor information
    // Vanilla dimensions
    private static ArmorInfo angelicInfo = new ArmorInfo(getArmorAbility("no_fall"), getArmorAbility("fly"));
    private static ArmorInfo aquastriveInfo = new ArmorInfo(getArmorAbility("underwater"), getArmorAbility("swim"));
    private static ArmorInfo arlemiteInfo = new ArmorInfo(getArmorAbility("ranged_protection", 85));
    private static ArmorInfo bedrockInfo = new ArmorInfo(getArmorAbility("fire_protection"), getArmorAbility("explosion_protection"));
    private static ArmorInfo corruptedInfo = new ArmorInfo(getArmorAbility("ranged_damage", 50));
    private static ArmorInfo divineInfo = new ArmorInfo(getArmorAbility("melee_damage", 6),
            getArmorAbility("jump_height", 2),
            getArmorAbility("no_fall"));
    private static ArmorInfo eliteRealmiteInfo = new ArmorInfo(getArmorAbility("no_fall"));
    private static ArmorInfo enderInfo = new ArmorInfo(getArmorAbility("explosion_protection"));
    private static ArmorInfo frozenInfo = new ArmorInfo(getArmorAbility("freeze", 6));
    private static ArmorInfo infernoInfo = new ArmorInfo(getArmorAbility("fire_protection"));
    private static ArmorInfo jackomanInfo = new ArmorInfo(getArmorAbility("scythe_damage", 3));
    private static ArmorInfo jungleInfo = new ArmorInfo(getArmorAbility("poison_protection"));
    private static ArmorInfo krakenInfo = new ArmorInfo(getArmorAbility("underwater"));
    private static ArmorInfo netheriteInfo = new ArmorInfo(getArmorAbility("fire_protection"));
    private static ArmorInfo rupeeInfo = new ArmorInfo(getArmorAbility("melee_protection", 85));
    private static ArmorInfo shadowInfo = new ArmorInfo(getArmorAbility("speed", 3), getArmorAbility("step_assist"));
    private static ArmorInfo skelemanInfo = new ArmorInfo(getArmorAbility("hunger"));
    private static ArmorInfo terranInfo = new ArmorInfo(getArmorAbility("haste"));
    private static ArmorInfo witherReaperInfo = new ArmorInfo(getArmorAbility("wither_protection"));
    private static ArmorInfo kingInfo = new ArmorInfo(new TextComponentString("Absorbs super-power from other sets"));

    // Iceika
    private static ArmorInfo santaInfo = new ArmorInfo(new TextComponentTranslation("tooltip.armor_info.massive_buff"),
            getArmorAbility("speed", 2),
            getArmorAbility("melee_damage", 6),
            getArmorAbility("hunger"),
            getArmorAbility("melee_protection", 80))
            .withDimension(new TextComponentTranslation("tooltip.armor_info.iceika"), x -> Objects.equals(x, ModDimensions.iceikaDimension));

    // Twilight
    private static ArmorInfo edenInfo = new ArmorInfo(getArmorAbility("ore_drops", 3));
    private static ArmorInfo wildInfo = new ArmorInfo(getArmorAbility("underwater_health_regen"));
    private static ArmorInfo apInfo = new ArmorInfo(getArmorAbility("block_protection"));
    private static ArmorInfo skyInfo = new ArmorInfo(getArmorAbility("jump_height", 5), getArmorAbility("no_fall"));
    private static ArmorInfo mortInfo = new ArmorInfo(getArmorAbility("night_vision"));
    private static ArmorInfo halInfo = new ArmorInfo(getArmorAbility("melee_damage", 16));
    private static ArmorInfo awakened_halInfo = new ArmorInfo(getArmorAbility("melee_damage", 20),
            getArmorAbility("ranged_damage", 50));

    // Arcana
    private static ArmorInfo kormInfo = new ArmorInfo(getArmorAbility("arcana_regen"));
    private static ArmorInfo vemInfo = new ArmorInfo(getArmorAbility("health_regen"));

    // Vethea
    private static ArmorInfo basicHelmInfo = new ArmorInfo(getArmorAbility("melee_protection", 15));
    private static ArmorInfo basicMaskInfo = new ArmorInfo(getArmorAbility("ranged_protection", 15));
    private static ArmorInfo basicHoodInfo = new ArmorInfo(getArmorAbility("arcana_protection", 15));

    private static ArmorInfo glisteningHelmInfo = new ArmorInfo(getArmorAbility("melee_protection", 15), getArmorAbility("melee_damage", 3));
    private static ArmorInfo glisteningMaskInfo = new ArmorInfo(getArmorAbility("ranged_protection", 15), getArmorAbility("speed", 1.4));
    private static ArmorInfo glisteningHoodInfo = new ArmorInfo(getArmorAbility("arcana_protection", 15), getArmorAbility("jump_height", 2), getArmorAbility("no_fall"));

    private static ArmorInfo demonizedHelmInfo = new ArmorInfo(getArmorAbility("melee_protection", 15), getArmorAbility("melee_damage", 6));
    private static ArmorInfo demonizedMaskInfo = new ArmorInfo(getArmorAbility("ranged_protection", 15), getArmorAbility("speed", 1.8));
    private static ArmorInfo demonizedHoodInfo = new ArmorInfo(getArmorAbility("arcana_protection", 15), getArmorAbility("jump_height", 3), getArmorAbility("no_fall"));

    private static ArmorInfo tormentedHelmInfo = new ArmorInfo(getArmorAbility("melee_protection", 15), getArmorAbility("melee_damage", 9));
    private static ArmorInfo tormentedMaskInfo = new ArmorInfo(getArmorAbility("ranged_protection", 15), getArmorAbility("speed", 2.2));
    private static ArmorInfo tormentedHoodInfo = new ArmorInfo(getArmorAbility("arcana_protection", 15), getArmorAbility("jump_height", 4), getArmorAbility("no_fall"));

    private static void registerArmorSet(IForgeRegistry<Item> registry, String prefix, ArmorMaterial material, ArmorInfo info) {
        register(registry, new ItemDivineArmor(prefix + "_helmet", material, EntityEquipmentSlot.HEAD, info));
        register(registry, new ItemDivineArmor(prefix + "_chestplate", material, EntityEquipmentSlot.CHEST, info));
        register(registry, new ItemDivineArmor(prefix + "_leggings", material, EntityEquipmentSlot.LEGS, info));
        register(registry, new ItemDivineArmor(prefix + "_boots", material, EntityEquipmentSlot.FEET, info));
    }

    private static void registerVetheanArmorSet(IForgeRegistry<Item> registry, String prefix, ArmorMaterial material, ArmorInfo helmetInfo, ArmorInfo hoodInfo, ArmorInfo maskInfo, ArmorInfo info) {
        register(registry, new ItemDivineArmor(prefix + "_helmet", material, EntityEquipmentSlot.HEAD, helmetInfo));
        register(registry, new ItemDivineArmor(prefix + "_hood", material, EntityEquipmentSlot.HEAD, hoodInfo));
        register(registry, new ItemDivineArmor(prefix + "_mask", material, EntityEquipmentSlot.HEAD, maskInfo));
        register(registry, new ItemDivineArmor(prefix + "_chestplate", material, EntityEquipmentSlot.CHEST, info));
        register(registry, new ItemDivineArmor(prefix + "_leggings", material, EntityEquipmentSlot.LEGS, info));
        register(registry, new ItemDivineArmor(prefix + "_boots", material, EntityEquipmentSlot.FEET, info));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        DivineRPG.logger.info("Registering DivineRPG armor");

        IForgeRegistry<Item> registry = event.getRegistry();

        // Vanilla dimension armor
        registerArmorSet(registry, "angelic", ToolMaterialMod.ANGELIC_ARMOR, angelicInfo);
        registerArmorSet(registry, "aquastrive", ToolMaterialMod.AQUASTRIVE_ARMOR, aquastriveInfo);
        registerArmorSet(registry, "arlemite", ToolMaterialMod.ARLEMITE_ARMOR, arlemiteInfo);
        registerArmorSet(registry, "bedrock", ToolMaterialMod.BEDROCK_ARMOR, bedrockInfo);
        registerArmorSet(registry, "corrupted", ToolMaterialMod.CORRUPTED_ARMOR, corruptedInfo);
        registerArmorSet(registry, "divine", ToolMaterialMod.DIVINE_ARMOR, divineInfo);
        registerArmorSet(registry, "elite_realmite", ToolMaterialMod.ELITE_REALMITE_ARMOR, eliteRealmiteInfo);
        registerArmorSet(registry, "ender", ToolMaterialMod.ENDER_ARMOR, enderInfo);
        registerArmorSet(registry, "blue_ender", ToolMaterialMod.BLUE_ENDER_ARMOR, enderInfo);
        registerArmorSet(registry, "gray_ender", ToolMaterialMod.GRAY_ENDER_ARMOR, enderInfo);
        registerArmorSet(registry, "green_ender", ToolMaterialMod.GREEN_ENDER_ARMOR, enderInfo);
        registerArmorSet(registry, "red_ender", ToolMaterialMod.RED_ENDER_ARMOR, enderInfo);
        registerArmorSet(registry, "yellow_ender", ToolMaterialMod.YELLOW_ENDER_ARMOR, enderInfo);

        registerArmorSet(registry, "frozen", ToolMaterialMod.FROZEN_ARMOR, frozenInfo);
        registerArmorSet(registry, "inferno", ToolMaterialMod.INFERNO_ARMOR, infernoInfo);
        registerArmorSet(registry, "jack_o_man", ToolMaterialMod.JACK_O_MAN_ARMOR, jackomanInfo);
        registerArmorSet(registry, "jungle", ToolMaterialMod.JUNGLE_ARMOR, jungleInfo);
        registerArmorSet(registry, "kraken", ToolMaterialMod.KRAKEN_ARMOR, krakenInfo);
        registerArmorSet(registry, "netherite", ToolMaterialMod.NETHERITE_ARMOR, netheriteInfo);
        registerArmorSet(registry, "realmite", ToolMaterialMod.REALMITE_ARMOR, new ArmorInfo());

        registerArmorSet(registry, "rupee", ToolMaterialMod.RUPEE_ARMOR, rupeeInfo);
        registerArmorSet(registry, "blue_rupee", ToolMaterialMod.BLUE_RUPEE_ARMOR, rupeeInfo);
        registerArmorSet(registry, "gray_rupee", ToolMaterialMod.GRAY_RUPEE_ARMOR, rupeeInfo);
        registerArmorSet(registry, "green_rupee", ToolMaterialMod.GREEN_RUPEE_ARMOR, rupeeInfo);
        registerArmorSet(registry, "red_rupee", ToolMaterialMod.RED_RUPEE_ARMOR, rupeeInfo);
        registerArmorSet(registry, "yellow_rupee", ToolMaterialMod.YELLOW_RUPEE_ARMOR, rupeeInfo);

        registerArmorSet(registry, "shadow", ToolMaterialMod.SHADOW_ARMOR, shadowInfo);
        registerArmorSet(registry, "skeleman", ToolMaterialMod.SKELEMAN_ARMOR, skelemanInfo);
        registerArmorSet(registry, "terran", ToolMaterialMod.TERRAN_ARMOR, terranInfo);
        registerArmorSet(registry, "wither_reaper", ToolMaterialMod.WITHER_REAPER_ARMOR, witherReaperInfo);

        // Iceika dimension armor
        registerArmorSet(registry, "santa", ToolMaterialMod.SANTA_ARMOR, santaInfo);

        // Twilight armor
        registerArmorSet(registry, "eden", ToolMaterialMod.EDEN_ARMOR, edenInfo);
        registerArmorSet(registry, "wildwood", ToolMaterialMod.WILDWOOD_ARMOR, wildInfo);
        registerArmorSet(registry, "apalachia", ToolMaterialMod.APALACHIA_ARMOR, apInfo);
        registerArmorSet(registry, "skythern", ToolMaterialMod.SKYTHERN_ARMOR, skyInfo);
        registerArmorSet(registry, "mortum", ToolMaterialMod.MORTUM_ARMOR, mortInfo);
        registerArmorSet(registry, "halite", ToolMaterialMod.HALITE_ARMOR, halInfo);
        registerArmorSet(registry, "awakened_halite", ToolMaterialMod.AWAKENED_HALITE_ARMOR, awakened_halInfo);

        // Arcana armor sets
        registerArmorSet(registry, "korma", ToolMaterialMod.KORMA_ARMOR, kormInfo);
        registerArmorSet(registry, "vemos", ToolMaterialMod.VEMOS_ARMOR, vemInfo);

        // Vethea armor sets
        registerVetheanArmorSet(registry, "degraded", ToolMaterialMod.DEGRADED_ARMOR, basicHelmInfo, basicHoodInfo, basicMaskInfo, new ArmorInfo());
        registerVetheanArmorSet(registry, "finished", ToolMaterialMod.FINISHED_ARMOR, basicHelmInfo, basicHoodInfo, basicMaskInfo, new ArmorInfo());
        registerVetheanArmorSet(registry, "glistening", ToolMaterialMod.GLISTENING_ARMOR, glisteningHelmInfo, glisteningHoodInfo, glisteningMaskInfo, new ArmorInfo());
        registerVetheanArmorSet(registry, "demonized", ToolMaterialMod.DEMONIZED_ARMOR, demonizedHelmInfo, demonizedHoodInfo, demonizedMaskInfo, new ArmorInfo());
        registerVetheanArmorSet(registry, "tormented", ToolMaterialMod.TORMENTED_ARMOR, tormentedHelmInfo, tormentedHoodInfo, tormentedMaskInfo, new ArmorInfo());

        // King armor
        //register(registry, new KingArmorItem("king_helmet", ToolMaterialMod.KING_ARMOR, EntityEquipmentSlot.HEAD, kingInfo));
        //register(registry, new KingArmorItem("king_chestplate", ToolMaterialMod.KING_ARMOR, EntityEquipmentSlot.CHEST, kingInfo));
        //register(registry, new KingArmorItem("king_leggings", ToolMaterialMod.KING_ARMOR, EntityEquipmentSlot.LEGS, kingInfo));
        //register(registry, new KingArmorItem("king_boots", ToolMaterialMod.KING_ARMOR, EntityEquipmentSlot.FEET, kingInfo));
    }

    private static void register(IForgeRegistry<Item> registry, Item item) {
        registry.register(item);
        ModItems.itemMap.put(item.getRegistryName().getResourcePath(), item);
    }
}
