package divinerpg.data;

import divinerpg.registries.DivineRegistries;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
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
            if(block instanceof GrassBlock) tag(GRASS_BLOCKS).add(blockKey);
            if(block instanceof LeavesBlock) tag(BlockTags.LEAVES).add(blockKey);
            if(block instanceof SaplingBlock) tag(BlockTags.SAPLINGS).add(blockKey);
            if(block instanceof FlowerPotBlock) tag(BlockTags.FLOWER_POTS).add(blockKey);
            if(block instanceof StandingSignBlock) tag(BlockTags.STANDING_SIGNS).add(blockKey); // TODO: sign and hanging sign tags
            if(block instanceof WallSignBlock) tag(BlockTags.WALL_SIGNS).add(blockKey);
            if(block instanceof CeilingHangingSignBlock) tag(BlockTags.CEILING_HANGING_SIGNS).add(blockKey);
            if(block instanceof WallHangingSignBlock) tag(BlockTags.WALL_HANGING_SIGNS).add(blockKey);
            if(block instanceof WallBlock) tag(BlockTags.WALLS).add(blockKey);
            if(block instanceof WoolCarpetBlock) tag(BlockTags.WOOL_CARPETS).add(blockKey); // TODO: to remove if it still doesn't generate anything
            if(path.contains("stripped_")) {
                if(path.contains("_log")) tag(Tags.Blocks.STRIPPED_LOGS).add(blockKey);
                if(path.contains("_wood")) tag(Tags.Blocks.STRIPPED_WOODS).add(blockKey);
            }
            if(path.contains("_furnace")) tag(FURNACES).add(blockKey);
        }
        tag(BlockTags.NEEDS_STONE_TOOL).addTags(ORES_REALMITE, STORAGE_BLOCKS_RAW_REALMITE, STORAGE_BLOCKS_REALMITE, ORES_OXDRITE, STORAGE_BLOCKS_RAW_OXDRITE, STORAGE_BLOCKS_OXDRITE, STORAGE_BLOCKS_RAW_ARCANIUM, STORAGE_BLOCKS_IRREVERSIBLE_STEEL, METAL_SPIKE_BLOCKS, LAMPS_METAL).add(cutOxdriteSet.getFirst().key(), cutOxdriteSet.get(1).key(), cutOxdriteSet.get(2).key(), arcanaPortalFrame.key(), arcaniumMetalSet.getLast().key(), acceleron.key(), elevantium.key());
        tag(BlockTags.NEEDS_IRON_TOOL).addTags(ORES_ARLEMITE, STORAGE_BLOCKS_RAW_ARLEMITE, STORAGE_BLOCKS_ARLEMITE, ORES_RUPEE, STORAGE_BLOCKS_RAW_RUPEE, STORAGE_BLOCKS_RUPEE, ORES_BLOODGEM, STORAGE_BLOCKS_BLOODGEM, STORAGE_BLOCKS_ARCANIUM, STORAGE_BLOCKS_IRREVERSIBLE_EDEN, STORAGE_BLOCKS_IRREVERSIBLE_WILDWOOD, STORAGE_BLOCKS_IRREVERSIBLE_APALACHIA, STORAGE_BLOCKS_IRREVERSIBLE_SKYTHERN, STORAGE_BLOCKS_IRREVERSIBLE_MORTUM).add(darkstoneBricks.key());
        tag(BlockTags.NEEDS_DIAMOND_TOOL).addTags(OBSIDIANS_CRYING, STORAGE_BLOCKS_SHADOW, ORES_TORRIDITE, STORAGE_BLOCKS_RAW_TORRIDITE, STORAGE_BLOCKS_TORRIDITE).add(darkstone.key(), icyStone.key());
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

        tag(BlockTags.MINEABLE_WITH_AXE).addTags(PUMPKINS, VINES, LADDERS_WOODEN, CRATES_WOODEN, FAIRY_LIGHTS).add(presentBox.key(), robbinHut.key(), snowyMoss.key(), glowsproutSet.getLast().key(), lowsproutSet.getLast().key(), slowsproutSet.getLast().key(), truffle.key());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).addTags(OBSIDIANS_CRYING, OBSIDIANS_DARK, ORES_REALMITE, ORES_ARLEMITE, ORES_RUPEE, ORES_BLOODGEM, ORES_TORRIDITE, ORES_ANTHRACITE, ORES_OXDRITE, ORES_EDEN, ORES_WILDWOOD, ORES_APALACHIA, ORES_SKYTHERN, ORES_MORTUM, STORAGE_BLOCKS_RAW_REALMITE, STORAGE_BLOCKS_REALMITE, STORAGE_BLOCKS_RAW_ARLEMITE, STORAGE_BLOCKS_ARLEMITE, STORAGE_BLOCKS_RAW_RUPEE, STORAGE_BLOCKS_RUPEE, STORAGE_BLOCKS_SHADOW, STORAGE_BLOCKS_BLOODGEM, STORAGE_BLOCKS_RAW_TORRIDITE, STORAGE_BLOCKS_TORRIDITE, STORAGE_BLOCKS_RAW_OXDRITE, STORAGE_BLOCKS_OXDRITE, STORAGE_BLOCKS_RAW_ARCANIUM, STORAGE_BLOCKS_ARCANIUM, STORAGE_BLOCKS_IRREVERSIBLE_OLIVINE, STORAGE_BLOCKS_IRREVERSIBLE_ANTHRACITE, STORAGE_BLOCKS_IRREVERSIBLE_STEEL, STORAGE_BLOCKS_IRREVERSIBLE_EDEN, STORAGE_BLOCKS_IRREVERSIBLE_WILDWOOD, STORAGE_BLOCKS_IRREVERSIBLE_APALACHIA, STORAGE_BLOCKS_IRREVERSIBLE_SKYTHERN, STORAGE_BLOCKS_IRREVERSIBLE_MORTUM, CANDY_CANES, MINIBRICKS, COLORED_BRICKS, TWILIGHT_BRICKS, LAMPS_METAL, SPAWNERS_BONE, SPAWNERS_METAL, SPAWNERS_EGG, STATUES, LADDERS_ARCANIUM, FURNACES, METAL_SPIKE_BLOCKS).add(scorchedGrass.key(), asphaltSet.getFirst().key(), asphaltSet.get(1).key(), asphaltSet.getLast().key(), buddingOlivine.key(), olivineCluster.key(), buddingDravite.key(), icyStone.key(), icyBricks.key(), runicIcyBricks.key(), gravestone.key(), frostedAllure.key(), snowBricks.key(), glaciline.key(), frozenStoneSet.getFirst().key(), frozenStoneSet.get(1).key(), frozenStoneSet.get(2).key(), frozenStoneSet.get(4).key(), cobbledFrozenStoneSet.getFirst().key(), cobbledFrozenStoneSet.get(1).key(), cobbledFrozenStoneSet.get(2).key(), cobbledFrozenStoneSet.get(4).key(), frozenBrickSet.getFirst().key(), frozenBrickSet.get(1).key(), frozenBrickSet.get(2).key(), frozenBrickSet.get(4).key(), cobaltiteSet.getFirst().key(), cobaltiteSet.get(1).key(), cobaltiteSet.get(2).key(), cobaltiteSet.get(4).key(), polishedCobaltiteSet.getFirst().key(), polishedCobaltiteSet.get(1).key(), polishedCobaltiteSet.get(2).key(), polishedCobaltiteSet.get(4).key(), thermalVent.key(), coalstoneSet.get(1).key(), coalstoneSet.get(2).key(), coalstoneSet.get(4).key(), workshopBookcase.key(), coalstoneBrickSet.get(1).key(), coalstoneBrickSet.get(2).key(), coalstoneBrickSet.get(4).key(), polishedCoalstoneSet.get(1).key(), polishedCoalstoneSet.get(2).key(), polishedCoalstoneSet.get(4).key(), cutOxdriteSet.getFirst().key(), cutOxdriteSet.get(1).key(), cutOxdriteSet.get(2).key(), cutOxdriteSet.get(4).key(), cutOxdriteSet.getLast().key(), arcanaPortalFrame.key(), arcaniteStoneSet.getFirst().key(), arcaniteStoneSet.get(1).key(), arcaniteStoneSet.get(2).key(), arcaniteStoneSet.get(4).key(), arcaniteTileSet.getFirst().key(), arcaniteTileSet.get(1).key(), arcaniteTileSet.get(2).key(), arcaniteTileSet.get(4).key(), ancientStoneSet.getLast().key(), soulStoneSet.getLast().key(), ancientBrickSet.get(5).key(), ancientBrickSet.get(6).key(), ancientBrickSet.get(7).key(), dungeonBookshelf.key(), degradedBrickSet.get(5).key(), degradedBrickSet.get(6).key(), degradedBrickSet.get(7).key(), ancientTileSet.getLast().key(), arcaniumMetalSet.getLast().key(), arcaniumPowerSet.getLast().key(), divineRock.key(), divineMossStone.key(), twilightStoneSet.getFirst().key(), twilightStoneSet.get(1).key(), twilightStoneSet.get(2).key(), twilightStoneSet.get(4).key(), twilightBrickSet.getFirst().key(), twilightBrickSet.get(1).key(), twilightBrickSet.get(2).key(), twilightBrickSet.get(4).key(), milkStone.key(), scorchaltSet.getFirst().key(), scorchaltSet.get(1).key(), scorchaltSet.get(2).key(), scorchaltSet.get(4).key(), cobbledScorchaltSet.getFirst().key(), cobbledScorchaltSet.get(1).key(), cobbledScorchaltSet.get(2).key(), cobbledScorchaltSet.get(4).key(), chiseledScorchalt.key(), polishedScorchaltSet.getFirst().key(), polishedScorchaltSet.get(1).key(), polishedScorchaltSet.get(2).key(), polishedScorchaltSet.get(4).key(), exposedScorchalt.key(), rayStoneSet.getFirst().key(), rayStoneSet.get(1).key(), rayStoneSet.get(2).key(), rayStoneSet.get(4).key(), polishedRayStoneSet.getFirst().key(), polishedRayStoneSet.get(1).key(), polishedRayStoneSet.get(2).key(), polishedRayStoneSet.get(4).key(), draughtStone.key(), duncap.key(), dreamStone.key(), lunaStone.key(), lunaBricks.key(), redDreamBricks.key(), lightDreamBricks.key(), darkDreamBricks.key(), metalCaging.key(), steelDoor.key(), barredDoor.key(), boneChest.key(), frostedChest.key(), edenChest.key(), randomItemDropper.key(), miner.key(), softMiner.key(), placer.key(), altarOfCorruption.key(), inserter.key(), distributor.key(), oxcrate.key(), oxdriteLamp.key(), capacitor.key(), acceleron.key(), elevantium.key(), gateway.key(), soulTrap.key());
        tag(BlockTags.MINEABLE_WITH_SHOVEL).addTags(DIRTS, SPAWNERS_DIRT, GRASS_BLOCKS, SANDS).add(gelidite.key(), frozenGravel.key(), soulSludgeSet.getLast().key()).remove(scorchedGrass.key());
        tag(BlockTags.MINEABLE_WITH_HOE).addTag(MOSS_BLOCKS).add(hellfireSponge.key(), coldHellfireSponge.key(), robbinNest.key(), winterberryBush.key(), glowsproutSet.get(2).key(), lowsproutSet.get(2).key(), slowsproutSet.get(2).key(), landVineStem.key());
        tag(MINEABLE_WITH_SHICKAXE).addTags(BlockTags.MINEABLE_WITH_AXE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.MINEABLE_WITH_SHOVEL, BlockTags.MINEABLE_WITH_HOE);
        tag(BlockTags.SWORD_EFFICIENT).addTags(PUMPKINS, VINES).add(snowyMoss.key(), duncap.key(), landVineStem.key(), truffle.key());

        tag(BlockTags.SHEARS_MINOR_BREAKING_SPEED).addTag(VINES).add(snowyMoss.key());
        tag(BlockTags.SHEARS_MAJOR_BREAKING_SPEED).add(landVineStem.key());
        tag(BlockTags.SHEARS_EXTREME_BREAKING_SPEED).add(winterberryBush.key());

        tag(Tags.Blocks.BUDDING_BLOCKS).add(buddingOlivine.key(), buddingDravite.key());
        tag(Tags.Blocks.CLUSTERS).add(olivineCluster.key());

        tag(ORES_REALMITE).add(realmiteOreSet.getFirst().key(), realmiteOreSet.getLast().key());
        tag(ORES_ARLEMITE).add(arlemiteOreSet.getFirst().key(), arlemiteOreSet.getLast().key());
        tag(ORES_RUPEE).add(rupeeOreSet.getFirst().key(), rupeeOreSet.getLast().key());
        tag(ORES_BLOODGEM).add(bloodgemOre.key());
        tag(ORES_TORRIDITE).add(torriditeOre.key());
        tag(ORES_ANTHRACITE).add(anthraciteOre.key());
        tag(commonTag("ores/anthracite")).addTag(ORES_ANTHRACITE);
        tag(ORES_OXDRITE).add(oxdriteOre.key());
        tag(ORES_EDEN).add(twilightEdenOre.key(), scorchaltEdenOre.key());
        tag(ORES_WILDWOOD).add(wildwoodOre.key());
        tag(ORES_APALACHIA).add(apalachiaOre.key());
        tag(ORES_SKYTHERN).add(skythernOre.key());
        tag(ORES_MORTUM).add(mortumOre.key());
        tag(BlockTags.ORES).addTags(ORES_REALMITE, ORES_ARLEMITE, ORES_RUPEE, ORES_BLOODGEM, ORES_TORRIDITE, ORES_ANTHRACITE, ORES_OXDRITE, ORES_EDEN, ORES_WILDWOOD, ORES_APALACHIA, ORES_SKYTHERN, ORES_MORTUM);

        tag(Tags.Blocks.ORES_IN_GROUND_STONE).add(realmiteOreSet.getFirst().key(), arlemiteOreSet.getFirst().key(), rupeeOreSet.getFirst().key());
        tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).add(realmiteOreSet.getLast().key(), arlemiteOreSet.getLast().key(), rupeeOreSet.getLast().key());
        tag(Tags.Blocks.ORES_IN_GROUND_NETHERRACK).add(bloodgemOre.key(), torriditeOre.key());
        tag(ORES_IN_GROUND_FROZEN).add(anthraciteOre.key(), oxdriteOre.key());
        tag(ORES_IN_GROUND_TWILIGHT).add(twilightEdenOre.key(), wildwoodOre.key(), apalachiaOre.key(), skythernOre.key(), mortumOre.key());
        tag(ORES_IN_GROUND_SCORCHALT).add(scorchaltEdenOre.key());

        tag(ORE_BEARING_GROUND_FROZEN).add(frozenStoneSet.getFirst().key());
        tag(ORE_BEARING_GROUND_TWILIGHT).add(twilightStoneSet.getFirst().key());
        tag(ORE_BEARING_GROUND_SCORCHALT).add(scorchaltSet.getFirst().key());

        tag(ORE_REPLACEABLES_FROZEN_STONE).add(frozenStoneSet.getFirst().key(), cobbledFrozenStoneSet.getFirst().key());
        tag(ORE_REPLACEABLES_TWILIGHT_STONE).add(twilightStoneSet.getFirst().key());
        tag(ORE_REPLACEABLES_SCORCHALT).add(scorchaltSet.getFirst().key());

        tag(Tags.Blocks.ORE_RATES_SINGULAR).add(realmiteOreSet.getFirst().key(), realmiteOreSet.getLast().key(), arlemiteOreSet.getFirst().key(), arlemiteOreSet.getLast().key(), rupeeOreSet.getFirst().key(), rupeeOreSet.getLast().key(), bloodgemOre.key(), torriditeOre.key(), anthraciteOre.key(), oxdriteOre.key());
        tag(Tags.Blocks.ORE_RATES_SPARSE).add(twilightEdenOre.key(), scorchaltEdenOre.key(), wildwoodOre.key(), apalachiaOre.key(), skythernOre.key(), mortumOre.key());

        tag(BlockTags.STONE_BRICKS).add(minibricks.key());
        tag(MINIBRICKS).add(minibricks.key(), bedrockMinibricks.key(), torriditeMinibricks.key(), realmiteMinibricks.key(), arlemiteMinibricks.key(), rupeeMinibricks.key(), bloodgemMinibricks.key());
        tag(COLORED_BRICKS).add(milkStoneBricks.key(), ironBricks.key(), torriditeBricks.key(), lavaBricks.key(), realmiteBricks.key(), goldBricks.key(), arlemiteBricks.key(), greenBricks.key(), darkstoneBricks.key(), aquatonicBricks.key(), diamondBricks.key(), lapisLazuliBricks.key(), purpleBricks.key(), magentaBricks.key(), bloodgemBricks.key());
        tag(TWILIGHT_BRICKS).add(edenBricks.key(), wildwoodBricks.key(), apalachiaBricks.key(), skythernBricks.key(), mortumBricks.key());
        tag(STONE_TYPES_ASPHALT).add(asphaltSet.getFirst().key(), asphaltSet.get(1).key());
        tag(STONE_TYPES_COALSTONE).add(coalstoneSet.getFirst().key(), coalstoneSet.get(1).key(), coalstoneSet.get(3).key(), coalstoneBrickSet.getFirst().key(), coalstoneBrickSet.get(1).key(), coalstoneBrickSet.get(3).key(), chiseledCoalstoneBricks.key(), polishedCoalstoneSet.getFirst().key(), polishedCoalstoneSet.get(1).key(), polishedCoalstoneSet.get(3).key(), coalstoneFurnace.key());
        tag(STONE_TYPES_COBALTITE).add(cobaltiteSet.getFirst().key(), cobaltiteSet.get(1).key(), cobaltiteSet.get(3).key(), polishedCobaltiteSet.getFirst().key(), polishedCobaltiteSet.get(1).key(), polishedCobaltiteSet.get(3).key());
        tag(BASE_STONE_ICEIKA).add(cobbledFrozenStoneSet.getFirst().key(), frozenStoneSet.getFirst().key(), cobaltiteSet.getFirst().key());
        tag(BASE_STONE_ARCANA).add(arcaniteStoneSet.getFirst().key());
        tag(BASE_STONE_EDEN).add(twilightStoneSet.getFirst().key(), rayStoneSet.getFirst().key(), exposedScorchalt.key(), scorchaltSet.getFirst().key(), draughtStone.key());
        tag(BASE_STONE_WILDWOOD).add(twilightStoneSet.getFirst().key());
        tag(BASE_STONE_APALACHIA).add(twilightStoneSet.getFirst().key());
        tag(BASE_STONE_SKYTHERN).add(twilightStoneSet.getFirst().key());
        tag(BASE_STONE_MORTUM).add(twilightStoneSet.getFirst().key());
        tag(BASE_STONE_VETHEA).add(dreamStone.key());
        tag(Tags.Blocks.STONES).add(frozenStoneSet.getFirst().key(), arcaniteStoneSet.getFirst().key(), divineRock.key(), twilightStoneSet.getFirst().key(), milkStone.key(), scorchaltSet.getFirst().key(), rayStoneSet.getFirst().key(), draughtStone.key(), dreamStone.key());

        tag(OBSIDIANS_CRYING).add(broodingObsidian.key(), bleedingObsidian.key(), shiningObsidian.key(), glitteringObsidian.key(), seepingObsidian.key(), vwoopingObsidian.key());
        tag(Tags.Blocks.OBSIDIANS_CRYING).addTag(OBSIDIANS_CRYING);
        tag(OBSIDIANS_DARK).add(darkstone.key(), darkstoneBricks.key());
        tag(Tags.Blocks.OBSIDIANS).addTag(OBSIDIANS_DARK);

        tag(Tags.Blocks.COBBLESTONES_MOSSY).add(divineMossStone.key());
        tag(COBBLESTONES_FROZEN).add(cobbledFrozenStoneSet.getFirst().key());
        tag(commonTag("cobblestones/frozen")).addTag(COBBLESTONES_FROZEN);
        tag(COBBLESTONES_ICY).add(icyStone.key());
        tag(commonTag("cobblestones/icy")).addTag(COBBLESTONES_ICY);
        tag(COBBLESTONES_SCORCHALT).add(cobbledScorchaltSet.getFirst().key());
        tag(Tags.Blocks.COBBLESTONES).addTags(COBBLESTONES_FROZEN, COBBLESTONES_ICY, COBBLESTONES_SCORCHALT).add(cobaltiteSet.getFirst().key(), ancientStoneSet.getLast().key(), soulStoneSet.getLast().key(), lunaStone.key());

        tag(BlockTags.SPELEOTHEMS).add(icicle.key());

        tag(Tags.Blocks.GRAVELS).add(frozenGravel.key());

        tag(DIRTS).add(frozenSoil.getFirst().key(), arcaniteSoil.getFirst().key(), scorchsoil.getFirst().key(), raySoil.getFirst().key(), wildwoodSoil.getFirst().key(), apalachiaSoil.getFirst().key(), skythernSoil.getFirst().key(), mortumSoil.getFirst().key(), dreamSoil.getFirst().key());
        tag(BlockTags.DIRT).addTag(DIRTS);
        tag(BlockTags.CONVERTIBLE_TO_MUD).addTag(DIRTS).add(kobblinBurrow.key());
        tag(minecraftTag("grass_blocks")).addTag(GRASS_BLOCKS);
        tag(BlockTags.MUD).add(gelidite.key());
        tag(BlockTags.OVERRIDES_MUSHROOM_LIGHT_REQUIREMENT).add(gelidite.key());
        /* Being a part of 'substrate_overworld' due to dirt, grass_blocks, etc. tags is strange, but I'll leave it as it is.
        Otherwise, I might as well make substrate_[dimension] tags and remove them from substrate_overworld, and then place them individually where needed.
        But that's a waste of time, and may potentially break the compatibility with other mods, if anyone would use a 'substrate_overworld' as the supports_*** tag.
        Let's see if Mojang will rename the tag to something like substrate_global, after the Sift dimension comes out. */

        tag(SANDS_ARCANA).add(arcaniteSand.key(), arcanicSand.key(), arcaniumRichSand.key());
        tag(commonTag("sands/light_blue")).add(arcaniteSand.key());
        tag(commonTag("sands/cyan")).add(arcanicSand.key());
        tag(commonTag("sands/blue")).add(arcaniumRichSand.key());
        tag(SANDS).addTag(SANDS_ARCANA);
        tag(BlockTags.SAND).addTag(SANDS);
        tag(Tags.Blocks.SANDS).addTag(SANDS);
        tag(minecraftTag("smelts_to_glass")).addTag(SANDS);
        tag(Tags.Blocks.GLASS_BLOCKS_COLORLESS).add(frostedGlass.key());
        tag(commonTag("glass_blocks/smooth")).add(smoothGlass.key());
        tag(commonTag("glass_blocks/stained")).add(stainedGlass.key());
        tag(Tags.Blocks.GLASS_BLOCKS).add(smoothGlass.key(), stainedGlass.key());
        tag(BlockTags.IMPERMEABLE).add(frostedGlass.key(), stainedGlass.key(), smoothGlass.key());

        tag(BlockTags.SOUL_FIRE_BASE_BLOCKS).addTag(SANDS_ARCANA).add(soulSludgeSet.getFirst().key(), soulSludgeSet.getLast().key(), arcaniteStoneSet.getFirst().key(), arcaniteStoneSet.get(1).key(), arcaniteStoneSet.get(2).key(), arcaniteTileSet.getFirst().key(), arcaniteTileSet.get(1).key(), arcaniteTileSet.get(2).key(), rawArcanium.key(), arcaniumBlock.key());
        tag(BlockTags.SOUL_SPEED_BLOCKS).add(soulSludgeSet.getFirst().key(), soulSludgeSet.getLast().key(), soulStoneSet.getFirst().key(), soulStoneSet.getLast().key());
        tag(BlockTags.WITHER_SUMMON_BASE_BLOCKS).add(soulSludgeSet.getLast().key());

        tag(BlockTags.ICE).add(glaciline.key(), icyBricks.key(), runicIcyBricks.key());
        tag(commonTag("ice")).add(glaciline.key(), icyBricks.key(), runicIcyBricks.key());

        tag(BlockTags.REPLACEABLE_BY_TREES).addTags(FLOWERS_TALL, GRASS, VINES).add(arcanaBush.getFirst().key(), snowyMoss.key(), duncap.key());
        tag(REPLACEABLE_BY_TREES_ICEIKA).addTag(BlockTags.REPLACEABLE_BY_TREES).add(toKey(Blocks.SNOW_BLOCK), toKey(Blocks.SNOW));
        tag(BlockTags.REPLACEABLE_BY_MUSHROOMS).addTags(FLOWERS_TALL, GRASS, VINES).add(arcanaBush.getFirst().key(), snowyMoss.key(), glowsproutSet.getFirst().key(), glowsproutSet.get(2).key(), lowsproutSet.getFirst().key(), lowsproutSet.get(2).key(), slowsproutSet.getFirst().key(), slowsproutSet.get(2).key());
        tag(PLACEABLE_BLOCKS_ICICLE).addTag(BlockTags.ICE).add(frozenSoil.getFirst().key(), toKey(Blocks.GRAVEL), frozenGravel.key(), frozenStoneSet.getFirst().key(), cobbledFrozenStoneSet.getFirst().key(), shiverspineWoodSet.get(2).key(), shiverspineWoodSet.get(3).key());
        tag(BlockTags.DRIPSTONE_REPLACEABLE).add(scorchaltSet.getFirst().key(), draughtStone.key());
        tag(BlockTags.FEATURES_CANNOT_REPLACE).addTags(CHESTS, SPAWNERS);

        tag(BlockTags.MOSS_REPLACEABLE).addTags(BASE_STONE_ICEIKA, BASE_STONE_ARCANA, BASE_STONE_EDEN, BASE_STONE_WILDWOOD, BASE_STONE_APALACHIA, BASE_STONE_SKYTHERN, BASE_STONE_MORTUM, BASE_STONE_VETHEA);
        tag(BlockTags.SCULK_REPLACEABLE).addTags(BASE_STONE_ICEIKA, BASE_STONE_ARCANA, BASE_STONE_EDEN, BASE_STONE_WILDWOOD, BASE_STONE_APALACHIA, BASE_STONE_SKYTHERN, BASE_STONE_MORTUM, BASE_STONE_VETHEA, SANDS).add(divineRock.key(), milkStone.key(), soulSludgeSet.getLast().key(), frozenGravel.key());
        tag(BlockTags.REPLACEABLE).addTags(FLOWERS_BRAMBLE, GRASS, VINES, ACIDS, FIRE).add(arcanaBush.getFirst().key(), snowyMoss.key(), SMOLDERING_TAR_BLOCK.key());

        tag(BlockTags.AIR).add(terranGhostBlock.key(), dungeonAir.key());

        tag(BlockTags.TRIGGERS_AMBIENT_DESERT_DRY_VEGETATION_BLOCK_SOUNDS).addTag(SANDS).add(scorchaltSet.getFirst().key());
        tag(BlockTags.TRIGGERS_AMBIENT_DESERT_SAND_BLOCK_SOUNDS).addTag(SANDS);
        tag(BlockTags.TRIGGERS_AMBIENT_DRIED_GHAST_BLOCK_SOUNDS).add(soulSludgeSet.getFirst().key(), soulSludgeSet.getLast().key(), soulStoneSet.getFirst().key(), soulStoneSet.getLast().key());
        tag(BlockTags.REQUIRED_FOR_POPLAR_LEAF_AMBIENCE).addTags(NATURAL_LOGS_ICEIKA, NATURAL_LOGS_ARCANA, NATURAL_LOGS_EDEN, NATURAL_LOGS_WILDWOOD, NATURAL_LOGS_APALACHIA, NATURAL_LOGS_SKYTHERN, NATURAL_LOGS_MORTUM, NATURAL_LOGS_VETHEA);
        tag(BlockTags.CRYSTAL_SOUND_BLOCKS).addTag(STORAGE_BLOCKS_IRREVERSIBLE_OLIVINE).add(buddingOlivine.key(), buddingDravite.key());
        tag(BlockTags.COMBINATION_STEP_SOUND_BLOCKS).add(winterberryBush.key());
        tag(BlockTags.INSIDE_STEP_SOUND_BLOCKS).add(snowyMoss.key());
        tag(BlockTags.VIBRATION_RESONATORS).addTag(STORAGE_BLOCKS_IRREVERSIBLE_OLIVINE);

        tag(MOSS_BLOCKS).add(brittleMoss.key(), arcaniteMoss.key());
        tag(BlockTags.MOSS_BLOCKS).addTag(MOSS_BLOCKS);
        tag(BlockTags.SUPPORTS_DRY_VEGETATION).add(scorchaltSet.getFirst().key());
        tag(BlockTags.SUPPORTS_SMALL_DRIPLEAF).add(arcaniteMoss.key()); // Arcana magic
        tag(BlockTags.SUPPORTS_BIG_DRIPLEAF).addTags(DIRTS, GRASS_BLOCKS).add(gelidite.key());
        tag(BlockTags.SUPPORTS_BAMBOO).add(frozenGravel.key());
        tag(BlockTags.SUPPORTS_WITHER_ROSE).add(soulSludgeSet.getFirst().key(), soulSludgeSet.getLast().key(), soulStoneSet.getFirst().key(), soulStoneSet.getLast().key());
        tag(BlockTags.MAINTAINS_FARMLAND).add(tomatoPlant.key(), whiteMushroomPlant.key(), aquamarinePlant.key(), eucalyptusPlant.key(), hitchakPlant.key(), lamonaPlant.key(), marsinePlant.key(), veiloPlant.key(), skyPlant.key());
        tag(CROPS).add(tomatoPlant.key(), whiteMushroomPlant.key(), aquamarinePlant.key(), eucalyptusPlant.key(), firestockPlant.key(), hitchakPlant.key(), lamonaPlant.key(), marsinePlant.key(), pinflyPlant.key(), veiloPlant.key(), moonbulbPlant.key(), purpleGlowbonePlant.key(), pinkGlowbonePlant.key(), skyPlant.key());
        tag(BlockTags.CROPS).addTag(CROPS);
        tag(PUMPKINS_MOB).add(blazePumpkin.key(), creeperPumpkin.key(), cyclopsPumpkin.key(), enderPumpkin.key(), enderWatcherPumpkin.key(), frostPumpkin.key(), ghastPumpkin.key(), glaconPumpkin.key(), hellspiderPumpkin.key(), jungleSpiderPumpkin.key(), skeletonPumpkin.key(), spiderPumpkin.key(), zombiePumpkin.key());
        tag(PUMPKINS).addTag(PUMPKINS_MOB);
        tag(Tags.Blocks.PUMPKINS).addTag(PUMPKINS);
        tag(NATURAL_BULBS).addTag(Tags.Blocks.FROGLIGHTS).add(toKey(Blocks.SHROOMLIGHT), glowsproutSet.get(2).key(), lowsproutSet.get(2).key(), slowsproutSet.get(2).key());
        tag(FLOWERS_SMALL).add(crimpetal.getFirst().key(), roofbell.getFirst().key(), winterbloom.getFirst().key(), wispLeaf.getFirst().key(), gemOfTheDunes.getFirst().key(), sunBlossom.getFirst().key(), sunbloom.getFirst().key(), moonBud.getFirst().key(), duskBloom.getFirst().key(), dustLily.getFirst().key(), eyePlant.getFirst().key(), shineGrass.getFirst().key(), cracklespike.getFirst().key(), fernite.getFirst().key(), bulbatobe.getFirst().key(), shimmer.getFirst().key(), yellowDulah.getFirst().key(), greenDulah.getFirst().key(), greenGemtop.getFirst().key(), purpleGemtop.getFirst().key());
        tag(BlockTags.SMALL_FLOWERS).addTag(FLOWERS_SMALL);
        tag(FLOWERS_BRAMBLE).add(dustBrambles.key(), demonBrambles.key());
        tag(FLOWERS_TALL).addTag(FLOWERS_BRAMBLE).add(globebrush.key(), thermoliage.key(), duskFlower.key());
        tag(Tags.Blocks.FLOWERS_TALL).addTag(FLOWERS_TALL);
        tag(FLOWERS).addTags(FLOWERS_SMALL, FLOWERS_TALL).add(mortumWoodSet.get(2).key());
        tag(BlockTags.FLOWERS).addTag(FLOWERS_TALL).add(mortumWoodSet.get(2).key());
        tag(GRASS_BRUSH).add(arcanaBrush.getFirst().key(), edenBrush.getFirst().key(), skythernBrush.getFirst().key(), mortumBrush.getFirst().key());
        tag(GRASS_SHORT).addTag(GRASS_BRUSH).add(brittleGrass.getFirst().key(), moonlightFern.getFirst().key(), apalachiaTallgrass.getFirst().key());
        tag(GRASS_TALL).add(wildwoodTallgrass.key());
        tag(GRASS).addTags(GRASS_SHORT, GRASS_TALL);
        tag(VINES).add(landVine.key(), wildwoodVine.key(), weedwoodVine.key(), blossomedWeedwoodVine.key());
        tag(CAVE_VINES).add(winterberryVinesHead.key(), winterberryVinesBody.key(), arcaniteVinesHead.key(), arcaniteVinesBody.key());
        tag(BlockTags.CAVE_VINES).addTag(CAVE_VINES);

        tag(BlockTags.SNAPS_GOAT_HORN).addTag(NATURAL_LOGS_ICEIKA).add(cobbledFrozenStoneSet.getFirst().key(), frozenStoneSet.getFirst().key());

        tag(LOGS_DIVINE).add(divineWoodSet.get(3).key(), divineWoodSet.get(4).key(), divineWoodSet.get(5).key(), divineWoodSet.get(6).key());
        tag(LOGS_SHIVERSPINE).add(shiverspineWoodSet.get(3).key(), shiverspineWoodSet.get(4).key(), shiverspineWoodSet.get(5).key(), shiverspineWoodSet.get(6).key());
        tag(LOGS_AURORAOAK).add(auroraoakWoodSet.get(3).key(), auroraoakWoodSet.get(4).key(), auroraoakWoodSet.get(5).key(), auroraoakWoodSet.get(6).key());
        tag(LOGS_COZYBARK).add(cozybarkWoodSet.get(3).key(), cozybarkWoodSet.get(4).key(), cozybarkWoodSet.get(5).key(), cozybarkWoodSet.get(6).key());
        tag(LOGS_STREAMLEAF).add(streamleafWoodSet.get(3).key(), streamleafWoodSet.get(4).key(), streamleafWoodSet.get(5).key(), streamleafWoodSet.get(6).key());
        tag(LOGS_EUCALYPTUS).add(eucalyptusWoodSet.getFirst().key(), eucalyptusWoodSet.get(1).key(), eucalyptusWoodSet.get(2).key(), eucalyptusWoodSet.get(3).key());
        tag(LOGS_EDEN).add(edenWoodSet.get(3).key(), edenWoodSet.get(4).key(), edenWoodSet.get(5).key(), edenWoodSet.get(6).key());
        tag(LOGS_CRIMSEEKER).add(crimseekerWoodSet.get(3).key(), crimseekerWoodSet.get(4).key(), crimseekerWoodSet.get(5).key(), crimseekerWoodSet.get(6).key());
        tag(LOGS_WILDWOOD).add(wildwoodWoodSet.get(3).key(), wildwoodWoodSet.get(4).key(), wildwoodWoodSet.get(5).key(), wildwoodWoodSet.get(6).key());
        tag(LOGS_APALACHIA).add(apalachiaWoodSet.get(3).key(), apalachiaWoodSet.get(4).key(), apalachiaWoodSet.get(5).key(), apalachiaWoodSet.get(6).key());
        tag(LOGS_SKYTHERN).add(skythernWoodSet.get(3).key(), skythernWoodSet.get(4).key(), skythernWoodSet.get(5).key(), skythernWoodSet.get(6).key());
        tag(LOGS_MORTUM).add(mortumWoodSet.get(3).key(), mortumWoodSet.get(4).key(), mortumWoodSet.get(5).key(), mortumWoodSet.get(6).key());
        tag(LOGS_FIREWOOD).add(firewoodSet.get(1).key(), firewoodSet.get(2).key(), firewoodSet.get(3).key(), firewoodSet.get(4).key());
        tag(LOGS_DREAMWOOD).add(dreamwoodSet.get(1).key(), dreamwoodSet.get(2).key(), dreamwoodSet.get(3).key(), dreamwoodSet.get(4).key());
        tag(LOGS_HYREWOOD).add(hyrewoodSet.get(1).key(), hyrewoodSet.get(2).key(), hyrewoodSet.get(3).key(), hyrewoodSet.get(4).key());
        tag(LOGS_MINTWOOD).add(mintwoodSet.get(1).key(), mintwoodSet.get(2).key(), mintwoodSet.get(3).key(), mintwoodSet.get(4).key());
        tag(LOGS_VETHEA).addTags(LOGS_FIREWOOD, LOGS_DREAMWOOD, LOGS_HYREWOOD, LOGS_MINTWOOD);
        tag(minecraftTag("logs_that_burn")).addTags(LOGS_DIVINE, LOGS_SHIVERSPINE, LOGS_AURORAOAK, LOGS_COZYBARK, LOGS_STREAMLEAF, LOGS_EUCALYPTUS, LOGS_EDEN, LOGS_CRIMSEEKER, LOGS_WILDWOOD, LOGS_APALACHIA, LOGS_SKYTHERN, LOGS_MORTUM, LOGS_FIREWOOD, LOGS_DREAMWOOD, LOGS_HYREWOOD, LOGS_MINTWOOD);

        tag(BlockTags.OVERWORLD_NATURAL_LOGS).add(divineWoodSet.get(3).key());
        tag(NATURAL_LOGS_ICEIKA).add(shiverspineWoodSet.get(3).key(), auroraoakWoodSet.get(3).key(), cozybarkWoodSet.get(3).key(), streamleafWoodSet.get(3).key());
        tag(NATURAL_LOGS_ARCANA).add(eucalyptusWoodSet.getFirst().key()); // Not so natural, eh?
        tag(NATURAL_LOGS_EDEN).add(edenWoodSet.get(3).key(), crimseekerWoodSet.get(3).key());
        tag(NATURAL_LOGS_WILDWOOD).add(wildwoodWoodSet.get(3).key());
        tag(NATURAL_LOGS_APALACHIA).add(apalachiaWoodSet.get(3).key());
        tag(NATURAL_LOGS_SKYTHERN).add(skythernWoodSet.get(3).key());
        tag(NATURAL_LOGS_MORTUM).add(mortumWoodSet.get(3).key());
        tag(NATURAL_LOGS_VETHEA).add(firewoodSet.get(1).key(), dreamwoodSet.get(1).key(), hyrewoodSet.get(1).key(), mintwoodSet.get(1).key());
        tag(Tags.Blocks.NATURAL_LOGS).addTags(NATURAL_LOGS_ICEIKA, NATURAL_LOGS_ARCANA, NATURAL_LOGS_EDEN, NATURAL_LOGS_WILDWOOD, NATURAL_LOGS_APALACHIA, NATURAL_LOGS_SKYTHERN, NATURAL_LOGS_MORTUM, NATURAL_LOGS_VETHEA);
        tag(Tags.Blocks.NATURAL_WOODS).add(shiverspineWoodSet.get(5).key(), auroraoakWoodSet.get(5).key(), cozybarkWoodSet.get(5).key(), streamleafWoodSet.get(5).key(), eucalyptusWoodSet.get(2).key(), edenWoodSet.get(5).key(), wildwoodWoodSet.get(5).key(), apalachiaWoodSet.get(5).key(), skythernWoodSet.get(5).key(), mortumWoodSet.get(5).key(), firewoodSet.get(3).key(), dreamwoodSet.get(3).key(), hyrewoodSet.get(3).key(), mintwoodSet.get(3).key());

        tag(PLANKS_DESIGN).add(plankDesign.key());
        tag(PLANKS_OVERWORLD).add(divineWoodSet.get(7).key());
        tag(PLANKS_ICEIKA).add(shiverspineWoodSet.get(7).key(), auroraoakWoodSet.get(7).key(), cozybarkWoodSet.get(7).key(), streamleafWoodSet.get(7).key());
        tag(PLANKS_ARCANA).add(eucalyptusWoodSet.get(4).key());
        tag(PLANKS_EDEN).add(edenWoodSet.get(7).key());
        tag(PLANKS_WILDWOOD).add(wildwoodWoodSet.get(7).key());
        tag(PLANKS_APALACHIA).add(apalachiaWoodSet.get(7).key());
        tag(PLANKS_SKYTHERN).add(skythernWoodSet.get(7).key());
        tag(PLANKS_MORTUM).add(mortumWoodSet.get(7).key());
        tag(PLANKS).addTags(PLANKS_DESIGN, PLANKS_OVERWORLD, PLANKS_ICEIKA, PLANKS_ARCANA, PLANKS_EDEN, PLANKS_WILDWOOD, PLANKS_APALACHIA, PLANKS_SKYTHERN, PLANKS_SKYTHERN, PLANKS_MORTUM);
        tag(BlockTags.PLANKS).addTag(PLANKS);

        tag(BlockTags.WOODEN_STAIRS).add(stairDesign.key(), divineWoodSet.get(8).key(), shiverspineWoodSet.get(8).key(), auroraoakWoodSet.get(8).key(), cozybarkWoodSet.get(8).key(), streamleafWoodSet.get(8).key(), eucalyptusWoodSet.get(5).key(), edenWoodSet.get(8).key(), wildwoodWoodSet.get(8).key(), apalachiaWoodSet.get(8).key(), skythernWoodSet.get(8).key(), mortumWoodSet.get(8).key());
        tag(BlockTags.STAIRS).add(asphaltSet.get(1).key(), frozenStoneSet.get(1).key(), cobbledFrozenStoneSet.get(1).key(), frozenBrickSet.get(1).key(), cobaltiteSet.get(1).key(), polishedCobaltiteSet.get(1).key(), coalstoneSet.get(1).key(), coalstoneBrickSet.get(1).key(), polishedCoalstoneSet.get(1).key(), cutOxdriteSet.get(1).key(), arcaniteStoneSet.get(1).key(), arcaniteTileSet.get(1).key(), ancientBrickSet.get(1).key(), ancientBrickSet.get(6).key(), degradedBrickSet.get(1).key(), degradedBrickSet.get(6).key(), twilightStoneSet.get(1).key(), twilightBrickSet.get(1).key(), scorchaltSet.get(1).key(), cobbledScorchaltSet.get(1).key(), polishedScorchaltSet.get(1).key(), rayStoneSet.get(1).key(), polishedRayStoneSet.get(1).key());
        tag(BlockTags.WOODEN_SLABS).add(slabDesign.key(), divineWoodSet.get(9).key(), shiverspineWoodSet.get(9).key(), auroraoakWoodSet.get(9).key(), cozybarkWoodSet.get(9).key(), streamleafWoodSet.get(9).key(), eucalyptusWoodSet.get(6).key(), edenWoodSet.get(9).key(), wildwoodWoodSet.get(9).key(), apalachiaWoodSet.get(9).key(), skythernWoodSet.get(9).key(), mortumWoodSet.get(9).key());
        tag(BlockTags.SLABS).add(asphaltSet.getLast().key(), frozenStoneSet.get(2).key(), cobbledFrozenStoneSet.get(2).key(), frozenBrickSet.get(2).key(), cobaltiteSet.get(2).key(), polishedCobaltiteSet.get(2).key(), coalstoneSet.get(2).key(), coalstoneBrickSet.get(2).key(), polishedCoalstoneSet.get(2).key(), cutOxdriteSet.get(2).key(), arcaniteStoneSet.get(2).key(), arcaniteTileSet.get(2).key(), ancientBrickSet.get(2).key(), ancientBrickSet.get(7).key(), degradedBrickSet.get(2).key(), degradedBrickSet.get(7).key(), twilightStoneSet.get(2).key(), twilightBrickSet.get(2).key(), scorchaltSet.get(2).key(), cobbledScorchaltSet.get(2).key(), polishedScorchaltSet.get(2).key(), rayStoneSet.get(2).key(), polishedRayStoneSet.get(2).key());

        tag(BlockTags.WALL_POST_OVERRIDE).addTag(TORCHES_STANDING);

        tag(FENCES_REDSTONE).add(redFence.key(), greenFence.key(), blueFence.key());
        tag(commonTag("fences/redstone")).addTag(FENCES_REDSTONE);
        tag(FENCES_DIVINE).add(divineWoodSet.get(10).key());
        tag(FENCES_SHIVERSPINE).add(shiverspineWoodSet.get(10).key());
        tag(FENCES_AURORAOAK).add(auroraoakWoodSet.get(10).key());
        tag(FENCES_COZYBARK).add(cozybarkWoodSet.get(10).key());
        tag(FENCES_STREAMLEAF).add(streamleafWoodSet.get(10).key());
        tag(FENCES_EUCALYPTUS).add(eucalyptusWoodSet.get(7).key());
        tag(commonTag("fences/eucalyptus")).addTag(FENCES_EUCALYPTUS);
        tag(FENCES_EDEN).add(edenWoodSet.get(10).key());
        tag(FENCES_WILDWOOD).add(wildwoodWoodSet.get(10).key());
        tag(FENCES_APALACHIA).add(apalachiaWoodSet.get(10).key());
        tag(FENCES_SKYTHERN).add(skythernWoodSet.get(10).key());
        tag(FENCES_MORTUM).add(mortumWoodSet.get(10).key());
        tag(BlockTags.WOODEN_FENCES).addTags(FENCES_DIVINE, FENCES_SHIVERSPINE, FENCES_AURORAOAK, FENCES_COZYBARK, FENCES_STREAMLEAF, FENCES_EUCALYPTUS, FENCES_EDEN, FENCES_WILDWOOD, FENCES_APALACHIA, FENCES_SKYTHERN, FENCES_MORTUM);
        tag(BlockTags.FENCES).addTag(FENCES_REDSTONE);
        tag(Tags.Blocks.FENCES).addTag(FENCES_REDSTONE);

        tag(FENCE_GATES_DIVINE).add(divineWoodSet.get(11).key());
        tag(FENCE_GATES_SHIVERSPINE).add(shiverspineWoodSet.get(11).key());
        tag(FENCE_GATES_AURORAOAK).add(auroraoakWoodSet.get(11).key());
        tag(FENCE_GATES_COZYBARK).add(cozybarkWoodSet.get(11).key());
        tag(FENCE_GATES_STREAMLEAF).add(streamleafWoodSet.get(11).key());
        tag(FENCE_GATES_EUCALYPTUS).add(eucalyptusWoodSet.get(8).key());
        tag(commonTag("fence_gates/eucalyptus")).addTag(FENCE_GATES_EUCALYPTUS);
        tag(FENCE_GATES_EDEN).add(edenWoodSet.get(11).key());
        tag(FENCE_GATES_WILDWOOD).add(wildwoodWoodSet.get(11).key());
        tag(FENCE_GATES_APALACHIA).add(apalachiaWoodSet.get(11).key());
        tag(FENCE_GATES_SKYTHERN).add(skythernWoodSet.get(11).key());
        tag(FENCE_GATES_MORTUM).add(mortumWoodSet.get(11).key());
        tag(BlockTags.FENCE_GATES).addTags(FENCE_GATES_DIVINE, FENCE_GATES_SHIVERSPINE, FENCE_GATES_AURORAOAK, FENCE_GATES_COZYBARK, FENCE_GATES_STREAMLEAF, FENCE_GATES_EUCALYPTUS, FENCE_GATES_EDEN, FENCE_GATES_WILDWOOD, FENCE_GATES_APALACHIA, FENCE_GATES_SKYTHERN, FENCE_GATES_MORTUM);
        tag(Tags.Blocks.FENCE_GATES_WOODEN).addTags(FENCE_GATES_DIVINE, FENCE_GATES_SHIVERSPINE, FENCE_GATES_AURORAOAK, FENCE_GATES_COZYBARK, FENCE_GATES_STREAMLEAF, FENCE_GATES_EUCALYPTUS, FENCE_GATES_EDEN, FENCE_GATES_WILDWOOD, FENCE_GATES_APALACHIA, FENCE_GATES_SKYTHERN, FENCE_GATES_MORTUM);

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
        tag(BlockTags.VALID_SPAWN).addTag(GRASS_BLOCKS).add(frostedAllure.key()); // This one is unused in Vanilla

        tag(BlockTags.BEE_ATTRACTIVE).addTag(FLOWERS);
        tag(BlockTags.BEE_GROWABLES).addTag(CAVE_VINES).add(winterberryBush.key());
        tag(BlockTags.EDIBLE_FOR_SHEEP).add(edenBrush.getFirst().key());
        tag(BlockTags.SNIFFER_DIGGABLE_BLOCK).addTag(GRASS_BLOCKS);
        tag(BlockTags.SNIFFER_EGG_HATCH_BOOST).add(arcaniteMoss.key()); // Also Arcana magic
        tag(BlockTags.ENDERMAN_HOLDABLE).addTag(SANDS).add(glowsproutSet.getFirst().key(), slowsproutSet.getFirst().key(), lowsproutSet.getFirst().key(), lushroom.getFirst().key(), dreamglow.getFirst().key(), frozenGravel.key(), truffle.key());
        tag(BlockTags.STRIDER_WARM_BLOCKS).add(SMOLDERING_TAR_BLOCK.key());
        tag(BlockTags.GUARDED_BY_PIGLINS).addTags(CRATES, CHESTS).add(goldBricks.key(), goldLamp.key(), shiningObsidian.key(), gildedBricks.key());
        tag(BlockTags.PIGLIN_REPELLENTS).add(soulfireLamp.key());
        tag(BlockTags.HAPPY_GHAST_AVOIDS).addTags(FLOWERS_BRAMBLE, METAL_SPIKE_BLOCKS, ACIDS, FIRE).add(heatTrap.key(), karosHeatTile.key());
        tag(BlockTags.DRAGON_IMMUNE).addTags(OBSIDIANS_CRYING, OBSIDIANS_DARK).add(soulSludgeSet.getFirst().key(), soulSludgeDoor.key(), ancientStoneSet.getFirst().key(), soulStoneSet.getFirst().key(), soulStoneDoor.key(), ancientBrickSet.getFirst().key(), ancientBrickSet.get(1).key(), ancientBrickSet.get(2).key(), ancientBrickSet.get(3).key(), ancientBrickSet.get(4).key(), degradedBrickSet.getFirst().key(), degradedBrickSet.get(1).key(), degradedBrickSet.get(2).key(), degradedBrickSet.get(3).key(), degradedBrickSet.get(4).key(), lightDegradedBrick.key(), darkDegradedBrick.key(), ancientTileSet.getFirst().key(), arcaniumMetalSet.getFirst().key(), arcaniumPowerSet.getFirst().key(), battleBricks.key(), gildedBricks.key(), dungeonLampSet.getFirst().key(), dramixAltar.key(), parasectaAltar.key(), arcaniumExtractor.key(), heatTrap.key(), arcanaPortal.key(), everstone.key(), whiteEverstone.key(), darkEverstone.key(), blackHungerstone.key(), greenHungerstone.key(), hallWall.key(), blueKarosBricks.key(), blackKarosBricks.key(), helioticBeam.key(), cryptFloor.key(), cryptWall.key(), chamberWall.key(), shiftedChamberWall.key(), stackedChamberWall.key(), karosAltar.key(), lunicAltar.key(), quadroticAltar.key(), raglokAltar.key(), wreckAltar.key(), infusionTable.key(), karosHeatTile.key(), karosDispenser.key(), terranGhostBlock.key(), dungeonAir.key());
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
        tag(BlockTags.CLIMBABLE).addTags(VINES, CAVE_VINES, LADDERS).add();

        tag(CRATES_WOODEN).add(crate.key());
        tag(commonTag("crates/wooden")).addTag(CRATES_WOODEN);
        tag(CRATES_OXDRITE).add(oxcrate.key());
        tag(CRATES).addTags(CRATES_WOODEN, CRATES_OXDRITE);
        tag(commonTag("crates")).addTag(CRATES);

        tag(CHESTS).add(boneChest.key(), frostedChest.key(), presentBox.key(), edenChest.key());
        tag(commonTag("chests/bone")).add(boneChest.key());
        tag(commonTag("chests/present")).add(presentBox.key());
        tag(Tags.Blocks.CHESTS).addTag(CHESTS);

        tag(Tags.Blocks.PLAYER_WORKSTATIONS_FURNACES).addTag(FURNACES);

        tag(BlockTags.CATS_CAN_SIT_ON).addTags(CRATES, CHESTS, FURNACES);

        tag(OXDRITE_TECH_BLOCKS).add(oxcrate.key(), booster.key(), limiter.key(), oxdriteRail.key(), oxdriteLamp.key(), capacitor.key());
        tag(BlockTags.RAILS).add(oxdriteRail.key());
        tag(METAL_SPIKE_BLOCKS).add(spikeBlock.key(), hotSpikeBlock.key());
        tag(LAMPS_METAL).add(milkyLamp.key(), edenLamp.key(), oxdriteLamp.key(), torriditeLamp.key(), lavaLamp.key(), drakenLamp.key(), realmiteLamp.key(), blazeLamp.key(), goldLamp.key(), arlemiteLamp.key(), krakenLamp.key(), diamondLamp.key(), rupeeLamp.key(), lapisLazuliLamp.key(), aquaLamp.key(), enderLamp.key(), bloodgemLamp.key());
        tag(LAMPS_GEM).add(moltenLamp.key(), divineLamp.key(), jungleLamp.key(), terranLamp.key(), iceLamp.key(), soulfireLamp.key(), enderStoneLamp.key());
        tag(BRIDGES).add(darkBridge.key(), starBridge.key());
        tag(FAIRY_LIGHTS).add(redFairyLights.key(), yellowFairyLights.key(), greenFairyLights.key(), blueFairyLights.key(), purpleFairyLights.key());

        tag(TORCHES_STANDING).add(skeletonTorchSet.getFirst().key(), aquaTorchSet.getFirst().key(), arcaniumTorchSet.getFirst().key(), edenTorchSet.getFirst().key());
        tag(TORCHES_WALL).add(skeletonTorchSet.getLast().key(), aquaTorchSet.getLast().key(), arcaniumTorchSet.getLast().key(), edenTorchSet.getLast().key());
        tag(TORCHES).addTags(TORCHES_STANDING, TORCHES_WALL);

        tag(Tags.Blocks.BOOKSHELVES).add(workshopBookcase.key(), dungeonBookshelf.key());
        tag(BlockTags.ENCHANTMENT_POWER_PROVIDER).add(workshopBookcase.key(), dungeonBookshelf.key());
        tag(BlockTags.ENCHANTMENT_POWER_TRANSMITTER).add(terranGhostBlock.key(), dungeonAir.key());

        tag(BlockTags.CAN_GLIDE_THROUGH).addTag(VINES);

        tag(CANDY_CANES).add(redCandyCane.key(), yellowCandyCane.key(), greenCandyCane.key(), blueCandyCane.key(), pinkCandyCane.key());

        tag(Tags.Blocks.DYEABLE_REDYEABLE_SIMPLE).addTags(STORAGE_BLOCKS_IRREVERSIBLE_STEEL, CANDY_CANES).remove(fancySet.getFirst().key(), fancySet.get(1).key(), fancySet.get(2).key(), fancySet.getLast().key(), workshopCarpetSet.getFirst().key(), workshopCarpetSet.get(1).key(), workshopCarpetSet.getLast().key());
        tag(DYED_BLACK_AND_WHITE).add(checkerSet.getFirst().key(), checkerSet.get(1).key(), checkerSet.get(2).key(), checkerSet.getLast().key());
        tag(Tags.Blocks.DYED_LIGHT_GRAY).add(steel.key());
        tag(Tags.Blocks.DYED_BLACK).add(blackSteel.key());
        tag(Tags.Blocks.DYED_RED).add(redSteel.key(), redCandyCane.key());
        tag(Tags.Blocks.DYED_ORANGE).add(orangeSteel.key());
        tag(Tags.Blocks.DYED_YELLOW).add(yellowSteel.key(), yellowCandyCane.key());
        tag(Tags.Blocks.DYED_GREEN).add(greenSteel.key(), greenCandyCane.key());
        tag(Tags.Blocks.DYED_CYAN).add(cyanSteel.key());
        tag(Tags.Blocks.DYED_BLUE).add(blueSteel.key(), blueCandyCane.key());
        tag(Tags.Blocks.DYED_PURPLE).add(purpleSteel.key());
        tag(Tags.Blocks.DYED_MAGENTA).add(magentaSteel.key());
        tag(Tags.Blocks.DYED_PINK).add(pinkCandyCane.key());
        tag(DYED_RAINBOW).add(rainbowSet.getFirst().key(), rainbowSet.get(1).key(), rainbowSet.get(2).key(), rainbowSet.getLast().key());
        tag(Tags.Blocks.DYED).add(checkerSet.getFirst().key(), checkerSet.get(1).key(), checkerSet.get(2).key(), checkerSet.getLast().key(), rainbowSet.getFirst().key(), rainbowSet.get(1).key(), rainbowSet.get(2).key(), rainbowSet.getLast().key());

        tag(STORAGE_BLOCKS_IRREVERSIBLE_GLOWSTONE).add(toKey(Blocks.GLOWSTONE), blueStone.key());
        tag(STORAGE_BLOCKS_IRREVERSIBLE_OLIVINE).add(olivineBlock.key());
        tag(STORAGE_BLOCKS_IRREVERSIBLE_ANTHRACITE).add(coalstoneSet.getFirst().key(), coalstoneBrickSet.getFirst().key(), chiseledCoalstoneBricks.key(), polishedCoalstoneSet.getFirst().key());
        tag(STORAGE_BLOCKS_IRREVERSIBLE_STEEL).add(steel.key(), blackSteel.key(), redSteel.key(), orangeSteel.key(), yellowSteel.key(), greenSteel.key(), cyanSteel.key(), blueSteel.key(), purpleSteel.key(), magentaSteel.key());
        tag(STORAGE_BLOCKS_IRREVERSIBLE_ARCANIC_SAND).add(arcanicSand.key());
        tag(STORAGE_BLOCKS_IRREVERSIBLE_ARCANIUM_RICH_SAND).add(arcaniumRichSand.key());
        tag(STORAGE_BLOCKS_IRREVERSIBLE_EDEN).add(edenBlock.key());
        tag(STORAGE_BLOCKS_IRREVERSIBLE_WILDWOOD).add(wildwoodBlock.key());
        tag(STORAGE_BLOCKS_IRREVERSIBLE_APALACHIA).add(apalachiaBlock.key());
        tag(STORAGE_BLOCKS_IRREVERSIBLE_SKYTHERN).add(skythernBlock.key());
        tag(STORAGE_BLOCKS_IRREVERSIBLE_MORTUM).add(mortumBlock.key());

        tag(STORAGE_BLOCKS_RAW_REALMITE).add(realmiteBlockSet.getFirst().key());
        tag(STORAGE_BLOCKS_REALMITE).add(realmiteBlockSet.getLast().key());
        tag(STORAGE_BLOCKS_RAW_ARLEMITE).add(arlemiteBlockSet.getFirst().key());
        tag(STORAGE_BLOCKS_ARLEMITE).add(arlemiteBlockSet.getLast().key());
        tag(STORAGE_BLOCKS_RAW_RUPEE).add(rupeeBlockSet.getFirst().key());
        tag(STORAGE_BLOCKS_RUPEE).add(rupeeBlockSet.getLast().key());
        tag(STORAGE_BLOCKS_SHADOW).add(shadowBlock.key());
        tag(STORAGE_BLOCKS_BLOODGEM).add(bloodgemBlock.key());
        tag(STORAGE_BLOCKS_RAW_TORRIDITE).add(torriditeBlockSet.getFirst().key());
        tag(STORAGE_BLOCKS_TORRIDITE).add(torriditeBlockSet.getLast().key());
        tag(STORAGE_BLOCKS_RAW_OXDRITE).add(oxdriteBlockSet.getFirst().key());
        tag(STORAGE_BLOCKS_OXDRITE).add(oxdriteBlockSet.getLast().key());
        tag(STORAGE_BLOCKS_RAW_ARCANIUM).add(rawArcanium.key());
        tag(STORAGE_BLOCKS_ARCANIUM).add(arcaniumBlock.key());
        tag(Tags.Blocks.STORAGE_BLOCKS).addTags(STORAGE_BLOCKS_RAW_REALMITE, STORAGE_BLOCKS_REALMITE, STORAGE_BLOCKS_RAW_ARLEMITE, STORAGE_BLOCKS_ARLEMITE, STORAGE_BLOCKS_RAW_RUPEE, STORAGE_BLOCKS_RUPEE, STORAGE_BLOCKS_SHADOW, STORAGE_BLOCKS_BLOODGEM, STORAGE_BLOCKS_RAW_TORRIDITE, STORAGE_BLOCKS_TORRIDITE, STORAGE_BLOCKS_RAW_OXDRITE, STORAGE_BLOCKS_OXDRITE, STORAGE_BLOCKS_RAW_ARCANIUM, STORAGE_BLOCKS_ARCANIUM);
        tag(BlockTags.BEACON_BASE_BLOCKS).addTags(STORAGE_BLOCKS_REALMITE, STORAGE_BLOCKS_ARLEMITE, STORAGE_BLOCKS_RUPEE, STORAGE_BLOCKS_SHADOW, STORAGE_BLOCKS_BLOODGEM, STORAGE_BLOCKS_TORRIDITE, STORAGE_BLOCKS_OXDRITE, STORAGE_BLOCKS_ARCANIUM, STORAGE_BLOCKS_IRREVERSIBLE_EDEN, STORAGE_BLOCKS_IRREVERSIBLE_WILDWOOD, STORAGE_BLOCKS_IRREVERSIBLE_APALACHIA, STORAGE_BLOCKS_IRREVERSIBLE_SKYTHERN, STORAGE_BLOCKS_IRREVERSIBLE_MORTUM);

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

        tag(BlockTags.DANGEROUS_FOR_TELEPORTATION).addTags(FLOWERS_BRAMBLE, METAL_SPIKE_BLOCKS, ACIDS, FIRE).add(icicle.key(), heatTrap.key(), karosHeatTile.key());

        /* This one is kinda broken (see MC-309259).
        Dunno if they are gonna make waterloggable blocks able to be washed away, but if so — add Aqua Torches back to the tag. */
        tag(BlockTags.WASHED_AWAY_BY_FLUIDS).addTags(CROPS, FLOWERS_SMALL, FLOWERS_TALL, GRASS, VINES, CAVE_VINES, STATUES, TORCHES, ACIDS).add(winterberryBush.key(), arcanaBush.getFirst().key(), snowyMoss.key(), glowsproutSet.getFirst().key(), slowsproutSet.getFirst().key(), lowsproutSet.getFirst().key(), lushroom.getFirst().key(), duncap.key(), dreamglow.getFirst().key(), robbinNest.key(), booster.key(), limiter.key(), SMOLDERING_TAR_BLOCK.key()).remove(terranGhostBlock.key(), dungeonAir.key(), aquaTorchSet.getFirst().key(), aquaTorchSet.getLast().key());
        tag(BlockTags.BLOCKS_MOTION_NO_LEAVES).addTags(OBSIDIANS_CRYING, STORAGE_BLOCKS_RAW_REALMITE, STORAGE_BLOCKS_REALMITE, STORAGE_BLOCKS_RAW_ARLEMITE, STORAGE_BLOCKS_ARLEMITE, STORAGE_BLOCKS_RAW_RUPEE, STORAGE_BLOCKS_RUPEE, STORAGE_BLOCKS_SHADOW, STORAGE_BLOCKS_BLOODGEM, STORAGE_BLOCKS_RAW_TORRIDITE, STORAGE_BLOCKS_TORRIDITE, STORAGE_BLOCKS_RAW_OXDRITE, STORAGE_BLOCKS_OXDRITE, STORAGE_BLOCKS_RAW_ARCANIUM, STORAGE_BLOCKS_ARCANIUM, STORAGE_BLOCKS_IRREVERSIBLE_OLIVINE, STORAGE_BLOCKS_IRREVERSIBLE_ANTHRACITE, STORAGE_BLOCKS_IRREVERSIBLE_STEEL, STORAGE_BLOCKS_IRREVERSIBLE_EDEN, STORAGE_BLOCKS_IRREVERSIBLE_WILDWOOD, STORAGE_BLOCKS_IRREVERSIBLE_APALACHIA, STORAGE_BLOCKS_IRREVERSIBLE_SKYTHERN, STORAGE_BLOCKS_IRREVERSIBLE_MORTUM, CANDY_CANES, MINIBRICKS, COLORED_BRICKS, TWILIGHT_BRICKS, LAMPS_GEM, LAMPS_METAL, BRIDGES, SPAWNERS, MOSS_BLOCKS, PUMPKINS, CRATES, CHESTS, FURNACES, METAL_SPIKE_BLOCKS).add(gelidite.key(), frozenGravel.key(), soulSludgeSet.getFirst().key(), soulSludgeSet.getLast().key(), frozenStoneSet.getFirst().key(), cobbledFrozenStoneSet.getFirst().key(), frozenBrickSet.getFirst().key(), snowBricks.key(), thermalVent.key(), cobaltiteSet.getFirst().key(), polishedCobaltiteSet.getFirst().key(), icyStone.key(), blueStone.key(), arcaniteStoneSet.getFirst().key(), arcaniteTileSet.getFirst().key(), ancientStoneSet.getFirst().key(), ancientStoneSet.getLast().key(), soulStoneSet.getFirst().key(), soulStoneSet.getLast().key(), twilightStoneSet.getFirst().key(), twilightBrickSet.getFirst().key(), milkStone.key(), scorchaltSet.getFirst().key(), cobbledScorchaltSet.getFirst().key(), polishedScorchaltSet.getFirst().key(), chiseledScorchalt.key(), exposedScorchalt.key(), rayStoneSet.getFirst().key(), polishedRayStoneSet.getFirst().key(), draughtStone.key(), divineMossStone.key(), divineRock.key(), dreamStone.key(), lunaStone.key(), everstone.key(), whiteEverstone.key(), darkEverstone.key(), blackHungerstone.key(), greenHungerstone.key(), hiveWall.key(), fireCrystal.key(), firelight.key(), arcanaPortalFrame.key(), buddingOlivine.key(), olivineCluster.key(), buddingDravite.key(), glowsproutSet.getLast().key(), glowsproutSet.get(2).key(), lowsproutSet.getLast().key(), lowsproutSet.get(2).key(), slowsproutSet.getLast().key(), slowsproutSet.get(2).key(), asphaltSet.getFirst().key(), darkstone.key(), workshopBookcase.key(), cutOxdriteSet.getFirst().key(), ancientBrickSet.getFirst().key(), lightDegradedBrick.key(), darkDegradedBrick.key(), degradedBrickSet.getFirst().key(), ancientTileSet.getFirst().key(), arcaniumMetalSet.getFirst().key(), arcaniumPowerSet.getFirst().key(), battleBricks.key(), gildedBricks.key(), ancientBrickSet.get(5).key(), dungeonBookshelf.key(), degradedBrickSet.get(5).key(), ancientTileSet.getLast().key(), arcaniumMetalSet.getLast().key(), arcaniumPowerSet.getLast().key(), hallWall.key(), blackKarosBricks.key(), blueKarosBricks.key(), cryptFloor.key(), cryptWall.key(), chamberWall.key(), shiftedChamberWall.key(), stackedChamberWall.key(), redDreamBricks.key(), lightDreamBricks.key(), darkDreamBricks.key(), lunaBricks.key(), metalCaging.key(), helioticBeam.key(), workshopLamp.key(), slimeLight.key(), dungeonLampSet.getFirst().key(), dungeonLampSet.getLast().key(), dreamLamp.key(), cellLamp.key(), villageLamp.key(), frostedGlass.key(), stainedGlass.key(), smoothGlass.key(), landVineStem.key(), truffle.key(), altarOfCorruption.key(), arcaniumExtractor.key(), infusionTable.key(), inserter.key(), distributor.key(), hellfireSponge.key(), coldHellfireSponge.key(), frostedAllure.key(), soulTrap.key(), gravestone.key(), robbinHut.key(), acceleron.key(), elevantium.key(), capacitor.key(), miner.key(), softMiner.key(), placer.key(), heatTrap.key(), karosHeatTile.key(), karosDispenser.key(), gateway.key(), randomItemDropper.key());
    }
    private ResourceKey<Block> toKey(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).orElseThrow();
    }
    private TagKey<Block> minecraftTag(String name){
        return TagKey.create(BLOCK, Identifier.withDefaultNamespace(name));
    }
    private TagKey<Block> commonTag(String name){
        return TagKey.create(BLOCK, Identifier.fromNamespaceAndPath("c", name));
    }
}