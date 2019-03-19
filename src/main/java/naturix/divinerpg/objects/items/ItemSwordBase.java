package naturix.divinerpg.objects.items;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSwordBase extends ItemSword implements IHasModel {

    private String name;
    private ToolMaterial material;

    public ItemSwordBase(ToolMaterial material, String name) {
        super(material);
        this.name = name;
        this.material = material;
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(DivineRPG.CombatTab);

        ModItems.ITEMS.add(this);
    }

    //@Override
    //public boolean isItemTool(ItemStack par1ItemStack) {
    //    return true;
    //}

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
        //if(stack.getItem() == ModItems.divineSword) player.triggerAchievement(DivineRPGAchievements.divinePlan);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(TooltipLocalizer.meleeDam(material.getAttackDamage() + 5));
        addAdditionalInformation(list);
        if (item.getMaxDamage() > 0) {
            list.add(TooltipLocalizer.usesRemaining(item.getMaxDamage() - item.getItemDamage()));
        } else {
            list.add(TooltipLocalizer.infiniteUses());
        }
    }

    protected void addAdditionalInformation(List list) {
    }

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(this, 0, name);
    }
}