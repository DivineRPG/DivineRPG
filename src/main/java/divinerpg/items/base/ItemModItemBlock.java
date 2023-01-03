package divinerpg.items.base;

import divinerpg.blocks.iceika.*;
import net.minecraft.network.chat.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.*;
import java.util.*;

public class ItemModItemBlock extends BlockItem {
    Block block;

    public ItemModItemBlock(Block blockIn, Properties builder) {
        super(blockIn, builder);
        this.block = blockIn;
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        //info - all tooltips for blocks must go here
        if (block instanceof BlockFrostedAllure) {
            tooltip.add(Component.translatable("tooltip.frosted_allure"));
        }

    }
}
