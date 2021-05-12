package divinerpg.advancement;

import com.google.common.collect.*;
import com.google.gson.*;
import net.minecraft.advancements.*;
import net.minecraft.advancements.criterion.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.loot.*;
import net.minecraft.util.*;

import java.util.*;

public class AdvancementDivineItem implements ICriterionTrigger<AdvancementDivineItem.Instance> {
    public static class Instance extends CriterionInstance {
        private final ItemPredicate item;

        public Instance(ResourceLocation parRL, ItemPredicate item) {
            super(parRL, EntityPredicate.AndPredicate.ANY);
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

        public void add(ICriterionTrigger.Listener<AdvancementDivineItem.Instance> listener) {
            listeners.add(listener);
        }

        public boolean isEmpty() {
            return listeners.isEmpty();
        }

        public void remove(ICriterionTrigger.Listener<AdvancementDivineItem.Instance> listener) {
            listeners.remove(listener);
        }

        public void trigger(ServerPlayerEntity player, ItemStack item) {
            ArrayList<ICriterionTrigger.Listener<AdvancementDivineItem.Instance>> list = null;
            for (ICriterionTrigger.Listener<AdvancementDivineItem.Instance> listener : listeners) {
                if (listener.getTriggerInstance().test(item)) {
                    if (list == null) {
                        list = Lists.newArrayList();
                    }
                    list.add(listener);
                }
            }
            if (list != null) {
                for (ICriterionTrigger.Listener<AdvancementDivineItem.Instance> listener1 : list) {
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



    public void trigger(ServerPlayerEntity player, ItemStack item) {
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
    public Instance createInstance(JsonObject json, ConditionArrayParser parser) {
        ItemPredicate itempredicate = ItemPredicate.fromJson(json.get("item"));
        return new AdvancementDivineItem.Instance(getId(), itempredicate);
    }
}