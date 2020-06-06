package divinerpg.structure.base;

import divinerpg.DivineRPG;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public abstract class DivineFixedAltitudeStructure extends DivineLargeStructure {
    protected int spawnAltitude;

    public DivineFixedAltitudeStructure(World world, String structureName, ResourceLocation folder, int chunkDistance, int spawnAltitude) {
        super(world, structureName, folder, chunkDistance);
        this.spawnAltitude = spawnAltitude;
    }
}
