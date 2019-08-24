package divinerpg.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModSmelting {
public static void init() {
	GameRegistry.addSmelting(ModBlocks.realmiteOre, new ItemStack(ModItems.realmiteIngot), 0.7F);
	GameRegistry.addSmelting(ModBlocks.arlemiteOre, new ItemStack(ModItems.arlemiteIngot), 1.0F);
	GameRegistry.addSmelting(ModBlocks.rupeeOre, new ItemStack(ModItems.rupeeIngot), 1.0F);
	GameRegistry.addSmelting(ModBlocks.netheriteOre, new ItemStack(ModItems.netheriteIngot), 1.1F);
	GameRegistry.addSmelting(ModBlocks.bloodgemOre, new ItemStack(ModItems.bloodgem), 1.2F);
	GameRegistry.addSmelting(ModItems.pureAquaticPellets, new ItemStack(ModItems.aquaticIngot), 0.6F);
	GameRegistry.addSmelting(ModItems.rawEmpoweredMeat, new ItemStack(ModItems.empoweredMeat), 1);
	GameRegistry.addSmelting(Items.EGG, new ItemStack(ModItems.boiledEgg), 0.3F);
	GameRegistry.addSmelting(Blocks.PUMPKIN, new ItemStack(ModItems.hotPumpkinPie), 0.3F);
	GameRegistry.addSmelting(ModItems.edenFragments, new ItemStack(ModItems.edenSparkles), 1);
	GameRegistry.addSmelting(ModBlocks.edenOre, new ItemStack(ModItems.edenFragments), 0.7F);
	GameRegistry.addSmelting(ModBlocks.wildwoodOre, new ItemStack(ModItems.wildwoodFragments), 1.0F);
	GameRegistry.addSmelting(ModBlocks.apalachiaOre, new ItemStack(ModItems.apalachiaFragments), 1.3F);
	GameRegistry.addSmelting(ModBlocks.skythernOre, new ItemStack(ModItems.skythernFragments), 1.7F);
	GameRegistry.addSmelting(ModBlocks.mortumOre, new ItemStack(ModItems.mortumFragments), 2.0F);
}
}
