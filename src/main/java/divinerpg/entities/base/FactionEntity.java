package divinerpg.entities.base;

import java.util.*;

import javax.annotation.Nullable;

import divinerpg.attachments.Reputation;
import divinerpg.registries.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;

public interface FactionEntity {
	Faction getFaction();
	default void modifyReputationOnHurt(DamageSource source, float f) {
		if(source.getDirectEntity() != null && source.getDirectEntity() instanceof Player player) {
			getFaction().reputation.modify(player, -1);
		} else if(source.getEntity() != null && source.getEntity() instanceof Player player) {
			getFaction().reputation.modify(player, -1);
		}
	}
	default void modifyReputationOnDeath(DamageSource source) {
		if(source.getDirectEntity() != null && source.getDirectEntity() instanceof Player player) {
			getFaction().reputation.modify(player, -10);
			for(Faction opposer : getFaction().enemies) opposer.reputation.modify(player, 2);
		} else if(source.getEntity() != null && source.getEntity() instanceof Player player) {
			getFaction().reputation.modify(player, -10);
			for(Faction opposer : getFaction().enemies) opposer.reputation.modify(player, 2);
		}
	}
	class Faction {
		public static LivingEntity getNearestEnemy(LivingEntity from, AABB searchArea, TargetingConditions conditions) {
			List<Entity> enemies = from.level().getEntities(from, searchArea, (entity) -> (entity instanceof LivingEntity ent && from instanceof FactionEntity fac && fac.getFaction().isAggressiveTowards(ent)) || (entity instanceof FactionEntity fact && fact.getFaction().isAggressiveTowards(from)));
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
			return !from.level().getEntities(from, searchArea, (entity) -> (entity instanceof LivingEntity ent && faction.isAggressiveTowards(ent) && !(entity instanceof Player player && player.isSpectator()))).isEmpty();
		}
		public static final Faction
			GROGLIN = new Faction(true, 0, AttachmentRegistry.GROGLIN_REPUTATION) {
			public boolean isAggressiveTowards(LivingEntity entity) {
				return entity.hasEffect(MobEffectRegistry.GROGLIN_BOUNTY) || super.isAggressiveTowards(entity);
			}},
			GRUZZORLUG = new Faction(true, 0, AttachmentRegistry.GRUZZORLUG_REPUTATION) {
			public boolean isAggressiveTowards(LivingEntity entity) {
				return entity.hasEffect(MobEffectRegistry.GRUZZORLUG_TARGET) || super.isAggressiveTowards(entity);
			}},
			ICEIKA_MERCHANT = new Faction(false, 20, AttachmentRegistry.ICEIKA_MERCHANT_REPUTATION).addEnemy(GROGLIN).addEnemy(GRUZZORLUG);
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
		public final Reputation reputation;
		public final boolean isAutoAggressive;
		public final int startingReputation;
		public Faction(boolean isAutoAggressive, int startingReputation, Reputation reputation) {
			this.isAutoAggressive = isAutoAggressive;
			this.startingReputation = startingReputation;
			nonFactionEnemies = isAutoAggressive ? null : new ArrayList<>();
			this.reputation = reputation;
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
		public boolean isAggressiveTowards(Faction faction) {
			return faction != this && !allies.contains(faction) && (isAutoAggressive || enemies.contains(faction));
		}
		public boolean isAggressiveTowards(LivingEntity entity) {
			EntityType<?> type = entity.getType();
			if(nonFactionAllies.contains(type)) return false;
			if(!isAutoAggressive && nonFactionEnemies.contains(type)) return true;
			if(entity instanceof Player player && !player.isCreative() && !player.isSpectator()) return hates(player);
			if(entity instanceof FactionEntity fac) return isAggressiveTowards(fac.getFaction());
			return isAutoAggressive;
		}
		public int getReputation(LivingEntity e) {
			if(e.level().isClientSide() && !reputation.has(e)) reputation.requestAttachment(e, null);
			return reputation.get(e);
		}
		public boolean hates(LivingEntity entity) {
			return getReputation(entity) < (isAutoAggressive ? 25 : -10);
		}
		public boolean likes(LivingEntity entity) {
			return getReputation(entity) > 24;
		}
	}
}