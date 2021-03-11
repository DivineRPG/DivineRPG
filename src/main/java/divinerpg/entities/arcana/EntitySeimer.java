package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntitySeimer extends EntityDivineTameable {
	
	public EntitySeimer(EntityType<? extends TameableEntity> type, World worldIn, PlayerEntity player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        setTamedBy(player);
    }
	
	public <T extends Entity> EntitySeimer(EntityType<T> type, World worldIn) {
        super((EntityType<? extends TameableEntity>) type, worldIn);
        setHealth(getMaxHealth());
    }
	
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.6F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return TameableEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.seimerHealth).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.seimerSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.seimerFollowRange);
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
    // TODO arcana replenishing
    /*
    @Override
    public void tick() {
        super.tick();
        if (this.getOwner() != null && this.getOwner() instanceof PlayerEntity) {
            IArcana arcana = DivineAPI.getArcana(this.getOwner());
            arcana.fill((PlayerEntity) this.getOwner(), 1);
        }
    }*/
}