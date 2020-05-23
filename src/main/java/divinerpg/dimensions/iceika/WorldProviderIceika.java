package divinerpg.dimensions.iceika;

import divinerpg.registry.DimensionRegistry;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

import divinerpg.proxy.ClientProxy;

public class WorldProviderIceika extends WorldProvider {
	
	@Override
	public void init() {
		this.biomeProvider = new BiomeProviderIceika();
		this.nether = false;
		this.hasSkyLight = true;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkProviderIceika(this.world, this.world.getSeed() + this.getDimension());
	}

    @Nullable
    @SideOnly(Side.CLIENT)
    public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks)
    {
        return null;
    }

    @Override
    public boolean isSkyColored() {
        return false;
    }

    public float calculateCelestialAngle(long worldTime, float partialTicks)
    {
        return 0.5f;
    }

    @Nullable
    @Override
    public MusicTicker.MusicType getMusicType() {
        return ClientProxy.Music_Iceika;
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }

	@Override
    public boolean isSurfaceWorld() {
        return false;
    }

	@Override
    @SideOnly(Side.CLIENT)
    public float getCloudHeight() {
        return 8.0F;
    }

	@Override
    public int getAverageGroundLevel() {
        return 72;
    }

	@Override
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(int x, int z) {
        return false;
    }

	@Override
	public DimensionType getDimensionType() {
		return DimensionRegistry.iceikaDimension;
	}
	@Nullable
    @Override
	public String getSaveFolder()
    {
        return "Iceika";
    }
}