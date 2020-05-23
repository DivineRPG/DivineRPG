package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityGorgosion extends VetheaMob {

	public EntityGorgosion(World worldIn) {
		super(worldIn);
		this.setSize(2F, 1.6f);
		this.addAttackingAI();
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();


	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		EntityPlayer closestPlayer = this.world.getClosestPlayerToEntity(this, 10);
		if(closestPlayer != null && !closestPlayer.isCreative() && this.rand.nextInt(30) == 0) {
			this.addVelocity(0, 1, 0);
		}
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
		if(distance > 2) {
			this.world.createExplosion(this, this.posX, this.posY, this.posZ, 3, false);
			return;
		}
		super.fall(distance, damageMultiplier);
	}

	@Override
	public int getSpawnLayer() {
		return 2;
	}

	@Override
	protected ResourceLocation getLootTable()
	{
		return LootTableRegistry.ENTITIES_GORGOSION;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundRegistry.GORGOSION;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundRegistry.GORGOSION_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundRegistry.GORGOSION_HURT;
	}
}