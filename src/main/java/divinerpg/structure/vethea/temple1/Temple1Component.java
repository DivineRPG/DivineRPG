package divinerpg.structure.vethea.temple1;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.vethea.EntityTempleGuardian;
import divinerpg.registry.LootTableRegistry;
import divinerpg.structure.base.DivineStructureComponentTemplate;
import divinerpg.utils.WorldGenUtils;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.Random;

public class Temple1Component extends DivineStructureComponentTemplate {

    public Temple1Component() {
        this.placeSettings = new PlacementSettings().setIgnoreEntities(true).setReplacedBlock(Blocks.AIR);
    }

    public Temple1Component(TemplateManager manager, ResourceLocation location, Rotation rotation, BlockPos start) {
        super(manager, location, start, new PlacementSettings().setReplacedBlock(Blocks.AIR).setRotation(rotation));
    }

    @Override
    protected void handleDataMarker(String function, BlockPos pos, World worldIn, Random rand, StructureBoundingBox sbb) {
        switch (function) {
            case "TempleLootBottom":
                WorldGenUtils.populateLootChestBelow(worldIn, pos, rand, LootTableRegistry.TEMPLE_LOOT_BOTTOM);
                break;
            case "TempleLootMiddle":
                WorldGenUtils.populateLootChestBelow(worldIn, pos, rand, LootTableRegistry.TEMPLE_LOOT_MIDDLE);
                break;
            case "TempleLootTop":
                WorldGenUtils.populateLootChestBelow(worldIn, pos, rand, LootTableRegistry.TEMPLE_LOOT_TOP);
                break;
            case "TempleGuardian":
                WorldGenUtils.spawnPersistentEntity(worldIn, pos, new EntityTempleGuardian(worldIn));
                break;
            default:
                DivineRPG.logger.warn("Unexpected data marker: " + function + " in a structure with class name " + this.getClass().toString() + ", please report this.");
                break;
        }
    }
}
