package divinerpg.structure.vethea.temple1;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineFixedAltitudeStructure;
import divinerpg.structure.base.DivineLargeStructure;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class Temple1 extends DivineFixedAltitudeStructure {

    public Temple1(World world, int spawnAltitude) {
        super(world, "Temple1", new ResourceLocation(DivineRPG.MODID, "vethea/layer2/temple1"), 15, spawnAltitude);
    }

    @Override
    protected StructureStart getStructureStart(int x, int z) {
        return new Temple1Start(folder, manager, x, spawnAltitude, z);
    }
}
