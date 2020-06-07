package divinerpg.structure.vethea.hive;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineFixedAltitudeStructure;
import divinerpg.structure.base.DivineLargeStructure;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class Hive extends DivineFixedAltitudeStructure {

    public Hive(World world, int chunkDistance, int spawnAltitude) {
        super(world, "Hive", new ResourceLocation(DivineRPG.MODID, "vethea/layer2/hive"), chunkDistance, spawnAltitude);
    }

    @Override
    protected StructureStart getStructureStart(int x, int z) {
        return new HiveStart(folder, manager, x, spawnAltitude, z);
    }
}
