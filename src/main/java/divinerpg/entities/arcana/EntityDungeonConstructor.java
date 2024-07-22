package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.*;
import net.minecraft.world.entity.player.Player;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntityDungeonConstructor extends EntityDivineMonster {
    
	private int angerLevel;
	
	public EntityDungeonConstructor(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        this.angerLevel = 0;
    }
//	@Override
//	public float getStepHeight() {
//		return 1F;
//	}
    @Override public boolean fireImmune() {return true;}
    @Override public boolean isAggressive() {return true;}
    @Override
    public void tick() {
        if (this.getTarget() != null) {
            this.lookAt(this.getTarget(), 100.0F, 100.0F);
        }

        if (!this.level().isClientSide() && this.isAlive()) {
            if (this.getTarget() != null) {
                if (this.getTarget() instanceof Player && this.angerLevel < 3) {
                    this.moveDist = 0.0F;
                }
            }
        }
        super.tick();
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CONSTRUCTOR_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CONSTRUCTOR_HURT.get();
    }
    
    @Override
    public boolean doHurtTarget(Entity par1Entity) {
        par1Entity.playSound(SoundRegistry.CONSTRUCTOR_PUNCH.get(), 1, 1);
        return super.doHurtTarget(par1Entity);
    }
}
