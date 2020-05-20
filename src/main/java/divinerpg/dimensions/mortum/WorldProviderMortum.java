package divinerpg.dimensions.mortum;

import divinerpg.registry.ModBiomes;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

import divinerpg.registry.ModDimensions;

public class WorldProviderMortum extends WorldProvider {
	
	@Override
	public void init() {
		this.biomeProvider = new BiomeProviderSingle(ModBiomes.biomeMortum);
		this.nether = false;
		this.hasSkyLight = true;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new MortumChunkGenerator(this.world, this.world.getSeed() + this.getDimension());
	}
	@Override
    protected void generateLightBrightnessTable() {
        float var1 = 0.1F;
        for (int var2 = 0; var2 <= 15; ++var2) {
            float var3 = 1.0F - var2 / 15.0F;
            this.lightBrightnessTable[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
        }
    }
	
	@Override
    public float calculateCelestialAngle(long var1, float var3) {
        return 0.5F;
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
        return 128.0F;
    }

	@Override
    public int getAverageGroundLevel() {
        return 70;
    }

	@Override
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(int x, int z) {
        return false;
    }

	@Override
	public DimensionType getDimensionType() {
		return ModDimensions.mortumDimension;
	}
	@Nullable
    @Override
	public String getSaveFolder()
    {
        return "Mortum";
    }
}