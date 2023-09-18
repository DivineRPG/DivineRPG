package divinerpg.block_entities.chests;

import divinerpg.DivineRPG;
import divinerpg.client.menu.BoneChestMenu;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class BoneChestBlockEntity extends ModChestBlockEntity {

    public BoneChestBlockEntity(BlockPos p_154992_, BlockState p_154993_) {
        super(BlockEntityRegistry.BONE_CHEST.get(), p_154992_, p_154993_);
        this.items = NonNullList.withSize(27, ItemStack.EMPTY);
    }

    @Override
    public String getChestName() {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "bone_chest")).getDescriptionId();
    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inv) {
        return BoneChestMenu.threeRows(i, inv, this);
    }
}
