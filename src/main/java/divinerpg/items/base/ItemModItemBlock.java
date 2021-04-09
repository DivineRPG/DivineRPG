package divinerpg.items.base;

import divinerpg.*;
import divinerpg.blocks.*;
import divinerpg.blocks.arcana.*;
import divinerpg.blocks.base.*;
import divinerpg.blocks.iceika.*;
import divinerpg.blocks.vanilla.*;
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
        //TODO - all tooltips for blocks must go here
        if (block instanceof BlockModNotReady) {
            tooltip.add(new TranslationTextComponent(DivineRPG.MODID + ".blockwip"));
        } else if (block instanceof BlockFrostedAllure) {
            tooltip.add(new TranslationTextComponent("tooltip.frosted_allure"));
        } else if (block instanceof BlockModSapling) {
            tooltip.add(new TranslationTextComponent(DivineRPG.MODID + ".sapling"));
        } else if (block instanceof BlockHeatTrap) {
            tooltip.add(new TranslationTextComponent(DivineRPG.MODID + ".collision"));
        } else if (block instanceof BlockSpike) {
            tooltip.add(new TranslationTextComponent(DivineRPG.MODID + ".collision"));
        }

    }
}
