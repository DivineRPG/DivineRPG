package net.divinerpg.dimensions.twilight.eden;

import net.divinerpg.utils.DimensionHelper;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderEden extends WorldProvider {

    @Override
    public void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerHell(DimensionHelper.edenBiome, 0.5F);
        this.dimensionId = ConfigurationHelper.eden;
        isHellWorld = false;
    }
    
    @Override
    public String getSaveFolder() {
    	return "Eden";
    }

    @Override
    public float getCloudHeight() {
        return 128.0F;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public Vec3 getFogColor(float f, float f1){
        return Vec3.createVectorHelper(0.1361F, 0.95F, 1.0F);
    }

    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderEden(this.worldObj, this.worldObj.getSeed());
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
        return "Eden";
    }
}
