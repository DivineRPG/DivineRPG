package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityBrownGrizzle extends EntityDivineTameable {
    public <T extends Entity> EntityBrownGrizzle(EntityType<T> type, World worldIn) {
        super((EntityType<? extends TameableEntity>) type, worldIn);
        setHealth(getMaxHealth());
    }

    protected EntityBrownGrizzle(EntityType<? extends TameableEntity> type, World worldIn, PlayerEntity player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        tame(player);
    }

    protected void registerGoals() {
        this.targetSelector.addGoal(3, (new net.minecraft.entity.ai.goal.HurtByTargetGoal(this)).setAlertOthers());
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.2F;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.grizzleHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.grizzleDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.grizzleSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.grizzleFollowRange);
    }

    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        if (!this.level.isClientSide) {
            ItemStack itemstack = player.getItemInHand(hand);
            Item item = itemstack.getItem();
            if (this.isTame()) {
                if (item.getFoodProperties() != null) {
                    if (item.getFoodProperties().isMeat() && this.getHealth() < this.getMaxHealth()) {
                        if (!player.isCreative()) {
                            itemstack.shrink(1);
                        }
                        this.heal(item.getFoodProperties().getNutrition());
                        if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                            this.tame(player);
                            this.navigation.recomputePath();
                            this.setTarget((LivingEntity) null);
                            this.level.broadcastEntityEvent(this, (byte) 7);
                        } else {
                            this.level.broadcastEntityEvent(this, (byte) 6);
                        }
                    } else {
                        tame(player);
                        this.setTame(true);
                    }
                }
            }
            return super.mobInteract(player, hand);
        }
        return ActionResultType.PASS;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GRIZZLE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GRIZZLE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GRIZZLE_HURT;
    }

}
