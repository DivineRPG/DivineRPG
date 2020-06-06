package divinerpg.structure.vethea.karosmadhouse;

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

public class KarosMadhouseComponent extends DivineStructureComponentTemplate {

    public KarosMadhouseComponent() {
        this.placeSettings = new PlacementSettings().setIgnoreEntities(true).setReplacedBlock(Blocks.AIR);
    }

    public KarosMadhouseComponent(TemplateManager manager, ResourceLocation location, BlockPos start) {
        super(manager, location, start);
    }

    @Override
    protected void handleDataMarker(String function, BlockPos pos, World worldIn, Random rand, StructureBoundingBox sbb) {
        switch (function) {
            case "KarosMadhouseLoot":
                populateLootChestBelow(worldIn, pos, rand, LootTableRegistry.KAROS_MADHOUSE_LOOT);
                System.out.println("Karos chest populated at " + pos);
                break;
            default:
                DivineRPG.logger.warn("Unexpected data marker: " + function + " in a structure, please report this.");
                break;
        }
    }
}
