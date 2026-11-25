package divinerpg.blocks.iceika;

import divinerpg.blocks.arcana.ArcaniteVinesHead;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jspecify.annotations.Nullable;

import static divinerpg.registries.ItemRegistry.winterberry;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.BLOOM;

public class WinterberryVinesHead extends ArcaniteVinesHead {
    public static final BooleanProperty RIPE = BLOOM;
    public WinterberryVinesHead(Properties properties) {super(properties);}
    @Override
    public void playerDestroy(ServerLevel level, ServerPlayer player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack destroyedWith) {
        BlockState aboveState = level.getBlockState(pos.above());
        if(aboveState.getBlock() == BlockRegistry.winterberryVines.body().get() && aboveState.getValue(RIPE))
            popResource(level, pos.above(), new ItemStack(winterberry.get(), 1));
        super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
    }
    @Override protected Block getBodyBlock() {return BlockRegistry.winterberryVines.body().get();}
}