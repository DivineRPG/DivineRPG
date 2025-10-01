package divinerpg.client.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;

import static divinerpg.registries.MenuTypeRegistry.ARCANIUM_EXTRACTOR;
import static divinerpg.registries.RecipeRegistry.Types.ARCANIUM_EXTRACTOR_RECIPE_TYPE;

public class ArcaniumExtractorMenu extends AbstractFurnaceMenu {//TODO: arcanium extractor recipe book type
	public ArcaniumExtractorMenu(int containerId, Inventory inv) {
        super(ARCANIUM_EXTRACTOR.get(), ARCANIUM_EXTRACTOR_RECIPE_TYPE.get(), RecipeBookType.FURNACE, containerId, inv);
	}
    public ArcaniumExtractorMenu(int containerId, Inventory inv, Container container, ContainerData data) {
        super(ARCANIUM_EXTRACTOR.get(), ARCANIUM_EXTRACTOR_RECIPE_TYPE.get(), RecipeBookType.FURNACE, containerId, inv, container, data);
    }
    public ArcaniumExtractorMenu(int containerId, Inventory playerInventory, FriendlyByteBuf buffer) {this(containerId, playerInventory);}
}