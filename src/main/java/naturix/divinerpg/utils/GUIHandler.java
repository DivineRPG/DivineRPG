package naturix.divinerpg.utils;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.blocks.tile.block.TileEntityFrostedChest;
import naturix.divinerpg.objects.blocks.tile.block.TileEntityInfiniteFurnace;
import naturix.divinerpg.objects.blocks.tile.container.ContainerFrostedChest;
import naturix.divinerpg.objects.blocks.tile.container.ContainerInfiniteFurnace;
import naturix.divinerpg.objects.blocks.tile.container.gui.CoalstoneFurnaceGUI;
import naturix.divinerpg.objects.blocks.tile.container.gui.DemonFurnaceGUI;
import naturix.divinerpg.objects.blocks.tile.container.gui.FrostedChestGUI;
import naturix.divinerpg.objects.blocks.tile.container.gui.MoltenFurnaceGUI;
import naturix.divinerpg.objects.blocks.tile.container.gui.OceanfireFurnaceGUI;
import naturix.divinerpg.objects.blocks.tile.container.gui.WhitefireFurnaceGUI;
import naturix.divinerpg.objects.entities.container.ContainerDivineMerchant;
import naturix.divinerpg.objects.entities.container.gui.GuiJackOMan;
import naturix.divinerpg.objects.entities.container.gui.GuiLivestockMerchant;
import naturix.divinerpg.objects.entities.container.gui.GuiTheHunger;
import naturix.divinerpg.objects.entities.container.gui.GuiWorkshopMerchant;
import naturix.divinerpg.objects.entities.container.gui.GuiWorkshopTinkerer;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by LiteWolf101 on Jan /31/2019
 */
public class GUIHandler implements IGuiHandler {
    public static final int COALSTONE_FURNACE_GUI_ID = 0;
    public static final int MOLTEN_FURNACE_GUI_ID = 1;
    public static final int OCEANFIRE_FURNACE_GUI_ID = 2;
    public static final int WHITEFIRE_FURNACE_GUI_ID = 3;
    public static final int DEMON_FURNACE_GUI_ID = 4;
    public static final int FROSTED_CHEST_GUI_ID = 5;
    public static final int WORKSHOP_MERCHANT = 6;
    public static final int WORKSHOP_TINKERER = 7;
    public static final int JACK_O_MAN = 8;
    public static final int LIVESTOCK_MERCHANT = 9;
    public static final int THE_HUNGER = 10;

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == COALSTONE_FURNACE_GUI_ID) {
            return new CoalstoneFurnaceGUI(player.inventory, (TileEntityInfiniteFurnace) world.getTileEntity(new BlockPos(x, y, z)));
        } else if (ID == MOLTEN_FURNACE_GUI_ID) {
            return new MoltenFurnaceGUI(player.inventory, (TileEntityInfiniteFurnace) world.getTileEntity(new BlockPos(x, y, z)));
        } else if (ID == OCEANFIRE_FURNACE_GUI_ID) {
            return new OceanfireFurnaceGUI(player.inventory, (TileEntityInfiniteFurnace) world.getTileEntity(new BlockPos(x, y, z)));
        } else if (ID == WHITEFIRE_FURNACE_GUI_ID) {
            return new WhitefireFurnaceGUI(player.inventory, (TileEntityInfiniteFurnace) world.getTileEntity(new BlockPos(x, y, z)));
        } else if (ID == DEMON_FURNACE_GUI_ID) {
            return new DemonFurnaceGUI(player.inventory, (TileEntityInfiniteFurnace) world.getTileEntity(new BlockPos(x, y, z)));
        } else if (ID == FROSTED_CHEST_GUI_ID) {
            return new FrostedChestGUI(player.inventory, (TileEntityFrostedChest) world.getTileEntity(new BlockPos(x, y, z)), player);
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
        if (ID == COALSTONE_FURNACE_GUI_ID || ID == MOLTEN_FURNACE_GUI_ID || ID == OCEANFIRE_FURNACE_GUI_ID || ID == WHITEFIRE_FURNACE_GUI_ID || ID == DEMON_FURNACE_GUI_ID) {
            return new ContainerInfiniteFurnace(player.inventory, (TileEntityInfiniteFurnace) world.getTileEntity(new BlockPos(x, y, z)));
        }
        if (ID == FROSTED_CHEST_GUI_ID) {
            return new ContainerFrostedChest(player.inventory, (TileEntityFrostedChest) world.getTileEntity(new BlockPos(x, y, z)), player);
        }
        if (ID == WORKSHOP_MERCHANT || ID == WORKSHOP_TINKERER || ID == JACK_O_MAN || ID == LIVESTOCK_MERCHANT || ID == THE_HUNGER) {
            return new ContainerDivineMerchant(player.inventory, (IMerchant) world.getEntityByID(x), world);
        }
        return null;
    }
}
