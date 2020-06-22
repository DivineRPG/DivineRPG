package divinerpg.structure.base;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public abstract class DivineFixedAltitudeStructure extends DivineLargeStructure {
    protected int spawnAltitude;

    public DivineFixedAltitudeStructure(World world, String structureName, ResourceLocation folder, int chance, int spawnAltitude) {
        super(world, structureName, folder, chance);
        this.spawnAltitude = spawnAltitude;
    }
}
