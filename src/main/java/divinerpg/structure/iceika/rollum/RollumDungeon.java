package divinerpg.structure.iceika.rollum;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineLargeStructure;
import divinerpg.utils.WorldGenUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class RollumDungeon extends DivineLargeStructure {
    public RollumDungeon(World world) {
        super(world, "RollumDungeon", new ResourceLocation(DivineRPG.MODID, "iceika/dungeons/rollum"), 500000);
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
        WorldGenUtils.seedRandomWithOffset(this.rand, WorldGenUtils.ROLLUM_DUNGEON_OFFSET, this.world, chunkX, chunkZ);
        return this.rand.nextInt(110) == 0;
    }

    @Override
    protected StructureStart getStructureStart(int x, int z) {
        WorldGenUtils.seedRandomWithWorldAndChunks(this.rand, this.world, x, z);
        Rotation rotation = WorldGenUtils.getRandomRotation(this.rand);
        int offset = this.rand.nextInt(40);
        return new RollumDungeonStart(folder, manager, rotation, offset, x, z);
    }
}
