package divinerpg.events.advancementtriggers;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.advancements.critereon.AbstractCriterionInstance;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;

public class AdvancementDivineBlock implements ICriterionTrigger<AdvancementDivineBlock.Instance> {
    public static class Instance extends AbstractCriterionInstance {
        private final Block block;

        public Instance(ResourceLocation parRL, @Nullable Block block) {
            super(parRL);
            this.block = block;
        }

        public boolean test(Block block) {
            if (this.block != null && block != this.block) {
                return false;
            }
            return true;
        }
    }

    static class Listeners {
        private final PlayerAdvancements playerAdvancements;
        private final Set<ICriterionTrigger.Listener<AdvancementDivineBlock.Instance>> listeners = Sets.newHashSet();

        public Listeners(PlayerAdvancements playerAdvancementsIn) {
            playerAdvancements = playerAdvancementsIn;
        }

        public void add(ICriterionTrigger.Listener<AdvancementDivineBlock.Instance> listener) {
            listeners.add(listener);
        }

        public boolean isEmpty() {
            return listeners.isEmpty();
        }

        public void remove(ICriterionTrigger.Listener<AdvancementDivineBlock.Instance> listener) {
            listeners.remove(listener);
        }

        public void trigger(EntityPlayerMP player, Block block) {
            ArrayList<ICriterionTrigger.Listener<AdvancementDivineBlock.Instance>> list = null;
            for (ICriterionTrigger.Listener<AdvancementDivineBlock.Instance> listener : listeners) {
                if (listener.getCriterionInstance().test(block)) {
                    if (list == null) {
                        list = Lists.newArrayList();
                    }
                    list.add(listener);
                }
            }
            if (list != null) {
                for (ICriterionTrigger.Listener<AdvancementDivineBlock.Instance> listener1 : list) {
                    listener1.grantCriterion(playerAdvancements);
                }
            }
        }
    }

    private final ResourceLocation RL;
    private final Map<PlayerAdvancements, AdvancementDivineBlock.Listeners> listeners = Maps.newHashMap();

    public AdvancementDivineBlock(ResourceLocation parRL) {
        super();
        RL = parRL;
    }

    public AdvancementDivineBlock(String parString) {
        super();
        RL = new ResourceLocation(parString);
    }

    @Override
    public void addListener(PlayerAdvancements playerAdvancementsIn,
            ICriterionTrigger.Listener<AdvancementDivineBlock.Instance> listener) {
        AdvancementDivineBlock.Listeners myCustomTrigger$listeners = listeners.get(playerAdvancementsIn);
        if (myCustomTrigger$listeners == null) {
            myCustomTrigger$listeners = new AdvancementDivineBlock.Listeners(playerAdvancementsIn);
            listeners.put(playerAdvancementsIn, myCustomTrigger$listeners);
        }
        myCustomTrigger$listeners.add(listener);
    }

    @Override
    public AdvancementDivineBlock.Instance deserializeInstance(JsonObject json, JsonDeserializationContext context) {
        Block block = null;
        if (json.has("block")) {
            ResourceLocation resourcelocation = new ResourceLocation(JsonUtils.getString(json, "block"));
            if (!Block.REGISTRY.containsKey(resourcelocation)) {
                throw new JsonSyntaxException("Unknown block type '" + resourcelocation + "'");
            }
            block = Block.REGISTRY.getObject(resourcelocation);
        }
        return new AdvancementDivineBlock.Instance(getId(), block);
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
            ICriterionTrigger.Listener<AdvancementDivineBlock.Instance> listener) {
        AdvancementDivineBlock.Listeners myCustomTrigger$listeners = listeners.get(playerAdvancementsIn);
        if (myCustomTrigger$listeners != null) {
            myCustomTrigger$listeners.remove(listener);
            if (myCustomTrigger$listeners.isEmpty()) {
                listeners.remove(playerAdvancementsIn);
            }
        }
    }

    public void trigger(EntityPlayerMP player, Block block) {
        AdvancementDivineBlock.Listeners myCustomTrigger$listeners = listeners.get(player.getAdvancements());
        if (myCustomTrigger$listeners != null) {
            myCustomTrigger$listeners.trigger(player, block);
        }
    }
}