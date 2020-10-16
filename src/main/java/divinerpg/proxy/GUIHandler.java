package divinerpg.proxy;

import divinerpg.objects.blocks.tile.container.*;
import divinerpg.objects.blocks.tile.container.gui.*;
import divinerpg.objects.blocks.tile.entity.*;
import divinerpg.objects.entities.container.gui.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GUIHandler implements IGuiHandler {
    public static final int COALSTONE_FURNACE_GUI_ID = 0;
    public static final int MOLTEN_FURNACE_GUI_ID = 1;
    public static final int OCEANFIRE_FURNACE_GUI_ID = 2;
    public static final int WHITEFIRE_FURNACE_GUI_ID = 3;
    public static final int DEMON_FURNACE_GUI_ID = 4;
    public static final int FROSTED_CHEST_GUI_ID = 5;
    public static final int WORKSHOP_MERCHANT_GUI_ID = 6;
    public static final int WORKSHOP_TINKERER_GUI_ID = 7;
    public static final int JACK_O_MAN_GUI_ID = 8;
    public static final int LIVESTOCK_MERCHANT_GUI_ID = 9;
    public static final int THE_HUNGER_GUI_ID = 10;
    public static final int PRESENT_BOX_GUI_ID = 11;
    public static final int BONE_CHEST_GUI_ID = 12;
    public static final int ALTAR_OF_CORRUPTION_GUI_ID = 13;
    public static final int EDEN_CHEST_GUI_ID = 14;
    public static final int CAPTAIN_MERIK_GUI_ID = 15;
    public static final int DATTICON_GUI_ID = 16;
    public static final int LEORNA_GUI_ID = 17;
    public static final int VATICUS_GUI_ID = 18;
    public static final int WAR_GENERAL_GUI_ID = 19;
    public static final int ZELUS_GUI_ID = 20;
    public static final int GREENLIGHT_FURNACE_GUI_ID = 21;
    public static final int MOONLIGHT_FURNACE_GUI_ID = 22;
    public static final int ARCANIUM_EXTRACTOR_GUI_ID = 23;
    public static final int INFUSION_TABLE_GUI_ID = 24;
    public static final int DREAM_LAMP_GUI_ID = 25;
    public static final int KAZARI_GUI_ID = 26;
    public static final int KingCompressorGuiId = 999;

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
        Entity entityByID = world.getEntityByID(x);

        switch (ID) {
            case COALSTONE_FURNACE_GUI_ID:
                return new CoalstoneFurnaceGUI(player.inventory, (TileEntityModFurnace) tileEntity);
            case MOLTEN_FURNACE_GUI_ID:
                return new MoltenFurnaceGUI(player.inventory, (TileEntityModFurnace) tileEntity);
            case OCEANFIRE_FURNACE_GUI_ID:
                return new OceanfireFurnaceGUI(player.inventory, (TileEntityModFurnace) tileEntity);
            case WHITEFIRE_FURNACE_GUI_ID:
                return new WhitefireFurnaceGUI(player.inventory, (TileEntityModFurnace) tileEntity);
            case DEMON_FURNACE_GUI_ID:
                return new DemonFurnaceGUI(player.inventory, (TileEntityModFurnace) tileEntity);
            case FROSTED_CHEST_GUI_ID:
                return new FrostedChestGUI(player.inventory, (TileEntityFrostedChest) tileEntity, player);
            case WORKSHOP_MERCHANT_GUI_ID:
                return new GuiWorkshopMerchant(player.inventory, (IMerchant) entityByID, world);
            case WORKSHOP_TINKERER_GUI_ID:
                return new GuiWorkshopTinkerer(player.inventory, (IMerchant) entityByID, world);
            case JACK_O_MAN_GUI_ID:
                return new GuiJackOMan(player.inventory, (IMerchant) entityByID, world);
            case LIVESTOCK_MERCHANT_GUI_ID:
                return new GuiLivestockMerchant(player.inventory, (IMerchant) entityByID, world);
            case THE_HUNGER_GUI_ID:
                return new GuiTheHunger(player.inventory, (IMerchant) entityByID, world);
            case PRESENT_BOX_GUI_ID:
                return new PresentBoxGUI(player.inventory, (TileEntityPresentBox) tileEntity, player);
            case BONE_CHEST_GUI_ID:
                return new BoneChestGUI(player.inventory, (TileEntityBoneChest) tileEntity, player);
            case ALTAR_OF_CORRUPTION_GUI_ID:
                return new AltarOfCorruptionGUI(player.inventory, world, (TileEntityAltarOfCorruption) tileEntity);
            case EDEN_CHEST_GUI_ID:
                return new EdenChestGUI(player.inventory, (TileEntityEdenChest) tileEntity, player);
            case CAPTAIN_MERIK_GUI_ID:
                return new GuiCaptainMerik(player.inventory, (IMerchant) entityByID, world);
            case DATTICON_GUI_ID:
                return new GuiDatticon(player.inventory, (IMerchant) entityByID, world);
            case LEORNA_GUI_ID:
                return new GuiLeorna(player.inventory, (IMerchant) entityByID, world);
            case VATICUS_GUI_ID:
                return new GuiLordVatticus(player.inventory, (IMerchant) entityByID, world);
            case WAR_GENERAL_GUI_ID:
                return new GuiWarGeneral(player.inventory, (IMerchant) entityByID, world);
            case ZELUS_GUI_ID:
                return new GuiZelus(player.inventory, (IMerchant) entityByID, world);
            case GREENLIGHT_FURNACE_GUI_ID:
                return new GreenlightFurnaceGUI(player.inventory, (TileEntityModFurnace) tileEntity);
            case MOONLIGHT_FURNACE_GUI_ID:
                return new MoonlightFurnaceGUI(player.inventory, (TileEntityModFurnace) tileEntity);
            case ARCANIUM_EXTRACTOR_GUI_ID:
                return new ArcaniumExtractorGUI(player.inventory, (TileEntityModFurnace) tileEntity);
            case INFUSION_TABLE_GUI_ID:
                return new InfusionTableGUI(new ContainerInfusionTable(player.inventory, world, (TileEntityInfusionTable) tileEntity));
            case DREAM_LAMP_GUI_ID:
                return new DreamLampGUI(new ContainerDreamLamp(player.inventory, world, (TileEntityDreamLamp) tileEntity));
            case KAZARI_GUI_ID:
                return new GuiKazari(player.inventory, (IMerchant) entityByID, world);
            case KingCompressorGuiId:
                return new KIngCompressionGUI(new KingCompressorContainer(player.inventory, (TileEntityKingCompressior) tileEntity));

            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));

        switch (ID) {
            case COALSTONE_FURNACE_GUI_ID:
            case MOLTEN_FURNACE_GUI_ID:
            case OCEANFIRE_FURNACE_GUI_ID:
            case WHITEFIRE_FURNACE_GUI_ID:
            case DEMON_FURNACE_GUI_ID:
            case GREENLIGHT_FURNACE_GUI_ID:
            case ARCANIUM_EXTRACTOR_GUI_ID:
            case MOONLIGHT_FURNACE_GUI_ID:
                return new ContainerModFurnace(player.inventory, (TileEntityModFurnace) tileEntity);

            case FROSTED_CHEST_GUI_ID:
            case PRESENT_BOX_GUI_ID:
            case BONE_CHEST_GUI_ID:
            case EDEN_CHEST_GUI_ID:
                return new ContainerModChest(player.inventory, (TileEntityModChest) tileEntity, player);

            case WORKSHOP_MERCHANT_GUI_ID:
            case WORKSHOP_TINKERER_GUI_ID:
            case JACK_O_MAN_GUI_ID:
            case LIVESTOCK_MERCHANT_GUI_ID:
            case CAPTAIN_MERIK_GUI_ID:
            case DATTICON_GUI_ID:
            case LEORNA_GUI_ID:
            case VATICUS_GUI_ID:
            case WAR_GENERAL_GUI_ID:
            case ZELUS_GUI_ID:
            case THE_HUNGER_GUI_ID:
            case KAZARI_GUI_ID:
                return new ContainerMerchant(player.inventory, (IMerchant) world.getEntityByID(x), world);

            case ALTAR_OF_CORRUPTION_GUI_ID:
                return new ContainerAltarOfCorruption(player.inventory, world, new BlockPos(x, y, z));

            case INFUSION_TABLE_GUI_ID:
                return new ContainerInfusionTable(player.inventory, world, (TileEntityInfusionTable) tileEntity);

            case DREAM_LAMP_GUI_ID:
                return new ContainerDreamLamp(player.inventory, world, (TileEntityDreamLamp) tileEntity);

            case KingCompressorGuiId:
                return new KingCompressorContainer(player.inventory, (TileEntityKingCompressior) tileEntity);

            default:
                return null;
        }

    }
}
