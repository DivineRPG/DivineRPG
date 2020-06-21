package divinerpg.structure.iceika.archerdungeon;

import divinerpg.DivineRPG;
import divinerpg.structure.base.DivineLargeStructure;
import divinerpg.structure.vethea.crypt1.Crypt1Start;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class ArcherDungeon extends DivineLargeStructure {
    public ArcherDungeon(World world) {
        super(world, "ArcherDungeon", new ResourceLocation(DivineRPG.MODID, "iceika/dungeons/archer"), 500000);
    }

    @Override
    protected StructureStart getStructureStart(int x, int z) {
        this.rand.setSeed(this.world.getSeed());
        long k = this.rand.nextLong() / 2L * 2L + 1L;
        long l = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed((long)x * k + (long)z * l ^ this.world.getSeed());
        int offset = this.rand.nextInt(30);

        return new ArcherDungeonStart(folder, manager, offset, x, z);
    }
}
