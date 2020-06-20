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
        return new ArcherDungeonStart(folder, manager, x, z);
    }
}
