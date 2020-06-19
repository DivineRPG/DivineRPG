package divinerpg.structure.iceika.archer;

import divinerpg.structure.base.DivineStructureStart;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.StructureComponentTemplate;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class ArcherStructureStart extends DivineStructureStart {

    /**
     * nbt ctor
     */
    public ArcherStructureStart() {
    }

    public ArcherStructureStart(ResourceLocation location, TemplateManager templateManager, int chunkX, int chunkZ) {
        super(location, templateManager, chunkX, 0, chunkZ, 2, 1);
    }

    @Override
    protected StructureComponentTemplate getComponent(TemplateManager manager, ResourceLocation location, BlockPos pos) {
        pos = pos.add(0, 100, 0);
        return new ArcherStructureComponent(manager, location, pos);
    }
}
