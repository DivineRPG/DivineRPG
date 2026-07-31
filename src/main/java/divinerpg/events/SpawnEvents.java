package divinerpg.events;

import divinerpg.entities.eden.EntityWeakCori;
import divinerpg.entities.vanilla.overworld.*;
import divinerpg.registries.AttachmentRegistry;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.SpawnPlacements.SpawnPredicate;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.living.MobSpawnEvent;
import net.neoforged.neoforge.event.entity.living.MobSpawnEvent.SpawnPlacementCheck.Result;

import javax.annotation.Nullable;
import java.util.*;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.EntityRegistry.*;
import static net.minecraft.core.registries.Registries.BIOME;
import static net.minecraft.resources.Identifier.fromNamespaceAndPath;
import static net.minecraft.resources.ResourceKey.create;
import static net.minecraft.world.entity.SpawnPlacementTypes.*;
import static net.minecraft.world.level.levelgen.Heightmap.Types.*;
import static net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent.Operation.REPLACE;

public class SpawnEvents {
    public static final ResourceKey<Biome>
            BONEYARD = create(BIOME, fromNamespaceAndPath(MODID, "iceika/boneyard")),
            BOREALIS_STEEPS = create(BIOME, fromNamespaceAndPath(MODID, "iceika/borealis_steeps")),
            CHILL_PASSAGE = create(BIOME, fromNamespaceAndPath(MODID, "iceika/chill_passage")),
            CHILLY_CAVERN = create(BIOME, fromNamespaceAndPath(MODID, "iceika/chilly_cavern")),
            COZYBARK_FOREST = create(BIOME, fromNamespaceAndPath(MODID, "iceika/cozybark_forest")),
            DEEP_FROZEN_OCEAN = create(BIOME, fromNamespaceAndPath(MODID, "iceika/deep_frozen_ocean")),
            FRACTAL_FOREST = create(BIOME, fromNamespaceAndPath(MODID, "iceika/fractal_forest")),
            FROZEN_MENAGERIE = create(BIOME, fromNamespaceAndPath(MODID, "iceika/frozen_menagerie")),
            FROZEN_OCEAN = create(BIOME, fromNamespaceAndPath(MODID, "iceika/frozen_ocean")),
            FROZEN_PEAKS = create(BIOME, fromNamespaceAndPath(MODID, "iceika/frozen_peaks")),
            GEYSER_PLATEAU = create(BIOME, fromNamespaceAndPath(MODID, "iceika/geyser_plateau")),
            GLOWING_DEEP = create(BIOME, fromNamespaceAndPath(MODID, "iceika/glowing_deep")),
            ICE_SHEET = create(BIOME, fromNamespaceAndPath(MODID, "iceika/ice_sheet")),
            ICE_SPIKES = create(BIOME, fromNamespaceAndPath(MODID, "iceika/ice_spikes")),
            MORGUE_MARSH = create(BIOME, fromNamespaceAndPath(MODID, "iceika/morgue_marsh")),
            SHELTERED_GARDEN = create(BIOME, fromNamespaceAndPath(MODID, "iceika/sheltered_garden")),
            SHIVERSPINE_FOREST = create(BIOME, fromNamespaceAndPath(MODID, "iceika/shiverspine_forest")),
            SNOW_BOG = create(BIOME, fromNamespaceAndPath(MODID, "iceika/snow_bog")),
            SNOWY_PEAKS = create(BIOME, fromNamespaceAndPath(MODID, "iceika/snowy_peaks")),
            THERMAL_VENTS = create(BIOME, fromNamespaceAndPath(MODID, "iceika/thermal_vents")),
            TUNDRA = create(BIOME, fromNamespaceAndPath(MODID, "iceika/tundra"));
    @SubscribeEvent
    public static void spawnPlacementCheck(MobSpawnEvent.SpawnPlacementCheck e) {
        if(e.getLevel() instanceof ServerLevel level) {
            EntitySpawnReason type = e.getSpawnType();
            if((type == EntitySpawnReason.NATURAL || type == EntitySpawnReason.STRUCTURE || type == EntitySpawnReason.PATROL) && level.getChunkAt(e.getPos()).getData(AttachmentRegistry.SOUL_TRAP_COUNT) > 0) {
                e.setResult(Result.FAIL);
            }
        }
    }
    @SubscribeEvent
    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent e) {
        //Boss
        register(e, AYERACO.get(), SpawnType.FLY, ALWAYS);
        //Overworld
        register(e, AEQUOREA.get(), SpawnType.WATER, DIFFICULTY_FILTER);
        register(e, ARID_WARRIOR.get(), SpawnType.GROUND, MONSTER_DARKNESS_UNDER_SKY);
        register(e, BROWN_GRIZZLE.get(), SpawnType.GROUND, MOB);
        register(e, CAVE_CRAWLER.get(), SpawnType.GROUND, CAVE_MONSTER);
        register(e, CAVECLOPS.get(), SpawnType.GROUND, (en, s, t, p, r) -> EntityCaveclops.caveClopsSpawnRule(s, p) && difficultyFilter(en, s, t, p, r) && Monster.isDarkEnoughToSpawn(s, p, r) && checkValidSpawnBlock(en, s, t, p, r));
        register(e, CRAB.get(), SpawnType.GROUND, MOB_UNDER_SKY);
        register(e, CYCLOPS.get(), SpawnType.GROUND, (en, s, t, p, r) -> EntityKobblin.kobblinSpawnRule(s, p));
        register(e, DESERT_CRAWLER.get(), SpawnType.GROUND, MONSTER_DARKNESS_UNDER_SKY);
        register(e, DIAMOND_DAVE.get(), SpawnType.GROUND, MOB);
        register(e, EHU.get(), SpawnType.GROUND, MOB);
        register(e, ENTHRALLED_DRAMCRYX.get(), SpawnType.GROUND, (en, s, t, p, r) -> EntityEnthralledDramcryx.enthralledDramcryxSpawnRule(s, p) && difficultyFilter(en, s, t, p, r) && Monster.isDarkEnoughToSpawn(s, p, r) && checkValidSpawnBlock(en, s, t, p, r));
        register(e, FROST.get(), SpawnType.AGILE, MONSTER_AGILE_UNDER_SKY);
        register(e, GLACON.get(), SpawnType.GROUND, MONSTER);
        register(e, HUSK.get(), SpawnType.GROUND, MOB);
        register(e, JACK_O_MAN.get(), SpawnType.GROUND, (en, s, t, p, r) -> checkValidSpawnBlock(en, s, t, p, r) && EntityJackOMan.rules(s, p));
        register(e, JUNGLE_BAT.get(), SpawnType.FLY, MOB);
        register(e, JUNGLE_DRAMCRYX.get(), SpawnType.GROUND, MONSTER);
        register(e, JUNGLE_SPIDER.get(), SpawnType.AGILE, MONSTER);
        register(e, KING_CRAB.get(), SpawnType.GROUND, MOB_UNDER_SKY);
        register(e, KOBBLIN.get(), SpawnType.GROUND, (en, s, t, p, r) -> difficultyFilter(en, s, t, p, r) && EntityKobblin.kobblinSpawnRule(s, p) && s.canSeeSky(p));
        register(e, LIOPLEURODON.get(), SpawnType.WATER, DIFFICULTY_FILTER);
        register(e, LIVESTOCK_MERCHANT.get(), SpawnType.GROUND, MOB);
        register(e, MINER.get(), SpawnType.GROUND, CAVE_MONSTER);
        register(e, PUMPKIN_SPIDER.get(), SpawnType.GROUND, (en, s, t, p, r) -> difficultyFilter(en, s, t, p, r) && EntityKobblin.kobblinSpawnRule(s, p));
        register(e, RAINBOUR.get(), SpawnType.AGILE, DARKNESS_AGILE);
        register(e, ROTATICK.get(), SpawnType.GROUND, DEEPSLATE_MONSTER);
        register(e, SAGUARO_WORM.get(), SpawnType.GROUND, (en, s, t, p, r) -> difficultyFilter(en, s, t, p, r) && EntitySaguaroWorm.saguaroWormSpawnRule(s, p));
        register(e, SHARK.get(), SpawnType.WATER, DIFFICULTY_FILTER);
        register(e, SMELTER.get(), SpawnType.GROUND, MOB);
        register(e, SNAPPER.get(), SpawnType.GROUND, MOB);
        register(e, STONE_GOLEM.get(), SpawnType.GROUND, MOB);
        register(e, THE_EYE.get(), SpawnType.GROUND, DEEPSLATE_MONSTER);
        register(e, THE_GRUE.get(), SpawnType.GROUND, DEEPSLATE_MONSTER);
        register(e, WHALE.get(), SpawnType.WATER, ALWAYS);
        register(e, WHITE_GRIZZLE.get(), SpawnType.GROUND, MOB);
        //Nether
        register(e, HELL_PIG.get(), SpawnType.GROUND, MOB);
        register(e, HELL_SPIDER.get(), SpawnType.AGILE, MONSTER);
        register(e, SCORCHER.get(), SpawnType.FLY, MONSTER);
        register(e, WILDFIRE.get(), SpawnType.GROUND, MONSTER);
        //End
        register(e, ENDER_SPIDER.get(), SpawnType.GROUND, MONSTER_DARKNESS_AGILE);
        register(e, ENDER_TRIPLETS.get(), SpawnType.GROUND, (en, s, t, p, r) -> difficultyFilter(en, s, t, p, r) && p.getY() > 60);
        register(e, ENDER_WATCHER.get(), SpawnType.GROUND, MONSTER);
        register(e, ENDER_SCROUNGE.get(), SpawnType.GROUND, DARKNESS);
        //Iceika
        register(e, CAULDRON_FISH.get(), SpawnType.WATER, ALWAYS);
        register(e, BLUBBERTUSK.get(), SpawnType.WG_SURFACE, (en, s, t, p, r) -> {
            Holder<Biome> b = s.getBiome(p);
            return b.is(DEEP_FROZEN_OCEAN) || b.is(FROZEN_OCEAN) || b.is(ICE_SHEET) || b.is(MORGUE_MARSH) || b.is(THERMAL_VENTS);
        });
        register(e, DOLOSSAL.get(), SpawnType.WG_SURFACE, (en, s, t, p, r) -> {
            Holder<Biome> b = s.getBiome(p);
            return b.is(BOREALIS_STEEPS) || b.is(COZYBARK_FOREST);
        });
        register(e, MAMOTH.get(), SpawnType.WG_SURFACE, (en, s, t, p, r) -> {
            Holder<Biome> b = s.getBiome(p);
            return b.is(COZYBARK_FOREST) || b.is(GLOWING_DEEP);
        });
        register(e, SNOW_SKIPPER.get(), SpawnType.AGILE, (en, s, t, p, r) -> {
            Holder<Biome> b = s.getBiome(p);
            return b.is(SNOW_BOG) || b.is(SNOWY_PEAKS);
        });
        register(e, PINK_GHOST_GLIDER.get(), SpawnType.WATER, ALWAYS);
        register(e, SENG.get(), SpawnType.WG_SURFACE, (en, s, t, p, r) -> {
            Holder<Biome> b = s.getBiome(p);
            return b.is(BOREALIS_STEEPS) || b.is(COZYBARK_FOREST) || b.is(FROZEN_PEAKS) || b.is(ICE_SPIKES) || b.is(SHIVERSPINE_FOREST);
        });
        register(e, SABEAR.get(), SpawnType.WG_SURFACE, (en, s, t, p, r) -> {
            Holder<Biome> b = s.getBiome(p);
            return b.is(CHILL_PASSAGE) || b.is(FRACTAL_FOREST) || b.is(GEYSER_PLATEAU) || b.is(MORGUE_MARSH) || b.is(SHIVERSPINE_FOREST) || b.is(SNOWY_PEAKS);
        });
        register(e, ALICANTO.get(), SpawnType.AGILE, MONSTER);
        register(e, FRACTITE.get(), SpawnType.AGILE, MONSTER_AGILE_UNDER_SKY);
        register(e, PALE_ARCHER.get(), SpawnType.GROUND, MONSTER);
        register(e, FROZEN_FLESH.get(), SpawnType.AGILE, MONSTER);
        register(e, GLACIDE.get(), SpawnType.GROUND, MONSTER);
        register(e, HASTREUS.get(), SpawnType.GROUND, MONSTER_DARKNESS);
        register(e, ROLLUM.get(), SpawnType.GROUND, (en, s, t, p, r) -> difficultyFilter(en, s, t, p, r) && (EntitySpawnReason.isSpawner(t) || Monster.isDarkEnoughToSpawn(s, p, r)) && checkValidSpawnBlock(en, s, t, p, r));
        register(e, WORKSHOP_MERCHANT.get(), SpawnType.GROUND, MOB);
        register(e, WORKSHOP_TINKERER.get(), SpawnType.GROUND, MOB);
        register(e, GROGLIN_HUNTER.get(), SpawnType.GROUND, MOB);
        register(e, GRUZZORLUG_MINER.get(), SpawnType.GROUND, MOB);
        register(e, ROBBIN.get(), SpawnType.WG_SURFACE, (en, s, t, p, r) -> {
            Holder<Biome> b = s.getBiome(p);
            return b.is(COZYBARK_FOREST) || b.is(GEYSER_PLATEAU) || b.is(ICE_SPIKES) || b.is(MORGUE_MARSH) || b.is(SHIVERSPINE_FOREST);
        });
        register(e, WOLPERTINGER.get(), SpawnType.WG_SURFACE, (en, s, t, p, r) -> {
            Holder<Biome> b = s.getBiome(p);
            return b.is(COZYBARK_FOREST) || b.is(FRACTAL_FOREST) || b.is(GEYSER_PLATEAU) || b.is(ICE_SPIKES) || b.is(MORGUE_MARSH) || b.is(SHELTERED_GARDEN) || b.is(SHIVERSPINE_FOREST) || b.is(SNOWY_PEAKS) || b.is(TUNDRA);
        });
        //Eden
        register(e, GLINTHOP.get(), SpawnType.GROUND, MOB);
        register(e, EDEN_CADILLION.get(), SpawnType.GROUND, MONSTER);
        register(e, EDEN_TOMO.get(), SpawnType.GROUND, MOB);
        register(e, GREENFEET.get(), SpawnType.GROUND, MONSTER_DARKNESS);
        register(e, MADIVEL.get(), SpawnType.GROUND, MONSTER_DARKNESS);
        register(e, SUN_ARCHER.get(), SpawnType.GROUND, MONSTER);
        register(e, WEAK_CORI.get(), SpawnType.FLY, (en, s, t, p, r) -> difficultyFilter(en, s, t, p, r) && EntityWeakCori.weakCoriSpawnRule(p));
        //Wildwood
        register(e, BEHEMOTH.get(), SpawnType.GROUND, MONSTER);
        register(e, EPIPHITE.get(), SpawnType.GROUND, MOB);
        register(e, MAGE.get(), SpawnType.GROUND, MONSTER);
        register(e, MOON_WOLF.get(), SpawnType.GROUND, MOB);
        register(e, TERMID.get(), SpawnType.AGILE, MONSTER);
        register(e, VEREK.get(), SpawnType.GROUND, MONSTER);
        register(e, WILDWOOD_CADILLION.get(), SpawnType.GROUND, MONSTER);
        register(e, WILDWOOD_GOLEM.get(), SpawnType.GROUND, MONSTER);
        register(e, WILDWOOD_TOMO.get(), SpawnType.GROUND, MOB);
        //Apalachia
        register(e, APALACHIA_CADILLION.get(), SpawnType.GROUND, MONSTER);
        register(e, APALACHIA_GOLEM.get(), SpawnType.GROUND, MONSTER);
        register(e, APALACHIA_TOMO.get(), SpawnType.GROUND, MOB);
        register(e, ENCHANTED_ARCHER.get(), SpawnType.GROUND, MONSTER);
        register(e, ENCHANTED_WARRIOR.get(), SpawnType.GROUND, MONSTER);
        register(e, SPELLBINDER.get(), SpawnType.GROUND, MONSTER);
        //Skythern
        register(e, ADVANCED_CORI.get(), SpawnType.FLY, MONSTER);
        register(e, MEGALITH.get(), SpawnType.GROUND, MONSTER);
        register(e, MYSTIC.get(), SpawnType.GROUND, MONSTER);
        register(e, SAMEK.get(), SpawnType.GROUND, MOB);
        register(e, SKYTHERN_ARCHER.get(), SpawnType.GROUND, MONSTER);
        register(e, SKYTHERN_FIEND.get(), SpawnType.GROUND, MONSTER);
        register(e, SKYTHERN_GOLEM.get(), SpawnType.GROUND, MONSTER);
        //Mortum
        register(e, ANGRY_GLINTHOP.get(), SpawnType.GROUND, MONSTER_DARKNESS);
        register(e, BASILISK.get(), SpawnType.GROUND, MONSTER_DARKNESS);
        register(e, DEMON_OF_DARKNESS.get(), SpawnType.GROUND, MONSTER_DARKNESS);
        register(e, MORTUM_CADILLION.get(), SpawnType.GROUND, MONSTER_DARKNESS);
        register(e, SORCERER.get(), SpawnType.GROUND, MONSTER_DARKNESS);
        register(e, SOUL_SPIDER.get(), SpawnType.GROUND, MONSTER_DARKNESS);
        register(e, SOUL_STEALER.get(), SpawnType.GROUND, MONSTER_DARKNESS);
        register(e, TWILIGHT_ARCHER.get(), SpawnType.GROUND, MONSTER_DARKNESS);
        //Arcana
        register(e, CAPTAIN_MERIK.get(), SpawnType.GROUND, MOB);
        register(e, DATTICON.get(), SpawnType.GROUND, MOB);
        register(e, DEATHCRYX.get(), SpawnType.GROUND, MONSTER);
        register(e, DEATH_HOUND.get(), SpawnType.GROUND, MONSTER);
        register(e, DUNGEON_CONSTRUCTOR.get(), SpawnType.GROUND, MONSTER);
        register(e, DUNGEON_DEMON.get(), SpawnType.GROUND, MONSTER);
        register(e, DUNGEON_PRISONER.get(), SpawnType.GROUND, MONSTER);
        register(e, FYRACRYX.get(), SpawnType.FLY, ALWAYS);
        register(e, GOLEM_OF_REJUVENATION.get(), SpawnType.AGILE, ALWAYS);
        register(e, KAZARI.get(), SpawnType.GROUND, MOB);
        register(e, LEORNA.get(), SpawnType.GROUND, MOB);
        register(e, LORD_VATTICUS.get(), SpawnType.GROUND, MOB);
        register(e, LIVING_STATUE.get(), SpawnType.GROUND, MONSTER);
        register(e, PARATIKU.get(), SpawnType.FLY, ALWAYS);
        register(e, RAZORBACK.get(), SpawnType.GROUND, MONSTER);
        register(e, ROAMER.get(), SpawnType.GROUND, MONSTER);
        register(e, SEIMER.get(), SpawnType.FLY, ALWAYS);
        register(e, SKYRE.get(), SpawnType.GROUND, MONSTER);
        register(e, WAR_GENERAL.get(), SpawnType.GROUND, MOB);
        register(e, WRAITH.get(), SpawnType.FLY, ALWAYS);
        register(e, ZELUS.get(), SpawnType.GROUND, MOB);
//        //Vethea
//        register(e, ACID_HAG.get(), SpawnType.GROUND, MONSTER);
//        register(e, BIPHRON.get(), SpawnType.AGILE, DIFFICULTY_FILTER);
//        register(e, BOHEMITE.get(), SpawnType.GROUND, MONSTER);
//        register(e, CRYPT_KEEPER.get(), SpawnType.GROUND, MOB);
//        register(e, CYMESOID.get(), SpawnType.GROUND, MONSTER);
//        register(e, DISSIMENT.get(), SpawnType.FLY, DIFFICULTY_FILTER);
//        register(e, DREAMWRECKER.get(), SpawnType.GROUND, MONSTER);
//        register(e, DUO.get(), SpawnType.GROUND, MONSTER);
//        register(e, ENT.get(), SpawnType.GROUND, MONSTER);
//        register(e, FAKE_VHRAAK.get(), SpawnType.GROUND, MONSTER);
//        register(e, GALROID.get(), SpawnType.AGILE, MONSTER);
//        register(e, GORGOSION.get(), SpawnType.AGILE, MONSTER);
//        register(e, HELIO.get(), SpawnType.GROUND, MONSTER);
//        register(e, HIVE_SOLDIER.get(), SpawnType.GROUND, MONSTER);
//        register(e, HOVER_STINGER.get(), SpawnType.FLY, MONSTER_DARKNESS_AGILE);
//        register(e, INSECT_FOURTEEN.get(), SpawnType.GROUND, MONSTER);
//        register(e, KAZROTIC.get(), SpawnType.GROUND, MONSTER);
//        register(e, LHEIVA.get(), SpawnType.GROUND, MONSTER);
//        register(e, LORGA.get(), SpawnType.GROUND, MONSTER);
//        register(e, LORGA_FLIGHT.get(), SpawnType.AGILE, DIFFICULTY_FILTER);
//        register(e, MANDRAGORA.get(), SpawnType.AGILE, DIFFICULTY_FILTER);
//        register(e, MYSTERIOUS_MAN_LAYER1.get(), SpawnType.GROUND, MOB);
//        register(e, MYSTERIOUS_MAN_LAYER2.get(), SpawnType.GROUND, MOB);
//        register(e, MYSTERIOUS_MAN_LAYER3.get(), SpawnType.GROUND, MOB);
//        register(e, SHADAHIER.get(), SpawnType.GROUND, MONSTER);
//        register(e, TEMPLE_GUARDIAN.get(), SpawnType.GROUND, MOB);
//        register(e, THE_HUNGER.get(), SpawnType.GROUND, MOB);
//        register(e, TOCAXIN.get(), SpawnType.GROUND, MONSTER);
//        register(e, TWINS.get(), SpawnType.GROUND, MONSTER);
//        register(e, VERMENOUS.get(), SpawnType.GROUND, MONSTER);
//        register(e, VHRAAK.get(), SpawnType.GROUND, MONSTER);
//        register(e, ZONE.get(), SpawnType.GROUND, MONSTER);
//        register(e, ZORAGON.get(), SpawnType.FLY, DIFFICULTY_FILTER);
    }
    public static <T extends Entity> void register(RegisterSpawnPlacementsEvent e, EntityType<? extends Entity> t, SpawnType s, SpawnPredicate<T> p) {
        e.register((EntityType<T>) t, s.placementType, s.heightMap, p, REPLACE);
    }
    public static final SpawnPlacementType ON_BLOCK = new SpawnPlacementType() {
        public boolean isSpawnPositionOk(LevelReader level, BlockPos pos, @Nullable EntityType<?> entityType) {
            pos = pos.below();
            BlockState state = level.getBlockState(pos);
            return entityType != null && level.getWorldBorder().isWithinBounds(pos) && (Block.isFaceFull(state.getCollisionShape(level, pos), Direction.UP) || state.is(Blocks.SNOW)) && !state.is(Blocks.ICE);
        }
        public BlockPos adjustSpawnPosition(LevelReader level, BlockPos pos) {
            BlockPos.MutableBlockPos mut = pos.mutable();
            BlockState state;
            while(Block.isFaceFull((state = level.getBlockState(mut)).getCollisionShape(level, mut), Direction.UP) || state.is(Blocks.SNOW)) mut.move(Direction.UP);
            return mut;
        }
    };
    private static final EnumMap<Difficulty, Integer> cancellationChances = new EnumMap<>(Map.of(
            Difficulty.PEACEFUL, 11,
            Difficulty.EASY, 6,
            Difficulty.NORMAL, 4,
            Difficulty.HARD, 0
    ));
    public static final SpawnPredicate<? extends Entity>
            ALWAYS = (e, s, t, p, r) -> true,//AGILE
            DIFFICULTY_FILTER = SpawnEvents::difficultyFilter,//MONSTER_AGILE
            MOB = SpawnEvents::checkValidSpawnBlock,
            MONSTER = (e, s, t, p, r) -> difficultyFilter(e, s, t, p, r) && checkValidSpawnBlock(e, s, t, p, r),
            DARKNESS = (e, s, t, p, r) -> Monster.isDarkEnoughToSpawn(s, p, r) && checkValidSpawnBlock(e, s, t, p, r),
            MONSTER_DARKNESS = (e,s,t,p,r) -> difficultyFilter(e, s, t, p, r) && Monster.isDarkEnoughToSpawn(s, p, r) && checkValidSpawnBlock(e, s, t, p, r),
            DARKNESS_AGILE = (e, s, t, p, r) -> Monster.isDarkEnoughToSpawn(s, p, r),
            MONSTER_DARKNESS_AGILE = (e, s, t, p, r) -> difficultyFilter(e, s, t, p, r) && Monster.isDarkEnoughToSpawn(s, p, r),

    CAVE_MONSTER = (en, s, t, p, r) -> p.getY() < 60 && difficultyFilter(en, s, t, p, r) && Monster.isDarkEnoughToSpawn(s, p, r) && checkValidSpawnBlock(en, s, t, p, r),
            DEEPSLATE_MONSTER = (en, s, t, p, r) -> p.getY() < 0 && difficultyFilter(en, s, t, p, r) && Monster.isDarkEnoughToSpawn(s, p, r) && checkValidSpawnBlock(en, s, t, p, r),

    AGILE_UNDER_SKY = (e, s, t, p, r) -> s.canSeeSky(p),
            MONSTER_AGILE_UNDER_SKY = (e, s, t, p, r) -> difficultyFilter(e, s, t, p, r) && s.canSeeSky(p),
            MOB_UNDER_SKY = (e, s, t, p, r) -> checkValidSpawnBlock(e, s, t, p, r) && s.canSeeSky(p),
            MONSTER_UNDER_SKY = (e, s, t, p, r) -> difficultyFilter(e, s, t, p, r) && checkValidSpawnBlock(e, s, t, p, r) && s.canSeeSky(p),
            DARKNESS_UNDER_SKY = (e, s, t, p, r) -> Monster.isDarkEnoughToSpawn(s, p, r) && checkValidSpawnBlock(e, s, t, p, r) && s.canSeeSky(p),
            MONSTER_DARKNESS_UNDER_SKY = (e, s, t, p, r) -> difficultyFilter(e, s, t, p, r) && Monster.isDarkEnoughToSpawn(s, p, r) && checkValidSpawnBlock(e, s, t, p, r) && s.canSeeSky(p),
            DARKNESS_AGILE_UNDER_SKY = (e, s, t, p, r) -> Monster.isDarkEnoughToSpawn(s, p, r) && s.canSeeSky(p),
            MONSTER_DARKNESS_AGILE_UNDER_SKY = (e, s, t, p, r) -> difficultyFilter(e, s, t, p, r) && Monster.isDarkEnoughToSpawn(s, p, r) && s.canSeeSky(p);
    public enum SpawnType {
        WG_SURFACE(ON_BLOCK, WORLD_SURFACE_WG),
        GROUND(ON_GROUND, MOTION_BLOCKING_NO_LEAVES),
        AGILE(ON_BLOCK, MOTION_BLOCKING),
        FLY(NO_RESTRICTIONS, MOTION_BLOCKING),
        OCEAN_FLOOR(IN_WATER, Heightmap.Types.OCEAN_FLOOR),
        WATER(IN_WATER, MOTION_BLOCKING);
        public final SpawnPlacementType placementType;
        public final Heightmap.Types heightMap;
        SpawnType(SpawnPlacementType placementType, Heightmap.Types heightMap) {
            this.placementType = placementType;
            this.heightMap = heightMap;
        }
    }
    public static boolean difficultyFilter(EntityType<? extends Entity> e, ServerLevelAccessor s, EntitySpawnReason t, BlockPos p, RandomSource r) {
        return t != EntitySpawnReason.NATURAL || r.nextInt(10) >= cancellationChances.getOrDefault(s.getDifficulty(), 0);
    }
    public static boolean checkValidSpawnBlock(EntityType<? extends Entity> type, LevelAccessor level, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
        BlockPos blockpos = pos.below();
        return spawnType == EntitySpawnReason.SPAWNER || level.getBlockState(blockpos).isValidSpawn(level, blockpos, type);
    }
}