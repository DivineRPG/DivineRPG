package divinerpg.registries;


import divinerpg.*;
import divinerpg.advancement.*;
import net.minecraft.advancements.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class TriggerRegistry {
    public static final AdvancementDivineItem DIVINERPG_ITEM = register("item", new AdvancementDivineItem());
    public static final AdvancementDivineBlock DIVINERPG_BLOCK = register("block", new AdvancementDivineBlock());
    public static final AdvancementDivineEye DIVINERPG_EYE = register("eye", new AdvancementDivineEye());

    public static <T extends CriterionTrigger<?>> T register(String name, T trigger) {
        return Registry.register(BuiltInRegistries.TRIGGER_TYPES, "divinerpg:" + name, trigger);
    }
    public static void registerTriggers() {
        DivineRPG.LOGGER.info("[DivineRPG] Registered triggers");
    }
}