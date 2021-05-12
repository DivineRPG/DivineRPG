package divinerpg.registries;


import divinerpg.*;
import divinerpg.advancement.*;
import net.minecraft.advancements.*;

public class TriggerRegistry {
    public static final AdvancementDivineItem DIVINERPG_ITEM = CriteriaTriggers.register(new AdvancementDivineItem("divinerpg:item"));
    public static final AdvancementDivineBlock DIVINERPG_BLOCK = CriteriaTriggers.register(new AdvancementDivineBlock("divinerpg:block"));
    public static final AdvancementDivineEye DIVINERPG_EYE = CriteriaTriggers.register(new AdvancementDivineEye("divinerpg:eye"));

    public static void registerTriggers() {
        DivineRPG.LOGGER.info("Registering custom triggers");
    }
}