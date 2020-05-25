package divinerpg.objects.entities.entity.twilight;

import divinerpg.objects.entities.entity.EntityDivineMob;
import divinerpg.registry.LootTableRegistry;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityTermid extends EntityDivineMob {
	public EntityTermid(World par1World) {
		super(par1World);
		this.setSize(0.4F, 1.2F);
	}
	
	@Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.BLOCK_WOOD_STEP;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BLOCK_WOOD_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_WOOD_BREAK;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_TERMID;
    }
    
    @Override
    public void fall(float distance, float damageMultiplier){}
}
