package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.AttachmentRegistry;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityRotatick extends EntityDivineMonster {
	public EntityRotatick(EntityType<? extends EntityRotatick> type, Level level) {
        super(type, level);
        if(!level().isClientSide() && random.nextInt(10) == 1) setData(AttachmentRegistry.SPECIAL.attachment, true);
    }
    @Override
    public void onAddedToLevel() {
        super.onAddedToLevel();
        if(level().isClientSide()) AttachmentRegistry.SPECIAL.requestAttachment(this, null);
    }
    public boolean isSpecialAlt() {
        return AttachmentRegistry.SPECIAL.get(this);
    }
    @Override
    protected SoundEvent getAmbientSound() {return SoundRegistry.ROTATICK.get();}
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.ROTATICK_HURT.get();}
    @Override
    protected SoundEvent getDeathSound() {return SoundRegistry.ROTATICK_HURT.get();}
}
