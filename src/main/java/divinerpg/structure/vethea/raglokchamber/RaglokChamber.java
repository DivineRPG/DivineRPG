package divinerpg.structure.vethea.raglokchamber;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineLargeStructure;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class RaglokChamber extends DivineLargeStructure {

    private final int ALTITUDE = 160;

    public RaglokChamber(World world) {
        super(world, "RaglokChamber", new ResourceLocation(DivineRPG.MODID, "vethea/3level/raglokchamber"), 15);
    }

    @Override
    protected StructureStart getStructureStart(int x, int z) {
        return new RaglokChamberStart(folder, manager, x, ALTITUDE, z);
    }
}
