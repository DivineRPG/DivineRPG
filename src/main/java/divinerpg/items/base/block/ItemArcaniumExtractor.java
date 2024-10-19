package divinerpg.items.base.block;

import divinerpg.client.renders.item.RenderArcaniumExtractorItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class ItemArcaniumExtractor extends BlockItem {
    public ItemArcaniumExtractor(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(RenderArcaniumExtractor.INSTANCE);
    }

    static class RenderArcaniumExtractor implements IClientItemExtensions {

        public static RenderArcaniumExtractor INSTANCE = new RenderArcaniumExtractor();

        @Override
        public BlockEntityWithoutLevelRenderer getCustomRenderer() {
            return new RenderArcaniumExtractorItem(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }
    }
}
