package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

import static net.minecraft.world.damagesource.DamageTypes.FELL_OUT_OF_WORLD;

public class EntityLheiva extends EntityDivineMonster {
    public EntityLheiva(EntityType<? extends EntityLheiva> type, Level worldIn) {super(type, worldIn);}
    @Override public boolean hurt(DamageSource source, float par2) {
        Entity var1 = source.getDirectEntity();
        if(var1 instanceof Player && ((Player)var1).getInventory().contains(ItemRegistry.band_of_lheiva_hunting.get().getDefaultInstance())) return super.hurt(source, par2);
        else if(source.is(FELL_OUT_OF_WORLD)) return super.hurt(source, par2);
        return false;
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.LHEIVA.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.LHEIVA_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.LHEIVA_HURT.get();}
}