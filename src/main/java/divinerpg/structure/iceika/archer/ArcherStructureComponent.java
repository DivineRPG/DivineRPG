package divinerpg.structure.iceika.archer;

import divinerpg.structure.base.DivineStructureComponentTemplate;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.Random;

public class ArcherStructureComponent extends DivineStructureComponentTemplate {

    public ArcherStructureComponent() {

    }

    public ArcherStructureComponent(TemplateManager templateManager, ResourceLocation location, BlockPos pos) {
        super(templateManager, location, pos);
    }

    @Override
    protected void handleDataMarker(String s, BlockPos blockPos, World world, Random random, StructureBoundingBox structureBoundingBox) {
        // todo inject loot
    }
}
