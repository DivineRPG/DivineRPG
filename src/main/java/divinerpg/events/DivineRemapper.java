package divinerpg.events;

import com.google.common.collect.ImmutableMap;
import divinerpg.DivineRPG;
import divinerpg.registries.ItemRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
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
                .build();



        for (MissingMappingsEvent.Mapping<Item> mapping : event.getMappings(ForgeRegistries.Keys.ITEMS, DivineRPG.MODID)) {
            Supplier<Item> itemSupplier = itemsMap.get(mapping.getKey());
            if (itemSupplier != null) {
                Item item = itemSupplier.get();
                mapping.remap(item);

            }
        }
    }
}
