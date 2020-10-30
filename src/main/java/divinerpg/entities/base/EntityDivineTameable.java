package divinerpg.entities.base;

import divinerpg.registries.ItemRegistry;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class EntityDivineTameable extends TameableEntity {

    protected EntityDivineTameable(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
        setTamed(false);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new SitGoal(this));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(7, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(10, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(10, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setCallsForHelp());
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, 20.0D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 8).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.27D);
    }

    protected void increaseHealthIfTimable() {
        if (this.isTamed()) {
            ModifiableAttributeInstance attribute = getAttribute(Attributes.MAX_HEALTH);
            attribute.setBaseValue(attribute.getValue() * 2);
        }
    }

    @Override
    public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }

    public boolean isAngry() {
        return false;
    }
    @Override
    public boolean attackEntityAsMob(Entity e) {
        boolean attack = super.attackEntityAsMob(e);
        if(!isTamed()) {
            if (attack && e instanceof LivingEntity) {
                ((LivingEntity) e).setRevengeTarget(this);
            }
            e.attackEntityFrom(DamageSource.causeMobDamage(this),
                    (float) getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue());
        }
        return attack;
    }
    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        Item item = itemstack.getItem();
        if (this.world.isRemote) {
            boolean flag = this.isOwner(player) || this.isTamed() || item == Items.BONE && !this.isTamed();
            return flag ? ActionResultType.CONSUME : ActionResultType.PASS;
        } else {
            if (this.isTamed()) {
                if (this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
                    if (!player.abilities.isCreativeMode) {
                        itemstack.shrink(1);
                    }

                    this.heal((float) item.getFood().getHealing());
                    return ActionResultType.SUCCESS;
                }

                    ActionResultType actionresulttype = super.func_230254_b_(player, hand);
                    if ((!actionresulttype.isSuccessOrConsume() || this.isChild()) && this.isOwner(player)) {
                        this.func_233687_w_(!this.isTamed());
                        this.isJumping = false;
                        this.navigator.clearPath();
                        this.setAttackTarget((LivingEntity) null);
                        return actionresulttype;
                }


            } else if (item == Items.CARROT || item == Items.APPLE || item == ItemRegistry.moonbulb) {
                if (!player.abilities.isCreativeMode) {
                    itemstack.shrink(1);
                }

                if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    this.setTamedBy(player);
                    this.navigator.clearPath();
                    this.setAttackTarget((LivingEntity) null);
                    this.func_233687_w_(true);
                    this.world.setEntityState(this, (byte) 7);
                } else {
                    this.world.setEntityState(this, (byte) 6);
                }

                return ActionResultType.SUCCESS;
            }
            return super.func_230254_b_(player, hand);
        }
    }
}
