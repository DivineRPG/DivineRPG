package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineWaterMob;
import divinerpg.registries.SoundRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import static net.minecraft.world.item.Items.BONE;

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
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
    @Override public ItemEntity spawnAtLocation(ServerLevel level, ItemStack stack) {
        ItemEntity itementity = spawnAtLocation(level, stack, 0);
        if(itementity != null) itementity.setExtendedLifetime();
        return itementity;
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
    output.putInt("AttackTick", attackTick);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
    attackTick = input.getIntOr("AttackTick", 0);
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
    @Override public boolean doHurtTarget(ServerLevel level, Entity target) {
        attackTick = 10;
        level().broadcastEntityEvent(this, (byte)4);
        //TODO: there is no such thing as shark tooth (edit: bone), so I've put fin as a placeholder
        if(!level().isClientSide() && level().getRandom().nextInt(12) == 2) spawnAtLocation(level, BONE);
        return super.doHurtTarget(level, target);
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.SHARK.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.SHARK_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.SHARK_HURT.get();}
}