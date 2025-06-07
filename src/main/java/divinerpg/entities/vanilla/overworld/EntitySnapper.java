package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static net.minecraft.tags.ItemTags.FISHES;
import static net.minecraft.world.effect.MobEffects.SATURATION;
import static net.minecraft.world.item.Items.KELP;
import static net.minecraft.world.item.Items.SEAGRASS;
import static net.neoforged.neoforge.common.Tags.Items.SLIME_BALLS;

public class EntitySnapper extends EntityDivineTameable {
    public EntitySnapper(EntityType<? extends EntitySnapper> type, Level worldIn) {super(type, worldIn, 1);}
    @Override public boolean isFood(ItemStack item) {return item.is(FISHES) || item.is(KELP) || item.is(SEAGRASS);}
    @Override protected boolean isTamingFood(ItemStack item) {return item.is(SLIME_BALLS);}
    @Override public void tick() {
        super.tick();
        if(getOwner() != null && getOwner() instanceof Player && random.nextInt(3000) == 0) getOwner().addEffect(new MobEffectInstance(SATURATION, 120));
    }
    @Override protected SoundEvent getAmbientSound() {return SoundEvents.TURTLE_AMBIENT_LAND;}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundEvents.TURTLE_HURT;}
    @Override protected SoundEvent getDeathSound() {return SoundEvents.TURTLE_DEATH;}
}