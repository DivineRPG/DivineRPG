package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Mage extends EntityDivineRPGMob {

    public Mage(World var1) {
        super(var1);
        this.setSize(0.5F, 2F);
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.mageHealth);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityStats.mageDamage);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.mageSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.mageFollowRange);
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return this.rand.nextInt(4) != 0 ? null : ModSounds.INSECT;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return getAmbientSound();
    }
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/mage");
    
    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.ticksExisted % 10 == 0) {
            this.attackingPlayer = this.world.getClosestPlayerToEntity(this, 16D);
            if (this.attackingPlayer != null && !this.world.isRemote) {
                double tx = this.attackingPlayer.posX - this.posX;
                double ty = this.attackingPlayer.getEntityBoundingBox().minY - this.posY;
                double tz = this.attackingPlayer.posZ - this.posZ;
                //FIXME - Twilight mage shot
//                EntityTwilightMageShot e = new EntityTwilightMageShot(this.world, this, 62, 212, 254);
//                e.setThrowableHeading(tx, ty, tz, 1.6f, 0);
//                this.world.spawnEntityInWorld(e);
//                this.world.playSoundAtEntity(this.attackingPlayer, Sounds.mageFire.getPrefixedName(), 1, 1);
            }
        }
    }
    
    @Override
    public boolean isValidLightLevel() {
        return true;
    }

}