package naturix.divinerpg.utils;

import naturix.divinerpg.ModBlocks;
import naturix.divinerpg.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	public static void init() {
		GameRegistry.addSmelting(ModBlocks.oreArlemite, new ItemStack(ModItems.ingotArlemite), 0.7f);

	}
}
