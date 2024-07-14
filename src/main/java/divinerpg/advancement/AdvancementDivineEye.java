package divinerpg.advancement;

import com.google.common.collect.*;
import com.google.gson.*;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.*;
import net.minecraft.server.*;
import net.minecraft.server.level.*;

import java.util.*;

public class AdvancementDivineEye implements CriterionTrigger<AdvancementDivineEye.Instance> {
    public static class Instance extends AbstractCriterionTriggerInstance {

        public Instance(ResourceLocation parRL) {
            super(parRL, ContextAwarePredicate.ANY);
        }

        public boolean test() {
            return true;
        }
    }

    static class Listeners {
        private final PlayerAdvancements playerAdvancements;
        private final Set<Listener<Instance>> listeners = Sets.newHashSet();

        public Listeners(PlayerAdvancements playerAdvancementsIn) {
            playerAdvancements = playerAdvancementsIn;
        }

        public void add(CriterionTrigger.Listener<AdvancementDivineEye.Instance> listener) {
            listeners.add(listener);
        }

        public boolean isEmpty() {
            return listeners.isEmpty();
        }

        public void remove(CriterionTrigger.Listener<AdvancementDivineEye.Instance> listener) {
            listeners.remove(listener);
        }

        public void trigger(ServerPlayer player) {
            ArrayList<CriterionTrigger.Listener<AdvancementDivineEye.Instance>> list = null;
            for (CriterionTrigger.Listener<AdvancementDivineEye.Instance> listener : listeners) {
                if (listener.getTriggerInstance().test()) {
                    if (list == null) {
                        list = Lists.newArrayList();
                    }
                    list.add(listener);
                }
            }
            if (list != null) {
                for (CriterionTrigger.Listener<AdvancementDivineEye.Instance> listener1 : list) {
                    listener1.run(playerAdvancements);
                }
            }
        }
    }

    private final ResourceLocation RL;
    private final Map<PlayerAdvancements, AdvancementDivineEye.Listeners> listeners = Maps.newHashMap();

    public AdvancementDivineEye(ResourceLocation parRL) {
        super();
        RL = parRL;
    }

    public AdvancementDivineEye(String parString) {
        super();
        RL = ResourceLocation.parse(parString);
    }

    @Override
    public ResourceLocation getId() {
        return RL;
    }

    public void trigger(ServerPlayer parPlayer) {
        AdvancementDivineEye.Listeners myCustomTrigger$listeners = listeners.get(parPlayer.getAdvancements());
        if (myCustomTrigger$listeners != null) {
            myCustomTrigger$listeners.trigger(parPlayer);
        }
    }
    @Override
    public void addPlayerListener(PlayerAdvancements playerAdvancementsIn, Listener<Instance> listener) {
        AdvancementDivineEye.Listeners myCustomTrigger$listeners = listeners.get(playerAdvancementsIn);
        if (myCustomTrigger$listeners == null) {
            myCustomTrigger$listeners = new AdvancementDivineEye.Listeners(playerAdvancementsIn);
            listeners.put(playerAdvancementsIn, myCustomTrigger$listeners);
        }
        myCustomTrigger$listeners.add(listener);
    }

    @Override
    public void removePlayerListener(PlayerAdvancements playerAdvancementsIn, Listener<Instance> listener) {
        AdvancementDivineEye.Listeners myCustomTrigger$listeners = listeners.get(playerAdvancementsIn);
        if (myCustomTrigger$listeners != null) {
            myCustomTrigger$listeners.remove(listener);
            if (myCustomTrigger$listeners.isEmpty()) {
                listeners.remove(playerAdvancementsIn);
            }
        }
    }

    @Override
    public void removePlayerListeners(PlayerAdvancements playerAdvancementsIn) {
        listeners.remove(playerAdvancementsIn);
    }

    @Override
    public Instance createInstance(JsonObject json, DeserializationContext parser) {
        return new AdvancementDivineEye.Instance(getId());
    }
}