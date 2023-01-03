package divinerpg.items.base.block;

import divinerpg.client.renders.item.RenderPresentBoxItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class ItemPresentBox extends BlockItem {
    public ItemPresentBox(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        super.initializeClient(consumer);
        consumer.accept(RenderPresentBox.INSTANCE);
    }

    static class RenderPresentBox implements IClientItemExtensions {

        public static RenderPresentBox INSTANCE = new RenderPresentBox();

        @Override
        public BlockEntityWithoutLevelRenderer getCustomRenderer() {

            return new RenderPresentBoxItem(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }
    }
}
