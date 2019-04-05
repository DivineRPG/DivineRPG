package naturix.divinerpg.utils.log;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class IntenseDebug {
public static void init() {

	if (Config.debug) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			DivineRPG.logger.info("Biome: " + biome.getBiomeName());
		}
		for (Item item : ForgeRegistries.ITEMS.getValues()) {
			DivineRPG.logger.info("Item: " + new ItemStack(item).getDisplayName());
		}
		for (Block block : ForgeRegistries.BLOCKS.getValues()) {
			DivineRPG.logger.info("Block: " + new ItemStack(Item.getItemFromBlock(block)).getDisplayName());
		}
		for (EntityEntry entities : ForgeRegistries.ENTITIES.getValues()) {
			DivineRPG.logger.info("Entity: " + entities.getName());
		}
	}

}
}
