package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.IAttackTimer;
import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import net.minecraft.network.syncher.*;
import net.minecraft.util.Mth;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;

public class EntitySmelter extends EntityDivineTameable implements IAttackTimer {
    private static final EntityDataAccessor<Integer> ATTACK_TIMER = SynchedEntityData.defineId(EntitySmelter.class,
            EntityDataSerializers.INT);

    public EntitySmelter(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn);
        setHealth(getMaxHealth());
    }

    protected EntitySmelter(EntityType<? extends TamableAnimal> type, Level worldIn, Player player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        tame(player);
    }


    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 3.2F;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(ATTACK_TIMER, Integer.valueOf(0));
    }

    @Override
    public void tick() {
        super.tick();
        if (getAttackTimer() > 0) {
            this.entityData.set(ATTACK_TIMER, Integer.valueOf(getAttackTimer() - 1));
        }
    }

    @Override
    public int getAttackTimer() {
        return this.entityData.get(ATTACK_TIMER).intValue();
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (!this.level().isClientSide) {
            ItemStack itemstack = player.getItemInHand(hand);
            Item item = itemstack.getItem();
            if (this.isTame()) {
                if (item == Items.FLINT && this.getHealth() < this.getMaxHealth()) {
                    if (!player.isCreative()) {
                        itemstack.shrink(1);
                    }
                    if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                        this.tame(player);
                        this.navigation.recomputePath();
                        this.setTarget((LivingEntity) null);
                        this.level().broadcastEntityEvent(this, (byte) 7);
                        this.heal(4.0F);
                    } else {
                        this.level().broadcastEntityEvent(this, (byte) 6);
                        this.heal(4.0F);
                    }
                } else {
                    tame(player);
                    this.setTame(true);
                }
            }
            return super.mobInteract(player, hand);
        }
        return InteractionResult.PASS;
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        boolean attack = super.doHurtTarget(entity);
        if (attack) {
            entity.setDeltaMovement(-Mth.sin(this.xRot * (float) Math.PI / 180.0F), 0.1D,
                    Mth.cos(this.xRot * (float) Math.PI / 180.0F));
            entity.setSecondsOnFire(5);
            this.entityData.set(ATTACK_TIMER, 10);
        }
        return attack;
    }

}