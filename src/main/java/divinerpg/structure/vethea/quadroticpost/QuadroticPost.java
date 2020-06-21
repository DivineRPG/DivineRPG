package divinerpg.structure.vethea.quadroticpost;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineFixedAltitudeStructure;
import divinerpg.structure.base.DivineLargeStructure;
import divinerpg.utils.WorldGenUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class QuadroticPost extends DivineFixedAltitudeStructure {

    public QuadroticPost(World world, int chunkDistance, int spawnAltitude) {
        super(world, "QuadroticPost", new ResourceLocation(DivineRPG.MODID, "vethea/layer3/quadroticpost"), chunkDistance, spawnAltitude);
    }

    @Override
    protected StructureStart getStructureStart(int chunkX, int chunkZ) {
        WorldGenUtils.seedRandomWithWorldAndChunks(this.rand, this.world, chunkX, chunkZ);
        Rotation rotation = WorldGenUtils.getRandomRotation(this.rand);
        return new QuadroticPostStart(folder, manager, rotation, chunkX, spawnAltitude, chunkZ);
    }
}
