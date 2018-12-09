package naturix.divinerpg.bases.items;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.entities.entity.EntityEMP;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class CannonBase extends Item
{
	public String name;
    public CannonBase(String name)
    {
        setCreativeTab(DivineRPG.CombatTab);
        setMaxStackSize(1);
        setMaxDamage(0);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.name=name;
    }
    ItemStack stack= new ItemStack(ModItems.acid);
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn)
    {
            player.swingArm(handIn);
            if (!world.isRemote)
            {
                if(player.inventory.hasItemStack(stack)) {
                    world.spawnEntity(new EntityEMP(world, player));
                	stack.shrink(1);
                }
            }

        	DivineRPG.logger.info(stack.getDisplayName()); 
     
        return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(handIn));
    }


    public void registerItemModel() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}
}