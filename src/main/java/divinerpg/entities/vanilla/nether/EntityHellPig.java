package divinerpg.entities.vanilla.nether;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.TagRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.pig.PigSoundVariant;
import net.minecraft.world.entity.animal.pig.PigSoundVariants;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntityHellPig extends EntityDivineTameable {
    public EntityHellPig(EntityType<? extends EntityHellPig> type, Level worldIn) {super(type, worldIn, 2);}
    @Override public boolean isFood(ItemStack item) {return item.is(TagRegistry.PET_HELL_PIG);}
    @Override protected boolean isTamingFood(ItemStack item) {return item.is(TagRegistry.TAMING_HELL_PIG);}
    private PigSoundVariant.PigSoundSet getSoundSet() {
        PigSoundVariant variant = this.registryAccess()
                .lookupOrThrow(Registries.PIG_SOUND_VARIANT)
                .get(PigSoundVariants.CLASSIC)
                .map(holder -> (PigSoundVariant) holder.value())
                .orElseThrow();

        return this.isBaby() ? variant.babySounds() : variant.adultSounds();
    }

    @Override
    public SoundEvent getAmbientSound() {
        return (SoundEvent) this.getSoundSet().ambientSound().value();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent) this.getSoundSet().hurtSound().value();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return (SoundEvent) this.getSoundSet().deathSound().value();
    }
}