package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntityGolemOfRejuvenation extends EntityDivineTameable {
    private int healTimer;
    public EntityGolemOfRejuvenation(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn, 1);
        healTimer = 0;
    }
    @Override public void tick() {
        super.tick();
        if(getOwner() != null) {
            if(healTimer == 16) {
                getOwner().heal(1);
                healTimer = 0;
            } else healTimer++;
        }
    }
    @Override public boolean isFood(ItemStack item) {return item.is(TagRegistry.PET_FOODS_GOLEM_OF_REJUVENATION);}
    @Override protected boolean isTamingFood(ItemStack item) {return item.is(TagRegistry.PET_TAMING_FOODS_GOLEM_OF_REJUVENATION);}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.GOLEM.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.GROWL_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.GROWL_HURT.get();}
}