package divinerpg.items.base.block;

import divinerpg.client.renders.item.RenderFrostedChestItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class ItemFrostedChest extends BlockItem {
    public ItemFrostedChest(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        super.initializeClient(consumer);
        consumer.accept(RenderFrostedChest.INSTANCE);
    }

    static class RenderFrostedChest implements IClientItemExtensions {

        public static RenderFrostedChest INSTANCE = new RenderFrostedChest();

        @Override
        public BlockEntityWithoutLevelRenderer getCustomRenderer() {

            return new RenderFrostedChestItem(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }
    }
}
