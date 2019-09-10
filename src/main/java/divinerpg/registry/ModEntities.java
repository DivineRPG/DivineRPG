package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.Reference;
import divinerpg.config.Config;
import divinerpg.objects.entities.assets.render.arcana.*;
import divinerpg.objects.entities.assets.render.iceika.*;
import divinerpg.objects.entities.assets.render.twilight.*;
import divinerpg.objects.entities.assets.render.vanilla.*;
import divinerpg.objects.entities.entity.EntityFrostCloud;
import divinerpg.objects.entities.entity.arcana.*;
import divinerpg.objects.entities.entity.iceika.*;
import divinerpg.objects.entities.entity.projectiles.*;
import divinerpg.objects.entities.entity.twilight.*;
import divinerpg.objects.entities.entity.vanilla.*;
import divinerpg.objects.entities.entity.vanilla.ayeraco.*;
import divinerpg.utils.SpawnEggColors;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import static divinerpg.utils.SpawnEggColors.Dimension.*;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ModEntities {

    public static int projectileID = 0;
    public static int mobID = 500;

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
        EntityEntry[] divineMobs = {
                // Overworld
                buildEntityEntry(AridWarrior.class, "arid_warrior", OVERWORLD),
                buildEntityEntry(CaveCrawler.class, "cave_crawler", OVERWORLD),
                buildEntityEntry(Caveclops.class, "caveclops", OVERWORLD),
                buildEntityEntry(Crab.class, "crab", OVERWORLD), buildEntityEntry(Cyclops.class, "cyclops", OVERWORLD),
                buildEntityEntry(DesertCrawler.class, "desert_crawler", OVERWORLD),
                buildEntityEntry(Ehu.class, "ehu", OVERWORLD),
                buildEntityEntry(EnthralledDramcryx.class, "enthralled_dramcryx", OVERWORLD),
                buildEntityEntry(Frost.class, "frost", OVERWORLD), buildEntityEntry(Glacon.class, "glacon", OVERWORLD),
                buildEntityEntry(BrownGrizzle.class, "brown_grizzle", OVERWORLD),
                buildEntityEntry(WhiteGrizzle.class, "white_grizzle", OVERWORLD),
                buildEntityEntry(Husk.class, "husk", OVERWORLD),
                buildEntityEntry(JackOMan.class, "jack_o_man", OVERWORLD),
                buildEntityEntry(JungleBat.class, "jungle_bat", OVERWORLD),
                buildEntityEntry(JungleDramcryx.class, "jungle_dramcryx", OVERWORLD),
                buildEntityEntry(JungleSpider.class, "jungle_spider", OVERWORLD),
                buildEntityEntry(KingCrab.class, "king_crab", OVERWORLD),
                buildEntityEntry(Kobblin.class, "kobblin", OVERWORLD),
                buildEntityEntry(Liopleurodon.class, "liopleurodon", OVERWORLD),
                buildEntityEntry(LivestockMerchant.class, "livestock_merchant", OVERWORLD),
                buildEntityEntry(Miner.class, "miner", OVERWORLD),
                buildEntityEntry(PumpkinSpider.class, "pumpkin_spider", OVERWORLD),
                buildEntityEntry(Rainbour.class, "rainbour", OVERWORLD),
                buildEntityEntry(Rotatick.class, "rotatick", OVERWORLD),
                buildEntityEntry(SaguaroWorm.class, "saguaro_worm", OVERWORLD),
                buildEntityEntry(Shark.class, "shark", OVERWORLD),
                buildEntityEntry(Smelter.class, "smelter", OVERWORLD),
                buildEntityEntry(Snapper.class, "snapper", OVERWORLD),
                buildEntityEntry(StoneGolem.class, "stone_golem", OVERWORLD),
                buildEntityEntry(TheEye.class, "the_eye", OVERWORLD),
                buildEntityEntry(TheGrue.class, "the_grue", OVERWORLD),
                buildEntityEntry(Whale.class, "whale", OVERWORLD),

                // Nether
                buildEntityEntry(HellPig.class, "hell_pig", NETHER),
                buildEntityEntry(HellSpider.class, "hell_spider", NETHER),
                buildEntityEntry(Scorcher.class, "scorcher", NETHER),
                buildEntityEntry(Wildfire.class, "wildfire", NETHER),

                // End
                buildEntityEntry(EnderSpider.class, "ender_spider", END),
                buildEntityEntry(EnderTriplets.class, "ender_triplets", END),
                buildEntityEntry(EnderWatcher.class, "ender_watcher", END),

                // Iceika
                buildEntityEntry(Alicanto.class, "alicanto", ICEIKA),
                buildEntityEntry(Fractite.class, "fractite", ICEIKA),
                buildEntityEntry(FrostArcher.class, "frost_archer", ICEIKA),
                buildEntityEntry(Frosty.class, "frosty", ICEIKA), buildEntityEntry(Glacide.class, "glacide", ICEIKA),
                buildEntityEntry(Hastreus.class, "hastreus", ICEIKA), buildEntityEntry(Rollum.class, "rollum", ICEIKA),
                buildEntityEntry(WorkshopMerchant.class, "workshop_merchant", ICEIKA),
                buildEntityEntry(WorkshopTinkerer.class, "workshop_tinkerer", ICEIKA),

                // Eden
                buildEntityEntry(Bunny.class, "bunny", EDEN),
                buildEntityEntry(EdenCadillion.class, "eden_cadillion", EDEN),
                buildEntityEntry(EdenTomo.class, "eden_tomo", EDEN),
                buildEntityEntry(Greenfeet.class, "greenfeet", EDEN), buildEntityEntry(Madivel.class, "madivel", EDEN),
                buildEntityEntry(SunArcher.class, "sun_archer", EDEN),
                buildEntityEntry(WeakCori.class, "weak_cori", EDEN),

                // Wildwood
                buildEntityEntry(Behemoth.class, "behemoth", WILDWOOD),
                buildEntityEntry(Epiphite.class, "epiphite", WILDWOOD), buildEntityEntry(Mage.class, "mage", WILDWOOD),
                buildEntityEntry(MoonWolf.class, "moon_wolf", WILDWOOD),
                buildEntityEntry(Verek.class, "verek", WILDWOOD),
                buildEntityEntry(WildwoodCadillion.class, "wildwood_cadillion", WILDWOOD),
                buildEntityEntry(WildwoodGolem.class, "wildwood_golem", WILDWOOD),
                buildEntityEntry(WildwoodTomo.class, "wildwood_tomo", WILDWOOD),

                // Apalachia
                buildEntityEntry(ApalachiaCadillion.class, "apalachia_cadillion", APALACHIA),
                buildEntityEntry(ApalachiaGolem.class, "apalachia_golem", APALACHIA),
                buildEntityEntry(ApalachiaTomo.class, "apalachia_tomo", APALACHIA),
                buildEntityEntry(EnchantedArcher.class, "enchanted_archer", APALACHIA),
                buildEntityEntry(EnchantedWarrior.class, "enchanted_warrior", APALACHIA),
                buildEntityEntry(Spellbinder.class, "spellbinder", APALACHIA),

                // Skythern
                buildEntityEntry(AdvancedCori.class, "advanced_cori", SKYTHERN),
                buildEntityEntry(Megalith.class, "megalith", SKYTHERN),
                buildEntityEntry(Mystic.class, "mystic", SKYTHERN), buildEntityEntry(Samek.class, "samek", SKYTHERN),
                buildEntityEntry(SkythernArcher.class, "skythern_archer", SKYTHERN),
                buildEntityEntry(SkythernFiend.class, "skythern_fiend", SKYTHERN),
                buildEntityEntry(SkythernGolem.class, "skythern_golem", SKYTHERN),

                // Mortum
                buildEntityEntry(AngryBunny.class, "angry_bunny", MORTUM),
                buildEntityEntry(Basilisk.class, "basilisk", MORTUM),
                buildEntityEntry(DemonOfDarkness.class, "demon_of_darkness", MORTUM),
                buildEntityEntry(MortumCadillion.class, "mortum_cadillion", MORTUM),
                buildEntityEntry(Sorcerer.class, "sorcerer", MORTUM),
                buildEntityEntry(SoulStealer.class, "soul_stealer", MORTUM),
                buildEntityEntry(SoulSpider.class, "soul_spider", MORTUM),
                buildEntityEntry(TwilightArcher.class, "twilight_archer", MORTUM),

                // Arcana
                buildEntityEntry(CaptainMerik.class, "captain_merik", ARCANA),
                buildEntityEntry(Datticon.class, "datticon", ARCANA),
                buildEntityEntry(Deathcryx.class, "deathcryx", ARCANA),
                buildEntityEntry(DeathHound.class, "death_hound", ARCANA),
                buildEntityEntry(DungeonConstructor.class, "dungeon_constructor", ARCANA),
                buildEntityEntry(DungeonDemon.class, "dungeon_demon", ARCANA),
                buildEntityEntry(DungeonPrisoner.class, "dungeon_prisoner", ARCANA),
                buildEntityEntry(Fyracryx.class, "fyracryx", ARCANA), buildEntityEntry(Leorna.class, "leorna", ARCANA),
                buildEntityEntry(LivingStatue.class, "living_statue", ARCANA),
                buildEntityEntry(Paratiku.class, "paratiku", ARCANA),
                buildEntityEntry(Razorback.class, "razorback", ARCANA),
                buildEntityEntry(GolemOfRejuvenation.class, "golem_of_rejuvenation", ARCANA),
                buildEntityEntry(Roamer.class, "roamer", ARCANA), buildEntityEntry(Seimer.class, "seimer", ARCANA),
                buildEntityEntry(LordVatticus.class, "lord_vatticus", ARCANA),
                buildEntityEntry(WarGeneral.class, "war_general", ARCANA),
                buildEntityEntry(Wraith.class, "wraith", ARCANA), buildEntityEntry(Zelus.class, "zelus", ARCANA),

                // Boss
                buildEntityEntry(AncientEntity.class, "ancient_entity", BOSS),
                buildEntityEntry(AyeracoBlue.class, "ayeraco_blue", BOSS),
                buildEntityEntry(AyeracoGreen.class, "ayeraco_green", BOSS),
                buildEntityEntry(AyeracoPurple.class, "ayeraco_purple", BOSS),
                buildEntityEntry(AyeracoRed.class, "ayeraco_red", BOSS),
                buildEntityEntry(AyeracoYellow.class, "ayeraco_yellow", BOSS),
                buildEntityEntry(Densos.class, "densos", BOSS), buildEntityEntry(Dramix.class, "dramix", BOSS),
                buildEntityEntry(EternalArcher.class, "eternal_archer", BOSS),
                buildEntityEntry(Karot.class, "karot", BOSS),
                buildEntityEntry(KingOfScorchers.class, "king_of_scorchers", BOSS),
                buildEntityEntry(Reyvor.class, "reyvor", BOSS), buildEntityEntry(SoulFiend.class, "soul_fiend", BOSS),
                buildEntityEntry(TheWatcher.class, "the_watcher", BOSS),
                buildEntityEntry(TwilightDemon.class, "twilight_demon", BOSS),
                buildEntityEntry(Vamacheron.class, "vamacheron", BOSS),
                buildEntityEntry(Parasecta.class, "parasecta", BOSS)
        };

        return divineMobs;
    }

    public static EntityEntry[] initProjectiles() {
        // Projectiles
        EntityEntry[] divineProjectiles = { buildProjectileEntry(EntityCaveRock.class, "cave_rock"),
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
                buildProjectileEntry(EntityDisk.class, "disk"), buildProjectileEntry(EntityGrenade.class, "grenade"),
                buildProjectileEntry(EntityAttractor.class, "attractor"),
                buildProjectileEntry(EntityGeneralsStaff.class, "generals_staff"),
                buildProjectileEntry(EntityMeteor.class, "meteor"), buildProjectileEntry(EntityStar.class, "star"),
                buildProjectileEntry(EntityBouncingProjectile.class, "bouncing"),
                buildProjectileEntry(EntityEvernightProjectile.class, "evernight"),
                buildProjectileEntry(EntityLamona.class, "lamona"),
                buildProjectileEntry(EntityFirefly.class, "firefly"),
                buildProjectileEntry(EntityReflector.class, "reflector"),
                buildProjectileEntry(EntityFyracryxFireball.class, "fyracryx_fireball"),
                buildProjectileEntry(EntityTwilightDemonShot.class, "twilight_demon_shot"),
                buildProjectileEntry(EntityMerikMissile.class, "meriks_missile") };

        if (Config.debug) {
            DivineRPG.logger.info(Reference.MODID + " entities have been loaded");
        }

        return divineProjectiles;
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        // Projectiles
        EntityCaveRock.renderMe();
        EntityEnderTripletsFireball.renderMe();
        EntityFractiteShot.renderMe();
        EntityFrostShot.renderMe();
        EntityFrostCloud.renderMe();
        EntityKingOfScorchersMeteor.renderMe();
        EntityKingOfScorchersShot.renderMe();
        EntitySaguaroWormShot.renderMe();
        EntityScorcherShot.renderMe();
        EntityVileStorm.renderMe();
        EntityWatcherShot.renderMe();
        EntitySnowflakeShuriken.renderMe();
        EntityShooterBullet.renderMe();
        EntityDisk.renderMe();
        EntityGrenade.renderMe();
        EntityCorruptedBullet.renderMe();
        EntitySerenadeOfDeath.renderMe();
        EntitySerenadeOfIce.renderMe();
        EntitySoundOfMusic.renderMe();
        EntitySoundOfCarols.renderMe();
        EntityDivineArrow.renderMe();
        EntityCoriShot.renderMe();
        EntityAttractor.renderMe();
        EntitySparkler.renderMe();
        EntityGeneralsStaff.renderMe();
        EntityMeteor.renderMe();
        EntityStar.renderMe();
        EntityBouncingProjectile.renderMe();
        EntityEvernightProjectile.renderMe();
        EntityLamona.renderMe();
        EntityFirefly.renderMe();
        EntityReflector.renderMe();
        EntityFyracryxFireball.renderMe();
        EntityMerikMissile.renderMe();

        // Arcana
        RenderingRegistry.registerEntityRenderingHandler(CaptainMerik.class, RenderCaptainMerik.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Datticon.class, RenderDatticon.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Deathcryx.class, RenderDeathcryx.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(DeathHound.class, RenderDeathHound.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(DungeonDemon.class, RenderDungeonDemon.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(DungeonPrisoner.class, RenderDungeonPrisoner.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Dramix.class, RenderDramix.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Fyracryx.class, RenderFyracryx.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Razorback.class, RenderRazorback.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(GolemOfRejuvenation.class, RenderGolemOfRejuvenation.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Roamer.class, RenderRoamer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Seimer.class, RenderSeimer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Zelus.class, RenderZelus.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Wraith.class, RenderWraith.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Leorna.class, RenderLeorna.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(LivingStatue.class, RenderLivingStatue.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Parasecta.class, RenderParasecta.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Paratiku.class, RenderParatiku.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(LordVatticus.class, RenderLordVatticus.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(WarGeneral.class, RenderWarGeneral.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(DungeonConstructor.class, RenderDungeonConstructor.FACTORY);

        // Iceika
        RenderingRegistry.registerEntityRenderingHandler(Alicanto.class, RenderAlicanto.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(FrostArcher.class, RenderFrostArcher.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Fractite.class, RenderFractite.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Frosty.class, RenderFrosty.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Glacide.class, RenderGlacide.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Hastreus.class, RenderHastreus.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Rollum.class, RenderRollum.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(WorkshopTinkerer.class, RenderWorkshopTinkerer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(WorkshopMerchant.class, RenderWorkshopMerchant.FACTORY);

        // Twilight
        RenderingRegistry.registerEntityRenderingHandler(AngryBunny.class, RenderAngryBunny.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Basilisk.class, RenderBasilisk.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Behemoth.class, RenderBehemoth.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Bunny.class, RenderBunny.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EdenCadillion.class, RenderEdenCadillion.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(WeakCori.class, RenderWeakCori.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Densos.class, RenderDensos.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Epiphite.class, RenderEpiphite.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EternalArcher.class, RenderEternalArcher.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Greenfeet.class, RenderGreenfeet.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Karot.class, RenderKarot.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Madivel.class, RenderMadivel.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Mage.class, RenderMage.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Megalith.class, RenderMegalith.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(MoonWolf.class, RenderMoonWolf.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Mystic.class, RenderMystic.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Samek.class, RenderSamek.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(SkythernFiend.class, RenderSkythernFiend.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Sorcerer.class, RenderSorcerer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(SoulFiend.class, RenderSoulFiend.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(SoulSpider.class, RenderSoulSpider.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(SoulStealer.class, RenderSoulStealer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Spellbinder.class, RenderSpellbinder.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(SunArcher.class, RenderSunArcher.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EdenTomo.class, RenderEdenTomo.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(TwilightArcher.class, RenderTwilightArcher.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(TwilightDemon.class, RenderTwilightDemon.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(ApalachiaGolem.class, RenderApalachiaGolem.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Vamacheron.class, RenderVamacheron.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EnchantedArcher.class, RenderEnchantedArcher.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(SkythernArcher.class, RenderSkythernArcher.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(ApalachiaCadillion.class, RenderApalachiaCadillion.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(MortumCadillion.class, RenderMortumCadillion.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(WildwoodCadillion.class, RenderWildwoodCadillion.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(AdvancedCori.class, RenderAdvancedCori.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(DemonOfDarkness.class, RenderDemonOfDarkness.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(SkythernGolem.class, RenderSkythernGolem.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(WildwoodGolem.class, RenderWildwoodGolem.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(ApalachiaTomo.class, RenderApalachiaTomo.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(WildwoodTomo.class, RenderWildwoodTomo.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EnchantedWarrior.class, RenderEnchantedWarrior.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Verek.class, RenderVerek.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Reyvor.class, RenderReyvor.FACTORY);

        // Vanilla
        RenderingRegistry.registerEntityRenderingHandler(JungleDramcryx.class, RenderJungleDramcryx.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(AncientEntity.class, RenderAncientEntity.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Shark.class, RenderShark.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Wildfire.class, RenderWildfire.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Rotatick.class, RenderRotatick.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(TheEye.class, RenderTheEye.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EnderTriplets.class, RenderEnderTriplets.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(TheWatcher.class, RenderTheWatcher.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(AyeracoRed.class, RenderAyerecoRed.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(AyeracoBlue.class, RenderAyeracoBlue.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(AyeracoYellow.class, RenderAyeracoYellow.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(AyeracoGreen.class, RenderAyeracoGreen.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(AyeracoPurple.class, RenderAyeracoPurple.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(AridWarrior.class, RenderAridWarrior.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Crab.class, RenderCrab.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(KingCrab.class, RenderKingCrab.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(KingOfScorchers.class, RenderKingOfScorchers.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EnthralledDramcryx.class, RenderEnthralledDramcryx.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Ehu.class, RenderEhu.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Frost.class, RenderFrost.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(CaveCrawler.class, RenderCaveCrawler.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(DesertCrawler.class, RenderDesertCrawler.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Glacon.class, RenderGlacon.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(BrownGrizzle.class, RenderBrownGrizzle.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(WhiteGrizzle.class, RenderWhiteGrizzle.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(TheGrue.class, RenderTheGrue.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(HellSpider.class, RenderHellSpider.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Husk.class, RenderHusk.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Miner.class, RenderMiner.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(JackOMan.class, RenderJackOMan.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(JungleBat.class, RenderJungleBat.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(JungleSpider.class, RenderJungleSpider.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Kobblin.class, RenderKobblin.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Liopleurodon.class, RenderLiopleurodon.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(LivestockMerchant.class, RenderLivestockMerchant.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(PumpkinSpider.class, RenderPumpkinSpider.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Rainbour.class, RenderRainbour.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Scorcher.class, RenderScorcher.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Snapper.class, RenderSnapper.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Smelter.class, RenderSmelter.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(StoneGolem.class, RenderStoneGolem.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Whale.class, RenderWhale.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EnderWatcher.class, RenderEnderWatcher.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Cyclops.class, RenderCyclops.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(Caveclops.class, RenderCaveclops.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EnderSpider.class, RenderEnderSpider.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(HellPig.class, RenderHellPig.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(SaguaroWorm.class, RenderSaguaroWorm.FACTORY);
    }
}