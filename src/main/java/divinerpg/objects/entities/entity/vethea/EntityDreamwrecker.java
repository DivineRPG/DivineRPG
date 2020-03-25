package divinerpg.objects.entities.entity.vethea;


import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityDreamwrecker extends VetheaMob {
	
    public EntityDreamwrecker(World var1) {
        super(var1);
        addAttackingAI();
        setSize(0.8f, 4);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
    }

    @Override
    public int getSpawnLayer() {
    	return 2;
    }
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        EntityLivingBase var1 = this.world.getClosestPlayerToEntity(this, 64.0D);

        if (var1 != null && var1.getDistance(this) < 20) var1 = getAttackTarget();
        if(this.getAttackTarget() != null && this.getAttackTarget() instanceof EntityPlayer && !this.getAttackTarget().isDead && this.canEntityBeSeen(this.getAttackTarget()))this.getAttackTarget().addVelocity(Math.signum(this.posX - this.getAttackTarget().posX) * 0.029, 0, Math.signum(this.posZ - this.getAttackTarget().posZ) * 0.029);
        if(this.getAttackTarget() != null && (this.getAttackTarget().getDistance(this) >= 20 || this.getAttackTarget().isDead)) this.attackingPlayer = null;
    }
 
    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.DREAMWRECKER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.DREAMWRECKER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.DREAMWRECKER_HURT;
    }
    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_DREAMWRECKER;
    }
}
