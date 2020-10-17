package divinerpg.items.base;

import divinerpg.DivineRPG;
import divinerpg.blocks.BlockModNotReady;
import divinerpg.blocks.arcana.BlockHeatTrap;
import divinerpg.blocks.base.BlockModSapling;
import divinerpg.blocks.iceika.BlockFrostedAllure;
import divinerpg.blocks.vanilla.BlockSpike;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.*;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.Nullable;
import java.util.List;

public class ItemModItemBlock extends BlockItem {
    Block block;

    public ItemModItemBlock(Block blockIn, Properties builder) {
        super(blockIn, builder);
        this.block = blockIn;
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
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
