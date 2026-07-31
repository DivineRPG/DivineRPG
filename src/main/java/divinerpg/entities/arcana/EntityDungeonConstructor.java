package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntityDungeonConstructor extends EntityDivineMonster {

    public EntityDungeonConstructor(EntityType<? extends EntityDungeonConstructor> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    public void tick() {
        if (this.getTarget() != null) {
            this.lookAt(this.getTarget(), 100.0F, 100.0F);
        }

        if (!this.level().isClientSide() && this.isAlive()) {
            if (this.getTarget() != null) {
                if (this.getTarget() instanceof Player) {
                    this.moveDist = 0.0F;
                }
            }
        }
        super.tick();
    }
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.CONSTRUCTOR_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.CONSTRUCTOR_HURT.get();}
    @Override public boolean doHurtTarget(ServerLevel level, Entity target) {target.playSound(SoundRegistry.CONSTRUCTOR_PUNCH.get(), 1, 1); return super.doHurtTarget(level, target);}
}