package divinerpg.objects.entities.entity.vethea;


import divinerpg.enums.ArrowType;
import divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityZone extends VetheaMob {

    public EntityZone(World worldIn) {
		super(worldIn);
		this.setSize(1F, 1.3f);
		this.setHealth(this.getMaxHealth());
	}

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513D);
	    this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
	

    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        EntityPlayer player = world.getClosestPlayerToEntity(this, 32);
        if(player != null && !player.isCreative()) {
            this.setAttackTarget(player);

            if(!this.world.isRemote && this.ticksExisted % 40 == 0) {
                this.shootEntity(this.getAttackTarget());
            }
        }
    }

    private void shootEntity(EntityLivingBase e) {
        EntityDivineArrow arrow = new EntityDivineArrow(this.world, ArrowType.KAROS_ARROW, this, e, 1.6f, 12);
        this.world.spawnEntity(arrow);
    }

    @Override
    public int getSpawnLayer() {
        return 4;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableRegistry.ENTITIES_ZONE;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ZONE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ZONE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ZONE_HURT;
    }
}
