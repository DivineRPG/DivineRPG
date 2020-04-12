package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.enums.*;
import divinerpg.objects.entities.entity.arcana.EntityFyracryx;
import divinerpg.objects.entities.entity.arcana.EntityGolemOfRejuvenation;
import divinerpg.objects.entities.entity.arcana.EntityParatiku;
import divinerpg.objects.entities.entity.arcana.EntitySeimer;
import divinerpg.objects.entities.entity.projectiles.EntitySoundOfCarols;
import divinerpg.objects.entities.entity.projectiles.EntitySoundOfMusic;
import divinerpg.objects.entities.entity.twilight.*;
import divinerpg.objects.entities.entity.vanilla.*;
import divinerpg.objects.items.arcana.*;
import divinerpg.objects.items.base.*;
import divinerpg.objects.items.iceika.ItemEggNog;
import divinerpg.objects.items.iceika.ItemMusicShooter;
import divinerpg.objects.items.iceika.ItemSerenadeOfIce;
import divinerpg.objects.items.iceika.ItemSnowGlobe;
import divinerpg.objects.items.twilight.*;
import divinerpg.objects.items.vanilla.*;
import divinerpg.objects.items.vethea.*;
import divinerpg.utils.ToolMaterialMod;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.DimensionType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.Objects;

import static divinerpg.utils.LocalizeUtils.getArmorAbility;

@Mod.EventBusSubscriber
@ObjectHolder("divinerpg")
public class ModItems {
    public static ArrayList<Item> itemList = new ArrayList<Item>();

    // Vanilla dimension weapons
    @ObjectHolder("aquatic_maul")
    public static final Item aquaticMaul = null;
    @ObjectHolder("aquatic_dagger")
    public static final Item aquaticDagger = null;
    @ObjectHolder("aquatic_trident")
    public static final Item aquaticTrident = null;
    @ObjectHolder("aquaton")
    public static final Item aquaton = null;
    @ObjectHolder("aquatooth_maul")
    public static final Item aquatoothMaul = null;
    @ObjectHolder("aquatooth_sword")
    public static final Item aquatoothSword = null;
    @ObjectHolder("arlemite_stabber")
    public static final Item arlemiteStabber = null;
    @ObjectHolder("bedrock_maul")
    public static final Item bedrockMaul = null;
    @ObjectHolder("bedrock_sword")
    public static final Item bedrockSword = null;
    @ObjectHolder("black_ender_sword")
    public static final Item blackEnderSword = null;
    @ObjectHolder("bloodgem_sword")
    public static final Item bloodgem_sword = null;
    @ObjectHolder("blue_divine_sword")
    public static final Item blueDivineSword = null;
    @ObjectHolder("blue_ender_sword")
    public static final Item blueEnderSword = null;
    @ObjectHolder("bluefire_sword")
    public static final Item bluefireSword = null;
    @ObjectHolder("corrupted_maul")
    public static final Item corruptedMaul = null;
    @ObjectHolder("crabclaw_maul")
    public static final Item crabclawMaul = null;
    @ObjectHolder("cyclopsian_sword")
    public static final Item cyclopsianSword = null;
    @ObjectHolder("death_bringer")
    public static final Item deathBringer = null;
    @ObjectHolder("divine_sword")
    public static final Item divineSword = null;
    @ObjectHolder("dual_claw")
    public static final Item dualClaw = null;
    @ObjectHolder("ender_sword")
    public static final Item enderSword = null;
    @ObjectHolder("flaming_fury")
    public static final Item flamingFury = null;
    @ObjectHolder("frost_sword")
    public static final Item frostSword = null;
    @ObjectHolder("fury_maul")
    public static final Item furyMaul = null;
    @ObjectHolder("gray_divine_sword")
    public static final Item grayDivineSword = null;
    @ObjectHolder("green_divine_sword")
    public static final Item greenDivineSword = null;
    @ObjectHolder("green_ender_sword")
    public static final Item greenEnderSword = null;
    @ObjectHolder("inferno_sword")
    public static final Item infernoSword = null;
    @ObjectHolder("jungle_knife")
    public static final Item jungleKnife = null;
    @ObjectHolder("jungle_rapier")
    public static final Item jungleRapier = null;
    @ObjectHolder("molten_sword")
    public static final Item moltenSword = null;
    @ObjectHolder("ocean_knife")
    public static final Item oceanKnife = null;
    @ObjectHolder("poison_saber")
    public static final Item poisonSaber = null;
    @ObjectHolder("realmite_sword")
    public static final Item realmiteSword = null;
    @ObjectHolder("red_divine_sword")
    public static final Item redDivineSword = null;
    @ObjectHolder("red_ender_sword")
    public static final Item redEnderSword = null;
    @ObjectHolder("rupee_rapier")
    public static final Item rupeeRapier = null;
    @ObjectHolder("sandslash")
    public static final Item sandslash = null;
    @ObjectHolder("scorching_sword")
    public static final Item scorchingSword = null;
    @ObjectHolder("shark_sword")
    public static final Item sharkSword = null;
    @ObjectHolder("slime_sword")
    public static final Item slimeSword = null;
    @ObjectHolder("terran_dagger")
    public static final Item terranDagger = null;
    @ObjectHolder("terran_knife")
    public static final Item terranKnife = null;
    @ObjectHolder("terran_maul")
    public static final Item terranMaul = null;
    @ObjectHolder("yellow_divine_sword")
    public static final Item yellowDivineSword = null;
    @ObjectHolder("yellow_ender_sword")
    public static final Item yellowEnderSword = null;

    @ObjectHolder("bluefire_bow")
    public static final Item bluefireBow = null;
    @ObjectHolder("ender_bow")
    public static final Item enderBow = null;
    @ObjectHolder("hunter_bow")
    public static final Item hunterBow = null;
    @ObjectHolder("inferno_bow")
    public static final Item infernoBow = null;
    @ObjectHolder("shadow_bow")
    public static final Item shadowBow = null;

    @ObjectHolder("scythe")
    public static final Item scythe = null;

    @ObjectHolder("shuriken")
    public static final Item shuriken = null;
    @ObjectHolder("vile_storm")
    public static final Item vileStorm = null;

    @ObjectHolder("bowhead_anchor")
    public static final Item bowheadAnchor = null;
    @ObjectHolder("bowhead_cannon")
    public static final Item bowheadCannon = null;
    @ObjectHolder("corrupted_cannon")
    public static final Item corruptedCannon = null;
    @ObjectHolder("crab_anchor")
    public static final Item crabAnchor = null;
    @ObjectHolder("crabclaw_cannon")
    public static final Item crabclawCannon = null;
    @ObjectHolder("cyclopsian_staff")
    public static final Item cyclopsianStaff = null;
    @ObjectHolder("frost_cannon")
    public static final Item frostCannon = null;
    @ObjectHolder("ghast_cannon")
    public static final Item ghastCannon = null;
    @ObjectHolder("golden_fury")
    public static final Item goldenFury = null;
    @ObjectHolder("liopleurodon_anchor")
    public static final Item liopleurodonAnchor = null;
    @ObjectHolder("maelstrom")
    public static final Item maelstrom = null;
    @ObjectHolder("shark_anchor")
    public static final Item sharkAnchor = null;

    @ObjectHolder("sound_of_music")
    public static final Item soundOfMusic = null;

    @ObjectHolder("serenade_of_death")
    public static final Item serenadeOfDeath = null;
    @ObjectHolder("serenade_of_health")
    public static final Item serenadeOfHealth = null;
    @ObjectHolder("serenade_of_infusion")
    public static final Item serenadeOfInfusion = null;
    @ObjectHolder("serenade_striker")
    public static final Item serenadeStriker = null;

    @ObjectHolder("massivence")
    public static final Item massivence = null;
    @ObjectHolder("palavence")
    public static final Item palavence = null;

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


    //DEAL WITH LATER
/*    public static final Item diamondHelmet = new ItemDivineArmor(EnumArmor.DIAMOND, EntityEquipmentSlot.HEAD);
    public static final Item diamondBody = new ItemDivineArmor(EnumArmor.DIAMOND, EntityEquipmentSlot.CHEST);
    public static final Item diamondLegs = new ItemDivineArmor(EnumArmor.DIAMOND, EntityEquipmentSlot.LEGS);
    public static final Item diamondBoots = new ItemDivineArmor(EnumArmor.DIAMOND, EntityEquipmentSlot.FEET);

    public static final Item ironHelmet = new ItemDivineArmor(EnumArmor.IRON, EntityEquipmentSlot.HEAD);
    public static final Item ironBody = new ItemDivineArmor(EnumArmor.IRON, EntityEquipmentSlot.CHEST);
    public static final Item ironLegs = new ItemDivineArmor(EnumArmor.IRON, EntityEquipmentSlot.LEGS);
    public static final Item ironBoots = new ItemDivineArmor(EnumArmor.IRON, EntityEquipmentSlot.FEET);

    public static final Item goldHelmet = new ItemDivineArmor("golden_helmet", EnumArmor.GOLD, EntityEquipmentSlot.HEAD);
    public static final Item goldBody = new ItemDivineArmor("golden_chestplate", EnumArmor.GOLD, EntityEquipmentSlot.CHEST);
    public static final Item goldLegs = new ItemDivineArmor("golden_leggings", EnumArmor.GOLD, EntityEquipmentSlot.LEGS);
    public static final Item goldBoots = new ItemDivineArmor("golden_boots", EnumArmor.GOLD, EntityEquipmentSlot.FEET);*/
    //END DEAL WITH LATER

    @ObjectHolder("arlemite_shovel")
    public static final Item arlemiteShovel = null;
    @ObjectHolder("arlemite_pickaxe")
    public static final Item arlemitePickaxe = null;
    @ObjectHolder("arlemite_axe")
    public static final Item arlemiteAxe = null;
    @ObjectHolder("arlemite_hoe")
    public static final Item arlemiteHoe = null;
    @ObjectHolder("arlemite_shickaxe")
    public static final Item arlemiteShickaxe = null;

    @ObjectHolder("bedrock_shovel")
    public static final Item bedrockShovel = null;
    @ObjectHolder("bedrock_pickaxe")
    public static final Item bedrockPickaxe = null;
    @ObjectHolder("bedrock_axe")
    public static final Item bedrockAxe = null;

    @ObjectHolder("corrupted_shovel")
    public static final Item corruptedShovel = null;
    @ObjectHolder("corrupted_pickaxe")
    public static final Item corruptedPickaxe = null;
    @ObjectHolder("corrupted_axe")
    public static final Item corruptedAxe = null;

    @ObjectHolder("divine_shovel")
    public static final Item divineShovel = null;
    @ObjectHolder("divine_pickaxe")
    public static final Item divinePickaxe = null;
    @ObjectHolder("divine_axe")
    public static final Item divineAxe = null;
    @ObjectHolder("divine_shickaxe")
    public static final Item divineShickaxe = null;

    @ObjectHolder("realmite_shovel")
    public static final Item realmiteShovel = null;
    @ObjectHolder("realmite_pickaxe")
    public static final Item realmitePickaxe = null;
    @ObjectHolder("realmite_axe")
    public static final Item realmiteAxe = null;
    @ObjectHolder("realmite_hoe")
    public static final Item realmiteHoe = null;

    @ObjectHolder("rupee_shovel")
    public static final Item rupeeShovel = null;
    @ObjectHolder("rupee_pickaxe")
    public static final Item rupeePickaxe = null;
    @ObjectHolder("rupee_axe")
    public static final Item rupeeAxe = null;
    @ObjectHolder("rupee_hoe")
    public static final Item rupeeHoe = null;
    @ObjectHolder("rupee_shickaxe")
    public static final Item rupeeShickaxe = null;

    // Teleportation crystal
    @ObjectHolder("teleportation_crystal")
    public static final Item teleportationCrystal = null;

    // Vanilla misc items

    // Shards
    @ObjectHolder("corrupted_shards")
    public static final Item corruptedShards = null;
    @ObjectHolder("divine_shards")
    public static final Item divineShards = null;
    @ObjectHolder("ender_shards")
    public static final Item enderShards = null;
    @ObjectHolder("ice_shards")
    public static final Item iceShards = null;
    @ObjectHolder("jungle_shards")
    public static final Item jungleShards = null;
    @ObjectHolder("molten_shards")
    public static final Item moltenShards = null;
    @ObjectHolder("terran_shards")
    public static final Item terranShards = null;

    // Stones
    @ObjectHolder("corrupted_stone")
    public static final Item corruptedStone = null;
    @ObjectHolder("divine_stone")
    public static final Item divineStone = null;
    @ObjectHolder("ender_stone")
    public static final Item enderStone = null;
    @ObjectHolder("ice_stone")
    public static final Item iceStone = null;
    @ObjectHolder("jungle_stone")
    public static final Item jungleStone = null;
    @ObjectHolder("molten_stone")
    public static final Item moltenStone = null;
    @ObjectHolder("shadow_stone")
    public static final Item shadowStone = null;
    @ObjectHolder("terran_stone")
    public static final Item terranStone = null;

    // Ingots
    @ObjectHolder("arlemite_ingot")
    public static final Item arlemiteIngot = null;
    @ObjectHolder("hellstone_ingot")
    public static final Item hellstoneIngot = null;
    @ObjectHolder("netherite_ingot")
    public static final Item netheriteIngot = null;
    @ObjectHolder("realmite_ingot")
    public static final Item realmiteIngot = null;
    @ObjectHolder("rupee_ingot")
    public static final Item rupeeIngot = null;
    @ObjectHolder("shadow_bar")
    public static final Item shadowBar = null;

    // Boss Spawners
    @ObjectHolder("call_of_the_watcher")
    public static final Item callOfTheWatcher = null;
    @ObjectHolder("horde_horn")
    public static final Item hordeHorn = null;
    @ObjectHolder("infernal_flame")
    public static final Item infernalFlame = null;
    @ObjectHolder("mysterious_clock")
    public static final Item mysteriousClock = null;
    @ObjectHolder("watching_eye")
    public static final Item watchingEye = null;

    // Ayeraco fragments
    @ObjectHolder("ayeraco_fragment_blue")
    public static final Item ayeracoFragmentBlue = null;
    @ObjectHolder("ayeraco_fragment_green")
    public static final Item ayeracoFragmentGreen = null;
    @ObjectHolder("ayeraco_fragment_purple")
    public static final Item ayeracoFragmentPurple = null;
    @ObjectHolder("ayeraco_fragment_red")
    public static final Item ayeracoFragmentRed = null;
    @ObjectHolder("ayeraco_fragment_yellow")
    public static final Item ayeracoFragmentYellow = null;

    // Diamond chunks
    @ObjectHolder("blue_diamond_chunk")
    public static final Item blueDiamondChunk = null;
    @ObjectHolder("gray_diamond_chunk")
    public static final Item grayDiamondChunk = null;
    @ObjectHolder("green_diamond_chunk")
    public static final Item greenDiamondChunk = null;
    @ObjectHolder("red_diamond_chunk")
    public static final Item redDiamondChunk = null;
    @ObjectHolder("yellow_diamond_chunk")
    public static final Item yellowDiamondChunk = null;

    // Pet spawn eggs
    @ObjectHolder("brown_grizzle_egg")
    public static final Item brownGrizzleEgg = null;
    @ObjectHolder("ehu_egg")
    public static final Item ehuEgg = null;
    @ObjectHolder("husk_egg")
    public static final Item huskEgg = null;
    @ObjectHolder("smelter_egg")
    public static final Item smelterEgg = null;
    @ObjectHolder("snapper_egg")
    public static final Item snapperEgg = null;
    @ObjectHolder("stone_golem_egg")
    public static final Item stoneGolemEgg = null;
    @ObjectHolder("white_grizzle_egg")
    public static final Item whiteGrizzleEgg = null;

    // Miscellaneous resources
    @ObjectHolder("aqua_ball")
    public static final Item aquaBall = null;
    @ObjectHolder("aquatic_blaze_rod")
    public static final Item aquaticBlazeRod = null;
    @ObjectHolder("aquatic_ingot")
    public static final Item aquaticIngot = null;
    @ObjectHolder("aquatic_pellets")
    public static final Item aquaticPellets = null;
    @ObjectHolder("bedrock_chunk")
    public static final Item bedrockChunk = null;
    @ObjectHolder("bloodgem")
    public static final Item bloodgem = null;
    @ObjectHolder("bluefire_stone")
    public static final Item bluefireStone = null;
    @ObjectHolder("corrupted_bullet")
    public static final Item corruptedBullet = null;
    @ObjectHolder("crab_claw")
    public static final Item crabClaw = null;
    @ObjectHolder("cyclops_eye")
    public static final Item cyclopsEye = null;
    @ObjectHolder("cyclops_eye_shards")
    public static final Item cyclopsEyeShards = null;
    @ObjectHolder("fury_fire")
    public static final Item furyFire = null;
    @ObjectHolder("healing_stone")
    public static final Item healingStone = null;
    @ObjectHolder("kraken_scale")
    public static final Item krakenScale = null;
    @ObjectHolder("kraken_skin")
    public static final Item krakenSkin = null;
    @ObjectHolder("legendary_ender_eye")
    public static final Item legendaryEnderEye = null;
    @ObjectHolder("liopleurodon_skull")
    public static final Item liopleurodonSkull = null;
    @ObjectHolder("liopleurodon_teeth")
    public static final Item liopleurodonTeeth = null;
    @ObjectHolder("netherite_chunk")
    public static final Item netheriteChunk = null;
    @ObjectHolder("pure_aquatic_pellets")
    public static final Item pureAquaticPellets = null;
    @ObjectHolder("purple_blaze")
    public static final Item purpleBlaze = null;
    @ObjectHolder("shadow_coins")
    public static final Item shadowCoins = null;
    @ObjectHolder("shark_fin")
    public static final Item sharkFin = null;
    @ObjectHolder("whale_fin")
    public static final Item whaleFin = null;

    // Iceika

    // Iceika dimension weapons - melee
    @ObjectHolder("enderice")
    public static final Item enderice = null;
    @ObjectHolder("frostking_sword")
    public static final Item frostkingSword = null;
    @ObjectHolder("frozen_maul")
    public static final Item frozenMaul = null;
    @ObjectHolder("glacier_sword")
    public static final Item glacierSword = null;
    @ObjectHolder("icicle_bane")
    public static final Item icicleBane = null;
    @ObjectHolder("icine_sword")
    public static final Item icineSword = null;
    @ObjectHolder("snowslash")
    public static final Item snowslash = null;
    @ObjectHolder("frossivence")
    public static final Item frossivence = null;

    // Iceika dimension weapons - ranged
    @ObjectHolder("icicle_bow")
    public static final Item icicleBow = null;
    @ObjectHolder("snowstorm_bow")
    public static final Item snowstormBow = null;

    @ObjectHolder("snowflake_shuriken")
    public static final Item snowflakeShuriken = null;

    @ObjectHolder("fractite_cannon")
    public static final Item fractiteCannon = null;
    @ObjectHolder("frostclaw_cannon")
    public static final Item frostclawCannon = null;

    @ObjectHolder("sound_of_carols")
    public static final Item soundOfCarols = null;

    @ObjectHolder("serenade_of_ice")
    public static final Item serenadeOfIce = null;

    // Iceika dimension armor
    @ObjectHolder("santa_cap")
    public static final Item santaCap = null;
    @ObjectHolder("santa_tunic")
    public static final Item santaTunic = null;
    @ObjectHolder("santa_pants")
    public static final Item santaPants = null;
    @ObjectHolder("santa_boots")
    public static final Item santaBoots = null;

    // Iceika misc
    @ObjectHolder("snowflake")
    public static final Item snowflake = null;

    // Iceika portal item
    @ObjectHolder("snow_globe")
    public static final Item snowGlobe = null;

    /*************************/

    // Foods
    @ObjectHolder("advanced_mushroom_stew")
    public static final Item advancedMushroomStew = null;
    @ObjectHolder("bacon")
    public static final Item bacon = null;
    @ObjectHolder("boiled_egg")
    public static final Item boiledEgg = null;
    @ObjectHolder("cheese")
    public static final Item cheese = null;
    @ObjectHolder("chicken_dinner")
    public static final Item chickenDinner = null;
    @ObjectHolder("chocolate_log")
    public static final Item chocolateLog = null;
    @ObjectHolder("donut")
    public static final Item donut = null;
    @ObjectHolder("egg_nog")
    public static final Item eggNog = null;
    @ObjectHolder("empowered_meat")
    public static final Item empoweredMeat = null;
    @ObjectHolder("enriched_magic_meat")
    public static final Item enrichedMagicMeat = null;
    @ObjectHolder("forbidden_fruit")
    public static final Item forbiddenFruit = null;
    @ObjectHolder("fruit_cake")
    public static final Item fruitCake = null;
    @ObjectHolder("hot_pumpkin_pie")
    public static final Item hotPumpkinPie = null;
    @ObjectHolder("magic_meat")
    public static final Item magicMeat = null;
    @ObjectHolder("moonbulb")
    public static final Item moonbulb = null;
    @ObjectHolder("peppermints")
    public static final Item peppermints = null;
    @ObjectHolder("pink_glowbone")
    public static final Item pinkGlowbone = null;
    @ObjectHolder("purple_glowbone")
    public static final Item purpleGlowbone = null;
    @ObjectHolder("raw_empowered_meat")
    public static final Item rawEmpoweredMeat = null;
    @ObjectHolder("sky_flower")
    public static final Item skyFlower = null;
    @ObjectHolder("snow_cones")
    public static final Item snowCones = null;
    @ObjectHolder("tomato")
    public static final Item tomato = null;
    @ObjectHolder("white_mushroom")
    public static final Item whiteMushroom = null;
    @ObjectHolder("winterberry")
    public static final Item winterberry = null;

    // Twilight Dimensions

    // Twilight souls
    @ObjectHolder("eden_soul")
    public static final Item edenSoul = null;
    @ObjectHolder("wildwood_soul")
    public static final Item wildwoodSoul = null;
    @ObjectHolder("apalachia_soul")
    public static final Item apalachiaSoul = null;
    @ObjectHolder("skythern_soul")
    public static final Item skythernSoul = null;
    @ObjectHolder("mortum_soul")
    public static final Item mortumSoul = null;

    // Twilight fragments
    @ObjectHolder("eden_fragments")
    public static final Item edenFragments = null;
    @ObjectHolder("wildwood_fragments")
    public static final Item wildwoodFragments = null;
    @ObjectHolder("apalachia_fragments")
    public static final Item apalachiaFragments = null;
    @ObjectHolder("skythern_fragments")
    public static final Item skythernFragments = null;
    @ObjectHolder("mortum_fragments")
    public static final Item mortumFragments = null;

    // Twilight gems
    @ObjectHolder("eden_gem")
    public static final Item edenGem = null;
    @ObjectHolder("wildwood_gem")
    public static final Item wildwoodGem = null;
    @ObjectHolder("apalachia_gem")
    public static final Item apalachiaGem = null;
    @ObjectHolder("skythern_gem")
    public static final Item skythernGem = null;
    @ObjectHolder("mortum_gem")
    public static final Item mortumGem = null;

    // Twilight chunks
    @ObjectHolder("eden_chunk")
    public static final Item edenChunk = null;
    @ObjectHolder("wildwood_chunk")
    public static final Item wildwoodChunk = null;
    @ObjectHolder("apalachia_chunk")
    public static final Item apalachiaChunk = null;
    @ObjectHolder("skythern_chunk")
    public static final Item skythernChunk = null;
    @ObjectHolder("mortum_chunk")
    public static final Item mortumChunk = null;

    // Twilight dust
    @ObjectHolder("eden_dust")
    public static final Item edenDust = null;
    @ObjectHolder("wildwood_dust")
    public static final Item wildwoodDust = null;
    @ObjectHolder("apalachia_dust")
    public static final Item apalachiaDust = null;
    @ObjectHolder("skythern_dust")
    public static final Item skythernDust = null;
    @ObjectHolder("mortum_dust")
    public static final Item mortumDust = null;

    // Twilight swords
    @ObjectHolder("eden_blade")
    public static final Item edenBlade = null;
    @ObjectHolder("wildwood_blade")
    public static final Item wildwoodBlade = null;
    @ObjectHolder("apalachia_blade")
    public static final Item apalachiaBlade = null;
    @ObjectHolder("skythern_blade")
    public static final Item skythernBlade = null;
    @ObjectHolder("mortum_blade")
    public static final Item mortumBlade = null;
    @ObjectHolder("halite_blade")
    public static final Item haliteBlade = null;

    // Twilight bows
    @ObjectHolder("eden_bow")
    public static final Item edenBow = null;
    @ObjectHolder("wildwood_bow")
    public static final Item wildwoodBow = null;
    @ObjectHolder("apalachia_bow")
    public static final Item apalachiaBow = null;
    @ObjectHolder("skythern_bow")
    public static final Item skythernBow = null;
    @ObjectHolder("mortum_bow")
    public static final Item mortumBow = null;
    @ObjectHolder("halite_bow")
    public static final Item haliteBow = null;
    @ObjectHolder("twilight_bow")
    public static final Item twilightBow = null;

    // Twilight slicers
    @ObjectHolder("eden_slicer")
    public static final Item edenSlicer = null;
    @ObjectHolder("wildwood_slicer")
    public static final Item wildwoodSlicer = null;
    @ObjectHolder("apalachia_slicer")
    public static final Item apalachiaSlicer = null;
    @ObjectHolder("skythern_slicer")
    public static final Item skythernSlicer = null;
    @ObjectHolder("mortum_slicer")
    public static final Item mortumSlicer = null;
    @ObjectHolder("halite_slicer")
    public static final Item haliteSlicer = null;

    // Twilight blitzes
    @ObjectHolder("eden_blitz")
    public static final Item edenBlitz = null;
    @ObjectHolder("wildwood_blitz")
    public static final Item wildwoodBlitz = null;
    @ObjectHolder("apalachia_blitz")
    public static final Item apalachiaBlitz = null;
    @ObjectHolder("skythern_blitz")
    public static final Item skythernBlitz = null;
    @ObjectHolder("mortum_blitz")
    public static final Item mortumBlitz = null;
    @ObjectHolder("halite_blitz")
    public static final Item haliteBlitz = null;

    // Twilight phasers
    @ObjectHolder("eden_phaser")
    public static final Item edenPhaser = null;
    @ObjectHolder("wildwood_phaser")
    public static final Item wildwoodPhaser = null;
    @ObjectHolder("apalachia_phaser")
    public static final Item apalachiaPhaser = null;
    @ObjectHolder("skythern_phaser")
    public static final Item skythernPhaser = null;
    @ObjectHolder("mortum_phaser")
    public static final Item mortumPhaser = null;
    @ObjectHolder("halite_phaser")
    public static final Item halitePhaser = null;

    // Twilight tools
    @ObjectHolder("eden_shovel")
    public static final Item edenShovel = null;
    @ObjectHolder("eden_pickaxe")
    public static final Item edenPickaxe = null;
    @ObjectHolder("eden_axe")
    public static final Item edenAxe = null;

    @ObjectHolder("wildwood_shovel")
    public static final Item wildwoodShovel = null;
    @ObjectHolder("wildwood_pickaxe")
    public static final Item wildwoodPickaxe = null;
    @ObjectHolder("wildwood_axe")
    public static final Item wildwoodAxe = null;

    @ObjectHolder("apalachia_shovel")
    public static final Item apalachiaShovel = null;
    @ObjectHolder("apalachia_pickaxe")
    public static final Item apalachiaPickaxe = null;
    @ObjectHolder("apalachia_axe")
    public static final Item apalachiaAxe = null;

    @ObjectHolder("skythern_shovel")
    public static final Item skythernShovel = null;
    @ObjectHolder("skythern_pickaxe")
    public static final Item skythernPickaxe = null;
    @ObjectHolder("skythern_axe")
    public static final Item skythernAxe = null;

    @ObjectHolder("mortum_shovel")
    public static final Item mortumShovel = null;
    @ObjectHolder("mortum_pickaxe")
    public static final Item mortumPickaxe = null;
    @ObjectHolder("mortum_axe")
    public static final Item mortumAxe = null;

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

    // Twilight boss spawners
    @ObjectHolder("densos_crystal")
    public static final Item densosCrystal = null;
    @ObjectHolder("eternal_archer_crystal")
    public static final Item eternalArcherCrystal = null;
    @ObjectHolder("karot_crystal")
    public static final Item karotCrystal = null;
    @ObjectHolder("reyvor_crystal")
    public static final Item reyvorCrystal = null;
    @ObjectHolder("soul_fiend_crystal")
    public static final Item soulFiendCrystal = null;
    @ObjectHolder("twilight_demon_crystal")
    public static final Item twilightDemonCrystal = null;
    @ObjectHolder("vamacheron_crystal")
    public static final Item vamacheronCrystal = null;

    // Twilight portal item
    @ObjectHolder("twilight_clock")
    public static final Item twilightClock = null;

    // Twilight arrows
    @ObjectHolder("eden_arrow")
    public static final Item edenArrow = null;
    @ObjectHolder("fury_arrow")
    public static final Item furyArrow = null;
    @ObjectHolder("wildwood_arrow")
    public static final Item wildwoodArrow = null;

    // Twilight miscellaneous
    @ObjectHolder("base_spawn_crystal")
    public static final Item baseSpawnCrystal = null;
    @ObjectHolder("eden_sparkles")
    public static final Item edenSparkles = null;

    // Arcana

    // Arcana melee
    @ObjectHolder("arcanite_blade")
    public static final Item arcaniteBlade = null;
    @ObjectHolder("arcanium_saber")
    public static final Item arcaniumSaber = null;
    @ObjectHolder("ender_scepter")
    public static final Item enderScepter = null;
    @ObjectHolder("livicia_sword")
    public static final Item liviciaSword = null;
    @ObjectHolder("shadow_saber")
    public static final Item shadowSaber = null;
    @ObjectHolder("storm_sword")
    public static final Item stormSword = null;

    // Arcana ranged
    @ObjectHolder("arcanite_blaster")
    public static final Item arcaniteBlaster = null;
    @ObjectHolder("captains_sparkler")
    public static final Item captainsSparkler = null;
    @ObjectHolder("firefly")
    public static final Item firefly = null;
    @ObjectHolder("generals_staff")
    public static final Item generalsStaff = null;
    @ObjectHolder("la_vekor")
    public static final Item laVekor = null;
    @ObjectHolder("meriks_missile")
    public static final Item meriksMissile = null;
    @ObjectHolder("meteor_mash")
    public static final Item meteorMash = null;
    @ObjectHolder("staff_of_starlight")
    public static final Item staffOfStarlight = null;
    @ObjectHolder("starlight")
    public static final Item starlight = null;

    // Arcana throwable
    @ObjectHolder("grenade")
    public static final Item grenade = null;

    // Arcana utility
    @ObjectHolder("arcanium_attractor")
    public static final Item arcaniumAttractor = null;
    @ObjectHolder("arcanium_reflector")
    public static final Item arcaniumReflector = null;
    @ObjectHolder("divine_accumulator")
    public static final Item divineAccumulator = null;
    @ObjectHolder("ghostbane")
    public static final Item ghostbane = null;
    @ObjectHolder("orb_of_light")
    public static final Item orbOfLight = null;
    @ObjectHolder("staff_of_enrichment")
    public static final Item staffOfEnrichment = null;
    @ObjectHolder("frozen_charge")
    public static final Item frozenCharge = null;

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

    // Arcana boss spawner
    @ObjectHolder("wizards_book")
    public static final Item wizardsBook = null;

    // Arcana pet spawners
    @ObjectHolder("fyracryx_egg")
    public static final Item fyracryxEgg = null;
    @ObjectHolder("golem_of_rejuvenation_egg")
    public static final Item golemOfRejuvenationEgg = null;
    @ObjectHolder("paratiku_egg")
    public static final Item paratikuEgg = null;
    @ObjectHolder("seimer_egg")
    public static final Item seimerEgg = null;

    // Arcana non-food crops

    // Arcana keys
    @ObjectHolder("ancient_key")
    public static final Item ancientKey = null;
    @ObjectHolder("degraded_key")
    public static final Item degradedKey = null;
    @ObjectHolder("sludge_key")
    public static final Item sludgeKey = null;
    @ObjectHolder("soul_key")
    public static final Item soulKey = null;

    // Arcana potions
    @ObjectHolder("strong_arcana_potion")
    public static final Item strongArcanaPotion = null;
    @ObjectHolder("weak_arcana_potion")
    public static final Item weakArcanaPotion = null;

    // Arcana crops
    @ObjectHolder("aquamarine")
    public static final Item aquamarine = null;
    @ObjectHolder("firestock")
    public static final Item firestock = null;
    @ObjectHolder("hitchak")
    public static final Item hitchak = null;
    @ObjectHolder("lamona")
    public static final Item lamona = null;
    @ObjectHolder("marsine")
    public static final Item marsine = null;
    @ObjectHolder("pinfly")
    public static final Item pinfly = null;
    @ObjectHolder("veilo")
    public static final Item veilo = null;

    //Doors
    @ObjectHolder("steel_door")
    public static final Item steelDoor = null;
    @ObjectHolder("ancient_brick_door")
    public static final Item ancientBrickDoor = null;
    @ObjectHolder("degraded_brick_door")
    public static final Item degradedBrickDoor = null;
    @ObjectHolder("soul_sludge_door")
    public static final Item soulSludgeDoor = null;
    @ObjectHolder("soul_stone_door")
    public static final Item soulStoneDoor = null;

    // Arcana miscellaneous
    @ObjectHolder("arcanium")
    public static final Item arcanium = null;
    @ObjectHolder("charged_collector")
    public static final Item chargedCollector = null;
    @ObjectHolder("collector")
    public static final Item collector = null;
    @ObjectHolder("dungeon_tokens")
    public static final Item dungeonTokens = null;

    //Seeds
    @ObjectHolder("aquamarine_seeds")
    public static final Item aquamarineSeeds = null;
    @ObjectHolder("eucalyptus_root_seeds")
    public static final Item eucalyptusRootSeeds = null;
    @ObjectHolder("firestock_seeds")
    public static final Item firestockSeeds = null;
    @ObjectHolder("hitchak_seeds")
    public static final Item hitchakSeeds = null;
    @ObjectHolder("lamona_seeds")
    public static final Item lamonaSeeds = null;
    @ObjectHolder("marsine_seeds")
    public static final Item marsineSeeds = null;
    @ObjectHolder("moonbulb_seeds")
    public static final Item moonbulbSeeds = null;
    @ObjectHolder("pinfly_seeds")
    public static final Item pinflySeeds = null;
    @ObjectHolder("pink_glowbone_seeds")
    public static final Item pinkGlowboneSeeds = null;
    @ObjectHolder("purple_glowbone_seeds")
    public static final Item purpleGlowboneSeeds = null;
    @ObjectHolder("sky_plant_seeds")
    public static final Item skyPlantSeeds = null;
    @ObjectHolder("tomato_seeds")
    public static final Item tomatoSeeds = null;
    @ObjectHolder("veilo_seeds")
    public static final Item veiloSeeds = null;
    @ObjectHolder("white_mushroom_seeds")
    public static final Item whiteMushroomSeeds = null;

    // Vethea
    // Vethea pearls
    @ObjectHolder("dirty_pearls")
    public static final Item dirtyPearls = null;
    @ObjectHolder("clean_pearls")
    public static final Item cleanPearls = null;
    @ObjectHolder("polished_pearls")
    public static final Item polishedPearls = null;
    @ObjectHolder("shiny_pearls")
    public static final Item shinyPearls = null;

    // Vethea lumps
    @ObjectHolder("teaker_lump")
    public static final Item teakerLump = null;
    @ObjectHolder("amthirmis_lump")
    public static final Item amthirmisLump = null;
    @ObjectHolder("darven_lump")
    public static final Item darvenLump = null;
    @ObjectHolder("cermile_lump")
    public static final Item cermileLump = null;
    @ObjectHolder("pardimal_lump")
    public static final Item pardimalLump = null;
    @ObjectHolder("quadrotic_lump")
    public static final Item quadroticLump = null;
    @ObjectHolder("karos_lump")
    public static final Item karosLump = null;
    @ObjectHolder("heliosis_lump")
    public static final Item heliosisLump = null;
    @ObjectHolder("arksiane_lump")
    public static final Item arksianeLump = null;


    // Vethea templates
    @ObjectHolder("backsword_template")
    public static final Item backswordTemplate = null;
    @ObjectHolder("bow_template")
    public static final Item bowTemplate = null;
    @ObjectHolder("cannon_template")
    public static final Item cannonTemplate = null;
    @ObjectHolder("claw_template")
    public static final Item clawTemplate = null;
    @ObjectHolder("disk_template")
    public static final Item diskTemplate = null;
    @ObjectHolder("hammer_template")
    public static final Item hammerTemplate = null;
    @ObjectHolder("staff_template")
    public static final Item staffTemplate = null;

    @ObjectHolder("degraded_template")
    public static final Item degradedTemplate = null;
    @ObjectHolder("finished_template")
    public static final Item finishedTemplate = null;
    @ObjectHolder("glistening_template")
    public static final Item glisteningTemplate = null;
    @ObjectHolder("demonized_template")
    public static final Item demonizedTemplate = null;
    @ObjectHolder("tormented_template")
    public static final Item tormentedTemplate = null;

    // Vethea food
    @ObjectHolder("dream_carrot")
    public static final Item dreamCarrot = null;
    @ObjectHolder("dream_melon")
    public static final Item dreamMelon = null;
    @ObjectHolder("dream_pie")
    public static final Item dreamPie = null;
    @ObjectHolder("dream_cake")
    public static final Item dreamCake = null;
    @ObjectHolder("dream_sweets")
    public static final Item dreamSweets = null;
    @ObjectHolder("dream_sours")
    public static final Item dreamSours = null;
    @ObjectHolder("honeysuckle")
    public static final Item honeysuckle = null;
    @ObjectHolder("honeychunk")
    public static final Item honeychunk = null;

    // Vethea boss spawners
    @ObjectHolder("dream_flint")
    public static final Item dreamFlint = null;
    @ObjectHolder("moon_clock")
    public static final Item moonClock = null;

    // Vethea weapons
    // Backsword
    @ObjectHolder("teaker_backsword")
    public static final Item teakerBacksword = null;
    @ObjectHolder("amthirmis_backsword")
    public static final Item amthirmisBacksword = null;
    @ObjectHolder("darven_backsword")
    public static final Item darvenBacksword = null;
    @ObjectHolder("cermile_backsword")
    public static final Item cermileBacksword = null;
    @ObjectHolder("pardimal_backsword")
    public static final Item pardimalBacksword = null;
    @ObjectHolder("quadrotic_backsword")
    public static final Item quadroticBacksword = null;
    @ObjectHolder("karos_backsword")
    public static final Item karosBacksword = null;
    @ObjectHolder("heliosis_backsword")
    public static final Item heliosisBacksword = null;
    @ObjectHolder("arksiane_backsword")
    public static final Item arksianeBacksword = null;

    // Bow
    @ObjectHolder("teaker_bow")
    public static final Item teakerBow = null;
    @ObjectHolder("amthirmis_bow")
    public static final Item amthirmisBow = null;
    @ObjectHolder("darven_bow")
    public static final Item darvenBow = null;
    @ObjectHolder("cermile_bow")
    public static final Item cermileBow = null;
    @ObjectHolder("pardimal_bow")
    public static final Item pardimalBow = null;
    @ObjectHolder("quadrotic_bow")
    public static final Item quadroticBow = null;
    @ObjectHolder("karos_bow")
    public static final Item karosBow = null;
    @ObjectHolder("heliosis_bow")
    public static final Item heliosisBow = null;
    @ObjectHolder("arksiane_bow")
    public static final Item arksianeBow = null;
    @ObjectHolder("everfright")
    public static final Item everfright = null;

    // Cannon
    @ObjectHolder("teaker_cannon")
    public static final Item teakerCannon = null;
    @ObjectHolder("amthirmis_cannon")
    public static final Item amthirmisCannon = null;
    @ObjectHolder("darven_cannon")
    public static final Item darvenCannon = null;
    @ObjectHolder("cermile_cannon")
    public static final Item cermileCannon = null;
    @ObjectHolder("pardimal_cannon")
    public static final Item pardimalCannon = null;
    @ObjectHolder("quadrotic_cannon")
    public static final Item quadroticCannon = null;
    @ObjectHolder("karos_cannon")
    public static final Item karosCannon = null;
    @ObjectHolder("heliosis_cannon")
    public static final Item heliosisCannon = null;
    @ObjectHolder("arksiane_cannon")
    public static final Item arksianeCannon = null;
    @ObjectHolder("eversight")
    public static final Item eversight = null;

    // Claw
    @ObjectHolder("teaker_claw")
    public static final Item teakerClaw = null;
    @ObjectHolder("amthirmis_claw")
    public static final Item amthirmisClaw = null;
    @ObjectHolder("darven_claw")
    public static final Item darvenClaw = null;
    @ObjectHolder("cermile_claw")
    public static final Item cermileClaw = null;
    @ObjectHolder("pardimal_claw")
    public static final Item pardimalClaw = null;
    @ObjectHolder("quadrotic_claw")
    public static final Item quadroticClaw = null;
    @ObjectHolder("karos_claw")
    public static final Item karosClaw = null;
    @ObjectHolder("heliosis_claw")
    public static final Item heliosisClaw = null;
    @ObjectHolder("arksiane_claw")
    public static final Item arksianeClaw = null;
    @ObjectHolder("everbright")
    public static final Item everbright = null;

    // Disk
    @ObjectHolder("teaker_disk")
    public static final Item teakerDisk = null;
    @ObjectHolder("amthirmis_disk")
    public static final Item amthirmisDisk = null;
    @ObjectHolder("darven_disk")
    public static final Item darvenDisk = null;
    @ObjectHolder("cermile_disk")
    public static final Item cermileDisk = null;
    @ObjectHolder("pardimal_disk")
    public static final Item pardimalDisk = null;
    @ObjectHolder("quadrotic_disk")
    public static final Item quadroticDisk = null;
    @ObjectHolder("karos_disk")
    public static final Item karosDisk = null;
    @ObjectHolder("heliosis_disk")
    public static final Item heliosisDisk = null;
    @ObjectHolder("arksiane_disk")
    public static final Item arksianeDisk = null;

    // Hammer
    @ObjectHolder("teaker_hammer")
    public static final Item teakerHammer = null;
    @ObjectHolder("amthirmis_hammer")
    public static final Item amthirmisHammer = null;
    @ObjectHolder("darven_hammer")
    public static final Item darvenHammer = null;
    @ObjectHolder("cermile_hammer")
    public static final Item cermileHammer = null;
    @ObjectHolder("pardimal_hammer")
    public static final Item pardimalHammer = null;
    @ObjectHolder("quadrotic_hammer")
    public static final Item quadroticHammer = null;
    @ObjectHolder("karos_hammer")
    public static final Item karosHammer = null;
    @ObjectHolder("heliosis_hammer")
    public static final Item heliosisHammer = null;
    @ObjectHolder("arksiane_hammer")
    public static final Item arksianeHammer = null;
    @ObjectHolder("everlight")
    public static final Item everlight = null;
    @ObjectHolder("karos_rockmaul")
    public static final Item karosRockmaul = null;

    // Staff
    @ObjectHolder("teaker_staff")
    public static final Item teakerStaff = null;
    @ObjectHolder("amthirmis_staff")
    public static final Item amthirmisStaff = null;
    @ObjectHolder("darven_staff")
    public static final Item darvenStaff = null;
    @ObjectHolder("cermile_staff")
    public static final Item cermileStaff = null;
    @ObjectHolder("pardimal_staff")
    public static final Item pardimalStaff = null;
    @ObjectHolder("quadrotic_staff")
    public static final Item quadroticStaff = null;
    @ObjectHolder("karos_staff")
    public static final Item karosStaff = null;
    @ObjectHolder("heliosis_staff")
    public static final Item heliosisStaff = null;
    @ObjectHolder("arksiane_staff")
    public static final Item arksianeStaff = null;
    @ObjectHolder("evernight")
    public static final Item evernight = null;

    // Vethea arrows
    @ObjectHolder("teaker_arrow")
    public static final Item teakerArrow = null;
    @ObjectHolder("darven_arrow")
    public static final Item darvenArrow = null;
    @ObjectHolder("pardimal_arrow")
    public static final Item pardimalArrow = null;
    @ObjectHolder("karos_arrow")
    public static final Item karosArrow = null;
    @ObjectHolder("ever_arrow")
    public static final Item everArrow = null;

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

    // Vethea portal item
    @ObjectHolder("nightmare_bed")
    public static final Item nightmareBed = null;

    // Vethea door
    @ObjectHolder("barred_door")
    public static final Item barredDoor = null;

    // Vethea miscellaneous
    @ObjectHolder("acid")
    public static final Item acid = null;
    @ObjectHolder("band_of_heiva_hunting")
    public static final Item bandOfHeivaHunting = null;
    @ObjectHolder("miners_amulet")
    public static final Item minersAmulet = null;
    @ObjectHolder("rock_chunks")
    public static final Item rockChunks = null;

    //Slabs
    @ObjectHolder("eden_slab")
    public static final Item edenSlab = null;
    @ObjectHolder("wildwood_slab")
    public static final Item wildwoodSlab = null;
    @ObjectHolder("apalachia_slab")
    public static final Item apalachiaSlab = null;
    @ObjectHolder("skythern_slab")
    public static final Item skythernSlab = null;
    @ObjectHolder("mortum_slab")
    public static final Item mortumSlab = null;
    @ObjectHolder("divine_slab")
    public static final Item divineSlab = null;
    @ObjectHolder("frozen_slab")
    public static final Item frozenSlab = null;
    @ObjectHolder("eucalyptus_slab")
    public static final Item eucalyptusSlab = null;

    // shields
    @ObjectHolder("realmite_shield")
    public static final Item realmite_shield = null;
    @ObjectHolder("arlemite_shield")
    public static final Item arlemite_shield = null;

    // Armor information
    // Vanilla dimensions
    private static ArmorInfo angelicInfo = new ArmorInfo(getArmorAbility("no_fall"), getArmorAbility("fly"));
    private static ArmorInfo aquastriveInfo = new ArmorInfo(getArmorAbility("underwater"), getArmorAbility("swim"));
    private static ArmorInfo arlemiteInfo = new ArmorInfo(getArmorAbility("ranged_protection", 85));
    private static ArmorInfo bedrockInfo = new ArmorInfo(getArmorAbility("fire_protection"), getArmorAbility("explosion_protection"));
    private static ArmorInfo corruptedInfo = new ArmorInfo(getArmorAbility("ranged_damage", 20));
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
    private static ArmorInfo shadowInfo = new ArmorInfo(getArmorAbility("speed", 3));
    private static ArmorInfo skelemanInfo = new ArmorInfo(getArmorAbility("hunger"));
    private static ArmorInfo terranInfo = new ArmorInfo(getArmorAbility("haste"));
    private static ArmorInfo witherReaperInfo = new ArmorInfo(getArmorAbility("wither_protection"));

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
        DivineRPG.logger.info("Registering DivineRPG items");

        IForgeRegistry<Item> registry = event.getRegistry();

        // Vanilla dimension weapons
        register(registry, new ItemModSword(ToolMaterialMod.AquaDagger, "aquatic_dagger"));
        register(registry, new ItemModSword(ToolMaterialMod.AquaMaul, "aquatic_maul"));
        register(registry, new ItemModSword(ToolMaterialMod.AquaTrident, "aquatic_trident"));
        register(registry, new ItemModSword(ToolMaterialMod.Aquaton, "aquaton"));
        register(registry, new ItemModSword(ToolMaterialMod.AquatoothMaul, "aquatooth_maul"));
        register(registry, new ItemModSword(ToolMaterialMod.AquatoothSword, "aquatooth_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.Arlemite, "arlemite_stabber"));
        register(registry, new ItemModSword(ToolMaterialMod.Bedrock, "bedrock_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.BedrockMaul, "bedrock_maul"));
        register(registry, new ItemModSword(ToolMaterialMod.Bloodgem, "bloodgem_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.Bluefire, "bluefire_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.CorruptedMaul, "corrupted_maul"));
        register(registry, new ItemModSword(ToolMaterialMod.CrabclawMaul, "crabclaw_maul"));
        register(registry, new ItemModSword(ToolMaterialMod.Cyclops, "cyclopsian_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.DeathBringer, "death_bringer"));
        register(registry, new ItemModSword(ToolMaterialMod.Divine, "blue_divine_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.Divine, "divine_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.Divine, "gray_divine_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.Divine, "green_divine_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.Divine, "red_divine_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.Divine, "yellow_divine_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.DualClaw, "dual_claw"));
        register(registry, new ItemModSword(ToolMaterialMod.Ender, "black_ender_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.Ender, "blue_ender_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.Ender, "ender_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.Ender, "green_ender_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.Ender, "red_ender_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.Ender, "yellow_ender_sword"));
        register(registry, new ItemSlowingSword(ToolMaterialMod.Frost, "frost_sword"));
        register(registry, new ItemBurningSword(ToolMaterialMod.FlamingFury, "flaming_fury", 15));
        register(registry, new ItemModSword(ToolMaterialMod.FuryMaul, "fury_maul"));
        register(registry, new ItemBurningSword(ToolMaterialMod.Inferno, "inferno_sword", 12));
        register(registry, new ItemPoisonousSword(ToolMaterialMod.JungleKnife, "jungle_knife", 2.5f));
        register(registry, new ItemPoisonousSword(ToolMaterialMod.JungleRapier, "jungle_rapier", 4f));
        register(registry, new ItemBurningSword(ToolMaterialMod.Molten, "molten_sword", 5));
        register(registry, new ItemModSword(ToolMaterialMod.OceanKnife, "ocean_knife"));
        register(registry, new ItemPoisonousSword(ToolMaterialMod.PoisonSaber, "poison_saber", 5));
        register(registry, new ItemModSword(ToolMaterialMod.Realmite, "realmite_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.Rupee, "rupee_rapier"));
        register(registry, new ItemModSword(ToolMaterialMod.Sandslash, "sandslash"));
        register(registry, new ItemModSword(ToolMaterialMod.Scorching, "scorching_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.Shark, "shark_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.Slime, "slime_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.TerranDagger, "terran_dagger"));
        register(registry, new ItemModSword(ToolMaterialMod.TerranKnife, "terran_knife"));
        register(registry, new ItemModSword(ToolMaterialMod.TerranMaul, "terran_maul"));

        register(registry, new ItemModBow("bluefire_bow", ArrowType.BLUEFIRE_ARROW, -1));
        register(registry, new ItemModBow("ender_bow", ArrowType.ENDER_ARROW, -1));
        register(registry, new ItemModBow("hunter_bow", ArrowType.HUNTER_ARROW, 2500, () -> Items.ARROW));
        register(registry, new ItemModBow("inferno_bow", ArrowType.INFERNO_ARROW, 10000));
        register(registry, new ItemModBow("shadow_bow", ArrowType.SHADOW_ARROW, 10000, 36000, () -> Items.ARROW));

        register(registry, new ItemScythe("scythe"));

        register(registry, new ItemThrowable("shuriken", BulletType.SHURIKEN_SHOT));
        register(registry, new ItemVileStorm("vile_storm"));

        register(registry, new ItemAnchor("bowhead_anchor", BulletType.BOWHEAD_ANCHOR_SHOT));
        register(registry, new RangedWeaponBase("bowhead_cannon", BulletType.BOWHEAD_CANNON_SHOT, ModSounds.GHAST_CANNON, () -> Item.getItemFromBlock(Blocks.CACTUS), 1000, 12));
        register(registry, new ItemCorruptedCannon("corrupted_cannon"));
        register(registry, new ItemAnchor("crab_anchor", BulletType.CRAB_ANCHOR_SHOT));
        register(registry, new RangedWeaponBase("crabclaw_cannon", BulletType.CRABCLAW_CANNON_SHOT, ModSounds.GHAST_CANNON, () -> Item.getItemFromBlock(Blocks.CACTUS), 1000, 12));
        register(registry, new RangedWeaponBase("cyclopsian_staff", BulletType.CYCLOPSIAN_STAFF_SHOT, ModSounds.STAFF, 600, 0));
        register(registry, new RangedWeaponBase("frost_cannon", BulletType.FROST_CANNON_SHOT, ModSounds.FROST_CANNON, () -> Items.SNOWBALL, 15000, 0));
        register(registry, new RangedWeaponBase("ghast_cannon", BulletType.GHAST_CANNON_SHOT, ModSounds.GHAST_CANNON, 100, 20));
        register(registry, new RangedWeaponBase("golden_fury", BulletType.GOLDEN_FURY_SHOT, ModSounds.BLITZ, () -> Items.GOLD_NUGGET, -1, 0));
        register(registry, new ItemAnchor("liopleurodon_anchor", BulletType.LIOPLEURODON_ANCHOR_SHOT));
        register(registry, new RangedWeaponBase("maelstrom", BulletType.MAELSTROM_SHOT, ModSounds.GHAST_CANNON, 100, 0));
        register(registry, new ItemAnchor("shark_anchor", BulletType.SHARK_ANCHOR_SHOT));

        register(registry, new ItemSerenadeOfDeath("serenade_of_death"));
        register(registry, new ItemSerenadeOfHealth("serenade_of_health"));
        register(registry, new ItemSerenadeOfInfusion("serenade_of_infusion"));
        register(registry, new ItemSerenadeStriker("serenade_striker"));

        register(registry, new ItemHealingSword("massivence", ToolMaterialMod.Palavence, 1F));
        register(registry, new ItemHealingSword("palavence", ToolMaterialMod.Palavence, 0.5F));

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

        // Vanilla dimension tools
        register(registry, new ItemModShovel(ToolMaterialMod.ArlemiteShovel, "arlemite_shovel"));
        register(registry, new ItemModPickaxe(ToolMaterialMod.ArlemitePick, "arlemite_pickaxe"));
        register(registry, new ItemModAxe(ToolMaterialMod.ArlemiteAxe, "arlemite_axe"));
        register(registry, new ItemModHoe(ToolMaterialMod.ArlemitePick, "arlemite_hoe"));
        register(registry, new ItemShickaxe(ToolMaterialMod.ArlemiteShick, "arlemite_shickaxe"));

        register(registry, new ItemModShovel(ToolMaterialMod.BedrockShovel, "bedrock_shovel"));
        register(registry, new ItemModPickaxe(ToolMaterialMod.BedrockPick, "bedrock_pickaxe"));
        register(registry, new ItemModAxe(ToolMaterialMod.BedrockAxe, "bedrock_axe"));

        register(registry, new ItemModShovel(ToolMaterialMod.CorruptedShovel, "corrupted_shovel"));
        register(registry, new ItemModPickaxe(ToolMaterialMod.CorruptedPick, "corrupted_pickaxe"));
        register(registry, new ItemModAxe(ToolMaterialMod.CorruptedAxe, "corrupted_axe"));

        register(registry, new ItemModShovel(ToolMaterialMod.DivineShovel, "divine_shovel"));
        register(registry, new ItemModPickaxe(ToolMaterialMod.DivinePick, "divine_pickaxe"));
        register(registry, new ItemModAxe(ToolMaterialMod.DivineAxe, "divine_axe"));
        register(registry, new ItemShickaxe(ToolMaterialMod.DivineShick, "divine_shickaxe"));

        register(registry, new ItemModShovel(ToolMaterialMod.RealmiteShovel, "realmite_shovel"));
        register(registry, new ItemModPickaxe(ToolMaterialMod.RealmitePick, "realmite_pickaxe"));
        register(registry, new ItemModAxe(ToolMaterialMod.RealmiteAxe, "realmite_axe"));
        register(registry, new ItemModHoe(ToolMaterialMod.RealmitePick, "realmite_hoe"));

        register(registry, new ItemModShovel(ToolMaterialMod.RupeeShovel, "rupee_shovel"));
        register(registry, new ItemModPickaxe(ToolMaterialMod.RupeePick, "rupee_pickaxe"));
        register(registry, new ItemModAxe(ToolMaterialMod.RupeeAxe, "rupee_axe"));
        register(registry, new ItemModHoe(ToolMaterialMod.RupeePick, "rupee_hoe"));
        register(registry, new ItemShickaxe(ToolMaterialMod.RupeeShick, "rupee_shickaxe"));

        // Teleportation crystal
        register(registry, new ItemTeleportationCrystal("teleportation_crystal"));

        // Vanilla misc items

        // Shards
        register(registry, new ItemMod("corrupted_shards"));
        register(registry, new ItemMod("divine_shards"));
        register(registry, new ItemMod("ender_shards"));
        register(registry, new ItemMod("ice_shards"));
        register(registry, new ItemMod("jungle_shards"));
        register(registry, new ItemMod("molten_shards"));
        register(registry, new ItemMod("terran_shards"));

        // Stones
        register(registry, new ItemMod("corrupted_stone"));
        register(registry, new ItemMod("divine_stone"));
        register(registry, new ItemMod("ender_stone"));
        register(registry, new ItemMod("ice_stone"));
        register(registry, new ItemMod("jungle_stone"));
        register(registry, new ItemMod("molten_stone"));
        register(registry, new ItemMod("shadow_stone"));
        register(registry, new ItemMod("terran_stone"));

        // Ingots
        register(registry, new ItemMod("arlemite_ingot"));
        register(registry, new ItemMod("hellstone_ingot"));
        register(registry, new ItemMod("netherite_ingot"));
        register(registry, new ItemMod("realmite_ingot"));
        register(registry, new ItemMod("rupee_ingot"));
        register(registry, new ItemMod("shadow_bar"));

        // Boss spawners
        register(registry, new ItemBossSpawner("call_of_the_watcher", "message.watcher", x -> Objects.equals(x, DimensionType.NETHER), EntityTheWatcher::new));
        register(registry, new ItemHordeHorn("horde_horn"));
        register(registry, new ItemBossSpawner("infernal_flame", "message.king_of_scorchers", x -> Objects.equals(x, DimensionType.NETHER), EntityKingOfScorchers::new));
        register(registry, new ItemBossSpawner("mysterious_clock", "message.ancient_entity", x -> Objects.equals(x, DimensionType.OVERWORLD), EntityAncientEntity::new));
        register(registry, new ItemMod("watching_eye"));

        // Ayeraco fragments
        register(registry, new ItemMod("ayeraco_fragment_blue"));
        register(registry, new ItemMod("ayeraco_fragment_green"));
        register(registry, new ItemMod("ayeraco_fragment_purple"));
        register(registry, new ItemMod("ayeraco_fragment_red"));
        register(registry, new ItemMod("ayeraco_fragment_yellow"));

        // Diamond chunks
        register(registry, new ItemMod("blue_diamond_chunk"));
        register(registry, new ItemMod("gray_diamond_chunk"));
        register(registry, new ItemMod("red_diamond_chunk"));
        register(registry, new ItemMod("yellow_diamond_chunk"));
        register(registry, new ItemMod("green_diamond_chunk"));

        // Pet spawn eggs
        register(registry, new ItemSpawnEgg("brown_grizzle_egg", EntityBrownGrizzle::new));
        register(registry, new ItemSpawnEgg("ehu_egg", EntityEhu::new));
        register(registry, new ItemSpawnEgg("husk_egg", EntityHusk::new));
        register(registry, new ItemSpawnEgg("smelter_egg", EntitySmelter::new));
        register(registry, new ItemSpawnEgg("snapper_egg", EntitySnapper::new));
        register(registry, new ItemSpawnEgg("stone_golem_egg", EntityStoneGolem::new));
        register(registry, new ItemSpawnEgg("white_grizzle_egg", EntityWhiteGrizzle::new));

        // Miscellaneous resources
        register(registry, new ItemMod("aqua_ball"));
        register(registry, new ItemMod("aquatic_blaze_rod"));
        register(registry, new ItemMod("aquatic_ingot"));
        register(registry, new ItemMod("aquatic_pellets"));
        register(registry, new ItemMod("bedrock_chunk"));
        register(registry, new ItemMod("bloodgem"));
        register(registry, new ItemMod("bluefire_stone"));
        register(registry, new ItemMod("corrupted_bullet"));
        register(registry, new ItemMod("crab_claw"));
        register(registry, new ItemMod("cyclops_eye"));
        register(registry, new ItemMod("cyclops_eye_shards"));
        register(registry, new ItemMod("fury_fire"));
        register(registry, new ItemHealingStone("healing_stone", 20));
        register(registry, new ItemMod("kraken_scale"));
        register(registry, new ItemMod("kraken_skin"));
        register(registry, new ItemMod("legendary_ender_eye"));
        register(registry, new ItemMod("liopleurodon_skull"));
        register(registry, new ItemMod("liopleurodon_teeth"));
        register(registry, new ItemMod("netherite_chunk"));
        register(registry, new ItemMod("pure_aquatic_pellets"));
        register(registry, new ItemMod("purple_blaze"));
        register(registry, new ItemMod("shadow_coins"));
        register(registry, new ItemMod("shark_fin"));
        register(registry, new ItemMod("whale_fin"));

        // Iceika

        // Iceika dimension weapons - melee
        register(registry, new ItemSlowingSword(ToolMaterialMod.Enderice, "enderice"));
        register(registry, new ItemSlowingSword(ToolMaterialMod.Frostking, "frostking_sword"));
        register(registry, new ItemSlowingSword(ToolMaterialMod.FrozenMaul, "frozen_maul"));
        register(registry, new ItemSlowingSword(ToolMaterialMod.Glacier, "glacier_sword"));
        register(registry, new ItemSlowingSword(ToolMaterialMod.Icine, "icine_sword"));
        register(registry, new ItemSlowingSword(ToolMaterialMod.Snowslash, "snowslash"));
        register(registry, new ItemSlowingSword(ToolMaterialMod.IcicleBane, "icicle_bane"));

        register(registry, new ItemHealingSword("frossivence", ToolMaterialMod.Frossivence, 1F));

        // Iceika dimension weapons - ranged
        register(registry, new ItemModBow("snowstorm_bow", ArrowType.SNOWSTORM_ARROW, -1));
        register(registry, new ItemModBow("icicle_bow", ArrowType.ICICLE_ARROW, 10000, 24000, () -> Items.ARROW));

        register(registry, new ItemThrowable("snowflake_shuriken", BulletType.SNOWFLAKE_SHURIKEN_SHOT));

        register(registry, new RangedWeaponBase("fractite_cannon", BulletType.FRACTITE_CANNON_SHOT, ModSounds.FRACTITE_CANNON, () -> iceShards, 10000, 0));
        register(registry, new RangedWeaponBase("frostclaw_cannon", BulletType.FROSTCLAW_CANNON_SHOT, ModSounds.FROSTCLAW_CANNON, () -> Item.getItemFromBlock(Blocks.CACTUS), 10000, 0));

        register(registry, new ItemMusicShooter("sound_of_music", ModSounds.SOUND_OF_MUSIC, EntitySoundOfMusic.class));
        register(registry, new ItemMusicShooter("sound_of_carols", ModSounds.SOUND_OF_CAROLS, EntitySoundOfCarols.class));

        register(registry, new ItemSerenadeOfIce("serenade_of_ice"));

        // Iceika dimension armor
        register(registry, new ItemDivineArmor("santa_boots", EnumArmor.SANTA, EntityEquipmentSlot.FEET, santaInfo));
        register(registry, new ItemDivineArmor("santa_pants", EnumArmor.SANTA, EntityEquipmentSlot.LEGS, santaInfo));
        register(registry, new ItemDivineArmor("santa_tunic", EnumArmor.SANTA, EntityEquipmentSlot.CHEST, santaInfo));
        register(registry, new ItemDivineArmor("santa_cap", EnumArmor.SANTA, EntityEquipmentSlot.HEAD, santaInfo));

        // Iceika misc
        register(registry, new ItemMod("snowflake"));

        // Iceika portal item
        register(registry, new ItemSnowGlobe("snow_globe"));

        /*************************/

        // Foods
        register(registry, new ItemModFood(10, 0.5F, "advanced_mushroom_stew"));
        register(registry, new ItemModFood(2, 2.0F, true, "bacon"));
        register(registry, new ItemModFood(4, 0.5F, "boiled_egg"));
        register(registry, new ItemModFood(2, 0.2F, "cheese"));
        register(registry, new ItemModFood(20, 0.5F, "chicken_dinner"));
        register(registry, new ItemModFood(4, 1.0F, "chocolate_log"));
        register(registry, new ItemModFood(16, 0.3F, "donut"));
        register(registry, new ItemEggNog("egg_nog"));
        register(registry, new ItemModFood(5, 1.0F, true, "raw_empowered_meat"));
        register(registry, new ItemModFood(10, 1.0F, true, "empowered_meat"));
        register(registry, new ItemFastFood(7, 1.0F, true, "enriched_magic_meat"));
        register(registry, new ItemForbiddenFruit());
        register(registry, new ItemModFood(16, 0.2F, "fruit_cake"));
        register(registry, new ItemModFood(5, 0.4F, true, "hot_pumpkin_pie"));
        register(registry, new ItemFastFood(5, 1.0F, true, "magic_meat"));
        register(registry, new ItemFastFood(1, 2.0F, false, "moonbulb"));
        register(registry, new ItemModFood(1, 0.3F, "peppermints"));
        register(registry, new ItemFastFood(3, 2.0F, false, "pink_glowbone"));
        register(registry, new ItemFastFood(3, 2.0F, false, "purple_glowbone"));
        register(registry, new ItemSkyFlower("sky_flower"));
        register(registry, new ItemModFood(2, 0.3F, "snow_cones"));
        register(registry, new ItemModFood(4, 0.3F, "tomato"));
        register(registry, new ItemModFood(1, 0.1F, "white_mushroom"));
        register(registry, new ItemModFood(4, 1.0F, "winterberry"));

        // Twilight Dimensions

        // Twilight souls
        register(registry, new ItemMod("eden_soul"));
        register(registry, new ItemMod("wildwood_soul"));
        register(registry, new ItemMod("apalachia_soul"));
        register(registry, new ItemMod("skythern_soul"));
        register(registry, new ItemMod("mortum_soul"));

        // Twilight fragments
        register(registry, new ItemMod("eden_fragments"));
        register(registry, new ItemMod("wildwood_fragments"));
        register(registry, new ItemMod("apalachia_fragments"));
        register(registry, new ItemMod("skythern_fragments"));
        register(registry, new ItemMod("mortum_fragments"));

        // Twilight gems
        register(registry, new ItemMod("eden_gem"));
        register(registry, new ItemMod("wildwood_gem"));
        register(registry, new ItemMod("apalachia_gem"));
        register(registry, new ItemMod("skythern_gem"));
        register(registry, new ItemMod("mortum_gem"));

        // Twilight chunks
        register(registry, new ItemMod("eden_chunk"));
        register(registry, new ItemMod("wildwood_chunk"));
        register(registry, new ItemMod("apalachia_chunk"));
        register(registry, new ItemMod("skythern_chunk"));
        register(registry, new ItemMod("mortum_chunk"));

        // Twilight dust
        register(registry, new ItemMod("eden_dust"));
        register(registry, new ItemMod("wildwood_dust"));
        register(registry, new ItemMod("apalachia_dust"));
        register(registry, new ItemMod("skythern_dust"));
        register(registry, new ItemMod("mortum_dust"));

        // Twilight boss spawners

        // Twilight swords
        register(registry, new ItemModSword(ToolMaterialMod.Eden, "eden_blade"));
        register(registry, new ItemModSword(ToolMaterialMod.Wildwood, "wildwood_blade"));
        register(registry, new ItemModSword(ToolMaterialMod.Apalachia, "apalachia_blade"));
        register(registry, new ItemModSword(ToolMaterialMod.Skythern, "skythern_blade"));
        register(registry, new ItemModSword(ToolMaterialMod.Mortum, "mortum_blade"));
        register(registry, new ItemModSword(ToolMaterialMod.Halite, "halite_blade"));

        // Twilight bows
        register(registry, new ItemModBow("eden_bow", ArrowType.EDEN_ARROW, -1, () -> edenArrow));
        register(registry, new ItemModBow("wildwood_bow", ArrowType.LESSER_WILDWOOD_ARROW, -1, 36000, () -> wildwoodArrow));
        register(registry, new ItemModBow("apalachia_bow", ArrowType.GREATER_WILDWOOD_ARROW, -1, () -> wildwoodArrow));
        register(registry, new ItemModBow("skythern_bow", ArrowType.GREATER_WILDWOOD_ARROW, -1, 36000, () -> wildwoodArrow));
        register(registry, new ItemModBow("mortum_bow", ArrowType.FURY_ARROW, -1, () -> furyArrow));
        register(registry, new ItemModBow("halite_bow", ArrowType.FURY_ARROW, -1, 36000, () -> furyArrow));
        register(registry, new ItemModBow("twilight_bow", ArrowType.FURY_ARROW, -1, 14400, () -> furyArrow));

        // Twilight slicers
        register(registry, new ItemThrowable("eden_slicer", BulletType.EDEN_SLICER_SHOT));
        register(registry, new ItemThrowable("wildwood_slicer", BulletType.WILDWOOD_SLICER_SHOT));
        register(registry, new ItemThrowable("apalachia_slicer", BulletType.APALACHIA_SLICER_SHOT));
        register(registry, new ItemThrowable("skythern_slicer", BulletType.SKYTHERN_SLICER_SHOT));
        register(registry, new ItemThrowable("mortum_slicer", BulletType.MORTUM_SLICER_SHOT));
        register(registry, new ItemThrowable("halite_slicer", BulletType.HALITE_SLICER_SHOT));

        // Twilight blitzes
        register(registry, new ItemTwilightBlitz("eden_blitz", BulletType.EDEN_BLITZ_SHOT, () -> edenDust));
        register(registry, new ItemTwilightBlitz("wildwood_blitz", BulletType.WILDWOOD_BLITZ_SHOT, () -> wildwoodDust));
        register(registry, new ItemTwilightBlitz("apalachia_blitz", BulletType.APALACHIA_BLITZ_SHOT, () -> apalachiaDust));
        register(registry, new ItemTwilightBlitz("skythern_blitz", BulletType.SKYTHERN_BLITZ_SHOT, () -> skythernDust));
        register(registry, new ItemTwilightBlitz("mortum_blitz", BulletType.MORTUM_BLITZ_SHOT, () -> mortumDust));
        register(registry, new ItemTwilightBlitz("halite_blitz", BulletType.HALITE_BLITZ_SHOT, () -> mortumDust));

        // Twilight phasers
        register(registry, new RangedWeaponBase("eden_phaser", BulletType.EDEN_PHASER_SHOT, ModSounds.PHASER, 3000, 12));
        register(registry, new RangedWeaponBase("wildwood_phaser", BulletType.WILDWOOD_PHASER_SHOT, ModSounds.PHASER, 3000, 12));
        register(registry, new RangedWeaponBase("apalachia_phaser", BulletType.APALACHIA_PHASER_SHOT, ModSounds.PHASER, 3000, 12));
        register(registry, new RangedWeaponBase("skythern_phaser", BulletType.SKYTHERN_PHASER_SHOT, ModSounds.PHASER, 3000, 12));
        register(registry, new RangedWeaponBase("mortum_phaser", BulletType.MORTUM_PHASER_SHOT, ModSounds.PHASER, 3000, 12));
        register(registry, new RangedWeaponBase("halite_phaser", BulletType.HALITE_PHASER_SHOT, ModSounds.PHASER, 3000, 12));

        // Twilight tools
        register(registry, new ItemModShovel(ToolMaterialMod.EdenShovel, "eden_shovel"));
        register(registry, new ItemModPickaxe(ToolMaterialMod.EdenPick, "eden_pickaxe"));
        register(registry, new ItemModAxe(ToolMaterialMod.EdenAxe, "eden_axe"));

        register(registry, new ItemModShovel(ToolMaterialMod.WildwoodShovel, "wildwood_shovel"));
        register(registry, new ItemModPickaxe(ToolMaterialMod.WildwoodPick, "wildwood_pickaxe"));
        register(registry, new ItemModAxe(ToolMaterialMod.WildwoodAxe, "wildwood_axe"));

        register(registry, new ItemModShovel(ToolMaterialMod.ApalachiaShovel, "apalachia_shovel"));
        register(registry, new ItemModPickaxe(ToolMaterialMod.ApalachiaPick, "apalachia_pickaxe"));
        register(registry, new ItemModAxe(ToolMaterialMod.ApalachiaAxe, "apalachia_axe"));

        register(registry, new ItemModShovel(ToolMaterialMod.SkythernShovel, "skythern_shovel"));
        register(registry, new ItemModPickaxe(ToolMaterialMod.SkythernPick, "skythern_pickaxe"));
        register(registry, new ItemModAxe(ToolMaterialMod.SkythernAxe, "skythern_axe"));

        register(registry, new ItemModShovel(ToolMaterialMod.MortumShovel, "mortum_shovel"));
        register(registry, new ItemModPickaxe(ToolMaterialMod.MortumPick, "mortum_pickaxe"));
        register(registry, new ItemModAxe(ToolMaterialMod.MortumAxe, "mortum_axe"));

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

        // Twilight boss spawners
        register(registry, new ItemBossSpawner("eternal_archer_crystal", "tooltip.mortum_only", x -> Objects.equals(x, ModDimensions.mortumDimension), EntityEternalArcher::new));
        register(registry, new ItemBossSpawner("karot_crystal", "tooltip.mortum_only", x -> Objects.equals(x, ModDimensions.mortumDimension), EntityKarot::new));
        register(registry, new ItemBossSpawner("reyvor_crystal", "tooltip.mortum_only", x -> Objects.equals(x, ModDimensions.mortumDimension), EntityReyvor::new, EntityDensos::new));
        register(registry, new ItemBossSpawner("densos_crystal", "tooltip.mortum_only", x -> Objects.equals(x, ModDimensions.mortumDimension), EntityReyvor::new, EntityDensos::new));
        register(registry, new ItemBossSpawner("soul_fiend_crystal", "tooltip.mortum_only", x -> Objects.equals(x, ModDimensions.mortumDimension), EntitySoulFiend::new));
        register(registry, new ItemBossSpawner("twilight_demon_crystal", "tooltip.mortum_only", x -> Objects.equals(x, ModDimensions.mortumDimension), EntityTwilightDemon::new));
        register(registry, new ItemBossSpawner("vamacheron_crystal", "tooltip.mortum_only", x -> Objects.equals(x, ModDimensions.mortumDimension), EntityVamacheron::new));

        // Twilight portal item
        register(registry, new ItemTwilightClock("twilight_clock"));

        // Twilight arrows
        register(registry, new ItemMod("eden_arrow").setCreativeTab(DivineRPGTabs.ranged));
        register(registry, new ItemMod("fury_arrow").setCreativeTab(DivineRPGTabs.ranged));
        register(registry, new ItemMod("wildwood_arrow").setCreativeTab(DivineRPGTabs.ranged));

        // Twilight miscellaneous
        register(registry, new ItemMod("base_spawn_crystal"));
        register(registry, new ItemMod("eden_sparkles"));

        // Arcana

        // Arcana melee
        register(registry, new ItemArcaniteBlade());
        register(registry, new ItemArcaniumSaber("arcanium_saber", ToolMaterialMod.Saber));
        register(registry, new ItemEnderScepter("ender_scepter"));
        register(registry, new ItemModSword(ToolMaterialMod.LiviciaSword, "livicia_sword"));
        register(registry, new ItemStormSword("storm_sword", ToolMaterialMod.Storm));
        register(registry, new ItemShadowSaber("shadow_saber", ToolMaterialMod.ShadowSaber));

        // Arcana ranged
        register(registry, new ItemArcaniteBlaster());
        register(registry, new ItemCaptainsSparkler("captains_sparkler"));
        register(registry, new ItemFirefly());
        register(registry, new ItemGeneralsStaff());
        register(registry, new ItemLaVekor());
        register(registry, new ItemMeriksMissile("meriks_missile"));
        register(registry, new ItemMeteorMash());
        register(registry, new ItemStaffStarlight("starlight", 5, 1));
        register(registry, new ItemStaffStarlight("staff_of_starlight", 25, 8));

        // Arcana throwable
        register(registry, new ItemGrenade("grenade"));

        // Arcana utility
        register(registry, new ItemAttractor());
        register(registry, new ItemReflector());
        register(registry, new ItemDivineAccumulator());
        register(registry, new ItemGhostbane());
        register(registry, new ItemOrbOfLight());
        register(registry, new ItemStaffEnrichment("staff_of_enrichment"));
        register(registry, new ItemArcanaCharge());

        // Arcana armor sets
        register(registry, new ItemDivineArmor(EnumArmor.KORMA, EntityEquipmentSlot.HEAD, kormInfo));
        register(registry, new ItemDivineArmor(EnumArmor.KORMA, EntityEquipmentSlot.CHEST, kormInfo));
        register(registry, new ItemDivineArmor(EnumArmor.KORMA, EntityEquipmentSlot.LEGS, kormInfo));
        register(registry, new ItemDivineArmor(EnumArmor.KORMA, EntityEquipmentSlot.FEET, kormInfo));

        register(registry, new ItemDivineArmor(EnumArmor.VEMOS, EntityEquipmentSlot.HEAD, vemInfo));
        register(registry, new ItemDivineArmor(EnumArmor.VEMOS, EntityEquipmentSlot.CHEST, vemInfo));
        register(registry, new ItemDivineArmor(EnumArmor.VEMOS, EntityEquipmentSlot.LEGS, vemInfo));
        register(registry, new ItemDivineArmor(EnumArmor.VEMOS, EntityEquipmentSlot.FEET, vemInfo));

        // Arcana boss spawners
        register(registry, new ItemWizardsBook("wizards_book"));

        // Arcana pet spawners
        register(registry, new ItemSpawnEgg("fyracryx_egg", EntityFyracryx::new));
        register(registry, new ItemSpawnEgg("paratiku_egg", EntityParatiku::new));
        register(registry, new ItemSpawnEgg("seimer_egg", EntitySeimer::new));
        register(registry, new ItemSpawnEgg("golem_of_rejuvenation_egg", EntityGolemOfRejuvenation::new));

        // Arcana crops
        register(registry, new ItemAquamarine("aquamarine"));
        register(registry, new ItemMod("firestock"));
        register(registry, new ItemLamona());
        register(registry, new ItemMod("marsine"));
        register(registry, new ItemModFood(2, 0.3F, "pinfly").setPotionEffect(new PotionEffect(MobEffects.SPEED, 10, 2), 1.0F));
        register(registry, new ItemMod("veilo"));
        register(registry, new ItemModFood(2, 3, "hitchak"));

        // Arcana keys
        register(registry, new ItemKey("ancient_key"));
        register(registry, new ItemKey("degraded_key"));
        register(registry, new ItemKey("soul_key"));
        register(registry, new ItemKey("sludge_key"));

        // Doors
        register(registry, new ItemModDoor(ModBlocks.ancientBrickDoor, "ancient_brick_door"));
        register(registry, new ItemModDoor(ModBlocks.degradedBrickDoor, "degraded_brick_door"));
        register(registry, new ItemModDoor(ModBlocks.soulSludgeDoor, "soul_sludge_door"));
        register(registry, new ItemModDoor(ModBlocks.soulStoneDoor, "soul_stone_door"));
        register(registry, new ItemModDoor(ModBlocks.steelDoor, "steel_door"));

        // Arcana potions
        register(registry, new ItemArcanaPotion("weak_arcana_potion", 100));
        register(registry, new ItemArcanaPotion("strong_arcana_potion", 200));

        // Arcana miscellaneous
        register(registry, new ItemMod("arcanium"));
        register(registry, new ItemChargedCollector("charged_collector"));
        register(registry, new ItemMod("collector"));
        register(registry, new ItemMod("dungeon_tokens"));

        // Seeds
        register(registry, new ItemArcanaSeeds("aquamarine_seeds", () -> ModBlocks.aquamarinePlant));
        register(registry, new ItemArcanaSeeds("eucalyptus_root_seeds", () -> ModBlocks.eucalyptusPlant));
        register(registry, new ItemArcanaSeeds("firestock_seeds", () -> ModBlocks.firestockPlant));
        register(registry, new ItemArcanaSeeds("hitchak_seeds", () -> ModBlocks.hitchakPlant));
        register(registry, new ItemArcanaSeeds("lamona_seeds", () -> ModBlocks.lamonaPlant));
        register(registry, new ItemArcanaSeeds("marsine_seeds", () -> ModBlocks.marsinePlant));
        register(registry, new ItemModSeeds("moonbulb_seeds", () -> ModBlocks.moonbulbPlant, () -> Blocks.FARMLAND));
        register(registry, new ItemArcanaSeeds("pinfly_seeds", () -> ModBlocks.pinflyPlant));
        register(registry, new ItemModSeeds("pink_glowbone_seeds", () -> ModBlocks.pinkGlowbonePlant, () -> Blocks.GRASS));
        register(registry, new ItemModSeeds("purple_glowbone_seeds", () -> ModBlocks.purpleGlowbonePlant, () -> Blocks.GRASS));
        register(registry, new ItemModSeeds("sky_plant_seeds", () -> ModBlocks.skyPlant, () -> Blocks.GRASS));
        register(registry, new ItemModSeeds("tomato_seeds", () -> ModBlocks.tomatoPlant, () -> Blocks.FARMLAND));
        register(registry, new ItemArcanaSeeds("veilo_seeds", () -> ModBlocks.veiloPlant));
        register(registry, new ItemModSeeds("white_mushroom_seeds", () -> ModBlocks.whiteMushroomPlant, () -> Blocks.FARMLAND));

        // Vethea
        // Vethea pearls
        register(registry, new ItemVethean("dirty_pearls"));
        register(registry, new ItemVethean("clean_pearls"));
        register(registry, new ItemVethean("polished_pearls"));
        register(registry, new ItemVethean("shiny_pearls"));

        // Vethea lumps
        register(registry, new ItemVethean("teaker_lump"));
        register(registry, new ItemVethean("amthirmis_lump"));
        register(registry, new ItemVethean("darven_lump"));
        register(registry, new ItemVethean("cermile_lump"));
        register(registry, new ItemVethean("pardimal_lump"));
        register(registry, new ItemVethean("quadrotic_lump"));
        register(registry, new ItemVethean("karos_lump"));
        register(registry, new ItemVethean("heliosis_lump"));
        register(registry, new ItemVethean("arksiane_lump"));

        // Vethea templates
        register(registry, new ItemVethean("backsword_template"));
        register(registry, new ItemVethean("bow_template"));
        register(registry, new ItemVethean("cannon_template"));
        register(registry, new ItemVethean("claw_template"));
        register(registry, new ItemVethean("disk_template"));
        register(registry, new ItemVethean("hammer_template"));
        register(registry, new ItemVethean("staff_template"));

        register(registry, new ItemVethean("degraded_template"));
        register(registry, new ItemVethean("finished_template"));
        register(registry, new ItemVethean("glistening_template"));
        register(registry, new ItemVethean("demonized_template"));
        register(registry, new ItemVethean("tormented_template"));

        // Vethea food
        register(registry, new ItemModFood(3, 0.4F, "dream_carrot").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new ItemModFood(6, 0.6F, "dream_melon").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new ItemModFood(4, 0.8F, "dream_pie").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new ItemModFood(8, 0.8F, "dream_cake").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new ItemHealingFood(0, 0F, 2, "dream_sweets").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new ItemHealingFood(0, 0F, 8, "dream_sours").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new ItemModFood(1, 0.2F, "honeysuckle").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new ItemModFood(1, 0.2F, "honeychunk").setCreativeTab(DivineRPGTabs.vethea));

        // Vethea boss spawners
        register(registry, new ItemVethean("dream_flint"));
        register(registry, new ItemVethean("moon_clock"));

        // Vethea weapons
        // Backsword
        register(registry, new ItemVetheanSword(ToolMaterialMod.TeakerSword, "teaker_backsword"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.AmthirmisSword, "amthirmis_backsword"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.DarvenSword, "darven_backsword"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.CermileSword, "cermile_backsword"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.PardimalSword, "pardimal_backsword"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.QuadroticSword, "quadrotic_backsword"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.KarosSword, "karos_backsword"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.HeliosisSword, "heliosis_backsword"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.ArksianeSword, "arksiane_backsword"));

        // Bow
        register(registry, new ItemVetheanBow("teaker_bow", ArrowType.TEAKER_ARROW, -1, () -> teakerArrow));
        register(registry, new ItemVetheanBow("amthirmis_bow", ArrowType.AMTHIRMIS_ARROW, -1, () -> teakerArrow));
        register(registry, new ItemVetheanBow("darven_bow", ArrowType.DARVEN_ARROW, -1, () -> darvenArrow));
        register(registry, new ItemVetheanBow("cermile_bow", ArrowType.CERMILE_ARROW, -1, () -> darvenArrow));
        register(registry, new ItemVetheanBow("pardimal_bow", ArrowType.PARDIMAL_ARROW, -1, () -> pardimalArrow));
        register(registry, new ItemVetheanBow("quadrotic_bow", ArrowType.QUADROTIC_ARROW, -1, () -> pardimalArrow));
        register(registry, new ItemVetheanBow("karos_bow", ArrowType.KAROS_ARROW, -1, () -> karosArrow));
        register(registry, new ItemVetheanBow("heliosis_bow", ArrowType.HELIOSIS_ARROW, -1, () -> karosArrow));
        register(registry, new ItemVetheanBow("arksiane_bow", ArrowType.ARKSIANE_ARROW, -1, () -> karosArrow));
        register(registry, new ItemVetheanBow("everfright", ArrowType.EVERFRIGHT, -1, () -> everArrow));

        // Cannon
        register(registry, new ItemVetheanCannon("teaker_cannon", BulletType.TEAKER_CANNON_SHOT, () -> ModItems.acid));
        register(registry, new ItemVetheanCannon("amthirmis_cannon", BulletType.AMTHIRMIS_CANNON_SHOT, () -> ModItems.acid));
        register(registry, new ItemVetheanCannon("darven_cannon", BulletType.DARVEN_CANNON_SHOT, () -> ModItems.acid));
        register(registry, new ItemVetheanCannon("cermile_cannon", BulletType.CERMILE_CANNON_SHOT, () -> ModItems.acid));
        register(registry, new ItemVetheanCannon("pardimal_cannon", BulletType.PARDIMAL_CANNON_SHOT, () -> ModItems.acid));
        register(registry, new ItemVetheanCannon("quadrotic_cannon", BulletType.QUADROTIC_CANNON_SHOT, () -> ModItems.acid));
        register(registry, new ItemVetheanCannon("karos_cannon", BulletType.KAROS_CANNON_SHOT, () -> ModItems.acid));
        register(registry, new ItemVetheanCannon("heliosis_cannon", BulletType.HELIOSIS_CANNON_SHOT, () -> ModItems.acid));
        register(registry, new ItemVetheanCannon("arksiane_cannon", BulletType.ARKSIANE_CANNON_SHOT, () -> ModItems.acid));
        register(registry, new ItemVetheanCannon("eversight", BulletType.EVERSIGHT_SHOT, () -> ModItems.acid));

        // Claw
        register(registry, new ItemVetheanSword(ToolMaterialMod.TeakerClaw, "teaker_claw"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.AmthirmisClaw, "amthirmis_claw"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.DarvenClaw, "darven_claw"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.CermileClaw, "cermile_claw"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.PardimalClaw, "pardimal_claw"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.QuadroticClaw, "quadrotic_claw"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.KarosClaw, "karos_claw"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.HeliosisClaw, "heliosis_claw"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.ArksianeClaw, "arksiane_claw"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.Everbright, "everbright"));

        // Disk
        register(registry, new ItemVetheanDisk("teaker_disk", DiskType.TEAKER_DISK));
        register(registry, new ItemVetheanDisk("amthirmis_disk", DiskType.AMTHRIMIS_DISK));
        register(registry, new ItemVetheanDisk("darven_disk", DiskType.DARVEN_DISK));
        register(registry, new ItemVetheanDisk("cermile_disk", DiskType.CERMILE_DISK));
        register(registry, new ItemVetheanDisk("pardimal_disk", DiskType.PARDIMAL_DISK));
        register(registry, new ItemVetheanDisk("quadrotic_disk", DiskType.QUADROTIC_DISK));
        register(registry, new ItemVetheanDisk("karos_disk", DiskType.KAROS_DISK));
        register(registry, new ItemVetheanDisk("heliosis_disk", DiskType.HELIOSIS_DISK));
        register(registry, new ItemVetheanDisk("arksiane_disk", DiskType.ARKSIANE_DISK));

        // Hammer
        register(registry, new ItemVetheanSword(ToolMaterialMod.TeakerHammer, "teaker_hammer"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.AmthirmisHammer, "amthirmis_hammer"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.DarvenHammer, "darven_hammer"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.CermileHammer, "cermile_hammer"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.PardimalHammer, "pardimal_hammer"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.QuadroticHammer, "quadrotic_hammer"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.KarosHammer, "karos_hammer"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.HeliosisHammer, "heliosis_hammer"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.ArksianeHammer, "arksiane_hammer"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.Everlight, "everlight"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.KarosRockmaul, "karos_rockmaul"));

        // Staff
        register(registry, new ItemStaff(3, 10, "teaker_staff"));
        register(registry, new ItemStaff(5, 10, "amthirmis_staff"));
        register(registry, new ItemStaff(8, 10, "darven_staff"));
        register(registry, new ItemStaff(12, 10, "cermile_staff"));
        register(registry, new ItemStaff(15, 10, "pardimal_staff"));
        register(registry, new ItemStaff(19, 10, "quadrotic_staff"));
        register(registry, new ItemStaff(21, 10, "karos_staff"));
        register(registry, new ItemStaff(28, 10, "heliosis_staff"));
        register(registry, new ItemStaff(36, 10, "arksiane_staff"));
        register(registry, new ItemEvernight(115, 80, "evernight"));

        // Vethea arrows
        register(registry, new ItemVethean("teaker_arrow"));
        register(registry, new ItemVethean("darven_arrow"));
        register(registry, new ItemVethean("pardimal_arrow"));
        register(registry, new ItemVethean("karos_arrow"));
        register(registry, new ItemVethean("ever_arrow"));

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

        // Vethea portal item
        register(registry, new ItemNightmareBed());

        // Vethea door
        register(registry, new ItemModDoor(ModBlocks.barredDoor, "barred_door"));

        // Vethea miscellaneous
        register(registry, new ItemVethean("acid"));
        register(registry, new ItemVethean("band_of_heiva_hunting"));
        register(registry, new ItemVethean("miners_amulet"));
        register(registry, new ItemVethean("rock_chunks"));

        //Slabs
        register(registry, new ItemModSlab("eden_slab", ModBlocks.edenSlab, ModBlocks.edenSlab, ModBlocks.edenDoubleSlab));
        register(registry, new ItemModSlab("wildwood_slab", ModBlocks.wildwoodSlab, ModBlocks.wildwoodSlab, ModBlocks.wildwoodDoubleSlab));
        register(registry, new ItemModSlab("apalachia_slab", ModBlocks.apalachiaSlab, ModBlocks.apalachiaSlab, ModBlocks.apalachiaDoubleSlab));
        register(registry, new ItemModSlab("skythern_slab", ModBlocks.skythernSlab, ModBlocks.skythernSlab, ModBlocks.skythernDoubleSlab));
        register(registry, new ItemModSlab("mortum_slab", ModBlocks.mortumSlab, ModBlocks.mortumSlab, ModBlocks.mortumDoubleSlab));
        register(registry, new ItemModSlab("divine_slab", ModBlocks.divineSlab, ModBlocks.divineSlab, ModBlocks.divineDoubleSlab));
        register(registry, new ItemModSlab("frozen_slab", ModBlocks.frozenSlab, ModBlocks.frozenSlab, ModBlocks.frozenDoubleSlab));
        register(registry, new ItemModSlab("eucalyptus_slab", ModBlocks.eucalyptusSlab, ModBlocks.eucalyptusSlab, ModBlocks.eucalyptusDoubleSlab));

        register(registry, new ItemModSlab("eden_double_slab", ModBlocks.edenSlab, ModBlocks.edenSlab, ModBlocks.edenDoubleSlab));
        register(registry, new ItemModSlab("wildwood_double_slab", ModBlocks.wildwoodSlab, ModBlocks.wildwoodSlab, ModBlocks.wildwoodDoubleSlab));
        register(registry, new ItemModSlab("apalachia_double_slab", ModBlocks.apalachiaSlab, ModBlocks.apalachiaSlab, ModBlocks.apalachiaDoubleSlab));
        register(registry, new ItemModSlab("skythern_double_slab", ModBlocks.skythernSlab, ModBlocks.skythernSlab, ModBlocks.skythernDoubleSlab));
        register(registry, new ItemModSlab("mortum_double_slab", ModBlocks.mortumSlab, ModBlocks.mortumSlab, ModBlocks.mortumDoubleSlab));
        register(registry, new ItemModSlab("divine_double_slab", ModBlocks.divineSlab, ModBlocks.divineSlab, ModBlocks.divineDoubleSlab));
        register(registry, new ItemModSlab("frozen_double_slab", ModBlocks.frozenSlab, ModBlocks.frozenSlab, ModBlocks.frozenDoubleSlab));
        register(registry, new ItemModSlab("eucalyptus_double_slab", ModBlocks.eucalyptusSlab, ModBlocks.eucalyptusSlab, ModBlocks.eucalyptusDoubleSlab));

        // Shields
        register(registry, new DivineShield("realmite_shield", DivineRPGTabs.armor, () -> realmiteIngot, 1200));
        register(registry, new DivineShield("arlemite_shield", DivineRPGTabs.armor, () -> arlemiteIngot, 1200));

    }

    private static void register(IForgeRegistry<Item> registry, Item item) {
        registry.register(item);
        itemList.add(item);
    }
}