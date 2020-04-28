package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.enums.ArmorInfo;
import divinerpg.enums.EnumArmor;
import divinerpg.objects.items.base.ItemDivineArmor;
import divinerpg.objects.items.vanilla.KingArmorItem;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
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
    @ObjectHolder("santa_cap")
    public static final Item santaCap = null;
    @ObjectHolder("santa_tunic")
    public static final Item santaTunic = null;
    @ObjectHolder("santa_pants")
    public static final Item santaPants = null;
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

    @ObjectHolder("king_helmet")
    public static final Item king_helmet = null;
    @ObjectHolder("king_chestplate")
    public static final Item king_chestplate = null;
    @ObjectHolder("king_leggings")
    public static final Item king_leggings = null;
    @ObjectHolder("king_boots")
    public static final Item king_boots = null;

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

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        DivineRPG.logger.info("Registering DivineRPG armor");

        IForgeRegistry<Item> registry = event.getRegistry();

        // Vanilla dimension armor

        register(registry, new ItemDivineArmor(EnumArmor.ANGELIC, EntityEquipmentSlot.HEAD, angelicInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ANGELIC, EntityEquipmentSlot.CHEST, angelicInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ANGELIC, EntityEquipmentSlot.LEGS, angelicInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ANGELIC, EntityEquipmentSlot.FEET, angelicInfo));

        register(registry, new ItemDivineArmor(EnumArmor.AQUATIC, EntityEquipmentSlot.HEAD, aquastriveInfo));
        register(registry, new ItemDivineArmor(EnumArmor.AQUATIC, EntityEquipmentSlot.CHEST, aquastriveInfo));
        register(registry, new ItemDivineArmor(EnumArmor.AQUATIC, EntityEquipmentSlot.LEGS, aquastriveInfo));
        register(registry, new ItemDivineArmor(EnumArmor.AQUATIC, EntityEquipmentSlot.FEET, aquastriveInfo));

        register(registry, new ItemDivineArmor(EnumArmor.ARLEMITE, EntityEquipmentSlot.HEAD, arlemiteInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ARLEMITE, EntityEquipmentSlot.CHEST, arlemiteInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ARLEMITE, EntityEquipmentSlot.LEGS, arlemiteInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ARLEMITE, EntityEquipmentSlot.FEET, arlemiteInfo));

        register(registry, new ItemDivineArmor(EnumArmor.BEDROCK, EntityEquipmentSlot.HEAD, bedrockInfo));
        register(registry, new ItemDivineArmor(EnumArmor.BEDROCK, EntityEquipmentSlot.CHEST, bedrockInfo));
        register(registry, new ItemDivineArmor(EnumArmor.BEDROCK, EntityEquipmentSlot.LEGS, bedrockInfo));
        register(registry, new ItemDivineArmor(EnumArmor.BEDROCK, EntityEquipmentSlot.FEET, bedrockInfo));

        register(registry, new ItemDivineArmor(EnumArmor.CORRUPTED, EntityEquipmentSlot.HEAD, corruptedInfo));
        register(registry, new ItemDivineArmor(EnumArmor.CORRUPTED, EntityEquipmentSlot.CHEST, corruptedInfo));
        register(registry, new ItemDivineArmor(EnumArmor.CORRUPTED, EntityEquipmentSlot.LEGS, corruptedInfo));
        register(registry, new ItemDivineArmor(EnumArmor.CORRUPTED, EntityEquipmentSlot.FEET, corruptedInfo));

        register(registry, new ItemDivineArmor(EnumArmor.DIVINE, EntityEquipmentSlot.HEAD, divineInfo));
        register(registry, new ItemDivineArmor(EnumArmor.DIVINE, EntityEquipmentSlot.CHEST, divineInfo));
        register(registry, new ItemDivineArmor(EnumArmor.DIVINE, EntityEquipmentSlot.LEGS, divineInfo));
        register(registry, new ItemDivineArmor(EnumArmor.DIVINE, EntityEquipmentSlot.FEET, divineInfo));

        register(registry, new ItemDivineArmor(EnumArmor.ELITE_REALMITE, EntityEquipmentSlot.HEAD, eliteRealmiteInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ELITE_REALMITE, EntityEquipmentSlot.CHEST, eliteRealmiteInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ELITE_REALMITE, EntityEquipmentSlot.LEGS, eliteRealmiteInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ELITE_REALMITE, EntityEquipmentSlot.FEET, eliteRealmiteInfo));

        register(registry, new ItemDivineArmor(EnumArmor.ENDER, EntityEquipmentSlot.HEAD, enderInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ENDER, EntityEquipmentSlot.CHEST, enderInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ENDER, EntityEquipmentSlot.LEGS, enderInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ENDER, EntityEquipmentSlot.FEET, enderInfo));

        register(registry, new ItemDivineArmor(EnumArmor.ENDER_BLUE, EntityEquipmentSlot.HEAD, enderInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ENDER_BLUE, EntityEquipmentSlot.CHEST, enderInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ENDER_BLUE, EntityEquipmentSlot.LEGS, enderInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ENDER_BLUE, EntityEquipmentSlot.FEET, enderInfo));

        register(registry, new ItemDivineArmor(EnumArmor.ENDER_GRAY, EntityEquipmentSlot.HEAD, enderInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ENDER_GRAY, EntityEquipmentSlot.CHEST, enderInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ENDER_GRAY, EntityEquipmentSlot.LEGS, enderInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ENDER_GRAY, EntityEquipmentSlot.FEET, enderInfo));

        register(registry, new ItemDivineArmor(EnumArmor.ENDER_GREEN, EntityEquipmentSlot.HEAD, enderInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ENDER_GREEN, EntityEquipmentSlot.CHEST, enderInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ENDER_GREEN, EntityEquipmentSlot.LEGS, enderInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ENDER_GREEN, EntityEquipmentSlot.FEET, enderInfo));

        register(registry, new ItemDivineArmor(EnumArmor.ENDER_RED, EntityEquipmentSlot.HEAD, enderInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ENDER_RED, EntityEquipmentSlot.CHEST, enderInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ENDER_RED, EntityEquipmentSlot.LEGS, enderInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ENDER_RED, EntityEquipmentSlot.FEET, enderInfo));

        register(registry, new ItemDivineArmor(EnumArmor.ENDER_YELLOW, EntityEquipmentSlot.HEAD, enderInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ENDER_YELLOW, EntityEquipmentSlot.CHEST, enderInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ENDER_YELLOW, EntityEquipmentSlot.LEGS, enderInfo));
        register(registry, new ItemDivineArmor(EnumArmor.ENDER_YELLOW, EntityEquipmentSlot.FEET, enderInfo));

        register(registry, new ItemDivineArmor(EnumArmor.FROZEN, EntityEquipmentSlot.HEAD, frozenInfo));
        register(registry, new ItemDivineArmor(EnumArmor.FROZEN, EntityEquipmentSlot.CHEST, frozenInfo));
        register(registry, new ItemDivineArmor(EnumArmor.FROZEN, EntityEquipmentSlot.LEGS, frozenInfo));
        register(registry, new ItemDivineArmor(EnumArmor.FROZEN, EntityEquipmentSlot.FEET, frozenInfo));

        register(registry, new ItemDivineArmor(EnumArmor.INFERNO, EntityEquipmentSlot.HEAD, infernoInfo));
        register(registry, new ItemDivineArmor(EnumArmor.INFERNO, EntityEquipmentSlot.CHEST, infernoInfo));
        register(registry, new ItemDivineArmor(EnumArmor.INFERNO, EntityEquipmentSlot.LEGS, infernoInfo));
        register(registry, new ItemDivineArmor(EnumArmor.INFERNO, EntityEquipmentSlot.FEET, infernoInfo));

        register(registry, new ItemDivineArmor(EnumArmor.JACKOMAN, EntityEquipmentSlot.HEAD, jackomanInfo));
        register(registry, new ItemDivineArmor(EnumArmor.JACKOMAN, EntityEquipmentSlot.CHEST, jackomanInfo));
        register(registry, new ItemDivineArmor(EnumArmor.JACKOMAN, EntityEquipmentSlot.LEGS, jackomanInfo));
        register(registry, new ItemDivineArmor(EnumArmor.JACKOMAN, EntityEquipmentSlot.FEET, jackomanInfo));

        register(registry, new ItemDivineArmor(EnumArmor.JUNGLE, EntityEquipmentSlot.HEAD, jungleInfo));
        register(registry, new ItemDivineArmor(EnumArmor.JUNGLE, EntityEquipmentSlot.CHEST, jungleInfo));
        register(registry, new ItemDivineArmor(EnumArmor.JUNGLE, EntityEquipmentSlot.LEGS, jungleInfo));
        register(registry, new ItemDivineArmor(EnumArmor.JUNGLE, EntityEquipmentSlot.FEET, jungleInfo));

        register(registry, new ItemDivineArmor(EnumArmor.KRAKEN, EntityEquipmentSlot.HEAD, krakenInfo));
        register(registry, new ItemDivineArmor(EnumArmor.KRAKEN, EntityEquipmentSlot.CHEST, krakenInfo));
        register(registry, new ItemDivineArmor(EnumArmor.KRAKEN, EntityEquipmentSlot.LEGS, krakenInfo));
        register(registry, new ItemDivineArmor(EnumArmor.KRAKEN, EntityEquipmentSlot.FEET, krakenInfo));

        register(registry, new ItemDivineArmor(EnumArmor.NETHERITE, EntityEquipmentSlot.HEAD, netheriteInfo));
        register(registry, new ItemDivineArmor(EnumArmor.NETHERITE, EntityEquipmentSlot.CHEST, netheriteInfo));
        register(registry, new ItemDivineArmor(EnumArmor.NETHERITE, EntityEquipmentSlot.LEGS, netheriteInfo));
        register(registry, new ItemDivineArmor(EnumArmor.NETHERITE, EntityEquipmentSlot.FEET, netheriteInfo));

        register(registry, new ItemDivineArmor(EnumArmor.REALMITE, EntityEquipmentSlot.HEAD));
        register(registry, new ItemDivineArmor(EnumArmor.REALMITE, EntityEquipmentSlot.CHEST));
        register(registry, new ItemDivineArmor(EnumArmor.REALMITE, EntityEquipmentSlot.LEGS));
        register(registry, new ItemDivineArmor(EnumArmor.REALMITE, EntityEquipmentSlot.FEET));

        register(registry, new ItemDivineArmor(EnumArmor.RUPEE, EntityEquipmentSlot.HEAD, rupeeInfo));
        register(registry, new ItemDivineArmor(EnumArmor.RUPEE, EntityEquipmentSlot.CHEST, rupeeInfo));
        register(registry, new ItemDivineArmor(EnumArmor.RUPEE, EntityEquipmentSlot.LEGS, rupeeInfo));
        register(registry, new ItemDivineArmor(EnumArmor.RUPEE, EntityEquipmentSlot.FEET, rupeeInfo));

        register(registry, new ItemDivineArmor(EnumArmor.RUPEE_BLUE, EntityEquipmentSlot.HEAD, rupeeInfo));
        register(registry, new ItemDivineArmor(EnumArmor.RUPEE_BLUE, EntityEquipmentSlot.CHEST, rupeeInfo));
        register(registry, new ItemDivineArmor(EnumArmor.RUPEE_BLUE, EntityEquipmentSlot.LEGS, rupeeInfo));
        register(registry, new ItemDivineArmor(EnumArmor.RUPEE_BLUE, EntityEquipmentSlot.FEET, rupeeInfo));

        register(registry, new ItemDivineArmor(EnumArmor.RUPEE_GRAY, EntityEquipmentSlot.HEAD, rupeeInfo));
        register(registry, new ItemDivineArmor(EnumArmor.RUPEE_GRAY, EntityEquipmentSlot.CHEST, rupeeInfo));
        register(registry, new ItemDivineArmor(EnumArmor.RUPEE_GRAY, EntityEquipmentSlot.LEGS, rupeeInfo));
        register(registry, new ItemDivineArmor(EnumArmor.RUPEE_GRAY, EntityEquipmentSlot.FEET, rupeeInfo));

        register(registry, new ItemDivineArmor(EnumArmor.RUPEE_GREEN, EntityEquipmentSlot.HEAD, rupeeInfo));
        register(registry, new ItemDivineArmor(EnumArmor.RUPEE_GREEN, EntityEquipmentSlot.CHEST, rupeeInfo));
        register(registry, new ItemDivineArmor(EnumArmor.RUPEE_GREEN, EntityEquipmentSlot.LEGS, rupeeInfo));
        register(registry, new ItemDivineArmor(EnumArmor.RUPEE_GREEN, EntityEquipmentSlot.FEET, rupeeInfo));

        register(registry, new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, EntityEquipmentSlot.HEAD, rupeeInfo));
        register(registry, new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, EntityEquipmentSlot.CHEST, rupeeInfo));
        register(registry, new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, EntityEquipmentSlot.LEGS, rupeeInfo));
        register(registry, new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, EntityEquipmentSlot.FEET, rupeeInfo));

        register(registry, new ItemDivineArmor(EnumArmor.RUPEE_RED, EntityEquipmentSlot.HEAD, rupeeInfo));
        register(registry, new ItemDivineArmor(EnumArmor.RUPEE_RED, EntityEquipmentSlot.CHEST, rupeeInfo));
        register(registry, new ItemDivineArmor(EnumArmor.RUPEE_RED, EntityEquipmentSlot.LEGS, rupeeInfo));
        register(registry, new ItemDivineArmor(EnumArmor.RUPEE_RED, EntityEquipmentSlot.FEET, rupeeInfo));

        register(registry, new ItemDivineArmor(EnumArmor.SHADOW, EntityEquipmentSlot.HEAD, shadowInfo));
        register(registry, new ItemDivineArmor(EnumArmor.SHADOW, EntityEquipmentSlot.CHEST, shadowInfo));
        register(registry, new ItemDivineArmor(EnumArmor.SHADOW, EntityEquipmentSlot.LEGS, shadowInfo));
        register(registry, new ItemDivineArmor(EnumArmor.SHADOW, EntityEquipmentSlot.FEET, shadowInfo));

        register(registry, new ItemDivineArmor(EnumArmor.SKELEMAN, EntityEquipmentSlot.HEAD, skelemanInfo));
        register(registry, new ItemDivineArmor(EnumArmor.SKELEMAN, EntityEquipmentSlot.CHEST, skelemanInfo));
        register(registry, new ItemDivineArmor(EnumArmor.SKELEMAN, EntityEquipmentSlot.LEGS, skelemanInfo));
        register(registry, new ItemDivineArmor(EnumArmor.SKELEMAN, EntityEquipmentSlot.FEET, skelemanInfo));

        register(registry, new ItemDivineArmor(EnumArmor.TERRAN, EntityEquipmentSlot.HEAD, terranInfo));
        register(registry, new ItemDivineArmor(EnumArmor.TERRAN, EntityEquipmentSlot.CHEST, terranInfo));
        register(registry, new ItemDivineArmor(EnumArmor.TERRAN, EntityEquipmentSlot.LEGS, terranInfo));
        register(registry, new ItemDivineArmor(EnumArmor.TERRAN, EntityEquipmentSlot.FEET, terranInfo));

        register(registry, new ItemDivineArmor(EnumArmor.WITHER_REAPER, EntityEquipmentSlot.HEAD, witherReaperInfo));
        register(registry, new ItemDivineArmor(EnumArmor.WITHER_REAPER, EntityEquipmentSlot.CHEST, witherReaperInfo));
        register(registry, new ItemDivineArmor(EnumArmor.WITHER_REAPER, EntityEquipmentSlot.LEGS, witherReaperInfo));
        register(registry, new ItemDivineArmor(EnumArmor.WITHER_REAPER, EntityEquipmentSlot.FEET, witherReaperInfo));

        // Iceika dimension armor
        register(registry, new ItemDivineArmor("santa_boots", EnumArmor.SANTA, EntityEquipmentSlot.FEET, santaInfo));
        register(registry, new ItemDivineArmor("santa_pants", EnumArmor.SANTA, EntityEquipmentSlot.LEGS, santaInfo));
        register(registry, new ItemDivineArmor("santa_tunic", EnumArmor.SANTA, EntityEquipmentSlot.CHEST, santaInfo));
        register(registry, new ItemDivineArmor("santa_cap", EnumArmor.SANTA, EntityEquipmentSlot.HEAD, santaInfo));

        // Twilight armor
        register(registry, new ItemDivineArmor(EnumArmor.EDEN, EntityEquipmentSlot.HEAD, edenInfo));
        register(registry, new ItemDivineArmor(EnumArmor.EDEN, EntityEquipmentSlot.CHEST, edenInfo));
        register(registry, new ItemDivineArmor(EnumArmor.EDEN, EntityEquipmentSlot.LEGS, edenInfo));
        register(registry, new ItemDivineArmor(EnumArmor.EDEN, EntityEquipmentSlot.FEET, edenInfo));

        register(registry, new ItemDivineArmor(EnumArmor.WILD, EntityEquipmentSlot.HEAD, wildInfo));
        register(registry, new ItemDivineArmor(EnumArmor.WILD, EntityEquipmentSlot.CHEST, wildInfo));
        register(registry, new ItemDivineArmor(EnumArmor.WILD, EntityEquipmentSlot.LEGS, wildInfo));
        register(registry, new ItemDivineArmor(EnumArmor.WILD, EntityEquipmentSlot.FEET, wildInfo));

        register(registry, new ItemDivineArmor(EnumArmor.APALACHIA, EntityEquipmentSlot.HEAD, apInfo));
        register(registry, new ItemDivineArmor(EnumArmor.APALACHIA, EntityEquipmentSlot.CHEST, apInfo));
        register(registry, new ItemDivineArmor(EnumArmor.APALACHIA, EntityEquipmentSlot.LEGS, apInfo));
        register(registry, new ItemDivineArmor(EnumArmor.APALACHIA, EntityEquipmentSlot.FEET, apInfo));

        register(registry, new ItemDivineArmor(EnumArmor.SKYTHERN, EntityEquipmentSlot.HEAD, skyInfo));
        register(registry, new ItemDivineArmor(EnumArmor.SKYTHERN, EntityEquipmentSlot.CHEST, skyInfo));
        register(registry, new ItemDivineArmor(EnumArmor.SKYTHERN, EntityEquipmentSlot.LEGS, skyInfo));
        register(registry, new ItemDivineArmor(EnumArmor.SKYTHERN, EntityEquipmentSlot.FEET, skyInfo));

        register(registry, new ItemDivineArmor(EnumArmor.MORTUM, EntityEquipmentSlot.HEAD, mortInfo));
        register(registry, new ItemDivineArmor(EnumArmor.MORTUM, EntityEquipmentSlot.CHEST, mortInfo));
        register(registry, new ItemDivineArmor(EnumArmor.MORTUM, EntityEquipmentSlot.LEGS, mortInfo));
        register(registry, new ItemDivineArmor(EnumArmor.MORTUM, EntityEquipmentSlot.FEET, mortInfo));

        register(registry, new ItemDivineArmor(EnumArmor.HALITE, EntityEquipmentSlot.HEAD, halInfo));
        register(registry, new ItemDivineArmor(EnumArmor.HALITE, EntityEquipmentSlot.CHEST, halInfo));
        register(registry, new ItemDivineArmor(EnumArmor.HALITE, EntityEquipmentSlot.LEGS, halInfo));
        register(registry, new ItemDivineArmor(EnumArmor.HALITE, EntityEquipmentSlot.FEET, halInfo));

        register(registry, new ItemDivineArmor(EnumArmor.AWAKENED_HALITE, EntityEquipmentSlot.HEAD, awakened_halInfo));
        register(registry, new ItemDivineArmor(EnumArmor.AWAKENED_HALITE, EntityEquipmentSlot.CHEST, awakened_halInfo));
        register(registry, new ItemDivineArmor(EnumArmor.AWAKENED_HALITE, EntityEquipmentSlot.LEGS, awakened_halInfo));
        register(registry, new ItemDivineArmor(EnumArmor.AWAKENED_HALITE, EntityEquipmentSlot.FEET, awakened_halInfo));

        // Arcana armor sets
        register(registry, new ItemDivineArmor(EnumArmor.KORMA, EntityEquipmentSlot.HEAD, kormInfo));
        register(registry, new ItemDivineArmor(EnumArmor.KORMA, EntityEquipmentSlot.CHEST, kormInfo));
        register(registry, new ItemDivineArmor(EnumArmor.KORMA, EntityEquipmentSlot.LEGS, kormInfo));
        register(registry, new ItemDivineArmor(EnumArmor.KORMA, EntityEquipmentSlot.FEET, kormInfo));

        register(registry, new ItemDivineArmor(EnumArmor.VEMOS, EntityEquipmentSlot.HEAD, vemInfo));
        register(registry, new ItemDivineArmor(EnumArmor.VEMOS, EntityEquipmentSlot.CHEST, vemInfo));
        register(registry, new ItemDivineArmor(EnumArmor.VEMOS, EntityEquipmentSlot.LEGS, vemInfo));
        register(registry, new ItemDivineArmor(EnumArmor.VEMOS, EntityEquipmentSlot.FEET, vemInfo));

        // Vethea armor sets
        register(registry, new ItemDivineArmor("degraded_helmet", EnumArmor.DEGRADED, EntityEquipmentSlot.HEAD, basicHelmInfo));
        register(registry, new ItemDivineArmor("degraded_hood", EnumArmor.DEGRADED, EntityEquipmentSlot.HEAD, basicHoodInfo));
        register(registry, new ItemDivineArmor("degraded_mask", EnumArmor.DEGRADED, EntityEquipmentSlot.HEAD, basicMaskInfo));
        register(registry, new ItemDivineArmor(EnumArmor.DEGRADED, EntityEquipmentSlot.CHEST));
        register(registry, new ItemDivineArmor(EnumArmor.DEGRADED, EntityEquipmentSlot.LEGS));
        register(registry, new ItemDivineArmor(EnumArmor.DEGRADED, EntityEquipmentSlot.FEET));

        register(registry, new ItemDivineArmor("finished_helmet", EnumArmor.FINISHED, EntityEquipmentSlot.HEAD, basicHelmInfo));
        register(registry, new ItemDivineArmor("finished_hood", EnumArmor.FINISHED, EntityEquipmentSlot.HEAD, basicHoodInfo));
        register(registry, new ItemDivineArmor("finished_mask", EnumArmor.FINISHED, EntityEquipmentSlot.HEAD, basicMaskInfo));
        register(registry, new ItemDivineArmor(EnumArmor.FINISHED, EntityEquipmentSlot.CHEST));
        register(registry, new ItemDivineArmor(EnumArmor.FINISHED, EntityEquipmentSlot.LEGS));
        register(registry, new ItemDivineArmor(EnumArmor.FINISHED, EntityEquipmentSlot.FEET));

        register(registry, new ItemDivineArmor("glistening_helmet", EnumArmor.GLISTENING, EntityEquipmentSlot.HEAD, glisteningHelmInfo));
        register(registry, new ItemDivineArmor("glistening_hood", EnumArmor.GLISTENING, EntityEquipmentSlot.HEAD, glisteningHoodInfo));
        register(registry, new ItemDivineArmor("glistening_mask", EnumArmor.GLISTENING, EntityEquipmentSlot.HEAD, glisteningMaskInfo));
        register(registry, new ItemDivineArmor(EnumArmor.GLISTENING, EntityEquipmentSlot.CHEST));
        register(registry, new ItemDivineArmor(EnumArmor.GLISTENING, EntityEquipmentSlot.LEGS));
        register(registry, new ItemDivineArmor(EnumArmor.GLISTENING, EntityEquipmentSlot.FEET));

        register(registry, new ItemDivineArmor("demonized_helmet", EnumArmor.DEMONIZED, EntityEquipmentSlot.HEAD, demonizedHelmInfo));
        register(registry, new ItemDivineArmor("demonized_hood", EnumArmor.DEMONIZED, EntityEquipmentSlot.HEAD, demonizedHoodInfo));
        register(registry, new ItemDivineArmor("demonized_mask", EnumArmor.DEMONIZED, EntityEquipmentSlot.HEAD, demonizedMaskInfo));
        register(registry, new ItemDivineArmor(EnumArmor.DEMONIZED, EntityEquipmentSlot.CHEST));
        register(registry, new ItemDivineArmor(EnumArmor.DEMONIZED, EntityEquipmentSlot.LEGS));
        register(registry, new ItemDivineArmor(EnumArmor.DEMONIZED, EntityEquipmentSlot.FEET));

        register(registry, new ItemDivineArmor("tormented_helmet", EnumArmor.TORMENTED, EntityEquipmentSlot.HEAD, tormentedHelmInfo));
        register(registry, new ItemDivineArmor("tormented_hood", EnumArmor.TORMENTED, EntityEquipmentSlot.HEAD, tormentedHoodInfo));
        register(registry, new ItemDivineArmor("tormented_mask", EnumArmor.TORMENTED, EntityEquipmentSlot.HEAD, tormentedMaskInfo));
        register(registry, new ItemDivineArmor(EnumArmor.TORMENTED, EntityEquipmentSlot.CHEST));
        register(registry, new ItemDivineArmor(EnumArmor.TORMENTED, EntityEquipmentSlot.LEGS));
        register(registry, new ItemDivineArmor(EnumArmor.TORMENTED, EntityEquipmentSlot.FEET));

        register(registry, new KingArmorItem(EnumArmor.KING, EntityEquipmentSlot.HEAD, kingInfo));
        register(registry, new KingArmorItem(EnumArmor.KING, EntityEquipmentSlot.CHEST, kingInfo));
        register(registry, new KingArmorItem(EnumArmor.KING, EntityEquipmentSlot.LEGS, kingInfo));
        register(registry, new KingArmorItem(EnumArmor.KING, EntityEquipmentSlot.FEET, kingInfo));
    }

    private static void register(IForgeRegistry<Item> registry, Item item) {
        registry.register(item);
        ModItems.itemMap.put(item.getRegistryName().getResourcePath(), item);
    }
}
