package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.registry.LootTableRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
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

import javax.annotation.Nullable;

public class EntityPumpkinSpider extends EntityDivineRPGMob {
    private static final DataParameter<Boolean> CLIMBING = EntityDataManager.createKey(EntityPumpkinSpider.class,
            DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> PROVOKED = EntityDataManager.createKey(EntityPumpkinSpider.class,
            DataSerializers.BOOLEAN);

    public EntityPumpkinSpider(World worldIn) {
        super(worldIn);
        this.setSize(1.25F, 1F);
    }

    @Override
    public float getEyeHeight() {
        return 0.5F;
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
            if (player != null) {
                this.setProvoked(player);
            }
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
        return this.dataManager.get(CLIMBING).booleanValue();
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
            setProvoked(null);
    }

    public boolean getProvoked() {
        return this.dataManager.get(PROVOKED).booleanValue();
    }

    @Nullable
    public void setProvoked(EntityPlayer player) {
        dataManager.set(PROVOKED, Boolean.valueOf(true));
        addBasicAI();
        addAttackingAI();
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        if (player != null && !player.capabilities.isCreativeMode) {
            this.setAttackTarget(player);
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        Entity entity = source.getTrueSource();
        if (entity instanceof EntityPlayer && !getProvoked()) {
            EntityPlayer player = (EntityPlayer) entity;
            this.setProvoked(player);
        }
        return super.attackEntityFrom(source, amount);
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
        return LootTableRegistry.ENTITIES_PUMPKIN_SPIDER;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0
                && this.world.getBlockState(getPosition().down()).getBlock() == Blocks.GRASS && super.getCanSpawnHere();
    }
}
