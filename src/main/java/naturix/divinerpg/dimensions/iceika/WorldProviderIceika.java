package naturix.divinerpg.dimensions.iceika;

import javax.annotation.Nullable;

import naturix.divinerpg.dimensions.iceika.biome.BiomeProviderIceika;
import naturix.divinerpg.dimensions.iceika.chunk.ChunkProviderIceika;
import naturix.divinerpg.proxy.ClientProxy;
import naturix.divinerpg.registry.ModBiomes;
import naturix.divinerpg.registry.ModDimensions;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderIceika extends WorldProvider {
	
	@Override
	public void init() {
		this.biomeProvider = new BiomeProviderSingle(ModBiomes.Iceika);
		this.nether = false;
		this.hasSkyLight = true;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkProviderIceika(this.world, this.world.getSeed() + this.getDimension());
	}
	
	@Override
    public BiomeProvider getBiomeProvider() {
		return this.biomeProvider = new BiomeProviderIceika();
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
		return ModDimensions.iceikaDimension;
	}
	@Nullable
    @Override
	public String getSaveFolder()
    {
        return "Iceika";
    }
}