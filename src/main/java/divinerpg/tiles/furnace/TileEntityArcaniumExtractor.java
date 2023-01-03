package divinerpg.tiles.furnace;

import com.google.common.collect.Maps;
import divinerpg.DivineRPG;
import divinerpg.client.containers.ArcaniumExtractorContainer;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;

public class TileEntityArcaniumExtractor extends AbstractFurnaceBlockEntity {
	public TileEntityArcaniumExtractor(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.ARCANIUM_EXTRACTOR.get(), pos, state, RecipeRegistry.Types.ARCANIUM_EXTRACTOR_RECIPE_TYPE.get());
    }
	protected Component getDefaultName() {
	      return Component.translatable("block.divinerpg.arcanium_extractor");
	}
	@Override
	protected AbstractContainerMenu createMenu(int i, Inventory playerInventory) {
		return new ArcaniumExtractorContainer(i, playerInventory, this, this.dataAccess);
	}
    public static Map<Item, Integer> getFuel() {
        Map<Item, Integer> map = Maps.newLinkedHashMap();
        map.put(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "collector")), 200);
        return map;
    }
	@Override
	protected int getBurnDuration(ItemStack stack) {
        if (stack == null || !stack.is(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "collector")))) return 0;
        return 100;
    }
	public static boolean isFuel(ItemStack stack) {
		return stack.is(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "collector")));
	}
}