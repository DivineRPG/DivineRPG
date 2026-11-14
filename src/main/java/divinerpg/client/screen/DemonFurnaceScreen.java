package divinerpg.client.screen;

import divinerpg.DivineRPG;
import divinerpg.client.menu.DemonFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class DemonFurnaceScreen extends InfiniFurnaceScreen<DemonFurnaceMenu> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/demon_furnace.png");
    public static final Identifier DEMON_FLAME_SPRITE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "demon_flame");
    public DemonFurnaceScreen(DemonFurnaceMenu menu, Inventory inv, Component c) {
        super(menu, inv, c, TEXTURE, 4210752, 4210752, DEMON_FLAME_SPRITE);
    }
}