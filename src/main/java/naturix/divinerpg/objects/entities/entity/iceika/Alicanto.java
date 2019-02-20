package naturix.divinerpg.objects.entities.entity.iceika;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.registry.ModDimensions;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class Alicanto extends EntityDivineRPGMob {
    public static final ResourceLocation LOOT = new ResourceLocation(DivineRPG.modId, "entities/alicanto");
    private BlockPos currentFlightTarget;
    private int flyTimer;

    public Alicanto(World worldIn) {
        super(worldIn);
        this.setHealth(this.getMaxHealth());
        this.flyTimer = 0;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(75.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.6000000238418579D;
    }

    protected void updateAITasks() {
        super.updateAITasks();

        if (this.getAttackTarget() != null) {
            this.currentFlightTarget = this.getAttackTarget().getPosition();
        } else if (this.flyTimer != 0) {
            this.flyTimer = 120;
            this.currentFlightTarget = new BlockPos((int) (this.posX + this.rand.nextInt(16)) - 8,
                    (int) (this.posY + this.rand.nextInt(32)) - 16, (int) (this.posZ + this.rand.nextInt(16)) - 8);
        }

        if (this.currentFlightTarget != null) {
            double deltaX = (double) this.currentFlightTarget.getX() - this.posX;
            double deltaY = (double) this.currentFlightTarget.getY() - this.posY;
            double deltaZ = (double) this.currentFlightTarget.getZ() - this.posZ;

            if (Math.signum(deltaX) != 0 || Math.signum(deltaY) != 0 || Math.signum(deltaZ) != 0) {
                this.motionX += (Math.signum(deltaX) * 0.15D - this.motionX) * 0.10000000149011612D;
                this.motionY += (Math.signum(deltaY) * 1.699999988079071D - this.motionY) * 0.10000000149011612D;
                this.motionZ += (Math.signum(deltaZ) * 0.15D - this.motionZ) * 0.10000000149011612D;
                float var7 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
                float var8 = MathHelper.wrapDegrees(var7 - this.rotationYaw);
                this.moveForward = 0.5F;
                this.rotationYaw += var8;
            }
            flyTimer--;
        }
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
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.95F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.rand.nextInt(4) != 0 ? null : ModSounds.ALICANTO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.ALICANTO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ALICANTO_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL
                && world.provider.getDimension() == ModDimensions.iceikaDimension.getId();
    }
}
