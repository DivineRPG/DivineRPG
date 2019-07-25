package naturix.divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.capabilities.ArcanaProvider;
import naturix.divinerpg.capabilities.IArcana;
import naturix.divinerpg.networking.message.MessageDivineAccumulator;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipHelper;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDivineAccumulator extends ItemMod {

    public ItemDivineAccumulator() {
        super("divine_accumulator", DivineRPGTabs.utility);
        setMaxStackSize(1);
        this.setFull3D();
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
            int x = (int) player.posX, y = (int) player.posY, z = (int) player.posZ;
    		IArcana arcana = player.getCapability(ArcanaProvider.ARCANA_CAP, null);
            if (!world.isRemote && arcana.getArcana()>=80) {
                DivineRPG.network.sendToDimension(new MessageDivineAccumulator(x, y, z), player.dimension);
                world.playSound(player, player.getPosition(), ModSounds.DIVINE_ACCUMULATOR, SoundCategory.PLAYERS, 1, 1);
                arcana.consume(80);
            }
            player.motionY = 2;
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(TooltipHelper.getInfoText("tooltip.divine_accumulator.launch"));
        list.add(TooltipHelper.getInfoText("tooltip.divine_accumulator.fall"));
        list.add(TooltipLocalizer.arcanaConsumed(80));
        list.add(TooltipLocalizer.infiniteUses());
    }

}