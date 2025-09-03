package divinerpg.registries;

import divinerpg.DivineRPG;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.*;

import static divinerpg.registries.ItemRegistry.*;

@OnlyIn(Dist.CLIENT)
public class ModelPropRegistry {
    public static void init() {
        DivineRPG.LOGGER.info("[DivineRPG] Attached model properties");
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
    }
    public static void registerBow(Item... bows){
        for(Item bow : bows) {
            ItemProperties.register(bow, ResourceLocation.withDefaultNamespace("pull"), (stack, level, entity, i) -> {
                if(entity == null) return 0;
                else return entity.getUseItem() != stack ? 0 : (float)(stack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / 20;
            });
            ItemProperties.register(bow, ResourceLocation.withDefaultNamespace("pulling"), (stack, level, entity, i) ->
                entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1 : 0
            );
        }
    }
    public static void registerShield(Item... shields) {
        for(Item shield : shields) ItemProperties.register(shield.asItem(), ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "blocking"), (stack, world, entity, i) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1 : 0);
    }
}