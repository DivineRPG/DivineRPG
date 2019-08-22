package naturix.divinerpg.objects.entities.container.gui;

import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class GuiLeorna extends GuiDivineMerchant {
    public static final ResourceLocation MERCHANT_GUI_TEXTURE = new ResourceLocation(Reference.MODID,
            "textures/gui/leorna.png");
    private static String merchantName = new TextComponentTranslation("entity.leorna.name")
            .getFormattedText();

    public GuiLeorna(InventoryPlayer playerInventory, IMerchant merchant, World world) {
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
