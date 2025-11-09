package divinerpg.block_entities.furnace;

import divinerpg.client.menu.ArcaniumExtractorMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import static divinerpg.registries.BlockEntityRegistry.ARCANIUM_EXTRACTOR;
import static divinerpg.registries.RecipeRegistry.Types.ARCANIUM_EXTRACTOR_RECIPE_TYPE;
import static divinerpg.registries.TagRegistry.FUELS_COLLECTOR;

public class ArcaniumExtractorBlockEntity extends AbstractFurnaceBlockEntity {
	public ArcaniumExtractorBlockEntity(BlockPos pos, BlockState state) {
        super(ARCANIUM_EXTRACTOR.get(), pos, state, ARCANIUM_EXTRACTOR_RECIPE_TYPE.get());
    }
	@Override protected Component getDefaultName() {return Component.translatable("block.divinerpg.arcanium_extractor");}
	@Override protected AbstractContainerMenu createMenu(int i, Inventory playerInventory) {
		return new ArcaniumExtractorMenu(i, playerInventory, this, this.dataAccess);
	}
	@Override protected int getBurnDuration(ItemStack stack) {
        if(!stack.is(FUELS_COLLECTOR)) return 0;
        return 100;
    }
}