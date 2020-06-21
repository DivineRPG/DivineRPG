package divinerpg.structure.iceika.rollum;

import divinerpg.DivineRPG;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.LootTableRegistry;
import divinerpg.structure.base.DivineStructureComponentTemplate;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.Random;

public class RollumDungeonComponent extends DivineStructureComponentTemplate {

    public RollumDungeonComponent() {

    }

    public RollumDungeonComponent(TemplateManager templateManager, ResourceLocation location, Rotation rotation, BlockPos pos) {
        super(templateManager, location, pos, new PlacementSettings().setRotation(rotation));
    }

    @Override
    protected void handleDataMarker(String function, BlockPos blockPos, World world, Random random, StructureBoundingBox structureBoundingBox) {
        switch (function) {
            case "RollumDungeonLoot":
                spawnLootChestAtLocation(world, blockPos, random, BlockRegistry.frostedChest, LootTableRegistry.ICEIKA_CHEST_DUNGEON);
                break;
            default:
                DivineRPG.logger.warn("Unexpected data marker: " + function + " in a structure, please report this.");
                break;
        }
    }
}
