package divinerpg.entities.arcana;

import divinerpg.capability.*;
import divinerpg.entities.base.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntitySeimer extends EntityDivineTameable {
	
	public EntitySeimer(EntityType<? extends TameableEntity> type, World worldIn, PlayerEntity player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        tame(player);
    }
	
	public <T extends Entity> EntitySeimer(EntityType<T> type, World worldIn) {
        super((EntityType<? extends TameableEntity>) type, worldIn);
        setHealth(getMaxHealth());
    }
	
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.6F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return TameableEntity.createMobAttributes().add(Attributes.MAX_HEALTH, EntityStats.seimerHealth).add(Attributes.MOVEMENT_SPEED, EntityStats.seimerSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.seimerFollowRange);
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
        if (this.getOwner() != null && this.getOwner() instanceof PlayerEntity) {
            IArcana arcana = getOwner().getCapability(ArcanaProvider.ARCANA_CAP).orElse(null);
            arcana.fill((PlayerEntity) this.getOwner(), 1);
        }
    }
}