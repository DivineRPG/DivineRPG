package divinerpg.objects.items.vanilla;

import com.google.common.collect.Sets;
import divinerpg.DivineRPG;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemShickaxe extends ItemTool {

    protected String name;

    public ItemShickaxe(ToolMaterial toolMaterial, String name) {
        super(1.0F, -2.8F, toolMaterial, Sets.newHashSet());
        this.name = name;
        setCreativeTab(DivineRPGTabs.tools);
        setUnlocalizedName(name);
        setRegistryName(DivineRPG.MODID, name);

        this.setHarvestLevel("pickaxe", toolMaterial.getHarvestLevel());
        this.setHarvestLevel("shovel", toolMaterial.getHarvestLevel());
        this.setHarvestLevel("axe", toolMaterial.getHarvestLevel());

        this.setMaxDamage(toolMaterial.getMaxUses());
    }

    public boolean canHarvestBlock(IBlockState blockIn) {
        return blockIn.getBlock().getHarvestLevel(blockIn) <= toolMaterial.getHarvestLevel();
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
                                      EnumFacing facing, float hitX, float hitY, float hitZ) {
        return Items.DIAMOND_HOE.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> infoList, ITooltipFlag flagIn) {
        infoList.add(LocalizeUtils.efficiency(toolMaterial.getEfficiency()));
        infoList.add(LocalizeUtils.harvestLevel(toolMaterial.getHarvestLevel()));
        if (stack.getMaxDamage() > 0) {
            infoList.add(LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getItemDamage()));
        } else {
            infoList.add(LocalizeUtils.infiniteUses());
        }
    }

    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        if (state.getBlock().getHarvestLevel(state) <= toolMaterial.getHarvestLevel()) {
            return this.efficiency;
        }

        return super.getDestroySpeed(stack, state);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        return true;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return this.getItemStackLimit(stack) == 1
                && (stack.getMaxDamage() < 0 || this.getItemStackLimit(stack) == 1);
    }
}