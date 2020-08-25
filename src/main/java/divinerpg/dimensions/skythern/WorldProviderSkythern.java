package divinerpg.dimensions.skythern;

import divinerpg.dimensions.IslandChunkGeneratorBase;
import divinerpg.dimensions.eden.EdenChunkGenerator;
import divinerpg.dimensions.wildwood.WildwoodChunkGenerator;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.BiomeRegistry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProvider.WorldSleepResult;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

import divinerpg.registry.DimensionRegistry;

public class WorldProviderSkythern extends WorldProvider {

    @Override
    public void init() {
        this.biomeProvider = new BiomeProviderSingle(BiomeRegistry.biomeSkythern);
        this.nether = false;
        this.hasSkyLight = true;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new SkythernChunkGenerator(world);
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
    public int getAverageGroundLevel() {
        return 70;
    }

    @Override
    public DimensionType getDimensionType() {
        return DimensionRegistry.skythernDimension;
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) { return 0.2F; }

    @Nullable
    @Override
    public String getSaveFolder()
    {
        return "Skythern";
    }
}