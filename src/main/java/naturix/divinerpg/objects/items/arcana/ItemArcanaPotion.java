package naturix.divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.client.ArcanaHelper;
import naturix.divinerpg.client.ArcanaRenderer;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemArcanaPotion extends ItemMod {

    protected int amountToAdd;

    public ItemArcanaPotion(String name, int amountToAdd) {
        super(name, DRPGCreativeTabs.utility);
        this.amountToAdd = amountToAdd;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn)
    {    list.add(TooltipLocalizer.arcanaRegen(amountToAdd));
    }
    EntityPlayer player;
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        if (!player.capabilities.isCreativeMode) stack.shrink(1);
        //FIXME - Suppopsed to be done via capabilities now
//        ArcanaHelper.getProperties(player).forceRegen(amountToAdd);
//        player.triggerAchievement(DivineRPGAchievements.yuk);
        return stack;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.DRINK;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 10;
    }

//    @Override
//    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
//        if (ArcanaHelper.getProperties(player).getBarValue() != 200 || ArcanaRenderer.value != 200) player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
//        return stack;
//    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}