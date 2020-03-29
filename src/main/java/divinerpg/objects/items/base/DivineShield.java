package divinerpg.objects.items.base;

import divinerpg.api.Reference;
import divinerpg.registry.ModItems;
import divinerpg.utils.Lazy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.*;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class DivineShield extends ItemShield {
    private Lazy<Item> repair;
    public DivineShield(String name, CreativeTabs tab, Supplier<Item> repairMaterial, int damage) {
        repair = new Lazy<>(repairMaterial);
        setCreativeTab(tab);
        setMaxDamage(damage);
        setUnlocalizedName(name);
        setRegistryName(Reference.MODID, name);
    }

    @Override
    public boolean isShield(ItemStack stack, @Nullable EntityLivingBase entity) {
        return true;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == this.repair.getValue();
    }
    
    @Override
    public String getItemStackDisplayName(ItemStack stack)
    {
            return I18n.translateToLocal(this.getUnlocalizedName()+".name");
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        if(this == ModItems.realmite_shield) {
        	playerIn.fallDistance = 0;
        }
//      if(this == ModItems.arlemite_shield) {
//    	Ranged damage protection boost
//      }
//      if(this == ModItems.rupee_shield) {
//    	melee damage protection boost
//      }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}
