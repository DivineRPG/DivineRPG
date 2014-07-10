package net.divinerpg.dimensions.twilight.wild_woods;

import net.divinerpg.utils.DimensionHelper;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderWildWoods extends WorldProvider {

    @Override
    public void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerHell(DimensionHelper.WildWoods, 0.5F);
        this.dimensionId = ConfigurationHelper.wildwood;
        isHellWorld = false;
    }
    
    @Override
    public String getSaveFolder() {
    	return "Wild Woods";
    }

    @Override
    public float getCloudHeight() {
        return 128.0F;
    }

    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderWildWoods(this.worldObj, this.worldObj.getSeed());
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public float calculateCelestialAngle(long var1, float var3) {
        return 0.1F;
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }
    
    @Override
    public String getDimensionName() {
        return "Wild Woods";
    }
}
