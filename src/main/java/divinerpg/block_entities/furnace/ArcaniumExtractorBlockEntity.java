package divinerpg.block_entities.furnace;

import com.google.common.collect.Maps;
import divinerpg.DivineRPG;
import divinerpg.client.menu.ArcaniumExtractorMenu;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

public class ArcaniumExtractorBlockEntity extends AbstractFurnaceBlockEntity {
	public ArcaniumExtractorBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.ARCANIUM_EXTRACTOR.get(), pos, state, RecipeRegistry.Types.ARCANIUM_EXTRACTOR_RECIPE_TYPE.get());
    }
	protected Component getDefaultName() {
	      return Component.translatable("block.divinerpg.arcanium_extractor");
	}
	@Override
	protected AbstractContainerMenu createMenu(int i, Inventory playerInventory) {
		return new ArcaniumExtractorMenu(i, playerInventory, this, this.dataAccess);
	}
    public static Map<Item, Integer> getFuel() {
        Map<Item, Integer> map = Maps.newLinkedHashMap();
        map.put(BuiltInRegistries.ITEM.get(new ResourceLocation(DivineRPG.MODID, "collector")), 200);
        return map;
    }
	@Override
	protected int getBurnDuration(ItemStack stack) {
        if (stack == null || !stack.is(BuiltInRegistries.ITEM.get(new ResourceLocation(DivineRPG.MODID, "collector")))) return 0;
        return 100;
    }
	public static boolean isFuel(ItemStack stack) {
		return stack.is(BuiltInRegistries.ITEM.get(new ResourceLocation(DivineRPG.MODID, "collector")));
	}
}