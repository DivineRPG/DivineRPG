package divinerpg.structure.iceika.archerdungeon;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineLargeStructure;
import divinerpg.structure.vethea.crypt1.Crypt1Start;
import divinerpg.utils.WorldGenUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class ArcherDungeon extends DivineLargeStructure {
    public ArcherDungeon(World world) {
        super(world, "ArcherDungeon", new ResourceLocation(DivineRPG.MODID, "iceika/dungeons/archer"), 500000);
    }

    @Override
    protected StructureStart getStructureStart(int x, int z) {
        WorldGenUtils.seedRandomWithWorldAndChunks(this.rand, this.world, x, z);
        Rotation rotation = WorldGenUtils.getRandomRotation(this.rand);
        int offset = this.rand.nextInt(30);
        return new ArcherDungeonStart(folder, manager, rotation, offset, x, z);
    }
}
