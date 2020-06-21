package divinerpg.structure.vethea.karosmadhouse;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineFixedAltitudeStructure;
import divinerpg.structure.base.DivineLargeStructure;
import divinerpg.utils.WorldGenUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class KarosMadhouse extends DivineFixedAltitudeStructure {

    public KarosMadhouse(World world, int chunkDistance, int spawnAltitude) {
        super(world, "KarosMadhouse", new ResourceLocation(DivineRPG.MODID, "vethea/layer3/karosmadhouse"), chunkDistance, spawnAltitude);
    }

    @Override
    protected StructureStart getStructureStart(int chunkX, int chunkZ) {
        WorldGenUtils.seedRandomWithWorldAndChunks(this.rand, this.world, chunkX, chunkZ);
        Rotation rotation = WorldGenUtils.getRandomRotation(this.rand);
        return new KarosMadhouseStart(folder, manager, rotation, chunkX, spawnAltitude, chunkZ);
    }
}
