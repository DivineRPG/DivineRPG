package divinerpg.entities.iceika;

import java.util.List;
import divinerpg.DivineRPG;
import divinerpg.entities.ai.FactionTargetGoal;
import divinerpg.entities.base.*;
import divinerpg.registries.ItemRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.storage.loot.*;
import net.minecraft.world.level.storage.loot.parameters.*;
import javax.annotation.Nullable;

public abstract class EntityIceikaNPC extends EntityDivineMonster implements FactionEntity {
	public static Item getItem(int i) {
		return switch(i) {
		case 1 -> ItemRegistry.oxdrite_pickaxe.get();//gruzzorlug miner
		case 2 -> ItemRegistry.icicle_bane.get();//groglin warrior
		case 3 -> ItemRegistry.icicle_bow.get();//groglin hunter
		case 4 -> ItemRegistry.frozen_maul.get();//gruzzorlug knight
		case 5 -> ItemRegistry.frost_sword.get();//gruzzorlug swordsman
		case 6 -> ItemRegistry.frostking_sword.get();//gruzzorlug general
		case 7 -> ItemRegistry.frost_cannon.get();//gruzzorlug cannoneer
		case 8 -> ItemRegistry.fractite_cannon.get();//gruzzorlug commander
		case 9 -> ItemRegistry.glacier_sword.get();//groglin chieftain
		case 10 -> ItemRegistry.serenade_of_ice.get();//groglin sharlatan
		case 11 -> ItemRegistry.sabear_sabre.get();//groglin ranger
		case 12 -> ItemRegistry.blue_armor_pouch.get();//groglin merchant
		default -> null;
		};
	}
    protected static final EntityDataAccessor<Integer> ITEM = SynchedEntityData.defineId(EntityIceikaNPC.class, EntityDataSerializers.INT);
    protected boolean important = false;
	public EntityIceikaNPC(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        setPathfindingMalus(BlockPathTypes.POWDER_SNOW, -1);
    }
	protected abstract TagKey<Item> getAcceptedItems();
	protected abstract String getTradesLocation();
	protected abstract TagKey<Structure> getRaidTargets();
	protected abstract MobEffect getTargetEffect();
	@Override protected void registerGoals() {
		goalSelector.addGoal(0, new FloatGoal(this));
        if(!(this instanceof RangedAttackMob)) goalSelector.addGoal(0, new MeleeAttackGoal(this, 1, false));
        goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1));
        goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6));
        goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        targetSelector.addGoal(1, new FactionTargetGoal<>(this, getFaction(), true, !(this instanceof RangedAttackMob)));
        targetSelector.addGoal(2, new HurtByTargetGoal(this));
	}
	@Override protected PathNavigation createNavigation(Level level) {
		GroundPathNavigation nav = new GroundPathNavigation(this, level);
		nav.setCanOpenDoors(true);
		nav.setCanPassDoors(true);
		return nav;
	}
	@Override protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(ITEM, 0);
    }
	@Override protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
		super.populateDefaultEquipmentSlots(random, difficulty);
		setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(getItem(entityData.get(ITEM))));
	}
	@Nullable
	@Override public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType type, @Nullable SpawnGroupData data, @Nullable CompoundTag tag) {
		RandomSource random = level.getRandom();
		populateDefaultEquipmentSlots(random, difficulty);
		populateDefaultEquipmentEnchantments(random, difficulty);
		return super.finalizeSpawn(level, difficulty, type, data, tag);
	}
	public void setUnimportant() {important = false;}
	@Override protected InteractionResult mobInteract(Player player, InteractionHand hand) {
		if(getFaction().getReputation(player) > 5) {
			ItemStack stack = player.getItemInHand(hand);
			if(stack.is(getAcceptedItems())) {
				ItemStack trade = getTradedItem(player);
				if(trade != null) {
					if(!player.isCreative()) {
						stack.shrink(1);
						player.setItemInHand(hand, stack);
					} level().addFreshEntity(new ItemEntity(level(), getX(), getY(), getZ(), trade));
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
	@Override public void die(DamageSource source) {
		modifyReputationOnDeath(source);
		super.die(source);
	}
	@Override public void modifyReputationOnDeath(DamageSource source) {
		if(important && level() instanceof ServerLevel) {
			if(source.getDirectEntity() != null && source.getDirectEntity() instanceof LivingEntity entity)
				entity.addEffect(new MobEffectInstance(getTargetEffect(), -1, 0, false, false, true));
			if(source.getEntity() != null && source.getEntity() instanceof LivingEntity entity)
				entity.addEffect(new MobEffectInstance(getTargetEffect(), -1, 0, false, false, true));
		} FactionEntity.super.modifyReputationOnDeath(source);
	}
	@Override public boolean hurt(DamageSource source, float f) {
		modifyReputationOnHurt(source, f);
		return super.hurt(source, f);
	}
	@Override protected boolean shouldDespawnInPeaceful() {return false;}
	@Override public boolean removeWhenFarAway(double d) {return false;}
	@Override public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		if(tag.contains("Important")) important = tag.getBoolean("Important");
	}
	@Override public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putBoolean("Important", important);
	}
}