package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityPeacefulUntilAttacked;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class EntityCyclops extends EntityPeacefulUntilAttacked {

    public EntityCyclops(World worldIn) {
        super(worldIn);
        this.setSize(1.2F, 4.0F);
        this.experienceValue = 40;
    }

    @Override
    public float getEyeHeight() {
        return 3.5F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


    }

    @Override
    public boolean isValidLightLevel() {
        BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

        if (this.world.getLightFor(EnumSkyBlock.SKY, blockpos) > this.rand.nextInt(32)) {
            return false;
        } else {
            int i = this.world.getLightFromNeighbors(blockpos);

            if (this.world.isThundering()) {
                int j = this.world.getSkylightSubtracted();
                this.world.setSkylightSubtracted(10);
                i = this.world.getLightFromNeighbors(blockpos);
                this.world.setSkylightSubtracted(j);
            }

            return i <= this.rand.nextInt(8);
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CYCLOPS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CYCLOPS_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CYCLOPS_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_CYCLOPS;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0 && this.getPosition().getY() > world.getSeaLevel();
    }
}
