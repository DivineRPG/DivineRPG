package net.divinerpg.dimension.gen.iceika;

import net.divinerpg.helper.DimensionHelper;
import net.divinerpg.helper.config.ConfigurationHelper;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderIceika extends WorldProvider{

	@Override
	public void registerWorldChunkManager() {
		this.dimensionId = ConfigurationHelper.iceika;
		this.worldChunkMgr = new WorldChunkManagerHell(DimensionHelper.Iceika, 1.0F);
	}

	@Override
	public float getCloudHeight() {
		return 128.0F;
	}
	
	@Override
	public boolean canSnowAt(int x, int y, int z, boolean checkLight) {
		return true;
	}

	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderIceika(this.worldObj, this.worldObj.getSeed());
	}

	@Override
	public boolean isSurfaceWorld() {
		return false;

	}
	
	@Override
	public float calculateCelestialAngle(long var1, float var3) {
		return 0.3F;
	}


	@Override
	public boolean canRespawnHere() {
		return false;
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