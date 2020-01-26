package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.config.Config;
import divinerpg.objects.entities.entity.arcana.CaptainMerik;
import divinerpg.objects.entities.entity.arcana.Datticon;
import divinerpg.objects.entities.entity.arcana.Leorna;
import divinerpg.objects.entities.entity.arcana.LordVatticus;
import divinerpg.objects.entities.entity.arcana.WarGeneral;
import divinerpg.objects.entities.entity.arcana.Zelus;
import divinerpg.objects.entities.entity.iceika.Alicanto;
import divinerpg.objects.entities.entity.iceika.Fractite;
import divinerpg.objects.entities.entity.iceika.FrostArcher;
import divinerpg.objects.entities.entity.iceika.Frosty;
import divinerpg.objects.entities.entity.iceika.Glacide;
import divinerpg.objects.entities.entity.iceika.Hastreus;
import divinerpg.objects.entities.entity.iceika.Rollum;
import divinerpg.objects.entities.entity.twilight.AdvancedCori;
import divinerpg.objects.entities.entity.twilight.ApalachiaCadillion;
import divinerpg.objects.entities.entity.twilight.ApalachiaGolem;
import divinerpg.objects.entities.entity.twilight.ApalachiaTomo;
import divinerpg.objects.entities.entity.twilight.Basilisk;
import divinerpg.objects.entities.entity.twilight.Behemoth;
import divinerpg.objects.entities.entity.twilight.Bunny;
import divinerpg.objects.entities.entity.twilight.DemonOfDarkness;
import divinerpg.objects.entities.entity.twilight.EdenCadillion;
import divinerpg.objects.entities.entity.twilight.EdenTomo;
import divinerpg.objects.entities.entity.twilight.EnchantedArcher;
import divinerpg.objects.entities.entity.twilight.EnchantedWarrior;
import divinerpg.objects.entities.entity.twilight.Epiphite;
import divinerpg.objects.entities.entity.twilight.Greenfeet;
import divinerpg.objects.entities.entity.twilight.Madivel;
import divinerpg.objects.entities.entity.twilight.Mage;
import divinerpg.objects.entities.entity.twilight.Megalith;
import divinerpg.objects.entities.entity.twilight.MoonWolf;
import divinerpg.objects.entities.entity.twilight.MortumCadillion;
import divinerpg.objects.entities.entity.twilight.Mystic;
import divinerpg.objects.entities.entity.twilight.Samek;
import divinerpg.objects.entities.entity.twilight.SkythernArcher;
import divinerpg.objects.entities.entity.twilight.SkythernFiend;
import divinerpg.objects.entities.entity.twilight.SkythernGolem;
import divinerpg.objects.entities.entity.twilight.Sorcerer;
import divinerpg.objects.entities.entity.twilight.SoulStealer;
import divinerpg.objects.entities.entity.twilight.Spellbinder;
import divinerpg.objects.entities.entity.twilight.SunArcher;
import divinerpg.objects.entities.entity.twilight.TwilightArcher;
import divinerpg.objects.entities.entity.twilight.Verek;
import divinerpg.objects.entities.entity.twilight.WeakCori;
import divinerpg.objects.entities.entity.twilight.WildwoodCadillion;
import divinerpg.objects.entities.entity.twilight.WildwoodGolem;
import divinerpg.objects.entities.entity.twilight.WildwoodTomo;
import divinerpg.objects.entities.entity.vanilla.EntityAridWarrior;
import divinerpg.objects.entities.entity.vanilla.EntityCaveCrawler;
import divinerpg.objects.entities.entity.vanilla.EntityCaveclops;
import divinerpg.objects.entities.entity.vanilla.EntityCrab;
import divinerpg.objects.entities.entity.vanilla.EntityCyclops;
import divinerpg.objects.entities.entity.vanilla.EntityDesertCrawler;
import divinerpg.objects.entities.entity.vanilla.EntityEnderSpider;
import divinerpg.objects.entities.entity.vanilla.EntityEnderTriplets;
import divinerpg.objects.entities.entity.vanilla.EntityEnderWatcher;
import divinerpg.objects.entities.entity.vanilla.EntityEnthralledDramcryx;
import divinerpg.objects.entities.entity.vanilla.EntityFrost;
import divinerpg.objects.entities.entity.vanilla.EntityGlacon;
import divinerpg.objects.entities.entity.vanilla.EntityHellPig;
import divinerpg.objects.entities.entity.vanilla.EntityHellSpider;
import divinerpg.objects.entities.entity.vanilla.EntityJackOMan;
import divinerpg.objects.entities.entity.vanilla.EntityJungleBat;
import divinerpg.objects.entities.entity.vanilla.EntityJungleDramcryx;
import divinerpg.objects.entities.entity.vanilla.EntityJungleSpider;
import divinerpg.objects.entities.entity.vanilla.EntityKingCrab;
import divinerpg.objects.entities.entity.vanilla.EntityKobblin;
import divinerpg.objects.entities.entity.vanilla.EntityLiopleurodon;
import divinerpg.objects.entities.entity.vanilla.EntityMiner;
import divinerpg.objects.entities.entity.vanilla.EntityPumpkinSpider;
import divinerpg.objects.entities.entity.vanilla.EntityRainbour;
import divinerpg.objects.entities.entity.vanilla.EntityRotatick;
import divinerpg.objects.entities.entity.vanilla.EntitySaguaroWorm;
import divinerpg.objects.entities.entity.vanilla.EntityScorcher;
import divinerpg.objects.entities.entity.vanilla.EntityShark;
import divinerpg.objects.entities.entity.vanilla.EntityTheEye;
import divinerpg.objects.entities.entity.vanilla.EntityTheGrue;
import divinerpg.objects.entities.entity.vanilla.EntityWhale;
import divinerpg.objects.entities.entity.vanilla.EntityWildfire;
import divinerpg.objects.entities.entity.vethea.*;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@Mod.EventBusSubscriber
public class ModSpawns {
    public static void init(LivingSpawnEvent event) {
        EntityLivingBase entity = event.getEntityLiving();
        if (entity.world.getGameRules().getBoolean("doMobSpawning") && entity.world.provider.getDimension() == 0
                && entity instanceof EntityWaterMob && entity.world.getDifficulty() != EnumDifficulty.PEACEFUL
                && !entity.world.isRemote
                && entity.world.getBlockState(entity.getPosition()) == Blocks.WATER.getDefaultState()
                && (entity.world.getBiome(entity.getPosition()) == Biomes.OCEAN
                        || entity.world.getBiome(entity.getPosition()) == Biomes.DEEP_OCEAN)) {

            if (entity.getRNG().nextInt(1500) == 0) {
                EntityShark shark = new EntityShark(entity.world);
                shark.copyLocationAndAnglesFrom(entity);
                entity.world.spawnEntity(shark);
                entity.setDead();

                if (Config.debug == true) {
                    DivineRPG.logger.info(shark.getName() + " just spawned at " + entity.getPosition());
                }
            } else if (entity.getRNG().nextInt(2500) == 0) {
                EntityWhale whale = new EntityWhale(entity.world);
                whale.copyLocationAndAnglesFrom(entity);
                entity.world.spawnEntity(whale);
                entity.setDead();

                if (Config.debug == true) {
                    DivineRPG.logger.info(whale.getName() + " just spawned at " + entity.getPosition());
                }
            } else if (entity.getRNG().nextInt(2500) == 0) {
                EntityLiopleurodon liopleurodon = new EntityLiopleurodon(entity.world);
                liopleurodon.copyLocationAndAnglesFrom(entity);
                entity.world.spawnEntity(liopleurodon);
                entity.setDead();

                if (Config.debug == true) {
                    DivineRPG.logger.info(liopleurodon.getName() + " just spawned at " + entity.getPosition());
                }
            }
        }
    }
    @SuppressWarnings("deprecation")	
    public static void initSpawns() {	
        for (Biome biome : ForgeRegistries.BIOMES.getValues())
            if (biome.equals(ModBiomes.Iceika)) {
                EntityRegistry.addSpawn(Alicanto.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Fractite.class, 1, 1, 1, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Glacide.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Hastreus.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(FrostArcher.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Frosty.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Rollum.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
            } else if (biome.equals(ModBiomes.Eden)) {
                EntityRegistry.addSpawn(EdenTomo.class, 20, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EdenCadillion.class, 20, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Bunny.class, 20, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EdenTomo.class, 20, 4, 4, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(EdenCadillion.class, 20, 4, 4, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(Bunny.class, 20, 4, 4, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(WeakCori.class, 1, 4, 4, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(WeakCori.class, 1, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Greenfeet.class, 20, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Madivel.class, 20, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(SunArcher.class, 6, 4, 4, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(SunArcher.class, 6, 4, 4, EnumCreatureType.MONSTER, biome);
            } else if (biome.equals(ModBiomes.WildWood)) {
                EntityRegistry.addSpawn(WildwoodCadillion.class, 4, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(WildwoodTomo.class, 4, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(WildwoodCadillion.class, 4, 4, 4, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(WildwoodTomo.class, 4, 4, 4, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(Epiphite.class, 1, 2, 2, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Epiphite.class, 1, 2, 2, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(Behemoth.class, 1, 1, 1, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Behemoth.class, 1, 1, 1, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(WildwoodGolem.class, 3, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Verek.class, 4, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Mage.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(MoonWolf.class, 4, 4, 4, EnumCreatureType.CREATURE, biome);
            } else if (biome.equals(ModBiomes.Apalachia)) {
                EntityRegistry.addSpawn(ApalachiaCadillion.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(ApalachiaGolem.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(ApalachiaTomo.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EnchantedWarrior.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EnchantedArcher.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Spellbinder.class, 1, 4, 4, EnumCreatureType.MONSTER, biome);
            } else if (biome.equals(ModBiomes.Skythern)) {
                EntityRegistry.addSpawn(SkythernFiend.class, 4, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(SkythernGolem.class, 4, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(SkythernArcher.class, 4, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Samek.class, 4, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(AdvancedCori.class, 1, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Mystic.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Megalith.class, 1, 4, 4, EnumCreatureType.MONSTER, biome);
            } else if (biome.equals(ModBiomes.Mortum)) {
                EntityRegistry.addSpawn(DemonOfDarkness.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Basilisk.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(SoulStealer.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(MortumCadillion.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(TwilightArcher.class, 2, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(Sorcerer.class, 1, 4, 4, EnumCreatureType.MONSTER, biome);
            } else if (biome.equals(ModBiomes.Arcana)) {
                EntityRegistry.addSpawn(Leorna.class, 1, 1, 1, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(Datticon.class, 1, 1, 1, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(Zelus.class, 1, 1, 1, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(LordVatticus.class, 1, 1, 1, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(CaptainMerik.class, 1, 1, 1, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(WarGeneral.class, 1, 1, 1, EnumCreatureType.CREATURE, biome);
            } else if (biome.equals(ModBiomes.Vethea)) {
                EntityRegistry.addSpawn(EntityAcidHag.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityBiphron.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityBohemite.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityCymesoid.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                //EntityRegistry.addSpawn(Dissiment.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityDreamwrecker.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityDuo.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityGalroid.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityGorgosion.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityHelio.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                //EntityRegistry.addSpawn(Herbomancer.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityHoverStinger.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityLheiva.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityLorga.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityLorgaflight.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                //EntityRegistry.addSpawn(Mandragora.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityMysteriousManLayer1.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityMysteriousManLayer2.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityMysteriousManLayer3.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
            } else if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.END)) {
                EntityRegistry.addSpawn(EntityEnderSpider.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityEnderTriplets.class, 1, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityEnderWatcher.class, 10, 4, 4, EnumCreatureType.MONSTER, biome);
            } else if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.NETHER)) {
                // EntityRegistry.addSpawn(EntityHellBat.class, 50, 1, 1, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityHellPig.class, 25, 5, 50, EnumCreatureType.CREATURE, biome);
                EntityRegistry.addSpawn(EntityHellSpider.class, 50, 1, 1, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityScorcher.class, 7, 4, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityWildfire.class, 50, 1, 1, EnumCreatureType.MONSTER, biome);
            } else if (!(BiomeDictionary.hasType(biome, BiomeDictionary.Type.MUSHROOM))) {
                // All Overworld Biomes
                EntityRegistry.addSpawn(EntityMiner.class, 5, 1, 1, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityJackOMan.class, 5, 1, 1, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityCaveCrawler.class, 70, 2, 3, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityRotatick.class, 70, 3, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityEnthralledDramcryx.class, 70, 3, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityTheEye.class, 30, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityTheGrue.class, 30, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityCaveclops.class, 70, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityEnderSpider.class, 4, 1, 4, EnumCreatureType.MONSTER, biome);
                EntityRegistry.addSpawn(EntityRainbour.class, 1, 1, 1, EnumCreatureType.AMBIENT, biome);

                if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SNOWY)) {
                    EntityRegistry.addSpawn(EntityGlacon.class, 30, 1, 1, EnumCreatureType.MONSTER, biome);
                    EntityRegistry.addSpawn(EntityGlacon.class, 30, 1, 1, EnumCreatureType.CREATURE, biome);
                    EntityRegistry.addSpawn(EntityFrost.class, 50, 1, 4, EnumCreatureType.MONSTER, biome);
                }
                if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SANDY)) {
                    EntityRegistry.addSpawn(EntityDesertCrawler.class, 50, 1, 4, EnumCreatureType.MONSTER, biome);
                    EntityRegistry.addSpawn(EntityAridWarrior.class, 35, 1, 4, EnumCreatureType.MONSTER, biome);
                    EntityRegistry.addSpawn(EntitySaguaroWorm.class, 20, 1, 4, EnumCreatureType.MONSTER, biome);
                }
                if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.BEACH)) {
                    EntityRegistry.addSpawn(EntityCrab.class, 100, 4, 4, EnumCreatureType.MONSTER, biome);
                    EntityRegistry.addSpawn(EntityKingCrab.class, 40, 4, 4, EnumCreatureType.MONSTER, biome);
                }
                if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.JUNGLE)) {
                    EntityRegistry.addSpawn(EntityJungleBat.class, 50, 1, 4, EnumCreatureType.MONSTER, biome);
                    EntityRegistry.addSpawn(EntityJungleDramcryx.class, 80, 1, 4, EnumCreatureType.MONSTER, biome);
                    EntityRegistry.addSpawn(EntityJungleSpider.class, 80, 1, 4, EnumCreatureType.MONSTER, biome);
                }
                if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLAINS)) {
                    EntityRegistry.addSpawn(EntityKobblin.class, 5, 1, 1, EnumCreatureType.MONSTER, biome);
                }
                if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLAINS)
                        || BiomeDictionary.hasType(biome, BiomeDictionary.Type.MOUNTAIN)) {
                    EntityRegistry.addSpawn(EntityCyclops.class, 10, 2, 4, EnumCreatureType.MONSTER, biome);
                }
                if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.FOREST)) {
                    EntityRegistry.addSpawn(EntityPumpkinSpider.class, 20, 1, 1, EnumCreatureType.MONSTER, biome);
                }
            }
    }
    @SubscribeEvent
    public static void onLivingSpawn(LivingSpawnEvent event) {
        ModSpawns.init(event);
    }

}