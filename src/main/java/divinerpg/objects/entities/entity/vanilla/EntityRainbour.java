package divinerpg.objects.entities.entity.vanilla;

import java.util.Calendar;
import java.util.UUID;

import javax.annotation.Nullable;

import divinerpg.DivineRPG;
import divinerpg.enums.ParticleType;
import divinerpg.objects.entities.ai.AIDivineFireballAttack;
import divinerpg.objects.entities.entity.EntityDivineFlyingMob;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityRainbour extends EntityDivineFlyingMob {

    private int angerLevel;
    private UUID angerTargetUUID;
    
    public EntityRainbour(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1F);
    }
    @Override
    public void setRevengeTarget(@Nullable EntityLivingBase livingBase)
    {
        super.setRevengeTarget(livingBase);

        if (livingBase != null)
        {
            this.angerTargetUUID = livingBase.getUniqueID();
        }
    }
    
    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.angerLevel = compound.getShort("Anger");
        String s = compound.getString("HurtBy");

        if (!s.isEmpty())
        {
            this.angerTargetUUID = UUID.fromString(s);
            EntityPlayer entityplayer = this.world.getPlayerEntityByUUID(this.angerTargetUUID);
            this.setRevengeTarget(entityplayer);

            if (entityplayer != null)
            {
                this.attackingPlayer = entityplayer;
                this.recentlyHit = this.getRevengeTimer();
            }
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
    	super.writeEntityToNBT(compound);
        compound.setShort("Anger", (short)this.angerLevel);

        if (this.angerTargetUUID != null)
        {
            compound.setString("HurtBy", this.angerTargetUUID.toString());
        }
        else
        {
            compound.setString("HurtBy", "");
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
    	if (this.isEntityInvulnerable(source))
        {
            return false;
        }
        else
        {
            Entity entity = source.getTrueSource();

            if (entity instanceof EntityPlayer)
            {
                this.becomeAngryAt(entity);
            }

            return super.attackEntityFrom(source, amount);
        }
    }


    public boolean isAngry() {
        return this.angerLevel > 0;
    }

    private void becomeAngryAt(Entity target)
    {
        this.angerLevel = 400 + this.rand.nextInt(400);

        if (target instanceof EntityLivingBase)
        {
            this.setRevengeTarget((EntityLivingBase)target);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (this.isAngry()) {
            return super.attackEntityAsMob(entity);
        }
        return false;
    }
    @Override
    public float getEyeHeight() {
        return 0.6F;
    }

    @Override
    public void entityInit() {
        super.entityInit();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public void onLivingUpdate() {
        super.onLivingUpdate();
        for (int var3 = 0; var3 < 8; ++var3) {
            DivineRPG.proxy.spawnParticle(this.world, ParticleType.SPARKLER,
                    this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width,
                    this.posY + this.rand.nextDouble() * (double) this.height - 0.25D,
                    this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width,
                    (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(),
                    (this.rand.nextDouble() - 0.5D) * 2.0D);
        }
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
    }

    @Override
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.RAINBOUR;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.RAINBOUR_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.RAINBOUR_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_RAINBOUR;
    }

    @Override
    public boolean getCanSpawnHere() {
        BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

        // Only spawn below sea level
        if (blockpos.getY() >= this.world.getSeaLevel()) {
            return false;
        } else {
            int lightLevel = this.world.getLightFromNeighbors(blockpos);
            int minLightLevel = 4;
            Calendar calendar = this.world.getCurrentDate();

            // Unless around Halloween (Oct 20 - Nov 3) there is a 50% chance not to spawn
            if ((calendar.get(Calendar.MONTH) != Calendar.OCTOBER || calendar.get(Calendar.DATE) < 20)
                    && (calendar.get(Calendar.MONTH) != Calendar.NOVEMBER || calendar.get(Calendar.DATE) > 3)) {
                if (this.rand.nextBoolean()) {
                    return false;
                }
            } else {
                minLightLevel = 7;
            }

            return world.provider.getDimension() == 0 && lightLevel <= this.rand.nextInt(minLightLevel)
                    && super.getCanSpawnHere();
        }
    }

	@Override
	protected AIDivineFireballAttack createShootAI() {
		return null;
	}
}
