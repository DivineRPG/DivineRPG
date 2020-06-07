package divinerpg.structure.vethea.crypt1;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineFixedAltitudeStructure;
import divinerpg.structure.vethea.evergarden.EvergardenStart;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class Crypt1 extends DivineFixedAltitudeStructure {

    public Crypt1(World world, int chunkDistance, int spawnAltitude) {
        super(world, "Crypt1", new ResourceLocation(DivineRPG.MODID, "vethea/layer1/crypt1"), chunkDistance, spawnAltitude);
    }

    @Override
    protected StructureStart getStructureStart(int x, int z) {
        return new Crypt1Start(folder, manager, x, spawnAltitude, z);
    }
}
