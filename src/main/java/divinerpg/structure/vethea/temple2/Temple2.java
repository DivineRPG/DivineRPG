package divinerpg.structure.vethea.temple2;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineFixedAltitudeStructure;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class Temple2 extends DivineFixedAltitudeStructure {

    public Temple2(World world, int chunkDistance, int spawnAltitude) {
        super(world, "Temple2", new ResourceLocation(DivineRPG.MODID, "vethea/layer2/temple2"), chunkDistance, spawnAltitude);
    }

    @Override
    protected StructureStart getStructureStart(int x, int z) {
        return new Temple2Start(folder, manager, x, spawnAltitude, z);
    }
}
