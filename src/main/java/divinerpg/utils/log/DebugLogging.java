package divinerpg.utils.log;

import divinerpg.DivineRPG;
import divinerpg.config.GeneralConfig;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DebugLogging {

    @SideOnly(Side.CLIENT)
    public static void preInitStageLog() {
        if(GeneralConfig.generalOptions.enableDebugMode == true) {
            DivineRPG.logger.info(DivineRPG.MODID + " is now loading");}
        if(Loader.isModLoaded("p455w0rdslib")) {
            DivineRPG.logger.info("O.o it's TheRealP455w0rd's mods");
        }
    }

    @SideOnly(Side.CLIENT)
    public static void initStageLog() {
        if(GeneralConfig.generalOptions.enableDebugMode == true) {
            DivineRPG.logger.info(DivineRPG.MODID + " is almost loaded");
        }
    }


    @SideOnly(Side.CLIENT)
    public static void postInitStageLog() {
        if(GeneralConfig.generalOptions.enableDebugMode == true) {
            DivineRPG.logger.info(DivineRPG.MODID + " has just finished loading");
            listEverythingInRegistries();
        }
    }

    @SideOnly(Side.CLIENT)
    public static void listEverythingInRegistries() {
        if (GeneralConfig.generalOptions.enableDebugMode) {
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
