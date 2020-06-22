package divinerpg.structure.vethea.wreckhall;

import divinerpg.DivineRPG;
import divinerpg.structure.StructureRarities;
import divinerpg.structure.base.DivineFixedAltitudeStructure;
import divinerpg.structure.base.DivineLargeStructure;
import divinerpg.utils.WorldGenUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class WreckHall extends DivineFixedAltitudeStructure {

    public WreckHall(World world, int spawnAltitude) {
        super(world, "WreckHall", new ResourceLocation(DivineRPG.MODID, "vethea/layer4/wreckhall"), StructureRarities.WRECK_HALL_RARITY, spawnAltitude);
    }

    @Override
    protected StructureStart getStructureStart(int chunkX, int chunkZ) {
        WorldGenUtils.seedRandomWithWorldAndChunks(this.rand, this.world, chunkX, chunkZ);
        Rotation rotation = WorldGenUtils.getRandomRotation(this.rand);
        return new WreckHallStart(folder, manager, rotation, chunkX, spawnAltitude, chunkZ);
    }
}
