package divinerpg.structure.vethea.temple1;

import divinerpg.structure.base.DivineStructureStart;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.StructureComponentTemplate;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class Temple1Start extends DivineStructureStart {

    public Temple1Start() {
    }

    public Temple1Start(ResourceLocation location, TemplateManager manager, int chunkX, int y, int chunkZ) {
        super(location, manager, chunkX, y, chunkZ, 3, 3);
    }

    @Override
    protected StructureComponentTemplate getComponent(TemplateManager manager, ResourceLocation location, BlockPos pos) {
        return new Temple1Component(manager, location, pos);
    }
}
