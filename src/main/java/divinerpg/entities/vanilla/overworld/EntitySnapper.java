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
import net.minecraft.potion.*;
import net.minecraft.tags.*;
import net.minecraft.util.*;
import net.minecraft.world.World;

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
        setTamedBy(player);
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.snapperHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.snapperDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.snapperSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.snapperFollowRange);
    }
    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        Item item = itemstack.getItem();

        if (this.isTamed()) {
            if (ItemTags.FISHES.getAllElements().contains(item) && this.getHealth() < this.getMaxHealth()) {
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
    public void tick() {
        super.tick();
        if (this.getOwner() != null && this.getOwner() instanceof PlayerEntity) {
            if (this.rand.nextInt(3000) == 0)
                this.getOwner().addPotionEffect(new EffectInstance(Effects.SATURATION, 5));
        }
    }
}
