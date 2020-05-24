package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.arcana.*;
import divinerpg.objects.entities.assets.model.twilight.*;
import divinerpg.objects.entities.assets.model.vethea.*;
import divinerpg.objects.entities.assets.render.RenderDivineFlyingMob;
import divinerpg.objects.entities.assets.render.RenderDivineMob;
import divinerpg.objects.entities.assets.render.RenderDivinePet;
import divinerpg.objects.entities.assets.render.RenderDivineVillager;
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
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = DivineRPG.MODID)
public class RenderRegistry {

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
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
        // Must fix, advanced cori should have a different model
        registerRender(EntityAdvancedCori.class, manager -> new RenderDivineFlyingMob(manager, new ModelCori(), new ResourceLocation(DivineRPG.MODID, "textures/entity/advanced_cori.png")));
        registerRender(EntityAngryBunny.class, manager -> new RenderDivineMob(manager, new ModelAngryBunny(), 2F, new ResourceLocation(DivineRPG.MODID, "textures/entity/angry_bunny.png")));
        registerRender(EntityApalachiaCadillion.class, manager -> new RenderDivineMob(manager, new ModelCadillion(), new ResourceLocation(DivineRPG.MODID, "textures/entity/apalachia_cadillion.png")));
        registerRender(EntityApalachiaGolem.class, manager -> new RenderDivineMob(manager, new ModelTwilightGolem(), new ResourceLocation(DivineRPG.MODID, "textures/entity/apalachia_golem.png")));
        registerRender(EntityApalachiaTomo.class, manager -> new RenderDivineMob(manager, new ModelTomo(), new ResourceLocation(DivineRPG.MODID, "textures/entity/apalachia_tomo.png")));
        registerRender(EntityBasilisk.class, manager -> new RenderDivineMob(manager, new ModelBasilisk(), new ResourceLocation(DivineRPG.MODID, "textures/entity/basilisk.png")));
        registerRender(EntityBehemoth.class, manager -> new RenderDivineMob(manager, new ModelBehemoth(), new ResourceLocation(DivineRPG.MODID, "textures/entity/behemoth.png")));
        registerRender(EntityBunny.class, manager -> new RenderBunny(manager));
        registerRender(EntityDemonOfDarkness.class, manager -> new RenderDivineMob(manager, new ModelDemonOfDarkness(), new ResourceLocation(DivineRPG.MODID, "textures/entity/demon_of_darkness.png")));
        registerRender(EntityDensos.class, manager -> new RenderDensos(manager));
        registerRender(EntityEdenCadillion.class, manager -> new RenderDivineMob(manager, new ModelCadillion(), new ResourceLocation(DivineRPG.MODID, "textures/entity/eden_cadillion.png")));
        registerRender(EntityEdenTomo.class, manager -> new RenderDivineMob(manager, new ModelTomo(), new ResourceLocation(DivineRPG.MODID, "textures/entity/eden_tomo.png")));
        registerRender(EntityEnchantedArcher.class, manager -> new RenderEnchantedArcher(manager));
        registerRender(EntityEnchantedWarrior.class, manager -> new RenderEnchantedWarrior(manager));
        registerRender(EntityEpiphite.class, manager -> new RenderDivineMob(manager, new ModelEpiphite(), 1.25F, new ResourceLocation(DivineRPG.MODID, "textures/entity/epiphite.png")));
        registerRender(EntityEternalArcher.class, manager -> new RenderEternalArcher(manager));
        registerRender(EntityExperiencedCori.class, manager -> new RenderDivineFlyingMob(manager, new ModelExperiencedCori(), 5F, new ResourceLocation(DivineRPG.MODID, "textures/entity/experienced_cori.png")));
        registerRender(EntityGreenfeet.class, manager -> new RenderDivineMob(manager, new ModelGreenfeet(), new ResourceLocation(DivineRPG.MODID, "textures/entity/greenfeet.png")));
        registerRender(EntityKarot.class, manager -> new RenderDivineMob(manager, new ModelKarot(), 5F, new ResourceLocation(DivineRPG.MODID, "textures/entity/karot.png")));
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
        registerRender(EntityCaptainMerik.class, manager -> new RenderDivineVillager(manager, new ModelSamek(), new ResourceLocation(DivineRPG.MODID, "textures/entity/captain_merik.png")));
        registerRender(EntityDatticon.class, manager -> new RenderDivineVillager(manager, new ModelSamek(), new ResourceLocation(DivineRPG.MODID, "textures/entity/datticon.png")));
        registerRender(EntityDeathcryx.class, manager -> new RenderDivineMob(manager, new ModelDeathcryx(), new ResourceLocation(DivineRPG.MODID, "textures/entity/deathcryx.png")));
        registerRender(EntityDeathHound.class, manager -> new RenderDivineMob(manager, new ModelDeathHound(), new ResourceLocation(DivineRPG.MODID, "textures/entity/death_hound.png")));
        registerRender(EntityDramix.class, manager -> new RenderDivineMob(manager, new ModelDramix(), 1.2F, new ResourceLocation(DivineRPG.MODID, "textures/entity/dramix.png")));
        registerRender(EntityDungeonConstructor.class, manager -> new RenderDivineMob(manager, new ModelDramix(), 0.4F, new ResourceLocation(DivineRPG.MODID, "textures/entity/dungeon_constructor.png")));
        registerRender(EntityDungeonDemon.class, manager -> new RenderDivineMob(manager, new ModelDungeonDemon(), new ResourceLocation(DivineRPG.MODID, "textures/entity/dungeon_demon.png")));
        registerRender(EntityDungeonPrisoner.class, manager -> new RenderDivineMob(manager, new ModelDungeonPrisoner(), new ResourceLocation(DivineRPG.MODID, "textures/entity/dungeon_prisoner.png")));
        registerRender(EntityFyracryx.class, manager -> new RenderDivinePet(manager, new ModelDeathcryx(), new ResourceLocation(DivineRPG.MODID, "textures/entity/fyracryx.png")));
        registerRender(EntityGolemOfRejuvenation.class, manager -> new RenderDivinePet(manager, new ModelRejuvGolem(), 1.5F, new ResourceLocation(DivineRPG.MODID, "textures/entity/golem_of_rejuvenation.png")));
        registerRender(EntityLeorna.class, manager -> new RenderDivineVillager(manager, new ModelLeorna(), new ResourceLocation(DivineRPG.MODID, "textures/entity/leorna.png")));
        registerRender(EntityLivingStatue.class, manager -> new RenderDivineMob(manager, new ModelBiped(), new ResourceLocation(DivineRPG.MODID, "textures/entity/living_statue.png")));
        registerRender(EntityLordVatticus.class, manager -> new RenderDivineVillager(manager, new ModelBiped(), new ResourceLocation(DivineRPG.MODID, "textures/entity/lord_vatticus.png")));
        registerRender(EntityParasecta.class, manager -> new RenderDivineMob(manager, new ModelParasecta(), 1.5F, new ResourceLocation(DivineRPG.MODID, "textures/entity/parasecta.png")));
        registerRender(EntityParatiku.class, manager -> new RenderDivinePet(manager, new ModelParatiku(), new ResourceLocation(DivineRPG.MODID, "textures/entity/paratiku.png")));
        registerRender(EntityRazorback.class, manager -> new RenderDivineMob(manager, new ModelRazorback(), new ResourceLocation(DivineRPG.MODID, "textures/entity/razorback.png")));
        registerRender(EntityRoamer.class, manager -> new RenderDivineMob(manager, new ModelRoamer(), new ResourceLocation(DivineRPG.MODID, "textures/entity/roamer.png")));
        registerRender(EntitySeimer.class, manager -> new RenderDivinePet(manager, new ModelSeimer(), new ResourceLocation(DivineRPG.MODID, "textures/entity/seimer.png")));
        registerRender(EntityWarGeneral.class, manager -> new RenderDivineVillager(manager, new ModelSamek(), new ResourceLocation(DivineRPG.MODID, "textures/entity/war_general.png")));
        registerRender(EntityWraith.class, manager -> new RenderDivinePet(manager, new ModelWraith(), new ResourceLocation(DivineRPG.MODID, "textures/entity/wraith.png")));
        registerRender(EntityZelus.class, manager -> new RenderDivineVillager(manager, new ModelBiped(), new ResourceLocation(DivineRPG.MODID, "textures/entity/zelus.png")));

        //Vethea
        registerRender(EntityAcidHag.class, manager -> new RenderDivineMob(manager, new ModelAcidHag(), new ResourceLocation(DivineRPG.MODID, "textures/entity/acid_hag.png")));
        registerRender(EntityBiphron.class, manager -> new RenderDivineMob(manager, new ModelBiphron(), new ResourceLocation(DivineRPG.MODID, "textures/entity/biphron.png")));
        registerRender(EntityBohemite.class, manager -> new RenderDivineMob(manager, new ModelBohemite(), new ResourceLocation(DivineRPG.MODID, "textures/entity/bohemite.png")));
        registerRender(EntityCryptKeeper.class, manager -> new RenderDivineMob(manager, new ModelCryptKeeper(), new ResourceLocation(DivineRPG.MODID, "textures/entity/crypt_keeper.png")));
        registerRender(EntityCymesoid.class, manager -> new RenderDivineMob(manager, new ModelCymesoid(), new ResourceLocation(DivineRPG.MODID, "textures/entity/cymesoid.png")));
        registerRender(EntityDissiment.class, manager -> new RenderDivineFlyingMob(manager, new ModelDissiment(), 3F, new ResourceLocation(DivineRPG.MODID, "textures/entity/dissiment.png")));
        registerRender(EntityDreamwrecker.class, manager -> new RenderDivineMob(manager, new ModelDreamwrecker(), new ResourceLocation(DivineRPG.MODID, "textures/entity/dreamwrecker.png")));
        registerRender(EntityDuo.class, manager -> new RenderDivineMob(manager, new ModelDuo(), new ResourceLocation(DivineRPG.MODID, "textures/entity/duo.png")));
        registerRender(EntityEnt.class, manager -> new RenderDivineMob(manager, new ModelEnt(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ent.png")));
        registerRender(EntityFakeVhraak.class, manager -> new RenderDivineMob(manager, new ModelVhraak(), new ResourceLocation(DivineRPG.MODID, "textures/entity/vhraak.png")));
        registerRender(EntityGalroid.class, manager -> new RenderGalroid(manager));
        registerRender(EntityGorgosion.class, manager -> new RenderDivineMob(manager, new ModelGorgosion(), new ResourceLocation(DivineRPG.MODID, "textures/entity/gorgosion.png")));
        registerRender(EntityHelio.class, manager -> new RenderDivineMob(manager, new ModelHelio(), new ResourceLocation(DivineRPG.MODID, "textures/entity/helio.png")));
        registerRender(EntityHiveQueen.class, manager -> new RenderDivineMob(manager, new ModelHiveQueen(), new ResourceLocation(DivineRPG.MODID, "textures/entity/hive_queen.png")));
        registerRender(EntityHiveSoldier.class, manager -> new RenderDivineMob(manager, new ModelHiveSoldier(), new ResourceLocation(DivineRPG.MODID, "textures/entity/hive_soldier.png")));
        registerRender(EntityHoverStinger.class, manager -> new RenderDivineMob(manager, new ModelHoverStinger(), new ResourceLocation(DivineRPG.MODID, "textures/entity/hover_stinger.png")));
        registerRender(EntityKaros.class, manager -> new RenderDivineMob(manager, new ModelKaros(), new ResourceLocation(DivineRPG.MODID, "textures/entity/karos.png")));
        registerRender(EntityKazrotic.class, manager -> new RenderDivineMob(manager, new ModelKazrotic(), new ResourceLocation(DivineRPG.MODID, "textures/entity/kazrotic.png")));
        registerRender(EntityLadyLuna.class, manager -> new RenderLadyLuna(manager));
        registerRender(EntityLheiva.class, manager -> new RenderDivineMob(manager, new ModelLheiva(), new ResourceLocation(DivineRPG.MODID, "textures/entity/lheiva.png")));
        registerRender(EntityLorga.class, manager -> new RenderDivineMob(manager, new ModelLorga(), new ResourceLocation(DivineRPG.MODID, "textures/entity/lorga.png")));
        registerRender(EntityLorgaflight.class, manager -> new RenderDivineMob(manager, new ModelLorgaflight(), new ResourceLocation(DivineRPG.MODID, "textures/entity/lorgaflight.png")));
        registerRender(EntityMandragora.class, manager -> new RenderDivineMob(manager, new ModelMandragora(), new ResourceLocation(DivineRPG.MODID, "textures/entity/mandragora.png")));
        registerRender(EntityMysteriousManLayer1.class, manager -> new RenderDivineMob(manager, new ModelMysteriousMan(), new ResourceLocation(DivineRPG.MODID, "textures/entity/mysterious_man_layer_1.png")));
        registerRender(EntityMysteriousManLayer2.class, manager -> new RenderDivineMob(manager, new ModelMysteriousMan(), new ResourceLocation(DivineRPG.MODID, "textures/entity/mysterious_man_layer_2.png")));
        registerRender(EntityMysteriousManLayer3.class, manager -> new RenderDivineMob(manager, new ModelMysteriousMan(), new ResourceLocation(DivineRPG.MODID, "textures/entity/mysterious_man_layer_3.png")));
        registerRender(EntityQuadro.class, manager -> new RenderDivineMob(manager, new ModelQuadro(), new ResourceLocation(DivineRPG.MODID, "textures/entity/quadro.png")));
        registerRender(EntityRaglok.class, manager -> new RenderDivineMob(manager, new ModelRaglok(), new ResourceLocation(DivineRPG.MODID, "textures/entity/raglok.png")));
        registerRender(EntityShadahier.class, manager -> new RenderDivineMob(manager, new ModelShadahier(), new ResourceLocation(DivineRPG.MODID, "textures/entity/shadahier.png")));
        registerRender(EntityTempleGuardian.class, manager -> new RenderDivineMob(manager, new ModelBiped(), new ResourceLocation(DivineRPG.MODID, "textures/entity/temple_guardian.png")));
        registerRender(EntityTheHunger.class, manager -> new RenderDivineVillager(manager, new ModelTheHunger(), new ResourceLocation(DivineRPG.MODID, "textures/entity/the_hunger.png")));
        registerRender(EntityTocaxin.class, manager -> new RenderDivineMob(manager, new ModelTocaxin(), new ResourceLocation(DivineRPG.MODID, "textures/entity/tocaxin.png")));
        registerRender(EntityTwins.class, manager -> new RenderDivineMob(manager, new ModelTwins(), new ResourceLocation(DivineRPG.MODID, "textures/entity/twins.png")));
        registerRender(EntityVermenous.class, manager -> new RenderDivineMob(manager, new ModelVermenous(), new ResourceLocation(DivineRPG.MODID, "textures/entity/vermenous.png")));
        registerRender(EntityVhraak.class, manager -> new RenderDivineMob(manager, new ModelVhraak(), new ResourceLocation(DivineRPG.MODID, "textures/entity/vhraak.png")));
        registerRender(EntityWreck.class, manager -> new RenderWreck(manager));
        registerRender(EntityZone.class, manager -> new RenderDivineMob(manager, new ModelZone(), new ResourceLocation(DivineRPG.MODID, "textures/entity/zone.png")));
        registerRender(EntityZoragon.class, manager -> new RenderDivineFlyingMob(manager, new ModelZoragon(), new ResourceLocation(DivineRPG.MODID, "textures/entity/zoragon.png")));
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
