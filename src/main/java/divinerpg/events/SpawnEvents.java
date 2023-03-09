package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.entities.ai.TurtleEatAequorea;
import divinerpg.entities.arcana.*;
import divinerpg.entities.iceika.*;
import divinerpg.entities.vanilla.overworld.*;
import divinerpg.entities.vethea.EntityTheHunger;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.SpawnPlacements.SpawnPredicate;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.*;

import static divinerpg.registries.EntityRegistry.*;
import static net.minecraft.world.entity.SpawnPlacements.Type.*;
import static net.minecraft.world.level.levelgen.Heightmap.Types.*;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpawnEvents {
    @SubscribeEvent
    public static void registerEntitySpawnPlacements(FMLCommonSetupEvent event) {
    	//Boss
    	registerSpawn(AYERACO.get());
    	
    	//Overworld
    	registerWaterSpawn(AEQUOREA.get());
    	registerMonsterSpawn(ARID_WARRIOR.get());
    	registerSpawn(BROWN_GRIZZLE.get());
    	registerDarkSpawn(CAVE_CRAWLER.get());
    	registerSpawn(CAVECLOPS.get(), EntityCaveclops::caveClopsSpawnRule);
    	registerMobSpawn(CRAB.get());
    	registerSpawn(CYCLOPS.get(), EntityKobblin::kobblinSpawnRule);
		registerMonsterSpawn(DESERT_CRAWLER.get());
		registerSpawn(DIAMOND_DAVE.get(), EntityDiamondDave::rules);
    	registerSpawn(EHU.get());
    	registerSpawn(ENTHRALLED_DRAMCRYX.get(), EntityEnthralledDramcryx::enthralledDramcryxSpawnRule);
    	registerAirSpawn(FROST.get());
    	registerMonsterSpawn(GLACON.get());
    	registerSpawn(HUSK.get());
    	registerSpawn(JACK_O_MAN.get(), EntityJackOMan::rules);
    	registerAirSpawn(JUNGLE_BAT.get());
    	registerAgileSpawn(JUNGLE_DRAMCRYX.get());
    	registerAgileSpawn(JUNGLE_SPIDER.get());
    	registerMonsterSpawn(KING_CRAB.get());
    	registerSpawn(KOBBLIN.get(), EntityKobblin::kobblinSpawnRule);
		registerLiopleurodon(LIOPLEURODON.get());
		registerSpawn(LIVESTOCK_MERCHANT.get(), EntityLivestockMerchant::rules);
    	registerDarkSpawn(MINER.get());
    	registerSpawn(PUMPKIN_SPIDER.get(), EntityKobblin::kobblinSpawnRule);
    	registerAirSpawn(RAINBOUR.get());
    	registerSpawn(ROTATICK.get(), EntityRotatick::rotatickSpawnRule);
    	registerSpawn(SAGUARO_WORM.get(), EntitySaguaroWorm::saguaroWormSpawnRule);
    	registerWaterSpawn(SHARK.get());
    	registerSpawn(SMELTER.get());
    	registerSpawn(SNAPPER.get());
    	registerSpawn(STONE_GOLEM.get());
    	registerSpawn(THE_EYE.get(), EntityTheEye::theEyeSpawnRule);
    	registerSpawn(THE_GRUE.get(), EntityTheGrue::theGrueSpawnRule);
    	registerWaterSpawn(WHALE.get());
    	registerSpawn(WHITE_GRIZZLE.get());

        //Nether
    	registerAirSpawn(HELL_BAT.get());
    	registerMobSpawn(HELL_PIG.get());
    	registerAgileSpawn(HELL_SPIDER.get());
    	registerAirSpawn(SCORCHER.get());
    	registerMonsterSpawn(WILDFIRE.get());

        //End
    	registerAgileSpawn(ENDER_SPIDER.get());
    	registerAirSpawn(ENDER_TRIPLETS.get());
    	registerMonsterSpawn(ENDER_WATCHER.get());

        //Iceika
    	registerAirSpawn(ALICANTO.get());
    	registerAirSpawn(FRACTITE.get());
    	registerMonsterSpawn(FROST_ARCHER.get());
    	registerMonsterSpawn(FROSTY.get());
    	registerMonsterSpawn(GLACIDE.get());
    	registerMonsterSpawn(HASTREUS.get());
    	registerMonsterSpawn(ROLLUM.get());
    	registerSpawn(WORKSHOP_MERCHANT.get(), EntityWorkshopMerchant::rules);
		registerSpawn(WORKSHOP_TINKERER.get(), EntityWorkshopTinkerer::rules);
		registerMonsterSpawn(SENG.get());
		registerMonsterSpawn(GROGLIN.get());
		registerMonsterSpawn(GRUZZORLUG.get());
		registerMonsterSpawn(SABEAR.get());
		registerRobinSpawn(ROBIN.get());
		registerMonsterSpawn(WOLPERTINGER.get());

        //Eden
    	registerMobSpawn(GLINTHOP.get());
    	registerMonsterSpawn(EDEN_CADILLION.get());
    	registerMonsterSpawn(EDEN_TOMO.get());
    	registerDarkSpawn(GREENFEET.get());
    	registerDarkSpawn(MADIVEL.get());
    	registerMonsterSpawn(SUN_ARCHER.get());
    	registerAirSpawn(WEAK_CORI.get());

        //Wildwood
    	registerMonsterSpawn(BEHEMOTH.get());
    	registerMobSpawn(EPIPHITE.get());
    	registerMonsterSpawn(MAGE.get());
    	registerMobSpawn(MOON_WOLF.get());
    	registerMonsterSpawn(TERMID.get());
    	registerMonsterSpawn(VEREK.get());
    	registerMonsterSpawn(WILDWOOD_CADILLION.get());
    	registerMonsterSpawn(WILDWOOD_GOLEM.get());
    	registerMonsterSpawn(WILDWOOD_TOMO.get());

        //Apalachia
    	registerMonsterSpawn(APALACHIA_CADILLION.get());
    	registerMonsterSpawn(APALACHIA_GOLEM.get());
    	registerMonsterSpawn(APALACHIA_TOMO.get());
    	registerMonsterSpawn(ENCHANTED_ARCHER.get());
    	registerMonsterSpawn(ENCHANTED_WARRIOR.get());
    	registerMonsterSpawn(SPELLBINDER.get());

        //Skythern
    	registerAirSpawn(ADVANCED_CORI.get());
    	registerMonsterSpawn(MEGALITH.get());
    	registerMonsterSpawn(MYSTIC.get());
    	registerMonsterSpawn(SAMEK.get());
    	registerMonsterSpawn(SKYTHERN_ARCHER.get());
    	registerMonsterSpawn(SKYTHERN_FIEND.get());
    	registerMonsterSpawn(SKYTHERN_GOLEM.get());

        //Mortum
    	registerMonsterSpawn(ANGRY_GLINTHOP.get());
    	registerMonsterSpawn(BASILISK.get());
    	registerMonsterSpawn(DEMON_OF_DARKNESS.get());
    	registerMonsterSpawn(MORTUM_CADILLION.get());
    	registerMonsterSpawn(SORCERER.get());
    	registerMonsterSpawn(SOUL_SPIDER.get());
    	registerMonsterSpawn(SOUL_STEALER.get());
    	registerMonsterSpawn(TWILIGHT_ARCHER.get());

        //Arcana
    	registerSpawn(CAPTAIN_MERIK.get(), EntityCaptainMerik::rules);
    	registerSpawn(DATTICON.get(), EntityCaptainMerik::rules);
    	registerMonsterSpawn(DEATHCRYX.get());
    	registerMonsterSpawn(DEATH_HOUND.get());
    	registerMonsterSpawn(DUNGEON_CONSTRUCTOR.get());
    	registerMonsterSpawn(DUNGEON_DEMON.get());
    	registerMonsterSpawn(DUNGEON_PRISONER.get());
    	registerSpawn(FYRACRYX.get());
    	registerSpawn(GOLEM_OF_REJUVENATION.get());
    	registerSpawn(KAZARI.get(), EntityKazari::rules);
    	registerSpawn(LEORNA.get(), EntityLeorna::rules);
    	registerSpawn(LORD_VATTICUS.get(), EntityLordVatticus::rules);
    	registerMonsterSpawn(LIVING_STATUE.get());
    	registerSpawn(PARATIKU.get());
    	registerMonsterSpawn(RAZORBACK.get());
    	registerMonsterSpawn(ROAMER.get());
    	registerSpawn(SEIMER.get());
    	registerMonsterSpawn(SKYRE.get());
    	registerSpawn(WAR_GENERAL.get(), EntityWarGeneral::rules);
    	registerSpawn(WRAITH.get());
    	registerSpawn(ZELUS.get(), EntityZelus::rules);

        //Vethea
    	registerMonsterSpawn(ACID_HAG.get());
    	registerMonsterSpawn(BIPHRON.get());
    	registerMonsterSpawn(BOHEMITE.get());
    	registerMobSpawn(CRYPT_KEEPER.get());
    	registerMonsterSpawn(CYMESOID.get());
    	registerAirSpawn(DISSIMENT.get());
    	registerMonsterSpawn(DREAMWRECKER.get());
    	registerMonsterSpawn(DUO.get());
    	registerMonsterSpawn(ENT.get());
    	registerMonsterSpawn(FAKE_VHRAAK.get());
    	registerMonsterSpawn(GALROID.get());
    	registerMonsterSpawn(GORGOSION.get());
    	registerMonsterSpawn(HELIO.get());
    	registerMonsterSpawn(HIVE_SOLDIER.get());
    	registerDarkSpawn(HOVER_STINGER.get());
    	registerMonsterSpawn(KAZROTIC.get());
    	registerMonsterSpawn(LHEIVA.get());
    	registerMonsterSpawn(LORGA.get());
    	registerAirSpawn(LORGA_FLIGHT.get());
    	registerMonsterSpawn(MANDRAGORA.get());
    	registerMobSpawn(MYSTERIOUS_MAN_LAYER1.get());
    	registerMobSpawn(MYSTERIOUS_MAN_LAYER2.get());
    	registerMobSpawn(MYSTERIOUS_MAN_LAYER3.get());
    	registerMonsterSpawn(SHADAHIER.get());
    	registerMobSpawn(TEMPLE_GUARDIAN.get());
    	registerSpawn(THE_HUNGER.get(), EntityTheHunger::rules);
    	registerMonsterSpawn(TOCAXIN.get());
    	registerMonsterSpawn(TWINS.get());
    	registerMonsterSpawn(VERMENOUS.get());
    	registerMonsterSpawn(VHRAAK.get());
    	registerMonsterSpawn(ZONE.get());
    	registerAirSpawn(ZORAGON.get());
    }


	public static void registerSpawn(EntityType<? extends Mob> type) {
    	SpawnPlacements.register(type, ON_GROUND, MOTION_BLOCKING_NO_LEAVES, SpawnEvents::always);
    }
    public static <T extends Mob> void registerSpawn(EntityType<T> type, SpawnPredicate<T> predicate) {
    	SpawnPlacements.register(type, ON_GROUND, MOTION_BLOCKING_NO_LEAVES, predicate);
    }
    public static void registerAgileSpawn(EntityType<? extends Monster> type) {
    	SpawnPlacements.register(type, ON_GROUND, MOTION_BLOCKING, Monster::checkAnyLightMonsterSpawnRules);
    }
	public static void registerWaterSpawn(EntityType<? extends Mob> type) {
		SpawnPlacements.register(type, IN_WATER, MOTION_BLOCKING, SpawnEvents::always);
	}
	public static void registerLiopleurodon(EntityType<? extends Mob> type) {
		SpawnPlacements.register(type, IN_WATER, MOTION_BLOCKING, SpawnEvents::liopleurodon);
	}
	public static void registerLavaSpawn(EntityType<? extends Mob> type) {
		SpawnPlacements.register(type, IN_LAVA, MOTION_BLOCKING, SpawnEvents::always);
	}

	public static void registerRobinSpawn(EntityType<? extends Mob> type) {
		SpawnPlacements.register(type, NO_RESTRICTIONS, MOTION_BLOCKING, SpawnEvents::always);
	}
    public static void registerAirSpawn(EntityType<? extends Mob> type) {
    	SpawnPlacements.register(type, ON_GROUND, MOTION_BLOCKING, Mob::checkMobSpawnRules);
    }
    public static void registerMobSpawn(EntityType<? extends Mob> type) {
    	SpawnPlacements.register(type, ON_GROUND, MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
    }
    public static void registerMonsterSpawn(EntityType<? extends Monster> type) {
    	SpawnPlacements.register(type, ON_GROUND, MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules);
    }
    public static void registerDarkSpawn(EntityType<? extends Monster> type) {
    	SpawnPlacements.register(type, ON_GROUND, MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
    }
	public static boolean always(EntityType<? extends Mob> typeIn, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
		return true;
	}
	public static boolean liopleurodon(EntityType<? extends Mob> typeIn, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
		List<Entity> entities = worldIn.getEntities(null, new AABB(pos.offset(-48, -48, -48), pos.offset(48, 48, 48)));
		List<EntityLiopleurodon> liopleurodon = new ArrayList<>();
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i) instanceof EntityLiopleurodon) {
				EntityLiopleurodon liopleurodonMob = (EntityLiopleurodon) entities.get(i);
				liopleurodon.add(liopleurodonMob);
			}
		}
		if (liopleurodon.size() < 2) {
			return true;
		}
		return false;
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
