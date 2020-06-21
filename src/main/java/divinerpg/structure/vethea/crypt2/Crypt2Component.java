package divinerpg.structure.vethea.crypt2;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.vethea.EntityCryptKeeper;
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

public class Crypt2Component extends DivineStructureComponentTemplate {

    public Crypt2Component() {
        this.placeSettings = new PlacementSettings();
    }

    public Crypt2Component(TemplateManager manager, ResourceLocation location, Rotation rotation, BlockPos start) {
        super(manager, location, start, new PlacementSettings().setRotation(rotation));
    }

    @Override
    protected void handleDataMarker(String function, BlockPos pos, World worldIn, Random rand, StructureBoundingBox sbb) {
        switch (function) {
            case "CryptLoot":
                populateLootChestBelow(worldIn, pos, rand, LootTableRegistry.CRYPT_LOOT);
                break;
            case "CryptKeeper":
                spawnPersistentEntity(worldIn, pos, new EntityCryptKeeper(worldIn));
                break;
            default:
                DivineRPG.logger.warn("Unexpected data marker: " + function + " in a structure with class name " + this.getClass().toString() + ", please report this.");
                break;
        }
    }
}
