package divinerpg.structure.vethea.temple1;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineFixedAltitudeStructure;
import divinerpg.structure.base.DivineLargeStructure;
import divinerpg.structure.vethea.crypt1.Crypt1Start;
import divinerpg.utils.WorldGenUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class Temple1 extends DivineFixedAltitudeStructure {

    public Temple1(World world, int chunkDistance, int spawnAltitude) {
        super(world, "Temple1", new ResourceLocation(DivineRPG.MODID, "vethea/layer2/temple1"), chunkDistance, spawnAltitude);
    }

    @Override
    protected StructureStart getStructureStart(int chunkX, int chunkZ) {
        WorldGenUtils.seedRandomWithWorldAndChunks(this.rand, this.world, chunkX, chunkZ);
        Rotation rotation = WorldGenUtils.getRandomRotation(this.rand);
        return new Temple1Start(folder, manager, rotation, chunkX, spawnAltitude, chunkZ);
    }
}
