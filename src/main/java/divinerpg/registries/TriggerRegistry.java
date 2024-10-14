package divinerpg.registries;


import divinerpg.advancement.*;
import net.minecraft.advancements.*;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static divinerpg.DivineRPG.MODID;

public class TriggerRegistry {
    public static final DeferredRegister<CriterionTrigger<?>> TRIGGERS = DeferredRegister.create(Registries.TRIGGER_TYPE, MODID);

    public static final DeferredHolder<CriterionTrigger<?>, LookAtEyeTrigger> EYE = TRIGGERS.register("eye", LookAtEyeTrigger::new);

}