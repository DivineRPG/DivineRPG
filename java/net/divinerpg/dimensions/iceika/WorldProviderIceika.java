package net.divinerpg.dimensions.iceika;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.divinerpg.utils.DimensionHelper;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderIceika extends WorldProvider{

	@Override
	public void registerWorldChunkManager() {
		this.dimensionId = ConfigurationHelper.iceika;
		this.worldChunkMgr = new WorldChunkManagerHell(DimensionHelper.iceikaBiome, 1.0F);
		this.hasNoSky=false;
	}

	@Override
	public float getCloudHeight() {
		return 128.0F;
	}

	public boolean canDoRainSnowIce(Chunk chunk)
	{
		return true;
	}

	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderIceika(this.worldObj, this.worldObj.getSeed());
	}
	
	@Override
	protected void generateLightBrightnessTable() {
        float f = 0.2F;

        for (int i = 0; i <= 15; ++i) {
            float f1 = 1.0F - (float)i / 15.0F;
            this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
        }
    }

	@SideOnly(Side.CLIENT)
    public float[] calcSunriseSunsetColors(float p_76560_1_, float p_76560_2_) {
	    return null;
    }
	@Override
	public boolean isSurfaceWorld() {
		return true;

	}
	
	@Override
	public float calculateCelestialAngle(long var1, float var3) {
		return 0.5F;
	}


	@Override
	public boolean canRespawnHere() {
		return true;
	}

	public boolean canCoordinateBeSpawn(int var1, int var2) {
		return true;
	}

	@Override
	public String getDimensionName() {
		return "Iceika";
	}

	@Override
	public String getSaveFolder() {
		return "Iceika";
	}

}