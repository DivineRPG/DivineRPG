package divinerpg.structure.iceika.rollum;

import divinerpg.structure.base.DivineStructureStart;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.StructureComponentTemplate;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class RollumDungeonStart extends DivineStructureStart {

    public RollumDungeonStart() {
    }

    public RollumDungeonStart(ResourceLocation location, TemplateManager templateManager, Rotation rotation, int offset, int chunkX, int chunkZ) {
        super(location, templateManager, rotation, chunkX, 15 + offset, chunkZ, 2, 2);
    }

    @Override
    protected StructureComponentTemplate getComponent(TemplateManager manager, ResourceLocation location, Rotation rotation, BlockPos pos) {
        return new RollumDungeonComponent(manager, location, rotation, pos);
    }
}
