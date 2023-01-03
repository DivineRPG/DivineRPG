package divinerpg.tiles.chests;

import divinerpg.DivineRPG;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.state.*;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityEdenChest extends TileEntityModChest {
    public TileEntityEdenChest(BlockPos p_154992_, BlockState p_154993_) {
        super(BlockEntityRegistry.EDEN_CHEST.get(), p_154992_, p_154993_);
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