package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Mystic extends EntityDivineRPGMob {

    public Mystic(World var1) {
        super(var1);
        this.setSize(0.5F, 2F);
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.mysticHealth);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityStats.mysticDamage);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.mysticSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.mysticFollowRange);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.rand.nextInt(4) != 0 ? null : ModSounds.INSECT;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return getAmbientSound();
    }
 
    @Override
    protected SoundEvent getDeathSound() {
        return getAmbientSound();
    }
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/mystic");
    
    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.ticksExisted % 10 == 0) {
            this.attackingPlayer = this.world.getClosestPlayerToEntity(this, 16D);
            if (this.getAttackTarget() != null && !this.world.isRemote) {
                double tx = this.attackingPlayer.posX - this.posX;
                double ty = this.attackingPlayer.getEntityBoundingBox().minY - this.posY;
                double tz = this.attackingPlayer.posZ - this.posZ;
                //FIXME -Sound and projectlie
//                EntityTwilightMageShot e = new EntityTwilightMageShot(this.world, this, 234, 223, 228);
//                e.setThrowableHeading(tx, ty, tz, 1.6f, 0);
//                this.world.spawnEntityInWorld(e);
//                this.world.playSoundAtEntity(this.entityToAttack, Sounds.mageFire.getPrefixedName(), 1, 1);
            }
        }
    }
    
    @Override
    public boolean isValidLightLevel() {
        return true;
    }


}