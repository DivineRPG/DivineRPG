package naturix.divinerpg.utils;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.blocks.tile.block.TileEntityCoalstoneFurnace;
import naturix.divinerpg.objects.blocks.tile.block.TileEntityIceikaChest;
import naturix.divinerpg.objects.blocks.tile.container.ContainerCoalstoneFurnace;
import naturix.divinerpg.objects.blocks.tile.container.ContainerIceikaChest;
import naturix.divinerpg.objects.blocks.tile.container.gui.CoalstoneFurnaceGUI;
import naturix.divinerpg.objects.blocks.tile.container.gui.IceikaChestGUI;
import naturix.divinerpg.objects.entities.container.ContainerDivineMerchant;
import naturix.divinerpg.objects.entities.container.gui.GuiJackOMan;
import naturix.divinerpg.objects.entities.container.gui.GuiLivestockMerchant;
import naturix.divinerpg.objects.entities.container.gui.GuiTheHunger;
import naturix.divinerpg.objects.entities.container.gui.GuiWorkshopMerchant;
import naturix.divinerpg.objects.entities.container.gui.GuiWorkshopTinkerer;
import naturix.divinerpg.objects.entities.entity.iceika.WorkshopMerchant;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by LiteWolf101 on Jan /31/2019
 */
public class GUIHandler implements IGuiHandler {
    private WorkshopMerchant merchant;
    public static final int COALSTONE_FURNACE_GUI_ID = 0;
    public static final int ICEIKA_CHEST_GUI_ID = 1;
    public static final int WORKSHOP_MERCHANT = 2;
    public static final int WORKSHOP_TINKERER = 3;
    public static final int JACK_O_MAN = 4;
    public static final int LIVESTOCK_MERCHANT = 5;
    public static final int THE_HUNGER = 6;

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == COALSTONE_FURNACE_GUI_ID) {
            return new CoalstoneFurnaceGUI(player.inventory,
                    (TileEntityCoalstoneFurnace) world.getTileEntity(new BlockPos(x, y, z)));
        } else if (ID == ICEIKA_CHEST_GUI_ID) {
            return new IceikaChestGUI(player.inventory,
                    (TileEntityIceikaChest) world.getTileEntity(new BlockPos(x, y, z)), player);
        } else if (ID == WORKSHOP_MERCHANT) {
            return new GuiWorkshopMerchant(player.inventory, (IMerchant) world.getEntityByID(x), world);
        } else if (ID == WORKSHOP_TINKERER) {
            return new GuiWorkshopTinkerer(player.inventory, (IMerchant) world.getEntityByID(x), world);
        } else if (ID == JACK_O_MAN) {
            return new GuiJackOMan(player.inventory, (IMerchant) world.getEntityByID(x), world);
        } else if (ID == LIVESTOCK_MERCHANT) {
            return new GuiLivestockMerchant(player.inventory, (IMerchant) world.getEntityByID(x), world);
        } else if (ID == THE_HUNGER) {
            return new GuiTheHunger(player.inventory, (IMerchant) world.getEntityByID(x), world);
        }
        return null;
    }

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == COALSTONE_FURNACE_GUI_ID) {
            return new ContainerCoalstoneFurnace(player.inventory,
                    (TileEntityCoalstoneFurnace) world.getTileEntity(new BlockPos(x, y, z)));
        }
        if (ID == ICEIKA_CHEST_GUI_ID) {
            return new ContainerIceikaChest(player.inventory,
                    (TileEntityIceikaChest) world.getTileEntity(new BlockPos(x, y, z)), player);
        }
        if (ID == WORKSHOP_MERCHANT || ID == WORKSHOP_TINKERER || ID == JACK_O_MAN || ID == LIVESTOCK_MERCHANT
                || ID == THE_HUNGER) {
            return new ContainerDivineMerchant(player.inventory, (IMerchant) world.getEntityByID(x), world);
        }
        return null;
    }
}
