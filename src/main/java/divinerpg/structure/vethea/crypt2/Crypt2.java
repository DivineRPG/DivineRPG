package divinerpg.structure.vethea.crypt2;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineFixedAltitudeStructure;
import divinerpg.structure.vethea.evergarden.EvergardenStart;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class Crypt2 extends DivineFixedAltitudeStructure {

    public Crypt2(World world, int spawnAltitude) {
        super(world, "Crypt2", new ResourceLocation(DivineRPG.MODID, "vethea/layer1/Crypt2"), 15, spawnAltitude);
    }

    @Override
    protected StructureStart getStructureStart(int x, int z) {
        return new Crypt2Start(folder, manager, x, spawnAltitude, z);
    }
}
