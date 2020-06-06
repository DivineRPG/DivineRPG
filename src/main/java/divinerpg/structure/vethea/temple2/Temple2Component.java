package divinerpg.structure.vethea.temple2;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.vethea.EntityTempleGuardian;
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

public class Temple2Component extends DivineStructureComponentTemplate {

    public Temple2Component() {
        this.placeSettings = new PlacementSettings().setIgnoreEntities(true).setReplacedBlock(Blocks.AIR);
    }

    public Temple2Component(TemplateManager manager, ResourceLocation location, BlockPos start) {
        super(manager, location, start);
    }

    @Override
    protected void handleDataMarker(String function, BlockPos pos, World worldIn, Random rand, StructureBoundingBox sbb) {
        switch (function) {
            case "TempleLootBottom":
                populateLootChestBelow(worldIn, pos, rand, LootTableRegistry.TEMPLE_LOOT_BOTTOM);
                System.out.println("Temple loot bottom at " + pos);
                break;
            case "TempleLootMiddle":
                populateLootChestBelow(worldIn, pos, rand, LootTableRegistry.TEMPLE_LOOT_MIDDLE);
                break;
            case "TempleLootTop":
                populateLootChestBelow(worldIn, pos, rand, LootTableRegistry.TEMPLE_LOOT_TOP);
                break;
            case "TempleGuardian":
                spawnPersistentEntity(worldIn, pos, new EntityTempleGuardian(worldIn));
                break;
            default:
                DivineRPG.logger.warn("Unexpected data marker: " + function + " in a structure, please report this.");
                break;
        }
    }
}
