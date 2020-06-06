package divinerpg.structure.vethea.wreckhall;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineLargeStructure;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class WreckHall extends DivineLargeStructure {

    private final int ALTITUDE = 160;

    public WreckHall(World world) {
        super(world, "WreckHall", new ResourceLocation(DivineRPG.MODID, "vethea/layer4/wreckhall"), 15);
    }

    @Override
    protected StructureStart getStructureStart(int x, int z) {
        return new WreckHallStart(folder, manager, x, ALTITUDE, z);
    }
}
