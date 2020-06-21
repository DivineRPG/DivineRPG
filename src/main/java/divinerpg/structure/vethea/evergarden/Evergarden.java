package divinerpg.structure.vethea.evergarden;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineFixedAltitudeStructure;
import divinerpg.utils.WorldGenUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class Evergarden extends DivineFixedAltitudeStructure {

    public Evergarden(World world, int chunkDistance, int spawnAltitude) {
        super(world, "Evergarden", new ResourceLocation(DivineRPG.MODID, "vethea/layer4/evergarden"), chunkDistance, spawnAltitude);
    }

    @Override
    protected StructureStart getStructureStart(int chunkX, int chunkZ) {
        WorldGenUtils.seedRandomWithWorldAndChunks(this.rand, this.world, chunkX, chunkZ);
        Rotation rotation = WorldGenUtils.getRandomRotation(this.rand);
        return new EvergardenStart(folder, manager, rotation, chunkX, spawnAltitude, chunkZ);
    }
}
