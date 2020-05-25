package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityDivineMob;
import divinerpg.objects.entities.entity.projectiles.EntitySaguaroWormShot;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntitySaguaroWorm extends EntityDivineMob {
    private static final DataParameter<Boolean> PROVOKED = EntityDataManager.createKey(EntitySaguaroWorm.class,
            DataSerializers.BOOLEAN);

    public EntitySaguaroWorm(World par1World) {
        super(par1World);
        this.setSize(1F, 3F);
        addAttackingAI();
    }

    @Override
    public float getEyeHeight() {
        return 2.5F;
    }

    @Override
    public void entityInit() {
        super.entityInit();
        dataManager.register(PROVOKED, Boolean.valueOf(false));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0);
    }

    @Override
    public boolean needsSpecialAI() {
        return true;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.world.isRemote) {
            EntityPlayer player = this.world.getNearestAttackablePlayer(this, 10.0D, 10.0D);
            this.setAttackTarget(player);
            if (player == null) {
                this.setProvoked(false);
            } else {
                this.setProvoked(true);
                if (this.ticksExisted % 50 == 0) {
                    this.attack(player);
                }
            }
        }
        if (!this.getProvoked()) {
            this.renderYawOffset = 0;
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setBoolean("Provoked", this.getProvoked());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
        setProvoked(tag.getBoolean("Provoked"));
    }

    public boolean getProvoked() {
        return this.dataManager.get(PROVOKED).booleanValue();
    }

    public void setProvoked(boolean provoked) {
        dataManager.set(PROVOKED, Boolean.valueOf(provoked));
    }

    public void attack(EntityLivingBase e) {
        double y = this.getEntityBoundingBox().minY + 2.7D;
        double tx = e.posX - this.posX;
        double ty = e.getEntityBoundingBox().minY - y;
        double tz = e.posZ - this.posZ;

        for (double h = -1.5; h < 1.5; h += 0.5) {
            for (double r = 0; r < 1.5 - Math.abs(h); r += 0.5) {
                for (double theta = 0; theta < Math.PI * 2; theta += Math.PI / 2) {
                    EntitySaguaroWormShot shot = new EntitySaguaroWormShot(this.world, this);
                    shot.posX = this.posX + r * Math.cos(theta);
                    shot.posY = this.posY + 5 + h;
                    shot.posZ = this.posZ + r * Math.sin(theta);
                    shot.shoot(tx, ty, tz, 0.9f, 5);
                    world.spawnEntity(shot);
                }
            }
        }
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.SAGUARO_WORM;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.SAGUARO_WORM;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_SAGUARO_WORM;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0
                && this.world.getBlockState(getPosition().down()).getBlock() == Blocks.SAND && super.getCanSpawnHere();
    }
}