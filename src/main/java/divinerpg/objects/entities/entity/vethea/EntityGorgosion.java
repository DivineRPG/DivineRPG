package divinerpg.objects.entities.entity.vethea;


import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityGorgosion extends VetheaMob {
	

	public EntityGorgosion(World var1) {
		super(var1);
		addAttackingAI();
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
	}

	@Override
    public int getSpawnLayer() {
    	return 2;
    }

	@Override
	public void fall(float par1, float par2)
    {
		if(par1 > 2) {
			this.world.createExplosion(this, this.posX, this.posY, this.posZ, 3, false);
			return;
		}
		super.fall(par1, par2);
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if(this.world.getClosestPlayerToEntity(this, 10) != null && this.rand.nextInt(30) == 0) {
			this.addVelocity(0, 1, 0);
		}
	}

	@Override
	protected float getSoundVolume() {
		return 0.7F;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float par2) {
		if (source.isExplosion()) return false;
		return super.attackEntityFrom(source, par2);
	}

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_GORGOSION;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.GORGOSION;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.GORGOSION_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.GORGOSION_HURT;
    }
}
