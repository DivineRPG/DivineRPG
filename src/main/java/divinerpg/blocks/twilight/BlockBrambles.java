package divinerpg.blocks.twilight;

import divinerpg.blocks.base.*;
import net.minecraft.core.*;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;

import javax.annotation.*;
import java.util.function.*;

public class BlockBrambles extends BlockModDoublePlant {

    public BlockBrambles(Supplier<Block> grassSupplier, MaterialColor mapColorIn) {
        super(grassSupplier, mapColorIn);
    }

    @Override
    public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        if(entity instanceof Player){
            entity.hurt(DamageSource.CACTUS, 6);
        }
    }

    @Override
    public void playerDestroy(Level worldIn, Player player, BlockPos pos, BlockState state,
                             @Nullable BlockEntity te, ItemStack stack) {
        super.playerDestroy(worldIn, player, pos, state, te, stack);
        player.hurt(DamageSource.CACTUS, 1);
    }
}