package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.items.arcana.ItemMeriksMissile;
import divinerpg.items.ranged.ItemBow;
import net.minecraft.client.renderer.item.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelPropRegistry {

    public static void init() {
        DivineRPG.LOGGER.info("[DivineRPG] Attached model properties");
        registerBow((ItemBow) ItemRegistry.apalachia_bow.get(),
        (ItemBow) ItemRegistry.soulfire_bow.get(),
        (ItemBow) ItemRegistry.eden_bow.get(),
        (ItemBow) ItemRegistry.ender_bow.get(),
        (ItemBow) ItemRegistry.halite_bow.get(),
        (ItemBow) ItemRegistry.hunter_bow.get(),
        (ItemBow) ItemRegistry.icicle_bow.get(),
        (ItemBow) ItemRegistry.inferno_bow.get(),
        (ItemBow) ItemRegistry.mortum_bow.get(),
        (ItemBow) ItemRegistry.shadow_bow.get(),
        (ItemBow) ItemRegistry.skythern_bow.get(),
        (ItemBow) ItemRegistry.snowstorm_bow.get(),
        (ItemBow) ItemRegistry.twilight_bow.get(),
        (ItemBow) ItemRegistry.wildwood_bow.get(),
        (ItemBow) ItemRegistry.amthirmis_bow.get(),
        (ItemBow) ItemRegistry.arksiane_bow.get(),
        (ItemBow) ItemRegistry.cermile_bow.get(),
        (ItemBow) ItemRegistry.darven_bow.get(),
        (ItemBow) ItemRegistry.everfright.get(),
        (ItemBow) ItemRegistry.heliosis_bow.get(),
        (ItemBow) ItemRegistry.karos_bow.get(),
        (ItemBow) ItemRegistry.pardimal_bow.get(),
        (ItemBow) ItemRegistry.quadrotic_bow.get(),
        (ItemBow) ItemRegistry.teaker_bow.get());
        registerMerik((ItemMeriksMissile) ItemRegistry.meriks_missile.get());

        registerShield(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "blocking"),
            (stack, world, entity, i) -> entity != null && entity.isUsingItem()
            && entity.getUseItem() == stack ? 1.0F : 0.0F,
        ItemRegistry.realmite_shield.get(),
        ItemRegistry.arlemite_shield.get(),
        ItemRegistry.rupee_shield.get(),
        ItemRegistry.eden_shield.get(),
        ItemRegistry.wildwood_shield.get(),
        ItemRegistry.apalachia_shield.get(),
        ItemRegistry.skythern_shield.get(),
        ItemRegistry.mortum_shield.get(),
        ItemRegistry.halite_shield.get());
    }

    public static void registerBow(ItemBow... item){
        for (ItemBow bow : item) {

            ItemProperties.register(bow, ResourceLocation.withDefaultNamespace("pull"), (stack, level, entity, i) -> {
                if (entity == null) {
                    return 0.0F;
                } else {
                    return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / 20.0F;
                }
            });
            ItemProperties.register(bow, ResourceLocation.withDefaultNamespace("pulling"), (stack, level, entity, i) ->
                entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F
            );
        }
    }

    public static void registerMerik(ItemMeriksMissile... item){
        for (ItemMeriksMissile missile : item) {
            ItemProperties.register(missile, ResourceLocation.withDefaultNamespace("pull"), (stack, level, entity, i) -> {
                if (entity == null) {
                    return 0.0F;
                } else {
                    return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / 20.0F;
                }
            });
            ItemProperties.register(missile, ResourceLocation.withDefaultNamespace("pulling"), (stack, level, entity, i) ->
                entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F
            );
        }
    }

    private static void registerShield(ResourceLocation override, @SuppressWarnings("deprecation") ItemPropertyFunction propertyGetter,
                                       Item... shields) {
        for (Item shield : shields) {
            ItemProperties.register(shield.asItem(), override, propertyGetter);
        }
    }
}