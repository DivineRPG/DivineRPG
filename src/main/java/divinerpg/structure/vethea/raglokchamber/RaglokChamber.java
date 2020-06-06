package divinerpg.structure.vethea.raglokchamber;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineFixedAltitudeStructure;
import divinerpg.structure.base.DivineLargeStructure;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class RaglokChamber extends DivineFixedAltitudeStructure {

    public RaglokChamber(World world, int spawnAltitude) {
        super(world, "RaglokChamber", new ResourceLocation(DivineRPG.MODID, "vethea/layer4/raglokchamber"), 15, spawnAltitude);
    }

    @Override
    protected StructureStart getStructureStart(int x, int z) {
        return new RaglokChamberStart(folder, manager, x, spawnAltitude, z);
    }
}
