package divinerpg.registry;

import divinerpg.DivineRPG;
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
            if(mapping.key.equals(new ResourceLocation("divinerpg:karos_cannon"))) {
                mapping.remap(BlockRegistry.karosDispenser);
            }
            else if(mapping.key.equals(new ResourceLocation("divinerpg:ayeraco_statue"))) {
                mapping.remap(BlockRegistry.ayeracoBlueStatue);
            }
        }
    }


    @SubscribeEvent
    public static void handleMissingItems(MissingMappings<Item> event) {
         for(MissingMappings.Mapping<Item> mapping: event.getAllMappings()) {
             if(mapping.key.equals(new ResourceLocation("divinerpg:ayeraco_statue"))) {
                 mapping.remap(Item.getItemFromBlock(BlockRegistry.ayeracoBlueStatue));
             }
             else if(mapping.key.equals(new ResourceLocation("divinerpg:santa_cap"))) {
                 mapping.remap(ArmorRegistry.santaHelmet);
             }
             else if(mapping.key.equals(new ResourceLocation("divinerpg:santa_tunic"))) {
                 mapping.remap(ArmorRegistry.santaChestplate);
             }
             else if(mapping.key.equals(new ResourceLocation("divinerpg:santa_pants"))) {
                 mapping.remap(ArmorRegistry.santaLeggings);
             }
         }
    }

    @SubscribeEvent
    public static void handleMissingBiomes(MissingMappings<Biome> event) {
        for(MissingMappings.Mapping<Biome> mapping: event.getAllMappings()) {
            if (mapping.key.equals(new ResourceLocation(DivineRPG.MODID, "arksiane"))) {
                mapping.remap(BiomeRegistry.biomeVethea);
            }
        }
    }
}
