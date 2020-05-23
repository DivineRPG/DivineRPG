package divinerpg.objects.items.base;

import divinerpg.DivineRPG;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemModSword extends ItemSword {

    private ToolMaterial material;

    public ItemModSword(ToolMaterial material, String name) {
        super(material);
        this.material = material;
        setRegistryName(DivineRPG.MODID, name);
        setUnlocalizedName(name);
        setCreativeTab(DivineRPGTabs.swords);


    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
        if (canUseSpecialEffect(player))
            this.useSpecialEffect(world, player);
        return super.onItemRightClick(world, player, handIn);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (canUseSpecialEffect(player))
            this.useSpecialEffect(player.world, player);
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(LocalizeUtils.meleeDam(material.getAttackDamage() + 4));
        addAdditionalInformation(list);
        if (item.getMaxDamage() > 0) {
            list.add(LocalizeUtils.usesRemaining(item.getMaxDamage() - item.getItemDamage()));
        } else {
            list.add(LocalizeUtils.infiniteUses());
        }
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return this.getItemStackLimit(stack) == 1
                && (stack.getMaxDamage() < 0 || this.getItemStackLimit(stack) == 1);
    }

    protected boolean canUseSpecialEffect(EntityPlayer player) {
        return false;
    }

    protected void useSpecialEffect(World world, EntityPlayer player) {
    }

    protected void addAdditionalInformation(List<String> list) {
    }
}