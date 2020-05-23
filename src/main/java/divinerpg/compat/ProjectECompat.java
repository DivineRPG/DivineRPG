package divinerpg.compat;

import divinerpg.registry.BlockRegistry;
import divinerpg.registry.ItemRegistry;
import divinerpg.registry.ModWeapons;
import moze_intel.projecte.api.ProjectEAPI;
import net.minecraft.item.ItemStack;

public class ProjectECompat {

	public static void init() {
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.aquaticIngot, 1, 0), 396L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.arlemiteIngot, 1, 0), 396L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.hellstoneIngot, 1, 0), 756L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.netheriteIngot, 1, 0), 512L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.realmiteIngot, 1, 0), 640L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.rupeeIngot, 1, 0), 418L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.divineShards, 1, 0), 640L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.corruptedShards, 1, 0), 1050L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.enderShards, 1, 0), 840L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.jungleShards, 1, 0), 160L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.moltenShards, 1, 0), 640L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.terranShards, 1, 0), 620L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.iceShards, 1, 0), 653L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.watchingEye, 1, 0), 4096L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(BlockRegistry.twilightStone, 1, 0), 1L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.edenSoul, 1, 0), 512L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.wildwoodSoul, 1, 0), 1024L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.apalachiaSoul, 1, 0), 2048L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.skythernSoul, 1, 0), 4096L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.mortumSoul, 1, 0), 8192L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.edenFragments, 1, 0), 1024L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.wildwoodFragments, 1, 0), 2048L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.apalachiaFragments, 1, 0), 4096L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.skythernFragments, 1, 0), 8192L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.mortumFragments, 1, 0), 16384);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.bloodgem, 1, 0), 380L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.purpleBlaze, 1, 0), 64L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.bluefireStone, 1, 0), 796L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.furyFire, 1, 0), 2048L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.sharkFin, 1, 0), 980L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.crabClaw, 1, 0), 150L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.whaleFin, 1, 0), 1508L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.liopleurodonSkull, 1, 0), 13945L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.liopleurodonTeeth, 1, 0), 300L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.cyclopsEye, 1, 0), 415L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.aquaticPellets, 1, 0), 800L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.snowflake, 1, 0), 99L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.eggNog, 1, 0), 302L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.peppermints, 1, 0), 54L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.chocolateLog, 1, 0), 415L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(BlockRegistry.divineMossStone, 1, 0), 3L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(BlockRegistry.apalachiaDirt, 1, 0), 1L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(BlockRegistry.edenDirt, 1, 0), 1L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(BlockRegistry.frozenDirt, 1, 0), 1L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(BlockRegistry.mortumDirt, 1, 0), 1L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(BlockRegistry.skythernDirt, 1, 0), 1L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(BlockRegistry.wildwoodDirt, 1, 0), 1L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(BlockRegistry.dreamDirt, 1, 0), 1L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(BlockRegistry.apalachiaGrass, 1, 0), 1L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(BlockRegistry.edenGrass, 1, 0), 1L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(BlockRegistry.frozenGrass, 1, 0), 1L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(BlockRegistry.mortumGrass, 1, 0), 1L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(BlockRegistry.skythernGrass, 1, 0), 1L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(BlockRegistry.wildwoodGrass, 1, 0), 1L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(BlockRegistry.dreamGrass, 1, 0), 1L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ModWeapons.infernoSword, 1, 0), 4740L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(BlockRegistry.arcaniumOre, 1, 0), 10304L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.edenHeart, 1, 0), 4096L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.wildwoodHeart, 1, 0), 16384L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.apalachiaHeart, 1, 0), 65536L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.skythernHeart, 1, 0), 262144L);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(ItemRegistry.mortumHeart, 1, 0), 1048576L);
        }

}
