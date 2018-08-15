package naturix.divinerpg.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	public static void init() {
		GameRegistry.addSmelting(ModBlocks.oreArlemite, new ItemStack(ModItems.ingotArlemite), 0.7f);
		GameRegistry.addSmelting(ModBlocks.oreapalachia, new ItemStack(ModItems.gemApalachia), 0.2f);
		GameRegistry.addSmelting(ModBlocks.oreEden, new ItemStack(ModItems.gemEden), 0.2f);
		GameRegistry.addSmelting(ModBlocks.oreNetherite.getBlockFromItem(Item.getItemFromBlock(ModBlocks.oreNetherite)), new ItemStack(ModItems.ingotNetherite), 0.2f);
		GameRegistry.addSmelting(ModBlocks.oreRealmite, new ItemStack(ModItems.ingotRealmite), 0.2f);
		GameRegistry.addSmelting(ModBlocks.oreRupee, new ItemStack(ModItems.ingotRupee), 0.2f);
		GameRegistry.addSmelting(ModBlocks.oreWildwood, new ItemStack(ModItems.gemWildwood), 0.2f);
		GameRegistry.addSmelting(ModBlocks.oreSkythern, new ItemStack(ModItems.gemSkythern), 0.2f);

	}

}
