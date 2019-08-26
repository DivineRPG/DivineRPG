package divinerpg.utils.log;

import divinerpg.Config;
import divinerpg.DivineRPG;
import divinerpg.objects.items.ItemNotReady;
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
	if (Config.debug) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			DivineRPG.logger.info("Biome: " + biome.getBiomeName());
		}
		for (Item item : ForgeRegistries.ITEMS.getValues()) {
			DivineRPG.logger.info("Item: " + new ItemStack(item).getDisplayName());
			if(item instanceof ItemNotReady) {
			DivineRPG.logger.info("Item: " +new ItemStack(item).getDisplayName() + " still needs porting");}
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
