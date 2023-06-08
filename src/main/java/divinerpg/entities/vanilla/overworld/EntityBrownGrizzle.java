package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import net.minecraft.world.*;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class EntityBrownGrizzle extends EntityDivineTameable {
    public EntityBrownGrizzle(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn);
        setHealth(getMaxHealth());
    }
    protected EntityBrownGrizzle(EntityType<? extends TamableAnimal> type, Level worldIn, Player player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        tame(player);
    }
    protected void registerGoals() {
        this.targetSelector.addGoal(3, (new net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal(this)).setAlertOthers());
    }
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.22F;
    }
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (!this.level().isClientSide) {
            ItemStack itemstack = player.getItemInHand(hand);
            Item item = itemstack.getItem();
            if (this.isTame()) {
                if (item.getFoodProperties(itemstack, player) != null) {
                    if (item.getFoodProperties(itemstack, player).isMeat() && this.getHealth() < this.getMaxHealth()) {
                        if (!player.isCreative()) itemstack.shrink(1);
                        this.heal(item.getFoodProperties(itemstack, player).getNutrition());
                        if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                            this.tame(player);
                            this.navigation.recomputePath();
                            this.setTarget((LivingEntity) null);
                            this.level().broadcastEntityEvent(this, (byte) 7);
                        } else this.level().broadcastEntityEvent(this, (byte) 6);
                    } else {
                        tame(player);
                        this.setTame(true);
                    }
                }
            }
            return super.mobInteract(player, hand);
        }
        return InteractionResult.PASS;
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GRIZZLE.get();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GRIZZLE_HURT.get();
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GRIZZLE_HURT.get();
    }
}