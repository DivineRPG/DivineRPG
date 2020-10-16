package divinerpg.objects.entities.container.gui;

import divinerpg.DivineRPG;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class GuiDatticon extends GuiDivineMerchant {
    public static final ResourceLocation MERCHANT_GUI_TEXTURE = new ResourceLocation(DivineRPG.MODID,
            "textures/gui/datticon.png");
    private static String merchantName = new TextComponentTranslation("entity.divinerpg.datticon.name")
            .getFormattedText();

    public GuiDatticon(InventoryPlayer playerInventory, IMerchant merchant, World world) {
        super(playerInventory, merchant, world);
    }

    protected ResourceLocation getGuiTexture() {
        return MERCHANT_GUI_TEXTURE;
    }

    protected String getMerchantName() {
        return merchantName;
    }

    protected int getTextColor() {
        return 0x404040;
    }
}
