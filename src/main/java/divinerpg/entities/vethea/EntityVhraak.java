package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.*;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;

public class EntityVhraak extends EntityDivineMonster {

    private int spawnTick = 80;

    public EntityVhraak(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.8F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public void tick() {
        super.tick();

        if(!level().isClientSide()) {
            if(this.getTarget() != null) {
                if (this.spawnTick == 0) {
                    EntityRegistry.FAKE_VHRAAK.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, blockPosition().offset(1, 0, 1), MobSpawnType.MOB_SUMMONED, true, false);
                    EntityRegistry.FAKE_VHRAAK.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, blockPosition().offset(-1, 0, 1), MobSpawnType.MOB_SUMMONED, true, false);
                    EntityRegistry.FAKE_VHRAAK.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, blockPosition().offset(1, 0, -1), MobSpawnType.MOB_SUMMONED, true, false);
                    EntityRegistry.FAKE_VHRAAK.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, blockPosition().offset(-1, 0, -1), MobSpawnType.MOB_SUMMONED, true, false);
                    this.spawnTick = 80;
                }
                else {
                    this.spawnTick--;
                }
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.VHRAAK.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.VHRAAK_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.VHRAAK_HURT.get();
    }
}