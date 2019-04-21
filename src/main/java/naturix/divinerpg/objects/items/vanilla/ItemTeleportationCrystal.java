package naturix.divinerpg.objects.items.vanilla;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.utils.SecondaryTeleporter;
import naturix.divinerpg.utils.TeleportationHandler;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumFacing;
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
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer entityIn, EnumHand hand) {
        ItemStack stack = new ItemStack(this);
        if (worldIn.provider.getDimension() != 0) {
            if (!worldIn.isRemote) {
//                teleportPlayer(worldIn, entityIn);
            	teleportToDimension(entityIn, 0, worldIn.getSpawnPoint().getX(), getGroundPos(worldIn, worldIn.getSpawnPoint().getX(), worldIn.getSpawnPoint().getZ()).getY(), worldIn.getSpawnPoint().getZ());
            }
        } else {
            entityIn.setPosition(entityIn.getBedLocation().getX(), entityIn.getBedLocation().getY(),
                    entityIn.getBedLocation().getZ());
        }
        if (!entityIn.isCreative()) {
            stack.damageItem(1, entityIn);
        }
        return super.onItemRightClick(worldIn, entityIn, hand);
    }
    @Nullable
	public static BlockPos getGroundPos(World world, int x, int z) {
		final BlockPos topPos = world.getHeight(new BlockPos(x, 0, z));
		
		return world.getTopSolidOrLiquidBlock(topPos);

	}
    private void teleportPlayer(World world, EntityPlayer player) {
        EntityPlayerMP playerMP = (EntityPlayerMP) player;
        BlockPos coords;

        coords = TeleportationHandler.getDimPos(playerMP, 0, world.getSpawnPoint());
        TeleportationHandler.updateDimPos(playerMP, world.provider.getDimension(), player.getPosition());
        TeleportationHandler.teleport(playerMP, 0, coords.getX(), coords.getY(), coords.getZ(),
                playerMP.mcServer.getPlayerList());
    }
    public static void teleportToDimension(EntityPlayer player, int dimension, double x, double y, double z) {
		int oldDimension = player.getEntityWorld().provider.getDimension();
		EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
		MinecraftServer server = player.getEntityWorld().getMinecraftServer();
		WorldServer worldServer = server.getWorld(dimension);
		player.addExperienceLevel(0);

		worldServer.getMinecraftServer().getPlayerList().transferPlayerToDimension(entityPlayerMP, dimension,
				new SecondaryTeleporter(worldServer, x, y, z));
		player.setPositionAndUpdate(x, y, z);
		if (oldDimension == 1) {
			player.setPositionAndUpdate(x, y, z);
			worldServer.spawnEntity(player);
			worldServer.updateEntityWithOptionalForce(player, false);
		}
	}

}