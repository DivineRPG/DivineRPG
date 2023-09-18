package divinerpg.block_entities.chests;

import divinerpg.DivineRPG;
import divinerpg.client.menu.PresentBoxMenu;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.state.*;
import net.minecraftforge.registries.ForgeRegistries;

public class PresentBoxBlockEntity extends ModChestBlockEntity {

    public PresentBoxBlockEntity(BlockPos p_154992_, BlockState p_154993_) {
        super(BlockEntityRegistry.PRESENT_BOX.get(), p_154992_, p_154993_);
    }

    @Override
    public String getChestName() {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "present_box")).getDescriptionId();
    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inv) {
        return PresentBoxMenu.threeRows(i, inv, this);
    }
}
