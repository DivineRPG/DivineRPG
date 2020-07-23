package divinerpg.objects.entities.entity;

import java.util.UUID;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class EntityPeacefulUntilAttacked extends EntityDivineMob {

    private int angerLevel;
    private UUID angerTargetUUID;
    public EntityPeacefulUntilAttacked(World world) {
        super(world);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 1F, true));
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
    public void entityInit() {
        super.entityInit();
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

    @Override
    public boolean isValidLightLevel() {
        return true;
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
    public boolean isPreventingPlayerRest(EntityPlayer playerIn) {
        return this.isAngry();
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (this.isAngry()) {
            return super.attackEntityAsMob(entity);
        }
        return false;
    }
}