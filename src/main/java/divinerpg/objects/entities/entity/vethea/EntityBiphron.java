package divinerpg.objects.entities.entity.vethea;


import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityBiphron extends VetheaMob {
	
    private boolean gravMove;

    public EntityBiphron(World var1) {
        super(var1);
        addAttackingAI();
        this.setSize(0.4F, 2.8F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(14);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.rand.nextInt(50) == 0) {
            this.gravMove = !this.gravMove;
        }

        if (this.gravMove) {
            this.motionY = 0.4;
        }
    }
 
    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    public int getSpawnLayer() {
    	return 2;
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.BIPHRON;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.BIPHRON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.BIPHRON_HURT;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_BIPHRON;
    }
}
