package divinerpg.items.vethea;

import divinerpg.DivineRPG;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class ItemNightmareBed extends BlockItem {
    public ItemNightmareBed() {
        super(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "nightmare_bed")), new Item.Properties().stacksTo(1)
        );
    }

    protected boolean placeBlock(BlockPlaceContext context, BlockState state) {
        return context.getLevel().setBlock(context.getClickedPos(), state, 26);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.divinerpg.nightmare_bed"));
    }
}
