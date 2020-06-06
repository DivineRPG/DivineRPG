package divinerpg.structure.vethea;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineLargeStructure;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class WreckHall extends DivineLargeStructure {

    public WreckHall(World world) {
        super(world, "WreckHall", new ResourceLocation(DivineRPG.MODID, "vethea/3level/wreckhall"), 160, 15);
    }

    @Override
    protected StructureStart getStructureStart(int x, int z) {
        return new WreckHallStart(folder, manager, x, height, z);
    }
}
