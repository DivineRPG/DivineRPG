package divinerpg.advancement;

import com.google.common.collect.*;
import com.google.gson.*;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.*;
import net.minecraft.server.*;
import net.minecraft.server.level.*;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.util.*;
import net.minecraftforge.registries.*;

import javax.annotation.*;
import java.util.*;

public class AdvancementDivineBlock implements CriterionTrigger<AdvancementDivineBlock.Instance> {
    public static class Instance extends AbstractCriterionTriggerInstance {
        private final Block block;

        public Instance(ResourceLocation parRL, @Nullable Block block) {
            super(parRL, ContextAwarePredicate.ANY);
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
        private final Set<Listener<Instance>> listeners = Sets.newHashSet();

        public Listeners(PlayerAdvancements playerAdvancementsIn) {
            playerAdvancements = playerAdvancementsIn;
        }

        public void add(CriterionTrigger.Listener<AdvancementDivineBlock.Instance> listener) {
            listeners.add(listener);
        }

        public boolean isEmpty() {
            return listeners.isEmpty();
        }

        public void remove(CriterionTrigger.Listener<AdvancementDivineBlock.Instance> listener) {
            listeners.remove(listener);
        }

        public void trigger(ServerPlayer player, Block block) {
            ArrayList<CriterionTrigger.Listener<AdvancementDivineBlock.Instance>> list = null;
            for (CriterionTrigger.Listener<AdvancementDivineBlock.Instance> listener : listeners) {
                if (listener.getTriggerInstance().test(block)) {
                    if (list == null) {
                        list = Lists.newArrayList();
                    }
                    list.add(listener);
                }
            }
            if (list != null) {
                for (CriterionTrigger.Listener<AdvancementDivineBlock.Instance> listener1 : list) {
                    listener1.run(playerAdvancements);
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
    public ResourceLocation getId() {
        return RL;
    }

    public void trigger(ServerPlayer player, Block block) {
        AdvancementDivineBlock.Listeners myCustomTrigger$listeners = listeners.get(player.getAdvancements());
        if (myCustomTrigger$listeners != null) {
            myCustomTrigger$listeners.trigger(player, block);
        }
    }

    @Override
    public void addPlayerListener(PlayerAdvancements playerAdvancementsIn, Listener<Instance> listener) {
        AdvancementDivineBlock.Listeners myCustomTrigger$listeners = listeners.get(playerAdvancementsIn);
        if (myCustomTrigger$listeners == null) {
            myCustomTrigger$listeners = new AdvancementDivineBlock.Listeners(playerAdvancementsIn);
            listeners.put(playerAdvancementsIn, myCustomTrigger$listeners);
        }
        myCustomTrigger$listeners.add(listener);
    }

    @Override
    public void removePlayerListener(PlayerAdvancements playerAdvancementsIn, Listener<Instance> listener) {
        AdvancementDivineBlock.Listeners myCustomTrigger$listeners = listeners.get(playerAdvancementsIn);
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
        Block block = null;
        if (json.has("block")) {
            ResourceLocation resourcelocation = new ResourceLocation(JsonUtils.readNBT(json, "block").getAsString());
            if (!ForgeRegistries.BLOCKS.containsKey(resourcelocation)) {
                throw new JsonSyntaxException("Unknown block type '" + resourcelocation + "'");
            }
            block = ForgeRegistries.BLOCKS.getValue(resourcelocation);
        }
        return new Instance(getId(), block);
    }
}