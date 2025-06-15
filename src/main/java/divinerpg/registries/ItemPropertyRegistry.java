package divinerpg.registries;

import divinerpg.DivineRPG;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.api.distmarker.*;

import java.util.ArrayList;

@OnlyIn(Dist.CLIENT)
public class ItemPropertyRegistry {
    public static void registerProperties() {
        ItemProperties.register(ItemRegistry.frozen_clock.get(), ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "time_of_day"), (stack, level, entity, seed) -> stack.get(DataComponentRegistry.variant));
        ItemProperties.register(ItemRegistry.jungle_hook.get(), ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "hooked"), (stack, level, entity, seed) -> entity != null && AttachmentRegistry.HOOKED.get(entity) ? 1 : 0);
    }

}