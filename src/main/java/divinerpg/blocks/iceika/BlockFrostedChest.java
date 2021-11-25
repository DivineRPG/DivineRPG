package divinerpg.blocks.iceika;

import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import divinerpg.tiles.chests.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.*;
import java.util.*;

public class BlockFrostedChest extends BlockModChest {

    public BlockFrostedChest(String name) {
        super(name, Properties.of(Material.GLASS).strength(2.5F).sound(SoundType.GLASS), () -> TileRegistry.FROSTED_CHEST);
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
        return new TileEntityFrostedChest();
    }

    @Override
    public void playerDestroy(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
        super.playerDestroy(world, player, pos, state, te, stack);
        if (player instanceof ServerPlayerEntity) {
            TriggerRegistry.DIVINERPG_BLOCK.trigger((ServerPlayerEntity) player, this);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        Random random = rand;
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