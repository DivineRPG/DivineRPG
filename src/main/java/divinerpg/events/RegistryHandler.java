package divinerpg.events;

import divinerpg.config.Config;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import divinerpg.registry.ModLiquids;
import divinerpg.registry.ModSpawns;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by LiteWolf101 on Feb /21/2019
 */
@Mod.EventBusSubscriber
public class RegistryHandler {

    public static void preInitRegistries(FMLPreInitializationEvent event) {
        ModLiquids.registerFluids();
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        ModBlocks.AddWoodVariants();
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
        if (Config.genJSON) {
            ModBlocks.CreateJSONs();
        }
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
        if (Config.genJSON) {
            ModItems.CreateJSONs();
        }
    }

    @SubscribeEvent
    public static void onLivingSpawn(LivingSpawnEvent event) {
        ModSpawns.init(event);
    }



}
