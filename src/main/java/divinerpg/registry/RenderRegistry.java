package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.arcana.*;
import divinerpg.objects.entities.assets.model.iceika.*;
import divinerpg.objects.entities.assets.model.twilight.*;
import divinerpg.objects.entities.assets.model.vanilla.*;
import divinerpg.objects.entities.assets.model.vethea.*;
import divinerpg.objects.entities.assets.render.*;
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
        registerRender(EntityAttractor.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/blank.png")));
        registerRender(EntityBouncingProjectile.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/bouncing_projectile.png")));
        registerRender(EntityCaveRock.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/cave_rock.png")));
        registerRender(EntityCoriShot.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/cori_shot.png")));
        registerRender(EntityCorruptedBullet.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/corrupted_bullet.png")));
        registerRender(EntityDisk.class, RenderDisk::new);
        registerRender(EntityDissimentShot.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/dissiment_shot.png")));
        registerRender(EntityDivineArrow.class, RenderDivineArrow::new);
        registerRender(EntityEnderTripletsFireball.class, manager -> new RenderDivineFireball(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/ender_triplets_fireball.png")));
        registerRender(EntityFirefly.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/firefly.png")));
        registerRender(EntityFractiteShot.class, manager -> new RenderDivineFireball(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/fractite_shot.png")));
        registerRender(EntityFrostShot.class, manager -> new RenderDivineFireball(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/frost_shot.png")));
        registerRender(EntityFyracryxFireball.class, manager -> new RenderDivineFireball(manager, new ResourceLocation("minecraft:textures/items/fireball.png")));
        registerRender(EntityGeneralsStaff.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/generals_staff.png")));
        registerRender(EntityGrenade.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/items/grenade.png")));
        registerRender(EntityKazroticShot.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/kazrotic_shot.png")));
        registerRender(EntityKingOfScorchersMeteor.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/king_of_scorchers_meteor.png")));
        registerRender(EntityKingOfScorchersShot.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/king_of_scorchers_shot.png")));
        registerRender(EntityLadyLunaSparkler.class, RenderShooterBullet::new);
        registerRender(EntityLamona.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/items/lamona.png")));
        registerRender(EntityMandragoraProjectile.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/mandragora_projectile.png")));
        registerRender(EntityMerikMissile.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/meriks_missile.png")));
        registerRender(EntityMeteor.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/meteor.png")));
        registerRender(EntityRaglokBomb.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/raglok_bomb.png")));
        registerRender(EntityReflector.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/blank.png")));
        registerRender(EntitySaguaroWormShot.class, RenderSaguaroWormShot::new);
        registerRender(EntityScorcherShot.class, manager -> new RenderDivineFireball(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/scorcher_shot.png")));
        registerRender(EntitySerenadeOfDeath.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/serenade_of_death.png")));
        registerRender(EntitySerenadeOfIce.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/blank.png")));
        registerRender(EntityShooterBullet.class, RenderShooterBullet::new);
        registerRender(EntitySnowflakeShuriken.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/items/snowflake_shuriken.png")));
        registerRender(EntitySoundOfCarols.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/music.png")));
        registerRender(EntitySoundOfMusic.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/music.png")));
        registerRender(EntitySparkler.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/sparkler.png")));
        registerRender(EntityStar.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/starlight.png")));
        registerRender(EntityVileStorm.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/items/vile_storm.png")));
        registerRender(EntityWatcherShot.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/watcher_shot.png")));
        registerRender(EntityWreckBouncingProjectile.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/wreck_bouncing_projectile.png")));
        registerRender(EntityWreckExplosiveShot.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/wreck_explosive_shot.png")));
        registerRender(EntityWreckShot.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/wreck_shot.png")));
        registerRender(EntityZoragonBomb.class, manager -> new RenderDivineThrowable(manager, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/zoragon_bomb.png")));
        registerRender(EntityWildwoodLog.class, manager -> new RenderWildwoodLog(manager, 1F));
        registerRender(EntityFrostCloud.class, manager -> new RenderFrostCloud(manager));

        // Vanilla
        registerRender(EntityAncientEntity.class, manager -> new RenderDivineMob(manager, new ModelAncientEntity(), 5F, new ResourceLocation(DivineRPG.MODID, "textures/entity/ancient_entity.png")));
        registerRender(EntityAridWarrior.class, manager -> new RenderAridWarrior(manager));
        registerRender(EntityAyeracoBlue.class, manager -> new RenderAyeraco(manager, "blue"));
        registerRender(EntityAyeracoGreen.class, manager -> new RenderAyeraco(manager, "green"));
        registerRender(EntityAyeracoPurple.class, manager -> new RenderAyeraco(manager, "purple"));
        registerRender(EntityAyeracoRed.class, manager -> new RenderAyeraco(manager, "red"));
        registerRender(EntityAyeracoYellow.class, manager -> new RenderAyeraco(manager, "yellow"));
        registerRender(EntityBrownGrizzle.class, manager -> new RenderDivinePet(manager, new ModelGrizzle(), new ResourceLocation(DivineRPG.MODID, "textures/entity/brown_grizzle.png")));
        registerRender(EntityCaveclops.class, manager -> new RenderDivineMob(manager, new ModelCyclops(), new ResourceLocation(DivineRPG.MODID, "textures/entity/caveclops.png")));
        registerRender(EntityCaveCrawler.class, manager -> new RenderDivineMob(manager, new ModelCrawler(), new ResourceLocation(DivineRPG.MODID, "textures/entity/cave_crawler.png")));
        registerRender(EntityCrab.class, manager -> new RenderDivineMob(manager, new ModelCrab(), new ResourceLocation(DivineRPG.MODID, "textures/entity/crab.png")));
        registerRender(EntityCyclops.class, manager -> new RenderCyclops(manager));
        registerRender(EntityDesertCrawler.class, manager -> new RenderDivineMob(manager, new ModelCrawler(), new ResourceLocation(DivineRPG.MODID, "textures/entity/desert_crawler.png")));
        registerRender(EntityEhu.class, manager -> new RenderDivinePet(manager, new ModelEhu(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ehu.png")));
        registerRender(EntityEnderSpider.class, manager -> new RenderEnderSpider(manager));
        registerRender(EntityEnderTriplets.class, manager -> new RenderDivineFlyingMob(manager, new ModelEnderTriplets(), new ResourceLocation(DivineRPG.MODID, "textures/entity/ender_triplets.png")));
        registerRender(EntityEnderWatcher.class, manager -> new RenderEnderWatcher(manager));
        registerRender(EntityEnthralledDramcryx.class, manager -> new RenderDivineMob(manager, new ModelEnthralledDramcryx(), new ResourceLocation(DivineRPG.MODID, "textures/entity/enthralled_dramcryx.png")));
        registerRender(EntityFrost.class, manager -> new RenderDivineMob(manager, new ModelFrost(), new ResourceLocation(DivineRPG.MODID, "textures/entity/frost.png")));
        registerRender(EntityGlacon.class, manager -> new RenderDivineMob(manager, new ModelGlacon(), new ResourceLocation(DivineRPG.MODID, "textures/entity/glacon.png")));
        registerRender(EntityHellPig.class, manager -> new RenderHellPig(manager));
        registerRender(EntityHellSpider.class, manager -> new RenderDivineMob(manager, new ModelHellSpider(), new ResourceLocation(DivineRPG.MODID, "textures/entity/hell_spider.png")));
        registerRender(EntityHusk.class, manager -> new RenderDivinePet(manager, new ModelHusk(), new ResourceLocation(DivineRPG.MODID, "textures/entity/husk.png")));
        registerRender(EntityJackOMan.class, manager -> new RenderJackOMan(manager));
        registerRender(EntityJungleBat.class, manager -> new RenderDivineMob(manager, new ModelJungleBat(), new ResourceLocation(DivineRPG.MODID, "textures/entity/jungle_bat.png")));
        registerRender(EntityJungleDramcryx.class, manager -> new RenderDivineMob(manager, new ModelDramcryx(), new ResourceLocation(DivineRPG.MODID, "textures/entity/jungle_dramcryx.png")));
        registerRender(EntityJungleSpider.class, manager -> new RenderDivineMob(manager, new ModelJungleSpider(), new ResourceLocation(DivineRPG.MODID, "textures/entity/jungle_spider.png")));
        registerRender(EntityKingCrab.class, manager -> new RenderDivineMob(manager, new ModelKingCrab(), new ResourceLocation(DivineRPG.MODID, "textures/entity/crab.png")));
        registerRender(EntityKingOfScorchers.class, manager -> new RenderDivineMob(manager, new ModelKingScorcher(), new ResourceLocation(DivineRPG.MODID, "textures/entity/king_of_scorchers.png")));
        registerRender(EntityKobblin.class, manager -> new RenderDivineMob(manager, new ModelKobblin(), new ResourceLocation(DivineRPG.MODID, "textures/entity/kobblin.png")));
        registerRender(EntityLiopleurodon.class, manager -> new RenderDivineMob(manager, new ModelLiopleurodon(), new ResourceLocation(DivineRPG.MODID, "textures/entity/liopleurodon.png")));
        registerRender(EntityLivestockMerchant.class, manager -> new RenderDivineVillager(manager, new ModelLivestockMerchant(), new ResourceLocation(DivineRPG.MODID, "textures/entity/livestock_merchant.png")));
        registerRender(EntityMiner.class, manager -> new RenderMiner(manager));
        registerRender(EntityPumpkinSpider.class, manager -> new RenderDivineMob(manager, new ModelPumpkinSpider(), new ResourceLocation(DivineRPG.MODID, "textures/entity/pumpkin_spider.png")));
        registerRender(EntityRainbour.class, manager -> new RenderRainbour(manager));
        registerRender(EntityRotatick.class, manager -> new RenderDivineMob(manager, new ModelRotatick(), new ResourceLocation(DivineRPG.MODID, "textures/entity/rotatick.png")));
        registerRender(EntitySaguaroWorm.class, manager -> new RenderDivineMob(manager, new ModelSaguaroWorm(), new ResourceLocation(DivineRPG.MODID, "textures/entity/saguaro_worm.png")));
        registerRender(EntityScorcher.class, manager -> new RenderDivineMob(manager, new ModelScorcher(), new ResourceLocation(DivineRPG.MODID, "textures/entity/scorcher.png")));
        registerRender(EntityShark.class, manager -> new RenderDivineMob(manager, new ModelShark(), new ResourceLocation(DivineRPG.MODID, "textures/entity/shark.png")));
        registerRender(EntitySmelter.class, manager -> new RenderDivinePet(manager, new ModelStoneGolem(), new ResourceLocation(DivineRPG.MODID, "textures/entity/smelter.png")));
        registerRender(EntitySnapper.class, manager -> new RenderDivinePet(manager, new ModelSnapper(), new ResourceLocation(DivineRPG.MODID, "textures/entity/snapper.png")));
        registerRender(EntityStoneGolem.class, manager -> new RenderDivinePet(manager, new ModelStoneGolem(), new ResourceLocation(DivineRPG.MODID, "textures/entity/stone_golem.png")));
        registerRender(EntityTheEye.class, manager -> new RenderDivineMob(manager, new ModelTheEye(), new ResourceLocation(DivineRPG.MODID, "textures/entity/the_eye.png")));
        registerRender(EntityTheGrue.class, manager -> new RenderDivineMob(manager, new ModelTheGrue(), new ResourceLocation(DivineRPG.MODID, "textures/entity/the_grue.png")));
        registerRender(EntityTheWatcher.class, manager -> new RenderDivineMob(manager, new ModelTheWatcher(), 3F, new ResourceLocation(DivineRPG.MODID, "textures/entity/the_watcher.png")));
        registerRender(EntityWhale.class, manager -> new RenderDivineMob(manager, new ModelWhale(), new ResourceLocation(DivineRPG.MODID, "textures/entity/whale.png")));
        registerRender(EntityWhiteGrizzle.class, manager -> new RenderDivinePet(manager, new ModelGrizzle(), new ResourceLocation(DivineRPG.MODID, "textures/entity/white_grizzle.png")));
        registerRender(EntityWildfire.class, manager -> new RenderWildfire(manager));

        // Iceika
        registerRender(EntityAlicanto.class, manager -> new RenderDivineMob(manager, new ModelAlicanto(), new ResourceLocation(DivineRPG.MODID, "textures/entity/alicanto.png")));
        registerRender(EntityFractite.class, manager -> new RenderDivineFlyingMob(manager, new ModelFractite(), new ResourceLocation(DivineRPG.MODID, "textures/entity/fractite.png")));
        registerRender(EntityFrostArcher.class, manager -> new RenderFrostArcher(manager));
        registerRender(EntityFrosty.class, manager -> new RenderFrosty(manager));
        registerRender(EntityGlacide.class, manager -> new RenderDivineMob(manager, new ModelGlacide(), new ResourceLocation(DivineRPG.MODID, "textures/entity/glacon.png")));
        registerRender(EntityHastreus.class, manager -> new RenderDivineMob(manager, new ModelHastreus(), new ResourceLocation(DivineRPG.MODID, "textures/entity/hastreus.png")));
        registerRender(EntityRollum.class, manager -> new RenderDivineMob(manager, new ModelRollum(), new ResourceLocation(DivineRPG.MODID, "textures/entity/rollum.png")));
        registerRender(EntityWorkshopMerchant.class, manager -> new RenderDivineVillager(manager, new ModelWorkshop(), new ResourceLocation(DivineRPG.MODID, "textures/entity/workshop_merchant.png")));
        registerRender(EntityWorkshopTinkerer.class, manager -> new RenderDivineVillager(manager, new ModelWorkshop(), new ResourceLocation(DivineRPG.MODID, "textures/entity/workshop_tinkerer.png")));


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
        registerRender(EntityMadivel.class, manager -> new RenderDivineMob(manager, new ModelMadivel(), new ResourceLocation(DivineRPG.MODID, "textures/entity/madivel.png")));
        registerRender(EntityMage.class, manager -> new RenderDivineMob(manager, new ModelMage(), new ResourceLocation(DivineRPG.MODID, "textures/entity/mage.png")));
        registerRender(EntityMegalith.class, manager -> new RenderDivineMob(manager, new ModelMegalith(), new ResourceLocation(DivineRPG.MODID, "textures/entity/megalith.png")));
        registerRender(EntityMoonWolf.class, manager -> new RenderDivinePet(manager, new ModelMoonWolf(), new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf.png")));
        registerRender(EntityMortumCadillion.class, manager -> new RenderDivineMob(manager, new ModelCadillion(), new ResourceLocation(DivineRPG.MODID, "textures/entity/mortum_cadillion.png")));
        registerRender(EntityMystic.class, manager -> new RenderDivineMob(manager, new ModelMystic(), new ResourceLocation(DivineRPG.MODID, "textures/entity/mystic.png")));
        registerRender(EntityReyvor.class, manager -> new RenderReyvor(manager));
        registerRender(EntitySamek.class, manager -> new RenderDivineMob(manager, new ModelSamek(), new ResourceLocation(DivineRPG.MODID, "textures/entity/samek.png")));
        registerRender(EntitySkythernArcher.class, manager -> new RenderSkythernArcher(manager));
        registerRender(EntitySkythernFiend.class, manager -> new RenderDivineMob(manager, new ModelSkythernFiend(), new ResourceLocation(DivineRPG.MODID, "textures/entity/skythern_fiend.png")));
        registerRender(EntitySkythernGolem.class, manager -> new RenderDivineMob(manager, new ModelTwilightGolem(), new ResourceLocation(DivineRPG.MODID, "textures/entity/skythern_golem.png")));
        registerRender(EntitySorcerer.class, manager -> new RenderDivineMob(manager, new ModelSorcerer(), new ResourceLocation(DivineRPG.MODID, "textures/entity/sorcerer.png")));
        registerRender(EntitySoulFiend.class, manager -> new RenderDivineMob(manager, new ModelSoulFiend(), new ResourceLocation(DivineRPG.MODID, "textures/entity/soul_fiend.png")));
        registerRender(EntitySoulSpider.class, manager -> new RenderDivineMob(manager, new ModelSoulSpider(), new ResourceLocation(DivineRPG.MODID, "textures/entity/soul_spider.png")));
        registerRender(EntitySoulStealer.class, manager -> new RenderDivineMob(manager, new ModelSoulStealer(), new ResourceLocation(DivineRPG.MODID, "textures/entity/soul_stealer.png")));
        registerRender(EntitySpellbinder.class, manager -> new RenderDivineMob(manager, new ModelMystic(), new ResourceLocation(DivineRPG.MODID, "textures/entity/spellbinder.png")));
        registerRender(EntitySunArcher.class, manager -> new RenderSunArcher(manager));
        registerRender(EntitySunstorm.class, manager -> new RenderDivineMob(manager, new ModelSunstorm(), new ResourceLocation(DivineRPG.MODID, "textures/entity/sunstorm.png")));
        registerRender(EntityTermasect.class, manager -> new RenderDivineMob(manager, new ModelTermasect(), 5F, new ResourceLocation(DivineRPG.MODID, "textures/entity/termasect.png")));
        registerRender(EntityTermid.class, manager -> new RenderDivineMob(manager, new ModelTermid(), new ResourceLocation(DivineRPG.MODID, "textures/entity/termid.png")));
        registerRender(EntityTwilightArcher.class, manager -> new RenderTwilightArcher(manager));
        registerRender(EntityTwilightDemon.class, manager -> new RenderDivineMob(manager, new ModelTwilightDemon(), 2F, new ResourceLocation(DivineRPG.MODID, "textures/entity/twilight_demon.png")));
        registerRender(EntityVamacheron.class, manager -> new RenderDivineMob(manager, new ModelVamacheron(), 1.5F, new ResourceLocation(DivineRPG.MODID, "textures/entity/vamacheron.png")));
        registerRender(EntityVerek.class, manager -> new RenderDivineMob(manager, new ModelSamek(), new ResourceLocation(DivineRPG.MODID, "textures/entity/verek.png")));
        registerRender(EntityWeakCori.class, manager -> new RenderDivineFlyingMob(manager, new ModelCori(), new ResourceLocation(DivineRPG.MODID, "textures/entity/weak_cori.png")));
        registerRender(EntityWildwoodCadillion.class, manager -> new RenderDivineMob(manager, new ModelCadillion(), new ResourceLocation(DivineRPG.MODID, "textures/entity/wildwood_cadillion.png")));
        registerRender(EntityWildwoodGolem.class, manager -> new RenderDivineMob(manager, new ModelTwilightGolem(), new ResourceLocation(DivineRPG.MODID, "textures/entity/wildwood_golem.png")));
        registerRender(EntityWildwoodTomo.class, manager -> new RenderDivineMob(manager, new ModelTomo(), new ResourceLocation(DivineRPG.MODID, "textures/entity/wildwood_tomo.png")));

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
