package divinerpg.entities.base;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.gameevent.GameEvent;
import javax.annotation.Nullable;
import java.util.UUID;

public class EntityDivineTameable extends TamableAnimal implements NeutralMob {
    private static final EntityDataAccessor<Integer> DATA_COLLAR_COLOR = SynchedEntityData.defineId(EntityDivineTameable.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_REMAINING_ANGER_TIME = SynchedEntityData.defineId(EntityDivineTameable.class, EntityDataSerializers.INT);
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    @Nullable private UUID persistentAngerTarget;
	protected final float healthIncrease;
    protected EntityDivineTameable(EntityType<? extends TamableAnimal> type, Level worldIn, float healthIncrease) {
        super(type, worldIn);
        this.healthIncrease = healthIncrease;
        setTame(false);
    }
    public boolean isMeat(ItemStack item) {return item.getFoodProperties(this) != null && item.getFoodProperties(this).isMeat();}
    @Override protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(1, new FloatGoal(this));
        goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        goalSelector.addGoal(4, new LeapAtTargetGoal(this, .4F));
        goalSelector.addGoal(5, new MeleeAttackGoal(this, 1, true));
        goalSelector.addGoal(6, new FollowOwnerGoal(this, 1, 10, 2, false));
//      goalSelector.addGoal(7, new BreedGoal(this, 1));
        goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1));
        goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8));
        goalSelector.addGoal(10, new RandomLookAroundGoal(this));
        targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        targetSelector.addGoal(3, new HurtByTargetGoal(this).setAlertOthers());
        targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        targetSelector.addGoal(5, new ResetUniversalAngerTargetGoal<>(this, true));
    }
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader reader) {return 0;}
    @Override public boolean hurt(DamageSource source, float amount) {
        if(isInvulnerableTo(source)) return false;
        else {
            Entity entity = source.getEntity();
            if(!level().isClientSide()) setOrderedToSit(false);
            if(entity != null && !(entity instanceof Player) && !(entity instanceof AbstractArrow)) amount = (amount + 1) / 2;
            return super.hurt(source, amount);
        }
    }
    @Override public void setTame(boolean tamed) {
        super.setTame(tamed);
        if(isTame()) {
            AttributeInstance attribute = getAttribute(Attributes.MAX_HEALTH);
            attribute.setBaseValue(attribute.getValue() * healthIncrease);
        }
    }
    @Override protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DATA_COLLAR_COLOR, DyeColor.RED.getId());
        entityData.define(DATA_REMAINING_ANGER_TIME, 0);
    }
    @Override public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putByte("CollarColor", (byte)getCollarColor().getId());
        addPersistentAngerSaveData(tag);
    }
    @Override public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if(tag.contains("CollarColor", 99)) setCollarColor(DyeColor.byId(tag.getInt("CollarColor")));
        readPersistentAngerSaveData(level(), tag);
    }
    @Override public void aiStep() {
        super.aiStep();
        if(!level().isClientSide()) updatePersistentAnger((ServerLevel)level(), true);
    }
    public DyeColor getCollarColor() {return DyeColor.byId(entityData.get(DATA_COLLAR_COLOR));}
    public void setCollarColor(DyeColor color) {entityData.set(DATA_COLLAR_COLOR, color.getId());}
    @Override public boolean isFood(ItemStack item) {return isMeat(item);}
    protected boolean isTamingFood(ItemStack item) {return isMeat(item);}
    @Override public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        if(level().isClientSide()) return isOwnedBy(player) ? InteractionResult.CONSUME : InteractionResult.PASS;
        if(isTame()) {
            if(isFood(itemstack) && getHealth() < getMaxHealth()) {
                if(!player.isCreative()) itemstack.shrink(1);
                heal((float) item.getFoodProperties(itemstack, this).getNutrition());
                gameEvent(GameEvent.EAT, this);
                return InteractionResult.SUCCESS;
            }
            if(item instanceof DyeItem dyeitem) {
                if(isOwnedBy(player)) {
                    DyeColor dyecolor = dyeitem.getDyeColor();
                    if(dyecolor != getCollarColor()) {
                        setCollarColor(dyecolor);
                        if(!player.getAbilities().instabuild) itemstack.shrink(1);
                        return InteractionResult.SUCCESS;
                    } return super.mobInteract(player, hand);
                }
            }
            InteractionResult actionresulttype = super.mobInteract(player, hand);
            if((!actionresulttype.consumesAction() || isBaby()) && isOwnedBy(player)) {
                setOrderedToSit(!isOrderedToSit());
                jumping = false;
                navigation.stop();
                setTarget(null);
                return InteractionResult.SUCCESS;
            }
        } else if(isTamingFood(itemstack) && !isAngry() && !player.isCreative()) {
            itemstack.shrink(1);
            if(random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                tame(player);
                navigation.stop();
                setTarget(null);
                setOrderedToSit(true);
                level().broadcastEntityEvent(this, (byte)7);
            } else level().broadcastEntityEvent(this, (byte)6);
            return InteractionResult.SUCCESS;
        } else if(player.isCreative()) tame(player);
        return super.mobInteract(player, hand);
    }
    @Override public boolean wantsToAttack(LivingEntity entity, LivingEntity entity1) {
        if(!(entity instanceof Creeper) && !(entity instanceof Ghast)) {
            if(entity instanceof EntityDivineTameable) {
                EntityDivineTameable pet = (EntityDivineTameable)entity;
                return !pet.isTame() || pet.getOwner() != entity1;
            } else if(entity instanceof Player && entity1 instanceof Player && !((Player)entity1).canHarmPlayer((Player)entity)) return false;
            else if(entity instanceof AbstractHorse && ((AbstractHorse)entity).isTamed()) return false;
            else return !(entity instanceof TamableAnimal) || !((TamableAnimal)entity).isTame();
        } else return false;
    }
    @Override public boolean canBeLeashed(Player player) {return !isAngry() && super.canBeLeashed(player);}
    @Override public int getRemainingPersistentAngerTime() {return entityData.get(DATA_REMAINING_ANGER_TIME);}
    @Override public void setRemainingPersistentAngerTime(int p_30404_) {entityData.set(DATA_REMAINING_ANGER_TIME, p_30404_);}
    @Override public void startPersistentAngerTimer() {setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(random));}
    @Override @Nullable public UUID getPersistentAngerTarget() {return persistentAngerTarget;}
    @Override public void setPersistentAngerTarget(@Nullable UUID p_30400_) {persistentAngerTarget = p_30400_;}
	@Override public AgeableMob getBreedOffspring(ServerLevel s, AgeableMob a) {return null;}
    @Override public boolean canMate(Animal animal) {return false;}
    @Override public boolean removeWhenFarAway(double distanceToClosestPlayer) {return !isTame();}
}