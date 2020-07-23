package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityLorgaflight extends VetheaMob {
	
    private BlockPos currentFlightTarget;
    private int flyTimer, spawnTick;
    public boolean canSpawnMinions;

    public EntityLorgaflight(World w){
    	this(w, true);
    }
    
    public EntityLorgaflight(World var1, boolean canSpawnMinions) {
        super(var1);
        this.canSpawnMinions = canSpawnMinions;
        this.flyTimer = 0;
        this.addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();

        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
    }

    @Override
    public int getSpawnLayer() {
    	return 3;
    }
    
    @Override
    public void fall(float distance, float damageMultiplier)
    {

    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.spawnTick == 0 && this.canSpawnMinions && !this.world.isRemote) {
            this.spawnTick = 200;
            EntityLorgaflight var2 = new EntityLorgaflight(this.world, false);
            var2.setLocationAndAngles(this.posX + 1, this.posY, this.posZ + 1, this.rotationYaw, this.rotationPitch);
            this.world.spawnEntity(var2);
        }
        else if (this.spawnTick > 0) {
            this.spawnTick--;
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.6000000238418579D;
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();

        if (this.getAttackTarget() != null) {
            int var1 = (int) this.getAttackTarget().posX;
            int var2 = (int) this.getAttackTarget().posY;
            int var3 = (int) this.getAttackTarget().posZ;
            this.currentFlightTarget = new BlockPos(var1, var2, var3);
        }
        else if (this.flyTimer != 0) {
            this.flyTimer = 120;
            this.currentFlightTarget = new BlockPos((int)(this.posX + this.rand.nextInt(16)) - 8, (int)(this.posY + this.rand.nextInt(32)) - 16, (int)(this.posZ + this.rand.nextInt(16)) - 8);
        }

        if (this.currentFlightTarget != null) {
            double var1 = this.currentFlightTarget.getX() - this.posX;
            double var3 = this.currentFlightTarget.getY() - this.posY;
            double var5 = this.currentFlightTarget.getZ() - this.posZ;

            if (Math.signum(var1) != 0 || Math.signum(var3) != 0 || Math.signum(var5) != 0) {
                this.motionX += (Math.signum(var1) * 0.15D - this.motionX) * 0.10000000149011612D;
                this.motionY += (Math.signum(var3) * 1.699999988079071D - this.motionY) * 0.10000000149011612D;
                this.motionZ += (Math.signum(var5) * 0.15D - this.motionZ) * 0.10000000149011612D;
                float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
                float var8 = MathHelper.wrapDegrees(var7 - this.rotationYaw);
                this.moveForward = 0.5F;
                this.rotationYaw += var8;
            }
            flyTimer--;
        }
    }
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
    	super.writeToNBT(tag);
    	tag.setBoolean("CanSpawnMinions", this.canSpawnMinions);
		return tag;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound tag) {
    	super.readFromNBT(tag);
    	this.canSpawnMinions = tag.getBoolean("CanSpawnMinions");
    }
    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableRegistry.ENTITIES_LORGAFLIGHT;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.LORGAFLIGHT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.LORGAFLIGHT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.LORGAFLIGHT_HURT;
    }

}
