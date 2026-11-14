package divinerpg.blocks.iceika;

import divinerpg.block_entities.block.FrostedAllureBlockEntity;
import divinerpg.registries.BlockEntityRegistry;
import divinerpg.registries.TagRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

import static net.minecraft.stats.Stats.ITEM_USED;

public class FrostedAllure extends BaseEntityBlock {
    public static final IntegerProperty CATEGORY = IntegerProperty.create("category", 0, 5);
    public FrostedAllure(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(CATEGORY, 0));
    }
    @Nullable
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {return new FrostedAllureBlockEntity(pos, state);}
    @Override public RenderShape getRenderShape(BlockState state) {return RenderShape.MODEL;}
    @Override public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide() ? null : createTickerHelper(type, BlockEntityRegistry.FROSTED_ALLURE.get(), FrostedAllureBlockEntity::serverTick);
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(CATEGORY);}
    @Override public InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(stack.is(TagRegistry.AMMO_APALACHIA_BLITZ)){
            int currentCategory = state.getValue(CATEGORY);
            String[] messages = {
                    "frosted_allure.all",
                    "frosted_allure.monster",
                    "frosted_allure.creature",
                    "frosted_allure.ambient",
                    "frosted_allure.water",
                    "frosted_allure.misc"
            };
            int newCategory = (currentCategory + 1) % messages.length;
            level.setBlock(pos, state.setValue(CATEGORY, newCategory), 0);
            player.sendOverlayMessage(LocalizeUtils.clientMessage(messages[newCategory]));
            stack.consume(1, player);
            player.awardStat(ITEM_USED.get(stack.getItem()));
            return InteractionResult.SUCCESS;
        } return InteractionResult.FAIL;
    }
    //TODO: appendHoverText
//    @OnlyIn(CLIENT)
//    @Override public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
//        tooltip.add(LocalizeUtils.i18n("frosted_allure"));
//        super.appendHoverText(stack, context, tooltip, flagIn);
//    }
}