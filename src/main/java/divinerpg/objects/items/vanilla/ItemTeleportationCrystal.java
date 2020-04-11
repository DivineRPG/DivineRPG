package divinerpg.objects.items.vanilla;

import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.LocalizeKeys;
import divinerpg.utils.SecondaryTeleporter;
import divinerpg.utils.TooltipHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import javax.annotation.Nullable;
import java.util.List;

public class ItemTeleportationCrystal extends ItemMod {

    WorldServer worldserver;

    public ItemTeleportationCrystal(String name) {
        super(name);
        setCreativeTab(DivineRPGTabs.utility);
        setMaxDamage(10);
        setMaxStackSize(1);
    }

    public static void teleportToDimension(EntityPlayer player, int dimension, BlockPos pos) {
        int oldDimension = player.getEntityWorld().provider.getDimension();
        EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
        MinecraftServer server = player.getEntityWorld().getMinecraftServer();
        WorldServer worldServer = server.getWorld(dimension);
        player.addExperienceLevel(0);

        if (EntityPlayer.getBedSpawnLocation(worldServer, pos, true) == null) {
            pos = worldServer.getTopSolidOrLiquidBlock(pos);
        }
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        worldServer.getMinecraftServer().getPlayerList().transferPlayerToDimension(entityPlayerMP, dimension,
                new SecondaryTeleporter(worldServer, x, y, z));
        player.setPositionAndUpdate(x, y, z);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(TooltipHelper.getInfoText("tooltip.teleport_bed_spawn"));
        list.add(LocalizeKeys.usesRemaining(stack.getMaxDamage() - stack.getMetadata()));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if (!worldIn.isRemote) {
            BlockPos teleportPos = player.getBedLocation(0);
            if (teleportPos == null) {
                teleportPos = player.getEntityWorld().getMinecraftServer().getWorld(0).getSpawnPoint();
            }
            if (worldIn.provider.getDimension() != 0) {
                teleportToDimension(player, 0, teleportPos);
            } else {
                if (EntityPlayer.getBedSpawnLocation(worldIn, teleportPos, true) == null) {
                    teleportPos = worldIn.getTopSolidOrLiquidBlock(teleportPos);
                }
                player.setPositionAndUpdate(teleportPos.getX(), teleportPos.getY(), teleportPos.getZ());
            }
        }
        if (!player.isCreative()) {
            stack.damageItem(1, player);
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }
}