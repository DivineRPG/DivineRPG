package divinerpg.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingRecipeRegistry {
    public static void registerSmeltingRecipes() {
        GameRegistry.addSmelting(BlockRegistry.realmiteOre, new ItemStack(ItemRegistry.realmiteIngot), 0.7F);
        GameRegistry.addSmelting(BlockRegistry.arlemiteOre, new ItemStack(ItemRegistry.arlemiteIngot), 1.0F);
        GameRegistry.addSmelting(BlockRegistry.rupeeOre, new ItemStack(ItemRegistry.rupeeIngot), 1.0F);
        GameRegistry.addSmelting(BlockRegistry.netheriteOre, new ItemStack(ItemRegistry.netheriteIngot), 1.1F);
        GameRegistry.addSmelting(BlockRegistry.bloodgemOre, new ItemStack(ItemRegistry.bloodgem), 1.2F);
        GameRegistry.addSmelting(ItemRegistry.pureAquaticPellets, new ItemStack(ItemRegistry.aquaticIngot), 0.6F);
        GameRegistry.addSmelting(ItemRegistry.rawEmpoweredMeat, new ItemStack(ItemRegistry.empoweredMeat), 1);
        GameRegistry.addSmelting(Items.EGG, new ItemStack(ItemRegistry.boiledEgg), 0.3F);
        GameRegistry.addSmelting(Blocks.PUMPKIN, new ItemStack(ItemRegistry.hotPumpkinPie), 0.3F);
        GameRegistry.addSmelting(ItemRegistry.edenFragments, new ItemStack(ItemRegistry.edenSparkles), 1);
        GameRegistry.addSmelting(BlockRegistry.edenOre, new ItemStack(ItemRegistry.edenFragments), 0.7F);
        GameRegistry.addSmelting(BlockRegistry.wildwoodOre, new ItemStack(ItemRegistry.wildwoodFragments), 1.0F);
        GameRegistry.addSmelting(BlockRegistry.apalachiaOre, new ItemStack(ItemRegistry.apalachiaFragments), 1.3F);
        GameRegistry.addSmelting(BlockRegistry.skythernOre, new ItemStack(ItemRegistry.skythernFragments), 1.7F);
        GameRegistry.addSmelting(BlockRegistry.mortumOre, new ItemStack(ItemRegistry.mortumFragments), 2.0F);
    }
}
