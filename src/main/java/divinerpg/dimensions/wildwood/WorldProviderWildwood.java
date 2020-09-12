package divinerpg.dimensions.wildwood;

import divinerpg.dimensions.IslandChunkGeneratorBase;
import divinerpg.dimensions.apalachia.ApalachiaChunkGenerator;
import divinerpg.registry.BiomeRegistry;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.DimensionRegistry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProvider.WorldSleepResult;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class WorldProviderWildwood extends WorldProvider {

    @Override
    public void init() {
        this.biomeProvider = new BiomeProviderSingle(BiomeRegistry.biomeWildwood);
        this.nether = false;
        this.hasSkyLight = true;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new WildwoodChunkGenerator(world);
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
        return DimensionRegistry.wildwoodDimension;
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) { return 0.0F; }

    @Nullable
    @Override
    public String getSaveFolder()
    {
        return "WildWood";
    }
}