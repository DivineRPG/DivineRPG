package divinerpg.registries;

import net.minecraft.client.renderer.item.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.OnlyIn;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.ItemRegistry.*;
import static net.neoforged.api.distmarker.Dist.CLIENT;

@OnlyIn(CLIENT)
public class ItemPropertyRegistry {
    public static final ItemPropertyFunction
        PULL = (stack, level, entity, i) -> entity != null && entity.getUseItem() == stack ? (stack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / 20F : 0,
        IS_USING = (stack, level, entity, i) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1 : 0;
    public static final ResourceLocation
        PULL_LOCATION = ResourceLocation.withDefaultNamespace("pull"),
        PULLING_LOCATION = ResourceLocation.withDefaultNamespace("pulling"),
        BLOCKING_LOCATION = ResourceLocation.withDefaultNamespace("blocking");
    public static void registerProperties() {
        registerBow(hunter_bow.get(),
                shadow_bow.get(),
                icicle_bow.get(),
                inferno_bow.get(),
                soulfire_bow.get(),
                snowstorm_bow.get(),
                ender_bow.get(),
                eden_bow.get(),
                wildwood_bow.get(),
                apalachia_bow.get(),
                skythern_bow.get(),
                mortum_bow.get(),
                halite_bow.get(),
                twilight_bow.get(),
                teaker_bow.get(),
                amthirmis_bow.get(),
                darven_bow.get(),
                cermile_bow.get(),
                pardimal_bow.get(),
                quadrotic_bow.get(),
                karos_bow.get(),
                heliosis_bow.get(),
                arksiane_bow.get(),
                everfright.get(),
                meriks_missile.get());
        registerShield(realmite_shield.get(),
                arlemite_shield.get(),
                rupee_shield.get(),
                eden_shield.get(),
                wildwood_shield.get(),
                apalachia_shield.get(),
                skythern_shield.get(),
                mortum_shield.get(),
                halite_shield.get());
        ItemProperties.register(ItemRegistry.frozen_clock.get(), ResourceLocation.fromNamespaceAndPath(MODID, "time_of_day"), (stack, level, entity, seed) -> stack.get(DataComponentRegistry.variant));
        ItemProperties.register(ItemRegistry.jungle_hook.get(), ResourceLocation.fromNamespaceAndPath(MODID, "hooked"), (stack, level, entity, seed) -> entity != null && AttachmentRegistry.HOOKED.get(entity) ? 1 : 0);
    }
    public static void registerBow(Item... bows){
        for(Item bow : bows) {
            ItemProperties.register(bow, PULL_LOCATION, PULL);
            ItemProperties.register(bow, PULLING_LOCATION, IS_USING);
        }
    }
    public static void registerShield(Item... shields) {
        for(Item shield : shields) ItemProperties.register(shield.asItem(), BLOCKING_LOCATION, IS_USING);
    }
}