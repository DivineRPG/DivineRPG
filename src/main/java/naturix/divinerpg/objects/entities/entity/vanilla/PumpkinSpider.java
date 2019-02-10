package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class PumpkinSpider extends EntityDivineRPGMob {
    public static final ResourceLocation LOOT = new ResourceLocation(DivineRPG.modId, "entities/pumpkin_spider");
    private static final DataParameter<Byte> CLIMBING = EntityDataManager.<Byte>createKey(PumpkinSpider.class,
            DataSerializers.BYTE);
    private static final DataParameter<Byte> PROVOKED = EntityDataManager.<Byte>createKey(PumpkinSpider.class,
            DataSerializers.BYTE);

    public PumpkinSpider(World worldIn) {
        super(worldIn);
        this.setSize(1.25F, 1F);
        this.setHealth(this.getMaxHealth());
    }

    @Override
    public void entityInit() {
        super.entityInit();
        dataManager.register(CLIMBING, (byte) 0);
        dataManager.register(PROVOKED, (byte) 0);
    }

    @Override
    protected PathNavigate createNavigator(World worldIn) {
        return new PathNavigateClimber(this, worldIn);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0D);
    }

    @Override
    public boolean needsSpecialAI() {
        return true;
    }

    @Override
    public void addVelocity(double x, double y, double z) {
        if (this.getProvoked())
            super.addVelocity(x, y, z);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!getProvoked()) {
            EntityPlayer player = this.world.getNearestAttackablePlayer(this, 6.0D, 6.0D);
            this.renderYawOffset = 0;
            if (player != null)
                this.setProvoked();
        } else {
            if (!this.world.isRemote) {
                this.setBesideClimbableBlock(this.collidedHorizontally);
            }
        }
    }

    public void setBesideClimbableBlock(boolean climbing) {
        byte b0 = ((Byte) this.dataManager.get(CLIMBING)).byteValue();

        if (climbing) {
            b0 = (byte) (b0 | 1);
        } else {
            b0 = (byte) (b0 & -2);
        }

        this.dataManager.set(CLIMBING, Byte.valueOf(b0));
    }

    public boolean isBesideClimbableBlock() {
        return (((Byte) this.dataManager.get(CLIMBING)).byteValue() & 1) != 0;
    }

    @Override
    public boolean isOnLadder() {
        return this.getProvoked() && this.isBesideClimbableBlock();
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setBoolean("Provoked", this.getProvoked());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
        if (tag.getBoolean("Provoked"))
            setProvoked();
    }

    public boolean getProvoked() {
        return dataManager.get(PROVOKED) == 1;
    }

    public void setProvoked() {
        dataManager.set(PROVOKED, (byte) 1);
        addBasicAI();
        addAttackingAI();
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SPIDER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SPIDER_DEATH;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    @Override
    public boolean getCanSpawnHere() {
        BlockPos blockPos = new BlockPos((int) this.posX, MathHelper.floor(this.getEntityBoundingBox().minY) - 1,
                (int) this.posZ);
        return this.world.getBlockState(blockPos).getBlock() == Blocks.GRASS && super.getCanSpawnHere();
    }
}
