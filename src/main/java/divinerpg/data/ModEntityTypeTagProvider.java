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
        tag(WHALES).add(WHALE.getKey(), KITRA.getKey());
        tag(SHARKS).add(SHARK.getKey());
        tag(JELLYFISH).add(AEQUOREA.getKey());
        tag(AQUATIC).add(LIOPLEURODON.getKey(), CAULDRON_FISH.getKey(), PINK_GHOST_GLIDER.getKey(), BLUBBERTUSK.getKey(), GEM_FIN.getKey()).addTags(JELLYFISH, SHARKS, WHALES);
        tag(BOSSES).add(ANCIENT_ENTITY.getKey(), THE_WATCHER.getKey(), KING_OF_SCORCHERS.getKey(), KITRA.getKey(), AYERACO.getKey(), DRAMIX.getKey(), PARASECTA.getKey(), SUNSTORM.getKey(), TERMASECT.getKey(), ETERNAL_ARCHER.getKey(), EXPERIENCED_CORI.getKey(), VAMACHERON.getKey(), KAROT.getKey(), TWILIGHT_DEMON.getKey(), DENSOS.getKey(), REYVOR.getKey(), SOUL_FIEND.getKey(), HIVE_QUEEN.getKey(), KAROS.getKey(), LADY_LUNA.getKey(), QUADRO.getKey(), RAGLOK.getKey(), WRECK.getKey());
        tag(PROJECTILE).add(THROWN_ITEM.getKey(), TOMATO.getKey(), SNOWFLAKE_SHURIKEN.getKey(), EDEN_SPARKLES.getKey(), VILE_STORM.getKey(), GRENADE.getKey(), ICE_BULLET.getKey(), DEATH_BULLET.getKey(), SOUND_OF_MUSIC.getKey(), SOUND_OF_CAROLS.getKey(), SOUND_OF_WHALES.getKey(), CRAB_ANCHOR_SHOT.getKey(), SHARK_ANCHOR_SHOT.getKey(), BOWHEAD_ANCHOR_SHOT.getKey(), LIOPLEURODON_ANCHOR_SHOT.getKey(), HOOK.getKey(), EYE_SHARD.getKey(), SCYTHE_SHOT.getKey(), MAELSTROM_SHOT.getKey(), CRAB_CLAW.getKey(), FROST_CLAW.getKey(), BOWHEAD_SHOT.getKey(), FROST_CANNON_SHOT.getKey(), FRACTITE_CANNON_SHOT.getKey(), CORRUPTED_BULLET.getKey(), GHAST_CANNON_SHOT.getKey(), GOLDEN_FURY_SHOT.getKey(), ATTRACTOR_BEAM.getKey(), REFLECTOR_BEAM.getKey(), SPARKLER_SHOT.getKey(), FIREFLY.getKey(), MERIKS_MISSILE.getKey(), GENERALS_SHOT.getKey(), STAR.getKey(), METEOR.getKey(), BLASTER_BULLET.getKey(), EDEN_PHASER_SHOT.getKey(), WILDWOOD_PHASER_SHOT.getKey(), APALACHIA_PHASER_SHOT.getKey(), SKYTHERN_PHASER_SHOT.getKey(), MORTUM_PHASER_SHOT.getKey(), HALITE_PHASER_SHOT.getKey(), EDEN_BLITZ_SHOT.getKey(), WILDWOOD_BLITZ_SHOT.getKey(), APALACHIA_BLITZ_SHOT.getKey(), SKYTHERN_BLITZ_SHOT.getKey(), MORTUM_BLITZ_SHOT.getKey(), HALITE_BLITZ_SHOT.getKey(), BOUNCING_PROJECTILE.getKey(), EVERNIGHT_SHOT.getKey(), CANNON_SHOT.getKey(), EVERSIGHT_SHOT.getKey(), DISK.getKey(), DISSIPATOR.getKey(), CAVE_ROCK.getKey(), SAGUARO_WORM_SHOT.getKey(), SCORCHER_SHOT.getKey(), FROST_SHOT.getKey(), FRACTITE_SHOT.getKey(), ENDER_TRIPLETS_FIREBALL.getKey(), FYRACRYX_FIREBALL.getKey(), SKYRE_BULLET.getKey(), MAGE_SHOT.getKey(), SPELLBINDER_SHOT.getKey(), MYSTIC_SHOT.getKey(), SORCERER_SHOT.getKey(), CORI_SHOT.getKey(), MANDRAGORA_SHOT.getKey(), DISSIMENT_SHOT.getKey(), KAZROTIC_SHOT.getKey(), ZORAGON_BOMB.getKey(), WATCHER_SHOT.getKey(), KING_OF_SCORCHERS_SHOT.getKey(), KING_OF_SCORCHERS_METEOR.getKey(), BONE_FRAGMENT.getKey(), BONE_BOMB.getKey(), SUNSTORM_SHOT.getKey(), SOUL_FIEND_SHOT.getKey(), TWILIGHT_DEMON_SHOT.getKey(), LADY_LUNA_SPARKLER.getKey(), RAGLOK_BOMB.getKey(), WRECK_SHOT.getKey(), WRECK_BOMB.getKey());
        tag(END).add(ENDER_SCROUNGE.getKey(), ENDER_SPIDER.getKey(), ENDER_WATCHER.getKey(), ENDER_TRIPLETS.getKey());
        tag(NETHER).add(HELL_PIG.getKey(), HELL_SPIDER.getKey(), WILDFIRE.getKey(), SCORCHER.getKey());
        tag(OVERWORLD).addTags(GENERAL, JUNGLE, DESERT, SNOWY, BEACH, WATER, CAVE, VISITOR);
        tag(BEACH).add(CRAB.getKey(), KING_CRAB.getKey());
        tag(CAVE).add(DIAMOND_DAVE.getKey(), RAINBOUR.getKey(), MINER.getKey(), ROTATICK.getKey(), CAVE_CRAWLER.getKey(), CAVECLOPS.getKey(), THE_EYE.getKey(), ENTHRALLED_DRAMCRYX.getKey(), THE_GRUE.getKey());
        tag(DESERT).add(SAGUARO_WORM.getKey(), DESERT_CRAWLER.getKey(), ARID_WARRIOR.getKey());
        tag(GENERAL).add(LIVESTOCK_MERCHANT.getKey(), JACK_O_MAN.getKey(), CYCLOPS.getKey(), KOBBLIN.getKey(), PUMPKIN_SPIDER.getKey());
        tag(JUNGLE).add(JUNGLE_BAT.getKey(), JUNGLE_SPIDER.getKey(), JUNGLE_DRAMCRYX.getKey());
        tag(SNOWY).add(FROST.getKey(), GLACON.getKey());
        tag(VISITOR).add(ENDER_SPIDER.getKey());
        tag(WATER).add(AEQUOREA.getKey(), SHARK.getKey(), WHALE.getKey(), LIOPLEURODON.getKey());
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
