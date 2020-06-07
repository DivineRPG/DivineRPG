package divinerpg.structure.vethea.hungerhouse;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineFixedAltitudeStructure;
import divinerpg.structure.base.DivineLargeStructure;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class HungerHouse1 extends DivineFixedAltitudeStructure {

    public HungerHouse1(World world, int chunkDistance, int spawnAltitude) {
        super(world, "HungerHouse", new ResourceLocation(DivineRPG.MODID, "vethea/layer1/hungerhouse1"), chunkDistance, spawnAltitude);
    }

    @Override
    protected StructureStart getStructureStart(int x, int z) {
        return new HungerHouseStart(folder, manager, x, spawnAltitude, z);
    }
}
