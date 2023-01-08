package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.items.arcana.ItemMeriksMissile;
import divinerpg.items.base.ItemModBow;
import net.minecraft.client.renderer.item.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.registries.ForgeRegistries;

@OnlyIn(Dist.CLIENT)
public class ModelPropRegistry {

    public static void init() {
        DivineRPG.LOGGER.info("[DivineRPG] Attached model properties");
        registerBow((ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "soulfire_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "ender_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "halite_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "hunter_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "icicle_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "inferno_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "shadow_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "snowstorm_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "twilight_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "amthirmis_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "arksiane_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "cermile_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "darven_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "everfright")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "heliosis_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "karos_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "pardimal_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "quadrotic_bow")),
        (ItemModBow) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "teaker_bow"))
        );
        registerMerik((ItemMeriksMissile) ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "meriks_missile")));

        registerShield(new ResourceLocation(DivineRPG.MODID, "blocking"),
            (stack, world, entity, i) -> entity != null && entity.isUsingItem()
            && entity.getUseItem() == stack ? 1.0F : 0.0F,
        ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "realmite_shield")),
        ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "arlemite_shield")),
        ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "rupee_shield")),
        ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_shield")),
        ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_shield")),
        ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_shield")),
        ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_shield")),
        ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_shield")),
        ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "halite_shield"))
        );
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

    private static void registerShield(ResourceLocation override, ItemPropertyFunction propertyGetter,
                                       Item... shields) {
        for (Item shield : shields) {
            ItemProperties.register(shield.asItem(), override, propertyGetter);
        }
    }
}