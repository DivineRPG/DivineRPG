package divinerpg.world.vethea;

import com.google.common.collect.*;
import com.mojang.serialization.*;
import com.mojang.serialization.codecs.*;
import divinerpg.*;
import divinerpg.util.WeightedRandom;
import divinerpg.world.*;
import divinerpg.world.arcana.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.biome.provider.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.*;
import net.minecraft.world.gen.settings.*;

import java.util.*;

public class VetheaChunkGenerator extends DivineChunkGenerator {
    private final List<VetheaLevelGenerators> levels = new ArrayList<>();
    private int floorHeight = 48;
    private int roofHeight = 16;
    protected Random rand;

    public static final Codec<VetheaChunkGenerator> CODEC = RecordCodecBuilder.create(
            (instance) -> instance.group(
                    BiomeProvider.CODEC.fieldOf("biome_source").forGetter((surfaceChunkGenerator) -> surfaceChunkGenerator.biomeSource),
                    DimensionStructuresSettings.CODEC.fieldOf("structures").forGetter((ChunkGenerator::getSettings))
            ).apply(instance, instance.stable(VetheaChunkGenerator::new)));


    public VetheaChunkGenerator(BiomeProvider provider, DimensionStructuresSettings settings) {
        super(provider, settings);
        this.rand = new Random();



        for (int i = 0; i < 4; i++) {
            VetheaLevelGenerators level = new VetheaLevelGenerators(floorHeight * i, roofHeight);
            levels.add(level);
        }
    }

    @Override
    protected Codec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    @Override
    public void applyBiomeDecoration(WorldGenRegion region, StructureManager structureManager) {
        int x = region.getCenterX() * 16;
        int z = region.getCenterZ() * 16;
        BlockPos pos = new BlockPos(x, 0, z);
        long worldSeed = region.getSeed();

        Random random = region.getRandom();
        levels.forEach(level -> level.populate(region, random, region.getCenterX(), region.getCenterZ()));

        this.rand.setSeed(region.getSeed());
        long k = this.rand.nextLong() / 2L * 2L + 1L;
        long l = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(region.getCenterX() * k + region.getCenterZ() * l ^ region.getSeed());

        Biome biome = region.getBiome(new BlockPos(x, 0, z));

        if(this.rand.nextInt(100) == 0) {
            int y = 20 + this.rand.nextInt(8);

            List<ResourceLocation> locations = new ArrayList<>();
            locations.add(new ResourceLocation(DivineRPG.MODID, "vethea/layer1/houses/hunger_house_1"));
            locations.add(new ResourceLocation(DivineRPG.MODID, "vethea/layer1/houses/hunger_house_2"));
            locations.add(new ResourceLocation(DivineRPG.MODID, "vethea/layer1/houses/hunger_house_3"));
            Template template = region.getLevel().getStructureManager().get(locations.get(random.nextInt(locations.size())));

            if (template != null) {
                template.placeInWorld(region,
                        new BlockPos(x, y + 12, z),
                        new PlacementSettings().setIgnoreEntities(false).setMirror(Mirror.NONE).addProcessor(DivineStructureBlockProcessor.INSTANCE), random);
            }
        }
        this.rand.setSeed(region.getCenterX() * k + region.getCenterZ() * l ^ region.getSeed());
        customize(region, pos);
        super.applyBiomeDecoration(region, structureManager);
    }




    private void customize(WorldGenRegion region, BlockPos pos) {
        Random random = region.getRandom();
        // ************************************************************************************
        WeightedRandom<ResourceLocation> allLevels = new WeightedRandom();
        WeightedRandom<ResourceLocation> level1 = new WeightedRandom();
        WeightedRandom<ResourceLocation> level2 = new WeightedRandom();
        WeightedRandom<ResourceLocation> level3 = new WeightedRandom();
        allLevels.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/all_floors/bow"), 4);
        allLevels.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/all_floors/floatingtree1"), 4);
        allLevels.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/all_floors/floatingtree2"), 4);
        allLevels.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/all_floors/floatingtree3"), 4);
        allLevels.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/all_floors/floatingtree4"), 4);
        allLevels.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/all_floors/floatingtree5"), 4);
        allLevels.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/all_floors/floatingtree6"), 4);
        allLevels.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/all_floors/floatingtree7"), 4);
        allLevels.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/all_floors/hook"), 4);
        allLevels.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/all_floors/lamp1"), 4);
        allLevels.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/all_floors/lamp2"), 4);
        allLevels.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/all_floors/mushroom"), 4);
        allLevels.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/all_floors/pickaxe"), 4);
        allLevels.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/all_floors/pointedsquare"), 4);
        allLevels.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/all_floors/ring"), 4);
        allLevels.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/all_floors/sword"), 4);
        allLevels.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/all_floors/trident"), 4);


        level1.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/layer1/tree4"), 4);
        level1.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/layer1/tree5"), 4);
        level1.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/layer1/tree6"), 4);

        level2.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/layer2/tree3"), 4);


        level3.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/layer3/tree7"), 4);
        level3.addItem(new ResourceLocation(DivineRPG.MODID, "vethea/layer3/tree8"), 4);

        List<BlockPos> posList = new ArrayList<>();
        BlockPos bottom = BlockPos.betweenClosed(new BlockPos(pos.getX(), 18, pos.getZ()), new BlockPos(pos.getX(), 37, pos.getZ())).iterator().next();
        BlockPos second = BlockPos.betweenClosed(new BlockPos(pos.getX(), 65, pos.getZ()), new BlockPos(pos.getX(), 86, pos.getZ())).iterator().next();
        BlockPos third = BlockPos.betweenClosed(new BlockPos(pos.getX(), 113, pos.getZ()), new BlockPos(pos.getX(), 134, pos.getZ())).iterator().next();
        BlockPos top = BlockPos.betweenClosed(new BlockPos(pos.getX(), 161, pos.getZ()), new BlockPos(pos.getX(), region.getMaxBuildHeight()-1, pos.getZ())).iterator().next();
        posList.addAll(ImmutableList.of(bottom, second, third, top));


        Template template = region.getLevel().getStructureManager().get(allLevels.selectRandomItem(random));
        if (template != null) {
            template.placeInWorld(region, posList.get(random.nextInt(posList.size())).above(random.nextInt(12)), new PlacementSettings().setIgnoreEntities(false).setMirror(Mirror.NONE).addProcessor(DivineStructureBlockProcessor.INSTANCE), random);
        }


        Template infusion = region.getLevel().getStructureManager().get(new ResourceLocation(DivineRPG.MODID, "vethea/all_floors/infusionoutpost"));
        if (infusion != null && random.nextInt(500) == 0) {
            infusion.placeInWorld(region, posList.get(random.nextInt(posList.size())), new PlacementSettings().setIgnoreEntities(false).setMirror(Mirror.NONE).addProcessor(DivineStructureBlockProcessor.INSTANCE), random);
        }

        Template cryptTemplate = region.getLevel().getStructureManager().get(new ResourceLocation(DivineRPG.MODID, "vethea/layer1/crypt"));
        Template cryptTemplate2 = region.getLevel().getStructureManager().get(new ResourceLocation(DivineRPG.MODID, "vethea/layer1/crypt2"));
        if(cryptTemplate!=null && random.nextInt(500) == 0) {
            if (random.nextBoolean()) {
                cryptTemplate.placeInWorldChunk(region, bottom.below(6), new PlacementSettings().setIgnoreEntities(false).setMirror(Mirror.NONE).addProcessor(DivineStructureBlockProcessor.INSTANCE), random);
            } else {
                cryptTemplate2.placeInWorldChunk(region, bottom.below(8), new PlacementSettings().setIgnoreEntities(false).setMirror(Mirror.NONE).addProcessor(DivineStructureBlockProcessor.INSTANCE), random);
            }
        }
        Template layer2 = region.getLevel().getStructureManager().get(new ResourceLocation(DivineRPG.MODID, random.nextBoolean() ? "vethea/layer2/hive" : "vethea/layer2/temple"));
        if(layer2!=null && random.nextInt(500) == 0){
            layer2.placeInWorldChunk(region, second.below(1), new PlacementSettings().setIgnoreEntities(false).setMirror(Mirror.NONE).addProcessor(DivineStructureBlockProcessor.INSTANCE), random);
        }
        Template layer3 = region.getLevel().getStructureManager().get(new ResourceLocation(DivineRPG.MODID, random.nextBoolean() ? "vethea/layer3/karos" : "vethea/layer3/quadrotic"));
        if(layer3!=null && random.nextInt(500) == 0){
            layer3.placeInWorldChunk(region, third.below(1), new PlacementSettings().setIgnoreEntities(false).setMirror(Mirror.NONE).addProcessor(DivineStructureBlockProcessor.INSTANCE), random);
        }
        List<ResourceLocation> layer4List = new ArrayList<>();
        layer4List.addAll(ImmutableList.of(
                new ResourceLocation(DivineRPG.MODID, "vethea/layer4/evergarden"),
                new ResourceLocation(DivineRPG.MODID, "vethea/layer4/layer4tree1"),
                new ResourceLocation(DivineRPG.MODID, "vethea/layer4/layer4tree2"),
                new ResourceLocation(DivineRPG.MODID, "vethea/layer4/raglokchamber"),
                new ResourceLocation(DivineRPG.MODID, "vethea/layer4/wreckhall")
        ));
        Template layer4 = region.getLevel().getStructureManager().get(layer4List.get(random.nextInt(layer4List.size())));
        if(layer4!=null && random.nextInt(500) == 0){
            layer4.placeInWorldChunk(region, top.below(1), new PlacementSettings().setIgnoreEntities(false).setMirror(Mirror.NONE).addProcessor(DivineStructureBlockProcessor.INSTANCE), random);
        }
    }


}