package divinerpg.entities.base;

import java.util.*;

import javax.annotation.Nullable;

import divinerpg.capability.ReputationProvider;
import divinerpg.registries.*;
import divinerpg.util.DivineRPGPacketHandler;
import divinerpg.util.packets.PacketRequestReputation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.*;

public interface FactionEntity {
	public Faction getFaction();
	public default boolean modifyReputationOnHurt(DamageSource source, float f) {
		if(source.getDirectEntity() != null && source.getDirectEntity() instanceof Player player) {
			getFaction().modifyReputation(player, -1);
			return true;
		} if(source.getEntity() != null && source.getEntity() instanceof Player player) {
			getFaction().modifyReputation(player, -1);
			return true;
		} return false;
	}
	public default void modifyReputationOnDeath(DamageSource source) {
		if(source.getDirectEntity() != null && source.getDirectEntity() instanceof Player player) {
			getFaction().modifyReputation(player, -10);
			for(Faction opposer : getFaction().enemies) opposer.modifyReputation(player, 2);
		} else if(source.getEntity() != null && source.getEntity() instanceof Player player) {
			getFaction().modifyReputation(player, -10);
			for(Faction opposer : getFaction().enemies) opposer.modifyReputation(player, 2);
		}
	}
	public static class Faction {
		public static LivingEntity getNearestEnemy(LivingEntity from, AABB searchArea, TargetingConditions conditions) {
			List<Entity> enemies = from.level().getEntities(from, searchArea, (entity) -> (entity instanceof LivingEntity ent && from instanceof FactionEntity fac && fac.getFaction().isAgressiveTowards(ent)) || (entity instanceof FactionEntity fact && fact.getFaction().isAgressiveTowards(from)));
			double closest = -1D;
			LivingEntity nearestEnemy = null;
			for(Entity enemy : enemies) if(conditions.test(from, (LivingEntity) enemy)) {
				double distance = enemy.distanceToSqr(from);
				if(closest == -1D || distance < closest) {
					closest = distance;
					nearestEnemy = (LivingEntity) enemy;
				}
			} return nearestEnemy;
		}
		public static boolean hasNearbyTarget(@Nullable Entity from, AABB searchArea, Faction faction) {
			return !from.level().getEntities(from, searchArea, (entity) -> (entity instanceof LivingEntity ent && faction.isAgressiveTowards(ent) && !(entity instanceof Player player && player.isSpectator()))).isEmpty();
		}
		public static final Faction
			GROGLIN = new Faction(true, 0, "groglin_reputation") {
			public boolean isAgressiveTowards(LivingEntity entity) {
				return entity.hasEffect(MobEffectRegistry.GROGLIN_BOUNTY.get()) || super.isAgressiveTowards(entity);
			};},
			GRUZZORLUG = new Faction(true, 0, "gruzzorlug_reputation") {
			public boolean isAgressiveTowards(LivingEntity entity) {
				return entity.hasEffect(MobEffectRegistry.GRUZZORLUG_TARGET.get()) || super.isAgressiveTowards(entity);
			};},
			ICEIKA_MERCHANT = new Faction(false, 20, "iceika_merchant_reputation").addEnemy(GROGLIN).addEnemy(GRUZZORLUG);
		static {
			ArrayList<EntityType<?>> iceikaNature = new ArrayList<>();
			iceikaNature.add(EntityType.COD);
			iceikaNature.add(EntityType.SALMON);
			iceikaNature.add(EntityType.TROPICAL_FISH);
			iceikaNature.add(EntityType.POLAR_BEAR);
			iceikaNature.add(EntityRegistry.WHALE.get());
			iceikaNature.add(EntityRegistry.LIOPLEURODON.get());
			iceikaNature.add(EntityRegistry.AEQUOREA.get());
			iceikaNature.add(EntityRegistry.ROBBIN.get());
			iceikaNature.add(EntityRegistry.WOLPERTINGER.get());
			iceikaNature.add(EntityRegistry.PALE_ARCHER.get());
			iceikaNature.add(EntityRegistry.FROZEN_FLESH.get());
			iceikaNature.add(EntityRegistry.ROLLUM.get());
			iceikaNature.add(EntityRegistry.ALICANTO.get());
			iceikaNature.add(EntityRegistry.SENG.get());
			iceikaNature.add(EntityRegistry.HASTREUS.get());
			iceikaNature.add(EntityRegistry.GLACIDE.get());
			iceikaNature.add(EntityRegistry.FRACTITE.get());
			GRUZZORLUG.nonFactionAllies.addAll(iceikaNature);
			GRUZZORLUG.addEnemy(GROGLIN).addEnemy(ICEIKA_MERCHANT);
			iceikaNature.remove(EntityRegistry.SENG.get());
			iceikaNature.remove(EntityType.COD);
			iceikaNature.add(EntityRegistry.SABEAR.get());
			GROGLIN.nonFactionAllies.addAll(iceikaNature);
			GROGLIN.addEnemy(GRUZZORLUG).addEnemy(ICEIKA_MERCHANT);
		}
		public final ArrayList<Faction> enemies = new ArrayList<>(), allies = new ArrayList<>();
		public final ArrayList<EntityType<?>> nonFactionEnemies, nonFactionAllies = new ArrayList<>();
		public final String reputationIdentifier;
		public final boolean isAutoAggressive;
		public final int startingReputation;
		public Faction(boolean isAutoAgressive, int startingReputation, String reputationIdentifier) {
			isAutoAggressive = isAutoAgressive;
			this.startingReputation = startingReputation;
			this.reputationIdentifier = reputationIdentifier;
			nonFactionEnemies = isAutoAgressive ? null : new ArrayList<>();
		}
		public Faction addEnemy(Faction faction) {
			enemies.add(faction);
			allies.remove(faction);
			return this;
		}
		public Faction addEnemy(LivingEntity entity) {
			if(!isAutoAggressive) nonFactionEnemies.add(entity.getType());
			nonFactionAllies.remove(entity.getType());
			return this;
		}
		public Faction addAlly(Faction faction) {
			allies.add(faction);
			enemies.remove(faction);
			return this;
		}
		public Faction addAlly(LivingEntity entity) {
			EntityType<?> t = entity.getType();
			nonFactionAllies.add(t);
			if(!isAutoAggressive) nonFactionEnemies.remove(t);
			return this;
		}
		public boolean isAlly(LivingEntity entity) {
			EntityType<?> type = entity.getType();
			return (entity instanceof FactionEntity e && (e.getFaction().equals(this) || allies.contains(e.getFaction()))) || nonFactionAllies.contains(type);
		}
		public boolean isAgressiveTowards(Faction faction) {
			return faction != this && !allies.contains(faction) && (isAutoAggressive || enemies.contains(faction));
		}
		public boolean isAgressiveTowards(LivingEntity entity) {
			EntityType<?> type = entity.getType();
			if(nonFactionAllies.contains(type)) return false;
			if(!isAutoAggressive && nonFactionEnemies.contains(type)) return true;
			if(entity instanceof Player player && !player.isCreative() && !player.isSpectator() && getReputation(player) < (isAutoAggressive ? 50 : -10)) return true;
			if(entity instanceof FactionEntity fac) return isAgressiveTowards(fac.getFaction());
			return isAutoAggressive;
		}
		public void modifyReputation(Player player, int amount) {
			player.getCapability(ReputationProvider.REPUTATION).orElse(null).modifyReputation(this, amount);
		}
		@OnlyIn(Dist.CLIENT)
		public static int rep;
		public int getReputation(Player player) {
			if(player.level().isClientSide()) {
				DivineRPGPacketHandler.INSTANCE.sendToServer(new PacketRequestReputation(this));
				return rep;
			} return player.getCapability(ReputationProvider.REPUTATION).orElse(null).getReputation(this);
		}
		@Override
		public String toString() {
			return reputationIdentifier;
		}
	}
}