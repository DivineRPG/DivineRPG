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
import net.minecraft.references.BlockIds;
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
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.*;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.BlockPropertyOverride.*;
import static divinerpg.registries.DivineRegistries.BLOCKS;
import static divinerpg.registries.ItemPropertyOverride.*;
import static divinerpg.registries.TagRegistry.Blocks.*;
import static divinerpg.registries.TagRegistry.Dimensions.*;
import static net.minecraft.world.level.material.MapColor.*;

public class BlockRegistry {
    //BLOCK SET TYPES
    public static final BlockSetType
        ARCANA_TYPE = BlockSetType.register(new BlockSetType(MODID + ":arcana", false, false, false, BlockSetType.PressurePlateSensitivity.MOBS, SoundType.STONE, SoundEvents.IRON_DOOR_CLOSE, SoundEvents.IRON_DOOR_OPEN, SoundEvents.IRON_TRAPDOOR_CLOSE, SoundEvents.IRON_TRAPDOOR_OPEN, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF, SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON)),
        STEEL_TYPE = BlockSetType.register(new BlockSetType(MODID + ":steel", true, true, false, BlockSetType.PressurePlateSensitivity.EVERYTHING, SoundType.METAL, SoundEvents.IRON_DOOR_CLOSE, SoundEvents.IRON_DOOR_OPEN, SoundEvents.IRON_TRAPDOOR_CLOSE, SoundEvents.IRON_TRAPDOOR_OPEN, SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF, SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON));
    // BLOCKS
    // Stone
    public static final StairSlabSet asphalt = new StairSlabSet("asphalt", "", Pasphalt);
    public static final RockSet
        frozen = RockSet.simpleStone("frozen", PfrozenStone),
        cobbledFrozen = RockSet.simpleStone("cobbled_frozen", PcobbledFrozenStone),
        cobaltite = RockSet.stoneType("cobaltite", PlightBlueStone),
        coalstone = RockSet.stoneType("coalstone", PgrayStone),
        arcanite = RockSet.simpleStone("arcanite", PcyanStone),
        twilight = RockSet.simpleStone("twilight", PtwilightStone),
        scorchalt = RockSet.stoneType("scorchalt", PpinkStone),
        cobbledScorchalt = RockSet.stoneType("cobbled_scorchalt", PcobbledScorchalt),
        rayStone = RockSet.stoneType("ray_stone", PgoldenStone);
    public static final BreakPair
        ancientStone = new BreakPair("ancient_stone", PgrayStone, PgrayStoneUnbreakable),
        soulStone = new BreakPair("soul_stone", PterraBlueStone, PsoulStoneUnbreakable);
    public static final DeferredBlock<Block>
        icyStone = register("icy_stone", PhardIce),
        thermalVent = register("thermal_vent", ThermalVent::new, PthermalVent),
        divineMossStone = register("divine_moss_stone", PdivineMossStone),
        divineRock = register("divine_rock", PdivineRock),
        draughtStone = register("draught_stone", PdraughtStone),
        milkStone = register("milk_stone", PwhiteStone),
        dreamStone = register("dream_stone", PcyanStone),
        lunaStone = register("luna_stone", PlunaStone),
        hiveWall = register("hive_wall", PhiveWall),
        everstone = register("everstone", PgreenUnbreakable),
        whiteEverstone = register("white_everstone", PwhiteUnbreakable),
        darkEverstone = register("dark_everstone", PblackUnbreakable),
        exposedScorchalt = register("exposed_scorchalt", PgoldenStone),
        blackHungerstone = register("black_hungerstone", PblackUnbreakable),
        greenHungerstone = register("green_hungerstone", PgreenUnbreakable);

    // Ores
    public static final OverworldOres
        realmiteOre = new OverworldOres("realmite"),
        arlemiteOre = new OverworldOres("arlemite"),
        rupeeOre = new OverworldOres("rupee");
    public static final DeferredBlock<Block>
        bloodgemOre	= registerOre("bloodgem", PbloodgemOre, 3, 7),
        torriditeOre = register("torridite_ore", PtorriditeOre),
        anthraciteOre = registerOre("anthracite", PFrozenOre, 0, 2),
        oxdriteOre = register("oxdrite_ore", PFrozenOre),
        rawArcanium = register("raw_arcanium", PrawArcanium),
        twilightEdenOre = register("twilight_eden_ore", PtwilightOre),
        scorchaltEdenOre = register("scorchalt_eden_ore", PscorchaltEdenOre),
        wildwoodOre = register("wildwood_ore", PtwilightOre),
        apalachiaOre = register("apalachia_ore", PtwilightOre),
        skythernOre = register("skythern_ore", PtwilightOre),
        mortumOre = register("mortum_ore", PtwilightOre);

    // Compressed blocks
    public static final MetalBlocks
        realmite = new MetalBlocks("realmite", PrawRealmite, PorangeMetal),
        arlemite = new MetalBlocks("arlemite", PrawArlemite, ParlemiteBlock),
        rupee = new MetalBlocks("rupee", PrawRupee, lightBlueMetal),
        torridite = new MetalBlocks("torridite", PrawTorridite, PtorriditeBlock),
        oxdrite = new MetalBlocks("oxdrite", PrawOxdrite, PoxdriteBlock);
    public static final DeferredBlock<Block>
        shadowBlock = register("shadow_block", PblackMetal),
        bloodgemBlock = register("bloodgem_block", PbloodgemBlock),
        arcaniumBlock = register("arcanium_block", lightBlueMetal),
        edenBlock = register("eden_block", PorangeMetal),
        wildwoodBlock = register("wildwood_block", PwildwoodBlock),
        apalachiaBlock = register("apalachia_block", PmagentaMetal),
        skythernBlock = register("skythern_block", PskythernBlock),
        mortumBlock = register("mortum_block", PmortumBlock);

    // Light crystals
    public static final DeferredBlock<Block>
        blueStone = register("blue_stone", PblueStone),
        firelight = register("firelight", Pfirelight),
        fireCrystal = register("fire_crystal", PfireCrystal);

    // Plants & fungi
    public static final PotPlant
        brittleGrass = new PotPlant("brittle_grass", BrittleGrass::new, PbrittleGrass), // TODO: grass and brush shouldn't really have pot variants
        crimpetal = PotPlant.flower("crimpetal", PmagentaFlower, MobEffects.FIRE_RESISTANCE, 4),
        roofbell = PotPlant.flower("roofbell", Proofbell, MobEffects.POISON, 11),
        winterbloom = PotPlant.flower("winterbloom", Pwinterbloom, MobEffects.LEVITATION, 8),
        wispLeaf = PotPlant.flower("wisp_leaf", Pwispleaf, MobEffects.DOLPHINS_GRACE, 7),
        arcanaBrush = PotPlant.dryGrass("arcana_brush", PiceGrass),
        arcanaBush = PotPlant.dryGrass("arcana_bush", PterraBlueGrass),
        gemOfTheDunes = new PotPlant("gem_of_the_dunes", p -> new Flower(MobEffects.RESISTANCE, 5, true, p), PmagentaFlower, EPIC),
        edenBrush = PotPlant.grass("eden_brush", PedenBrush),
        sunBlossom = PotPlant.flower("sun_blossom", plantFlower, MobEffects.FIRE_RESISTANCE, 6),
        sunbloom = PotPlant.flower("sunbloom", PterraYellowFlower, MobEffects.GLOWING, 6),
        lushroom = new PotPlant("lushroom", Lushroom::new, PterraOrangeFlower),
        moonlightFern = PotPlant.grass("moonlight_fern", PiceGrass),
        moonBud = PotPlant.flower("moon_bud", PquartzFlower, MobEffects.WATER_BREATHING, 4),
        apalachiaTallgrass = PotPlant.grass("apalachia_tallgrass", PterraBlueGrass),
        duskBloom = PotPlant.flower("dusk_bloom", PterraBlueFlower, MobEffects.BLINDNESS, 11),
        skythernBrush = PotPlant.grass("skythern_brush", PskythernBrush),
        dustLily = PotPlant.flower("dust_lily", PwoolFlower, MobEffects.INVISIBILITY, 5),
        mortumBrush = PotPlant.grass("mortum_brush", PmortumBrush),
        eyePlant = PotPlant.flower("eye_plant", PgrayFlower, MobEffects.NIGHT_VISION, 6),
        shineGrass = PotPlant.flower("shine_grass", PcyanFlower, MobEffects.GLOWING, 6),
        cracklespike = PotPlant.flower("cracklespike", PcyanFlower, MobEffects.NAUSEA, 7),
        fernite = PotPlant.flower("fernite", PcyanFlower, MobEffects.WEAKNESS, 7),
        dreamglow = PotPlant.flower("dreamglow", PcyanFlower, MobEffects.NIGHT_VISION, 5),
        bulbatobe = PotPlant.flower("bulbatobe", PcyanFlower, MobEffects.POISON, 11),
        shimmer = PotPlant.flower("shimmer", PcyanFlower, MobEffects.BLINDNESS, 11),
        yellowDulah = PotPlant.flower("yellow_dulah", PcyanFlower, MobEffects.JUMP_BOOST, 5),
        greenDulah = PotPlant.flower("green_dulah", PcyanFlower, MobEffects.MINING_FATIGUE, 11),
        greenGemtop = PotPlant.flower("green_gemtop", PcyanFlower, MobEffects.SLOW_FALLING, 5),
        purpleGemtop = PotPlant.flower("purple_gemtop", PcyanFlower, MobEffects.HASTE, 6);
    public static final CaveVines
        winterberryVines = new CaveVines("winterberry", WinterberryVinesBody::new, WinterberryVinesHead::new, PwinterberryVinesBody, PwinterberryVinesHead),
        arcaniteVines = new CaveVines("arcanite", ArcaniteVinesBody::new, ArcaniteVinesHead::new, ParcaniteVines, ParcaniteVines);
    public static final DeferredBlock<Block>
        winterberryBush = register("winterberry_bush", WinterberryBush::new, PwinterberryBush),
        snowyMoss = register("snowy_moss", SnowyMoss::new, PsnowyMoss),
        globebrush = registerTallFlower("globebrush", Pglobebrush), // TODO: tall flowers miss pot variants
        thermoliage = registerTallFlower("thermoliage", Pthermoliage),
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
    // Crops
        tomatoPlant = registerCrop("tomato", crop),
        whiteMushroomPlant = registerCrop("white_mushroom", crop),
        aquamarinePlant = registerCrop("aquamarine", crop),
        eucalyptusPlant = registerCrop("eucalyptus", "_root", crop),
        firestockPlant = registerArcanaDoubleCrop("firestock", crop),
        hitchakPlant = registerCrop("hitchak", crop),
        lamonaPlant = registerCrop("lamona", crop),
        marsinePlant = registerCrop("marsine", crop),
        pinflyPlant = registerArcanaDoubleCrop("pinfly", crop),
        veiloPlant = registerCrop("veilo", crop),
        moonbulbPlant = registerDoubleCrop("moonbulb", PcropLight4),
        purpleGlowbonePlant = registerDoubleCrop("purple_glowbone", PcropLight6),
        pinkGlowbonePlant = registerDoubleCrop("pink_glowbone", PcropLight6),
        skyPlant = registerCrop("sky", "_plant", crop);

    // Soil
    public static final Soil
        frozenSoil = new Soil("frozen", PfrozenDirt, PfrozenGrass, null, true),
        arcaniteSoil = new Soil("arcanite", PblueDirt, ParcaniteGrass, null, true),
        scorchsoil = new Soil("scorchdirt", "scorchgrass", Scorchdirt::new, (d, g, b) -> p -> new Scorchgrass(p, d, g, b), Pscorchdirt, PyellowGrass, edenBrush.plant, true),
        raySoil = new Soil("ray", PrayDirt, PyellowGrass, edenBrush.plant, true),
        wildwoodSoil = new Soil("wildwood", PwildwoodDirt, PwildwoodGrass, moonlightFern.plant, true),
        apalachiaSoil = new Soil("apalachia", PblueDirt, PapalachiaGrass, apalachiaTallgrass.plant, true),
        skythernSoil = new Soil("skythern", PskythernDirt, PskythernGrass, skythernBrush.plant, true),
        mortumSoil = new Soil("mortum", PmortumDirt, PmortumGrass, mortumBrush.plant, false),
        dreamSoil = new Soil("dream", PdreamDirt, PdreamGrass, null, false);
    public static final BreakPair
        soulSludge = new BreakPair("soul_sludge", PsoulSludge, PsoulSludgeUnbreakable);
    public static final DeferredBlock<Block>
        arcaniteSand = registerSand("arcanite_sand", ParcaniteSand, 7911916),
        arcanicSand = registerSand("arcanic_sand", ParcanicSand, 4027550),
        arcaniumRichSand = registerSand("arcanium_rich_sand", ParcaniumRichSand, 1130855),
        frozenGravel = register("frozen_gravel", FrozenGravel::new, PfrozenGravel),
        gelidite = register("gelidite", Pgelidite),
    //TODO: rakedFrozenGravel = ModList.get().isLoaded("supplementaries") && SupplementariesLoader.rakedGravelEnabled() ? register("raked_frozen_gravel", RakedFrozenGravel::new, gravel) : null,
        flameGrass = registerDreamGrass("flame_grass", PflameGrass),
        evergrass = registerDreamGrass("evergrass", PeverGrass),
        scorchedGrass = register("scorched_grass", p -> new ModGrassBlock(p, dreamStone, false), PscorchedGrass);

    // Ice
    public static final DeferredBlock<Block>
        glaciline = register("glaciline", Pglaciline),
        icicle = register("icicle", p -> new Icicle(Blocks.PACKED_ICE.defaultBlockState(), p), Picicle);

    // Moss blocks
    public static final DeferredBlock<Block>
        brittleMoss = register("brittle_moss", BrittleMoss::new, PbrittleMoss),
        arcaniteMoss = register("arcanite_moss", MossBlock::new, ParcaniteMoss);

    // Portal frames
    public static final DeferredBlock<Block>
        arcanaPortalFrame = register("arcana_portal_frame", ArcanaPortalFrame::new, ParcanaPortalFrame);

    // Crystals & budding blocks
    public static final DeferredBlock<Block>
        olivineBlock = register("olivine_block", AmethystBlock::new, PolivineBlock),
        buddingOlivine = register("budding_olivine", BuddingOlivine::new, PbuddingOlivine),
        olivineCluster = register("olivine_cluster", p -> new AmethystClusterBlock(7, 3, p), PolivineCluster),
        buddingDravite = register("budding_dravite", PbuddingDravite);

    // Wood
    public static final Tree
        divine = new Tree("divine", GOLD, TERRACOTTA_LIGHT_GREEN, TERRACOTTA_LIGHT_GREEN, BlockSetType.CHERRY, ConfiguredFeatureKeys.DIVINE_TREE),
        shiverspine = new Tree("shiverspine", WOOL, COLOR_LIGHT_GRAY, GLOW_LICHEN, BlockSetType.PALE_OAK, ConfiguredFeatureKeys.SHIVERSPINE_TREE),
        auroraoak = new Tree("auroraoak", COLOR_PURPLE, COLOR_BROWN, ICE, BlockSetType.OAK, ConfiguredFeatureKeys.AURORAOAK_TREE),
        cozybark = new Tree("cozybark", CRIMSON_STEM, TERRACOTTA_PURPLE, TERRACOTTA_PURPLE, BlockSetType.DARK_OAK, ConfiguredFeatureKeys.COZYBARK_TREE, CozybarkLeaves::new),
        streamleaf = new Tree("streamleaf", GLOW_LICHEN, TERRACOTTA_BROWN, ICE, BlockSetType.WARPED, ConfiguredFeatureKeys.STREAMLEAF_TREE);
    public static final Wood
        eucalyptus = new Wood("eucalyptus", COLOR_LIGHT_GRAY, TERRACOTTA_WHITE, BlockSetType.OAK);
    public static final Tree
        eden = new Tree("eden", GOLD, COLOR_BROWN, SAND, BlockSetType.OAK, ConfiguredFeatureKeys.EDEN_TREE),
        crimseeker = new Tree("crimseeker", CRIMSON_STEM, CRIMSON_STEM, COLOR_GREEN, BlockSetType.CHERRY, null, Block::new),//TODO: Tree feature
        wildwood = new Tree("wildwood", COLOR_LIGHT_BLUE, COLOR_BLUE, COLOR_LIGHT_BLUE, BlockSetType.OAK, ConfiguredFeatureKeys.WILDWOOD_TREE),
        apalachia = new Tree("apalachia", COLOR_MAGENTA, WARPED_HYPHAE, COLOR_MAGENTA, BlockSetType.WARPED, ConfiguredFeatureKeys.APALACHIA_TREE),
        skythern = new Tree("skythern", COLOR_LIGHT_GRAY, COLOR_LIGHT_GRAY, WOOL, BlockSetType.WARPED, ConfiguredFeatureKeys.SKYTHERN_TREE),
        mortum = new Tree("mortum", COLOR_BLACK, TERRACOTTA_PINK, COLOR_GRAY, BlockSetType.DARK_OAK, ConfiguredFeatureKeys.MORTUM_TREE);
    public static final DreamTree
        firewood = new DreamTree("firewood", CRIMSON_NYLIUM, COLOR_RED, TERRACOTTA_ORANGE),
        dreamwood = new DreamTree("dreamwood", COLOR_CYAN, COLOR_CYAN, COLOR_LIGHT_BLUE),
        hyrewood = new DreamTree("hyrewood", COLOR_BLUE, COLOR_BLUE, COLOR_BLUE),
        mintwood = new DreamTree("mintwood", WARPED_WART_BLOCK, WARPED_WART_BLOCK, DIAMOND);
    public static final DeferredBlock<Block>
        plankDesign = register("plank_design", Pdesign),
        stairDesign = registerStair("stair_design", Pdesign, plankDesign),
        slabDesign = registerSlab("slab_design", Pdesign);
    //TODO: woodcutterDesign = registerBlockCorailWoodcutter("woodcutter_design", ModList.get().isLoaded("corail_woodcutter") ? WoodcutterLoader.create(plankDesign, WoodType.OAK) : null),

    // Tall fungi
    public static final TallFungus
        glowsprout = new TallFungus("glowsprout", COLOR_CYAN, DIAMOND, COLOR_LIGHT_BLUE, ConfiguredFeatureKeys.GLOWSPROUT),
        lowsprout = new TallFungus("lowsprout", COLOR_GREEN, WARPED_WART_BLOCK, GLOW_LICHEN, ConfiguredFeatureKeys.LOWSPROUT),
        slowsprout = new TallFungus("slowsprout", COLOR_MAGENTA, ICE, COLOR_PINK, ConfiguredFeatureKeys.SLOWSPROUT);

    // Wool
    public static final WoolSet
        checker = new WoolSet("checker", "", Pchecker, DyeColor.BLACK),
        rainbow = new WoolSet("rainbow", "_wool", Prainbow, DyeColor.PURPLE),
        fancy = new WoolSet("fancy", "_wool", Pfancy, DyeColor.BROWN);
    public static final StairSlabSet workshopCarpet = new StairSlabSet("workshop_carpet", "", PworkshopCarpet);

    // Obsidian
    public static final DeferredBlock<Block>
        darkstone = register("darkstone", Pdarkstone),
        bleedingObsidian = register("bleeding_obsidian", PcryingObsidian),
        shiningObsidian = register("shining_obsidian", PcryingObsidian),
        glitteringObsidian = register("glittering_obsidian", PcryingObsidian),
        seepingObsidian = register("seeping_obsidian", PcryingObsidian),
        vwoopingObsidian = register("vwooping_obsidian", PcryingObsidian),
        broodingObsidian = register("brooding_obsidian", PcryingObsidian);

    // Bricks
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

    // Minibricks
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

    // Iceika bricks & other
    public static final RockSet
        frozenBrick = RockSet.bricks("frozen_brick", PfrozenStone),
        polishedCobaltite = RockSet.stoneType("polished_cobaltite", PlightBlueStone),
        coalstoneBrick = RockSet.bricks("coalstone_brick", PcoalstoneBricks),
        polishedCoalstone = RockSet.stoneType("polished_coalstone", PgrayStone),
        cutOxdrite = new RockSet("cut_oxdrite", "", PcutOxdrite, BlockSetType.COPPER, WaterloggedTransparentBlock::new);
    public static final DeferredBlock<Block>
        snowBricks = register("snow_bricks", PsnowBricks),
        icyBricks = register("icy_bricks", Pice),
        runicIcyBricks = register("runic_icy_bricks", Pice),
        workshopBookcase = register("workshop_bookcase", PgrayCobblestone),
        chiseledCoalstoneBricks = register("chiseled_coalstone_bricks", PgrayStone);

    // Arcana bricks & other
    public static final RockSet
        arcaniteTile = RockSet.bricks("arcanite_tile", PcyanStone);
    public static final ArcanaSet
        ancientBrick = new ArcanaSet("ancient_brick", ItemRegistry.ancient_key, WARPED_NYLIUM),
        degradedBrick = new ArcanaSet("degraded_brick", ItemRegistry.degraded_key, COLOR_BLUE);
    public static final BreakPair
        ancientTile = new BreakPair("ancient_tile", PblueCobblestone, PblueUnbreakable),
        arcaniumMetal = new BreakPair("arcanium_metal", PterraBlueMetal, ParcaniumMetal),
        arcaniumPower = new BreakPair("arcanium_power", PgrayCobblestone, PgrayStoneUnbreakable);
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

    // Twilight bricks & other
    public static final RockSet
        twilightBrick = RockSet.bricks("twilight_brick", PterraBlueStone),
        polishedScorchalt = RockSet.stoneType("polished_scorchalt", PpinkStone),
        polishedRayStone = RockSet.stoneType("polished_ray_stone", PgoldenStone);
    public static final DeferredBlock<Block>
        chiseledScorchalt = register("chiseled_scorchalt", PpinkStone),
        edenBricks = register("eden_bricks", PyellowStone),
        wildwoodBricks = register("wildwood_bricks", PlightBlueStone),
        apalachiaBricks = register("apalachia_bricks", PmagentaStone),
        skythernBricks = register("skythern_bricks", PwhiteStone),
        mortumBricks = register("mortum_bricks", PgrayStone);

    // Vethea bricks & other
    public static final DeferredBlock<Block>
        hallWall = register("hall_wall", PnetherUnbreakable),
        redDreamBricks = register("red_dream_bricks", PcrimsonNyliumStone),
        lightDreamBricks = register("light_dream_bricks", PlapisStone),
        darkDreamBricks = register("dark_dream_bricks", PblueStone),
        blackKarosBricks = register("black_karos_bricks", PblackUnbreakable),
        blueKarosBricks = register("blue_karos_bricks", PblueUnbreakable),
        metalCaging = register("metal_caging", PterraGreenMetal),
        barredDoor = registerDoor("barred", PbarredDoor, STEEL_TYPE),
        helioticBeam = register("heliotic_beam", HelioticBeam::new, PwhiteUnbreakable),
        lunaBricks = register("luna_bricks", PblueCobblestone),
        cryptFloor = register("crypt_floor", PterraGreenUnbreakable),
        cryptWall = register("crypt_wall", PbrownUnbreakable),
        chamberWall = register("chamber_wall", PbrownUnbreakable),
        shiftedChamberWall = register("shifted_chamber_wall", PbrownUnbreakable),
        stackedChamberWall = register("stacked_chamber_wall", PbrownUnbreakable);

    // Steel
    public static final DeferredBlock<Block>
        steel = register("steel", BlockPropertyOverride.PterraBlueMetal),
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

    // Candy canes
    public static final DeferredBlock<Block>
        redCandyCane = registerCandy("red_candy_cane", PredCandy),
        yellowCandyCane = registerCandy("yellow_candy_cane", PyellowCandy),
        greenCandyCane = registerCandy("green_candy_cane", PemeraldCandy),
        blueCandyCane = registerCandy("blue_candy_cane", PblueCandy),
        pinkCandyCane = registerCandy("pink_candy_cane", PmagentaCandy);

    // Lights
    public static final DeferredBlock<Block>
        redFairyLights = registerLadder("red_fairy_lights", Plights),
        yellowFairyLights = registerLadder("yellow_fairy_lights", Plights),
        greenFairyLights = registerLadder("green_fairy_lights", Plights),
        blueFairyLights = registerLadder("blue_fairy_lights", Plights),
        purpleFairyLights = registerLadder("purple_fairy_lights", Plights);

    // Torches
    public static final Torch
        skeletonTorch = new Torch("skeleton", PskeletonTorch, () -> ParticleTypes.FLAME),
        aquaTorch = new Torch("aqua", AquaTorch::new, AquaWallTorch::new, Ptorch),
        arcaniumTorch = new Torch("arcanium",Ptorch, ParticleRegistry.PURPLE_FLAME),
        edenTorch = new Torch("eden", Ptorch, ParticleRegistry.GREEN_FLAME);

    // Lamps
    public static final BreakPair
        dungeonLamp = new BreakPair("dungeon_lamp", PquartzLamp, PquartzLampUnbreakable);
    public static final DeferredBlock<Block>
    // Gem lamps
        moltenLamp = register("molten_lamp", PorangeLamp),
        divineLamp = register("divine_lamp", PterraYellowLamp),
        jungleLamp = register("jungle_lamp", PlightGreenLamp),
        terranLamp = register("terran_lamp", PemeraldLamp),
        iceLamp = register("ice_lamp", PcyanLamp),
        soulfireLamp = register("soulfire_lamp", PwaterLamp),
        enderStoneLamp = register("ender_stone_lamp", PpurpleLamp),
    // Metal lamps
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
        workshopLamp = register("workshop_lamp", PlightBlueLamp),
        slimeLight = register("slime_light", RedstoneLampBlock::new, PgreenRedstoneLamp),
        dreamLamp = register("dream_lamp", DreamLamp::new, PgrayRedstoneLamp),
        cellLamp = register("cell_lamp", PlightGreenLamp),
        villageLamp = register("village_lamp", PterraRedLamp);

    // Bridges
    public static final DeferredBlock<Block>
        darkBridge = registerBridge("dark_bridge", PgrayRedstoneLamp),
        starBridge = registerBridge("star_bridge", PredRedstoneLamp);

    // Redstone fences
    public static final DeferredBlock<Block>
        redFence = registerRedstoneFence("red", PredFence),
        greenFence = registerRedstoneFence("green", PgreenFence),
        blueFence = registerRedstoneFence("blue", PblueFence);

    // Glass
    public static final DeferredBlock<Block>
        frostedGlass = register("frosted_glass", PsnowGlass),
        stainedGlass = register("stained_glass", PredGlass),
        smoothGlass = register("smooth_glass", PlightGreenGlass);

    // Mob pumpkins
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

    // Statues
    public static final DeferredBlock<Block>
        ancientEntityStatue = registerStatue("ancient_entity", statue, () -> SoundEvents.IRON_GOLEM_DEATH),
        theWatcherStatue = registerStatue("the_watcher", statue, SoundRegistry.ROAR),
        kingOfScorchersStatue = registerStatue("king_of_scorchers", statue, SoundRegistry.KING_OF_SCORCHERS),
        kitraStatue = registerStatue("kitra", statue, SoundRegistry.WHALE),
        ayeracoStatue = register("ayeraco_statue", AyeracoStatue::new, statue, PrareFireResistant.then(p -> p.component(DataComponents.DYE, DyeColor.WHITE))),
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

    // Spawners
    public static final DeferredBlock<Block>
        proximitySpawner = register("proximity_spawner", ProximitySpawner::new, spawner),
        kobblinBurrow = register("kobblin_burrow", KobblinBurrow::new, PdirtDirt),
        calcifiedBrain = register("calcified_brain", p -> new MobCage(p, EntityRegistry.KITRA, TagRegistry.Items.SUMMONING_KITRA, new BlockPos(0, 5, 0)), PboneBlock),
        ayeracoSpawn = registerItemless("ayeraco_spawn", AyeracoSpawn::new, shapedUnbreakable),
        encagedCaptainMerik = registerEncaged("captain_merik", spawner, EntityRegistry.CAPTAIN_MERIK, TagRegistry.Items.SUMMONING_CAPTAIN_MERIK),
        encagedDatticon = registerEncaged("datticon", spawner, EntityRegistry.DATTICON, TagRegistry.Items.SUMMONING_DATTICON),
        encagedKazari = registerEncaged("kazari", spawner, EntityRegistry.KAZARI, TagRegistry.Items.SUMMONING_KAZARI),
        encagedLeorna = registerEncaged("leorna", spawner, EntityRegistry.LEORNA, TagRegistry.Items.SUMMONING_LEORNA),
        encagedLordVatticus = registerEncaged("lord_vatticus", spawner, EntityRegistry.LORD_VATTICUS, TagRegistry.Items.SUMMONING_LORD_VATTICUS),
        encagedWarGeneral = registerEncaged("war_general", spawner, EntityRegistry.WAR_GENERAL, TagRegistry.Items.SUMMONING_WAR_GENERAL),
        encagedZelus = registerEncaged("zelus", spawner, EntityRegistry.ZELUS, TagRegistry.Items.SUMMONING_ZELUS),
        dramixAltar = registerAltar("dramix", ArcanaAltar::new, PcrimsonHyphaeAltar),
        parasectaAltar = registerAltar("parasecta", ArcanaAltar::new, PterraBrownAltar),
        sunstormSpawner = registerBossSpawner("sunstorm", PyellowSpawner, EntityRegistry.SUNSTORM, TagRegistry.Items.SUMMONING_SUNSTORM),
        termasectSpawner = registerFlyingBossSpawner("termasect", PlightBlueSpawner, EntityRegistry.TERMASECT, TagRegistry.Items.SUMMONING_TERMASECT),
        eternalArcherSpawner = registerBossSpawner("eternal_archer", PmagentaSpawner, EntityRegistry.ETERNAL_ARCHER, TagRegistry.Items.SUMMONING_ETERNAL_ARCHER),
        experiencedCoriSpawner = registerFlyingBossSpawner("experienced_cori", PlightGraySpawner, EntityRegistry.EXPERIENCED_CORI, TagRegistry.Items.SUMMONING_EXPERIENCED_CORI),
        hiveEgg = register("hive_egg", HiveEgg::new, PhiveEgg),
        karosAltar = registerAltar("karos", KarosAltar::new, PwarpedWartUnbreakable),
        lunicAltar = registerAltar("lunic", LunicAltar::new, PblueUnbreakable),
        quadroticAltar = registerAltar("quadrotic", QuadroticAltar::new, PblueUnbreakable),
        raglokAltar = registerAltar("raglok", RaglokAltar::new, PredUnbreakable),
        wreckAltar = registerAltar("wreck", WreckAltar::new, PredUnbreakable);

    // Ayeraco beams
    public static final DeferredBlock<Block>
        ayeracoBeamRed = registerBeam("red", BossEvent.BossBarColor.RED),
        ayeracoBeamYellow = registerBeam("yellow", BossEvent.BossBarColor.YELLOW),
        ayeracoBeamGreen = registerBeam("green", BossEvent.BossBarColor.GREEN),
        ayeracoBeamBlue = registerBeam("blue", BossEvent.BossBarColor.BLUE),
        ayeracoBeamPurple = registerBeam("purple", BossEvent.BossBarColor.PURPLE),
        ayeracoBeamPink = registerBeam("pink", BossEvent.BossBarColor.PINK);

    // Work stations
    public static final DeferredBlock<Block>
        altarOfCorruption = register("altar_of_corruption", AltarOfCorruption::new, PaltarOfCorruption, UNCOMMON),
        arcaniumExtractor = register("arcanium_extractor", ArcaniumExtractor::new, ParcaniumExtractor, RARE),
        infusionTable = register("infusion_table", InfusionTable::new, PfireUnbreakable, RARE);

    // Furnaces
    public static final DeferredBlock<Block>
        coalstoneFurnace = registerInfiniFurnace("coalstone", PcoalstoneFurnace, BlockEntityRegistry.COALSTONE_FURNACE::get),
        greenlightFurnace = registerFurnace("greenlight", PgreenlightFurnace, BlockEntityRegistry.GREENLIGHT_FURNACE::get),
        oceanfireFurnace = registerInfiniFurnace("oceanfire", PoceanfireFurnace, BlockEntityRegistry.OCEANFIRE_FURNACE::get),
        moltenFurnace = registerInfiniFurnace("molten", PmoltenFurnace, BlockEntityRegistry.MOLTEN_FURNACE::get),
        whitefireFurnace = registerInfiniFurnace("whitefire", PwhitefireFurnace, BlockEntityRegistry.WHITEFIRE_FURNACE::get),
        moonlightFurnace = registerFurnace("moonlight", PmoonlightFurnace, BlockEntityRegistry.MOONLIGHT_FURNACE::get),
        demonFurnace = register("demon_furnace", DemonFurnace::new, PdemonFurnace, EPIC);

    // Chests
    public static final DeferredBlock<Block>
        boneChest = register("bone_chest", BoneChest::new, PboneChest, COMMON),
        frostedChest = register("frosted_chest", FrostedChest::new, PfrostedChest, COMMON),
        presentBox = register("present_box", PresentBox::new, PpresentBox, COMMON),
        edenChest = register("eden_chest", EdenChest::new, PedenChest, COMMON),
        crate = register("crate", Crate::new, Pcrate),
        oxcrate = register("oxcrate", Oxcrate::new, Pcrate),
        inserter = register("inserter", Inserter::new, Pinserter),
        distributor = register("distributor", Distributor::new, Pinserter);

    // Utility blocks
    public static final DeferredBlock<Block>
        nightmareBed = register("nightmare_bed", NightmareBed::new, PnightmareBed, p -> p.stacksTo(1)),
        hellfireSponge = register("hellfire_sponge", HellfireSponge::new, PhellfireSponge),
        coldHellfireSponge = register("cold_hellfire_sponge", ColdHellfireSponge::new, PhellfireSponge),
        frostedAllure = register("frosted_allure", FrostedAllure::new, PfrostedAllure, UNCOMMON),
        soulTrap = register("soul_trap", SoulTrap::new, PsoulTrap),
        acceleron = register("acceleron", Acceleron::new, Pacceleron, UNCOMMON),
        gravestone = register("gravestone", Gravestone::new, Pgravestone, UNCOMMON),
        robbinHut = register("robbin_hut", RobbinHut::new, PshapedPlank),
        robbinNest = register("robbin_nest", RobbinNest::new, ProbbinNest),
        elevantium = register("elevantium", Elevantium::new, Pelevantium, UNCOMMON),
        booster = register("booster", RedstoneBooster::new, Prepeater),
        limiter = register("limiter", RedstoneLimiter::new, Prepeater),
        oxdriteRail = register("oxdrite_rail", OxdriteRail::new, Prail),
        oxdriteLamp = register("oxdrite_lamp", OxdriteLamp::new, PoxdriteLamp),
        capacitor = register("capacitor", Capacitor::new, PoxdriteBlock),
        miner = register("miner", MinerBlock::new, lightBlueMetal),
        softMiner = register("soft_miner", SoftMinerBlock::new, PsoftMiner),
        placer = register("placer", PlacerBlock::new, ParlemiteBlock);

    // Traps
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

    // Fire
    public static final DeferredBlock<Block>
        bonfire = register("bonfire", Bonfire::new, PshapedPlank),
        icyFire = register("icy_fire", IcyFire::new, PicyFire),
        hellfire = register("hellfire", Fire::new, Pfire),
        divineFlame = register("divine_flame", DivineFlame::new, Pfire),
        wildFlame = register("wild_flame", WildFlame::new, Pfire),
        enchantedFlame = register("enchanted_flame", EnchantedFlame::new, Pfire),
        skyFire = register("sky_fire", SkyFire::new, Pfire),
        mortumEmbers = register("mortum_embers", MortumEmbers::new, Pfire);

    // Portals
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

    // Rifts
    public static final DeferredBlock<Block>
        overworldRift = registerRift("overworld", Prift, Level.OVERWORLD, STABLE_RIFT_OVERWORLD, RIFT_RESONATING_OVERWORLD, TagRegistry.Items.RIFT_REPLENISHING_OVERWORLD, (byte)6),
        edenRift = registerRift("eden", Prift, LevelRegistry.EDEN, STABLE_RIFT_EDEN, RIFT_RESONATING_EDEN, TagRegistry.Items.RIFT_REPLENISHING_EDEN, (byte)1),
        wildwoodRift = registerRift("wildwood", Prift, LevelRegistry.WILDWOOD, STABLE_RIFT_WILDWOOD, RIFT_RESONATING_WILDWOOD, TagRegistry.Items.RIFT_REPLENISHING_WILDWOOD, (byte)2),
        apalachiaRift = registerRift("apalachia", Prift, LevelRegistry.APALACHIA, STABLE_RIFT_APALACHIA, RIFT_RESONATING_APALACHIA, TagRegistry.Items.RIFT_REPLENISHING_APALACHIA, (byte)3),
        skythernRift = registerRift("skythern", Prift, LevelRegistry.SKYTHERN, STABLE_RIFT_SKYTHERN, RIFT_RESONATING_SKYTHERN, TagRegistry.Items.RIFT_REPLENISHING_SKYTHERN, (byte)4),
        mortumRift = registerRift("mortum", Prift, LevelRegistry.MORTUM, STABLE_RIFT_MORTUM, RIFT_RESONATING_MORTUM, TagRegistry.Items.RIFT_REPLENISHING_MORTUM, (byte)5);

    // Air
    public static final DeferredBlock<Block>
        terranGhostBlock = registerItemless("terran_ghost_block", TerranGhostBlock::new, air),
        dungeonAir = register("dungeon_air", DungeonAir::new, air, EPIC);

    // Creative mode blocks
    public static final DeferredBlock<Block>
        randomItemDropper = register("random_item_dropper", RandomItemDropper::new, furnace);

    //ALIASES
    static {
        // Obsidian
        addAliases("red_vane", bleedingObsidian);
        addAliases("yellow_vane", shiningObsidian);
        addAliases("cyan_vane", glitteringObsidian);
        addAliases("blue_vane", seepingObsidian);
        addAliases("purple_vane", vwoopingObsidian);
        // Lamps
        addAliases("bluefire_lamp", soulfireLamp);
        addAliases("redstone_ore_lamp", bloodgemLamp);
        // Shiverspine
        addAliases("frozen_sapling", shiverspine.sapling);
        addAliases("frozen_log", shiverspine.log);
        addAliases("stripped_frozen_log", shiverspine.strippedLog);
        addAliases("frozen_planks", shiverspine.planks);
        addAliases("frozen_stairs", shiverspine.stairs);
        addAliases("frozen_slab", shiverspine.slab);
        addAliases("frozen_fence", shiverspine.fence);
        addAliases("frozen_fence_gate", shiverspine.gate);
        addAliases("frozen_door", shiverspine.door);
        addAliases("frozen_trapdoor", shiverspine.trapdoor);
        addAliases("brittle_leaves", shiverspine.leaves);
        // Fire
        addAliases("iceika_fire", icyFire);
        addAliases("blue_fire", BlockIds.SOUL_FIRE);
        // Steel
        addAliases("white_steel", steel);
        addAliases("teal_steel", cyanSteel);
        addAliases("bright_red_steel", magentaSteel);
        // Stained Glass
        addAliases("stained_glass2", stainedGlass);
        addAliases("stained_glass3", stainedGlass);
        addAliases("stained_glass4", stainedGlass);
        addAliases("stained_glass5", stainedGlass);
        addAliases("stained_glass6", stainedGlass);
        addAliases("stained_glass7", stainedGlass);
        addAliases("stained_glass8", stainedGlass);
        // Extra Arcana
        addAliases("arcana_hard_portal_frame", arcanaPortalFrame);
        // Eden
        addAliases("eden_dirt", raySoil.dirt);
        addAliases("eden_grass", raySoil.grass);
        addAliases("eden_ore", twilightEdenOre);
        // Vethea
        addAliases("acid_block", bacterialAcid);
        addAliases("karos_heat_tile_green", karosHeatTile);
        addAliases("karos_heat_tile_red", karosHeatTile);
        // Compat (why not)
        if(!ModList.get().isLoaded("supplementaries")) {
            addAliases("raked_frozen_gravel", frozenGravel);
            addAliases("frozen_gravel_bricks", frozenGravel);
            addAliases("suspicious_frozen_gravel_bricks", frozenGravel);
        }
    }

    // REGISTER SETS
    public record OverworldOres(DeferredBlock<Block> stone, DeferredBlock<Block> deepslate) {OverworldOres(String baseName) {this(register(baseName + "_ore", PoverworldOre), register(baseName + "_ore_deepslate", PdeepslateOre));}}
    public record MetalBlocks(DeferredBlock<Block> raw, DeferredBlock<Block> block) {MetalBlocks(String baseName, BlockPropertyOverride raw, BlockPropertyOverride block) {this(register("raw_" + baseName + "_block", raw), register(baseName + "_block", block));}}
    public record CaveVines(DeferredBlock<Block> body, DeferredBlock<Block> head) { CaveVines(String baseName, BlockConstructor body, BlockConstructor head, BlockPropertyOverride pBody, BlockPropertyOverride pHead) {this(registerItemless(baseName + "_vines_body", body, pBody), register(baseName + "_vines_head", baseName + "_vines", head, pHead));}}
    public record WoolSet(DeferredBlock<Block> wool, DeferredBlock<Block> stairs, DeferredBlock<Block> slab, DeferredBlock<Block> carpet) {
        WoolSet(String baseName, String woolSignifier, BlockPropertyOverride properties, DyeColor color) {
            StairSlabSet set = new StairSlabSet(baseName, woolSignifier, properties);
            this(set.block, set.stairs, set.slab, register(baseName + "_carpet", p -> new WoolCarpetBlock(color, p), properties));
        }
    }
    public record Torch(DeferredBlock<Block> torch, DeferredBlock<Block> wallTorch) {
        Torch(String baseName, BlockPropertyOverride properties, Supplier<SimpleParticleType> particle) {this(baseName, p -> new TorchBlock(particle.get(), p), p -> new WallTorchBlock(particle.get(), p), properties);}
        Torch(String baseName, BlockConstructor torch, BlockConstructor wallTorch, BlockPropertyOverride properties) {
            DeferredBlock<Block> wt = registerItemless(baseName + "_wall_torch", wallTorch, properties);
            this(register(baseName + "_torch", torch, properties, (b, p) -> new StandingAndWallBlockItem(b, wt.get(), Direction.DOWN, p)), wt);
        }
    }
    public record TallFungus(DeferredBlock<Block> shroom, DeferredBlock<Block> pottedShroom, DeferredBlock<Block> bulb, DeferredBlock<Block> stem) {
        TallFungus(String baseName, MapColor shroomColor, MapColor bulbColor, MapColor stemColor, ResourceKey<Feature> bigShroom) {
            PotPlant shroom = new PotPlant(baseName, p -> new MushroomBlock(bigShroom, p), mushroom.map(shroomColor));
            this(shroom.plant, shroom.pottedPlant, register(baseName + "_bulb", HalfTransparentBlock::new, BlockPropertyOverride.bulb.map(bulbColor)), register(baseName + "_stem", RotatedPillarBlock::new, log.map(stemColor)));
        }
    }
    public record DreamTree(DeferredBlock<Block> leaves, DeferredBlock<Block> log, DeferredBlock<Block> wood, DeferredBlock<Block> strippedLog, DeferredBlock<Block> strippedWood) {
        DreamTree(String baseName, MapColor leavesColor, MapColor logColor, MapColor strippedColor) {
            this(register(baseName + "_leaves", p -> new LeavesBlock(AmbientLeavesBlockSoundPlayer.noAmbientSound(), p), BlockPropertyOverride.leaves.map(leavesColor)), registerVetheaLog(baseName + "_log", dreamLog.then(p -> p.mapColor((state) -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? strippedColor : logColor))), registerVetheaLog(baseName + "_wood", dreamLog.map(logColor)), registerVetheaLog("stripped_" + baseName + "_log", dreamLog.map(strippedColor)), registerVetheaLog("stripped_" + baseName + "_wood", dreamLog.map(strippedColor)));
        }
    }
    public record Tree(DeferredBlock<Block> sapling, DeferredBlock<Block> pottedSapling, DeferredBlock<Block> leaves, DeferredBlock<Block> log, DeferredBlock<Block> wood, DeferredBlock<Block> strippedLog, DeferredBlock<Block> strippedWood, DeferredBlock<Block> planks, DeferredBlock<Block> stairs, DeferredBlock<Block> slab, DeferredBlock<Block> fence, DeferredBlock<Block> gate, DeferredBlock<Block> ladder, DeferredBlock<Block> door, DeferredBlock<Block> trapdoor, DeferredBlock<Block> pressurePlate, DeferredBlock<Block> button, DeferredBlock<Block> sign, DeferredBlock<Block> wallSign, DeferredBlock<Block> hangingSign, DeferredBlock<Block> wallHangingSign) {
        Tree(String baseName, MapColor leavesColor, MapColor logColor, MapColor plankColor, BlockSetType type, ResourceKey<Feature> tree) {this(baseName, leavesColor, logColor, plankColor, type, tree, p -> new LeavesBlock(AmbientLeavesBlockSoundPlayer.noAmbientSound(), p));}
        Tree(String baseName, MapColor leavesColor, MapColor logColor, MapColor plankColor, BlockSetType type, ResourceKey<Feature> tree, BlockConstructor leaf) {
            PotPlant sapling = new PotPlant(baseName + "_sapling", p -> new SaplingBlock(new TreeGrower(baseName, WeightedList.of(tree), WeightedList.of(), WeightedList.of(), null), p), growingPlant.map(leavesColor));
            Wood wood = new Wood(baseName, logColor, plankColor, type);
            this(sapling.plant, sapling.pottedPlant, register(baseName + "_leaves", leaf, BlockPropertyOverride.leaves.map(leavesColor)), wood.log, wood.wood, wood.strippedLog, wood.strippedWood, wood.planks, wood.stairs, wood.slab, wood.fence, wood.gate, wood.ladder, wood.door, wood.trapdoor, wood.pressurePlate, wood.button, wood.sign, wood.wallSign, wood.hangingSign, wood.wallHangingSign);
        }
    }
    public record PotPlant(DeferredBlock<Block> plant, DeferredBlock<Block> pottedPlant) {
        PotPlant(String name, BlockConstructor block, BlockPropertyOverride properties) {
            DeferredBlock<Block> b = register(name, block, properties);
            this(b, registerItemless(name + "_pot", p -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, b, p), PflowerPot));
        }
        PotPlant(String name, BlockConstructor block, BlockPropertyOverride properties, ItemPropertyOverride itemProperties) {
            DeferredBlock<Block> b = register(name, block, properties, itemProperties);
            this(b, registerItemless(name + "_pot", p -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, b, p), PflowerPot));
        }
        static PotPlant grass(String name, BlockPropertyOverride properties) {return new PotPlant(name, ModGrass::new, properties);}
        static PotPlant dryGrass(String name, BlockPropertyOverride properties) {return new PotPlant(name, p -> new ModGrass(p, true), properties);}
        static PotPlant flower(String name, BlockPropertyOverride properties, Holder<MobEffect> effect, float durationInSeconds) {return new PotPlant(name, p -> new Flower(effect, durationInSeconds, p), properties);}
    }
    public record Wood(DeferredBlock<Block> log, DeferredBlock<Block> wood, DeferredBlock<Block> strippedLog, DeferredBlock<Block> strippedWood, DeferredBlock<Block> planks, DeferredBlock<Block> stairs, DeferredBlock<Block> slab, DeferredBlock<Block> fence, DeferredBlock<Block> gate, DeferredBlock<Block> ladder, DeferredBlock<Block> door, DeferredBlock<Block> trapdoor, DeferredBlock<Block> pressurePlate, DeferredBlock<Block> button, DeferredBlock<Block> sign, DeferredBlock<Block> wallSign, DeferredBlock<Block> hangingSign, DeferredBlock<Block> wallHangingSign) {
        Wood(String baseName, MapColor logColor, MapColor plankColor, BlockSetType blockSetType) {
            WoodType type = WoodType.register(new WoodType(baseName, blockSetType));
            BlockPropertyOverride plank = BlockPropertyOverride.materialPlank.map(plankColor), stripped = BlockPropertyOverride.log.map(plankColor);
            StairSlabSet plankSet = new StairSlabSet(baseName, "_planks", plank);
            DeferredBlock<Block>
                log = register(baseName + "_log", RotatedPillarBlock::new, BlockPropertyOverride.log.then(p -> p.mapColor((state) -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? plankColor : logColor))),
                wood = register(baseName + "_wood", RotatedPillarBlock::new, BlockPropertyOverride.log.map(logColor)),
                strippedLog = register("stripped_" + baseName + "_log", RotatedPillarBlock::new, stripped),
                strippedWood = register("stripped_" + baseName + "_wood", RotatedPillarBlock::new, stripped),
                fence = register(baseName + "_fence", FenceBlock::new, plank),
                gate = register(baseName + "_fence_gate", p -> new FenceGateBlock(type, p), plank),
                ladder = register(baseName + "_ladder", LadderBlock::new, BlockPropertyOverride.ladder),
                door = register(baseName + "_door", p -> new DoorBlock(BlockSetType.CHERRY, p), plank),
                trapdoor = register(baseName + "_trapdoor", p -> new TrapDoorBlock(BlockSetType.CHERRY, p), plank),
                pressurePlate = registerPressurePlate(baseName, plank, BlockSetType.CHERRY),
                button = registerButton(baseName, plank, BlockSetType.CHERRY, 30),
                wallSign = registerItemless(baseName + "_wall_sign", p -> new WallSignBlock(type, p), plank),
                sign = register(baseName + "_sign", p -> new StandingSignBlock(type, p), plank, (b, p) -> new StandingAndWallBlockItem(b, wallSign.get(), Direction.DOWN, p.stacksTo(16))),
                wallHangingSign = registerItemless(baseName + "_wall_hanging_sign", p -> new WallHangingSignBlock(type, p), plank),
                hangingSign = register(baseName + "_hanging_sign", p -> new CeilingHangingSignBlock(type, p), plank, (b, p) -> new HangingSignItem(b, wallHangingSign.get(), p.stacksTo(16)));
            this(log, wood, strippedLog, strippedWood, plankSet.block, plankSet.stairs, plankSet.slab, fence, gate, ladder, door, trapdoor, pressurePlate, button, sign, wallSign, hangingSign, wallHangingSign);
        }
    }
    public record Soil(DeferredBlock<Block> dirt, DeferredBlock<Block> grass) {
        Soil(String baseName, BlockPropertyOverride dirtProperties, BlockPropertyOverride grassProperties, Supplier<Block> plant, boolean requiresLightToGrow) {this(baseName + "_dirt", baseName + "_grass", Block::new, (d, g, b) -> p -> new ModGrassBlock(p, d, g, b), dirtProperties, grassProperties, plant, requiresLightToGrow);}
        Soil(String dirtName, String grassName, BlockConstructor dirtF, GrassConstructor grassF, BlockPropertyOverride dirtProperties, BlockPropertyOverride grassProperties, Supplier<Block> plant, boolean requiresLightToGrow) {
            DeferredBlock<Block> dirt = register(dirtName,dirtF, dirtProperties);
            this(dirt, register(grassName, grassF.apply(dirt, plant, requiresLightToGrow), grassProperties));
        }
    }
    public record ArcanaSet(DeferredBlock<Block> block, DeferredBlock<Block> stairs, DeferredBlock<Block> slab, DeferredBlock<Block> wall, DeferredBlock<Block> door, DeferredBlock<Block> blockBreakable, DeferredBlock<Block> stairsBreakable, DeferredBlock<Block> slabBreakable, DeferredBlock<Block> wallBreakable) {
        ArcanaSet(String baseName, Holder<Item> key, MapColor color) {
            BlockPropertyOverride unbreakable = unbreakableBlock.map(color), breakable = rock.map(color);
            StairSlabSet set = new StairSlabSet(baseName, "s", unbreakable);
            DeferredBlock<Block> blockBreakable = register(baseName + "s_breakable", breakable);
            this(set.block, set.stairs, set.slab, registerWall(baseName, unbreakable), registerArcanaDoor(baseName, arcanaDoor.map(color), key), blockBreakable, registerStair(baseName + "_stairs_breakable", breakable, blockBreakable), registerSlab(baseName + "_slab_breakable", breakable), register(baseName + "_wall_breakable", WallBlock::new, breakable));
        }
    }
    public record BreakPair(DeferredBlock<Block> unbreakable, DeferredBlock<Block> breakable) {BreakPair(String name, BlockPropertyOverride breakable, BlockPropertyOverride unbreakable) {this(register(name, unbreakable), register(name + "_breakable", breakable));}}
    public record RockSet(DeferredBlock<Block> block, DeferredBlock<Block> stairs, DeferredBlock<Block> slab, DeferredBlock<Block> wall, DeferredBlock<Block> pressurePlate, DeferredBlock<Block> button) {
        RockSet(String baseName, String stoneSignifier, BlockPropertyOverride properties, BlockSetType type, BlockConstructor baseBlock) {
            StairSlabSet set = new StairSlabSet(baseName, stoneSignifier, properties);
            this(set.block, set.stairs, set.slab, registerWall(baseName, properties), registerPressurePlate(baseName, properties, type), registerButton(baseName, properties, type, 20));
        }
        static RockSet stone(String baseName, String stoneSignifier, BlockPropertyOverride properties) {return new RockSet(baseName, stoneSignifier, properties, BlockSetType.STONE, Block::new);}
        static RockSet simpleStone(String baseName, BlockPropertyOverride properties) {return stone(baseName, "_stone", properties);}
        static RockSet stoneType(String baseName, BlockPropertyOverride properties) {return stone(baseName, "", properties);}
        static RockSet bricks(String baseName, BlockPropertyOverride properties) {return stone(baseName, "s", properties);}
    }
    public record StairSlabSet(DeferredBlock<Block> block, DeferredBlock<Block> stairs, DeferredBlock<Block> slab) {
        StairSlabSet(String baseName, String blockSignifier, BlockPropertyOverride properties) {
            DeferredBlock<Block> block = register(baseName + blockSignifier, properties);
            this(block, registerStair(baseName + "_stairs", properties, block), registerSlab(baseName + "_slab", properties));
        }
    }
    //SPECIALIZED REGISTER METHODS
    private static DeferredBlock<Block> registerRift(String baseName, BlockPropertyOverride properties, ResourceKey<Level> rootDimension, TagKey<Level> stableDimension, TagKey<Block> resonanceTag, TagKey<Item> empowerTag, byte variant) {return register(baseName + "_rift", p -> new Rift(p, rootDimension, stableDimension, resonanceTag, empowerTag, variant), properties);}
    private static DeferredBlock<Block> registerPortal(String baseName, BlockPropertyOverride properties, ResourceKey<Level> rootDimension, ResourceKey<Level> chainDimension, Supplier<Block> frameBlock, String particle) {return register(baseName + "_portal", p -> new SimplePortal(p, rootDimension, chainDimension, frameBlock.get(), Identifier.fromNamespaceAndPath(MODID, particle)), properties);}
    private static DeferredBlock<Block> registerFurnace(String baseName, BlockPropertyOverride properties, Supplier<BlockEntityType<? extends ModFurnaceBlockEntity>> blockEntity) {return register(baseName + "_furnace", p -> new ModFurnace(p, blockEntity), properties, UNCOMMON);}
    private static DeferredBlock<Block> registerInfiniFurnace(String baseName, BlockPropertyOverride properties, Supplier<BlockEntityType<? extends InfiniFurnaceBlockEntity>> blockEntity) {return register(baseName + "_furnace", p -> new InfiniFurnace(p, blockEntity), properties, UNCOMMON);}
    private static DeferredBlock<Block> registerBeam(String baseName, BossEvent.BossBarColor color) {return registerItemless("ayeraco_beam_" + baseName, p -> new AyeracoBeam(p, color), air);}
    private static DeferredBlock<Block> registerAltar(String baseName, BlockConstructor f, BlockPropertyOverride p) {return register(baseName + "_altar", f, p, COMMON);}
    private static DeferredBlock<Block> registerFlyingBossSpawner(String baseName, BlockPropertyOverride properties, Holder<EntityType<?>> entity, TagKey<Item> item) {return register(baseName + "_spawner", p -> new MobCage(p, entity, item, new BlockPos(0, 11, 0)), properties);}
    private static DeferredBlock<Block> registerBossSpawner(String baseName, BlockPropertyOverride properties, Holder<EntityType<?>> entity, TagKey<Item> item) {return register(baseName + "_spawner", p -> new MobCage(p, entity, item), properties);}
    private static DeferredBlock<Block> registerEncaged(String baseName, BlockPropertyOverride properties, Holder<EntityType<?>> entity, TagKey<Item> item) {return register("encaged_" + baseName, p -> new MobCage(p, entity, item), properties);}
    private static DeferredBlock<Block> registerStatue(String baseName, BlockPropertyOverride properties) {return register(baseName + "_statue", p -> new Statue(p, null), properties, PrareFireResistant);}
    private static DeferredBlock<Block> registerStatue(String baseName, BlockPropertyOverride properties, Supplier<SoundEvent> sound) {return register(baseName + "_statue", p -> new Statue(p, sound), properties, PrareFireResistant);}
    private static DeferredBlock<Block> registerMobPumpkin(String baseName, BlockPropertyOverride properties, Supplier<SoundEvent> sound) {return register(baseName + "_pumpkin", p -> new MobPumpkin(p, sound), properties);}
    private static DeferredBlock<Block> registerDoubleCrop(String baseName, BlockPropertyOverride properties) {return registerCrop(baseName, DoubleCrop::new, properties);}
    private static DeferredBlock<Block> registerArcanaDoubleCrop(String baseName, BlockPropertyOverride properties) {return registerCrop(baseName, ArcanaDoubleCrop::new, properties);}
    private static DeferredBlock<Block> registerCrop(String baseName, BlockPropertyOverride properties) {return registerCrop(baseName, Crop::new, properties);}
    private static DeferredBlock<Block> registerCrop(String baseName, BlockConstructor block, BlockPropertyOverride properties) {return register(baseName + "_plant", baseName + "_seeds", block, properties);}
    private static DeferredBlock<Block> registerCrop(String baseName, String cropSignifier, BlockPropertyOverride properties) {return registerCrop(baseName, cropSignifier, Crop::new, properties);}
    private static DeferredBlock<Block> registerCrop(String baseName, String cropSignifier, BlockConstructor block, BlockPropertyOverride properties) {return register(baseName + "_plant", baseName + cropSignifier + "_seeds", block, properties);}
    private static DeferredBlock<Block> registerVine(String baseName, BlockPropertyOverride properties) {return register(baseName + "_vine", VineBlock::new, properties);}
    private static DeferredBlock<Block> registerOre(String baseName, BlockPropertyOverride properties, int minXp, int maxXp) {return register(baseName + "_ore", p -> new DropExperienceBlock(UniformInt.of(minXp, maxXp), p), properties);}
    private static DeferredBlock<Block> registerRedstoneFence(String baseName, BlockPropertyOverride properties) {return register(baseName + "_fence", RedstoneFence::new, properties);}
    private static DeferredBlock<Block> registerBridge(String name, BlockPropertyOverride properties) {return register(name, Bridge::new, properties);}
    private static DeferredBlock<Block> registerDoor(String baseName, BlockPropertyOverride properties, BlockSetType type) {return register(baseName + "_door", p -> new DoorBlock(type, p), properties);}
    private static DeferredBlock<Block> registerWall(String baseName, BlockPropertyOverride properties) {return register(baseName + "_wall", WallBlock::new, properties);}
    private static DeferredBlock<Block> registerButton(String baseName, BlockPropertyOverride properties, BlockSetType type, int ticks) {return register(baseName + "_button", p -> new ButtonBlock(type, ticks, p), properties);}
    private static DeferredBlock<Block> registerPressurePlate(String baseName, BlockPropertyOverride properties, BlockSetType type) {return register(baseName + "_pressure_plate", p -> new PressurePlateBlock(type, p), properties);}
    private static DeferredBlock<Block> registerSlab(String name, BlockPropertyOverride properties) {return register(name, SlabBlock::new, properties);}
    private static DeferredBlock<Block> registerStair(String name, BlockPropertyOverride properties, Holder<Block> block) {return register(name, p -> new StairBlock(block.value().defaultBlockState(), p), properties);}
    private static DeferredBlock<Block> registerVetheaLog(String name, BlockPropertyOverride properties) {return register(name, VetheaLog::new, properties);}
    private static DeferredBlock<Block> registerArcanaDoor(String baseName, BlockPropertyOverride properties, Holder<Item> key) {return register(baseName + "_door", p -> new ArcanaDoor(p, key), properties);}
    private static DeferredBlock<Block> registerTallFlower(String name, BlockPropertyOverride properties) {return register(name, TallFlowerBlock::new, properties);}
    private static DeferredBlock<Block> registerLadder(String name, BlockPropertyOverride properties) {return register(name, LadderBlock::new, properties);}
    private static DeferredBlock<Block> registerCandy(String name, BlockPropertyOverride properties) {return register(name, CandyCane::new, properties);}
    private static DeferredBlock<Block> registerSand(String name, BlockPropertyOverride properties, int color) {return register(name, p -> new ColoredFallingBlock(new ColorRGBA(color), p), properties);}
    private static DeferredBlock<Block> registerDreamGrass(String name, BlockPropertyOverride properties) {return register(name, p -> new ModGrassBlock(p, dreamSoil.dirt), properties);}
    private static DeferredBlock<Block> registerFireResistant(String name, BlockPropertyOverride properties) {return register(name, properties, Item.Properties::fireResistant);}
    //BASE REGISTER
    private static DeferredBlock<Block> register(String name, BlockPropertyOverride properties) {return register(name, Block::new, properties);}
    private static DeferredBlock<Block> register(String name, BlockConstructor blockConstructor, BlockPropertyOverride properties) {return register(name, name, blockConstructor, properties);}
    private static DeferredBlock<Block> register(String name, String itemName, BlockConstructor blockConstructor, BlockPropertyOverride properties) {
        DeferredBlock<Block> block = BLOCKS.register(name, () -> blockConstructor.apply(properties.apply(Properties.of()).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MODID, name)))));
        DivineRegistries.blocks.add(DivineRegistries.ITEMS.register(itemName, () -> new BlockItem(block.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, itemName))))));
        return block;
    }
    private static DeferredBlock<Block> registerItemless(String name, BlockConstructor blockConstructor, BlockPropertyOverride properties) {
        return BLOCKS.register(name, () -> blockConstructor.apply(properties.apply(Properties.of()).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MODID, name)))));
    }
    private static DeferredBlock<Block> register(String name, BlockPropertyOverride properties, ItemPropertyOverride itemProperties) {return register(name, Block::new, properties, itemProperties);}
    private static DeferredBlock<Block> register(String name, BlockConstructor blockConstructor, BlockPropertyOverride properties, ItemPropertyOverride itemProperties) {return register(name, blockConstructor, properties, (b, p) -> new BlockItem(b, itemProperties.apply(p)));}
    private static DeferredBlock<Block> register(String name, BlockConstructor blockConstructor, BlockPropertyOverride properties, ItemConstructor item) {return register(name, name, blockConstructor, properties, item);}
    private static DeferredBlock<Block> register(String name, String itemName, BlockConstructor blockConstructor, BlockPropertyOverride properties, ItemConstructor item) {
        DeferredBlock<Block> block = BLOCKS.register(name, () -> blockConstructor.apply(properties.apply(Properties.of()).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MODID, name)))));
        DivineRegistries.blocks.add(DivineRegistries.ITEMS.register(itemName, () -> item.apply(block.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, itemName))))));
        return block;
    }
    private static void addAliases(String path, DeferredBlock<Block> block) {
        Identifier loc = getIdentifier(path);
        BLOCKS.addAlias(loc, block.getId());
        DivineRegistries.ITEMS.addAlias(loc, block.getId());
    }
    private static void addAliases(String path, ResourceKey<Block> block) {
        Identifier loc = getIdentifier(path);
        Identifier defLoc = block.identifier();
        BLOCKS.addAlias(loc, defLoc);
        DivineRegistries.ITEMS.addAlias(loc, defLoc);
    }
    private static Identifier getIdentifier(String path) {
        return Identifier.fromNamespaceAndPath(MODID, path);
    }
    //INTERFACES
    interface BlockConstructor extends Function<Properties, Block> {}
    interface ItemConstructor extends BiFunction<Block, Item.Properties, Item> {}
    interface GrassConstructor extends Function3<Supplier<Block>, Supplier<Block>, Boolean, BlockConstructor> {}

    public static void load() {}
}