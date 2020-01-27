package divinerpg.registry;

import java.util.ArrayList;
import java.util.List;

import divinerpg.enums.*;
import divinerpg.objects.entities.entity.projectiles.EntitySoundOfCarols;
import divinerpg.objects.entities.entity.projectiles.EntitySoundOfMusic;
import divinerpg.objects.items.arcana.ItemAquamarine;
import divinerpg.objects.items.arcana.ItemArcanaPotion;
import divinerpg.objects.items.arcana.ItemArcanaSeeds;
import divinerpg.objects.items.arcana.ItemArcaniteBlade;
import divinerpg.objects.items.arcana.ItemArcaniteBlaster;
import divinerpg.objects.items.arcana.ItemArcaniumSaber;
import divinerpg.objects.items.arcana.ItemAttractor;
import divinerpg.objects.items.arcana.ItemCaptainsSparkler;
import divinerpg.objects.items.arcana.ItemChargedCollector;
import divinerpg.objects.items.arcana.ItemDivineAccumulator;
import divinerpg.objects.items.arcana.ItemEnderScepter;
import divinerpg.objects.items.arcana.ItemFirefly;
import divinerpg.objects.items.arcana.ItemGeneralsStaff;
import divinerpg.objects.items.arcana.ItemGhostbane;
import divinerpg.objects.items.arcana.ItemGrenade;
import divinerpg.objects.items.arcana.ItemKey;
import divinerpg.objects.items.arcana.ItemLaVekor;
import divinerpg.objects.items.arcana.ItemLamona;
import divinerpg.objects.items.arcana.ItemMeriksMissile;
import divinerpg.objects.items.arcana.ItemMeteorMash;
import divinerpg.objects.items.arcana.ItemOrbOfLight;
import divinerpg.objects.items.arcana.ItemReflector;
import divinerpg.objects.items.arcana.ItemShadowSaber;
import divinerpg.objects.items.arcana.ItemStaffEnrichment;
import divinerpg.objects.items.arcana.ItemStaffStarlight;
import divinerpg.objects.items.arcana.ItemStormSword;
import divinerpg.objects.items.arcana.ItemWizardsBook;
import divinerpg.objects.items.arcana.ItemZelusSpawnEgg;
import divinerpg.objects.items.base.*;
import divinerpg.objects.items.iceika.ItemEggNog;
import divinerpg.objects.items.iceika.ItemMusicShooter;
import divinerpg.objects.items.iceika.ItemSerenadeOfIce;
import divinerpg.objects.items.iceika.ItemSnowGlobe;
import divinerpg.objects.items.twilight.ItemForbiddenFruit;
import divinerpg.objects.items.twilight.ItemSkyFlower;
import divinerpg.objects.items.twilight.ItemTwilightBlitz;
import divinerpg.objects.items.twilight.ItemTwilightClock;
import divinerpg.objects.items.twilight.ItemTwilightSpawner;
import divinerpg.objects.items.vethea.*;
import divinerpg.objects.items.vanilla.*;
import divinerpg.utils.ChatFormats;
import divinerpg.utils.ToolMaterialMod;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
@ObjectHolder("divinerpg")
public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    // Vanilla dimension weapons
    @ObjectHolder("aquatic_maul")
    public static Item aquaticMaul = null;
    @ObjectHolder("aquatic_dagger")
    public static Item aquaticDagger = null;
    @ObjectHolder("aquatic_trident")
    public static Item aquaticTrident = null;
    @ObjectHolder("aquaton")
    public static Item aquaton = null;
    @ObjectHolder("aquatooth_maul")
    public static Item aquatoothMaul = null;
    @ObjectHolder("aquatooth_sword")
    public static Item aquatoothSword = null;
    @ObjectHolder("arlemite_stabber")
    public static Item arlemiteStabber = null;
    @ObjectHolder("bedrock_maul")
    public static Item bedrockMaul = null;
    @ObjectHolder("bedrock_sword")
    public static Item bedrockSword = null;
    @ObjectHolder("black_ender_sword")
    public static Item blackEnderSword = null;
    @ObjectHolder("bloodgem_sword")
    public static Item bloodgem_sword = null;
    @ObjectHolder("blue_divine_sword")
    public static Item blueDivineSword = null;
    @ObjectHolder("blue_ender_sword")
    public static Item blueEnderSword = null;
    @ObjectHolder("bluefire_sword")
    public static Item bluefireSword = null;
    @ObjectHolder("corrupted_maul")
    public static Item corruptedMaul = null;
    @ObjectHolder("crabclaw_maul")
    public static Item crabclawMaul = null;
    @ObjectHolder("cyclopsian_sword")
    public static Item cyclopsianSword = null;
    @ObjectHolder("death_bringer")
    public static Item deathBringer = null;
    @ObjectHolder("divine_sword")
    public static Item divineSword = null;
    @ObjectHolder("dual_claw")
    public static Item dualClaw = null;
    @ObjectHolder("ender_sword")
    public static Item enderSword = null;
    @ObjectHolder("flaming_fury")
    public static Item flamingFury = null;
    @ObjectHolder("frost_sword")
    public static Item frostSword = null;
    @ObjectHolder("fury_maul")
    public static Item furyMaul = null;
    @ObjectHolder("gray_divine_sword")
    public static Item grayDivineSword = null;
    @ObjectHolder("green_divine_sword")
    public static Item greenDivineSword = null;
    @ObjectHolder("green_ender_sword")
    public static Item greenEnderSword = null;
    @ObjectHolder("inferno_sword")
    public static Item infernoSword = null;
    @ObjectHolder("jungle_knife")
    public static Item jungleKnife = null;
    @ObjectHolder("jungle_rapier")
    public static Item jungleRapier = null;
    @ObjectHolder("molten_sword")
    public static Item moltenSword = null;
    @ObjectHolder("ocean_knife")
    public static Item oceanKnife = null;
    @ObjectHolder("poison_saber")
    public static Item poisonSaber = null;
    @ObjectHolder("realmite_sword")
    public static Item realmiteSword = null;
    @ObjectHolder("red_divine_sword")
    public static Item redDivineSword = null;
    @ObjectHolder("red_ender_sword")
    public static Item redEnderSword = null;
    @ObjectHolder("rupee_rapier")
    public static Item rupeeRapier = null;
    @ObjectHolder("sandslash")
    public static Item sandslash = null;
    @ObjectHolder("scorching_sword")
    public static Item scorchingSword = null;
    @ObjectHolder("shark_sword")
    public static Item sharkSword = null;
    @ObjectHolder("slime_sword")
    public static Item slimeSword = null;
    @ObjectHolder("terran_dagger")
    public static Item terranDagger = null;
    @ObjectHolder("terran_knife")
    public static Item terranKnife = null;
    @ObjectHolder("terran_maul")
    public static Item terranMaul = null;
    @ObjectHolder("yellow_divine_sword")
    public static Item yellowDivineSword = null;
    @ObjectHolder("yellow_ender_sword")
    public static Item yellowEnderSword = null;

    @ObjectHolder("bluefire_bow")
    public static Item bluefireBow = null;
    @ObjectHolder("ender_bow")
    public static Item enderBow = null;
    @ObjectHolder("hunter_bow")
    public static Item hunterBow = null;
    @ObjectHolder("inferno_bow")
    public static Item infernoBow = null;
    @ObjectHolder("shadow_bow")
    public static Item shadowBow = null;

    @ObjectHolder("scythe")
    public static Item scythe = null;

    @ObjectHolder("shuriken")
    public static Item shuriken = null;
    @ObjectHolder("vile_storm")
    public static Item vileStorm = null;

    @ObjectHolder("bowhead_anchor")
    public static Item bowheadAnchor = null;
    @ObjectHolder("bowhead_cannon")
    public static Item bowheadCannon = null;
    @ObjectHolder("corrupted_cannon")
    public static Item corruptedCannon = null;
    @ObjectHolder("crab_anchor")
    public static Item crabAnchor = null;
    @ObjectHolder("crabclaw_cannon")
    public static Item crabclawCannon = null;
    @ObjectHolder("cyclopsian_staff")
    public static Item cyclopsianStaff = null;
    @ObjectHolder("frost_cannon")
    public static Item frostCannon = null;
    @ObjectHolder("ghast_cannon")
    public static Item ghastCannon = null;
    @ObjectHolder("golden_fury")
    public static Item goldenFury = null;
    @ObjectHolder("liopleurodon_anchor")
    public static Item liopleurodonAnchor = null;
    @ObjectHolder("maelstrom")
    public static Item maelstrom = null;
    @ObjectHolder("shark_anchor")
    public static Item sharkAnchor = null;

    @ObjectHolder("sound_of_music")
    public static Item soundOfMusic = null;

    @ObjectHolder("serenade_of_death")
    public static Item serenadeOfDeath = null;
    @ObjectHolder("serenade_of_health")
    public static Item serenadeOfHealth = null;
    @ObjectHolder("serenade_of_infusion")
    public static Item serenadeOfInfusion = null;
    @ObjectHolder("serenade_striker")
    public static Item serenadeStriker = null;

    @ObjectHolder("massivence")
    public static Item massivence = null;
    @ObjectHolder("palavence")
    public static Item palavence = null;

    // Vanilla dimension armor
    @ObjectHolder("angelic_helmet")
    public static Item angelicHelmet = null;
    @ObjectHolder("angelic_chestplate")
    public static Item angelicChestplate = null;
    @ObjectHolder("angelic_leggings")
    public static Item angelicLeggings = null;
    @ObjectHolder("angelic_boots")
    public static Item angelicBoots = null;

    @ObjectHolder("aquastrive_helmet")
    public static Item aquastriveHelmet = null;
    @ObjectHolder("aquastrive_chestplate")
    public static Item aquastriveChestplate = null;
    @ObjectHolder("aquastrive_leggings")
    public static Item aquastriveLeggings = null;
    @ObjectHolder("aquastrive_boots")
    public static Item aquastriveBoots = null;

    @ObjectHolder("arlemite_helmet")
    public static Item arlemiteHelmet = null;
    @ObjectHolder("arlemite_chestplate")
    public static Item arlemiteChestplate = null;
    @ObjectHolder("arlemite_leggings")
    public static Item arlemiteLeggings = null;
    @ObjectHolder("arlemite_boots")
    public static Item arlemiteBoots = null;

    @ObjectHolder("bedrock_helmet")
    public static Item bedrockHelmet = null;
    @ObjectHolder("bedrock_chestplate")
    public static Item bedrockChestplate = null;
    @ObjectHolder("bedrock_leggings")
    public static Item bedrockLeggings = null;
    @ObjectHolder("bedrock_boots")
    public static Item bedrockBoots = null;

    @ObjectHolder("corrupted_helmet")
    public static Item corruptedHelmet = null;
    @ObjectHolder("corrupted_chestplate")
    public static Item corruptedChestplate = null;
    @ObjectHolder("corrupted_leggings")
    public static Item corruptedLeggings = null;
    @ObjectHolder("corrupted_boots")
    public static Item corruptedBoots = null;

    @ObjectHolder("divine_helmet")
    public static Item divineHelmet = null;
    @ObjectHolder("divine_chestplate")
    public static Item divineChestplate = null;
    @ObjectHolder("divine_leggings")
    public static Item divineLeggings = null;
    @ObjectHolder("divine_boots")
    public static Item divineBoots = null;

    @ObjectHolder("elite_realmite_helmet")
    public static Item eliteRealmiteHelmet = null;
    @ObjectHolder("elite_realmite_chestplate")
    public static Item eliteRealmiteChestplate = null;
    @ObjectHolder("elite_realmite_leggings")
    public static Item eliteRealmiteLeggings = null;
    @ObjectHolder("elite_realmite_boots")
    public static Item eliteRealmiteBoots = null;

    @ObjectHolder("ender_helmet")
    public static Item enderHelmet = null;
    @ObjectHolder("ender_chestplate")
    public static Item enderChestplate = null;
    @ObjectHolder("ender_leggings")
    public static Item enderLeggings = null;
    @ObjectHolder("ender_boots")
    public static Item enderBoots = null;

    @ObjectHolder("blue_ender_helmet")
    public static Item blueEnderHelmet = null;
    @ObjectHolder("blue_ender_chestplate")
    public static Item blueEnderChestplate = null;
    @ObjectHolder("blue_ender_leggings")
    public static Item blueEnderLeggings = null;
    @ObjectHolder("blue_ender_boots")
    public static Item blueEnderBoots = null;

    @ObjectHolder("gray_ender_helmet")
    public static Item grayEnderHelmet = null;
    @ObjectHolder("gray_ender_chestplate")
    public static Item grayEnderChestplate = null;
    @ObjectHolder("gray_ender_leggings")
    public static Item grayEnderLeggings = null;
    @ObjectHolder("gray_ender_boots")
    public static Item grayEnderBoots = null;

    @ObjectHolder("green_ender_helmet")
    public static Item greenEnderHelmet = null;
    @ObjectHolder("green_ender_chestplate")
    public static Item greenEnderChestplate = null;
    @ObjectHolder("green_ender_leggings")
    public static Item greenEnderLeggings = null;
    @ObjectHolder("green_ender_boots")
    public static Item greenEnderBoots = null;

    @ObjectHolder("red_ender_helmet")
    public static Item redEnderHelmet = null;
    @ObjectHolder("red_ender_chestplate")
    public static Item redEnderChestplate = null;
    @ObjectHolder("red_ender_leggings")
    public static Item redEnderLeggings = null;
    @ObjectHolder("red_ender_boots")
    public static Item redEnderBoots = null;

    @ObjectHolder("yellow_ender_helmet")
    public static Item yellowEnderHelmet = null;
    @ObjectHolder("yellow_ender_chestplate")
    public static Item yellowEnderChestplate = null;
    @ObjectHolder("yellow_ender_leggings")
    public static Item yellowEnderLeggings = null;
    @ObjectHolder("yellow_ender_boots")
    public static Item yellowEnderBoots = null;

    @ObjectHolder("frozen_helmet")
    public static Item frozenHelmet = null;
    @ObjectHolder("frozen_chestplate")
    public static Item frozenChestplate = null;
    @ObjectHolder("frozen_leggings")
    public static Item frozenLeggings = null;
    @ObjectHolder("frozen_boots")
    public static Item frozenBoots = null;

    @ObjectHolder("inferno_helmet")
    public static Item infernoHelmet = null;
    @ObjectHolder("inferno_chestplate")
    public static Item infernoChestplate = null;
    @ObjectHolder("inferno_leggings")
    public static Item infernoLeggings = null;
    @ObjectHolder("inferno_boots")
    public static Item infernoBoots = null;

    @ObjectHolder("jack_o_man_helmet")
    public static Item jackOManHelmet = null;
    @ObjectHolder("jack_o_man_chestplate")
    public static Item jackOManChestplate = null;
    @ObjectHolder("jack_o_man_leggings")
    public static Item jackOManLeggings = null;
    @ObjectHolder("jack_o_man_boots")
    public static Item jackOManBoots = null;

    @ObjectHolder("jungle_helmet")
    public static Item jungleHelmet = null;
    @ObjectHolder("jungle_chestplate")
    public static Item jungleChestplate = null;
    @ObjectHolder("jungle_leggings")
    public static Item jungleLeggings = null;
    @ObjectHolder("jungle_boots")
    public static Item jungleBoots = null;

    @ObjectHolder("kraken_helmet")
    public static Item krakenHelmet = null;
    @ObjectHolder("kraken_chestplate")
    public static Item krakenChestplate = null;
    @ObjectHolder("kraken_leggings")
    public static Item krakenLeggings = null;
    @ObjectHolder("kraken_boots")
    public static Item krakenBoots = null;

    @ObjectHolder("netherite_helmet")
    public static Item netheriteHelmet = null;
    @ObjectHolder("netherite_chestplate")
    public static Item netheriteChestplate = null;
    @ObjectHolder("netherite_leggings")
    public static Item netheriteLeggings = null;
    @ObjectHolder("netherite_boots")
    public static Item netheriteBoots = null;

    @ObjectHolder("realmite_helmet")
    public static Item realmiteHelmet = null;
    @ObjectHolder("realmite_chestplate")
    public static Item realmiteChestplate = null;
    @ObjectHolder("realmite_leggings")
    public static Item realmiteLeggings = null;
    @ObjectHolder("realmite_boots")
    public static Item realmiteBoots = null;

    @ObjectHolder("rupee_helmet")
    public static Item rupeeHelmet = null;
    @ObjectHolder("rupee_chestplate")
    public static Item rupeeChestplate = null;
    @ObjectHolder("rupee_leggings")
    public static Item rupeeLeggings = null;
    @ObjectHolder("rupee_boots")
    public static Item rupeeBoots = null;

    @ObjectHolder("blue_rupee_helmet")
    public static Item blueRupeeHelmet = null;
    @ObjectHolder("blue_rupee_chestplate")
    public static Item blueRupeeChestplate = null;
    @ObjectHolder("blue_rupee_leggings")
    public static Item blueRupeeLeggings = null;
    @ObjectHolder("blue_rupee_boots")
    public static Item blueRupeeBoots = null;

    @ObjectHolder("green_rupee_helmet")
    public static Item greenRupeeHelmet = null;
    @ObjectHolder("green_rupee_chestplate")
    public static Item greenRupeeChestplate = null;
    @ObjectHolder("green_rupee_leggings")
    public static Item greenRupeeLeggings = null;
    @ObjectHolder("green_rupee_boots")
    public static Item greenRupeeBoots = null;

    @ObjectHolder("gray_rupee_helmet")
    public static Item grayRupeeHelmet = null;
    @ObjectHolder("gray_rupee_chestplate")
    public static Item grayRupeeChestplate = null;
    @ObjectHolder("gray_rupee_leggings")
    public static Item grayRupeeLeggings = null;
    @ObjectHolder("gray_rupee_boots")
    public static Item grayRupeeBoots = null;

    @ObjectHolder("red_rupee_helmet")
    public static Item redRupeeHelmet = null;
    @ObjectHolder("red_rupee_chestplate")
    public static Item redRupeeChestplate = null;
    @ObjectHolder("red_rupee_leggings")
    public static Item redRupeeLeggings = null;
    @ObjectHolder("red_rupee_boots")
    public static Item redRupeeBoots = null;

    @ObjectHolder("yellow_rupee_helmet")
    public static Item yellowRupeeHelmet = null;
    @ObjectHolder("yellow_rupee_chestplate")
    public static Item yellowRupeeChestplate = null;
    @ObjectHolder("yellow_rupee_leggings")
    public static Item yellowRupeeLeggings = null;
    @ObjectHolder("yellow_rupee_boots")
    public static Item yellowRupeeBoots = null;

    @ObjectHolder("shadow_helmet")
    public static Item shadowHelmet = null;
    @ObjectHolder("shadow_chestplate")
    public static Item shadowChestplate = null;
    @ObjectHolder("shadow_leggings")
    public static Item shadowLeggings = null;
    @ObjectHolder("shadow_boots")
    public static Item shadowBoots = null;

    @ObjectHolder("skeleman_helmet")
    public static Item skelemanHelmet = null;
    @ObjectHolder("skeleman_chestplate")
    public static Item skelemanChestplate = null;
    @ObjectHolder("skeleman_leggings")
    public static Item skelemanLeggings = null;
    @ObjectHolder("skeleman_boots")
    public static Item skelemanBoots = null;

    @ObjectHolder("terran_helmet")
    public static Item terranHelmet = null;
    @ObjectHolder("terran_chestplate")
    public static Item terranChestplate = null;
    @ObjectHolder("terran_leggings")
    public static Item terranLeggings = null;
    @ObjectHolder("terran_boots")
    public static Item terranBoots = null;

    @ObjectHolder("wither_reaper_helmet")
    public static Item witherReaperHelmet = null;
    @ObjectHolder("wither_reaper_chestplate")
    public static Item witherReaperChestplate = null;
    @ObjectHolder("wither_reaper_leggings")
    public static Item witherReaperLeggings = null;
    @ObjectHolder("wither_reaper_boots")
    public static Item witherReaperBoots = null;


    //DEAL WITH LATER
/*    public static Item diamondHelmet = new ItemDivineArmor(EnumArmor.DIAMOND, EntityEquipmentSlot.HEAD);
    public static Item diamondBody = new ItemDivineArmor(EnumArmor.DIAMOND, EntityEquipmentSlot.CHEST);
    public static Item diamondLegs = new ItemDivineArmor(EnumArmor.DIAMOND, EntityEquipmentSlot.LEGS);
    public static Item diamondBoots = new ItemDivineArmor(EnumArmor.DIAMOND, EntityEquipmentSlot.FEET);

    public static Item ironHelmet = new ItemDivineArmor(EnumArmor.IRON, EntityEquipmentSlot.HEAD);
    public static Item ironBody = new ItemDivineArmor(EnumArmor.IRON, EntityEquipmentSlot.CHEST);
    public static Item ironLegs = new ItemDivineArmor(EnumArmor.IRON, EntityEquipmentSlot.LEGS);
    public static Item ironBoots = new ItemDivineArmor(EnumArmor.IRON, EntityEquipmentSlot.FEET);

    public static Item goldHelmet = new ItemDivineArmor("golden_helmet", EnumArmor.GOLD, EntityEquipmentSlot.HEAD);
    public static Item goldBody = new ItemDivineArmor("golden_chestplate", EnumArmor.GOLD, EntityEquipmentSlot.CHEST);
    public static Item goldLegs = new ItemDivineArmor("golden_leggings", EnumArmor.GOLD, EntityEquipmentSlot.LEGS);
    public static Item goldBoots = new ItemDivineArmor("golden_boots", EnumArmor.GOLD, EntityEquipmentSlot.FEET);*/
    //END DEAL WITH LATER

    @ObjectHolder("arlemite_shovel")
    public static Item arlemiteShovel = null;
    @ObjectHolder("arlemite_pickaxe")
    public static Item arlemitePickaxe = null;
    @ObjectHolder("arlemite_axe")
    public static Item arlemiteAxe = null;
    @ObjectHolder("arlemite_hoe")
    public static Item arlemiteHoe = null;
    @ObjectHolder("arlemite_shickaxe")
    public static Item arlemiteShickaxe = null;

    @ObjectHolder("bedrock_shovel")
    public static Item bedrockShovel = null;
    @ObjectHolder("bedrock_pickaxe")
    public static Item bedrockPickaxe = null;
    @ObjectHolder("bedrock_axe")
    public static Item bedrockAxe = null;

    @ObjectHolder("corrupted_shovel")
    public static Item corruptedShovel = null;
    @ObjectHolder("corrupted_pickaxe")
    public static Item corruptedPickaxe = null;
    @ObjectHolder("corrupted_axe")
    public static Item corruptedAxe = null;

    @ObjectHolder("divine_shovel")
    public static Item divineShovel = null;
    @ObjectHolder("divine_pickaxe")
    public static Item divinePickaxe = null;
    @ObjectHolder("divine_axe")
    public static Item divineAxe = null;
    @ObjectHolder("divine_shickaxe")
    public static Item divineShickaxe = null;

    @ObjectHolder("realmite_shovel")
    public static Item realmiteShovel = null;
    @ObjectHolder("realmite_pickaxe")
    public static Item realmitePickaxe = null;
    @ObjectHolder("realmite_axe")
    public static Item realmiteAxe = null;
    @ObjectHolder("realmite_hoe")
    public static Item realmiteHoe = null;

    @ObjectHolder("rupee_shovel")
    public static Item rupeeShovel = null;
    @ObjectHolder("rupee_pickaxe")
    public static Item rupeePickaxe = null;
    @ObjectHolder("rupee_axe")
    public static Item rupeeAxe = null;
    @ObjectHolder("rupee_hoe")
    public static Item rupeeHoe = null;
    @ObjectHolder("rupee_shickaxe")
    public static Item rupeeShickaxe = null;

    // Teleportation crystal
    @ObjectHolder("teleportation_crystal")
    public static Item teleportationCrystal = null;

    // Vanilla misc items

    // Shards
    @ObjectHolder("corrupted_shards")
    public static Item corruptedShards = null;
    @ObjectHolder("divine_shards")
    public static Item divineShards = null;
    @ObjectHolder("ender_shards")
    public static Item enderShards = null;
    @ObjectHolder("ice_shards")
    public static Item iceShards = null;
    @ObjectHolder("jungle_shards")
    public static Item jungleShards = null;
    @ObjectHolder("molten_shards")
    public static Item moltenShards = null;
    @ObjectHolder("terran_shards")
    public static Item terranShards = null;

    // Stones
    @ObjectHolder("corrupted_stone")
    public static Item corruptedStone = null;
    @ObjectHolder("divine_stone")
    public static Item divineStone = null;
    @ObjectHolder("ender_stone")
    public static Item enderStone = null;
    @ObjectHolder("ice_stone")
    public static Item iceStone = null;
    @ObjectHolder("jungle_stone")
    public static Item jungleStone = null;
    @ObjectHolder("molten_stone")
    public static Item moltenStone = null;
    @ObjectHolder("shadow_stone")
    public static Item shadowStone = null;
    @ObjectHolder("terran_stone")
    public static Item terranStone = null;

    // Ingots
    @ObjectHolder("arlemite_ingot")
    public static Item arlemiteIngot = null;
    @ObjectHolder("hellstone_ingot")
    public static Item hellstoneIngot = null;
    @ObjectHolder("netherite_ingot")
    public static Item netheriteIngot = null;
    @ObjectHolder("realmite_ingot")
    public static Item realmiteIngot = null;
    @ObjectHolder("rupee_ingot")
    public static Item rupeeIngot = null;
    @ObjectHolder("shadow_bar")
    public static Item shadowBar = null;

    // Boss Spawners
    @ObjectHolder("call_of_the_watcher")
    public static Item callOfTheWatcher = null;
    @ObjectHolder("horde_horn")
    public static Item hordeHorn = null;
    @ObjectHolder("infernal_flame")
    public static Item infernalFlame = null;
    @ObjectHolder("mysterious_clock")
    public static Item mysteriousClock = null;
    @ObjectHolder("watching_eye")
    public static Item watchingEye = null;

    // Ayeraco fragments
    @ObjectHolder("ayeraco_fragment_blue")
    public static Item ayeracoFragmentBlue = null;
    @ObjectHolder("ayeraco_fragment_green")
    public static Item ayeracoFragmentGreen = null;
    @ObjectHolder("ayeraco_fragment_purple")
    public static Item ayeracoFragmentPurple = null;
    @ObjectHolder("ayeraco_fragment_red")
    public static Item ayeracoFragmentRed = null;
    @ObjectHolder("ayeraco_fragment_yellow")
    public static Item ayeracoFragmentYellow = null;

    // Diamond chunks
    @ObjectHolder("blue_diamond_chunk")
    public static Item blueDiamondChunk = null;
    @ObjectHolder("gray_diamond_chunk")
    public static Item grayDiamondChunk = null;
    @ObjectHolder("green_diamond_chunk")
    public static Item greenDiamondChunk = null;
    @ObjectHolder("red_diamond_chunk")
    public static Item redDiamondChunk = null;
    @ObjectHolder("yellow_diamond_chunk")
    public static Item yellowDiamondChunk = null;

    // Pet spawn eggs
    @ObjectHolder("brown_grizzle_egg")
    public static Item brownGrizzleEgg = null;
    @ObjectHolder("ehu_egg")
    public static Item ehuEgg = null;
    @ObjectHolder("husk_egg")
    public static Item huskEgg = null;
    @ObjectHolder("smelter_egg")
    public static Item smelterEgg = null;
    @ObjectHolder("snapper_egg")
    public static Item snapperEgg = null;
    @ObjectHolder("stone_golem_egg")
    public static Item stoneGolemEgg = null;
    @ObjectHolder("white_grizzle_egg")
    public static Item whiteGrizzleEgg = null;

    // Miscellaneous resources
    @ObjectHolder("aqua_ball")
    public static Item aquaBall = null;
    @ObjectHolder("aquatic_blaze_rod")
    public static Item aquaticBlazeRod = null;
    @ObjectHolder("aquatic_ingot")
    public static Item aquaticIngot = null;
    @ObjectHolder("aquatic_pellets")
    public static Item aquaticPellets = null;
    @ObjectHolder("bedrock_chunk")
    public static Item bedrockChunk = null;
    @ObjectHolder("bloodgem")
    public static Item bloodgem = null;
    @ObjectHolder("bluefire_stone")
    public static Item bluefireStone = null;
    @ObjectHolder("corrupted_bullet")
    public static Item corruptedBullet = null;
    @ObjectHolder("crab_claw")
    public static Item crabClaw = null;
    @ObjectHolder("cyclops_eye")
    public static Item cyclopsEye = null;
    @ObjectHolder("cyclops_eye_shards")
    public static Item cyclopsEyeShards = null;
    @ObjectHolder("fury_fire")
    public static Item furyFire = null;
    @ObjectHolder("healing_stone")
    public static Item healingStone = null;
    @ObjectHolder("kraken_scale")
    public static Item krakenScale = null;
    @ObjectHolder("kraken_skin")
    public static Item krakenSkin = null;
    @ObjectHolder("legendary_ender_eye")
    public static Item legendaryEnderEye = null;
    @ObjectHolder("liopleurodon_skull")
    public static Item liopleurodonSkull = null;
    @ObjectHolder("liopleurodon_teeth")
    public static Item liopleurodonTeeth = null;
    @ObjectHolder("netherite_chunk")
    public static Item netheriteChunk = null;
    @ObjectHolder("pure_aquatic_pellets")
    public static Item pureAquaticPellets = null;
    @ObjectHolder("purple_blaze")
    public static Item purpleBlaze = null;
    @ObjectHolder("shadow_coins")
    public static Item shadowCoins = null;
    @ObjectHolder("shark_fin")
    public static Item sharkFin = null;
    @ObjectHolder("whale_fin")
    public static Item whaleFin = null;

    // Iceika

    // Iceika dimension weapons - melee
    @ObjectHolder("enderice")
    public static Item enderice = null;
    @ObjectHolder("frostking_sword")
    public static Item frostkingSword = null;
    @ObjectHolder("frozen_maul")
    public static Item frozenMaul = null;
    @ObjectHolder("glacier_sword")
    public static Item glacierSword = null;
    @ObjectHolder("icicle_bane")
    public static Item icicleBane = null;
    @ObjectHolder("icine_sword")
    public static Item icineSword = null;
    @ObjectHolder("snowslash")
    public static Item snowslash = null;
    @ObjectHolder("frossivence")
    public static Item frossivence = null;

    // Iceika dimension weapons - ranged
    @ObjectHolder("icicle_bow")
    public static Item icicleBow = null;
    @ObjectHolder("snowstorm_bow")
    public static Item snowstormBow = null;

    @ObjectHolder("snowflake_shuriken")
    public static Item snowflakeShuriken = null;

    @ObjectHolder("fractite_cannon")
    public static Item fractiteCannon = null;
    @ObjectHolder("frostclaw_cannon")
    public static Item frostclawCannon = null;

    @ObjectHolder("sound_of_carols")
    public static Item soundOfCarols = null;

    @ObjectHolder("serenade_of_ice")
    public static Item serenadeOfIce = null;

    // Iceika dimension armor
    @ObjectHolder("santa_cap")
    public static Item santaCap = null;
    @ObjectHolder("santa_tunic")
    public static Item santaTunic = null;
    @ObjectHolder("santa_pants")
    public static Item santaPants = null;
    @ObjectHolder("santa_boots")
    public static Item santaBoots = null;

    // Iceika misc
    @ObjectHolder("snowflake")
    public static Item snowflake = null;

    // Iceika portal item
    @ObjectHolder("snow_globe")
    public static Item snowGlobe = null;

    /*************************/

    // Foods
    @ObjectHolder("advanced_mushroom_stew")
    public static Item advancedMushroomStew = null;
    @ObjectHolder("bacon")
    public static Item bacon = null;
    @ObjectHolder("boiled_egg")
    public static Item boiledEgg = null;
    @ObjectHolder("cheese")
    public static Item cheese = null;
    @ObjectHolder("chicken_dinner")
    public static Item chickenDinner = null;
    @ObjectHolder("chocolate_log")
    public static Item chocolateLog = null;
    @ObjectHolder("donut")
    public static Item donut = null;
    @ObjectHolder("egg_nog")
    public static Item eggNog = null;
    @ObjectHolder("empowered_meat")
    public static Item empoweredMeat = null;
    @ObjectHolder("enriched_magic_meat")
    public static Item enrichedMagicMeat = null;
    @ObjectHolder("forbidden_fruit")
    public static Item forbiddenFruit = null;
    @ObjectHolder("fruit_cake")
    public static Item fruitCake = null;
    @ObjectHolder("hot_pumpkin_pie")
    public static Item hotPumpkinPie = null;
    @ObjectHolder("magic_meat")
    public static Item magicMeat = null;
    @ObjectHolder("moonbulb")
    public static Item moonbulb = null;
    @ObjectHolder("peppermints")
    public static Item peppermints = null;
    @ObjectHolder("pink_glowbone")
    public static Item pinkGlowbone = null;
    @ObjectHolder("purple_glowbone")
    public static Item purpleGlowbone = null;
    @ObjectHolder("raw_empowered_meat")
    public static Item rawEmpoweredMeat = null;
    @ObjectHolder("sky_flower")
    public static Item skyFlower = null;
    @ObjectHolder("snow_cones")
    public static Item snowCones = null;
    @ObjectHolder("tomato")
    public static Item tomato = null;
    @ObjectHolder("white_mushroom")
    public static Item whiteMushroom = null;
    @ObjectHolder("winterberry")
    public static Item winterberry = null;

    // Twilight Dimensions

    // Twilight souls
    @ObjectHolder("eden_soul")
    public static Item edenSoul = null;
    @ObjectHolder("wildwood_soul")
    public static Item wildwoodSoul = null;
    @ObjectHolder("apalachia_soul")
    public static Item apalachiaSoul = null;
    @ObjectHolder("skythern_soul")
    public static Item skythernSoul = null;
    @ObjectHolder("mortum_soul")
    public static Item mortumSoul = null;

    // Twilight fragments
    @ObjectHolder("eden_fragments")
    public static Item edenFragments = null;
    @ObjectHolder("wildwood_fragments")
    public static Item wildwoodFragments = null;
    @ObjectHolder("apalachia_fragments")
    public static Item apalachiaFragments = null;
    @ObjectHolder("skythern_fragments")
    public static Item skythernFragments = null;
    @ObjectHolder("mortum_fragments")
    public static Item mortumFragments = null;

    // Twilight gems
    @ObjectHolder("eden_gem")
    public static Item edenGem = null;
    @ObjectHolder("wildwood_gem")
    public static Item wildwoodGem = null;
    @ObjectHolder("apalachia_gem")
    public static Item apalachiaGem = null;
    @ObjectHolder("skythern_gem")
    public static Item skythernGem = null;
    @ObjectHolder("mortum_gem")
    public static Item mortumGem = null;

    // Twilight chunks
    @ObjectHolder("eden_chunk")
    public static Item edenChunk = null;
    @ObjectHolder("wildwood_chunk")
    public static Item wildwoodChunk = null;
    @ObjectHolder("apalachia_chunk")
    public static Item apalachiaChunk = null;
    @ObjectHolder("skythern_chunk")
    public static Item skythernChunk = null;
    @ObjectHolder("mortum_chunk")
    public static Item mortumChunk = null;

    // Twilight dust
    @ObjectHolder("eden_dust")
    public static Item edenDust = null;
    @ObjectHolder("wildwood_dust")
    public static Item wildwoodDust = null;
    @ObjectHolder("apalachia_dust")
    public static Item apalachiaDust = null;
    @ObjectHolder("skythern_dust")
    public static Item skythernDust = null;
    @ObjectHolder("mortum_dust")
    public static Item mortumDust = null;

    // Twilight swords
    @ObjectHolder("eden_blade")
    public static Item edenBlade = null;
    @ObjectHolder("wildwood_blade")
    public static Item wildwoodBlade = null;
    @ObjectHolder("apalachia_blade")
    public static Item apalachiaBlade = null;
    @ObjectHolder("skythern_blade")
    public static Item skythernBlade = null;
    @ObjectHolder("mortum_blade")
    public static Item mortumBlade = null;
    @ObjectHolder("halite_blade")
    public static Item haliteBlade = null;

    // Twilight bows
    @ObjectHolder("eden_bow")
    public static Item edenBow = null;
    @ObjectHolder("wildwood_bow")
    public static Item wildwoodBow = null;
    @ObjectHolder("apalachia_bow")
    public static Item apalachiaBow = null;
    @ObjectHolder("skythern_bow")
    public static Item skythernBow = null;
    @ObjectHolder("mortum_bow")
    public static Item mortumBow = null;
    @ObjectHolder("halite_bow")
    public static Item haliteBow = null;
    @ObjectHolder("twilight_bow")
    public static Item twilightBow = null;

    // Twilight slicers
    @ObjectHolder("eden_slicer")
    public static Item edenSlicer = null;
    @ObjectHolder("wildwood_slicer")
    public static Item wildwoodSlicer = null;
    @ObjectHolder("apalachia_slicer")
    public static Item apalachiaSlicer = null;
    @ObjectHolder("skythern_slicer")
    public static Item skythernSlicer = null;
    @ObjectHolder("mortum_slicer")
    public static Item mortumSlicer = null;
    @ObjectHolder("halite_slicer")
    public static Item haliteSlicer = null;

    // Twilight blitzes
    @ObjectHolder("eden_blitz")
    public static Item edenBlitz = null;
    @ObjectHolder("wildwood_blitz")
    public static Item wildwoodBlitz = null;
    @ObjectHolder("apalachia_blitz")
    public static Item apalachiaBlitz = null;
    @ObjectHolder("skythern_blitz")
    public static Item skythernBlitz = null;
    @ObjectHolder("mortum_blitz")
    public static Item mortumBlitz = null;
    @ObjectHolder("halite_blitz")
    public static Item haliteBlitz = null;

    // Twilight phasers
    @ObjectHolder("eden_phaser")
    public static Item edenPhaser = null;
    @ObjectHolder("wildwood_phaser")
    public static Item wildwoodPhaser = null;
    @ObjectHolder("apalachia_phaser")
    public static Item apalachiaPhaser = null;
    @ObjectHolder("skythern_phaser")
    public static Item skythernPhaser = null;
    @ObjectHolder("mortum_phaser")
    public static Item mortumPhaser = null;
    @ObjectHolder("halite_phaser")
    public static Item halitePhaser = null;

    // Twilight tools
    @ObjectHolder("eden_shovel")
    public static Item edenShovel = null;
    @ObjectHolder("eden_pickaxe")
    public static Item edenPickaxe = null;
    @ObjectHolder("eden_axe")
    public static Item edenAxe = null;

    @ObjectHolder("wildwood_shovel")
    public static Item wildwoodShovel = null;
    @ObjectHolder("wildwood_pickaxe")
    public static Item wildwoodPickaxe = null;
    @ObjectHolder("wildwood_axe")
    public static Item wildwoodAxe = null;

    @ObjectHolder("apalachia_shovel")
    public static Item apalachiaShovel = null;
    @ObjectHolder("apalachia_pickaxe")
    public static Item apalachiaPickaxe = null;
    @ObjectHolder("apalachia_axe")
    public static Item apalachiaAxe = null;

    @ObjectHolder("skythern_shovel")
    public static Item skythernShovel = null;
    @ObjectHolder("skythern_pickaxe")
    public static Item skythernPickaxe = null;
    @ObjectHolder("skythern_axe")
    public static Item skythernAxe = null;

    @ObjectHolder("mortum_shovel")
    public static Item mortumShovel = null;
    @ObjectHolder("mortum_pickaxe")
    public static Item mortumPickaxe = null;
    @ObjectHolder("mortum_axe")
    public static Item mortumAxe = null;

    // Twilight armor
    @ObjectHolder("eden_helmet")
    public static Item edenHelmet = null;
    @ObjectHolder("eden_chestplate")
    public static Item edenChestplate = null;
    @ObjectHolder("eden_leggings")
    public static Item edenLeggings = null;
    @ObjectHolder("eden_boot")
    public static Item edenBoot = null;

    @ObjectHolder("wildwood_helmet")
    public static Item wildwoodHelmet = null;
    @ObjectHolder("wildwood_chestplate")
    public static Item wildwoodChestplate = null;
    @ObjectHolder("wildwood_leggings")
    public static Item wildwoodLeggings = null;
    @ObjectHolder("wildwood_boots")
    public static Item wildwoodBoots = null;

    @ObjectHolder("apalachia_helmet")
    public static Item apalachiaHelmet = null;
    @ObjectHolder("apalachia_chestplate")
    public static Item apalachiaChestplate = null;
    @ObjectHolder("apalachia_leggings")
    public static Item apalachiaLeggings = null;
    @ObjectHolder("apalachia_boots")
    public static Item apalachiaBoots = null;

    @ObjectHolder("skythern_helmet")
    public static Item skythernHelmet = null;
    @ObjectHolder("skythern_chestplate")
    public static Item skythernChestplate = null;
    @ObjectHolder("skythern_leggings")
    public static Item skythernLeggings = null;
    @ObjectHolder("skythern_boots")
    public static Item skythernBoots = null;

    @ObjectHolder("mortum_helmet")
    public static Item mortumHelmet = null;
    @ObjectHolder("mortum_chestplate")
    public static Item mortumChestplate = null;
    @ObjectHolder("mortum_leggings")
    public static Item mortumLeggings = null;
    @ObjectHolder("mortum_boots")
    public static Item mortumBoots = null;

    @ObjectHolder("halite_helmet")
    public static Item haliteHelmet = null;
    @ObjectHolder("halite_chestplate")
    public static Item haliteChestplate = null;
    @ObjectHolder("halite_leggings")
    public static Item haliteLeggings = null;
    @ObjectHolder("halite_boots")
    public static Item haliteBoots = null;

    // Twilight boss spawners
    @ObjectHolder("densos_crystal")
    public static Item densosCrystal = null;
    @ObjectHolder("eternal_archer_crystal")
    public static Item eternalArcherCrystal = null;
    @ObjectHolder("karot_crystal")
    public static Item karotCrystal = null;
    @ObjectHolder("reyvor_crystal")
    public static Item reyvorCrystal = null;
    @ObjectHolder("soul_fiend_crystal")
    public static Item soulFiendCrystal = null;
    @ObjectHolder("twilight_demon_crystal")
    public static Item twilightDemonCrystal = null;
    @ObjectHolder("vamacheron_crystal")
    public static Item vamacheronCrystal = null;

    // Twilight portal item
    @ObjectHolder("twilight_clock")
    public static Item twilightClock = null;

    // Twilight arrows
    @ObjectHolder("eden_arrow")
    public static Item edenArrow = null;
    @ObjectHolder("fury_arrow")
    public static Item furyArrow = null;
    @ObjectHolder("wildwood_arrow")
    public static Item wildwoodArrow = null;

    // Twilight miscellaneous
    @ObjectHolder("base_spawn_crystal")
    public static Item baseSpawnCrystal = null;
    @ObjectHolder("eden_sparkles")
    public static Item edenSparkles = null;

    // Arcana

    // Arcana melee
    @ObjectHolder("arcanite_blade")
    public static Item arcaniteBlade = null;
    @ObjectHolder("arcanium_saber")
    public static Item arcaniumSaber = null;
    @ObjectHolder("ender_scepter")
    public static Item enderScepter = null;
    @ObjectHolder("livicia_sword")
    public static Item liviciaSword = null;
    @ObjectHolder("shadow_saber")
    public static Item shadowSaber = null;
    @ObjectHolder("storm_sword")
    public static Item stormSword = null;

    // Arcana ranged
    @ObjectHolder("arcanite_blaster")
    public static Item arcaniteBlaster = null;
    @ObjectHolder("captains_sparkler")
    public static Item captainsSparkler = null;
    @ObjectHolder("firefly")
    public static Item firefly = null;
    @ObjectHolder("generals_staff")
    public static Item generalsStaff = null;
    @ObjectHolder("la_vekor")
    public static Item laVekor = null;
    @ObjectHolder("meriks_missile")
    public static Item meriksMissile = null;
    @ObjectHolder("meteor_mash")
    public static Item meteorMash = null;
    @ObjectHolder("staff_of_starlight")
    public static Item staffOfStarlight = null;
    @ObjectHolder("starlight")
    public static Item starlight = null;

    // Arcana throwable
    @ObjectHolder("grenade")
    public static Item grenade = null;

    // Arcana utility
    @ObjectHolder("arcanium_attractor")
    public static Item arcaniumAttractor = null;
    @ObjectHolder("arcanium_reflector")
    public static Item arcaniumReflector = null;
    @ObjectHolder("divine_accumulator")
    public static Item divineAccumulator = null;
    @ObjectHolder("ghostbane")
    public static Item ghostbane = null;
    @ObjectHolder("orb_of_light")
    public static Item orbOfLight = null;
    @ObjectHolder("staff_of_enrichment")
    public static Item staffOfEnrichment = null;

    // Arcana armor sets
    @ObjectHolder("korma_helmet")
    public static Item kormaHelmet = null;
    @ObjectHolder("korma_chestplate")
    public static Item kormaChestplate = null;
    @ObjectHolder("korma_leggings")
    public static Item kormaLeggings = null;
    @ObjectHolder("korma_boots")
    public static Item kormaBoots = null;

    @ObjectHolder("vemos_helmet")
    public static Item vemosHelmet = null;
    @ObjectHolder("vemos_chestplate")
    public static Item vemosChestplate = null;
    @ObjectHolder("vemos_leggings")
    public static Item vemosLeggings = null;
    @ObjectHolder("vemos_boots")
    public static Item vemosBoots = null;

    // Arcana boss spawner
    @ObjectHolder("wizards_book")
    public static Item wizardsBook = null;

    // Arcana pet spawners
    @ObjectHolder("fyracryx_egg")
    public static Item fyracryxEgg = null;
    @ObjectHolder("golem_of_rejuvenation_egg")
    public static Item golemOfRejuvenationEgg = null;
    @ObjectHolder("paratiku_egg")
    public static Item paratikuEgg = null;
    @ObjectHolder("seimer_egg")
    public static Item seimerEgg = null;

    // Arcana non-food crops

    // Arcana keys
    @ObjectHolder("ancient_key")
    public static Item ancientKey = null;
    @ObjectHolder("degraded_key")
    public static Item degradedKey = null;
    @ObjectHolder("sludge_key")
    public static Item sludgeKey = null;
    @ObjectHolder("soul_key")
    public static Item soulKey = null;

    // Arcana potions
    @ObjectHolder("strong_arcana_potion")
    public static Item strongArcanaPotion = null;
    @ObjectHolder("weak_arcana_potion")
    public static Item weakArcanaPotion = null;

    // Arcana crops
    @ObjectHolder("aquamarine")
    public static Item aquamarine = null;
    @ObjectHolder("firestock")
    public static Item firestock = null;
    @ObjectHolder("hitchak")
    public static Item hitchak = null;
    @ObjectHolder("lamona")
    public static Item lamona = null;
    @ObjectHolder("marsine")
    public static Item marsine = null;
    @ObjectHolder("pinfly")
    public static Item pinfly = null;
    @ObjectHolder("veilo")
    public static Item veilo = null;

    // Arcana miscellaneous
    @ObjectHolder("arcanium")
    public static Item arcanium = null;
    @ObjectHolder("charged_collector")
    public static Item chargedCollector = null;
    @ObjectHolder("collector")
    public static Item collector = null;
    @ObjectHolder("dungeon_tokens")
    public static Item dungeonTokens = null;

    //Seeds
    @ObjectHolder("aquamarine_seeds")
    public static Item aquamarineSeeds = null;
    @ObjectHolder("eucalyptus_root_seeds")
    public static Item eucalyptusRootSeeds = null;
    @ObjectHolder("firestock_seeds")
    public static Item firestockSeeds = null;
    @ObjectHolder("hitchak_seeds")
    public static Item hitchakSeeds = null;
    @ObjectHolder("lamona_seeds")
    public static Item lamonaSeeds = null;
    @ObjectHolder("marsine_seeds")
    public static Item marsineSeeds = null;
    @ObjectHolder("moonbulb_seeds")
    public static Item moonbulbSeeds = null;
    @ObjectHolder("pinfly_seeds")
    public static Item pinflySeeds = null;
    @ObjectHolder("pink_glowbone_seeds")
    public static Item pinkGlowboneSeeds = null;
    @ObjectHolder("purple_glowbone_seeds")
    public static Item purpleGlowboneSeeds = null;
    @ObjectHolder("sky_plant_seeds")
    public static Item skyPlantSeeds = null;
    @ObjectHolder("tomato_seeds")
    public static Item tomatoSeeds = null;
    @ObjectHolder("veilo_seeds")
    public static Item veiloSeeds = null;
    @ObjectHolder("white_mushroom_seeds")
    public static Item whiteMushroomSeeds = null;

    // Vethea
    // Vethea pearls
    @ObjectHolder("dirty_pearls")
    public static Item dirtyPearls = null;
    @ObjectHolder("clean_pearls")
    public static Item cleanPearls = null;
    @ObjectHolder("polished_pearls")
    public static Item polishedPearls = null;
    @ObjectHolder("shiny_pearls")
    public static Item shinyPearls = null;

    // Vethea lumps
    @ObjectHolder("teaker_lump")
    public static Item teakerLump = null;
    @ObjectHolder("amthirmis_lump")
    public static Item amthirmisLump = null;
    @ObjectHolder("darven_lump")
    public static Item darvenLump = null;
    @ObjectHolder("cermile_lump")
    public static Item cermileLump = null;
    @ObjectHolder("pardimal_lump")
    public static Item pardimalLump = null;
    @ObjectHolder("quadrotic_lump")
    public static Item quadroticLump = null;
    @ObjectHolder("karos_lump")
    public static Item karosLump = null;
    @ObjectHolder("heliosis_lump")
    public static Item heliosisLump = null;
    @ObjectHolder("arksiane_lump")
    public static Item arksianeLump = null;


    // Vethea templates
    @ObjectHolder("backsword_template")
    public static Item backswordTemplate = null;
    @ObjectHolder("bow_template")
    public static Item bowTemplate = null;
    @ObjectHolder("cannon_template")
    public static Item cannonTemplate = null;
    @ObjectHolder("claw_template")
    public static Item clawTemplate = null;
    @ObjectHolder("disk_template")
    public static Item diskTemplate = null;
    @ObjectHolder("hammer_template")
    public static Item hammerTemplate = null;
    @ObjectHolder("staff_template")
    public static Item staffTemplate = null;

    @ObjectHolder("degraded_template")
    public static Item degradedTemplate = null;
    @ObjectHolder("finished_template")
    public static Item finishedTemplate = null;
    @ObjectHolder("glistening_template")
    public static Item glisteningTemplate = null;
    @ObjectHolder("demonized_template")
    public static Item demonizedTemplate = null;
    @ObjectHolder("tormented_template")
    public static Item tormentedTemplate = null;

    // Vethea food
    @ObjectHolder("dream_carrot")
    public static Item dreamCarrot = null;
    @ObjectHolder("dream_melon")
    public static Item dreamMelon = null;
    @ObjectHolder("dream_pie")
    public static Item dreamPie = null;
    @ObjectHolder("dream_cake")
    public static Item dreamCake = null;
    @ObjectHolder("dream_sweets")
    public static Item dreamSweets = null;
    @ObjectHolder("dream_sours")
    public static Item dreamSours = null;
    @ObjectHolder("honeysuckle")
    public static Item honeysuckle = null;
    @ObjectHolder("honeychunk")
    public static Item honeychunk = null;

    // Vethea boss spawners
    @ObjectHolder("dream_flint")
    public static Item dreamFlint = null;
    @ObjectHolder("moon_clock")
    public static Item moonClock = null;

    // Vethea weapons
    // Backsword
    @ObjectHolder("teaker_backsword")
    public static Item teakerBacksword = null;
    @ObjectHolder("amthirmis_backsword")
    public static Item amthirmisBacksword = null;
    @ObjectHolder("darven_backsword")
    public static Item darvenBacksword = null;
    @ObjectHolder("cermile_backsword")
    public static Item cermileBacksword = null;
    @ObjectHolder("pardimal_backsword")
    public static Item pardimalBacksword = null;
    @ObjectHolder("quadrotic_backsword")
    public static Item quadroticBacksword = null;
    @ObjectHolder("karos_backsword")
    public static Item karosBacksword = null;
    @ObjectHolder("heliosis_backsword")
    public static Item heliosisBacksword = null;
    @ObjectHolder("arksiane_backsword")
    public static Item arksianeBacksword = null;

    // Bow
    @ObjectHolder("teaker_bow")
    public static Item teakerBow = null;
    @ObjectHolder("amthirmis_bow")
    public static Item amthirmisBow = null;
    @ObjectHolder("darven_bow")
    public static Item darvenBow = null;
    @ObjectHolder("cermile_bow")
    public static Item cermileBow = null;
    @ObjectHolder("pardimal_bow")
    public static Item pardimalBow = null;
    @ObjectHolder("quadrotic_bow")
    public static Item quadroticBow = null;
    @ObjectHolder("karos_bow")
    public static Item karosBow = null;
    @ObjectHolder("heliosis_bow")
    public static Item heliosisBow = null;
    @ObjectHolder("arksiane_bow")
    public static Item arksianeBow = null;
    @ObjectHolder("everfright")
    public static Item everfright = null;

    // Cannon
    @ObjectHolder("teaker_cannon")
    public static Item teakerCannon = null;
    @ObjectHolder("amthirmis_cannon")
    public static Item amthirmisCannon = null;
    @ObjectHolder("darven_cannon")
    public static Item darvenCannon = null;
    @ObjectHolder("cermile_cannon")
    public static Item cermileCannon = null;
    @ObjectHolder("pardimal_cannon")
    public static Item pardimalCannon = null;
    @ObjectHolder("quadrotic_cannon")
    public static Item quadroticCannon = null;
    @ObjectHolder("karos_cannon")
    public static Item karosCannon = null;
    @ObjectHolder("heliosis_cannon")
    public static Item heliosisCannon = null;
    @ObjectHolder("arksiane_cannon")
    public static Item arksianeCannon = null;
    @ObjectHolder("eversight")
    public static Item eversight = null;

    // Claw
    @ObjectHolder("teaker_claw")
    public static Item teakerClaw = null;
    @ObjectHolder("amthirmis_claw")
    public static Item amthirmisClaw = null;
    @ObjectHolder("darven_claw")
    public static Item darvenClaw = null;
    @ObjectHolder("cermile_claw")
    public static Item cermileClaw = null;
    @ObjectHolder("pardimal_claw")
    public static Item pardimalClaw = null;
    @ObjectHolder("quadrotic_claw")
    public static Item quadroticClaw = null;
    @ObjectHolder("karos_claw")
    public static Item karosClaw = null;
    @ObjectHolder("heliosis_claw")
    public static Item heliosisClaw = null;
    @ObjectHolder("arksiane_claw")
    public static Item arksianeClaw = null;
    @ObjectHolder("everbright")
    public static Item everbright = null;

    // Disk
    @ObjectHolder("teaker_disk")
    public static Item teakerDisk = null;
    @ObjectHolder("amthirmis_disk")
    public static Item amthirmisDisk = null;
    @ObjectHolder("darven_disk")
    public static Item darvenDisk = null;
    @ObjectHolder("cermile_disk")
    public static Item cermileDisk = null;
    @ObjectHolder("pardimal_disk")
    public static Item pardimalDisk = null;
    @ObjectHolder("quadrotic_disk")
    public static Item quadroticDisk = null;
    @ObjectHolder("karos_disk")
    public static Item karosDisk = null;
    @ObjectHolder("heliosis_disk")
    public static Item heliosisDisk = null;
    @ObjectHolder("arksiane_disk")
    public static Item arksianeDisk = null;

    // Hammer
    @ObjectHolder("teaker_hammer")
    public static Item teakerHammer = null;
    @ObjectHolder("amthirmis_hammer")
    public static Item amthirmisHammer = null;
    @ObjectHolder("darven_hammer")
    public static Item darvenHammer = null;
    @ObjectHolder("cermile_hammer")
    public static Item cermileHammer = null;
    @ObjectHolder("pardimal_hammer")
    public static Item pardimalHammer = null;
    @ObjectHolder("quadrotic_hammer")
    public static Item quadroticHammer = null;
    @ObjectHolder("karos_hammer")
    public static Item karosHammer = null;
    @ObjectHolder("heliosis_hammer")
    public static Item heliosisHammer = null;
    @ObjectHolder("arksiane_hammer")
    public static Item arksianeHammer = null;
    @ObjectHolder("everlight")
    public static Item everlight = null;
    @ObjectHolder("karos_rockmaul")
    public static Item karosRockmaul = null;

    // Staff
    @ObjectHolder("teaker_staff")
    public static Item teakerStaff = null;
    @ObjectHolder("amthirmis_staff")
    public static Item amthirmisStaff = null;
    @ObjectHolder("darven_staff")
    public static Item darvenStaff = null;
    @ObjectHolder("cermile_staff")
    public static Item cermileStaff = null;
    @ObjectHolder("pardimal_staff")
    public static Item pardimalStaff = null;
    @ObjectHolder("quadrotic_staff")
    public static Item quadroticStaff = null;
    @ObjectHolder("karos_staff")
    public static Item karosStaff = null;
    @ObjectHolder("heliosis_staff")
    public static Item heliosisStaff = null;
    @ObjectHolder("arksiane_staff")
    public static Item arksianeStaff = null;
    @ObjectHolder("evernight")
    public static Item evernight = null;

    // Vethea arrows
    @ObjectHolder("teaker_arrow")
    public static Item teakerArrow = null;
    @ObjectHolder("darven_arrow")
    public static Item darvenArrow = null;
    @ObjectHolder("pardimal_arrow")
    public static Item pardimalArrow = null;
    @ObjectHolder("karos_arrow")
    public static Item karosArrow = null;
    @ObjectHolder("ever_arrow")
    public static Item everArrow = null;

    // Vethea armor sets
    @ObjectHolder("degraded_helmet")
    public static Item degradedHelmet = null;
    @ObjectHolder("degraded_hood")
    public static Item degradedHood = null;
    @ObjectHolder("degraded_mask")
    public static Item degradedMask = null;
    @ObjectHolder("degraded_chestplate")
    public static Item degradedChestplate = null;
    @ObjectHolder("degraded_leggings")
    public static Item degradedLeggings = null;
    @ObjectHolder("degraded_boots")
    public static Item degradedBoots = null;

    @ObjectHolder("finished_helmet")
    public static Item finishedHelmet = null;
    @ObjectHolder("finished_hood")
    public static Item finishedHood = null;
    @ObjectHolder("finished_mask")
    public static Item finishedMask = null;
    @ObjectHolder("finished_chestplate")
    public static Item finishedChestplate = null;
    @ObjectHolder("finished_leggings")
    public static Item finishedLeggings = null;
    @ObjectHolder("finished_boots")
    public static Item finishedBoots = null;

    @ObjectHolder("glistening_helmet")
    public static Item glisteningHelmet = null;
    @ObjectHolder("glistening_hood")
    public static Item glisteningHood = null;
    @ObjectHolder("glistening_mask")
    public static Item glisteningMask = null;
    @ObjectHolder("glistening_chestplate")
    public static Item glisteningChestplate = null;
    @ObjectHolder("glistening_leggings")
    public static Item glisteningLeggings = null;
    @ObjectHolder("glistening_boots")
    public static Item glisteningBoots = null;

    @ObjectHolder("demonized_helmet")
    public static Item demonizedHelmet = null;
    @ObjectHolder("demonized_hood")
    public static Item demonizedHood = null;
    @ObjectHolder("demonized_mask")
    public static Item demonizedMask = null;
    @ObjectHolder("demonized_chestplate")
    public static Item demonizedChestplate = null;
    @ObjectHolder("demonized_leggings")
    public static Item demonizedLeggings = null;
    @ObjectHolder("demonized_boots")
    public static Item demonizedBoots = null;

    @ObjectHolder("tormented_helmet")
    public static Item tormentedHelmet = null;
    @ObjectHolder("tormented_hood")
    public static Item tormentedHood = null;
    @ObjectHolder("tormented_mask")
    public static Item tormentedMask = null;
    @ObjectHolder("tormented_chestplate")
    public static Item tormentedChestplate = null;
    @ObjectHolder("tormented_leggings")
    public static Item tormentedLeggings = null;
    @ObjectHolder("tormented_boots")
    public static Item tormentedBoots = null;

    // Vethea portal item
    @ObjectHolder("nightmare_bed")
    public static Item nightmareBed = null;

    // Vethea miscellaneous
    @ObjectHolder("acid")
    public static Item acid = null;
    @ObjectHolder("band_of_heiva_hunting")
    public static Item bandOfHeivaHunting = null;
    @ObjectHolder("miners_amulet")
    public static Item minersAmulet = null;
    @ObjectHolder("rock_chunks")
    public static Item rockChunks = null;
    /*
    public static Item barredDoor = new ItemModDoor(VetheaBlocks.barredDoor, "barredDoor").setCreativeTab(DivineRPGTabs.vethea);
*/

    // Armor information
    // Vanilla dimensions
    private static Object[] angelicInfo = new Object[] { ArmorInfo.NO_FALL, ArmorInfo.FLY };
    private static Object[] aquastriveInfo = new Object[] { ArmorInfo.UNDERWATER, ArmorInfo.SWIM };
    private static Object[] arlemiteInfo = new Object[] { 85, ArmorInfo.RANGED_PROTECTION };
    private static Object[] bedrockInfo = new Object[] { ArmorInfo.FIRE_PROTECTION, ArmorInfo.EXPLOSION_PROTECTION };
    private static Object[] corruptedInfo = new Object[] { 20, ArmorInfo.RANGED_DAMAGE };
    private static Object[] divineInfo = new Object[] { 6, ArmorInfo.MELEE_DAMAGE, 2, ArmorInfo.JUMP_HEIGHT,
            ArmorInfo.NO_FALL };
    private static Object[] eliteRealmiteInfo = new Object[] { ArmorInfo.NO_FALL };
    private static Object[] enderInfo = new Object[] { ArmorInfo.EXPLOSION_PROTECTION };
    private static Object[] frozenInfo = new Object[] { ArmorInfo.FREEZE };
    private static Object[] infernoInfo = new Object[] { ArmorInfo.FIRE_PROTECTION };
    private static Object[] jackomanInfo = new Object[] { 3, ArmorInfo.SCYTHE_DAMAGE };
    private static Object[] jungleInfo = new Object[] { ArmorInfo.POISON_PROTECTION };
    private static Object[] krakenInfo = new Object[] { ArmorInfo.UNDERWATER };
    private static Object[] netheriteInfo = new Object[] { ArmorInfo.FIRE_PROTECTION };
    private static Object[] rupeeInfo = new Object[] { 85, ArmorInfo.MELEE_PROTECTION };
    private static Object[] shadowInfo = new Object[] { 3, ArmorInfo.SPEED };
    private static Object[] skelemanInfo = new Object[] { ArmorInfo.HUNGER };
    private static Object[] terranInfo = new Object[] { 20, ArmorInfo.HASTE };
    private static Object[] witherReaperInfo = new Object[] { ArmorInfo.WITHER_PROTECTION };

    // Iceika
    private static Object[] santaInfo = new Object[] { ChatFormats.ICEIKA, "Massive Buff", 2, ArmorInfo.SPEED, 6,
            ArmorInfo.MELEE_DAMAGE, ArmorInfo.HUNGER, 80, ArmorInfo.DAMAGE_REDUCTION };

    // Twilight
    private static Object[] edenInfo = new Object[] { 3, ArmorInfo.ORE_DROPS };
    private static Object[] wildInfo = new Object[] { ArmorInfo.UNDERWATER_HEALTH_REGEN };
    private static Object[] apInfo = new Object[] { ArmorInfo.BLOCK_PROTECTION };
    private static Object[] skyInfo = new Object[] { 5, ArmorInfo.JUMP_HEIGHT, ArmorInfo.NO_FALL };
    private static Object[] mortInfo = new Object[] { ArmorInfo.NIGHT_VISION };
    private static Object[] halInfo = new Object[] { 16, ArmorInfo.MELEE_DAMAGE };

    // Arcana
    private static Object[] kormInfo = new Object[] { ArmorInfo.ARCANA_REGEN };
    private static Object[] vemInfo = new Object[] { ArmorInfo.HEALTH_REGEN };

    // Vethea
    private static Object[] basicHelmInfo = { 15, ArmorInfo.MELEE_PROTECTION };
    private static Object[] basicMaskInfo = { 15, ArmorInfo.RANGED_PROTECTION };
    private static Object[] basicHoodInfo = { 15, ArmorInfo.ARCANA_PROTECTION };
    private static Object[] glisteningHelmInfo = { 15, ArmorInfo.MELEE_PROTECTION, 3, ArmorInfo.MELEE_DAMAGE };
    private static Object[] glisteningMaskInfo = { 15, ArmorInfo.RANGED_PROTECTION, 1.4, ArmorInfo.SPEED };
    private static Object[] glisteningHoodInfo = { 15, ArmorInfo.ARCANA_PROTECTION, 2, ArmorInfo.JUMP_HEIGHT, ArmorInfo.NO_FALL };
    private static Object[] demonizedHelmInfo = { 15, ArmorInfo.MELEE_PROTECTION, 6, ArmorInfo.MELEE_DAMAGE };
    private static Object[] demonizedMaskInfo = { 15, ArmorInfo.RANGED_PROTECTION, 1.8, ArmorInfo.SPEED };
    private static Object[] demonizedHoodInfo = { 15, ArmorInfo.ARCANA_PROTECTION, 3, ArmorInfo.JUMP_HEIGHT, ArmorInfo.NO_FALL };
    private static Object[] tormentedHelmInfo = { 15, ArmorInfo.MELEE_PROTECTION, 9, ArmorInfo.MELEE_DAMAGE };
    private static Object[] tormentedMaskInfo = { 15, ArmorInfo.RANGED_PROTECTION, 2.2, ArmorInfo.SPEED };
    private static Object[] tormentedHoodInfo = { 15, ArmorInfo.ARCANA_PROTECTION, 4, ArmorInfo.JUMP_HEIGHT, ArmorInfo.NO_FALL };

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        // Vanilla dimension weapons
        registry.register(new ItemModSword(ToolMaterialMod.AquaDagger, "aquatic_dagger"));
        registry.register(new ItemModSword(ToolMaterialMod.AquaMaul, "aquatic_maul"));
        registry.register(new ItemModSword(ToolMaterialMod.AquaTrident, "aquatic_trident"));
        registry.register(new ItemModSword(ToolMaterialMod.Aquaton, "aquaton"));
        registry.register(new ItemModSword(ToolMaterialMod.AquatoothMaul, "aquatooth_maul"));
        registry.register(new ItemModSword(ToolMaterialMod.AquatoothSword, "aquatooth_sword"));
        registry.register(new ItemModSword(ToolMaterialMod.Arlemite, "arlemite_stabber"));
        registry.register(new ItemModSword(ToolMaterialMod.Bedrock, "bedrock_sword"));
        registry.register(new ItemModSword(ToolMaterialMod.BedrockMaul, "bedrock_maul"));
        registry.register(new ItemModSword(ToolMaterialMod.Bloodgem, "bloodgem_sword"));
        registry.register(new ItemModSword(ToolMaterialMod.Bluefire, "bluefire_sword"));
        registry.register(new ItemModSword(ToolMaterialMod.CorruptedMaul, "corrupted_maul"));
        registry.register(new ItemModSword(ToolMaterialMod.CrabclawMaul, "crabclaw_maul"));
        registry.register(new ItemModSword(ToolMaterialMod.Cyclops, "cyclopsian_sword"));
        registry.register(new ItemModSword(ToolMaterialMod.DeathBringer, "death_bringer"));
        registry.register(new ItemModSword(ToolMaterialMod.Divine, "blue_divine_sword"));
        registry.register(new ItemModSword(ToolMaterialMod.Divine, "divine_sword"));
        registry.register(new ItemModSword(ToolMaterialMod.Divine, "gray_divine_sword"));
        registry.register(new ItemModSword(ToolMaterialMod.Divine, "green_divine_sword"));
        registry.register(new ItemModSword(ToolMaterialMod.Divine, "red_divine_sword"));
        registry.register(new ItemModSword(ToolMaterialMod.Divine, "yellow_divine_sword"));
        registry.register(new ItemModSword(ToolMaterialMod.DualClaw, "dual_claw"));
        registry.register(new ItemModSword(ToolMaterialMod.Ender, "black_ender_sword"));
        registry.register(new ItemModSword(ToolMaterialMod.Ender, "blue_ender_sword"));
        registry.register(new ItemModSword(ToolMaterialMod.Ender, "ender_sword"));
        registry.register(new ItemModSword(ToolMaterialMod.Ender, "green_ender_sword"));
        registry.register(new ItemModSword(ToolMaterialMod.Ender, "red_ender_sword"));
        registry.register(new ItemModSword(ToolMaterialMod.Ender, "yellow_ender_sword"));
        registry.register(new ItemSlowingSword(ToolMaterialMod.Frost, "frost_sword"));
        registry.register(new ItemBurningSword(ToolMaterialMod.FlamingFury, "flaming_fury", 15));
        registry.register(new ItemModSword(ToolMaterialMod.FuryMaul, "fury_maul"));
        registry.register(new ItemBurningSword(ToolMaterialMod.Inferno, "inferno_sword", 12));
        registry.register(new ItemPoisonousSword(ToolMaterialMod.JungleKnife, "jungle_knife", 2.5f));
        registry.register(new ItemPoisonousSword(ToolMaterialMod.JungleRapier, "jungle_rapier", 4f));
        registry.register(new ItemBurningSword(ToolMaterialMod.Molten, "molten_sword", 5));
        registry.register(new ItemModSword(ToolMaterialMod.OceanKnife, "ocean_knife"));
        registry.register(new ItemPoisonousSword(ToolMaterialMod.PoisonSaber, "poison_saber", 5));
        registry.register(new ItemModSword(ToolMaterialMod.Realmite, "realmite_sword"));
        registry.register(new ItemModSword(ToolMaterialMod.Rupee, "rupee_rapier"));
        registry.register(new ItemModSword(ToolMaterialMod.Sandslash, "sandslash"));
        registry.register(new ItemModSword(ToolMaterialMod.Scorching, "scorching_sword"));
        registry.register(new ItemModSword(ToolMaterialMod.Shark, "shark_sword"));
        registry.register(new ItemModSword(ToolMaterialMod.Slime, "slime_sword"));
        registry.register(new ItemModSword(ToolMaterialMod.TerranDagger, "terran_dagger"));
        registry.register(new ItemModSword(ToolMaterialMod.TerranKnife, "terran_knife"));
        registry.register(new ItemModSword(ToolMaterialMod.TerranMaul, "terran_maul"));

        registry.register(new ItemModBow("bluefire_bow", ArrowType.BLUEFIRE_ARROW, -1));
        registry.register(new ItemModBow("ender_bow", ArrowType.ENDER_ARROW, -1));
        registry.register(new ItemModBow("hunter_bow", ArrowType.HUNTER_ARROW, 2500, Items.ARROW));
        registry.register(new ItemModBow("inferno_bow", ArrowType.INFERNO_ARROW, 10000));
        registry.register(new ItemModBow("shadow_bow", ArrowType.SHADOW_ARROW, 10000, 36000, Items.ARROW));

        registry.register(new ItemScythe("scythe"));

        registry.register(new ItemThrowable("shuriken", BulletType.SHURIKEN_SHOT));
        registry.register(new ItemVileStorm("vile_storm"));

        registry.register(new ItemAnchor("bowhead_anchor", BulletType.BOWHEAD_ANCHOR_SHOT));
        registry.register(new RangedWeaponBase("bowhead_cannon", BulletType.BOWHEAD_CANNON_SHOT, ModSounds.GHAST_CANNON, Item.getItemFromBlock(Blocks.CACTUS), 1000, 12));
        registry.register(new ItemCorruptedCannon("corrupted_cannon"));
        registry.register(new ItemAnchor("crab_anchor", BulletType.CRAB_ANCHOR_SHOT));
        registry.register(new RangedWeaponBase("crabclaw_cannon", BulletType.CRABCLAW_CANNON_SHOT, ModSounds.GHAST_CANNON, Item.getItemFromBlock(Blocks.CACTUS), 1000, 12));
        registry.register(new RangedWeaponBase("cyclopsian_staff", BulletType.CYCLOPSIAN_STAFF_SHOT, ModSounds.STAFF, 600, 0));
        registry.register(new RangedWeaponBase("frost_cannon", BulletType.FROST_CANNON_SHOT, ModSounds.FROST_CANNON, Items.SNOWBALL, 15000, 0));
        registry.register(new RangedWeaponBase("ghast_cannon", BulletType.GHAST_CANNON_SHOT, ModSounds.GHAST_CANNON, 100, 20));
        registry.register(new RangedWeaponBase("golden_fury", BulletType.GOLDEN_FURY_SHOT, ModSounds.BLITZ, Items.GOLD_NUGGET, -1, 0));
        registry.register(new ItemAnchor("liopleurodon_anchor", BulletType.LIOPLEURODON_ANCHOR_SHOT));
        registry.register(new RangedWeaponBase("maelstrom", BulletType.MAELSTROM_SHOT, ModSounds.GHAST_CANNON, 100, 0));
        registry.register(new ItemAnchor("shark_anchor", BulletType.SHARK_ANCHOR_SHOT));

        registry.register(new ItemSerenadeOfDeath("serenade_of_death"));
        registry.register(new ItemSerenadeOfHealth("serenade_of_health"));
        registry.register(new ItemSerenadeOfInfusion("serenade_of_infusion"));
        registry.register(new ItemSerenadeStriker("serenade_striker"));

        registry.register(new ItemHealingSword("massivence", ToolMaterialMod.Palavence, 1F));
        registry.register(new ItemHealingSword("palavence", ToolMaterialMod.Palavence, 0.5F));

        // Vanilla dimension armor

        registry.register(new ItemDivineArmor(EnumArmor.ANGELIC, EntityEquipmentSlot.HEAD, angelicInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ANGELIC, EntityEquipmentSlot.CHEST, angelicInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ANGELIC, EntityEquipmentSlot.LEGS, angelicInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ANGELIC, EntityEquipmentSlot.FEET, angelicInfo));

        registry.register(new ItemDivineArmor(EnumArmor.AQUATIC, EntityEquipmentSlot.HEAD, aquastriveInfo));
        registry.register(new ItemDivineArmor(EnumArmor.AQUATIC, EntityEquipmentSlot.CHEST, aquastriveInfo));
        registry.register(new ItemDivineArmor(EnumArmor.AQUATIC, EntityEquipmentSlot.LEGS, aquastriveInfo));
        registry.register(new ItemDivineArmor(EnumArmor.AQUATIC, EntityEquipmentSlot.FEET, aquastriveInfo));

        registry.register(new ItemDivineArmor(EnumArmor.ARLEMITE, EntityEquipmentSlot.HEAD, arlemiteInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ARLEMITE, EntityEquipmentSlot.CHEST, arlemiteInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ARLEMITE, EntityEquipmentSlot.LEGS, arlemiteInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ARLEMITE, EntityEquipmentSlot.FEET, arlemiteInfo));

        registry.register(new ItemDivineArmor(EnumArmor.BEDROCK, EntityEquipmentSlot.HEAD, bedrockInfo));
        registry.register(new ItemDivineArmor(EnumArmor.BEDROCK, EntityEquipmentSlot.CHEST, bedrockInfo));
        registry.register(new ItemDivineArmor(EnumArmor.BEDROCK, EntityEquipmentSlot.LEGS, bedrockInfo));
        registry.register(new ItemDivineArmor(EnumArmor.BEDROCK, EntityEquipmentSlot.FEET, bedrockInfo));

        registry.register(new ItemDivineArmor(EnumArmor.CORRUPTED, EntityEquipmentSlot.HEAD, corruptedInfo));
        registry.register(new ItemDivineArmor(EnumArmor.CORRUPTED, EntityEquipmentSlot.CHEST, corruptedInfo));
        registry.register(new ItemDivineArmor(EnumArmor.CORRUPTED, EntityEquipmentSlot.LEGS, corruptedInfo));
        registry.register(new ItemDivineArmor(EnumArmor.CORRUPTED, EntityEquipmentSlot.FEET, corruptedInfo));

        registry.register(new ItemDivineArmor(EnumArmor.DIVINE, EntityEquipmentSlot.HEAD, divineInfo));
        registry.register(new ItemDivineArmor(EnumArmor.DIVINE, EntityEquipmentSlot.CHEST, divineInfo));
        registry.register(new ItemDivineArmor(EnumArmor.DIVINE, EntityEquipmentSlot.LEGS, divineInfo));
        registry.register(new ItemDivineArmor(EnumArmor.DIVINE, EntityEquipmentSlot.FEET, divineInfo));

        registry.register(new ItemDivineArmor(EnumArmor.ELITE_REALMITE, EntityEquipmentSlot.HEAD, eliteRealmiteInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ELITE_REALMITE, EntityEquipmentSlot.CHEST, eliteRealmiteInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ELITE_REALMITE, EntityEquipmentSlot.LEGS, eliteRealmiteInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ELITE_REALMITE, EntityEquipmentSlot.FEET, eliteRealmiteInfo));

        registry.register(new ItemDivineArmor(EnumArmor.ENDER, EntityEquipmentSlot.HEAD, enderInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ENDER, EntityEquipmentSlot.CHEST, enderInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ENDER, EntityEquipmentSlot.LEGS, enderInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ENDER, EntityEquipmentSlot.FEET, enderInfo));

        registry.register(new ItemDivineArmor(EnumArmor.ENDER_BLUE, EntityEquipmentSlot.HEAD, enderInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ENDER_BLUE, EntityEquipmentSlot.CHEST, enderInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ENDER_BLUE, EntityEquipmentSlot.LEGS, enderInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ENDER_BLUE, EntityEquipmentSlot.FEET, enderInfo));

        registry.register(new ItemDivineArmor(EnumArmor.ENDER_GRAY, EntityEquipmentSlot.HEAD, enderInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ENDER_GRAY, EntityEquipmentSlot.CHEST, enderInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ENDER_GRAY, EntityEquipmentSlot.LEGS, enderInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ENDER_GRAY, EntityEquipmentSlot.FEET, enderInfo));

        registry.register(new ItemDivineArmor(EnumArmor.ENDER_GREEN, EntityEquipmentSlot.HEAD, enderInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ENDER_GREEN, EntityEquipmentSlot.CHEST, enderInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ENDER_GREEN, EntityEquipmentSlot.LEGS, enderInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ENDER_GREEN, EntityEquipmentSlot.FEET, enderInfo));

        registry.register(new ItemDivineArmor(EnumArmor.ENDER_RED, EntityEquipmentSlot.HEAD, enderInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ENDER_RED, EntityEquipmentSlot.CHEST, enderInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ENDER_RED, EntityEquipmentSlot.LEGS, enderInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ENDER_RED, EntityEquipmentSlot.FEET, enderInfo));

        registry.register(new ItemDivineArmor(EnumArmor.ENDER_YELLOW, EntityEquipmentSlot.HEAD, enderInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ENDER_YELLOW, EntityEquipmentSlot.CHEST, enderInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ENDER_YELLOW, EntityEquipmentSlot.LEGS, enderInfo));
        registry.register(new ItemDivineArmor(EnumArmor.ENDER_YELLOW, EntityEquipmentSlot.FEET, enderInfo));

        registry.register(new ItemDivineArmor(EnumArmor.FROZEN, EntityEquipmentSlot.HEAD, frozenInfo));
        registry.register(new ItemDivineArmor(EnumArmor.FROZEN, EntityEquipmentSlot.CHEST, frozenInfo));
        registry.register(new ItemDivineArmor(EnumArmor.FROZEN, EntityEquipmentSlot.LEGS, frozenInfo));
        registry.register(new ItemDivineArmor(EnumArmor.FROZEN, EntityEquipmentSlot.FEET, frozenInfo));

        registry.register(new ItemDivineArmor(EnumArmor.INFERNO, EntityEquipmentSlot.HEAD, infernoInfo));
        registry.register(new ItemDivineArmor(EnumArmor.INFERNO, EntityEquipmentSlot.CHEST, infernoInfo));
        registry.register(new ItemDivineArmor(EnumArmor.INFERNO, EntityEquipmentSlot.LEGS, infernoInfo));
        registry.register(new ItemDivineArmor(EnumArmor.INFERNO, EntityEquipmentSlot.FEET, infernoInfo));

        registry.register(new ItemDivineArmor(EnumArmor.JACKOMAN, EntityEquipmentSlot.HEAD, jackomanInfo));
        registry.register(new ItemDivineArmor(EnumArmor.JACKOMAN, EntityEquipmentSlot.CHEST, jackomanInfo));
        registry.register(new ItemDivineArmor(EnumArmor.JACKOMAN, EntityEquipmentSlot.LEGS, jackomanInfo));
        registry.register(new ItemDivineArmor(EnumArmor.JACKOMAN, EntityEquipmentSlot.FEET, jackomanInfo));

        registry.register(new ItemDivineArmor(EnumArmor.JUNGLE, EntityEquipmentSlot.HEAD, jungleInfo));
        registry.register(new ItemDivineArmor(EnumArmor.JUNGLE, EntityEquipmentSlot.CHEST, jungleInfo));
        registry.register(new ItemDivineArmor(EnumArmor.JUNGLE, EntityEquipmentSlot.LEGS, jungleInfo));
        registry.register(new ItemDivineArmor(EnumArmor.JUNGLE, EntityEquipmentSlot.FEET, jungleInfo));

        registry.register(new ItemDivineArmor(EnumArmor.KRAKEN, EntityEquipmentSlot.HEAD, krakenInfo));
        registry.register(new ItemDivineArmor(EnumArmor.KRAKEN, EntityEquipmentSlot.CHEST, krakenInfo));
        registry.register(new ItemDivineArmor(EnumArmor.KRAKEN, EntityEquipmentSlot.LEGS, krakenInfo));
        registry.register(new ItemDivineArmor(EnumArmor.KRAKEN, EntityEquipmentSlot.FEET, krakenInfo));

        registry.register(new ItemDivineArmor(EnumArmor.NETHERITE, EntityEquipmentSlot.HEAD, netheriteInfo));
        registry.register(new ItemDivineArmor(EnumArmor.NETHERITE, EntityEquipmentSlot.CHEST, netheriteInfo));
        registry.register(new ItemDivineArmor(EnumArmor.NETHERITE, EntityEquipmentSlot.LEGS, netheriteInfo));
        registry.register(new ItemDivineArmor(EnumArmor.NETHERITE, EntityEquipmentSlot.FEET, netheriteInfo));

        registry.register(new ItemDivineArmor(EnumArmor.REALMITE, EntityEquipmentSlot.HEAD));
        registry.register(new ItemDivineArmor(EnumArmor.REALMITE, EntityEquipmentSlot.CHEST));
        registry.register(new ItemDivineArmor(EnumArmor.REALMITE, EntityEquipmentSlot.LEGS));
        registry.register(new ItemDivineArmor(EnumArmor.REALMITE, EntityEquipmentSlot.FEET));

        registry.register(new ItemDivineArmor(EnumArmor.RUPEE, EntityEquipmentSlot.HEAD, rupeeInfo));
        registry.register(new ItemDivineArmor(EnumArmor.RUPEE, EntityEquipmentSlot.CHEST, rupeeInfo));
        registry.register(new ItemDivineArmor(EnumArmor.RUPEE, EntityEquipmentSlot.LEGS, rupeeInfo));
        registry.register(new ItemDivineArmor(EnumArmor.RUPEE, EntityEquipmentSlot.FEET, rupeeInfo));

        registry.register(new ItemDivineArmor(EnumArmor.RUPEE_BLUE, EntityEquipmentSlot.HEAD, rupeeInfo));
        registry.register(new ItemDivineArmor(EnumArmor.RUPEE_BLUE, EntityEquipmentSlot.CHEST, rupeeInfo));
        registry.register(new ItemDivineArmor(EnumArmor.RUPEE_BLUE, EntityEquipmentSlot.LEGS, rupeeInfo));
        registry.register(new ItemDivineArmor(EnumArmor.RUPEE_BLUE, EntityEquipmentSlot.FEET, rupeeInfo));

        registry.register(new ItemDivineArmor(EnumArmor.RUPEE_GRAY, EntityEquipmentSlot.HEAD, rupeeInfo));
        registry.register(new ItemDivineArmor(EnumArmor.RUPEE_GRAY, EntityEquipmentSlot.CHEST, rupeeInfo));
        registry.register(new ItemDivineArmor(EnumArmor.RUPEE_GRAY, EntityEquipmentSlot.LEGS, rupeeInfo));
        registry.register(new ItemDivineArmor(EnumArmor.RUPEE_GRAY, EntityEquipmentSlot.FEET, rupeeInfo));

        registry.register(new ItemDivineArmor(EnumArmor.RUPEE_GREEN, EntityEquipmentSlot.HEAD, rupeeInfo));
        registry.register(new ItemDivineArmor(EnumArmor.RUPEE_GREEN, EntityEquipmentSlot.CHEST, rupeeInfo));
        registry.register(new ItemDivineArmor(EnumArmor.RUPEE_GREEN, EntityEquipmentSlot.LEGS, rupeeInfo));
        registry.register(new ItemDivineArmor(EnumArmor.RUPEE_GREEN, EntityEquipmentSlot.FEET, rupeeInfo));

        registry.register(new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, EntityEquipmentSlot.HEAD,rupeeInfo));
        registry.register(new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, EntityEquipmentSlot.CHEST, rupeeInfo));
        registry.register(new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, EntityEquipmentSlot.LEGS, rupeeInfo));
        registry.register(new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, EntityEquipmentSlot.FEET, rupeeInfo));

        registry.register(new ItemDivineArmor(EnumArmor.RUPEE_RED, EntityEquipmentSlot.HEAD, rupeeInfo));
        registry.register(new ItemDivineArmor(EnumArmor.RUPEE_RED, EntityEquipmentSlot.CHEST, rupeeInfo));
        registry.register(new ItemDivineArmor(EnumArmor.RUPEE_RED, EntityEquipmentSlot.LEGS, rupeeInfo));
        registry.register(new ItemDivineArmor(EnumArmor.RUPEE_RED, EntityEquipmentSlot.FEET, rupeeInfo));

        registry.register(new ItemDivineArmor(EnumArmor.SHADOW, EntityEquipmentSlot.HEAD, shadowInfo));
        registry.register(new ItemDivineArmor(EnumArmor.SHADOW, EntityEquipmentSlot.CHEST, shadowInfo));
        registry.register(new ItemDivineArmor(EnumArmor.SHADOW, EntityEquipmentSlot.LEGS, shadowInfo));
        registry.register(new ItemDivineArmor(EnumArmor.SHADOW, EntityEquipmentSlot.FEET, shadowInfo));

        registry.register(new ItemDivineArmor(EnumArmor.SKELEMAN, EntityEquipmentSlot.HEAD, skelemanInfo));
        registry.register(new ItemDivineArmor(EnumArmor.SKELEMAN, EntityEquipmentSlot.CHEST, skelemanInfo));
        registry.register(new ItemDivineArmor(EnumArmor.SKELEMAN, EntityEquipmentSlot.LEGS, skelemanInfo));
        registry.register(new ItemDivineArmor(EnumArmor.SKELEMAN, EntityEquipmentSlot.FEET, skelemanInfo));

        registry.register(new ItemDivineArmor(EnumArmor.TERRAN, EntityEquipmentSlot.HEAD, terranInfo));
        registry.register(new ItemDivineArmor(EnumArmor.TERRAN, EntityEquipmentSlot.CHEST, terranInfo));
        registry.register(new ItemDivineArmor(EnumArmor.TERRAN, EntityEquipmentSlot.LEGS, terranInfo));
        registry.register(new ItemDivineArmor(EnumArmor.TERRAN, EntityEquipmentSlot.FEET, terranInfo));

        registry.register(new ItemDivineArmor(EnumArmor.WITHER_REAPER, EntityEquipmentSlot.HEAD, witherReaperInfo));
        registry.register(new ItemDivineArmor(EnumArmor.WITHER_REAPER, EntityEquipmentSlot.CHEST, witherReaperInfo));
        registry.register(new ItemDivineArmor(EnumArmor.WITHER_REAPER, EntityEquipmentSlot.LEGS, witherReaperInfo));
        registry.register(new ItemDivineArmor(EnumArmor.WITHER_REAPER, EntityEquipmentSlot.FEET, witherReaperInfo));

        // Vanilla dimension tools
        registry.register(new ItemModShovel(ToolMaterialMod.ArlemiteShovel, "arlemite_shovel"));
        registry.register(new ItemModPickaxe(ToolMaterialMod.ArlemitePick, "arlemite_pickaxe"));
        registry.register(new ItemModAxe(ToolMaterialMod.ArlemiteAxe, "arlemite_axe"));
        registry.register(new ItemModHoe(ToolMaterialMod.ArlemitePick, "arlemite_hoe"));
        registry.register(new ItemShickaxe(ToolMaterialMod.ArlemiteShick, "arlemite_shickaxe"));

        registry.register(new ItemModShovel(ToolMaterialMod.BedrockShovel, "bedrock_shovel"));
        registry.register(new ItemModPickaxe(ToolMaterialMod.BedrockPick, "bedrock_pickaxe"));
        registry.register(new ItemModAxe(ToolMaterialMod.BedrockAxe, "bedrock_axe"));

        registry.register(new ItemModShovel(ToolMaterialMod.CorruptedShovel, "corrupted_shovel"));
        registry.register(new ItemModPickaxe(ToolMaterialMod.CorruptedPick, "corrupted_pickaxe"));
        registry.register(new ItemModAxe(ToolMaterialMod.CorruptedAxe, "corrupted_axe"));

        registry.register(new ItemModShovel(ToolMaterialMod.DivineShovel, "divine_shovel"));
        registry.register(new ItemModPickaxe(ToolMaterialMod.DivinePick, "divine_pickaxe"));
        registry.register(new ItemModAxe(ToolMaterialMod.DivineAxe, "divine_axe"));
        registry.register(new ItemShickaxe(ToolMaterialMod.DivineShick, "divine_shickaxe"));

        registry.register(new ItemModShovel(ToolMaterialMod.RealmiteShovel, "realmite_shovel"));
        registry.register(new ItemModPickaxe(ToolMaterialMod.RealmitePick, "realmite_pickaxe"));
        registry.register(new ItemModAxe(ToolMaterialMod.RealmiteAxe, "realmite_axe"));
        registry.register(new ItemModHoe(ToolMaterialMod.RealmitePick, "realmite_hoe"));

        registry.register(new ItemModShovel(ToolMaterialMod.RupeeShovel, "rupee_shovel"));
        registry.register(new ItemModPickaxe(ToolMaterialMod.RupeePick, "rupee_pickaxe"));
        registry.register(new ItemModAxe(ToolMaterialMod.RupeeAxe, "rupee_axe"));
        registry.register(new ItemModHoe(ToolMaterialMod.RupeePick, "rupee_hoe"));
        registry.register(new ItemShickaxe(ToolMaterialMod.RupeeShick, "rupee_shickaxe"));

        // Teleportation crystal
        registry.register(new ItemTeleportationCrystal("teleportation_crystal"));

        // Vanilla misc items

        // Shards
        registry.register(new ItemMod("corrupted_shards"));
        registry.register(new ItemMod("divine_shards"));
        registry.register(new ItemMod("ender_shards"));
        registry.register(new ItemMod("ice_shards"));
        registry.register(new ItemMod("jungle_shards"));
        registry.register(new ItemMod("molten_shards"));
        registry.register(new ItemMod("terran_shards"));

        // Stones
        registry.register(new ItemMod("corrupted_stone"));
        registry.register(new ItemMod("divine_stone"));
        registry.register(new ItemMod("ender_stone"));
        registry.register(new ItemMod("ice_stone"));
        registry.register(new ItemMod("jungle_stone"));
        registry.register(new ItemMod("molten_stone"));
        registry.register(new ItemMod("shadow_stone"));
        registry.register(new ItemMod("terran_stone"));

        // Ingots
        registry.register(new ItemMod("arlemite_ingot"));
        registry.register(new ItemMod("hellstone_ingot"));
        registry.register(new ItemMod("netherite_ingot"));
        registry.register(new ItemMod("realmite_ingot"));
        registry.register(new ItemMod("rupee_ingot"));
        registry.register(new ItemMod("shadow_bar"));

        // Gems
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));

        // Boss spawners
        registry.register(new ItemCallOfTheWatcher("call_of_the_watcher"));
        registry.register(new ItemHordeHorn("horde_horn"));
        registry.register(new ItemInfernalFlame("infernal_flame"));
        registry.register(new ItemMysteriousClock("mysterious_clock"));
        registry.register(new ItemMod("watching_eye"));

        // Ayeraco fragments
        registry.register(new ItemMod("ayeraco_fragment_blue"));
        registry.register(new ItemMod("ayeraco_fragment_green"));
        registry.register(new ItemMod("ayeraco_fragment_purple"));
        registry.register(new ItemMod("ayeraco_fragment_red"));
        registry.register(new ItemMod("ayeraco_fragment_yellow"));

        // Diamond chunks
        registry.register(new ItemMod("blue_diamond_chunk"));
        registry.register(new ItemMod("gray_diamond_chunk"));
        registry.register(new ItemMod("red_diamond_chunk"));
        registry.register(new ItemMod("yellow_diamond_chunk"));
        registry.register(new ItemMod("green_diamond_chunk"));

        // Pet spawn eggs
        registry.register(new ItemLivestockSpawnEgg("brown_grizzle_egg"));
        registry.register(new ItemLivestockSpawnEgg("husk_egg"));
        registry.register(new ItemLivestockSpawnEgg("smelter_egg"));
        registry.register(new ItemLivestockSpawnEgg("snapper_egg"));
        registry.register(new ItemLivestockSpawnEgg("stone_golem_egg"));
        registry.register(new ItemLivestockSpawnEgg("white_grizzle_egg"));
        registry.register(new ItemLivestockSpawnEgg("ehu_egg"));

        // Miscellaneous resources
        registry.register(new ItemMod("aqua_ball"));
        registry.register(new ItemMod("aquatic_blaze_rod"));
        registry.register(new ItemMod("aquatic_ingot"));
        registry.register(new ItemMod("aquatic_pellets"));
        registry.register(new ItemMod("bedrock_chunk"));
        registry.register(new ItemMod("bloodgem"));
        registry.register(new ItemMod("bluefire_stone"));
        registry.register(new ItemMod("corrupted_bullet"));
        registry.register(new ItemMod("crab_claw"));
        registry.register(new ItemMod("cyclops_eye"));
        registry.register(new ItemMod("cyclops_eye_shards"));
        registry.register(new ItemMod("fury_fire"));
        registry.register(new ItemHealingStone("healing_stone", 20));
        registry.register(new ItemMod("kraken_scale"));
        registry.register(new ItemMod("kraken_skin"));
        registry.register(new ItemMod("legendary_ender_eye"));
        registry.register(new ItemMod("liopleurodon_skull"));
        registry.register(new ItemMod("liopleurodon_teeth"));
        registry.register(new ItemMod("netherite_chunk"));
        registry.register(new ItemMod("pure_aquatic_pellets"));
        registry.register(new ItemMod("purple_blaze"));
        registry.register(new ItemMod("shadow_coins"));
        registry.register(new ItemMod("shark_fin"));
        registry.register(new ItemMod("whale_fin"));

        // Iceika

        // Iceika dimension weapons - melee
        registry.register(new ItemSlowingSword(ToolMaterialMod.Enderice, "enderice"));
        registry.register(new ItemSlowingSword(ToolMaterialMod.Frostking, "frostking_sword"));
        registry.register(new ItemSlowingSword(ToolMaterialMod.FrozenMaul, "frozen_maul"));
        registry.register(new ItemSlowingSword(ToolMaterialMod.Glacier, "glacier_sword"));
        registry.register(new ItemSlowingSword(ToolMaterialMod.Icine, "icine_sword"));
        registry.register(new ItemSlowingSword(ToolMaterialMod.Snowslash, "snowslash"));
        registry.register(new ItemSlowingSword(ToolMaterialMod.IcicleBane, "icicle_bane"));

        registry.register(new ItemHealingSword("frossivence", ToolMaterialMod.Frossivence, 1F));

        // Iceika dimension weapons - ranged
        registry.register(new ItemModBow("snowstorm_bow", ArrowType.SNOWSTORM_ARROW, -1));
        registry.register(new ItemModBow("icicle_bow", ArrowType.ICICLE_ARROW, 10000, 24000, Items.ARROW));

        registry.register(new ItemThrowable("snowflake_shuriken", BulletType.SNOWFLAKE_SHURIKEN_SHOT));

        registry.register(new RangedWeaponBase("fractite_cannon", BulletType.FRACTITE_CANNON_SHOT, ModSounds.FRACTITE_CANNON, iceShards, 10000, 0));
        registry.register(new RangedWeaponBase("frostclaw_cannon", BulletType.FROSTCLAW_CANNON_SHOT, ModSounds.FROSTCLAW_CANNON, Item.getItemFromBlock(Blocks.CACTUS), 10000, 0));

        registry.register(new ItemMusicShooter("sound_of_music", ModSounds.SOUND_OF_MUSIC, EntitySoundOfMusic.class));
        registry.register(new ItemMusicShooter("sound_of_carols", ModSounds.SOUND_OF_CAROLS, EntitySoundOfCarols.class));

        registry.register(new ItemSerenadeOfIce("serenade_of_ice"));

        // Iceika dimension armor
        registry.register(new ItemDivineArmor("santa_boots", EnumArmor.SANTA, EntityEquipmentSlot.FEET, santaInfo));
        registry.register(new ItemDivineArmor("santa_pants", EnumArmor.SANTA, EntityEquipmentSlot.LEGS, santaInfo));
        registry.register(new ItemDivineArmor("santa_tunic", EnumArmor.SANTA, EntityEquipmentSlot.CHEST, santaInfo));
        registry.register(new ItemDivineArmor("santa_cap", EnumArmor.SANTA, EntityEquipmentSlot.HEAD, santaInfo));

        // Iceika misc
        registry.register(new ItemMod("snowflake"));

        // Iceika portal item
        registry.register(new ItemSnowGlobe("snow_globe"));

        /*************************/

        // Foods
        registry.register(new ItemModFood(10, 10.0F, "advanced_mushroom_stew"));
        registry.register(new ItemModFood(2, 3.0F, true, "bacon"));
        registry.register(new ItemModFood(4, 0.5F, "boiled_egg"));
        registry.register(new ItemModFood(2, 0.2F,  "cheese"));
        registry.register(new ItemModFood(20, 20.0F,  "chicken_dinner"));
        registry.register(new ItemModFood(4, 1.0F,  "chocolate_log"));
        registry.register(new ItemModFood(16, 0.3F, "donut"));
        registry.register(new ItemEggNog("egg_nog"));
        registry.register(new ItemModFood(5, 2.0F, true, "raw_empowered_meat"));
        registry.register(new ItemModFood(10, 4.0F, true, "empowered_meat"));
        registry.register(new ItemFastFood(7, 2.5F, true, "enriched_magic_meat"));
        registry.register(new ItemForbiddenFruit());
        registry.register(new ItemModFood(16, 2.0F, "fruit_cake"));
        registry.register(new ItemModFood(5, 7.0F, true, "hot_pumpkin_pie"));
        registry.register(new ItemFastFood(5, 1.0F, true, "magic_meat"));
        registry.register(new ItemFastFood(1, 5, false, "moonbulb"));
        registry.register(new ItemModFood(1, 0.3F,  "peppermints"));
        registry.register(new ItemFastFood(3, 5, false, "pink_glowbone"));
        registry.register(new ItemFastFood(3, 5, false, "purple_glowbone"));
        registry.register(new ItemSkyFlower("sky_flower"));
        registry.register(new ItemModFood(2, 0.3F, "snow_cones"));
        registry.register(new ItemModFood(4, 0.3F,  "tomato"));
        registry.register(new ItemModFood(1, 0.1F,  "white_mushroom"));
        registry.register(new ItemModFood(4, 1.0F, "winterberry"));

        // Twilight Dimensions

        // Twilight souls
        registry.register(new ItemMod("eden_soul"));
        registry.register(new ItemMod("wildwood_soul"));
        registry.register(new ItemMod("apalachia_soul"));
        registry.register(new ItemMod("skythern_soul"));
        registry.register(new ItemMod("mortum_soul"));

        // Twilight fragments
        registry.register(new ItemMod("eden_fragments"));
        registry.register(new ItemMod("wildwood_fragments"));
        registry.register(new ItemMod("apalachia_fragments"));
        registry.register(new ItemMod("skythern_fragments"));
        registry.register(new ItemMod("mortum_fragments"));

        // Twilight gems
        registry.register(new ItemMod("eden_gem"));
        registry.register(new ItemMod("wildwood_gem"));
        registry.register(new ItemMod("apalachia_gem"));
        registry.register(new ItemMod("skythern_gem"));
        registry.register(new ItemMod("mortum_gem"));

        // Twilight chunks
        registry.register(new ItemMod("eden_chunk"));
        registry.register(new ItemMod("wildwood_chunk"));
        registry.register(new ItemMod("apalachia_chunk"));
        registry.register(new ItemMod("skythern_chunk"));
        registry.register(new ItemMod("mortum_chunk"));

        // Twilight dust
        registry.register(new ItemMod("eden_dust"));
        registry.register(new ItemMod("wildwood_dust"));
        registry.register(new ItemMod("apalachia_dust"));
        registry.register(new ItemMod("skythern_dust"));
        registry.register(new ItemMod("mortum_dust"));

        // Twilight boss spawners

        // Twilight swords
        registry.register(new ItemModSword(ToolMaterialMod.Eden, "eden_blade"));
        registry.register(new ItemModSword(ToolMaterialMod.Wildwood, "wildwood_blade"));
        registry.register(new ItemModSword(ToolMaterialMod.Apalachia, "apalachia_blade"));
        registry.register(new ItemModSword(ToolMaterialMod.Skythern, "skythern_blade"));
        registry.register(new ItemModSword(ToolMaterialMod.Mortum, "mortum_blade"));
        registry.register(new ItemModSword(ToolMaterialMod.Halite, "halite_blade"));

        // Twilight bows
        registry.register(new ItemModBow("eden_bow", ArrowType.EDEN_ARROW, -1, edenArrow));
        registry.register(new ItemModBow("wildwood_bow", ArrowType.LESSER_WILDWOOD_ARROW, -1, 36000, wildwoodArrow));
        registry.register(new ItemModBow("apalachia_bow", ArrowType.GREATER_WILDWOOD_ARROW, -1, wildwoodArrow));
        registry.register(new ItemModBow("skythern_bow", ArrowType.GREATER_WILDWOOD_ARROW, -1, 36000, wildwoodArrow));
        registry.register(new ItemModBow("mortum_bow", ArrowType.FURY_ARROW, -1, furyArrow));
        registry.register(new ItemModBow("halite_bow", ArrowType.FURY_ARROW, -1, 36000, furyArrow));
        registry.register(new ItemModBow("twilight_bow", ArrowType.FURY_ARROW, -1, 14400, furyArrow));

        // Twilight slicers
        registry.register(new ItemThrowable("eden_slicer", BulletType.EDEN_SLICER_SHOT));
        registry.register(new ItemThrowable("wildwood_slicer", BulletType.WILDWOOD_SLICER_SHOT));
        registry.register(new ItemThrowable("apalachia_slicer", BulletType.APALACHIA_SLICER_SHOT));
        registry.register(new ItemThrowable("skythern_slicer", BulletType.SKYTHERN_SLICER_SHOT));
        registry.register(new ItemThrowable("mortum_slicer", BulletType.MORTUM_SLICER_SHOT));
        registry.register(new ItemThrowable("halite_slicer", BulletType.HALITE_SLICER_SHOT));

        // Twilight blitzes
        registry.register(new ItemTwilightBlitz("eden_blitz", BulletType.EDEN_BLITZ_SHOT, edenDust));
        registry.register(new ItemTwilightBlitz("wildwood_blitz", BulletType.WILDWOOD_BLITZ_SHOT, wildwoodDust));
        registry.register(new ItemTwilightBlitz("apalachia_blitz", BulletType.APALACHIA_BLITZ_SHOT, apalachiaDust));
        registry.register(new ItemTwilightBlitz("skythern_blitz", BulletType.SKYTHERN_BLITZ_SHOT, skythernDust));
        registry.register(new ItemTwilightBlitz("mortum_blitz", BulletType.MORTUM_BLITZ_SHOT, mortumDust));
        registry.register(new ItemTwilightBlitz("halite_blitz", BulletType.HALITE_BLITZ_SHOT, mortumDust));

        // Twilight phasers
        registry.register(new RangedWeaponBase("eden_phaser", BulletType.EDEN_PHASER_SHOT, ModSounds.PHASER, 3000, 12));
        registry.register(new RangedWeaponBase("wildwood_phaser", BulletType.WILDWOOD_PHASER_SHOT, ModSounds.PHASER, 3000, 12));
        registry.register(new RangedWeaponBase("apalachia_phaser", BulletType.APALACHIA_PHASER_SHOT, ModSounds.PHASER, 3000, 12));
        registry.register(new RangedWeaponBase("skythern_phaser", BulletType.SKYTHERN_PHASER_SHOT, ModSounds.PHASER, 3000, 12));
        registry.register(new RangedWeaponBase("mortum_phaser", BulletType.MORTUM_PHASER_SHOT, ModSounds.PHASER, 3000, 12));
        registry.register(new RangedWeaponBase("halite_phaser", BulletType.HALITE_PHASER_SHOT, ModSounds.PHASER, 3000, 12));

        // Twilight tools
        registry.register(new ItemModShovel(ToolMaterialMod.EdenShovel, "eden_shovel"));
        registry.register(new ItemModPickaxe(ToolMaterialMod.EdenPick, "eden_pickaxe"));
        registry.register(new ItemModAxe(ToolMaterialMod.EdenAxe, "eden_axe"));

        registry.register(new ItemModShovel(ToolMaterialMod.WildwoodShovel, "wildwood_shovel"));
        registry.register(new ItemModPickaxe(ToolMaterialMod.WildwoodPick, "wildwood_pickaxe"));
        registry.register(new ItemModAxe(ToolMaterialMod.WildwoodAxe, "wildwood_axe"));

        registry.register(new ItemModShovel(ToolMaterialMod.ApalachiaShovel, "apalachia_shovel"));
        registry.register(new ItemModPickaxe(ToolMaterialMod.ApalachiaPick, "apalachia_pickaxe"));
        registry.register(new ItemModAxe(ToolMaterialMod.ApalachiaAxe, "apalachia_axe"));

        registry.register(new ItemModShovel(ToolMaterialMod.SkythernShovel, "skythern_shovel"));
        registry.register(new ItemModPickaxe(ToolMaterialMod.SkythernPick, "skythern_pickaxe"));
        registry.register(new ItemModAxe(ToolMaterialMod.SkythernAxe, "skythern_axe"));

        registry.register(new ItemModShovel(ToolMaterialMod.MortumShovel, "mortum_shovel"));
        registry.register(new ItemModPickaxe(ToolMaterialMod.MortumPick, "mortum_pickaxe"));
        registry.register(new ItemModAxe(ToolMaterialMod.MortumAxe, "mortum_axe"));

        // Twilight armor
        registry.register(new ItemDivineArmor(EnumArmor.EDEN, EntityEquipmentSlot.HEAD, edenInfo));
        registry.register(new ItemDivineArmor(EnumArmor.EDEN, EntityEquipmentSlot.CHEST, edenInfo));
        registry.register(new ItemDivineArmor(EnumArmor.EDEN, EntityEquipmentSlot.LEGS, edenInfo));
        registry.register(new ItemDivineArmor(EnumArmor.EDEN, EntityEquipmentSlot.FEET, edenInfo));

        registry.register(new ItemDivineArmor(EnumArmor.WILD, EntityEquipmentSlot.HEAD, wildInfo));
        registry.register(new ItemDivineArmor(EnumArmor.WILD, EntityEquipmentSlot.CHEST, wildInfo));
        registry.register(new ItemDivineArmor(EnumArmor.WILD, EntityEquipmentSlot.LEGS, wildInfo));
        registry.register(new ItemDivineArmor(EnumArmor.WILD, EntityEquipmentSlot.FEET, wildInfo));

        registry.register(new ItemDivineArmor(EnumArmor.APALACHIA, EntityEquipmentSlot.HEAD, apInfo));
        registry.register(new ItemDivineArmor(EnumArmor.APALACHIA, EntityEquipmentSlot.CHEST, apInfo));
        registry.register(new ItemDivineArmor(EnumArmor.APALACHIA, EntityEquipmentSlot.LEGS, apInfo));
        registry.register(new ItemDivineArmor(EnumArmor.APALACHIA, EntityEquipmentSlot.FEET, apInfo));

        registry.register(new ItemDivineArmor(EnumArmor.SKYTHERN, EntityEquipmentSlot.HEAD, skyInfo));
        registry.register(new ItemDivineArmor(EnumArmor.SKYTHERN, EntityEquipmentSlot.CHEST, skyInfo));
        registry.register(new ItemDivineArmor(EnumArmor.SKYTHERN, EntityEquipmentSlot.LEGS, skyInfo));
        registry.register(new ItemDivineArmor(EnumArmor.SKYTHERN, EntityEquipmentSlot.FEET, skyInfo));

        registry.register(new ItemDivineArmor(EnumArmor.MORTUM, EntityEquipmentSlot.HEAD, mortInfo));
        registry.register(new ItemDivineArmor(EnumArmor.MORTUM, EntityEquipmentSlot.CHEST, mortInfo));
        registry.register(new ItemDivineArmor(EnumArmor.MORTUM, EntityEquipmentSlot.LEGS, mortInfo));
        registry.register(new ItemDivineArmor(EnumArmor.MORTUM, EntityEquipmentSlot.FEET, mortInfo));

        registry.register(new ItemDivineArmor(EnumArmor.HALITE, EntityEquipmentSlot.HEAD, halInfo));
        registry.register(new ItemDivineArmor(EnumArmor.HALITE, EntityEquipmentSlot.CHEST, halInfo));
        registry.register(new ItemDivineArmor(EnumArmor.HALITE, EntityEquipmentSlot.LEGS, halInfo));
        registry.register(new ItemDivineArmor(EnumArmor.HALITE, EntityEquipmentSlot.FEET, halInfo));

        // Twilight boss spawners
        registry.register(new ItemTwilightSpawner("eternal_archer_crystal"));
        registry.register(new ItemTwilightSpawner("karot_crystal"));
        registry.register(new ItemTwilightSpawner("reyvor_crystal"));
        registry.register(new ItemTwilightSpawner("soul_fiend_crystal"));
        registry.register(new ItemTwilightSpawner("twilight_demon_crystal"));
        registry.register(new ItemTwilightSpawner("vamacheron_crystal"));
        registry.register(new ItemTwilightSpawner("densos_crystal"));

        // Twilight portal item
        registry.register(new ItemTwilightClock("twilight_clock"));

        // Twilight arrows
        registry.register(new ItemMod("eden_arrow").setCreativeTab(DivineRPGTabs.ranged));
        registry.register(new ItemMod("fury_arrow").setCreativeTab(DivineRPGTabs.ranged));
        registry.register(new ItemMod("wildwood_arrow").setCreativeTab(DivineRPGTabs.ranged));

        // Twilight miscellaneous
        registry.register(new ItemMod("base_spawn_crystal"));
        registry.register(new ItemMod("eden_sparkles"));

        // Arcana

        // Arcana melee
        registry.register(new ItemArcaniteBlade());
        registry.register(new ItemArcaniumSaber("arcanium_saber", ToolMaterialMod.Saber));
        registry.register(new ItemEnderScepter("ender_scepter"));
        registry.register(new ItemModSword(ToolMaterialMod.LiviciaSword, "livicia_sword"));
        registry.register(new ItemStormSword("storm_sword", ToolMaterialMod.Storm));
        registry.register(new ItemShadowSaber("shadow_saber", ToolMaterialMod.ShadowSaber));

        // Arcana ranged
        registry.register(new ItemArcaniteBlaster());
        registry.register(new ItemCaptainsSparkler("captains_sparkler"));
        registry.register(new ItemFirefly());
        registry.register(new ItemGeneralsStaff());
        registry.register(new ItemLaVekor());
        registry.register(new ItemMeriksMissile("meriks_missile"));
        registry.register(new ItemMeteorMash());
        registry.register(new ItemStaffStarlight("starlight", 5));
        registry.register(new ItemStaffStarlight("staff_of_starlight", 25));

        // Arcana throwable
        registry.register(new ItemGrenade("grenade"));

        // Arcana utility
        registry.register(new ItemAttractor());
        registry.register(new ItemReflector());
        registry.register(new ItemDivineAccumulator());
        registry.register(new ItemGhostbane());
        registry.register(new ItemOrbOfLight());
        registry.register(new ItemStaffEnrichment("staff_of_enrichment"));

        // Arcana armor sets
        registry.register(new ItemDivineArmor(EnumArmor.KORMA, EntityEquipmentSlot.HEAD, kormInfo));
        registry.register(new ItemDivineArmor(EnumArmor.KORMA, EntityEquipmentSlot.CHEST, kormInfo));
        registry.register(new ItemDivineArmor(EnumArmor.KORMA, EntityEquipmentSlot.LEGS, kormInfo));
        registry.register(new ItemDivineArmor(EnumArmor.KORMA, EntityEquipmentSlot.FEET, kormInfo));

        registry.register(new ItemDivineArmor(EnumArmor.VEMOS, EntityEquipmentSlot.HEAD, vemInfo));
        registry.register(new ItemDivineArmor(EnumArmor.VEMOS, EntityEquipmentSlot.CHEST, vemInfo));
        registry.register(new ItemDivineArmor(EnumArmor.VEMOS, EntityEquipmentSlot.LEGS, vemInfo));
        registry.register(new ItemDivineArmor(EnumArmor.VEMOS, EntityEquipmentSlot.FEET, vemInfo));

        // Arcana boss spawners
        registry.register(new ItemWizardsBook("wizards_book"));

        // Arcana pet spawners
        registry.register(new ItemZelusSpawnEgg("fyracryx_egg"));
        registry.register(new ItemZelusSpawnEgg("paratiku_egg"));
        registry.register(new ItemZelusSpawnEgg("seimer_egg"));
        registry.register(new ItemZelusSpawnEgg("golem_of_rejuvenation_egg"));

        // Arcana crops
        registry.register(new ItemAquamarine("aquamarine"));
        registry.register(new ItemMod("firestock"));
        registry.register(new ItemLamona());
        registry.register(new ItemMod("marsine"));
        registry.register(new ItemModFood(2, 0.3F,  "pinfly").setPotionEffect(new PotionEffect(MobEffects.SPEED, 10, 2), 1.0F));
        registry.register(new ItemMod("veilo"));
        registry.register(new ItemModFood(2, 3,  "hitchak"));

        // Arcana keys
        registry.register(new ItemKey("ancient_key"));
        registry.register(new ItemKey("degraded_key"));
        registry.register(new ItemKey("soul_key"));
        registry.register(new ItemKey("sludge_key"));

        // Arcana potions
        registry.register(new ItemArcanaPotion("weak_arcana_potion", 100));
        registry.register(new ItemArcanaPotion("strong_arcana_potion", 200));

        // Arcana miscellaneous
        registry.register(new ItemMod("arcanium"));
        registry.register(new ItemChargedCollector("charged_collector"));
        registry.register(new ItemMod("collector"));
        registry.register(new ItemMod("dungeon_tokens"));

        // Seeds
        registry.register(new ItemArcanaSeeds("aquamarine_seeds"));
        registry.register(new ItemArcanaSeeds("eucalyptus_root_seeds"));
        registry.register(new ItemArcanaSeeds("firestock_seeds"));
        registry.register(new ItemArcanaSeeds("hitchak_seeds"));
        registry.register(new ItemArcanaSeeds("lamona_seeds"));
        registry.register(new ItemArcanaSeeds("marsine_seeds"));
        registry.register(new ItemModSeeds("moonbulb_seeds", Blocks.FARMLAND));
        registry.register(new ItemArcanaSeeds("pinfly_seeds"));
        registry.register(new ItemModSeeds("pink_glowbone_seeds", Blocks.GRASS));
        registry.register(new ItemModSeeds("purple_glowbone_seeds", Blocks.GRASS));
        registry.register(new ItemModSeeds("sky_plant_seeds", Blocks.GRASS));
        registry.register(new ItemModSeeds("tomato_seeds", Blocks.FARMLAND));
        registry.register(new ItemArcanaSeeds("veilo_seeds"));
        registry.register(new ItemModSeeds("white_mushroom_seeds", Blocks.FARMLAND));

        // Vethea
        // Vethea pearls
        registry.register(new ItemVethean("dirty_pearls"));
        registry.register(new ItemVethean("clean_pearls"));
        registry.register(new ItemVethean("polished_pearls"));
        registry.register(new ItemVethean("shiny_pearls"));

        // Vethea lumps
        registry.register(new ItemVethean("teaker_lump"));
        registry.register(new ItemVethean("amthirmis_lump"));
        registry.register(new ItemVethean("darven_lump"));
        registry.register(new ItemVethean("cermile_lump"));
        registry.register(new ItemVethean("pardimal_lump"));
        registry.register(new ItemVethean("quadrotic_lump"));
        registry.register(new ItemVethean("karos_lump"));
        registry.register(new ItemVethean("heliosis_lump"));
        registry.register(new ItemVethean("arksiane_lump"));

        // Vethea templates
        registry.register(new ItemVethean("backsword_template"));
        registry.register(new ItemVethean("bow_template"));
        registry.register(new ItemVethean("cannon_template"));
        registry.register(new ItemVethean("claw_template"));
        registry.register(new ItemVethean("disk_template"));
        registry.register(new ItemVethean("hammer_template"));
        registry.register(new ItemVethean("staff_template"));

        registry.register(new ItemVethean("degraded_template"));
        registry.register(new ItemVethean("finished_template"));
        registry.register(new ItemVethean("glistening_template"));
        registry.register(new ItemVethean("demonized_template"));
        registry.register(new ItemVethean("tormented_template"));

        // Vethea food
        registry.register(new ItemModFood(3, 0.4F, "dream_carrot").setCreativeTab(DivineRPGTabs.vethea));
        registry.register(new ItemModFood(6, 0.6F, "dream_melon").setCreativeTab(DivineRPGTabs.vethea));
        registry.register(new ItemModFood(4, 0.8F, "dream_pie").setCreativeTab(DivineRPGTabs.vethea));
        registry.register(new ItemModFood(8, 0.8F, "dream_cake").setCreativeTab(DivineRPGTabs.vethea));
        registry.register(new ItemHealingFood(0, 0F, 2, "dream_sweets").setCreativeTab(DivineRPGTabs.vethea));
        registry.register(new ItemHealingFood(0, 0F, 8, "dream_sours").setCreativeTab(DivineRPGTabs.vethea));
        registry.register(new ItemModFood(1, 0.2F, "honeysuckle").setCreativeTab(DivineRPGTabs.vethea));
        registry.register(new ItemModFood(1, 0.2F, "honeychunk").setCreativeTab(DivineRPGTabs.vethea));

        // Vethea boss spawners
        registry.register(new ItemVethean("dream_flint"));
        registry.register(new ItemVethean("moon_clock"));

        // Vethea weapons
        // Backsword
        registry.register(new ItemVetheanSword(ToolMaterialMod.TeakerSword, "teaker_backsword"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.AmthirmisSword, "amthirmis_backsword"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.DarvenSword,"darven_backsword"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.CermileSword,"cermile_backsword"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.PardimalSword,"pardimal_backsword"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.QuadroticSword,"quadrotic_warsword"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.KarosSword,"karos_warsword"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.HeliosisSword,"heliosis_wrathsword"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.ArksianeSword,"arksiane_wrathsword"));

        // Bow
        registry.register(new ItemVetheanBow("teaker_bow", ArrowType.TEAKER_ARROW, -1, teakerArrow));
        registry.register(new ItemVetheanBow("amthirmis_bow", ArrowType.AMTHIRMIS_ARROW, -1, teakerArrow));
        registry.register(new ItemVetheanBow("darven_bow", ArrowType.DARVEN_ARROW, -1, darvenArrow));
        registry.register(new ItemVetheanBow("cermile_bow", ArrowType.CERMILE_ARROW, -1, darvenArrow));
        registry.register(new ItemVetheanBow("pardimal_bow", ArrowType.PARDIMAL_ARROW, -1, pardimalArrow));
        registry.register(new ItemVetheanBow("quadrotic_warbow", ArrowType.QUADROTIC_ARROW, -1, pardimalArrow));
        registry.register(new ItemVetheanBow("karos_warbow", ArrowType.KAROS_ARROW, -1, karosArrow));
        registry.register(new ItemVetheanBow("heliosis_wrathbow", ArrowType.HELIOSIS_ARROW, -1, karosArrow));
        registry.register(new ItemVetheanBow("arksiane_wrathbow", ArrowType.ARKSIANE_ARROW, -1, karosArrow));
        registry.register(new ItemVetheanBow("everfright", ArrowType.EVERFRIGHT, -1, everArrow));

        // Cannon
        registry.register(new ItemVetheanCannon("teaker_cannon", BulletType.TEAKER_CANNON_SHOT, ModItems.acid));
        registry.register(new ItemVetheanCannon("amthirmis_cannon", BulletType.AMTHIRMIS_CANNON_SHOT, ModItems.acid));
        registry.register(new ItemVetheanCannon("darven_cannon", BulletType.DARVEN_CANNON_SHOT, ModItems.acid));
        registry.register(new ItemVetheanCannon("cermile_cannon", BulletType.CERMILE_CANNON_SHOT, ModItems.acid));
        registry.register(new ItemVetheanCannon("pardimal_cannon", BulletType.PARDIMAL_CANNON_SHOT, ModItems.acid));
        registry.register(new ItemVetheanCannon("quadrotic_warcannon", BulletType.QUADROTIC_CANNON_SHOT, ModItems.acid));
        registry.register(new ItemVetheanCannon("karos_warcannon", BulletType.KAROS_CANNON_SHOT, ModItems.acid));
        registry.register(new ItemVetheanCannon("heliosis_wrathcannon", BulletType.HELIOSIS_CANNON_SHOT, ModItems.acid));
        registry.register(new ItemVetheanCannon("arksiane_wrathcannon", BulletType.ARKSIANE_CANNON_SHOT, ModItems.acid));
        registry.register(new ItemVetheanCannon("eversight", BulletType.EVERSIGHT_SHOT, ModItems.acid));

        // Claw
        registry.register(new ItemVetheanSword(ToolMaterialMod.TeakerClaw, "teaker_claw"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.AmthirmisClaw, "amthirmis_claw"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.DarvenClaw, "darven_claw"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.CermileClaw,"cermile_claw"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.PardimalClaw, "pardimal_claw"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.QuadroticClaw, "quadrotic_warclaw"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.KarosClaw, "karos_warclaw"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.HeliosisClaw, "heliosis_wrathclaw"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.ArksianeClaw, "arksiane_wrathclaw"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.Everbright, "everbright"));

        // Disk
        registry.register(new ItemVetheanDisk("teaker_disk", DiskType.TEAKER_DISK));
        registry.register(new ItemVetheanDisk("amthirmis_disk", DiskType.AMTHRIMIS_DISK));
        registry.register(new ItemVetheanDisk("darven_disk", DiskType.DARVEN_DISK));
        registry.register(new ItemVetheanDisk("cermile_disk", DiskType.CERMILE_DISK));
        registry.register(new ItemVetheanDisk("pardimal_disk", DiskType.PARDIMAL_DISK));
        registry.register(new ItemVetheanDisk("quadrotic_wardisk", DiskType.QUADROTIC_DISK));
        registry.register(new ItemVetheanDisk("karos_wardisk", DiskType.KAROS_DISK));
        registry.register(new ItemVetheanDisk("heliosis_wrathdisk", DiskType.HELIOSIS_DISK));
        registry.register(new ItemVetheanDisk("arksiane_wrathdisk", DiskType.ARKSIANE_DISK));

        // Hammer
        registry.register(new ItemVetheanSword(ToolMaterialMod.TeakerHammer,"teaker_hammer"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.AmthirmisHammer, "amthirmis_hammer"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.DarvenHammer,"darven_hammer"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.CermileHammer,"cermile_hammer"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.PardimalHammer,"pardimal_hammer"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.QuadroticHammer,"quadrotic_warhammer"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.KarosHammer,"karos_warhammer"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.HeliosisHammer,"heliosis_wrathhammer"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.ArksianeHammer,"arksiane_wrathhammer"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.Everlight, "everlight"));
        registry.register(new ItemVetheanSword(ToolMaterialMod.KarosRockmaul, "karos_rockmaul"));

        // Staff
        registry.register(new ItemStaff(3, 10, "teaker_staff"));
        registry.register(new ItemStaff(5, 10, "amthirmis_staff"));
        registry.register(new ItemStaff(8, 10, "darven_staff"));
        registry.register(new ItemStaff(12, 10, "cermile_staff"));
        registry.register(new ItemStaff(15, 10, "pardimal_staff"));
        registry.register(new ItemStaff(19, 10, "quadrotic_warstaff"));
        registry.register(new ItemStaff(21, 10, "karos_warstaff"));
        registry.register(new ItemStaff(28, 10, "heliosis_wrathstaff"));
        registry.register(new ItemStaff(36, 10, "arksiane_wrathstaff"));
        registry.register(new ItemEvernight(115, 80, "evernight"));

        // Vethea arrows
        registry.register(new ItemVethean("teaker_arrow"));
        registry.register(new ItemVethean("darven_arrow"));
        registry.register(new ItemVethean("pardimal_arrow"));
        registry.register(new ItemVethean("karos_arrow"));
        registry.register(new ItemVethean("ever_arrow"));

        // Vethea armor sets
        registry.register(new ItemDivineArmor("degraded_helmet", EnumArmor.DEGRADED, EntityEquipmentSlot.HEAD, basicHelmInfo));
        registry.register(new ItemDivineArmor("degraded_hood", EnumArmor.DEGRADED, EntityEquipmentSlot.HEAD, basicHoodInfo));
        registry.register(new ItemDivineArmor("degraded_mask", EnumArmor.DEGRADED, EntityEquipmentSlot.HEAD, basicMaskInfo));
        registry.register(new ItemDivineArmor(EnumArmor.DEGRADED, EntityEquipmentSlot.CHEST));
        registry.register(new ItemDivineArmor(EnumArmor.DEGRADED, EntityEquipmentSlot.LEGS));
        registry.register(new ItemDivineArmor(EnumArmor.DEGRADED, EntityEquipmentSlot.FEET));

        registry.register(new ItemDivineArmor("finished_helmet", EnumArmor.FINISHED, EntityEquipmentSlot.HEAD, basicHelmInfo));
        registry.register(new ItemDivineArmor("finished_hood", EnumArmor.FINISHED, EntityEquipmentSlot.HEAD, basicHoodInfo));
        registry.register(new ItemDivineArmor("finished_mask", EnumArmor.FINISHED, EntityEquipmentSlot.HEAD, basicMaskInfo));
        registry.register(new ItemDivineArmor(EnumArmor.FINISHED, EntityEquipmentSlot.CHEST));
        registry.register(new ItemDivineArmor(EnumArmor.FINISHED, EntityEquipmentSlot.LEGS));
        registry.register(new ItemDivineArmor(EnumArmor.FINISHED, EntityEquipmentSlot.FEET));

        registry.register(new ItemDivineArmor("glistening_helmet", EnumArmor.GLISTENING, EntityEquipmentSlot.HEAD, glisteningHelmInfo));
        registry.register(new ItemDivineArmor("glistening_hood", EnumArmor.GLISTENING, EntityEquipmentSlot.HEAD, glisteningHoodInfo));
        registry.register(new ItemDivineArmor("glistening_mask", EnumArmor.GLISTENING, EntityEquipmentSlot.HEAD, glisteningMaskInfo));
        registry.register(new ItemDivineArmor(EnumArmor.GLISTENING, EntityEquipmentSlot.CHEST));
        registry.register(new ItemDivineArmor(EnumArmor.GLISTENING, EntityEquipmentSlot.LEGS));
        registry.register(new ItemDivineArmor(EnumArmor.GLISTENING, EntityEquipmentSlot.FEET));

        registry.register(new ItemDivineArmor("demonized_helmet", EnumArmor.DEMONIZED, EntityEquipmentSlot.HEAD, demonizedHelmInfo));
        registry.register(new ItemDivineArmor("demonized_hood", EnumArmor.DEMONIZED, EntityEquipmentSlot.HEAD, demonizedHoodInfo));
        registry.register(new ItemDivineArmor("demonized_mask", EnumArmor.DEMONIZED, EntityEquipmentSlot.HEAD, demonizedMaskInfo));
        registry.register(new ItemDivineArmor(EnumArmor.DEMONIZED, EntityEquipmentSlot.CHEST));
        registry.register(new ItemDivineArmor(EnumArmor.DEMONIZED, EntityEquipmentSlot.LEGS));
        registry.register(new ItemDivineArmor(EnumArmor.DEMONIZED, EntityEquipmentSlot.FEET));

        registry.register(new ItemDivineArmor("tormented_helmet", EnumArmor.TORMENTED, EntityEquipmentSlot.HEAD, tormentedHelmInfo));
        registry.register(new ItemDivineArmor("tormented_hood", EnumArmor.TORMENTED, EntityEquipmentSlot.HEAD, tormentedHoodInfo));
        registry.register(new ItemDivineArmor("tormented_mask", EnumArmor.TORMENTED, EntityEquipmentSlot.HEAD, tormentedMaskInfo));
        registry.register(new ItemDivineArmor(EnumArmor.TORMENTED, EntityEquipmentSlot.CHEST));
        registry.register(new ItemDivineArmor(EnumArmor.TORMENTED, EntityEquipmentSlot.LEGS));
        registry.register(new ItemDivineArmor(EnumArmor.TORMENTED, EntityEquipmentSlot.FEET));

        // Vethea portal item
        registry.register(new ItemNightmareBed());

        // Vethea miscellaneous
        registry.register(new ItemVethean("acid"));
        registry.register(new ItemVethean("band_of_heiva_hunting"));
        registry.register(new ItemVethean("miners_amulet"));
        registry.register(new ItemVethean("rock_chunks"));
    }

    /**
     * Called during FML init, ensures that the crop blocks aren't null before the seeds are set to plant them
     */
    public static void addCropsToSeeds() {
        ((ItemModSeeds)whiteMushroomSeeds).setCrop(ModBlocks.whiteMushroomPlant);
        ((ItemModSeeds)tomatoSeeds).setCrop(ModBlocks.tomatoPlant);
        ((ItemModSeeds)moonbulbSeeds).setCrop(ModBlocks.moonbulb);
        ((ItemModSeeds)pinkGlowboneSeeds).setCrop(ModBlocks.pinkGlowbone);
        ((ItemModSeeds)purpleGlowboneSeeds).setCrop(ModBlocks.purpleGlowbone);
        ((ItemModSeeds)skyPlantSeeds).setCrop(ModBlocks.skyPlant);
        ((ItemModSeeds)hitchakSeeds).setCrop(ModBlocks.hitchak);
        ((ItemModSeeds)veiloSeeds).setCrop(ModBlocks.veilo);
        ((ItemModSeeds)marsineSeeds).setCrop(ModBlocks.marsine);
        ((ItemModSeeds)lamonaSeeds).setCrop(ModBlocks.lamona);
        ((ItemModSeeds)firestockSeeds).setCrop(ModBlocks.firestock);
        ((ItemModSeeds)pinflySeeds).setCrop(ModBlocks.pinfly);
        ((ItemModSeeds)aquamarineSeeds).setCrop(ModBlocks.aquamarine);
        ((ItemModSeeds)eucalyptusRootSeeds).setCrop(ModBlocks.eucalyptusRoot);
    }
}