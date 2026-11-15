package divinerpg.registries;

import com.mojang.datafixers.util.Function3;
import divinerpg.block_entities.furnace.*;
import divinerpg.blocks.arcana.*;
import divinerpg.blocks.base.*;
import divinerpg.blocks.iceika.*;
import divinerpg.blocks.twilight.*;
import divinerpg.blocks.vanilla.*;
import divinerpg.blocks.vethea.*;
import divinerpg.world.ConfiguredFeatureKeys;
import net.minecraft.core.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.*;
import net.minecraft.sounds.*;
import net.minecraft.tags.TagKey;
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.BossEvent;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.sounds.AmbientLeavesBlockSoundPlayer;
import net.minecraft.world.level.block.state.BlockBehaviour.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.material.*;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.DivineRegistries.BLOCKS;

import static divinerpg.registries.PropertyOverride.*;
import static divinerpg.registries.TagRegistry.Blocks.*;
import static divinerpg.registries.TagRegistry.Dimensions.*;
import static net.minecraft.world.level.material.MapColor.*;

public class BlockRegistry {
    //BLOCK SET TYPES
    public static final BlockSetType
        ARCANA_TYPE = BlockSetType.register(new BlockSetType(MODID + ":arcana", false, false, false, BlockSetType.PressurePlateSensitivity.MOBS, SoundType.STONE, SoundEvents.IRON_DOOR_CLOSE, SoundEvents.IRON_DOOR_OPEN, SoundEvents.IRON_TRAPDOOR_CLOSE, SoundEvents.IRON_TRAPDOOR_OPEN, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF, SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON)),
        STEEL_TYPE = BlockSetType.register(new BlockSetType(MODID + ":steel", true, true, false, BlockSetType.PressurePlateSensitivity.EVERYTHING, SoundType.METAL, SoundEvents.IRON_DOOR_CLOSE, SoundEvents.IRON_DOOR_OPEN, SoundEvents.IRON_TRAPDOOR_CLOSE, SoundEvents.IRON_TRAPDOOR_OPEN, SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF, SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON));
    //WOOD TYPES
    public static final WoodType
        DIVINE_WOOD_TYPE = WoodType.register(new WoodType("divine", BlockSetType.CHERRY)),
    // TODO: remap brittle_leaves into shiverspine_leaves
        SHIVERSPINE_WOOD_TYPE = WoodType.register(new WoodType("shiverspine", BlockSetType.OAK)),
        AURORAOAK_WOOD_TYPE = WoodType.register(new WoodType("auroraoak", BlockSetType.OAK)),
        COZYBARK_WOOD_TYPE = WoodType.register(new WoodType("cozybark", BlockSetType.CHERRY)),
        CRIMSEEKER_WOOD_TYPE = WoodType.register(new WoodType("crimseeker", BlockSetType.CHERRY)),
        STREAMLEAF_WOOD_TYPE = WoodType.register(new WoodType("streamleaf", BlockSetType.WARPED)),
        EUCALYPTUS_WOOD_TYPE = WoodType.register(new WoodType("eucalyptus", BlockSetType.OAK)),
        EDEN_WOOD_TYPE = WoodType.register(new WoodType("eden", BlockSetType.OAK)),
        WILDWOOD_WOOD_TYPE = WoodType.register(new WoodType("wildwood", BlockSetType.OAK)),
        APALACHIA_WOOD_TYPE = WoodType.register(new WoodType("apalachia", BlockSetType.WARPED)),
        SKYTHERN_WOOD_TYPE = WoodType.register(new WoodType("skythern", BlockSetType.WARPED)),
        MORTUM_WOOD_TYPE = WoodType.register(new WoodType("mortum", BlockSetType.DARK_OAK));
    //BLOCKS
    //stone
    public static final List<DeferredBlock<Block>>
    asphaltSet = registerStairSlabSet("asphalt", "", Pasphalt),
    ancientStoneSet = registerBreakPair("ancient_stone", PgrayStone, PgrayStoneUnbreakable),
    arcaniteStoneSet = registerSimpleStoneSet("arcanite", PcyanStone),
    coalstoneSet = registerStoneTypeSet("coalstone", PgrayStone),
    cobbledFrozenStoneSet = registerSimpleStoneSet("cobbled_frozen", PcobbledFrozenStone),
    cobbledScorchaltSet = registerStoneTypeSet("cobbled_scorchalt", PcobbledScorchalt),
    cobaltiteSet = registerStoneTypeSet("cobaltite", PlightBlueStone),
    frozenStoneSet = registerSimpleStoneSet("frozen", PfrozenStone),
    rayStoneSet = registerStoneTypeSet("ray_stone", PgoldenStone),
    scorchaltSet = registerStoneTypeSet("scorchalt", PpinkStone),
    soulStoneSet = registerBreakPair("soul_stone", PterraBlueStone, PsoulStoneUnbreakable),
    twilightStoneSet = registerSimpleStoneSet("twilight", PtwilightStone);
    public static final DeferredBlock<Block>
    blackHungerstone = register("black_hungerstone", PblackUnbreakable),
    darkEverstone = register("dark_everstone", PblackUnbreakable),
    divineMossStone = register("divine_moss_stone", PdivineMossStone),
    divineRock = register("divine_rock", PdivineRock),
    draughtStone = register("draught_stone", PdraughtStone),
    dreamStone = register("dream_stone", PcyanStone),
    everstone = register("everstone", PgreenUnbreakable),
    exposedScorchalt = register("exposed_scorchalt", PgoldenStone),
    greenHungerstone = register("green_hungerstone", PgreenUnbreakable),
    hiveWall = register("hive_wall", PhiveWall),
    icyStone = register("icy_stone", PhardIce),
    lunaStone = register("luna_stone", PlunaStone),
    milkStone = register("milk_stone", PwhiteStone),
    thermalVent = register("thermal_vent", ThermalVent::new, PthermalVent),
    whiteEverstone = register("white_everstone", PwhiteUnbreakable);

    //ore
    public static final List<DeferredBlock<Block>>
    realmiteOreSet = registerOverworldOres("realmite"),
    arlemiteOreSet = registerOverworldOres("arlemite"),
    rupeeOreSet = registerOverworldOres("rupee");
    public static final DeferredBlock<Block>
    anthraciteOre = registerOre("anthracite", PFrozenOre, 0, 2),
    apalachiaOre = register("apalachia_ore", PtwilightOre),
    bloodgemOre	= registerOre("bloodgem", PbloodgemOre, 3, 7),
    mortumOre = register("mortum_ore", PtwilightOre),
    oxdriteOre = register("oxdrite_ore", PFrozenOre),
    rawArcanium = register("raw_arcanium", PrawArcanium),
    scorchaltEdenOre = register("scorchalt_eden_ore", PscorchaltEdenOre),
    skythernOre = register("skythern_ore", PtwilightOre),
    torriditeOre = register("torridite_ore", PtorriditeOre),
    twilightEdenOre = register("twilight_eden_ore", PtwilightOre),
    wildwoodOre = register("wildwood_ore", PtwilightOre);

    //compressed blocks
    public static final List<DeferredBlock<Block>>
    arlemiteBlockSet = registerMetalBlocks("arlemite", PrawArlemite, ParlemiteBlock),
    realmiteBlockSet = registerMetalBlocks("realmite", PrawRealmite, PorangeMetal),
    rupeeBlockSet = registerMetalBlocks("rupee", PrawRupee, lightBlueMetal),
    torriditeBlockSet = registerMetalBlocks("torridite", PrawTorridite, PtorriditeBlock),
    oxdriteBlockSet = registerMetalBlocks("oxdrite", PrawOxdrite, PoxdriteBlock);
    public static final DeferredBlock<Block>
    apalachiaBlock = register("apalachia_block", PmagentaMetal),
    arcaniumBlock = register("arcanium_block", lightBlueMetal),
    bloodgemBlock = register("bloodgem_block", PbloodgemBlock),
    edenBlock = register("eden_block", PorangeMetal),
    mortumBlock = register("mortum_block", PmortumBlock),
    shadowBlock = register("shadow_block", PblackMetal),
    skythernBlock = register("skythern_block", PskythernBlock),
    wildwoodBlock = register("wildwood_block", PwildwoodBlock);

    //light crystal
    public static final DeferredBlock<Block>
    blueStone = register("blue_stone", PblueStone),
    fireCrystal = register("fire_crystal", PfireCrystal),
    firelight = register("firelight", Pfirelight);

    //plant
    public static final List<DeferredBlock<Block>>
    brittleGrass = registerPotted("brittle_grass", BrittleGrass::new, PbrittleGrass),
    crimpetal = registerFlower("crimpetal", PmagentaFlower, MobEffects.FIRE_RESISTANCE, 4),
    roofbell = registerFlower("roofbell", Proofbell, MobEffects.POISON, 11),
    winterbloom = registerFlower("winterbloom", Pwinterbloom, MobEffects.LEVITATION, 8),
    wispLeaf = registerFlower("wisp_leaf", Pwispleaf, MobEffects.DOLPHINS_GRACE, 7),
    arcanaBrush = registerDryGrass("arcana_brush", PiceGrass),
    arcanaBush = registerDryGrass("arcana_bush", PterraBlueGrass),
    gemOfTheDunes = registerPotted("gem_of_the_dunes", p -> new Flower(MobEffects.RESISTANCE, 5, true, p), PmagentaFlower),
    edenBrush = registerGrass("eden_brush", PedenBrush),
    sunBlossom = registerFlower("sun_blossom", plantFlower, MobEffects.FIRE_RESISTANCE, 6),
    sunbloom = registerFlower("sunbloom", PterraYellowFlower, MobEffects.GLOWING, 6),
    lushroom = registerPotted("lushroom", Lushroom::new, PterraOrangeFlower),
    moonlightFern = registerGrass("moonlight_fern", PiceGrass),
    moonBud = registerFlower("moon_bud", PquartzFlower, MobEffects.WATER_BREATHING, 4),
    apalachiaTallgrass = registerGrass("apalachia_tallgrass", PterraBlueGrass),
    duskBloom = registerFlower("dusk_bloom", PterraBlueFlower, MobEffects.BLINDNESS, 11),
    skythernBrush = registerGrass("skythern_brush", PskythernBrush),
    dustLily = registerFlower("dust_lily", PwoolFlower, MobEffects.INVISIBILITY, 5),
    mortumBrush = registerGrass("mortum_brush", PmortumBrush),
    eyePlant = registerFlower("eye_plant", PgrayFlower, MobEffects.NIGHT_VISION, 6),
    shineGrass = registerFlower("shine_grass", PcyanFlower, MobEffects.GLOWING, 6),
    cracklespike = registerFlower("cracklespike", PcyanFlower, MobEffects.NAUSEA, 7),
    fernite = registerFlower("fernite", PcyanFlower, MobEffects.WEAKNESS, 7),
    dreamglow = registerFlower("dreamglow", PcyanFlower, MobEffects.NIGHT_VISION, 5),
    bulbatobe = registerFlower("bulbatobe", PcyanFlower, MobEffects.POISON, 11),
    shimmer = registerFlower("shimmer", PcyanFlower, MobEffects.BLINDNESS, 11),
    yellowDulah = registerFlower("yellow_dulah", PcyanFlower, MobEffects.JUMP_BOOST, 5),
    greenDulah = registerFlower("green_dulah", PcyanFlower, MobEffects.MINING_FATIGUE, 11),
    greenGemtop = registerFlower("green_gemtop", PcyanFlower, MobEffects.SLOW_FALLING, 5),
    purpleGemtop = registerFlower("purple_gemtop", PcyanFlower, MobEffects.HASTE, 6);
    public static final DeferredBlock<Block>
    winterberryBush = register("winterberry_bush", WinterberryBush::new, PwinterberryBush),
    winterberryVinesBody = registerItemless("winterberry_vines_body", WinterberryVinesBody::new, PwinterberryVinesBody),
    winterberryVinesHead = register("winterberry_vines_head", WinterberryVinesHead::new, PwinterberryVinesHead),
    snowyMoss = register("snowy_moss", SnowyMoss::new, PsnowyMoss),
    globebrush = registerTallFlower("globebrush", Pglobebrush),
    thermoliage = registerTallFlower("thermoliage", Pthermoliage),
    arcaniteVinesBody = registerItemless("arcanite_vines_body", ArcaniteVinesBody::new, ParcaniteVines),
    arcaniteVinesHead = register("arcanite_vines_head", ArcaniteVinesHead::new, ParcaniteVines),
    duncap = register("duncap", Duncap::new, Pduncap),
    landVineStem = register("land_vine_stem", LandVineStem::new, PlandVineStem),
    landVine = register("land_vine", LandVine::new, PlandVine),
    wildwoodTallgrass = register("wildwood_tallgrass", DoublePlantBlock::new, PblueTallgrass),
    truffle = register("truffle", Ptruffle),
    wildwoodVine = registerVine("wildwood", PwildwoodVine),
    duskFlower = registerTallFlower("dusk_flower", PduskFlower),
    dustBrambles = register("dust_brambles", Bramble::new, PwoolTallgrass),
    demonBrambles = register("demon_brambles", Bramble::new, PgrayTallgrass),
    weedwoodVine = registerVine("weedwood", PweedwoodVine),
    blossomedWeedwoodVine = registerVine("blossomed_weedwood", PweedwoodVine),
    tomatoPlant = registerCrop("tomato", crop, ItemRegistry.tomato_seeds),
    whiteMushroomPlant = registerCrop("white_mushroom", crop, ItemRegistry.white_mushroom_seeds),
    aquamarinePlant = registerCrop("aquamarine", crop, ItemRegistry.aquamarine_seeds),
    eucalyptusPlant = registerCrop("eucalyptus", crop, ItemRegistry.eucalyptus_root_seeds),
    firestockPlant = registerArcanaDoubleCrop("firestock", crop, ItemRegistry.firestock_seeds),
    hitchakPlant = registerCrop("hitchak", crop, ItemRegistry.hitchak_seeds),
    lamonaPlant = registerCrop("lamona", crop, ItemRegistry.lamona_seeds),
    marsinePlant = registerCrop("marsine", crop, ItemRegistry.marsine_seeds),
    pinflyPlant = registerArcanaDoubleCrop("pinfly", crop, ItemRegistry.pinfly_seeds),
    veiloPlant = registerCrop("veilo", crop, ItemRegistry.veilo_seeds),
    moonbulbPlant = registerDoubleCrop("moonbulb", PcropLight4, ItemRegistry.moonbulb_seeds),
    purpleGlowbonePlant = registerDoubleCrop("purple_glowbone", PcropLight6, ItemRegistry.purple_glowbone_seeds),
    pinkGlowbonePlant = registerDoubleCrop("pink_glowbone", PcropLight6, ItemRegistry.pink_glowbone_seeds),
    skyPlant = registerCrop("sky", crop, ItemRegistry.sky_plant_seeds);

    //soil
    public static final List<DeferredBlock<Block>>
    apalachiaSoil = registerSoils("apalachia", PblueDirt, PapalachiaGrass, apalachiaTallgrass.getFirst(), true),
    arcaniteSoil = registerSoils("arcanite", PblueDirt, ParcaniteGrass, null, true),
    dreamSoil = registerSoils("dream", PdreamDirt, PdreamGrass, null, false),
    frozenSoil = registerSoils("frozen", PfrozenDirt, PfrozenGrass, null, true),
    mortumSoil = registerSoils("mortum", PmortumDirt, PmortumGrass, mortumBrush.getFirst(), false),
    raySoil = registerSoils("ray", PrayDirt, PyellowGrass, edenBrush.getFirst(), true),
    scorchsoil = registerSoils("scorchdirt", "scorchgrass", Scorchdirt::new, (d, g, b) -> p -> new Scorchgrass(p, d, g, b), Pscorchdirt, PyellowGrass, edenBrush.getFirst(), true),
    skythernSoil = registerSoils("skythern", PskythernDirt, PskythernGrass, skythernBrush.getFirst(), true),
    soulSludgeSet = registerBreakPair("soul_sludge", PsoulSludge, PsoulSludgeUnbreakable),
    wildwoodSoil = registerSoils("wildwood", PwildwoodDirt, PwildwoodGrass, moonlightFern.getFirst(), true);
    public static final DeferredBlock<Block>
    arcanicSand = registerSand("arcanic_sand", ParcanicSand, 4027550),
    arcaniteSand = registerSand("arcanite_sand", ParcaniteSand, 7911916),
    arcaniumRichSand = registerSand("arcanium_rich_sand", ParcaniumRichSand, 1130855),
    evergrass = registerDreamGrass("evergrass", PeverGrass),
    flameGrass = registerDreamGrass("flame_grass", PflameGrass),
    frozenGravel = register("frozen_gravel", FrozenGravel::new, PfrozenGravel),
    gelidite = register("gelidite", Pgelidite),
    //TODO: rakedFrozenGravel = ModList.get().isLoaded("supplementaries") && SupplementariesLoader.rakedGravelEnabled() ? register("raked_frozen_gravel", RakedFrozenGravel::new, gravel) : null,
    scorchedGrass = register("scorched_grass", p -> new ModGrassBlock(p, dreamStone, false), PscorchedGrass);

    //ice
    public static final DeferredBlock<Block>
    glaciline = register("glaciline", Pglaciline),
    icicle = register("icicle", p -> new Icicle(Blocks.PACKED_ICE.defaultBlockState(), p), Picicle);

    //moss
    public static final DeferredBlock<Block>
    arcaniteMoss = register("arcanite_moss", MossBlock::new, ParcaniteMoss),
    brittleMoss = register("brittle_moss", BrittleMoss::new, PbrittleMoss);

    //portal
    public static final DeferredBlock<Block>
    arcanaPortalFrame = register("arcana_portal_frame", ArcanaPortalFrame::new, ParcanaPortalFrame);

    //gems
    public static final DeferredBlock<Block>
    olivineBlock = register("olivine_block", AmethystBlock::new, PolivineBlock),
    buddingOlivine = register("budding_olivine", BuddingOlivine::new, PbuddingOlivine),
    olivineCluster = register("olivine_cluster", p -> new AmethystClusterBlock(7, 3, p), PolivineCluster),
    buddingDravite = register("budding_dravite", PbuddingDravite);

    //wood
    public static final List<DeferredBlock<Block>>
    apalachiaWoodSet = registerTreeSet("apalachia", COLOR_MAGENTA, WARPED_HYPHAE, COLOR_MAGENTA, APALACHIA_WOOD_TYPE, ConfiguredFeatureKeys.APALACHIA_TREE),
    auroraoakWoodSet = registerTreeSet("auroraoak", COLOR_PURPLE, COLOR_BROWN, ICE, AURORAOAK_WOOD_TYPE, ConfiguredFeatureKeys.AURORAOAK_TREE),
    cozybarkWoodSet = registerTreeSet("cozybark", CRIMSON_STEM, TERRACOTTA_PURPLE, TERRACOTTA_PURPLE, COZYBARK_WOOD_TYPE, ConfiguredFeatureKeys.COZYBARK_TREE, CozybarkLeaves::new),
    crimseekerWoodSet = registerTreeSet("crimseeker", CRIMSON_STEM, CRIMSON_STEM, COLOR_GREEN, CRIMSEEKER_WOOD_TYPE, null, Block::new),//TODO: Tree feature
    divineWoodSet = registerTreeSet("divine", GOLD, TERRACOTTA_LIGHT_GREEN, TERRACOTTA_LIGHT_GREEN, DIVINE_WOOD_TYPE, ConfiguredFeatureKeys.DIVINE_TREE),
    dreamwoodSet = registerDreamTreeSet("dreamwood", COLOR_CYAN, COLOR_CYAN, COLOR_LIGHT_BLUE),
    edenWoodSet = registerTreeSet("eden", GOLD, COLOR_BROWN, SAND, EDEN_WOOD_TYPE, ConfiguredFeatureKeys.EDEN_TREE),
    eucalyptusWoodSet = registerWoodSet("eucalyptus", COLOR_LIGHT_GRAY, TERRACOTTA_WHITE, EUCALYPTUS_WOOD_TYPE),
    firewoodSet = registerDreamTreeSet("firewood", CRIMSON_NYLIUM, COLOR_RED, TERRACOTTA_ORANGE),
    hyrewoodSet = registerDreamTreeSet("hyrewood", COLOR_BLUE, COLOR_BLUE, COLOR_BLUE),
    mintwoodSet = registerDreamTreeSet("mintwood", WARPED_WART_BLOCK, WARPED_WART_BLOCK, DIAMOND),
    mortumWoodSet = registerTreeSet("mortum", COLOR_BLACK, TERRACOTTA_PINK, COLOR_GRAY, MORTUM_WOOD_TYPE, ConfiguredFeatureKeys.MORTUM_TREE),
    shiverspineWoodSet = registerTreeSet("shiverspine", WOOL, COLOR_LIGHT_GRAY, GLOW_LICHEN, SHIVERSPINE_WOOD_TYPE, ConfiguredFeatureKeys.SHIVERSPINE_TREE),
    skythernWoodSet = registerTreeSet("skythern", COLOR_LIGHT_GRAY, COLOR_LIGHT_GRAY, WOOL, SKYTHERN_WOOD_TYPE, ConfiguredFeatureKeys.SKYTHERN_TREE),
    streamleafWoodSet = registerTreeSet("streamleaf", GLOW_LICHEN, TERRACOTTA_BROWN, ICE, STREAMLEAF_WOOD_TYPE, ConfiguredFeatureKeys.STREAMLEAF_TREE),
    wildwoodWoodSet = registerTreeSet("wildwood", COLOR_LIGHT_BLUE, COLOR_BLUE, COLOR_LIGHT_BLUE, WILDWOOD_WOOD_TYPE, ConfiguredFeatureKeys.WILDWOOD_TREE);
    public static final DeferredBlock<Block>
    plankDesign = register("plank_design", Pdesign),
    stairDesign = registerStair("stair_design", Pdesign, plankDesign),
    slabDesign = registerSlab("slab_design", Pdesign);
    //TODO: woodcutterDesign = registerBlockCorailWoodcutter("woodcutter_design", ModList.get().isLoaded("corail_woodcutter") ? WoodcutterLoader.create(plankDesign, WoodType.OAK) : null),

    //tall fungus
    public static final List<DeferredBlock<Block>>
    glowsproutSet = registerFungusSet("glowsprout", COLOR_CYAN, DIAMOND, COLOR_LIGHT_BLUE, ConfiguredFeatureKeys.GLOWSPROUT),
    lowsproutSet = registerFungusSet("lowsprout", COLOR_GREEN, WARPED_WART_BLOCK, GLOW_LICHEN, ConfiguredFeatureKeys.LOWSPROUT),
    slowsproutSet = registerFungusSet("slowsprout", COLOR_MAGENTA, ICE, COLOR_PINK, ConfiguredFeatureKeys.SLOWSPROUT);

    //wool
    public static final List<DeferredBlock<Block>>
    checkerSet = registerWoolSet("checker", "", Pchecker, DyeColor.BLACK),
    rainbowSet = registerWoolSet("rainbow", "_wool", Prainbow, DyeColor.PURPLE),
    fancySet = registerWoolSet("fancy", "_wool", Pfancy, DyeColor.BROWN),
    workshopCarpetSet = registerStairSlabSet("workshop", "_carpet", PworkshopCarpet);

    //obsidian
    public static final DeferredBlock<Block>
    darkstone = register("darkstone", Pdarkstone),
    bleedingObsidian = register("bleeding_obsidian", PcryingObsidian),
    shiningObsidian = register("shining_obsidian", PcryingObsidian),
    glitteringObsidian = register("glittering_obsidian", PcryingObsidian),
    seepingObsidian = register("seeping_obsidian", PcryingObsidian),
    vwoopingObsidian = register("vwooping_obsidian", PcryingObsidian),
    broodingObsidian = register("brooding_obsidian", PcryingObsidian);

    //bricks
    public static final DeferredBlock<Block>
    milkStoneBricks = register("milk_stone_bricks", PmilkStoneBricks),
    ironBricks = register("iron_bricks", PironBricks),
    torriditeBricks = register("torridite_bricks", PtorriditeBricks),
    lavaBricks = register("lava_bricks", PlavaBricks),
    realmiteBricks = register("realmite_bricks", PorangeBricks),
    goldBricks = register("gold_bricks", PgoldBricks),
    arlemiteBricks = register("arlemite_bricks", PlightGreenBricks),
    greenBricks = register("green_bricks", PgreenBricks),
    darkstoneBricks = register("darkstone_bricks", PdarkstoneBricks),
    aquatonicBricks = register("aquatonic_bricks", PaquatonicBricks),
    diamondBricks = register("diamond_bricks", PdiamondBricks),
    lapisLazuliBricks = register("lapis_lazuli_bricks", PlapisBricks),
    purpleBricks = register("purple_bricks", PpurpleBricks),
    magentaBricks = register("magenta_bricks", PmagentaBricks),
    bloodgemBricks = register("bloodgem_bricks", PcrimsonBricks);

    //Minibricks
    public static final DeferredBlock<Block>
    minibricks = register("minibricks", PminiBricks),
    bedrockMinibricks = registerFireResistant("bedrock_minibricks", PbedrockMinibricks),
    torriditeMinibricks = registerFireResistant("torridite_minibricks", PtorriditeBricks),
    realmiteMinibricks = register("realmite_minibricks", PorangeBricks),
    arlemiteMinibricks = register("arlemite_minibricks", PlightGreenBricks),
    rupeeMinibricks = register("rupee_minibricks", PrupeeMinibricks),
    bloodgemMinibricks = register("bloodgem_minibricks", PcrimsonBricks);

    //TODO: frozenGravelBricks = registerBlockSupplementariesGravelBricks("frozen_gravel_bricks",ModList.get().isLoaded("supplementaries") ? FrozenGravelBricks::new : null),
    //TODO: suspiciousFrozenGravelBricks = registerBlockSupplementariesGravelBricks("suspicious_frozen_gravel_bricks", ModList.get().isLoaded("supplementaries") ? SuspiciousFrozenGravelBricks::new : null),

    //Iceika bricks & other
    public static final List<DeferredBlock<Block>>
    coalstoneBrickSet = registerBrickSet("coalstone_brick", PcoalstoneBricks),
    cutOxdriteSet = registerRockSet("cut_oxdrite", "", PcutOxdrite, BlockSetType.COPPER, WaterloggedTransparentBlock::new),
    frozenBrickSet = registerBrickSet("frozen_brick", PfrozenStone),
    polishedCoalstoneSet = registerStoneTypeSet("polished_coalstone", PgrayStone),
    polishedCobaltiteSet = registerStoneTypeSet("polished_cobaltite", PlightBlueStone);
    public static final DeferredBlock<Block>
    snowBricks = register("snow_bricks", PsnowBricks),
    icyBricks = register("icy_bricks", Pice),
    runicIcyBricks = register("runic_icy_bricks", Pice),
    workshopBookcase = register("workshop_bookcase", PgrayCobblestone),
    chiseledCoalstoneBricks = register("chiseled_coalstone_bricks", PgrayStone);

    //Arcana bricks & other
    public static final List<DeferredBlock<Block>>
    ancientBrickSet = registerArcanaSet("ancient_brick", ItemRegistry.ancient_key, WARPED_NYLIUM),
    ancientTileSet = registerBreakPair("ancient_tile", PblueCobblestone, PblueUnbreakable),
    arcaniteTileSet = registerBrickSet("arcanite_tile", PcyanStone),
    arcaniumMetalSet = registerBreakPair("arcanium_metal", PterraBlueMetal, ParcaniumMetal),
    arcaniumPowerSet = registerBreakPair("arcanium_power", PgrayCobblestone, PgrayStoneUnbreakable),
    degradedBrickSet = registerArcanaSet("degraded_brick", ItemRegistry.degraded_key, COLOR_BLUE);
    public static final DeferredBlock<Block>
    lightDegradedBrick = register("light_degraded_brick", PcyanStoneUnbreakable),
    darkDegradedBrick = register("dark_degraded_brick", PblackUnbreakable),
    battleBricks = register("battle_bricks", PcrimsonHyphaeUnbreakable),
    gildedBricks = register("gilded_bricks", PterraYellowUnbreakable),
    dungeonBookshelf = register("dungeon_bookshelf", PblueCobblestone),
    arcaniteTubes = registerLadder("arcanite_tubes", ladder),
    arcaniteLadder = registerLadder("arcanite_ladder", ladder),
    soulSludgeDoor = registerArcanaDoor("soul_sludge", PsludgeDoor, ItemRegistry.sludge_key),
    soulStoneDoor = registerArcanaDoor("soul_stone", PsoulStoneDoor, ItemRegistry.soul_key);

    //Twilight bricks & other
    public static final List<DeferredBlock<Block>>
    twilightBrickSet = registerBrickSet("twilight_brick", PterraBlueStone),
    polishedScorchaltSet = registerSimpleStoneSet("polished_scorchalt", PpinkStone),
    polishedRayStoneSet = registerSimpleStoneSet("polished_ray_stone", PgoldenStone);
    public static final DeferredBlock<Block>
    chiseledScorchalt = register("chiseled_scorchalt", PpinkStone),
    edenBricks = register("eden_bricks", PyellowStone),
    wildwoodBricks = register("wildwood_bricks", PlightBlueStone),
    apalachiaBricks = register("apalachia_bricks", PmagentaStone),
    skythernBricks = register("skythern_bricks", PwhiteStone),
    mortumBricks = register("mortum_bricks", PgrayStone);

    //Vethea bricks & other
    public static final DeferredBlock<Block>
    hallWall = register("hall_wall", PnetherUnbreakable),
    redDreamBricks = register("red_dream_bricks", PcrimsonNyliumStone),
    lightDreamBricks = register("light_dream_bricks", PlapisStone),
    darkDreamBricks = register("dark_dream_bricks", PblueStone),
    blueKarosBricks = register("blue_karos_bricks", PblueUnbreakable),
    blackKarosBricks = register("black_karos_bricks", PblackUnbreakable),
    metalCaging = register("metal_caging", PterraGreenMetal),
    barredDoor = registerDoor("barred", PbarredDoor, STEEL_TYPE),
    helioticBeam = register("heliotic_beam", HelioticBeam::new, PwhiteUnbreakable),
    lunaBricks = register("luna_bricks", PblueCobblestone),
    cryptFloor = register("crypt_floor", PterraGreenUnbreakable),
    cryptWall = register("crypt_wall", PbrownUnbreakable),
    chamberWall = register("chamber_wall", PbrownUnbreakable),
    shiftedChamberWall = register("shifted_chamber_wall", PbrownUnbreakable),
    stackedChamberWall = register("stacked_chamber_wall", PbrownUnbreakable);

    //Steel
    public static final DeferredBlock<Block>
    steel = register("steel", PropertyOverride.PterraBlueMetal),
    blackSteel = register("black_steel", PblackMetal),
    redSteel = register("red_steel", PredMetal),
    orangeSteel = register("orange_steel", PorangeMetal),
    yellowSteel = register("yellow_steel", PyellowMetal),
    greenSteel = register("green_steel", PgreenMetal),
    cyanSteel = register("cyan_steel", PcyanMetal),
    blueSteel = register("blue_steel", PblueMetal),
    purpleSteel = register("purple_steel", PpurpleMetal),
    magentaSteel = register("magenta_steel", PmagentaMetal),
    steelDoor = registerDoor("steel", PsteelDoor, STEEL_TYPE);

    //Candy
    public static final DeferredBlock<Block>
    redCandyCane = registerCandy("red_candy_cane", PredCandy),
    yellowCandyCane = registerCandy("yellow_candy_cane", PyellowCandy),
    greenCandyCane = registerCandy("green_candy_cane", PemeraldCandy),
    blueCandyCane = registerCandy("blue_candy_cane", PblueCandy),
    pinkCandyCane = registerCandy("pink_candy_cane", PmagentaCandy);

    //Lights
    public static final DeferredBlock<Block>
    redFairyLights = registerLadder("red_fairy_lights", Plights),
    yellowFairyLights = registerLadder("yellow_fairy_lights", Plights),
    greenFairyLights = registerLadder("green_fairy_lights", Plights),
    blueFairyLights = registerLadder("blue_fairy_lights", Plights),
    purpleFairyLights = registerLadder("purple_fairy_lights", Plights);

    //Torches
    public static final List<DeferredBlock<Block>>
    aquaTorchSet = registerTorchSet("aqua", AquaTorch::new, AquaWallTorch::new, Ptorch),
    arcaniumTorchSet = registerTorchSet("arcanium",Ptorch, ParticleRegistry.PURPLE_FLAME),
    skeletonTorchSet = registerTorchSet("skeleton", PskeletonTorch, () -> ParticleTypes.FLAME),
    edenTorchSet = registerTorchSet("eden", Ptorch, ParticleRegistry.GREEN_FLAME);

    //Lamps
    public static final List<DeferredBlock<Block>>
    dungeonLampSet = registerBreakPair("dungeon_lamp", PquartzLamp, PquartzLampUnbreakable);
    public static final DeferredBlock<Block>
    moltenLamp = register("molten_lamp", PorangeLamp),
    divineLamp = register("divine_lamp", PterraYellowLamp),
    jungleLamp = register("jungle_lamp", PlightGreenLamp),
    terranLamp = register("terran_lamp", PemeraldLamp),
    iceLamp = register("ice_lamp", PcyanLamp),
    soulfireLamp = register("soulfire_lamp", PwaterLamp),
    enderStoneLamp = register("ender_stone_lamp", PpurpleLamp),
    milkyLamp = register("milky_lamp", PquartzLantern),
    edenLamp = register("eden_lamp", PredLantern),
    torriditeLamp = register("torridite_lamp", PcrimsonNyliumLantern),
    lavaLamp = register("lava_lamp", PfireLantern),
    drakenLamp = register("draken_lamp", PorangeLantern),
    realmiteLamp = register("realmite_lamp", PorangeLantern),
    blazeLamp = register("blaze_lamp", PyellowLantern),
    goldLamp = register("gold_lamp", PgoldLantern),
    arlemiteLamp = register("arlemite_lamp", PlightGreenLantern),
    krakenLamp = register("kraken_lamp", PwarpedNyliumLantern),
    diamondLamp = register("diamond_lamp", PdiamondLantern),
    rupeeLamp = register("rupee_lamp", PlightBlueLantern),
    lapisLazuliLamp = register("lapis_lazuli_lamp", PlapisLantern),
    aquaLamp = register("aqua_lamp", PblueLantern),
    enderLamp = register("ender_lamp", PblueLantern),
    bloodgemLamp = register("bloodgem_lamp", PpinkLantern),
    slimeLight = register("slime_light", RedstoneLampBlock::new, PgreenRedstoneLamp),
    workshopLamp = register("workshop_lamp", PlightBlueLamp),
    cellLamp = register("cell_lamp", PlightGreenLamp),
    villageLamp = register("village_lamp", PterraRedLamp),
    dreamLamp = register("dream_lamp", DreamLamp::new, PgrayRedstoneLamp);

    //Bridge
    public static final DeferredBlock<Block>
    darkBridge = registerBridge("dark_bridge", PgrayRedstoneLamp),
    starBridge = registerBridge("star_bridge", PredRedstoneLamp);

    //Redstone Fence
    public static final DeferredBlock<Block>
    redFence = registerRedstoneFence("red", PredFence),
    blueFence = registerRedstoneFence("blue", PblueFence),
    greenFence = registerRedstoneFence("green", PgreenFence);

    //Glass
    public static final DeferredBlock<Block>
    frostedGlass = register("frosted_glass", PsnowGlass),
    stainedGlass = register("stained_glass", PredGlass),
    smoothGlass = register("smooth_glass", PlightGreenGlass);

    //Mob Pumpkins
    public static final DeferredBlock<Block>
    blazePumpkin = registerMobPumpkin("blaze", PyellowPumpkin, () -> SoundEvents.BLAZE_AMBIENT),
    creeperPumpkin = registerMobPumpkin("creeper", PemeraldPumpkin, () -> SoundEvents.CREEPER_PRIMED),
    cyclopsPumpkin = registerMobPumpkin("cyclops", PterraLightGreenPumpkin, SoundRegistry.CYCLOPS),
    enderPumpkin = registerMobPumpkin("ender", PblackPumpkin, () -> SoundEvents.ENDERMAN_SCREAM),
    enderWatcherPumpkin = registerMobPumpkin("ender_watcher", PterraBluePumpkin, () -> SoundEvents.ENDERMAN_AMBIENT),
    frostPumpkin = registerMobPumpkin("frost", PwarpedStemPumpkin, SoundRegistry.FROST),
    ghastPumpkin = registerMobPumpkin("ghast", PsnowPumpkin, () -> SoundEvents.GHAST_SCREAM),
    glaconPumpkin = registerMobPumpkin("glacon", PcyanPumpkin, SoundRegistry.GLACIDE),
    hellspiderPumpkin = registerMobPumpkin("hellspider", PnetherPumpkin, SoundRegistry.HELL_SPIDER),
    jungleSpiderPumpkin = registerMobPumpkin("jungle_spider", PplantPumpkin, SoundRegistry.JUNGLE_SPIDER),
    skeletonPumpkin = registerMobPumpkin("skeleton", PwoolPumpkin, () -> SoundEvents.SKELETON_AMBIENT),
    spiderPumpkin = registerMobPumpkin("spider", PgrayPumpkin, () -> SoundEvents.SPIDER_AMBIENT),
    zombiePumpkin = registerMobPumpkin("zombie", PgreenPumpkin, () -> SoundEvents.ZOMBIE_AMBIENT);

    //Statues
    public static final DeferredBlock<Block>
    ancientEntityStatue = registerStatue("ancient_entity", statue, () -> SoundEvents.IRON_GOLEM_DEATH),
    theWatcherStatue = registerStatue("the_watcher", statue, SoundRegistry.ROAR),
    kingOfScorchersStatue = registerStatue("king_of_scorchers", statue, SoundRegistry.KING_OF_SCORCHERS),
    kitraStatue = registerStatue("kitra", statue, SoundRegistry.WHALE),
    ayeracoStatue = register("ayeraco_statue", AyeracoStatue::new, statue, p -> p.component(DataComponents.DYE, DyeColor.WHITE).fireResistant().rarity(Rarity.RARE)),
    dramixStatue = registerStatue("dramix", statue, SoundRegistry.DRAMIX),
    parasectaStatue = registerStatue("parasecta", statue, SoundRegistry.PARASECTA),
    sunstormStatue = registerStatue("sunstorm", statue, SoundRegistry.SPARKLER),
    termasectStatue = registerStatue("termasect", statue, () -> SoundEvents.WOOD_STEP),
    eternalArcherStatue = registerStatue("eternal_archer", statue, SoundRegistry.ARCHER),
    experiencedCoriStatue = registerStatue("experienced_cori", statue, SoundRegistry.CORI),
    vamacheronStatue = registerStatue("vamacheron", statue),
    karotStatue = registerStatue("karot", statue),
    twilightDemonStatue = registerStatue("twilight_demon", statue, SoundRegistry.INSECT),
    densosStatue = registerStatue("densos", statue, SoundRegistry.DENSOS),
    reyvorStatue = registerStatue("reyvor", statue, SoundRegistry.REYVOR),
    soulFiendStatue = registerStatue("soul_fiend", statue);

    //Spawners
    public static final DeferredBlock<Block>
    proximitySpawner = register("proximity_spawner", ProximitySpawner::new, spawner),
    kobblinBurrow = register("kobblin_burrow", KobblinBurrow::new, PdirtDirt),
    encagedCaptainMerik = registerEncaged("captain_merik", spawner, EntityRegistry.CAPTAIN_MERIK, TagRegistry.Items.SUMMONING_CAPTAIN_MERIK),
    encagedDatticon = registerEncaged("datticon", spawner, EntityRegistry.DATTICON, TagRegistry.Items.SUMMONING_DATTICON),
    encagedKazari = registerEncaged("kazari", spawner, EntityRegistry.KAZARI, TagRegistry.Items.SUMMONING_KAZARI),
    encagedLeorna = registerEncaged("leorna", spawner, EntityRegistry.LEORNA, TagRegistry.Items.SUMMONING_LEORNA),
    encagedLordVatticus = registerEncaged("lord_vatticus", spawner, EntityRegistry.LORD_VATTICUS, TagRegistry.Items.SUMMONING_LORD_VATTICUS),
    encagedWarGeneral = registerEncaged("war_general", spawner, EntityRegistry.WAR_GENERAL, TagRegistry.Items.SUMMONING_WAR_GENERAL),
    encagedZelus = registerEncaged("zelus", spawner, EntityRegistry.ZELUS, TagRegistry.Items.SUMMONING_ZELUS),
    calcifiedBrain = register("calcified_brain", p -> new MobCage(p, EntityRegistry.KITRA, TagRegistry.Items.SUMMONING_KITRA, new BlockPos(0, 5, 0)), PboneBlock),
    sunstormSpawner = registerBossSpawner("sunstorm", PyellowSpawner, EntityRegistry.SUNSTORM, TagRegistry.Items.SUMMONING_SUNSTORM),
    termasectSpawner = registerFlyingBossSpawner("termasect", PlightBlueSpawner, EntityRegistry.TERMASECT, TagRegistry.Items.SUMMONING_TERMASECT),
    eternalArcherSpawner = registerBossSpawner("eternal_archer", PmagentaSpawner, EntityRegistry.ETERNAL_ARCHER, TagRegistry.Items.SUMMONING_ETERNAL_ARCHER),
    experiencedCoriSpawner = registerFlyingBossSpawner("experienced_cori", PlightGraySpawner, EntityRegistry.EXPERIENCED_CORI, TagRegistry.Items.SUMMONING_EXPERIENCED_CORI),
    dramixAltar = registerAltar("dramix", ArcanaAltar::new, PcrimsonHyphaeAltar),
    parasectaAltar = registerAltar("parasecta", ArcanaAltar::new, PterraBrownAltar),
    karosAltar = registerAltar("karos", KarosAltar::new, PwarpedWartUnbreakable),
    lunicAltar = registerAltar("lunic", LunicAltar::new, PblueUnbreakable),
    quadroticAltar = registerAltar("quadrotic", QuadroticAltar::new, PblueUnbreakable),
    raglokAltar = registerAltar("raglok", RaglokAltar::new, PredUnbreakable),
    wreckAltar = registerAltar("wreck", WreckAltar::new, PredUnbreakable),
    hiveEgg = register("hive_egg", HiveEgg::new, PhiveEgg),
    ayeracoSpawn = registerItemless("ayeraco_spawn", AyeracoSpawn::new, shapedUnbreakable);

    //Ayeraco Beam
    public static final DeferredBlock<Block>
    ayeracoBeamRed = registerBeam("red", BossEvent.BossBarColor.RED),
    ayeracoBeamYellow = registerBeam("yellow", BossEvent.BossBarColor.YELLOW),
    ayeracoBeamGreen = registerBeam("green", BossEvent.BossBarColor.GREEN),
    ayeracoBeamBlue = registerBeam("blue", BossEvent.BossBarColor.BLUE),
    ayeracoBeamPurple = registerBeam("purple", BossEvent.BossBarColor.PURPLE),
    ayeracoBeamPink = registerBeam("pink", BossEvent.BossBarColor.PINK);

    //Workstations
    public static final DeferredBlock<Block>
    altarOfCorruption = register("altar_of_corruption", AltarOfCorruption::new, PaltarOfCorruption),
    arcaniumExtractor = register("arcanium_extractor", ArcaniumExtractor::new, ParcaniumExtractor),
    infusionTable = register("infusion_table", InfusionTable::new, PfireUnbreakable);

    //Furnaces
    public static final DeferredBlock<Block>
    coalstoneFurnace = registerInfiniFurnace("coalstone", PcoalstoneFurnace, BlockEntityRegistry.COALSTONE_FURNACE::get),
    moltenFurnace = registerInfiniFurnace("molten", PmoltenFurnace, BlockEntityRegistry.MOLTEN_FURNACE::get),
    greenlightFurnace = registerFurnace("greenlight", PgreenlightFurnace, BlockEntityRegistry.GREENLIGHT_FURNACE::get),
    oceanfireFurnace = registerInfiniFurnace("oceanfire", PoceanfireFurnace, BlockEntityRegistry.OCEANFIRE_FURNACE::get),
    moonlightFurnace = registerFurnace("moonlight", PmoonlightFurnace, BlockEntityRegistry.MOONLIGHT_FURNACE::get),
    whitefireFurnace = registerInfiniFurnace("whitefire", PwhitefireFurnace, BlockEntityRegistry.WHITEFIRE_FURNACE::get),
    demonFurnace = register("demon_furnace", DemonFurnace::new, PdemonFurnace);

    //Chests
    public static final DeferredBlock<Block>
    boneChest = register("bone_chest", BoneChest::new, PboneChest),
    frostedChest = register("frosted_chest", FrostedChest::new, PfrostedChest),
    presentBox = register("present_box", PresentBox::new, PpresentBox),
    edenChest = register("eden_chest", EdenChest::new, PedenChest),
    crate = register("crate", Crate::new, Pcrate),
    oxcrate = register("oxcrate", Oxcrate::new, Pcrate),
    inserter = register("inserter", Inserter::new, Pinserter),
    distributor = register("distributor", Distributor::new, Pinserter);

    //Utility Blocks
    public static final DeferredBlock<Block>
    nightmareBed = registerItemless("nightmare_bed", NightmareBed::new, PnightmareBed),
    hellfireSponge = register("hellfire_sponge", HellfireSponge::new, PhellfireSponge),
    coldHellfireSponge = register("cold_hellfire_sponge", ColdHellfireSponge::new, PhellfireSponge),
    frostedAllure = register("frosted_allure", FrostedAllure::new, PfrostedAllure),
    soulTrap = register("soul_trap", SoulTrap::new, PsoulTrap),
    acceleron = register("acceleron", Acceleron::new, Pacceleron),
    gravestone = register("gravestone", Gravestone::new, Pgravestone),
    robbinHut = register("robbin_hut", RobbinHut::new, PshapedPlank),
    robbinNest = register("robbin_nest", RobbinNest::new, ProbbinNest),
    elevantium = register("elevantium", Elevantium::new, Pelevantium),
    booster = register("booster", RedstoneBooster::new, Prepeater),
    limiter = register("limiter", RedstoneLimiter::new, Prepeater),
    oxdriteRail = register("oxdrite_rail", OxdriteRail::new, Prail),
    oxdriteLamp = register("oxdrite_lamp", OxdriteLamp::new, PoxdriteLamp),
    capacitor = register("capacitor", Capacitor::new, PoxdriteBlock),
    miner = register("miner", MinerBlock::new, lightBlueMetal),
    softMiner = register("soft_miner", SoftMinerBlock::new, PsoftMiner),
    placer = register("placer", PlacerBlock::new, ParlemiteBlock);

    //Traps
    public static final DeferredBlock<Block>
    spikeBlock = register("spike_block", p -> new SpikeBlock(p, false), PmetalMetal),
    hotSpikeBlock = register("hot_spike_block", p -> new SpikeBlock(p, true), PtorriditeBlock),
    heatTrap = register("heat_trap", HeatTrap::new, PblueUnbreakable),
    karosHeatTile = register("karos_heat_tile", KarosHeatTile::new, PemeraldUnbreakable),
    karosDispenser = register("karos_dispenser", KarosDispenser::new, PplantUnbreakable);

    //Acid
    public static final DeferredBlock<Block>
    bacterialAcid = register("bacterial_acid", Acid::new, Pacid),
    lunicAcid = register("lunic_acid", Acid::new, Pacid);

    //Fire
    public static final DeferredBlock<Block>
    bonfire = register("bonfire", Bonfire::new, PshapedPlank),
    icyFire = register("icy_fire", IcyFire::new, PicyFire),
    hellfire = register("hellfire", Fire::new, Pfire),
    divineFlame = register("divine_flame", DivineFlame::new, Pfire),
    wildFlame = register("wild_flame", WildFlame::new, Pfire),
    enchantedFlame = register("enchanted_flame", EnchantedFlame::new, Pfire),
    skyFire = register("sky_fire", SkyFire::new, Pfire),
    mortumEmbers = register("mortum_embers", MortumEmbers::new, Pfire);

    //Portals
    public static final DeferredBlock<Block>
    gateway = register("gateway", Gateway::new, Pgateway),
    arcanaPortal = register("arcana_portal", ArcanaPortal::new, ParcanaPortal),
    iceikaPortal = registerPortal("iceika", Pportal, LevelRegistry.ICEIKA, Level.OVERWORLD, () -> Blocks.SNOW_BLOCK, "frost"),
    divinePortal = registerPortal("divine", Pportal, Level.OVERWORLD, Level.OVERWORLD, divineRock, "eden_portal"),
    edenPortal = registerPortal("eden", Pportal, LevelRegistry.EDEN, Level.OVERWORLD, edenBlock, "eden_portal"),
    wildwoodPortal = registerPortal("wildwood", Pportal, LevelRegistry.WILDWOOD, LevelRegistry.EDEN, wildwoodBlock, "wildwood_portal"),
    apalachiaPortal = registerPortal("apalachia", Pportal, LevelRegistry.APALACHIA, LevelRegistry.WILDWOOD, apalachiaBlock, "apalachia_portal"),
    skythernPortal = registerPortal("skythern", Pportal, LevelRegistry.SKYTHERN, LevelRegistry.APALACHIA, skythernBlock, "skythern_portal"),
    mortumPortal = registerPortal("mortum", Pportal, LevelRegistry.MORTUM, LevelRegistry.SKYTHERN, mortumBlock, "mortum_portal"),
    vetheaPortal = register("vethea_portal", VetheaPortal::new, Pportal);

    //Rifts
    public static final DeferredBlock<Block>
    overworldRift = registerRift("overworld", Prift, Level.OVERWORLD, STABLE_RIFT_OVERWORLD, RIFT_RESONATING_OVERWORLD, TagRegistry.Items.RIFT_REPLENISHING_OVERWORLD, (byte)6),
    edenRift = registerRift("eden", Prift, LevelRegistry.EDEN, STABLE_RIFT_EDEN, RIFT_RESONATING_EDEN, TagRegistry.Items.RIFT_REPLENISHING_EDEN, (byte)1),
    wildwoodRift = registerRift("wildwood", Prift, LevelRegistry.WILDWOOD, STABLE_RIFT_WILDWOOD, RIFT_RESONATING_WILDWOOD, TagRegistry.Items.RIFT_REPLENISHING_WILDWOOD, (byte)2),
    apalachiaRift = registerRift("apalachia", Prift, LevelRegistry.APALACHIA, STABLE_RIFT_APALACHIA, RIFT_RESONATING_APALACHIA, TagRegistry.Items.RIFT_REPLENISHING_APALACHIA, (byte)3),
    skythernRift = registerRift("skythern", Prift, LevelRegistry.SKYTHERN, STABLE_RIFT_SKYTHERN, RIFT_RESONATING_SKYTHERN, TagRegistry.Items.RIFT_REPLENISHING_SKYTHERN, (byte)4),
    mortumRift = registerRift("mortum", Prift, LevelRegistry.MORTUM, STABLE_RIFT_MORTUM, RIFT_RESONATING_MORTUM, TagRegistry.Items.RIFT_REPLENISHING_MORTUM, (byte)5);

    //Air
    public static final DeferredBlock<Block>
    dungeonAir = register("dungeon_air", DungeonAir::new, air),
    terranGhostBlock = registerItemless("terran_ghost_block", TerranGhostBlock::new, air);

    //Creative Mode Blocks
    public static final DeferredBlock<Block>
    randomItemDropper = register("random_item_dropper", RandomItemDropper::new, furnace);

    //REGISTER SETS
    private static List<DeferredBlock<Block>> registerGrass(String name, PropertyOverride properties) {return registerPotted(name, ModGrass::new, properties);}
    private static List<DeferredBlock<Block>> registerDryGrass(String name, PropertyOverride properties) {return registerPotted(name, p -> new ModGrass(p, true), properties);}
    private static List<DeferredBlock<Block>> registerFlower(String name, PropertyOverride properties, Holder<MobEffect> effect, float durationInSeconds) {return registerPotted(name, p -> new Flower(effect, durationInSeconds, p), properties);}
    private static List<DeferredBlock<Block>> registerPotted(String name, BlockFactory block, PropertyOverride properties) {
        DeferredBlock<Block> b = register(name, block, properties),
        pot = registerItemless(name + "_pot", p -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, b, p), PflowerPot);
        return List.of(b, pot);
    }
    private static List<DeferredBlock<Block>> registerWoolSet(String baseName, String woolSignifier, PropertyOverride properties, DyeColor color) {
        DeferredBlock<Block>
            wool = register(baseName + woolSignifier, properties),
            stairs = registerStair(baseName + "_stairs", properties, wool),
            slab = registerSlab(baseName + "_slab", properties),
            carpet = register(baseName + "_carpet", p -> new WoolCarpetBlock(color, p), properties);
        return List.of(wool, stairs, slab, carpet);
    }
    private static List<DeferredBlock<Block>> registerTorchSet(String baseName, PropertyOverride properties, Supplier<SimpleParticleType> particle) {return registerTorchSet(baseName, p -> new TorchBlock(particle.get(), p), p -> new WallTorchBlock(particle.get(), p), properties);}
    private static List<DeferredBlock<Block>> registerTorchSet(String baseName, BlockFactory torch, BlockFactory wallTorch, PropertyOverride properties) {
        DeferredBlock<Block>
            t = registerItemless(baseName + "_torch", torch, properties),
            wt = registerItemless(baseName + "_wall_torch", wallTorch, properties);
        return List.of(t, wt);
    }
    private static List<DeferredBlock<Block>> registerFungusSet(String baseName, MapColor shroomColor, MapColor bulbColor, MapColor stemColor, ResourceKey<Feature> bigShroom) {
        List<DeferredBlock<Block>> sapling = registerPotted(baseName, p -> new MushroomBlock(bigShroom, p), mushroom.map(shroomColor));
        DeferredBlock<Block>
            bulb = register(baseName + "_bulb", HalfTransparentBlock::new, PropertyOverride.bulb.map(bulbColor)),
            stem = register(baseName + "_stem", RotatedPillarBlock::new, log.map(stemColor));
        return List.of(sapling.getFirst(), bulb, stem, sapling.getLast());
    }
    private static List<DeferredBlock<Block>> registerDreamTreeSet(String baseName, MapColor leavesColor, MapColor logColor, MapColor strippedColor) {
        DeferredBlock<Block>
            lea = register(baseName + "_leaves", p -> new LeavesBlock(AmbientLeavesBlockSoundPlayer.noAmbientSound(), p), leaves.map(leavesColor)),
            log = register(baseName + "_log", VetheaLog::new, dreamLog.then(p -> p.mapColor((state) -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? strippedColor : logColor))),
            woo = register(baseName, VetheaLog::new, dreamLog.map(logColor)),
            strippedLog = register("stripped_" + baseName + "_log", VetheaLog::new, dreamLog.map(strippedColor)),
            strippedWood = register("stripped_" + baseName, VetheaLog::new, dreamLog.map(strippedColor));
        return List.of(lea, log, woo, strippedLog, strippedWood);
    }
    private static List<DeferredBlock<Block>> registerTreeSet(String baseName, MapColor leavesColor, MapColor logColor, MapColor plankColor, WoodType type, ResourceKey<Feature> tree) {return registerTreeSet(baseName, leavesColor, logColor, plankColor, type, tree, p -> new LeavesBlock(AmbientLeavesBlockSoundPlayer.noAmbientSound(), p));}
    private static List<DeferredBlock<Block>> registerTreeSet(String baseName, MapColor leavesColor, MapColor logColor, MapColor plankColor, WoodType type, ResourceKey<Feature> tree, BlockFactory leaf) {
        List<DeferredBlock<Block>> l = new ArrayList<>(20);
        l.addAll(registerPotted(baseName + "_sapling", p -> new SaplingBlock(new TreeGrower("divine", WeightedList.of(tree), WeightedList.of(), WeightedList.of(), null), p), growingPlant.map(leavesColor)));
        l.add(register(baseName + "_leaves", leaf, leaves.map(leavesColor)));
        l.addAll(registerWoodSet(baseName, logColor, plankColor, type));
        return l;
    }
    private static List<DeferredBlock<Block>> registerWoodSet(String baseName, MapColor logColor, MapColor plankColor, WoodType type) {
        PropertyOverride plank = PropertyOverride.materialPlank.map(plankColor), stripped = log.map(plankColor);
        DeferredBlock<Block>
            log = register(baseName + "_log", RotatedPillarBlock::new, PropertyOverride.log.then(p -> p.mapColor((state) -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? plankColor : logColor))),
            wood = register(baseName + "_wood", RotatedPillarBlock::new, PropertyOverride.log.map(logColor)),
            strippedLog = register("stripped_" + baseName + "_log", RotatedPillarBlock::new, stripped),
            strippedWood = register("stripped_" + baseName + "_wood", RotatedPillarBlock::new, stripped),
            planks = register(baseName + "_planks", plank),
            stairs = registerStair(baseName + "_stairs", plank, planks),
            slab = registerSlab(baseName + "_slab", plank),
            fence = register(baseName + "_fence", FenceBlock::new, plank),
            gate = register(baseName + "_fence_gate", p -> new FenceGateBlock(type, p), plank),
            ladder = register(baseName + "_ladder", LadderBlock::new, PropertyOverride.ladder),
            door = register(baseName + "_door", p -> new DoorBlock(BlockSetType.CHERRY, p), plank),
            trapdoor = register(baseName + "_trapdoor", p -> new TrapDoorBlock(BlockSetType.CHERRY, p), plank),
            pressurePlate = register(baseName + "_pressure_plate", p -> new PressurePlateBlock(BlockSetType.CHERRY, p), plank),
            button = register(baseName + "_button", p -> new ButtonBlock(BlockSetType.CHERRY, 30, p), plank),
            sign = registerItemless(baseName + "_sign", p -> new StandingSignBlock(type, p), plank),
            wallSign = registerItemless(baseName + "_wall_sign", p -> new WallSignBlock(type, p), plank),
            hangingSign = registerItemless(baseName + "_hanging_sign", p -> new CeilingHangingSignBlock(type, p), plank),
            wallHangingSign = registerItemless(baseName + "_wall_hanging_sign", p -> new WallHangingSignBlock(type, p), plank);
        //TODO: Woodcutter = registerBlockCorailWoodcutter(baseName + "_woodcutter", ModList.get().isLoaded("corail_woodcutter") ? WoodcutterLoader.create(planks, type) : null)
        return List.of(log, wood, strippedLog, strippedWood, planks, stairs, slab, fence, gate, ladder, door, trapdoor, pressurePlate, button, sign, wallSign, hangingSign, wallHangingSign);
    }
    private static List<DeferredBlock<Block>> registerSoils(String baseName, PropertyOverride dirtProperties, PropertyOverride grassProperties, Supplier<Block> plant, boolean requiresLightToGrow) {return registerSoils(baseName + "_dirt", baseName + "_grass", Block::new, (d, g, b) -> p -> new ModGrassBlock(p, d, g, b), dirtProperties, grassProperties, plant, requiresLightToGrow);}
    private static List<DeferredBlock<Block>> registerSoils(String dirtName, String grassName, BlockFactory dirtF, GrassFactory grassF, PropertyOverride dirtProperties, PropertyOverride grassProperties, Supplier<Block> plant, boolean requiresLightToGrow) {
        DeferredBlock<Block>
                dirt = register(dirtName,dirtF, dirtProperties),
                grass = register(grassName, grassF.apply(dirt, plant, requiresLightToGrow), grassProperties);
        return List.of(dirt, grass);
    }
    private static List<DeferredBlock<Block>> registerArcanaSet(String baseName, Holder<Item> key, MapColor color){
        PropertyOverride unbreakable = unbreakableBlock.map(color), breakable = rock.map(color);
        DeferredBlock<Block>
            block = register(baseName + "s", unbreakable),
            stairs = registerStair(baseName + "_stairs", unbreakable, block),
            slab = registerSlab(baseName + "_slab", unbreakable),
            wall = register(baseName + "_wall", WallBlock::new, unbreakable),
            door = registerArcanaDoor(baseName, arcanaDoor.map(color), key),
            blockBreakable = register(baseName + "s_breakable", breakable),
            stairsBreakable = registerStair(baseName + "_stairs_breakable", breakable, blockBreakable),
            slabBreakable = registerSlab(baseName + "_slab_breakable", breakable),
            wallBreakable = register(baseName + "_wall_breakable", WallBlock::new, breakable);
        return List.of(block, stairs, slab, wall, door, blockBreakable, stairsBreakable, slabBreakable, wallBreakable);
    }
    private static List<DeferredBlock<Block>> registerBreakPair(String name, PropertyOverride breakable, PropertyOverride unbreakable) {
        return List.of(register(name, unbreakable), register(name + "_breakable", breakable));
    }
    private static List<DeferredBlock<Block>> registerBrickSet(String baseName, PropertyOverride properties) {return registerStoneSet(baseName, "s", properties);}
    private static List<DeferredBlock<Block>> registerStoneTypeSet(String baseName, PropertyOverride properties) {return registerStoneSet(baseName, "", properties);}
    private static List<DeferredBlock<Block>> registerSimpleStoneSet(String baseName, PropertyOverride properties) {return registerStoneSet(baseName, "_stone", properties);}
    private static List<DeferredBlock<Block>> registerStoneSet(String baseName, String stoneSignifier, PropertyOverride properties) {return registerRockSet(baseName, stoneSignifier, properties, BlockSetType.STONE, null);}
    private static List<DeferredBlock<Block>> registerRockSet(String baseName, String stoneSignifier, PropertyOverride properties, BlockSetType type, BlockFactory baseBlock) {
        DeferredBlock<Block>
            stone = register(baseName + stoneSignifier, baseBlock == null ? Block::new : baseBlock, properties),
            stairs = register(baseName + "_stairs", p -> new StairBlock(stone.get().defaultBlockState(), p), properties),
            slab = register(baseName + "_slab", SlabBlock::new, properties),
            wall = register(baseName + "_wall", WallBlock::new, properties),
            pressure_plate = register(baseName + "_pressure_plate", p -> new PressurePlateBlock(type, p), properties),
            button = register(baseName + "_button", p -> new ButtonBlock(type, 20, p), properties);
        return List.of(stone, stairs, slab, wall, pressure_plate, button);
    }
    private static List<DeferredBlock<Block>> registerStairSlabSet(String baseName, String blockSignifier, PropertyOverride properties) {
        DeferredBlock<Block>
            block = register(baseName + blockSignifier, properties),
            stairs = register(baseName + "_stairs", p -> new StairBlock(block.get().defaultBlockState(), p), properties),
            slab = register(baseName + "_slab", SlabBlock::new, properties);
        return List.of(stairs, slab);
    }
    private static List<DeferredBlock<Block>> registerOverworldOres(String baseName) {
        return List.of(register(baseName + "_ore", PoverworldOre), register(baseName + "_ore_deepslate", PdeepslateOre));
    }
    private static List<DeferredBlock<Block>> registerMetalBlocks(String baseName, PropertyOverride raw, PropertyOverride block) {
        return List.of(register("raw_" + baseName + "_block", raw), register(baseName + "_block", block));
    }
    //SPECIALIZED REGISTER METHODS
    private static DeferredBlock<Block> registerRift(String baseName, PropertyOverride properties, ResourceKey<Level> rootDimension, TagKey<Level> stableDimension, TagKey<Block> resonanceTag, TagKey<Item> empowerTag, byte variant) {return registerItemless(baseName + "_rift", p -> new Rift(p, rootDimension, stableDimension, resonanceTag, empowerTag, variant), properties);}
    private static DeferredBlock<Block> registerPortal(String baseName, PropertyOverride properties, ResourceKey<Level> rootDimension, ResourceKey<Level> chainDimension, Supplier<Block> frameBlock, String particle) {return register(baseName + "_portal", p -> new SimplePortal(p, rootDimension, chainDimension, frameBlock.get(), Identifier.fromNamespaceAndPath(MODID, particle)), properties);}
    private static DeferredBlock<Block> registerFurnace(String baseName, PropertyOverride properties, Supplier<BlockEntityType<? extends ModFurnaceBlockEntity>> blockEntity) {return register(baseName + "_furnace", p -> new ModFurnace(p, blockEntity), properties);}
    private static DeferredBlock<Block> registerInfiniFurnace(String baseName, PropertyOverride properties, Supplier<BlockEntityType<? extends InfiniFurnaceBlockEntity>> blockEntity) {return register(baseName + "_furnace", p -> new InfiniFurnace(p, blockEntity), properties);}
    private static DeferredBlock<Block> registerBeam(String baseName, BossEvent.BossBarColor color) {return registerItemless("ayeraco_beam_" + baseName, p -> new AyeracoBeam(p, color), air);}
    private static DeferredBlock<Block> registerAltar(String baseName, BlockFactory f, PropertyOverride p) {return register(baseName + "_altar", f, p);}
    private static DeferredBlock<Block> registerFlyingBossSpawner(String baseName, PropertyOverride properties, Holder<EntityType<?>> entity, TagKey<Item> item) {return register(baseName + "_spawner", p -> new MobCage(p, entity, item, new BlockPos(0, 11, 0)), properties);}
    private static DeferredBlock<Block> registerBossSpawner(String baseName, PropertyOverride properties, Holder<EntityType<?>> entity, TagKey<Item> item) {return register(baseName + "_spawner", p -> new MobCage(p, entity, item), properties);}
    private static DeferredBlock<Block> registerEncaged(String baseName, PropertyOverride properties, Holder<EntityType<?>> entity, TagKey<Item> item) {return register("encaged_" + baseName, p -> new MobCage(p, entity, item), properties);}
    private static DeferredBlock<Block> registerStatue(String baseName, PropertyOverride properties) {return register(baseName + "_statue", p -> new Statue(p, null), properties, p -> p.fireResistant().rarity(Rarity.RARE));}
    private static DeferredBlock<Block> registerStatue(String baseName, PropertyOverride properties, Supplier<SoundEvent> sound) {return register(baseName + "_statue", p -> new Statue(p, sound), properties, p -> p.fireResistant().rarity(Rarity.RARE));}
    private static DeferredBlock<Block> registerMobPumpkin(String baseName, PropertyOverride properties, Supplier<SoundEvent> sound) {return register(baseName + "_pumpkin", p -> new MobPumpkin(p, sound), properties);}
    private static DeferredBlock<Block> registerDoubleCrop(String baseName, PropertyOverride properties, ItemLike seed) {return registerItemless(baseName + "_plant", p -> new DoubleCrop(p, seed), properties);}
    private static DeferredBlock<Block> registerArcanaDoubleCrop(String baseName, PropertyOverride properties, ItemLike seed) {return registerItemless(baseName + "_plant", p -> new ArcanaDoubleCrop(p, seed), properties);}
    private static DeferredBlock<Block> registerCrop(String baseName, PropertyOverride properties, ItemLike seed) {return registerItemless(baseName + "_plant", p -> new Crop(p, seed), properties);}
    private static DeferredBlock<Block> registerVine(String baseName, PropertyOverride properties) {return register(baseName + "_vine", VineBlock::new, properties);}
    private static DeferredBlock<Block> registerOre(String baseName, PropertyOverride properties, int minXp, int maxXp) {return register(baseName + "_ore", p -> new DropExperienceBlock(UniformInt.of(minXp, maxXp), p), properties);}
    private static DeferredBlock<Block> registerRedstoneFence(String baseName, PropertyOverride properties) {return register(baseName + "_fence", RedstoneFence::new, properties);}
    private static DeferredBlock<Block> registerBridge(String name, PropertyOverride properties) {return register(name, Bridge::new, properties);}
    private static DeferredBlock<Block> registerDoor(String baseName, PropertyOverride properties, BlockSetType type) {return register(baseName + "_door", p -> new DoorBlock(type, p), properties);}
    private static DeferredBlock<Block> registerSlab(String name, PropertyOverride properties) {return register(name, SlabBlock::new, properties);}
    private static DeferredBlock<Block> registerStair(String name, PropertyOverride properties, Holder<Block> block) {return register(name, p -> new StairBlock(block.value().defaultBlockState(), p), properties);}
    private static DeferredBlock<Block> registerArcanaDoor(String baseName, PropertyOverride properties, Holder<Item> key) {return register(baseName + "_door", p -> new ArcanaDoor(p, key), properties);}
    private static DeferredBlock<Block> registerTallFlower(String name, PropertyOverride properties) {return register(name, TallFlowerBlock::new, properties);}
    private static DeferredBlock<Block> registerLadder(String name, PropertyOverride properties) {return register(name, LadderBlock::new, properties);}
    private static DeferredBlock<Block> registerCandy(String name, PropertyOverride properties) {return register(name, CandyCane::new, properties);}
    private static DeferredBlock<Block> registerSand(String name, PropertyOverride properties, int color) {return register(name, p -> new ColoredFallingBlock(new ColorRGBA(color), p), properties);}
    private static DeferredBlock<Block> registerDreamGrass(String name, PropertyOverride properties) {return register(name, p -> new ModGrassBlock(p, dreamSoil.getFirst()), properties);}
    private static DeferredBlock<Block> registerFireResistant(String name, PropertyOverride properties) {return register(name, properties, Item.Properties::fireResistant);}
    //BASE REGISTER
    private static DeferredBlock<Block> register(String name, PropertyOverride properties) {return register(name, Block::new, properties);}
    private static DeferredBlock<Block> register(String name, BlockFactory blockFactory, PropertyOverride properties) {
        DeferredBlock<Block> block = BLOCKS.register(name, () -> blockFactory.apply(properties.apply(Properties.of()).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MODID, name)))));
        DivineRegistries.blocks.add(DivineRegistries.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name))))));
        return block;
    }
    private static DeferredBlock<Block> registerItemless(String name, BlockFactory blockFactory, PropertyOverride properties) {
        return BLOCKS.register(name, () -> blockFactory.apply(properties.apply(Properties.of()).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MODID, name)))));
    }
    private static DeferredBlock<Block> register(String name, PropertyOverride properties, ItemPropertyOverride itemProperties) {return register(name, Block::new, properties, itemProperties);}
    private static DeferredBlock<Block> register(String name, BlockFactory blockFactory, PropertyOverride properties, ItemPropertyOverride itemProperties) {return register(name, blockFactory, properties, (b, p) -> new BlockItem(b, itemProperties.apply(p)));}
    private static DeferredBlock<Block> register(String name, BlockFactory blockFactory, PropertyOverride properties, ItemFactory item) {
        DeferredBlock<Block> block = BLOCKS.register(name, () -> blockFactory.apply(properties.apply(Properties.of()).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MODID, name)))));
        DivineRegistries.blocks.add(DivineRegistries.ITEMS.register(name, () -> item.apply(block.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name))))));
        return block;
    }
    private static void addAliases(String path, DeferredBlock<Block> block) {
        Identifier loc = getIdentifier(path);
        BLOCKS.addAlias(loc, block.getId());
        DivineRegistries.ITEMS.addAlias(loc, block.getId());
    }
    private static void addVanillaAliases(String path, Block block) {
        Identifier loc = getIdentifier(path);
        Identifier defLoc = Identifier.withDefaultNamespace(path);
        BLOCKS.addAlias(loc, defLoc);
        DivineRegistries.ITEMS.addAlias(loc, defLoc);
    }
    private static Identifier getIdentifier(String path) {
        return Identifier.fromNamespaceAndPath(MODID, path);
    }
    //INTERFACES
    interface BlockFactory extends Function<Properties, Block> {}
    interface ItemPropertyOverride extends Function<Item.Properties, Item.Properties> {}
    interface ItemFactory extends BiFunction<Block, Item.Properties, Item> {}
    interface GrassFactory extends Function3<Supplier<Block>, Supplier<Block>, Boolean, BlockFactory> {}

    public static void load() {}
}