package divinerpg.structure.vethea.quadroticpost;

import divinerpg.DivineRPG;
import divinerpg.registry.LootTableRegistry;
import divinerpg.structure.base.DivineStructureComponentTemplate;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.Random;

public class QuadroticPostComponent extends DivineStructureComponentTemplate {

    public QuadroticPostComponent() {
        this.placeSettings = new PlacementSettings().setIgnoreEntities(true).setReplacedBlock(Blocks.AIR);
    }

    public QuadroticPostComponent(TemplateManager manager, ResourceLocation location, BlockPos start) {
        super(manager, location, start);
    }

    @Override
    protected void handleDataMarker(String function, BlockPos pos, World worldIn, Random rand, StructureBoundingBox sbb) {
        switch (function) {
            case "QuadroticPostLoot":
                populateLootChestBelow(worldIn, pos, rand, LootTableRegistry.QUADROTIC_POST_LOOT);
                System.out.println("Quadrotic chest populated at " + pos);
                break;
            default:
                DivineRPG.logger.warn("Unexpected data marker: " + function + " in a structure, please report this.");
                break;
        }
    }
}
