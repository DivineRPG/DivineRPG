package naturix.divinerpg.compat;

import moze_intel.projecte.api.ProjectEAPI;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.item.ItemStack;

public class ProjectECompat {

	public static void init() {
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.ingotAquatic, 1, 0), (int) 396);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.ingotArlemite, 1, 0), (int) 396);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.ingotHellstone, 1, 0), (int) 756);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.ingotNetherite, 1, 0), (int) 512);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.ingotRealmite, 1, 0), (int) 640);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.ingotRupee, 1, 0), (int) 418);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.shardDivine, 1, 0), (int) 64);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.shardCorrupted, 1, 0), (int) 64);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.shardEnder, 1, 0), (int) 64);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.shardJungle, 1, 0), (int) 64);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.shardMolten, 1, 0), (int) 64);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.shardTerran, 1, 0), (int) 64);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.eyeWatch, 1, 0), (int) 4096);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModBlocks.rockTwilight, 1, 0), (int) 1);
		
		
	}

}
