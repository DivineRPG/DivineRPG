package divinerpg.entities.base;

import divinerpg.DivineRPG;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityDivineTameable extends TamableAnimal {

    protected EntityDivineTameable(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn);
        setTame(false);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(7, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader reader) {
        return 0.0F;
    }
    protected void increaseHealthIfTimable() {
        if (this.isTame()) {
            AttributeInstance attribute = getAttribute(Attributes.MAX_HEALTH);
            attribute.setBaseValue(attribute.getValue() * 2);
        }
    }

    public boolean isAngry() {
        return false;
    }

    @Override
    public boolean doHurtTarget(Entity e) {
        boolean attack = super.doHurtTarget(e);
        if(!isTame()) {
            if (attack && e instanceof LivingEntity) {
                ((LivingEntity) e).canAttack(this);
            }
            e.hurt(e.level().damageSources().mobAttack(this), (float) getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue());
        }
        return attack;
    }

    @Override
    public InteractionResult interactAt(Player p_184199_1_, Vec3 p_184199_2_, InteractionHand p_184199_3_) {
        return super.interactAt(p_184199_1_, p_184199_2_, p_184199_3_);
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        if (this.level().isClientSide) {
            boolean flag = this.isOwnedBy(player) || this.isTame() || item == Items.BONE && !this.isTame();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (this.isTame()) {
                if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                    if (!player.isCreative()) {
                        itemstack.shrink(1);
                    }

                    this.heal((float)item.getFoodProperties(itemstack, this).getNutrition());
                    return InteractionResult.SUCCESS;
                }

                InteractionResult actionresulttype = super.mobInteract(player, hand);
                if ((!actionresulttype.consumesAction() || this.isBaby()) && this.isOwnedBy(player)) {
                    this.setOrderedToSit(!this.isOrderedToSit());
                    this.jumping = false;
                    this.navigation.stop();
                    this.setTarget((LivingEntity)null);
                    return InteractionResult.SUCCESS;
                }


            } else if (item == Items.CARROT || item == Items.APPLE || item == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "moonbulb"))) {
                if (!player.isCreative()) {
                    itemstack.shrink(1);
                }

                if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    this.tame(player);
                    this.navigation.stop();
                    this.setTarget((LivingEntity)null);
                    this.setOrderedToSit(true);
                    this.level().broadcastEntityEvent(this, (byte)7);
                } else {
                    this.level().broadcastEntityEvent(this, (byte)6);
                }

                return InteractionResult.SUCCESS;
            } else tame(player);
            return super.mobInteract(player, hand);
        }
    }

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
		return null;
	}
}
