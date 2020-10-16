package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.config.GeneralConfig;
import divinerpg.objects.entities.entity.EntityFrostCloud;
import divinerpg.objects.entities.entity.apalachia.*;
import divinerpg.objects.entities.entity.arcana.*;
import divinerpg.objects.entities.entity.arcana.EntityDeathHound;
import divinerpg.objects.entities.entity.arcana.EntityDeathcryx;
import divinerpg.objects.entities.entity.boss.*;
import divinerpg.objects.entities.entity.eden.*;
import divinerpg.objects.entities.entity.end.EntityEnderSpider;
import divinerpg.objects.entities.entity.end.EntityEnderTriplets;
import divinerpg.objects.entities.entity.end.EntityEnderWatcher;
import divinerpg.objects.entities.entity.iceika.*;
import divinerpg.objects.entities.entity.mortum.*;
import divinerpg.objects.entities.entity.nether.EntityHellPig;
import divinerpg.objects.entities.entity.nether.EntityHellSpider;
import divinerpg.objects.entities.entity.nether.EntityScorcher;
import divinerpg.objects.entities.entity.nether.EntityWildfire;
import divinerpg.objects.entities.entity.npc.*;
import divinerpg.objects.entities.entity.projectiles.*;
import divinerpg.objects.entities.entity.skythern.*;
import divinerpg.objects.entities.entity.skythern.EntityAdvancedCori;
import divinerpg.objects.entities.entity.boss.EntityExperiencedCori;
import divinerpg.objects.entities.entity.eden.EntityWeakCori;
import divinerpg.objects.entities.entity.wildwood.EntityMage;
import divinerpg.objects.entities.entity.vanilla.*;
import divinerpg.objects.entities.entity.boss.ayeraco.*;
import divinerpg.objects.entities.entity.vethea.*;
import divinerpg.objects.entities.entity.wildwood.*;
import divinerpg.utils.SpawnEggColors;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.registries.IForgeRegistry;

import static divinerpg.utils.SpawnEggColors.Dimension.*;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID)
public class EntityRegistry {
    private static int mobID = 500;
    private static int projectileID = 0;

    @SubscribeEvent
    public static void registerEnities(RegistryEvent.Register<EntityEntry> event) {
        IForgeRegistry<EntityEntry> registry = event.getRegistry();

        registry.registerAll(createProjectileEntries());
        registry.registerAll(createMobEntries());
    }

    public static EntityEntry buildEntityEntry(Class entityClass, String entityID, SpawnEggColors.Dimension dimension) { 
        SpawnEggColors colors = SpawnEggColors.getColorsForDimension(dimension);
        return EntityEntryBuilder.create().entity(entityClass)
                .id(new ResourceLocation(DivineRPG.MODID, entityID), mobID++).name(DivineRPG.MODID + "." + entityID).tracker(128, 3, true)
                .egg(colors.getPrimaryColor(), colors.getSecondaryColor()).build();
    }

    public static EntityEntry buildProjectileEntry(Class entityClass, String entityID) {
        return EntityEntryBuilder.create().entity(entityClass)
                .id(new ResourceLocation(DivineRPG.MODID, entityID), projectileID++).name(DivineRPG.MODID + "." + entityID)
                .tracker(250, 5, true).build();
    }

    public static EntityEntry[] createMobEntries() {
        EntityEntry[] divineMobs;
        divineMobs = new EntityEntry[]{
                // Overworld
                buildEntityEntry(EntityAridWarrior.class, "arid_warrior", OVERWORLD),
                buildEntityEntry(EntityCaveCrawler.class, "cave_crawler", OVERWORLD),
                buildEntityEntry(EntityCaveclops.class, "caveclops", OVERWORLD),
                buildEntityEntry(EntityCrab.class, "crab", OVERWORLD),
                buildEntityEntry(EntityCyclops.class, "cyclops", OVERWORLD),
                buildEntityEntry(EntityDesertCrawler.class, "desert_crawler", OVERWORLD),
                buildEntityEntry(EntityEhu.class, "ehu", OVERWORLD),
                buildEntityEntry(EntityEnthralledDramcryx.class, "enthralled_dramcryx", OVERWORLD),
                buildEntityEntry(EntityFrost.class, "frost", OVERWORLD),
                buildEntityEntry(EntityGlacon.class, "glacon", OVERWORLD),
                buildEntityEntry(EntityBrownGrizzle.class, "brown_grizzle", OVERWORLD),
                buildEntityEntry(EntityWhiteGrizzle.class, "white_grizzle", OVERWORLD),
                buildEntityEntry(EntityHusk.class, "husk", OVERWORLD),
                buildEntityEntry(EntityJackOMan.class, "jack_o_man", OVERWORLD),
                buildEntityEntry(EntityJungleBat.class, "jungle_bat", OVERWORLD),
                buildEntityEntry(EntityJungleDramcryx.class, "jungle_dramcryx", OVERWORLD),
                buildEntityEntry(EntityJungleSpider.class, "jungle_spider", OVERWORLD),
                buildEntityEntry(EntityKingCrab.class, "king_crab", OVERWORLD),
                buildEntityEntry(EntityKobblin.class, "kobblin", OVERWORLD),
                buildEntityEntry(EntityLiopleurodon.class, "liopleurodon", OVERWORLD),
                buildEntityEntry(EntityLivestockMerchant.class, "livestock_merchant", OVERWORLD),
                buildEntityEntry(EntityMiner.class, "miner", OVERWORLD),
                buildEntityEntry(EntityPumpkinSpider.class, "pumpkin_spider", OVERWORLD),
                buildEntityEntry(EntityRainbour.class, "rainbour", OVERWORLD),
                buildEntityEntry(EntityRotatick.class, "rotatick", OVERWORLD),
                buildEntityEntry(EntitySaguaroWorm.class, "saguaro_worm", OVERWORLD),
                buildEntityEntry(EntityShark.class, "shark", OVERWORLD),
                buildEntityEntry(EntitySmelter.class, "smelter", OVERWORLD),
                buildEntityEntry(EntitySnapper.class, "snapper", OVERWORLD),
                buildEntityEntry(EntityStoneGolem.class, "stone_golem", OVERWORLD),
                buildEntityEntry(EntityTheEye.class, "the_eye", OVERWORLD),
                buildEntityEntry(EntityTheGrue.class, "the_grue", OVERWORLD),
                buildEntityEntry(EntityWhale.class, "whale", OVERWORLD),

                // Nether
                buildEntityEntry(EntityHellPig.class, "hell_pig", NETHER),
                buildEntityEntry(EntityHellSpider.class, "hell_spider", NETHER),
                buildEntityEntry(EntityScorcher.class, "scorcher", NETHER),
                buildEntityEntry(EntityWildfire.class, "wildfire", NETHER),

                // End
                buildEntityEntry(EntityEnderSpider.class, "ender_spider", END),
                buildEntityEntry(EntityEnderTriplets.class, "ender_triplets", END),
                buildEntityEntry(EntityEnderWatcher.class, "ender_watcher", END),

                // Iceika
                buildEntityEntry(EntityAlicanto.class, "alicanto", ICEIKA),
                buildEntityEntry(EntityFractite.class, "fractite", ICEIKA),
                buildEntityEntry(EntityFrostArcher.class, "frost_archer", ICEIKA),
                buildEntityEntry(EntityFrosty.class, "frosty", ICEIKA),
                buildEntityEntry(EntityGlacide.class, "glacide", ICEIKA),
                buildEntityEntry(EntityHastreus.class, "hastreus", ICEIKA),
                buildEntityEntry(EntityRollum.class, "rollum", ICEIKA),
                buildEntityEntry(EntityWorkshopMerchant.class, "workshop_merchant", ICEIKA),
                buildEntityEntry(EntityWorkshopTinkerer.class, "workshop_tinkerer", ICEIKA),

                // Eden
                buildEntityEntry(EntityBunny.class, "bunny", EDEN),
                buildEntityEntry(EntityEdenCadillion.class, "eden_cadillion", EDEN),
                buildEntityEntry(EntityEdenTomo.class, "eden_tomo", EDEN),
                buildEntityEntry(EntityGreenfeet.class, "greenfeet", EDEN),
                buildEntityEntry(EntityMadivel.class, "madivel", EDEN),
                buildEntityEntry(EntitySunArcher.class, "sun_archer", EDEN),
                buildEntityEntry(EntityWeakCori.class, "weak_cori", EDEN),

                // Wildwood
                buildEntityEntry(EntityBehemoth.class, "behemoth", WILDWOOD),
                buildEntityEntry(EntityEpiphite.class, "epiphite", WILDWOOD),
                buildEntityEntry(EntityMage.class, "mage", WILDWOOD),
                buildEntityEntry(EntityMoonWolf.class, "moon_wolf", WILDWOOD),
                buildEntityEntry(EntityTermid.class, "termid", WILDWOOD),
                buildEntityEntry(EntityVerek.class, "verek", WILDWOOD),
                buildEntityEntry(EntityWildwoodCadillion.class, "wildwood_cadillion", WILDWOOD),
                buildEntityEntry(EntityWildwoodGolem.class, "wildwood_golem", WILDWOOD),
                buildEntityEntry(EntityWildwoodTomo.class, "wildwood_tomo", WILDWOOD),

                // Apalachia
                buildEntityEntry(EntityApalachiaCadillion.class, "apalachia_cadillion", APALACHIA),
                buildEntityEntry(EntityApalachiaGolem.class, "apalachia_golem", APALACHIA),
                buildEntityEntry(EntityApalachiaTomo.class, "apalachia_tomo", APALACHIA),
                buildEntityEntry(EntityEnchantedArcher.class, "enchanted_archer", APALACHIA),
                buildEntityEntry(EntityEnchantedWarrior.class, "enchanted_warrior", APALACHIA),
                buildEntityEntry(EntitySpellbinder.class, "spellbinder", APALACHIA),

                // Skythern
                buildEntityEntry(EntityAdvancedCori.class, "advanced_cori", SKYTHERN),
                buildEntityEntry(EntityMegalith.class, "megalith", SKYTHERN),
                buildEntityEntry(EntityMystic.class, "mystic", SKYTHERN),
                buildEntityEntry(EntitySamek.class, "samek", SKYTHERN),
                buildEntityEntry(EntitySkythernArcher.class, "skythern_archer", SKYTHERN),
                buildEntityEntry(EntitySkythernFiend.class, "skythern_fiend", SKYTHERN),
                buildEntityEntry(EntitySkythernGolem.class, "skythern_golem", SKYTHERN),

                // Mortum
                buildEntityEntry(EntityAngryBunny.class, "angry_bunny", MORTUM),
                buildEntityEntry(EntityBasilisk.class, "basilisk", MORTUM),
                buildEntityEntry(EntityDemonOfDarkness.class, "demon_of_darkness", MORTUM),
                buildEntityEntry(EntityMortumCadillion.class, "mortum_cadillion", MORTUM),
                buildEntityEntry(EntitySorcerer.class, "sorcerer", MORTUM),
                buildEntityEntry(EntitySoulStealer.class, "soul_stealer", MORTUM),
                buildEntityEntry(EntitySoulSpider.class, "soul_spider", MORTUM),
                buildEntityEntry(EntityTwilightArcher.class, "twilight_archer", MORTUM),

                // Arcana
                buildEntityEntry(EntityCaptainMerik.class, "captain_merik", ARCANA),
                buildEntityEntry(EntityDatticon.class, "datticon", ARCANA),
                buildEntityEntry(EntityDeathcryx.class, "deathcryx", ARCANA),
                buildEntityEntry(EntityDeathHound.class, "death_hound", ARCANA),
                buildEntityEntry(EntityDungeonConstructor.class, "dungeon_constructor", ARCANA),
                buildEntityEntry(EntityDungeonDemon.class, "dungeon_demon", ARCANA),
                buildEntityEntry(EntityDungeonPrisoner.class, "dungeon_prisoner", ARCANA),
                buildEntityEntry(EntityFyracryx.class, "fyracryx", ARCANA),
                buildEntityEntry(EntityKazari.class, "kazari", ARCANA),
                buildEntityEntry(EntityLeorna.class, "leorna", ARCANA),
                buildEntityEntry(EntityLivingStatue.class, "living_statue", ARCANA),
                buildEntityEntry(EntityParatiku.class, "paratiku", ARCANA),
                buildEntityEntry(EntityRazorback.class, "razorback", ARCANA),
                buildEntityEntry(EntityGolemOfRejuvenation.class, "golem_of_rejuvenation", ARCANA),
                buildEntityEntry(EntityRoamer.class, "roamer", ARCANA),
                buildEntityEntry(EntitySeimer.class, "seimer", ARCANA),
                buildEntityEntry(EntityLordVatticus.class, "lord_vatticus", ARCANA),
                buildEntityEntry(EntityWarGeneral.class, "war_general", ARCANA),
                buildEntityEntry(EntityWraith.class, "wraith", ARCANA),
                buildEntityEntry(EntityZelus.class, "zelus", ARCANA),

                // Vethea
                buildEntityEntry(EntityAcidHag.class, "acid_hag", VETHEA),
                buildEntityEntry(EntityBiphron.class, "biphron", VETHEA),
                buildEntityEntry(EntityBohemite.class, "bohemite", VETHEA),
                buildEntityEntry(EntityCryptKeeper.class, "crypt_keeper", VETHEA),
                buildEntityEntry(EntityCymesoid.class, "cymesoid", VETHEA),
                buildEntityEntry(EntityDissiment.class, "dissiment", VETHEA),
                buildEntityEntry(EntityDreamwrecker.class, "dreamwrecker", VETHEA),
                buildEntityEntry(EntityDuo.class, "duo", VETHEA),
                buildEntityEntry(EntityEnt.class, "ent", VETHEA),
                buildEntityEntry(EntityFakeVhraak.class, "fake_vhraak", VETHEA),
                buildEntityEntry(EntityGalroid.class, "galroid", VETHEA),
                buildEntityEntry(EntityGorgosion.class, "gorgosion", VETHEA),
                buildEntityEntry(EntityHelio.class, "helio", VETHEA),
                buildEntityEntry(EntityHiveSoldier.class, "hive_soldier", VETHEA),
                buildEntityEntry(EntityHoverStinger.class, "hover_stinger", VETHEA),
                buildEntityEntry(EntityKazrotic.class, "kazrotic", VETHEA),
                buildEntityEntry(EntityLheiva.class, "lheiva", VETHEA),
                buildEntityEntry(EntityLorga.class, "lorga", VETHEA),
                buildEntityEntry(EntityLorgaflight.class, "lorga_flight", VETHEA),
                buildEntityEntry(EntityMandragora.class, "mandragora", VETHEA),
                buildEntityEntry(EntityMysteriousManLayer1.class, "mysterious_man_layer_1", VETHEA),
                buildEntityEntry(EntityMysteriousManLayer2.class, "mysterious_man_layer_2", VETHEA),
                buildEntityEntry(EntityMysteriousManLayer3.class, "mysterious_man_layer_3", VETHEA),
                buildEntityEntry(EntityShadahier.class, "shadahier", VETHEA),
                buildEntityEntry(EntityTheHunger.class, "the_hunger", VETHEA),
                buildEntityEntry(EntityTempleGuardian.class, "temple_guardian", VETHEA),
                buildEntityEntry(EntityTocaxin.class, "tocaxin", VETHEA),
                buildEntityEntry(EntityTwins.class, "twins", VETHEA),
                buildEntityEntry(EntityVermenous.class, "vermenous", VETHEA),
                buildEntityEntry(EntityVhraak.class, "vhraak", VETHEA),
                buildEntityEntry(EntityZone.class, "zone", VETHEA),
                buildEntityEntry(EntityZoragon.class, "zoragon", VETHEA),

                // Boss
                buildEntityEntry(EntityAncientEntity.class, "ancient_entity", BOSS),
                buildEntityEntry(EntityAyeracoBlue.class, "ayeraco_blue", BOSS),
                buildEntityEntry(EntityAyeracoGreen.class, "ayeraco_green", BOSS),
                buildEntityEntry(EntityAyeracoPurple.class, "ayeraco_purple", BOSS),
                buildEntityEntry(EntityAyeracoRed.class, "ayeraco_red", BOSS),
                buildEntityEntry(EntityAyeracoYellow.class, "ayeraco_yellow", BOSS),
                buildEntityEntry(EntityDensos.class, "densos", BOSS),
                buildEntityEntry(EntityDramix.class, "dramix", BOSS),
                buildEntityEntry(EntityEternalArcher.class, "eternal_archer", BOSS),
                buildEntityEntry(EntityExperiencedCori.class, "experienced_cori", BOSS),
                buildEntityEntry(EntityHiveQueen.class, "hive_queen", BOSS),
                buildEntityEntry(EntityKarot.class, "karot", BOSS),
                buildEntityEntry(EntityKaros.class, "karos", BOSS),
                buildEntityEntry(EntityKingOfScorchers.class, "king_of_scorchers", BOSS),
                buildEntityEntry(EntityLadyLuna.class, "lady_luna", BOSS),
                buildEntityEntry(EntityParasecta.class, "parasecta", BOSS),
                buildEntityEntry(EntityQuadro.class, "quadro", BOSS),
                buildEntityEntry(EntityRaglok.class, "raglok", BOSS),
                buildEntityEntry(EntityReyvor.class, "reyvor", BOSS),
                buildEntityEntry(EntitySoulFiend.class, "soul_fiend", BOSS),
                buildEntityEntry(EntitySunstorm.class, "sunstorm", BOSS),
                buildEntityEntry(EntityTermasect.class, "termasect", BOSS),
                buildEntityEntry(EntityTheWatcher.class, "the_watcher", BOSS),
                buildEntityEntry(EntityTwilightDemon.class, "twilight_demon", BOSS),
                buildEntityEntry(EntityVamacheron.class, "vamacheron", BOSS),
                buildEntityEntry(EntityWreck.class, "wreck", BOSS)
        };

        return divineMobs;
    }

    public static EntityEntry[] createProjectileEntries() {
        // Projectiles
        EntityEntry[] divineProjectiles = {buildProjectileEntry(EntityCaveRock.class, "cave_rock"),
                buildProjectileEntry(EntitySerenadeOfDeath.class, "serenade_of_death"),
                buildProjectileEntry(EntitySerenadeOfIce.class, "serenade_of_ice"),
                buildProjectileEntry(EntityEnderTripletsFireball.class, "ender_triplets_fireball"),
                buildProjectileEntry(EntityFractiteShot.class, "fractite_shot"),
                buildProjectileEntry(EntityFrostShot.class, "frost_shot"),
                buildProjectileEntry(EntityFrostCloud.class, "frost_cloud"),
                buildProjectileEntry(EntityKingOfScorchersMeteor.class, "king_of_scorchers_meteor"),
                buildProjectileEntry(EntityKingOfScorchersShot.class, "king_of_scorchers_shot"),
                buildProjectileEntry(EntitySaguaroWormShot.class, "saguaro_worm_shot"),
                buildProjectileEntry(EntityScorcherShot.class, "scorcher_shot"),
                buildProjectileEntry(EntityShuriken.class, "shuriken"),
                buildProjectileEntry(EntitySparkler.class, "sparkler"),
                buildProjectileEntry(EntityWatcherShot.class, "watcher_shot"),
                buildProjectileEntry(EntityVileStorm.class, "vile_storm"),
                buildProjectileEntry(EntitySnowflakeShuriken.class, "snowflake_shuriken"),
                buildProjectileEntry(EntityShooterBullet.class, "shooter_bullet"),
                buildProjectileEntry(EntityParticleBullet.class, "particle_bullet"),
                buildProjectileEntry(EntityColoredBullet.class, "colored_bullet"),
                buildProjectileEntry(EntityCorruptedBullet.class, "corrupted_bullet"),
                buildProjectileEntry(EntitySoundOfMusic.class, "sound_of_music"),
                buildProjectileEntry(EntitySoundOfCarols.class, "sound_of_carols"),
                buildProjectileEntry(EntityDivineArrow.class, "arrow_shot"),
                buildProjectileEntry(EntityCoriShot.class, "cori_shot"),
                buildProjectileEntry(EntityTwilightMageShot.class, "twilight_mage_shot"),
                buildProjectileEntry(EntitySoulFiendShot.class, "soul_fiend_shot"),
                buildProjectileEntry(EntityDisk.class, "disk"),
                buildProjectileEntry(EntityGrenade.class, "grenade"),
                buildProjectileEntry(EntityAttractor.class, "attractor"),
                buildProjectileEntry(EntityGeneralsStaff.class, "generals_staff"),
                buildProjectileEntry(EntityMeteor.class, "meteor"),
                buildProjectileEntry(EntityStar.class, "star"),
                buildProjectileEntry(EntityFirefly.class, "firefly"),
                buildProjectileEntry(EntityReflector.class, "reflector"),
                buildProjectileEntry(EntityFyracryxFireball.class, "fyracryx_fireball"),
                buildProjectileEntry(EntityTwilightDemonShot.class, "twilight_demon_shot"),
                buildProjectileEntry(EntityMerikMissile.class, "meriks_missile"),
                buildProjectileEntry(EntityBouncingProjectile.class, "bouncing_projectile"),
                buildProjectileEntry(EntityMandragoraProjectile.class, "mandragora_projectile"),
                buildProjectileEntry(EntityKazroticShot.class, "kazrotic_shot"),
                buildProjectileEntry(EntityZoragonBomb.class, "zoragon_bomb"),
                buildProjectileEntry(EntityDissimentShot.class, "dissiment_shot"),
                buildProjectileEntry(EntityLadyLunaSparkler.class, "lady_luna_sparkler"),
                buildProjectileEntry(EntityRaglokBomb.class, "raglok_bomb"),
                buildProjectileEntry(EntityWreckBouncingProjectile.class, "wreck_bouncing_projectile"),
                buildProjectileEntry(EntityWreckExplosiveShot.class, "wreck_explosive_shot"),
                buildProjectileEntry(EntityWreckShot.class, "wreck_shot"),
        buildProjectileEntry(EntityWildwoodLog.class, "wildwood_log")};

        if (GeneralConfig.generalOptions.enableDebugMode) {
            DivineRPG.logger.info(DivineRPG.MODID + " entities have been loaded");
        }

        return divineProjectiles;
    }
}