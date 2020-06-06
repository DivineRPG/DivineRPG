package divinerpg.structure.base;

import divinerpg.DivineRPG;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.gen.structure.template.TemplateManager;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class DivineLargeStructure extends MapGenStructure {
    protected final String structureName;
    protected final TemplateManager manager;
    protected final ResourceLocation folder;
    private int chunkDistance;


    public DivineLargeStructure(World world, String structureName, ResourceLocation folder, int chunkDistance) {
        this.structureName = structureName;
        this.folder = folder;
        this.manager = world.getSaveHandler().getStructureTemplateManager();

        if (chunkDistance < 2) {
            DivineRPG.logger.warn(String.format("Spaces between structure %s can be closer than 2 chunks, but there is %s",
                    getStructureName(),
                    chunkDistance));

            chunkDistance = 2;
        }

        this.chunkDistance = chunkDistance;
    }

    @Override
    public String getStructureName() {
        return structureName;
    }

    @Nullable
    @Override
    public BlockPos getNearestStructurePos(World world, BlockPos blockPos, boolean findUnexplored) {
        this.world = world;

        // todo think about step by structure size
        return findNearestStructurePosBySpacing(world, this, blockPos, this.chunkDistance, 8, 10387312, false, 100, findUnexplored);
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
        int i = chunkX;
        int j = chunkZ;
        if (chunkX < 0) {
            i = chunkX - chunkDistance - 1;
        }

        if (chunkZ < 0) {
            j = chunkZ - chunkDistance - 1;
        }

        int k = i / chunkDistance;
        int l = j / chunkDistance;

        int folderHash = folder.hashCode();

        Random random = this.world.setRandomSeed(k, l, folderHash);
        k *= chunkDistance;
        l *= chunkDistance;

        int smallerParameter = (int) (chunkDistance * 0.75);

        k += (random.nextInt(smallerParameter) + random.nextInt(smallerParameter)) / 2;
        l += (random.nextInt(smallerParameter) + random.nextInt(smallerParameter)) / 2;
        return chunkX == k && chunkZ == l;
    }
}
