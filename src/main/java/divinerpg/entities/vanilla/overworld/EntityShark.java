package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineWaterMob;
import divinerpg.registries.SoundRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static divinerpg.registries.ItemRegistry.shark_fin;

public class EntityShark extends EntityDivineWaterMob {
    private int attackTick;
    public EntityShark(EntityType<? extends EntityShark> type, Level worldIn) {
        super(type, worldIn);
        moveControl = new SmoothSwimmingMoveControl(this, 85, 10, .15F, .1F, true);
        lookControl = new SmoothSwimmingLookControl(this, 10);
    }
    @Override protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, true));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player .class, true));
    }
    @Override public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = spawnAtLocation(stack, 0);
        if(itementity != null) itementity.setExtendedLifetime();
        return itementity;
    }
    @Override public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("AttackTick", attackTick);
    }
    @Override public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        attackTick = tag.getInt("AttackTick");
    }
    @Override public void aiStep() {
        super.aiStep();
        if(isAlive() && attackTick > 0) --attackTick;
    }
    @Override public void handleEntityEvent(byte b) {
        if(b == 4) attackTick = 10;
        super.handleEntityEvent(b);
    }
    public int getAttackTick() {return attackTick;}
    @Override public boolean doHurtTarget(Entity target) {
        attackTick = 10;
        level().broadcastEntityEvent(this, (byte)4);
        if(!level().isClientSide() && level().getRandom().nextInt(12) == 2) {
            //TODO: there is no such thing as shark tooth, so I've put fin as a placeholder
            spawnAtLocation(shark_fin.get());
        } return super.doHurtTarget(target);
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.SHARK.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.SHARK_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.SHARK_HURT.get();}
}