package divinerpg.objects.items.vanilla;

import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.LocalizeUtils;
import divinerpg.utils.SecondaryTeleporter;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nullable;
import java.util.List;

public class ItemTeleportationCrystal extends ItemMod {

    public ItemTeleportationCrystal(String name) {
        super(name);
        setCreativeTab(DivineRPGTabs.UTILITY);
        setMaxDamage(10);
        setMaxStackSize(1);
    }

    /**
     * Teleports player to current pos on current dimension
     *
     * @param player    - player
     * @param dimension - dimension to travel
     * @param pos       - pos to travel
     */
    public static void teleportToDimension(Entity player, DimensionType dimension, BlockPos pos) {
        if (player == null || dimension == null || pos == null)
            return;

        MinecraftServer server = player.getServer();
        if (server == null)
            return;


        if (player.world.provider.getDimensionType() != dimension) {
            ITeleporter teleporter = new SecondaryTeleporter(server.getWorld(dimension.getId()), pos.getX(), pos.getY(), pos.getZ());

            player.changeDimension(dimension.getId(), teleporter);
        }

        player.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(LocalizeUtils.i18n("tooltip.teleport_bed_spawn"));
        list.add(LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getMetadata()));
    }

    /**
     * Returns teleporting block position
     *
     * @param player - current player
     * @param stack  - curret item stack
     * @return
     */
    @Nullable
    protected BlockPos getSavedPos(EntityPlayer player, ItemStack stack) {
        BlockPos bedLocation = player.getBedLocation(getSavedDimType(player, stack).getId());

        if (bedLocation != null) {
            if (EntityPlayer.getBedSpawnLocation(player.world, bedLocation, true) == null) {
                bedLocation = player.world.getTopSolidOrLiquidBlock(bedLocation);
            }
        } else {

            if (player.getServer() != null)
                bedLocation = player.getServer().getWorld(getSavedDimType(player, stack).getId()).getSpawnPoint();
        }


        return bedLocation;
    }

    /**
     * Returns saved dimenstion to travel
     *
     * @param player - current player
     * @param stack  - current stack
     * @return
     */
    protected DimensionType getSavedDimType(EntityPlayer player, ItemStack stack) {
        return DimensionType.OVERWORLD;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand) {

        ItemStack stack = player.getHeldItem(hand);

        if (!player.world.isRemote) {
            BlockPos pos = getSavedPos(player, stack);
            DimensionType dimType = getSavedDimType(player, stack);

            teleportToDimension(player, dimType, pos);

            if (!player.isCreative()) {
                stack.damageItem(1, player);
            }
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }
}