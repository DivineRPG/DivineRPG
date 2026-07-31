package divinerpg.entities.base;

import divinerpg.registries.AttachmentRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.equine.AbstractHorse;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.event.EventHooks;

import javax.annotation.Nullable;
import java.util.UUID;

public class EntityDivineTameable extends TamableAnimal implements NeutralMob {
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    protected final float healthIncrease;
    private UUID angry_at;

    protected EntityDivineTameable(EntityType<? extends TamableAnimal> type, Level worldIn, float healthIncrease) {
        super(type, worldIn);
        this.healthIncrease = healthIncrease;
        setTame(false, false);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(1, new FloatGoal(this));
        goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        goalSelector.addGoal(4, new LeapAtTargetGoal(this, .4F));
        goalSelector.addGoal(5, new MeleeAttackGoal(this, 1, true));
        goalSelector.addGoal(6, new FollowOwnerGoal(this, 1, 10, 2));
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

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader reader) { return 0; }

    @Override
    public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
        if (isInvulnerableTo(level, source)) return false;
        else {
            Entity entity = source.getEntity();
            if (!level().isClientSide()) setOrderedToSit(false);
            if (entity != null && !(entity instanceof Player) && !(entity instanceof AbstractArrow)) amount = (amount + 1) / 2;
            return super.hurtServer(level, source, amount);
        }
    }

    @Override
    protected void applyTamingSideEffects() {
        if (isTame()) {
            getAttribute(Attributes.MAX_HEALTH).setBaseValue(getMaxHealth() * healthIncrease);
            setHealth(getMaxHealth());
        } else {
            getAttribute(Attributes.MAX_HEALTH).setBaseValue(getMaxHealth());
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (!level().isClientSide()) updatePersistentAnger((ServerLevel) level(), true);
    }

    // Modern NeoForge Attachments getter/setter helpers
    public DyeColor getCollarColor() {
        return DyeColor.byId(this.getData(AttachmentRegistry.COLOR.attachment.get()));
    }

    public void setCollarColor(DyeColor color) {
        this.setData(AttachmentRegistry.COLOR.attachment.get(), color.getId());
    }

    public boolean isMeat(ItemStack stack) {
        return stack.is(ItemTags.MEAT);
    }

    // Default food & taming food
    @Override
    public boolean isFood(ItemStack item) {
        return isMeat(item);
    }

    protected boolean isTamingFood(ItemStack item) {
        return isMeat(item);
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (!level().isClientSide() || (isBaby() && isFood(itemstack))) {
            if (isTame()) {
                if (isFood(itemstack) && getHealth() < getMaxHealth()) {
                    // Modern 1.21+ Data Components food check
                    FoodProperties foodproperties = itemstack.get(DataComponents.FOOD);
                    float f = foodproperties != null ? (float) foodproperties.nutrition() : 1;
                    heal(2 * f);
                    itemstack.consume(1, player);
                    gameEvent(GameEvent.EAT, this);
                    return InteractionResult.SUCCESS;
                }

                DyeColor dyecolor = itemstack.get(DataComponents.DYE);
                if (dyecolor != null && isOwnedBy(player)) {
                    if (dyecolor != getCollarColor()) {
                        setCollarColor(dyecolor);
                        itemstack.consume(1, player);
                        return InteractionResult.SUCCESS;
                    }
                    return super.mobInteract(player, hand);
                }

                InteractionResult interactionresult = super.mobInteract(player, hand);
                if (!interactionresult.consumesAction() && isOwnedBy(player)) {
                    setOrderedToSit(!isOrderedToSit());
                    jumping = false;
                    navigation.stop();
                    setTarget(null);
                    return InteractionResult.SUCCESS;
                } else {
                    return interactionresult;
                }
            } else if (isTamingFood(itemstack) && !isAngry() && !player.isCreative()) {
                itemstack.consume(1, player);
                if (random.nextInt(3) == 0 && !EventHooks.onAnimalTame(this, player)) {
                    tame(player);
                    navigation.stop();
                    setTarget(null);
                    setOrderedToSit(true);
                    level().broadcastEntityEvent(this, (byte) 7);
                } else {
                    level().broadcastEntityEvent(this, (byte) 6);
                }
                return InteractionResult.SUCCESS;
            } else if (player.isCreative()) {
                tame(player);
            }
            return super.mobInteract(player, hand);
        } else {
            boolean flag = isOwnedBy(player) || isTame() || (isTamingFood(itemstack) && !isTame() && !isAngry());
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        }
    }

    @Override
    public void tame(Player player) {
        super.tame(player);
        setCollarColor(DyeColor.RED);
    }

    @Override
    public boolean wantsToAttack(LivingEntity entity, LivingEntity entity1) {
        if (!(entity instanceof Creeper) && !(entity instanceof Ghast)) {
            return switch (entity) {
                case EntityDivineTameable pet -> !pet.isTame() || pet.getOwner() != entity1;
                case Player player when entity1 instanceof Player && !((Player) entity1).canHarmPlayer(player) -> false;
                case AbstractHorse abstractHorse when abstractHorse.isTamed() -> false;
                default -> !(entity instanceof TamableAnimal) || !((TamableAnimal) entity).isTame();
            };
        } else return false;
    }

    @Override
    public boolean canBeLeashed() {
        return !isAngry() && super.canBeLeashed();
    }

    @Override
    public long getPersistentAngerEndTime() {
        return getData(AttachmentRegistry.ANGER_TIME.attachment.get());
    }

    @Override
    public void setPersistentAngerEndTime(long l) {
        setData(AttachmentRegistry.ANGER_TIME.attachment.get(), (int)l);
    }

    @Override
    public void startPersistentAngerTimer() {
        setPersistentAngerEndTime(PERSISTENT_ANGER_TIME.sample(random));
    }

    @Override
    public @Nullable EntityReference<LivingEntity> getPersistentAngerTarget() {
        if (isAngry() && angry_at != null) return EntityReference.of(angry_at);
        return null;
    }

    @Override
    public boolean isAngry() {
        return this.getData(AttachmentRegistry.ANGRY.attachment.get());
    }

    @Override
    public void setPersistentAngerTarget(@Nullable EntityReference<LivingEntity> entityReference) {
        if (entityReference != null) {
            angry_at = entityReference.getUUID();
            setData(AttachmentRegistry.ANGRY.attachment.get(), true);
        } else {
            angry_at = null;
            setData(AttachmentRegistry.ANGRY.attachment.get(), false);
        }
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        String angryAtStr = input.getStringOr("angryAt", "");
        if (!angryAtStr.isEmpty()) {
            try {
                angry_at = UUID.fromString(angryAtStr);
            } catch (IllegalArgumentException e) {
                angry_at = null;
            }
        } else {
            angry_at = null;
        }
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        if (angry_at != null) {
            output.putString("angryAt", angry_at.toString());
        }
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel s, AgeableMob a) { return null; }

    @Override
    public boolean canMate(Animal animal) { return false; }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) { return false; }
}