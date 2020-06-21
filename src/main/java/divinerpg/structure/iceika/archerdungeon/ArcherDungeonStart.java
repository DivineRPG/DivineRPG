package divinerpg.structure.iceika.archerdungeon;

import divinerpg.structure.base.DivineStructureStart;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.StructureComponentTemplate;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.Random;

public class ArcherDungeonStart extends DivineStructureStart {

    public ArcherDungeonStart() {
        System.out.println("stop calling this bull");
    }

    public ArcherDungeonStart(ResourceLocation location, TemplateManager templateManager, int offset, int chunkX, int chunkZ) {
        super(location, templateManager, chunkX, 100 + offset, chunkZ, 2, 1);
    }

    @Override
    protected StructureComponentTemplate getComponent(TemplateManager manager, ResourceLocation location, BlockPos pos) {
        return new ArcherDungeonComponent(manager, location, pos);
    }
}
