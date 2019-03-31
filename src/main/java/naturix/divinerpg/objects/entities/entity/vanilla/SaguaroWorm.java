package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.objects.entities.entity.projectiles.EntitySaguaroWormShot;
import naturix.divinerpg.registry.DRPGSoundHandler;
import naturix.divinerpg.utils.Reference;
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

public class SaguaroWorm extends EntityDivineRPGMob {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/vanilla/saguaro_worm");
    private static final DataParameter<Boolean> PROVOKED = EntityDataManager.<Boolean>createKey(SaguaroWorm.class,
            DataSerializers.BOOLEAN);

    public SaguaroWorm(World par1World) {
        super(par1World);
        this.setSize(0.5F, 3F);
        addAttackingAI();
    }

    @Override
    public void entityInit() {
        super.entityInit();
        dataManager.register(PROVOKED, Boolean.valueOf(false));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4);
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
                    this.attack((EntityLivingBase) player);
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
        return ((Boolean) this.dataManager.get(PROVOKED)).booleanValue();
    }

    public void setProvoked(boolean provoked) {
        dataManager.set(PROVOKED, Boolean.valueOf(provoked));
    }

    public void attack(EntityLivingBase e) {
        double y = this.getEntityBoundingBox().minY + 2.7D;
        double tx = e.posX - this.posX;
        double ty = e.getEntityBoundingBox().minY - y;
        double tz = e.posZ - this.posZ;

        for (double h = -1.5; h < 1.5; h += 0.3) {
            for (double r = 0; r < 1.5 - Math.abs(h); r += 0.3) {
                for (double theta = 0; theta < Math.PI * 2; theta += Math.PI / 8) {
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
        return DRPGSoundHandler.SAGUARO_WORM;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return DRPGSoundHandler.SAGUARO_WORM;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0
                && this.world.getBlockState(getPosition().down()).getBlock() == Blocks.SAND && super.getCanSpawnHere();
    }
}