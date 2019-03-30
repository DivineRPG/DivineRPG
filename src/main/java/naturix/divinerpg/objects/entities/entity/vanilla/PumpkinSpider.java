package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
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
import net.minecraft.world.World;

public class PumpkinSpider extends EntityDivineRPGMob {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/vanilla/pumpkin_spider");
    private static final DataParameter<Boolean> CLIMBING = EntityDataManager.<Boolean>createKey(PumpkinSpider.class,
            DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> PROVOKED = EntityDataManager.<Boolean>createKey(PumpkinSpider.class,
            DataSerializers.BOOLEAN);

    public PumpkinSpider(World worldIn) {
        super(worldIn);
        this.setSize(1.25F, 1F);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        dataManager.register(CLIMBING, Boolean.valueOf(false));
        dataManager.register(PROVOKED, Boolean.valueOf(false));
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
        this.dataManager.set(CLIMBING, Boolean.valueOf(climbing));
    }

    public boolean isBesideClimbableBlock() {
        return ((Boolean) this.dataManager.get(CLIMBING)).booleanValue();
    }

    @Override
    public boolean isOnLadder() {
        return this.getProvoked() && this.isBesideClimbableBlock();
    }

    @Override
    public void setInWeb() {
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.ARTHROPOD;
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
        return ((Boolean) this.dataManager.get(PROVOKED)).booleanValue();
    }

    public void setProvoked() {
        dataManager.set(PROVOKED, Boolean.valueOf(true));
        addBasicAI();
        addAttackingAI();
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
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
        return world.provider.getDimension() == 0
                && this.world.getBlockState(getPosition().down()).getBlock() == Blocks.GRASS && super.getCanSpawnHere();
    }
}
