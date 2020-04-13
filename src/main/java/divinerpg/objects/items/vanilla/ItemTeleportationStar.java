package divinerpg.objects.items.vanilla;

import divinerpg.utils.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemTeleportationStar extends ItemTeleportationCrystal {
    private final static String posKey = "BlockPos";
    private final static String dimKey = "Dim";

    public ItemTeleportationStar(String name) {
        super(name);
        setMaxDamage(64);
    }

    private NBTTagCompound getFromStack(ItemStack stack) {
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }

        return stack.getTagCompound();
    }

    @Nullable
    @Override
    protected BlockPos getSavedPos(EntityPlayer player, ItemStack stack) {
        NBTTagCompound tag = getFromStack(stack);
        if (!tag.hasKey(posKey))
            return null;

        return BlockPos.fromLong(tag.getLong(posKey));
    }

    @Override
    protected DimensionType getSavedDimType(EntityPlayer player, ItemStack stack) {
        NBTTagCompound tag = getFromStack(stack);
        if (!tag.hasKey(dimKey))
            return null;

        String dimName = tag.getString(dimKey);

        try {
            return DimensionType.byName(dimName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Tries to set current position
     *
     * @param compound - stack compund
     * @param player   - current player
     * @param hasInfo  - is value already set
     * @return
     */
    protected boolean trySetCords(NBTTagCompound compound, EntityPlayer player, boolean hasInfo) {
        if (hasInfo)
            return false;

        compound.setString(dimKey, player.world.provider.getDimensionType().getName());
        compound.setLong(posKey, player.getPosition().toLong());

        return true;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        NBTTagCompound compound = getFromStack(stack);

        boolean hasInfo = compound.hasKey(dimKey) && compound.hasKey(posKey);


        if (player.isSneaking()) {
            if (trySetCords(compound, player, hasInfo)) {
                return new ActionResult<>(EnumActionResult.SUCCESS, stack);
            }

            // only on client side
            if (player.world.isRemote) {
                ITextComponent message = new TextComponentTranslation("messaage.teleportation_star");
                message.getStyle().setColor(TextFormatting.RED);
                player.sendMessage(message);
            }

        }

        return hasInfo
                ? super.onItemRightClick(worldIn, player, hand)
                : ActionResult.newResult(EnumActionResult.FAIL, stack);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        NBTTagCompound compound = getFromStack(stack);

        if (compound.hasKey(dimKey)) {
            list.add(compound.getString(dimKey));
        }

        if (compound.hasKey(posKey)) {
            BlockPos pos = BlockPos.fromLong(compound.getLong(posKey));
            list.add(pos.toString());
        }

        list.add("");
        list.add(LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getMetadata()));
    }
}
