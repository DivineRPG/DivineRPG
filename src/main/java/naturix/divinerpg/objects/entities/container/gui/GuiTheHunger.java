package naturix.divinerpg.objects.entities.container.gui;

import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiTheHunger extends GuiDivineMerchant {
    private static final ResourceLocation MERCHANT_GUI_TEXTURE = new ResourceLocation(Reference.MODID,
            "textures/gui/the_hunger.png");

    public GuiTheHunger(InventoryPlayer playerInventory, IMerchant merchant, World world) {
        super(playerInventory, merchant, world);
    }

    protected ResourceLocation getGuiTexture() {
        return MERCHANT_GUI_TEXTURE;
    }

    protected String getMerchantName() {
        return "The Hunger";
    }

    protected int getTextColor() {
        return 0xFF545F;
    }
}
