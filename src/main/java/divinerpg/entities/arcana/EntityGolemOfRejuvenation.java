package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityGolemOfRejuvenation extends EntityDivineTameable {
	
	private int healTimer;
	
	public EntityGolemOfRejuvenation(EntityType<? extends TameableEntity> type, World worldIn, PlayerEntity player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        setTamedBy(player);
        this.healTimer = 0;
    }
	
	public <T extends Entity> EntityGolemOfRejuvenation(EntityType<T> type, World worldIn) {
        super((EntityType<? extends TameableEntity>) type, worldIn);
        setHealth(getMaxHealth());
    }
	
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 2.0F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return TameableEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.golemRejuvHealth).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.golemRejuvSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.golemRejuvFollowRange);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GOLEM;
    }
    
    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        Item item = itemstack.getItem();
        if (this.isTamed()) {
            if (item.getFood().isMeat() && this.getHealth() < this.getMaxHealth()) {
                if (!player.abilities.isCreativeMode) {
                    itemstack.shrink(1);
                }
                this.heal((float) item.getFood().getHealing());
                return ActionResultType.PASS;
            } else {
                setTamedBy(player);
                this.playTameEffect(true);
            }
        }
        return super.func_230254_b_(player, hand);
    }
    
    @Override
    public void tick() {
        super.tick();
        if (this.getOwner() != null) {
            if (this.healTimer == 16) {
                this.getOwner().heal(1);
                this.healTimer = 0;
            } else {
                this.healTimer++;
            }
        }
    }
}
