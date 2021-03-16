package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.tags.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntitySnapper extends EntityDivineTameable {
    public <T extends Entity> EntitySnapper(EntityType<T> type, World worldIn) {
        super((EntityType<? extends TameableEntity>) type, worldIn);
        setHealth(getMaxHealth());
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.4F;
    }

    protected EntitySnapper(EntityType<? extends TameableEntity> type, World worldIn, PlayerEntity player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        tame(player);
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.snapperHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.snapperDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.snapperSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.snapperFollowRange);
    }
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();

        if (this.isTame()) {
            if (ItemTags.FISHES.getValues().contains(item) && this.getHealth() < this.getMaxHealth()) {
                if (!player.isCreative()) {
                    itemstack.shrink(1);
                }
                if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    this.tame(player);
                    this.navigation.recomputePath();
                    this.setTarget((LivingEntity)null);
                    this.level.broadcastEntityEvent(this, (byte)7);
                    this.heal(item.getFoodProperties().getNutrition());
                } else {
                    this.level.broadcastEntityEvent(this, (byte)6);
                    this.heal(item.getFoodProperties().getNutrition());
                }
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
            if (this.random.nextInt(3000) == 0)
                this.getOwner().addEffect(new EffectInstance(Effects.SATURATION, 5));
        }
    }
}
