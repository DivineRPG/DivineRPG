package divinerpg.registries;

import divinerpg.items.base.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

//public class ModelPropRegistry {
//    public static void init() {
//        registerBows(
//                (ItemModBow) ItemRegistry.apalachiaBow,
//                (ItemModBow) ItemRegistry.bluefireBow,
//                (ItemModBow) ItemRegistry.edenBow,
//                (ItemModBow) ItemRegistry.enderBow,
//                (ItemModBow) ItemRegistry.haliteBow,
//                (ItemModBow) ItemRegistry.hunterBow,
//                (ItemModBow) ItemRegistry.icicleBow,
//                (ItemModBow) ItemRegistry.infernoBow,
//                (ItemModBow) ItemRegistry.mortumBow,
//                (ItemModBow) ItemRegistry.shadowBow,
//                (ItemModBow) ItemRegistry.skythernBow,
//                (ItemModBow) ItemRegistry.snowstormBow,
//                (ItemModBow) ItemRegistry.twilightBow,
//                (ItemModBow) ItemRegistry.wildwoodBow
//        );
//    }
@OnlyIn(Dist.CLIENT)
public class ModelPropRegistry {

    public static void init() {
        registerBow((ItemModBow) ItemRegistry.apalachiaBow,
                (ItemModBow) ItemRegistry.bluefireBow,
                (ItemModBow) ItemRegistry.edenBow,
                (ItemModBow) ItemRegistry.enderBow,
                (ItemModBow) ItemRegistry.haliteBow,
                (ItemModBow) ItemRegistry.hunterBow,
                (ItemModBow) ItemRegistry.icicleBow,
                (ItemModBow) ItemRegistry.infernoBow,
                (ItemModBow) ItemRegistry.mortumBow,
                (ItemModBow) ItemRegistry.shadowBow,
                (ItemModBow) ItemRegistry.skythernBow,
                (ItemModBow) ItemRegistry.snowstormBow,
                (ItemModBow) ItemRegistry.twilightBow,
                (ItemModBow) ItemRegistry.wildwoodBow
        );
    }

    public static void registerBow(ItemModBow... item){
        for (ItemModBow bow : item) {
            ItemModelsProperties.register(bow, new ResourceLocation("pull"), (itemStack, clientWorld, livingEntity) -> {
                if (livingEntity == null) {
                    return 0.0F;
                } else {
                    return livingEntity.getUseItem() != itemStack ? 0.0F : (float) (itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / 20.0F;
                }
            });
            ItemModelsProperties.register(bow, new ResourceLocation("pulling"), (itemStack, clientWorld, livingEntity) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getMainHandItem() == itemStack ? 1.0F : 0.0F);
        }
    }
}