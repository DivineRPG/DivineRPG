package divinerpg.block_entities.chests;

import divinerpg.DivineRPG;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class EdenChestBlockEntity extends ModChestBlockEntity {
    public EdenChestBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.EDEN_CHEST.get(), pos, state);
        this.items = NonNullList.withSize(54, ItemStack.EMPTY);
    }

    @Override
    public String getChestName() {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_chest")).getDescriptionId();
    }

    @Override
    public int getContainerSize() {
        return 54;
    }
    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inv) {
    	return ChestMenu.sixRows(i, inv, this);
    }
}