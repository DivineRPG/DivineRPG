package divinerpg.objects.entities.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.ai.AIBreach;
import divinerpg.objects.entities.entity.EntityDivineWaterMob;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityWhale extends EntityDivineWaterMob {

    public EntityWhale(World worldIn) {
        super(worldIn);
        this.setSize(3F, 0.8F);
    }

    @Override
    public float getEyeHeight() {
        return 0.4F;
    }

    @Override
    protected void initEntityAI()
    {
    	super.initEntityAI();
    	this.tasks.addTask(0, new AIBreach(this));
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.WHALE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.WHALE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.WHALE_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_WHALE;
    }
    
    @Override
    public void onLivingUpdate()
    {
    	super.onLivingUpdate();
        if(posY > world.getSeaLevel()-1) {
        	if(rand.nextInt(2)==0) {
        	double y = this.getEntityBoundingBox().minY + 2.7D;
            double tx = posX - this.posX;
            double ty = getEntityBoundingBox().minY - y;
            double tz = posZ - this.posZ;

            for (double h = -1.5; h < 1.5; h += 0.5) {
                for (double r = 0; r < 1.5 - Math.abs(h); r += 0.5) {
                    for (double theta = 0; theta < Math.PI * 2; theta += Math.PI / 2) {
        	world.spawnParticle(EnumParticleTypes.WATER_WAKE, posX, posY, posZ, 0, 0.4, 0);
        	}}
        }
    }
}
}
}
