package divinerpg.registries;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import divinerpg.DivineRPG;
import divinerpg.client.models.arcana.*;
import divinerpg.client.models.iceika.*;
import divinerpg.client.models.twilight.*;
import divinerpg.client.models.vanilla.*;
import divinerpg.client.renders.base.RenderDivineMob;
import divinerpg.client.renders.entity.arcana.*;
import divinerpg.client.renders.entity.iceika.RenderFrostArcher;
import divinerpg.client.renders.entity.twilight.RenderSunArcher;
import divinerpg.client.renders.entity.vanilla.*;
import divinerpg.entities.apalachia.*;
import divinerpg.entities.arcana.*;
import divinerpg.entities.boss.EntityTheWatcher;
import divinerpg.entities.eden.*;
import divinerpg.entities.iceika.*;
import divinerpg.entities.mortum.*;
import divinerpg.entities.projectile.EntityWatcherShot;
import divinerpg.entities.skythern.*;
import divinerpg.entities.vanilla.end.*;
import divinerpg.entities.vanilla.nether.*;
import divinerpg.entities.vanilla.overworld.*;
import divinerpg.entities.wildwood.*;
import divinerpg.util.SpawnEggColors;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.client.registry.*;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRegistry {
    private static final List<EntityType<?>> ENTITIES = Lists.newArrayList();
    private static final List<Item> SPAWN_EGGS = Lists.newArrayList();

    //Projectile
    public static final EntityType WATCHER_SHOT = registerEntity(EntityWatcherShot::new, "watcher_shot",0.5F, 0.5F, EntityClassification.MISC);
//    buildProjectileEntry(EntityCaveRock.class, "cave_rock"),
//    buildProjectileEntry(EntitySerenadeOfDeath.class, "serenade_of_death"),
//    buildProjectileEntry(EntitySerenadeOfIce.class, "serenade_of_ice"),
//    buildProjectileEntry(EntityEnderTripletsFireball.class, "ender_triplets_fireball"),
//    buildProjectileEntry(EntityFractiteShot.class, "fractite_shot"),
//    buildProjectileEntry(EntityFrostShot.class, "frost_shot"),
//    buildProjectileEntry(EntityFrostCloud.class, "frost_cloud"),
//    buildProjectileEntry(EntityKingOfScorchersMeteor.class, "king_of_scorchers_meteor"),
//    buildProjectileEntry(EntityKingOfScorchersShot.class, "king_of_scorchers_shot"),
//    buildProjectileEntry(EntitySaguaroWormShot.class, "saguaro_worm_shot"),
//    buildProjectileEntry(EntityScorcherShot.class, "scorcher_shot"),
//    buildProjectileEntry(EntityShuriken.class, "shuriken"),
//    buildProjectileEntry(EntitySparkler.class, "sparkler"),
//    buildProjectileEntry(EntityVileStorm.class, "vile_storm"),
//    buildProjectileEntry(EntitySnowflakeShuriken.class, "snowflake_shuriken"),
//    buildProjectileEntry(EntityShooterBullet.class, "shooter_bullet"),
//    buildProjectileEntry(EntityParticleBullet.class, "particle_bullet"),
//    buildProjectileEntry(EntityColoredBullet.class, "colored_bullet"),
//    buildProjectileEntry(EntityCorruptedBullet.class, "corrupted_bullet"),
//    buildProjectileEntry(EntitySoundOfMusic.class, "sound_of_music"),
//    buildProjectileEntry(EntitySoundOfCarols.class, "sound_of_carols"),
//    buildProjectileEntry(EntityDivineArrow.class, "arrow_shot"),
//    buildProjectileEntry(EntityCoriShot.class, "cori_shot"),
//    buildProjectileEntry(EntityTwilightMageShot.class, "twilight_mage_shot"),
//    buildProjectileEntry(EntitySoulFiendShot.class, "soul_fiend_shot"),
//    buildProjectileEntry(EntityDisk.class, "disk"),
//    buildProjectileEntry(EntityGrenade.class, "grenade"),
//    buildProjectileEntry(EntityAttractor.class, "attractor"),
//    buildProjectileEntry(EntityGeneralsStaff.class, "generals_staff"),
//    buildProjectileEntry(EntityMeteor.class, "meteor"),
//    buildProjectileEntry(EntityStar.class, "star"),
//    buildProjectileEntry(EntityFirefly.class, "firefly"),
//    buildProjectileEntry(EntityReflector.class, "reflector"),
//    buildProjectileEntry(EntityFyracryxFireball.class, "fyracryx_fireball"),
//    buildProjectileEntry(EntityTwilightDemonShot.class, "twilight_demon_shot"),
//    buildProjectileEntry(EntityMerikMissile.class, "meriks_missile"),
//    buildProjectileEntry(EntityBouncingProjectile.class, "bouncing_projectile"),
//    buildProjectileEntry(EntityMandragoraProjectile.class, "mandragora_projectile"),
//    buildProjectileEntry(EntityKazroticShot.class, "kazrotic_shot"),
//    buildProjectileEntry(EntityZoragonBomb.class, "zoragon_bomb"),
//    buildProjectileEntry(EntityDissimentShot.class, "dissiment_shot"),
//    buildProjectileEntry(EntityLadyLunaSparkler.class, "lady_luna_sparkler"),
//    buildProjectileEntry(EntityRaglokBomb.class, "raglok_bomb"),
//    buildProjectileEntry(EntityWreckBouncingProjectile.class, "wreck_bouncing_projectile"),
//    buildProjectileEntry(EntityWreckExplosiveShot.class, "wreck_explosive_shot"),
//    buildProjectileEntry(EntityWreckShot.class, "wreck_shot"),
//    buildProjectileEntry(EntityWildwoodLog.class, "wildwood_log")

    // Boss
//    buildEntityEntry(EntityAncientEntity.class, "ancient_entity", BOSS),
//    buildEntityEntry(EntityAyeracoBlue.class, "ayeraco_blue", BOSS),
//    buildEntityEntry(EntityAyeracoGreen.class, "ayeraco_green", BOSS),
//    buildEntityEntry(EntityAyeracoPurple.class, "ayeraco_purple", BOSS),
//    buildEntityEntry(EntityAyeracoRed.class, "ayeraco_red", BOSS),
//    buildEntityEntry(EntityAyeracoYellow.class, "ayeraco_yellow", BOSS),
//    buildEntityEntry(EntityDensos.class, "densos", BOSS),
//    buildEntityEntry(EntityDramix.class, "dramix", BOSS),
//    buildEntityEntry(EntityEternalArcher.class, "eternal_archer", BOSS),
//    buildEntityEntry(EntityExperiencedCori.class, "experienced_cori", BOSS),
//    buildEntityEntry(EntityHiveQueen.class, "hive_queen", BOSS),
//    buildEntityEntry(EntityKarot.class, "karot", BOSS),
//    buildEntityEntry(EntityKaros.class, "karos", BOSS),
//    buildEntityEntry(EntityKingOfScorchers.class, "king_of_scorchers", BOSS),
//    buildEntityEntry(EntityLadyLuna.class, "lady_luna", BOSS),
//    buildEntityEntry(EntityParasecta.class, "parasecta", BOSS),
//    buildEntityEntry(EntityQuadro.class, "quadro", BOSS),
//    buildEntityEntry(EntityRaglok.class, "raglok", BOSS),
//    buildEntityEntry(EntityReyvor.class, "reyvor", BOSS),
//    buildEntityEntry(EntitySoulFiend.class, "soul_fiend", BOSS),
//    buildEntityEntry(EntitySunstorm.class, "sunstorm", BOSS),
//    buildEntityEntry(EntityTermasect.class, "termasect", BOSS),
    public static final EntityType THE_WATCHER = registerEntity(EntityTheWatcher::new, "the_watcher",4F, 4F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.BOSS), EntityClassification.MONSTER);
//    buildEntityEntry(EntityTwilightDemon.class, "twilight_demon", BOSS),
//    buildEntityEntry(EntityVamacheron.class, "vamacheron", BOSS),
//    buildEntityEntry(EntityWreck.class, "wreck", BOSS)

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
    public static final EntityType JACK_O_MAN = registerEntity(EntityJackOMan::new, "jack_o_man", 0.8F, 2F, EntityClassification.MISC);
    public static final EntityType JUNGLE_BAT = registerEntity(EntityJungleBat::new, "jungle_bat", 0.7F, 1F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType JUNGLE_DRAMCRYX = registerEntity(EntityJungleDramcryx::new, "jungle_dramcryx", 1F, 1.3F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType JUNGLE_SPIDER = registerEntity(EntityJungleSpider::new, "jungle_spider", 1.4F, 0.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType KING_CRAB = registerEntity(EntityKingCrab::new, "king_crab", 1.8F, 1.7F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType KOBBLIN = registerEntity(EntityKobblin::new, "kobblin", 0.75F, 1F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType LIOPLEURODON = registerEntity(EntityLiopleurodon::new, "liopleurodon", 4F, 1f, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType LIVESTOCK_MERCHANT = registerEntity(EntityLivestockMerchant::new, "livestock_merchant", 0.8F, 2f, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType MINER = registerEntity(EntityMiner::new, "miner", 0.6F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType PUMPKIN_SPIDER = registerEntity(EntityPumpkinSpider::new, "pumpkin_spider", 1.25F, 1F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType RAINBOUR = registerEntity(EntityRainbour::new, "rainbour", 1F, 1F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
    public static final EntityType ROTATICK = registerEntity(EntityRotatick::new, "rotatick", 0.85F, 0.8F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.OVERWORLD), EntityClassification.MONSTER);
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

    // Iceika
    public static final EntityType ALICANTO = registerEntity(EntityAlicanto::new, "alicanto",1.2F, 1.6F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ICEIKA), EntityClassification.MONSTER);
    public static final EntityType FRACTITE = registerEntity(EntityFractite::new, "fractite",1.7F, 1.3F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ICEIKA), EntityClassification.MONSTER);
    public static final EntityType FROST_ARCHER = registerEntity(EntityFrostArcher::new, "frost_archer",0.6F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ICEIKA), EntityClassification.MONSTER);
    public static final EntityType FROSTY = registerEntity(EntityFrosty::new, "frosty",0.9F, 2.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ICEIKA), EntityClassification.MONSTER);
    public static final EntityType GLACIDE = registerEntity(EntityGlacide::new, "glacide",0.9F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ICEIKA), EntityClassification.MONSTER);
    public static final EntityType HASTREUS = registerEntity(EntityHastreus::new, "hastreus",1.0F, 1.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ICEIKA), EntityClassification.MONSTER);
    public static final EntityType ROLLUM = registerEntity(EntityRollum::new, "rollum",1.2F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ICEIKA), EntityClassification.MONSTER);
    public static final EntityType WORKSHOP_MERCHANT = registerEntity(EntityWorkshopMerchant::new, "workshop_merchant",1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ICEIKA), EntityClassification.MISC);
    public static final EntityType WORKSHOP_TINKERER = registerEntity(EntityWorkshopTinkerer::new, "workshop_tinkerer",1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ICEIKA), EntityClassification.MISC);

    // Eden
    public static final EntityType BUNNY = registerEntity(EntityBunny::new, "bunny",0.5F, 0.7F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.EDEN), EntityClassification.MISC);
    public static final EntityType EDEN_CADILLION = registerEntity(EntityEdenCadillion::new, "eden_cadillion", 1.0F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.EDEN), EntityClassification.MONSTER);
    public static final EntityType EDEN_TOMO = registerEntity(EntityEdenTomo::new, "eden_tomo", 1.0F, 1.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.EDEN), EntityClassification.MONSTER);
    public static final EntityType GREENFEET = registerEntity(EntityGreenfeet::new, "greenfeet", 1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.EDEN), EntityClassification.MONSTER);
    public static final EntityType MADIVEL = registerEntity(EntityMadivel::new, "madivel", 0.6F, 2.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.EDEN), EntityClassification.MONSTER);
    public static final EntityType SUN_ARCHER = registerEntity(EntitySunArcher::new, "sun_archer", 0.8F, 2.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.EDEN), EntityClassification.MONSTER);
    public static final EntityType WEAK_CORI = registerEntity(EntityWeakCori::new, "weak_cori", 0.6F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.EDEN), EntityClassification.MONSTER);

    // Wildwood
    public static final EntityType BEHEMOTH = registerEntity(EntityBehemoth::new, "behemoth", 1.0F, 1.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.WILDWOOD), EntityClassification.MONSTER);
    public static final EntityType EPIPHITE = registerEntity(EntityEpiphite::new, "epiphite", 0.9F, 1.3F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.WILDWOOD), EntityClassification.MONSTER);
    public static final EntityType MAGE = registerEntity(EntityMage::new, "mage", 0.5F, 2.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.WILDWOOD), EntityClassification.MONSTER);
    public static final EntityType MOON_WOLF = registerEntity(EntityMoonWolf::new, "moon_wolf", 0.6F, 0.85F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.WILDWOOD), EntityClassification.MISC);
    public static final EntityType TERMID = registerEntity(EntityTermid::new, "termid", 0.4F, 1.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.WILDWOOD), EntityClassification.MONSTER);
    public static final EntityType VEREK = registerEntity(EntityVerek::new, "verek", 0.8F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.WILDWOOD), EntityClassification.MONSTER);
    public static final EntityType WILDWOOD_CADILLION = registerEntity(EntityWildwoodCadillion::new, "wildwood_cadillion", 1.0F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.WILDWOOD), EntityClassification.MONSTER);
    public static final EntityType WILDWOOD_GOLEM = registerEntity(EntityWildwoodGolem::new, "wildwood_golem", 1.3F, 2.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.WILDWOOD), EntityClassification.MONSTER);
    public static final EntityType WILDWOOD_TOMO = registerEntity(EntityWildwoodTomo::new, "wildwood_tomo", 1.0F, 1.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.WILDWOOD), EntityClassification.MONSTER);

    // Apalachia
    public static final EntityType APALACHIA_CADILLION = registerEntity(EntityApalachiaCadillion::new, "apalachia_cadillion", 1.0F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.APALACHIA), EntityClassification.MONSTER);
    public static final EntityType APALACHIA_GOLEM = registerEntity(EntityApalachiaGolem::new, "apalachia_golem", 1.3F, 2.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.APALACHIA), EntityClassification.MONSTER);
    public static final EntityType APALACHIA_TOMO = registerEntity(EntityApalachiaTomo::new, "apalachia_tomo", 1.0F, 1.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.APALACHIA), EntityClassification.MONSTER);
    public static final EntityType ENCHANTED_ARCHER = registerEntity(EntityEnchantedArcher::new, "enchanted_archer", 1.8F, 3.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.APALACHIA), EntityClassification.MONSTER);
    public static final EntityType ENCHANTED_WARRIOR = registerEntity(EntityEnchantedWarrior::new, "enchanted_warrior", 0.6F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.APALACHIA), EntityClassification.MONSTER);
    public static final EntityType SPELLBINDER = registerEntity(EntitySpellbinder::new, "spellbinder", 1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.APALACHIA), EntityClassification.MONSTER);

    // Skythern
    public static final EntityType ADVANCED_CORI = registerEntity(EntityAdvancedCori::new, "advanced_cori", 0.6F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.SKYTHERN), EntityClassification.MONSTER);
    public static final EntityType MEGALITH = registerEntity(EntityMegalith::new, "megalith", 1.2F, 4.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.SKYTHERN), EntityClassification.MONSTER);
    public static final EntityType MYSTIC = registerEntity(EntityMystic::new, "mystic", 1.0F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.SKYTHERN), EntityClassification.MONSTER);
    public static final EntityType SAMEK = registerEntity(EntitySamek::new, "samek", 0.8F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.SKYTHERN), EntityClassification.MONSTER);
    public static final EntityType SKYTHERN_ARCHER = registerEntity(EntitySkythernArcher::new, "skythern_archer", 1.8F, 3.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.SKYTHERN), EntityClassification.MONSTER);
    public static final EntityType SKYTHERN_FIEND = registerEntity(EntitySkythernFiend::new, "skythern_fiend", 0.6F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.SKYTHERN), EntityClassification.MONSTER);
    public static final EntityType SKYTHERN_GOLEM = registerEntity(EntitySkythernGolem::new, "skythern_golem", 1.3F, 2.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.SKYTHERN), EntityClassification.MONSTER);

    // Mortum
    public static final EntityType ANGRY_BUNNY = registerEntity(EntityAngryBunny::new, "angry_bunny", 1.1F, 1.8F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.MORTUM), EntityClassification.MONSTER);
    public static final EntityType BASILISK = registerEntity(EntityBasilisk::new, "basilisk", 0.7F, 0.8F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.MORTUM), EntityClassification.MONSTER);
    public static final EntityType DEMON_OF_DARKNESS = registerEntity(EntityDemonOfDarkness::new, "demon_of_darkness", 0.8F, 1.6F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.MORTUM), EntityClassification.MONSTER);
    public static final EntityType MORTUM_CADILLION = registerEntity(EntityMortumCadillion::new, "mortum_cadillion", 1.0F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.MORTUM), EntityClassification.MONSTER);
    public static final EntityType SORCERER = registerEntity(EntitySorcerer::new, "sorcerer", 0.6F, 1.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.MORTUM), EntityClassification.MONSTER);
    public static final EntityType SOUL_SPIDER = registerEntity(EntitySoulSpider::new, "soul_spider", 0.3F, 0.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.MORTUM), EntityClassification.MONSTER);
    public static final EntityType SOUL_STEALER = registerEntity(EntitySoulStealer::new, "soul_stealer", 0.8F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.MORTUM), EntityClassification.MONSTER);
    public static final EntityType TWILIGHT_ARCHER = registerEntity(EntityTwilightArcher::new, "twilight_archer", 1.8F, 3.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.MORTUM), EntityClassification.MONSTER);

    // Arcana
    public static final EntityType CAPTAIN_MERIK = registerEntity(EntityCaptainMerik::new, "captain_merik", 0.8F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType DATTICON = registerEntity(EntityDatticon::new, "datticon", 0.8F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType DEATHCRYX = registerEntity(EntityDeathcryx::new, "deathcryx", 1.0F, 1.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MONSTER);
    public static final EntityType DEATH_HOUND = registerEntity(EntityDeathHound::new, "death_hound", 0.8F, 0.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MONSTER);
    public static final EntityType DUNGEON_CONSTRUCTOR = registerEntity(EntityDungeonConstructor::new, "dungeon_constructor", 0.5F, 1.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MONSTER);
    public static final EntityType DUNGEON_DEMON = registerEntity(EntityDungeonDemon::new, "dungeon_demon", 0.6F, 2.15F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MONSTER);
    public static final EntityType DUNGEON_PRISONER = registerEntity(EntityDungeonPrisoner::new, "dungeon_prisoner", 0.6F, 2.15F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MONSTER);
    public static final EntityType FYRACRYX = registerEntity(EntityFyracryx::new, "fyracryx", 1.0F, 1.2F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType GOLEM_OF_REJUVENATION = registerEntity(EntityGolemOfRejuvenation::new, "golem_of_rejuvenation", 1F, 2.35F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType KAZARI = registerEntity(EntityKazari::new, "kazari", 0.8F, 1.8F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType LEORNA = registerEntity(EntityLeorna::new, "leorna", 0.8F, 1.8F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType LIVING_STATUE = registerEntity(EntityLivingStatue::new, "living_statue", 0.8F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MONSTER);
    public static final EntityType LORD_VATTICUS = registerEntity(EntityLordVatticus::new, "lord_vatticus", 0.8F, 1.8F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType PARATIKU = registerEntity(EntityParatiku::new, "paratiku", 0.5F, 0.9F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType RAZORBACK = registerEntity(EntityRazorback::new, "razorback", 0.6F, 0.5F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MONSTER);
    public static final EntityType ROAMER = registerEntity(EntityRoamer::new, "roamer", 0.6F, 1.8F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MONSTER);
    public static final EntityType SEIMER = registerEntity(EntitySeimer::new, "seimer", 1.0F, 1.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType WAR_GENERAL = registerEntity(EntityWarGeneral::new, "war_general", 0.8F, 2.0F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType WRAITH = registerEntity(EntityWraith::new, "wraith", 0.9F, 1.4F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
    public static final EntityType ZELUS = registerEntity(EntityZelus::new, "zelus", 0.8F, 1.8F, SpawnEggColors.getColorsForDimension(SpawnEggColors.Dimension.ARCANA), EntityClassification.MISC);
//
//    // Vethea //TODO - Add Vethean mobs
//    buildEntityEntry(EntityAcidHag.class, "acid_hag", VETHEA),
//    buildEntityEntry(EntityBiphron.class, "biphron", VETHEA),
//    buildEntityEntry(EntityBohemite.class, "bohemite", VETHEA),
//    buildEntityEntry(EntityCryptKeeper.class, "crypt_keeper", VETHEA),
//    buildEntityEntry(EntityCymesoid.class, "cymesoid", VETHEA),
//    buildEntityEntry(EntityDissiment.class, "dissiment", VETHEA),
//    buildEntityEntry(EntityDreamwrecker.class, "dreamwrecker", VETHEA),
//    buildEntityEntry(EntityDuo.class, "duo", VETHEA),
//    buildEntityEntry(EntityEnt.class, "ent", VETHEA),
//    buildEntityEntry(EntityFakeVhraak.class, "fake_vhraak", VETHEA),
//    buildEntityEntry(EntityGalroid.class, "galroid", VETHEA),
//    buildEntityEntry(EntityGorgosion.class, "gorgosion", VETHEA),
//    buildEntityEntry(EntityHelio.class, "helio", VETHEA),
//    buildEntityEntry(EntityHiveSoldier.class, "hive_soldier", VETHEA),
//    buildEntityEntry(EntityHoverStinger.class, "hover_stinger", VETHEA),
//    buildEntityEntry(EntityKazrotic.class, "kazrotic", VETHEA),
//    buildEntityEntry(EntityLheiva.class, "lheiva", VETHEA),
//    buildEntityEntry(EntityLorga.class, "lorga", VETHEA),
//    buildEntityEntry(EntityLorgaflight.class, "lorga_flight", VETHEA),
//    buildEntityEntry(EntityMandragora.class, "mandragora", VETHEA),
//    buildEntityEntry(EntityMysteriousManLayer1.class, "mysterious_man_layer_1", VETHEA),
//    buildEntityEntry(EntityMysteriousManLayer2.class, "mysterious_man_layer_2", VETHEA),
//    buildEntityEntry(EntityMysteriousManLayer3.class, "mysterious_man_layer_3", VETHEA),
//    buildEntityEntry(EntityShadahier.class, "shadahier", VETHEA),
//    buildEntityEntry(EntityTheHunger.class, "the_hunger", VETHEA),
//    buildEntityEntry(EntityTempleGuardian.class, "temple_guardian", VETHEA),
//    buildEntityEntry(EntityTocaxin.class, "tocaxin", VETHEA),
//    buildEntityEntry(EntityTwins.class, "twins", VETHEA),
//    buildEntityEntry(EntityVermenous.class, "vermenous", VETHEA),
//    buildEntityEntry(EntityVhraak.class, "vhraak", VETHEA),
//    buildEntityEntry(EntityZone.class, "zone", VETHEA),
//    buildEntityEntry(EntityZoragon.class, "zoragon", VETHEA),

    public static void init() {
        // Vanilla
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
        GlobalEntityTypeAttributes.put(JACK_O_MAN, EntityJackOMan.attributes().create());
        GlobalEntityTypeAttributes.put(JUNGLE_DRAMCRYX, EntityJungleDramcryx.attributes().create());
        GlobalEntityTypeAttributes.put(JUNGLE_SPIDER, EntityJungleSpider.attributes().create());
        GlobalEntityTypeAttributes.put(KING_CRAB, EntityKingCrab.attributes().create());
        GlobalEntityTypeAttributes.put(KOBBLIN, EntityKobblin.attributes().create());
        GlobalEntityTypeAttributes.put(LIOPLEURODON, EntityLiopleurodon.attributes().create());
        GlobalEntityTypeAttributes.put(LIVESTOCK_MERCHANT, EntityLivestockMerchant.attributes().create());
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

        //Nether
        GlobalEntityTypeAttributes.put(HELL_BAT, EntityHellBat.attributes().create());
        GlobalEntityTypeAttributes.put(HELL_PIG, EntityHellPig.attributes().create());
        GlobalEntityTypeAttributes.put(HELL_SPIDER, EntityHellSpider.attributes().create());
        GlobalEntityTypeAttributes.put(SCORCHER, EntityScorcher.attributes().create());
        GlobalEntityTypeAttributes.put(WILDFIRE, EntityWildfire.attributes().create());

        //End
        GlobalEntityTypeAttributes.put(ENDER_SPIDER, EntityEnderSpider.attributes().create());
        GlobalEntityTypeAttributes.put(ENDER_TRIPLETS, EntityEnderTriplets.attributes().create());
        GlobalEntityTypeAttributes.put(ENDER_WATCHER, EntityEnderWatcher.attributes().create());

        //Boss
        GlobalEntityTypeAttributes.put(THE_WATCHER, EntityTheWatcher.attributes().create());

        //Iceika
        GlobalEntityTypeAttributes.put(ALICANTO, EntityAlicanto.attributes().create());
        GlobalEntityTypeAttributes.put(FRACTITE, EntityFractite.attributes().create());
        GlobalEntityTypeAttributes.put(FROST_ARCHER, EntityFrostArcher.attributes().create());
        GlobalEntityTypeAttributes.put(FROSTY, EntityFrosty.attributes().create());
        GlobalEntityTypeAttributes.put(GLACIDE, EntityGlacide.attributes().create());
        GlobalEntityTypeAttributes.put(HASTREUS, EntityHastreus.attributes().create());
        GlobalEntityTypeAttributes.put(ROLLUM, EntityRollum.attributes().create());
        GlobalEntityTypeAttributes.put(WORKSHOP_MERCHANT, EntityWorkshopMerchant.attributes().create());
        GlobalEntityTypeAttributes.put(WORKSHOP_TINKERER, EntityWorkshopTinkerer.attributes().create());

        //Eden
        GlobalEntityTypeAttributes.put(BUNNY, EntityBunny.attributes().create());
        GlobalEntityTypeAttributes.put(EDEN_CADILLION, EntityEdenCadillion.attributes().create());
        GlobalEntityTypeAttributes.put(EDEN_TOMO, EntityEdenTomo.attributes().create());
        GlobalEntityTypeAttributes.put(GREENFEET, EntityGreenfeet.attributes().create());
        GlobalEntityTypeAttributes.put(MADIVEL, EntityMadivel.attributes().create());
        GlobalEntityTypeAttributes.put(SUN_ARCHER, EntitySunArcher.attributes().create());
        GlobalEntityTypeAttributes.put(WEAK_CORI, EntityWeakCori.attributes().create());

        //Wildwood
        GlobalEntityTypeAttributes.put(BEHEMOTH, EntityBehemoth.attributes().create());
        GlobalEntityTypeAttributes.put(EPIPHITE, EntityEpiphite.attributes().create());
        GlobalEntityTypeAttributes.put(MAGE, EntityMage.attributes().create());
        GlobalEntityTypeAttributes.put(MOON_WOLF, EntityMoonWolf.attributes().create());
        GlobalEntityTypeAttributes.put(TERMID, EntityTermid.attributes().create());
        GlobalEntityTypeAttributes.put(VEREK, EntityVerek.attributes().create());
        GlobalEntityTypeAttributes.put(WILDWOOD_CADILLION, EntityWildwoodCadillion.attributes().create());
        GlobalEntityTypeAttributes.put(WILDWOOD_GOLEM, EntityWildwoodGolem.attributes().create());
        GlobalEntityTypeAttributes.put(WILDWOOD_TOMO, EntityWildwoodTomo.attributes().create());

        //Apalachia
        GlobalEntityTypeAttributes.put(APALACHIA_CADILLION, EntityApalachiaCadillion.attributes().create());
        GlobalEntityTypeAttributes.put(APALACHIA_GOLEM, EntityApalachiaGolem.attributes().create());
        GlobalEntityTypeAttributes.put(APALACHIA_TOMO, EntityApalachiaTomo.attributes().create());
        GlobalEntityTypeAttributes.put(ENCHANTED_ARCHER, EntityEnchantedArcher.attributes().create());
        GlobalEntityTypeAttributes.put(ENCHANTED_WARRIOR, EntityEnchantedWarrior.attributes().create());
        GlobalEntityTypeAttributes.put(SPELLBINDER, EntitySpellbinder.attributes().create());

        //Skythern
        GlobalEntityTypeAttributes.put(ADVANCED_CORI, EntityAdvancedCori.attributes().create());
        GlobalEntityTypeAttributes.put(MEGALITH, EntityMegalith.attributes().create());
        GlobalEntityTypeAttributes.put(MYSTIC, EntityMystic.attributes().create());
        GlobalEntityTypeAttributes.put(SAMEK, EntitySamek.attributes().create());
        GlobalEntityTypeAttributes.put(SKYTHERN_ARCHER, EntitySkythernArcher.attributes().create());
        GlobalEntityTypeAttributes.put(SKYTHERN_FIEND, EntitySkythernFiend.attributes().create());
        GlobalEntityTypeAttributes.put(SKYTHERN_GOLEM, EntitySkythernGolem.attributes().create());

        //Mortum
        GlobalEntityTypeAttributes.put(ANGRY_BUNNY, EntityAngryBunny.attributes().create());
        GlobalEntityTypeAttributes.put(BASILISK, EntityBasilisk.attributes().create());
        GlobalEntityTypeAttributes.put(DEMON_OF_DARKNESS, EntityDemonOfDarkness.attributes().create());
        GlobalEntityTypeAttributes.put(MORTUM_CADILLION, EntityMortumCadillion.attributes().create());
        GlobalEntityTypeAttributes.put(SORCERER, EntitySorcerer.attributes().create());
        GlobalEntityTypeAttributes.put(SOUL_SPIDER, EntitySoulSpider.attributes().create());
        GlobalEntityTypeAttributes.put(SOUL_STEALER, EntitySoulStealer.attributes().create());
        GlobalEntityTypeAttributes.put(TWILIGHT_ARCHER, EntityTwilightArcher.attributes().create());
        
        //Arcana
        GlobalEntityTypeAttributes.put(CAPTAIN_MERIK, EntityCaptainMerik.attributes().create());
        GlobalEntityTypeAttributes.put(DATTICON, EntityDatticon.attributes().create());
        GlobalEntityTypeAttributes.put(DEATHCRYX, EntityDeathcryx.attributes().create());
        GlobalEntityTypeAttributes.put(DEATH_HOUND, EntityDeathHound.attributes().create());
        GlobalEntityTypeAttributes.put(DUNGEON_CONSTRUCTOR, EntityDungeonConstructor.attributes().create());
        GlobalEntityTypeAttributes.put(DUNGEON_DEMON, EntityDungeonDemon.attributes().create());
        GlobalEntityTypeAttributes.put(DUNGEON_PRISONER, EntityDungeonPrisoner.attributes().create());
        GlobalEntityTypeAttributes.put(FYRACRYX, EntityFyracryx.attributes().create());
        GlobalEntityTypeAttributes.put(GOLEM_OF_REJUVENATION, EntityGolemOfRejuvenation.attributes().create());
        GlobalEntityTypeAttributes.put(KAZARI, EntityKazari.attributes().create());
        GlobalEntityTypeAttributes.put(LEORNA, EntityLeorna.attributes().create());
        GlobalEntityTypeAttributes.put(LORD_VATTICUS, EntityLordVatticus.attributes().create());
        GlobalEntityTypeAttributes.put(LIVING_STATUE, EntityLivingStatue.attributes().create());
        GlobalEntityTypeAttributes.put(PARATIKU, EntityParatiku.attributes().create());
        GlobalEntityTypeAttributes.put(RAZORBACK, EntityRazorback.attributes().create());
        GlobalEntityTypeAttributes.put(ROAMER, EntityRoamer.attributes().create());
        GlobalEntityTypeAttributes.put(SEIMER, EntitySeimer.attributes().create());
        GlobalEntityTypeAttributes.put(WAR_GENERAL, EntityWarGeneral.attributes().create());
        GlobalEntityTypeAttributes.put(WRAITH, EntityWraith.attributes().create());
        GlobalEntityTypeAttributes.put(ZELUS, EntityZelus.attributes().create());

        //PLACEMENT
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
        EntitySpawnPlacementRegistry.register(JACK_O_MAN, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityJackOMan::canSpawnOn);
        EntitySpawnPlacementRegistry.register(JUNGLE_BAT, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityJungleBat::canSpawnOn);
        EntitySpawnPlacementRegistry.register(JUNGLE_DRAMCRYX, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityJungleDramcryx::canSpawnOn);
        EntitySpawnPlacementRegistry.register(JUNGLE_SPIDER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityJungleSpider::canSpawnOn);
        EntitySpawnPlacementRegistry.register(KING_CRAB, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityKingCrab::canSpawnOn);
        EntitySpawnPlacementRegistry.register(KOBBLIN, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityKobblin::canSpawnOn);
        EntitySpawnPlacementRegistry.register(LIOPLEURODON, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityLiopleurodon::canSpawnOn);
        EntitySpawnPlacementRegistry.register(LIVESTOCK_MERCHANT, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityLivestockMerchant::canSpawnOn);
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

        //Iceika
        EntitySpawnPlacementRegistry.register(ALICANTO, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityAlicanto::canSpawnOn);
        EntitySpawnPlacementRegistry.register(FRACTITE, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityFractite::canSpawnOn);
        EntitySpawnPlacementRegistry.register(FROST_ARCHER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityFrostArcher::canSpawnOn);
        EntitySpawnPlacementRegistry.register(FROSTY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityFrosty::canSpawnOn);
        EntitySpawnPlacementRegistry.register(GLACIDE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityGlacide::canSpawnOn);
        EntitySpawnPlacementRegistry.register(HASTREUS, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityHastreus::canSpawnOn);
        EntitySpawnPlacementRegistry.register(ROLLUM, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityRollum::canSpawnOn);
        EntitySpawnPlacementRegistry.register(WORKSHOP_MERCHANT, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityWorkshopMerchant::canSpawnOn);
        EntitySpawnPlacementRegistry.register(WORKSHOP_TINKERER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityWorkshopTinkerer::canSpawnOn);

        //Eden
        EntitySpawnPlacementRegistry.register(BUNNY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityBunny::canSpawnOn);
        EntitySpawnPlacementRegistry.register(EDEN_CADILLION, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityEdenCadillion::canSpawnOn);
        EntitySpawnPlacementRegistry.register(EDEN_TOMO, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityEdenTomo::canSpawnOn);
        EntitySpawnPlacementRegistry.register(GREENFEET, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityGreenfeet::canSpawnOn);
        EntitySpawnPlacementRegistry.register(MADIVEL, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityMadivel::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SUN_ARCHER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySunArcher::canSpawnOn);
        EntitySpawnPlacementRegistry.register(WEAK_CORI, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityWeakCori::canSpawnOn);

        //Wildwood
        EntitySpawnPlacementRegistry.register(BEHEMOTH, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityBehemoth::canSpawnOn);
        EntitySpawnPlacementRegistry.register(EPIPHITE, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityEpiphite::canSpawnOn);
        EntitySpawnPlacementRegistry.register(MAGE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityMage::canSpawnOn);
        EntitySpawnPlacementRegistry.register(MOON_WOLF, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityMoonWolf::canSpawnOn);
        EntitySpawnPlacementRegistry.register(TERMID, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityTermid::canSpawnOn);
        EntitySpawnPlacementRegistry.register(VEREK, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityVerek::canSpawnOn);
        EntitySpawnPlacementRegistry.register(WILDWOOD_CADILLION, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityWildwoodCadillion::canSpawnOn);
        EntitySpawnPlacementRegistry.register(WILDWOOD_GOLEM, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityWildwoodGolem::canSpawnOn);
        EntitySpawnPlacementRegistry.register(WILDWOOD_TOMO, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityWildwoodTomo::canSpawnOn);

        //Apalachia
        EntitySpawnPlacementRegistry.register(APALACHIA_CADILLION, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityApalachiaCadillion::canSpawnOn);
        EntitySpawnPlacementRegistry.register(APALACHIA_GOLEM, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityApalachiaGolem::canSpawnOn);
        EntitySpawnPlacementRegistry.register(APALACHIA_TOMO, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityApalachiaTomo::canSpawnOn);
        EntitySpawnPlacementRegistry.register(ENCHANTED_ARCHER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityEnchantedArcher::canSpawnOn);
        EntitySpawnPlacementRegistry.register(ENCHANTED_WARRIOR, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityEnchantedWarrior::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SPELLBINDER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySpellbinder::canSpawnOn);

        //Skythern
        EntitySpawnPlacementRegistry.register(ADVANCED_CORI, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityAdvancedCori::canSpawnOn);
        EntitySpawnPlacementRegistry.register(MEGALITH, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityMegalith::canSpawnOn);
        EntitySpawnPlacementRegistry.register(MYSTIC, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityMystic::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SAMEK, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySamek::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SKYTHERN_ARCHER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySkythernArcher::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SKYTHERN_FIEND, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySkythernFiend::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SKYTHERN_GOLEM, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySkythernGolem::canSpawnOn);

        //Mortum
        EntitySpawnPlacementRegistry.register(ANGRY_BUNNY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityAngryBunny::canSpawnOn);
        EntitySpawnPlacementRegistry.register(BASILISK, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityBasilisk::canSpawnOn);
        EntitySpawnPlacementRegistry.register(DEMON_OF_DARKNESS, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityDemonOfDarkness::canSpawnOn);
        EntitySpawnPlacementRegistry.register(MORTUM_CADILLION, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityMortumCadillion::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SORCERER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySorcerer::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SOUL_SPIDER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySoulSpider::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SOUL_STEALER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySoulStealer::canSpawnOn);
        EntitySpawnPlacementRegistry.register(TWILIGHT_ARCHER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityTwilightArcher::canSpawnOn);

        //Arcana
        EntitySpawnPlacementRegistry.register(CAPTAIN_MERIK, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityCaptainMerik::canSpawnOn);
        EntitySpawnPlacementRegistry.register(DATTICON, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityDatticon::canSpawnOn);
        EntitySpawnPlacementRegistry.register(DEATHCRYX, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityDeathcryx::canSpawnOn);
        EntitySpawnPlacementRegistry.register(DEATH_HOUND, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityDeathHound::canSpawnOn);
        EntitySpawnPlacementRegistry.register(DUNGEON_CONSTRUCTOR, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityCaptainMerik::canSpawnOn);
        EntitySpawnPlacementRegistry.register(DUNGEON_DEMON, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityDungeonDemon::canSpawnOn);
        EntitySpawnPlacementRegistry.register(DUNGEON_PRISONER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityDungeonPrisoner::canSpawnOn);
        EntitySpawnPlacementRegistry.register(FYRACRYX, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityFyracryx::canSpawnOn);
        EntitySpawnPlacementRegistry.register(GOLEM_OF_REJUVENATION, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityGolemOfRejuvenation::canSpawnOn);
        EntitySpawnPlacementRegistry.register(KAZARI, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityKazari::canSpawnOn);
        EntitySpawnPlacementRegistry.register(LEORNA, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityLeorna::canSpawnOn);
        EntitySpawnPlacementRegistry.register(LORD_VATTICUS, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityLordVatticus::canSpawnOn);
        EntitySpawnPlacementRegistry.register(LIVING_STATUE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityLivingStatue::canSpawnOn);
        EntitySpawnPlacementRegistry.register(PARATIKU, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityParatiku::canSpawnOn);
        EntitySpawnPlacementRegistry.register(RAZORBACK, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityRazorback::canSpawnOn);
        EntitySpawnPlacementRegistry.register(ROAMER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityRoamer::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SEIMER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySeimer::canSpawnOn);
        EntitySpawnPlacementRegistry.register(WAR_GENERAL, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityCaptainMerik::canSpawnOn);
        EntitySpawnPlacementRegistry.register(WRAITH, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityWarGeneral::canSpawnOn);
        EntitySpawnPlacementRegistry.register(ZELUS, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityWraith::canSpawnOn);
    }

    public static void render() {
        //Overworld
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
        RenderingRegistry.registerEntityRenderingHandler(KING_CRAB, manager -> new RenderDivineMob(manager, new ModelKingCrab(), 2F, new ResourceLocation(DivineRPG.MODID, "textures/entity/king_crab.png")));
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

        //Nether
        RenderingRegistry.registerEntityRenderingHandler(HELL_BAT, manager -> new RenderDivineMob(manager, new ModelHellBat(), new ResourceLocation(DivineRPG.MODID, "textures/entity/hell_bat.png")));
        RenderingRegistry.registerEntityRenderingHandler(HELL_PIG, RenderHellPig::new);
        RenderingRegistry.registerEntityRenderingHandler(HELL_SPIDER, manager -> new RenderDivineMob(manager, new ModelHellSpider(), new ResourceLocation(DivineRPG.MODID, "textures/entity/hell_spider.png")));
        RenderingRegistry.registerEntityRenderingHandler(SCORCHER, manager -> new RenderDivineMob(manager, new ModelScorcher(), new ResourceLocation(DivineRPG.MODID, "textures/entity/scorcher.png")));
        RenderingRegistry.registerEntityRenderingHandler(WILDFIRE, RenderWildfire::new);

        //End
        RenderingRegistry.registerEntityRenderingHandler(ENDER_SPIDER, manager -> new RenderDivineMob(manager, new ModelEnderSpider(), 0.5F, new ResourceLocation(DivineRPG.MODID, "textures/entity/ender_spider.png")));
        RenderingRegistry.registerEntityRenderingHandler(ENDER_TRIPLETS, manager -> new RenderDivineMob(manager, new ModelEnderTriplets(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ender_triplets.png")));
        RenderingRegistry.registerEntityRenderingHandler(ENDER_WATCHER, manager -> new RenderDivineMob(manager, new ModelEnderWatcher(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ender_watcher.png")));

        //Boss
        RenderingRegistry.registerEntityRenderingHandler(THE_WATCHER, manager -> new RenderDivineMob(manager, new ModelTheWatcher(), 6F, new ResourceLocation(DivineRPG.MODID, "textures/entity/the_watcher.png")));

        //Iceika
        RenderingRegistry.registerEntityRenderingHandler(ALICANTO, manager -> new RenderDivineMob(manager, new ModelAlicanto(), new ResourceLocation(DivineRPG.MODID, "textures/entity/alicanto.png")));
        RenderingRegistry.registerEntityRenderingHandler(FRACTITE, manager -> new RenderDivineMob(manager, new ModelFractite(), new ResourceLocation(DivineRPG.MODID, "textures/entity/fractite.png")));
        RenderingRegistry.registerEntityRenderingHandler(FROST_ARCHER, RenderFrostArcher::new);
        RenderingRegistry.registerEntityRenderingHandler(FROSTY, manager -> new RenderDivineMob(manager, new ModelFrosty(), new ResourceLocation(DivineRPG.MODID, "textures/entity/frosty.png")));
        RenderingRegistry.registerEntityRenderingHandler(GLACIDE, manager -> new RenderDivineMob(manager, new ModelGlacide(), new ResourceLocation(DivineRPG.MODID, "textures/entity/glacon.png")));
        RenderingRegistry.registerEntityRenderingHandler(HASTREUS, manager -> new RenderDivineMob(manager, new ModelHastreus(), new ResourceLocation(DivineRPG.MODID, "textures/entity/hastreus.png")));
        RenderingRegistry.registerEntityRenderingHandler(ROLLUM, manager -> new RenderDivineMob(manager, new ModelRollum(), new ResourceLocation(DivineRPG.MODID, "textures/entity/rollum.png")));
        RenderingRegistry.registerEntityRenderingHandler(WORKSHOP_MERCHANT, manager -> new RenderDivineMob(manager, new ModelWorkshop(), new ResourceLocation(DivineRPG.MODID, "textures/entity/workshop_merchant.png")));
        RenderingRegistry.registerEntityRenderingHandler(WORKSHOP_TINKERER, manager -> new RenderDivineMob(manager, new ModelWorkshop(), new ResourceLocation(DivineRPG.MODID, "textures/entity/workshop_tinkerer.png")));

        //Eden
        RenderingRegistry.registerEntityRenderingHandler(BUNNY, manager -> new RenderDivineMob(manager, new ModelBunny(), new ResourceLocation(DivineRPG.MODID, "textures/entity/bunny.png")));
        RenderingRegistry.registerEntityRenderingHandler(EDEN_CADILLION, manager -> new RenderDivineMob(manager, new ModelCadillion(), new ResourceLocation(DivineRPG.MODID, "textures/entity/eden_cadillion.png")));
        RenderingRegistry.registerEntityRenderingHandler(EDEN_TOMO, manager -> new RenderDivineMob(manager, new ModelTomo(), new ResourceLocation(DivineRPG.MODID, "textures/entity/eden_tomo.png")));
        RenderingRegistry.registerEntityRenderingHandler(GREENFEET, manager -> new RenderDivineMob(manager, new ModelGreenfeet(), new ResourceLocation(DivineRPG.MODID, "textures/entity/greenfeet.png")));
        RenderingRegistry.registerEntityRenderingHandler(MADIVEL, manager -> new RenderDivineMob(manager, new ModelMadivel(), new ResourceLocation(DivineRPG.MODID, "textures/entity/madivel.png")));
        RenderingRegistry.registerEntityRenderingHandler(SUN_ARCHER, RenderSunArcher::new);
        RenderingRegistry.registerEntityRenderingHandler(WEAK_CORI, manager -> new RenderDivineMob(manager, new ModelCori(), new ResourceLocation(DivineRPG.MODID, "textures/entity/weak_cori.png")));

        //Wildwood
        RenderingRegistry.registerEntityRenderingHandler(BEHEMOTH, manager -> new RenderDivineMob(manager, new ModelBehemoth(), new ResourceLocation(DivineRPG.MODID, "textures/entity/behemoth.png")));
        RenderingRegistry.registerEntityRenderingHandler(EPIPHITE, manager -> new RenderDivineMob(manager, new ModelEpiphite(), new ResourceLocation(DivineRPG.MODID, "textures/entity/epiphite.png")));
        RenderingRegistry.registerEntityRenderingHandler(MAGE, manager -> new RenderDivineMob(manager, new ModelMage(), new ResourceLocation(DivineRPG.MODID, "textures/entity/mage.png")));
        RenderingRegistry.registerEntityRenderingHandler(MOON_WOLF, manager -> new RenderDivineMob(manager, new ModelMoonWolf(), new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf.png")));
        RenderingRegistry.registerEntityRenderingHandler(TERMID, manager -> new RenderDivineMob(manager, new ModelTermid(), new ResourceLocation(DivineRPG.MODID, "textures/entity/termid.png")));
        RenderingRegistry.registerEntityRenderingHandler(VEREK, manager -> new RenderDivineMob(manager, new ModelSamek(), new ResourceLocation(DivineRPG.MODID, "textures/entity/verek.png")));
        RenderingRegistry.registerEntityRenderingHandler(WILDWOOD_CADILLION, manager -> new RenderDivineMob(manager, new ModelCadillionTEMP(), new ResourceLocation(DivineRPG.MODID, "textures/entity/wildwood_cadillion.png")));
        RenderingRegistry.registerEntityRenderingHandler(WILDWOOD_GOLEM, manager -> new RenderDivineMob(manager, new ModelTwilightGolem(), new ResourceLocation(DivineRPG.MODID, "textures/entity/wildwood_golem.png")));
        RenderingRegistry.registerEntityRenderingHandler(WILDWOOD_TOMO, manager -> new RenderDivineMob(manager, new ModelTomo(), new ResourceLocation(DivineRPG.MODID, "textures/entity/wildwood_tomo.png")));

        //Apalachia
        RenderingRegistry.registerEntityRenderingHandler(APALACHIA_CADILLION, manager -> new RenderDivineMob(manager, new ModelCadillionTEMP(), new ResourceLocation(DivineRPG.MODID, "textures/entity/apalachia_cadillion.png")));
        RenderingRegistry.registerEntityRenderingHandler(APALACHIA_GOLEM, manager -> new RenderDivineMob(manager, new ModelTwilightGolem(), new ResourceLocation(DivineRPG.MODID, "textures/entity/apalachia_golem.png")));
        RenderingRegistry.registerEntityRenderingHandler(APALACHIA_TOMO, manager -> new RenderDivineMob(manager, new ModelTomo(), new ResourceLocation(DivineRPG.MODID, "textures/entity/apalachia_tomo.png")));
        RenderingRegistry.registerEntityRenderingHandler(ENCHANTED_ARCHER, manager -> new RenderDivineMob(manager, new ModelEnchantedArcher(), new ResourceLocation(DivineRPG.MODID, "textures/entity/enchanted_archer.png"))); //TODO - bow
        RenderingRegistry.registerEntityRenderingHandler(ENCHANTED_WARRIOR, manager -> new RenderDivineMob(manager, new ModelEnchantedWarrior(), new ResourceLocation(DivineRPG.MODID, "textures/entity/enchanted_warrior.png")));
        RenderingRegistry.registerEntityRenderingHandler(SPELLBINDER, manager -> new RenderDivineMob(manager, new ModelMystic(), new ResourceLocation(DivineRPG.MODID, "textures/entity/spellbinder.png")));

        //Skythern
        RenderingRegistry.registerEntityRenderingHandler(ADVANCED_CORI, manager -> new RenderDivineMob(manager, new ModelCori(), new ResourceLocation(DivineRPG.MODID, "textures/entity/advanced_cori.png")));
        RenderingRegistry.registerEntityRenderingHandler(MEGALITH, manager -> new RenderDivineMob(manager, new ModelMegalith(), new ResourceLocation(DivineRPG.MODID, "textures/entity/megalith.png")));
        RenderingRegistry.registerEntityRenderingHandler(MYSTIC, manager -> new RenderDivineMob(manager, new ModelMystic(), new ResourceLocation(DivineRPG.MODID, "textures/entity/mystic.png")));
        RenderingRegistry.registerEntityRenderingHandler(SAMEK, manager -> new RenderDivineMob(manager, new ModelSamek(), new ResourceLocation(DivineRPG.MODID, "textures/entity/samek.png")));
        RenderingRegistry.registerEntityRenderingHandler(SKYTHERN_ARCHER, manager -> new RenderDivineMob(manager, new ModelTwilightArcher(), new ResourceLocation(DivineRPG.MODID, "textures/entity/skythern_archer.png"))); //TODO - bow
        RenderingRegistry.registerEntityRenderingHandler(SKYTHERN_FIEND, manager -> new RenderDivineMob(manager, new ModelSkythernFiend(), new ResourceLocation(DivineRPG.MODID, "textures/entity/skythern_fiend.png")));
        RenderingRegistry.registerEntityRenderingHandler(SKYTHERN_GOLEM, manager -> new RenderDivineMob(manager, new ModelTwilightGolem(), new ResourceLocation(DivineRPG.MODID, "textures/entity/skythern_golem.png")));

        //Mortum
        RenderingRegistry.registerEntityRenderingHandler(ANGRY_BUNNY, manager -> new RenderDivineMob(manager, new ModelAngryBunny(), new ResourceLocation(DivineRPG.MODID, "textures/entity/angry_bunny.png")));
        RenderingRegistry.registerEntityRenderingHandler(BASILISK, manager -> new RenderDivineMob(manager, new ModelBasilisk(), new ResourceLocation(DivineRPG.MODID, "textures/entity/basilisk.png")));
        RenderingRegistry.registerEntityRenderingHandler(DEMON_OF_DARKNESS, manager -> new RenderDivineMob(manager, new ModelDemonOfDarkness(), new ResourceLocation(DivineRPG.MODID, "textures/entity/demon_of_darkness.png")));
        RenderingRegistry.registerEntityRenderingHandler(MORTUM_CADILLION, manager -> new RenderDivineMob(manager, new ModelCadillionTEMP(), new ResourceLocation(DivineRPG.MODID, "textures/entity/mortum_cadillion.png")));
        RenderingRegistry.registerEntityRenderingHandler(SORCERER, manager -> new RenderDivineMob(manager, new ModelSorcerer(), new ResourceLocation(DivineRPG.MODID, "textures/entity/sorcerer.png")));
        RenderingRegistry.registerEntityRenderingHandler(SOUL_SPIDER, manager -> new RenderDivineMob(manager, new ModelSoulSpider(), new ResourceLocation(DivineRPG.MODID, "textures/entity/soul_spider.png")));
        RenderingRegistry.registerEntityRenderingHandler(SOUL_STEALER, manager -> new RenderDivineMob(manager, new ModelSoulStealer(), new ResourceLocation(DivineRPG.MODID, "textures/entity/soul_stealer.png")));
        RenderingRegistry.registerEntityRenderingHandler(TWILIGHT_ARCHER, manager -> new RenderDivineMob(manager, new ModelTwilightArcher(), new ResourceLocation(DivineRPG.MODID, "textures/entity/twilight_archer.png"))); //TODO - bow
        
        //Arcana
        RenderingRegistry.registerEntityRenderingHandler(CAPTAIN_MERIK, manager -> new RenderDivineMob(manager, new ModelSamek(), new ResourceLocation(DivineRPG.MODID, "textures/entity/captain_merik.png")));
        RenderingRegistry.registerEntityRenderingHandler(DATTICON, manager -> new RenderDivineMob(manager, new ModelSamek(), new ResourceLocation(DivineRPG.MODID, "textures/entity/datticon.png")));
        RenderingRegistry.registerEntityRenderingHandler(DEATHCRYX, manager -> new RenderDivineMob(manager, new ModelDeathcryx(), new ResourceLocation(DivineRPG.MODID, "textures/entity/deathcryx.png")));
        RenderingRegistry.registerEntityRenderingHandler(DEATH_HOUND, manager -> new RenderDivineMob(manager, new ModelDeathHound(), new ResourceLocation(DivineRPG.MODID, "textures/entity/death_hound.png")));
        RenderingRegistry.registerEntityRenderingHandler(DUNGEON_CONSTRUCTOR, RenderDungeonConstructor::new);
        RenderingRegistry.registerEntityRenderingHandler(DUNGEON_DEMON, manager -> new RenderDivineMob(manager, new ModelDungeonDemon(), new ResourceLocation(DivineRPG.MODID, "textures/entity/dungeon_demon.png")));
        RenderingRegistry.registerEntityRenderingHandler(DUNGEON_PRISONER, manager -> new RenderDivineMob(manager, new ModelDungeonPrisoner(), new ResourceLocation(DivineRPG.MODID, "textures/entity/dungeon_prisoner.png")));
        RenderingRegistry.registerEntityRenderingHandler(FYRACRYX, manager -> new RenderDivineMob(manager, new ModelDeathcryx(), new ResourceLocation(DivineRPG.MODID, "textures/entity/fyracryx.png")));
        RenderingRegistry.registerEntityRenderingHandler(GOLEM_OF_REJUVENATION, manager -> new RenderDivineMob(manager, new ModelRejuvGolem(), new ResourceLocation(DivineRPG.MODID, "textures/entity/golem_of_rejuvenation.png")));
        RenderingRegistry.registerEntityRenderingHandler(KAZARI, RenderKazari::new);
        RenderingRegistry.registerEntityRenderingHandler(LEORNA, manager -> new RenderDivineMob(manager, new ModelLeorna(), new ResourceLocation(DivineRPG.MODID, "textures/entity/leorna.png")));
        RenderingRegistry.registerEntityRenderingHandler(LORD_VATTICUS, RenderLordVatticus::new);
        RenderingRegistry.registerEntityRenderingHandler(LIVING_STATUE, RenderLivingStatue::new);
        RenderingRegistry.registerEntityRenderingHandler(PARATIKU, manager -> new RenderDivineMob(manager, new ModelParatiku(), new ResourceLocation(DivineRPG.MODID, "textures/entity/paratiku.png")));
        RenderingRegistry.registerEntityRenderingHandler(RAZORBACK, manager -> new RenderDivineMob(manager, new ModelRazorback(), new ResourceLocation(DivineRPG.MODID, "textures/entity/razorback.png")));
        RenderingRegistry.registerEntityRenderingHandler(ROAMER, manager -> new RenderDivineMob(manager, new ModelRoamer(), new ResourceLocation(DivineRPG.MODID, "textures/entity/roamer.png")));
        RenderingRegistry.registerEntityRenderingHandler(SEIMER, manager -> new RenderDivineMob(manager, new ModelSeimer(), new ResourceLocation(DivineRPG.MODID, "textures/entity/seimer.png")));
        RenderingRegistry.registerEntityRenderingHandler(WAR_GENERAL, manager -> new RenderDivineMob(manager, new ModelSamek(), new ResourceLocation(DivineRPG.MODID, "textures/entity/war_general.png")));
        RenderingRegistry.registerEntityRenderingHandler(WRAITH, manager -> new RenderDivineMob(manager, new ModelWraith(), new ResourceLocation(DivineRPG.MODID, "textures/entity/wraith.png")));
        RenderingRegistry.registerEntityRenderingHandler(ZELUS, RenderZelus::new);
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


    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        for (EntityType entity : ENTITIES) {
            Preconditions.checkNotNull(entity.getRegistryName(), "registryName");
            event.getRegistry().register(entity);
            }
    }
    private static <T extends Entity> EntityType<T> registerEntity(EntityType.IFactory<T> factory, String entityName, float width, float height, SpawnEggColors colors, EntityClassification classification) {
        ResourceLocation location = new ResourceLocation(DivineRPG.MODID, entityName);
        boolean cache = SharedConstants.useDatafixers;
        SharedConstants.useDatafixers = false;
        EntityType<T> entity = EntityType.Builder.create(factory, classification).size(width, height).setTrackingRange(64).setUpdateInterval(1).build(location.toString());
        entity.setRegistryName(location);
        SharedConstants.useDatafixers = cache;
        ENTITIES.add(entity);
        Item spawnEgg = new SpawnEggItem(entity, colors.getPrimaryColor(), colors.getSecondaryColor(), (new Item.Properties()).group(DivineRPG.tabs.spawners)).setRegistryName(entityName +"_spawn_egg");
        SPAWN_EGGS.add(spawnEgg);
        return entity;
    }

    private static <T extends Entity> EntityType<T> registerEntity(EntityType.IFactory<T> factory, String entityName, float width, float height, EntityClassification classification) {
        ResourceLocation location = new ResourceLocation(DivineRPG.MODID, entityName);
        boolean cache = SharedConstants.useDatafixers;
        SharedConstants.useDatafixers = false;
        EntityType<T> entity = EntityType.Builder.create(factory, classification).size(width, height).setTrackingRange(64).setUpdateInterval(1).build(location.toString());
        entity.setRegistryName(location);
        SharedConstants.useDatafixers = cache;
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