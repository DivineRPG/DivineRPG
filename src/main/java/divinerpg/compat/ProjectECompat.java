package divinerpg.compat;

import com.electronwill.nightconfig.core.file.*;
import divinerpg.registries.*;
import moze_intel.projecte.api.mapper.*;
import moze_intel.projecte.api.mapper.collector.*;
import moze_intel.projecte.api.nss.*;
import net.minecraft.item.*;
import net.minecraft.resources.*;

import javax.annotation.*;
import java.util.*;

@EMCMapper
public class ProjectECompat implements IEMCMapper<NormalizedSimpleStack, Long> {

    private static final Map<NormalizedSimpleStack, Long> CUSTOM_EMC_VALUES = new HashMap<>();

    public static void init() {
        register(NSSItem.createItem(new ItemStack(ItemRegistry.aquaticIngot, 1)), 396L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.arlemiteIngot, 1)), 396L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.hellstoneIngot, 1)), 756L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.torriditeIngot, 1)), 512L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.realmiteIngot, 1)), 640L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.rupeeIngot, 1)), 418L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.divineShards, 1)), 640L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.corruptedShards, 1)), 1050L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.enderShards, 1)), 840L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.jungleShards, 1)), 160L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.moltenShards, 1)), 640L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.terranShards, 1)), 620L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.iceShards, 1)), 653L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.watchingEye, 1)), 4096L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.twilightStone, 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.edenSoul, 1)), 512L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.wildwoodSoul, 1)), 1024L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.apalachiaSoul, 1)), 2048L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.skythernSoul, 1)), 4096L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.mortumSoul, 1)), 8192L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.edenFragments, 1)), 1024L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.wildwoodFragments, 1)), 2048L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.apalachiaFragments, 1)), 4096L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.skythernFragments, 1)), 8192L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.mortumFragments, 1)), 16384);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.bloodgem, 1)), 380L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.purpleBlaze, 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.bluefireStone, 1)), 796L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.furyFire, 1)), 2048L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.sharkFin, 1)), 980L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.crabClaw, 1)), 150L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.whaleFin, 1)), 1508L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.liopleurodonSkull, 1)), 13945L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.liopleurodonTeeth, 1)), 300L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.cyclopsEye, 1)), 415L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.aquaticPellets, 1)), 800L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.snowflake, 1)), 99L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.eggNog, 1)), 302L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.peppermints, 1)), 54L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.chocolateLog, 1)), 415L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.divineMossStone, 1)), 3L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.apalachiaDirt, 1)), 1L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.edenDirt, 1)), 1L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.frozenDirt, 1)), 1L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.mortumDirt, 1)), 1L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.skythernDirt, 1)), 1L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.wildwoodDirt, 1)), 1L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.dreamDirt, 1)), 1L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.apalachiaGrass, 1)), 1L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.edenGrass, 1)), 1L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.frozenGrass, 1)), 1L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.mortumGrass, 1)), 1L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.skythernGrass, 1)), 1L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.wildwoodGrass, 1)), 1L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.dreamGrass, 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.infernoSword, 1)), 4740L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.rawArcanium, 1)), 10304L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.edenHeart, 1)), 4096L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.wildwoodHeart, 1)), 16384L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.apalachiaHeart, 1)), 65536L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.skythernHeart, 1)), 262144L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.mortumHeart, 1)), 1048576L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.teleportationStar, 1)), 64000L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.rawEmpoweredMeat, 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.forbiddenFruit, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.fruitCake, 1)), 5877L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.enrichedMagicMeat, 1)), 256L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.moonbulb, 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.pinkGlowbone, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.purpleGlowbone, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.skyFlower, 1)), 128L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.snowCones, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.tomato, 1)), 32L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.whiteMushroom, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.winterberry, 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.magicMeat, 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.arcanium, 1)), 4096L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.arcaniumAttractor, 1)), 28682L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.arcaniumReflector, 1)), 28682L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.divineAccumulator, 1)), 24576L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.ghostbane, 1)), 81920L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.orbOfLight, 1)), 81920L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.staffOfEnrichment, 1)), 8192L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.wizardsBook, 1)), 8192L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.aquamarine, 1)), 256L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.firestock, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.lamona, 1)), 128L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.marsine, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.pinfly, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.veilo, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.hitchak, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.weakArcanaPotion, 1)), 1024L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.strongArcanaPotion, 1)), 2048L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.collectorFragments, 1)), 128L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.dungeonTokens, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.aquamarineSeeds, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.eucalyptusRootSeeds, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.firestockSeeds, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.hitchakSeeds, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.lamonaSeeds, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.marsineSeeds, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.moonbulbSeeds, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.pinflySeeds, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.pinkGlowboneSeeds, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.purpleGlowboneSeeds, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.skyPlantSeeds, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.veiloSeeds, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.truffle, 1)), 32L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.truffle, 1)), 32L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.sunBlossom, 1)), 32L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.sunbloom, 1)), 32L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.edenBrush, 1)), 32L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.moonBud, 1)), 48L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.moonlightFern, 1)), 48L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.wildwoodTallgrass, 1)), 48L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.duskBloom, 1)), 64L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.duskFlower, 1)), 64L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.apalachiaTallgrass, 1)), 64L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.dustBrambles, 1)), 72L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.dustLily, 1)), 72L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.skythernBrush, 1)), 72L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.demonBrambles, 1)), 80L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.eyePlant, 1)), 80L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.mortumBrush, 1)), 80L);
        register(NSSItem.createItem(new ItemStack(BlockRegistry.wildwoodVine, 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.edenDust, 1)), 32L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.wildwoodDust, 1)), 48L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.apalachiaDust, 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.skythernDust, 1)), 72L);
        register(NSSItem.createItem(new ItemStack(ItemRegistry.mortumDust, 1)), 80L);
    }
    public static void register(@Nonnull NormalizedSimpleStack stack, long emcValue) {
        CUSTOM_EMC_VALUES.put(stack, emcValue);
    }
    @Override
    public String getName() {
        return "DivineRPGMapper";
    }

    @Override
    public String getDescription() {
        return "Adds EMC to DivineRPG";
    }

    @Override
    public void addMappings(IMappingCollector<NormalizedSimpleStack, Long> iMappingCollector, CommentedFileConfig commentedFileConfig, DataPackRegistries dataPackRegistries, IResourceManager iResourceManager) {
        for (Map.Entry<NormalizedSimpleStack, Long> entry : CUSTOM_EMC_VALUES.entrySet()) {
            NormalizedSimpleStack normStack = entry.getKey();
            long value = entry.getValue();
            iMappingCollector.setValueBefore(normStack, value);
        }
    }
}
