package divinerpg.objects.blocks;

import java.util.List;

import javax.annotation.Nullable;

import divinerpg.enums.EnumBlockType;
import divinerpg.enums.WoodType;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.TooltipHelper;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockNotReady extends BlockMod {

    public BlockNotReady(String name) {
        super(Material.ROCK, name);
        this.setCreativeTab(DivineRPGTabs.BlocksTab);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced)
    {
    	tooltip.add(TooltipHelper.getInfoText("tooltip.not_done"));
    }
}