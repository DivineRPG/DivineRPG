package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import static divinerpg.registries.AttachmentRegistry.SPECIAL;

public class EntityRotatick extends EntityDivineMonster {
	public EntityRotatick(EntityType<? extends EntityRotatick> type, Level level) {
        super(type, level);
        if(!level().isClientSide() && random.nextInt(10) == 1) setData(SPECIAL.attachment, true);
    }
    public boolean isSpecialAlt() {return SPECIAL.get(this);}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.ROTATICK.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.ROTATICK_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.ROTATICK_HURT.get();}
}