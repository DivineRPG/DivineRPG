package net.divinerpg.dimensions.iceika;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.ChunkPosition;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;

public class WorldChunkManagerIceika extends WorldChunkManager {
	
    private BiomeGenBase biomeGenerator;
    private float hellTemperature;
    private float rainfall;

    public WorldChunkManagerIceika(BiomeGenBase var1) {
        this.biomeGenerator = var1;
        this.rainfall = 1.0F;
    }

    @Override
    public BiomeGenBase getBiomeGenAt(int var1, int var2) {
        return this.biomeGenerator;
    }

    @Override
    public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] var1, int var2, int var3, int var4, int var5) {
        if (var1 == null || var1.length < var4 * var5)
            var1 = new BiomeGenBase[var4 * var5];
        
        Arrays.fill(var1, 0, var4 * var5, this.biomeGenerator);
        return var1;
    }

    @Override
    public float[] getRainfall(float[] var1, int var2, int var3, int var4, int var5) {
        if (var1 == null || var1.length < var4 * var5)
            var1 = new float[var4 * var5];

        Arrays.fill(var1, 0, var4 * var5, this.rainfall);
        return var1;
    }

    @Override
    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] var1, int var2, int var3, int var4, int var5) {
        if (var1 == null || var1.length < var4 * var5)
            var1 = new BiomeGenBase[var4 * var5];

        Arrays.fill(var1, 0, var4 * var5, this.biomeGenerator);
        return var1;
    }

    @Override
    public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] var1, int var2, int var3, int var4, int var5, boolean var6) {
        return this.loadBlockGeneratorData(var1, var2, var3, var4, var5);
    }
 
    @Override
    public ChunkPosition findBiomePosition(int var1, int var2, int var3, List var4, Random var5) {
        return var4.contains(this.biomeGenerator) ? new ChunkPosition(var1 - var3 + var5.nextInt(var3 * 2 + 1), 0, var2 - var3 + var5.nextInt(var3 * 2 + 1)) : null;
    }
 
    @Override
    public boolean areBiomesViable(int var1, int var2, int var3, List var4) {
        return var4.contains(this.biomeGenerator);
    }
}
