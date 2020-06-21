package divinerpg.structure.vethea.evergarden;

import divinerpg.DivineRPG;
import divinerpg.registry.LootTableRegistry;
import divinerpg.structure.base.DivineStructureComponentTemplate;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.Random;

public class EvergardenComponent extends DivineStructureComponentTemplate {

    public EvergardenComponent() {
        this.placeSettings = new PlacementSettings().setIgnoreEntities(true).setReplacedBlock(Blocks.AIR);
    }

    public EvergardenComponent(TemplateManager manager, ResourceLocation location, Rotation rotation, BlockPos start) {
        super(manager, location, start, new PlacementSettings().setReplacedBlock(Blocks.AIR).setRotation(rotation));
    }

    @Override
    protected void handleDataMarker(String function, BlockPos pos, World worldIn, Random rand, StructureBoundingBox sbb) {
        DivineRPG.logger.warn("Unexpected data marker: " + function + " in a structure, please report this.");
    }
}
