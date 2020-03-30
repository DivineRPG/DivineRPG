package divinerpg.registry;

import divinerpg.api.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent.MissingMappings;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Class to handle all internal ID changes by remapping old resources to the versions with the new IDs.
 */
@Mod.EventBusSubscriber
public class MissingMappingHandler {

    @SubscribeEvent
    public static void handleMissingBlocks(MissingMappings<Block> event) {
        for(MissingMappings.Mapping<Block> mapping: event.getAllMappings()) {
            ResourceLocation oldKey = mapping.key;
            if (!oldKey.getResourceDomain().equals(Reference.MODID))
                continue;

            switch (oldKey.getResourcePath()) {
                case "karos_cannon":
                    mapping.remap(ModBlocks.karosDispenser);
                    break;

                case "ayeraco_statue":
                    mapping.remap(ModBlocks.ayeracoBlueStatue);
                    break;
            }
        }
    }

    @SubscribeEvent
    public static void handleMissingItems(MissingMappings<Item> event) {
        for (MissingMappings.Mapping<Item> mapping : event.getAllMappings()) {
            ResourceLocation oldKey = mapping.key;
            if (!oldKey.getResourceDomain().equals(Reference.MODID))
                continue;

            switch (oldKey.getResourcePath()) {

                case "ayeraco_statue":
                    mapping.remap(Item.getItemFromBlock(ModBlocks.ayeracoBlueStatue));
                    break;
            }
        }
    }

    @SubscribeEvent
    public static void handleMissingBiomes(MissingMappings<Biome> event) {
        for(MissingMappings.Mapping<Biome> mapping: event.getAllMappings()) {
            if (mapping.key.equals(new ResourceLocation(Reference.MODID, "arksiane"))) {
                mapping.remap(ModBiomes.Vethea);
            }
        }
    }
}
