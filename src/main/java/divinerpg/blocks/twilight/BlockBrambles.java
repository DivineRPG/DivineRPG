package divinerpg.blocks.twilight;

import divinerpg.blocks.base.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.function.*;

public class BlockBrambles extends BlockModDoublePlant {

    public BlockBrambles(String name, Supplier<Block> grassSupplier, MaterialColor mapColorIn) {
        super(name, grassSupplier, mapColorIn);
    }

    @Override
    public void entityInside(BlockState state, World world, BlockPos pos, Entity entity) {
        if(entity instanceof PlayerEntity){
            entity.hurt(DamageSource.CACTUS, 6);
        }
    }

    @Override
    public void playerDestroy(World worldIn, PlayerEntity player, BlockPos pos, BlockState state,
                             @Nullable TileEntity te, ItemStack stack) {
        super.playerDestroy(worldIn, player, pos, state, te, stack);
        player.hurt(DamageSource.CACTUS, 1);
    }
}