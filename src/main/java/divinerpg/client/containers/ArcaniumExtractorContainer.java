package divinerpg.client.containers;
import divinerpg.registries.*;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;

public class ArcaniumExtractorContainer extends AbstractFurnaceMenu {//TODO: arcanium extractor recipe book type
	public ArcaniumExtractorContainer(int p_i50082_1_, Inventory p_i50082_2_) {
        super(MenuTypeRegistry.ARCANIUM_EXTRACTOR.get(), RecipeRegistry.Types.ARCANIUM_EXTRACTOR_RECIPE_TYPE.get(), RecipeBookType.FURNACE, p_i50082_1_, p_i50082_2_);
	}
    public ArcaniumExtractorContainer(int p_i50083_1_, Inventory p_i50083_2_, Container p_i50083_3_, ContainerData p_i50083_4_) {
        super(MenuTypeRegistry.ARCANIUM_EXTRACTOR.get(), RecipeRegistry.Types.ARCANIUM_EXTRACTOR_RECIPE_TYPE.get(), RecipeBookType.FURNACE, p_i50083_1_, p_i50083_2_, p_i50083_3_, p_i50083_4_);
    }
    public ArcaniumExtractorContainer(int i, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(i, playerInventory);
    }
}