package net.divinerpg.dimensions.vethea;

import net.divinerpg.utils.DimensionHelper;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderVethea extends WorldProvider {
	
	public void registerWorldChunkManager()  {
		this.worldChunkMgr = new WorldChunkManagerHell(DimensionHelper.Vethea, 1.0F);
		this.dimensionId = ConfigurationHelper.vethea;
	}

	public float getCloudHeight() {
		return 256.0F;
	}

	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderVethea(this.worldObj, this.worldObj.getSeed());
	}

	public boolean isSurfaceWorld() {
		return false;
	}

	public boolean canCoordinateBeSpawn(int var1, int var2) {
		return false;
	}

	public float calculateCelestialAngle(long var1, float var3) {
		return 0.3F;
	}

	public boolean canRespawnHere() {
		return false;
	}

	public String getSaveFolder() {
		return "Vethea";
	}

	public double getMovementFactor() {
		return 1.0D;
	}

	public String getDimensionName() {
		return "Vethea";
	}
}