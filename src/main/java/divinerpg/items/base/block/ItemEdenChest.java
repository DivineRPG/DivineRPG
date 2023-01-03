package divinerpg.items.base.block;

import divinerpg.client.renders.item.RenderEdenChestItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class ItemEdenChest extends BlockItem {
    public ItemEdenChest(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        super.initializeClient(consumer);
        consumer.accept(RenderEdenChest.INSTANCE);
    }

    static class RenderEdenChest implements IClientItemExtensions {

        public static RenderEdenChest INSTANCE = new RenderEdenChest();

        @Override
        public BlockEntityWithoutLevelRenderer getCustomRenderer() {

            return new RenderEdenChestItem(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }
    }
}
