package naturix.divinerpg.objects.items.vanilla;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.utils.SecondaryTeleporter;
import naturix.divinerpg.utils.TooltipLocalizer;
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

public class ItemTeleportationCrystal extends ItemMod {

    WorldServer worldserver;

    public ItemTeleportationCrystal(String name) {
        super(name);
        setCreativeTab(DRPGCreativeTabs.utility);
        setMaxDamage(10);
        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add("Teleport to spawn point");
        list.add(TooltipLocalizer.usesRemaining(stack.getMaxDamage() - stack.getMetadata()));
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
                teleportPos = worldIn.getTopSolidOrLiquidBlock(teleportPos);
                player.setPositionAndUpdate(teleportPos.getX(), teleportPos.getY(), teleportPos.getZ());
            }
        }
        if (!player.isCreative()) {
            stack.damageItem(1, player);
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }

    public static void teleportToDimension(EntityPlayer player, int dimension, BlockPos pos) {
        int oldDimension = player.getEntityWorld().provider.getDimension();
        EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
        MinecraftServer server = player.getEntityWorld().getMinecraftServer();
        WorldServer worldServer = server.getWorld(dimension);
        player.addExperienceLevel(0);

        BlockPos teleportPos = worldServer.getTopSolidOrLiquidBlock(pos);
        double x = teleportPos.getX();
        double y = teleportPos.getY();
        double z = teleportPos.getZ();
        worldServer.getMinecraftServer().getPlayerList().transferPlayerToDimension(entityPlayerMP, dimension,
                new SecondaryTeleporter(worldServer, x, y, z));
        player.setPositionAndUpdate(x, y, z);
    }
}