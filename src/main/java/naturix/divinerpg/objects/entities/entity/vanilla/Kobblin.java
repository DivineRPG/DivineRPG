package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.block.Block;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class Kobblin extends EntityDivineRPGMob {
    public static final ResourceLocation LOOT = new ResourceLocation(DivineRPG.modId, "entities/kobblin");
    private static final DataParameter<Byte> PROVOKED = EntityDataManager.<Byte>createKey(Kobblin.class,
            DataSerializers.BYTE);

    public Kobblin(World worldIn) {
        super(worldIn);
        this.setSize(0.75F, 1F);
        this.setHealth(this.getMaxHealth());
    }

    @Override
    public void entityInit() {
        super.entityInit();
        dataManager.register(PROVOKED, (byte) 0);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0D);
    }

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
            this.renderYawOffset = 0;
            EntityPlayer player = this.world.getNearestAttackablePlayer(this, 4.0D, 4.0D);
            if (player != null) {
                this.setProvoked();
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
    protected void playStepSound(BlockPos pos, Block blockIn) {
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.KOBBLIN;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.KOBBLIN;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    @Override
    public boolean getCanSpawnHere() {
        BlockPos blockPosUnder = new BlockPos((int) this.posX, MathHelper.floor(this.getEntityBoundingBox().minY) - 1,
                (int) this.posZ);
        BlockPos blockPosOneUnder = new BlockPos((int) this.posX,
                MathHelper.floor(this.getEntityBoundingBox().minY) - 2, (int) this.posZ);
        return this.world.getBlockState(blockPosUnder).getBlock() == Blocks.GRASS
                && this.world.getBlockState(blockPosOneUnder).getBlock() != Blocks.AIR && super.getCanSpawnHere();
    }
}
