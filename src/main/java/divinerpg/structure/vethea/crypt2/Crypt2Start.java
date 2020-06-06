package divinerpg.structure.vethea.crypt2;

import divinerpg.structure.base.DivineStructureStart;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.StructureComponentTemplate;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class Crypt2Start extends DivineStructureStart {

    public Crypt2Start() {
    }

    public Crypt2Start(ResourceLocation location, TemplateManager manager, int chunkX, int y, int chunkZ) {
        super(location, manager, chunkX, y, chunkZ, 2, 1);
    }

    @Override
    protected StructureComponentTemplate getComponent(TemplateManager manager, ResourceLocation location, BlockPos pos) {
        return new Crypt2Component(manager, location, pos);
    }
}
