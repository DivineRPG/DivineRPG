package divinerpg.events;

import divinerpg.*;
import divinerpg.entities.apalachia.*;
import divinerpg.entities.eden.*;
import divinerpg.entities.iceika.*;
import divinerpg.entities.mortum.*;
import divinerpg.entities.skythern.*;
import divinerpg.entities.vanilla.end.*;
import divinerpg.entities.vanilla.nether.*;
import divinerpg.entities.vanilla.overworld.*;
import divinerpg.entities.vethea.*;
import divinerpg.entities.wildwood.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.event.lifecycle.*;

import java.util.*;

import static divinerpg.registries.EntityRegistry.*;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpawnEvents {
    @SubscribeEvent
    public static void registerEntitySpawnPlacements(FMLCommonSetupEvent event) {
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
        EntitySpawnPlacementRegistry.register(JACK_O_MAN, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityJackOMan::canSpawnOn);
        EntitySpawnPlacementRegistry.register(JUNGLE_BAT, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityJungleBat::canSpawnOn);
        EntitySpawnPlacementRegistry.register(JUNGLE_DRAMCRYX, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityJungleDramcryx::canSpawnOn);
        EntitySpawnPlacementRegistry.register(JUNGLE_SPIDER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityJungleSpider::canSpawnOn);
        EntitySpawnPlacementRegistry.register(KING_CRAB, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityKingCrab::canSpawnOn);
        EntitySpawnPlacementRegistry.register(KOBBLIN, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityKobblin::canSpawnOn);
        EntitySpawnPlacementRegistry.register(LIOPLEURODON, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityLiopleurodon::canSpawnOn);
        EntitySpawnPlacementRegistry.register(LIVESTOCK_MERCHANT, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityLivestockMerchant::canSpawnOn);
        EntitySpawnPlacementRegistry.register(MINER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityMiner::canSpawnOn);
        EntitySpawnPlacementRegistry.register(PUMPKIN_SPIDER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityPumpkinSpider::canSpawnOn);
        EntitySpawnPlacementRegistry.register(RAINBOUR, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityRainbour::canSpawnOn);
        EntitySpawnPlacementRegistry.register(ROTATICK, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityRotatick::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SAGUARO_WORM, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySaguaroWorm::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SHARK, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityShark::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SMELTER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySmelter::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SNAPPER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySnapper::canSpawnOn);
        EntitySpawnPlacementRegistry.register(STONE_GOLEM, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityStoneGolem::canSpawnOn);
        EntitySpawnPlacementRegistry.register(THE_EYE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityTheEye::canSpawnOn);
        EntitySpawnPlacementRegistry.register(THE_GRUE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityTheGrue::canSpawnOn);
        EntitySpawnPlacementRegistry.register(WHALE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityWhale::canSpawnOn);
        EntitySpawnPlacementRegistry.register(WHITE_GRIZZLE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityWhiteGrizzle::canSpawnOn);

        //Nether
        EntitySpawnPlacementRegistry.register(HELL_BAT, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityHellBat::canSpawnOn);
        EntitySpawnPlacementRegistry.register(HELL_PIG, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityHellPig::canSpawnOn);
        EntitySpawnPlacementRegistry.register(HELL_SPIDER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityHellSpider::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SCORCHER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityScorcher::canSpawnOn);
        EntitySpawnPlacementRegistry.register(WILDFIRE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityWildfire::canSpawnOn);

        //End
        EntitySpawnPlacementRegistry.register(ENDER_SPIDER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityEnderSpider::canSpawnOn);
        EntitySpawnPlacementRegistry.register(ENDER_TRIPLETS, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityEnderTriplets::canSpawnOn);
        EntitySpawnPlacementRegistry.register(ENDER_WATCHER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityEnderWatcher::canSpawnOn);

        //Iceika
        EntitySpawnPlacementRegistry.register(ALICANTO, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityAlicanto::canSpawnOn);
        EntitySpawnPlacementRegistry.register(FRACTITE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityFractite::canSpawnOn);
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
        EntitySpawnPlacementRegistry.register(EPIPHITE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityEpiphite::canSpawnOn);
        EntitySpawnPlacementRegistry.register(MAGE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityMage::canSpawnOn);
        EntitySpawnPlacementRegistry.register(MOON_WOLF, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityMoonWolf::canSpawnOn);
        EntitySpawnPlacementRegistry.register(TERMID, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityTermid::canSpawnOn);
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
        EntitySpawnPlacementRegistry.register(ADVANCED_CORI, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityAdvancedCori::canSpawnOn);
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
        EntitySpawnPlacementRegistry.register(CAPTAIN_MERIK, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::arcanaSpawn);
        EntitySpawnPlacementRegistry.register(DATTICON, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::arcanaSpawn);
        EntitySpawnPlacementRegistry.register(DEATHCRYX, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::arcanaSpawn);
        EntitySpawnPlacementRegistry.register(DEATH_HOUND, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::arcanaSpawn);
        EntitySpawnPlacementRegistry.register(DUNGEON_CONSTRUCTOR, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::arcanaSpawn);
        EntitySpawnPlacementRegistry.register(DUNGEON_DEMON, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::arcanaSpawn);
        EntitySpawnPlacementRegistry.register(DUNGEON_PRISONER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::arcanaSpawn);
        EntitySpawnPlacementRegistry.register(FYRACRYX, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::arcanaSpawn);
        EntitySpawnPlacementRegistry.register(GOLEM_OF_REJUVENATION, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::arcanaSpawn);
        EntitySpawnPlacementRegistry.register(KAZARI, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::arcanaSpawn);
        EntitySpawnPlacementRegistry.register(LEORNA, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::arcanaSpawn);
        EntitySpawnPlacementRegistry.register(LORD_VATTICUS, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::arcanaSpawn);
        EntitySpawnPlacementRegistry.register(LIVING_STATUE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::arcanaSpawn);
        EntitySpawnPlacementRegistry.register(PARATIKU, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::arcanaSpawn);
        EntitySpawnPlacementRegistry.register(RAZORBACK, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::arcanaSpawn);
        EntitySpawnPlacementRegistry.register(ROAMER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::arcanaSpawn);
        EntitySpawnPlacementRegistry.register(SEIMER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::arcanaSpawn);
        EntitySpawnPlacementRegistry.register(WAR_GENERAL, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::arcanaSpawn);
        EntitySpawnPlacementRegistry.register(WRAITH, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::arcanaSpawn);
        EntitySpawnPlacementRegistry.register(ZELUS, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::arcanaSpawn);

        //Vethea
        EntitySpawnPlacementRegistry.register(ACID_HAG, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer1);
        EntitySpawnPlacementRegistry.register(BIPHRON, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer2);
        EntitySpawnPlacementRegistry.register(BOHEMITE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer3);
        EntitySpawnPlacementRegistry.register(CRYPT_KEEPER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityCryptKeeper::canSpawnOn);
        EntitySpawnPlacementRegistry.register(CYMESOID, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer1);
        EntitySpawnPlacementRegistry.register(DISSIMENT, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer4);
        EntitySpawnPlacementRegistry.register(DREAMWRECKER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer1);
        EntitySpawnPlacementRegistry.register(DUO, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer1);
        EntitySpawnPlacementRegistry.register(ENT, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityEnt::canSpawnOn);
        EntitySpawnPlacementRegistry.register(FAKE_VHRAAK, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityFakeVhraak::canSpawnOn);
        EntitySpawnPlacementRegistry.register(GALROID, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer3);
        EntitySpawnPlacementRegistry.register(GORGOSION, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer2);
        EntitySpawnPlacementRegistry.register(HELIO, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer4);
        EntitySpawnPlacementRegistry.register(HIVE_SOLDIER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityHiveSoldier::canSpawnOn);
        EntitySpawnPlacementRegistry.register(HOVER_STINGER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityHoverStinger::canSpawnOn);
        EntitySpawnPlacementRegistry.register(KAZROTIC, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer3);
        EntitySpawnPlacementRegistry.register(LHEIVA, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer3);
        EntitySpawnPlacementRegistry.register(LORGA, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer1);
        EntitySpawnPlacementRegistry.register(LORGA_FLIGHT, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer3);
        EntitySpawnPlacementRegistry.register(MANDRAGORA, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer2);
        EntitySpawnPlacementRegistry.register(MYSTERIOUS_MAN_LAYER1, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer1);
        EntitySpawnPlacementRegistry.register(MYSTERIOUS_MAN_LAYER2, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer2);
        EntitySpawnPlacementRegistry.register(MYSTERIOUS_MAN_LAYER3, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer3);
        EntitySpawnPlacementRegistry.register(SHADAHIER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer1);
        EntitySpawnPlacementRegistry.register(TEMPLE_GUARDIAN, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityTempleGuardian::canSpawnOn);
        EntitySpawnPlacementRegistry.register(THE_HUNGER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityTheHunger::canSpawnOn);
        EntitySpawnPlacementRegistry.register(TOCAXIN, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer3);
        EntitySpawnPlacementRegistry.register(TWINS, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer2);
        EntitySpawnPlacementRegistry.register(VERMENOUS, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer3);
        EntitySpawnPlacementRegistry.register(VHRAAK, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer4);
        EntitySpawnPlacementRegistry.register(ZONE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer4);
        EntitySpawnPlacementRegistry.register(ZORAGON, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnEvents::vetheaLayer4);

    }

    public static boolean arcanaSpawn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return !worldIn.getBlockState(pos.below()).is(Blocks.BEDROCK);
    }
    public static boolean vetheaLayer1(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || !worldIn.getBlockState(pos.below()).is(Blocks.BEDROCK) && pos.getY() > 18 && pos.getY() < 36;
    }
    public static boolean vetheaLayer2(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || !worldIn.getBlockState(pos.below()).is(Blocks.BEDROCK) && pos.getY() > 65 && pos.getY() < 85;
    }
    public static boolean vetheaLayer3(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || !worldIn.getBlockState(pos.below()).is(Blocks.BEDROCK) && pos.getY() > 113 && pos.getY() < 133;
    }
    public static boolean vetheaLayer4(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || !worldIn.getBlockState(pos.below()).is(Blocks.BEDROCK) && pos.getY() > 160;
    }
}
