package divinerpg.events;

import com.google.common.collect.ImmutableMap;
import divinerpg.DivineRPG;
import divinerpg.registries.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.*;

import java.util.Map;
import java.util.function.Supplier;

@Mod.EventBusSubscriber
public class DivineRemapper {

    @SubscribeEvent
    public static void fixMissingMappings(MissingMappingsEvent event) {
        Map<ResourceLocation, Supplier<Item>> itemsMap = (new ImmutableMap.Builder<ResourceLocation, Supplier<Item>>())
                .put(new ResourceLocation(DivineRPG.MODID, "santa_helmet"), ItemRegistry.bedrock_helmet)
                .put(new ResourceLocation(DivineRPG.MODID, "santa_chestplate"), ItemRegistry.bedrock_chestplate)
                .put(new ResourceLocation(DivineRPG.MODID, "santa_leggings"), ItemRegistry.bedrock_leggings)
                .put(new ResourceLocation(DivineRPG.MODID, "santa_boots"), ItemRegistry.bedrock_boots)
                .put(new ResourceLocation(DivineRPG.MODID, "bluefire_stone"), ItemRegistry.soulfire_stone)
                .put(new ResourceLocation(DivineRPG.MODID, "bluefire_bow"), ItemRegistry.soulfire_bow)
                .put(new ResourceLocation(DivineRPG.MODID, "bluefire_sword"), ItemRegistry.soulfire_sword)
                .put(new ResourceLocation(DivineRPG.MODID, "bluefire_lamp"), () -> Item.byBlock(BlockRegistry.soulfireLamp.get()))
                .build();

        Map<ResourceLocation, Supplier<Block>> blocksMap = (new ImmutableMap.Builder<ResourceLocation, Supplier<Block>>())
                .put(new ResourceLocation(DivineRPG.MODID, "bluefire_lamp"), BlockRegistry.soulfireLamp)
                .build();



        for (MissingMappingsEvent.Mapping<Item> mapping : event.getMappings(ForgeRegistries.Keys.ITEMS, DivineRPG.MODID)) {
            Supplier<Item> itemSupplier = itemsMap.get(mapping.getKey());
            if (itemSupplier != null) {
                Item item = itemSupplier.get();
                mapping.remap(item);

            }
        }

        for (MissingMappingsEvent.Mapping<Block> mapping : event.getMappings(ForgeRegistries.Keys.BLOCKS, DivineRPG.MODID)) {
            Supplier<Block> itemSupplier = blocksMap.get(mapping.getKey());
            if (itemSupplier != null) {
                Block item = itemSupplier.get();
                mapping.remap(item);

            }
        }
    }
}
