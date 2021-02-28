package divinerpg.events;

import divinerpg.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.enchantment.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.biome.*;
import net.minecraftforge.event.*;
import net.minecraftforge.eventbus.api.*;

public class MissingMappingEvent
{
    @SubscribeEvent
    public static void handleMissingBlocks(RegistryEvent.MissingMappings<Block> event) {
        for(RegistryEvent.MissingMappings.Mapping<Block> mapping: event.getMappings()) {
            if(mapping.key.equals(new ResourceLocation("divinerpg:netherite_block"))) {
                mapping.remap(BlockRegistry.torriditeBlock);
            }
            else if(mapping.key.equals(new ResourceLocation("divinerpg:netherite_bricks"))) {
                mapping.remap(BlockRegistry.torriditeBricks);
            }
            else if(mapping.key.equals(new ResourceLocation("divinerpg:netherite_lamp"))) {
                mapping.remap(BlockRegistry.torriditeLamp);
            }
            else if(mapping.key.equals(new ResourceLocation("divinerpg:netherite_minibricks"))) {
                mapping.remap(BlockRegistry.torriditeMinibricks);
            }
            else if(mapping.key.equals(new ResourceLocation("divinerpg:netherite_ore"))) {
                mapping.remap(BlockRegistry.torriditeOre);
            }
            else if(mapping.key.equals(new ResourceLocation("divinerpg:karos_cannon"))) {
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
            else if(mapping.key.equals(new ResourceLocation("divinerpg:arcanium_ore"))) {
                mapping.remap(BlockRegistry.rawArcanium);
            }
        }
    }


    @SubscribeEvent
    public static void handleMissingItems(RegistryEvent.MissingMappings<Item> event) {
        for(RegistryEvent.MissingMappings.Mapping<Item> mapping: event.getMappings()) {
            if(mapping.key.equals(new ResourceLocation("divinerpg:netherite_boots"))) {
                mapping.remap(ItemRegistry.torriditeBoots);
            }
            else if(mapping.key.equals(new ResourceLocation("divinerpg:netherite_chunk"))) {
                mapping.remap(ItemRegistry.torriditeChunk);
            }
            else if(mapping.key.equals(new ResourceLocation("divinerpg:netherite_ingot"))) {
                mapping.remap(ItemRegistry.torriditeIngot);
            }
            else if(mapping.key.equals(new ResourceLocation("divinerpg:netherite_chestplate"))) {
                mapping.remap(ItemRegistry.torriditeChestplate);
            }
            else if(mapping.key.equals(new ResourceLocation("divinerpg:netherite_nugget"))) {
                mapping.remap(ItemRegistry.torriditeNugget);
            }
            else if(mapping.key.equals(new ResourceLocation("divinerpg:netherite_helmet"))) {
                mapping.remap(ItemRegistry.torriditeHelmet);
            }
            else if(mapping.key.equals(new ResourceLocation("divinerpg:netherite_leggings"))) {
                mapping.remap(ItemRegistry.torriditeLeggings);
            }
            else if(mapping.key.equals(new ResourceLocation("divinerpg:ayeraco_statue"))) {
                mapping.remap(Item.getItemFromBlock(BlockRegistry.ayeracoBlueStatue));
            }
            else if(mapping.key.equals(new ResourceLocation("divinerpg:santa_cap"))) {
                mapping.remap(ItemRegistry.santaHelmet);
            }
            else if(mapping.key.equals(new ResourceLocation("divinerpg:santa_tunic"))) {
                mapping.remap(ItemRegistry.santaChestplate);
            }
            else if(mapping.key.equals(new ResourceLocation("divinerpg:santa_pants"))) {
                mapping.remap(ItemRegistry.santaLeggings);
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
            else if(mapping.key.equals(new ResourceLocation("divinerpg:arcanium_ore"))) {
                mapping.remap(Item.getItemFromBlock(BlockRegistry.rawArcanium));
            }
        }
    }

    @SubscribeEvent
    public static void handleMissingBiomes(RegistryEvent.MissingMappings<Biome> event) {
        for(RegistryEvent.MissingMappings.Mapping<Biome> mapping: event.getMappings()) {
            if (mapping.key.equals(new ResourceLocation(DivineRPG.MODID, "arksiane"))) {
                //TODO - biomeVethea remap
//                mapping.remap(BiomeRegistry.biomeVethea);
            }
        }
    }

    @SubscribeEvent
    public static void handleMissingEnchantments(RegistryEvent.MissingMappings<Enchantment> event) {
        for(RegistryEvent.MissingMappings.Mapping<Enchantment> mapping: event.getMappings()) {
            if (mapping.key.equals(new ResourceLocation(DivineRPG.MODID, "world_break"))) {
                //TODO - enchant remap
//                mapping.remap(EnchantmentRegistry.RIVE);
            }
            else if (mapping.key.equals(new ResourceLocation(DivineRPG.MODID, "double_dealing_damage"))) {
//                mapping.remap(EnchantmentRegistry.AFTERSHOCK);
            }
        }
    }

}
