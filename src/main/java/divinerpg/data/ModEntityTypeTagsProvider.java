package divinerpg.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.EntityRegistry.*;
import static divinerpg.registries.TagRegistry.EntityTypes.*;

public class ModEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public ModEntityTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MODID);
    }
    @SuppressWarnings("unchecked")
    @Override protected void addTags(HolderLookup.Provider registries) {
        tag(CREATURES_OVERWORLD_GENERAL).add(LIVESTOCK_MERCHANT.key(), JACK_O_MAN.key(), CYCLOPS.key(), KOBBLIN.key(), PUMPKIN_SPIDER.key());
        tag(CREATURES_OVERWORLD_JUNGLE).add(JUNGLE_BAT.key(), JUNGLE_SPIDER.key(), JUNGLE_DRAMCRYX.key());
        tag(CREATURES_OVERWORLD_DESERT).add(SAGUARO_WORM.key(), DESERT_CRAWLER.key(), ARID_WARRIOR.key());
        tag(CREATURES_OVERWORLD_SNOWY).add(FROST.key(), GLACON.key());
        tag(CREATURES_OVERWORLD_BEACH).add(CRAB.key(), KING_CRAB.key());
        tag(CREATURES_OVERWORLD_WATER).add(AEQUOREA.key(), SHARK.key(), WHALE.key(), LIOPLEURODON.key());
        tag(CREATURES_OVERWORLD_CAVE).add(DIAMOND_DAVE.key(), RAINBOUR.key(), MINER.key(), ROTATICK.key(), CAVE_CRAWLER.key(), CAVECLOPS.key(), THE_EYE.key(), ENTHRALLED_DRAMCRYX.key(), THE_GRUE.key());
        tag(CREATURES_OVERWORLD_VISITOR).add(ENDER_SPIDER.key());
        tag(CREATURES_OVERWORLD).addTags(CREATURES_OVERWORLD_GENERAL, CREATURES_OVERWORLD_CAVE, CREATURES_OVERWORLD_VISITOR, CREATURES_OVERWORLD_SNOWY, CREATURES_OVERWORLD_JUNGLE, CREATURES_OVERWORLD_DESERT, CREATURES_OVERWORLD_BEACH, CREATURES_OVERWORLD_WATER);
        tag(CREATURES_NETHER).add(HELL_PIG.key(), HELL_SPIDER.key(), WILDFIRE.key(), SCORCHER.key());
        tag(CREATURES_END).add(ENDER_SCROUNGE.key(), ENDER_SPIDER.key(), ENDER_WATCHER.key(), ENDER_TRIPLETS.key());

        tag(EntityTypeTags.FALL_DAMAGE_IMMUNE).add(JUNGLE_BAT.key(), FROST.key(), RAINBOUR.key(), SCORCHER.key(), ROBBIN.key(), SNOW_SKIPPER.key(), DOLOSSAL.key(), ALICANTO.key(), FRACTITE.key(), ENDER_TRIPLETS.key(), PARATIKU.key(), WRAITH.key(), WEAK_CORI.key(), TERMID.key(), ADVANCED_CORI.key(), BIPHRON.key(), LHEIVA.key(), LORGA_FLIGHT.key(), ZORAGON.key(), THE_WATCHER.key(), KING_OF_SCORCHERS.key(), KITRA.key(), AYERACO.key(), PARASECTA.key(), TERMASECT.key(), EXPERIENCED_CORI.key());
        tag(EntityTypeTags.POWDER_SNOW_WALKABLE_MOBS).add(WOLPERTINGER.key(), DOLOSSAL.key(), PALE_ARCHER.key(), FROZEN_FLESH.key(), GROGLIN_MERCHANT.key(), GROGLIN_SHARLATAN.key(), GROGLIN_HUNTER.key(), GROGLIN_RANGER.key(), GROGLIN_WARRIOR.key(), GROGLIN_CHIEFTAIN.key(), ROBBIN.key(), ALICANTO.key(), GLACIDE.key(), FROST.key(), FRACTITE.key(), MAMOTH.key());

        tag(EntityTypeTags.CANDIDATE_FOR_IRON_GOLEM_GIFT).add(LIVESTOCK_MERCHANT.key());

        tag(EntityTypeTags.CAN_EQUIP_SADDLE).add(DOLOSSAL.key());
        tag(EntityTypeTags.DISMOUNTS_UNDERWATER).add(DOLOSSAL.key());
        tag(EntityTypeTags.FOLLOWABLE_FRIENDLY_MOBS).add(LIVESTOCK_MERCHANT.key(), DIAMOND_DAVE.key(), SNAPPER.key(), EHU.key(), HUSK.key(), BROWN_GRIZZLE.key(), WHITE_GRIZZLE.key(), HELL_PIG.key(), BLUBBERTUSK.key(), WOLPERTINGER.key(), DOLOSSAL.key(), MAMOTH.key(), WORKSHOP_MERCHANT.key(), WORKSHOP_TINKERER.key(), CAPTAIN_MERIK.key(), DATTICON.key(), KAZARI.key(), LEORNA.key(), LORD_VATTICUS.key(), WAR_GENERAL.key(), ZELUS.key(), FYRACRYX.key(), PARATIKU.key(), SEIMER.key(), GLINTHOP.key(), MOON_WOLF.key());

        tag(EntityTypeTags.ARTHROPOD).add(ROTATICK.key(), CRAB.key(), KING_CRAB.key(), PUMPKIN_SPIDER.key(), JUNGLE_SPIDER.key(), HELL_SPIDER.key(), ENDER_SPIDER.key(), RAZORBACK.key(), BEHEMOTH.key(), SOUL_SPIDER.key());
        tag(EntityTypeTags.SKELETONS).add(PALE_ARCHER.key());
        tag(EntityTypeTags.ZOMBIES).add(MINER.key());
        tag(EntityTypeTags.UNDEAD).add(JACK_O_MAN.key(), FROZEN_FLESH.key(), KITRA.key());
        tag(EntityTypeTags.BURN_IN_DAYLIGHT).add(MINER.key(), GREENFEET.key());
        tag(EntityTypeTags.FREEZE_HURTS_EXTRA_TYPES).add(SCORCHER.key(), KING_OF_SCORCHERS.key());
        tag(EntityTypeTags.FREEZE_IMMUNE_ENTITY_TYPES).add(BLUBBERTUSK.key(), SNOW_SKIPPER.key(), WOLPERTINGER.key(), DOLOSSAL.key(), MAMOTH.key(), WORKSHOP_MERCHANT.key(), WORKSHOP_TINKERER.key(), ROLLUM.key(), PALE_ARCHER.key(), FROZEN_FLESH.key(), ALICANTO.key(), SENG.key(), SABEAR.key(), HASTREUS.key(), GLACON.key(), GLACIDE.key(), FROST.key(), FRACTITE.key(), KITRA.key());

        tag(JELLYFISH).add(AEQUOREA.key());
        tag(SHARKS).add(SHARK.key());
        tag(WHALES).add(WHALE.key(), KITRA.key());
        tag(EntityTypeTags.NOT_SCARY_FOR_PUFFERFISH).addTags(JELLYFISH, SHARKS, WHALES).add(CAULDRON_FISH.key(), PINK_GHOST_GLIDER.key(), GEM_FIN.key());
        tag(EntityTypeTags.AXOLOTL_HUNT_TARGETS).addTag(JELLYFISH).add(CAULDRON_FISH.key(), PINK_GHOST_GLIDER.key(), GEM_FIN.key());
        tag(EntityTypeTags.CAN_BREATHE_UNDER_WATER).add(AEQUOREA.key(), WHALE.key(), SHARK.key(), LIOPLEURODON.key(), CAULDRON_FISH.key(), PINK_GHOST_GLIDER.key(), GEM_FIN.key());
        tag(AQUATIC).addTags(JELLYFISH, SHARKS, WHALES).add(LIOPLEURODON.key(), CAULDRON_FISH.key(), PINK_GHOST_GLIDER.key(), BLUBBERTUSK.key(), GEM_FIN.key());
        tag(EntityTypeTags.AQUATIC).addTag(AQUATIC);
        tag(EntityTypeTags.CANNOT_BE_PUSHED_ONTO_BOATS).addTag(AQUATIC);

        tag(BOSSES).add(ANCIENT_ENTITY.key(), THE_WATCHER.key(), KING_OF_SCORCHERS.key(), KITRA.key(), AYERACO.key(), DRAMIX.key(), PARASECTA.key(), SUNSTORM.key(), TERMASECT.key(), ETERNAL_ARCHER.key(), EXPERIENCED_CORI.key(), VAMACHERON.key(), KAROT.key(), TWILIGHT_DEMON.key(), DENSOS.key(), REYVOR.key(), SOUL_FIEND.key(), HIVE_QUEEN.key(), KAROS.key(), LADY_LUNA.key(), QUADRO.key(), RAGLOK.key(), WRECK.key());
        tag(Tags.EntityTypes.BOSSES).addTag(BOSSES);

        tag(ARROWS).add(HUNTER_ARROW.key(), SHADOW_ARROW.key(), ICICLE_ARROW.key(), INFERNO_ARROW.key(), SOULFIRE_ARROW.key(), SNOWSTORM_ARROW.key(), ENDER_ARROW.key(), EDEN_ARROW.key(), WILDWOOD_ARROW.key(), FURY_ARROW.key(), TEAKER_ARROW.key(), DARVEN_ARROW.key(), PARDIMAL_ARROW.key(), KAROS_ARROW.key(), EVER_ARROW.key());
        tag(EntityTypeTags.ARROWS).addTag(ARROWS);
        tag(EntityTypeTags.REDIRECTABLE_PROJECTILE).add(FYRACRYX_FIREBALL.key());
        tag(EntityTypeTags.IMPACT_PROJECTILES).addTag(PROJECTILES).remove(ICE_BULLET.key(), ATTRACTOR_BEAM.key(), REFLECTOR_BEAM.key());
        tag(PROJECTILES).add(THROWN_ITEM.key(), TOMATO.key(), SNOWFLAKE_SHURIKEN.key(), EDEN_SPARKLES.key(), VILE_STORM.key(), GRENADE.key(), ICE_BULLET.key(), DEATH_BULLET.key(), SOUND_OF_MUSIC.key(), SOUND_OF_CAROLS.key(), SOUND_OF_WHALES.key(), CRAB_ANCHOR_SHOT.key(), SHARK_ANCHOR_SHOT.key(), BOWHEAD_ANCHOR_SHOT.key(), LIOPLEURODON_ANCHOR_SHOT.key(), HOOK.key(), EYE_SHARD.key(), SCYTHE_SHOT.key(), MAELSTROM_SHOT.key(), CRAB_CLAW.key(), FROST_CLAW.key(), BOWHEAD_SHOT.key(), FROST_CANNON_SHOT.key(), FRACTITE_CANNON_SHOT.key(), CORRUPTED_BULLET.key(), GHAST_CANNON_SHOT.key(), GOLDEN_FURY_SHOT.key(), ATTRACTOR_BEAM.key(), REFLECTOR_BEAM.key(), SPARKLER_SHOT.key(), FIREFLY.key(), MERIKS_MISSILE.key(), GENERALS_SHOT.key(), STAR.key(), METEOR.key(), BLASTER_BULLET.key(), EDEN_PHASER_SHOT.key(), WILDWOOD_PHASER_SHOT.key(), APALACHIA_PHASER_SHOT.key(), SKYTHERN_PHASER_SHOT.key(), MORTUM_PHASER_SHOT.key(), HALITE_PHASER_SHOT.key(), EDEN_BLITZ_SHOT.key(), WILDWOOD_BLITZ_SHOT.key(), APALACHIA_BLITZ_SHOT.key(), SKYTHERN_BLITZ_SHOT.key(), MORTUM_BLITZ_SHOT.key(), HALITE_BLITZ_SHOT.key(), BOUNCING_PROJECTILE.key(), EVERNIGHT_SHOT.key(), CANNON_SHOT.key(), EVERSIGHT_SHOT.key(), DISK.key(), DISSIPATOR.key(), CAVE_ROCK.key(), SAGUARO_WORM_SHOT.key(), SCORCHER_SHOT.key(), FROST_SHOT.key(), FRACTITE_SHOT.key(), ENDER_TRIPLETS_FIREBALL.key(), FYRACRYX_FIREBALL.key(), SKYRE_BULLET.key(), MAGE_SHOT.key(), SPELLBINDER_SHOT.key(), MYSTIC_SHOT.key(), SORCERER_SHOT.key(), CORI_SHOT.key(), MANDRAGORA_SHOT.key(), DISSIMENT_SHOT.key(), KAZROTIC_SHOT.key(), ZORAGON_BOMB.key(), WATCHER_SHOT.key(), KING_OF_SCORCHERS_SHOT.key(), KING_OF_SCORCHERS_METEOR.key(), BONE_FRAGMENT.key(), BONE_BOMB.key(), SUNSTORM_SHOT.key(), SOUL_FIEND_SHOT.key(), TWILIGHT_DEMON_SHOT.key(), LADY_LUNA_SPARKLER.key(), RAGLOK_BOMB.key(), WRECK_SHOT.key(), WRECK_BOMB.key());
        tag(Tags.EntityTypes.MINECARTS).add(INSERTER_MINECART.key());
    }
}