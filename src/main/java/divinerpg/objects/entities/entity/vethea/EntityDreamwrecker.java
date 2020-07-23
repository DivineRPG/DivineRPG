package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityDreamwrecker extends VetheaMob {

    public EntityDreamwrecker(World worldIn) {
        super(worldIn);
        this.setSize(1F, 4.4f);
    }
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        EntityPlayer var1 = this.world.getClosestPlayerToEntity(this, 64.0D);

        if(var1 != null && !var1.isCreative() && var1.getDistance(this) < 20) {
            this.setAttackTarget(var1);
        }

        Entity attackTarget = this.getAttackTarget();
        if(attackTarget != null && attackTarget instanceof EntityPlayer && !((EntityPlayer)attackTarget).isCreative() && !attackTarget.isDead && this.canEntityBeSeen(attackTarget)) {
            attackTarget.addVelocity(Math.signum(this.posX - attackTarget.posX) * 0.029, 0, Math.signum(this.posZ - attackTarget.posZ) * 0.029);
        }
        else {
            this.setAttackTarget(null);
        }
    }

    @Override
    public int getSpawnLayer() {
        return 1;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableRegistry.ENTITIES_DREAMWRECKER;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DREAMWRECKER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DREAMWRECKER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DREAMWRECKER_HURT;
    }
}