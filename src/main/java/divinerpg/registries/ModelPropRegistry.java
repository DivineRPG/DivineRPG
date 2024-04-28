package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.items.arcana.ItemMeriksMissile;
import divinerpg.items.base.ItemModBow;
import net.minecraft.client.renderer.item.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelPropRegistry {

    public static void init() {
        DivineRPG.LOGGER.info("[DivineRPG] Attached model properties");
        registerBow((ItemModBow) ItemRegistry.apalachia_bow.get(),
        (ItemModBow) ItemRegistry.soulfire_bow.get(),
        (ItemModBow) ItemRegistry.eden_bow.get(),
        (ItemModBow) ItemRegistry.ender_bow.get(),
        (ItemModBow) ItemRegistry.halite_bow.get(),
        (ItemModBow) ItemRegistry.hunter_bow.get(),
        (ItemModBow) ItemRegistry.icicle_bow.get(),
        (ItemModBow) ItemRegistry.inferno_bow.get(),
        (ItemModBow) ItemRegistry.mortum_bow.get(),
        (ItemModBow) ItemRegistry.shadow_bow.get(),
        (ItemModBow) ItemRegistry.skythern_bow.get(),
        (ItemModBow) ItemRegistry.snowstorm_bow.get(),
        (ItemModBow) ItemRegistry.twilight_bow.get(),
        (ItemModBow) ItemRegistry.wildwood_bow.get(),
        (ItemModBow) ItemRegistry.amthirmis_bow.get(),
        (ItemModBow) ItemRegistry.arksiane_bow.get(),
        (ItemModBow) ItemRegistry.cermile_bow.get(),
        (ItemModBow) ItemRegistry.darven_bow.get(),
        (ItemModBow) ItemRegistry.everfright.get(),
        (ItemModBow) ItemRegistry.heliosis_bow.get(),
        (ItemModBow) ItemRegistry.karos_bow.get(),
        (ItemModBow) ItemRegistry.pardimal_bow.get(),
        (ItemModBow) ItemRegistry.quadrotic_bow.get(),
        (ItemModBow) ItemRegistry.teaker_bow.get());
        registerMerik((ItemMeriksMissile) ItemRegistry.meriks_missile.get());

        registerShield(new ResourceLocation(DivineRPG.MODID, "blocking"),
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

    public static void registerBow(ItemModBow... item){
        for (ItemModBow bow : item) {

            ItemProperties.register(bow, new ResourceLocation("pull"), (stack, level, entity, i) -> {
                if (entity == null) {
                    return 0.0F;
                } else {
                    return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F;
                }
            });
            ItemProperties.register(bow, new ResourceLocation("pulling"), (stack, level, entity, i) -> {
                return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F;
            });
        }
    }

    public static void registerMerik(ItemMeriksMissile... item){
        for (ItemMeriksMissile missile : item) {
            ItemProperties.register(missile, new ResourceLocation("pull"), (stack, level, entity, i) -> {
                if (entity == null) {
                    return 0.0F;
                } else {
                    return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F;
                }
            });
            ItemProperties.register(missile, new ResourceLocation("pulling"), (stack, level, entity, i) -> {
                return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F;
            });
        }
    }

    private static void registerShield(ResourceLocation override, @SuppressWarnings("deprecation") ItemPropertyFunction propertyGetter,
                                       Item... shields) {
        for (Item shield : shields) {
            ItemProperties.register(shield.asItem(), override, propertyGetter);
        }
    }
}