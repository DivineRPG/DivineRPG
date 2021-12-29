package divinerpg.items.twilight;

import divinerpg.DivineRPG;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.BlockRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ItemTwilightClock extends ItemMod {
    private final Set<Block> possibleBlocks = new HashSet<Block>() {{
        add(BlockRegistry.divineRock);
        add(BlockRegistry.edenBlock);
        add(BlockRegistry.wildwoodBlock);
        add(BlockRegistry.apalachiaBlock);
        add(BlockRegistry.skythernBlock);
    }};

    public ItemTwilightClock(String name) {
        super(name, new Item.Properties().tab(DivineRPG.tabs.utilities).stacksTo(1));
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        PlayerEntity player = context.getPlayer();
        Hand hand = context.getHand();
        BlockPos pos = context.getClickedPos();
        Direction facing = context.getClickedFace();
        ItemStack itemstack = player.getItemInHand(hand);
        World worldIn = context.getLevel();
        Random random = context.getLevel().random;

        if (!player.mayUseItemAt(pos, facing, itemstack)) {
            return ActionResultType.FAIL;
        }

        if(facing != Direction.UP) {
            return ActionResultType.FAIL;
        }

        if (!worldIn.isClientSide) {
            worldIn.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F,
                    random.nextFloat() * 0.4F + 0.8F);

            if(possibleBlocks.contains(worldIn.getBlockState(context.getClickedPos()).getBlock())){
                worldIn.setBlock(context.getClickedPos().above(), BlockRegistry.blueFire.defaultBlockState(), 0);
            }
        }
        return ActionResultType.FAIL;
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
            tooltip.add(LocalizeUtils.i18n(DivineRPG.MODID + ".twilight_clock"));
    }
}
