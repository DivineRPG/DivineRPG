package divinerpg.structure.vethea.temple1;

import divinerpg.structure.base.DivineStructureStart;
import divinerpg.structure.vethea.crypt2.Crypt2Component;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.StructureComponentTemplate;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class Temple1Start extends DivineStructureStart {

    public Temple1Start() {
    }

    public Temple1Start(ResourceLocation location, TemplateManager manager, Rotation rotation, int chunkX, int y, int chunkZ) {
        super(location, manager, rotation, chunkX, y, chunkZ, 3, 3);
    }

    @Override
    protected StructureComponentTemplate getComponent(TemplateManager manager, ResourceLocation location, Rotation rotation, BlockPos pos) {
        return new Temple1Component(manager, location, rotation, pos);
    }
}
