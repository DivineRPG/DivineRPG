package divinerpg.entities.vanilla.nether;

import divinerpg.entities.base.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityHellPig extends EntityDivineTameable {
    private static final DataParameter<Float> HEALTH = EntityDataManager.defineId(EntityHellPig.class,
            DataSerializers.FLOAT);
    private static final DataParameter<Boolean> ANGRY = EntityDataManager.defineId(EntityHellPig.class,
            DataSerializers.BOOLEAN);

    protected EntityHellPig(EntityType<? extends TameableEntity> type, World worldIn, PlayerEntity player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        tame(player);
    }

    public <T extends Entity> EntityHellPig(EntityType<T> type, World worldIn) {
        super((EntityType<? extends TameableEntity>) type, worldIn);
        setHealth(getMaxHealth());
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.8F;
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(HEALTH, this.getHealth());
        entityData.define(ANGRY, Boolean.FALSE);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.entityData.set(HEALTH, this.getHealth());
    }

    @Override
    public void setTarget(LivingEntity attackTarget) {
        super.setTarget(attackTarget);
        if (attackTarget == null)
            this.setAngry(false);
        else if (!this.isTame())
            this.setAngry(true);
    }
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        if (this.isTame()) {
            if (item.getFoodProperties().isMeat() && this.getHealth() < this.getMaxHealth()) {
                if (!player.isCreative()) {
                    itemstack.shrink(1);
                }
        }
            if (item == Items.BLAZE_POWDER && !isAngry()) {
                if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    this.tame(player);
                    this.getNavigation().recomputePath();
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
    public void setTame(boolean tamed) {
        super.setTame(tamed);
        increaseHealthIfTimable();
    }


    @Override
    public void addAdditionalSaveData(CompoundNBT tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("Angry", this.isAngry());
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT tag) {
        super.readAdditionalSaveData(tag);
        setAngry(tag.getBoolean("Angry"));
    }

    public boolean isAngry() {
        return this.entityData.get(ANGRY);
    }

    public void setAngry(boolean angry) {
        this.entityData.set(ANGRY, angry);
        MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.hellPigTamedHealth);
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.hellPigHealth).add(Attributes.ATTACK_DAMAGE, 5).add(Attributes.MOVEMENT_SPEED, EntityStats.hellPigSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.hellPigRange);
    }

    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return true;
    }
}