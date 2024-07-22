package divinerpg.registries;


import divinerpg.*;
import divinerpg.advancement.*;
import net.minecraft.advancements.*;

public class TriggerRegistry {
    public static final AdvancementDivineItem DIVINERPG_ITEM = CriteriaTriggers.register("divinerpg_item", new AdvancementDivineItem("divinerpg:item"));
    public static final AdvancementDivineBlock DIVINERPG_BLOCK = CriteriaTriggers.register("divinerpg_block", new AdvancementDivineBlock("divinerpg:block"));
    public static final AdvancementDivineEye DIVINERPG_EYE = CriteriaTriggers.register("divinerpg_eye", new AdvancementDivineEye("divinerpg:eye"));

    public static void registerTriggers() {
        DivineRPG.LOGGER.info("[DivineRPG] Registered triggers");
    }
}