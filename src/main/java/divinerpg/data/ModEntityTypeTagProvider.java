package divinerpg.data;

import divinerpg.registries.EntityRegistry;
import divinerpg.registries.TagRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

import java.util.concurrent.CompletableFuture;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.EntityRegistry.*;
import static divinerpg.registries.TagRegistry.*;

public class ModEntityTypeTagProvider extends EntityTypeTagsProvider {
    public ModEntityTypeTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(WHALES).add(WHALE.key(), KITRA.key());
        tag(SHARKS).add(SHARK.key());
        tag(JELLYFISH).add(AEQUOREA.key());
        tag(AQUATIC).add(LIOPLEURODON.key(), CAULDRON_FISH.key(), PINK_GHOST_GLIDER.key(), BLUBBERTUSK.key(), GEM_FIN.key()).addTags(JELLYFISH, SHARKS, WHALES);
        tag(BOSSES).add(ANCIENT_ENTITY.key(), THE_WATCHER.key(), KING_OF_SCORCHERS.key(), KITRA.key(), AYERACO.key(), DRAMIX.key(), PARASECTA.key(), SUNSTORM.key(), TERMASECT.key(), ETERNAL_ARCHER.key(), EXPERIENCED_CORI.key(), VAMACHERON.key(), KAROT.key(), TWILIGHT_DEMON.key(), DENSOS.key(), REYVOR.key(), SOUL_FIEND.key(), HIVE_QUEEN.key(), KAROS.key(), LADY_LUNA.key(), QUADRO.key(), RAGLOK.key(), WRECK.key());
        tag(PROJECTILE).add(THROWN_ITEM.key(), TOMATO.key(), SNOWFLAKE_SHURIKEN.key(), EDEN_SPARKLES.key(), VILE_STORM.key(), GRENADE.key(), ICE_BULLET.key(), DEATH_BULLET.key(), SOUND_OF_MUSIC.key(), SOUND_OF_CAROLS.key(), SOUND_OF_WHALES.key(), CRAB_ANCHOR_SHOT.key(), SHARK_ANCHOR_SHOT.key(), BOWHEAD_ANCHOR_SHOT.key(), LIOPLEURODON_ANCHOR_SHOT.key(), HOOK.key(), EYE_SHARD.key(), SCYTHE_SHOT.key(), MAELSTROM_SHOT.key(), CRAB_CLAW.key(), FROST_CLAW.key(), BOWHEAD_SHOT.key(), FROST_CANNON_SHOT.key(), FRACTITE_CANNON_SHOT.key(), CORRUPTED_BULLET.key(), GHAST_CANNON_SHOT.key(), GOLDEN_FURY_SHOT.key(), ATTRACTOR_BEAM.key(), REFLECTOR_BEAM.key(), SPARKLER_SHOT.key(), FIREFLY.key(), MERIKS_MISSILE.key(), GENERALS_SHOT.key(), STAR.key(), METEOR.key(), BLASTER_BULLET.key(), EDEN_PHASER_SHOT.key(), WILDWOOD_PHASER_SHOT.key(), APALACHIA_PHASER_SHOT.key(), SKYTHERN_PHASER_SHOT.key(), MORTUM_PHASER_SHOT.key(), HALITE_PHASER_SHOT.key(), EDEN_BLITZ_SHOT.key(), WILDWOOD_BLITZ_SHOT.key(), APALACHIA_BLITZ_SHOT.key(), SKYTHERN_BLITZ_SHOT.key(), MORTUM_BLITZ_SHOT.key(), HALITE_BLITZ_SHOT.key(), BOUNCING_PROJECTILE.key(), EVERNIGHT_SHOT.key(), CANNON_SHOT.key(), EVERSIGHT_SHOT.key(), DISK.key(), DISSIPATOR.key(), CAVE_ROCK.key(), SAGUARO_WORM_SHOT.key(), SCORCHER_SHOT.key(), FROST_SHOT.key(), FRACTITE_SHOT.key(), ENDER_TRIPLETS_FIREBALL.key(), FYRACRYX_FIREBALL.key(), SKYRE_BULLET.key(), MAGE_SHOT.key(), SPELLBINDER_SHOT.key(), MYSTIC_SHOT.key(), SORCERER_SHOT.key(), CORI_SHOT.key(), MANDRAGORA_SHOT.key(), DISSIMENT_SHOT.key(), KAZROTIC_SHOT.key(), ZORAGON_BOMB.key(), WATCHER_SHOT.key(), KING_OF_SCORCHERS_SHOT.key(), KING_OF_SCORCHERS_METEOR.key(), BONE_FRAGMENT.key(), BONE_BOMB.key(), SUNSTORM_SHOT.key(), SOUL_FIEND_SHOT.key(), TWILIGHT_DEMON_SHOT.key(), LADY_LUNA_SPARKLER.key(), RAGLOK_BOMB.key(), WRECK_SHOT.key(), WRECK_BOMB.key());
        tag(END).add(ENDER_SCROUNGE.key(), ENDER_SPIDER.key(), ENDER_WATCHER.key(), ENDER_TRIPLETS.key());
        tag(NETHER).add(HELL_PIG.key(), HELL_SPIDER.key(), WILDFIRE.key(), SCORCHER.key());
        tag(OVERWORLD).addTags(GENERAL, JUNGLE, DESERT, SNOWY, BEACH, WATER, CAVE, VISITOR);
        tag(BEACH).add(CRAB.key(), KING_CRAB.key());
        tag(CAVE).add(DIAMOND_DAVE.key(), RAINBOUR.key(), MINER.key(), ROTATICK.key(), CAVE_CRAWLER.key(), CAVECLOPS.key(), THE_EYE.key(), ENTHRALLED_DRAMCRYX.key(), THE_GRUE.key());
        tag(DESERT).add(SAGUARO_WORM.key(), DESERT_CRAWLER.key(), ARID_WARRIOR.key());
        tag(GENERAL).add(LIVESTOCK_MERCHANT.key(), JACK_O_MAN.key(), CYCLOPS.key(), KOBBLIN.key(), PUMPKIN_SPIDER.key());
        tag(JUNGLE).add(JUNGLE_BAT.key(), JUNGLE_SPIDER.key(), JUNGLE_DRAMCRYX.key());
        tag(SNOWY).add(FROST.key(), GLACON.key());
        tag(VISITOR).add(ENDER_SPIDER.key());
        tag(WATER).add(AEQUOREA.key(), SHARK.key(), WHALE.key(), LIOPLEURODON.key());
    }

    private TagKey<EntityType<?>> commonTag(String name){
        return TagKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("c", name));
    }
    private TagKey<EntityType<?>> minecraftTag(String name){
        return TagKey.create(Registries.ENTITY_TYPE, Identifier.withDefaultNamespace(name));
    }
    private TagKey<EntityType<?>> customTag(String name){
        return TagKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(MODID, name));
    }
}
