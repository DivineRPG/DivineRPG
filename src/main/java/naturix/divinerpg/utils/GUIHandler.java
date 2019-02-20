package naturix.divinerpg.utils;

import naturix.divinerpg.objects.blocks.tile.block.TileEntityCoalstoneFurnace;
import naturix.divinerpg.objects.blocks.tile.block.TileEntityIceikaChest;
import naturix.divinerpg.objects.blocks.tile.container.ContainerCoalstoneFurnace;
import naturix.divinerpg.objects.blocks.tile.container.ContainerIceikaChest;
import naturix.divinerpg.objects.blocks.tile.container.gui.CoalstoneFurnaceGUI;
import naturix.divinerpg.objects.blocks.tile.container.gui.IceikaChestGUI;
import naturix.divinerpg.objects.entities.container.ContainerWorkshopMerchant;
import naturix.divinerpg.objects.entities.container.gui.GuiWorkshopMerchant;
import naturix.divinerpg.objects.entities.entity.iceika.WorkshopMerchant;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

/**
 * Created by LiteWolf101 on Jan
 * /31/2019
 */
public class GUIHandler implements IGuiHandler {
    private WorkshopMerchant merchant;
    public static final int COALSTONE_FURNACE_GUI_ID = 0;
    public static final int ICEIKA_CHEST_GUI_ID = 1;
    public static final int WORKSHOP_MERCHANT = 2;
    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == COALSTONE_FURNACE_GUI_ID) {
            return new CoalstoneFurnaceGUI(player.inventory, (TileEntityCoalstoneFurnace)world.getTileEntity(new BlockPos(x, y, z)));
        }
        if (ID == ICEIKA_CHEST_GUI_ID) {
            return new IceikaChestGUI(player.inventory, (TileEntityIceikaChest)world.getTileEntity(new BlockPos(x, y, z)), player);
        }
        if (ID == WORKSHOP_MERCHANT) {

            return new GuiWorkshopMerchant(player.inventory, (IMerchant) world.getEntityByID(x), world);

        }
        return null;
    }

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == COALSTONE_FURNACE_GUI_ID) {
            return new ContainerCoalstoneFurnace(player.inventory, (TileEntityCoalstoneFurnace)world.getTileEntity(new BlockPos(x, y, z)));
        }
        if (ID == ICEIKA_CHEST_GUI_ID) {
            return new ContainerIceikaChest(player.inventory, (TileEntityIceikaChest)world.getTileEntity(new BlockPos(x, y, z)), player);
        }
        if (ID == WORKSHOP_MERCHANT) {
            return new ContainerWorkshopMerchant(player.inventory, (IMerchant) world.getEntityByID(x), world);

        }
        return null;
    }
}
