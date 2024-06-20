package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.capability.*;
import divinerpg.entities.ai.TurtleEatAequorea;
import divinerpg.entities.eden.EntityWeakCori;
import divinerpg.entities.vanilla.end.EntityEnderTriplets;
import divinerpg.entities.vanilla.overworld.*;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.SpawnPlacements.SpawnPredicate;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.event.entity.*;
import net.minecraftforge.event.entity.living.MobSpawnEvent.SpawnPlacementCheck;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.*;

import static divinerpg.registries.EntityRegistry.*;
import static net.minecraft.world.entity.SpawnPlacements.Type.*;
import static net.minecraft.world.level.levelgen.Heightmap.Types.*;
import static net.minecraftforge.event.entity.SpawnPlacementRegisterEvent.Operation.REPLACE;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpawnEvents {
	public static void spawnPlacementCheck(SpawnPlacementCheck e) {
		if(e.getLevel() instanceof ServerLevel level) {
			MobSpawnType type = e.getSpawnType();
			if((type == MobSpawnType.NATURAL || type == MobSpawnType.STRUCTURE || type == MobSpawnType.PATROL) && level.getChunkAt(e.getPos()).getCapability(SoulTrapCountProvider.SOUL_TRAP_COUNT).orElseGet(() -> new SoulTrapCount()).count > 0) {
				e.setResult(Result.DENY);
			}
		}
	}
	@SubscribeEvent
	public static void registerSpawnPlacements(SpawnPlacementRegisterEvent e) {
    	//Boss
    	registerSpawn(e, AYERACO.get());
    	//Overworld
    	registerWaterSpawn(e, AEQUOREA.get());
    	registerMonsterSpawn(e, ARID_WARRIOR.get());
    	registerSpawn(e, BROWN_GRIZZLE.get());
    	registerDarkSpawn(e, CAVE_CRAWLER.get());
    	registerSpawn(e, CAVECLOPS.get(), EntityCaveclops::caveClopsSpawnRule);
    	registerSpawn(e, CRAB.get(), EntityCrab::crabSpawnRule);
    	registerSpawn(e, CYCLOPS.get(), EntityKobblin::kobblinSpawnRule);
		registerMonsterSpawn(e, DESERT_CRAWLER.get());
		registerMobSpawn(e, DIAMOND_DAVE.get());
    	registerSpawn(e, EHU.get());
    	registerSpawn(e, ENTHRALLED_DRAMCRYX.get(), EntityEnthralledDramcryx::enthralledDramcryxSpawnRule);
    	registerAgileSurfaceMonsterSpawn(e, FROST.get());
    	registerSurfaceMonsterSpawn(e, GLACON.get());
    	registerSpawn(e, HUSK.get());
    	registerSpawn(e, JACK_O_MAN.get(), EntityJackOMan::rules);
    	registerAirSpawn(e, JUNGLE_BAT.get());
    	registerAgileMonsterSpawn(e, JUNGLE_DRAMCRYX.get());
    	registerAgileMonsterSpawn(e, JUNGLE_SPIDER.get());
    	registerSpawn(e, KING_CRAB.get(), EntityCrab::crabSpawnRule);
    	registerSpawn(e, KOBBLIN.get(), EntityKobblin::kobblinSpawnRule);
		registerWaterSpawn(e, LIOPLEURODON.get(), EntityLiopleurodon::liopleurodonSpawnRule);
		registerMobSpawn(e, LIVESTOCK_MERCHANT.get());
    	registerDarkSpawn(e, MINER.get());
    	registerSpawn(e, PUMPKIN_SPIDER.get(), EntityKobblin::kobblinSpawnRule);
    	registerAirSpawn(e, RAINBOUR.get(), EntityRainbour::rainbourSpawnRule);
    	registerSpawn(e, ROTATICK.get(), EntityRotatick::rotatickSpawnRule);
    	registerSpawn(e, SAGUARO_WORM.get(), EntitySaguaroWorm::saguaroWormSpawnRule);
    	registerWaterSpawn(e, SHARK.get());
    	registerSpawn(e, SMELTER.get());
    	registerSpawn(e, SNAPPER.get());
    	registerSpawn(e, STONE_GOLEM.get());
    	registerSpawn(e, THE_EYE.get(), EntityTheEye::theEyeSpawnRule);
    	registerSpawn(e, THE_GRUE.get(), EntityTheGrue::theGrueSpawnRule);
    	registerWaterSpawn(e, WHALE.get());
    	registerSpawn(e, WHITE_GRIZZLE.get());
    	//Nether
    	registerMobSpawn(e, HELL_PIG.get());
    	registerAgileMonsterSpawn(e, HELL_SPIDER.get());
		registerMonsterSpawn(e, SCORCHER.get());
    	registerMonsterSpawn(e, WILDFIRE.get());
    	//End
		registerDarkSpawn(e, ENDER_SPIDER.get());
    	registerAirSpawn(e, ENDER_TRIPLETS.get(), EntityEnderTriplets::enderTripletSpawnRule);
    	registerMonsterSpawn(e, ENDER_WATCHER.get());
    	//Iceika
    	registerWaterSpawn(e, CAULDRON_FISH.get());
    	registerSurfaceSpawn(e, BLUBBERTUSK.get());
    	registerAgileMobSpawn(e, ROBBIN.get());
    	registerMobSpawn(e, WOLPERTINGER.get());
    	registerMobSpawn(e, DOLOSSAL.get());
    	registerMobSpawn(e, MAMOTH.get());
    	registerAgileMobSpawn(e, SNOW_SKIPPER.get());
    	registerWaterSpawn(e, PINK_GHOST_GLIDER.get());
    	registerMobSpawn(e, SENG.get());
    	registerMobSpawn(e, SABEAR.get());
		registerAgileMonsterSpawn(e, ALICANTO.get());
		registerAgileMonsterSpawn(e, FRACTITE.get());
    	registerMonsterSpawn(e, PALE_ARCHER.get());
    	registerMonsterSpawn(e, FROZEN_FLESH.get());
    	registerMonsterSpawn(e, GLACIDE.get());
    	registerMonsterSpawn(e, HASTREUS.get());
    	registerMonsterSpawn(e, ROLLUM.get());
    	registerMobSpawn(e, WORKSHOP_MERCHANT.get());
		registerMobSpawn(e, WORKSHOP_TINKERER.get());
		registerMobSpawn(e, GROGLIN_HUNTER.get());
		registerMobSpawn(e, GRUZZORLUG_MINER.get());
		registerMobSpawn(e, ROBBIN.get());
		registerMobSpawn(e, WOLPERTINGER.get());
		//Eden
    	registerMobSpawn(e, GLINTHOP.get());
    	registerMonsterSpawn(e, EDEN_CADILLION.get());
    	registerMonsterSpawn(e, EDEN_TOMO.get());
    	registerDarkSpawn(e, GREENFEET.get());
    	registerDarkSpawn(e, MADIVEL.get());
    	registerMonsterSpawn(e, SUN_ARCHER.get());
    	registerAirSpawn(e, WEAK_CORI.get(), EntityWeakCori::weakCoriSpawnRule);
    	//Wildwood
    	registerMonsterSpawn(e, BEHEMOTH.get());
    	registerMobSpawn(e, EPIPHITE.get());
    	registerMonsterSpawn(e, MAGE.get());
    	registerMobSpawn(e, MOON_WOLF.get());
    	registerMonsterSpawn(e, TERMID.get());
    	registerMonsterSpawn(e, VEREK.get());
    	registerMonsterSpawn(e, WILDWOOD_CADILLION.get());
    	registerMonsterSpawn(e, WILDWOOD_GOLEM.get());
    	registerMonsterSpawn(e, WILDWOOD_TOMO.get());
    	//Apalachia
    	registerMonsterSpawn(e, APALACHIA_CADILLION.get());
    	registerMonsterSpawn(e, APALACHIA_GOLEM.get());
    	registerMonsterSpawn(e, APALACHIA_TOMO.get());
    	registerMonsterSpawn(e, ENCHANTED_ARCHER.get());
    	registerMonsterSpawn(e, ENCHANTED_WARRIOR.get());
    	registerMonsterSpawn(e, SPELLBINDER.get());
    	//Skythern
    	registerMonsterSpawn(e, ADVANCED_CORI.get());
    	registerMonsterSpawn(e, MEGALITH.get());
    	registerMonsterSpawn(e, MYSTIC.get());
    	registerMonsterSpawn(e, SAMEK.get());
    	registerMonsterSpawn(e, SKYTHERN_ARCHER.get());
    	registerMonsterSpawn(e, SKYTHERN_FIEND.get());
    	registerMonsterSpawn(e, SKYTHERN_GOLEM.get());
    	//Mortum
    	registerMonsterSpawn(e, ANGRY_GLINTHOP.get());
    	registerMonsterSpawn(e, BASILISK.get());
    	registerMonsterSpawn(e, DEMON_OF_DARKNESS.get());
    	registerMonsterSpawn(e, MORTUM_CADILLION.get());
    	registerMonsterSpawn(e, SORCERER.get());
    	registerMonsterSpawn(e, SOUL_SPIDER.get());
    	registerMonsterSpawn(e, SOUL_STEALER.get());
    	registerMonsterSpawn(e, TWILIGHT_ARCHER.get());
    	//Arcana
    	registerMobSpawn(e, CAPTAIN_MERIK.get());
    	registerMobSpawn(e, DATTICON.get());
    	registerMonsterSpawn(e, DEATHCRYX.get());
    	registerMonsterSpawn(e, DEATH_HOUND.get());
    	registerMonsterSpawn(e, DUNGEON_CONSTRUCTOR.get());
    	registerMonsterSpawn(e, DUNGEON_DEMON.get());
    	registerMonsterSpawn(e, DUNGEON_PRISONER.get());
    	registerSpawn(e, FYRACRYX.get());
    	registerSpawn(e, GOLEM_OF_REJUVENATION.get());
    	registerMobSpawn(e, KAZARI.get());
    	registerMobSpawn(e, LEORNA.get());
    	registerMobSpawn(e, LORD_VATTICUS.get());
    	registerMonsterSpawn(e, LIVING_STATUE.get());
    	registerSpawn(e, PARATIKU.get());
    	registerMonsterSpawn(e, RAZORBACK.get());
    	registerMonsterSpawn(e, ROAMER.get());
    	registerSpawn(e, SEIMER.get());
    	registerMonsterSpawn(e, SKYRE.get());
    	registerMobSpawn(e, WAR_GENERAL.get());
    	registerSpawn(e, WRAITH.get());
    	registerMobSpawn(e, ZELUS.get());
    	//Vethea
    	registerMonsterSpawn(e, ACID_HAG.get());
    	registerMonsterSpawn(e, BIPHRON.get());
    	registerMonsterSpawn(e, BOHEMITE.get());
    	registerMobSpawn(e, CRYPT_KEEPER.get());
    	registerMonsterSpawn(e, CYMESOID.get());
		registerMonsterSpawn(e, DISSIMENT.get());
    	registerMonsterSpawn(e, DREAMWRECKER.get());
    	registerMonsterSpawn(e, DUO.get());
    	registerMonsterSpawn(e, ENT.get());
    	registerMonsterSpawn(e, FAKE_VHRAAK.get());
    	registerMonsterSpawn(e, GALROID.get());
    	registerMonsterSpawn(e, GORGOSION.get());
    	registerMonsterSpawn(e, HELIO.get());
    	registerMonsterSpawn(e, HIVE_SOLDIER.get());
    	registerDarkSpawn(e, HOVER_STINGER.get());
    	registerMonsterSpawn(e, KAZROTIC.get());
    	registerMonsterSpawn(e, LHEIVA.get());
    	registerMonsterSpawn(e, LORGA.get());
		registerMonsterSpawn(e, LORGA_FLIGHT.get());
    	registerMonsterSpawn(e, MANDRAGORA.get());
    	registerMobSpawn(e, MYSTERIOUS_MAN_LAYER1.get());
    	registerMobSpawn(e, MYSTERIOUS_MAN_LAYER2.get());
    	registerMobSpawn(e, MYSTERIOUS_MAN_LAYER3.get());
    	registerMonsterSpawn(e, SHADAHIER.get());
    	registerMobSpawn(e, TEMPLE_GUARDIAN.get());
    	registerMobSpawn(e, THE_HUNGER.get());
    	registerMonsterSpawn(e, TOCAXIN.get());
    	registerMonsterSpawn(e, TWINS.get());
    	registerMonsterSpawn(e, VERMENOUS.get());
    	registerMonsterSpawn(e, VHRAAK.get());
    	registerMonsterSpawn(e, ZONE.get());
		registerMonsterSpawn(e, ZORAGON.get());
	}
	public static void registerSpawn(SpawnPlacementRegisterEvent e, EntityType<? extends Entity> type) {
    	e.register(type, ON_GROUND, MOTION_BLOCKING_NO_LEAVES, SpawnEvents::always, REPLACE);
    }
    public static <T extends Entity> void registerSpawn(SpawnPlacementRegisterEvent e, EntityType<T> type, SpawnPredicate<T> predicate) {
    	e.register(type, ON_GROUND, MOTION_BLOCKING_NO_LEAVES, predicate, REPLACE);
    }
    public static void registerAgileMonsterSpawn(SpawnPlacementRegisterEvent e, EntityType<? extends Monster> type) {
    	e.register(type, ON_GROUND, MOTION_BLOCKING, Monster::checkAnyLightMonsterSpawnRules, REPLACE);
    }
    public static void registerAgileMobSpawn(SpawnPlacementRegisterEvent e, EntityType<? extends Mob> type) {
    	e.register(type, ON_GROUND, MOTION_BLOCKING, Mob::checkMobSpawnRules, REPLACE);
    }
	public static void registerWaterSpawn(SpawnPlacementRegisterEvent e, EntityType<? extends Entity> type) {
		e.register(type, IN_WATER, MOTION_BLOCKING, SpawnEvents::always, REPLACE);
	}
	public static <T extends Entity> void registerWaterSpawn(SpawnPlacementRegisterEvent e, EntityType<T> type, SpawnPredicate<T> predicate) {
		e.register(type, IN_WATER, MOTION_BLOCKING, predicate, REPLACE);
	}
	public static void registerLavaSpawn(SpawnPlacementRegisterEvent e, EntityType<? extends Mob> type) {
		e.register(type, IN_LAVA, MOTION_BLOCKING, SpawnEvents::always, REPLACE);
	}
    public static void registerAirSpawn(SpawnPlacementRegisterEvent e, EntityType<? extends Mob> type) {
    	e.register(type, NO_RESTRICTIONS, MOTION_BLOCKING, SpawnEvents::always, REPLACE);
    }
    public static <T extends Mob> void registerAirSpawn(SpawnPlacementRegisterEvent e, EntityType<T> type, SpawnPredicate<T> predicate) {
    	e.register(type, NO_RESTRICTIONS, MOTION_BLOCKING, predicate, REPLACE);
    }
    public static void registerDarkAirSpawn(SpawnPlacementRegisterEvent e, EntityType<? extends Mob> type) {
    	e.register(type, NO_RESTRICTIONS, MOTION_BLOCKING, SpawnEvents::checkDarknessSpawnRules, REPLACE);
    }
    public static void registerPassiveAirSpawn(SpawnPlacementRegisterEvent e, EntityType<? extends Mob> type) {
    	e.register(type, NO_RESTRICTIONS, MOTION_BLOCKING, SpawnEvents::always, REPLACE);
    }
    public static void registerMobSpawn(SpawnPlacementRegisterEvent e, EntityType<? extends Mob> type) {
    	e.register(type, ON_GROUND, MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, REPLACE);
    }
    public static void registerMonsterSpawn(SpawnPlacementRegisterEvent e, EntityType<? extends Monster> type) {
    	e.register(type, ON_GROUND, MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules, REPLACE);
    }
    public static void registerDarkSpawn(SpawnPlacementRegisterEvent e, EntityType<? extends Monster> type) {
    	e.register(type, ON_GROUND, MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, REPLACE);
    }
    public static void registerSurfaceSpawn(SpawnPlacementRegisterEvent e, EntityType<? extends Mob> type) {
    	e.register(type, ON_GROUND, MOTION_BLOCKING_NO_LEAVES, SpawnEvents::onSurface, REPLACE);
    }
    public static void registerSurfaceMonsterSpawn(SpawnPlacementRegisterEvent e, EntityType<? extends Monster> type) {
    	e.register(type, ON_GROUND, MOTION_BLOCKING_NO_LEAVES, SpawnEvents::monsterOnSurface, REPLACE);
    }
    public static void registerAgileSurfaceMonsterSpawn(SpawnPlacementRegisterEvent e, EntityType<? extends Monster> type) {
    	e.register(type, ON_GROUND, MOTION_BLOCKING, SpawnEvents::monsterOnSurface, REPLACE);
    }
	public static boolean always(EntityType<? extends Entity> e, ServerLevelAccessor l, MobSpawnType t, BlockPos p, RandomSource r) {
		Difficulty difficulty = l.getDifficulty();
		EnumMap<Difficulty, Integer> cancellationChances = new EnumMap<>(Map.of(
				Difficulty.EASY, 6,
				Difficulty.NORMAL, 4,
				Difficulty.HARD, 2
		));
		int cancelChance = cancellationChances.getOrDefault(difficulty, 0);

		return r.nextInt(10) >= cancelChance;
	}
	public static boolean checkDarknessSpawnRules(EntityType<? extends Mob> e, ServerLevelAccessor s, MobSpawnType t, BlockPos p, RandomSource r) {
		Difficulty difficulty = s.getDifficulty();
		EnumMap<Difficulty, Integer> cancellationChances = new EnumMap<>(Map.of(
				Difficulty.EASY, 6,
				Difficulty.NORMAL, 4,
				Difficulty.HARD, 2
		));
		int cancelChance = cancellationChances.getOrDefault(difficulty, 0);
		return r.nextInt(10) >= cancelChance && Monster.isDarkEnoughToSpawn(s, p, r);
	}
	public static boolean onSurface(EntityType<? extends Mob> e, ServerLevelAccessor s, MobSpawnType t, BlockPos p, RandomSource r) {
		Difficulty difficulty = s.getDifficulty();
		EnumMap<Difficulty, Integer> cancellationChances = new EnumMap<>(Map.of(
				Difficulty.EASY, 6,
				Difficulty.NORMAL, 4,
				Difficulty.HARD, 2
		));
		int cancelChance = cancellationChances.getOrDefault(difficulty, 0);
		return r.nextInt(10) >= cancelChance && Mob.checkMobSpawnRules(e, s, t, p, r) && s.canSeeSky(p);
	}
	public static boolean monsterOnSurface(EntityType<? extends Monster> e, ServerLevelAccessor s, MobSpawnType t, BlockPos p, RandomSource r) {
		Difficulty difficulty = s.getDifficulty();
		EnumMap<Difficulty, Integer> cancellationChances = new EnumMap<>(Map.of(
				Difficulty.EASY, 6,
				Difficulty.NORMAL, 4,
				Difficulty.HARD, 2
		));
		int cancelChance = cancellationChances.getOrDefault(difficulty, 0);
		return r.nextInt(10) >= cancelChance && Monster.checkAnyLightMonsterSpawnRules(e, s, t, p, r) && s.canSeeSky(p);
	}
    @SubscribeEvent
    public void addVanillaMobGoals(EntityJoinLevelEvent event) {
        if(event.getEntity() instanceof Turtle) {
            Turtle turtle = (Turtle) event.getEntity();
            turtle.goalSelector.addGoal(3, new NearestAttackableTargetGoal<>(turtle, EntityAequorea.class, false));
            turtle.goalSelector.addGoal(3, new TurtleEatAequorea(turtle, turtle.getAttributeValue(Attributes.FOLLOW_RANGE), false));
        }
    }
}
