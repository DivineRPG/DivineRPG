package divinerpg.registries;

import com.google.common.base.*;
import com.google.common.collect.*;
import divinerpg.*;
import divinerpg.client.models.arcana.*;
import divinerpg.client.models.boss.*;
import divinerpg.client.models.iceika.*;
import divinerpg.client.models.twilight.*;
import divinerpg.client.models.vanilla.*;
import divinerpg.client.models.vethea.*;
import divinerpg.client.renders.base.*;
import divinerpg.client.renders.entity.arcana.*;
import divinerpg.client.renders.entity.boss.*;
import divinerpg.client.renders.entity.iceika.*;
import divinerpg.client.renders.entity.projectile.*;
import divinerpg.client.renders.entity.twilight.*;
import divinerpg.client.renders.entity.vanilla.*;
import divinerpg.entities.apalachia.*;
import divinerpg.entities.arcana.*;
import divinerpg.entities.boss.*;
import divinerpg.entities.boss.ayeraco.*;
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
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.biome.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.event.*;
import net.minecraftforge.event.entity.*;
import net.minecraftforge.event.world.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;

import java.util.*;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRegistry {
    private static final List<EntityType<?>> ENTITIES = Lists.newArrayList();
    private static final List<Item> SPAWN_EGGS = Lists.newArrayList();

    //Projectile
    public static final EntityType<EntityAttractor> ATTRACTOR = registerProjectile(EntityAttractor::new, "attractor");
    public static final EntityType<EntityBouncingProjectile> BOUNCING_PROJECTILE = registerProjectile(EntityBouncingProjectile::new, "bouncing_projectile");
    public static final EntityType<EntityCaveRock> CAVE_ROCK = registerProjectile(EntityCaveRock::new, "cave_rock");
    public static final EntityType<EntityColoredBullet> COLORED_BULLET = registerProjectile(EntityColoredBullet::new, "colored_bullet");
    public static final EntityType<EntityCoriShot> CORI_SHOT = registerProjectile(EntityCoriShot::new, "cori_shot");
    public static final EntityType<EntityCorruptedBullet> CORRUPTED_BULLET = registerProjectile(EntityCorruptedBullet::new, "corrupted_bullet");
    public static final EntityType<EntityDisk> DISK = registerProjectile(EntityDisk::new, "disk");
    public static final EntityType<EntityDissimentShot> DISSIMENT_SHOT = registerProjectile(EntityDissimentShot::new, "dissiment_shot");
    public static final EntityType<EntityDivineArrow> ARROW_SHOT = registerArrowProjectile(EntityDivineArrow::new, "arrow_shot");
    public static final EntityType ENDER_TRIPLETS_FIREBALL = registerFireballProjectile(EntityEnderTripletsFireball::new, "ender_triplets_fireball");
    public static final EntityType<EntityFirefly> FIREFLY = registerProjectile(EntityFirefly::new, "firefly");
    public static final EntityType FRACTITE_SHOT = registerFireballProjectile(EntityFractiteShot::new, "fractite_shot");
    public static final EntityType<EntityFrostCloud> FROST_CLOUD = registerProjectileNoThrow(EntityFrostCloud::new, "frost_cloud");
    public static final EntityType FROST_SHOT = registerFireballProjectile(EntityFrostShot::new, "frost_shot");
    public static final EntityType FYRACRYX_FIREBALL = registerFireballProjectile(EntityFyracryxFireball::new, "fyracryx_fireball");
    public static final EntityType<EntityGeneralsStaff> GENERALS_STAFF = registerProjectile(EntityGeneralsStaff::new, "generals_staff");
    public static final EntityType GRENADE = registerSnowballProjectile(EntityGrenade::new, "grenade");
    public static final EntityType<EntityKazroticShot> KAZROTIC_SHOT = registerProjectile(EntityKazroticShot::new, "kazrotic_shot");
    public static final EntityType<EntityKingOfScorchersMeteor> KING_OF_SCORCHERS_METEOR = registerProjectile(EntityKingOfScorchersMeteor::new, "king_of_scorchers_meteor");
    public static final EntityType<EntityKingOfScorchersShot> KING_OF_SCORCHERS_SHOT = registerProjectile(EntityKingOfScorchersShot::new, "king_of_scorchers_shot");
    public static final EntityType<EntityLadyLunaSparkler> LADY_LUNA_SPARKLER = registerProjectile(EntityLadyLunaSparkler::new, "lady_luna_sparkler");
    public static final EntityType<EntityTwilightMageShot> MAGE_SHOT = registerProjectile(EntityTwilightMageShot::new, "mage_shot");
    public static final EntityType<EntityMandragoraProjectile> MANDRAGORA_PROJECTILE = registerProjectile(EntityMandragoraProjectile::new, "mandragora_projectile");
    public static final EntityType<EntityMerikMissile> MERIKS_MISSILE = registerProjectile(EntityMerikMissile::new, "meriks_missile");
    public static final EntityType<EntityMeteor> METEOR = registerProjectile(EntityMeteor::new, "meteor");
    public static final EntityType<EntityParticleBullet> PARTICLE_BULLET = registerProjectile(EntityParticleBullet::new, "particle_bullet");
    public static final EntityType<EntityRaglokBomb> RAGLOK_BOMB = registerProjectile(EntityRaglokBomb::new, "raglok_bomb");
    public static final EntityType<EntityReflector> REFLECTOR = registerProjectile(EntityReflector::new, "reflector");
    public static final EntityType<EntitySaguaroWormShot> SAGUARO_WORM_SHOT = registerProjectile(EntitySaguaroWormShot::new, "saguaro_worm_shot");
    public static final EntityType SCORCHER_SHOT = registerFireballProjectile(EntityScorcherShot::new, "scorcher_shot");
    public static final EntityType<EntitySerenadeOfDeath> SERENADE_OF_DEATH = registerProjectile(EntitySerenadeOfDeath::new, "serenade_of_death");
    public static final EntityType<EntitySerenadeOfIce> SERENADE_OF_ICE = registerProjectile(EntitySerenadeOfIce::new, "serenade_of_ice");
    public static final EntityType<EntityShooterBullet> SHOOTER_BULLET = registerProjectile(EntityShooterBullet::new, "shooter_bullet");
    public static final EntityType<EntityShuriken> SHURIKEN = registerProjectile(EntityShuriken::new, "shuriken");
    public static final EntityType<EntitySnowflakeShuriken> SNOWFLAKE_SHURIKEN = registerProjectile(EntitySnowflakeShuriken::new, "snowflake_shuriken");
    public static final EntityType<EntitySoulFiendShot> SOUL_FIEND_SHOT = registerProjectile(EntitySoulFiendShot::new, "soul_fiend_shot");
    public static final EntityType<EntitySoundOfCarols> SOUND_OF_CAROLS = registerProjectile(EntitySoundOfCarols::new, "sound_of_carols");
    public static final EntityType<EntitySoundOfMusic> SOUND_OF_MUSIC = registerProjectile(EntitySoundOfMusic::new, "sound_of_music");
    public static final EntityType<EntitySparkler> SPARKLER = registerProjectile(EntitySparkler::new, "sparkler");
    public static final EntityType<EntityStar> STARLIGHT = registerProjectile(EntityStar::new, "star");
    public static final EntityType<EntityTwilightDemonShot> TWILIGHT_DEMON_SHOT = registerProjectile(EntityTwilightDemonShot::new, "twilight_demon_shot");
    public static final EntityType<EntityTwilightMageShot> TWILIGHT_MAGE_SHOT = registerProjectile(EntityTwilightMageShot::new, "twilight_mage_shot");
    public static final EntityType<EntityVileStorm> VILE_STORM = registerProjectile(EntityVileStorm::new, "vile_storm");
    public static final EntityType<EntityWatcherShot> WATCHER_SHOT = registerProjectile(EntityWatcherShot::new, "watcher_shot");
    public static final EntityType<EntityWildwoodLog> WILDWOOD_LOG = registerProjectile(EntityWildwoodLog::new, "wildwood_log");
    public static final EntityType<EntityWreckBouncingProjectile> WRECK_BOUNCING_PROJECTILE = registerProjectile(EntityWreckBouncingProjectile::new, "wreck_bouncing_projectile");
    public static final EntityType<EntityWreckExplosiveShot> WRECK_EXPLOSIVE_SHOT = registerProjectile(EntityWreckExplosiveShot::new, "wreck_explosive_shot");
    public static final EntityType<EntityWreckShot> WRECK_SHOT = registerProjectile(EntityWreckShot::new, "wreck_shot");
    public static final EntityType<EntityZoragonBomb> ZORAGON_BOMB = registerProjectile(EntityZoragonBomb::new, "zoragon_bomb");

    // Boss
    public static final EntityType<EntityAncientEntity> ANCIENT_ENTITY = registerEntity(EntityAncientEntity::new, "ancient_entity",4.0F, 6.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType AYERACO_BLUE = registerEntity(EntityAyeracoBlue::new, "ayeraco_blue",2.8F, 1.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType AYERACO_GREEN = registerEntity(EntityAyeracoGreen::new, "ayeraco_green",2.8F, 1.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType AYERACO_PURPLE = registerEntity(EntityAyeracoPurple::new, "ayeraco_purple",2.8F, 1.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType AYERACO_RED = registerEntity(EntityAyeracoRed::new, "ayeraco_red",2.8F, 1.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType AYERACO_YELLOW = registerEntity(EntityAyeracoYellow::new, "ayeraco_yellow",2.8F, 1.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType<EntityDensos> DENSOS = registerEntity(EntityDensos::new, "densos",1.0F, 2.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType<EntityDramix> DRAMIX = registerEntity(EntityDramix::new, "dramix",0.85F, 3.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType<EntityEternalArcher> ETERNAL_ARCHER = registerEntity(EntityEternalArcher::new, "eternal_archer",3.0F, 5.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType<EntityExperiencedCori> EXPERIENCED_CORI = registerEntity(EntityExperiencedCori::new, "experienced_cori",4F, 6.8F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType<EntityHiveQueen> HIVE_QUEEN = registerEntity(EntityHiveQueen::new, "hive_queen",1.5F, 4.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType<EntityKarot> KAROT = registerEntity(EntityKarot::new, "karot",3.25F, 4F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType<EntityKaros> KAROS = registerEntity(EntityKaros::new, "karos",1.0F, 3.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType<EntityKingOfScorchers> KING_OF_SCORCHERS = registerEntity(EntityKingOfScorchers::new, "king_of_scorchers",2.0F, 2.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType<EntityLadyLuna> LADY_LUNA = registerEntity(EntityLadyLuna::new, "lady_luna",1.0F, 3.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType<EntityParasecta> PARASECTA = registerEntity(EntityParasecta::new, "parasecta",1.3F, 3.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType<EntityQuadro> QUADRO = registerEntity(EntityQuadro::new, "quadro",1.2F, 2.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType<EntityRaglok> RAGLOK = registerEntity(EntityRaglok::new, "raglok",3.0F, 5.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType<EntityReyvor> REYVOR = registerEntity(EntityReyvor::new, "reyvor",1.0F, 2.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType<EntitySoulFiend> SOUL_FIEND = registerEntity(EntitySoulFiend::new, "soul_fiend",0.8F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType<EntitySunstorm> SUNSTORM = registerEntity(EntitySunstorm::new, "sunstorm",0.9F, 3.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType<EntityTermasect> TERMASECT = registerEntity(EntityTermasect::new, "termasect",5.9F, 8.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType<EntityTheWatcher> THE_WATCHER = registerEntity(EntityTheWatcher::new, "the_watcher",4F, 4F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType<EntityTwilightDemon> TWILIGHT_DEMON = registerEntity(EntityTwilightDemon::new, "twilight_demon",2.0F, 4.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType<EntityVamacheron> VAMACHERON = registerEntity(EntityVamacheron::new, "vamacheron",1.45F, 2.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
    public static final EntityType<EntityWreck> WRECK = registerEntity(EntityWreck::new, "wreck",2.0F, 2.4F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);



    // Vanilla
    public static final EntityType<EntityAridWarrior> ARID_WARRIOR = registerEntity(EntityAridWarrior::new, "arid_warrior",1.4F, 2.8f, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityBrownGrizzle> BROWN_GRIZZLE = registerEntity(EntityBrownGrizzle::new, "brown_grizzle",0.8F, 1.4F, EntityClassification.MONSTER);
    public static final EntityType<EntityCaveCrawler> CAVE_CRAWLER = registerEntity(EntityCaveCrawler::new, "cave_crawler",1.0F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityCaveclops> CAVECLOPS = registerEntity(EntityCaveclops::new, "caveclops", 1.2F, 4.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityCrab> CRAB = registerEntity(EntityCrab::new, "crab", 0.9F, 0.6F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityCyclops> CYCLOPS = registerEntity(EntityCyclops::new, "cyclops", 1.2F, 4.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityDesertCrawler> DESERT_CRAWLER = registerEntity(EntityDesertCrawler::new, "desert_crawler", 1.0F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityEhu> EHU = registerEntity(EntityEhu::new, "ehu", 0.6F, 1.0F, EntityClassification.MONSTER);
    public static final EntityType<EntityEnthralledDramcryx> ENTHRALLED_DRAMCRYX = registerEntity(EntityEnthralledDramcryx::new, "enthralled_dramcryx", 1.35F, 1.75F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityFrost> FROST = registerEntity(EntityFrost::new, "frost", 1.0F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityGlacon> GLACON = registerEntity(EntityGlacon::new, "glacon", 0.8F, 1.4F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityHusk> HUSK = registerEntity(EntityHusk::new, "husk", 0.8F, 1.5F, EntityClassification.MONSTER);
    public static final EntityType<EntityJackOMan> JACK_O_MAN = registerEntity(EntityJackOMan::new, "jack_o_man", 0.8F, 2F, EntityClassification.MISC);
    public static final EntityType<EntityJungleBat> JUNGLE_BAT = registerEntity(EntityJungleBat::new, "jungle_bat", 0.7F, 1F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityJungleDramcryx> JUNGLE_DRAMCRYX = registerEntity(EntityJungleDramcryx::new, "jungle_dramcryx", 1F, 1.3F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityJungleSpider> JUNGLE_SPIDER = registerEntity(EntityJungleSpider::new, "jungle_spider", 1.4F, 0.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityKingCrab> KING_CRAB = registerEntity(EntityKingCrab::new, "king_crab", 1.8F, 1.7F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityKobblin> KOBBLIN = registerEntity(EntityKobblin::new, "kobblin", 0.75F, 1F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityLiopleurodon> LIOPLEURODON = registerEntity(EntityLiopleurodon::new, "liopleurodon", 4F, 1f, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityLivestockMerchant> LIVESTOCK_MERCHANT = registerEntity(EntityLivestockMerchant::new, "livestock_merchant", 0.8F, 2f, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityMiner> MINER = registerEntity(EntityMiner::new, "miner", 0.6F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityPumpkinSpider> PUMPKIN_SPIDER = registerEntity(EntityPumpkinSpider::new, "pumpkin_spider", 1.25F, 1F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityRainbour> RAINBOUR = registerEntity(EntityRainbour::new, "rainbour", 1F, 1F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityRotatick> ROTATICK = registerEntity(EntityRotatick::new, "rotatick", 0.85F, 0.8F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntitySaguaroWorm> SAGUARO_WORM = registerEntity(EntitySaguaroWorm::new, "saguaro_worm", 1F, 3F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityShark> SHARK = registerEntity(EntityShark::new, "shark", 1.0F, 0.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.WATER_CREATURE);
    public static final EntityType<? extends TameableEntity> SMELTER = registerEntity(EntitySmelter::new, "smelter", 1.5F, 3.5F, EntityClassification.MONSTER);
    public static final EntityType<? extends TameableEntity> SNAPPER = registerEntity(EntitySnapper::new, "snapper", 0.6F, 0.5F, EntityClassification.MONSTER);
    public static final EntityType<? extends TameableEntity> STONE_GOLEM = registerEntity(EntityStoneGolem::new, "stone_golem", 1.5F, 3.5F, EntityClassification.MONSTER);
    public static final EntityType<EntityTheEye> THE_EYE = registerEntity(EntityTheEye::new, "the_eye", 1.3F, 2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityTheGrue> THE_GRUE = registerEntity(EntityTheGrue::new, "the_grue", 0.8F, 1.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType<EntityWhale> WHALE = registerEntity(EntityWhale::new, "whale", 3F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.WATER_CREATURE);
    public static final EntityType<? extends TameableEntity> WHITE_GRIZZLE = registerEntity(EntityWhiteGrizzle::new, "white_grizzle",0.8F, 1.4F, EntityClassification.MONSTER);

    //Nether
    public static final EntityType<EntityHellBat> HELL_BAT = registerEntity(EntityHellBat::new, "hell_bat",0.7F, 1.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.NETHER), EntityClassification.MONSTER);
    public static final EntityType<EntityHellPig> HELL_PIG = registerEntity(EntityHellPig::new, "hell_pig",1F, 0.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.NETHER), EntityClassification.MONSTER);
    public static final EntityType<EntityHellSpider> HELL_SPIDER = registerEntity(EntityHellSpider::new, "hell_spider",1.4F, 0.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.NETHER), EntityClassification.MONSTER);
    public static final EntityType<EntityScorcher> SCORCHER = registerEntity(EntityScorcher::new, "scorcher",1.2F, 2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.NETHER), EntityClassification.MONSTER);
    public static final EntityType<EntityWildfire> WILDFIRE = registerEntity(EntityWildfire::new, "wildfire",0.8F, 2.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.NETHER), EntityClassification.MONSTER);

    // End
    public static final EntityType<EntityEnderSpider> ENDER_SPIDER = registerEntity(EntityEnderSpider::new, "ender_spider",0.5F, 0.55F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.END), EntityClassification.MONSTER);
    public static final EntityType<EntityEnderTriplets> ENDER_TRIPLETS = registerEntity(EntityEnderTriplets::new, "ender_triplets",2.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.END), EntityClassification.MONSTER);
    public static final EntityType<EntityEnderWatcher> ENDER_WATCHER = registerEntity(EntityEnderWatcher::new, "ender_watcher",0.7F, 0.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.END), EntityClassification.MONSTER);

    // Iceika
    public static final EntityType<EntityAlicanto> ALICANTO = registerEntity(EntityAlicanto::new, "alicanto",1.2F, 1.6F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ICEIKA), EntityClassification.MONSTER);
    public static final EntityType<EntityFractite> FRACTITE = registerEntity(EntityFractite::new, "fractite",1.7F, 1.3F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ICEIKA), EntityClassification.MONSTER);
    public static final EntityType<EntityFrostArcher> FROST_ARCHER = registerEntity(EntityFrostArcher::new, "frost_archer",0.6F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ICEIKA), EntityClassification.MONSTER);
    public static final EntityType<EntityFrosty> FROSTY = registerEntity(EntityFrosty::new, "frosty",0.9F, 2.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ICEIKA), EntityClassification.MONSTER);
    public static final EntityType<EntityGlacide> GLACIDE = registerEntity(EntityGlacide::new, "glacide",0.9F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ICEIKA), EntityClassification.MONSTER);
    public static final EntityType<EntityHastreus> HASTREUS = registerEntity(EntityHastreus::new, "hastreus",1.0F, 1.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ICEIKA), EntityClassification.MONSTER);
    public static final EntityType<EntityRollum> ROLLUM = registerEntity(EntityRollum::new, "rollum",1.2F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ICEIKA), EntityClassification.MONSTER);
    public static final EntityType<EntityWorkshopMerchant> WORKSHOP_MERCHANT = registerEntity(EntityWorkshopMerchant::new, "workshop_merchant",1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ICEIKA), EntityClassification.MISC);
    public static final EntityType<EntityWorkshopTinkerer> WORKSHOP_TINKERER = registerEntity(EntityWorkshopTinkerer::new, "workshop_tinkerer",1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ICEIKA), EntityClassification.MISC);

    // Eden
    public static final EntityType<EntityBunny> BUNNY = registerEntity(EntityBunny::new, "bunny",0.5F, 0.7F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.EDEN), EntityClassification.MISC);
    public static final EntityType<EntityEdenCadillion> EDEN_CADILLION = registerEntity(EntityEdenCadillion::new, "eden_cadillion", 1.0F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.EDEN), EntityClassification.MONSTER);
    public static final EntityType<EntityEdenTomo> EDEN_TOMO = registerEntity(EntityEdenTomo::new, "eden_tomo", 1.0F, 1.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.EDEN), EntityClassification.MONSTER);
    public static final EntityType<EntityGreenfeet> GREENFEET = registerEntity(EntityGreenfeet::new, "greenfeet", 1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.EDEN), EntityClassification.MONSTER);
    public static final EntityType<EntityMadivel> MADIVEL = registerEntity(EntityMadivel::new, "madivel", 0.6F, 2.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.EDEN), EntityClassification.MONSTER);
    public static final EntityType<EntitySunArcher> SUN_ARCHER = registerEntity(EntitySunArcher::new, "sun_archer", 0.8F, 2.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.EDEN), EntityClassification.MONSTER);
    public static final EntityType<EntityWeakCori> WEAK_CORI = registerEntity(EntityWeakCori::new, "weak_cori", 0.6F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.EDEN), EntityClassification.MONSTER);

    // Wildwood
    public static final EntityType<EntityBehemoth> BEHEMOTH = registerEntity(EntityBehemoth::new, "behemoth", 1.0F, 1.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.WILDWOOD), EntityClassification.MONSTER);
    public static final EntityType<EntityEpiphite> EPIPHITE = registerEntity(EntityEpiphite::new, "epiphite", 0.9F, 1.3F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.WILDWOOD), EntityClassification.MONSTER);
    public static final EntityType<EntityMage> MAGE = registerEntity(EntityMage::new, "mage", 0.5F, 2.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.WILDWOOD), EntityClassification.MONSTER);
    public static final EntityType<EntityMoonWolf> MOON_WOLF = registerEntity(EntityMoonWolf::new, "moon_wolf", 0.6F, 0.85F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.WILDWOOD), EntityClassification.MISC);
    public static final EntityType<EntityTermid> TERMID = registerEntity(EntityTermid::new, "termid", 0.4F, 1.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.WILDWOOD), EntityClassification.MONSTER);
    public static final EntityType<EntityVerek> VEREK = registerEntity(EntityVerek::new, "verek", 0.8F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.WILDWOOD), EntityClassification.MONSTER);
    public static final EntityType<EntityWildwoodCadillion> WILDWOOD_CADILLION = registerEntity(EntityWildwoodCadillion::new, "wildwood_cadillion", 1.0F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.WILDWOOD), EntityClassification.MONSTER);
    public static final EntityType<EntityWildwoodGolem> WILDWOOD_GOLEM = registerEntity(EntityWildwoodGolem::new, "wildwood_golem", 1.3F, 2.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.WILDWOOD), EntityClassification.MONSTER);
    public static final EntityType<EntityWildwoodTomo> WILDWOOD_TOMO = registerEntity(EntityWildwoodTomo::new, "wildwood_tomo", 1.0F, 1.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.WILDWOOD), EntityClassification.MONSTER);

    // Apalachia
    public static final EntityType<EntityApalachiaCadillion> APALACHIA_CADILLION = registerEntity(EntityApalachiaCadillion::new, "apalachia_cadillion", 1.0F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.APALACHIA), EntityClassification.MONSTER);
    public static final EntityType<EntityApalachiaGolem> APALACHIA_GOLEM = registerEntity(EntityApalachiaGolem::new, "apalachia_golem", 1.3F, 2.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.APALACHIA), EntityClassification.MONSTER);
    public static final EntityType<EntityApalachiaTomo> APALACHIA_TOMO = registerEntity(EntityApalachiaTomo::new, "apalachia_tomo", 1.0F, 1.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.APALACHIA), EntityClassification.MONSTER);
    public static final EntityType<EntityEnchantedArcher> ENCHANTED_ARCHER = registerEntity(EntityEnchantedArcher::new, "enchanted_archer", 1.8F, 3.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.APALACHIA), EntityClassification.MONSTER);
    public static final EntityType<EntityEnchantedWarrior> ENCHANTED_WARRIOR = registerEntity(EntityEnchantedWarrior::new, "enchanted_warrior", 0.6F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.APALACHIA), EntityClassification.MONSTER);
    public static final EntityType<EntitySpellbinder> SPELLBINDER = registerEntity(EntitySpellbinder::new, "spellbinder", 1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.APALACHIA), EntityClassification.MONSTER);

    // Skythern
    public static final EntityType<EntityAdvancedCori> ADVANCED_CORI = registerEntity(EntityAdvancedCori::new, "advanced_cori", 0.6F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.SKYTHERN), EntityClassification.MONSTER);
    public static final EntityType<EntityMegalith> MEGALITH = registerEntity(EntityMegalith::new, "megalith", 1.2F, 4.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.SKYTHERN), EntityClassification.MONSTER);
    public static final EntityType<EntityMystic> MYSTIC = registerEntity(EntityMystic::new, "mystic", 1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.SKYTHERN), EntityClassification.MONSTER);
    public static final EntityType<EntitySamek> SAMEK = registerEntity(EntitySamek::new, "samek", 0.8F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.SKYTHERN), EntityClassification.MONSTER);
    public static final EntityType<EntitySkythernArcher> SKYTHERN_ARCHER = registerEntity(EntitySkythernArcher::new, "skythern_archer", 1.8F, 3.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.SKYTHERN), EntityClassification.MONSTER);
    public static final EntityType<EntitySkythernFiend> SKYTHERN_FIEND = registerEntity(EntitySkythernFiend::new, "skythern_fiend", 0.6F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.SKYTHERN), EntityClassification.MONSTER);
    public static final EntityType<EntitySkythernGolem> SKYTHERN_GOLEM = registerEntity(EntitySkythernGolem::new, "skythern_golem", 1.3F, 2.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.SKYTHERN), EntityClassification.MONSTER);

    // Mortum
    public static final EntityType<EntityAngryBunny> ANGRY_BUNNY = registerEntity(EntityAngryBunny::new, "angry_bunny", 1.1F, 1.8F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.MORTUM), EntityClassification.MONSTER);
    public static final EntityType<EntityBasilisk> BASILISK = registerEntity(EntityBasilisk::new, "basilisk", 0.7F, 0.8F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.MORTUM), EntityClassification.MONSTER);
    public static final EntityType<EntityDemonOfDarkness> DEMON_OF_DARKNESS = registerEntity(EntityDemonOfDarkness::new, "demon_of_darkness", 0.8F, 1.6F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.MORTUM), EntityClassification.MONSTER);
    public static final EntityType<EntityMortumCadillion> MORTUM_CADILLION = registerEntity(EntityMortumCadillion::new, "mortum_cadillion", 1.0F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.MORTUM), EntityClassification.MONSTER);
    public static final EntityType<EntitySorcerer> SORCERER = registerEntity(EntitySorcerer::new, "sorcerer", 0.6F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.MORTUM), EntityClassification.MONSTER);
    public static final EntityType<EntitySoulSpider> SOUL_SPIDER = registerEntity(EntitySoulSpider::new, "soul_spider", 0.3F, 0.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.MORTUM), EntityClassification.MONSTER);
    public static final EntityType<EntitySoulStealer> SOUL_STEALER = registerEntity(EntitySoulStealer::new, "soul_stealer", 0.8F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.MORTUM), EntityClassification.MONSTER);
    public static final EntityType<EntityTwilightArcher> TWILIGHT_ARCHER = registerEntity(EntityTwilightArcher::new, "twilight_archer", 1.8F, 3.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.MORTUM), EntityClassification.MONSTER);

    // Arcana
    public static final EntityType<EntityCaptainMerik> CAPTAIN_MERIK = registerEntity(EntityCaptainMerik::new, "captain_merik", 0.8F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType<EntityDatticon> DATTICON = registerEntity(EntityDatticon::new, "datticon", 0.8F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType<EntityDeathcryx> DEATHCRYX = registerEntity(EntityDeathcryx::new, "deathcryx", 1.0F, 1.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MONSTER);
    public static final EntityType<EntityDeathHound> DEATH_HOUND = registerEntity(EntityDeathHound::new, "death_hound", 0.8F, 0.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MONSTER);
    public static final EntityType<EntityDungeonConstructor> DUNGEON_CONSTRUCTOR = registerEntity(EntityDungeonConstructor::new, "dungeon_constructor", 0.5F, 1.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MONSTER);
    public static final EntityType<EntityDungeonDemon> DUNGEON_DEMON = registerEntity(EntityDungeonDemon::new, "dungeon_demon", 0.6F, 2.15F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MONSTER);
    public static final EntityType<EntityDungeonPrisoner> DUNGEON_PRISONER = registerEntity(EntityDungeonPrisoner::new, "dungeon_prisoner", 0.6F, 2.15F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MONSTER);
    public static final EntityType<? extends TameableEntity> FYRACRYX = registerEntity(EntityFyracryx::new, "fyracryx", 1.0F, 1.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType<? extends TameableEntity> GOLEM_OF_REJUVENATION = registerEntity(EntityGolemOfRejuvenation::new, "golem_of_rejuvenation", 1F, 2.35F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType<EntityKazari> KAZARI = registerEntity(EntityKazari::new, "kazari", 0.8F, 1.8F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType<EntityLeorna> LEORNA = registerEntity(EntityLeorna::new, "leorna", 0.8F, 1.8F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType<EntityLivingStatue> LIVING_STATUE = registerEntity(EntityLivingStatue::new, "living_statue", 0.8F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MONSTER);
    public static final EntityType<EntityLordVatticus> LORD_VATTICUS = registerEntity(EntityLordVatticus::new, "lord_vatticus", 0.8F, 1.8F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType<? extends TameableEntity> PARATIKU = registerEntity(EntityParatiku::new, "paratiku", 0.5F, 0.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType<EntityRazorback> RAZORBACK = registerEntity(EntityRazorback::new, "razorback", 0.6F, 0.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MONSTER);
    public static final EntityType<EntityRoamer> ROAMER = registerEntity(EntityRoamer::new, "roamer", 0.6F, 1.8F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MONSTER);
    public static final EntityType<? extends TameableEntity> SEIMER = registerEntity(EntitySeimer::new, "seimer", 1.0F, 1.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType<EntityWarGeneral> WAR_GENERAL = registerEntity(EntityWarGeneral::new, "war_general", 0.8F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType<? extends TameableEntity> WRAITH = registerEntity(EntityWraith::new, "wraith", 0.9F, 1.4F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType<EntityZelus> ZELUS = registerEntity(EntityZelus::new, "zelus", 0.8F, 1.8F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);

    // Vethea
    public static final EntityType<EntityAcidHag> ACID_HAG = registerEntity(EntityAcidHag::new, "acid_hag", 1.0F, 1.6F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityBiphron> BIPHRON = registerEntity(EntityBiphron::new, "biphron", 1.0F, 4.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityBohemite> BOHEMITE = registerEntity(EntityBohemite::new, "bohemite", 1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityCryptKeeper> CRYPT_KEEPER = registerEntity(EntityCryptKeeper::new, "crypt_keeper", 1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MISC);
    public static final EntityType<EntityCymesoid> CYMESOID = registerEntity(EntityCymesoid::new, "cymesoid", 0.8F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityDissiment> DISSIMENT = registerEntity(EntityDissiment::new, "dissiment", 4.0F, 4.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityDreamwrecker> DREAMWRECKER = registerEntity(EntityDreamwrecker::new, "dreamwrecker", 1.0F, 4.4F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityDuo> DUO = registerEntity(EntityDuo::new, "duo", 1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityEnt> ENT = registerEntity(EntityEnt::new, "ent", 2.0F, 4.4F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityFakeVhraak> FAKE_VHRAAK = registerEntity(EntityFakeVhraak::new, "fake_vhraak", 1.0F, 1.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityGalroid> GALROID = registerEntity(EntityGalroid::new, "galroid", 1.0F, 3.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityGorgosion> GORGOSION = registerEntity(EntityGorgosion::new, "gorgosion", 2.0F, 1.6F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityHelio> HELIO = registerEntity(EntityHelio::new, "helio", 1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityHiveSoldier> HIVE_SOLDIER = registerEntity(EntityHiveSoldier::new, "hive_soldier", 0.6F, 1.8F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityHoverStinger> HOVER_STINGER = registerEntity(EntityHoverStinger::new, "hover_stinger", 1F, 2.4F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityKazrotic> KAZROTIC = registerEntity(EntityKazrotic::new, "kazrotic", 1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityLheiva> LHEIVA = registerEntity(EntityLheiva::new, "lheiva", 1.0F, 1.4F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<? extends MobEntity> LORGA = registerEntity(EntityLorga::new, "lorga", 1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<? extends MobEntity> LORGA_FLIGHT = registerEntity(EntityLorgaflight::new, "lorga_flight", 1.0F, 1.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityMandragora> MANDRAGORA = registerEntity(EntityMandragora::new, "mandragora", 1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityMysteriousManLayer1> MYSTERIOUS_MAN_LAYER1 = registerEntity(EntityMysteriousManLayer1::new, "mysterious_man_layer_1", 1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityMysteriousManLayer2> MYSTERIOUS_MAN_LAYER2 = registerEntity(EntityMysteriousManLayer2::new, "mysterious_man_layer_2", 1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityMysteriousManLayer3> MYSTERIOUS_MAN_LAYER3 = registerEntity(EntityMysteriousManLayer3::new, "mysterious_man_layer_3", 1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityShadahier> SHADAHIER = registerEntity(EntityShadahier::new, "shadahier", 0.8F, 1.3F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityTheHunger> THE_HUNGER = registerEntity(EntityTheHunger::new, "the_hunger", 0.8F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MISC);
    public static final EntityType<EntityTempleGuardian> TEMPLE_GUARDIAN = registerEntity(EntityTempleGuardian::new, "temple_guardian", 2.0F, 4.4F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityTocaxin> TOCAXIN = registerEntity(EntityTocaxin::new, "tocaxin", 1.0F, 3.3F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityTwins> TWINS = registerEntity(EntityTwins::new, "twins", 1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityVermenous> VERMENOUS = registerEntity(EntityVermenous::new, "vermenous", 1.0F, 3.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityVhraak> VHRAAK = registerEntity(EntityVhraak::new, "vhraak", 1.0F, 1.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityZone> ZONE = registerEntity(EntityZone::new, "zone", 1.0F, 1.3F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);
    public static final EntityType<EntityZoragon> ZORAGON = registerEntity(EntityZoragon::new, "zoragon", 4.0F, 4.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.VETHEA), EntityClassification.MONSTER);

    @SubscribeEvent
    public static void registerGlobalEntityAttributes(EntityAttributeCreationEvent event) {
        DivineRPG.LOGGER.info("[DivineRPG] Attached entity attributes");
        // Vanilla
        event.put(ARID_WARRIOR, EntityAridWarrior.attributes().build());
        event.put(BROWN_GRIZZLE, EntityBrownGrizzle.attributes().build());
        event.put(CAVE_CRAWLER, EntityCaveCrawler.attributes().build());
        event.put(CAVECLOPS, EntityCaveclops.attributes().build());
        event.put(CRAB, EntityCrab.attributes().build());
        event.put(CYCLOPS, EntityCyclops.attributes().build());
        event.put(DESERT_CRAWLER, EntityDesertCrawler.attributes().build());
        event.put(EHU, EntityEhu.attributes().build());
        event.put(ENTHRALLED_DRAMCRYX, EntityEnthralledDramcryx.attributes().build());
        event.put(FROST, EntityFrost.attributes().build());
        event.put(GLACON, EntityGlacon.attributes().build());
        event.put(HUSK, EntityHusk.attributes().build());
        event.put(JUNGLE_BAT, EntityJungleBat.attributes().build());
        event.put(JACK_O_MAN, EntityJackOMan.attributes().build());
        event.put(JUNGLE_DRAMCRYX, EntityJungleDramcryx.attributes().build());
        event.put(JUNGLE_SPIDER, EntityJungleSpider.attributes().build());
        event.put(KING_CRAB, EntityKingCrab.attributes().build());
        event.put(KOBBLIN, EntityKobblin.attributes().build());
        event.put(LIOPLEURODON, EntityLiopleurodon.attributes().build());
        event.put(LIVESTOCK_MERCHANT, EntityLivestockMerchant.attributes().build());
        event.put(MINER, EntityMiner.attributes().build());
        event.put(PUMPKIN_SPIDER, EntityPumpkinSpider.attributes().build());
        event.put(RAINBOUR, EntityRainbour.attributes().build());
        event.put(ROTATICK, EntityRotatick.attributes().build());
        event.put(SAGUARO_WORM, EntitySaguaroWorm.attributes().build());
        event.put(SHARK, EntityShark.attributes().build());
        event.put(SMELTER, EntitySmelter.attributes().build());
        event.put(SNAPPER, EntitySnapper.attributes().build());
        event.put(STONE_GOLEM, EntityStoneGolem.attributes().build());
        event.put(THE_EYE, EntityTheEye.attributes().build());
        event.put(THE_GRUE, EntityTheGrue.attributes().build());
        event.put(WHALE, EntityWhale.attributes().build());
        event.put(WHITE_GRIZZLE, EntityWhiteGrizzle.attributes().build());

        //Nether
        event.put(HELL_BAT, EntityHellBat.attributes().build());
        event.put(HELL_PIG, EntityHellPig.attributes().build());
        event.put(HELL_SPIDER, EntityHellSpider.attributes().build());
        event.put(SCORCHER, EntityScorcher.attributes().build());
        event.put(WILDFIRE, EntityWildfire.attributes().build());

        //End
        event.put(ENDER_SPIDER, EntityEnderSpider.attributes().build());
        event.put(ENDER_TRIPLETS, EntityEnderTriplets.attributes().build());
        event.put(ENDER_WATCHER, EntityEnderWatcher.attributes().build());

        //Boss
        event.put(ANCIENT_ENTITY, EntityAncientEntity.attributes().build());
        event.put(AYERACO_BLUE, EntityAyeracoBlue.attributes().build());
        event.put(AYERACO_GREEN, EntityAyeracoGreen.attributes().build());
        event.put(AYERACO_PURPLE, EntityAyeracoPurple.attributes().build());
        event.put(AYERACO_RED, EntityAyeracoRed.attributes().build());
        event.put(AYERACO_YELLOW, EntityAyeracoYellow.attributes().build());
        event.put(DENSOS, EntityDensos.attributes().build());
        event.put(DRAMIX, EntityDramix.attributes().build());
        event.put(ETERNAL_ARCHER, EntityEternalArcher.attributes().build());
        event.put(EXPERIENCED_CORI, EntityExperiencedCori.attributes().build());
        event.put(HIVE_QUEEN, EntityHiveQueen.attributes().build());
        event.put(KAROT, EntityKarot.attributes().build());
        event.put(KAROS, EntityKaros.attributes().build());
        event.put(KING_OF_SCORCHERS, EntityKingOfScorchers.attributes().build());
        event.put(LADY_LUNA, EntityLadyLuna.attributes().build());
        event.put(PARASECTA, EntityParasecta.attributes().build());
        event.put(QUADRO, EntityQuadro.attributes().build());
        event.put(RAGLOK, EntityRaglok.attributes().build());
        event.put(REYVOR, EntityReyvor.attributes().build());
        event.put(SOUL_FIEND, EntitySoulFiend.attributes().build());
        event.put(SUNSTORM, EntitySunstorm.attributes().build());
        event.put(TERMASECT, EntityTermasect.attributes().build());
        event.put(THE_WATCHER, EntityTheWatcher.attributes().build());
        event.put(TWILIGHT_DEMON, EntityTwilightDemon.attributes().build());
        event.put(VAMACHERON, EntityVamacheron.attributes().build());
        event.put(WRECK, EntityWreck.attributes().build());

        //Iceika
        event.put(ALICANTO, EntityAlicanto.attributes().build());
        event.put(FRACTITE, EntityFractite.attributes().build());
        event.put(FROST_ARCHER, EntityFrostArcher.attributes().build());
        event.put(FROSTY, EntityFrosty.attributes().build());
        event.put(GLACIDE, EntityGlacide.attributes().build());
        event.put(HASTREUS, EntityHastreus.attributes().build());
        event.put(ROLLUM, EntityRollum.attributes().build());
        event.put(WORKSHOP_MERCHANT, EntityWorkshopMerchant.attributes().build());
        event.put(WORKSHOP_TINKERER, EntityWorkshopTinkerer.attributes().build());

        //Eden
        event.put(BUNNY, EntityBunny.attributes().build());
        event.put(EDEN_CADILLION, EntityEdenCadillion.attributes().build());
        event.put(EDEN_TOMO, EntityEdenTomo.attributes().build());
        event.put(GREENFEET, EntityGreenfeet.attributes().build());
        event.put(MADIVEL, EntityMadivel.attributes().build());
        event.put(SUN_ARCHER, EntitySunArcher.attributes().build());
        event.put(WEAK_CORI, EntityWeakCori.attributes().build());

        //Wildwood
        event.put(BEHEMOTH, EntityBehemoth.attributes().build());
        event.put(EPIPHITE, EntityEpiphite.attributes().build());
        event.put(MAGE, EntityMage.attributes().build());
        event.put(MOON_WOLF, EntityMoonWolf.attributes().build());
        event.put(TERMID, EntityTermid.attributes().build());
        event.put(VEREK, EntityVerek.attributes().build());
        event.put(WILDWOOD_CADILLION, EntityWildwoodCadillion.attributes().build());
        event.put(WILDWOOD_GOLEM, EntityWildwoodGolem.attributes().build());
        event.put(WILDWOOD_TOMO, EntityWildwoodTomo.attributes().build());

        //Apalachia
        event.put(APALACHIA_CADILLION, EntityApalachiaCadillion.attributes().build());
        event.put(APALACHIA_GOLEM, EntityApalachiaGolem.attributes().build());
        event.put(APALACHIA_TOMO, EntityApalachiaTomo.attributes().build());
        event.put(ENCHANTED_ARCHER, EntityEnchantedArcher.attributes().build());
        event.put(ENCHANTED_WARRIOR, EntityEnchantedWarrior.attributes().build());
        event.put(SPELLBINDER, EntitySpellbinder.attributes().build());

        //Skythern
        event.put(ADVANCED_CORI, EntityAdvancedCori.attributes().build());
        event.put(MEGALITH, EntityMegalith.attributes().build());
        event.put(MYSTIC, EntityMystic.attributes().build());
        event.put(SAMEK, EntitySamek.attributes().build());
        event.put(SKYTHERN_ARCHER, EntitySkythernArcher.attributes().build());
        event.put(SKYTHERN_FIEND, EntitySkythernFiend.attributes().build());
        event.put(SKYTHERN_GOLEM, EntitySkythernGolem.attributes().build());

        //Mortum
        event.put(ANGRY_BUNNY, EntityAngryBunny.attributes().build());
        event.put(BASILISK, EntityBasilisk.attributes().build());
        event.put(DEMON_OF_DARKNESS, EntityDemonOfDarkness.attributes().build());
        event.put(MORTUM_CADILLION, EntityMortumCadillion.attributes().build());
        event.put(SORCERER, EntitySorcerer.attributes().build());
        event.put(SOUL_SPIDER, EntitySoulSpider.attributes().build());
        event.put(SOUL_STEALER, EntitySoulStealer.attributes().build());
        event.put(TWILIGHT_ARCHER, EntityTwilightArcher.attributes().build());

        //Arcana
        event.put(CAPTAIN_MERIK, EntityCaptainMerik.attributes().build());
        event.put(DATTICON, EntityDatticon.attributes().build());
        event.put(DEATHCRYX, EntityDeathcryx.attributes().build());
        event.put(DEATH_HOUND, EntityDeathHound.attributes().build());
        event.put(DUNGEON_CONSTRUCTOR, EntityDungeonConstructor.attributes().build());
        event.put(DUNGEON_DEMON, EntityDungeonDemon.attributes().build());
        event.put(DUNGEON_PRISONER, EntityDungeonPrisoner.attributes().build());
        event.put(FYRACRYX, EntityFyracryx.attributes().build());
        event.put(GOLEM_OF_REJUVENATION, EntityGolemOfRejuvenation.attributes().build());
        event.put(KAZARI, EntityKazari.attributes().build());
        event.put(LEORNA, EntityLeorna.attributes().build());
        event.put(LORD_VATTICUS, EntityLordVatticus.attributes().build());
        event.put(LIVING_STATUE, EntityLivingStatue.attributes().build());
        event.put(PARATIKU, EntityParatiku.attributes().build());
        event.put(RAZORBACK, EntityRazorback.attributes().build());
        event.put(ROAMER, EntityRoamer.attributes().build());
        event.put(SEIMER, EntitySeimer.attributes().build());
        event.put(WAR_GENERAL, EntityWarGeneral.attributes().build());
        event.put(WRAITH, EntityWraith.attributes().build());
        event.put(ZELUS, EntityZelus.attributes().build());
        
        //Vethea
        event.put(ACID_HAG, EntityAcidHag.attributes().build());
        event.put(BIPHRON, EntityBiphron.attributes().build());
        event.put(BOHEMITE, EntityBohemite.attributes().add(Attributes.MOVEMENT_SPEED, 0.4D).build());
        event.put(CRYPT_KEEPER, EntityCryptKeeper.attributes().add(Attributes.MOVEMENT_SPEED, 0.32D).add(Attributes.FOLLOW_RANGE, 35.0D).build());
        event.put(CYMESOID, EntityCymesoid.attributes().build());
        event.put(DISSIMENT, EntityDissiment.attributes().build());
        event.put(DREAMWRECKER, EntityDreamwrecker.attributes().build());
        event.put(DUO, EntityDuo.attributes().build());
        event.put(ENT, EntityEnt.attributes().build());
        event.put(FAKE_VHRAAK, EntityFakeVhraak.attributes().build());
        event.put(GALROID, EntityGalroid.attributes().build());
        event.put(GORGOSION, EntityGorgosion.attributes().build());
        event.put(HELIO, EntityHelio.attributes().build());
        event.put(HIVE_SOLDIER, EntityHiveSoldier.attributes().build());
        event.put(HOVER_STINGER, EntityHoverStinger.attributes().add(Attributes.MOVEMENT_SPEED, 0.32D).add(Attributes.FOLLOW_RANGE, 35.0D).build());
        event.put(KAZROTIC, EntityKazrotic.attributes().add(Attributes.MOVEMENT_SPEED, 0.27000000417232513D).add(Attributes.FOLLOW_RANGE, 20D).build());
        event.put(LHEIVA, EntityLheiva.attributes().build());
        event.put(LORGA, EntityLorga.attributes().add(Attributes.MOVEMENT_SPEED, 0.27000000417232513D).add(Attributes.FOLLOW_RANGE, 20D).build());
        event.put(LORGA_FLIGHT, EntityLorgaflight.attributes().add(Attributes.MOVEMENT_SPEED, 0.27000000417232513D).add(Attributes.FOLLOW_RANGE, 20D).build());
        event.put(MANDRAGORA, EntityMandragora.attributes().add(Attributes.MOVEMENT_SPEED, 0.27000000417232513D).add(Attributes.FOLLOW_RANGE, 20D).build());
        event.put(MYSTERIOUS_MAN_LAYER1, EntityMysteriousManLayer1.attributes().add(Attributes.MOVEMENT_SPEED, 0.32D).add(Attributes.FOLLOW_RANGE, 35.0D).build());
        event.put(MYSTERIOUS_MAN_LAYER2, EntityMysteriousManLayer2.attributes().add(Attributes.MOVEMENT_SPEED, 0.32D).add(Attributes.FOLLOW_RANGE, 35.0D).build());
        event.put(MYSTERIOUS_MAN_LAYER3, EntityMysteriousManLayer3.attributes().add(Attributes.MOVEMENT_SPEED, 0.32D).add(Attributes.FOLLOW_RANGE, 35.0D).build());
        event.put(SHADAHIER, EntityShadahier.attributes().build());
        event.put(TEMPLE_GUARDIAN, EntityTempleGuardian.attributes().add(Attributes.MOVEMENT_SPEED, 0.32D).add(Attributes.FOLLOW_RANGE, 35.0D).build());
        event.put(THE_HUNGER, EntityTheHunger.attributes().build());
        event.put(TOCAXIN, EntityTocaxin.attributes().build());
        event.put(TWINS, EntityTwins.attributes().add(Attributes.MOVEMENT_SPEED, 0.27000000417232513D).add(Attributes.FOLLOW_RANGE, 20.0D).build());
        event.put(VERMENOUS, EntityVermenous.attributes().build());
        event.put(VHRAAK, EntityVhraak.attributes().build());
        event.put(ZONE, EntityZone.attributes().add(Attributes.MOVEMENT_SPEED, 0.27000000417232513D).add(Attributes.FOLLOW_RANGE, 20.0D).build());
        event.put(ZORAGON, EntityZoragon.attributes().build());
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
        if (biome == Biome.Category.TAIGA || biome == Biome.Category.EXTREME_HILLS || biome == Biome.Category.JUNGLE || biome == Biome.Category.MESA || biome == Biome.Category.PLAINS || biome == Biome.Category.SAVANNA
                || biome == Biome.Category.ICY || biome == Biome.Category.BEACH || biome == Biome.Category.FOREST || biome == Biome.Category.OCEAN || biome == Biome.Category.DESERT || biome == Biome.Category.RIVER
                || biome == Biome.Category.SWAMP || biome == Biome.Category.MUSHROOM) {
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(CAVE_CRAWLER, 70, 2, 3));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(CAVECLOPS, 70, 1, 4));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(ENDER_SPIDER,  4, 1, 4));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(ENTHRALLED_DRAMCRYX, 70, 3, 4));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(JACK_O_MAN, 5, 1, 1));
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
        if (biome == Biome.Category.BEACH || biome == Biome.Category.RIVER || biome == Biome.Category.OCEAN) {
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(CRAB, 100, 4, 4));
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(KING_CRAB, 40, 4, 4));
        }
        if (biome == Biome.Category.JUNGLE) {
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(JUNGLE_BAT, 50, 1, 4));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(JUNGLE_DRAMCRYX, 80, 1, 4));
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(JUNGLE_SPIDER , 80, 1, 4));
        }
        if (biome == Biome.Category.PLAINS || biome == Biome.Category.SAVANNA || biome == Biome.Category.SWAMP || biome == Biome.Category.MESA || biome == Biome.Category.TAIGA) {
            event.getSpawns().getSpawner(EntityClassification.MISC).add(new MobSpawnInfo.Spawners(CYCLOPS, 10, 2, 4));
            event.getSpawns().getSpawner(EntityClassification.MISC).add(new MobSpawnInfo.Spawners(KOBBLIN, 5, 1, 1));
        }
        if (biome == Biome.Category.FOREST || biome == Biome.Category.MUSHROOM || biome == Biome.Category.SAVANNA) {
            event.getSpawns().getSpawner(EntityClassification.MISC).add(new MobSpawnInfo.Spawners(PUMPKIN_SPIDER, 20, 1, 1));
        }
        if (biome == Biome.Category.OCEAN) {
            event.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(LIOPLEURODON, 1, 1, 1));
            event.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(SHARK, 2, 1, 2));
            event.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(WHALE, 3, 1, 3));
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static void render() {
        DivineRPG.LOGGER.info("[DivineRPG] Registered entity renders");
        EntityRendererManager manager = Minecraft.getInstance().getEntityRenderDispatcher();

        //Projectile
        manager.register(ATTRACTOR, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/blank.png")));
        manager.register(BOUNCING_PROJECTILE, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/bouncing_projectile.png")));
        manager.register(CAVE_ROCK, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/cave_rock.png")));
        manager.register(CORI_SHOT, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/cori_shot.png")));
        manager.register(CORRUPTED_BULLET, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/items/corrupted_bullet.png")));
        manager.register(COLORED_BULLET, new RenderShooterBullet(manager));
        manager.register(DISK, new RenderDisk(manager));
        manager.register(DISSIMENT_SHOT, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/dissiment_shot.png")));
        manager.register(ARROW_SHOT, new RenderDivineArrow(manager));
        manager.register(ENDER_TRIPLETS_FIREBALL, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/ender_triplets_fireball.png")));
        manager.register(FIREFLY, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/firefly.png")));
        manager.register(FRACTITE_SHOT, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/fractite_shot.png")));
        manager.register(FROST_SHOT, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/frost_shot.png")));
        manager.register(FYRACRYX_FIREBALL, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation("minecraft:textures/items/fireball.png")));
        manager.register(GENERALS_STAFF, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/generals_staff.png")));
        manager.register(GRENADE, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/items/grenade.png")));
        manager.register(KAZROTIC_SHOT, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/kazrotic_shot.png")));
        manager.register(KING_OF_SCORCHERS_METEOR, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/king_of_scorchers_meteor.png")));
        manager.register(KING_OF_SCORCHERS_SHOT, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/king_of_scorchers_shot.png")));
        manager.register(LADY_LUNA_SPARKLER, new RenderShooterBullet(manager));
        manager.register(MAGE_SHOT, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/mage_shot.png")));
        manager.register(MANDRAGORA_PROJECTILE, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/mandragora_projectile.png")));
        manager.register(MERIKS_MISSILE, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/meriks_missile.png")));
        manager.register(METEOR, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/meteor.png")));
        manager.register(PARTICLE_BULLET, new RenderShooterBullet(manager));
        manager.register(RAGLOK_BOMB, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/raglok_bomb.png")));
        manager.register(REFLECTOR, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/blank.png")));
        manager.register(SAGUARO_WORM_SHOT, new RenderSaguaroWormShot(manager));
        manager.register(SCORCHER_SHOT, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/scorcher_shot.png")));
        manager.register(SERENADE_OF_DEATH, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/serenade_of_death.png")));
        manager.register(SERENADE_OF_ICE, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/blank.png")));
        manager.register(SHOOTER_BULLET, new RenderShooterBullet(manager));
        manager.register(SHURIKEN, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/items/shuriken.png")));
        manager.register(SNOWFLAKE_SHURIKEN, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/items/snowflake_shuriken.png")));
        manager.register(SOUL_FIEND_SHOT, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/blank.png")));
        manager.register(SOUND_OF_CAROLS, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/music.png")));
        manager.register(SOUND_OF_MUSIC, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/music.png")));
        manager.register(SPARKLER, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/sparkler.png")));
        manager.register(STARLIGHT, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/starlight.png")));
        manager.register(TWILIGHT_DEMON_SHOT, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/twilight_demon_shot.png")));
        manager.register(TWILIGHT_MAGE_SHOT, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/blank.png")));
        manager.register(VILE_STORM, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/items/vile_storm.png")));
        manager.register(WATCHER_SHOT, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/watcher_shot.png")));
        manager.register(WRECK_BOUNCING_PROJECTILE, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/wreck_bouncing_projectile.png")));
        manager.register(WRECK_EXPLOSIVE_SHOT, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/wreck_explosive_shot.png")));
        manager.register(WRECK_SHOT, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/wreck_shot.png")));
        manager.register(ZORAGON_BOMB, new RenderDivineProjectile<DivineThrowable>(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/zoragon_bomb.png")));
        manager.register(WILDWOOD_LOG, new RenderWildwoodLog(manager));
        manager.register(FROST_CLOUD, new RenderFrostCloud(manager));

        //Overworld
        manager.register(ARID_WARRIOR, new RenderAridWarrior(manager));
        manager.register(CAVE_CRAWLER, new RenderDivineMob(manager, new ModelCrawler<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/cave_crawler.png")));
        manager.register(BROWN_GRIZZLE, new RenderDivineMob(manager, new ModelGrizzle<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/brown_grizzle.png")));
        manager.register(CAVECLOPS, new RenderCaveclops(manager));
        manager.register(CRAB, new RenderDivineMob(manager, new ModelCrab<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/crab.png")));
        manager.register(CYCLOPS, new RenderCyclops(manager));
        manager.register(DESERT_CRAWLER, new RenderDivineMob(manager, new ModelCrawler<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/desert_crawler.png")));
        manager.register(EHU, new RenderDivineMob(manager, new ModelEhu<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ehu.png")));
        manager.register(ENTHRALLED_DRAMCRYX, new RenderDivineMob(manager, new ModelEnthralledDramcryx<Entity>(), 1.5F, new ResourceLocation(DivineRPG.MODID, "textures/entity/enthralled_dramcryx.png")));
        manager.register(FROST, new RenderDivineMob(manager, new ModelFrost<Entity>(), 1.5F, new ResourceLocation(DivineRPG.MODID, "textures/entity/frost.png")));
        manager.register(GLACON, new RenderDivineMob(manager, new ModelGlacon<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/glacon.png")));
        manager.register(HUSK, new RenderDivineMob(manager, new ModelHusk<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/husk.png")));
        manager.register(JACK_O_MAN, new RenderJackOMan(manager));
        manager.register(JUNGLE_BAT, new RenderDivineMob(manager, new ModelJungleBat(), new ResourceLocation(DivineRPG.MODID, "textures/entity/jungle_bat.png")));
        manager.register(JUNGLE_DRAMCRYX, new RenderDivineMob(manager, new ModelDramcryx<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/jungle_dramcryx.png")));
        manager.register(JUNGLE_SPIDER, new RenderDivineMob(manager, new ModelJungleSpider<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/jungle_spider.png")));
        manager.register(KING_CRAB, new RenderDivineMob(manager, new ModelKingCrab(), 2F, new ResourceLocation(DivineRPG.MODID, "textures/entity/king_crab.png")));
        manager.register(KOBBLIN, new RenderKobblin(manager));
        manager.register(LIOPLEURODON, new RenderDivineMob(manager, new ModelLiopleurodon<Entity>(), 2F, new ResourceLocation(DivineRPG.MODID, "textures/entity/liopleurodon.png")));
        manager.register(LIVESTOCK_MERCHANT, new RenderDivineMob(manager, new ModelLivestockMerchant<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/livestock_merchant.png")));
        manager.register(MINER, new RenderMiner(manager));
        manager.register(PUMPKIN_SPIDER, new RenderDivineMob(manager, new ModelPumpkinSpider<EntityPumpkinSpider>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/pumpkin_spider.png"), 0));
        manager.register(RAINBOUR, new RenderDivineMob(manager, new ModelRainbour<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/rainbour.png"), 0));
        manager.register(ROTATICK, new RenderDivineMob(manager, new ModelRotatick<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/rotatick.png"), 0));
        manager.register(SAGUARO_WORM, new RenderDivineMob(manager, new ModelSaguaroWorm<EntitySaguaroWorm>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/saguaro_worm.png"), 0));
        manager.register(SHARK, new RenderShark(manager));
        manager.register(SMELTER, new RenderDivineMob(manager, new ModelStoneGolem<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/smelter.png"), 0));
        manager.register(SNAPPER, new RenderDivineMob(manager, new ModelSnapper<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/snapper.png"), 0));
        manager.register(STONE_GOLEM, new RenderDivineMob(manager, new ModelStoneGolem<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/stone_golem.png"), 0));
        manager.register(THE_EYE, new RenderDivineMob(manager, new ModelTheEye<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/the_eye.png"), 0));
        manager.register(THE_GRUE, new RenderDivineMob(manager, new ModelTheGrue<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/the_grue.png"), 0));
        manager.register(WHALE, new RenderWhale(manager));
        manager.register(WHITE_GRIZZLE, new RenderDivineMob(manager, new ModelGrizzle<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/white_grizzle.png")));

        //Nether
        manager.register(HELL_BAT, new RenderDivineMob(manager, new ModelHellBat(), new ResourceLocation(DivineRPG.MODID, "textures/entity/hell_bat.png")));
        manager.register(HELL_PIG, new RenderHellPig(manager));
        manager.register(HELL_SPIDER, new RenderDivineMob(manager, new ModelHellSpider<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/hell_spider.png")));
        manager.register(SCORCHER, new RenderDivineMob(manager, new ModelScorcher<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/scorcher.png")));
        manager.register(WILDFIRE, new RenderWildfire(manager));

        //End
        manager.register(ENDER_SPIDER, new RenderDivineMob(manager, new ModelEnderSpider<Entity>(), 0.5F, new ResourceLocation(DivineRPG.MODID, "textures/entity/ender_spider.png")));
        manager.register(ENDER_TRIPLETS, new RenderDivineMob(manager, new ModelEnderTriplets<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ender_triplets.png")));
        manager.register(ENDER_WATCHER, new RenderDivineMob(manager, new ModelEnderWatcher<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ender_watcher.png")));

        //Boss
        manager.register(ANCIENT_ENTITY, new RenderDivineMob(manager, new ModelAncientEntity<Entity>(), 6F, new ResourceLocation(DivineRPG.MODID, "textures/entity/ancient_entity.png")));
        manager.register(AYERACO_BLUE, new RenderDivineMob(manager, new ModelAyeraco(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_blue.png")));
        manager.register(AYERACO_GREEN, new RenderDivineMob(manager, new ModelAyeraco(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_green.png")));
        manager.register(AYERACO_RED, new RenderDivineMob(manager, new ModelAyeraco(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_red.png")));
        manager.register(AYERACO_PURPLE, new RenderDivineMob(manager, new ModelAyeraco(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_purple.png")));
        manager.register(AYERACO_YELLOW, new RenderDivineMob(manager, new ModelAyeraco(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_yellow.png")));
        manager.register(DENSOS, new RenderDivineMob(manager, new ModelDensos<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/densos.png")));
        manager.register(DRAMIX, new RenderDivineMob(manager, new ModelDramix<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/dramix.png")));
        manager.register(ETERNAL_ARCHER, new RenderDivineMob(manager, new ModelEternalArcher<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/eternal_archer.png")));
        manager.register(EXPERIENCED_CORI, new RenderDivineMob(manager, new ModelExperiencedCori<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/experienced_cori.png")));
        manager.register(HIVE_QUEEN, new RenderDivineMob(manager, new ModelHiveQueen<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/hive_queen.png")));
        manager.register(KAROT, new RenderDivineMob(manager, new ModelKarot<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/karot.png")));
        manager.register(KAROS, new RenderDivineMob(manager, new ModelKaros<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/karos.png")));
        manager.register(KING_OF_SCORCHERS, new RenderDivineMob(manager, new ModelKingScorcher<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/king_of_scorchers.png")));
        manager.register(LADY_LUNA, new RenderDivineMob(manager, new ModelLadyLuna<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/lady_luna.png")));
        manager.register(PARASECTA, new RenderDivineMob(manager, new ModelParasecta<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/parasecta.png")));
        manager.register(QUADRO, new RenderDivineMob(manager, new ModelQuadro<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/quadro.png")));
        manager.register(RAGLOK, new RenderDivineMob(manager, new ModelRaglok<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/raglok.png")));
        manager.register(REYVOR, new RenderReyvor(manager));
        manager.register(SOUL_FIEND, new RenderDivineMob(manager, new ModelSoulFiend<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/soul_fiend.png")));
        manager.register(SUNSTORM, new RenderDivineMob(manager, new ModelSunstorm<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/sunstorm.png")));
        manager.register(TERMASECT, new RenderDivineMob(manager, new ModelTermasect<Entity>(), 5F, new ResourceLocation(DivineRPG.MODID, "textures/entity/termasect.png")));
        manager.register(THE_WATCHER, new RenderDivineMob(manager, new ModelTheWatcher<Entity>(), 6F, new ResourceLocation(DivineRPG.MODID, "textures/entity/the_watcher.png")));
        manager.register(TWILIGHT_DEMON, new RenderDivineMob(manager, new ModelTwilightDemon<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/twilight_demon.png")));
        manager.register(VAMACHERON, new RenderDivineMob(manager, new ModelVamacheron<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/vamacheron.png")));
        manager.register(WRECK, new RenderWreck(manager));

        //Iceika
        manager.register(ALICANTO, new RenderDivineMob(manager, new ModelAlicanto<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/alicanto.png")));
        manager.register(FRACTITE, new RenderDivineMob(manager, new ModelFractite<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/fractite.png")));
        manager.register(FROST_ARCHER, new RenderFrostArcher(manager));
        manager.register(FROSTY, new RenderDivineMob(manager, new ModelFrosty<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/frosty.png")));
        manager.register(GLACIDE, new RenderDivineMob(manager, new ModelGlacide<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/glacon.png")));
        manager.register(HASTREUS, new RenderDivineMob(manager, new ModelHastreus<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/hastreus.png")));
        manager.register(ROLLUM, new RenderDivineMob(manager, new ModelRollum<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/rollum.png")));
        manager.register(WORKSHOP_MERCHANT, new RenderDivineMob(manager, new ModelWorkshop<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/workshop_merchant.png")));
        manager.register(WORKSHOP_TINKERER, new RenderDivineMob(manager, new ModelWorkshop<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/workshop_tinkerer.png")));

        //Eden
        manager.register(BUNNY, new RenderDivineMob(manager, new ModelBunny<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/bunny.png")));
        manager.register(EDEN_CADILLION, new RenderDivineMob(manager, new ModelCadillion(), new ResourceLocation(DivineRPG.MODID, "textures/entity/eden_cadillion.png")));
        manager.register(EDEN_TOMO, new RenderDivineMob(manager, new ModelTomo<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/eden_tomo.png")));
        manager.register(GREENFEET, new RenderDivineMob(manager, new ModelGreenfeet<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/greenfeet.png")));
        manager.register(MADIVEL, new RenderDivineMob(manager, new ModelMadivel<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/madivel.png")));
        manager.register(SUN_ARCHER, new RenderSunArcher(manager));
        manager.register(WEAK_CORI, new RenderDivineMob(manager, new ModelCori<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/weak_cori.png")));

        //Wildwood
        manager.register(BEHEMOTH, new RenderDivineMob(manager, new ModelBehemoth<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/behemoth.png")));
        manager.register(EPIPHITE, new RenderDivineMob(manager, new ModelEpiphite<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/epiphite.png")));
        manager.register(MAGE, new RenderDivineMob(manager, new ModelMage<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/mage.png")));
        manager.register(MOON_WOLF, new RenderDivineMob(manager, new ModelMoonWolf<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf.png")));
        manager.register(TERMID, new RenderDivineMob(manager, new ModelTermid<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/termid.png")));
        manager.register(VEREK, new RenderDivineMob(manager, new ModelSamek<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/verek.png")));
        manager.register(WILDWOOD_CADILLION, new RenderDivineMob(manager, new ModelCadillionTEMP<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/wildwood_cadillion.png")));
        manager.register(WILDWOOD_GOLEM, new RenderDivineMob(manager, new ModelTwilightGolem<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/wildwood_golem.png")));
        manager.register(WILDWOOD_TOMO, new RenderDivineMob(manager, new ModelTomo<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/wildwood_tomo.png")));

        //Apalachia
        manager.register(APALACHIA_CADILLION, new RenderDivineMob(manager, new ModelCadillionTEMP<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/apalachia_cadillion.png")));
        manager.register(APALACHIA_GOLEM, new RenderDivineMob(manager, new ModelTwilightGolem<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/apalachia_golem.png")));
        manager.register(APALACHIA_TOMO, new RenderDivineMob(manager, new ModelTomo<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/apalachia_tomo.png")));
        manager.register(ENCHANTED_ARCHER, new RenderEnchantedArcher(manager));
        manager.register(ENCHANTED_WARRIOR, new RenderEnchantedWarrior(manager));
        manager.register(SPELLBINDER, new RenderDivineMob(manager, new ModelMystic<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/spellbinder.png")));

        //Skythern
        manager.register(ADVANCED_CORI, new RenderDivineMob(manager, new ModelCori<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/advanced_cori.png")));
        manager.register(MEGALITH, new RenderDivineMob(manager, new ModelMegalith<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/megalith.png")));
        manager.register(MYSTIC, new RenderDivineMob(manager, new ModelMystic<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/mystic.png")));
        manager.register(SAMEK, new RenderDivineMob(manager, new ModelSamek<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/samek.png")));
        manager.register(SKYTHERN_ARCHER, new RenderSkythernArcher(manager));
        manager.register(SKYTHERN_FIEND, new RenderDivineMob(manager, new ModelSkythernFiend<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/skythern_fiend.png")));
        manager.register(SKYTHERN_GOLEM, new RenderDivineMob(manager, new ModelTwilightGolem<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/skythern_golem.png")));

        //Mortum
        manager.register(ANGRY_BUNNY, new RenderDivineMob(manager, new ModelAngryBunny<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/angry_bunny.png")));
        manager.register(BASILISK, new RenderDivineMob(manager, new ModelBasilisk<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/basilisk.png")));
        manager.register(DEMON_OF_DARKNESS, new RenderDivineMob(manager, new ModelDemonOfDarkness<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/demon_of_darkness.png")));
        manager.register(MORTUM_CADILLION, new RenderDivineMob(manager, new ModelCadillionTEMP<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/mortum_cadillion.png")));
        manager.register(SORCERER, new RenderDivineMob(manager, new ModelSorcerer<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/sorcerer.png")));
        manager.register(SOUL_SPIDER, new RenderDivineMob(manager, new ModelSoulSpider<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/soul_spider.png")));
        manager.register(SOUL_STEALER, new RenderDivineMob(manager, new ModelSoulStealer<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/soul_stealer.png")));
        manager.register(TWILIGHT_ARCHER, new RenderTwilightArcher(manager));

        //Arcana
        manager.register(CAPTAIN_MERIK, new RenderDivineMob(manager, new ModelSamek<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/captain_merik.png")));
        manager.register(DATTICON, new RenderDivineMob(manager, new ModelSamek<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/datticon.png")));
        manager.register(DEATHCRYX, new RenderDivineMob(manager, new ModelDeathcryx<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/deathcryx.png")));
        manager.register(DEATH_HOUND, new RenderDivineMob(manager, new ModelDeathHound<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/death_hound.png")));
        manager.register(DUNGEON_CONSTRUCTOR, new RenderDungeonConstructor(manager));
        manager.register(DUNGEON_DEMON, new RenderDivineMob(manager, new ModelDungeonDemon<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/dungeon_demon.png")));
        manager.register(DUNGEON_PRISONER, new RenderDivineMob(manager, new ModelDungeonPrisoner<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/dungeon_prisoner.png")));
        manager.register(FYRACRYX, new RenderDivineMob(manager, new ModelDeathcryx<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/fyracryx.png")));
        manager.register(GOLEM_OF_REJUVENATION, new RenderDivineMob(manager, new ModelRejuvGolem<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/golem_of_rejuvenation.png")));
        manager.register(KAZARI, new RenderKazari(manager));
        manager.register(LEORNA, new RenderDivineMob(manager, new ModelLeorna<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/leorna.png")));
        manager.register(LORD_VATTICUS, new RenderLordVatticus(manager));
        manager.register(LIVING_STATUE, new RenderLivingStatue(manager));
        manager.register(PARATIKU, new RenderDivineMob(manager, new ModelParatiku<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/paratiku.png")));
        manager.register(RAZORBACK, new RenderDivineMob(manager, new ModelRazorback<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/razorback.png")));
        manager.register(ROAMER, new RenderDivineMob(manager, new ModelRoamer<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/roamer.png")));
        manager.register(SEIMER, new RenderDivineMob(manager, new ModelSeimer<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/seimer.png")));
        manager.register(WAR_GENERAL, new RenderDivineMob(manager, new ModelSamek<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/war_general.png")));
        manager.register(WRAITH, new RenderDivineMob(manager, new ModelWraith<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/wraith.png")));
        manager.register(ZELUS, new RenderZelus(manager));
        
        //Vethea
        manager.register(ACID_HAG, new RenderDivineMob(manager, new ModelAcidHag<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/acid_hag.png")));
        manager.register(BIPHRON, new RenderDivineMob(manager, new ModelBiphron<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/biphron.png")));
        manager.register(BOHEMITE, new RenderDivineMob(manager, new ModelBohemite<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/bohemite.png")));
        manager.register(CRYPT_KEEPER, new RenderDivineMob(manager, new ModelCryptKeeper<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/crypt_keeper.png")));
        manager.register(CYMESOID, new RenderDivineMob(manager, new ModelCymesoid<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/cymesoid.png")));
        manager.register(DISSIMENT, new RenderDivineMob(manager, new ModelDissiment<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/dissiment.png")));
        manager.register(DREAMWRECKER, new RenderDivineMob(manager, new ModelDreamwrecker<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/dreamwrecker.png")));
        manager.register(DUO, new RenderDivineMob(manager, new ModelDuo<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/duo.png")));
        manager.register(ENT, new RenderDivineMob(manager, new ModelEnt<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ent.png")));
        manager.register(FAKE_VHRAAK, new RenderDivineMob(manager, new ModelVhraak<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/vhraak.png")));
        manager.register(GALROID, new RenderDivineMob(manager, new ModelGalroid<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/galroid.png")));
        manager.register(GORGOSION, new RenderDivineMob(manager, new ModelGorgosion<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/gorgosion.png")));
        manager.register(HELIO, new RenderDivineMob(manager, new ModelHelio<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/helio.png")));
        manager.register(HIVE_SOLDIER, new RenderDivineMob(manager, new ModelHiveSoldier<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/hive_soldier.png")));
        manager.register(HOVER_STINGER, new RenderDivineMob(manager, new ModelHoverStinger<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/hover_stinger.png")));
        manager.register(KAZROTIC, new RenderDivineMob(manager, new ModelKazrotic<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/kazrotic.png")));
        manager.register(LHEIVA, new RenderDivineMob(manager, new ModelLheiva<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/lheiva.png")));
        manager.register(LORGA, new RenderDivineMob(manager, new ModelLorga<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/lorga.png")));
        manager.register(LORGA_FLIGHT, new RenderDivineMob(manager, new ModelLorgaflight<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/lorga_flight.png")));
        manager.register(MANDRAGORA, new RenderDivineMob(manager, new ModelMandragora<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/mandragora.png")));
        manager.register(MYSTERIOUS_MAN_LAYER1, new RenderDivineMob(manager, new ModelMysteriousMan<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/mysterious_man_layer_1.png")));
        manager.register(MYSTERIOUS_MAN_LAYER2, new RenderDivineMob(manager, new ModelMysteriousMan<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/mysterious_man_layer_2.png")));
        manager.register(MYSTERIOUS_MAN_LAYER3, new RenderDivineMob(manager, new ModelMysteriousMan<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/mysterious_man_layer_3.png")));
        manager.register(SHADAHIER, new RenderDivineMob(manager, new ModelShadahier<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/shadahier.png")));
        manager.register(THE_HUNGER, new RenderDivineMob(manager, new ModelTheHunger<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/the_hunger.png")));
        manager.register(TOCAXIN, new RenderDivineMob(manager, new ModelTocaxin<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/tocaxin.png")));
        manager.register(TWINS, new RenderDivineMob(manager, new ModelTwins<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/twins.png")));
        manager.register(VERMENOUS, new RenderDivineMob(manager, new ModelVermenous<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/vermenous.png")));
        manager.register(VHRAAK, new RenderDivineMob(manager, new ModelVhraak<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/vhraak.png")));
        manager.register(ZONE, new RenderDivineMob(manager, new ModelZone<Entity>(), new ResourceLocation(DivineRPG.MODID, "textures/entity/zone.png")));
        manager.register(ZORAGON, new RenderDivineMob(manager, new ModelZoragon<Entity>(), 4, new ResourceLocation(DivineRPG.MODID, "textures/entity/zoragon.png")));
    }

    private static <T extends Entity> EntityType<T> registerEntity(EntityType.IFactory<T> factory, String entityName, float width, float height, SpawnEggColors colors, EntityClassification classification) {
        ResourceLocation location = new ResourceLocation(DivineRPG.MODID, entityName);
        boolean cache = SharedConstants.CHECK_DATA_FIXER_SCHEMA;
        SharedConstants.CHECK_DATA_FIXER_SCHEMA = false;
        EntityType<T> entity = EntityType.Builder.of(factory, classification).sized(width, height).setTrackingRange(120).build(location.getPath());
        entity.setRegistryName(location);
        SharedConstants.CHECK_DATA_FIXER_SCHEMA = cache;
        ENTITIES.add(entity);
        SPAWN_EGGS.add(new SpawnEggItem(entity, colors.getPrimaryColor(), colors.getSecondaryColor(), (new Item.Properties()).tab(DivineRPG.tabs.spawners)).setRegistryName(entityName +"_spawn_egg"));
        return entity;
    }

    private static <T extends Entity> EntityType<T> registerEntity(EntityType.IFactory<T> factory, String entityName, float width, float height, EntityClassification classification) {
        ResourceLocation location = new ResourceLocation(DivineRPG.MODID, entityName);
        boolean cache = SharedConstants.CHECK_DATA_FIXER_SCHEMA;
        SharedConstants.CHECK_DATA_FIXER_SCHEMA = false;
        EntityType<T> entity = EntityType.Builder.of(factory, classification).sized(width, height).setTrackingRange(120).build(location.getPath());
        entity.setRegistryName(location);
        SharedConstants.CHECK_DATA_FIXER_SCHEMA = cache;
        ENTITIES.add(entity);
        return entity;
    }

    private static <T extends Entity> EntityType<T> registerProjectileNoThrow(EntityType.IFactory<T> factory, String entityName) {
        ResourceLocation location = new ResourceLocation(DivineRPG.MODID, entityName);
        boolean cache = SharedConstants.CHECK_DATA_FIXER_SCHEMA;
        SharedConstants.CHECK_DATA_FIXER_SCHEMA = false;
        EntityType<T> entity = EntityType.Builder.of(factory, EntityClassification.MISC).sized(0.5F, 0.5F).setTrackingRange(120).setUpdateInterval(20).build(location.getPath());
        entity.setRegistryName(location);
        SharedConstants.CHECK_DATA_FIXER_SCHEMA = cache;
        ENTITIES.add(entity);
        return entity;
    }

    private static <T extends ThrowableEntity> EntityType<T> registerProjectile(EntityType.IFactory<T> factory, String entityName) {
        ResourceLocation location = new ResourceLocation(DivineRPG.MODID, entityName);
        boolean cache = SharedConstants.CHECK_DATA_FIXER_SCHEMA;
        SharedConstants.CHECK_DATA_FIXER_SCHEMA = false;
        EntityType<T> entity = EntityType.Builder.of(factory, EntityClassification.MISC).sized(0.25F, 0.25F).setTrackingRange(120).setUpdateInterval(20).build(location.getPath());
        entity.setRegistryName(location);
        SharedConstants.CHECK_DATA_FIXER_SCHEMA = cache;
        ENTITIES.add(entity);
        return entity;
    }
    private static <T extends ArrowEntity> EntityType<T> registerArrowProjectile(EntityType.IFactory<T> factory, String entityName) {
        ResourceLocation location = new ResourceLocation(DivineRPG.MODID, entityName);
        boolean cache = SharedConstants.CHECK_DATA_FIXER_SCHEMA;
        SharedConstants.CHECK_DATA_FIXER_SCHEMA = false;
        EntityType<T> entity = EntityType.Builder.of(factory, EntityClassification.MISC).sized(0.25F, 0.25F).setTrackingRange(120).setUpdateInterval(20).build(location.getPath());
        entity.setRegistryName(location);
        SharedConstants.CHECK_DATA_FIXER_SCHEMA = cache;
        ENTITIES.add(entity);
        return entity;
    }
    private static <T extends FireballEntity> EntityType<T> registerFireballProjectile(EntityType.IFactory<T> factory, String entityName) {
        ResourceLocation location = new ResourceLocation(DivineRPG.MODID, entityName);
        boolean cache = SharedConstants.CHECK_DATA_FIXER_SCHEMA;
        SharedConstants.CHECK_DATA_FIXER_SCHEMA = false;
        EntityType<T> entity = EntityType.Builder.of(factory, EntityClassification.MISC).sized(0.25F, 0.25F).setTrackingRange(120).setUpdateInterval(20).build(location.getPath());
        entity.setRegistryName(location);
        SharedConstants.CHECK_DATA_FIXER_SCHEMA = cache;
        ENTITIES.add(entity);
        return entity;
    }
    private static <T extends SnowballEntity> EntityType<T> registerSnowballProjectile(EntityType.IFactory<T> factory, String entityName) {
        ResourceLocation location = new ResourceLocation(DivineRPG.MODID, entityName);
        boolean cache = SharedConstants.CHECK_DATA_FIXER_SCHEMA;
        SharedConstants.CHECK_DATA_FIXER_SCHEMA = false;
        EntityType<T> entity = EntityType.Builder.of(factory, EntityClassification.MISC).sized(0.25F, 0.25F).setTrackingRange(120).setUpdateInterval(20).build(location.getPath());
        entity.setRegistryName(location);
        SharedConstants.CHECK_DATA_FIXER_SCHEMA = cache;
        ENTITIES.add(entity);
        return entity;
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        for (EntityType<?> entity : ENTITIES) {
            Preconditions.checkNotNull(entity.getRegistryName(), "registryName");
            event.getRegistry().register(entity);
        }
    }
    @SubscribeEvent
    public static void registerSpawnEggs(final RegistryEvent.Register<Item> event) {
        for (Item spawnEgg : SPAWN_EGGS) {
            Preconditions.checkNotNull(spawnEgg.getRegistryName(), "registryName");
            event.getRegistry().register(spawnEgg);
        }
    }
}