package divinerpg.dimensions.arcana;

import java.util.Random;

import divinerpg.api.java.divinerpg.api.Reference;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class BiomeArcana extends Biome {
    private static BiomeProperties properties = new BiomeProperties("Arcana").setRainDisabled();
    private World world;
    private Random rand;
    private BlockPos pos;

    public BiomeArcana() {
        super(properties);
        this.setRegistryName(Reference.MODID, "arcana");

        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.flowers.clear();
        this.decorator.flowersPerChunk = 0;
        this.decorator.grassPerChunk = 0;
    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {
    }
}