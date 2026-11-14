package divinerpg.client.screen;

import divinerpg.DivineRPG;
import divinerpg.client.menu.OceanfireFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class OceanfireFurnaceScreen extends InfiniFurnaceScreen<OceanfireFurnaceMenu> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/oceanfire_furnace.png");
    public static final Identifier OCEAN_FIRE_SPRITE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "ocean_fire");
    public OceanfireFurnaceScreen(OceanfireFurnaceMenu menu, Inventory inv, Component c) {
        super(menu, inv, c, TEXTURE, 1980988, 1980988, OCEAN_FIRE_SPRITE);
    }
}