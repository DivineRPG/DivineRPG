package divinerpg.objects.items.arcana;

import divinerpg.api.DivineAPI;
import divinerpg.api.arcana.IArcana;
import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.LocalizeUtils;
import divinerpg.utils.PositionHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class ItemEnderScepter extends ItemMod {

    public ItemEnderScepter(String name) {
        super(name, DivineRPGTabs.MELEE_WEAPONS);
        setMaxStackSize(1);
    }

    @Override
    public @Nonnull
    ActionResult<ItemStack> onItemRightClick(@Nonnull World world, @Nonnull EntityPlayer player,
            @Nonnull EnumHand hand) {
        IArcana arcana = DivineAPI.getArcana(player);
        if (!world.isRemote && arcana.getArcana() >= 75) {
            RayTraceResult pos = PositionHelper.rayTrace(player, 32, 1);
            int x = pos.getBlockPos().getX(), y = pos.getBlockPos().getY() + 1, z = pos.getBlockPos().getZ();
            player.dismountRidingEntity();
            player.setPosition(x, y, z);
            player.playSound(SoundEvents.BLOCK_PORTAL_TRAVEL, 1, 1);
            arcana.consume(player, 75);
            return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItemMainhand());
        }
        return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItemMainhand());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(LocalizeUtils.arcanaConsumed(75));
        list.add(LocalizeUtils.i18n("tooltip.ender_scepter"));
        list.add(LocalizeUtils.infiniteUses());
    }
}