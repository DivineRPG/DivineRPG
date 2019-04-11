package naturix.divinerpg.objects.items.vanilla;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.utils.TeleportationHandler;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
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
                teleportPlayer(worldIn, entityIn);
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

    private void teleportPlayer(World world, EntityPlayer player) {
        EntityPlayerMP playerMP = (EntityPlayerMP) player;
        BlockPos coords;

        coords = TeleportationHandler.getDimPos(playerMP, 0, player.getBedLocation());
        TeleportationHandler.updateDimPos(playerMP, world.provider.getDimension(), player.getPosition());
        TeleportationHandler.teleport(playerMP, 0, coords.getX(), coords.getY(), coords.getZ(),
                playerMP.mcServer.getPlayerList());
    }
}