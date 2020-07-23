package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityAcidHag extends VetheaMob {

    public EntityAcidHag(World var1) {
        super(var1);
        this.addAttackingAI();
    }


    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        BlockPos current = new BlockPos((int)posX - 1, (int)posY, (int)posZ - 1);
        BlockPos below = new BlockPos((int)posX - 1, (int)posY - 1, (int)posZ - 1);
        IBlockState belowState = this.world.getBlockState(below);

        if(this.world.getBlockState(current).getBlock() == Blocks.AIR) {
            if(belowState.isOpaqueCube() && belowState.isFullCube()) {
                this.world.setBlockState(current, BlockRegistry.acidBlock.getDefaultState());
            }
        }
    }

    @Override
    public int getSpawnLayer() {
        return 1;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableRegistry.ENTITIES_ACID_HAG;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ACID_HAG;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ACID_HAG_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ACID_HAG_HURT;
    }
}