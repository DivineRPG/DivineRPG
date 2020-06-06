package divinerpg.structure.vethea.quadroticpost;

import divinerpg.structure.base.DivineStructureStart;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.StructureComponentTemplate;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class QuadroticPostStart extends DivineStructureStart {

    public QuadroticPostStart() {
    }

    public QuadroticPostStart(ResourceLocation location, TemplateManager manager, int chunkX, int y, int chunkZ) {
        super(location, manager, chunkX, y, chunkZ, 2, 2);
    }

    @Override
    protected StructureComponentTemplate getComponent(TemplateManager manager, ResourceLocation location, BlockPos pos) {
        return new QuadroticPostComponent(manager, location, pos);
    }
}
