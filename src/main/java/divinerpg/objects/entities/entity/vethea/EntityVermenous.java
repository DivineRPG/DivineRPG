package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class EntityVermenous extends VetheaMob {
	
    public int ability;
    
    public EntityVermenous(World var1) {
        super(var1);
        addAttackingAI();
        this.ability = 0;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(13);
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
        EntityPlayer var1 = this.world.getClosestPlayerToEntity(this, 64.0D);

        if (var1 == null)
            return;
        else {
            Vec3d var3 = var1.getLook(1.0F).normalize();
            Vec3d var4 = new Vec3d(this.posX - var1.posX, this.getEntityBoundingBox().minY + this.height / 2.0F - (var1.posY + var1.getEyeHeight()), this.posZ - var1.posZ);
            double var5 = var4.lengthVector();
            var4 = var4.normalize();
            double var7 = var3.dotProduct(var4);
            if(var7 > 1.0D - 0.025D / var5 && var1.canEntityBeSeen(this)) {
                var1.attackEntityFrom(DamageSource.causeMobDamage(this), 4);
            }
        }
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_VERMENOUS;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.VERMENOUS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.VERMENOUS_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.VERMENOUS_HURT;
    }
}
