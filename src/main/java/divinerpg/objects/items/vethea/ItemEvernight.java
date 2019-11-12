package divinerpg.objects.items.vethea;

import com.sun.istack.internal.Nullable;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModSounds;
import divinerpg.utils.TooltipHelper;
import divinerpg.utils.TooltipLocalizer;
import divinerpg.utils.Utils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemEvernight extends ItemStaff {
    public ItemEvernight(int dam, int arcana, String name) {
        super(dam, arcana, name);
    }

    @Override
    protected void doPreUsageEffects(World world, EntityPlayer player) {
        player.attackEntityFrom(Utils.arcanaSource, 20);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        super.addInformation(stack,worldIn,list,flagIn);
        list.add(TooltipHelper.getInfoText("tooltip.staff.evernight.damage"));
    }
}
