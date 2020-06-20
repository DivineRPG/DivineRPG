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

    public DivineLargeStructure(World world, String structureName, ResourceLocation folder, int chunkDistance) {
        this.structureName = structureName;
        this.folder = folder;
        this.manager = world.getSaveHandler().getStructureTemplateManager();
    }

    @Override
    public String getStructureName() {
        return structureName;
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
        return this.rand.nextDouble() < 0.03; //hardcoded lol
    }

    //Copied from mineshaft class. Cryptic code is fun
    public BlockPos getNearestStructurePos(World worldIn, BlockPos pos, boolean findUnexplored) {
        boolean i = true;
        int j = pos.getX() >> 4;
        int k = pos.getZ() >> 4;

        for(int l = 0; l <= 1000; ++l) {
            for(int i1 = -l; i1 <= l; ++i1) {
                boolean flag = i1 == -l || i1 == l;

                for(int j1 = -l; j1 <= l; ++j1) {
                    boolean flag1 = j1 == -l || j1 == l;
                    if (flag || flag1) {
                        int k1 = j + i1;
                        int l1 = k + j1;
                        this.rand.setSeed((long)(k1 ^ l1) ^ worldIn.getSeed());
                        this.rand.nextInt();
                        if (this.canSpawnStructureAtCoords(k1, l1) && (!findUnexplored || !worldIn.isChunkGeneratedAt(k1, l1))) {
                            return new BlockPos((k1 << 4) + 8, 64, (l1 << 4) + 8);
                        }
                    }
                }
            }
        }

        return null;
    }


}
