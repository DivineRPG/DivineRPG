package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.util.EntityStats;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityParatiku extends EntityDivineTameable {
	
	private static final DataParameter<Byte> HANGING = EntityDataManager.createKey(EntityParatiku.class, DataSerializers.BYTE);
	
	private BlockPos spawnPosition;
	
	public EntityParatiku(EntityType<? extends TameableEntity> type, World worldIn, PlayerEntity player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        setTamedBy(player);
        this.setIsParatikuHanging(true);
    }
	
	public <T extends Entity> EntityParatiku(EntityType<T> type, World worldIn) {
        super((EntityType<? extends TameableEntity>) type, worldIn);
        setHealth(getMaxHealth());
        this.setIsParatikuHanging(true);
    }
	
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return this.getHeight() / 2.0F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return TameableEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.paratikuHealth).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.paratikuSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.paratikuFollowRange);
    }
    
    protected void registerData()
    {
        super.registerData();
        this.dataManager.register(HANGING, Byte.valueOf((byte)0));
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Override
    public boolean onLivingFall(float distance, float damageMultiplier) {
    	return false;
    }
    
    @Override
    protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }

    @Override
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }
    
    protected float getSoundVolume()
    {
        return 0.1F;
    }
    
    protected float getSoundPitch()
    {
        return super.getSoundPitch() * 0.95F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
    	return this.getIsParatikuHanging() && this.rand.nextInt(4) != 0 ? null : SoundEvents.ENTITY_BAT_AMBIENT;
    }
    
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_BAT_HURT;
    }
    
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_BAT_DEATH;
    }
    
    public boolean canBePushed()
    {
        return false;
    }
    
    protected void collideWithEntity(Entity entityIn) {
    }

    protected void collideWithNearbyEntities() {
    }

    public boolean getIsParatikuHanging() {
        return (this.dataManager.get(HANGING).byteValue() & 1) != 0;
    }
    
    public void setIsParatikuHanging(boolean isHanging) {
        byte b0 = this.dataManager.get(HANGING).byteValue();

        if (isHanging) {
            this.dataManager.set(HANGING, Byte.valueOf((byte) (b0 | 1)));
        } else {
            this.dataManager.set(HANGING, Byte.valueOf((byte) (b0 & -2)));
        }
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
    
    public void tick()
    {
        super.tick();

        if (this.getIsParatikuHanging())
        {
            this.setMotion(0.0D, 0.0D, 0.0D);
            this.setPosition(chunkCoordX, (double)MathHelper.floor(this.getPosY()) + 1.0D - (double)this.stepHeight, chunkCoordZ);
        }
        else
        {
            this.setMotion(getMotion().x, getMotion().y * 0.6000000238418579D, getMotion().z);
        }
    }
    
    protected void updateAITasks()
    {
        super.updateAITasks();
        BlockPos blockpos = new BlockPos(chunkCoordX, chunkCoordY, chunkCoordZ);
        BlockPos blockpos1 = blockpos.up();

        if (this.getIsParatikuHanging())
        {
            if (this.world.getBlockState(blockpos1).isNormalCube(world, blockpos1))
            {
                if (this.rand.nextInt(200) == 0)
                {
                    this.rotationYawHead = (float)this.rand.nextInt(360);
                }

                if (this.world.getClosestPlayer(this, 4.0D) != null)
                {
                    this.setIsParatikuHanging(false);
                    this.world.playEvent(null, 1025, blockpos, 0);
                }
            }
            else
            {
                this.setIsParatikuHanging(false);
                this.world.playEvent(null, 1025, blockpos, 0);
            }
        }
        else {
            if (this.spawnPosition != null && (!this.world.isAirBlock(this.spawnPosition) || this.spawnPosition.getY() < 1)) {
                this.spawnPosition = null;
            }

            if (this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.distanceSq((int) this.getPosX(), (int) this.getPosY(), (int) this.getPosZ(), true) < 4.0D) {
                this.spawnPosition = new BlockPos((int) this.getPosX() + this.rand.nextInt(7) - this.rand.nextInt(7), (int) this.getPosY() + this.rand.nextInt(6) - 2, (int) this.getPosZ() + this.rand.nextInt(7) - this.rand.nextInt(7));
            }

            double d0 = (double) this.spawnPosition.getX() + 0.5D - this.getPosX();
            double d1 = (double) this.spawnPosition.getY() + 0.1D - this.getPosY();
            double d2 = (double) this.spawnPosition.getZ() + 0.5D - this.getPosZ();
            this.setMotion(this.getMotion().x + (Math.signum(d0) * 0.5D - this.getMotion().x) * 0.10000000149011612D, this.getMotion().y + (Math.signum(d1) * 0.699999988079071D - this.getMotion().y) * 0.10000000149011612D, this.getMotion().z + (Math.signum(d2) * 0.5D - this.getMotion().z) * 0.10000000149011612D);
            float f = (float) (MathHelper.atan2(this.getMotion().z, this.getMotion().x) * (180D / Math.PI)) - 90.0F;
            float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
            this.moveForward = 0.5F;
            this.rotationYaw += f1;

            if (this.rand.nextInt(100) == 0 && this.world.getBlockState(blockpos1).isNormalCube(world, blockpos1))
            {
                this.setIsParatikuHanging(true);
            }
        }
    }
    
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (source.isCreativePlayer())
        {
            return false;
        }
        else
        {
            if (!this.world.isRemote && this.getIsParatikuHanging())
            {
                this.setIsParatikuHanging(false);
            }

            return super.attackEntityFrom(source, amount);
        }
    }
    
    public void readEntityFromNBT(CompoundNBT compound)
    {
        super.readAdditional(compound);
        this.dataManager.set(HANGING, Byte.valueOf(compound.getByte("ParatikuFlags")));
    }
    
    public void writeEntityToNBT(CompoundNBT compound)
    {
        super.writeAdditional(compound);
        if (this.getOwnerId() == null) {
            compound.putString("Owner", "");
        } else {
            compound.putString("Owner", this.getOwnerId().toString());
        }
        compound.putByte("ParatikuFlags", this.dataManager.get(HANGING).byteValue());
    }
}
