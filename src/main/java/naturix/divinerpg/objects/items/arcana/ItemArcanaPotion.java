package naturix.divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.capabilities.ArcanaProvider;
import naturix.divinerpg.capabilities.IArcana;
import naturix.divinerpg.client.ArcanaRenderer;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemArcanaPotion extends ItemMod {

    protected int amountToAdd;

    public ItemArcanaPotion(String name, int amountToAdd) {
        super(name, DivineRPGTabs.utility);
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
        IArcana arcana = DivineRPG.proxy.getPlayer().getCapability(ArcanaProvider.ARCANA_CAP, null);
        arcana.fill(player, arcana.getArcana() + amountToAdd);
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

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
    	IArcana arcana = DivineRPG.proxy.getPlayer().getCapability(ArcanaProvider.ARCANA_CAP, null);
    	ItemStack stack = player.getHeldItem(hand);
    	if (arcana.getArcana() != 200 || ArcanaRenderer.value != 200);
        
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}