package divinerpg.entities.iceika;

import java.util.List;

import divinerpg.DivineRPG;
import divinerpg.entities.ai.FactionTargetGoal;
import divinerpg.entities.base.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.storage.loot.*;
import net.minecraft.world.level.storage.loot.parameters.*;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class EntityIceikaNPC extends EntityDivineMonster implements FactionEntity {
	public static String getItemName(int i) {
		return switch(i) {
		case 1 -> "oxdrite_pickaxe";//gruzzorlug miner
		case 2 -> "icicle_bane";//groglin warrior
		case 3 -> "icicle_bow";//groglin hunter
		case 4 -> "frozen_maul";//gruzzorlug knight
		case 5 -> "frost_sword";//gruzzorlug swordsman
		case 6 -> "frostking_sword";//gruzzorlug general
		case 7 -> "frost_cannon";//gruzzorlug cannoneer
		case 8 -> "fractite_cannon";//gruzzorlug commander
		case 9 -> "glacier_sword";//groglin chieftain
		case 10 -> "serenade_of_ice";//groglin sharlatan
		case 11 -> "sabear_sabre";//groglin ranger
		case 12 -> "blue_armor_pouch";//groglin merchant
		default -> null;
		};
	}
    protected static final EntityDataAccessor<Integer> ITEM = SynchedEntityData.defineId(EntityIceikaNPC.class, EntityDataSerializers.INT);
    public boolean isImportant = false;
	public EntityIceikaNPC(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        ((GroundPathNavigation) getNavigation()).setCanOpenDoors(true);
    }
	protected abstract TagKey<Item> getAcceptedItems();
	protected abstract String getTradesLocation();
	protected abstract TagKey<Structure> getRaidTargets();
	protected abstract MobEffect getTargetEffect();
	@Override
	protected void registerGoals() {
		goalSelector.addGoal(0, new FloatGoal(this));
        if(!(this instanceof RangedAttackMob)) goalSelector.addGoal(0, new MeleeAttackGoal(this, 1, false));
        goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1D));
        goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6F));
        goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        targetSelector.addGoal(1, new FactionTargetGoal<>(this, getFaction(), true, !(this instanceof RangedAttackMob)));
        targetSelector.addGoal(2, new HurtByTargetGoal(this));
	}
	protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(ITEM, 0);
    }
	public int heldItem() {
        return entityData.get(ITEM);
    }
	@Override
	protected InteractionResult mobInteract(Player player, InteractionHand hand) {
		if(getFaction().getReputation(player) > 5) {
			ItemStack stack = player.getItemInHand(hand);
			if(stack.is(getAcceptedItems())) {
				ItemStack trade = getTradedItem(player);
				if(trade != null) {
					if(!player.isCreative()) {
						stack.shrink(1);
						player.setItemInHand(hand, stack);
					}
					level().addFreshEntity(new ItemEntity(level(), getX(), getY(), getZ(), trade));
					getFaction().modifyReputation(player, 1);
					return InteractionResult.CONSUME;
				}
			}
		} playSound(SoundEvents.VILLAGER_NO);
		return InteractionResult.FAIL;
	}
	private ItemStack getTradedItem(Player player) {
		if(player.level().isClientSide()) return null;
        ResourceLocation lootTableLocation = new ResourceLocation(DivineRPG.MODID, getTradesLocation());
        LootParams lootparams = (new LootParams.Builder((ServerLevel) player.level())).withParameter(LootContextParams.THIS_ENTITY, player).withParameter(LootContextParams.ORIGIN, player.position()).create(LootContextParamSets.SELECTOR);
        if(new LootContext.Builder(lootparams).create(lootTableLocation) != null) {
            List<ItemStack> tradedItems = player.getServer().getLootData().getLootTable(lootTableLocation).getRandomItems(lootparams);
            if(!tradedItems.isEmpty()) return tradedItems.get(0);
        } return null;
	}
	@Override
	public void die(DamageSource source) {
		if(random.nextInt(4) == 0) {
			int item = entityData.get(ITEM);
			String drop = getItemName(item);
			if(drop != null) {
				ItemStack i = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, drop)));
				if(i.isDamageableItem()) i.setDamageValue(getRandom().nextInt(i.getMaxDamage()));
				level().addFreshEntity(new ItemEntity(level(), getX(), getY(), getZ(), i));
			}
		} modifyReputationOnDeath(source);
		super.die(source);
	}
	@Override
	public void modifyReputationOnDeath(DamageSource source) {
		if(isImportant && level() instanceof ServerLevel level) {
			if(source.getDirectEntity() != null && source.getDirectEntity() instanceof LivingEntity entity)
				entity.addEffect(new MobEffectInstance(getTargetEffect(), -1, 0, false, false, true));
			if(source.getEntity() != null && source.getEntity() instanceof LivingEntity entity)
				entity.addEffect(new MobEffectInstance(getTargetEffect(), -1, 0, false, false, true));
		} FactionEntity.super.modifyReputationOnDeath(source);
	}
	@Override
	public boolean hurt(DamageSource source, float f) {
		modifyReputationOnHurt(source, f);
		return super.hurt(source, f);
	}
	@Override
	protected boolean shouldDespawnInPeaceful() {
		return false;
	}
	@Override
	public boolean removeWhenFarAway(double d) {
		return false;
	}
	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		if(tag.contains("Important")) isImportant = tag.getBoolean("Important");
	}
	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putBoolean("Important", isImportant);
	}
}