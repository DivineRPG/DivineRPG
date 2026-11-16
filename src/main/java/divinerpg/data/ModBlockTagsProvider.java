package divinerpg.data;

import divinerpg.registries.DivineRegistries;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.BlockRegistry.*;
import static divinerpg.registries.FluidRegistry.SMOLDERING_TAR_BLOCK;
import static divinerpg.registries.TagRegistry.Blocks.*;
import static divinerpg.registries.TagRegistry.BlockItems.*;
import static net.minecraft.core.registries.Registries.BLOCK;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MODID);
    }
    // TODO: compat raked gravel and gravel bricks here and in ModItemTagsProvider
    @SuppressWarnings("unchecked")
    @Override protected void addTags(HolderLookup.Provider registries) {
        for(var entry : DivineRegistries.BLOCKS.getEntries()) {
            Block block = entry.get();
            if(block == Blocks.AIR) continue;
            var blockKey = toKey(block);
            String path = entry.getId().getPath();
            if(block instanceof GrassBlock) tag(GRASS_BLOCKS.block()).add(blockKey);
            if(block instanceof LeavesBlock) tag(BlockTags.LEAVES).add(blockKey);
            if(block instanceof SaplingBlock) tag(BlockTags.SAPLINGS).add(blockKey);
            if(block instanceof FlowerPotBlock) tag(BlockTags.FLOWER_POTS).add(blockKey);
            if(block instanceof StandingSignBlock) tag(BlockTags.STANDING_SIGNS).add(blockKey);
            if(block instanceof WallSignBlock) tag(BlockTags.WALL_SIGNS).add(blockKey);
            if(block instanceof CeilingHangingSignBlock) tag(BlockTags.CEILING_HANGING_SIGNS).add(blockKey);
            if(block instanceof WallHangingSignBlock) tag(BlockTags.WALL_HANGING_SIGNS).add(blockKey);
            if(block instanceof WallBlock) tag(BlockTags.WALLS).add(blockKey);
            if(block instanceof WoolCarpetBlock) tag(BlockTags.WOOL_CARPETS).add(blockKey);
            if(path.contains("stripped_")) {
                if(path.contains("_log")) tag(Tags.BlockItems.STRIPPED_LOGS.block()).add(blockKey);
                if(path.contains("_wood")) tag(Tags.BlockItems.STRIPPED_WOODS.block()).add(blockKey);
            }
            if(path.contains("_furnace")) tag(FURNACES.block()).add(blockKey);
        }
        tag(BlockTags.NEEDS_STONE_TOOL).addTags(ORES_REALMITE.block(), STORAGE_BLOCKS_RAW_REALMITE.block(), STORAGE_BLOCKS_REALMITE.block(), ORES_OXDRITE.block(), STORAGE_BLOCKS_RAW_OXDRITE.block(), STORAGE_BLOCKS_OXDRITE.block(), STORAGE_BLOCKS_RAW_ARCANIUM.block(), STORAGE_BLOCKS_IRREVERSIBLE_STEEL.block(), METAL_SPIKE_BLOCKS.block(), LAMPS_METAL.block()).add(cutOxdriteSet.getFirst().key(), cutOxdriteSet.get(1).key(), cutOxdriteSet.get(2).key(), arcanaPortalFrame.key(), arcaniumMetalSet.getLast().key(), acceleron.key(), elevantium.key());
        tag(BlockTags.NEEDS_IRON_TOOL).addTags(ORES_ARLEMITE.block(), STORAGE_BLOCKS_RAW_ARLEMITE.block(), STORAGE_BLOCKS_ARLEMITE.block(), ORES_RUPEE.block(), STORAGE_BLOCKS_RAW_RUPEE.block(), STORAGE_BLOCKS_RUPEE.block(), ORES_BLOODGEM.block(), STORAGE_BLOCKS_BLOODGEM.block(), STORAGE_BLOCKS_ARCANIUM.block(), ORES_EDEN.block(), STORAGE_BLOCKS_IRREVERSIBLE_EDEN.block(), ORES_WILDWOOD.block(), STORAGE_BLOCKS_IRREVERSIBLE_WILDWOOD.block(), ORES_APALACHIA.block(), STORAGE_BLOCKS_IRREVERSIBLE_APALACHIA.block(), ORES_SKYTHERN.block(), STORAGE_BLOCKS_IRREVERSIBLE_SKYTHERN.block(), ORES_MORTUM.block(), STORAGE_BLOCKS_IRREVERSIBLE_MORTUM.block()).add(darkstoneBricks.key());
        tag(BlockTags.NEEDS_DIAMOND_TOOL).addTags(STORAGE_BLOCKS_SHADOW.block(), ORES_TORRIDITE.block(), STORAGE_BLOCKS_RAW_TORRIDITE.block(), STORAGE_BLOCKS_TORRIDITE.block(), OBSIDIANS_CRYING.block()).add(darkstone.key(), icyStone.key());
        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(icyBricks.key(), runicIcyBricks.key());

        tag(INCORRECT_FOR_TOOL_AQUATIC).addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);
        tag(INCORRECT_FOR_TOOL_REALMITE).addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);
        tag(INCORRECT_FOR_TOOL_OXDRITE).addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);
        tag(INCORRECT_FOR_TOOL_ARLEMITE).addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
        tag(INCORRECT_FOR_TOOL_TERRAN).addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
        tag(INCORRECT_FOR_TOOL_JUNGLE).addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
        tag(INCORRECT_FOR_TOOL_RUPEE).addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
        tag(INCORRECT_FOR_TOOL_TORRIDITE).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_BLOODGEM).addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
        tag(INCORRECT_FOR_TOOL_MOLTEN).addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
        tag(INCORRECT_FOR_TOOL_SOULFIRE).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_ICE).addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
        tag(INCORRECT_FOR_TOOL_SHADOW).addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
        tag(INCORRECT_FOR_TOOL_SHADOW_GEM).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_BEDROCK).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_CORRUPTED).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_ENDER).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_DIVINE).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_ARCANIUM).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_EDEN).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_WILDWOOD).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_APALACHIA).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_SKYTHERN).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_MORTUM).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_HALITE).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_DREAM).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_TEAKER).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_AMTHIRMIS).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_DARVEN).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_CERMILE).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_PARDIMAL).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_QUADROTIC).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_KAROS).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_HELIOSIS).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_ARKSIANE).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        tag(INCORRECT_FOR_TOOL_EVER).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);

        tag(BlockTags.MINEABLE_WITH_AXE).addTags(PUMPKINS.block(), VINES.block(), LADDERS_WOODEN, CRATES_WOODEN.block(), FAIRY_LIGHTS.block()).add(presentBox.key(), robbinHut.key(), snowyMoss.key(), glowsproutSet.getLast().key(), lowsproutSet.getLast().key(), slowsproutSet.getLast().key(), truffle.key());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).addTags(ORES_REALMITE.block(), STORAGE_BLOCKS_RAW_REALMITE.block(), STORAGE_BLOCKS_REALMITE.block(), ORES_ARLEMITE.block(), STORAGE_BLOCKS_RAW_ARLEMITE.block(), STORAGE_BLOCKS_ARLEMITE.block(), ORES_RUPEE.block(), STORAGE_BLOCKS_RAW_RUPEE.block(), STORAGE_BLOCKS_RUPEE.block(), STORAGE_BLOCKS_SHADOW.block(), ORES_BLOODGEM.block(), STORAGE_BLOCKS_BLOODGEM.block(), ORES_TORRIDITE.block(), STORAGE_BLOCKS_RAW_TORRIDITE.block(), STORAGE_BLOCKS_TORRIDITE.block(), STORAGE_BLOCKS_RAW_OXDRITE.block(), ORES_OXDRITE.block(), STORAGE_BLOCKS_OXDRITE.block(), STORAGE_BLOCKS_RAW_ARCANIUM.block(), STORAGE_BLOCKS_ARCANIUM.block(), STORAGE_BLOCKS_IRREVERSIBLE_OLIVINE.block(), ORES_ANTHRACITE.block(), STORAGE_BLOCKS_IRREVERSIBLE_ANTHRACITE.block(), STORAGE_BLOCKS_IRREVERSIBLE_STEEL.block(), ORES_EDEN.block(), STORAGE_BLOCKS_IRREVERSIBLE_EDEN.block(), ORES_WILDWOOD.block(), STORAGE_BLOCKS_IRREVERSIBLE_WILDWOOD.block(), ORES_APALACHIA.block(), STORAGE_BLOCKS_IRREVERSIBLE_APALACHIA.block(), ORES_SKYTHERN.block(), STORAGE_BLOCKS_IRREVERSIBLE_SKYTHERN.block(), ORES_MORTUM.block(), STORAGE_BLOCKS_IRREVERSIBLE_MORTUM.block(), COBBLESTONES_FROZEN.block(), COBBLESTONES_ICY.block(), COBBLESTONES_SCORCHALT.block(), OBSIDIANS_CRYING.block(), OBSIDIANS_DARK.block(), CANDY_CANES.block(), MINIBRICKS.block(), COLORED_BRICKS.block(), TWILIGHT_BRICKS.block(), LAMPS_METAL.block(), SPAWNERS_BONE, SPAWNERS_METAL, SPAWNERS_EGG, STATUES, LADDERS_ARCANIUM, FURNACES.block(), METAL_SPIKE_BLOCKS.block()).add(scorchedGrass.key(), asphaltSet.getFirst().key(), asphaltSet.get(1).key(), asphaltSet.getLast().key(), buddingOlivine.key(), olivineCluster.key(), buddingDravite.key(), icyBricks.key(), runicIcyBricks.key(), gravestone.key(), frostedAllure.key(), snowBricks.key(), glaciline.key(), frozenStoneSet.getFirst().key(), frozenStoneSet.get(1).key(), frozenStoneSet.get(2).key(), frozenStoneSet.get(4).key(), cobbledFrozenStoneSet.get(1).key(), cobbledFrozenStoneSet.get(2).key(), cobbledFrozenStoneSet.get(4).key(), frozenBrickSet.getFirst().key(), frozenBrickSet.get(1).key(), frozenBrickSet.get(2).key(), frozenBrickSet.get(4).key(), cobaltiteSet.getFirst().key(), cobaltiteSet.get(1).key(), cobaltiteSet.get(2).key(), cobaltiteSet.get(4).key(), polishedCobaltiteSet.getFirst().key(), polishedCobaltiteSet.get(1).key(), polishedCobaltiteSet.get(2).key(), polishedCobaltiteSet.get(4).key(), thermalVent.key(), coalstoneSet.get(1).key(), coalstoneSet.get(2).key(), coalstoneSet.get(4).key(), workshopBookcase.key(), coalstoneBrickSet.get(1).key(), coalstoneBrickSet.get(2).key(), coalstoneBrickSet.get(4).key(), polishedCoalstoneSet.get(1).key(), polishedCoalstoneSet.get(2).key(), polishedCoalstoneSet.get(4).key(), cutOxdriteSet.getFirst().key(), cutOxdriteSet.get(1).key(), cutOxdriteSet.get(2).key(), cutOxdriteSet.get(4).key(), cutOxdriteSet.getLast().key(), arcanaPortalFrame.key(), arcaniteStoneSet.getFirst().key(), arcaniteStoneSet.get(1).key(), arcaniteStoneSet.get(2).key(), arcaniteStoneSet.get(4).key(), arcaniteTileSet.getFirst().key(), arcaniteTileSet.get(1).key(), arcaniteTileSet.get(2).key(), arcaniteTileSet.get(4).key(), ancientStoneSet.getLast().key(), soulStoneSet.getLast().key(), ancientBrickSet.get(5).key(), ancientBrickSet.get(6).key(), ancientBrickSet.get(7).key(), dungeonBookshelf.key(), degradedBrickSet.get(5).key(), degradedBrickSet.get(6).key(), degradedBrickSet.get(7).key(), ancientTileSet.getLast().key(), arcaniumMetalSet.getLast().key(), arcaniumPowerSet.getLast().key(), divineRock.key(), divineMossStone.key(), twilightStoneSet.getFirst().key(), twilightStoneSet.get(1).key(), twilightStoneSet.get(2).key(), twilightStoneSet.get(4).key(), twilightBrickSet.getFirst().key(), twilightBrickSet.get(1).key(), twilightBrickSet.get(2).key(), twilightBrickSet.get(4).key(), milkStone.key(), scorchaltSet.getFirst().key(), scorchaltSet.get(1).key(), scorchaltSet.get(2).key(), scorchaltSet.get(4).key(), cobbledScorchaltSet.get(1).key(), cobbledScorchaltSet.get(2).key(), cobbledScorchaltSet.get(4).key(), chiseledScorchalt.key(), polishedScorchaltSet.getFirst().key(), polishedScorchaltSet.get(1).key(), polishedScorchaltSet.get(2).key(), polishedScorchaltSet.get(4).key(), exposedScorchalt.key(), rayStoneSet.getFirst().key(), rayStoneSet.get(1).key(), rayStoneSet.get(2).key(), rayStoneSet.get(4).key(), polishedRayStoneSet.getFirst().key(), polishedRayStoneSet.get(1).key(), polishedRayStoneSet.get(2).key(), polishedRayStoneSet.get(4).key(), draughtStone.key(), duncap.key(), dreamStone.key(), lunaStone.key(), lunaBricks.key(), redDreamBricks.key(), lightDreamBricks.key(), darkDreamBricks.key(), metalCaging.key(), steelDoor.key(), barredDoor.key(), boneChest.key(), frostedChest.key(), edenChest.key(), randomItemDropper.key(), miner.key(), softMiner.key(), placer.key(), altarOfCorruption.key(), inserter.key(), distributor.key(), oxcrate.key(), oxdriteLamp.key(), capacitor.key(), acceleron.key(), elevantium.key(), gateway.key(), soulTrap.key());
        tag(BlockTags.MINEABLE_WITH_SHOVEL).addTags(DIRTS.block(), SPAWNERS_DIRT, GRASS_BLOCKS.block(), SANDS.block()).add(gelidite.key(), frozenGravel.key(), soulSludgeSet.getLast().key()).remove(scorchedGrass.key());
        tag(BlockTags.MINEABLE_WITH_HOE).addTag(MOSS_BLOCKS.block()).add(hellfireSponge.key(), coldHellfireSponge.key(), robbinNest.key(), winterberryBush.key(), glowsproutSet.get(2).key(), lowsproutSet.get(2).key(), slowsproutSet.get(2).key(), landVineStem.key());
        tag(MINEABLE_WITH_SHICKAXE).addTags(BlockTags.MINEABLE_WITH_AXE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.MINEABLE_WITH_SHOVEL, BlockTags.MINEABLE_WITH_HOE);
        tag(BlockTags.SWORD_EFFICIENT).addTags(PUMPKINS.block(), VINES.block()).add(snowyMoss.key(), duncap.key(), landVineStem.key(), truffle.key());

        tag(BlockTags.SHEARS_MINOR_BREAKING_SPEED).addTag(VINES.block()).add(snowyMoss.key());
        tag(BlockTags.SHEARS_MAJOR_BREAKING_SPEED).add(landVineStem.key());
        tag(BlockTags.SHEARS_EXTREME_BREAKING_SPEED).add(winterberryBush.key());

        tag(Tags.BlockItems.BUDDING_BLOCKS.block()).add(buddingOlivine.key(), buddingDravite.key());
        tag(Tags.BlockItems.CLUSTERS.block()).add(olivineCluster.key());

        tag(ORES_REALMITE.block()).add(realmiteOreSet.getFirst().key(), realmiteOreSet.getLast().key());
        tag(ORES_ARLEMITE.block()).add(arlemiteOreSet.getFirst().key(), arlemiteOreSet.getLast().key());
        tag(ORES_RUPEE.block()).add(rupeeOreSet.getFirst().key(), rupeeOreSet.getLast().key());
        tag(ORES_BLOODGEM.block()).add(bloodgemOre.key());
        tag(ORES_TORRIDITE.block()).add(torriditeOre.key());
        tag(ORES_ANTHRACITE.block()).add(anthraciteOre.key());
        tag(commonTag("ores/anthracite")).addTag(ORES_ANTHRACITE.block());
        tag(ORES_OXDRITE.block()).add(oxdriteOre.key());
        tag(ORES_EDEN.block()).add(twilightEdenOre.key(), scorchaltEdenOre.key());
        tag(ORES_WILDWOOD.block()).add(wildwoodOre.key());
        tag(ORES_APALACHIA.block()).add(apalachiaOre.key());
        tag(ORES_SKYTHERN.block()).add(skythernOre.key());
        tag(ORES_MORTUM.block()).add(mortumOre.key());
        tag(BlockTags.ORES).addTags(ORES_REALMITE.block(), ORES_ARLEMITE.block(), ORES_RUPEE.block(), ORES_BLOODGEM.block(), ORES_TORRIDITE.block(), ORES_ANTHRACITE.block(), ORES_OXDRITE.block(), ORES_EDEN.block(), ORES_WILDWOOD.block(), ORES_APALACHIA.block(), ORES_SKYTHERN.block(), ORES_MORTUM.block());

        tag(Tags.BlockItems.ORES_IN_GROUND_STONE.block()).add(realmiteOreSet.getFirst().key(), arlemiteOreSet.getFirst().key(), rupeeOreSet.getFirst().key());
        tag(Tags.BlockItems.ORES_IN_GROUND_DEEPSLATE.block()).add(realmiteOreSet.getLast().key(), arlemiteOreSet.getLast().key(), rupeeOreSet.getLast().key());
        tag(Tags.BlockItems.ORES_IN_GROUND_NETHERRACK.block()).add(bloodgemOre.key(), torriditeOre.key());
        tag(ORES_IN_GROUND_FROZEN.block()).add(anthraciteOre.key(), oxdriteOre.key());
        tag(ORES_IN_GROUND_TWILIGHT.block()).add(twilightEdenOre.key(), wildwoodOre.key(), apalachiaOre.key(), skythernOre.key(), mortumOre.key());
        tag(ORES_IN_GROUND_SCORCHALT.block()).add(scorchaltEdenOre.key());

        tag(ORE_BEARING_GROUND_FROZEN.block()).add(frozenStoneSet.getFirst().key());
        tag(ORE_BEARING_GROUND_TWILIGHT.block()).add(twilightStoneSet.getFirst().key());
        tag(ORE_BEARING_GROUND_SCORCHALT.block()).add(scorchaltSet.getFirst().key());

        tag(ORE_REPLACEABLES_FROZEN_STONE).add(frozenStoneSet.getFirst().key(), cobbledFrozenStoneSet.getFirst().key());
        tag(ORE_REPLACEABLES_TWILIGHT_STONE).add(twilightStoneSet.getFirst().key());
        tag(ORE_REPLACEABLES_SCORCHALT).add(scorchaltSet.getFirst().key());

        tag(Tags.BlockItems.ORE_RATES_SINGULAR.block()).add(realmiteOreSet.getFirst().key(), realmiteOreSet.getLast().key(), arlemiteOreSet.getFirst().key(), arlemiteOreSet.getLast().key(), rupeeOreSet.getFirst().key(), rupeeOreSet.getLast().key(), bloodgemOre.key(), torriditeOre.key(), anthraciteOre.key(), oxdriteOre.key());
        tag(Tags.BlockItems.ORE_RATES_SPARSE.block()).add(twilightEdenOre.key(), scorchaltEdenOre.key(), wildwoodOre.key(), apalachiaOre.key(), skythernOre.key(), mortumOre.key());

        tag(BlockTags.STONE_BRICKS).add(minibricks.key());
        tag(MINIBRICKS.block()).add(minibricks.key(), bedrockMinibricks.key(), torriditeMinibricks.key(), realmiteMinibricks.key(), arlemiteMinibricks.key(), rupeeMinibricks.key(), bloodgemMinibricks.key());
        tag(COLORED_BRICKS.block()).add(milkStoneBricks.key(), ironBricks.key(), torriditeBricks.key(), lavaBricks.key(), realmiteBricks.key(), goldBricks.key(), arlemiteBricks.key(), greenBricks.key(), darkstoneBricks.key(), aquatonicBricks.key(), diamondBricks.key(), lapisLazuliBricks.key(), purpleBricks.key(), magentaBricks.key(), bloodgemBricks.key());
        tag(TWILIGHT_BRICKS.block()).add(edenBricks.key(), wildwoodBricks.key(), apalachiaBricks.key(), skythernBricks.key(), mortumBricks.key());
        tag(STONE_TYPES_ASPHALT.block()).add(asphaltSet.getFirst().key(), asphaltSet.get(1).key());
        tag(STONE_TYPES_COALSTONE.block()).add(coalstoneSet.getFirst().key(), coalstoneSet.get(1).key(), coalstoneSet.get(3).key(), coalstoneBrickSet.getFirst().key(), coalstoneBrickSet.get(1).key(), coalstoneBrickSet.get(3).key(), chiseledCoalstoneBricks.key(), polishedCoalstoneSet.getFirst().key(), polishedCoalstoneSet.get(1).key(), polishedCoalstoneSet.get(3).key(), coalstoneFurnace.key());
        tag(STONE_TYPES_COBALTITE.block()).add(cobaltiteSet.getFirst().key(), cobaltiteSet.get(1).key(), cobaltiteSet.get(3).key(), polishedCobaltiteSet.getFirst().key(), polishedCobaltiteSet.get(1).key(), polishedCobaltiteSet.get(3).key());
        tag(BASE_STONE_ICEIKA).add(cobbledFrozenStoneSet.getFirst().key(), frozenStoneSet.getFirst().key(), cobaltiteSet.getFirst().key());
        tag(BASE_STONE_ARCANA).add(arcaniteStoneSet.getFirst().key());
        tag(BASE_STONE_EDEN).add(twilightStoneSet.getFirst().key(), rayStoneSet.getFirst().key(), exposedScorchalt.key(), scorchaltSet.getFirst().key(), draughtStone.key());
        tag(BASE_STONE_WILDWOOD).add(twilightStoneSet.getFirst().key());
        tag(BASE_STONE_APALACHIA).add(twilightStoneSet.getFirst().key());
        tag(BASE_STONE_SKYTHERN).add(twilightStoneSet.getFirst().key());
        tag(BASE_STONE_MORTUM).add(twilightStoneSet.getFirst().key());
        tag(BASE_STONE_VETHEA).add(dreamStone.key());
        tag(Tags.BlockItems.STONES.block()).add(frozenStoneSet.getFirst().key(), arcaniteStoneSet.getFirst().key(), divineRock.key(), twilightStoneSet.getFirst().key(), milkStone.key(), scorchaltSet.getFirst().key(), rayStoneSet.getFirst().key(), draughtStone.key(), dreamStone.key());

        tag(OBSIDIANS_CRYING.block()).add(broodingObsidian.key(), bleedingObsidian.key(), shiningObsidian.key(), glitteringObsidian.key(), seepingObsidian.key(), vwoopingObsidian.key());
        tag(Tags.BlockItems.OBSIDIANS_CRYING.block()).addTag(OBSIDIANS_CRYING.block());
        tag(OBSIDIANS_DARK.block()).add(darkstone.key(), darkstoneBricks.key());
        tag(Tags.BlockItems.OBSIDIANS.block()).addTag(OBSIDIANS_DARK.block());

        tag(Tags.BlockItems.COBBLESTONES_MOSSY.block()).add(divineMossStone.key());
        tag(COBBLESTONES_FROZEN.block()).add(cobbledFrozenStoneSet.getFirst().key());
        tag(commonTag("cobblestones/frozen")).addTag(COBBLESTONES_FROZEN.block());
        tag(COBBLESTONES_ICY.block()).add(icyStone.key());
        tag(commonTag("cobblestones/icy")).addTag(COBBLESTONES_ICY.block());
        tag(COBBLESTONES_SCORCHALT.block()).add(cobbledScorchaltSet.getFirst().key());
        tag(Tags.BlockItems.COBBLESTONES.block()).addTags(COBBLESTONES_FROZEN.block(), COBBLESTONES_ICY.block(), COBBLESTONES_SCORCHALT.block()).add(cobaltiteSet.getFirst().key(), ancientStoneSet.getLast().key(), soulStoneSet.getLast().key(), lunaStone.key());

        tag(BlockTags.SPELEOTHEMS).add(icicle.key());

        tag(Tags.BlockItems.GRAVELS.block()).add(frozenGravel.key());

        tag(DIRTS.block()).add(frozenSoil.getFirst().key(), arcaniteSoil.getFirst().key(), scorchsoil.getFirst().key(), raySoil.getFirst().key(), wildwoodSoil.getFirst().key(), apalachiaSoil.getFirst().key(), skythernSoil.getFirst().key(), mortumSoil.getFirst().key(), dreamSoil.getFirst().key());
        tag(BlockItemTags.DIRT.block()).addTag(DIRTS.block());
        tag(BlockTags.CONVERTIBLE_TO_MUD).addTag(DIRTS.block()).add(kobblinBurrow.key());
        tag(BlockItemTags.GRASS_BLOCKS.block()).addTag(GRASS_BLOCKS.block());
        tag(BlockTags.MUD).add(gelidite.key());
        tag(BlockTags.OVERRIDES_MUSHROOM_LIGHT_REQUIREMENT).add(gelidite.key());
        /* Being a part of 'substrate_overworld' due to dirt, grass_blocks, etc. tags is strange, but I'll leave it as it is.
        Otherwise, I might as well make substrate_[dimension] tags and remove them from substrate_overworld, and then place them individually where needed.
        But that's a waste of time, and may potentially break the compatibility with other mods, if anyone would use a 'substrate_overworld' as the supports_*** tag.
        Let's see if Mojang will rename the tag to something like substrate_global, after the Sift dimension comes out. */

        tag(SANDS_ARCANA.block()).add(arcaniteSand.key(), arcanicSand.key(), arcaniumRichSand.key());
        tag(commonTag("sands/light_blue")).add(arcaniteSand.key());
        tag(commonTag("sands/cyan")).add(arcanicSand.key());
        tag(commonTag("sands/blue")).add(arcaniumRichSand.key());
        tag(SANDS.block()).addTag(SANDS_ARCANA.block());
        tag(BlockTags.SAND).addTag(SANDS.block());
        tag(Tags.BlockItems.SANDS.block()).addTag(SANDS.block());
        tag(BlockItemTags.SMELTS_TO_GLASS.block()).addTag(SANDS.block());
        tag(Tags.BlockItems.GLASS_BLOCKS_COLORLESS.block()).add(frostedGlass.key());
        tag(commonTag("glass_blocks/smooth")).add(smoothGlass.key());
        tag(commonTag("glass_blocks/stained")).add(stainedGlass.key());
        tag(Tags.BlockItems.GLASS_BLOCKS.block()).add(smoothGlass.key(), stainedGlass.key());
        tag(BlockTags.IMPERMEABLE).add(frostedGlass.key(), stainedGlass.key(), smoothGlass.key());

        tag(BlockTags.SOUL_FIRE_BASE_BLOCKS).addTag(SANDS_ARCANA.block()).add(soulSludgeSet.getFirst().key(), soulSludgeSet.getLast().key(), arcaniteStoneSet.getFirst().key(), arcaniteStoneSet.get(1).key(), arcaniteStoneSet.get(2).key(), arcaniteTileSet.getFirst().key(), arcaniteTileSet.get(1).key(), arcaniteTileSet.get(2).key(), rawArcanium.key(), arcaniumBlock.key());
        tag(BlockTags.SOUL_SPEED_BLOCKS).add(soulSludgeSet.getFirst().key(), soulSludgeSet.getLast().key(), soulStoneSet.getFirst().key(), soulStoneSet.getLast().key());
        tag(BlockTags.WITHER_SUMMON_BASE_BLOCKS).add(soulSludgeSet.getLast().key());

        tag(BlockTags.ICE).add(glaciline.key(), icyBricks.key(), runicIcyBricks.key());
        tag(Tags.BlockItems.ICE.block()).add(glaciline.key(), icyBricks.key(), runicIcyBricks.key());

        tag(BlockTags.REPLACEABLE_BY_TREES).addTags(FLOWERS_TALL.block(), GRASS.block(), VINES.block()).add(arcanaBush.getFirst().key(), snowyMoss.key(), duncap.key());
        tag(REPLACEABLE_BY_TREES_ICEIKA).addTag(BlockTags.REPLACEABLE_BY_TREES).add(toKey(Blocks.SNOW_BLOCK), toKey(Blocks.SNOW));
        tag(BlockTags.REPLACEABLE_BY_MUSHROOMS).addTags(FLOWERS_TALL.block(), GRASS.block(), VINES.block()).add(arcanaBush.getFirst().key(), snowyMoss.key(), glowsproutSet.getFirst().key(), glowsproutSet.get(2).key(), lowsproutSet.getFirst().key(), lowsproutSet.get(2).key(), slowsproutSet.getFirst().key(), slowsproutSet.get(2).key());
        tag(PLACEABLE_BLOCKS_ICICLE).addTag(BlockTags.ICE).add(frozenSoil.getFirst().key(), toKey(Blocks.GRAVEL), frozenGravel.key(), frozenStoneSet.getFirst().key(), cobbledFrozenStoneSet.getFirst().key(), shiverspineWoodSet.get(2).key(), shiverspineWoodSet.get(3).key());
        tag(BlockTags.DRIPSTONE_REPLACEABLE).add(scorchaltSet.getFirst().key(), draughtStone.key());
        tag(BlockTags.FEATURES_CANNOT_REPLACE).addTags(CHESTS.block(), SPAWNERS);

        tag(BlockTags.MOSS_REPLACEABLE).addTags(BASE_STONE_ICEIKA, BASE_STONE_ARCANA, BASE_STONE_EDEN, BASE_STONE_WILDWOOD, BASE_STONE_APALACHIA, BASE_STONE_SKYTHERN, BASE_STONE_MORTUM, BASE_STONE_VETHEA);
        tag(BlockTags.SCULK_REPLACEABLE).addTags(BASE_STONE_ICEIKA, BASE_STONE_ARCANA, BASE_STONE_EDEN, BASE_STONE_WILDWOOD, BASE_STONE_APALACHIA, BASE_STONE_SKYTHERN, BASE_STONE_MORTUM, BASE_STONE_VETHEA, SANDS.block()).add(divineRock.key(), milkStone.key(), soulSludgeSet.getLast().key(), frozenGravel.key());
        tag(BlockTags.REPLACEABLE).addTags(FLOWERS_BRAMBLE.block(), GRASS.block(), VINES.block(), ACIDS, FIRE).add(arcanaBush.getFirst().key(), snowyMoss.key(), SMOLDERING_TAR_BLOCK.key());

        tag(BlockTags.AIR).add(terranGhostBlock.key(), dungeonAir.key());

        tag(BlockTags.TRIGGERS_AMBIENT_DESERT_DRY_VEGETATION_BLOCK_SOUNDS).addTag(SANDS.block()).add(scorchaltSet.getFirst().key());
        tag(BlockTags.TRIGGERS_AMBIENT_DESERT_SAND_BLOCK_SOUNDS).addTag(SANDS.block());
        tag(BlockTags.TRIGGERS_AMBIENT_DRIED_GHAST_BLOCK_SOUNDS).add(soulSludgeSet.getFirst().key(), soulSludgeSet.getLast().key(), soulStoneSet.getFirst().key(), soulStoneSet.getLast().key());
        tag(BlockTags.REQUIRED_FOR_POPLAR_LEAF_AMBIENCE).addTags(NATURAL_LOGS_ICEIKA.block(), NATURAL_LOGS_ARCANA.block(), NATURAL_LOGS_EDEN.block(), NATURAL_LOGS_WILDWOOD.block(), NATURAL_LOGS_APALACHIA.block(), NATURAL_LOGS_SKYTHERN.block(), NATURAL_LOGS_MORTUM.block(), NATURAL_LOGS_VETHEA.block());
        tag(BlockTags.CRYSTAL_SOUND_BLOCKS).addTag(STORAGE_BLOCKS_IRREVERSIBLE_OLIVINE.block()).add(buddingOlivine.key(), buddingDravite.key());
        tag(BlockTags.COMBINATION_STEP_SOUND_BLOCKS).add(winterberryBush.key());
        tag(BlockTags.INSIDE_STEP_SOUND_BLOCKS).add(snowyMoss.key());
        tag(BlockTags.VIBRATION_RESONATORS).addTag(STORAGE_BLOCKS_IRREVERSIBLE_OLIVINE.block());

        tag(MOSS_BLOCKS.block()).add(brittleMoss.key(), arcaniteMoss.key());
        tag(BlockTags.MOSS_BLOCKS).addTag(MOSS_BLOCKS.block());
        tag(BlockTags.SUPPORTS_DRY_VEGETATION).add(scorchaltSet.getFirst().key());
        tag(BlockTags.SUPPORTS_SMALL_DRIPLEAF).add(arcaniteMoss.key()); // Arcana magic
        tag(BlockTags.SUPPORTS_BIG_DRIPLEAF).addTags(DIRTS.block(), GRASS_BLOCKS.block()).add(gelidite.key());
        tag(BlockTags.SUPPORTS_BAMBOO).add(frozenGravel.key());
        tag(BlockTags.SUPPORTS_WITHER_ROSE).add(soulSludgeSet.getFirst().key(), soulSludgeSet.getLast().key(), soulStoneSet.getFirst().key(), soulStoneSet.getLast().key());
        tag(BlockTags.MAINTAINS_FARMLAND).add(tomatoPlant.key(), whiteMushroomPlant.key(), aquamarinePlant.key(), eucalyptusPlant.key(), hitchakPlant.key(), lamonaPlant.key(), marsinePlant.key(), veiloPlant.key(), skyPlant.key());
        tag(CROPS).add(tomatoPlant.key(), whiteMushroomPlant.key(), aquamarinePlant.key(), eucalyptusPlant.key(), firestockPlant.key(), hitchakPlant.key(), lamonaPlant.key(), marsinePlant.key(), pinflyPlant.key(), veiloPlant.key(), moonbulbPlant.key(), purpleGlowbonePlant.key(), pinkGlowbonePlant.key(), skyPlant.key());
        tag(BlockTags.CROPS).addTag(CROPS);
        tag(PUMPKINS_MOB.block()).add(blazePumpkin.key(), creeperPumpkin.key(), cyclopsPumpkin.key(), enderPumpkin.key(), enderWatcherPumpkin.key(), frostPumpkin.key(), ghastPumpkin.key(), glaconPumpkin.key(), hellspiderPumpkin.key(), jungleSpiderPumpkin.key(), skeletonPumpkin.key(), spiderPumpkin.key(), zombiePumpkin.key());
        tag(PUMPKINS.block()).addTag(PUMPKINS_MOB.block());
        tag(Tags.BlockItems.PUMPKINS.block()).addTag(PUMPKINS.block());
        tag(NATURAL_BULBS.block()).addTag(Tags.BlockItems.FROGLIGHTS.block()).add(toKey(Blocks.SHROOMLIGHT), glowsproutSet.get(2).key(), lowsproutSet.get(2).key(), slowsproutSet.get(2).key());
        tag(FLOWERS_SMALL.block()).add(crimpetal.getFirst().key(), roofbell.getFirst().key(), winterbloom.getFirst().key(), wispLeaf.getFirst().key(), gemOfTheDunes.getFirst().key(), sunBlossom.getFirst().key(), sunbloom.getFirst().key(), moonBud.getFirst().key(), duskBloom.getFirst().key(), dustLily.getFirst().key(), eyePlant.getFirst().key(), shineGrass.getFirst().key(), cracklespike.getFirst().key(), fernite.getFirst().key(), bulbatobe.getFirst().key(), shimmer.getFirst().key(), yellowDulah.getFirst().key(), greenDulah.getFirst().key(), greenGemtop.getFirst().key(), purpleGemtop.getFirst().key());
        tag(BlockTags.SMALL_FLOWERS).addTag(FLOWERS_SMALL.block());
        tag(FLOWERS_BRAMBLE.block()).add(dustBrambles.key(), demonBrambles.key());
        tag(FLOWERS_TALL.block()).addTag(FLOWERS_BRAMBLE.block()).add(globebrush.key(), thermoliage.key(), duskFlower.key());
        tag(Tags.BlockItems.FLOWERS_TALL.block()).addTag(FLOWERS_TALL.block());
        tag(FLOWERS.block()).addTags(FLOWERS_SMALL.block(), FLOWERS_TALL.block()).add(mortumWoodSet.get(2).key());
        tag(BlockTags.FLOWERS).addTag(FLOWERS_TALL.block()).add(mortumWoodSet.get(2).key());
        tag(GRASS_BRUSH.block()).add(arcanaBrush.getFirst().key(), edenBrush.getFirst().key(), skythernBrush.getFirst().key(), mortumBrush.getFirst().key());
        tag(GRASS_SHORT.block()).addTag(GRASS_BRUSH.block()).add(brittleGrass.getFirst().key(), moonlightFern.getFirst().key(), apalachiaTallgrass.getFirst().key());
        tag(GRASS_TALL.block()).add(wildwoodTallgrass.key());
        tag(GRASS.block()).addTags(GRASS_SHORT.block(), GRASS_TALL.block());
        tag(VINES.block()).add(landVine.key(), wildwoodVine.key(), weedwoodVine.key(), blossomedWeedwoodVine.key());
        tag(CAVE_VINES).add(winterberryVinesHead.key(), winterberryVinesBody.key(), arcaniteVinesHead.key(), arcaniteVinesBody.key());
        tag(BlockTags.CAVE_VINES).addTag(CAVE_VINES);

        tag(BlockTags.SNAPS_GOAT_HORN).addTag(NATURAL_LOGS_ICEIKA.block()).add(cobbledFrozenStoneSet.getFirst().key(), frozenStoneSet.getFirst().key());

        tag(LOGS_DIVINE.block()).add(divineWoodSet.get(3).key(), divineWoodSet.get(4).key(), divineWoodSet.get(5).key(), divineWoodSet.get(6).key());
        tag(LOGS_SHIVERSPINE.block()).add(shiverspineWoodSet.get(3).key(), shiverspineWoodSet.get(4).key(), shiverspineWoodSet.get(5).key(), shiverspineWoodSet.get(6).key());
        tag(LOGS_AURORAOAK.block()).add(auroraoakWoodSet.get(3).key(), auroraoakWoodSet.get(4).key(), auroraoakWoodSet.get(5).key(), auroraoakWoodSet.get(6).key());
        tag(LOGS_COZYBARK.block()).add(cozybarkWoodSet.get(3).key(), cozybarkWoodSet.get(4).key(), cozybarkWoodSet.get(5).key(), cozybarkWoodSet.get(6).key());
        tag(LOGS_STREAMLEAF.block()).add(streamleafWoodSet.get(3).key(), streamleafWoodSet.get(4).key(), streamleafWoodSet.get(5).key(), streamleafWoodSet.get(6).key());
        tag(LOGS_EUCALYPTUS.block()).add(eucalyptusWoodSet.getFirst().key(), eucalyptusWoodSet.get(1).key(), eucalyptusWoodSet.get(2).key(), eucalyptusWoodSet.get(3).key());
        tag(LOGS_EDEN.block()).add(edenWoodSet.get(3).key(), edenWoodSet.get(4).key(), edenWoodSet.get(5).key(), edenWoodSet.get(6).key());
        tag(LOGS_CRIMSEEKER.block()).add(crimseekerWoodSet.get(3).key(), crimseekerWoodSet.get(4).key(), crimseekerWoodSet.get(5).key(), crimseekerWoodSet.get(6).key());
        tag(LOGS_WILDWOOD.block()).add(wildwoodWoodSet.get(3).key(), wildwoodWoodSet.get(4).key(), wildwoodWoodSet.get(5).key(), wildwoodWoodSet.get(6).key());
        tag(LOGS_APALACHIA.block()).add(apalachiaWoodSet.get(3).key(), apalachiaWoodSet.get(4).key(), apalachiaWoodSet.get(5).key(), apalachiaWoodSet.get(6).key());
        tag(LOGS_SKYTHERN.block()).add(skythernWoodSet.get(3).key(), skythernWoodSet.get(4).key(), skythernWoodSet.get(5).key(), skythernWoodSet.get(6).key());
        tag(LOGS_MORTUM.block()).add(mortumWoodSet.get(3).key(), mortumWoodSet.get(4).key(), mortumWoodSet.get(5).key(), mortumWoodSet.get(6).key());
        tag(LOGS_FIREWOOD.block()).add(firewoodSet.get(1).key(), firewoodSet.get(2).key(), firewoodSet.get(3).key(), firewoodSet.get(4).key());
        tag(LOGS_DREAMWOOD.block()).add(dreamwoodSet.get(1).key(), dreamwoodSet.get(2).key(), dreamwoodSet.get(3).key(), dreamwoodSet.get(4).key());
        tag(LOGS_HYREWOOD.block()).add(hyrewoodSet.get(1).key(), hyrewoodSet.get(2).key(), hyrewoodSet.get(3).key(), hyrewoodSet.get(4).key());
        tag(LOGS_MINTWOOD.block()).add(mintwoodSet.get(1).key(), mintwoodSet.get(2).key(), mintwoodSet.get(3).key(), mintwoodSet.get(4).key());
        tag(LOGS_VETHEA.block()).addTags(LOGS_FIREWOOD.block(), LOGS_DREAMWOOD.block(), LOGS_HYREWOOD.block(), LOGS_MINTWOOD.block());
        tag(BlockItemTags.LOGS_THAT_BURN.block()).addTags(LOGS_DIVINE.block(), LOGS_SHIVERSPINE.block(), LOGS_AURORAOAK.block(), LOGS_COZYBARK.block(), LOGS_STREAMLEAF.block(), LOGS_EUCALYPTUS.block(), LOGS_EDEN.block(), LOGS_CRIMSEEKER.block(), LOGS_WILDWOOD.block(), LOGS_APALACHIA.block(), LOGS_SKYTHERN.block(), LOGS_MORTUM.block(), LOGS_FIREWOOD.block(), LOGS_DREAMWOOD.block(), LOGS_HYREWOOD.block(), LOGS_MINTWOOD.block());

        tag(BlockTags.OVERWORLD_NATURAL_LOGS).add(divineWoodSet.get(3).key());
        tag(NATURAL_LOGS_ICEIKA.block()).add(shiverspineWoodSet.get(3).key(), auroraoakWoodSet.get(3).key(), cozybarkWoodSet.get(3).key(), streamleafWoodSet.get(3).key());
        tag(NATURAL_LOGS_ARCANA.block()).add(eucalyptusWoodSet.getFirst().key()); // Not so natural, eh?
        tag(NATURAL_LOGS_EDEN.block()).add(edenWoodSet.get(3).key(), crimseekerWoodSet.get(3).key());
        tag(NATURAL_LOGS_WILDWOOD.block()).add(wildwoodWoodSet.get(3).key());
        tag(NATURAL_LOGS_APALACHIA.block()).add(apalachiaWoodSet.get(3).key());
        tag(NATURAL_LOGS_SKYTHERN.block()).add(skythernWoodSet.get(3).key());
        tag(NATURAL_LOGS_MORTUM.block()).add(mortumWoodSet.get(3).key());
        tag(NATURAL_LOGS_VETHEA.block()).add(firewoodSet.get(1).key(), dreamwoodSet.get(1).key(), hyrewoodSet.get(1).key(), mintwoodSet.get(1).key());
        tag(Tags.BlockItems.NATURAL_LOGS.block()).addTags(NATURAL_LOGS_ICEIKA.block(), NATURAL_LOGS_ARCANA.block(), NATURAL_LOGS_EDEN.block(), NATURAL_LOGS_WILDWOOD.block(), NATURAL_LOGS_APALACHIA.block(), NATURAL_LOGS_SKYTHERN.block(), NATURAL_LOGS_MORTUM.block(), NATURAL_LOGS_VETHEA.block());
        tag(Tags.BlockItems.NATURAL_WOODS.block()).add(shiverspineWoodSet.get(5).key(), auroraoakWoodSet.get(5).key(), cozybarkWoodSet.get(5).key(), streamleafWoodSet.get(5).key(), eucalyptusWoodSet.get(2).key(), edenWoodSet.get(5).key(), wildwoodWoodSet.get(5).key(), apalachiaWoodSet.get(5).key(), skythernWoodSet.get(5).key(), mortumWoodSet.get(5).key(), firewoodSet.get(3).key(), dreamwoodSet.get(3).key(), hyrewoodSet.get(3).key(), mintwoodSet.get(3).key());

        tag(PLANKS_DESIGN.block()).add(plankDesign.key());
        tag(PLANKS_OVERWORLD.block()).add(divineWoodSet.get(7).key());
        tag(PLANKS_ICEIKA.block()).add(shiverspineWoodSet.get(7).key(), auroraoakWoodSet.get(7).key(), cozybarkWoodSet.get(7).key(), streamleafWoodSet.get(7).key());
        tag(PLANKS_ARCANA.block()).add(eucalyptusWoodSet.get(4).key());
        tag(PLANKS_EDEN.block()).add(edenWoodSet.get(7).key());
        tag(PLANKS_WILDWOOD.block()).add(wildwoodWoodSet.get(7).key());
        tag(PLANKS_APALACHIA.block()).add(apalachiaWoodSet.get(7).key());
        tag(PLANKS_SKYTHERN.block()).add(skythernWoodSet.get(7).key());
        tag(PLANKS_MORTUM.block()).add(mortumWoodSet.get(7).key());
        tag(PLANKS.block()).addTags(PLANKS_DESIGN.block(), PLANKS_OVERWORLD.block(), PLANKS_ICEIKA.block(), PLANKS_ARCANA.block(), PLANKS_EDEN.block(), PLANKS_WILDWOOD.block(), PLANKS_APALACHIA.block(), PLANKS_SKYTHERN.block(), PLANKS_SKYTHERN.block(), PLANKS_MORTUM.block());
        tag(BlockTags.PLANKS).addTag(PLANKS.block());

        tag(BlockTags.WOODEN_STAIRS).add(stairDesign.key(), divineWoodSet.get(8).key(), shiverspineWoodSet.get(8).key(), auroraoakWoodSet.get(8).key(), cozybarkWoodSet.get(8).key(), streamleafWoodSet.get(8).key(), eucalyptusWoodSet.get(5).key(), edenWoodSet.get(8).key(), wildwoodWoodSet.get(8).key(), apalachiaWoodSet.get(8).key(), skythernWoodSet.get(8).key(), mortumWoodSet.get(8).key());
        tag(BlockTags.STAIRS).add(asphaltSet.get(1).key(), frozenStoneSet.get(1).key(), cobbledFrozenStoneSet.get(1).key(), frozenBrickSet.get(1).key(), cobaltiteSet.get(1).key(), polishedCobaltiteSet.get(1).key(), coalstoneSet.get(1).key(), coalstoneBrickSet.get(1).key(), polishedCoalstoneSet.get(1).key(), cutOxdriteSet.get(1).key(), arcaniteStoneSet.get(1).key(), arcaniteTileSet.get(1).key(), ancientBrickSet.get(1).key(), ancientBrickSet.get(6).key(), degradedBrickSet.get(1).key(), degradedBrickSet.get(6).key(), twilightStoneSet.get(1).key(), twilightBrickSet.get(1).key(), scorchaltSet.get(1).key(), cobbledScorchaltSet.get(1).key(), polishedScorchaltSet.get(1).key(), rayStoneSet.get(1).key(), polishedRayStoneSet.get(1).key());
        tag(BlockTags.WOODEN_SLABS).add(slabDesign.key(), divineWoodSet.get(9).key(), shiverspineWoodSet.get(9).key(), auroraoakWoodSet.get(9).key(), cozybarkWoodSet.get(9).key(), streamleafWoodSet.get(9).key(), eucalyptusWoodSet.get(6).key(), edenWoodSet.get(9).key(), wildwoodWoodSet.get(9).key(), apalachiaWoodSet.get(9).key(), skythernWoodSet.get(9).key(), mortumWoodSet.get(9).key());
        tag(BlockTags.SLABS).add(asphaltSet.getLast().key(), frozenStoneSet.get(2).key(), cobbledFrozenStoneSet.get(2).key(), frozenBrickSet.get(2).key(), cobaltiteSet.get(2).key(), polishedCobaltiteSet.get(2).key(), coalstoneSet.get(2).key(), coalstoneBrickSet.get(2).key(), polishedCoalstoneSet.get(2).key(), cutOxdriteSet.get(2).key(), arcaniteStoneSet.get(2).key(), arcaniteTileSet.get(2).key(), ancientBrickSet.get(2).key(), ancientBrickSet.get(7).key(), degradedBrickSet.get(2).key(), degradedBrickSet.get(7).key(), twilightStoneSet.get(2).key(), twilightBrickSet.get(2).key(), scorchaltSet.get(2).key(), cobbledScorchaltSet.get(2).key(), polishedScorchaltSet.get(2).key(), rayStoneSet.get(2).key(), polishedRayStoneSet.get(2).key());

        tag(BlockTags.WALL_POST_OVERRIDE).addTag(TORCHES_STANDING);

        tag(FENCES_REDSTONE.block()).add(redFence.key(), greenFence.key(), blueFence.key());
        tag(commonTag("fences/redstone")).addTag(FENCES_REDSTONE.block());
        tag(FENCES_DIVINE.block()).add(divineWoodSet.get(10).key());
        tag(FENCES_SHIVERSPINE.block()).add(shiverspineWoodSet.get(10).key());
        tag(FENCES_AURORAOAK.block()).add(auroraoakWoodSet.get(10).key());
        tag(FENCES_COZYBARK.block()).add(cozybarkWoodSet.get(10).key());
        tag(FENCES_STREAMLEAF.block()).add(streamleafWoodSet.get(10).key());
        tag(FENCES_EUCALYPTUS.block()).add(eucalyptusWoodSet.get(7).key());
        tag(commonTag("fences/eucalyptus")).addTag(FENCES_EUCALYPTUS.block());
        tag(FENCES_EDEN.block()).add(edenWoodSet.get(10).key());
        tag(FENCES_WILDWOOD.block()).add(wildwoodWoodSet.get(10).key());
        tag(FENCES_APALACHIA.block()).add(apalachiaWoodSet.get(10).key());
        tag(FENCES_SKYTHERN.block()).add(skythernWoodSet.get(10).key());
        tag(FENCES_MORTUM.block()).add(mortumWoodSet.get(10).key());
        tag(BlockTags.WOODEN_FENCES).addTags(FENCES_DIVINE.block(), FENCES_SHIVERSPINE.block(), FENCES_AURORAOAK.block(), FENCES_COZYBARK.block(), FENCES_STREAMLEAF.block(), FENCES_EUCALYPTUS.block(), FENCES_EDEN.block(), FENCES_WILDWOOD.block(), FENCES_APALACHIA.block(), FENCES_SKYTHERN.block(), FENCES_MORTUM.block());
        tag(BlockTags.FENCES).addTag(FENCES_REDSTONE.block());
        tag(Tags.BlockItems.FENCES.block()).addTag(FENCES_REDSTONE.block());

        tag(FENCE_GATES_DIVINE.block()).add(divineWoodSet.get(11).key());
        tag(FENCE_GATES_SHIVERSPINE.block()).add(shiverspineWoodSet.get(11).key());
        tag(FENCE_GATES_AURORAOAK.block()).add(auroraoakWoodSet.get(11).key());
        tag(FENCE_GATES_COZYBARK.block()).add(cozybarkWoodSet.get(11).key());
        tag(FENCE_GATES_STREAMLEAF.block()).add(streamleafWoodSet.get(11).key());
        tag(FENCE_GATES_EUCALYPTUS.block()).add(eucalyptusWoodSet.get(8).key());
        tag(commonTag("fence_gates/eucalyptus")).addTag(FENCE_GATES_EUCALYPTUS.block());
        tag(FENCE_GATES_EDEN.block()).add(edenWoodSet.get(11).key());
        tag(FENCE_GATES_WILDWOOD.block()).add(wildwoodWoodSet.get(11).key());
        tag(FENCE_GATES_APALACHIA.block()).add(apalachiaWoodSet.get(11).key());
        tag(FENCE_GATES_SKYTHERN.block()).add(skythernWoodSet.get(11).key());
        tag(FENCE_GATES_MORTUM.block()).add(mortumWoodSet.get(11).key());
        tag(BlockTags.FENCE_GATES).addTags(FENCE_GATES_DIVINE.block(), FENCE_GATES_SHIVERSPINE.block(), FENCE_GATES_AURORAOAK.block(), FENCE_GATES_COZYBARK.block(), FENCE_GATES_STREAMLEAF.block(), FENCE_GATES_EUCALYPTUS.block(), FENCE_GATES_EDEN.block(), FENCE_GATES_WILDWOOD.block(), FENCE_GATES_APALACHIA.block(), FENCE_GATES_SKYTHERN.block(), FENCE_GATES_MORTUM.block());
        tag(Tags.BlockItems.FENCE_GATES_WOODEN.block()).addTags(FENCE_GATES_DIVINE.block(), FENCE_GATES_SHIVERSPINE.block(), FENCE_GATES_AURORAOAK.block(), FENCE_GATES_COZYBARK.block(), FENCE_GATES_STREAMLEAF.block(), FENCE_GATES_EUCALYPTUS.block(), FENCE_GATES_EDEN.block(), FENCE_GATES_WILDWOOD.block(), FENCE_GATES_APALACHIA.block(), FENCE_GATES_SKYTHERN.block(), FENCE_GATES_MORTUM.block());

        tag(BlockTags.WOODEN_BUTTONS).add(divineWoodSet.get(16).key(), shiverspineWoodSet.get(16).key(), auroraoakWoodSet.get(16).key(), cozybarkWoodSet.get(16).key(), streamleafWoodSet.get(16).key(), eucalyptusWoodSet.get(13).key(), edenWoodSet.get(16).key(), wildwoodWoodSet.get(16).key(), apalachiaWoodSet.get(16).key(), skythernWoodSet.get(16).key(), mortumWoodSet.get(16).key());
        tag(BlockTags.STONE_BUTTONS).add(frozenStoneSet.getLast().key(), cobbledFrozenStoneSet.getLast().key(), frozenBrickSet.getLast().key(), cobaltiteSet.getLast().key(), polishedCobaltiteSet.getLast().key(), coalstoneSet.getLast().key(), coalstoneBrickSet.getLast().key(), polishedCoalstoneSet.getLast().key(), arcaniteStoneSet.getLast().key(), arcaniteTileSet.getLast().key(), twilightStoneSet.getLast().key(), twilightBrickSet.getLast().key(), scorchaltSet.getLast().key(), cobbledScorchaltSet.getLast().key(), polishedScorchaltSet.getLast().key(), rayStoneSet.getLast().key(), polishedRayStoneSet.getLast().key());
        tag(BlockTags.BUTTONS).add(cutOxdriteSet.getLast().key());
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(divineWoodSet.get(15).key(), shiverspineWoodSet.get(15).key(), auroraoakWoodSet.get(15).key(), cozybarkWoodSet.get(15).key(), streamleafWoodSet.get(15).key(), eucalyptusWoodSet.get(12).key(), edenWoodSet.get(15).key(), wildwoodWoodSet.get(15).key(), apalachiaWoodSet.get(15).key(), skythernWoodSet.get(15).key(), mortumWoodSet.get(15).key());
        tag(BlockTags.STONE_PRESSURE_PLATES).add(frozenStoneSet.get(4).key(), cobbledFrozenStoneSet.get(4).key(), frozenBrickSet.get(4).key(), cobaltiteSet.get(4).key(), polishedCobaltiteSet.get(4).key(), coalstoneSet.get(4).key(), coalstoneBrickSet.get(4).key(), polishedCoalstoneSet.get(4).key(), arcaniteStoneSet.get(4).key(), arcaniteTileSet.get(4).key(), twilightStoneSet.get(4).key(), twilightBrickSet.get(4).key(), scorchaltSet.get(4).key(), cobbledScorchaltSet.get(4).key(), polishedScorchaltSet.get(4).key(), rayStoneSet.get(4).key(), polishedRayStoneSet.get(4).key());
        tag(BlockTags.PRESSURE_PLATES).add(cutOxdriteSet.get(4).key());

        tag(BlockTags.WOODEN_DOORS).add(divineWoodSet.get(13).key(), shiverspineWoodSet.get(13).key(), auroraoakWoodSet.get(13).key(), cozybarkWoodSet.get(13).key(), streamleafWoodSet.get(13).key(), eucalyptusWoodSet.get(10).key(), edenWoodSet.get(13).key(), wildwoodWoodSet.get(13).key(), apalachiaWoodSet.get(13).key(), skythernWoodSet.get(13).key(), mortumWoodSet.get(13).key());
        tag(BlockTags.DOORS).add(steelDoor.key(), ancientBrickSet.get(4).key(), degradedBrickSet.get(4).key(), soulSludgeDoor.key(), soulStoneDoor.key(), barredDoor.key());
        tag(BlockTags.MOB_INTERACTABLE_DOORS).add(steelDoor.key(), barredDoor.key());
        tag(BlockTags.WOODEN_TRAPDOORS).add(divineWoodSet.get(14).key(), shiverspineWoodSet.get(14).key(), auroraoakWoodSet.get(14).key(), cozybarkWoodSet.get(14).key(), streamleafWoodSet.get(14).key(), eucalyptusWoodSet.get(11).key(), edenWoodSet.get(14).key(), wildwoodWoodSet.get(14).key(), apalachiaWoodSet.get(14).key(), skythernWoodSet.get(14).key(), mortumWoodSet.get(14).key());

        tag(BlockTags.WOOL).add(checkerSet.getFirst().key(), rainbowSet.getFirst().key(), fancySet.getFirst().key(), workshopCarpetSet.getFirst().key());
        tag(BlockTags.WOOL_STAIRS).add(checkerSet.get(1).key(), rainbowSet.get(1).key(), fancySet.get(1).key(), workshopCarpetSet.get(1).key());
        tag(BlockTags.WOOL_SLABS).add(checkerSet.get(2).key(), rainbowSet.get(2).key(), fancySet.get(2).key(), workshopCarpetSet.get(2).key());

        tag(BlockTags.BEDS).add(nightmareBed.key());

        // TODO: custom immune_to for some mobs, like immune_to/mortum and add tar or brambles

        tag(BlockTags.ANIMALS_SPAWNABLE_ON).add(frozenSoil.getLast().key(), frostedAllure.key());
        tag(BlockTags.BATS_SPAWNABLE_ON).addTag(BASE_STONE_ICEIKA).add(gelidite.key(), frostedAllure.key());
        tag(BlockTags.AXOLOTLS_SPAWNABLE_ON).add(frostedAllure.key());
        tag(BlockTags.FROGS_SPAWNABLE_ON).add(frozenSoil.getLast().key(), gelidite.key(), frostedAllure.key());
        tag(BlockTags.PARROTS_SPAWNABLE_ON).add(frostedAllure.key());
        tag(BlockTags.RABBITS_SPAWNABLE_ON).add(frozenSoil.getLast().key(), frostedAllure.key());
        tag(BlockTags.FOXES_SPAWNABLE_ON).add(frozenSoil.getLast().key(), frostedAllure.key());
        tag(BlockTags.WOLVES_SPAWNABLE_ON).add(frozenSoil.getLast().key(), frostedAllure.key());
        tag(BlockTags.GOATS_SPAWNABLE_ON).add(frozenGravel.key(), frozenStoneSet.getFirst().key());
        tag(BlockTags.CAMELS_SPAWNABLE_ON).add(frostedAllure.key());
        tag(BlockTags.POLAR_BEARS_SPAWNABLE_ON_ALTERNATE).add(frostedAllure.key());
        tag(BlockTags.MOOSHROOMS_SPAWNABLE_ON).add(frostedAllure.key());
        tag(BlockTags.VALID_SPAWN).addTag(GRASS_BLOCKS.block()).add(frostedAllure.key()); // This one is unused in Vanilla

        tag(BlockTags.BEE_ATTRACTIVE).addTag(FLOWERS.block());
        tag(BlockTags.BEE_GROWABLES).addTag(CAVE_VINES).add(winterberryBush.key());
        tag(BlockTags.EDIBLE_FOR_SHEEP).add(edenBrush.getFirst().key());
        tag(BlockTags.SNIFFER_DIGGABLE_BLOCK).addTag(GRASS_BLOCKS.block());
        tag(BlockTags.SNIFFER_EGG_HATCH_BOOST).add(arcaniteMoss.key()); // Also Arcana magic
        tag(BlockTags.ENDERMAN_HOLDABLE).addTag(SANDS.block()).add(glowsproutSet.getFirst().key(), slowsproutSet.getFirst().key(), lowsproutSet.getFirst().key(), lushroom.getFirst().key(), dreamglow.getFirst().key(), frozenGravel.key(), truffle.key());
        tag(BlockTags.STRIDER_WARM_BLOCKS).add(SMOLDERING_TAR_BLOCK.key());
        tag(BlockTags.GUARDED_BY_PIGLINS).addTags(CRATES.block(), CHESTS.block()).add(goldBricks.key(), goldLamp.key(), shiningObsidian.key(), gildedBricks.key());
        tag(BlockTags.PIGLIN_REPELLENTS).add(soulfireLamp.key());
        tag(BlockTags.HAPPY_GHAST_AVOIDS).addTags(FLOWERS_BRAMBLE.block(), METAL_SPIKE_BLOCKS.block(), ACIDS, FIRE).add(heatTrap.key(), karosHeatTile.key());
        tag(BlockTags.DRAGON_IMMUNE).addTags(OBSIDIANS_CRYING.block(), OBSIDIANS_DARK.block()).add(soulSludgeSet.getFirst().key(), soulSludgeDoor.key(), ancientStoneSet.getFirst().key(), soulStoneSet.getFirst().key(), soulStoneDoor.key(), ancientBrickSet.getFirst().key(), ancientBrickSet.get(1).key(), ancientBrickSet.get(2).key(), ancientBrickSet.get(3).key(), ancientBrickSet.get(4).key(), degradedBrickSet.getFirst().key(), degradedBrickSet.get(1).key(), degradedBrickSet.get(2).key(), degradedBrickSet.get(3).key(), degradedBrickSet.get(4).key(), lightDegradedBrick.key(), darkDegradedBrick.key(), ancientTileSet.getFirst().key(), arcaniumMetalSet.getFirst().key(), arcaniumPowerSet.getFirst().key(), battleBricks.key(), gildedBricks.key(), dungeonLampSet.getFirst().key(), dramixAltar.key(), parasectaAltar.key(), arcaniumExtractor.key(), heatTrap.key(), arcanaPortal.key(), everstone.key(), whiteEverstone.key(), darkEverstone.key(), blackHungerstone.key(), greenHungerstone.key(), hallWall.key(), blueKarosBricks.key(), blackKarosBricks.key(), helioticBeam.key(), cryptFloor.key(), cryptWall.key(), chamberWall.key(), shiftedChamberWall.key(), stackedChamberWall.key(), karosAltar.key(), lunicAltar.key(), quadroticAltar.key(), raglokAltar.key(), wreckAltar.key(), infusionTable.key(), karosHeatTile.key(), karosDispenser.key(), terranGhostBlock.key(), dungeonAir.key());
        tag(BlockTags.WITHER_IMMUNE).add(soulSludgeSet.getFirst().key(), soulSludgeDoor.key(), ancientStoneSet.getFirst().key(), soulStoneSet.getFirst().key(), soulStoneDoor.key(), ancientBrickSet.getFirst().key(), ancientBrickSet.get(1).key(), ancientBrickSet.get(2).key(), ancientBrickSet.get(3).key(), ancientBrickSet.get(4).key(), degradedBrickSet.getFirst().key(), degradedBrickSet.get(1).key(), degradedBrickSet.get(2).key(), degradedBrickSet.get(3).key(), degradedBrickSet.get(4).key(), lightDegradedBrick.key(), darkDegradedBrick.key(), ancientTileSet.getFirst().key(), arcaniumMetalSet.getFirst().key(), arcaniumPowerSet.getFirst().key(), battleBricks.key(), gildedBricks.key(), dungeonLampSet.getFirst().key(), dramixAltar.key(), parasectaAltar.key(), arcaniumExtractor.key(), heatTrap.key(), arcanaPortal.key(), everstone.key(), whiteEverstone.key(), darkEverstone.key(), blackHungerstone.key(), greenHungerstone.key(), hallWall.key(), blueKarosBricks.key(), blackKarosBricks.key(), helioticBeam.key(), cryptFloor.key(), cryptWall.key(), chamberWall.key(), shiftedChamberWall.key(), stackedChamberWall.key(), karosAltar.key(), lunicAltar.key(), quadroticAltar.key(), raglokAltar.key(), wreckAltar.key(), infusionTable.key(), karosHeatTile.key(), karosDispenser.key(), terranGhostBlock.key(), dungeonAir.key());

        tag(SPAWNERS_DIRT).add(kobblinBurrow.key());
        tag(SPAWNERS_BONE).add(calcifiedBrain.key());
        tag(SPAWNERS_METAL).add(proximitySpawner.key(), encagedCaptainMerik.key(), encagedDatticon.key(), encagedKazari.key(), encagedLeorna.key(), encagedLordVatticus.key(), encagedWarGeneral.key(), encagedZelus.key(), sunstormSpawner.key(), termasectSpawner.key(), eternalArcherSpawner.key(), experiencedCoriSpawner.key());
        tag(SPAWNERS_EGG).add(hiveEgg.key());
        tag(SPAWNERS_UNBREAKABLE).add(dramixAltar.key(), parasectaAltar.key(), karosAltar.key(), quadroticAltar.key(), lunicAltar.key(), raglokAltar.key(), wreckAltar.key());
        tag(SPAWNERS).addTags(SPAWNERS_DIRT, SPAWNERS_BONE, SPAWNERS_METAL, SPAWNERS_EGG, SPAWNERS_UNBREAKABLE);

        tag(STATUES).add(ancientEntityStatue.key(), theWatcherStatue.key(), kingOfScorchersStatue.key(), kitraStatue.key(), ayeracoStatue.key(), dramixStatue.key(), parasectaStatue.key(), sunstormStatue.key(), termasectStatue.key(), eternalArcherStatue.key(), experiencedCoriStatue.key(), vamacheronStatue.key(), karotStatue.key(), twilightDemonStatue.key(), densosStatue.key(), reyvorStatue.key(), soulFiendStatue.key());

        tag(LADDERS_WOODEN).add(divineWoodSet.get(12).key(), shiverspineWoodSet.get(12).key(), auroraoakWoodSet.get(12).key(), cozybarkWoodSet.get(12).key(), streamleafWoodSet.get(12).key(), eucalyptusWoodSet.get(9).key(), arcaniteLadder.key(), arcaniteTubes.key(), edenWoodSet.get(12).key(), wildwoodWoodSet.get(12).key(), apalachiaWoodSet.get(12).key(), skythernWoodSet.get(12).key(), mortumWoodSet.get(12).key());
        tag(commonTag("ladders/wooden")).addTag(LADDERS_WOODEN);
        tag(LADDERS_ARCANIUM).add(arcaniteLadder.key(), arcaniteTubes.key());
        tag(LADDERS).addTags(LADDERS_WOODEN, LADDERS_ARCANIUM);
        tag(BlockTags.CLIMBABLE).addTags(VINES.block(), CAVE_VINES, LADDERS).add();

        tag(CRATES_WOODEN.block()).add(crate.key());
        tag(commonTag("crates/wooden")).addTag(CRATES_WOODEN.block());
        tag(CRATES_OXDRITE.block()).add(oxcrate.key());
        tag(CRATES.block()).addTags(CRATES_WOODEN.block(), CRATES_OXDRITE.block());
        tag(commonTag("crates")).addTag(CRATES.block());

        tag(CHESTS.block()).add(boneChest.key(), frostedChest.key(), presentBox.key(), edenChest.key());
        tag(commonTag("chests/bone")).add(boneChest.key());
        tag(commonTag("chests/present")).add(presentBox.key());
        tag(Tags.BlockItems.CHESTS.block()).addTag(CHESTS.block());

        tag(Tags.BlockItems.PLAYER_WORKSTATIONS_FURNACES.block()).addTag(FURNACES.block());

        tag(BlockTags.CATS_CAN_SIT_ON).addTags(CRATES.block(), CHESTS.block(), FURNACES.block());

        tag(OXDRITE_TECH_BLOCKS.block()).add(oxcrate.key(), booster.key(), limiter.key(), oxdriteRail.key(), oxdriteLamp.key(), capacitor.key());
        tag(BlockTags.RAILS).add(oxdriteRail.key());
        tag(METAL_SPIKE_BLOCKS.block()).add(spikeBlock.key(), hotSpikeBlock.key());
        tag(LAMPS_METAL.block()).add(milkyLamp.key(), edenLamp.key(), oxdriteLamp.key(), torriditeLamp.key(), lavaLamp.key(), drakenLamp.key(), realmiteLamp.key(), blazeLamp.key(), goldLamp.key(), arlemiteLamp.key(), krakenLamp.key(), diamondLamp.key(), rupeeLamp.key(), lapisLazuliLamp.key(), aquaLamp.key(), enderLamp.key(), bloodgemLamp.key());
        tag(LAMPS_GEM.block()).add(moltenLamp.key(), divineLamp.key(), jungleLamp.key(), terranLamp.key(), iceLamp.key(), soulfireLamp.key(), enderStoneLamp.key());
        tag(BRIDGES.block()).add(darkBridge.key(), starBridge.key());
        tag(FAIRY_LIGHTS.block()).add(redFairyLights.key(), yellowFairyLights.key(), greenFairyLights.key(), blueFairyLights.key(), purpleFairyLights.key());

        tag(TORCHES_STANDING).add(skeletonTorchSet.getFirst().key(), aquaTorchSet.getFirst().key(), arcaniumTorchSet.getFirst().key(), edenTorchSet.getFirst().key());
        tag(TORCHES_WALL).add(skeletonTorchSet.getLast().key(), aquaTorchSet.getLast().key(), arcaniumTorchSet.getLast().key(), edenTorchSet.getLast().key());
        tag(TORCHES.block()).addTags(TORCHES_STANDING, TORCHES_WALL);

        tag(Tags.BlockItems.BOOKSHELVES.block()).add(workshopBookcase.key(), dungeonBookshelf.key());
        tag(BlockTags.ENCHANTMENT_POWER_PROVIDER).add(workshopBookcase.key(), dungeonBookshelf.key());
        tag(BlockTags.ENCHANTMENT_POWER_TRANSMITTER).add(terranGhostBlock.key(), dungeonAir.key());

        tag(BlockTags.CAN_GLIDE_THROUGH).addTag(VINES.block());

        tag(CANDY_CANES.block()).add(redCandyCane.key(), yellowCandyCane.key(), greenCandyCane.key(), blueCandyCane.key(), pinkCandyCane.key());

        tag(Tags.BlockItems.DYEABLE_REDYEABLE_SIMPLE.block()).addTags(STORAGE_BLOCKS_IRREVERSIBLE_STEEL.block(), CANDY_CANES.block()).remove(fancySet.getFirst().key(), fancySet.get(1).key(), fancySet.get(2).key(), fancySet.getLast().key(), workshopCarpetSet.getFirst().key(), workshopCarpetSet.get(1).key(), workshopCarpetSet.getLast().key());
        tag(DYED_BLACK_AND_WHITE.block()).add(checkerSet.getFirst().key(), checkerSet.get(1).key(), checkerSet.get(2).key(), checkerSet.getLast().key());
        tag(Tags.BlockItems.DYED_LIGHT_GRAY.block()).add(steel.key());
        tag(Tags.BlockItems.DYED_BLACK.block()).add(blackSteel.key());
        tag(Tags.BlockItems.DYED_RED.block()).add(redSteel.key(), redCandyCane.key());
        tag(Tags.BlockItems.DYED_ORANGE.block()).add(orangeSteel.key());
        tag(Tags.BlockItems.DYED_YELLOW.block()).add(yellowSteel.key(), yellowCandyCane.key());
        tag(Tags.BlockItems.DYED_GREEN.block()).add(greenSteel.key(), greenCandyCane.key());
        tag(Tags.BlockItems.DYED_CYAN.block()).add(cyanSteel.key());
        tag(Tags.BlockItems.DYED_BLUE.block()).add(blueSteel.key(), blueCandyCane.key());
        tag(Tags.BlockItems.DYED_PURPLE.block()).add(purpleSteel.key());
        tag(Tags.BlockItems.DYED_MAGENTA.block()).add(magentaSteel.key());
        tag(Tags.BlockItems.DYED_PINK.block()).add(pinkCandyCane.key());
        tag(DYED_RAINBOW.block()).add(rainbowSet.getFirst().key(), rainbowSet.get(1).key(), rainbowSet.get(2).key(), rainbowSet.getLast().key());
        tag(Tags.BlockItems.DYED.block()).add(checkerSet.getFirst().key(), checkerSet.get(1).key(), checkerSet.get(2).key(), checkerSet.getLast().key(), rainbowSet.getFirst().key(), rainbowSet.get(1).key(), rainbowSet.get(2).key(), rainbowSet.getLast().key());

        tag(STORAGE_BLOCKS_IRREVERSIBLE_GLOWSTONE.block()).add(toKey(Blocks.GLOWSTONE), blueStone.key());
        tag(STORAGE_BLOCKS_IRREVERSIBLE_OLIVINE.block()).add(olivineBlock.key());
        tag(STORAGE_BLOCKS_IRREVERSIBLE_ANTHRACITE.block()).add(coalstoneSet.getFirst().key(), coalstoneBrickSet.getFirst().key(), chiseledCoalstoneBricks.key(), polishedCoalstoneSet.getFirst().key());
        tag(STORAGE_BLOCKS_IRREVERSIBLE_STEEL.block()).add(steel.key(), blackSteel.key(), redSteel.key(), orangeSteel.key(), yellowSteel.key(), greenSteel.key(), cyanSteel.key(), blueSteel.key(), purpleSteel.key(), magentaSteel.key());
        tag(STORAGE_BLOCKS_IRREVERSIBLE_ARCANIC_SAND.block()).add(arcanicSand.key());
        tag(STORAGE_BLOCKS_IRREVERSIBLE_ARCANIUM_RICH_SAND.block()).add(arcaniumRichSand.key());
        tag(STORAGE_BLOCKS_IRREVERSIBLE_EDEN.block()).add(edenBlock.key());
        tag(STORAGE_BLOCKS_IRREVERSIBLE_WILDWOOD.block()).add(wildwoodBlock.key());
        tag(STORAGE_BLOCKS_IRREVERSIBLE_APALACHIA.block()).add(apalachiaBlock.key());
        tag(STORAGE_BLOCKS_IRREVERSIBLE_SKYTHERN.block()).add(skythernBlock.key());
        tag(STORAGE_BLOCKS_IRREVERSIBLE_MORTUM.block()).add(mortumBlock.key());

        tag(STORAGE_BLOCKS_RAW_REALMITE.block()).add(realmiteBlockSet.getFirst().key());
        tag(STORAGE_BLOCKS_REALMITE.block()).add(realmiteBlockSet.getLast().key());
        tag(STORAGE_BLOCKS_RAW_ARLEMITE.block()).add(arlemiteBlockSet.getFirst().key());
        tag(STORAGE_BLOCKS_ARLEMITE.block()).add(arlemiteBlockSet.getLast().key());
        tag(STORAGE_BLOCKS_RAW_RUPEE.block()).add(rupeeBlockSet.getFirst().key());
        tag(STORAGE_BLOCKS_RUPEE.block()).add(rupeeBlockSet.getLast().key());
        tag(STORAGE_BLOCKS_SHADOW.block()).add(shadowBlock.key());
        tag(STORAGE_BLOCKS_BLOODGEM.block()).add(bloodgemBlock.key());
        tag(STORAGE_BLOCKS_RAW_TORRIDITE.block()).add(torriditeBlockSet.getFirst().key());
        tag(STORAGE_BLOCKS_TORRIDITE.block()).add(torriditeBlockSet.getLast().key());
        tag(STORAGE_BLOCKS_RAW_OXDRITE.block()).add(oxdriteBlockSet.getFirst().key());
        tag(STORAGE_BLOCKS_OXDRITE.block()).add(oxdriteBlockSet.getLast().key());
        tag(STORAGE_BLOCKS_RAW_ARCANIUM.block()).add(rawArcanium.key());
        tag(STORAGE_BLOCKS_ARCANIUM.block()).add(arcaniumBlock.key());
        tag(Tags.BlockItems.STORAGE_BLOCKS.block()).addTags(STORAGE_BLOCKS_RAW_REALMITE.block(), STORAGE_BLOCKS_REALMITE.block(), STORAGE_BLOCKS_RAW_ARLEMITE.block(), STORAGE_BLOCKS_ARLEMITE.block(), STORAGE_BLOCKS_RAW_RUPEE.block(), STORAGE_BLOCKS_RUPEE.block(), STORAGE_BLOCKS_SHADOW.block(), STORAGE_BLOCKS_BLOODGEM.block(), STORAGE_BLOCKS_RAW_TORRIDITE.block(), STORAGE_BLOCKS_TORRIDITE.block(), STORAGE_BLOCKS_RAW_OXDRITE.block(), STORAGE_BLOCKS_OXDRITE.block(), STORAGE_BLOCKS_RAW_ARCANIUM.block(), STORAGE_BLOCKS_ARCANIUM.block());
        tag(BlockTags.BEACON_BASE_BLOCKS).addTags(STORAGE_BLOCKS_REALMITE.block(), STORAGE_BLOCKS_ARLEMITE.block(), STORAGE_BLOCKS_RUPEE.block(), STORAGE_BLOCKS_SHADOW.block(), STORAGE_BLOCKS_BLOODGEM.block(), STORAGE_BLOCKS_TORRIDITE.block(), STORAGE_BLOCKS_OXDRITE.block(), STORAGE_BLOCKS_ARCANIUM.block(), STORAGE_BLOCKS_IRREVERSIBLE_EDEN.block(), STORAGE_BLOCKS_IRREVERSIBLE_WILDWOOD.block(), STORAGE_BLOCKS_IRREVERSIBLE_APALACHIA.block(), STORAGE_BLOCKS_IRREVERSIBLE_SKYTHERN.block(), STORAGE_BLOCKS_IRREVERSIBLE_MORTUM.block());

        tag(ACIDS).add(bacterialAcid.key(), lunicAcid.key());

        tag(BASE_BLOCKS_ICY_FIRE).addTags(BlockTags.SNOW, BlockTags.ICE).add(snowBricks.key(), icyStone.key());
        tag(FIRE).add(icyFire.key(), hellfire.key(), divineFlame.key(), wildFlame.key(), enchantedFlame.key(), skyFire.key(), mortumEmbers.key());
        tag(BlockTags.FIRE).addTag(FIRE);

        tag(BEDROCK_GRINDING_BASE).add(toKey(Blocks.BEDROCK), bedrockMinibricks.key());
        tag(GATEWAY_RECEIVER).add(toKey(Blocks.LODESTONE), toKey(Blocks.RESPAWN_ANCHOR), arcaniumPowerSet.getFirst().key(), arcaniumPowerSet.getLast().key(), gateway.key());

        tag(BlockTags.INFINIBURN_OVERWORLD).add(coalstoneSet.getFirst().key(), coalstoneSet.get(1).key(), coalstoneSet.get(2).key(), coalstoneBrickSet.getFirst().key(), coalstoneBrickSet.get(1).key(), coalstoneBrickSet.get(2).key(), chiseledCoalstoneBricks.key(), polishedCoalstoneSet.getFirst().key(), polishedCoalstoneSet.get(1).key(), polishedCoalstoneSet.get(2).key(), coalstoneFurnace.key(), workshopBookcase.key());
        tag(INFINIBURN_ICEIKA).addTag(BlockTags.INFINIBURN_OVERWORLD);
        tag(INFINIBURN_ARCANA).addTag(BlockTags.INFINIBURN_OVERWORLD);
        tag(INFINIBURN_EDEN).addTag(BlockTags.INFINIBURN_OVERWORLD);
        tag(INFINIBURN_WILDWOOD).addTag(BlockTags.INFINIBURN_OVERWORLD);
        tag(INFINIBURN_APALACHIA).addTag(BlockTags.INFINIBURN_OVERWORLD);
        tag(INFINIBURN_SKYTHERN).addTag(BlockTags.INFINIBURN_OVERWORLD);
        tag(INFINIBURN_MORTUM).addTag(BlockTags.INFINIBURN_OVERWORLD);
        tag(INFINIBURN_VETHEA).addTag(BlockTags.INFINIBURN_OVERWORLD);

        tag(BlockTags.CONDUIT_EFFECT_BLOCK).add(krakenLamp.key());

        tag(BlockTags.NETHER_PORTAL_FRAME).add(darkstone.key());
        // TODO: to use these
        tag(PORTAL_FRAMES_DIVINE).add(divineRock.key());
        tag(PORTAL_FRAMES_EDEN).add(edenBlock.key());
        tag(PORTAL_FRAMES_WILDWOOD).add(wildwoodBlock.key());
        tag(PORTAL_FRAMES_APALACHIA).add(apalachiaBlock.key());
        tag(PORTAL_FRAMES_SKYTHERN).add(skythernBlock.key());
        tag(PORTAL_FRAMES_MORTUM).add(mortumBlock.key());
        tag(PORTAL_FRAMES_VETHEA).add(mortumBlock.key());

        tag(BlockTags.PORTALS).add(iceikaPortal.key(), arcanaPortal.key(), divinePortal.key(), edenPortal.key(), wildwoodPortal.key(), apalachiaPortal.key(), skythernPortal.key(), mortumPortal.key(), vetheaPortal.key());

        tag(RIFTS_OVERWORLD).add(overworldRift.key());
        tag(RIFTS_EDEN).add(edenRift.key());
        tag(RIFTS_WILDWOOD).add(wildwoodRift.key());
        tag(RIFTS_APALACHIA).add(apalachiaRift.key());
        tag(RIFTS_SKYTHERN).add(skythernRift.key());
        tag(RIFTS_MORTUM).add(mortumRift.key());
        tag(RIFTS).addTags(RIFTS_OVERWORLD, RIFTS_EDEN, RIFTS_WILDWOOD, RIFTS_APALACHIA, RIFTS_SKYTHERN, RIFTS_MORTUM);

        tag(RIFT_RESONATING_OVERWORLD).add(glitteringObsidian.key());
        tag(RIFT_RESONATING_EDEN).add(shiningObsidian.key());
        tag(RIFT_RESONATING_WILDWOOD).add(seepingObsidian.key());
        tag(RIFT_RESONATING_APALACHIA).add(vwoopingObsidian.key());
        tag(RIFT_RESONATING_SKYTHERN).add(broodingObsidian.key());
        tag(RIFT_RESONATING_MORTUM).add(bleedingObsidian.key());

        tag(BlockTags.DANGEROUS_FOR_TELEPORTATION).addTags(FLOWERS_BRAMBLE.block(), METAL_SPIKE_BLOCKS.block(), ACIDS, FIRE).add(icicle.key(), heatTrap.key(), karosHeatTile.key());

        /* This one is kinda broken (see MC-309259).
        Dunno if they are gonna make waterloggable blocks able to be washed away, but if so — add Aqua Torches back to the tag. */
        tag(BlockTags.WASHED_AWAY_BY_FLUIDS).addTags(CROPS, FLOWERS_SMALL.block(), FLOWERS_TALL.block(), GRASS.block(), VINES.block(), CAVE_VINES, STATUES, TORCHES.block(), ACIDS).add(winterberryBush.key(), arcanaBush.getFirst().key(), snowyMoss.key(), glowsproutSet.getFirst().key(), slowsproutSet.getFirst().key(), lowsproutSet.getFirst().key(), lushroom.getFirst().key(), duncap.key(), dreamglow.getFirst().key(), robbinNest.key(), booster.key(), limiter.key(), SMOLDERING_TAR_BLOCK.key()).remove(terranGhostBlock.key(), dungeonAir.key(), aquaTorchSet.getFirst().key(), aquaTorchSet.getLast().key());
        tag(BlockTags.BLOCKS_MOTION_NO_LEAVES).addTags(STORAGE_BLOCKS_RAW_REALMITE.block(), STORAGE_BLOCKS_REALMITE.block(), STORAGE_BLOCKS_RAW_ARLEMITE.block(), STORAGE_BLOCKS_ARLEMITE.block(), STORAGE_BLOCKS_RAW_RUPEE.block(), STORAGE_BLOCKS_RUPEE.block(), STORAGE_BLOCKS_SHADOW.block(), STORAGE_BLOCKS_BLOODGEM.block(), STORAGE_BLOCKS_RAW_TORRIDITE.block(), STORAGE_BLOCKS_TORRIDITE.block(), STORAGE_BLOCKS_RAW_OXDRITE.block(), STORAGE_BLOCKS_OXDRITE.block(), STORAGE_BLOCKS_RAW_ARCANIUM.block(), STORAGE_BLOCKS_ARCANIUM.block(), STORAGE_BLOCKS_IRREVERSIBLE_OLIVINE.block(), STORAGE_BLOCKS_IRREVERSIBLE_ANTHRACITE.block(), STORAGE_BLOCKS_IRREVERSIBLE_STEEL.block(), STORAGE_BLOCKS_IRREVERSIBLE_EDEN.block(), STORAGE_BLOCKS_IRREVERSIBLE_WILDWOOD.block(), STORAGE_BLOCKS_IRREVERSIBLE_APALACHIA.block(), STORAGE_BLOCKS_IRREVERSIBLE_SKYTHERN.block(), STORAGE_BLOCKS_IRREVERSIBLE_MORTUM.block(), COBBLESTONES_FROZEN.block(), COBBLESTONES_ICY.block(), COBBLESTONES_SCORCHALT.block(), OBSIDIANS_CRYING.block(), CANDY_CANES.block(), MINIBRICKS.block(), COLORED_BRICKS.block(), TWILIGHT_BRICKS.block(), LAMPS_GEM.block(), LAMPS_METAL.block(), BRIDGES.block(), SPAWNERS, MOSS_BLOCKS.block(), PUMPKINS.block(), CRATES.block(), CHESTS.block(), FURNACES.block(), METAL_SPIKE_BLOCKS.block()).add(gelidite.key(), frozenGravel.key(), soulSludgeSet.getFirst().key(), soulSludgeSet.getLast().key(), frozenStoneSet.getFirst().key(), frozenBrickSet.getFirst().key(), snowBricks.key(), thermalVent.key(), cobaltiteSet.getFirst().key(), polishedCobaltiteSet.getFirst().key(), blueStone.key(), arcaniteStoneSet.getFirst().key(), arcaniteTileSet.getFirst().key(), ancientStoneSet.getFirst().key(), ancientStoneSet.getLast().key(), soulStoneSet.getFirst().key(), soulStoneSet.getLast().key(), twilightStoneSet.getFirst().key(), twilightBrickSet.getFirst().key(), milkStone.key(), scorchaltSet.getFirst().key(), polishedScorchaltSet.getFirst().key(), chiseledScorchalt.key(), exposedScorchalt.key(), rayStoneSet.getFirst().key(), polishedRayStoneSet.getFirst().key(), draughtStone.key(), divineMossStone.key(), divineRock.key(), dreamStone.key(), lunaStone.key(), everstone.key(), whiteEverstone.key(), darkEverstone.key(), blackHungerstone.key(), greenHungerstone.key(), hiveWall.key(), fireCrystal.key(), firelight.key(), arcanaPortalFrame.key(), buddingOlivine.key(), olivineCluster.key(), buddingDravite.key(), glowsproutSet.getLast().key(), glowsproutSet.get(2).key(), lowsproutSet.getLast().key(), lowsproutSet.get(2).key(), slowsproutSet.getLast().key(), slowsproutSet.get(2).key(), asphaltSet.getFirst().key(), darkstone.key(), workshopBookcase.key(), cutOxdriteSet.getFirst().key(), ancientBrickSet.getFirst().key(), lightDegradedBrick.key(), darkDegradedBrick.key(), degradedBrickSet.getFirst().key(), ancientTileSet.getFirst().key(), arcaniumMetalSet.getFirst().key(), arcaniumPowerSet.getFirst().key(), battleBricks.key(), gildedBricks.key(), ancientBrickSet.get(5).key(), dungeonBookshelf.key(), degradedBrickSet.get(5).key(), ancientTileSet.getLast().key(), arcaniumMetalSet.getLast().key(), arcaniumPowerSet.getLast().key(), hallWall.key(), blackKarosBricks.key(), blueKarosBricks.key(), cryptFloor.key(), cryptWall.key(), chamberWall.key(), shiftedChamberWall.key(), stackedChamberWall.key(), redDreamBricks.key(), lightDreamBricks.key(), darkDreamBricks.key(), lunaBricks.key(), metalCaging.key(), helioticBeam.key(), workshopLamp.key(), slimeLight.key(), dungeonLampSet.getFirst().key(), dungeonLampSet.getLast().key(), dreamLamp.key(), cellLamp.key(), villageLamp.key(), frostedGlass.key(), stainedGlass.key(), smoothGlass.key(), landVineStem.key(), truffle.key(), altarOfCorruption.key(), arcaniumExtractor.key(), infusionTable.key(), inserter.key(), distributor.key(), hellfireSponge.key(), coldHellfireSponge.key(), frostedAllure.key(), soulTrap.key(), gravestone.key(), robbinHut.key(), acceleron.key(), elevantium.key(), capacitor.key(), miner.key(), softMiner.key(), placer.key(), heatTrap.key(), karosHeatTile.key(), karosDispenser.key(), gateway.key(), randomItemDropper.key());
    }
    private ResourceKey<Block> toKey(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).orElseThrow();
    }
    private TagKey<Block> commonTag(String name){
        return TagKey.create(BLOCK, Identifier.fromNamespaceAndPath("c", name));
    }
}