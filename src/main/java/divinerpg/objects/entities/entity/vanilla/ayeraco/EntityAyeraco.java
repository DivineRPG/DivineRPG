package divinerpg.objects.entities.entity.vanilla.ayeraco;

import divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import divinerpg.objects.entities.entity.projectiles.EntityEnderTripletsFireball;
import divinerpg.registry.SoundRegistry;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import javax.annotation.Nullable;

public class EntityAyeraco extends EntityDivineRPGBoss {
    private int waitTick;
    private BlockPos currentFlightTarget;
    private boolean attacks;
    private double moveX;
    private double moveZ;
    private boolean halfHp;
    public float moveSpeed = 0.3F;
    private BlockPos beamLocation;

    /**
     * EntityAyeraco group refference. Exists only on server side!!!
     */
    private AyeracoGroup group;
    private ResourceLocation loot;

    public EntityAyeraco(World worldIn) {
        this(worldIn, new BlockPos(0, 100, 0), new ResourceLocation(""));
    }

    /**
     * Main constructor
     *
     * @param world
     * @param beam  - beam location
     */
    public EntityAyeraco(World world, BlockPos beam, ResourceLocation loot) {
        super(world);
        beamLocation = beam;
        this.loot = loot;
        this.setSize(2.8F, 1.2F);
        this.waitTick = 0;
        this.attacks = false;
        this.halfHp = false;
        this.moveX = this.rand.nextGaussian() * 0.25 - 0.125;
        this.moveZ = this.rand.nextGaussian() * 0.25 - 0.125;

        setLocationAndAngles(beam.getX(), beam.getY() + 4, beam.getZ(),
                this.world.rand.nextFloat() * 360.0F, 0.0F);

        WorldServer serverWorld = world instanceof WorldServer
                ? ((WorldServer) world)
                : null;

        group = new AyeracoGroup(serverWorld);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.6000000238418579D;
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();

        group.tick(this);

        if (getHealth() * 2 < getMaxHealth()) {
            if (this.halfHp == false) {
                this.playSound(SoundRegistry.AYERACO_HALF_HEALTH, 20.0F,
                        0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));
                this.halfHp = true;
            }
        }

        EntityPlayer attackablePlayer = this.world.getNearestAttackablePlayer(this, 128.0D, 128.0D);
        if (attackablePlayer != null)
            this.setAttackTarget(attackablePlayer);

        if (this.waitTick == 0) {
            if (this.getAttackTarget() != null) {
                int var1 = (int) this.getAttackTarget().posX;
                int var2 = (int) this.getAttackTarget().posY;
                int var3 = (int) this.getAttackTarget().posZ;
                this.currentFlightTarget = this.getAttackTarget().getPosition();
            }

            this.motionY = 0;

            if (this.currentFlightTarget != null) {
                double var1 = this.currentFlightTarget.getX() - this.posX;
                double var3 = this.currentFlightTarget.getY() - this.posY;
                double var5 = this.currentFlightTarget.getZ() - this.posZ;

                if (Math.signum(var1) != 0 || Math.signum(var3) != 0 || Math.signum(var5) != 0) {
                    this.motionX = Math.signum(var1) * moveSpeed;
                    this.motionY += (Math.signum(var3) * 5.699999988079071D - this.motionY) * 0.10000000149011612D;
                    this.motionZ = Math.signum(var5) * moveSpeed;
                    float var7 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
                    float var8 = MathHelper.wrapDegrees(var7 - this.rotationYaw);
                    this.moveForward = 0.5F;
                    this.rotationYaw += var8;
                }
            }
        } else {
            this.waitTick--;
            this.motionY = 0.3;
            this.motionX = this.moveX;
            this.motionZ = this.moveZ;
        }

        if (!this.attacks) {
            this.waitTick = 80;
            this.attacks = true;

            if (group.canTeleport(this)) {
                this.waitTick = 0;
                this.teleportRandomUp();
            }
        }
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float par2) {
        if (isEntityInvulnerable(damageSource)
                // ignoring local mobs damage. Maybe check for Ender Dragon?
                || damageSource.getImmediateSource() instanceof EntityEnderTripletsFireball
                || (damageSource.isProjectile() && group.projectileProtected(this))) {
            return false;
        }

        if (damageSource.getTrueSource() instanceof EntityPlayer) {
            attacks = true;
        }

        return super.attackEntityFrom(damageSource, par2);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        this.attacks = false;
        return super.attackEntityAsMob(entity);
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.AYERACO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.AYERACO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.AYERACO_HURT;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setTag("group", group.serializeNBT());
        compound.setLong("beamPos", beamLocation.toLong());
        compound.setString("lootTable", loot.toString());
        return super.writeToNBT(compound);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        group.deserializeNBT(compound.getCompoundTag("group"));
        beamLocation = BlockPos.fromLong(compound.getLong("beamPos"));
        loot = new ResourceLocation(compound.getString("lootTable"));
    }

    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        if (world.isBlockLoaded(beamLocation)) {
            world.setBlockState(beamLocation, Blocks.AIR.getDefaultState());
        }
    }

    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return loot;
    }

    /**
     * Should called before spawn entity in the world
     *
     * @param group - group of ayeracos
     */
    public void initGroup(AyeracoGroup group) {
        this.group = group;
    }

    protected void teleportRandomUp() {
        this.playSound(SoundRegistry.AYERACO_TELEPORT, 2.0F, 0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));
        this.motionY = 20;
        this.motionX = this.rand.nextInt(5);
        this.motionZ = this.rand.nextInt(5);
    }
}
