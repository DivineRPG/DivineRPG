package divinerpg.compat;

import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import moze_intel.projecte.api.ProjectEAPI;
import net.minecraft.item.ItemStack;

public class ProjectECompat {

	public static void init() {
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.aquaticIngot, 1, 0), 396L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.arlemiteIngot, 1, 0), 396L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.hellstoneIngot, 1, 0), 756L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.netheriteIngot, 1, 0), 512L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.realmiteIngot, 1, 0), 640L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.rupeeIngot, 1, 0), 418L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.divineShards, 1, 0), 640L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.corruptedShards, 1, 0), 1050L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.enderShards, 1, 0), 840L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.jungleShards, 1, 0), 160L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.moltenShards, 1, 0), 640L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.terranShards, 1, 0), 620L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.iceShards, 1, 0), 653L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.watchingEye, 1, 0), 4096L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModBlocks.twilightStone, 1, 0), 1L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.edenSoul, 1, 0), 512L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.wildwoodSoul, 1, 0), 1024L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.apalachiaSoul, 1, 0), 2048L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.skythernSoul, 1, 0), 4096L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.mortumSoul, 1, 0), 8192L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.bloodgem, 1, 0), 380L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.purpleBlaze, 1, 0), 64L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.bluefireStone, 1, 0), 796L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.furyFire, 1, 0), 2048L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.sharkFin, 1, 0), 980L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.crabClaw, 1, 0), 150L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.whaleFin, 1, 0), 1508L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.liopleurodonSkull, 1, 0), 13945L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.liopleurodonTeeth, 1, 0), 300L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.cyclopsEye, 1, 0), 415L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.aquaticPellets, 1, 0), 800L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.snowflake, 1, 0), 99L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.eggNog, 1, 0), 302L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.peppermints, 1, 0), 54L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.chocolateLog, 1, 0), 415L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModBlocks.divineMossStone, 1, 0), 3L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModBlocks.apalachiaDirt, 1, 0), 1L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModBlocks.edenDirt, 1, 0), 1L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModBlocks.frozenDirt, 1, 0), 1L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModBlocks.mortumDirt, 1, 0), 1L);
        ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModBlocks.skythernDirt, 1, 0), 1L);
        ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModBlocks.wildwoodDirt, 1, 0), 1L);
        ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModBlocks.dreamDirt, 1, 0), 1L);
        ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModBlocks.apalachiaGrass, 1, 0), 1L);
        ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModBlocks.edenGrass, 1, 0), 1L);
        ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModBlocks.frozenGrass, 1, 0), 1L);
        ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModBlocks.mortumGrass, 1, 0), 1L);
        ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModBlocks.skythernGrass, 1, 0), 1L);
        ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModBlocks.wildwoodGrass, 1, 0), 1L);
        ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModBlocks.dreamGrass, 1, 0), 1L);
        ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModItems.infernoSword, 1, 0), 4740L);
        ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModBlocks.arcaniumOre, 1, 0), 10304L);
    }

}
