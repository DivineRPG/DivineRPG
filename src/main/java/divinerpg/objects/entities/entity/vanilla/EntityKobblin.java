package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityKobblin extends EntityDivineRPGMob {
    private static final DataParameter<Boolean> PROVOKED = EntityDataManager.createKey(EntityKobblin.class,
            DataSerializers.BOOLEAN);

    public EntityKobblin(World worldIn) {
        super(worldIn);
        this.setSize(0.75F, 1F);
    }

    @Override
    public float getEyeHeight() {
        return 0.9F;
    }

    @Override
    public void entityInit() {
        super.entityInit();
        dataManager.register(PROVOKED, Boolean.valueOf(false));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


    }

    public boolean needsSpecialAI() {
        return true;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
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
            this.renderYawOffset = 0;
            EntityPlayer player = this.world.getNearestAttackablePlayer(this, 4.0D, 4.0D);
            if (player != null) {
                this.setProvoked(player);
                this.motionY = 0.6;
            }
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
        if (tag.getBoolean("Provoked"))
            setProvoked(null);
    }

    public boolean getProvoked() {
        return dataManager.get(PROVOKED).booleanValue();
    }

    @Nullable
    public void setProvoked(EntityPlayer player) {
        dataManager.set(PROVOKED, Boolean.valueOf(true));
        addBasicAI();
        addAttackingAI();
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
            this.motionY = 0.6;
        }
        return super.attackEntityFrom(source, amount);
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.KOBBLIN;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.KOBBLIN;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_KOBBLIN;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0
                && this.world.getBlockState(getPosition().down()).getBlock() == Blocks.GRASS
                && this.world.getBlockState(getPosition().down(2)).getBlock() != Blocks.AIR && super.getCanSpawnHere();
    }
}
