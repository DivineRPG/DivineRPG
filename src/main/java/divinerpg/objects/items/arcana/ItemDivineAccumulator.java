package divinerpg.objects.items.arcana;

import divinerpg.DivineRPG;
import divinerpg.api.DivineAPI;
import divinerpg.api.arcana.IArcana;
import divinerpg.networking.message.MessageDivineAccumulator;
import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.SoundRegistry;
import divinerpg.utils.LocalizeUtils;
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

import javax.annotation.Nullable;
import java.util.List;

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
        IArcana arcana = DivineAPI.getArcana(player);
        if (arcana.getArcana() >= 80) {
            if (!world.isRemote) {
                DivineRPG.network.sendToDimension(new MessageDivineAccumulator(x, y, z), player.dimension);
                world.playSound(player, player.getPosition(), SoundRegistry.DIVINE_ACCUMULATOR, SoundCategory.PLAYERS, 1, 1);
                arcana.consume(player, 80);
            }
            player.motionY = 2;
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(LocalizeUtils.i18n("tooltip.divine_accumulator.launch"));
        list.add(LocalizeUtils.i18n("tooltip.divine_accumulator.fall"));
        list.add(LocalizeUtils.arcanaConsumed(80));
        list.add(LocalizeUtils.infiniteUses());
    }
}