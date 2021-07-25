package divinerpg.items.base;

import divinerpg.blocks.iceika.*;
import net.minecraft.block.*;
import net.minecraft.client.util.*;
import net.minecraft.item.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
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
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        //info - all tooltips for blocks must go here
        if (block instanceof BlockFrostedAllure) {
            tooltip.add(new TranslationTextComponent("tooltip.frosted_allure"));
        }

    }
}
