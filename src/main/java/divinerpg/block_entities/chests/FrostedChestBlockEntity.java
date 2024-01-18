package divinerpg.block_entities.chests;

import divinerpg.DivineRPG;
import divinerpg.client.menu.FrostedChestMenu;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;

public class FrostedChestBlockEntity extends ModChestBlockEntity {

    public FrostedChestBlockEntity(BlockPos p_154992_, BlockState p_154993_) {
        super(BlockEntityRegistry.FROSTED_CHEST.get(), p_154992_, p_154993_);
    }

    @Override
    public String getChestName() {
        return BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "frosted_chest")).getDescriptionId();
    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inv) {
        return FrostedChestMenu.threeRows(i, inv, this);
    }
}