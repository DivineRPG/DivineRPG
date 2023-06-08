package divinerpg.advancement;

import com.google.common.collect.*;
import com.google.gson.*;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.*;
import net.minecraft.server.*;
import net.minecraft.server.level.*;
import net.minecraft.world.item.*;

import java.util.*;

public class AdvancementDivineItem implements CriterionTrigger<AdvancementDivineItem.Instance> {
    public static class Instance extends AbstractCriterionTriggerInstance {
        private final ItemPredicate item;

        public Instance(ResourceLocation parRL, ItemPredicate item) {
            super(parRL, ContextAwarePredicate.ANY);
            this.item = item;
        }

        public boolean test(ItemStack item) {
            return this.item.matches(item);
        }
    }

    static class Listeners {
        private final PlayerAdvancements playerAdvancements;
        private final Set<Listener<Instance>> listeners = Sets.newHashSet();

        public Listeners(PlayerAdvancements playerAdvancementsIn) {
            playerAdvancements = playerAdvancementsIn;
        }

        public void add(CriterionTrigger.Listener<AdvancementDivineItem.Instance> listener) {
            listeners.add(listener);
        }

        public boolean isEmpty() {
            return listeners.isEmpty();
        }

        public void remove(CriterionTrigger.Listener<AdvancementDivineItem.Instance> listener) {
            listeners.remove(listener);
        }

        public void trigger(ServerPlayer player, ItemStack item) {
            ArrayList<CriterionTrigger.Listener<AdvancementDivineItem.Instance>> list = null;
            for (CriterionTrigger.Listener<AdvancementDivineItem.Instance> listener : listeners) {
                if (listener.getTriggerInstance().test(item)) {
                    if (list == null) {
                        list = Lists.newArrayList();
                    }
                    list.add(listener);
                }
            }
            if (list != null) {
                for (CriterionTrigger.Listener<AdvancementDivineItem.Instance> listener1 : list) {
                    listener1.run(playerAdvancements);
                }
            }
        }
    }

    private final ResourceLocation RL;
    private final Map<PlayerAdvancements, AdvancementDivineItem.Listeners> listeners = Maps.newHashMap();

    public AdvancementDivineItem(ResourceLocation parRL) {
        super();
        RL = parRL;
    }

    public AdvancementDivineItem(String parString) {
        super();
        RL = new ResourceLocation(parString);
    }


    @Override
    public ResourceLocation getId() {
        return RL;
    }



    public void trigger(ServerPlayer player, ItemStack item) {
        AdvancementDivineItem.Listeners myCustomTrigger$listeners = listeners.get(player.getAdvancements());
        if (myCustomTrigger$listeners != null) {
            myCustomTrigger$listeners.trigger(player, item);
        }
    }

    @Override
    public void addPlayerListener(PlayerAdvancements playerAdvancementsIn, Listener<Instance> listener) {
        AdvancementDivineItem.Listeners myCustomTrigger$listeners = listeners.get(playerAdvancementsIn);
        if (myCustomTrigger$listeners == null) {
            myCustomTrigger$listeners = new AdvancementDivineItem.Listeners(playerAdvancementsIn);
            listeners.put(playerAdvancementsIn, myCustomTrigger$listeners);
        }
        myCustomTrigger$listeners.add(listener);
    }

    @Override
    public void removePlayerListener(PlayerAdvancements playerAdvancementsIn, Listener<Instance> listener) {
        AdvancementDivineItem.Listeners myCustomTrigger$listeners = listeners.get(playerAdvancementsIn);
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
        ItemPredicate itempredicate = ItemPredicate.fromJson(json.get("item"));
        return new AdvancementDivineItem.Instance(getId(), itempredicate);
    }
}