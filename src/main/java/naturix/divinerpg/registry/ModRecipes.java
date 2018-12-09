package naturix.divinerpg.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	public static void init() {
		GameRegistry.addSmelting(ModBlocks.oreArlemite, new ItemStack(ModItems.ingotArlemite), 0.7f);
		GameRegistry.addSmelting(ModBlocks.oreapalachia, new ItemStack(ModItems.fragmentApalachia), 0.2f);
		GameRegistry.addSmelting(ModBlocks.oreEden, new ItemStack(ModItems.fragmentEden), 0.2f);
		GameRegistry.addSmelting(ModBlocks.oreNetherite, new ItemStack(ModItems.ingotNetherite), 0.2f);
		GameRegistry.addSmelting(ModBlocks.oreRealmite, new ItemStack(ModItems.ingotRealmite), 0.2f);
		GameRegistry.addSmelting(ModBlocks.oreRupee, new ItemStack(ModItems.ingotRupee), 0.2f);
		GameRegistry.addSmelting(ModBlocks.oreWildwood, new ItemStack(ModItems.fragmentWildwood), 0.2f);
		GameRegistry.addSmelting(ModBlocks.oreSkythern, new ItemStack(ModItems.fragmentSkythern), 0.2f);
		GameRegistry.addSmelting(Items.EGG, new ItemStack(ModItems.boiledEgg), 0.2f);
		GameRegistry.addSmelting(ModBlocks.oreMortum, new ItemStack(ModItems.fragmentMortum), 0.2f);
		GameRegistry.addSmelting(ModItems.fragmentEden, new ItemStack(ModItems.edenSparklez), 0.2f);
		GameRegistry.addSmelting(Blocks.PUMPKIN, new ItemStack(ModItems.hotPumpkinPie), 0f);
		GameRegistry.addSmelting(ModItems.rawEmpoweredMeat, new ItemStack(ModItems.empoweredMeat), 0.2f);
		GameRegistry.addSmelting(ModItems.pelletsAquaticPure, new ItemStack(ModItems.ingotAquatic), 0.2f);
		GameRegistry.addSmelting(ModBlocks.orebloodgem, new ItemStack(ModItems.gemBlood), 0.2f);

	}

}
