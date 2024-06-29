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
    private static ResourceLocation id(String name) {return new ResourceLocation(DivineRPG.MODID, name);}
    @SubscribeEvent
    public static void fixMissingMappings(MissingMappingsEvent event) {
        Map<ResourceLocation, Supplier<Item>> itemsMap = (new ImmutableMap.Builder<ResourceLocation, Supplier<Item>>())
                .put(id("bluefire_stone"), ItemRegistry.soulfire_stone)
                .put(id("bluefire_bow"), ItemRegistry.soulfire_bow)
                .put(id("bluefire_sword"), ItemRegistry.soulfire_sword)
                .put(id("white_steel"), () -> BlockRegistry.steel.get().asItem())
                .put(id("teal_steel"), () -> BlockRegistry.cyanSteel.get().asItem())
                .put(id("bright_red_steel"), () -> BlockRegistry.magentaSteel.get().asItem())
                .put(id("red_vane"), () -> BlockRegistry.bleedingObsidian.get().asItem())
                .put(id("yellow_vane"), () -> BlockRegistry.shiningObsidian.get().asItem())
                .put(id("cyan_vane"), () -> BlockRegistry.glitteringObsidian.get().asItem())
                .put(id("blue_vane"), () -> BlockRegistry.seepingObsidian.get().asItem())
                .put(id("purple_vane"), () -> BlockRegistry.vwoopingObsidian.get().asItem())
                .put(id("bluefire_lamp"), () -> BlockRegistry.soulfireLamp.get().asItem())
                .put(id("redstone_ore_lamp"), () -> BlockRegistry.bloodgemLamp.get().asItem())
                .put(id("frozen_sapling"), () -> BlockRegistry.shiverspineSapling.get().asItem())
                .put(id("frozen_log"), () -> BlockRegistry.shiverspineLog.get().asItem())
                .put(id("stripped_frozen_log"), () -> BlockRegistry.strippedShiverspineLog.get().asItem())
                .put(id("frozen_planks"), () -> BlockRegistry.shiverspinePlanks.get().asItem())
                .put(id("frozen_fence"), () -> BlockRegistry.shiverspineFence.get().asItem())
                .put(id("stained_glass2"), () -> BlockRegistry.stainedGlass.get().asItem())
                .put(id("stained_glass3"), () -> BlockRegistry.stainedGlass.get().asItem())
                .put(id("stained_glass4"), () -> BlockRegistry.stainedGlass.get().asItem())
                .put(id("stained_glass5"), () -> BlockRegistry.stainedGlass.get().asItem())
                .put(id("stained_glass6"), () -> BlockRegistry.stainedGlass.get().asItem())
                .put(id("stained_glass7"), () -> BlockRegistry.stainedGlass.get().asItem())
                .put(id("stained_glass8"), () -> BlockRegistry.stainedGlass.get().asItem())
                .put(id("karos_heat_tile_green"), () -> BlockRegistry.karosHeatTile.get().asItem())
                .put(id("karos_heat_tile_red"), () -> BlockRegistry.karosHeatTile.get().asItem())
                .build();
        Map<ResourceLocation, Supplier<Block>> blocksMap = (new ImmutableMap.Builder<ResourceLocation, Supplier<Block>>())
                .put(id("white_steel"), BlockRegistry.steel)
                .put(id("teal_steel"), BlockRegistry.cyanSteel)
                .put(id("bright_red_steel"), BlockRegistry.magentaSteel)
                .put(id("red_vane"), BlockRegistry.bleedingObsidian)
                .put(id("yellow_vane"), BlockRegistry.shiningObsidian)
                .put(id("cyan_vane"), BlockRegistry.glitteringObsidian)
                .put(id("blue_vane"), BlockRegistry.seepingObsidian)
                .put(id("purple_vane"), BlockRegistry.vwoopingObsidian)
                .put(id("bluefire_lamp"), BlockRegistry.soulfireLamp)
                .put(id("redstone_ore_lamp"), BlockRegistry.bloodgemLamp)
                .put(id("frozen_sapling"), BlockRegistry.shiverspineSapling)
                .put(id("frozen_log"), BlockRegistry.shiverspineLog)
                .put(id("stripped_frozen_log"), BlockRegistry.strippedShiverspineLog)
                .put(id("frozen_planks"), BlockRegistry.shiverspinePlanks)
                .put(id("frozen_fence"), BlockRegistry.shiverspineFence)
                .put(id("stained_glass2"), BlockRegistry.stainedGlass)
                .put(id("stained_glass3"), BlockRegistry.stainedGlass)
                .put(id("stained_glass4"), BlockRegistry.stainedGlass)
                .put(id("stained_glass5"), BlockRegistry.stainedGlass)
                .put(id("stained_glass6"), BlockRegistry.stainedGlass)
                .put(id("stained_glass7"), BlockRegistry.stainedGlass)
                .put(id("stained_glass8"), BlockRegistry.stainedGlass)
                .put(id("karos_heat_tile_green"), BlockRegistry.karosHeatTile)
                .put(id("karos_heat_tile_red"), BlockRegistry.karosHeatTile)
                .build();
        for(MissingMappingsEvent.Mapping<Item> mapping : event.getMappings(ForgeRegistries.Keys.ITEMS, DivineRPG.MODID)) {
            Supplier<Item> itemSupplier = itemsMap.get(mapping.getKey());
            if(itemSupplier != null) {
                Item item = itemSupplier.get();
                mapping.remap(item);
            }
        } for(MissingMappingsEvent.Mapping<Block> mapping : event.getMappings(ForgeRegistries.Keys.BLOCKS, DivineRPG.MODID)) {
            Supplier<Block> itemSupplier = blocksMap.get(mapping.getKey());
            if(itemSupplier != null) {
                Block item = itemSupplier.get();
                mapping.remap(item);
            }
        }
    }
}