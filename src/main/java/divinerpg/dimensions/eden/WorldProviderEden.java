package divinerpg.dimensions.eden;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

import divinerpg.registry.ModDimensions;

public class WorldProviderEden extends WorldProvider {
	
	@Override
	public void init() {
		this.biomeProvider = new BiomeProviderEden();
		this.nether = false;
		this.hasSkyLight = true;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorEden(this.world, this.world.getSeed() + this.getDimension());
	}
	
	@Override
    public BiomeProvider getBiomeProvider() {
		return this.biomeProvider;
	}

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
        return 0.1f;
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
        return 70;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Vec3d getFogColor(float f, float f1){
        return new Vec3d(0.1361F, 0.95F, 1.0F);
    }

	@Override
	public DimensionType getDimensionType() {
		return ModDimensions.edenDimension;
	}
	@Nullable
    @Override
	public String getSaveFolder()
    {
        return "Eden";
    }
}