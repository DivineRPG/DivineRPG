package divinerpg.registry;

import divinerpg.DivineRPG;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
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
        for(MissingMappings.Mapping<Block> mapping: event.getMappings()) {


            if(mapping.key.equals(new ResourceLocation("divinerpg:karos_cannon"))) {
                mapping.remap(BlockRegistry.karosDispenser);
            }
            else if(mapping.key.equals(new ResourceLocation("divinerpg:ayeraco_statue"))) {
                mapping.remap(BlockRegistry.ayeracoBlueStatue);
            }
            else if(mapping.key.equals(new ResourceLocation("divinerpg:tar"))) {
                mapping.remap(BlockRegistry.smolderingTar);
            }
            else if(mapping.key.equals(new ResourceLocation("divinerpg:ancient_brick"))) {
                mapping.remap(BlockRegistry.ancientBricks);
            }
            else if(mapping.key.equals(new ResourceLocation("divinerpg:degraded_brick"))) {
                mapping.remap(BlockRegistry.degradedBricks);
            }
        }
    }


    @SubscribeEvent
    public static void handleMissingItems(MissingMappings<Item> event) {
         for(MissingMappings.Mapping<Item> mapping: event.getMappings()) {
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
             else if(mapping.key.equals(new ResourceLocation("divinerpg:tar"))) {
                 mapping.remap(Item.getItemFromBlock(BlockRegistry.smolderingTar));
             }
             else if(mapping.key.equals(new ResourceLocation("divinerpg:ancient_brick"))) {
                 mapping.remap(Item.getItemFromBlock(BlockRegistry.ancientBricks));
             }
             else if(mapping.key.equals(new ResourceLocation("divinerpg:degraded_brick"))) {
                 mapping.remap(Item.getItemFromBlock(BlockRegistry.degradedBricks));
             }
         }
    }

    @SubscribeEvent
    public static void handleMissingBiomes(MissingMappings<Biome> event) {
        for(MissingMappings.Mapping<Biome> mapping: event.getMappings()) {
            if (mapping.key.equals(new ResourceLocation(DivineRPG.MODID, "arksiane"))) {
                mapping.remap(BiomeRegistry.biomeVethea);
            }
        }
    }

    @SubscribeEvent
    public static void handleMissingEnchantments(MissingMappings<Enchantment> event) {
        for(MissingMappings.Mapping<Enchantment> mapping: event.getMappings()) {
            if (mapping.key.equals(new ResourceLocation(DivineRPG.MODID, "world_break"))) {
                mapping.remap(EnchantmentRegistry.RIVE);
            }
            else if (mapping.key.equals(new ResourceLocation(DivineRPG.MODID, "double_dealing_damage"))) {
                mapping.remap(EnchantmentRegistry.AFTERSHOCK);
            }
        }
    }
}
