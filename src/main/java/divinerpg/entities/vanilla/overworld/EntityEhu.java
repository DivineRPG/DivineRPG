package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.*;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;

public class EntityEhu extends EntityDivineTameable {
    public EntityEhu(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn);
        setHealth(getMaxHealth());
    }
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.6F;
    }
    protected EntityEhu(EntityType<? extends TamableAnimal> type, Level worldIn, Player player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        tame(player);
    }
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (!this.level.isClientSide) {
            ItemStack itemstack = player.getItemInHand(hand);
            Item item = itemstack.getItem();
            if (this.isTame()) {
                if (item.getFoodProperties(itemstack, player) != null) {
                    if (item.getFoodProperties(itemstack, player).isMeat() && this.getHealth() < this.getMaxHealth()) {
                        if (!player.isCreative()) itemstack.shrink(1);
                        if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                            this.tame(player);
                            this.navigation.recomputePath();
                            this.setTarget((LivingEntity) null);
                            this.level.broadcastEntityEvent(this, (byte) 7);
                            this.heal(item.getFoodProperties(itemstack, player).getNutrition());
                        } else {
                            this.level.broadcastEntityEvent(this, (byte) 6);
                            this.heal(item.getFoodProperties(itemstack, player).getNutrition());
                        }
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
        return SoundRegistry.GROWL.get();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GROWL_HURT.get();
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GROWL_HURT.get();
    }
}