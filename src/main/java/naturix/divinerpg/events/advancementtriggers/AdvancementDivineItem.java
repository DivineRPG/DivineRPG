package naturix.divinerpg.events.advancementtriggers;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;

import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.advancements.critereon.AbstractCriterionInstance;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class AdvancementDivineItem implements ICriterionTrigger<AdvancementDivineItem.Instance> {
    public static class Instance extends AbstractCriterionInstance {
        private final ItemPredicate item;

        public Instance(ResourceLocation parRL, ItemPredicate item) {
            super(parRL);
            this.item = item;
        }

        public boolean test(ItemStack item) {
            return this.item.test(item);
        }
    }

    static class Listeners {
        private final PlayerAdvancements playerAdvancements;
        private final Set<ICriterionTrigger.Listener<AdvancementDivineItem.Instance>> listeners = Sets.newHashSet();

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

        public void trigger(EntityPlayerMP player, ItemStack item) {
            ArrayList<ICriterionTrigger.Listener<AdvancementDivineItem.Instance>> list = null;
            for (ICriterionTrigger.Listener<AdvancementDivineItem.Instance> listener : listeners) {
                if (listener.getCriterionInstance().test(item)) {
                    if (list == null) {
                        list = Lists.newArrayList();
                    }
                    list.add(listener);
                }
            }
            if (list != null) {
                for (ICriterionTrigger.Listener<AdvancementDivineItem.Instance> listener1 : list) {
                    listener1.grantCriterion(playerAdvancements);
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
    public void addListener(PlayerAdvancements playerAdvancementsIn,
            ICriterionTrigger.Listener<AdvancementDivineItem.Instance> listener) {
        AdvancementDivineItem.Listeners myCustomTrigger$listeners = listeners.get(playerAdvancementsIn);
        if (myCustomTrigger$listeners == null) {
            myCustomTrigger$listeners = new AdvancementDivineItem.Listeners(playerAdvancementsIn);
            listeners.put(playerAdvancementsIn, myCustomTrigger$listeners);
        }
        myCustomTrigger$listeners.add(listener);
    }

    @Override
    public AdvancementDivineItem.Instance deserializeInstance(JsonObject json, JsonDeserializationContext context) {
        ItemPredicate itempredicate = ItemPredicate.deserialize(json.get("item"));
        return new AdvancementDivineItem.Instance(getId(), itempredicate);
    }

    @Override
    public ResourceLocation getId() {
        return RL;
    }

    @Override
    public void removeAllListeners(PlayerAdvancements playerAdvancementsIn) {
        listeners.remove(playerAdvancementsIn);
    }

    @Override
    public void removeListener(PlayerAdvancements playerAdvancementsIn,
            ICriterionTrigger.Listener<AdvancementDivineItem.Instance> listener) {
        AdvancementDivineItem.Listeners myCustomTrigger$listeners = listeners.get(playerAdvancementsIn);
        if (myCustomTrigger$listeners != null) {
            myCustomTrigger$listeners.remove(listener);
            if (myCustomTrigger$listeners.isEmpty()) {
                listeners.remove(playerAdvancementsIn);
            }
        }
    }

    public void trigger(EntityPlayerMP player, ItemStack item) {
        AdvancementDivineItem.Listeners myCustomTrigger$listeners = listeners.get(player.getAdvancements());
        if (myCustomTrigger$listeners != null) {
            myCustomTrigger$listeners.trigger(player, item);
        }
    }
}