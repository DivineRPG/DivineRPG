package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class EntityEhu extends EntityDivineTameable {
    public <T extends Entity> EntityEhu(EntityType<T> type, World worldIn) {
        super((EntityType<? extends TameableEntity>) type, worldIn);
        setHealth(getMaxHealth());
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.6F;
    }

    protected EntityEhu(EntityType<? extends TameableEntity> type, World worldIn, PlayerEntity player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        setTamedBy(player);
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.ehuHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.ehuDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.ehuSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.ehuFollowRange);
    }
    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        Item item = itemstack.getItem();
        if (this.isTamed()) {
            if (!item.getFood().isMeat() && this.getHealth() < this.getMaxHealth()) {
                if (!player.abilities.isCreativeMode) {
                    itemstack.shrink(1);
                }
                if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    this.setTamedBy(player);
                    this.navigator.clearPath();
                    this.setAttackTarget((LivingEntity)null);
                    this.world.setEntityState(this, (byte)7);
                    this.heal(item.getFood().getHealing());
                } else {
                    this.world.setEntityState(this, (byte)6);
                    this.heal(item.getFood().getHealing());
                }
                } else {
                setTamedBy(player);
                this.playTameEffect(true);
            }
        }
        return super.func_230254_b_(player, hand);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GROWL;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GROWL_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GROWL_HURT;
    }
}
