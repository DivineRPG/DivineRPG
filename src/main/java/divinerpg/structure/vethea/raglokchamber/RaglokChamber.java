package divinerpg.structure.vethea.raglokchamber;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineFixedAltitudeStructure;
import divinerpg.structure.base.DivineLargeStructure;
import divinerpg.utils.WorldGenUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class RaglokChamber extends DivineFixedAltitudeStructure {

    public RaglokChamber(World world, int chunkDistance, int spawnAltitude) {
        super(world, "RaglokChamber", new ResourceLocation(DivineRPG.MODID, "vethea/layer4/raglokchamber"), chunkDistance, spawnAltitude);
    }

    @Override
    protected StructureStart getStructureStart(int chunkX, int chunkZ) {
        WorldGenUtils.seedRandomWithWorldAndChunks(this.rand, this.world, chunkX, chunkZ);
        Rotation rotation = WorldGenUtils.getRandomRotation(this.rand);
        return new RaglokChamberStart(folder, manager, rotation, chunkX, spawnAltitude, chunkZ);
    }
}
