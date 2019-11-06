package divinerpg.dimensions.vethea;

import divinerpg.api.java.divinerpg.api.Reference;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.Random;

public class BiomeVethea extends Biome {
    private static BiomeProperties properties = new BiomeProperties("Arksiane").setRainDisabled();
    private World world;
    private Random rand;
    private BlockPos pos;

    public BiomeVethea() {
        super(properties);
        this.setRegistryName(Reference.MODID, "Arksiane");

        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.topBlock = ModBlocks.dreamGrass.getDefaultState();
        this.fillerBlock = ModBlocks.dreamDirt.getDefaultState();
        this.flowers.clear();
        this.decorator.flowersPerChunk = 0;
        this.decorator.grassPerChunk = 0;
    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {
    }
}