package divinerpg.structure.iceika.archerdungeon;

import divinerpg.structure.base.DivineStructureStart;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.StructureComponentTemplate;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.Random;

public class ArcherDungeonStart extends DivineStructureStart {

    public ArcherDungeonStart() {
    }

    public ArcherDungeonStart(ResourceLocation location, TemplateManager templateManager, Rotation rotation, int offset, int chunkX, int chunkZ) {
        super(location, templateManager, rotation, chunkX, 15 + offset, chunkZ, 2, 1);
    }

    @Override
    protected StructureComponentTemplate getComponent(TemplateManager manager, ResourceLocation location, Rotation rotation, BlockPos pos) {
        return new ArcherDungeonComponent(manager, location, rotation, pos);
    }
}
