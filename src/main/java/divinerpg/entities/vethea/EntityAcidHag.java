package divinerpg.entities.vethea;

import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityAcidHag extends EntityDivineMonster {
    public EntityAcidHag(EntityType<? extends Monster> type, Level world) {super(type, world);}
    @Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return 1.525F;}
    @Override public boolean isAggressive() {return true;}
    @Override public void tick() {
        super.tick();
        BlockPos current = new BlockPos((int)getX() - 1, (int)getY(), (int)getZ() - 1);
        BlockPos below = new BlockPos((int)getX(), (int)getY() - 1, (int)getZ() - 1);
        BlockState belowState = this.level().getBlockState(below);
        if(level().getBlockState(current).getBlock() == Blocks.AIR && belowState.isValidSpawn(level(), below, EntityRegistry.ACID_HAG.get()) && belowState.canOcclude())
            level().setBlockAndUpdate(current, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "acid_block")).defaultBlockState());
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.ACID_HAG.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.ACID_HAG_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.ACID_HAG_HURT.get();}
}