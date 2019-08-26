package divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import divinerpg.DivineRPG;
import divinerpg.capabilities.ArcanaProvider;
import divinerpg.capabilities.IArcana;
import divinerpg.networking.message.MessageDivineAccumulator;
import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModSounds;
import divinerpg.utils.TooltipHelper;
import divinerpg.utils.TooltipLocalizer;
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
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        int x = (int) player.posX, y = (int) player.posY, z = (int) player.posZ;
        IArcana arcana = player.getCapability(ArcanaProvider.ARCANA_CAP, null);
        if (!world.isRemote && arcana.getArcana() >= 80) {
            DivineRPG.network.sendToDimension(new MessageDivineAccumulator(x, y, z), player.dimension);
            world.playSound(player, player.getPosition(), ModSounds.DIVINE_ACCUMULATOR, SoundCategory.PLAYERS, 1, 1);
            arcana.consume(player, 80);
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