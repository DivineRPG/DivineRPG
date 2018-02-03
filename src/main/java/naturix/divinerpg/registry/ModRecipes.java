package naturix.divinerpg.registry;

import naturix.divinerpg.utils.DivineRecipeCheats;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	public static void init() {
		GameRegistry.addSmelting(ModBlocks.oreArlemite, new ItemStack(ModItems.ingotArlemite), 0.7f);
		GameRegistry.addSmelting(ModBlocks.oreapalachia, new ItemStack(ModItems.gemApalachia), 0.2f);
		GameRegistry.addSmelting(ModBlocks.oreEden, new ItemStack(ModItems.gemEden), 0.2f);
		GameRegistry.addSmelting(ModBlocks.oreNetherite, new ItemStack(ModItems.ingotNetherite), 0.2f);
		GameRegistry.addSmelting(ModBlocks.oreRealmite, new ItemStack(ModItems.ingotRealmite), 0.2f);
		GameRegistry.addSmelting(ModBlocks.oreRupee, new ItemStack(ModItems.ingotRupee), 0.2f);
		GameRegistry.addSmelting(ModBlocks.oreWildwood, new ItemStack(ModItems.gemWildwood), 0.2f);
		GameRegistry.addSmelting(ModBlocks.oreSkythern, new ItemStack(ModItems.gemSkythern), 0.2f);
		}
	static void registerShaped(ItemStack output, Object... inputs) {
		DivineRecipeCheats.addShapedOreRecipe(output, inputs);
	}

	static void registerShapeless(ItemStack output, Object... inputs) {
		DivineRecipeCheats.addShapelessOreRecipe(output, inputs);
	}
	static void addToolAndArmourRecipes(ItemStack sword, ItemStack pickaxe, ItemStack axe, ItemStack hoe, ItemStack spade, ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots, String material) {
		registerShaped(sword, "G", "G", "S", 'S', Items.STICK, 'G', material);
		registerShaped(pickaxe, "GGG", " S ", " S ", 'S', Items.STICK, 'G', material);
		registerShaped(axe, "GG", "GS", " S", 'S', Items.STICK, 'G', material);
		registerShaped(hoe, "GG", " S", " S", 'S', Items.STICK, 'G', material);
		registerShaped(spade, "G", "S", "S", 'S', Items.STICK, 'G', material);
		registerShaped(helmet, "GGG", "G G", 'G', material);
		registerShaped(chestplate, "G G", "GGG", "GGG", 'G', material);
		registerShaped(leggings, "GGG", "G G", "G G", 'G', material);
		registerShaped(boots, "G G", "G G", 'G', material);
}
}
