package divinerpg.structure.vethea.hungerhouse;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.vethea.EntityCryptKeeper;
import divinerpg.objects.entities.entity.vethea.EntityTheHunger;
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

public class HungerHouseComponent extends DivineStructureComponentTemplate {

    public HungerHouseComponent() {
        this.placeSettings = new PlacementSettings();
    }

    public HungerHouseComponent(TemplateManager manager, ResourceLocation location, Rotation rotation, BlockPos start) {
        super(manager, location, start, new PlacementSettings().setReplacedBlock(Blocks.AIR).setRotation(rotation));
    }

    @Override
    protected void handleDataMarker(String function, BlockPos pos, World worldIn, Random rand, StructureBoundingBox sbb) {
        switch (function) {
            case "TheHunger":
                spawnPersistentEntity(worldIn, pos, new EntityTheHunger(worldIn));
                break;
            default:
                DivineRPG.logger.warn("Unexpected data marker: " + function + " in a structure with class name " + this.getClass().toString() + ", please report this.");
                break;
        }
    }
}
