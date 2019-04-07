package naturix.divinerpg.objects.items.base;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemHealingSword extends ItemModSword {

    private float healAmount;

    public ItemHealingSword(String name, ToolMaterial material, float healAmount) {
        super(material, name);
        this.healAmount = healAmount;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        float current = player.getHealth();
        if ((current >= 0.0F) && (current < 20.0F)) {
            ItemStack stack = new ItemStack(this.getContainerItem());
            if (!player.capabilities.isCreativeMode) {
                stack.shrink(1);
            }
            player.playSound(ModSounds.HEAL, 1, 1);
        }
        return super.onItemRightClick(world, player, hand);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add("Heals " + this.healAmount / 2 + " hearts on use");
        list.add(TooltipLocalizer.usesRemaining(item.getMaxDamage() - item.getItemDamage()));
    }
}
