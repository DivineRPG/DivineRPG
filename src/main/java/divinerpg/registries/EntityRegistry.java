package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.client.models.ModelHat;
import divinerpg.client.models.arcana.*;
import divinerpg.client.models.block.*;
import divinerpg.client.models.boss.*;
import divinerpg.client.models.iceika.*;
import divinerpg.client.models.twilight.*;
import divinerpg.client.models.vanilla.*;
import divinerpg.client.models.vethea.*;
import divinerpg.client.renders.base.*;
import divinerpg.client.renders.entity.boss.*;
import divinerpg.client.renders.entity.iceika.*;
import divinerpg.client.renders.entity.projectile.*;
import divinerpg.client.renders.entity.twilight.*;
import divinerpg.client.renders.entity.vanilla.*;
import divinerpg.client.renders.entity.vethea.RenderGalroid;
import divinerpg.client.renders.tiles.RenderNightmareBed;
import divinerpg.entities.apalachia.*;
import divinerpg.entities.arcana.*;
import divinerpg.entities.base.*;
import divinerpg.entities.boss.*;
import divinerpg.entities.eden.*;
import divinerpg.entities.iceika.*;
import divinerpg.entities.iceika.groglin.*;
import divinerpg.entities.iceika.gruzzorlug.*;
import divinerpg.entities.mortum.*;
import divinerpg.entities.projectile.*;
import divinerpg.entities.skythern.*;
import divinerpg.entities.vanilla.end.*;
import divinerpg.entities.vanilla.nether.*;
import divinerpg.entities.vanilla.overworld.*;
import divinerpg.entities.vethea.*;
import divinerpg.entities.wildwood.*;
import divinerpg.enums.EntityStats;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.EntityType.EntityFactory;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.*;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.util.ClientUtils.*;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);
    private EntityRegistry(){}

    //Projectiles
    public static final RegistryObject<EntityType<EntityAttractor>>				 ATTRACTOR = registerProjectile(EntityAttractor::new,                               "attractor");
    public static final RegistryObject<EntityType<EntityBouncingProjectile>>	 BOUNCING_PROJECTILE = registerProjectile(EntityBouncingProjectile::new,            "bouncing_projectile");
    public static final RegistryObject<EntityType<EntityCaveRock>>				 CAVE_ROCK = registerProjectile(EntityCaveRock::new,                                "cave_rock");
    public static final RegistryObject<EntityType<EntityColoredBullet>>			 COLORED_BULLET = registerProjectile(EntityColoredBullet::new,                      "colored_bullet");
    public static final RegistryObject<EntityType<EntityCoriShot>>				 CORI_SHOT = registerProjectile(EntityCoriShot::new,                                "cori_shot");
    public static final RegistryObject<EntityType<EntityCorruptedBullet>>		 CORRUPTED_BULLET = registerProjectile(EntityCorruptedBullet::new,                  "corrupted_bullet");
    public static final RegistryObject<EntityType<EntityDisk>>					 DISK = registerProjectile(EntityDisk::new,                                         "disk");
    public static final RegistryObject<EntityType<EntityDissimentShot>>			 DISSIMENT_SHOT = registerProjectile(EntityDissimentShot::new,                      "dissiment_shot");
    public static final RegistryObject<EntityType<EntityDivineArrow>>			 ARROW_SHOT = registerArrowProjectile(EntityDivineArrow::new,                       "arrow_shot");
    public static final RegistryObject<EntityType<EntityEnderTripletsFireball>>  ENDER_TRIPLETS_FIREBALL = registerFireballProjectile(EntityEnderTripletsFireball::new, "ender_triplets_fireball");
    public static final RegistryObject<EntityType<EntityFirefly>>				 FIREFLY = registerProjectile(EntityFirefly::new,                                   "firefly");
    public static final RegistryObject<EntityType<EntityFractiteShot>>			 FRACTITE_SHOT = registerFireballProjectile(EntityFractiteShot::new,                "fractite_shot");
    public static final RegistryObject<EntityType<EntityFrostCloud>>			 FROST_CLOUD = registerFrostCloud(EntityFrostCloud::new,                            "frost_cloud");
    public static final RegistryObject<EntityType<EntityFrostShot>>				 FROST_SHOT = registerFireballProjectile(EntityFrostShot::new,                      "frost_shot");
    public static final RegistryObject<EntityType<EntityFyracryxFireball>>		 FYRACRYX_FIREBALL = registerFireballProjectile(EntityFyracryxFireball::new,        "fyracryx_fireball");
    public static final RegistryObject<EntityType<EntityGeneralsStaff>>			 GENERALS_STAFF = registerProjectile(EntityGeneralsStaff::new,                      "generals_staff");
    public static final RegistryObject<EntityType<EntityGrenade>>				 GRENADE = registerProjectile(EntityGrenade::new,                                   "grenade");
    public static final RegistryObject<EntityType<EntityKazroticShot>>			 KAZROTIC_SHOT = registerProjectile(EntityKazroticShot::new,                        "kazrotic_shot");
    public static final RegistryObject<EntityType<EntityKingOfScorchersMeteor>>  KING_OF_SCORCHERS_METEOR = registerProjectile(EntityKingOfScorchersMeteor::new,    "king_of_scorchers_meteor");
    public static final RegistryObject<EntityType<EntityKingOfScorchersShot>>	 KING_OF_SCORCHERS_SHOT = registerProjectile(EntityKingOfScorchersShot::new,        "king_of_scorchers_shot");
    public static final RegistryObject<EntityType<EntityLadyLunaSparkler>>		 LADY_LUNA_SPARKLER = registerProjectile(EntityLadyLunaSparkler::new,               "lady_luna_sparkler");
    public static final RegistryObject<EntityType<EntityTwilightMageShot>>		 MAGE_SHOT = registerProjectile(EntityTwilightMageShot::new,                        "mage_shot");
    public static final RegistryObject<EntityType<EntityMandragoraProjectile>>	 MANDRAGORA_PROJECTILE = registerProjectile(EntityMandragoraProjectile::new,        "mandragora_projectile");
    public static final RegistryObject<EntityType<EntityMerikMissile>>			 MERIKS_MISSILE = registerProjectile(EntityMerikMissile::new,                       "meriks_missile");
    public static final RegistryObject<EntityType<EntityMeteor>>				 METEOR = registerProjectile(EntityMeteor::new,                                     "meteor");
    public static final RegistryObject<EntityType<EntityParticleBullet>>		 PARTICLE_BULLET = registerProjectile(EntityParticleBullet::new,                    "particle_bullet");
    public static final RegistryObject<EntityType<EntityRaglokBomb>>			 RAGLOK_BOMB = registerProjectile(EntityRaglokBomb::new,                            "raglok_bomb");
    public static final RegistryObject<EntityType<EntityReflector>>				 REFLECTOR = registerProjectile(EntityReflector::new,                               "reflector");
    public static final RegistryObject<EntityType<EntitySaguaroWormShot>>		 SAGUARO_WORM_SHOT = registerProjectile(EntitySaguaroWormShot::new,                 "saguaro_worm_shot");
    public static final RegistryObject<EntityType<EntityScorcherShot>>			 SCORCHER_SHOT = registerFireballProjectile(EntityScorcherShot::new,                "scorcher_shot");
    public static final RegistryObject<EntityType<EntitySerenadeOfDeath>>		 SERENADE_OF_DEATH = registerProjectile(EntitySerenadeOfDeath::new,                 "serenade_of_death");
    public static final RegistryObject<EntityType<EntitySerenadeOfIce>>			 SERENADE_OF_ICE = registerProjectile(EntitySerenadeOfIce::new,                     "serenade_of_ice");
    public static final RegistryObject<EntityType<EntityShooterBullet>>			 SHOOTER_BULLET = registerProjectile(EntityShooterBullet::new,                      "shooter_bullet");
    public static final RegistryObject<EntityType<EntityShuriken>>				 SHURIKEN = registerProjectile(EntityShuriken::new,                                 "shuriken");
    public static final RegistryObject<EntityType<EntitySkyreBullet>>			 SKYRE_BULLET = registerProjectile(EntitySkyreBullet::new,                          "skyre_bullet");
    public static final RegistryObject<EntityType<EntitySnowflakeShuriken>>		 SNOWFLAKE_SHURIKEN = registerProjectile(EntitySnowflakeShuriken::new,              "snowflake_shuriken");
    public static final RegistryObject<EntityType<EntitySoulFiendShot>>			 SOUL_FIEND_SHOT = registerProjectile(EntitySoulFiendShot::new,                     "soul_fiend_shot");
    public static final RegistryObject<EntityType<EntitySoundOfCarols>>			 SOUND_OF_CAROLS = registerProjectile(EntitySoundOfCarols::new,                     "sound_of_carols");
    public static final RegistryObject<EntityType<EntitySoundOfMusic>>			 SOUND_OF_MUSIC = registerProjectile(EntitySoundOfMusic::new,                       "sound_of_music");
    public static final RegistryObject<EntityType<EntitySoundOfWhales>>			 SOUND_OF_WHALES = registerProjectile(EntitySoundOfWhales::new,                     "sound_of_whales");
    public static final RegistryObject<EntityType<EntitySparkler>>				 SPARKLER = registerProjectile(EntitySparkler::new,                                 "sparkler");
    public static final RegistryObject<EntityType<EntityStar>>					 STARLIGHT = registerProjectile(EntityStar::new,                                    "star");
    public static final RegistryObject<EntityType<EntityTomato>>			     TOMATO = registerProjectile(EntityTomato::new,                                     "tomato");
    public static final RegistryObject<EntityType<EntityTwilightDemonShot>>		 TWILIGHT_DEMON_SHOT = registerProjectile(EntityTwilightDemonShot::new,             "twilight_demon_shot");
    public static final RegistryObject<EntityType<EntityTwilightMageShot>>		 TWILIGHT_MAGE_SHOT = registerProjectile(EntityTwilightMageShot::new,               "twilight_mage_shot");
    public static final RegistryObject<EntityType<EntityVileStorm>>				 VILE_STORM = registerProjectile(EntityVileStorm::new,                              "vile_storm");
    public static final RegistryObject<EntityType<EntityWatcherShot>>			 WATCHER_SHOT = registerProjectile(EntityWatcherShot::new,                          "watcher_shot");
    public static final RegistryObject<EntityType<EntityWildwoodLog>>			 WILDWOOD_LOG = registerProjectile(EntityWildwoodLog::new,                          "wildwood_log");
    public static final RegistryObject<EntityType<EntityWreckBouncingProjectile>>WRECK_BOUNCING_PROJECTILE = registerProjectile(EntityWreckBouncingProjectile::new, "wreck_bouncing_projectile");
    public static final RegistryObject<EntityType<EntityWreckExplosiveShot>>	 WRECK_EXPLOSIVE_SHOT = registerProjectile(EntityWreckExplosiveShot::new,           "wreck_explosive_shot");
    public static final RegistryObject<EntityType<EntityWreckShot>>				 WRECK_SHOT = registerProjectile(EntityWreckShot::new,                              "wreck_shot");
    public static final RegistryObject<EntityType<EntityZoragonBomb>>			 ZORAGON_BOMB = registerProjectile(EntityZoragonBomb::new,                          "zoragon_bomb");

    //Bosses
    public static final RegistryObject<EntityType<EntityAncientEntity>>      ANCIENT_ENTITY 	 = registerEntity(EntityAncientEntity::new, 	"ancient_entity", 	    4.0F, 6.5F);
    public static final RegistryObject<EntityType<EntityTheWatcher>>	     THE_WATCHER 		 = registerEntity(EntityTheWatcher::new, 	    "the_watcher", 		    3.875F, 4.875F);
    public static final RegistryObject<EntityType<EntityKingOfScorchers>>    KING_OF_SCORCHERS 	 = registerEntity(EntityKingOfScorchers::new,   "king_of_scorchers",      2.0F, 2.5F);
    public static final RegistryObject<EntityType<EntityKitra>>              KITRA               = registerEntity(EntityKitra::new,             "kitra",                  3.0F, 2.0F, 0x7a8383, 0xb6f0f0, MobCategory.WATER_CREATURE);
    public static final RegistryObject<EntityType<EntityAyeraco>>		     AYERACO			 = registerEntity(EntityAyeraco::new,		    "ayeraco",			    2.0F, 1.2F);
    public static final RegistryObject<EntityType<EntityDramix>>		     DRAMIX 			 = registerEntity(EntityDramix::new, 		    "dramix", 			    0.85F,2.5625F);
    public static final RegistryObject<EntityType<EntityParasecta>>		     PARASECTA 			 = registerEntity(EntityParasecta::new, 		"parasecta", 	        	1.3F, 2.0F);
    public static final RegistryObject<EntityType<EntitySunstorm>>		     SUNSTORM 			 = registerEntity(EntitySunstorm::new, 		    "sunstorm", 		        1.7F, 3.4375F);
    public static final RegistryObject<EntityType<EntityTermasect>>		     TERMASECT 			 = registerEntity(EntityTermasect::new, 		"termasect", 		        5.9F, 8.0F);
    public static final RegistryObject<EntityType<EntityEternalArcher>>      ETERNAL_ARCHER 	 = registerEntity(EntityEternalArcher::new,  	"eternal_archer",       	3.0F, 5.0F);
    public static final RegistryObject<EntityType<EntityExperiencedCori>>    EXPERIENCED_CORI 	 = registerEntity(EntityExperiencedCori::new,   "experienced_cori",       4.0F, 7.1875F);
    public static final RegistryObject<EntityType<EntityVamacheron>>	     VAMACHERON 		 = registerEntity(EntityVamacheron::new, 	    "vamacheron", 		    1.45F,2.25F);
    public static final RegistryObject<EntityType<EntityKarot>>			     KAROT 				 = registerEntity(EntityKarot::new, 			"karot", 			        3.0F,4.1875F);
    public static final RegistryObject<EntityType<EntityTwilightDemon>>      TWILIGHT_DEMON 	 = registerEntity(EntityTwilightDemon::new,  	"twilight_demon", 	    2.0F, 4.0F);
    public static final RegistryObject<EntityType<EntityDensos>>		     DENSOS 			 = registerEntity(EntityDensos::new, 		    "densos", 			    1.0F, 2.5F);
    public static final RegistryObject<EntityType<EntityReyvor>>		     REYVOR 			 = registerEntity(EntityReyvor::new, 		    "reyvor", 			    1.0F, 2.5F);
    public static final RegistryObject<EntityType<EntitySoulFiend>>		     SOUL_FIEND 		 = registerEntity(EntitySoulFiend::new, 		"soul_fiend", 	    	0.8F, 2.0F);
    public static final RegistryObject<EntityType<EntityHiveQueen>>		     HIVE_QUEEN 		 = registerEntity(EntityHiveQueen::new, 		"hive_queen", 		    1.5F, 0.75F);
    public static final RegistryObject<EntityType<EntityKaros>>			     KAROS 				 = registerEntity(EntityKaros::new, 			"karos", 			        1.0F, 2.6875F);
    public static final RegistryObject<EntityType<EntityLadyLuna>>		     LADY_LUNA 			 = registerEntity(EntityLadyLuna::new, 		    "lady_luna", 		        1.0F, 3.25F);
    public static final RegistryObject<EntityType<EntityQuadro>>		     QUADRO 			 = registerEntity(EntityQuadro::new, 		    "quadro", 		    	1.2F, 2.2F);
    public static final RegistryObject<EntityType<EntityRaglok>>		     RAGLOK 			 = registerEntity(EntityRaglok::new, 		    "raglok", 		    	3.0F, 5.25F);
    public static final RegistryObject<EntityType<EntityWreck>>			     WRECK 				 = registerEntity(EntityWreck::new, 			"wreck", 			        1.5F, 2.0F);

    //Overworld
    public static final RegistryObject<EntityType<EntityLivestockMerchant>>  LIVESTOCK_MERCHANT  = registerEntity(EntityLivestockMerchant::new, "livestock_merchant", 	0.8F, 2.0f, 0x213c56, 0xa27d6a, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityJackOMan>>			 JACK_O_MAN 		 = registerEntity(EntityJackOMan::new, 			"jack_o_man", 			0.8F, 2.0F, 0x3d2322, 0xe3901d, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityCyclops>>			 CYCLOPS 			 = registerEntity(EntityCyclops::new, 			"cyclops", 				1.2F, 4.0F, 0x352a1f, 0x877e47);
    public static final RegistryObject<EntityType<EntityKobblin>>			 KOBBLIN 			 = registerEntity(EntityKobblin::new, 			"kobblin", 				0.75F,1.0F, 0x79553a, 0x73b349);
    public static final RegistryObject<EntityType<EntityPumpkinSpider>>		 PUMPKIN_SPIDER 	 = registerEntity(EntityPumpkinSpider::new, 	"pumpkin_spider", 		1.4F,1.0F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityRainbour>>			 RAINBOUR 			 = registerEntity(EntityRainbour::new, 			"rainbour", 			    1.0F, 1.0F, 0xffffff, 0xffffff, MobCategory.CREATURE);

    //Jungle
    public static final RegistryObject<EntityType<EntityJungleBat>>			 JUNGLE_BAT 		 = registerEntity(EntityJungleBat::new, 		"jungle_bat", 			0.7F, 1.0F, 0x1f360b, 0x6d9856, MobCategory.AMBIENT);
    public static final RegistryObject<EntityType<EntityJungleSpider>>		 JUNGLE_SPIDER 		 = registerEntity(EntityJungleSpider::new, 		"jungle_spider", 		    1.4F, 0.9F, 0x176b07, 0x0026ff);
    public static final RegistryObject<EntityType<EntityJungleDramcryx>>	 JUNGLE_DRAMCRYX 	 = registerEntity(EntityJungleDramcryx::new, 	"jungle_dramcryx", 		1.0F, 1.4375F, 0xffffff, 0xffffff);

    //Desert
    public static final RegistryObject<EntityType<EntitySaguaroWorm>> 		 SAGUARO_WORM 		 = registerEntity(EntitySaguaroWorm::new, 		"saguaro_worm", 	    	1.0F, 3.0F, 0x42651e, 0xd5d67d);
    public static final RegistryObject<EntityType<EntityDesertCrawler>>		 DESERT_CRAWLER 	 = registerEntity(EntityDesertCrawler::new, 	"desert_crawler", 	    0.9F, 0.94F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityAridWarrior>>		 ARID_WARRIOR 		 = registerEntity(EntityAridWarrior::new, 		"arid_warrior",			0.7F, 2.125f, 0xffffff, 0xffffff);

    //Snow
    public static final RegistryObject<EntityType<EntityGlacon>>			 GLACON 			 = registerEntity(EntityGlacon::new, 			"glacon", 				0.8F, 1.3125F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityFrost>>				 FROST 				 = registerEntity(EntityFrost::new, 			"frost", 			    	1.0F, 1.125F, 0xb9e5ff, 0xfffff4);

    //Beach
    public static final RegistryObject<EntityType<EntityCrab>>				 CRAB 				 = registerEntity(EntityCrab::new, 				"crab", 				    0.9F, 0.5625F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityKingCrab>>			 KING_CRAB 			 = registerEntity(EntityKingCrab::new, 			"king_crab", 			    1.8F, 1.4375F, 0xffffff, 0xffffff);

    //Water
    public static final RegistryObject<EntityType<EntityAequorea>>			 AEQUOREA 			 = registerEntity(EntityAequorea::new, 			"aequorea", 			    0.3F, 0.3125F, 0x79ab82, 0x7ae174, MobCategory.WATER_CREATURE);
    public static final RegistryObject<EntityType<EntityShark>>				 SHARK 				 = registerEntity(EntityShark::new, 			"shark", 				    1.0F, 0.75F, 0xffffff, 0xffffff, MobCategory.WATER_CREATURE);
    public static final RegistryObject<EntityType<EntityWhale>>				 WHALE 				 = registerEntity(EntityWhale::new, 			"whale", 				    3.0F, 1.875F, 0x638bb3, 0x273649, MobCategory.WATER_CREATURE);
    public static final RegistryObject<EntityType<EntityLiopleurodon>>		 LIOPLEURODON 		 = registerEntity(EntityLiopleurodon::new, 		"liopleurodon", 		    3.0F, 1.0f, 0x253a73, 0x6273a5, MobCategory.WATER_CREATURE);

    //Cave
    public static final RegistryObject<EntityType<EntityDiamondDave>>        DIAMOND_DAVE        = registerEntity(EntityDiamondDave::new, 	    "diamond_dave", 		    0.8F, 2F, 0xffffff, 0xffffff, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityMiner>>				 MINER 				 = registerEntity(EntityMiner::new, 			"miner", 				    0.6F, 2.0F, 0x7f5200, 0xe2e048);
    public static final RegistryObject<EntityType<EntityRotatick>>			 ROTATICK 			 = registerEntity(EntityRotatick::new, 			"rotatick", 			    0.85F, 0.8F,0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityCrawler>>			 CAVE_CRAWLER 		 = registerEntity(EntityCrawler::new, 			"cave_crawler", 		    0.75F, 1.0F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityCaveclops>>			 CAVECLOPS 			 = registerEntity(EntityCaveclops::new, 		"caveclops", 			    1.2F, 4.0F, 0x3a3030, 0x77352b);
    public static final RegistryObject<EntityType<EntityTheEye>>			 THE_EYE 			 = registerEntity(EntityTheEye::new, 			"the_eye", 				0.8F, 2.625F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityEnthralledDramcryx>> ENTHRALLED_DRAMCRYX = registerEntity(EntityEnthralledDramcryx::new,"enthralled_dramcryx",    1.35F,1.75F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityTheGrue>>			 THE_GRUE 			 = registerEntity(EntityTheGrue::new, 			"the_grue", 			    1.0F, 1.75F, 0xffffff, 0xffffff);

    //Livestock
    public static final RegistryObject<EntityType<EntitySnapper>>			 SNAPPER 			 = registerEntity(EntitySnapper::new, 			"snapper", 				1.1F, 0.8125F, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityEhu>>				 EHU 				 = registerEntity(EntityEhu::new, 				"ehu", 					0.75F, 0.78125F, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityHusk>>				 HUSK 				 = registerEntity(EntityHusk::new, 				"husk", 				    0.8F, 1.5F, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityBrownGrizzle>>		 BROWN_GRIZZLE 		 = registerEntity(EntityBrownGrizzle::new, 		"brown_grizzle", 		    0.8F, 1.25F, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityWhiteGrizzle>>		 WHITE_GRIZZLE 		 = registerEntity(EntityWhiteGrizzle::new, 		"white_grizzle", 		    0.8F, 1.25F, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityStoneGolem>>		 STONE_GOLEM 		 = registerEntity(EntityStoneGolem::new, 		"stone_golem", 			1.5F, 3.5F, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntitySmelter>>			 SMELTER 			 = registerEntity(EntitySmelter::new, 			"smelter", 				1.5F, 3.5F, MobCategory.CREATURE);

    //Nether
    public static final RegistryObject<EntityType<EntityHellPig>>	         HELL_PIG 	         = registerEntity(EntityHellPig::new, 	        "hell_pig", 	            0.9F, 1.15625F, 0xffffff, 0xffffff, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityHellSpider>>         HELL_SPIDER         = registerEntity(EntityHellSpider::new,        "hell_spider",            1.4F, 0.9F, 0xb01916, 0x720b07);
    public static final RegistryObject<EntityType<EntityWildfire>>	         WILDFIRE 	         = registerEntity(EntityWildfire::new, 	        "wildfire", 	            0.8F, 2.2F, 0xaa0b01, 0x9c6d11);
    public static final RegistryObject<EntityType<EntityScorcher>>	         SCORCHER 	         = registerEntity(EntityScorcher::new, 	        "scorcher", 	            1.2F, 1.875F, 0xffffff, 0xffffff);

    //End
    public static final RegistryObject<EntityType<EntityEnderScrounge>>      ENDER_SCROUNGE      = registerEntity(EntityEnderScrounge::new,     "ender_scrounge",         0.2F, 0.15F, 0x162916, 0xfc1b11, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityEnderSpider>>        ENDER_SPIDER        = registerEntity(EntityEnderSpider::new,       "ender_spider",           0.5F, 0.55F,0x0a0a0a, 0x260125);
    public static final RegistryObject<EntityType<EntityEnderWatcher>>       ENDER_WATCHER       = registerEntity(EntityEnderWatcher::new,      "ender_watcher",          0.7F, 0.8125F, 0x161616, 0xca1ae1);
    public static final RegistryObject<EntityType<EntityEnderTriplets>>      ENDER_TRIPLETS      = registerEntity(EntityEnderTriplets::new,     "ender_triplets",         2.0F, 2.0F, 0x161616, 0xfc1b28);

    //Iceika
    public static final RegistryObject<EntityType<EntityCauldronFish>>		CAULDRON_FISH		= registerEntity(EntityCauldronFish::new,		"cauldron_fish",		.5625F, .8125F, 0xffffff, 0xffffff, MobCategory.WATER_AMBIENT);
    public static final RegistryObject<EntityType<EntityBlubbertusk>>		BLUBBERTUSK			= registerEntity(EntityBlubbertusk::new,		"blubbertusk",			.85F, .875F, 0xffffff, 0xffffff, MobCategory.WATER_CREATURE);
    public static final RegistryObject<EntityType<EntityRobbin>>            ROBBIN              = registerEntity(EntityRobbin::new,            "robbin",                0.3F, 0.5625F, 0xffffff, 0xffffff, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityWolpertinger>>      WOLPERTINGER        = registerEntity(EntityWolpertinger::new,      "wolpertinger",          0.6F, 0.875F, 0xffffff, 0xffffff, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityDolossal>>			DOLOSSAL			= registerEntity(EntityDolossal::new,			"dolossal",				1.3F, 2F, 0x462630, 0x422742, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityMamoth>>			MAMOTH				= registerEntity(EntityMamoth::new,				"mamoth",				1.4F, 2F, 0x49302f, 0x87ffd3, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntitySnowSkipper>>		SNOW_SKIPPER		= registerEntity(EntitySnowSkipper::new,		"snow_skipper",			.5F, .5F, 0x3f3431, 0xcbf8f5, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityDivineWaterMob>>	PINK_GHOST_GLIDER	= registerEntity(EntityDivineWaterMob::new,		"pink_ghost_glider",	.5F, .5F, 0xbb94cf, 0xfafafa, MobCategory.WATER_AMBIENT);
    public static final RegistryObject<EntityType<EntityWorkshopMerchant>>  WORKSHOP_MERCHANT   = registerEntity(EntityWorkshopMerchant::new,  "workshop_merchant",     0.9F, 1.8125F, 0xffffff, 0xffffff, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityWorkshopTinkerer>>  WORKSHOP_TINKERER   = registerEntity(EntityWorkshopTinkerer::new,  "workshop_tinkerer",     0.9F, 1.8125F, 0xffffff, 0xffffff, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityPaleArcher>>	    PALE_ARCHER 	  	= registerEntity(EntityPaleArcher::new, 	   "pale_archer",	        0.6F, 1.9375F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityFrozenFlesh>>		FROZEN_FLESH 		= registerEntity(EntityFrozenFlesh::new, 	   "frozen_flesh",			0.65F, 1.75F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityRollum>>		    ROLLUM 				= registerEntity(EntityRollum::new, 		   "rollum",				1.2F, 2.0F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityAlicanto>>		    ALICANTO 		  	= registerEntity(EntityAlicanto::new,          "alicanto",		        0.85F, 1.3F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntitySeng>>              SENG                = registerEntity(EntitySeng::new,              "seng",                  0.9F, 1.0F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntitySabear>>            SABEAR              = registerEntity(EntitySabear::new,            "sabear",                1.3F, 1.4375F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityHastreus>>		    HASTREUS 		  	= registerEntity(EntityHastreus::new, 		   "hastreus",		        1.4F, 1.625F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityGlacide>>		    GLACIDE 		  	= registerEntity(EntityGlacide::new, 		   "glacide",			    1.4F, 2.0F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityFractite>>		    FRACTITE 		  	= registerEntity(EntityFractite::new, 		   "fractite",		        1.7F, 3.0F, 0xeeffff, 0xe2ffff);

    //Groglin
    public static final RegistryObject<EntityType<GroglinChieftain>>		GROGLIN_CHIEFTAIN	= registerEntity(GroglinChieftain::new,			"groglin_chieftain",	.5F, 1.375F, 0xffffff, 0xffffff, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<GroglinHunter>>		    GROGLIN_HUNTER	  	= registerEntity(GroglinHunter::new, 		    "groglin_hunter",		.5F, 1.375F, 0xffffff, 0xffffff, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<GroglinMerchant>>		    GROGLIN_MERCHANT	= registerEntity(GroglinMerchant::new, 		    "groglin_merchant",		.5F, 1.375F, 0xffffff, 0xffffff, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<GroglinRanger>>		    GROGLIN_RANGER	  	= registerEntity(GroglinRanger::new, 		    "groglin_ranger",		.5F, 1.375F, 0xffffff, 0xffffff, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<GroglinSharlatan>>		GROGLIN_SHARLATAN	= registerEntity(GroglinSharlatan::new, 		"groglin_sharlatan",	.5F, 1.375F, 0xffffff, 0xffffff, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<GroglinWarrior>>		    GROGLIN_WARRIOR	  	= registerEntity(GroglinWarrior::new, 		    "groglin_warrior",		.5F, 1.375F, 0xffffff, 0xffffff, MobCategory.CREATURE);

    //Gruzzorlug
    public static final RegistryObject<EntityType<GruzzorlugCannoneer>>    	GRUZZORLUG_CANNONEER= registerEntity(GruzzorlugCannoneer::new,     	"gruzzorlug_cannoneer", .5F, 1.125F, 0xffffff, 0xffffff, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<GruzzorlugCommander>>    	GRUZZORLUG_COMMANDER= registerEntity(GruzzorlugCommander::new,     	"gruzzorlug_commander", .5F, 1.125F, 0xffffff, 0xffffff, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<GruzzorlugGeneral>>    	GRUZZORLUG_GENERAL	= registerEntity(GruzzorlugGeneral::new,     	"gruzzorlug_general",   .5F, 1.125F, 0xffffff, 0xffffff, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<GruzzorlugKnight>>    	GRUZZORLUG_KNIGHT	= registerEntity(GruzzorlugKnight::new,     	"gruzzorlug_knight",   	.5F, 1.125F, 0xffffff, 0xffffff, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<GruzzorlugMiner>>	     	GRUZZORLUG_MINER 	= registerEntity(GruzzorlugMiner::new,        	"gruzzorlug_miner",     .5F, 1.125F, 0xffffff, 0xffffff, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<GruzzorlugSwordsman>>    	GRUZZORLUG_SWORDSMAN= registerEntity(GruzzorlugSwordsman::new,     	"gruzzorlug_swordsman", .5F, 1.125F, 0xffffff, 0xffffff, MobCategory.CREATURE);

    //Arcana
    public static final RegistryObject<EntityType<EntityCaptainMerik>>		 CAPTAIN_MERIK 		  = registerEntity(EntityCaptainMerik::new, 	  "captain_merik", 		  0.8F, 2.0F, 0xd8473f, 0x403331, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityDatticon>>			 DATTICON 			  = registerEntity(EntityDatticon::new, 		  "datticon", 			  0.8F, 2.0F, 0x4bd9e2, 0x313e40, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityKazari>>			 KAZARI				  = registerEntity(EntityKazari::new, 			  "kazari", 			      0.8F, 1.8F, 0x171717, 0x161d5a, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityLeorna>>			 LEORNA 			  = registerEntity(EntityLeorna::new, 			  "leorna", 			      0.6F, 2.0F, 0x004f04, 0x0c7807, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityLordVatticus>>		 LORD_VATTICUS 		  = registerEntity(EntityLordVatticus::new, 	  "lord_vatticus", 		  0.6F, 2.0F, 0x2d0701, 0xb91c20, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityWarGeneral>>		 WAR_GENERAL 		  = registerEntity(EntityWarGeneral::new, 		  "war_general", 		      0.6F, 2.0F, 0x272928, 0x1d326a, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityZelus>>				 ZELUS 				  = registerEntity(EntityZelus::new, 			  "zelus", 				  0.6F, 2.0F, 0x141414, 0x800706, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntitySkyre>>			     SKYRE 			      = registerEntity(EntitySkyre::new, 			  "skyre", 			      0.4F, 0.5625F,0xffffff, 0xffffff, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityRazorback>>			 RAZORBACK 			  = registerEntity(EntityRazorback::new, 		  "razorback", 			  0.6F, 0.5F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityDeathHound>>		 DEATH_HOUND 		  = registerEntity(EntityDeathHound::new, 		  "death_hound", 		      0.8F, 0.85F, 0x011821, 0x03345a);
    public static final RegistryObject<EntityType<EntityDungeonConstructor>> DUNGEON_CONSTRUCTOR  = registerEntity(EntityDungeonConstructor::new, "dungeon_constructor",    0.5F, 1.0625F, 0x203e0a, 0xd0ff00);
    public static final RegistryObject<EntityType<EntityDungeonPrisoner>>	 DUNGEON_PRISONER 	  = registerEntity(EntityDungeonPrisoner::new, 	  "dungeon_prisoner", 	  0.6F,2.4375F, 0x8d8c76, 0xe5e5d3);
    public static final RegistryObject<EntityType<EntityDungeonDemon>>		 DUNGEON_DEMON 		  = registerEntity(EntityDungeonDemon::new, 	  "dungeon_demon", 		  0.6F, 2.4375F);
    public static final RegistryObject<EntityType<EntityRoamer>>			 ROAMER 			  = registerEntity(EntityRoamer::new, 			  "roamer", 			      0.6F, 1.75F, 0x21425f, 0x1162ff);
    public static final RegistryObject<EntityType<EntityDeathcryx>>			 DEATHCRYX 			  = registerEntity(EntityDeathcryx::new, 		  "deathcryx", 			  1.0F, 1.0625F, 0x071b35, 0x0d2ebe);
    public static final RegistryObject<EntityType<EntityLivingStatue>>		 LIVING_STATUE 		  = registerEntity(EntityLivingStatue::new, 	  "living_statue", 		  0.6F, 2.0F, 0x041920, 0x5e0909);

    //Arcana Pets
    public static final RegistryObject<EntityType<EntityWraith>>			 WRAITH 			  = registerEntity(EntityWraith::new, 			  "wraith", 			      0.9F, 1.4F, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityFyracryx>>			 FYRACRYX 			  = registerEntity(EntityFyracryx::new, 		  "fyracryx", 			  1.0F, 0.9375F, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityGolemOfRejuvenation>>GOLEM_OF_REJUVENATION= registerEntity(EntityGolemOfRejuvenation::new,"golem_of_rejuvenation",  1.0F,1.5625F, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityParatiku>>			 PARATIKU 			  = registerEntity(EntityParatiku::new, 		  "paratiku", 			  0.7F, 1.4375F, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntitySeimer>>			 SEIMER 			  = registerEntity(EntitySeimer::new, 			  "seimer", 			      1.0F, 1.0F, MobCategory.CREATURE);

    //Eden
    public static final RegistryObject<EntityType<EntityGemFin>> 	         GEM_FIN 		     = registerEntity(EntityGemFin::new, 		    "gem_fin", 	            0.7F, 0.375F, 0xffffff, 0xffffff, MobCategory.WATER_AMBIENT);
    public static final RegistryObject<EntityType<EntityGlinthop>>           GLINTHOP            = registerEntity(EntityGlinthop::new, 		    "glinthop",		        0.5F, 0.75F, 0xffffff, 0xffffff, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityEdenTomo>> 		     EDEN_TOMO 		     = registerEntity(EntityEdenTomo::new, 		    "eden_tomo", 	            0.99F, 0.83F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityEdenCadillion>>      EDEN_CADILLION      = registerEntity(EntityEdenCadillion::new,     "eden_cadillion",         0.875F, 1.4F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityGreenfeet>> 	     GREENFEET 		     = registerEntity(EntityGreenfeet::new, 		"greenfeet", 	            0.8F, 1.9375F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityMadivel>> 		     MADIVEL 		     = registerEntity(EntityMadivel::new, 		    "madivel", 		        1.6F, 3.0F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntitySunArcher>> 	     SUN_ARCHER 		 = registerEntity(EntitySunArcher::new, 		"sun_archer", 	        0.8F, 2.2F, 0xeaab42, 0xfdf182);
    public static final RegistryObject<EntityType<EntityWeakCori>> 		     WEAK_CORI 		     = registerEntity(EntityWeakCori::new, 		    "weak_cori", 	            0.7F, 1.125F, 0xffffff, 0xffffff);

    //Wildwood
    public static final RegistryObject<EntityType<EntityMoonWolf>> 			 MOON_WOLF 			 = registerEntity(EntityMoonWolf::new, 			"moon_wolf", 		        0.6F,0.98F, 0xffffff, 0xffffff, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityWildwoodTomo>> 		 WILDWOOD_TOMO 		 = registerEntity(EntityWildwoodTomo::new, 		"wildwood_tomo", 	        1.0F, 0.625F, 0x06224c, 0x214985);
    public static final RegistryObject<EntityType<EntityWildwoodCadillion>>  WILDWOOD_CADILLION  = registerEntity(EntityWildwoodCadillion::new, "wildwood_cadillion",     0.875F, 1.4F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityEpiphite>> 			 EPIPHITE 			 = registerEntity(EntityEpiphite::new, 			"epiphite", 		        0.8F, 1.0625F, 0x2f74d9, 0x87ecfa);
    public static final RegistryObject<EntityType<EntityBehemoth>> 			 BEHEMOTH 			 = registerEntity(EntityBehemoth::new, 			"behemoth", 		        1.0F, 1.125F, 0x4180d0, 0x54b7e0);
    public static final RegistryObject<EntityType<EntityTermid>> 			 TERMID 			 = registerEntity(EntityTermid::new, 		    "termid", 			    0.4F, 1.6875F, 0x384d6e, 0x6388d4);
    public static final RegistryObject<EntityType<EntityVerek>> 			 VEREK 				 = registerEntity(EntityVerek::new, 			"verek", 			        0.8F, 2.0F, 0x0d5754, 0x3a8e89);
    public static final RegistryObject<EntityType<EntityWildwoodGolem>> 	 WILDWOOD_GOLEM 	 = registerEntity(EntityWildwoodGolem::new, 	"wildwood_golem", 	    1.3F, 2.9F, 0x4889de, 0x1e4a91);
    public static final RegistryObject<EntityType<EntityMage>> 				 MAGE 				 = registerEntity(EntityMage::new, 				"mage", 			        0.9F, 2.2F, 0x0f7adf, 0x2fc7fb);

    //Apalachia
    public static final RegistryObject<EntityType<EntityApalachiaTomo>> 	 APALACHIA_TOMO 	 = registerEntity(EntityApalachiaTomo::new, 	"apalachia_tomo", 		0.99F, 0.83F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityApalachiaCadillion>> APALACHIA_CADILLION = registerEntity(EntityApalachiaCadillion::new,"apalachia_cadillion",    0.875F, 1.4F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityEnchantedWarrior>> 	 ENCHANTED_WARRIOR 	 = registerEntity(EntityEnchantedWarrior::new, 	"enchanted_warrior", 	    0.6F, 2.25F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityApalachiaGolem>> 	 APALACHIA_GOLEM 	 = registerEntity(EntityApalachiaGolem::new, 	"apalachia_golem", 		1.3F, 2.9F, 0x7c4bca, 0x4417a2);
    public static final RegistryObject<EntityType<EntityEnchantedArcher>> 	 ENCHANTED_ARCHER  	 = registerEntity(EntityEnchantedArcher::new, 	"enchanted_archer", 	    1.8F, 3.0F, 0x160430, 0x2f0a66);
    public static final RegistryObject<EntityType<EntitySpellbinder>> 		 SPELLBINDER 		 = registerEntity(EntitySpellbinder::new, 		"spellbinder", 			0.9F, 2.2F, 0x8b27de, 0xd16ff7);

    //Skythern
    public static final RegistryObject<EntityType<EntitySamek>>			     SAMEK 			     = registerEntity(EntitySamek::new, 			"samek", 			        0.8F, 2.0F, 0xa6a875, 0x6e703b);
    public static final RegistryObject<EntityType<EntitySkythernFiend>>      SKYTHERN_FIEND 	 = registerEntity(EntitySkythernFiend::new, 	"skythern_fiend", 	    0.6F, 2.0F, 0xffffff, 0xe8e8e8);
    public static final RegistryObject<EntityType<EntitySkythernGolem>>      SKYTHERN_GOLEM 	 = registerEntity(EntitySkythernGolem::new, 	"skythern_golem", 	    1.3F, 2.9F, 0x6b6b6b, 0x474747);
    public static final RegistryObject<EntityType<EntityMegalith>>		     MEGALITH 		     = registerEntity(EntityMegalith::new,		    "megalith", 		        1.2F, 4.0F, 0x7b7b7b, 0x939393);
    public static final RegistryObject<EntityType<EntitySkythernArcher>>     SKYTHERN_ARCHER     = registerEntity(EntitySkythernArcher::new,    "skythern_archer",        1.8F, 3.0F, 0x3e3e3e, 0x828282);
    public static final RegistryObject<EntityType<EntityMystic>>		     MYSTIC 			 = registerEntity(EntityMystic::new, 		    "mystic", 			    0.9F, 2.2F, 0xb7a5a9, 0xe4d9dd);
    public static final RegistryObject<EntityType<EntityAdvancedCori>>	     ADVANCED_CORI 	     = registerEntity(EntityAdvancedCori::new, 	    "advanced_cori", 	        0.6F, 1.5F, 0x160f00, 0xffc446);

    //Mortum
    public static final RegistryObject<EntityType<EntityAngryGlinthop>>	    ANGRY_GLINTHOP 	     = registerEntity(EntityAngryGlinthop::new, 	"angry_glinthop", 	    1.1F, 1.5625F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityMortumCadillion>>   MORTUM_CADILLION     = registerEntity(EntityMortumCadillion::new,   "mortum_cadillion",       0.875F, 1.4F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntitySoulSpider>>	    SOUL_SPIDER 	     = registerEntity(EntitySoulSpider::new, 	    "soul_spider", 	        0.4F, 0.4375F, 0x060505, 0x452827);
    public static final RegistryObject<EntityType<EntityBasilisk>>		    BASILISK 		     = registerEntity(EntityBasilisk::new, 	        "basilisk", 		        0.7F, 0.8F, 0x424242, 0x5f5f5f);
    public static final RegistryObject<EntityType<EntityDemonOfDarkness>>   DEMON_OF_DARKNESS    = registerEntity(EntityDemonOfDarkness::new,   "demon_of_darkness",      0.8F, 1.6F, 0x090909, 0x202020);
    public static final RegistryObject<EntityType<EntitySoulStealer>>	    SOUL_STEALER 	     = registerEntity(EntitySoulStealer::new, 	    "soul_stealer", 	        1.3F, 2.125F, 0xffffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityTwilightArcher>>    TWILIGHT_ARCHER      = registerEntity(EntityTwilightArcher::new,    "twilight_archer",        1.8F, 3.0F, 0x200306, 0x670710);
    public static final RegistryObject<EntityType<EntitySorcerer>>		    SORCERER 		     = registerEntity(EntitySorcerer::new, 	        "sorcerer", 		        0.9F, 2.2F, 0x4f1014, 0xa82732);

    //Vethea
    //Layer 1
    public static final RegistryObject<EntityType<EntityTheHunger>>			 THE_HUNGER			  = registerEntity(EntityTheHunger::new,			"the_hunger",			     0.8F, 2.0F, 0x1e1e1e, 0xaa7d66, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityCryptKeeper>>		 CRYPT_KEEPER		  = registerEntity(EntityCryptKeeper::new,			"crypt_keeper",			 0.6F, 2.0625F, 0x202f05, 0x4c6e08, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityMysteriousManLayer1>>MYSTERIOUS_MAN_LAYER1= registerEntity(EntityMysteriousManLayer1::new,  "mysterious_man_layer_1",  0.6F, 2.125F, 0x060000, 0xb11d1d, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityAcidHag>>			 ACID_HAG			  = registerEntity(EntityAcidHag::new,				"acid_hag",				 0.9F, 1.7F, 0x657b17, 0x7e4f19);
    public static final RegistryObject<EntityType<EntityCymesoid>>			 CYMESOID			  = registerEntity(EntityCymesoid::new,				"cymesoid",				 0.8F, 2.0F, 0x6dd4fa, 0x469afc);
    public static final RegistryObject<EntityType<EntityDreamwrecker>>		 DREAMWRECKER		  = registerEntity(EntityDreamwrecker::new,			"dreamwrecker",			 1.0F, 4.5625F, 0xd7d7d7, 0x92dd91);
    public static final RegistryObject<EntityType<EntityDuo>>				 DUO				  = registerEntity(EntityDuo::new,					"duo",					 1.0F, 2.25F, 0xec2f0c, 0x621000);
    public static final RegistryObject<EntityType<EntityEnt>>				 ENT				  = registerEntity(EntityEnt::new,					"ent",					 2.0F, 4.4F, 0x4c5645, 0x209633);
    public static final RegistryObject<EntityType<EntityHiveSoldier>>		 HIVE_SOLDIER		  = registerEntity(EntityHiveSoldier::new,			"hive_soldier",			 0.6F, 1.9375F, 0xcbbf79, 0x68c66e);
    public static final RegistryObject<EntityType<EntityHoverStinger>>		 HOVER_STINGER		  = registerEntity(EntityHoverStinger::new,			"hover_stinger",		     0.7F, 2.1875F, 0xc4c53d, 0x57b90e);
    public static final RegistryObject<EntityType<EntityLorga>>				 LORGA				  = registerEntity(EntityLorga::new,				"lorga",				     1.0F, 2.25F, 0xff641c, 0xfed31b);
    public static final RegistryObject<EntityType<EntityShadahier>>			 SHADAHIER 			  = registerEntity(EntityShadahier::new,			"shadahier",			     0.8F, 1.375F, 0x252525, 0x972626);

    //Layer 2
    public static final RegistryObject<EntityType<EntityTempleGuardian>>	 TEMPLE_GUARDIAN	  = registerEntity(EntityTempleGuardian::new, 		"temple_guardian",		 0.6F, 2.0F, 0x25340a, 0x547412);
    public static final RegistryObject<EntityType<EntityMysteriousManLayer2>>MYSTERIOUS_MAN_LAYER2= registerEntity(EntityMysteriousManLayer2::new,  "mysterious_man_layer_2",  0.6F, 2.125F, 0x060000, 0x40b724, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityBiphron>>			 BIPHRON			  = registerEntity(EntityBiphron::new,				"biphron",				 1.0F, 3.5F, 0xf1dc1b, 0x5e5e5e);
    public static final RegistryObject<EntityType<EntityGorgosion>>			 GORGOSION			  = registerEntity(EntityGorgosion::new,			"gorgosion",			     2.0F, 1.75F, 0x8c13c5, 0xc98a39);
    public static final RegistryObject<EntityType<EntityMandragora>>		 MANDRAGORA			  = registerEntity(EntityMandragora::new,			"mandragora",			     1.0F, 2.0F, 0x178b1e, 0x0b3a0d);
    public static final RegistryObject<EntityType<EntityTwins>>				 TWINS				  = registerEntity(EntityTwins::new, 				"twins",				     1.0F, 2.25F, 0x3ab921, 0xb3d400);
    public static final RegistryObject<EntityType<EntityVermenous>>			 VERMENOUS			  = registerEntity(EntityVermenous::new, 			"vermenous",			     1.0F, 2.9375F, 0x581b15, 0xa55f12);

    //Layer 3
    public static final RegistryObject<EntityType<EntityMysteriousManLayer3>>MYSTERIOUS_MAN_LAYER3= registerEntity(EntityMysteriousManLayer3::new,  "mysterious_man_layer_3",  0.6F, 2.125F, 0x060000, 0x0049d0, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityBohemite>>			 BOHEMITE			  = registerEntity(EntityBohemite::new,				"bohemite",				 1.0F, 2.0F, 0x7d1818, 0xeb0016);
    public static final RegistryObject<EntityType<EntityGalroid>>			 GALROID			  = registerEntity(EntityGalroid::new,				"galroid",				 1.0F, 2.5F, 0x141f51, 0x365196);
    public static final RegistryObject<EntityType<EntityKazrotic>>			 KAZROTIC			  = registerEntity(EntityKazrotic::new,				"kazrotic",				 1.2F, 2.9375F, 0xda6f1c, 0x4a4a4a);
    public static final RegistryObject<EntityType<EntityLheiva>>			 LHEIVA				  = registerEntity(EntityLheiva::new,				"lheiva",				     1.0F, 1.5625F, 0x0817d0, 0x00006b);
    public static final RegistryObject<EntityType<EntityLorgaflight>>		 LORGA_FLIGHT		  = registerEntity(EntityLorgaflight::new,			"lorga_flight",			 0.7F, 1.1875F, 0xff641c, 0xfed31b);
    public static final RegistryObject<EntityType<EntityTocaxin>>			 TOCAXIN			  = registerEntity(EntityTocaxin::new, 				"tocaxin",				 1.0F, 3.5F, 0xceb89e, 0x5f5143);

    //Layer 4
    public static final RegistryObject<EntityType<EntityDissiment>>			 DISSIMENT			  = registerEntity(EntityDissiment::new,			"dissiment",			     1.5F, 2.5F, 0xbec7e2, 0x2a65ff);
    public static final RegistryObject<EntityType<EntityHelio>>				 HELIO				  = registerEntity(EntityHelio::new,				"helio",				     1.0F, 2.0F, 0xb8b8b8, 0x757575);
    public static final RegistryObject<EntityType<EntityVhraak>>			 VHRAAK				  = registerEntity(EntityVhraak::new, 				"vhraak",				     1.0F, 1.25F, 0x3f2626, 0x5d1a1a);
    public static final RegistryObject<EntityType<EntityFakeVhraak>>		 FAKE_VHRAAK		  = registerEntity(EntityFakeVhraak::new,			"fake_vhraak",			 1.0F, 1.25F);
    public static final RegistryObject<EntityType<EntityZone>>				 ZONE				  = registerEntity(EntityZone::new, 				"zone",					 1.0F, 1.4375F, 0xb31c15, 0xaf9311);
    public static final RegistryObject<EntityType<EntityZoragon>>			 ZORAGON			  = registerEntity(EntityZoragon::new, 				"zoragon",				 3.8F, 3.75F, 0xc71a1a, 0x0613c0);

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        DivineRPG.LOGGER.info("[DivineRPG] Attached entity attributes");

        //Bosses
        registerMobAttributes(event, ANCIENT_ENTITY, EntityStats.ANCIENT_ENTITY);
        registerMobAttributes(event, THE_WATCHER, EntityStats.THE_WATCHER);
        registerMobAttributes(event, KING_OF_SCORCHERS, EntityStats.KING_OF_SCORCHERS);
        registerMobAttributes(event, KITRA, EntityStats.KITRA);
        registerMobAttributes(event, AYERACO, EntityStats.AYERACO);
        registerMobAttributes(event, DRAMIX, EntityStats.DRAMIX);
        registerMobAttributes(event, PARASECTA, EntityStats.PARASECTA);
        registerMobAttributes(event, SUNSTORM, EntityStats.SUNSTORM);
        registerMobAttributes(event, TERMASECT, EntityStats.TERMASECT);
        registerMobAttributes(event, ETERNAL_ARCHER, EntityStats.ETERNAL_ARCHER);
        registerMobAttributes(event, EXPERIENCED_CORI, EntityStats.EXPERIENCED_CORI);
        registerMobAttributes(event, VAMACHERON, EntityStats.VAMACHERON);
        registerMobAttributes(event, KAROT, EntityStats.KAROT);
        registerMobAttributes(event, TWILIGHT_DEMON, EntityStats.TWILIGHT_DEMON);
        registerMobAttributes(event, DENSOS, EntityStats.DENSOS);
        registerMobAttributes(event, REYVOR, EntityStats.REYVOR);
        registerMobAttributes(event, SOUL_FIEND, EntityStats.SOUL_FIEND);
        registerMobAttributes(event, HIVE_QUEEN, EntityStats.HIVE_QUEEN);
        registerMobAttributes(event, KAROS, EntityStats.KAROS);
        registerMobAttributes(event, LADY_LUNA, EntityStats.LADY_LUNA);
        registerMobAttributes(event, QUADRO, EntityStats.QUADRO);
        registerMobAttributes(event, RAGLOK, EntityStats.RAGLOK);
        registerMobAttributes(event, WRECK, EntityStats.WRECK);

        //Overworld
        registerDefaultMobAttributes(event, LIVESTOCK_MERCHANT);
        registerDefaultMobAttributes(event, JACK_O_MAN);
        registerMobAttributes(event, CYCLOPS, EntityStats.CYCLOPS);
        registerMobAttributes(event, KOBBLIN, EntityStats.KOBBLIN);
        registerMobAttributes(event, PUMPKIN_SPIDER, EntityStats.PUMPKIN_SPIDER);
        registerMobAttributes(event, RAINBOUR, EntityStats.RAINBOUR);

        //Jungle
        registerMobAttributes(event, JUNGLE_BAT, EntityStats.JUNGLE_BAT);
        registerMobAttributes(event, JUNGLE_SPIDER, EntityStats.JUNGLE_SPIDER);
        registerMobAttributes(event, JUNGLE_DRAMCRYX, EntityStats.JUNGLE_DRAMCRYX);

        //Desert
        registerMobAttributes(event, SAGUARO_WORM, EntityStats.SAGUARO_WORM);
        registerMobAttributes(event, DESERT_CRAWLER, EntityStats.DESERT_CRAWLER);
        registerMobAttributes(event, ARID_WARRIOR, EntityStats.ARID_WARRIOR);

        //Snow
        registerMobAttributes(event, GLACON, EntityStats.GLACON);
        registerMobAttributes(event, FROST, EntityStats.FROST);

        //Beach
        registerMobAttributes(event, CRAB, EntityStats.CRAB);
        registerMobAttributes(event, KING_CRAB, EntityStats.KING_CRAB);

        //Water
        registerMobAttributes(event, AEQUOREA, EntityStats.AEQUOREA);
        registerMobAttributes(event, SHARK, EntityStats.SHARK);
        registerMobAttributes(event, WHALE, EntityStats.WHALE);
        registerMobAttributes(event, LIOPLEURODON, EntityStats.LIOPLEURODON);

        //Cave
        registerDefaultMobAttributes(event, DIAMOND_DAVE);
        registerMobAttributesArmour(event, MINER, EntityStats.MINER, 10);
        registerMobAttributes(event, ROTATICK, EntityStats.ROTATICK);
        registerMobAttributes(event, CAVE_CRAWLER, EntityStats.CAVE_CRAWLER);
        registerMobAttributes(event, CAVECLOPS, EntityStats.CAVECLOPS);
        registerMobAttributes(event, THE_EYE, EntityStats.THE_EYE);
        registerMobAttributes(event, ENTHRALLED_DRAMCRYX, EntityStats.ENTHRALLED_DRAMCRYX);
        registerMobAttributes(event, THE_GRUE, EntityStats.THE_GRUE);

        //Livestock
        registerMobAttributes(event, SNAPPER, EntityStats.SNAPPER);
        registerMobAttributes(event, EHU, EntityStats.EHU);
        registerMobAttributes(event, HUSK, EntityStats.HUSK);
        registerMobAttributes(event, BROWN_GRIZZLE, EntityStats.GRIZZLE);
        registerMobAttributes(event, WHITE_GRIZZLE, EntityStats.GRIZZLE);
        registerMobAttributes(event, STONE_GOLEM, EntityStats.STONE_GOLEM);
        registerMobAttributes(event, SMELTER, EntityStats.SMELTER);

        //Nether
        registerMobAttributes(event, HELL_PIG, EntityStats.HELL_PIG);
        registerMobAttributes(event, HELL_SPIDER, EntityStats.HELL_SPIDER);
        registerMobAttributes(event, WILDFIRE, EntityStats.WILDFIRE);
        registerMobAttributes(event, SCORCHER, EntityStats.SCORCHER);

        //End
        registerMobAttributes(event, ENDER_SCROUNGE, EntityStats.ENDER_SCROUNGE);
        registerMobAttributes(event, ENDER_SPIDER, EntityStats.END_SPIDER);
        registerMobAttributes(event, ENDER_WATCHER, EntityStats.ENDER_WATCHER);
        registerMobAttributes(event, ENDER_TRIPLETS, EntityStats.ENDER_TRIPLETS);

        //Iceika
        registerMobAttributes(event, BLUBBERTUSK, EntityStats.BLUBBERTUSK);
        registerMobAttributes(event, CAULDRON_FISH, EntityStats.CAULDRON_FISH);
        EntityDolossal.registerDolossalAttributes(event, DOLOSSAL);
        registerMobAttributes(event, MAMOTH, EntityStats.MAMOTH);
        registerMobAttributes(event, SNOW_SKIPPER, EntityStats.SNOW_SKIPPER);
        registerMobAttributes(event, PINK_GHOST_GLIDER, EntityStats.GHOST_GLIDER);
        registerMobAttributes(event, ROBBIN, EntityStats.ROBBIN);
        registerMobAttributes(event, WOLPERTINGER, EntityStats.WOLPERTINGER);
        registerDefaultMobAttributes(event, WORKSHOP_MERCHANT);
        registerDefaultMobAttributes(event, WORKSHOP_TINKERER);
        registerMobAttributes(event, PALE_ARCHER, EntityStats.PALE_ARCHER);
        registerMobAttributes(event, FROZEN_FLESH, EntityStats.FROZEN_FLESH);
        registerMobAttributes(event, ROLLUM, EntityStats.ROLLUM);
        registerMobAttributes(event, ALICANTO, EntityStats.ALICANTO);
        registerMobAttributes(event, SENG, EntityStats.SENG);
        registerMobAttributes(event, SABEAR, EntityStats.SABEAR);
        registerMobAttributes(event, HASTREUS, EntityStats.HASTREUS);
        registerMobAttributes(event, GLACIDE, EntityStats.GLACIDE);
        registerMobAttributes(event, FRACTITE, EntityStats.FRACTITE);
        //Groglin
        registerMobAttributes(event, GROGLIN_CHIEFTAIN, EntityStats.GROGLIN_CHIEFTAIN);
        registerMobAttributes(event, GROGLIN_HUNTER, EntityStats.GROGLIN);
        registerMobAttributes(event, GROGLIN_MERCHANT, EntityStats.GROGLIN);
        registerMobAttributes(event, GROGLIN_RANGER, EntityStats.GROGLIN_RANGER);
        registerMobAttributes(event, GROGLIN_SHARLATAN, EntityStats.GROGLIN_SHARLATAN);
        registerMobAttributes(event, GROGLIN_WARRIOR, EntityStats.GROGLIN_WARRIOR);
        //Gruzzorlug
        registerMobAttributes(event, GRUZZORLUG_CANNONEER, EntityStats.GRUZZORLUG);
        registerMobAttributes(event, GRUZZORLUG_COMMANDER, EntityStats.GRUZZORLUG_COMMANDER);
        registerMobAttributes(event, GRUZZORLUG_GENERAL, EntityStats.GRUZZORLUG_GENERAL);
        registerMobAttributes(event, GRUZZORLUG_KNIGHT, EntityStats.GRUZZORLUG_KNIGHT);
        registerMobAttributes(event, GRUZZORLUG_MINER, EntityStats.GRUZZORLUG);
        registerMobAttributes(event, GRUZZORLUG_SWORDSMAN, EntityStats.GRUZZORLUG_SWORDSMAN);

        //Arcana
        registerDefaultMobAttributes(event, CAPTAIN_MERIK);
        registerDefaultMobAttributes(event, DATTICON);
        registerDefaultMobAttributes(event, KAZARI);
        registerDefaultMobAttributes(event, LEORNA);
        registerDefaultMobAttributes(event, LORD_VATTICUS);
        registerDefaultMobAttributes(event, WAR_GENERAL);
        registerDefaultMobAttributes(event, ZELUS);
        registerMobAttributes(event, SKYRE, EntityStats.SKYRE);
        registerMobAttributes(event, RAZORBACK, EntityStats.RAZORBACK);
        registerMobAttributes(event, DEATH_HOUND, EntityStats.DEATH_HOUND);
        registerMobAttributes(event, DUNGEON_CONSTRUCTOR, EntityStats.DUNGEON_CONSTRUCTOR);
        registerMobAttributes(event, DUNGEON_PRISONER, EntityStats.DUNGEON_PRISONER);
        registerMobAttributes(event, DUNGEON_DEMON, EntityStats.DUNGEON_PRISONER);
        registerMobAttributes(event, ROAMER, EntityStats.ROAMER);
        registerMobAttributes(event, DEATHCRYX, EntityStats.DEATHCRYX);
        registerMobAttributes(event, LIVING_STATUE, EntityStats.LIVING_STATUE);

        //Arcana Pets
        registerMobAttributes(event, WRAITH, EntityStats.WRAITH);
        registerMobAttributes(event, FYRACRYX, EntityStats.FYRACRYX);
        registerMobAttributes(event, GOLEM_OF_REJUVENATION, EntityStats.GOLEM_OF_REJUVENATION);
        registerMobAttributes(event, PARATIKU, EntityStats.PARATIKU);
        registerMobAttributes(event, SEIMER, EntityStats.SEIMER);

        //Eden
        registerMobAttributes(event, GEM_FIN, EntityStats.GEM_FIN);
        registerMobAttributes(event, GLINTHOP, EntityStats.GLINTHOP);
        registerMobAttributes(event, EDEN_TOMO, EntityStats.EDEN_TOMO);
        registerMobAttributes(event, EDEN_CADILLION, EntityStats.EDEN_CADILLION);
        registerMobAttributes(event, GREENFEET, EntityStats.GREENFEET);
        registerMobAttributes(event, MADIVEL, EntityStats.MADIVEL);
        registerMobAttributes(event, SUN_ARCHER, EntityStats.SUN_ARCHER);
        registerMobAttributes(event, WEAK_CORI, EntityStats.WEAK_CORI);

        //Wildwood
        registerMobAttributes(event, MOON_WOLF, EntityStats.MOON_WOLF);
        registerMobAttributes(event, WILDWOOD_TOMO, EntityStats.WILDWOOD_TOMO);
        registerMobAttributes(event, WILDWOOD_CADILLION, EntityStats.WILDWOOD_CADILLION);
        registerMobAttributes(event, EPIPHITE, EntityStats.EPIPHITE);
        registerMobAttributes(event, BEHEMOTH, EntityStats.BEHEMOTH);
        registerMobAttributes(event, TERMID, EntityStats.TERMID);
        registerMobAttributes(event, VEREK, EntityStats.VEREK);
        registerMobAttributes(event, WILDWOOD_GOLEM, EntityStats.WILDWOOD_GOLEM);
        registerMobAttributes(event, MAGE, EntityStats.MAGE);

        //Apalachia
        registerMobAttributes(event, APALACHIA_TOMO, EntityStats.APALACHIA_TOMO);
        registerMobAttributes(event, APALACHIA_CADILLION, EntityStats.APALACHIA_CADILLION);
        registerMobAttributes(event, ENCHANTED_WARRIOR, EntityStats.ENCHANTED_WARRIOR);
        registerMobAttributes(event, APALACHIA_GOLEM, EntityStats.APALACHIA_GOLEM);
        registerMobAttributes(event, ENCHANTED_ARCHER, EntityStats.ENCHANTED_ARCHER);
        registerMobAttributes(event, SPELLBINDER, EntityStats.SPELLBINDER);

        //Skythern
        registerMobAttributes(event, SAMEK, EntityStats.SAMEK);
        registerMobAttributes(event, SKYTHERN_FIEND, EntityStats.SKYTHERN_FIEND);
        registerMobAttributes(event, SKYTHERN_GOLEM, EntityStats.SKYTHERN_GOLEM);
        registerMobAttributesKnockback(event, MEGALITH, EntityStats.MEGALITH, 1);
        registerMobAttributes(event, SKYTHERN_ARCHER, EntityStats.SKYTHERN_ARCHER);
        registerMobAttributes(event, MYSTIC, EntityStats.MYSTIC);
        registerMobAttributes(event, ADVANCED_CORI, EntityStats.ADVANCED_CORI);

        //Mortum
        registerMobAttributes(event, ANGRY_GLINTHOP, EntityStats.ANGRY_GLINTHOP);
        registerMobAttributes(event, MORTUM_CADILLION, EntityStats.MORTUM_CADILLION);
        registerMobAttributes(event, SOUL_SPIDER, EntityStats.SOUL_SPIDER);
        registerMobAttributes(event, BASILISK, EntityStats.BASALISK);
        registerMobAttributes(event, DEMON_OF_DARKNESS, EntityStats.DEMON_OF_DARKNESS);
        registerMobAttributes(event, SOUL_STEALER, EntityStats.SOUL_STEALER);
        registerMobAttributes(event, TWILIGHT_ARCHER, EntityStats.TWILIGHT_ARCHER);
        registerMobAttributes(event, SORCERER, EntityStats.SORCERER);

        //Vethea
        //Layer 1
        registerDefaultMobAttributes(event, THE_HUNGER);
        registerMobAttributes(event, CRYPT_KEEPER, EntityStats.CRYPT_KEEPER);
        registerMobAttributes(event, MYSTERIOUS_MAN_LAYER1, EntityStats.MYSTERIOUS_MAN);
        registerMobAttributes(event, ACID_HAG, EntityStats.ACID_HAG);
        registerMobAttributes(event, CYMESOID, EntityStats.CYMESOID);
        registerMobAttributes(event, DREAMWRECKER, EntityStats.DREAMWRECKER);
        registerMobAttributes(event, DUO, EntityStats.DUO);
        registerMobAttributes(event, ENT, EntityStats.ENT);
        registerMobAttributes(event, HIVE_SOLDIER, EntityStats.HIVE_SOLDIER);
        registerMobAttributes(event, HOVER_STINGER, EntityStats.HOVER_STINGER);
        registerMobAttributes(event, LORGA, EntityStats.LORGA);
        registerMobAttributes(event, SHADAHIER, EntityStats.SHADAHIER);

        //Layer 2
        registerMobAttributes(event, TEMPLE_GUARDIAN, EntityStats.TEMPLE_GUARDIAN);
        registerMobAttributes(event, MYSTERIOUS_MAN_LAYER2, EntityStats.MYSTERIOUS_MAN);
        registerMobAttributes(event, BIPHRON, EntityStats.BIPHRON);
        registerMobAttributes(event, GORGOSION, EntityStats.GORGOSION);
        registerMobAttributes(event, MANDRAGORA, EntityStats.MANDRAGORA);
        registerMobAttributes(event, TWINS, EntityStats.TWINS);
        registerMobAttributes(event, VERMENOUS, EntityStats.VERMENOUS);

        //Layer 3
        registerMobAttributes(event, MYSTERIOUS_MAN_LAYER3, EntityStats.MYSTERIOUS_MAN);
        registerMobAttributes(event, BOHEMITE, EntityStats.BOHEMITE);
        registerMobAttributes(event, GALROID, EntityStats.GALROID);
        registerMobAttributes(event, KAZROTIC, EntityStats.KAZROTIC);
        registerMobAttributes(event, LHEIVA, EntityStats.LHEIVA);
        registerMobAttributes(event, LORGA_FLIGHT, EntityStats.LORGA_FLIGHT);
        registerMobAttributes(event, TOCAXIN, EntityStats.TOCAXIN);

        //Layer 4
        registerMobAttributes(event, DISSIMENT, EntityStats.DISSIMENT);
        registerMobAttributes(event, HELIO, EntityStats.HELIO);
        registerMobAttributes(event, VHRAAK, EntityStats.VHRAAK);
        registerMobAttributes(event, FAKE_VHRAAK, EntityStats.VHRAAK);
        registerMobAttributes(event, ZONE, EntityStats.ZONE);
        registerMobAttributes(event, ZORAGON, EntityStats.ZORAGON);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        //Base
        event.registerLayerDefinition(layerHumanoid, () -> LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0), 64, 32));
        event.registerLayerDefinition(layerBat, BatModel::createBodyLayer);
        event.registerLayerDefinition(layerSpider, SpiderModel::createSpiderBodyLayer);

        //Boss
        event.registerLayerDefinition(ModelAncientEntity.LAYER_LOCATION, 	ModelAncientEntity::createBodyLayer);
        event.registerLayerDefinition(ModelAyeraco.LAYER_LOCATION, 			ModelAyeraco::createBodyLayer);
        event.registerLayerDefinition(ModelDensos.LAYER_LOCATION, 			ModelDensos::createBodyLayer);
        event.registerLayerDefinition(ModelDramix.LAYER_LOCATION, 			ModelDramix::createBodyLayer);
        event.registerLayerDefinition(ModelEternalArcher.LAYER_LOCATION, 	ModelEternalArcher::createBodyLayer);
        event.registerLayerDefinition(ModelExperiencedCori.LAYER_LOCATION,  ModelExperiencedCori::createBodyLayer);
        event.registerLayerDefinition(ModelKitra.LAYER_LOCATION,			ModelKitra::createBodyLayer);
        event.registerLayerDefinition(ModelHiveQueen.LAYER_LOCATION, 		ModelHiveQueen::createBodyLayer);
        event.registerLayerDefinition(ModelKaros.LAYER_LOCATION, 			ModelKaros::createBodyLayer);
        event.registerLayerDefinition(ModelKarot.LAYER_LOCATION, 			ModelKarot::createBodyLayer);
        event.registerLayerDefinition(ModelKingOfScorchers.LAYER_LOCATION,  ModelKingOfScorchers::createBodyLayer);
        event.registerLayerDefinition(ModelLadyLuna.LAYER_LOCATION, 		ModelLadyLuna::createBodyLayer);
        event.registerLayerDefinition(ModelParasecta.LAYER_LOCATION, 		ModelParasecta::createBodyLayer);
        event.registerLayerDefinition(ModelQuadro.LAYER_LOCATION, 			ModelQuadro::createBodyLayer);
        event.registerLayerDefinition(ModelRaglok.LAYER_LOCATION, 			ModelRaglok::createBodyLayer);
        event.registerLayerDefinition(ModelReyvor.LAYER_LOCATION, 			ModelReyvor::createBodyLayer);
        event.registerLayerDefinition(ModelSoulFiend.LAYER_LOCATION, 		ModelSoulFiend::createBodyLayer);
        event.registerLayerDefinition(ModelSunstorm.LAYER_LOCATION, 		ModelSunstorm::createBodyLayer);
        event.registerLayerDefinition(ModelTermasect.LAYER_LOCATION, 		ModelTermasect::createBodyLayer);
        event.registerLayerDefinition(ModelTwilightDemon.LAYER_LOCATION, 	ModelTwilightDemon::createBodyLayer);
        event.registerLayerDefinition(ModelVamacheron.LAYER_LOCATION, 		ModelVamacheron::createBodyLayer);
        event.registerLayerDefinition(ModelWreck.LAYER_LOCATION, 			ModelWreck::createBodyLayer);
        event.registerLayerDefinition(ModelWreckArcanic.LAYER_LOCATION, 	ModelWreckArcanic::createBodyLayer);
        event.registerLayerDefinition(ModelWreckRanged.LAYER_LOCATION, 		ModelWreckRanged::createBodyLayer);

        //Overworld
        event.registerLayerDefinition(ModelAequorea.LAYER_LOCATION,			 ModelAequorea::createBodyLayer);
        event.registerLayerDefinition(ModelAridWarrior.LAYER_LOCATION,		 ModelAridWarrior::createBodyLayer);
        event.registerLayerDefinition(ModelCaveCrawler.LAYER_LOCATION,	     ModelCaveCrawler::createBodyLayer);
        event.registerLayerDefinition(ModelGrizzle.LAYER_LOCATION,			 ModelGrizzle::createBodyLayer);
        event.registerLayerDefinition(ModelCrab.LAYER_LOCATION,				 ModelCrab::createBodyLayer);
        event.registerLayerDefinition(ModelDesertCrawler.LAYER_LOCATION,	 ModelDesertCrawler::createBodyLayer);
        event.registerLayerDefinition(ModelEnthralledDramcryx.LAYER_LOCATION,ModelEnthralledDramcryx::createBodyLayer);
        event.registerLayerDefinition(ModelEhu.LAYER_LOCATION,				 ModelEhu::createBodyLayer);
        event.registerLayerDefinition(ModelFrost.LAYER_LOCATION,			 ModelFrost::createBodyLayer);
        event.registerLayerDefinition(ModelGlacon.LAYER_LOCATION,			 ModelGlacon::createBodyLayer);
        event.registerLayerDefinition(ModelGrizzle.LAYER_LOCATION,			 ModelGrizzle::createBodyLayer);
        event.registerLayerDefinition(ModelHusk.LAYER_LOCATION,				 ModelHusk::createBodyLayer);
        event.registerLayerDefinition(ModelJungleDramcryx.LAYER_LOCATION,    ModelJungleDramcryx::createBodyLayer);
        event.registerLayerDefinition(ModelJungleSpider.LAYER_LOCATION,		 ModelJungleSpider::createBodyLayer);
        event.registerLayerDefinition(ModelKingCrab.LAYER_LOCATION,			 ModelKingCrab::createBodyLayer);
        event.registerLayerDefinition(ModelKobblin.LAYER_LOCATION,			 ModelKobblin::createBodyLayer);
        event.registerLayerDefinition(ModelLiopleurodon.LAYER_LOCATION,		 ModelLiopleurodon::createBodyLayer);
        event.registerLayerDefinition(ModelLivestockMerchant.LAYER_LOCATION, ModelLivestockMerchant::createBodyLayer);
        event.registerLayerDefinition(ModelPumpkinSpider.LAYER_LOCATION,	 ModelPumpkinSpider::createBodyLayer);
        event.registerLayerDefinition(ModelRainbour.LAYER_LOCATION,			 ModelRainbour::createBodyLayer);
        event.registerLayerDefinition(ModelRotatick.LAYER_LOCATION,			 ModelRotatick::createBodyLayer);
        event.registerLayerDefinition(ModelSaguaroWorm.LAYER_LOCATION,		 ModelSaguaroWorm::createBodyLayer);
        event.registerLayerDefinition(ModelSaguaroWormShot.LAYER_LOCATION,	 ModelSaguaroWormShot::createBodyLayer);
        event.registerLayerDefinition(ModelShark.LAYER_LOCATION,			 ModelShark::createBodyLayer);
        event.registerLayerDefinition(ModelSnapper.LAYER_LOCATION,			 ModelSnapper::createBodyLayer);
        event.registerLayerDefinition(ModelStoneGolem.LAYER_LOCATION,		 ModelStoneGolem::createBodyLayer);
        event.registerLayerDefinition(ModelTheEye.LAYER_LOCATION,			 ModelTheEye::createBodyLayer);
        event.registerLayerDefinition(ModelTheGrue.LAYER_LOCATION,			 ModelTheGrue::createBodyLayer);
        event.registerLayerDefinition(ModelWatcher.LAYER_LOCATION,			 ModelWatcher::createBodyLayer);
        event.registerLayerDefinition(ModelWhale.LAYER_LOCATION,			 ModelWhale::createBodyLayer);

        //Nether
        event.registerLayerDefinition(ModelHellPig.LAYER_LOCATION,ModelHellPig::createBodyLayer);
        event.registerLayerDefinition(ModelHellSpider.LAYER_LOCATION,ModelHellSpider::createBodyLayer);
        event.registerLayerDefinition(ModelScorcher.LAYER_LOCATION,  ModelScorcher::createBodyLayer);
        event.registerLayerDefinition(ModelWildfire.LAYER_LOCATION,  ModelWildfire::createBodyLayer);

        //End
        event.registerLayerDefinition(ModelEnderTriplets.LAYER_LOCATION, ModelEnderTriplets::createBodyLayer);
        event.registerLayerDefinition(ModelEnderScrounge.LAYER_LOCATION, ModelEnderScrounge::createBodyLayer);

        //Iceika
        event.registerLayerDefinition(ModelBlubbertusk.LAYER_LOCATION, ModelBlubbertusk::createBodyLayer);
        event.registerLayerDefinition(ModelCauldronFish.LAYER_LOCATION, ModelCauldronFish::createBodyLayer);
        event.registerLayerDefinition(ModelDolossal.LAYER_LOCATION, ModelDolossal::createBodyLayer);
        event.registerLayerDefinition(ModelMamoth.LAYER_LOCATION, ModelMamoth::createBodyLayer);
        event.registerLayerDefinition(ModelSnowSkipper.LAYER_LOCATION, ModelSnowSkipper::createBodyLayer);
        event.registerLayerDefinition(ModelGhostGlider.LAYER_LOCATION, ModelGhostGlider::createBodyLayer);
        event.registerLayerDefinition(ModelAlicanto.LAYER_LOCATION, ModelAlicanto::createBodyLayer);
        event.registerLayerDefinition(ModelFractite.LAYER_LOCATION, ModelFractite::createBodyLayer);
        event.registerLayerDefinition(ModelPaleArcher.LAYER_LOCATION, ModelPaleArcher::createBodyLayer);
        event.registerLayerDefinition(ModelFrozenFlesh.LAYER_LOCATION, ModelFrozenFlesh::createBodyLayer);
        event.registerLayerDefinition(ModelGlacide.LAYER_LOCATION, ModelGlacide::createBodyLayer);
        event.registerLayerDefinition(ModelGroglin.LAYER_LOCATION, ModelGroglin::createBodyLayer);
        event.registerLayerDefinition(ModelGruzzorlug.LAYER_LOCATION, ModelGruzzorlug::createBodyLayer);
        event.registerLayerDefinition(ModelHastreus.LAYER_LOCATION, ModelHastreus::createBodyLayer);
        event.registerLayerDefinition(ModelRollum.LAYER_LOCATION, ModelRollum::createBodyLayer);
        event.registerLayerDefinition(ModelWorkshopMerchant.LAYER_LOCATION, ModelWorkshopMerchant::createBodyLayer);
        event.registerLayerDefinition(ModelWorkshopTinkerer.LAYER_LOCATION, ModelWorkshopTinkerer::createBodyLayer);
        event.registerLayerDefinition(ModelSeng.LAYER_LOCATION, ModelSeng::createBodyLayer);
        event.registerLayerDefinition(ModelSabear.LAYER_LOCATION, ModelSabear::createBodyLayer);
        event.registerLayerDefinition(ModelWolpertinger.LAYER_LOCATION, ModelWolpertinger::createBodyLayer);
        event.registerLayerDefinition(ModelRobbin.LAYER_LOCATION, ModelRobbin::createBodyLayer);

        //Eden
        event.registerLayerDefinition(ModelGlinthop.LAYER_LOCATION, ModelGlinthop::createBodyLayer);
        event.registerLayerDefinition(ModelCadillion.LAYER_LOCATION, ModelCadillion::createBodyLayer);
        event.registerLayerDefinition(ModelEdenTomo.LAYER_LOCATION, ModelEdenTomo::createBodyLayer);
        event.registerLayerDefinition(ModelGemFin.LAYER_LOCATION, ModelGemFin::createBodyLayer);
        event.registerLayerDefinition(ModelGreenfeet.LAYER_LOCATION, ModelGreenfeet::createBodyLayer);
        event.registerLayerDefinition(ModelMadivel.LAYER_LOCATION, ModelMadivel::createBodyLayer);
        event.registerLayerDefinition(ModelSunArcher.LAYER_LOCATION, ModelSunArcher::createBodyLayer);
        event.registerLayerDefinition(ModelWeakCori.LAYER_LOCATION, ModelWeakCori::createBodyLayer);

        //Wildwood
        event.registerLayerDefinition(ModelBehemoth.LAYER_LOCATION, ModelBehemoth::createBodyLayer);
        event.registerLayerDefinition(ModelWildwoodTomo.LAYER_LOCATION, ModelWildwoodTomo::createBodyLayer);
        event.registerLayerDefinition(ModelEpiphite.LAYER_LOCATION, ModelEpiphite::createBodyLayer);
        event.registerLayerDefinition(ModelMage.LAYER_LOCATION, ModelMage::createBodyLayer);
        event.registerLayerDefinition(ModelMoonWolf.LAYER_LOCATION, ModelMoonWolf::createBodyLayer);
        event.registerLayerDefinition(ModelTermid.LAYER_LOCATION, ModelTermid::createBodyLayer);
        event.registerLayerDefinition(ModelSamek.LAYER_LOCATION, ModelSamek::createBodyLayer);
        event.registerLayerDefinition(ModelTwilightGolem.LAYER_LOCATION, ModelTwilightGolem::createBodyLayer);

        //Apalachia
        event.registerLayerDefinition(ModelApalachiaTomo.LAYER_LOCATION, ModelApalachiaTomo::createBodyLayer);
        event.registerLayerDefinition(ModelEnchantedArcher.LAYER_LOCATION, ModelEnchantedArcher::createBodyLayer);
        event.registerLayerDefinition(ModelEnchantedWarrior.LAYER_LOCATION, ModelEnchantedWarrior::createBodyLayer);
        event.registerLayerDefinition(ModelMystic.LAYER_LOCATION, ModelMystic::createBodyLayer);

        //Skythern
        event.registerLayerDefinition(ModelMegalith.LAYER_LOCATION, ModelMegalith::createBodyLayer);
        event.registerLayerDefinition(ModelSkythernFiend.LAYER_LOCATION, ModelSkythernFiend::createBodyLayer);
        event.registerLayerDefinition(ModelAdvancedCori.LAYER_LOCATION, ModelAdvancedCori::createBodyLayer);

        //Mortum
        event.registerLayerDefinition(ModelAngryGlinthop.LAYER_LOCATION, ModelAngryGlinthop::createBodyLayer);
        event.registerLayerDefinition(ModelBasilisk.LAYER_LOCATION, ModelBasilisk::createBodyLayer);
        event.registerLayerDefinition(ModelDemonOfDarkness.LAYER_LOCATION, ModelDemonOfDarkness::createBodyLayer);
        event.registerLayerDefinition(ModelSorcerer.LAYER_LOCATION, ModelSorcerer::createBodyLayer);
        event.registerLayerDefinition(ModelSoulSpider.LAYER_LOCATION, ModelSoulSpider::createBodyLayer);
        event.registerLayerDefinition(ModelSoulStealer.LAYER_LOCATION, ModelSoulStealer::createBodyLayer);
        event.registerLayerDefinition(ModelTwilightArcher.LAYER_LOCATION, ModelTwilightArcher::createBodyLayer);

        //Arcana
        event.registerLayerDefinition(ModelDeathcryx.LAYER_LOCATION, ModelDeathcryx::createBodyLayer);
        event.registerLayerDefinition(ModelDeathHound.LAYER_LOCATION, ModelDeathHound::createBodyLayer);
        event.registerLayerDefinition(ModelDungeonConstructor.LAYER_LOCATION, ModelDungeonConstructor::createBodyLayer);
        event.registerLayerDefinition(ModelDungeonDemon.LAYER_LOCATION, ModelDungeonDemon::createBodyLayer);
        event.registerLayerDefinition(ModelDungeonPrisoner.LAYER_LOCATION, ModelDungeonPrisoner::createBodyLayer);
        event.registerLayerDefinition(ModelRejuvGolem.LAYER_LOCATION, ModelRejuvGolem::createBodyLayer);
        event.registerLayerDefinition(ModelLeorna.LAYER_LOCATION, ModelLeorna::createBodyLayer);
        event.registerLayerDefinition(ModelParatiku.LAYER_LOCATION, ModelParatiku::createBodyLayer);
        event.registerLayerDefinition(ModelRazorback.LAYER_LOCATION, ModelRazorback::createBodyLayer);
        event.registerLayerDefinition(ModelRoamer.LAYER_LOCATION, ModelRoamer::createBodyLayer);
        event.registerLayerDefinition(ModelSeimer.LAYER_LOCATION, ModelSeimer::createBodyLayer);
        event.registerLayerDefinition(ModelSkyre.LAYER_LOCATION, ModelSkyre::createBodyLayer);
        event.registerLayerDefinition(ModelWraith.LAYER_LOCATION, ModelWraith::createBodyLayer);

        //Vethea
        event.registerLayerDefinition(ModelAcidHag.LAYER_LOCATION, ModelAcidHag::createBodyLayer);
        event.registerLayerDefinition(ModelBiphron.LAYER_LOCATION, ModelBiphron::createBodyLayer);
        event.registerLayerDefinition(ModelBohemite.LAYER_LOCATION, ModelBohemite::createBodyLayer);
        event.registerLayerDefinition(ModelCryptKeeper.LAYER_LOCATION, ModelCryptKeeper::createBodyLayer);
        event.registerLayerDefinition(ModelCymesoid.LAYER_LOCATION, ModelCymesoid::createBodyLayer);
        event.registerLayerDefinition(ModelDissiment.LAYER_LOCATION, ModelDissiment::createBodyLayer);
        event.registerLayerDefinition(ModelDreamwrecker.LAYER_LOCATION, ModelDreamwrecker::createBodyLayer);
        event.registerLayerDefinition(ModelDuo.LAYER_LOCATION, ModelDuo::createBodyLayer);
        event.registerLayerDefinition(ModelEnt.LAYER_LOCATION, ModelEnt::createBodyLayer);
        event.registerLayerDefinition(ModelVhraak.LAYER_LOCATION, ModelVhraak::createBodyLayer);
        event.registerLayerDefinition(ModelGalroid.LAYER_LOCATION, ModelGalroid::createBodyLayer);
        event.registerLayerDefinition(ModelGorgosion.LAYER_LOCATION, ModelGorgosion::createBodyLayer);
        event.registerLayerDefinition(ModelHelio.LAYER_LOCATION, ModelHelio::createBodyLayer);
        event.registerLayerDefinition(ModelHiveSoldier.LAYER_LOCATION, ModelHiveSoldier::createBodyLayer);
        event.registerLayerDefinition(ModelHoverStinger.LAYER_LOCATION, ModelHoverStinger::createBodyLayer);
        event.registerLayerDefinition(ModelKazrotic.LAYER_LOCATION, ModelKazrotic::createBodyLayer);
        event.registerLayerDefinition(ModelLheiva.LAYER_LOCATION, ModelLheiva::createBodyLayer);
        event.registerLayerDefinition(ModelLorga.LAYER_LOCATION, ModelLorga::createBodyLayer);
        event.registerLayerDefinition(ModelLorgaFlight.LAYER_LOCATION, ModelLorgaFlight::createBodyLayer);
        event.registerLayerDefinition(ModelMandragora.LAYER_LOCATION, ModelMandragora::createBodyLayer);
        event.registerLayerDefinition(ModelMysteriousMan.LAYER_LOCATION, ModelMysteriousMan::createBodyLayer);
        event.registerLayerDefinition(ModelShadahier.LAYER_LOCATION, ModelShadahier::createBodyLayer);
        event.registerLayerDefinition(ModelTheHunger.LAYER_LOCATION, ModelTheHunger::createBodyLayer);
        event.registerLayerDefinition(ModelTocaxin.LAYER_LOCATION, ModelTocaxin::createBodyLayer);
        event.registerLayerDefinition(ModelTwins.LAYER_LOCATION, ModelTwins::createBodyLayer);
        event.registerLayerDefinition(ModelVermenous.LAYER_LOCATION, ModelVermenous::createBodyLayer);
        event.registerLayerDefinition(ModelZone.LAYER_LOCATION, ModelZone::createBodyLayer);
        event.registerLayerDefinition(ModelZoragon.LAYER_LOCATION, ModelZoragon::createBodyLayer);

        //Blocks
        event.registerLayerDefinition(ModelArcaniumExtractor.LAYER_LOCATION, ModelArcaniumExtractor::createBodyLayer);
        event.registerLayerDefinition(ModelBoneChest.LAYER_LOCATION, ModelBoneChest::createBodyLayer);
        event.registerLayerDefinition(ModelDemonFurnace.LAYER_LOCATION, ModelDemonFurnace::createBodyLayer);
        event.registerLayerDefinition(ModelDramixAltar.LAYER_LOCATION, ModelDramixAltar::createBodyLayer);
        event.registerLayerDefinition(ModelEdenChest.LAYER_LOCATION, ModelEdenChest::createBodyLayer);
        event.registerLayerDefinition(ModelFrostedChest.LAYER_LOCATION, ModelFrostedChest::createBodyLayer);
        event.registerLayerDefinition(ModelParasectaAltar.LAYER_LOCATION, ModelParasectaAltar::createBodyLayer);
        event.registerLayerDefinition(ModelPresentBox.LAYER_LOCATION, ModelPresentBox::createBodyLayer);

        //Misc
        event.registerLayerDefinition(ModelHat.LAYER_LOCATION, ModelHat::createBodyLayer);
        event.registerLayerDefinition(RenderNightmareBed.HEAD, RenderNightmareBed::createHeadLayer);
        event.registerLayerDefinition(RenderNightmareBed.FOOT, RenderNightmareBed::createFootLayer);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        DivineRPG.LOGGER.info("[DivineRPG] Registered entity renders");
        //Projectile
        event.registerEntityRenderer(ATTRACTOR.get(), 				(Context context) -> new RenderDivineProjectile<>(context));
        event.registerEntityRenderer(BOUNCING_PROJECTILE.get(), 	(Context context) -> new RenderDivineProjectile<>(context, "bouncing_projectile"));
        event.registerEntityRenderer(CAVE_ROCK.get(), 				(Context context) -> new RenderDivineProjectile<>(context, "cave_rock"));
        event.registerEntityRenderer(CORI_SHOT.get(), 				(Context context) -> new RenderDivineProjectile<>(context, "cori_shot"));
        event.registerEntityRenderer(CORRUPTED_BULLET.get(), 		(Context context) -> new RenderItemProjectile<>(context, "corrupted_bullet"));
        event.registerEntityRenderer(COLORED_BULLET.get(), 			(Context context) -> new RenderShooterBullet<>(context));
        event.registerEntityRenderer(DISK.get(), 					(Context context) -> new RenderDisk<>(context));
        event.registerEntityRenderer(DISSIMENT_SHOT.get(), 			(Context context) -> new RenderDivineProjectile<>(context, "dissiment_shot"));
        event.registerEntityRenderer(ARROW_SHOT.get(), 				(Context context) -> new RenderDivineArrow<>(context));
        event.registerEntityRenderer(ENDER_TRIPLETS_FIREBALL.get(), (Context context) -> new RenderDivineFireball<>(context, "ender_triplets_fireball"));
        event.registerEntityRenderer(FIREFLY.get(), 				(Context context) -> new RenderDivineProjectile<>(context, "firefly"));
        event.registerEntityRenderer(FRACTITE_SHOT.get(), 			(Context context) -> new RenderDivineFireball<>(context, "fractite_shot"));
        event.registerEntityRenderer(FROST_SHOT.get(), 				(Context context) -> new RenderDivineFireball<>(context, "frost_shot"));
        event.registerEntityRenderer(FYRACRYX_FIREBALL.get(), 		(Context context) -> new RenderDivineFireball<>(context, new ResourceLocation("minecraft:textures/items/fireball.png")));
        event.registerEntityRenderer(GENERALS_STAFF.get(), 			(Context context) -> new RenderDivineProjectile<>(context, "generals_staff"));
        event.registerEntityRenderer(GRENADE.get(), 				(Context context) -> new RenderItemProjectile<>(context, "grenade"));
        event.registerEntityRenderer(KAZROTIC_SHOT.get(), 			(Context context) -> new RenderDivineProjectile<>(context, "kazrotic_shot"));
        event.registerEntityRenderer(KING_OF_SCORCHERS_METEOR.get(),(Context context) -> new RenderDivineProjectile<>(context, "king_of_scorchers_meteor"));
        event.registerEntityRenderer(KING_OF_SCORCHERS_SHOT.get(), 	(Context context) -> new RenderDivineProjectile<>(context, "king_of_scorchers_shot"));
        event.registerEntityRenderer(LADY_LUNA_SPARKLER.get(), 		(Context context) -> new RenderShooterBullet<>(context));
        event.registerEntityRenderer(MAGE_SHOT.get(), 				(Context context) -> new RenderDivineProjectile<>(context));
        event.registerEntityRenderer(MANDRAGORA_PROJECTILE.get(), 	(Context context) -> new RenderDivineProjectile<>(context, "mandragora_projectile"));
        event.registerEntityRenderer(MERIKS_MISSILE.get(), 			(Context context) -> new RenderDivineProjectile<>(context, "meriks_missile"));
        event.registerEntityRenderer(METEOR.get(), 					(Context context) -> new RenderDivineProjectile<>(context, "meteor"));
        event.registerEntityRenderer(PARTICLE_BULLET.get(), 		(Context context) -> new RenderShooterBullet<>(context));
        event.registerEntityRenderer(RAGLOK_BOMB.get(), 			(Context context) -> new RenderDivineProjectile<>(context, "raglok_bomb"));
        event.registerEntityRenderer(REFLECTOR.get(), 				(Context context) -> new RenderDivineProjectile<>(context));
        event.registerEntityRenderer(SAGUARO_WORM_SHOT.get(), 		(Context context) -> new RenderSaguaroWormShot(context));
        event.registerEntityRenderer(SCORCHER_SHOT.get(), 			(Context context) -> new RenderDivineFireball<>(context, "scorcher_shot"));
        event.registerEntityRenderer(SERENADE_OF_DEATH.get(), 		(Context context) -> new RenderDivineProjectile<>(context, "serenade_of_death"));
        event.registerEntityRenderer(SERENADE_OF_ICE.get(), 		(Context context) -> new RenderDivineProjectile<>(context));
        event.registerEntityRenderer(SHOOTER_BULLET.get(), 			(Context context) -> new RenderShooterBullet<>(context));
        event.registerEntityRenderer(SHURIKEN.get(), 				(Context context) -> new RenderItemProjectile<>(context, "shuriken"));
        event.registerEntityRenderer(SKYRE_BULLET.get(), 		    (Context context) -> new RenderDivineProjectile<>(context, "skyre_bullet"));
        event.registerEntityRenderer(SNOWFLAKE_SHURIKEN.get(), 		(Context context) -> new RenderItemProjectile<>(context, "snowflake_shuriken"));
        event.registerEntityRenderer(SOUL_FIEND_SHOT.get(), 		(Context context) -> new RenderDivineProjectile<>(context));
        event.registerEntityRenderer(SOUND_OF_CAROLS.get(), 		(Context context) -> new RenderDivineProjectile<>(context, "music"));
        event.registerEntityRenderer(SOUND_OF_MUSIC.get(), 			(Context context) -> new RenderDivineProjectile<>(context, "music"));
        event.registerEntityRenderer(SOUND_OF_WHALES.get(), 		(Context context) -> new RenderDivineProjectile<>(context, "music"));
        event.registerEntityRenderer(SPARKLER.get(), 				(Context context) -> new RenderDivineProjectile<>(context, "sparkler"));
        event.registerEntityRenderer(STARLIGHT.get(), 				(Context context) -> new RenderDivineProjectile<>(context, "starlight"));
        event.registerEntityRenderer(TWILIGHT_DEMON_SHOT.get(), 	(Context context) -> new RenderDivineProjectile<>(context, "twilight_demon_shot"));
        event.registerEntityRenderer(TWILIGHT_MAGE_SHOT.get(), 		(Context context) -> new RenderDivineProjectile<>(context));
        event.registerEntityRenderer(VILE_STORM.get(), 				(Context context) -> new RenderItemProjectile<>(context, "vile_storm"));
        event.registerEntityRenderer(WATCHER_SHOT.get(), 			(Context context) -> new RenderDivineProjectile<>(context, "watcher_shot"));
        event.registerEntityRenderer(WRECK_BOUNCING_PROJECTILE.get(),(Context context) -> new RenderDivineProjectile<>(context, "wreck_bouncing_projectile"));
        event.registerEntityRenderer(WRECK_EXPLOSIVE_SHOT.get(), 	(Context context) -> new RenderDivineProjectile<>(context, "wreck_explosive_shot"));
        event.registerEntityRenderer(WRECK_SHOT.get(), 				(Context context) -> new RenderDivineProjectile<>(context, "wreck_shot"));
        event.registerEntityRenderer(ZORAGON_BOMB.get(), 			(Context context) -> new RenderDivineProjectile<>(context, "zoragon_bomb"));
        event.registerEntityRenderer(TOMATO.get(), 			        (Context context) -> new RenderDivineProjectile<>(context, new ResourceLocation(MODID, "textures/item/tomato.png")));
        event.registerEntityRenderer(WILDWOOD_LOG.get(), 			(Context context) -> new RenderWildwoodLog(context));
        event.registerEntityRenderer(FROST_CLOUD.get(), 			(Context context) -> new RenderFrostCloud(context));

        //Boss
        event.registerEntityRenderer(ANCIENT_ENTITY.get(), 	(Context context) -> new RenderDivineMob<>(context, "ancient_entity", 	new ModelAncientEntity(context), 6F, 6F));
        event.registerEntityRenderer(AYERACO.get(),			RenderAyeraco::new);
        event.registerEntityRenderer(DENSOS.get(), 			(Context context) -> new RenderDivineMob<>(context, "densos", 			new ModelDensos<>(context), 0.4F));
        event.registerEntityRenderer(DRAMIX.get(), 			(Context context) -> new RenderDivineMob<>(context, "dramix", 			new ModelDramix<>(context), 0.4F));
        event.registerEntityRenderer(ETERNAL_ARCHER.get(),  RenderEternalArcher::new);
        event.registerEntityRenderer(EXPERIENCED_CORI.get(),(Context context) -> new RenderDivineMob<>(context, "experienced_cori", new ModelExperiencedCori(context), 1F, 5F));
        event.registerEntityRenderer(KITRA.get(), 	RenderKitra::new);
        event.registerEntityRenderer(HIVE_QUEEN.get(), 		(Context context) -> new RenderDivineMob<>(context, "hive_queen", 		new ModelHiveQueen(context), 0.4F));
        event.registerEntityRenderer(KAROS.get(), 			(Context context) -> new RenderDivineMob<>(context, "karos", 			new ModelKaros(context)));
        event.registerEntityRenderer(KAROT.get(), 			(Context context) -> new RenderDivineMob<>(context, "karot", 			new ModelKarot(context), 0.5F, 5F));
        event.registerEntityRenderer(KING_OF_SCORCHERS.get(),(Context context) -> new RenderDivineMob<>(context,"king_of_scorchers",new ModelKingOfScorchers(context)));
        event.registerEntityRenderer(LADY_LUNA.get(), 		RenderLadyLuna::new);
        event.registerEntityRenderer(PARASECTA.get(), 		(Context context) -> new RenderDivineMob<>(context, "parasecta", 		new ModelParasecta(context), 0.8F));
        event.registerEntityRenderer(QUADRO.get(), 			(Context context) -> new RenderDivineMob<>(context, "quadro", 			new ModelQuadro(context)));
        event.registerEntityRenderer(RAGLOK.get(), 			(Context context) -> new RenderDivineMob<>(context, "raglok", 			new ModelRaglok(context)));
        event.registerEntityRenderer(REYVOR.get(), 			(Context context) -> new RenderDivineMob<>(context, "reyvor", 			new ModelReyvor<>(context), 0.8F));
        event.registerEntityRenderer(SOUL_FIEND.get(), 		(Context context) -> new RenderDivineMob<>(context, "soul_fiend", 		new ModelSoulFiend(context)));
        event.registerEntityRenderer(SUNSTORM.get(), 		(Context context) -> new RenderDivineMob<>(context, "sunstorm", 		new ModelSunstorm<>(context), 1.2F));
        event.registerEntityRenderer(TERMASECT.get(), 		(Context context) -> new RenderDivineMob<>(context, "termasect", 		new ModelTermasect<>(context), 0.5F, 5F));
        event.registerEntityRenderer(THE_WATCHER.get(), 	(Context context) -> new RenderDivineMob<>(context, "the_watcher",		new ModelWatcher(context), 0.5F, 6F));
        event.registerEntityRenderer(TWILIGHT_DEMON.get(), 	(Context context) -> new RenderDivineMob<>(context, "twilight_demon", 	new ModelTwilightDemon(context), 0.5F, 2F));
        event.registerEntityRenderer(VAMACHERON.get(), 		(Context context) -> new RenderDivineMob<>(context, "mortum_cadillion", new ModelVamacheron(context), 0.5F, 1.6F));
        event.registerEntityRenderer(WRECK.get(), 			RenderWreck::new);

        //Overworld
        event.registerEntityRenderer(AEQUOREA.get(),		 RenderAequorea::new);
        event.registerEntityRenderer(ARID_WARRIOR.get(),	 RenderAridWarrior::new);
        event.registerEntityRenderer(CAVE_CRAWLER.get(),	 (Context context) -> new RenderDivineMob<>(context, "cave_crawler", new ModelCaveCrawler(context), 0.5F));
        event.registerEntityRenderer(BROWN_GRIZZLE.get(),	 (Context context) -> new RenderDivineMob<>(context, "brown_grizzle", new ModelGrizzle<>(context)));
        event.registerEntityRenderer(CAVECLOPS.get(),		 (Context context) -> new RenderDivineMob<>(context,"caveclops",new HumanoidModel<>(context.bakeLayer(layerHumanoid)), 0.8F, 2F));
        event.registerEntityRenderer(CRAB.get(),			 (Context context) -> new RenderDivineMob<>(context, "crab", new ModelCrab(context), 0.6F));
        event.registerEntityRenderer(CYCLOPS.get(),			 RenderCyclops::new);
        event.registerEntityRenderer(DESERT_CRAWLER.get(),	 (Context context) -> new RenderDivineMob<>(context, "desert_crawler", new ModelDesertCrawler(context), 0.7F));
        event.registerEntityRenderer(DIAMOND_DAVE.get(),     (Context context) -> new RenderDivineMob<>(context, "diamond_dave", new HumanoidModel<>(context.bakeLayer(layerHumanoid)), 0.5F));
        event.registerEntityRenderer(EHU.get(),				 (Context context) -> new RenderPet(context, "ehu", new ModelEhu(context), 0.5F));
        event.registerEntityRenderer(ENTHRALLED_DRAMCRYX.get(),(Context context) -> new RenderDivineMob<>(context, "enthralled_dramcryx", new ModelEnthralledDramcryx(context), 0.9F, 1.2F));
        event.registerEntityRenderer(FROST.get(),			 (Context context) -> new RenderDivineMob<>(context, "frost", new ModelFrost(context), 0.6F));
        event.registerEntityRenderer(GLACON.get(),			 (Context context) -> new RenderDivineMob<>(context, "glacon", new ModelGlacon(context), 0.8F));
        event.registerEntityRenderer(HUSK.get(),			 (Context context) -> new RenderDivineMob<>(context, "husk", new ModelHusk(context), 0.4F));
        event.registerEntityRenderer(JACK_O_MAN.get(),		 RenderJackOMan::new);
        event.registerEntityRenderer(JUNGLE_BAT.get(),		 (Context context) -> new RenderDivineBat<>(context, "jungle_bat", 0.2F));
        event.registerEntityRenderer(JUNGLE_DRAMCRYX.get(),	 (Context context) -> new RenderDivineMob<>(context, "jungle_dramcryx", new ModelJungleDramcryx<>(context), 0.64F, 1.5F));
        event.registerEntityRenderer(JUNGLE_SPIDER.get(),	 (Context context) -> new RenderDivineMob<>(context, "jungle_spider", new ModelJungleSpider(context), 0.8F));
        event.registerEntityRenderer(KING_CRAB.get(),		 (Context context) -> new RenderDivineMob<>(context, "king_crab", new ModelKingCrab(context), 1.3F, 1.2F));
        event.registerEntityRenderer(KOBBLIN.get(),			 RenderKobblin::new);
        event.registerEntityRenderer(LIOPLEURODON.get(),	 RenderLiopleurodon::new);
        event.registerEntityRenderer(LIVESTOCK_MERCHANT.get(),(Context context) -> new RenderDivineMob<>(context, "livestock_merchant", new ModelLivestockMerchant(context), 0.4F));
        event.registerEntityRenderer(MINER.get(),			 RenderMiner::new);
        event.registerEntityRenderer(PUMPKIN_SPIDER.get(),	 (Context context) -> new RenderDivineMob<>(context, "pumpkin_spider", new ModelPumpkinSpider(context), 0.5F));
        event.registerEntityRenderer(RAINBOUR.get(),		 RenderRainbour::new);
        event.registerEntityRenderer(ROTATICK.get(),		 RenderRotatick::new);
        event.registerEntityRenderer(SAGUARO_WORM.get(),	 (Context context) -> new RenderDivineMob<>(context, "saguaro_worm", new ModelSaguaroWorm(context), 0.3F));
        event.registerEntityRenderer(SHARK.get(),			 (Context context) -> new RenderDivineMob<>(context, "shark", new ModelShark<>(context), 0.8F));
        event.registerEntityRenderer(SMELTER.get(),			 (Context context) -> new RenderDivineMob<>(context, "smelter", new ModelStoneGolem<>(context)));
        event.registerEntityRenderer(SNAPPER.get(),			 (Context context) -> new RenderPet(context, "snapper", new ModelSnapper<>(context), 0.7F));
        event.registerEntityRenderer(STONE_GOLEM.get(),		 (Context context) -> new RenderDivineMob<>(context, "stone_golem", new ModelStoneGolem<>(context)));
        event.registerEntityRenderer(THE_EYE.get(),			 RenderTheEye::new);
        event.registerEntityRenderer(THE_GRUE.get(),		 (Context context) -> new RenderDivineMob<>(context, "the_grue", new ModelTheGrue(context), 0.8F));
        event.registerEntityRenderer(WHALE.get(),			 (Context context) -> new RenderDivineMob<>(context, "whale", new ModelWhale(context), 0.8F, 5F));
        event.registerEntityRenderer(WHITE_GRIZZLE.get(),	 (Context context) -> new RenderDivineMob<>(context, "white_grizzle", new ModelGrizzle<>(context)));

        //Nether
        event.registerEntityRenderer(HELL_PIG.get(),	RenderHellPig::new);
        event.registerEntityRenderer(HELL_SPIDER.get(), (Context context) -> new RenderDivineMob<>(context, "hell_spider", new ModelHellSpider(context), 0.2F));
        event.registerEntityRenderer(SCORCHER.get(),	(Context context) -> new RenderDivineMob<>(context, "scorcher", new ModelScorcher(context), 0.72F, 1.5F));
        event.registerEntityRenderer(WILDFIRE.get(),	RenderWildfire::new);

        //End
        event.registerEntityRenderer(ENDER_SPIDER.get(),  (Context context) -> new RenderDivineMob<>(context, "ender_spider", new SpiderModel<>(context.bakeLayer(layerSpider)), 0.5F, 0.6F));
        event.registerEntityRenderer(ENDER_SCROUNGE.get(),     (Context context) -> new RenderDivineMob<>(context, "ender_scrounge", new ModelEnderScrounge(context), 0.1F, 0.5F));
        event.registerEntityRenderer(ENDER_TRIPLETS.get(),(Context context) -> new RenderDivineMob<>(context, "ender_triplets", new ModelEnderTriplets(context), 0.4F));
        event.registerEntityRenderer(ENDER_WATCHER.get(), (Context context) -> new RenderDivineMob<>(context, "ender_watcher", new ModelWatcher(context), 0.4F));

        //Iceika
        event.registerEntityRenderer(BLUBBERTUSK.get(),		(Context context) -> new RenderDivineMob<>(context, "blubbertusk", new ModelBlubbertusk(context), .7F));
        event.registerEntityRenderer(CAULDRON_FISH.get(),	(Context context) -> new RenderDivineMob<>(context, "cauldron_fish", new ModelCauldronFish(context), .3F));
        event.registerEntityRenderer(DOLOSSAL.get(),		(Context context) -> new RenderDivineMob<>(context, "dolossal", new ModelDolossal(context), .9F));
        event.registerEntityRenderer(MAMOTH.get(),			(Context context) -> new RenderDivineMob<>(context, "mamoth", new ModelMamoth(context), .9F));
        event.registerEntityRenderer(SNOW_SKIPPER.get(),	(Context context) -> new RenderDivineMob<>(context, "snow_skipper", new ModelSnowSkipper(context), .4F));
        event.registerEntityRenderer(PINK_GHOST_GLIDER.get(),(Context context) -> new RenderDivineMob<>(context, "pink_ghost_glider", new ModelGhostGlider(context), .5F));
        event.registerEntityRenderer(ALICANTO.get(),		 (Context context) -> new RenderDivineMob<>(context, "alicanto",  new ModelAlicanto(context), .7F));
        event.registerEntityRenderer(FRACTITE.get(),		 (Context context) -> new RenderDivineMob<>(context, "fractite",  new ModelFractite(context), .5F, 2F));
        event.registerEntityRenderer(PALE_ARCHER.get(),	     RenderPaleArcher::new);
        event.registerEntityRenderer(FROZEN_FLESH.get(),	 (Context context) -> new RenderDivineMob<>(context, "frozen_flesh",  new ModelFrozenFlesh(context), .5F));
        event.registerEntityRenderer(GLACIDE.get(),			 (Context context) -> new RenderDivineMob<>(context, "glacide",  new ModelGlacide(context)));
        event.registerEntityRenderer(HASTREUS.get(),		 (Context context) -> new RenderDivineMob<>(context, "hastreus",  new ModelHastreus(context)));
        event.registerEntityRenderer(ROLLUM.get(),			 (Context context) -> new RenderDivineMob<>(context, "rollum",  new ModelRollum(context), .8F));
        event.registerEntityRenderer(WORKSHOP_MERCHANT.get(),(Context context) -> new RenderDivineMob<>(context, "workshop_merchant",  new ModelWorkshopMerchant(context), .6F));
        event.registerEntityRenderer(WORKSHOP_TINKERER.get(),(Context context) -> new RenderDivineMob<>(context, "workshop_tinkerer",  new ModelWorkshopTinkerer(context), .6F));
        event.registerEntityRenderer(SENG.get(),             (Context context) -> new RenderDivineMob<>(context, "seng",  new ModelSeng(context), .65F));
        event.registerEntityRenderer(SABEAR.get(),           (Context context) -> new RenderDivineMob<>(context, "sabear",  new ModelSabear(context), .8F));
        event.registerEntityRenderer(WOLPERTINGER.get(),     (Context context) -> new RenderDivineMob<>(context, "wolpertinger",  new ModelWolpertinger(context), .6F));
        event.registerEntityRenderer(ROBBIN.get(),           RenderRobbin::new);
        //Groglin
        event.registerEntityRenderer(GROGLIN_CHIEFTAIN.get(),RenderGroglin::new);
        event.registerEntityRenderer(GROGLIN_HUNTER.get(),	RenderGroglin::new);
        event.registerEntityRenderer(GROGLIN_MERCHANT.get(),RenderGroglin::new);
        event.registerEntityRenderer(GROGLIN_RANGER.get(),	RenderGroglin::new);
        event.registerEntityRenderer(GROGLIN_SHARLATAN.get(),RenderGroglin::new);
        event.registerEntityRenderer(GROGLIN_WARRIOR.get(),	RenderGroglin::new);
        //Gruzzorlug
        event.registerEntityRenderer(GRUZZORLUG_CANNONEER.get(),RenderGruzzorlug::new);
        event.registerEntityRenderer(GRUZZORLUG_COMMANDER.get(),RenderGruzzorlug::new);
        event.registerEntityRenderer(GRUZZORLUG_GENERAL.get(),	RenderGruzzorlug::new);
        event.registerEntityRenderer(GRUZZORLUG_KNIGHT.get(),	RenderGruzzorlug::new);
        event.registerEntityRenderer(GRUZZORLUG_MINER.get(),	RenderGruzzorlug::new);
        event.registerEntityRenderer(GRUZZORLUG_SWORDSMAN.get(),RenderGruzzorlug::new);

        //Eden
        event.registerEntityRenderer(GLINTHOP.get(),	    RenderGlinthop::new);
        event.registerEntityRenderer(EDEN_CADILLION.get(),(Context context) -> new RenderDivineMob<>(context, "eden_cadillion",  new ModelCadillion(context), 0.7F));
        event.registerEntityRenderer(EDEN_TOMO.get(),	  (Context context) -> new RenderDivineMob<>(context, "eden_tomo",  new ModelEdenTomo(context), 0.65F, 1.2F));
        event.registerEntityRenderer(GEM_FIN.get(),	        RenderGemFin::new);
        event.registerEntityRenderer(GREENFEET.get(),	  (Context context) -> new RenderDivineMob<>(context, "greenfeet",  new ModelGreenfeet(context), 0.6F));
        event.registerEntityRenderer(MADIVEL.get(),		  (Context context) -> new RenderDivineMob<>(context, "madivel",  new ModelMadivel(context), 0.85F));
        event.registerEntityRenderer(SUN_ARCHER.get(),	  RenderSunArcher::new);
        event.registerEntityRenderer(WEAK_CORI.get(),	  (Context context) -> new RenderDivineMob<>(context, "weak_cori",  new ModelWeakCori(context), 0.7F));

        //Wildwood
        event.registerEntityRenderer(BEHEMOTH.get(), (Context context) -> new RenderDivineMob<>(context, "behemoth",  new ModelBehemoth(context)));
        event.registerEntityRenderer(EPIPHITE.get(), (Context context) -> new RenderDivineMob<>(context, "epiphite",  new ModelEpiphite<>(context), 0.7F));
        event.registerEntityRenderer(MAGE.get(),	 (Context context) -> new RenderDivineMob<>(context, "mage",  new ModelMage<>(context)));
        event.registerEntityRenderer(MOON_WOLF.get(), RenderMoonWolf::new);
        event.registerEntityRenderer(TERMID.get(),	 (Context context) -> new RenderDivineMob<>(context, "termid",  new ModelTermid<>(context), 0.6F));
        event.registerEntityRenderer(VEREK.get(),	 (Context context) -> new RenderDivineMob<>(context, "verek",  new ModelSamek<>(context)));
        event.registerEntityRenderer(WILDWOOD_CADILLION.get(),(Context context) -> new RenderDivineMob<>(context, "wildwood_cadillion",  new ModelCadillion(context), 0.7F));
        event.registerEntityRenderer(WILDWOOD_GOLEM.get(),	  (Context context) -> new RenderDivineMob<>(context, "wildwood_golem",  new ModelTwilightGolem<>(context)));
        event.registerEntityRenderer(WILDWOOD_TOMO.get(),	  (Context context) -> new RenderDivineMob<>(context, "wildwood_tomo",  new ModelWildwoodTomo<>(context)));

        //Apalachia
        event.registerEntityRenderer(APALACHIA_CADILLION.get(), (Context context) -> new RenderDivineMob<>(context, "apalachia_cadillion",  new ModelCadillion(context), 0.7F));
        event.registerEntityRenderer(APALACHIA_GOLEM.get(),		(Context context) -> new RenderDivineMob<>(context, "apalachia_golem",  new ModelTwilightGolem<>(context)));
        event.registerEntityRenderer(APALACHIA_TOMO.get(),		(Context context) -> new RenderDivineMob<>(context, "apalachia_tomo",  new ModelApalachiaTomo(context), 0.65F, 1.2F));
        event.registerEntityRenderer(ENCHANTED_ARCHER.get(),	RenderEnchantedArcher::new);
        event.registerEntityRenderer(ENCHANTED_WARRIOR.get(),	RenderEnchantedWarrior::new);
        event.registerEntityRenderer(SPELLBINDER.get(),			(Context context) -> new RenderDivineMob<>(context, "spellbinder",  new ModelMystic<>(context)));

        //Skythern
        event.registerEntityRenderer(ADVANCED_CORI.get(),(Context context) -> new RenderDivineMob<>(context, "advanced_cori",  new ModelAdvancedCori<>(context)));
        event.registerEntityRenderer(MEGALITH.get(),	 (Context context) -> new RenderDivineMob<>(context, "megalith",  new ModelMegalith<>(context)));
        event.registerEntityRenderer(MYSTIC.get(),		 (Context context) -> new RenderDivineMob<>(context, "mystic",  new ModelMystic<>(context)));
        event.registerEntityRenderer(SAMEK.get(),		 (Context context) -> new RenderDivineMob<>(context, "samek",  new ModelSamek<>(context)));
        event.registerEntityRenderer(SKYTHERN_ARCHER.get(),RenderSkythernArcher::new);
        event.registerEntityRenderer(SKYTHERN_FIEND.get(), (Context context) -> new RenderDivineMob<>(context, "skythern_fiend",  new ModelSkythernFiend<>(context)));
        event.registerEntityRenderer(SKYTHERN_GOLEM.get(), (Context context) -> new RenderDivineMob<>(context, "skythern_golem",  new ModelTwilightGolem<>(context)));

        //Mortum
        event.registerEntityRenderer(ANGRY_GLINTHOP.get(),	 (Context context) -> new RenderDivineMob<>(context, "glinthop_angry",  new ModelAngryGlinthop(context), 0.8F));
        event.registerEntityRenderer(BASILISK.get(),		 (Context context) -> new RenderDivineMob<>(context, "basilisk",  new ModelBasilisk(context), 0.8F));
        event.registerEntityRenderer(DEMON_OF_DARKNESS.get(),RenderDemonOfDarkness::new);
        event.registerEntityRenderer(MORTUM_CADILLION.get(), (Context context) -> new RenderDivineMob<>(context, "mortum_cadillion",  new ModelCadillion(context), 0.7F));
        event.registerEntityRenderer(SORCERER.get(),		 (Context context) -> new RenderDivineMob<>(context, "sorcerer",  new ModelSorcerer<>(context)));
        event.registerEntityRenderer(SOUL_SPIDER.get(),		 (Context context) -> new RenderDivineMob<>(context, "soul_spider", new ModelSoulSpider<>(context), 0.3F));
        event.registerEntityRenderer(SOUL_STEALER.get(),	 (Context context) -> new RenderDivineMob<>(context, "soul_stealer", new ModelSoulStealer(context)));
        event.registerEntityRenderer(TWILIGHT_ARCHER.get(),  RenderTwilightArcher::new);

        //Arcana
        event.registerEntityRenderer(CAPTAIN_MERIK.get(),	  (Context context) -> new RenderDivineMob<>(context, "captain_merik", new ModelSamek<>(context)));
        event.registerEntityRenderer(DATTICON.get(),		  (Context context) -> new RenderDivineMob<>(context, "datticon", new ModelSamek<>(context)));
        event.registerEntityRenderer(DEATHCRYX.get(),		  (Context context) -> new RenderDivineMob<>(context, "deathcryx", new ModelDeathcryx<>(context), 0.8F,  1.1F));
        event.registerEntityRenderer(DEATH_HOUND.get(),		  (Context context) -> new RenderDivineMob<>(context, "death_hound", new ModelDeathHound(context), 0.7F));
        event.registerEntityRenderer(DUNGEON_CONSTRUCTOR.get(),(Context context) -> new RenderDivineMob<>(context, "dungeon_constructor", new ModelDungeonConstructor<>(context), 0.4F, 0.4F));
        event.registerEntityRenderer(DUNGEON_DEMON.get(),	  (Context context) -> new RenderDivineMob<>(context, "dungeon_demon", new ModelDungeonDemon<>(context)));
        event.registerEntityRenderer(DUNGEON_PRISONER.get(),  (Context context) -> new RenderDivineMob<>(context, "dungeon_prisoner", new ModelDungeonPrisoner(context), 0.9F));
        event.registerEntityRenderer(FYRACRYX.get(),		  (Context context) -> new RenderDivineMob<>(context, "fyracryx", new ModelDeathcryx<>(context)));
        event.registerEntityRenderer(GOLEM_OF_REJUVENATION.get(),(Context context) -> new RenderDivineMob<>(context, "golem_of_rejuvenation", new ModelRejuvGolem<>(context)));
        event.registerEntityRenderer(KAZARI.get(),			  (Context context) -> new RenderDivineMob<>(context, "kazari", new HumanoidModel<>(context.bakeLayer(layerHumanoid)), 0.8F));
        event.registerEntityRenderer(LEORNA.get(),			  (Context context) -> new RenderDivineMob<>(context, "leorna", new ModelLeorna<>(context)));
        event.registerEntityRenderer(LORD_VATTICUS.get(),	  (Context context) -> new RenderDivineMob<>(context, "lord_vatticus", new HumanoidModel<>(context.bakeLayer(layerHumanoid)), 0.8F));
        event.registerEntityRenderer(LIVING_STATUE.get(),	  (Context context) -> new RenderDivineMob<>(context, "living_statue", new HumanoidModel<>(context.bakeLayer(layerHumanoid)), 0.5F));
        event.registerEntityRenderer(PARATIKU.get(),		  (Context context) -> new RenderDivineMob<>(context, "paratiku", new ModelParatiku<>(context)));
        event.registerEntityRenderer(RAZORBACK.get(),		  (Context context) -> new RenderDivineMob<>(context, "razorback", new ModelRazorback(context), 0.4F));
        event.registerEntityRenderer(ROAMER.get(),			  (Context context) -> new RenderDivineMob<>(context, "roamer", new ModelRoamer(context)));
        event.registerEntityRenderer(SEIMER.get(),			  (Context context) -> new RenderDivineMob<>(context, "seimer", new ModelSeimer<>(context)));
        event.registerEntityRenderer(SKYRE.get(),			  (Context context) -> new RenderDivineMob<>(context, "skyre", new ModelSkyre<>(context), 0.25F, 0.5F));
        event.registerEntityRenderer(WAR_GENERAL.get(),		  (Context context) -> new RenderDivineMob<>(context, "war_general", new ModelSamek<>(context)));
        event.registerEntityRenderer(WRAITH.get(),			  (Context context) -> new RenderDivineMob<>(context, "wraith", new ModelWraith<>(context)));
        event.registerEntityRenderer(ZELUS.get(),			  (Context context) -> new RenderDivineMob<>(context, "zelus", new HumanoidModel<>(context.bakeLayer(layerHumanoid)), 0.5F));

        //Vethea
        event.registerEntityRenderer(ACID_HAG.get(), (Context context) -> new RenderDivineMob<>(context, "acid_hag", new ModelAcidHag<>(context)));
        event.registerEntityRenderer(BIPHRON.get(), (Context context) -> new RenderDivineMob<>(context, "biphron", new ModelBiphron<>(context)));
        event.registerEntityRenderer(BOHEMITE.get(), (Context context) -> new RenderDivineMob<>(context, "bohemite", new ModelBohemite<>(context)));
        event.registerEntityRenderer(CRYPT_KEEPER.get(), (Context context) -> new RenderDivineMob<>(context, "crypt_keeper", new ModelCryptKeeper<>(context)));
        event.registerEntityRenderer(CYMESOID.get(), (Context context) -> new RenderDivineMob<>(context, "cymesoid", new ModelCymesoid<>(context)));
        event.registerEntityRenderer(DISSIMENT.get(), (Context context) -> new RenderDivineMob<>(context, "dissiment", new ModelDissiment<>(context)));
        event.registerEntityRenderer(DREAMWRECKER.get(), (Context context) -> new RenderDivineMob<>(context, "dreamwrecker", new ModelDreamwrecker<>(context)));
        event.registerEntityRenderer(DUO.get(), (Context context) -> new RenderDivineMob<>(context, "duo", new ModelDuo(context)));
        event.registerEntityRenderer(ENT.get(), (Context context) -> new RenderDivineMob<>(context, "ent", new ModelEnt<>(context)));
        event.registerEntityRenderer(FAKE_VHRAAK.get(), (Context context) -> new RenderDivineMob<>(context, "vhraak", new ModelVhraak<>(context)));
        event.registerEntityRenderer(GALROID.get(), (Context context) -> new RenderGalroid(context, "galroid", new ModelGalroid<>(context)));
        event.registerEntityRenderer(GORGOSION.get(), (Context context) -> new RenderDivineMob<>(context, "gorgosion", new ModelGorgosion<>(context)));
        event.registerEntityRenderer(HELIO.get(), (Context context) -> new RenderDivineMob<>(context, "helio", new ModelHelio<>(context)));
        event.registerEntityRenderer(HIVE_SOLDIER.get(), (Context context) -> new RenderDivineMob<>(context, "hive_soldier", new ModelHiveSoldier<>(context)));
        event.registerEntityRenderer(HOVER_STINGER.get(), (Context context) -> new RenderDivineMob<>(context, "hover_stinger", new ModelHoverStinger<>(context)));
        event.registerEntityRenderer(KAZROTIC.get(), (Context context) -> new RenderDivineMob<>(context, "kazrotic", new ModelKazrotic<>(context)));
        event.registerEntityRenderer(LHEIVA.get(), (Context context) -> new RenderDivineMob<>(context, "lheiva", new ModelLheiva<>(context)));
        event.registerEntityRenderer(LORGA.get(), (Context context) -> new RenderDivineMob<>(context, "lorga", new ModelLorga<>(context)));
        event.registerEntityRenderer(LORGA_FLIGHT.get(), (Context context) -> new RenderDivineMob<>(context, "lorgaflight", new ModelLorgaFlight<>(context)));
        event.registerEntityRenderer(MANDRAGORA.get(), (Context context) -> new RenderDivineMob<>(context, "mandragora", new ModelMandragora<>(context)));
        event.registerEntityRenderer(MYSTERIOUS_MAN_LAYER1.get(), (Context context) -> new RenderDivineMob<>(context, "mysterious_man_layer_1", new ModelMysteriousMan<>(context)));
        event.registerEntityRenderer(MYSTERIOUS_MAN_LAYER2.get(), (Context context) -> new RenderDivineMob<>(context, "mysterious_man_layer_2", new ModelMysteriousMan<>(context)));
        event.registerEntityRenderer(MYSTERIOUS_MAN_LAYER3.get(), (Context context) -> new RenderDivineMob<>(context, "mysterious_man_layer_3", new ModelMysteriousMan<>(context)));
        event.registerEntityRenderer(SHADAHIER.get(), (Context context) -> new RenderDivineMob<>(context, "shadahier", new ModelShadahier<>(context)));
        event.registerEntityRenderer(TEMPLE_GUARDIAN.get(), (Context context) -> new RenderDivineMob<>(context, "temple_guardian", new HumanoidModel<>(context.bakeLayer(layerHumanoid)), 0.5F));
        event.registerEntityRenderer(THE_HUNGER.get(), (Context context) -> new RenderDivineMob<>(context, "the_hunger", new ModelTheHunger<>(context)));
        event.registerEntityRenderer(TOCAXIN.get(), (Context context) -> new RenderDivineMob<>(context, "tocaxin", new ModelTocaxin<>(context)));
        event.registerEntityRenderer(TWINS.get(), (Context context) -> new RenderDivineMob<>(context, "twins", new ModelTwins(context)));
        event.registerEntityRenderer(VERMENOUS.get(), (Context context) -> new RenderDivineMob<>(context, "vermenous", new ModelVermenous<>(context)));
        event.registerEntityRenderer(VHRAAK.get(), (Context context) -> new RenderDivineMob<>(context, "vhraak", new ModelVhraak<>(context)));
        event.registerEntityRenderer(ZONE.get(), (Context context) -> new RenderDivineMob<>(context, "zone", new ModelZone<>(context)));
        event.registerEntityRenderer(ZORAGON.get(), (Context context) -> new RenderDivineMob<>(context, "zoragon", new ModelZoragon<>(context), 0.5F, 3F));
    }

    private static final <T extends Entity> RegistryObject<EntityType<T>> registerEntity(EntityFactory<T> factory, String name, float width, float height) {
        return ENTITIES.register(name, () -> EntityType.Builder.of(factory, MobCategory.MONSTER).sized(width, height).build(new ResourceLocation(DivineRPG.MODID, name).toString()));
    }
    private static final <T extends Entity> RegistryObject<EntityType<T>> registerEntity(EntityFactory<T> factory, String name, float width, float height, MobCategory category) {
        return ENTITIES.register(name, () -> EntityType.Builder.of(factory, category).sized(width, height).build(new ResourceLocation(DivineRPG.MODID, name).toString()));
    }
    private static final <T extends Mob> RegistryObject<EntityType<T>> registerEntity(EntityFactory<T> factory, String name, float width, float height, int backgroundColor, int highlightColor) {
        return registerEntity(factory, name, width, height, backgroundColor, highlightColor, MobCategory.MONSTER);
    }
    private static final <T extends Mob> RegistryObject<EntityType<T>> registerEntity(EntityFactory<T> factory, String name, float width, float height, int backgroundColor, int highlightColor, MobCategory category) {
        RegistryObject<EntityType<T>> entity = ENTITIES.register(name, () -> EntityType.Builder.of(factory, category).sized(width, height).build(new ResourceLocation(DivineRPG.MODID, name).toString()));
        ItemRegistry.ITEMS.register(name + "_spawn_egg", () -> new ForgeSpawnEggItem(entity, backgroundColor, highlightColor, new Item.Properties()));
        return entity;
    }

    private static final <T extends Mob> void registerMobAttributes(EntityAttributeCreationEvent event, RegistryObject<EntityType<T>> entity, EntityStats stats) {
        event.put(entity.get(), Mob.createMobAttributes().add(Attributes.MAX_HEALTH, stats.getHealth()).add(Attributes.ATTACK_DAMAGE, stats.getAttackDamage()).add(Attributes.MOVEMENT_SPEED, stats.getMovementSpeed()).add(Attributes.FOLLOW_RANGE, stats.getFollowRange()).add(Attributes.FLYING_SPEED, stats.getMovementSpeed()).build());
    }
    private static final <T extends Mob> void registerMobAttributesKnockback(EntityAttributeCreationEvent event, RegistryObject<EntityType<T>> entity, EntityStats stats, double knockback) {
        event.put(entity.get(), Mob.createMobAttributes().add(Attributes.MAX_HEALTH, stats.getHealth()).add(Attributes.ATTACK_DAMAGE, stats.getAttackDamage()).add(Attributes.MOVEMENT_SPEED, stats.getMovementSpeed()).add(Attributes.FOLLOW_RANGE, stats.getFollowRange()).add(Attributes.FLYING_SPEED, stats.getMovementSpeed()).add(Attributes.KNOCKBACK_RESISTANCE, knockback).build());
    }
    private static final <T extends Mob> void registerMobAttributesArmour(EntityAttributeCreationEvent event, RegistryObject<EntityType<T>> entity, EntityStats stats, double armour) {
        event.put(entity.get(), Mob.createMobAttributes().add(Attributes.MAX_HEALTH, stats.getHealth()).add(Attributes.ATTACK_DAMAGE, stats.getAttackDamage()).add(Attributes.MOVEMENT_SPEED, stats.getMovementSpeed()).add(Attributes.FOLLOW_RANGE, stats.getFollowRange()).add(Attributes.FLYING_SPEED, stats.getMovementSpeed()).add(Attributes.ARMOR, armour).build());
    }

    private static final <T extends Mob> void registerDefaultMobAttributes(EntityAttributeCreationEvent event, RegistryObject<EntityType<T>> entity) {
        event.put(entity.get(), Mob.createMobAttributes().add(Attributes.MAX_HEALTH, EntityStats.DEFAULT.getHealth()).add(Attributes.ATTACK_DAMAGE, EntityStats.DEFAULT.getAttackDamage()).add(Attributes.MOVEMENT_SPEED, EntityStats.DEFAULT.getMovementSpeed()).add(Attributes.FOLLOW_RANGE, EntityStats.DEFAULT.getFollowRange()).add(Attributes.FLYING_SPEED, EntityStats.DEFAULT.getMovementSpeed()).build());
    }
    private static RegistryObject<EntityType<EntityFrostCloud>> registerFrostCloud(EntityType.EntityFactory<EntityFrostCloud> factory, String entityName){
        return ENTITIES.register(entityName, () -> EntityType.Builder.of(factory, MobCategory.MISC).sized(0.5F, 0.5F).setTrackingRange(120).setUpdateInterval(20).build(new ResourceLocation(DivineRPG.MODID, entityName).getPath()));
    }
    private static final <T extends Projectile> RegistryObject<EntityType<T>> registerProjectile(EntityType.EntityFactory<T> factory, String entityName, float width, float length) {
        return ENTITIES.register(entityName, () -> EntityType.Builder.of(factory, MobCategory.MISC).sized(width, length).setTrackingRange(120).setUpdateInterval(20).build(new ResourceLocation(DivineRPG.MODID, entityName).getPath()));
    }
    private static final <T extends Projectile> RegistryObject<EntityType<T>> registerProjectile(EntityType.EntityFactory<T> factory, String entityName) {
        return registerProjectile(factory, entityName, 0.25F, 0.25F);
    }
    private static final <T extends AbstractArrow> RegistryObject<EntityType<T>> registerArrowProjectile(EntityType.EntityFactory<T> factory, String entityName) {
        return registerProjectile(factory, entityName, 0.5F, 0.5F);
    }
    private static final <T extends DivineFireball> RegistryObject<EntityType<T>> registerFireballProjectile(EntityType.EntityFactory<T> factory, String entityName) {
        return registerProjectile(factory, entityName, 0.25F, 0.25F);
    }
}