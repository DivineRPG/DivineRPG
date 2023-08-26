package divinerpg.blocks.iceika;

import divinerpg.DivineRPG;
import divinerpg.registries.BlockEntityRegistry;
import divinerpg.block_entities.block.FrostedAllureBlockEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlockFrostedAllure extends BaseEntityBlock {
    public static final IntegerProperty CATEGORY = IntegerProperty.create("category", 0, 5);

    public BlockFrostedAllure() {
        super(Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).strength(0.8F).sound(SoundType.CALCITE).instrument(NoteBlockInstrument.CHIME).randomTicks());
        registerDefaultState(this.stateDefinition.any().setValue(CATEGORY, 0));
    }

    @Override
    public void appendHoverText(ItemStack stack, BlockGetter worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(Component.translatable("tooltip.frosted_allure").withStyle(ChatFormatting.GRAY));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FrostedAllureBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? null : createTickerHelper(type, BlockEntityRegistry.FROSTED_ALLURE.get(), FrostedAllureBlockEntity::serverTick);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CATEGORY);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(hand == InteractionHand.MAIN_HAND && player.getItemInHand(hand).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "corrupted_stone"))){
            if(state.getValue(CATEGORY) == 0){
                level.setBlock(pos, state.setValue(CATEGORY, 1), 0);
                player.displayClientMessage(Component.translatable("tooltip.divinerpg.monster"), true);
                if(!player.isCreative()) {
                    player.getItemInHand(hand).shrink(1);
                }
                return InteractionResult.SUCCESS;
            }
            if(state.getValue(CATEGORY) == 1){
                level.setBlock(pos, state.setValue(CATEGORY, 2), 0);
                player.displayClientMessage(Component.translatable("tooltip.divinerpg.creature"), true);
                if(!player.isCreative()) {
                    player.getItemInHand(hand).shrink(1);
                }
                return InteractionResult.SUCCESS;
            }
            if(state.getValue(CATEGORY) == 2){
                level.setBlock(pos, state.setValue(CATEGORY, 3), 0);
                player.displayClientMessage(Component.translatable("tooltip.divinerpg.ambient"), true);
                if(!player.isCreative()) {
                    player.getItemInHand(hand).shrink(1);
                }
                return InteractionResult.SUCCESS;
            }
            if(state.getValue(CATEGORY) == 3){
                level.setBlock(pos, state.setValue(CATEGORY, 4), 0);
                player.displayClientMessage(Component.translatable("tooltip.divinerpg.water"), true);
                if(!player.isCreative()) {
                    player.getItemInHand(hand).shrink(1);
                }
                return InteractionResult.SUCCESS;
            }
            if(state.getValue(CATEGORY) == 4){
                level.setBlock(pos, state.setValue(CATEGORY, 5), 0);
                player.displayClientMessage(Component.translatable("tooltip.divinerpg.misc"), true);
                if(!player.isCreative()) {
                    player.getItemInHand(hand).shrink(1);
                }
                return InteractionResult.SUCCESS;
            }
            if(state.getValue(CATEGORY) == 5){
                level.setBlock(pos, state.setValue(CATEGORY, 0), 0);
                player.displayClientMessage(Component.translatable("tooltip.divinerpg.all"), true);
                if(!player.isCreative()) {
                    player.getItemInHand(hand).shrink(1);
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }
}
