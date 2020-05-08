package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.api.Reference;
import divinerpg.config.Config;
import divinerpg.objects.entities.assets.render.arcana.*;
import divinerpg.objects.entities.assets.render.iceika.*;
import divinerpg.objects.entities.assets.render.projectiles.*;
import divinerpg.objects.entities.assets.render.twilight.*;
import divinerpg.objects.entities.assets.render.vanilla.*;
import divinerpg.objects.entities.assets.render.vethea.*;
import divinerpg.objects.entities.entity.EntityFrostCloud;
import divinerpg.objects.entities.entity.arcana.*;
import divinerpg.objects.entities.entity.arcana.death.EntityDeathHound;
import divinerpg.objects.entities.entity.arcana.death.EntityDeathcryx;
import divinerpg.objects.entities.entity.iceika.*;
import divinerpg.objects.entities.entity.projectiles.*;
import divinerpg.objects.entities.entity.twilight.*;
import divinerpg.objects.entities.entity.twilight.cories.EntityAdvancedCori;
import divinerpg.objects.entities.entity.twilight.cories.EntityExperiencedCori;
import divinerpg.objects.entities.entity.twilight.cories.EntityWeakCori;
import divinerpg.objects.entities.entity.twilight.mage.EntityMage;
import divinerpg.objects.entities.entity.twilight.mage.EntityMystic;
import divinerpg.objects.entities.entity.twilight.mage.EntitySorcerer;
import divinerpg.objects.entities.entity.twilight.mage.EntitySpellbinder;
import divinerpg.objects.entities.entity.vanilla.*;
import divinerpg.objects.entities.entity.vanilla.ayeraco.*;
import divinerpg.objects.entities.entity.vethea.*;
import divinerpg.utils.SpawnEggColors;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import static divinerpg.utils.SpawnEggColors.Dimension.*;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ModEntities {
    private static int mobID = 500;
    private static int projectileID = 0;

    @SubscribeEvent
    public static void registerEnities(RegistryEvent.Register<EntityEntry> event) {
        IForgeRegistry<EntityEntry> registry = event.getRegistry();

        registry.registerAll(initProjectiles());
        registry.registerAll(initMobs());
    }

    public static EntityEntry buildEntityEntry(Class entityClass, String entityID, SpawnEggColors.Dimension dimension) { 
        SpawnEggColors colors = SpawnEggColors.getColorsForDimension(dimension);
        return EntityEntryBuilder.create().entity(entityClass)
                .id(new ResourceLocation(Reference.MODID, entityID), mobID++).name(Reference.MODID + "." + entityID).tracker(128, 3, true)
                .egg(colors.getPrimaryColor(), colors.getSecondaryColor()).build();
    }

    public static EntityEntry buildProjectileEntry(Class entityClass, String entityID) {
        return EntityEntryBuilder.create().entity(entityClass)
                .id(new ResourceLocation(Reference.MODID, entityID), projectileID++).name(Reference.MODID + "." + entityID)
                .tracker(250, 5, true).build();
    }

    public static EntityEntry[] initMobs() {
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
                buildEntityEntry(EntityHerbomancer.class, "herbomancer", VETHEA),
                buildEntityEntry(EntityHerbomancerMinion.class, "herbomancer_minion", VETHEA),
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

    public static EntityEntry[] initProjectiles() {
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
                buildProjectileEntry(EntityLamona.class, "lamona"),
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

        if (Config.debug) {
            DivineRPG.logger.info(Reference.MODID + " entities have been loaded");
        }

        return divineProjectiles;
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {

        // Projectiles
        registerRender(EntityAttractor.class, RenderAttractor::new);
        registerRender(EntityBouncingProjectile.class, RenderBouncingProjectile::new);
        registerRender(EntityCaveRock.class, manager -> new RenderCaveRock(manager, 1f));
        registerRender(EntityCoriShot.class, manager -> new RenderCoriShot(manager, 1f));
        registerRender(EntityCorruptedBullet.class, manager -> new RenderCorruptedBullet(manager, 1f));
        registerRender(EntityDisk.class, RenderDisk::new);
        registerRender(EntityDissimentShot.class, manager -> new RenderDissimentShot(manager, 1f));
        registerRender(EntityDivineArrow.class, RenderDivineArrow::new);
        registerRender(EntityEnderTripletsFireball.class, manager -> new RenderEnderTripletsFireball(manager, 1f));
        registerRender(EntityFirefly.class, RenderFirefly::new);
        registerRender(EntityFractiteShot.class, manager -> new RenderFractiteShot(manager, 1.0f));
        registerRender(EntityFrostShot.class, manager -> new RenderFrostShot(manager, 0.75f));
        registerRender(EntityFyracryxFireball.class, RenderFyracryxFireball::new);
        registerRender(EntityGeneralsStaff.class, RenderStaff::new);
        registerRender(EntityGrenade.class, RenderGrenade::new);
        registerRender(EntityKazroticShot.class, manager -> new RenderKazroticShot(manager, 1f));
        registerRender(EntityKingOfScorchersMeteor.class, manager -> new RenderKingofScorchersMeteor(manager, 1f));
        registerRender(EntityKingOfScorchersShot.class, manager -> new RenderKingofScorchersShot(manager, 1f));
        registerRender(EntityLadyLunaSparkler.class, RenderShooterBullet::new);
        registerRender(EntityLamona.class, RenderLamona::new);
        registerRender(EntityMandragoraProjectile.class, manager -> new RenderMandragoraProjectile(manager, 1f));
        registerRender(EntityMerikMissile.class, RenderMerikMissile::new);
        registerRender(EntityMeteor.class, RenderMeteor::new);
        registerRender(EntityRaglokBomb.class, manager -> new RenderRaglokBomb(manager, 1f));
        registerRender(EntityReflector.class, RenderReflector::new);
        registerRender(EntitySaguaroWormShot.class, RenderSaguaroWormShot::new);
        registerRender(EntityScorcherShot.class, manager -> new RenderScorcherShot(manager, 0.5f));
        registerRender(EntitySerenadeOfDeath.class, manager -> new RenderSerenadeOfDeath(manager, 1f));
        registerRender(EntitySerenadeOfIce.class, manager -> new RenderSerenadeOfIce(manager, 1f));
        registerRender(EntityShooterBullet.class, RenderShooterBullet::new);
        registerRender(EntitySnowflakeShuriken.class, manager -> new RenderSnowShuriken(manager, 1f));
        registerRender(EntitySoundOfCarols.class, manager -> new RenderSoundOfCarols(manager, 1f));
        registerRender(EntitySoundOfMusic.class, manager -> new RenderSoundOfMusic(manager, 1f));
        registerRender(EntitySparkler.class, RenderSparkler::new);
        registerRender(EntityStar.class, RenderStar::new);
        registerRender(EntityVileStorm.class, manager -> new RenderVileStorm(manager, 1f));
        registerRender(EntityWatcherShot.class, manager -> new RenderWatcherShot(manager, 1f));
        registerRender(EntityWreckBouncingProjectile.class, manager -> new RenderWreckBouncingProjectile(manager, 1f));
        registerRender(EntityWreckExplosiveShot.class, manager -> new RenderWreckExplosiveShot(manager, 1f));
        registerRender(EntityWreckShot.class, manager -> new RenderWreckShot(manager, 1f));
        registerRender(EntityZoragonBomb.class, manager -> new RenderZoragonBomb(manager, 1f));
        registerRender(EntityWildwoodLog.class, manager -> new RenderWildwoodLog(manager, 1f));

        registerRender(EntityFrostCloud.class, RenderFrostCloud::new);

        // Vanilla
        registerRender(EntityAncientEntity.class, RenderAncientEntity::new);
        registerRender(EntityAridWarrior.class, RenderAridWarrior::new);

        registerRender(EntityAyeracoBlue.class, x -> new RenderAyeraco(x, "blue"));
        registerRender(EntityAyeracoGreen.class, x -> new RenderAyeraco(x, "green"));
        registerRender(EntityAyeracoPurple.class, x -> new RenderAyeraco(x, "purple"));
        registerRender(EntityAyeracoRed.class, x -> new RenderAyeraco(x, "red"));
        registerRender(EntityAyeracoYellow.class, x -> new RenderAyeraco(x, "yellow"));

        registerRender(EntityBrownGrizzle.class, RenderBrownGrizzle::new);
        registerRender(EntityCaveclops.class, RenderCaveclops::new);
        registerRender(EntityCaveCrawler.class, RenderCaveCrawler::new);
        registerRender(EntityCrab.class, RenderCrab::new);
        registerRender(EntityCyclops.class, RenderCyclops::new);
        registerRender(EntityDesertCrawler.class, RenderDesertCrawler::new);
        registerRender(EntityEhu.class, RenderEhu::new);
        registerRender(EntityEnderSpider.class, RenderEnderSpider::new);
        registerRender(EntityEnderTriplets.class, RenderEnderTriplets::new);
        registerRender(EntityEnderWatcher.class, RenderEnderWatcher::new);
        registerRender(EntityEnthralledDramcryx.class, RenderEnthralledDramcryx::new);
        registerRender(EntityFrost.class, RenderFrost::new);
        registerRender(EntityGlacon.class, RenderGlacon::new);
        registerRender(EntityHellPig.class, RenderHellPig::new);
        registerRender(EntityHellSpider.class, RenderHellSpider::new);
        registerRender(EntityHusk.class, RenderHusk::new);
        registerRender(EntityJackOMan.class, RenderJackOMan::new);
        registerRender(EntityJungleBat.class, RenderJungleBat::new);
        registerRender(EntityJungleDramcryx.class, RenderJungleDramcryx::new);
        registerRender(EntityJungleSpider.class, RenderJungleSpider::new);
        registerRender(EntityKingCrab.class, RenderKingCrab::new);
        registerRender(EntityKingOfScorchers.class, RenderKingOfScorchers::new);
        registerRender(EntityKobblin.class, RenderKobblin::new);
        registerRender(EntityLiopleurodon.class, RenderLiopleurodon::new);
        registerRender(EntityLivestockMerchant.class, RenderLivestockMerchant::new);
        registerRender(EntityMiner.class, RenderMiner::new);
        registerRender(EntityPumpkinSpider.class, RenderPumpkinSpider::new);
        registerRender(EntityRainbour.class, RenderRainbour::new);
        registerRender(EntityRotatick.class, RenderRotatick::new);
        registerRender(EntitySaguaroWorm.class, RenderSaguaroWorm::new);
        registerRender(EntityScorcher.class, RenderScorcher::new);
        registerRender(EntityShark.class, RenderShark::new);
        registerRender(EntitySmelter.class, RenderSmelter::new);
        registerRender(EntitySnapper.class, RenderSnapper::new);
        registerRender(EntityStoneGolem.class, RenderStoneGolem::new);
        registerRender(EntityTheEye.class, RenderTheEye::new);
        registerRender(EntityTheGrue.class, RenderTheGrue::new);
        registerRender(EntityTheWatcher.class, RenderTheWatcher::new);
        registerRender(EntityWhale.class, RenderWhale::new);
        registerRender(EntityWhiteGrizzle.class, RenderWhiteGrizzle::new);
        registerRender(EntityWildfire.class, RenderWildfire::new);

        // Iceika
        registerRender(EntityAlicanto.class, RenderAlicanto::new);
        registerRender(EntityFrostArcher.class, RenderFrostArcher::new);
        registerRender(EntityFractite.class, RenderFractite::new);
        registerRender(EntityFrosty.class, RenderFrosty::new);
        registerRender(EntityGlacide.class, RenderGlacide::new);
        registerRender(EntityHastreus.class, RenderHastreus::new);
        registerRender(EntityRollum.class, RenderRollum::new);
        registerRender(EntityWorkshopTinkerer.class, RenderWorkshopTinkerer::new);
        registerRender(EntityWorkshopMerchant.class, RenderWorkshopMerchant::new);

        // Twilight
        registerRender(EntityAdvancedCori.class, RenderAdvancedCori::new);
        registerRender(EntityAngryBunny.class, RenderAngryBunny::new);
        registerRender(EntityApalachiaCadillion.class, RenderApalachiaCadillion::new);
        registerRender(EntityApalachiaGolem.class, RenderApalachiaGolem::new);
        registerRender(EntityApalachiaTomo.class, RenderApalachiaTomo::new);
        registerRender(EntityBasilisk.class, RenderBasilisk::new);
        registerRender(EntityBehemoth.class, RenderBehemoth::new);
        registerRender(EntityBunny.class, RenderBunny::new);
        registerRender(EntityDemonOfDarkness.class, RenderDemonOfDarkness::new);
        registerRender(EntityDensos.class, RenderDensos::new);
        registerRender(EntityEdenCadillion.class, RenderEdenCadillion::new);
        registerRender(EntityEdenTomo.class, RenderEdenTomo::new);
        registerRender(EntityEnchantedArcher.class, RenderEnchantedArcher::new);
        registerRender(EntityEnchantedWarrior.class, RenderEnchantedWarrior::new);
        registerRender(EntityEpiphite.class, RenderEpiphite::new);
        registerRender(EntityEternalArcher.class, RenderEternalArcher::new);
        registerRender(EntityExperiencedCori.class, RenderExperiencedCori::new);
        registerRender(EntityGreenfeet.class, RenderGreenfeet::new);
        registerRender(EntityKarot.class, RenderKarot::new);
        registerRender(EntityMadivel.class, RenderMadivel::new);
        registerRender(EntityMage.class, RenderMage::new);
        registerRender(EntityMegalith.class, RenderMegalith::new);
        registerRender(EntityMoonWolf.class, RenderMoonWolf::new);
        registerRender(EntityMortumCadillion.class, RenderMortumCadillion::new);
        registerRender(EntityMystic.class, RenderMystic::new);
        registerRender(EntityReyvor.class, RenderReyvor::new);
        registerRender(EntitySamek.class, RenderSamek::new);
        registerRender(EntitySkythernArcher.class, RenderSkythernArcher::new);
        registerRender(EntitySkythernFiend.class, RenderSkythernFiend::new);
        registerRender(EntitySkythernGolem.class, RenderSkythernGolem::new);
        registerRender(EntitySorcerer.class, RenderSorcerer::new);
        registerRender(EntitySoulFiend.class, RenderSoulFiend::new);
        registerRender(EntitySoulSpider.class, RenderSoulSpider::new);
        registerRender(EntitySoulStealer.class, RenderSoulStealer::new);
        registerRender(EntitySpellbinder.class, RenderSpellbinder::new);
        registerRender(EntitySunArcher.class, RenderSunArcher::new);
        registerRender(EntitySunstorm.class, RenderSunstorm::new);
        registerRender(EntityTermasect.class, RenderTermasect::new);
        registerRender(EntityTermid.class, RenderTermid::new);
        registerRender(EntityTwilightArcher.class, RenderTwilightArcher::new);
        registerRender(EntityTwilightDemon.class, RenderTwilightDemon::new);
        registerRender(EntityVamacheron.class, RenderVamacheron::new);
        registerRender(EntityVerek.class, RenderVerek::new);
        registerRender(EntityWeakCori.class, RenderWeakCori::new);
        registerRender(EntityWildwoodCadillion.class, RenderWildwoodCadillion::new);
        registerRender(EntityWildwoodGolem.class, RenderWildwoodGolem::new);
        registerRender(EntityWildwoodTomo.class, RenderWildwoodTomo::new);

        // Arcana
        registerRender(EntityCaptainMerik.class, RenderCaptainMerik::new);
        registerRender(EntityDatticon.class, RenderDatticon::new);
        registerRender(EntityDeathcryx.class, RenderDeathcryx::new);
        registerRender(EntityDeathHound.class, RenderDeathHound::new);
        registerRender(EntityDramix.class, RenderDramix::new);
        registerRender(EntityDungeonConstructor.class, RenderDungeonConstructor::new);
        registerRender(EntityDungeonDemon.class, RenderDungeonDemon::new);
        registerRender(EntityDungeonPrisoner.class, RenderDungeonPrisoner::new);
        registerRender(EntityFyracryx.class, RenderFyracryx::new);
        registerRender(EntityGolemOfRejuvenation.class, RenderGolemOfRejuvenation::new);
        registerRender(EntityLeorna.class, RenderLeorna::new);
        registerRender(EntityLivingStatue.class, RenderLivingStatue::new);
        registerRender(EntityLordVatticus.class, RenderLordVatticus::new);
        registerRender(EntityParasecta.class, RenderParasecta::new);
        registerRender(EntityParatiku.class, RenderParatiku::new);
        registerRender(EntityRazorback.class, RenderRazorback::new);
        registerRender(EntityRoamer.class, RenderRoamer::new);
        registerRender(EntitySeimer.class, RenderSeimer::new);
        registerRender(EntityWarGeneral.class, RenderWarGeneral::new);
        registerRender(EntityWraith.class, RenderWraith::new);
        registerRender(EntityZelus.class, RenderZelus::new);

        //Vethea
        registerRender(EntityAcidHag.class, RenderAcidHag::new);
        registerRender(EntityBiphron.class, RenderBiphron::new);
        registerRender(EntityBohemite.class, RenderBohemite::new);
        registerRender(EntityCryptKeeper.class, RenderCryptKeeper::new);
        registerRender(EntityCymesoid.class, RenderCymesoid::new);
        registerRender(EntityDissiment.class, RenderDissiment::new);
        registerRender(EntityDreamwrecker.class, RenderDreamwrecker::new);
        registerRender(EntityDuo.class, RenderDuo::new);
        registerRender(EntityEnt.class, RenderEnt::new);
        registerRender(EntityFakeVhraak.class, RenderFakeVhraak::new);
        registerRender(EntityGalroid.class, RenderGalroid::new);
        registerRender(EntityGorgosion.class, RenderGorgosion::new);
        registerRender(EntityHelio.class, RenderHelio::new);
        registerRender(EntityHerbomancer.class, RenderHerbomancer::new);
        registerRender(EntityHerbomancerMinion.class, RenderHerbomancerMinion::new);
        registerRender(EntityHiveQueen.class, RenderHiveQueen::new);
        registerRender(EntityHiveSoldier.class, RenderHiveSoldier::new);
        registerRender(EntityHoverStinger.class, RenderHoverStinger::new);
        registerRender(EntityKaros.class, RenderKaros::new);
        registerRender(EntityKazrotic.class, RenderKazrotic::new);
        registerRender(EntityLadyLuna.class, RenderLadyLuna::new);
        registerRender(EntityLheiva.class, RenderLheiva::new);
        registerRender(EntityLorga.class, RenderLorga::new);
        registerRender(EntityLorgaflight.class, RenderLorgaFlight::new);
        registerRender(EntityMandragora.class, RenderMandragora::new);
        registerRender(EntityMysteriousManLayer1.class, RenderMysteriousManLayer1::new);
        registerRender(EntityMysteriousManLayer2.class, RenderMysteriousManLayer2::new);
        registerRender(EntityMysteriousManLayer3.class, RenderMysteriousManLayer3::new);
        registerRender(EntityQuadro.class, RenderQuadro::new);
        registerRender(EntityRaglok.class, RenderRaglok::new);
        registerRender(EntityShadahier.class, RenderShadahier::new);
        registerRender(EntitySpinarus.class, RenderSpinarus::new);
        registerRender(EntityTempleGuardian.class, RenderTempleGuardian::new);
        registerRender(EntityTheHunger.class, RenderTheHunger::new);
        registerRender(EntityTocaxin.class, RenderTocaxin::new);
        registerRender(EntityTwins.class, RenderTwins::new);
        registerRender(EntityVermenous.class, RenderVermenous::new);
        registerRender(EntityVhraak.class, RenderVhraak::new);
        registerRender(EntityWreck.class, RenderWreck::new);
        registerRender(EntityZone.class, RenderZone::new);
        registerRender(EntityZoragon.class, RenderZoragon::new);
    }

    /**
     * Private helper method that simply calls the rendering registry method.
     * No functional benefit, exists solely to make rendering registry code section less of an eyesore.
     *
     * @param entityClass   the entity class of type T
     * @param renderFactory a render factory for the entity
     * @param <T>           generic class to ensure it extends entity
     */
    private static <T extends Entity> void registerRender(Class<T> entityClass, IRenderFactory<? super T> renderFactory) {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, renderFactory);
    }
}