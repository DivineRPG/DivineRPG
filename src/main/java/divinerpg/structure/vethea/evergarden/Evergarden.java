package divinerpg.structure.vethea.evergarden;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineFixedAltitudeStructure;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class Evergarden extends DivineFixedAltitudeStructure {

    public Evergarden(World world, int spawnAltitude) {
        super(world, "Evergarden", new ResourceLocation(DivineRPG.MODID, "vethea/layer4/evergarden"), 15, spawnAltitude);
    }

    @Override
    protected StructureStart getStructureStart(int x, int z) {
        return new EvergardenStart(folder, manager, x, spawnAltitude, z);
    }
}
