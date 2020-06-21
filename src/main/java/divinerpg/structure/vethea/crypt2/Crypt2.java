package divinerpg.structure.vethea.crypt2;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineFixedAltitudeStructure;
import divinerpg.structure.vethea.evergarden.EvergardenStart;
import divinerpg.utils.WorldGenUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class Crypt2 extends DivineFixedAltitudeStructure {

    public Crypt2(World world, int chunkDistance, int spawnAltitude) {
        super(world, "Crypt2", new ResourceLocation(DivineRPG.MODID, "vethea/layer1/Crypt2"), chunkDistance, spawnAltitude);
    }

    @Override
    protected StructureStart getStructureStart(int chunkX, int chunkZ) {
        WorldGenUtils.seedRandomWithWorldAndChunks(this.rand, this.world, chunkX, chunkZ);
        Rotation rotation = WorldGenUtils.getRandomRotation(this.rand);
        return new Crypt2Start(folder, manager, rotation, chunkX, spawnAltitude, chunkZ);
    }
}
