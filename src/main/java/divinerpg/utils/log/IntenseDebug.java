package divinerpg.utils.log;

import divinerpg.DivineRPG;
import divinerpg.config.GeneralConfig;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class IntenseDebug {

    @SideOnly(Side.CLIENT)
public static void init() {
	if (GeneralConfig.generalOptions.debugMode) {
		for (Biome biome : ForgeRegistries.BIOMES.getValuesCollection()) {
			DivineRPG.logger.info("Biome: " + biome.getBiomeName());
		}
		for (Item item : ForgeRegistries.ITEMS.getValuesCollection()) {
			DivineRPG.logger.info("Item: " + new ItemStack(item).getDisplayName());
		}
		for (Block block : ForgeRegistries.BLOCKS.getValuesCollection()) {
			DivineRPG.logger.info("Block: " + new ItemStack(Item.getItemFromBlock(block)).getDisplayName());
		}
		for (EntityEntry entities : ForgeRegistries.ENTITIES.getValuesCollection()) {
			DivineRPG.logger.info("Entity: " + entities.getName());
		}
	}

}
}
