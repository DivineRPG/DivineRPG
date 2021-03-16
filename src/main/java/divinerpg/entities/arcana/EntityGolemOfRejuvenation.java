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
        tame(player);
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
        return TameableEntity.createMobAttributes().add(Attributes.MAX_HEALTH, EntityStats.golemRejuvHealth).add(Attributes.MOVEMENT_SPEED, EntityStats.golemRejuvSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.golemRejuvFollowRange);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GOLEM;
    }
    
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        if (this.isTame()) {
            if (item.getFoodProperties().isMeat() && this.getHealth() < this.getMaxHealth()) {
                if (!player.isCreative()) {
                    itemstack.shrink(1);
                }
                this.heal((float) item.getFoodProperties().getNutrition());
                return ActionResultType.PASS;
            } else {
                tame(player);
                this.setTame(true);
            }
        }
        return super.mobInteract(player, hand);
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
