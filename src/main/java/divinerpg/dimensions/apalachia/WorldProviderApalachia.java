package divinerpg.dimensions.apalachia;

import divinerpg.dimensions.IslandChunkGeneratorBase;
import divinerpg.registry.BiomeRegistry;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.DimensionRegistry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class WorldProviderApalachia extends WorldProvider {
	
	@Override
	public void init() {
        this.biomeProvider = new BiomeProviderSingle(BiomeRegistry.biomeApalachia);
		this.nether = false;
		this.hasSkyLight = true;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new IslandChunkGeneratorBase(this.world, BlockRegistry.twilightStone, BlockRegistry.apalachiaGrass, BlockRegistry.apalachiaDirt);
	}
	
    @Override
	public int getMoonPhase(long s) {
        return (int)(s / 24000L % 8L + 8L) % 8;
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

	@Override
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(int x, int z) {
        return false;
    }

	@Override
	public DimensionType getDimensionType() {
		return DimensionRegistry.apalachiaDimension;
	}
	@Nullable
    @Override
	public String getSaveFolder()
    {
        return "Apalachia";
    }
}