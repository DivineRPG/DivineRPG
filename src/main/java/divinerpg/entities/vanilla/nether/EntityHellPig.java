package divinerpg.entities.vanilla.nether;

import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.Random;

public class EntityHellPig extends EntityDivineTameable {
    private static final EntityDataAccessor<Float> HEALTH = SynchedEntityData.defineId(EntityHellPig.class,
            EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Boolean> ANGRY = SynchedEntityData.defineId(EntityHellPig.class,
            EntityDataSerializers.BOOLEAN);

    protected EntityHellPig(EntityType<? extends TamableAnimal> type, Level worldIn, Player player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        this.setTame(false);
    }

    public EntityHellPig(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        this.setTame(false);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
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

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        if (this.isTame() && item.getFoodProperties(itemstack, player) != null) {
            if (item.getFoodProperties(itemstack, player).isMeat() && this.getHealth() < this.getMaxHealth()) {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                this.heal((float) itemstack.getFoodProperties(this).getNutrition());
                this.gameEvent(GameEvent.EAT, this);
                return InteractionResult.SUCCESS;
            }
        }
        if (itemstack.is(Items.BLAZE_POWDER) && !isAngry() && !this.isTame()) {
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }
            if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                this.tame(player);
                this.navigation.stop();
                this.setTarget((LivingEntity)null);
                this.level.broadcastEntityEvent(this, (byte)7);
            } else {
                this.level.broadcastEntityEvent(this, (byte)6);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }


    @Override
    public void setTame(boolean tamed) {
        super.setTame(tamed);
        increaseHealthIfTimable();
    }


    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("Angry", this.isAngry());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setAngry(tag.getBoolean("Angry"));
    }

    public boolean isAngry() {
        return this.entityData.get(ANGRY);
    }

    public void setAngry(boolean angry) {
        this.entityData.set(ANGRY, angry);
        Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 10);
    }

    public static boolean canSpawnOn(EntityType<? extends Mob> typeIn, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, Random randomIn) {
        return true;
    }
}