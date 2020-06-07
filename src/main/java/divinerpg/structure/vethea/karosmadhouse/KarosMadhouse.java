package divinerpg.structure.vethea.karosmadhouse;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineFixedAltitudeStructure;
import divinerpg.structure.base.DivineLargeStructure;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class KarosMadhouse extends DivineFixedAltitudeStructure {

    public KarosMadhouse(World world, int chunkDistance, int spawnAltitude) {
        super(world, "KarosMadhouse", new ResourceLocation(DivineRPG.MODID, "vethea/layer3/karosmadhouse"), chunkDistance, spawnAltitude);
    }

    @Override
    protected StructureStart getStructureStart(int x, int z) {
        return new KarosMadhouseStart(folder, manager, x, spawnAltitude, z);
    }
}
