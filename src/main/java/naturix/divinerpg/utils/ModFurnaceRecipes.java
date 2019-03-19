package naturix.divinerpg.utils;

import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by LiteWolf101 on Feb /22/2019
 */
public class ModFurnaceRecipes {
    public static void registerFurnaceRecipies() {
        //GameRegistry.addSmelting(ModBlocks.arlemiteOre, new ItemStack(ModItems.arlemiteIngot), 0.7f);
        GameRegistry.addSmelting(ModBlocks.apalachiaOre, new ItemStack(ModItems.apalachiaFragments), 0.2f);
        GameRegistry.addSmelting(ModBlocks.edenOre, new ItemStack(ModItems.edenFragments), 0.2f);
        //GameRegistry.addSmelting(ModBlocks.netheriteOre, new ItemStack(ModItems.netheriteIngot), 0.2f);
        //GameRegistry.addSmelting(ModBlocks.realmiteOre, new ItemStack(ModItems.realmiteIngot), 0.2f);
        //GameRegistry.addSmelting(ModBlocks.rupeeOre, new ItemStack(ModItems.rupeeIngot), 0.2f);
        GameRegistry.addSmelting(ModBlocks.wildwoodOre, new ItemStack(ModItems.wildwoodFragments), 0.2f);
        GameRegistry.addSmelting(ModBlocks.skythernOre, new ItemStack(ModItems.skythernFragments), 0.2f);
        //GameRegistry.addSmelting(Items.EGG, new ItemStack(ModItems.boiledEgg), 0.2f);
        GameRegistry.addSmelting(ModBlocks.mortumOre, new ItemStack(ModItems.mortumFragments), 0.2f);
        GameRegistry.addSmelting(ModItems.edenFragments, new ItemStack(ModItems.edenSparkles), 0.2f);
        //GameRegistry.addSmelting(Blocks.PUMPKIN, new ItemStack(ModItems.hotPumpkinPie), 0f);
        //GameRegistry.addSmelting(ModItems.rawEmpoweredMeat, new ItemStack(ModItems.empoweredMeat), 0.2f);
        //GameRegistry.addSmelting(ModItems.pureAquaticPellets, new ItemStack(ModItems.aquaticIngot), 0.2f);
        //GameRegistry.addSmelting(ModBlocks.bloodgemOre, new ItemStack(ModItems.bloodgem), 0.2f);
    }
}
