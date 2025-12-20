package divinerpg.registries;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.OnlyIn;

import static divinerpg.DivineRPG.MODID;
import static net.neoforged.api.distmarker.Dist.CLIENT;

@OnlyIn(CLIENT)
public class ItemPropertyRegistry {
    public static void registerProperties() {
        ItemProperties.register(ItemRegistry.frozen_clock.get(), ResourceLocation.fromNamespaceAndPath(MODID, "time_of_day"), (stack, level, entity, seed) -> stack.get(DataComponentRegistry.variant));
        ItemProperties.register(ItemRegistry.jungle_hook.get(), ResourceLocation.fromNamespaceAndPath(MODID, "hooked"), (stack, level, entity, seed) -> entity != null && AttachmentRegistry.HOOKED.get(entity) ? 1 : 0);
    }
}