package divinerpg.structure.vethea.temple2;

import divinerpg.DivineRPG;
import divinerpg.structure.StructureRarities;
import divinerpg.structure.base.DivineFixedAltitudeStructure;
import divinerpg.utils.WorldGenUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class Temple2 extends DivineFixedAltitudeStructure {

    public Temple2(World world, int spawnAltitude) {
        super(world, "Temple2", new ResourceLocation(DivineRPG.MODID, "vethea/layer2/temple2"), StructureRarities.TEMPLE_2_RARITY, spawnAltitude);
    }

    @Override
    protected StructureStart getStructureStart(int chunkX, int chunkZ) {
        WorldGenUtils.seedRandomWithWorldAndChunks(this.rand, this.world, chunkX, chunkZ);
        Rotation rotation = WorldGenUtils.getRandomRotation(this.rand);
        return new Temple2Start(folder, manager, rotation, chunkX, spawnAltitude, chunkZ);
    }
}
