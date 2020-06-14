package divinerpg.structure.iceika.archer;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineLargeStructure;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

import java.util.Random;

public class ArcherStructure extends DivineLargeStructure {
    private final int chunkDistance;

    public ArcherStructure(World world, int chunkDistance) {
        super(world, "Archer", new ResourceLocation(DivineRPG.MODID, "iceika/archer"), chunkDistance);
        this.chunkDistance = chunkDistance;
    }

    @Override
    protected StructureStart getStructureStart(int i, int i1) {
        return new ArcherStructureStart(folder, manager, i, i1);
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
        int code = folder.hashCode();
        Random random = this.world.setRandomSeed(chunkX, chunkZ, code);
        return random.nextInt(chunkDistance * chunkDistance) == chunkDistance;
    }
}
