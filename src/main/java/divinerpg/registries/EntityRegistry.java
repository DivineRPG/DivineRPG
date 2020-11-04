package divinerpg.registries;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.*;
import divinerpg.client.renders.base.RenderDivineMob;
import divinerpg.client.renders.vanilla.*;
import divinerpg.entities.vanilla.end.*;
import divinerpg.entities.vanilla.nether.*;
import divinerpg.entities.vanilla.overworld.*;
import divinerpg.util.SpawnEggColors;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRegistry {
    private static final List<EntityType<?>> ENTITIES = Lists.newArrayList();
    private static final List<Item> SPAWN_EGGS = Lists.newArrayList();
    // Vanilla
    public static final EntityType ARID_WARRIOR = registerEntity(EntityAridWarrior::new, "arid_warrior",1.4F, 2.8f, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType BROWN_GRIZZLE = registerEntity(EntityBrownGrizzle::new, "brown_grizzle",0.8F, 1.4F, EntityClassification.MONSTER);
    public static final EntityType CAVE_CRAWLER = registerEntity(EntityCaveCrawler::new, "cave_crawler",1.0F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType CAVECLOPS = registerEntity(EntityCaveclops::new, "caveclops", 1.2F, 4.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType CRAB = registerEntity(EntityCrab::new, "crab", 0.9F, 0.6F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType CYCLOPS = registerEntity(EntityCyclops::new, "cyclops", 1.2F, 4.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType DESERT_CRAWLER = registerEntity(EntityDesertCrawler::new, "desert_crawler", 1.0F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType EHU = registerEntity(EntityEhu::new, "ehu", 0.6F, 1.0F, EntityClassification.MONSTER);
    public static final EntityType ENTHRALLED_DRAMCRYX = registerEntity(EntityEnthralledDramcryx::new, "enthralled_dramcryx", 1.35F, 1.75F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType FROST = registerEntity(EntityFrost::new, "frost", 1.0F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType GLACON = registerEntity(EntityGlacon::new, "glacon", 0.8F, 1.4F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType HUSK = registerEntity(EntityHusk::new, "husk", 0.8F, 1.5F, EntityClassification.MONSTER);
//    public static final EntityType JACK_O_MAN = registerEntity(EntityJackOMan::new, "jack_o_man", 0.8F, 2F, EntityClassification.MISC);
    public static final EntityType JUNGLE_BAT = registerEntity(EntityJungleBat::new, "jungle_bat", 0.7F, 1F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType JUNGLE_DRAMCRYX = registerEntity(EntityJungleDramcryx::new, "jungle_dramcryx", 1F, 1.3F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType JUNGLE_SPIDER = registerEntity(EntityJungleSpider::new, "jungle_spider", 1.4F, 0.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType KING_CRAB = registerEntity(EntityKingCrab::new, "king_crab", 1.8F, 1.7F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType KOBBLIN = registerEntity(EntityKobblin::new, "kobblin", 0.75F, 1F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType LIOPLEURODON = registerEntity(EntityLiopleurodon::new, "liopleurodon", 4F, 1f, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
//    public static final EntityType LIVESTOCK_MERCHANT = registerEntity(EntityLivestockMerchant::new, "livestock_merchant", 4F, 1f, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType MINER = registerEntity(EntityMiner::new, "miner", 0.6F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType PUMPKIN_SPIDER = registerEntity(EntityPumpkinSpider::new, "pumpkin_spider", 1.25F, 1F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType RAINBOUR = registerEntity(EntityRainbour::new, "rainbour", 1F, 1F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType ROTATICK = registerEntity(EntityRotatick::new, "rotatick", 0.85F, 1F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType SAGUARO_WORM = registerEntity(EntitySaguaroWorm::new, "saguaro_worm", 1F, 3F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType SHARK = registerEntity(EntityShark::new, "shark", 1.0F, 0.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.WATER_CREATURE);
    public static final EntityType SMELTER = registerEntity(EntitySmelter::new, "smelter", 1.5F, 3.5F, EntityClassification.MONSTER);
    public static final EntityType SNAPPER = registerEntity(EntitySnapper::new, "snapper", 0.6F, 0.5F, EntityClassification.MONSTER);
    public static final EntityType STONE_GOLEM = registerEntity(EntityStoneGolem::new, "stone_golem", 1.5F, 3.5F, EntityClassification.MONSTER);
    public static final EntityType THE_EYE = registerEntity(EntityTheEye::new, "the_eye", 1.3F, 2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType THE_GRUE = registerEntity(EntityTheGrue::new, "the_grue", 0.8F, 1.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType WHALE = registerEntity(EntityWhale::new, "whale", 3F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.WATER_CREATURE);
    public static final EntityType WHITE_GRIZZLE = registerEntity(EntityWhiteGrizzle::new, "white_grizzle",0.8F, 1.4F, EntityClassification.MONSTER);

    //Nether
    public static final EntityType HELL_BAT = registerEntity(EntityHellBat::new, "hell_bat",0.7F, 1.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.NETHER), EntityClassification.MONSTER);
    public static final EntityType HELL_PIG = registerEntity(EntityHellPig::new, "hell_pig",1F, 0.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.NETHER), EntityClassification.MONSTER);
    public static final EntityType HELL_SPIDER = registerEntity(EntityHellSpider::new, "hell_spider",1.4F, 0.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.NETHER), EntityClassification.MONSTER);
    public static final EntityType SCORCHER = registerEntity(EntityScorcher::new, "scorcher",1.2F, 2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.NETHER), EntityClassification.MONSTER);
    public static final EntityType WILDFIRE = registerEntity(EntityWildfire::new, "wildfire",0.8F, 2.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.NETHER), EntityClassification.MONSTER);

    // End
    public static final EntityType ENDER_SPIDER = registerEntity(EntityEnderSpider::new, "ender_spider",0.5F, 0.55F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.END), EntityClassification.MONSTER);
    public static final EntityType ENDER_TRIPLETS = registerEntity(EntityEnderTriplets::new, "ender_triplets",2.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.END), EntityClassification.MONSTER);
    public static final EntityType ENDER_WATCHER = registerEntity(EntityEnderWatcher::new, "ender_watcher",0.7F, 0.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.END), EntityClassification.MONSTER);

    public static void init() {
        // VANILLA
        GlobalEntityTypeAttributes.put(ARID_WARRIOR, EntityAridWarrior.attributes().create());
        GlobalEntityTypeAttributes.put(BROWN_GRIZZLE, EntityBrownGrizzle.attributes().create());
        GlobalEntityTypeAttributes.put(CAVE_CRAWLER, EntityCaveCrawler.attributes().create());
        GlobalEntityTypeAttributes.put(CAVECLOPS, EntityCaveclops.attributes().create());
        GlobalEntityTypeAttributes.put(CRAB, EntityCrab.attributes().create());
        GlobalEntityTypeAttributes.put(CYCLOPS, EntityCyclops.attributes().create());
        GlobalEntityTypeAttributes.put(DESERT_CRAWLER, EntityDesertCrawler.attributes().create());
        GlobalEntityTypeAttributes.put(EHU, EntityEhu.attributes().create());
        GlobalEntityTypeAttributes.put(ENTHRALLED_DRAMCRYX, EntityEnthralledDramcryx.attributes().create());
        GlobalEntityTypeAttributes.put(FROST, EntityFrost.attributes().create());
        GlobalEntityTypeAttributes.put(GLACON, EntityGlacon.attributes().create());
        GlobalEntityTypeAttributes.put(HUSK, EntityHusk.attributes().create());
        GlobalEntityTypeAttributes.put(JUNGLE_BAT, EntityJungleBat.attributes().create());
        GlobalEntityTypeAttributes.put(JUNGLE_DRAMCRYX, EntityJungleDramcryx.attributes().create());
        GlobalEntityTypeAttributes.put(JUNGLE_SPIDER, EntityJungleSpider.attributes().create());
        GlobalEntityTypeAttributes.put(KING_CRAB, EntityKingCrab.attributes().create());
        GlobalEntityTypeAttributes.put(KOBBLIN, EntityKobblin.attributes().create());
        GlobalEntityTypeAttributes.put(LIOPLEURODON, EntityLiopleurodon.attributes().create());
        GlobalEntityTypeAttributes.put(MINER, EntityMiner.attributes().create());
        GlobalEntityTypeAttributes.put(PUMPKIN_SPIDER, EntityPumpkinSpider.attributes().create());
        GlobalEntityTypeAttributes.put(RAINBOUR, EntityRainbour.attributes().create());
        GlobalEntityTypeAttributes.put(ROTATICK, EntityRotatick.attributes().create());
        GlobalEntityTypeAttributes.put(SAGUARO_WORM, EntitySaguaroWorm.attributes().create());
        GlobalEntityTypeAttributes.put(SHARK, EntityShark.attributes().create());
        GlobalEntityTypeAttributes.put(SMELTER, EntitySmelter.attributes().create());
        GlobalEntityTypeAttributes.put(SNAPPER, EntitySnapper.attributes().create());
        GlobalEntityTypeAttributes.put(STONE_GOLEM, EntityStoneGolem.attributes().create());
        GlobalEntityTypeAttributes.put(THE_EYE, EntityTheEye.attributes().create());
        GlobalEntityTypeAttributes.put(THE_GRUE, EntityTheGrue.attributes().create());
        GlobalEntityTypeAttributes.put(WHALE, EntityWhale.attributes().create());
        GlobalEntityTypeAttributes.put(WHITE_GRIZZLE, EntityWhiteGrizzle.attributes().create());

        //NETHER
        GlobalEntityTypeAttributes.put(HELL_BAT, EntityHellBat.attributes().create());
        GlobalEntityTypeAttributes.put(HELL_PIG, EntityHellPig.attributes().create());
        GlobalEntityTypeAttributes.put(HELL_SPIDER, EntityHellSpider.attributes().create());
        GlobalEntityTypeAttributes.put(SCORCHER, EntityScorcher.attributes().create());
        GlobalEntityTypeAttributes.put(WILDFIRE, EntityWildfire.attributes().create());

        //END
        GlobalEntityTypeAttributes.put(ENDER_SPIDER, EntityEnderSpider.attributes().create());
        GlobalEntityTypeAttributes.put(ENDER_TRIPLETS, EntityEnderTriplets.attributes().create());
        GlobalEntityTypeAttributes.put(ENDER_WATCHER, EntityEnderWatcher.attributes().create());


        //PLACEMENT
        //TODO - Configure canSpawnOn methods
        EntitySpawnPlacementRegistry.register(ARID_WARRIOR, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityAridWarrior::canSpawnOn);
        EntitySpawnPlacementRegistry.register(BROWN_GRIZZLE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityBrownGrizzle::canSpawnOn);
        EntitySpawnPlacementRegistry.register(CAVE_CRAWLER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityCaveCrawler::canSpawnOn);
        EntitySpawnPlacementRegistry.register(CAVECLOPS, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityCaveclops::canSpawnOn);
        EntitySpawnPlacementRegistry.register(CRAB, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityCrab::canSpawnOn);
        EntitySpawnPlacementRegistry.register(CYCLOPS, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityCyclops::canSpawnOn);
        EntitySpawnPlacementRegistry.register(DESERT_CRAWLER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityDesertCrawler::canSpawnOn);
        EntitySpawnPlacementRegistry.register(EHU, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityEhu::canSpawnOn);
        EntitySpawnPlacementRegistry.register(ENTHRALLED_DRAMCRYX, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityEnthralledDramcryx::canSpawnOn);
        EntitySpawnPlacementRegistry.register(FROST, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityFrost::canSpawnOn);
        EntitySpawnPlacementRegistry.register(GLACON, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityGlacon::canSpawnOn);
        EntitySpawnPlacementRegistry.register(HUSK, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityHusk::canSpawnOn);
        EntitySpawnPlacementRegistry.register(JUNGLE_BAT, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityJungleBat::canSpawnOn);
        EntitySpawnPlacementRegistry.register(JUNGLE_DRAMCRYX, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityJungleDramcryx::canSpawnOn);
        EntitySpawnPlacementRegistry.register(JUNGLE_SPIDER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityJungleSpider::canSpawnOn);
        EntitySpawnPlacementRegistry.register(KING_CRAB, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityKingCrab::canSpawnOn);
        EntitySpawnPlacementRegistry.register(KOBBLIN, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityKobblin::canSpawnOn);
        EntitySpawnPlacementRegistry.register(LIOPLEURODON, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityLiopleurodon::canSpawnOn);
        EntitySpawnPlacementRegistry.register(MINER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityMiner::canSpawnOn);
        EntitySpawnPlacementRegistry.register(PUMPKIN_SPIDER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityPumpkinSpider::canSpawnOn);
        EntitySpawnPlacementRegistry.register(RAINBOUR, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityRainbour::canSpawnOn);
        EntitySpawnPlacementRegistry.register(ROTATICK, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityRotatick::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SAGUARO_WORM, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySaguaroWorm::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SHARK, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityShark::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SMELTER, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySmelter::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SNAPPER, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySnapper::canSpawnOn);
        EntitySpawnPlacementRegistry.register(STONE_GOLEM, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityStoneGolem::canSpawnOn);
        EntitySpawnPlacementRegistry.register(THE_EYE, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityTheEye::canSpawnOn);
        EntitySpawnPlacementRegistry.register(THE_GRUE, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityTheGrue::canSpawnOn);
        EntitySpawnPlacementRegistry.register(WHALE, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityWhale::canSpawnOn);
        EntitySpawnPlacementRegistry.register(WHITE_GRIZZLE, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityWhiteGrizzle::canSpawnOn);

        //Nether
        EntitySpawnPlacementRegistry.register(HELL_BAT, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityHellBat::canSpawnOn);
        EntitySpawnPlacementRegistry.register(HELL_PIG, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityHellPig::canSpawnOn);
        EntitySpawnPlacementRegistry.register(HELL_SPIDER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityHellSpider::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SCORCHER, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityScorcher::canSpawnOn);
        EntitySpawnPlacementRegistry.register(WILDFIRE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityWildfire::canSpawnOn);

        //End
        EntitySpawnPlacementRegistry.register(ENDER_SPIDER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityEnderSpider::canSpawnOn);
        EntitySpawnPlacementRegistry.register(ENDER_TRIPLETS, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING, EntityEnderTriplets::canSpawnOn);
        EntitySpawnPlacementRegistry.register(ENDER_WATCHER, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityEnderWatcher::canSpawnOn);

    }

    public static void render() {
        RenderingRegistry.registerEntityRenderingHandler(ARID_WARRIOR, RenderAridWarrior::new);
        RenderingRegistry.registerEntityRenderingHandler(CAVE_CRAWLER, manager -> new RenderDivineMob(manager, new ModelCrawler(), new ResourceLocation(DivineRPG.MODID, "textures/entity/cave_crawler.png")));
        RenderingRegistry.registerEntityRenderingHandler(BROWN_GRIZZLE, manager -> new RenderDivineMob(manager, new ModelGrizzle(), new ResourceLocation(DivineRPG.MODID, "textures/entity/brown_grizzle.png")));
        RenderingRegistry.registerEntityRenderingHandler(CAVECLOPS, RenderCaveclops::new);
        RenderingRegistry.registerEntityRenderingHandler(CRAB, manager -> new RenderDivineMob(manager, new ModelCrab(), new ResourceLocation(DivineRPG.MODID, "textures/entity/crab.png")));
        RenderingRegistry.registerEntityRenderingHandler(CYCLOPS, RenderCyclops::new);
        RenderingRegistry.registerEntityRenderingHandler(DESERT_CRAWLER, manager -> new RenderDivineMob(manager, new ModelCrawler(), new ResourceLocation(DivineRPG.MODID, "textures/entity/desert_crawler.png")));
        RenderingRegistry.registerEntityRenderingHandler(EHU, manager -> new RenderDivineMob(manager, new ModelEhu(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ehu.png")));
        RenderingRegistry.registerEntityRenderingHandler(ENTHRALLED_DRAMCRYX, manager -> new RenderDivineMob(manager, new ModelEnthralledDramcryx(), 1.5F, new ResourceLocation(DivineRPG.MODID, "textures/entity/enthralled_dramcryx.png")));
        RenderingRegistry.registerEntityRenderingHandler(FROST, manager -> new RenderDivineMob(manager, new ModelFrost(), 1.5F, new ResourceLocation(DivineRPG.MODID, "textures/entity/frost.png")));
        RenderingRegistry.registerEntityRenderingHandler(GLACON, manager -> new RenderDivineMob(manager, new ModelGlacon(), new ResourceLocation(DivineRPG.MODID, "textures/entity/glacon.png")));
        RenderingRegistry.registerEntityRenderingHandler(HUSK, manager -> new RenderDivineMob(manager, new ModelHusk(), new ResourceLocation(DivineRPG.MODID, "textures/entity/husk.png")));
        RenderingRegistry.registerEntityRenderingHandler(JUNGLE_BAT, manager -> new RenderDivineMob(manager, new ModelJungleBat(), new ResourceLocation(DivineRPG.MODID, "textures/entity/jungle_bat.png")));
        RenderingRegistry.registerEntityRenderingHandler(JUNGLE_DRAMCRYX, manager -> new RenderDivineMob(manager, new ModelDramcryx(), new ResourceLocation(DivineRPG.MODID, "textures/entity/jungle_dramcryx.png")));
        RenderingRegistry.registerEntityRenderingHandler(JUNGLE_SPIDER, manager -> new RenderDivineMob(manager, new ModelJungleSpider(), new ResourceLocation(DivineRPG.MODID, "textures/entity/jungle_spider.png")));
        RenderingRegistry.registerEntityRenderingHandler(KING_CRAB, manager -> new RenderDivineMob(manager, new ModelKingCrab(), 2F, new ResourceLocation(DivineRPG.MODID, "textures/entity/crab.png")));
        RenderingRegistry.registerEntityRenderingHandler(KOBBLIN, RenderKobblin::new);
        RenderingRegistry.registerEntityRenderingHandler(LIOPLEURODON, manager -> new RenderDivineMob(manager, new ModelLiopleurodon(), 2F, new ResourceLocation(DivineRPG.MODID, "textures/entity/liopleurodon.png")));
        RenderingRegistry.registerEntityRenderingHandler(MINER, RenderMiner::new);
        RenderingRegistry.registerEntityRenderingHandler(PUMPKIN_SPIDER, manager -> new RenderDivineMob(manager, new ModelPumpkinSpider(), new ResourceLocation(DivineRPG.MODID, "textures/entity/pumpkin_spider.png"), 0));
        RenderingRegistry.registerEntityRenderingHandler(RAINBOUR, manager -> new RenderDivineMob(manager, new ModelRainbour(), new ResourceLocation(DivineRPG.MODID, "textures/entity/rainbour.png"), 0));
        RenderingRegistry.registerEntityRenderingHandler(ROTATICK, manager -> new RenderDivineMob(manager, new ModelRotatick(), new ResourceLocation(DivineRPG.MODID, "textures/entity/rotatick.png"), 0));
        RenderingRegistry.registerEntityRenderingHandler(SAGUARO_WORM, manager -> new RenderDivineMob(manager, new ModelSaguaroWorm(), new ResourceLocation(DivineRPG.MODID, "textures/entity/saguaro_worm.png"), 0));
        RenderingRegistry.registerEntityRenderingHandler(SHARK, RenderShark::new);
        RenderingRegistry.registerEntityRenderingHandler(SMELTER, manager -> new RenderDivineMob(manager, new ModelStoneGolem(), new ResourceLocation(DivineRPG.MODID, "textures/entity/smelter.png"), 0));
        RenderingRegistry.registerEntityRenderingHandler(SNAPPER, manager -> new RenderDivineMob(manager, new ModelSnapper(), new ResourceLocation(DivineRPG.MODID, "textures/entity/snapper.png"), 0));
        RenderingRegistry.registerEntityRenderingHandler(STONE_GOLEM, manager -> new RenderDivineMob(manager, new ModelStoneGolem(), new ResourceLocation(DivineRPG.MODID, "textures/entity/stone_golem.png"), 0));
        RenderingRegistry.registerEntityRenderingHandler(THE_EYE, manager -> new RenderDivineMob(manager, new ModelTheEye(), new ResourceLocation(DivineRPG.MODID, "textures/entity/the_eye.png"), 0));
        RenderingRegistry.registerEntityRenderingHandler(THE_GRUE, manager -> new RenderDivineMob(manager, new ModelTheGrue(), new ResourceLocation(DivineRPG.MODID, "textures/entity/the_grue.png"), 0));
        RenderingRegistry.registerEntityRenderingHandler(WHALE, RenderWhale::new);
        RenderingRegistry.registerEntityRenderingHandler(WHITE_GRIZZLE, manager -> new RenderDivineMob(manager, new ModelGrizzle(), new ResourceLocation(DivineRPG.MODID, "textures/entity/white_grizzle.png")));

        //NETHER
        RenderingRegistry.registerEntityRenderingHandler(HELL_BAT, manager -> new RenderDivineMob(manager, new ModelHellBat(), new ResourceLocation(DivineRPG.MODID, "textures/entity/hell_bat.png")));
        RenderingRegistry.registerEntityRenderingHandler(HELL_PIG, RenderHellPig::new);
        RenderingRegistry.registerEntityRenderingHandler(HELL_SPIDER, manager -> new RenderDivineMob(manager, new ModelHellSpider(), new ResourceLocation(DivineRPG.MODID, "textures/entity/hell_spider.png")));
        RenderingRegistry.registerEntityRenderingHandler(SCORCHER, manager -> new RenderDivineMob(manager, new ModelScorcher(), new ResourceLocation(DivineRPG.MODID, "textures/entity/scorcher.png")));
        RenderingRegistry.registerEntityRenderingHandler(WILDFIRE, RenderWildfire::new);

        //END
        RenderingRegistry.registerEntityRenderingHandler(ENDER_SPIDER, manager -> new RenderDivineMob(manager, new ModelEnderSpider(), 0.5F, new ResourceLocation(DivineRPG.MODID, "textures/entity/ender_spider.png")));
        RenderingRegistry.registerEntityRenderingHandler(ENDER_TRIPLETS, manager -> new RenderDivineMob(manager, new ModelEnderTriplets(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ender_triplets.png")));
        RenderingRegistry.registerEntityRenderingHandler(ENDER_WATCHER, manager -> new RenderDivineMob(manager, new ModelEnderWatcher(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ender_watcher.png")));

    }

    public static void spawnStuff(BiomeLoadingEvent event) {
        Biome.Category biome = event.getCategory();
        if (biome == Biome.Category.THEEND) {
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(ENDER_SPIDER,  2, 1, 4));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(ENDER_TRIPLETS,  1, 1, 4));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(ENDER_TRIPLETS,  10, 4, 4));
        }
        if (biome == Biome.Category.NETHER) {
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(HELL_BAT, 50, 1, 4));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(HELL_PIG, 25, 5, 50));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(HELL_SPIDER, 50, 1, 1));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(SCORCHER, 7, 1, 4));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(WILDFIRE, 50, 1, 1));
        }
        if (biome != Biome.Category.MUSHROOM) {
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(CAVE_CRAWLER, 70, 2, 3));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(CAVECLOPS, 70, 1, 4));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(ENDER_SPIDER,  4, 1, 4));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(ENTHRALLED_DRAMCRYX, 70, 3, 4));
//            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(JACK_O_MAN, 5, 1, 1));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(MINER, 5, 1, 1));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(RAINBOUR, 1, 1, 1));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(ROTATICK, 70, 3, 4));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(THE_EYE, 30, 1, 4));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(THE_GRUE, 30, 1, 4));
        }
        if (biome == Biome.Category.ICY) {
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(FROST, 50, 1, 4));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(GLACON, 30, 1, 1));
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(GLACON, 30, 1, 1));
        }
        if (biome == Biome.Category.DESERT) {
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(ARID_WARRIOR, 35, 1, 4));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(DESERT_CRAWLER, 50, 1, 4));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(SAGUARO_WORM, 20, 1, 4));
        }
        if (biome == Biome.Category.BEACH) {
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(CRAB, 100, 4, 4));
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(KING_CRAB, 40, 4, 4));
        }
        if (biome == Biome.Category.JUNGLE) {
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(JUNGLE_BAT, 50, 1, 4));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(JUNGLE_DRAMCRYX, 80, 1, 4));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(JUNGLE_SPIDER , 80, 1, 4));
        }
        if (biome == Biome.Category.PLAINS) {
            event.getSpawns().getSpawner(EntityClassification.MISC).add(new MobSpawnInfo.Spawners(CYCLOPS, 10, 2, 4));
            event.getSpawns().getSpawner(EntityClassification.MISC).add(new MobSpawnInfo.Spawners(KOBBLIN, 5, 1, 1));
        }
        if (biome == Biome.Category.FOREST) {
            event.getSpawns().getSpawner(EntityClassification.MISC).add(new MobSpawnInfo.Spawners(PUMPKIN_SPIDER, 20, 1, 1));
        }
        if (biome == Biome.Category.OCEAN) {
            event.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(LIOPLEURODON, 1, 1, 1));
            event.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(SHARK, 2, 1, 2));
            event.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(WHALE, 3, 1, 3));
        }
    }


    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        for (EntityType entity : ENTITIES) {
            Preconditions.checkNotNull(entity.getRegistryName(), "registryName");
            event.getRegistry().register(entity);
            }
    }
    private static <T extends Entity> EntityType<T> registerEntity(EntityType.IFactory<T> factory, String entityName, float width, float height, SpawnEggColors colors, EntityClassification classification) {
        ResourceLocation location = new ResourceLocation(DivineRPG.MODID, entityName);
        EntityType<T> entity = EntityType.Builder.create(factory, classification).size(width, height).setTrackingRange(64).setUpdateInterval(1).build(location.toString());
        entity.setRegistryName(location);
        ENTITIES.add(entity);
        Item spawnEgg = new SpawnEggItem(entity, colors.getPrimaryColor(), colors.getSecondaryColor(), (new Item.Properties()).group(DivineRPG.tabs.spawners)).setRegistryName(entityName +"_spawn_egg");
        SPAWN_EGGS.add(spawnEgg);

        return entity;
    }
    private static <T extends Entity> EntityType<T> registerEntity(EntityType.IFactory<T> factory, String entityName, float width, float height, EntityClassification classification) {
        ResourceLocation location = new ResourceLocation(DivineRPG.MODID, entityName);
        EntityType<T> entity = EntityType.Builder.create(factory, classification).size(width, height).setTrackingRange(64).setUpdateInterval(1).build(location.toString());
        entity.setRegistryName(location);
        ENTITIES.add(entity);
        return entity;
    }

    @SubscribeEvent
    public static void registerSpawnEggs(final RegistryEvent.Register<Item> event) {
        for (Item spawnEgg : SPAWN_EGGS) {
            Preconditions.checkNotNull(spawnEgg.getRegistryName(), "registryName");
            event.getRegistry().register(spawnEgg);
        }
    }
}