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
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;

public class AdvancementTenHeads implements ICriterionTrigger<AdvancementTenHeads.Instance> {
	public static class Instance extends AbstractCriterionInstance {

		public Instance(ResourceLocation parRL) {
			super(parRL);
		}

		public boolean test() {
			return true;
		}
	}

	static class Listeners {
		private final PlayerAdvancements playerAdvancements;
		private final Set<ICriterionTrigger.Listener<AdvancementTenHeads.Instance>> listeners = Sets.newHashSet();

		public Listeners(PlayerAdvancements playerAdvancementsIn) {
			playerAdvancements = playerAdvancementsIn;
		}

		public void add(ICriterionTrigger.Listener<AdvancementTenHeads.Instance> listener) {
			listeners.add(listener);
		}

		public boolean isEmpty() {
			return listeners.isEmpty();
		}

		public void remove(ICriterionTrigger.Listener<AdvancementTenHeads.Instance> listener) {
			listeners.remove(listener);
		}

		public void trigger(EntityPlayerMP player) {
			ArrayList<ICriterionTrigger.Listener<AdvancementTenHeads.Instance>> list = null;

			for (ICriterionTrigger.Listener<AdvancementTenHeads.Instance> listener : listeners) {
				if (listener.getCriterionInstance().test()) {
					if (list == null) {
						list = Lists.newArrayList();
					}

					list.add(listener);
				}
			}

			if (list != null) {
				for (ICriterionTrigger.Listener<AdvancementTenHeads.Instance> listener1 : list) {
					listener1.grantCriterion(playerAdvancements);
				}
			}
		}
	}

	private final ResourceLocation RL;

	private final Map<PlayerAdvancements, AdvancementTenHeads.Listeners> listeners = Maps.newHashMap();

	public AdvancementTenHeads(ResourceLocation parRL) {
		super();
		RL = parRL;
	}

	public AdvancementTenHeads(String parString) {
		super();
		RL = new ResourceLocation(parString);
	}

	@Override
	public void addListener(PlayerAdvancements playerAdvancementsIn,
	        ICriterionTrigger.Listener<AdvancementTenHeads.Instance> listener) {
		AdvancementTenHeads.Listeners myCustomTrigger$listeners = listeners.get(playerAdvancementsIn);

		if (myCustomTrigger$listeners == null) {
			myCustomTrigger$listeners = new AdvancementTenHeads.Listeners(playerAdvancementsIn);
			listeners.put(playerAdvancementsIn, myCustomTrigger$listeners);
		}

		myCustomTrigger$listeners.add(listener);
	}

	@Override
	public AdvancementTenHeads.Instance deserializeInstance(JsonObject json, JsonDeserializationContext context) {
		return new AdvancementTenHeads.Instance(getId());
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
	        ICriterionTrigger.Listener<AdvancementTenHeads.Instance> listener) {
		AdvancementTenHeads.Listeners tameanimaltrigger$listeners = listeners.get(playerAdvancementsIn);

		if (tameanimaltrigger$listeners != null) {
			tameanimaltrigger$listeners.remove(listener);

			if (tameanimaltrigger$listeners.isEmpty()) {
				listeners.remove(playerAdvancementsIn);
			}
		}
	}

	public void trigger(EntityPlayerMP parPlayer) {
		AdvancementTenHeads.Listeners tameanimaltrigger$listeners = listeners.get(parPlayer.getAdvancements());

		if (tameanimaltrigger$listeners != null) {
			tameanimaltrigger$listeners.trigger(parPlayer);
		}
	}
}