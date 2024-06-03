package divinerpg.blocks.iceika;

import divinerpg.registries.BlockEntityRegistry;
import divinerpg.block_entities.block.FrostedAllureBlockEntity;
import divinerpg.registries.ItemRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.*;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class BlockFrostedAllure extends BaseEntityBlock {
    public static final IntegerProperty CATEGORY = IntegerProperty.create("category", 0, 5);
    public BlockFrostedAllure() {
        super(Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).strength(.8F).sound(SoundType.CALCITE).instrument(NoteBlockInstrument.CHIME).randomTicks());
        registerDefaultState(stateDefinition.any().setValue(CATEGORY, 0));
    }
    @Nullable
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {return new FrostedAllureBlockEntity(pos, state);}
    @Override public RenderShape getRenderShape(BlockState state) {return RenderShape.MODEL;}
    @Override public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? null : createTickerHelper(type, BlockEntityRegistry.FROSTED_ALLURE.get(), FrostedAllureBlockEntity::serverTick);
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(CATEGORY);}
    @Override public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(hand == InteractionHand.MAIN_HAND && player.getItemInHand(hand).getItem() == ItemRegistry.ice_stone.get()){
            if(state.getValue(CATEGORY) == 0) {
                level.setBlock(pos, state.setValue(CATEGORY, 1), 0);
                player.displayClientMessage(LocalizeUtils.clientMessage("frosted_allure.monster"), true);
                if(!player.isCreative()) player.getItemInHand(hand).shrink(1);
                return InteractionResult.SUCCESS;
            } if(state.getValue(CATEGORY) == 1) {
                level.setBlock(pos, state.setValue(CATEGORY, 2), 0);
                player.displayClientMessage(LocalizeUtils.clientMessage("frosted_allure.creature"), true);
                if(!player.isCreative()) player.getItemInHand(hand).shrink(1);
                return InteractionResult.SUCCESS;
            } if(state.getValue(CATEGORY) == 2) {
                level.setBlock(pos, state.setValue(CATEGORY, 3), 0);
                player.displayClientMessage(LocalizeUtils.clientMessage("frosted_allure.ambient"), true);
                if(!player.isCreative()) player.getItemInHand(hand).shrink(1);
                return InteractionResult.SUCCESS;
            } if(state.getValue(CATEGORY) == 3) {
                level.setBlock(pos, state.setValue(CATEGORY, 4), 0);
                player.displayClientMessage(LocalizeUtils.clientMessage("frosted_allure.water"), true);
                if(!player.isCreative()) player.getItemInHand(hand).shrink(1);
                return InteractionResult.SUCCESS;
            } if(state.getValue(CATEGORY) == 4) {
                level.setBlock(pos, state.setValue(CATEGORY, 5), 0);
                player.displayClientMessage(LocalizeUtils.clientMessage("frosted_allure.misc"), true);
                if(!player.isCreative()) player.getItemInHand(hand).shrink(1);
                return InteractionResult.SUCCESS;
            } if(state.getValue(CATEGORY) == 5) {
                level.setBlock(pos, state.setValue(CATEGORY, 0), 0);
                player.displayClientMessage(LocalizeUtils.clientMessage("frosted_allure.all"), true);
                if(!player.isCreative()) player.getItemInHand(hand).shrink(1);
                return InteractionResult.SUCCESS;
            }
        } return InteractionResult.FAIL;
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, BlockGetter worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("frosted_allure"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}