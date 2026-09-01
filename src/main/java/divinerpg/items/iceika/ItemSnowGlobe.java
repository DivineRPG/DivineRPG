package divinerpg.items.iceika;

import divinerpg.items.base.ItemMod;
import divinerpg.registries.*;
import divinerpg.utils.Utils;
import net.minecraft.core.*;
import net.minecraft.core.Direction.Axis;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class ItemSnowGlobe extends ItemMod {
    public ItemSnowGlobe(Properties properties) {super(properties.stacksTo(1));}
    @Override public InteractionResult useOn(UseOnContext context) {
        Direction facing = context.getClickedFace();
        BlockPos pos = context.getClickedPos();
        Level worldIn = context.getLevel();
        Player player = context.getPlayer();
        if(!player.mayUseItemAt(pos, facing, player.getItemInHand(context.getHand()))) return InteractionResult.FAIL;
        BlockState block = worldIn.getBlockState(pos);
        if(!block.is(TagRegistry.BASE_ICY_FIRE)) return InteractionResult.FAIL;
        pos = pos.relative(facing);
        if(!worldIn.isClientSide()) {
            Axis axis = Utils.checkForFrame(worldIn, pos, new TagMatchTest(TagRegistry.BASE_ICY_FIRE));
            if(axis != null) {
                Utils.spreadBlock(worldIn, BlockRegistry.iceikaPortal.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_AXIS, axis), pos, Blocks.AIR, axis);
                worldIn.playSound(null, pos, SoundRegistry.ICEIKA_PORTAL_TRIGGER.get(), SoundSource.BLOCKS, 1, 1);
                return InteractionResult.SUCCESS;
            }
        } return InteractionResult.CONSUME;
    }
}