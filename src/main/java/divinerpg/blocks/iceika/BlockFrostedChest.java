package divinerpg.blocks.iceika;

import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import divinerpg.block_entities.chests.*;
import net.minecraft.core.*;
import net.minecraft.server.level.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.*;

public class BlockFrostedChest extends BlockModChest {

    public BlockFrostedChest() {
        super(Properties.of(Material.GLASS).strength(2.5F).sound(SoundType.GLASS), () -> BlockEntityRegistry.FROSTED_CHEST.get());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new FrostedChestBlockEntity(p_153215_, p_153216_);
    }

    @Override
    public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity te, ItemStack stack) {
        super.playerDestroy(world, player, pos, state, te, stack);
        if (player instanceof ServerPlayer) {
            TriggerRegistry.DIVINERPG_BLOCK.trigger((ServerPlayer) player, this);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand) {
        RandomSource random = rand;
        for (int i = 0; i < 6; ++i) {
            double d1 = pos.getX() + random.nextFloat();
            double d2 = pos.getY() + random.nextFloat();
            double d3 = pos.getZ() + random.nextFloat();

            if (i == 0 && !worldIn.getBlockState(pos.above()).canOcclude()) {
                d2 = pos.getY() + 0.0625D + 1.0D;
            }

            if (i == 1 && !worldIn.getBlockState(pos.below()).canOcclude()) {
                d2 = pos.getY() - 0.0625D;
            }

            if (i == 2 && !worldIn.getBlockState(pos.south()).canOcclude()) {
                d3 = pos.getZ() + 0.0625D + 1.0D;
            }

            if (i == 3 && !worldIn.getBlockState(pos.north()).canOcclude()) {
                d3 = pos.getZ() - 0.0625D;
            }

            if (i == 4 && !worldIn.getBlockState(pos.east()).canOcclude()) {
                d1 = pos.getX() + 0.0625D + 1.0D;
            }

            if (i == 5 && !worldIn.getBlockState(pos.west()).canOcclude()) {
                d1 = pos.getX() - 0.0625D;
            }

            if (d1 < pos.getX() || d1 > pos.getX() + 1 || d2 < 0.0D || d2 > pos.getY() + 1 || d3 < pos.getZ()
                    || d3 > pos.getZ() + 1) {
                if (rand.nextInt(10) <= 5) {
                    worldIn.addParticle(ParticleRegistry.FROST.get(), d1, d2, d3, 0.0D, 0.5D, 0.0D);
                }
            }
        }
    }


}