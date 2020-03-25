package divinerpg.structure.legacy;

import divinerpg.structure.mock.MockWorld;
import divinerpg.structure.mock.WorldStorage;
import divinerpg.structure.mock.interfaces.IWorldStorage;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.StructureStart;

public class DivineLegacyStructureStart extends StructureStart {
    IWorldStorage storage;

    /**
     * NBT ctor
     */
    public DivineLegacyStructureStart() {

    }

    public DivineLegacyStructureStart(WorldGenerator generator, int chunkX, int height, int chunkZ) {
        super(chunkX, chunkZ);

        ChunkPos chunkPos = new ChunkPos(chunkX, chunkZ);

        storage = new WorldStorage();
        MockWorld world = new MockWorld(storage);
        generator.generate(world, world.rand, chunkPos.getBlock(0, height, 0));

        components.add(new DivineStructureComponent(storage));

        this.updateBoundingBox();
    }
}
