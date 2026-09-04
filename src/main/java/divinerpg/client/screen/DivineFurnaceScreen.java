package divinerpg.client.screen;

import divinerpg.DivineRPG;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;

import java.util.List;

public abstract class DivineFurnaceScreen<T extends AbstractFurnaceMenu> extends AbstractFurnaceScreen<T> {
    public static final Identifier FLAME_SPRITE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "furnace_flame");
    public static final Identifier PROGRESS_ARROW_SPRITE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "progress_arrow");

    private final int titleColor;
    private final int invColor;

    public DivineFurnaceScreen(T container, Inventory inv, Component c, Identifier location, int titleColor, int invColor, Identifier flameSprite) {
        super(container, inv, c, c, location, flameSprite, PROGRESS_ARROW_SPRITE, List.of());
        this.titleColor = titleColor;
        this.invColor = invColor;
    }

    public DivineFurnaceScreen(T container, Inventory inv, Component c, Identifier location, int titleColor, int invColor) {
        this(container, inv, c, location, titleColor, invColor, FLAME_SPRITE);
    }

    @Override
    protected void extractLabels(GuiGraphicsExtractor graphics, int xm, int ym) {
        graphics.text(font, title, titleLabelX, titleLabelY, titleColor, false);
        graphics.text(font, playerInventoryTitle, inventoryLabelX, inventoryLabelY, invColor, false);
    }
}