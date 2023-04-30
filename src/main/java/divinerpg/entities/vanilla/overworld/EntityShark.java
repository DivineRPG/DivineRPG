package divinerpg.entities.vanilla.overworld;

import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityDivineWaterMob;
import divinerpg.registries.SoundRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityShark extends EntityDivineWaterMob {

    public EntityShark(EntityType<? extends EntityShark> type, Level worldIn) {
        super(type, worldIn);
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.15F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.59375F;
    }

    @Override
    public boolean isAggressive() {
        return true;
    }

    @Override
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack, 0.0F);
        if (itementity != null) {
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        if(!level.isClientSide) {
            if (level.random.nextInt(12) == 2) {
                spawnAtLocation(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "shark_tooth")));
            }
        }
        return super.doHurtTarget(target);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.SHARK.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.SHARK_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.SHARK_HURT.get();
    }

}