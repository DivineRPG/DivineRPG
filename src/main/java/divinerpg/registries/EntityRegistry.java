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
import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.entities.boss.*;
import divinerpg.entities.eden.*;
import divinerpg.entities.iceika.*;
import divinerpg.entities.mortum.*;
import divinerpg.entities.projectile.*;
import divinerpg.entities.skythern.*;
import divinerpg.entities.vanilla.end.*;
import divinerpg.entities.vanilla.nether.*;
import divinerpg.entities.vanilla.overworld.*;
import divinerpg.entities.vethea.*;
import divinerpg.entities.wildwood.*;
import divinerpg.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.EntityType.EntityFactory;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
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
import static divinerpg.util.EntityStats.*;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);
    private EntityRegistry(){}

    //Projectile
    public static final RegistryObject<EntityType<EntityAttractor>>				ATTRACTOR = registerProjectile(EntityAttractor::new, "attractor");
    public static final RegistryObject<EntityType<EntityBouncingProjectile>>	BOUNCING_PROJECTILE = registerProjectile(EntityBouncingProjectile::new, "bouncing_projectile");
    public static final RegistryObject<EntityType<EntityCaveRock>>				CAVE_ROCK = registerProjectile(EntityCaveRock::new, "cave_rock");
    public static final RegistryObject<EntityType<EntityColoredBullet>>			COLORED_BULLET = registerProjectile(EntityColoredBullet::new, "colored_bullet");
    public static final RegistryObject<EntityType<EntityCoriShot>>				CORI_SHOT = registerProjectile(EntityCoriShot::new, "cori_shot");
    public static final RegistryObject<EntityType<EntityCorruptedBullet>>		CORRUPTED_BULLET = registerProjectile(EntityCorruptedBullet::new, "corrupted_bullet");
    public static final RegistryObject<EntityType<EntityDisk>>					DISK = registerProjectile(EntityDisk::new, "disk");
    public static final RegistryObject<EntityType<EntityDissimentShot>>			DISSIMENT_SHOT = registerProjectile(EntityDissimentShot::new, "dissiment_shot");
    public static final RegistryObject<EntityType<EntityDivineArrow>>			ARROW_SHOT = registerArrowProjectile(EntityDivineArrow::new, "arrow_shot");
    public static final RegistryObject<EntityType<EntityEnderTripletsFireball>> ENDER_TRIPLETS_FIREBALL = registerFireballProjectile(EntityEnderTripletsFireball::new, "ender_triplets_fireball");
    public static final RegistryObject<EntityType<EntityFirefly>>				FIREFLY = registerProjectile(EntityFirefly::new, "firefly");
    public static final RegistryObject<EntityType<EntityFractiteShot>>			FRACTITE_SHOT = registerFireballProjectile(EntityFractiteShot::new, "fractite_shot");
    public static final RegistryObject<EntityType<EntityFrostCloud>>			FROST_CLOUD = registerFrostCloud(EntityFrostCloud::new, "frost_cloud");
    public static final RegistryObject<EntityType<EntityFrostShot>>				FROST_SHOT = registerFireballProjectile(EntityFrostShot::new, "frost_shot");
    public static final RegistryObject<EntityType<EntityFyracryxFireball>>		FYRACRYX_FIREBALL = registerFireballProjectile(EntityFyracryxFireball::new, "fyracryx_fireball");
    public static final RegistryObject<EntityType<EntityGeneralsStaff>>			GENERALS_STAFF = registerProjectile(EntityGeneralsStaff::new, "generals_staff");
    public static final RegistryObject<EntityType<EntityGrenade>>				GRENADE = registerProjectile(EntityGrenade::new, "grenade");
    public static final RegistryObject<EntityType<EntityKazroticShot>>			KAZROTIC_SHOT = registerProjectile(EntityKazroticShot::new, "kazrotic_shot");
    public static final RegistryObject<EntityType<EntityKingOfScorchersMeteor>> KING_OF_SCORCHERS_METEOR = registerProjectile(EntityKingOfScorchersMeteor::new, "king_of_scorchers_meteor");
    public static final RegistryObject<EntityType<EntityKingOfScorchersShot>>	KING_OF_SCORCHERS_SHOT = registerProjectile(EntityKingOfScorchersShot::new, "king_of_scorchers_shot");
    public static final RegistryObject<EntityType<EntityLadyLunaSparkler>>		LADY_LUNA_SPARKLER = registerProjectile(EntityLadyLunaSparkler::new, "lady_luna_sparkler");
    public static final RegistryObject<EntityType<EntityTwilightMageShot>>		MAGE_SHOT = registerProjectile(EntityTwilightMageShot::new, "mage_shot");
    public static final RegistryObject<EntityType<EntityMandragoraProjectile>>	MANDRAGORA_PROJECTILE = registerProjectile(EntityMandragoraProjectile::new, "mandragora_projectile");
    public static final RegistryObject<EntityType<EntityMerikMissile>>			MERIKS_MISSILE = registerProjectile(EntityMerikMissile::new, "meriks_missile");
    public static final RegistryObject<EntityType<EntityMeteor>>				METEOR = registerProjectile(EntityMeteor::new, "meteor");
    public static final RegistryObject<EntityType<EntityParticleBullet>>		PARTICLE_BULLET = registerProjectile(EntityParticleBullet::new, "particle_bullet");
    public static final RegistryObject<EntityType<EntityRaglokBomb>>			RAGLOK_BOMB = registerProjectile(EntityRaglokBomb::new, "raglok_bomb");
    public static final RegistryObject<EntityType<EntityReflector>>				REFLECTOR = registerProjectile(EntityReflector::new, "reflector");
    public static final RegistryObject<EntityType<EntitySaguaroWormShot>>		SAGUARO_WORM_SHOT = registerProjectile(EntitySaguaroWormShot::new, "saguaro_worm_shot");
    public static final RegistryObject<EntityType<EntityScorcherShot>>			SCORCHER_SHOT = registerFireballProjectile(EntityScorcherShot::new, "scorcher_shot");
    public static final RegistryObject<EntityType<EntitySerenadeOfDeath>>		SERENADE_OF_DEATH = registerProjectile(EntitySerenadeOfDeath::new, "serenade_of_death");
    public static final RegistryObject<EntityType<EntitySerenadeOfIce>>			SERENADE_OF_ICE = registerProjectile(EntitySerenadeOfIce::new, "serenade_of_ice");
    public static final RegistryObject<EntityType<EntityShooterBullet>>			SHOOTER_BULLET = registerProjectile(EntityShooterBullet::new, "shooter_bullet");
    public static final RegistryObject<EntityType<EntityShuriken>>				SHURIKEN = registerProjectile(EntityShuriken::new, "shuriken");
    public static final RegistryObject<EntityType<EntitySkyreBullet>>			SKYRE_BULLET = registerProjectile(EntitySkyreBullet::new, "skyre_bullet");
    public static final RegistryObject<EntityType<EntitySnowflakeShuriken>>		SNOWFLAKE_SHURIKEN = registerProjectile(EntitySnowflakeShuriken::new, "snowflake_shuriken");
    public static final RegistryObject<EntityType<EntitySoulFiendShot>>			SOUL_FIEND_SHOT = registerProjectile(EntitySoulFiendShot::new, "soul_fiend_shot");
    public static final RegistryObject<EntityType<EntitySoundOfCarols>>			SOUND_OF_CAROLS = registerProjectile(EntitySoundOfCarols::new, "sound_of_carols");
    public static final RegistryObject<EntityType<EntitySoundOfMusic>>			SOUND_OF_MUSIC = registerProjectile(EntitySoundOfMusic::new, "sound_of_music");
    public static final RegistryObject<EntityType<EntitySparkler>>				SPARKLER = registerProjectile(EntitySparkler::new, "sparkler");
    public static final RegistryObject<EntityType<EntityStar>>					STARLIGHT = registerProjectile(EntityStar::new, "star");
    public static final RegistryObject<EntityType<EntityTwilightDemonShot>>		TWILIGHT_DEMON_SHOT = registerProjectile(EntityTwilightDemonShot::new, "twilight_demon_shot");
    public static final RegistryObject<EntityType<EntityTwilightMageShot>>		TWILIGHT_MAGE_SHOT = registerProjectile(EntityTwilightMageShot::new, "twilight_mage_shot");
    public static final RegistryObject<EntityType<EntityVileStorm>>				VILE_STORM = registerProjectile(EntityVileStorm::new, "vile_storm");
    public static final RegistryObject<EntityType<EntityWatcherShot>>			WATCHER_SHOT = registerProjectile(EntityWatcherShot::new, "watcher_shot");
    public static final RegistryObject<EntityType<EntityWildwoodLog>>			WILDWOOD_LOG = registerProjectile(EntityWildwoodLog::new, "wildwood_log");
    public static final RegistryObject<EntityType<EntityWreckBouncingProjectile>>WRECK_BOUNCING_PROJECTILE = registerProjectile(EntityWreckBouncingProjectile::new, "wreck_bouncing_projectile");
    public static final RegistryObject<EntityType<EntityWreckExplosiveShot>>	WRECK_EXPLOSIVE_SHOT = registerProjectile(EntityWreckExplosiveShot::new, "wreck_explosive_shot");
    public static final RegistryObject<EntityType<EntityWreckShot>>				WRECK_SHOT = registerProjectile(EntityWreckShot::new, "wreck_shot");
    public static final RegistryObject<EntityType<EntityZoragonBomb>>			ZORAGON_BOMB = registerProjectile(EntityZoragonBomb::new, "zoragon_bomb");
    public static final RegistryObject<EntityType<EntityTomato>>			    TOMATO = registerProjectile(EntityTomato::new, "tomato");

    // Boss
    public static final RegistryObject<EntityType<EntityAncientEntity>>  ANCIENT_ENTITY 	= registerEntity(EntityAncientEntity::new, 	"ancient_entity", 	4.0F, 6.5F);
    public static final RegistryObject<EntityType<EntityAyeraco>>		 AYERACO			= registerEntity(EntityAyeraco::new,		"ayeraco",			2.8F, 1.2F);
    public static final RegistryObject<EntityType<EntityDensos>>		 DENSOS 			= registerEntity(EntityDensos::new, 		"densos", 			1.0F, 2.5F);
    public static final RegistryObject<EntityType<EntityDramix>>		 DRAMIX 			= registerEntity(EntityDramix::new, 		"dramix", 			0.85F,3.0F);
    public static final RegistryObject<EntityType<EntityEternalArcher>>  ETERNAL_ARCHER 	= registerEntity(EntityEternalArcher::new, 	"eternal_archer", 	3.0F, 5.0F);
    public static final RegistryObject<EntityType<EntityExperiencedCori>>EXPERIENCED_CORI 	= registerEntity(EntityExperiencedCori::new,"experienced_cori", 4.0F, 6.8F);
    public static final RegistryObject<EntityType<EntityHiveQueen>>		 HIVE_QUEEN 		= registerEntity(EntityHiveQueen::new, 		"hive_queen", 		1.5F, 4.0F);
    public static final RegistryObject<EntityType<EntityKaros>>			 KAROS 				= registerEntity(EntityKaros::new, 			"karos", 			1.0F, 3.0F);
    public static final RegistryObject<EntityType<EntityKarot>>			 KAROT 				= registerEntity(EntityKarot::new, 			"karot", 			3.25F,4.0F);
    public static final RegistryObject<EntityType<EntityKingOfScorchers>>KING_OF_SCORCHERS 	= registerEntity(EntityKingOfScorchers::new,"king_of_scorchers",2.0F, 2.5F);
    public static final RegistryObject<EntityType<EntityLadyLuna>>		 LADY_LUNA 			= registerEntity(EntityLadyLuna::new, 		"lady_luna", 		1.0F, 3.5F);
    public static final RegistryObject<EntityType<EntityParasecta>>		 PARASECTA 			= registerEntity(EntityParasecta::new, 		"parasecta", 		1.3F, 3.0F);
    public static final RegistryObject<EntityType<EntityQuadro>>		 QUADRO 			= registerEntity(EntityQuadro::new, 		"quadro", 			1.2F, 2.2F);
    public static final RegistryObject<EntityType<EntityRaglok>>		 RAGLOK 			= registerEntity(EntityRaglok::new, 		"raglok", 			3.0F, 5.0F);
    public static final RegistryObject<EntityType<EntityReyvor>>		 REYVOR 			= registerEntity(EntityReyvor::new, 		"reyvor", 			1.0F, 2.5F);
    public static final RegistryObject<EntityType<EntitySoulFiend>>		 SOUL_FIEND 		= registerEntity(EntitySoulFiend::new, 		"soul_fiend", 		0.8F, 2.0F);
    public static final RegistryObject<EntityType<EntitySunstorm>>		 SUNSTORM 			= registerEntity(EntitySunstorm::new, 		"sunstorm", 		0.9F, 3.0F);
    public static final RegistryObject<EntityType<EntityTermasect>>		 TERMASECT 			= registerEntity(EntityTermasect::new, 		"termasect", 		5.9F, 8.0F);
    public static final RegistryObject<EntityType<EntityTheWatcher>>	 THE_WATCHER 		= registerEntity(EntityTheWatcher::new, 	"the_watcher", 		4.0F, 4.0F);
    public static final RegistryObject<EntityType<EntityTwilightDemon>>  TWILIGHT_DEMON 	= registerEntity(EntityTwilightDemon::new, 	"twilight_demon", 	2.0F, 4.0F);
    public static final RegistryObject<EntityType<EntityVamacheron>>	 VAMACHERON 		= registerEntity(EntityVamacheron::new, 	"vamacheron", 		1.45F,2.2F);
    public static final RegistryObject<EntityType<EntityWreck>>			 WRECK 				= registerEntity(EntityWreck::new, 			"wreck", 			2.0F, 2.4F);

    // Overworld
    public static final RegistryObject<EntityType<EntityAequorea>>			 AEQUOREA 			= registerEntity(EntityAequorea::new, 			"aequorea", 			0.3F, 0.4F, 0x79ab82, 0x7ae174, MobCategory.WATER_CREATURE);
    public static final RegistryObject<EntityType<EntityAridWarrior>>		 ARID_WARRIOR 		= registerEntity(EntityAridWarrior::new, 		"arid_warrior",			1.4F, 2.8f, 0x6e5209, 0xc19b28);
    public static final RegistryObject<EntityType<EntityBrownGrizzle>>		 BROWN_GRIZZLE 		= registerEntity(EntityBrownGrizzle::new, 		"brown_grizzle", 		0.8F, 1.4F);
    public static final RegistryObject<EntityType<EntityCrawler>>			 CAVE_CRAWLER 		= registerEntity(EntityCrawler::new, 			"cave_crawler", 		0.6F, 0.8F, 0x90bc93, 0x8bf285);
    public static final RegistryObject<EntityType<EntityCaveclops>>			 CAVECLOPS 			= registerEntity(EntityCaveclops::new, 			"caveclops", 			1.2F, 4.0F, 0x3a3030, 0x77352b);
    public static final RegistryObject<EntityType<EntityCrab>>				 CRAB 				= registerEntity(EntityCrab::new, 				"crab", 				0.9F, 0.6F, 0xbf5241, 0xe2cfc0);
    public static final RegistryObject<EntityType<EntityCyclops>>			 CYCLOPS 			= registerEntity(EntityCyclops::new, 			"cyclops", 				1.2F, 4.0F, 0x534e2f, 0xc2b66e);
    public static final RegistryObject<EntityType<EntityDesertCrawler>>		DESERT_CRAWLER 	    = registerEntity(EntityDesertCrawler::new, 		"desert_crawler", 		0.8F, 0.8F, 0xc3be8e, 0xf2d676);
    public static final RegistryObject<EntityType<EntityDiamondDave>>       DIAMOND_DAVE        = registerEntity(EntityDiamondDave::new, 	    "diamond_dave", 		0.8F, 2F, 0x000000, 0x7D3C98, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityEhu>>				 EHU 				= registerEntity(EntityEhu::new, 				"ehu", 					0.6F, 1.0F);
    public static final RegistryObject<EntityType<EntityEnthralledDramcryx>> ENTHRALLED_DRAMCRYX= registerEntity(EntityEnthralledDramcryx::new, "enthralled_dramcryx",  1.35F,1.75F,0x171d3e, 0x423a82);
    public static final RegistryObject<EntityType<EntityFrost>>				 FROST 				= registerEntity(EntityFrost::new, 				"frost", 				1.0F, 1.5F, 0xbce8ff, 0xc6f8ff);
    public static final RegistryObject<EntityType<EntityGlacon>>			 GLACON 			= registerEntity(EntityGlacon::new, 			"glacon", 				0.8F, 1.4F, 0x88deff, 0x1788bc);
    public static final RegistryObject<EntityType<EntityHusk>>				 HUSK 				= registerEntity(EntityHusk::new, 				"husk", 				0.8F, 1.5F);
    public static final RegistryObject<EntityType<EntityJackOMan>>			 JACK_O_MAN 		= registerEntity(EntityJackOMan::new, 			"jack_o_man", 			0.8F, 2.0F, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityJungleBat>>			 JUNGLE_BAT 		= registerEntity(EntityJungleBat::new, 			"jungle_bat", 			0.7F, 1.0F, 0x325a24, 0x1b3008);
    public static final RegistryObject<EntityType<EntityJungleDramcryx>>	 JUNGLE_DRAMCRYX 	= registerEntity(EntityJungleDramcryx::new, 	"jungle_dramcryx", 		1.0F, 1.3F, 0x2d442c, 0x3d513b);
    public static final RegistryObject<EntityType<EntityJungleSpider>>		 JUNGLE_SPIDER 		= registerEntity(EntityJungleSpider::new, 		"jungle_spider", 		1.4F, 0.9F, 0x1a6706, 0x35a216);
    public static final RegistryObject<EntityType<EntityKingCrab>>			 KING_CRAB 			= registerEntity(EntityKingCrab::new, 			"king_crab", 			1.8F, 1.7F, 0x771f2a, 0x272322);
    public static final RegistryObject<EntityType<EntityKobblin>>			 KOBBLIN 			= registerEntity(EntityKobblin::new, 			"kobblin", 				0.75F,1.0F, 0x79553a, 0x6eae44);
    public static final RegistryObject<EntityType<EntityLiopleurodon>>		 LIOPLEURODON 		= registerEntity(EntityLiopleurodon::new, 		"liopleurodon", 		4.0F, 1.0f, 0x2f4581, 0x3d548f);
    public static final RegistryObject<EntityType<EntityLivestockMerchant>>  LIVESTOCK_MERCHANT = registerEntity(EntityLivestockMerchant::new, 	"livestock_merchant", 	0.8F, 2.0f, 0xa27d6a, 0x8e5f45, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityMiner>>				 MINER 				= registerEntity(EntityMiner::new, 				"miner", 				0.6F, 2.0F, 0x7f5200, 0xe2e048);
    public static final RegistryObject<EntityType<EntityPumpkinSpider>>		 PUMPKIN_SPIDER 	= registerEntity(EntityPumpkinSpider::new, 		"pumpkin_spider", 		1.25F,1.0F, 0xe38a1d, 0xa0560b);
    public static final RegistryObject<EntityType<EntityRainbour>>			 RAINBOUR 			= registerEntity(EntityRainbour::new, 			"rainbour", 			1.0F, 1.0F, 0x969798, 0x6c6e71);
    public static final RegistryObject<EntityType<EntityRotatick>>			 ROTATICK 			= registerEntity(EntityRotatick::new, 			"rotatick", 			0.85F, 0.8F,0x443844, 0x3d9a54);
    public static final RegistryObject<EntityType<EntitySaguaroWorm>> 		 SAGUARO_WORM 		= registerEntity(EntitySaguaroWorm::new, 		"saguaro_worm", 		1.0F, 3.0F, 0x699f35, 0xaab484);
    public static final RegistryObject<EntityType<EntityShark>>				 SHARK 				= registerEntity(EntityShark::new, 				"shark", 				1.0F, 0.5F, 0xbbcde2, 0xa6b8cd);
    public static final RegistryObject<EntityType<EntitySmelter>>			 SMELTER 			= registerEntity(EntitySmelter::new, 			"smelter", 				1.5F, 3.5F);
    public static final RegistryObject<EntityType<EntitySnapper>>			 SNAPPER 			= registerEntity(EntitySnapper::new, 			"snapper", 				0.6F, 0.5F);
    public static final RegistryObject<EntityType<EntityStoneGolem>>		 STONE_GOLEM 		= registerEntity(EntityStoneGolem::new, 		"stone_golem", 			1.5F, 3.5F);
    public static final RegistryObject<EntityType<EntityTheEye>>			 THE_EYE 			= registerEntity(EntityTheEye::new, 			"the_eye", 				1.3F, 2.0F, 0xFFFFFF, 0xFFFFFF);
    public static final RegistryObject<EntityType<EntityTheGrue>>			 THE_GRUE 			= registerEntity(EntityTheGrue::new, 			"the_grue", 			0.8F, 1.9F, 0x210e2a, 0x4f3764);
    public static final RegistryObject<EntityType<EntityWhale>>				 WHALE 				= registerEntity(EntityWhale::new, 				"whale", 				3.0F, 1.5F, 0x445c7b, 0x2b3b4f, MobCategory.WATER_CREATURE);
    public static final RegistryObject<EntityType<EntityWhiteGrizzle>>		 WHITE_GRIZZLE 		= registerEntity(EntityWhiteGrizzle::new, 		"white_grizzle", 		0.8F, 1.4F);

    //Nether
    public static final RegistryObject<EntityType<EntityHellBat>>	 HELL_BAT 	= registerEntity(EntityHellBat::new, 	"hell_bat", 	0.7F, 1.0F, 0x430c0c, 0x854343);
    public static final RegistryObject<EntityType<EntityHellPig>>	 HELL_PIG 	= registerEntity(EntityHellPig::new, 	"hell_pig", 	1.0F, 0.9F, 0xd64942, 0x91231b);
    public static final RegistryObject<EntityType<EntityHellSpider>> HELL_SPIDER= registerEntity(EntityHellSpider::new, "hell_spider",  1.4F, 0.9F, 0xb01916, 0x720b07);
    public static final RegistryObject<EntityType<EntityScorcher>>	 SCORCHER 	= registerEntity(EntityScorcher::new, 	"scorcher", 	1.2F, 2.0F, 0x8c00f3, 0x1c007a);
    public static final RegistryObject<EntityType<EntityWildfire>>	 WILDFIRE 	= registerEntity(EntityWildfire::new, 	"wildfire", 	0.8F, 2.2F, 0xaa0b01, 0x9c6d11);

    // End
    public static final RegistryObject<EntityType<EntityEnderSpider>>   ENDER_SPIDER  = registerEntity(EntityEnderSpider::new,  "ender_spider",  0.5F, 0.55F,0x0a0a0a, 0x260125);
    public static final RegistryObject<EntityType<EntityEnderScrounge>> ENDER_SCROUNGE = registerEntity(EntityEnderScrounge::new,"ender_scrounge",0.2F, 0.15F, 0x162916, 0xfc1b11);
    public static final RegistryObject<EntityType<EntityEnderTriplets>> ENDER_TRIPLETS = registerEntity(EntityEnderTriplets::new,"ender_triplets",2.0F, 2.0F, 0x161616, 0xfc1b28);
    public static final RegistryObject<EntityType<EntityEnderWatcher>>  ENDER_WATCHER = registerEntity(EntityEnderWatcher::new, "ender_watcher", 0.7F, 0.9F, 0x161616, 0xca1ae1);

    // Iceika
    public static final RegistryObject<EntityType<EntityAlicanto>>		  ALICANTO 		  	= registerEntity(EntityAlicanto::new, 		 "alicanto",		 1.2F, 1.6F, 0x1c94ff, 0x0837a6);
    public static final RegistryObject<EntityType<EntityFractite>>		  FRACTITE 		  	= registerEntity(EntityFractite::new, 		 "fractite",		 1.7F, 1.3F, 0xeeffff, 0xe2ffff);
    public static final RegistryObject<EntityType<EntityFrostArcher>>	  FROST_ARCHER 	  	= registerEntity(EntityFrostArcher::new, 	 "frost_archer",	 0.6F, 2.0F, 0x4095da, 0x407eb9);
    public static final RegistryObject<EntityType<EntityFrosty>>		  FROSTY 			= registerEntity(EntityFrosty::new, 		 "frosty",			 0.9F, 2.5F, 0xdcffff, 0xffffff);
    public static final RegistryObject<EntityType<EntityGroglin>>		  GROGLIN 		  	= registerEntity(EntityGroglin::new, 		 "groglin",		0.5F, 1.3F, 0x88c89c, 0x587090);
    public static final RegistryObject<EntityType<EntityGruzzorlug>>	  GRUZZORLUG 		= registerEntity(EntityGruzzorlug::new,      "gruzzorlug", 0.5F, 1.3F, 0x9370DB, 0x8B4513);
    public static final RegistryObject<EntityType<EntityGlacide>>		  GLACIDE 		  	= registerEntity(EntityGlacide::new, 		 "glacide",			 0.9F, 2.0F, 0x7ce3fe, 0x218fbf);
    public static final RegistryObject<EntityType<EntityHastreus>>		  HASTREUS 		  	= registerEntity(EntityHastreus::new, 		 "hastreus",		 1.0F, 1.9F, 0x136bd1, 0x418bea);
    public static final RegistryObject<EntityType<EntityRollum>>		  ROLLUM 			= registerEntity(EntityRollum::new, 		 "rollum",			 1.2F, 2.0F, 0x0504b7, 0x0d003d);
    public static final RegistryObject<EntityType<EntityWorkshopMerchant>>WORKSHOP_MERCHANT = registerEntity(EntityWorkshopMerchant::new,"workshop_merchant",1.0F, 2.0F, 0xb81503, 0x321100, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityWorkshopTinkerer>>WORKSHOP_TINKERER = registerEntity(EntityWorkshopTinkerer::new,"workshop_tinkerer",1.0F, 2.0F, 0x003859, 0x087aa6, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntitySeng>>            SENG              = registerEntity(EntitySeng::new,"seng",0.7F, 1.1F, 0x6091152, 0x000000);
    public static final RegistryObject<EntityType<EntitySabear>>          SABEAR            = registerEntity(EntitySabear::new,"sabear", 1.3F, 1.1F, 0x5C4312, 0x74510D);
    public static final RegistryObject<EntityType<EntityWolpertinger>>    WOLPERTINGER      = registerEntity(EntityWolpertinger::new,"wolpertinger", 0.6F, 0.6F, 0x4a321f, 0xc9b6a7);
    public static final RegistryObject<EntityType<EntityRobin>>           ROBIN             = registerEntity(EntityRobin::new,"robin", 0.3F, 0.3F, 0x63312e, 0x8c4541);

    // Eden
    public static final RegistryObject<EntityType<EntityGlinthop>>      GLINTHOP        = registerEntity(EntityGlinthop::new, 			    "glinthop",		 0.5F, 0.7F, 0xd7d2cf, 0xa0998c, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityEdenCadillion>> EDEN_CADILLION  = registerEntity(EntityEdenCadillion::new,  "eden_cadillion",1.0F, 1.5F, 0xfff7e1, 0xe2af20);
    public static final RegistryObject<EntityType<EntityEdenTomo>> 		EDEN_TOMO 		= registerEntity(EntityEdenTomo::new, 		"eden_tomo", 	 1.0F, 1.0F, 0x4a5e0c, 0x738b16);
    public static final RegistryObject<EntityType<EntityGreenfeet>> 	GREENFEET 		= registerEntity(EntityGreenfeet::new, 		"greenfeet", 	 1.0F, 2.0F, 0x084f1e, 0x4c5815);
    public static final RegistryObject<EntityType<EntityMadivel>> 		MADIVEL 		= registerEntity(EntityMadivel::new, 		"madivel", 		 0.6F, 2.9F, 0xf86a54, 0xffe15c);
    public static final RegistryObject<EntityType<EntitySunArcher>> 	SUN_ARCHER 		= registerEntity(EntitySunArcher::new, 		"sun_archer", 	 0.8F, 2.2F, 0xeaab42, 0xfdf182);
    public static final RegistryObject<EntityType<EntityWeakCori>> 		WEAK_CORI 		= registerEntity(EntityWeakCori::new, 		"weak_cori", 	 0.6F, 1.5F, 0x160f00, 0x4681ff);

    // Wildwood
    public static final RegistryObject<EntityType<EntityBehemoth>> 			BEHEMOTH 			= registerEntity(EntityBehemoth::new, 			"behemoth", 		 1.0F, 1.2F, 0x4180d0, 0x54b7e0);
    public static final RegistryObject<EntityType<EntityEpiphite>> 			EPIPHITE 			= registerEntity(EntityEpiphite::new, 			"epiphite", 		 0.9F, 1.3F, 0x2f74d9, 0x87ecfa);
    public static final RegistryObject<EntityType<EntityMage>> 				MAGE 				= registerEntity(EntityMage::new, 				"mage", 			 0.5F, 2.2F, 0x0f7adf, 0x2fc7fb);
    public static final RegistryObject<EntityType<EntityMoonWolf>> 			MOON_WOLF 			= registerEntity(EntityMoonWolf::new, 			"moon_wolf", 		 0.6F,0.85F, 0x3b8c8d, 0x070706, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityTermid>> 			TERMID 				= registerEntity(EntityTermid::new, 			"termid", 			 0.4F, 1.2F, 0x384d6e, 0x6388d4);
    public static final RegistryObject<EntityType<EntityVerek>> 			VEREK 				= registerEntity(EntityVerek::new, 				"verek", 			 0.8F, 2.0F, 0x0d5754, 0x3a8e89);
    public static final RegistryObject<EntityType<EntityWildwoodCadillion>> WILDWOOD_CADILLION  = registerEntity(EntityWildwoodCadillion::new,  "wildwood_cadillion",1.0F, 1.5F, 0x85e5ff, 0x0061c1);
    public static final RegistryObject<EntityType<EntityWildwoodGolem>> 	WILDWOOD_GOLEM 		= registerEntity(EntityWildwoodGolem::new, 		"wildwood_golem", 	 1.3F, 2.9F, 0x4889de, 0x1e4a91);
    public static final RegistryObject<EntityType<EntityWildwoodTomo>> 		WILDWOOD_TOMO 		= registerEntity(EntityWildwoodTomo::new, 		"wildwood_tomo", 	 1.0F, 1.0F, 0x06224c, 0x214985);

    // Apalachia
    public static final RegistryObject<EntityType<EntityApalachiaCadillion>>APALACHIA_CADILLION = registerEntity(EntityApalachiaCadillion::new, "apalachia_cadillion",  1.0F, 1.5F, 0xfedcf4, 0xf4afe5);
    public static final RegistryObject<EntityType<EntityApalachiaGolem>> 	APALACHIA_GOLEM 	= registerEntity(EntityApalachiaGolem::new, 	"apalachia_golem", 		1.3F, 2.9F, 0x7c4bca, 0x4417a2);
    public static final RegistryObject<EntityType<EntityApalachiaTomo>> 	APALACHIA_TOMO 		= registerEntity(EntityApalachiaTomo::new, 		"apalachia_tomo", 		1.0F, 1.0F, 0x650054, 0x96007e);
    public static final RegistryObject<EntityType<EntityEnchantedArcher>> 	ENCHANTED_ARCHER  	= registerEntity(EntityEnchantedArcher::new, 	"enchanted_archer", 	1.8F, 3.0F, 0x160430, 0x2f0a66);
    public static final RegistryObject<EntityType<EntityEnchantedWarrior>> 	ENCHANTED_WARRIOR 	= registerEntity(EntityEnchantedWarrior::new, 	"enchanted_warrior", 	0.6F, 2.4F, 0x5800a2, 0x30005b);
    public static final RegistryObject<EntityType<EntitySpellbinder>> 		SPELLBINDER 		= registerEntity(EntitySpellbinder::new, 		"spellbinder", 			1.0F, 2.0F, 0x8b27de, 0xd16ff7);

    // Skythern
    public static final RegistryObject<EntityType<EntityAdvancedCori>>	ADVANCED_CORI 	= registerEntity(EntityAdvancedCori::new, 	"advanced_cori", 	0.6F, 1.5F, 0x160f00, 0xffc446);
    public static final RegistryObject<EntityType<EntityMegalith>>		MEGALITH 		= registerEntity(EntityMegalith::new,		"megalith", 		1.2F, 4.0F, 0x7b7b7b, 0x939393);
    public static final RegistryObject<EntityType<EntityMystic>>		MYSTIC 			= registerEntity(EntityMystic::new, 		"mystic", 			1.0F, 2.0F, 0xb7a5a9, 0xe4d9dd);
    public static final RegistryObject<EntityType<EntitySamek>>			SAMEK 			= registerEntity(EntitySamek::new, 			"samek", 			0.8F, 2.0F, 0xa6a875, 0x6e703b);
    public static final RegistryObject<EntityType<EntitySkythernArcher>>SKYTHERN_ARCHER = registerEntity(EntitySkythernArcher::new, "skythern_archer",  1.8F, 3.0F, 0x3e3e3e, 0x828282);
    public static final RegistryObject<EntityType<EntitySkythernFiend>> SKYTHERN_FIEND 	= registerEntity(EntitySkythernFiend::new, 	"skythern_fiend", 	0.6F, 2.0F, 0xffffff, 0xe8e8e8);
    public static final RegistryObject<EntityType<EntitySkythernGolem>> SKYTHERN_GOLEM 	= registerEntity(EntitySkythernGolem::new, 	"skythern_golem", 	1.3F, 2.9F, 0x6b6b6b, 0x474747);

    // Mortum
    public static final RegistryObject<EntityType<EntityAngryGlinthop>>	 ANGRY_GLINTHOP 	  = registerEntity(EntityAngryGlinthop::new, 	  "angry_glinthop", 	  1.1F, 1.8F, 0x282c2a, 0x686d71);
    public static final RegistryObject<EntityType<EntityBasilisk>>		 BASILISK 		  = registerEntity(EntityBasilisk::new, 	  "basilisk", 		  0.7F, 0.8F, 0x424242, 0x5f5f5f);
    public static final RegistryObject<EntityType<EntityDemonOfDarkness>>DEMON_OF_DARKNESS= registerEntity(EntityDemonOfDarkness::new,"demon_of_darkness",0.8F, 1.6F, 0x090909, 0x202020);
    public static final RegistryObject<EntityType<EntityMortumCadillion>>MORTUM_CADILLION = registerEntity(EntityMortumCadillion::new,"mortum_cadillion", 1.0F, 1.5F, 0x170b1b, 0xb61604);
    public static final RegistryObject<EntityType<EntitySorcerer>>		 SORCERER 		  = registerEntity(EntitySorcerer::new, 	  "sorcerer", 		  0.6F, 1.5F, 0x4f1014, 0xa82732);
    public static final RegistryObject<EntityType<EntitySoulSpider>>	 SOUL_SPIDER 	  = registerEntity(EntitySoulSpider::new, 	  "soul_spider", 	  0.3F, 0.5F, 0x060505, 0x452827);
    public static final RegistryObject<EntityType<EntitySoulStealer>>	 SOUL_STEALER 	  = registerEntity(EntitySoulStealer::new, 	  "soul_stealer", 	  0.8F, 2.0F, 0x211111, 0x2f2d2d);
    public static final RegistryObject<EntityType<EntityTwilightArcher>> TWILIGHT_ARCHER  = registerEntity(EntityTwilightArcher::new, "twilight_archer",  1.8F, 3.0F, 0x200306, 0x670710);

    // Arcana
    public static final RegistryObject<EntityType<EntityCaptainMerik>>		 CAPTAIN_MERIK 		  = registerEntity(EntityCaptainMerik::new, 	  "captain_merik", 		  0.8F, 2.0F, 0xd8473f, 0x403331, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityDatticon>>			 DATTICON 			  = registerEntity(EntityDatticon::new, 		  "datticon", 			  0.8F, 2.0F, 0x4bd9e2, 0x313e40, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityDeathcryx>>			 DEATHCRYX 			  = registerEntity(EntityDeathcryx::new, 		  "deathcryx", 			  1.0F, 1.2F, 0x020c19, 0x0a1831);
    public static final RegistryObject<EntityType<EntityDeathHound>>		 DEATH_HOUND 		  = registerEntity(EntityDeathHound::new, 		  "death_hound", 		  0.8F, 0.9F, 0x011821, 0x03345a);
    public static final RegistryObject<EntityType<EntityDungeonConstructor>> DUNGEON_CONSTRUCTOR  = registerEntity(EntityDungeonConstructor::new, "dungeon_constructor",  0.5F, 1.0F, 0x214108, 0x316a07);
    public static final RegistryObject<EntityType<EntityDungeonDemon>>		 DUNGEON_DEMON 		  = registerEntity(EntityDungeonDemon::new, 	  "dungeon_demon", 		  0.6F, 2.15F);
    public static final RegistryObject<EntityType<EntityDungeonPrisoner>>	 DUNGEON_PRISONER 	  = registerEntity(EntityDungeonPrisoner::new, 	  "dungeon_prisoner", 	  0.6F,2.15F, 0x8e8d77, 0xe3e3d0);
    public static final RegistryObject<EntityType<EntityFyracryx>>			 FYRACRYX 			  = registerEntity(EntityFyracryx::new, 		  "fyracryx", 			  1.0F, 1.2F, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityGolemOfRejuvenation>>GOLEM_OF_REJUVENATION= registerEntity(EntityGolemOfRejuvenation::new,"golem_of_rejuvenation",1.0F,2.35F, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityKazari>>			 KAZARI				  = registerEntity(EntityKazari::new, 			  "kazari", 			  0.8F, 1.8F, 0x171717, 0x161d5a, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityLeorna>>			 LEORNA 			  = registerEntity(EntityLeorna::new, 			  "leorna", 			  0.8F, 1.8F, 0x004f04, 0x0c7807, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityLivingStatue>>		 LIVING_STATUE 		  = registerEntity(EntityLivingStatue::new, 	  "living_statue", 		  0.8F, 2.0F, 0x04202e, 0x03151c);
    public static final RegistryObject<EntityType<EntityLordVatticus>>		 LORD_VATTICUS 		  = registerEntity(EntityLordVatticus::new, 	  "lord_vatticus", 		  0.8F, 1.8F, 0x2d0701, 0xb91c20, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityParatiku>>			 PARATIKU 			  = registerEntity(EntityParatiku::new, 		  "paratiku", 			  0.5F, 0.9F, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityRazorback>>			 RAZORBACK 			  = registerEntity(EntityRazorback::new, 		  "razorback", 			  0.6F, 0.5F, 0x4d4d4d, 0x565656);
    public static final RegistryObject<EntityType<EntityRoamer>>			 ROAMER 			  = registerEntity(EntityRoamer::new, 			  "roamer", 			  0.6F, 1.8F, 0x14293a, 0x2a5878);
    public static final RegistryObject<EntityType<EntitySeimer>>			 SEIMER 			  = registerEntity(EntitySeimer::new, 			  "seimer", 			  1.0F, 1.0F, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntitySkyre>>			     SKYRE 			      = registerEntity(EntitySkyre::new, 			  "skyre", 			  0.5F, 0.3F,0x7400FF, 0x0035FF, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityWarGeneral>>		 WAR_GENERAL 		  = registerEntity(EntityWarGeneral::new, 		  "war_general", 		  0.8F, 2.0F, 0x272928, 0x1d326a, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityWraith>>			 WRAITH 			  = registerEntity(EntityWraith::new, 			  "wraith", 			  0.9F, 1.4F, 0x160d0d, 0xff0708, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityZelus>>				 ZELUS 				  = registerEntity(EntityZelus::new, 			  "zelus", 				  0.8F, 1.8F, 0x141414, 0x800706, MobCategory.CREATURE);

    // Vethea
    public static final RegistryObject<EntityType<EntityAcidHag>>			 ACID_HAG			  = registerEntity(EntityAcidHag::new,				"acid_hag",				 1.0F, 1.6F, 0x657b17, 0x7e4f19);
    public static final RegistryObject<EntityType<EntityBiphron>>			 BIPHRON			  = registerEntity(EntityBiphron::new,				"biphron",				 1.0F, 4.0F, 0xf1dc1b, 0x5e5e5e);
    public static final RegistryObject<EntityType<EntityBohemite>>			 BOHEMITE			  = registerEntity(EntityBohemite::new,				"bohemite",				 1.0F, 2.0F, 0x7d1818, 0xeb0016);
    public static final RegistryObject<EntityType<EntityCryptKeeper>>		 CRYPT_KEEPER		  = registerEntity(EntityCryptKeeper::new,			"crypt_keeper",			 1.0F, 2.0F, 0x202f05, 0x4c6e08, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityCymesoid>>			 CYMESOID			  = registerEntity(EntityCymesoid::new,				"cymesoid",				 0.8F, 2.0F, 0x6dd4fa, 0x469afc);
    public static final RegistryObject<EntityType<EntityDissiment>>			 DISSIMENT			  = registerEntity(EntityDissiment::new,			"dissiment",			 4.0F, 4.0F, 0xbec7e2, 0x2a65ff);
    public static final RegistryObject<EntityType<EntityDreamwrecker>>		 DREAMWRECKER		  = registerEntity(EntityDreamwrecker::new,			"dreamwrecker",			 1.0F, 4.4F, 0xd7d7d7, 0x92dd91);
    public static final RegistryObject<EntityType<EntityDuo>>				 DUO				  = registerEntity(EntityDuo::new,					"duo",					 1.0F, 2.0F, 0xec2f0c, 0x621000);
    public static final RegistryObject<EntityType<EntityEnt>>				 ENT				  = registerEntity(EntityEnt::new,					"ent",					 2.0F, 4.4F, 0x4c5645, 0x209633);
    public static final RegistryObject<EntityType<EntityFakeVhraak>>		 FAKE_VHRAAK		  = registerEntity(EntityFakeVhraak::new,			"fake_vhraak",			 1.0F, 1.0F, 0x3f2626, 0x5d1a1a);
    public static final RegistryObject<EntityType<EntityGalroid>>			 GALROID			  = registerEntity(EntityGalroid::new,				"galroid",				 1.0F, 3.0F, 0x141f51, 0x365196);
    public static final RegistryObject<EntityType<EntityGorgosion>>			 GORGOSION			  = registerEntity(EntityGorgosion::new,			"gorgosion",			 2.0F, 1.6F, 0x8c13c5, 0xc98a39);
    public static final RegistryObject<EntityType<EntityHelio>>				 HELIO				  = registerEntity(EntityHelio::new,				"helio",				 1.0F, 2.0F, 0xb8b8b8, 0x757575);
    public static final RegistryObject<EntityType<EntityHiveSoldier>>		 HIVE_SOLDIER		  = registerEntity(EntityHiveSoldier::new,			"hive_soldier",			 0.6F, 1.8F, 0xcbbf79, 0x68c66e);
    public static final RegistryObject<EntityType<EntityHoverStinger>>		 HOVER_STINGER		  = registerEntity(EntityHoverStinger::new,			"hover_stinger",		 1.0F, 2.4F, 0xc4c53d, 0x57b90e);
    public static final RegistryObject<EntityType<EntityKazrotic>>			 KAZROTIC			  = registerEntity(EntityKazrotic::new,				"kazrotic",				 1.0F, 2.0F, 0xda6f1c, 0x4a4a4a);
    public static final RegistryObject<EntityType<EntityLheiva>>			 LHEIVA				  = registerEntity(EntityLheiva::new,				"lheiva",				 1.0F, 1.4F, 0x0817d0, 0x00006b);
    public static final RegistryObject<EntityType<EntityLorga>>				 LORGA				  = registerEntity(EntityLorga::new,				"lorga",				 1.0F, 2.0F, 0xff641c, 0xfed31b);
    public static final RegistryObject<EntityType<EntityLorgaflight>>		 LORGA_FLIGHT		  = registerEntity(EntityLorgaflight::new,			"lorga_flight",			 1.0F, 1.0F, 0xff641c, 0xfed31b);
    public static final RegistryObject<EntityType<EntityMandragora>>		 MANDRAGORA			  = registerEntity(EntityMandragora::new,			"mandragora",			 1.0F, 2.0F, 0x178b1e, 0x0b3a0d);
    public static final RegistryObject<EntityType<EntityMysteriousManLayer1>>MYSTERIOUS_MAN_LAYER1= registerEntity(EntityMysteriousManLayer1::new,  "mysterious_man_layer_1",1.0F, 2.0F, 0x060000, 0xb11d1d, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityMysteriousManLayer2>>MYSTERIOUS_MAN_LAYER2= registerEntity(EntityMysteriousManLayer2::new,  "mysterious_man_layer_2",1.0F, 2.0F, 0x060000, 0x40b724, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityMysteriousManLayer3>>MYSTERIOUS_MAN_LAYER3= registerEntity(EntityMysteriousManLayer3::new,  "mysterious_man_layer_3",1.0F, 2.0F, 0x060000, 0x0049d0, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityShadahier>>			 SHADAHIER 			  = registerEntity(EntityShadahier::new,			"shadahier",			 0.8F, 1.3F, 0x252525, 0x972626);
    public static final RegistryObject<EntityType<EntityTheHunger>>			 THE_HUNGER			  = registerEntity(EntityTheHunger::new,			"the_hunger",			 0.8F, 2.0F, 0x1e1e1e, 0xaa7d66, MobCategory.CREATURE);
    public static final RegistryObject<EntityType<EntityTempleGuardian>>	 TEMPLE_GUARDIAN	  = registerEntity(EntityTempleGuardian::new, 		"temple_guardian",		 2.0F, 4.4F, 0x25340a, 0x547412);
    public static final RegistryObject<EntityType<EntityTocaxin>>			 TOCAXIN			  = registerEntity(EntityTocaxin::new, 				"tocaxin",				 1.0F, 3.3F, 0xceb89e, 0x5f5143);
    public static final RegistryObject<EntityType<EntityTwins>>				 TWINS				  = registerEntity(EntityTwins::new, 				"twins",				 1.0F, 2.0F, 0x3ab921, 0xb3d400);
    public static final RegistryObject<EntityType<EntityVermenous>>			 VERMENOUS			  = registerEntity(EntityVermenous::new, 			"vermenous",			 1.0F, 3.0F, 0x581b15, 0xa55f12);
    public static final RegistryObject<EntityType<EntityVhraak>>			 VHRAAK				  = registerEntity(EntityVhraak::new, 				"vhraak",				 1.0F, 1.0F, 0x3f2626, 0x5d1a1a);
    public static final RegistryObject<EntityType<EntityZone>>				 ZONE				  = registerEntity(EntityZone::new, 				"zone",					 1.0F, 1.3F, 0xb31c15, 0xaf9311);
    public static final RegistryObject<EntityType<EntityZoragon>>			 ZORAGON			  = registerEntity(EntityZoragon::new, 				"zoragon",				 4.0F, 4.0F, 0xc71a1a, 0x0613c0);

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        DivineRPG.LOGGER.info("[DivineRPG] Attached entity attributes");

        //Boss
        registerMonsterAttributes(event, ANCIENT_ENTITY, ancientEntityHealth, ancientEntityDamage);
        registerMonsterAttributes(event, AYERACO, ayeracoHealth);
        registerMonsterAttributes(event, DENSOS, densosHealth, densosDamage);
        registerMonsterAttributes(event, DRAMIX, dramixHealth, dramixDamage);
        registerMonsterAttributes(event, ETERNAL_ARCHER, eternalArcherHealth, eternalArcherDamage);
        registerFlyingMobAttributes(event, EXPERIENCED_CORI, experiencedCoriHealth, experiencedCoriDamage);
        registerMonsterAttributes(event, HIVE_QUEEN, hiveQueenHealth, hiveQueenDamage);
        registerMonsterAttributes(event, KAROS, karosHealth, karosDamage);
        registerMonsterAttributes(event, KAROT, karotHealth, karotDamage);
        registerMonsterAttributes(event, KING_OF_SCORCHERS, kingOfScorchersHealth, kingOfScorchersDamage);
        registerMonsterAttributes(event, LADY_LUNA, ladyLunaHealth, ladyLunaDamage);
        registerMonsterAttributes(event, PARASECTA, parasectaHealth, parasectaDamage);
        registerMonsterAttributes(event, QUADRO, quadroHealth, quadroDamage, quadroSpeedSlow);
        registerMonsterAttributes(event, RAGLOK, raglokHealth, raglokDamage);
        registerMonsterAttributes(event, REYVOR, reyvorHealth, reyvorDamage);
        registerMonsterAttributes(event, SOUL_FIEND, soulFiendHealth, soulFiendDamage);
        registerMonsterAttributes(event, SUNSTORM, sunstormHealth, sunstormDamage);
        registerFlyingMobAttributes(event, TERMASECT, 1050D, advancedCoriDamage, normalSpeed, 64D);
        registerFlyingMobAttributes(event, THE_WATCHER, theWatcherHealth, theWatcherDamage);
        registerMonsterAttributes(event, TWILIGHT_DEMON, twilightDemonHealth, twilightDemonDamage);
        registerMonsterAttributes(event, VAMACHERON, vamacheronHealth, vamacheronDamage, vamacheronSpeed);
        registerMonsterAttributes(event, WRECK, wreckHealth, wreckDamage);

        // Vanilla
        registerDamageMobAttributes(event, AEQUOREA, aequoreaHealth, aequoreaDamage, aequoreaSpeed, aequoreaFollowRange);
        registerMonsterAttributes(event, ARID_WARRIOR, aridWarriorHealth, aridWarriorDamage);
        registerDamageMobAttributes(event, BROWN_GRIZZLE, grizzleHealth, grizzleDamage, grizzleSpeed);
        registerMonsterAttributes(event, CAVE_CRAWLER, caveCrawlerHealth, caveCrawlerDamage, .198000000417232513);
        registerMonsterAttributes(event, CAVECLOPS, caveclopsHealth, caveclopsDamage);
        registerMonsterAttributes(event, CRAB, crabHealth, crabDamage);
        registerMonsterAttributes(event, CYCLOPS, cyclopsHealth);
        registerMonsterAttributes(event, DESERT_CRAWLER, desertCrawlerHealth, desertCrawlerDamage);
        registerMobAttributes(event, DIAMOND_DAVE);
        registerDamageMobAttributes(event, EHU, ehuHealth);
        registerMonsterAttributes(event, ENTHRALLED_DRAMCRYX, enthralledDramcryxHealth, enthralledDramcryxDamage);
        registerMonsterAttributes(event, FROST, frostHealth, frostDamage);
        registerMonsterAttributes(event, GLACON, glaconHealth, glaconDamage, glaconSpeed);
        registerDamageMobAttributes(event, HUSK, huskHealth, huskDamage);
        registerMobAttributes(event, JACK_O_MAN);
        event.put(JUNGLE_BAT.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, jungleBatHealth).add(Attributes.ATTACK_DAMAGE, jungleBatDamage).add(Attributes.MOVEMENT_SPEED, normalSpeed).add(Attributes.FOLLOW_RANGE, hellBatFollowRange).build());
        registerMonsterAttributes(event, JUNGLE_DRAMCRYX, jungleDramcryxHealth, jungleDramcryxDamage);
        registerMonsterAttributes(event, JUNGLE_SPIDER, jungleSpiderHealth, jungleSpiderDamage);
        registerMonsterAttributes(event, KING_CRAB, kingCrabHealth, kingCrabDamage);
        registerMonsterAttributes(event, KOBBLIN, kobblinHealth, kobblinDamage);
        registerDamageMobAttributes(event, LIOPLEURODON, liopleurodonHealth, liopleurodonDamage);
        registerMobAttributes(event, LIVESTOCK_MERCHANT);
        event.put(MINER.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, minerHealth).add(Attributes.ATTACK_DAMAGE, normalDamage).add(Attributes.MOVEMENT_SPEED, normalSpeed).add(Attributes.FOLLOW_RANGE, normalFollowRange).add(Attributes.ARMOR, minerArmor).build());
        registerMonsterAttributes(event, PUMPKIN_SPIDER, pumpkinSpiderHealth, pumpkinSpiderDamage);
        registerFlyingMobAttributes(event, RAINBOUR, rainbourHealth, rainbourDamage);
        registerMonsterAttributes(event, ROTATICK, rotatickHealth, rotatickDamage);
        registerMonsterAttributes(event, SAGUARO_WORM, saguaroWormHealth, saguaroWormDamage, saguaroWormSpeed);
        registerDamageMobAttributes(event, SHARK, sharkHealth, sharkDamage, normalSpeed * 2);
        registerDamageMobAttributes(event, SMELTER, smelterHealth, smelterDamage);
        registerDamageMobAttributes(event, SNAPPER, snapperHealth, snapperDamage, snapperSpeed);
        registerDamageMobAttributes(event, STONE_GOLEM, stoneGolemHealth);
        registerMonsterAttributes(event, THE_EYE, theEyeHealth, theEyeDamage);
        registerMonsterAttributes(event, THE_GRUE, theGrueHealth, theGrueDamage, theGrueSpeed);
        registerDamageMobAttributes(event, WHALE, whaleHealth, whaleDamage);
        registerDamageMobAttributes(event, WHITE_GRIZZLE, grizzleHealth, grizzleDamage, grizzleSpeed);

        //Nether
        event.put(HELL_BAT.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, hellBatHealth).add(Attributes.ATTACK_DAMAGE, hellBatDamage).add(Attributes.MOVEMENT_SPEED, normalSpeed).add(Attributes.FOLLOW_RANGE, hellBatFollowRange).build());
        registerDamageMobAttributes(event, HELL_PIG, hellPigHealth);
        registerMonsterAttributes(event, HELL_SPIDER, hellSpiderHealth, hellSpiderDamage);
        registerMonsterAttributes(event, SCORCHER, scorcherHealth);
        registerMonsterAttributes(event, WILDFIRE, wildFireHealth, wildFireDamage);

        //End
        registerMonsterAttributes(event, ENDER_SPIDER, enderSpiderHealth, enderSpiderDamage);
        registerMonsterAttributes(event, ENDER_SCROUNGE, 10, 1, normalSpeed, 32);
        registerFlyingMobAttributes(event, ENDER_TRIPLETS, enderTripletsHealth);
        registerMonsterAttributes(event, ENDER_WATCHER, enderWatcherHealth, enderWatcherDamage);

        //Iceika
        registerFlyingMobAttributes(event, ALICANTO, alicantoHealth, alicantoDamage);
        registerFlyingMobAttributes(event, FRACTITE, fractiteHealth);
        registerMonsterAttributes(event, FROST_ARCHER, frostArcherHealth, frostArcherDamage);
        registerMonsterAttributes(event, FROSTY, frostyHealth, frostyDamage, frostySpeed);
        registerMonsterAttributes(event, GLACIDE, glacideHealth, glacideDamage, glacideSpeed);
        registerMonsterAttributes(event, GROGLIN, groglinHealth, groglinDamage, groglinSpeed);
        registerMonsterAttributes(event, GRUZZORLUG, gruzzorlugHealth, gruzzorlugDamage, gruzzorlugSpeed);
        registerMonsterAttributes(event, HASTREUS, hastreusHealth, hastreusDamage);
        registerMonsterAttributes(event, ROLLUM, rollumHealth, normalDamage, rollumSpeed);
        registerMobAttributes(event, WORKSHOP_MERCHANT);
        registerMobAttributes(event, WORKSHOP_TINKERER);
        registerMonsterAttributes(event, SENG, sengHealth, normalDamage, sengSpeed, sengRange);
        registerMonsterAttributes(event, SABEAR, sabearHealth, sabearDamage, sabearSpeed, normalFollowRange);
        registerMonsterAttributes(event, WOLPERTINGER, wolpertingerHealth, wolpertingerDamage, wolpertingerSpeed, normalFollowRange);
        registerFlyingMobAttributes(event, ROBIN, robinHealth, robinDamage, robinSpeed, normalFollowRange);

        //Eden
        registerDamageMobAttributes(event, GLINTHOP, glinthopHealth, glinthopDamage);
        registerMonsterAttributes(event, EDEN_CADILLION, edenCadillionHealth, edenCadillionDamage);
        registerMonsterAttributes(event, EDEN_TOMO, edenTomoHealth, edenTomoDamage);
        registerMonsterAttributes(event, GREENFEET, greenfeetHealth, greenfeetDamage);
        registerMonsterAttributes(event, MADIVEL, madivelHealth, madivelDamage);
        registerMonsterAttributes(event, SUN_ARCHER, sunArcherHealth, sunArcherDamage);
        registerFlyingMobAttributes(event, WEAK_CORI, weakCoriHealth, weakCoriDamage);

        //Wildwood
        registerMonsterAttributes(event, BEHEMOTH, behemothHealth, behemothDamage);
        registerMonsterAttributes(event, EPIPHITE, epiphiteHealth, epiphiteDamage);
        registerMonsterAttributes(event, MAGE, mageHealth, mageDamage);
        registerDamageMobAttributes(event, MOON_WOLF, moonWolfHealth, moonWolfDamage);
        registerMonsterAttributes(event, TERMID, termidHealth, termidDamage);
        registerMonsterAttributes(event, VEREK, verekHealth, verekDamage);
        registerMonsterAttributes(event, WILDWOOD_CADILLION, wildwoodCadillionHealth, wildwoodCadillionDamage);
        registerMonsterAttributes(event, WILDWOOD_GOLEM, wildwoodGolemHealth, wildwoodGolemDamage);
        registerMonsterAttributes(event, WILDWOOD_TOMO, wildwoodTomoHealth, wildwoodTomoDamage);

        //Apalachia
        registerMonsterAttributes(event, APALACHIA_CADILLION, apalachiaCadillionHealth, apalachiaCadillionDamage);
        registerMonsterAttributes(event, APALACHIA_GOLEM, apalachiaGolemHealth, apalachiaGolemDamage);
        registerMonsterAttributes(event, APALACHIA_TOMO, apalachiaTomoHealth, apalachiaTomoDamage);
        registerMonsterAttributes(event, ENCHANTED_ARCHER, enchantedArcherHealth);
        registerMonsterAttributes(event, ENCHANTED_WARRIOR, enchantedWarriorHealth, enchantedWarriorDamage);
        registerMonsterAttributes(event, SPELLBINDER, spellbinderHealth, spellbinderDamage);

        //Skythern
        registerFlyingMobAttributes(event, ADVANCED_CORI, advancedCoriHealth, advancedCoriDamage);
        event.put(MEGALITH.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, megalithHealth).add(Attributes.ATTACK_DAMAGE, megalithDamage).add(Attributes.MOVEMENT_SPEED, megalithSpeed).add(Attributes.FOLLOW_RANGE, normalFollowRange).add(Attributes.KNOCKBACK_RESISTANCE, megalithKnockbackResistance).build());
        registerMonsterAttributes(event, MYSTIC, mysticHealth, mysticDamage);
        registerMonsterAttributes(event, SAMEK, samekHealth, samekDamage);
        registerMonsterAttributes(event, SKYTHERN_ARCHER, skythernArcherHealth);
        registerMonsterAttributes(event, SKYTHERN_FIEND, skythernFiendHealth, skythernFiendDamage);
        registerMonsterAttributes(event, SKYTHERN_GOLEM, skythernGolemHealth, skythernGolemDamage);

        //Mortum
        registerMonsterAttributes(event, ANGRY_GLINTHOP, angryGlinthopHealth, angryGlinthopDamage);
        registerMonsterAttributes(event, BASILISK, basliskHealth, basliskDamage);
        registerMonsterAttributes(event, DEMON_OF_DARKNESS, demonOfDarknessHealth, demonOfDarknessDamage);
        registerMonsterAttributes(event, MORTUM_CADILLION, mortumCadillionHealth, mortumCadillionDamage);
        registerMonsterAttributes(event, SORCERER, sorcererHealth, sorcererDamage);
        registerMonsterAttributes(event, SOUL_SPIDER, soulSpiderHealth, soulSpiderDamage);
        registerMonsterAttributes(event, SOUL_STEALER, soulStealerHealth, soulStealerDamage);
        registerMonsterAttributes(event, TWILIGHT_ARCHER, twilightArcherHealth);

        //Arcana
        registerMobAttributes(event, CAPTAIN_MERIK);
        registerMobAttributes(event, DATTICON);
        registerMonsterAttributes(event, DEATHCRYX, deathcryxHealth, deathcryxDamage);
        registerMonsterAttributes(event, DEATH_HOUND, deathHoundHealth, deathHoundDamage);
        registerMonsterAttributes(event, DUNGEON_CONSTRUCTOR, constructorHealth, constructorDamage);
        registerMonsterAttributes(event, DUNGEON_DEMON, dungeonPrisonerHealth, dungeonPrisonerDamage);
        registerMonsterAttributes(event, DUNGEON_PRISONER, dungeonPrisonerHealth, dungeonPrisonerDamage);
        registerDamageMobAttributes(event, FYRACRYX, fyracryxHealth, fyracryxDamage);
        registerDamageMobAttributes(event, GOLEM_OF_REJUVENATION, golemRejuvHealth, golemRejuvDamage);
        registerMobAttributes(event, KAZARI);
        registerMobAttributes(event, LEORNA);
        registerMonsterAttributes(event, LIVING_STATUE, livingStatueHealth, dungeonPrisonerDamage);
        registerMobAttributes(event, LORD_VATTICUS);
        registerMobAttributes(event, PARATIKU, paratikuHealth);
        registerMonsterAttributes(event, RAZORBACK, razorbackHealth, razorbackDamage);
        registerMonsterAttributes(event, ROAMER, roamerHealth, roamerDamage);
        registerMobAttributes(event, SEIMER, seimerHealth);
        registerMonsterAttributes(event, SKYRE, skyreHealth, skyreDamage, normalSpeed, skyreFollowRange);
        registerMobAttributes(event, WAR_GENERAL);
        event.put(WRAITH.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, seimerHealth).add(Attributes.ATTACK_DAMAGE, 1).add(Attributes.MOVEMENT_SPEED, normalSpeed).add(Attributes.FOLLOW_RANGE, normalFollowRange).add(Attributes.FLYING_SPEED, normalSpeed).build());
        registerMobAttributes(event, ZELUS);

        //Vethea
        registerMonsterAttributes(event, ACID_HAG, acidHagHealth);
        registerMonsterAttributes(event, BIPHRON, biphronHealth, biphronDamage);
        registerMonsterAttributes(event, BOHEMITE, bohemiteHealth, bohemiteDamage, bohemiteSpeed);
        registerMobAttributes(event, CRYPT_KEEPER, cryptKeeperHealth, cryptKeeperMovementSpeed, cryptKeeperFollowRange);
        registerMonsterAttributes(event, CYMESOID, cymesoidHealth, cymesoidDamage);
        registerFlyingMobAttributes(event, DISSIMENT, dissimentHealth);
        registerMonsterAttributes(event, DREAMWRECKER, dreamwreckerHealth, dreamwreckerDamage);
        registerMonsterAttributes(event, DUO, duoHealth, duoDamage, duoSpeed);
        registerMonsterAttributes(event, ENT, entHealth, entDamage);
        registerMonsterAttributes(event, FAKE_VHRAAK, vhraakHealth, vhraakDamage);
        registerMonsterAttributes(event, GALROID, galroidHealth, galroidDamage);
        event.put(GORGOSION.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.gorgosionHealth).add(Attributes.MOVEMENT_SPEED, EntityStats.normalSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.normalFollowRange).build());
        registerMonsterAttributes(event, HELIO, helioHealth, helioDamage);
        registerMonsterAttributes(event, HIVE_SOLDIER, hiveSoldierHealth, hiveSoldierDamage);
        registerMonsterAttributes(event, HOVER_STINGER, hoverStingerHealth, hoverStingerDamage, hoverStingerMovementSpeed, hoverStingerFollowRange);
        registerMonsterAttributes(event, KAZROTIC, kazroticHealth, kazroticDamage);
        registerMonsterAttributes(event, LHEIVA, lheivaHealth, lheivaDamage);
        registerMonsterAttributes(event, LORGA, lorgaHealth, lorgaDamage);
        registerFlyingMobAttributes(event, LORGA_FLIGHT, lorgaFlightHealth, lorgaFlightDamage);
        registerMonsterAttributes(event, MANDRAGORA, mandragoraHealth);
        registerMobAttributes(event, MYSTERIOUS_MAN_LAYER1, normalHealth, mysteriousManSpeed, mysteriousManFollowRange);
        registerMobAttributes(event, MYSTERIOUS_MAN_LAYER2, normalHealth, mysteriousManSpeed, mysteriousManFollowRange);
        registerMobAttributes(event, MYSTERIOUS_MAN_LAYER3, normalHealth, mysteriousManSpeed, mysteriousManFollowRange);
        registerMonsterAttributes(event, SHADAHIER, shadahierHealth, shadahierDamage);
        registerMobAttributes(event, TEMPLE_GUARDIAN, normalHealth, mysteriousManSpeed, mysteriousManFollowRange);
        registerMobAttributes(event, THE_HUNGER);
        registerMonsterAttributes(event, TOCAXIN, tocaxinHealth, tocaxinDamage);
        registerMonsterAttributes(event, TWINS, twinsHealth);
        registerMonsterAttributes(event, VERMENOUS, vermenousHealth, vermenousDamage);
        registerMonsterAttributes(event, VHRAAK, vhraakHealth, vhraakDamage);
        registerMonsterAttributes(event, ZONE, zoneHealth);
        registerFlyingMobAttributes(event, ZORAGON, zoragonHealth, zoragonDamage, zoragonSpeed, normalFollowRange);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        //Base
        event.registerLayerDefinition(layerHumanoid, () -> LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0), 64, 32));
        event.registerLayerDefinition(layerBat, BatModel::createBodyLayer);
        event.registerLayerDefinition(layerPig, () -> PigModel.createBodyLayer(CubeDeformation.NONE));
        event.registerLayerDefinition(layerSpider, SpiderModel::createSpiderBodyLayer);

        //Boss
        event.registerLayerDefinition(ModelAncientEntity.LAYER_LOCATION, 	ModelAncientEntity::createBodyLayer);
        event.registerLayerDefinition(ModelAyeraco.LAYER_LOCATION, 			ModelAyeraco::createBodyLayer);
        event.registerLayerDefinition(ModelDensos.LAYER_LOCATION, 			ModelDensos::createBodyLayer);
        event.registerLayerDefinition(ModelDramix.LAYER_LOCATION, 			ModelDramix::createBodyLayer);
        event.registerLayerDefinition(ModelEternalArcher.LAYER_LOCATION, 	ModelEternalArcher::createBodyLayer);
        event.registerLayerDefinition(ModelExperiencedCori.LAYER_LOCATION,  ModelExperiencedCori::createBodyLayer);
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
        event.registerLayerDefinition(ModelCrawler.LAYER_LOCATION,			 ModelCrawler::createBodyLayer);
        event.registerLayerDefinition(ModelGrizzle.LAYER_LOCATION,			 ModelGrizzle::createBodyLayer);
        event.registerLayerDefinition(ModelCrab.LAYER_LOCATION,				 ModelCrab::createBodyLayer);
        event.registerLayerDefinition(ModelDesertCrawler.LAYER_LOCATION,	 ModelDesertCrawler::createBodyLayer);
        event.registerLayerDefinition(ModelDramcryx.LAYER_LOCATION,			 ModelDramcryx::createBodyLayer);
        event.registerLayerDefinition(ModelEhu.LAYER_LOCATION,				 ModelEhu::createBodyLayer);
        event.registerLayerDefinition(ModelFrost.LAYER_LOCATION,			 ModelFrost::createBodyLayer);
        event.registerLayerDefinition(ModelGlacon.LAYER_LOCATION,			 ModelGlacon::createBodyLayer);
        event.registerLayerDefinition(ModelGrizzle.LAYER_LOCATION,			 ModelGrizzle::createBodyLayer);
        event.registerLayerDefinition(ModelHusk.LAYER_LOCATION,				 ModelHusk::createBodyLayer);
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
        event.registerLayerDefinition(ModelHellSpider.LAYER_LOCATION,ModelHellSpider::createBodyLayer);
        event.registerLayerDefinition(ModelScorcher.LAYER_LOCATION,  ModelScorcher::createBodyLayer);
        event.registerLayerDefinition(ModelWildfire.LAYER_LOCATION,  ModelWildfire::createBodyLayer);

        //End
        event.registerLayerDefinition(ModelEnderTriplets.LAYER_LOCATION, ModelEnderTriplets::createBodyLayer);
        event.registerLayerDefinition(ModelEnderScrounge.LAYER_LOCATION, ModelEnderScrounge::createBodyLayer);

        //Iceika
        event.registerLayerDefinition(ModelAlicanto.LAYER_LOCATION, ModelAlicanto::createBodyLayer);
        event.registerLayerDefinition(ModelFractite.LAYER_LOCATION, ModelFractite::createBodyLayer);
        event.registerLayerDefinition(ModelFrostArcher.LAYER_LOCATION, ModelFrostArcher::createBodyLayer);
        event.registerLayerDefinition(ModelFrosty.LAYER_LOCATION, ModelFrosty::createBodyLayer);
        event.registerLayerDefinition(ModelGlacide.LAYER_LOCATION, ModelGlacide::createBodyLayer);
        event.registerLayerDefinition(ModelGroglin.LAYER_LOCATION, ModelGroglin::createBodyLayer);
        event.registerLayerDefinition(ModelGruzzorlug.LAYER_LOCATION, ModelGruzzorlug::createBodyLayer);
        event.registerLayerDefinition(ModelHastreus.LAYER_LOCATION, ModelHastreus::createBodyLayer);
        event.registerLayerDefinition(ModelRollum.LAYER_LOCATION, ModelRollum::createBodyLayer);
        event.registerLayerDefinition(ModelWorkshop.LAYER_LOCATION, ModelWorkshop::createBodyLayer);
        event.registerLayerDefinition(ModelSeng.LAYER_LOCATION, ModelSeng::createBodyLayer);
        event.registerLayerDefinition(ModelSabear.LAYER_LOCATION, ModelSabear::createBodyLayer);
        event.registerLayerDefinition(ModelWolpertinger.LAYER_LOCATION, ModelWolpertinger::createBodyLayer);
        event.registerLayerDefinition(ModelRobin.LAYER_LOCATION, ModelRobin::createBodyLayer);

        //Eden
        event.registerLayerDefinition(ModelGlinthop.LAYER_LOCATION, ModelGlinthop::createBodyLayer);
        event.registerLayerDefinition(ModelCadillion.LAYER_LOCATION, ModelCadillion::createBodyLayer);
        event.registerLayerDefinition(ModelTomo.LAYER_LOCATION, ModelTomo::createBodyLayer);
        event.registerLayerDefinition(ModelGreenfeet.LAYER_LOCATION, ModelGreenfeet::createBodyLayer);
        event.registerLayerDefinition(ModelMadivel.LAYER_LOCATION, ModelMadivel::createBodyLayer);
        event.registerLayerDefinition(ModelSunArcher.LAYER_LOCATION, ModelSunArcher::createBodyLayer);
        event.registerLayerDefinition(ModelCori.LAYER_LOCATION, ModelCori::createBodyLayer);

        //Wildwood
        event.registerLayerDefinition(ModelBehemoth.LAYER_LOCATION, ModelBehemoth::createBodyLayer);
        event.registerLayerDefinition(ModelEpiphite.LAYER_LOCATION, ModelEpiphite::createBodyLayer);
        event.registerLayerDefinition(ModelMage.LAYER_LOCATION, ModelMage::createBodyLayer);
        event.registerLayerDefinition(ModelMoonWolf.LAYER_LOCATION, ModelMoonWolf::createBodyLayer);
        event.registerLayerDefinition(ModelTermid.LAYER_LOCATION, ModelTermid::createBodyLayer);
        event.registerLayerDefinition(ModelSamek.LAYER_LOCATION, ModelSamek::createBodyLayer);
        event.registerLayerDefinition(ModelTwilightGolem.LAYER_LOCATION, ModelTwilightGolem::createBodyLayer);

        //Apalachia
        event.registerLayerDefinition(ModelEnchantedArcher.LAYER_LOCATION, ModelEnchantedArcher::createBodyLayer);
        event.registerLayerDefinition(ModelEnchantedWarrior.LAYER_LOCATION, ModelEnchantedWarrior::createBodyLayer);
        event.registerLayerDefinition(ModelMystic.LAYER_LOCATION, ModelMystic::createBodyLayer);

        //Skythern
        event.registerLayerDefinition(ModelMegalith.LAYER_LOCATION, ModelMegalith::createBodyLayer);
        event.registerLayerDefinition(ModelSkythernFiend.LAYER_LOCATION, ModelSkythernFiend::createBodyLayer);

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
        event.registerEntityRenderer(TOMATO.get(), 			        (Context context) -> new RenderDivineProjectile<>(context, new ResourceLocation(MODID, "textures/items/tomato.png")));
        event.registerEntityRenderer(WILDWOOD_LOG.get(), 			(Context context) -> new RenderWildwoodLog(context));
        event.registerEntityRenderer(FROST_CLOUD.get(), 			(Context context) -> new RenderFrostCloud(context));

        //Boss
        event.registerEntityRenderer(ANCIENT_ENTITY.get(), 	(Context context) -> new RenderDivineMob<>(context, "ancient_entity", 	new ModelAncientEntity(context), 6F, 6F));
        event.registerEntityRenderer(AYERACO.get(),			RenderAyeraco::new);
        event.registerEntityRenderer(DENSOS.get(), 			(Context context) -> new RenderDivineMob<>(context, "densos", 			new ModelDensos<>(context), 0.4F));
        event.registerEntityRenderer(DRAMIX.get(), 			(Context context) -> new RenderDivineMob<>(context, "dramix", 			new ModelDramix<>(context), 0.4F));
        event.registerEntityRenderer(ETERNAL_ARCHER.get(),  RenderEternalArcher::new);
        event.registerEntityRenderer(EXPERIENCED_CORI.get(),(Context context) -> new RenderDivineMob<>(context, "experienced_cori", new ModelExperiencedCori(context), 1F, 5F));
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
        event.registerEntityRenderer(SUNSTORM.get(), 		(Context context) -> new RenderDivineMob<>(context, "sunstorm", 		new ModelSunstorm<>(context), 0.6F));
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
        event.registerEntityRenderer(CRAB.get(),			 (Context context) -> new RenderDivineMob<>(context, "crab", new ModelCrab(context), 0.7F));
        event.registerEntityRenderer(CYCLOPS.get(),			 RenderCyclops::new);
        event.registerEntityRenderer(DESERT_CRAWLER.get(),	 (Context context) -> new RenderDivineMob<>(context, "desert_crawler", new ModelDesertCrawler(context), 0.6F));
        event.registerEntityRenderer(DIAMOND_DAVE.get(),     (Context context) -> new RenderDivineMob<>(context, "diamond_dave", new HumanoidModel<>(context.bakeLayer(layerHumanoid)), 0.4F));
        event.registerEntityRenderer(EHU.get(),				 (Context context) -> new RenderDivineMob<>(context, "ehu", new ModelEhu(context)));
        event.registerEntityRenderer(ENTHRALLED_DRAMCRYX.get(),(Context context) -> new RenderDivineMob<>(context, "enthralled_dramcryx", new ModelDramcryx<>(context), 0.5F, 2F));
        event.registerEntityRenderer(FROST.get(),			 (Context context) -> new RenderDivineMob<>(context, "frost", new ModelFrost(context), 0.6F));
        event.registerEntityRenderer(GLACON.get(),			 (Context context) -> new RenderDivineMob<>(context, "glacon", new ModelGlacon(context), 0.8F));
        event.registerEntityRenderer(HUSK.get(),			 (Context context) -> new RenderDivineMob<>(context, "husk", new ModelHusk(context), 0.4F));
        event.registerEntityRenderer(JACK_O_MAN.get(),		 RenderJackOMan::new);
        event.registerEntityRenderer(JUNGLE_BAT.get(),		 (Context context) -> new RenderDivineBat<>(context, "jungle_bat", 0.2F));
        event.registerEntityRenderer(JUNGLE_DRAMCRYX.get(),	 (Context context) -> new RenderDivineMob<>(context, "jungle_dramcryx", new ModelDramcryx<>(context), 0.5F, 1.2F));
        event.registerEntityRenderer(JUNGLE_SPIDER.get(),	 (Context context) -> new RenderDivineMob<>(context, "jungle_spider", new ModelJungleSpider(context), 0.8F));
        event.registerEntityRenderer(KING_CRAB.get(),		 (Context context) -> new RenderDivineMob<>(context, "king_crab", new ModelKingCrab(context), 0.5F, 1.5F));
        event.registerEntityRenderer(KOBBLIN.get(),			 RenderKobblin::new);
        event.registerEntityRenderer(LIOPLEURODON.get(),	 RenderLiopleurodon::new);
        event.registerEntityRenderer(LIVESTOCK_MERCHANT.get(),(Context context) -> new RenderDivineMob<>(context, "livestock_merchant", new ModelLivestockMerchant(context), 0.4F));
        event.registerEntityRenderer(MINER.get(),			 RenderMiner::new);
        event.registerEntityRenderer(PUMPKIN_SPIDER.get(),	 (Context context) -> new RenderDivineMob<>(context, "pumpkin_spider", new ModelPumpkinSpider(context), 0.0F));
        event.registerEntityRenderer(RAINBOUR.get(),		 (Context context) -> new RenderDivineMob<>(context, "rainbour", new ModelRainbour(context), 0.4F));
        event.registerEntityRenderer(ROTATICK.get(),		 (Context context) -> new RenderDivineMob<>(context, "rotatick", new ModelRotatick(context), 0.4F));
        event.registerEntityRenderer(SAGUARO_WORM.get(),	 (Context context) -> new RenderDivineMob<>(context, "saguaro_worm", new ModelSaguaroWorm(context), 0.3F));
        event.registerEntityRenderer(SHARK.get(),			 (Context context) -> new RenderDivineMob<>(context, "shark", new ModelShark(context), 0.8F));
        event.registerEntityRenderer(SMELTER.get(),			 (Context context) -> new RenderDivineMob<>(context, "smelter", new ModelStoneGolem<>(context)));
        event.registerEntityRenderer(SNAPPER.get(),			 (Context context) -> new RenderDivineMob<>(context, "snapper", new ModelSnapper(context)));
        event.registerEntityRenderer(STONE_GOLEM.get(),		 (Context context) -> new RenderDivineMob<>(context, "stone_golem", new ModelStoneGolem<>(context)));
        event.registerEntityRenderer(THE_EYE.get(),			 (Context context) -> new RenderDivineMob<>(context, "the_eye", new ModelTheEye(context)));
        event.registerEntityRenderer(THE_GRUE.get(),		 (Context context) -> new RenderDivineMob<>(context, "the_grue", new ModelTheGrue(context)));
        event.registerEntityRenderer(WHALE.get(),			 (Context context) -> new RenderDivineMob<>(context, "whale", new ModelWhale(context), 0.8F, 5F));
        event.registerEntityRenderer(WHITE_GRIZZLE.get(),	 (Context context) -> new RenderDivineMob<>(context, "white_grizzle", new ModelGrizzle<>(context)));

        //Nether
        event.registerEntityRenderer(HELL_BAT.get(),	(Context context) -> new RenderDivineBat<>(context, "hell_bat", 0.5F, 1F));
        event.registerEntityRenderer(HELL_PIG.get(),	RenderHellPig::new);
        event.registerEntityRenderer(HELL_SPIDER.get(), (Context context) -> new RenderDivineMob<>(context, "hell_spider", new ModelHellSpider(context), 0.2F));
        event.registerEntityRenderer(SCORCHER.get(),	(Context context) -> new RenderDivineMob<>(context, "scorcher", new ModelScorcher(context), 0.5F, 1.5F));
        event.registerEntityRenderer(WILDFIRE.get(),	RenderWildfire::new);

        //End
        event.registerEntityRenderer(ENDER_SPIDER.get(),  (Context context) -> new RenderDivineMob<>(context, "ender_spider", new SpiderModel<>(context.bakeLayer(layerSpider)), 0.5F, 0.6F));
        event.registerEntityRenderer(ENDER_SCROUNGE.get(),     (Context context) -> new RenderDivineMob<>(context, "ender_scrounge", new ModelEnderScrounge(context), 0.1F, 0.5F));
        event.registerEntityRenderer(ENDER_TRIPLETS.get(),(Context context) -> new RenderDivineMob<>(context, "ender_triplets", new ModelEnderTriplets(context), 0.4F));
        event.registerEntityRenderer(ENDER_WATCHER.get(), (Context context) -> new RenderDivineMob<>(context, "ender_watcher", new ModelWatcher(context), 0.4F));

        //Iceika
        event.registerEntityRenderer(ALICANTO.get(),		 (Context context) -> new RenderDivineMob<>(context, "alicanto",  new ModelAlicanto<>(context)));
        event.registerEntityRenderer(FRACTITE.get(),		 (Context context) -> new RenderDivineMob<>(context, "fractite",  new ModelFractite<>(context), 0.5F, 2F));
        event.registerEntityRenderer(FROST_ARCHER.get(),	 RenderFrostArcher::new);
        event.registerEntityRenderer(FROSTY.get(),			 (Context context) -> new RenderDivineMob<>(context, "frosty",  new ModelFrosty(context)));
        event.registerEntityRenderer(GROGLIN.get(),			 RenderGroglin::new);
        event.registerEntityRenderer(GRUZZORLUG.get(),		 RenderGruzzorlug::new);
        event.registerEntityRenderer(GLACIDE.get(),			 (Context context) -> new RenderDivineMob<>(context, "glacide",  new ModelGlacide<>(context)));
        event.registerEntityRenderer(HASTREUS.get(),		 (Context context) -> new RenderDivineMob<>(context, "hastreus",  new ModelHastreus<>(context)));
        event.registerEntityRenderer(ROLLUM.get(),			 (Context context) -> new RenderDivineMob<>(context, "rollum",  new ModelRollum<>(context)));
        event.registerEntityRenderer(WORKSHOP_MERCHANT.get(),(Context context) -> new RenderDivineMob<>(context, "workshop_merchant",  new ModelWorkshop<>(context)));
        event.registerEntityRenderer(WORKSHOP_TINKERER.get(),(Context context) -> new RenderDivineMob<>(context, "workshop_tinkerer",  new ModelWorkshop<>(context)));
        event.registerEntityRenderer(SENG.get(),             (Context context) -> new RenderDivineMob<>(context, "seng",  new ModelSeng<>(context), 0.3F));
        event.registerEntityRenderer(SABEAR.get(),           (Context context) -> new RenderDivineMob<>(context, "sabear",  new ModelSabear<>(context), 0.8F));
        event.registerEntityRenderer(WOLPERTINGER.get(),     (Context context) -> new RenderDivineMob<>(context, "wolpertinger",  new ModelWolpertinger<>(context), 0.6F));
        event.registerEntityRenderer(ROBIN.get(),            (Context context) -> new RenderDivineMob<>(context, "robin",  new ModelRobin(context), 0.1F));

        //Eden
        event.registerEntityRenderer(GLINTHOP.get(),	    RenderGlinthop::new);
        event.registerEntityRenderer(EDEN_CADILLION.get(),(Context context) -> new RenderDivineMob<>(context, "eden_cadillion",  new ModelCadillion<>(context)));
        event.registerEntityRenderer(EDEN_TOMO.get(),	  (Context context) -> new RenderDivineMob<>(context, "eden_tomo",  new ModelTomo<>(context)));
        event.registerEntityRenderer(GREENFEET.get(),	  (Context context) -> new RenderDivineMob<>(context, "greenfeet",  new ModelGreenfeet<>(context)));
        event.registerEntityRenderer(MADIVEL.get(),		  (Context context) -> new RenderDivineMob<>(context, "madivel",  new ModelMadivel(context)));
        event.registerEntityRenderer(SUN_ARCHER.get(),	  RenderSunArcher::new);
        event.registerEntityRenderer(WEAK_CORI.get(),	  (Context context) -> new RenderDivineMob<>(context, "weak_cori",  new ModelCori<>(context)));

        //Wildwood
        event.registerEntityRenderer(BEHEMOTH.get(), (Context context) -> new RenderDivineMob<>(context, "behemoth",  new ModelBehemoth(context)));
        event.registerEntityRenderer(EPIPHITE.get(), (Context context) -> new RenderDivineMob<>(context, "epiphite",  new ModelEpiphite<>(context), 0.7F));
        event.registerEntityRenderer(MAGE.get(),	 (Context context) -> new RenderDivineMob<>(context, "mage",  new ModelMage<>(context)));
        event.registerEntityRenderer(MOON_WOLF.get(),(Context context) -> new RenderDivineMob<>(context, "moon_wolf",  new ModelMoonWolf(context), 0.7F));
        event.registerEntityRenderer(TERMID.get(),	 (Context context) -> new RenderDivineMob<>(context, "termid",  new ModelTermid<>(context), 0.6F));
        event.registerEntityRenderer(VEREK.get(),	 (Context context) -> new RenderDivineMob<>(context, "verek",  new ModelSamek<>(context)));
        event.registerEntityRenderer(WILDWOOD_CADILLION.get(),(Context context) -> new RenderDivineMob<>(context, "wildwood_cadillion",  new ModelCadillion<>(context)));
        event.registerEntityRenderer(WILDWOOD_GOLEM.get(),	  (Context context) -> new RenderDivineMob<>(context, "wildwood_golem",  new ModelTwilightGolem<>(context)));
        event.registerEntityRenderer(WILDWOOD_TOMO.get(),	  (Context context) -> new RenderDivineMob<>(context, "wildwood_tomo",  new ModelTomo<>(context)));

        //Apalachia
        event.registerEntityRenderer(APALACHIA_CADILLION.get(), (Context context) -> new RenderDivineMob<>(context, "apalachia_cadillion",  new ModelCadillion<>(context)));
        event.registerEntityRenderer(APALACHIA_GOLEM.get(),		(Context context) -> new RenderDivineMob<>(context, "apalachia_golem",  new ModelTwilightGolem<>(context)));
        event.registerEntityRenderer(APALACHIA_TOMO.get(),		(Context context) -> new RenderDivineMob<>(context, "apalachia_tomo",  new ModelTomo<>(context)));
        event.registerEntityRenderer(ENCHANTED_ARCHER.get(),	RenderEnchantedArcher::new);
        event.registerEntityRenderer(ENCHANTED_WARRIOR.get(),	RenderEnchantedWarrior::new);
        event.registerEntityRenderer(SPELLBINDER.get(),			(Context context) -> new RenderDivineMob<>(context, "spellbinder",  new ModelMystic<>(context)));

        //Skythern
        event.registerEntityRenderer(ADVANCED_CORI.get(),(Context context) -> new RenderDivineMob<>(context, "advanced_cori",  new ModelCori<>(context)));
        event.registerEntityRenderer(MEGALITH.get(),	 (Context context) -> new RenderDivineMob<>(context, "megalith",  new ModelMegalith<>(context)));
        event.registerEntityRenderer(MYSTIC.get(),		 (Context context) -> new RenderDivineMob<>(context, "mystic",  new ModelMystic<>(context)));
        event.registerEntityRenderer(SAMEK.get(),		 (Context context) -> new RenderDivineMob<>(context, "samek",  new ModelSamek<>(context)));
        event.registerEntityRenderer(SKYTHERN_ARCHER.get(),RenderSkythernArcher::new);
        event.registerEntityRenderer(SKYTHERN_FIEND.get(), (Context context) -> new RenderDivineMob<>(context, "skythern_fiend",  new ModelSkythernFiend<>(context)));
        event.registerEntityRenderer(SKYTHERN_GOLEM.get(), (Context context) -> new RenderDivineMob<>(context, "skythern_golem",  new ModelTwilightGolem<>(context)));

        //Mortum
        event.registerEntityRenderer(ANGRY_GLINTHOP.get(),	 RenderAngryGlinthop::new);
        event.registerEntityRenderer(BASILISK.get(),		 (Context context) -> new RenderDivineMob<>(context, "basilisk",  new ModelBasilisk(context), 0.8F));
        event.registerEntityRenderer(DEMON_OF_DARKNESS.get(),RenderDemonOfDarkness::new);
        event.registerEntityRenderer(MORTUM_CADILLION.get(), (Context context) -> new RenderDivineMob<>(context, "mortum_cadillion",  new ModelCadillion<>(context)));
        event.registerEntityRenderer(SORCERER.get(),		 (Context context) -> new RenderDivineMob<>(context, "sorcerer",  new ModelSorcerer<>(context)));
        event.registerEntityRenderer(SOUL_SPIDER.get(),		 (Context context) -> new RenderDivineMob<>(context, "soul_spider", new ModelSoulSpider<>(context), 0.3F));
        event.registerEntityRenderer(SOUL_STEALER.get(),	 (Context context) -> new RenderDivineMob<>(context, "soul_stealer", new ModelSoulStealer<>(context)));
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
        event.registerEntityRenderer(SKYRE.get(),			  (Context context) -> new RenderDivineMob<>(context, "skyre", new ModelSkyre<>(context), 0.2F, 0.5F));
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

    private static final <T extends Mob> void registerMobAttributes(EntityAttributeCreationEvent event, RegistryObject<EntityType<T>> entity) {
        event.put(entity.get(), Mob.createMobAttributes().add(Attributes.MAX_HEALTH, normalHealth).add(Attributes.ATTACK_DAMAGE, 1).add(Attributes.MOVEMENT_SPEED, normalSpeed).build());
    }
    private static final <T extends Mob> void registerMobAttributes(EntityAttributeCreationEvent event, RegistryObject<EntityType<T>> entity, double health) {
        event.put(entity.get(), Mob.createMobAttributes().add(Attributes.MAX_HEALTH, health).add(Attributes.ATTACK_DAMAGE, 1).add(Attributes.MOVEMENT_SPEED, normalSpeed).add(Attributes.FOLLOW_RANGE, normalFollowRange).build());
    }
    private static final <T extends Mob> void registerMobAttributes(EntityAttributeCreationEvent event, RegistryObject<EntityType<T>> entity, double health, double speed, double followRange) {
        event.put(entity.get(), Mob.createMobAttributes().add(Attributes.MAX_HEALTH, health).add(Attributes.ATTACK_DAMAGE, 1).add(Attributes.MOVEMENT_SPEED, speed).add(Attributes.FOLLOW_RANGE, followRange).build());
    }
    private static final <T extends Monster> void registerMonsterAttributes(EntityAttributeCreationEvent event, RegistryObject<EntityType<T>> entity, double health) {
        event.put(entity.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, health).add(Attributes.ATTACK_DAMAGE, normalDamage).add(Attributes.MOVEMENT_SPEED, normalSpeed).add(Attributes.FOLLOW_RANGE, normalFollowRange).build());
    }
    private static final <T extends Monster> void registerMonsterAttributes(EntityAttributeCreationEvent event, RegistryObject<EntityType<T>> entity, double health, double damage) {
        event.put(entity.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, health).add(Attributes.ATTACK_DAMAGE, damage).add(Attributes.MOVEMENT_SPEED, normalSpeed).add(Attributes.FOLLOW_RANGE, normalFollowRange).build());
    }
    private static final <T extends Monster> void registerMonsterAttributes(EntityAttributeCreationEvent event, RegistryObject<EntityType<T>> entity, double health, double damage, double speed) {
        event.put(entity.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, health).add(Attributes.ATTACK_DAMAGE, damage).add(Attributes.MOVEMENT_SPEED, speed).add(Attributes.FOLLOW_RANGE, normalFollowRange).build());
    }
    private static final <T extends Monster> void registerMonsterAttributes(EntityAttributeCreationEvent event, RegistryObject<EntityType<T>> entity, double health, double damage, double speed, double followRange) {
        event.put(entity.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, health).add(Attributes.ATTACK_DAMAGE, damage).add(Attributes.MOVEMENT_SPEED, speed).add(Attributes.FOLLOW_RANGE, followRange).build());
    }
    private static final <T extends EntityDivineFlyingMob> void registerFlyingMobAttributes(EntityAttributeCreationEvent event, RegistryObject<EntityType<T>> entity, double health) {
        event.put(entity.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, health).add(Attributes.ATTACK_DAMAGE, normalDamage).add(Attributes.MOVEMENT_SPEED, normalSpeed).add(Attributes.FOLLOW_RANGE, normalFollowRange).add(Attributes.FLYING_SPEED, normalSpeed).build());
    }
    private static final <T extends EntityDivineFlyingMob> void registerFlyingMobAttributes(EntityAttributeCreationEvent event, RegistryObject<EntityType<T>> entity, double health, double damage) {
        event.put(entity.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, health).add(Attributes.ATTACK_DAMAGE, damage).add(Attributes.MOVEMENT_SPEED, normalSpeed).add(Attributes.FOLLOW_RANGE, normalFollowRange).add(Attributes.FLYING_SPEED, normalSpeed).build());
    }
    private static final <T extends EntityDivineFlyingMob> void registerFlyingMobAttributes(EntityAttributeCreationEvent event, RegistryObject<EntityType<T>> entity, double health, double damage, double speed, double followRange) {
        event.put(entity.get(), Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, health).add(Attributes.ATTACK_DAMAGE, damage).add(Attributes.MOVEMENT_SPEED, speed).add(Attributes.FOLLOW_RANGE, followRange).add(Attributes.FLYING_SPEED, speed).build());
    }
    private static final <T extends Mob> void registerDamageMobAttributes(EntityAttributeCreationEvent event, RegistryObject<EntityType<T>> entity, double health) {
        event.put(entity.get(), Mob.createMobAttributes().add(Attributes.MAX_HEALTH, health).add(Attributes.ATTACK_DAMAGE, normalDamage).add(Attributes.MOVEMENT_SPEED, normalSpeed).add(Attributes.FOLLOW_RANGE, normalFollowRange).build());
    }
    private static final <T extends Mob> void registerDamageMobAttributes(EntityAttributeCreationEvent event, RegistryObject<EntityType<T>> entity, double health, double damage) {
        event.put(entity.get(), Mob.createMobAttributes().add(Attributes.MAX_HEALTH, health).add(Attributes.ATTACK_DAMAGE, damage).add(Attributes.MOVEMENT_SPEED, normalSpeed).add(Attributes.FOLLOW_RANGE, normalFollowRange).build());
    }
    private static final <T extends Mob> void registerDamageMobAttributes(EntityAttributeCreationEvent event, RegistryObject<EntityType<T>> entity, double health, double damage, double speed) {
        event.put(entity.get(), Mob.createMobAttributes().add(Attributes.MAX_HEALTH, health).add(Attributes.ATTACK_DAMAGE, damage).add(Attributes.MOVEMENT_SPEED, speed).add(Attributes.FOLLOW_RANGE, normalFollowRange).build());
    }
    private static final <T extends Mob> void registerDamageMobAttributes(EntityAttributeCreationEvent event, RegistryObject<EntityType<T>> entity, double health, double damage, double speed, double followRange) {
        event.put(entity.get(), Mob.createMobAttributes().add(Attributes.MAX_HEALTH, health).add(Attributes.ATTACK_DAMAGE, damage).add(Attributes.MOVEMENT_SPEED, speed).add(Attributes.FOLLOW_RANGE, followRange).build());
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
        return registerProjectile(factory, entityName, 0.25F, 0.25F);
    }
    private static final <T extends LargeFireball> RegistryObject<EntityType<T>> registerFireballProjectile(EntityType.EntityFactory<T> factory, String entityName) {
        return registerProjectile(factory, entityName, 0.25F, 0.25F);
    }
}