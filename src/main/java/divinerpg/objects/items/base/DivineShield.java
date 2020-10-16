package divinerpg.objects.items.base;

import divinerpg.DivineRPG;
import divinerpg.registry.ItemRegistry;
import divinerpg.utils.Lazy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
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
        setRegistryName(DivineRPG.MODID, name);
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
    public String getItemStackDisplayName(ItemStack stack) {
        return I18n.translateToLocal(this.getUnlocalizedName() + ".name");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

        ActionResult<ItemStack> result = super.onItemRightClick(worldIn, playerIn, handIn);
        Item item = result.getResult().getItem();

        if (item == ItemRegistry.realmite_shield) {
            playerIn.fallDistance = 0;
        }

        return result;
    }
}
