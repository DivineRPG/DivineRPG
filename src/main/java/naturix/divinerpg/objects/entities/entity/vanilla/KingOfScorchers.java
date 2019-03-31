package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityKingOfScorchersMeteor;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityKingOfScorchersShot;
import naturix.divinerpg.registry.DRPGSoundHandler;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class KingOfScorchers extends EntityDivineRPGBoss {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/vanilla/king_of_scorchers");
    private int special;

    public KingOfScorchers(World worldIn) {
        super(worldIn);
        this.setSize(2.0F, 3.9F);
        this.special = 0;
        this.isImmuneToFire = true;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(22.0D);
    }

    /*
     * @Override protected void entityInit() { super.entityInit();
     * this.dataWatcher.addObject(16, new Integer(100));
     * this.dataWatcher.addObject(13, new Byte((byte) 0)); }
     */

    @Override
    protected void updateAITasks() {
        if (this.ticksExisted % 250 == 0 && this.special == 0) {
            this.special = 15;
        }

        EntityLivingBase attackTarget = this.getAttackTarget();
        if (this.special > 0 && attackTarget != null) {
            this.special--;
            if (this.special % 5 == 0) {
                for (int i = 0; i < 4; i++) {
                    EntityKingOfScorchersMeteor meteor = new EntityKingOfScorchersMeteor(this.world,
                            attackTarget.posX + (rand.nextDouble() - rand.nextDouble()) * 2, attackTarget.posY + 10,
                            attackTarget.posZ + (rand.nextDouble() - rand.nextDouble()) * 2);
                    meteor.motionX = (rand.nextDouble() - rand.nextDouble()) / 5;
                    meteor.motionY = -0.7;
                    meteor.motionZ = (rand.nextDouble() - rand.nextDouble()) / 5;
                    world.spawnEntity(meteor);
                }
            }
        }
        super.updateAITasks();
        EntityPlayer player = this.world.getNearestAttackablePlayer(this, 40.0D, 40.0D);
        this.setAttackTarget(player);
        if (player != null && !this.world.isRemote && this.ticksExisted % 15 == 0) {
            this.attackEntityWithRangedAttack(player);
        }
    }

    @Override
    public int getTotalArmorValue() {
        return 10;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float par2) {
        if (source.isExplosion())
            return false;
        return super.attackEntityFrom(source, par2);
    }

    public void attackEntityWithRangedAttack(Entity entity) {
        double tx = entity.posX - this.posX;
        double ty = entity.getEntityBoundingBox().minY - this.posY - 2;
        double tz = entity.posZ - this.posZ;
        EntityKingOfScorchersShot shot = new EntityKingOfScorchersShot(this.world, this);
        shot.shoot(tx, ty, tz, 1.3f, 1);
        world.spawnEntity(shot);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return DRPGSoundHandler.KING_OF_SCORCHERS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return DRPGSoundHandler.KING_OF_SCORCHERS_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}
