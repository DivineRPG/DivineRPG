package divinerpg.items.base.block;

import divinerpg.client.renders.item.RenderItemStatue;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.*;

public class ItemStatueBlock extends BlockItem {
    static Supplier<Block> block;
    public ItemStatueBlock(Supplier<Block> block, Properties properties) {
        super(block.get(), properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        super.initializeClient(consumer);
        consumer.accept(RenderStatueBlock.INSTANCE);
    }

    static class RenderStatueBlock implements IClientItemExtensions {

        public static RenderStatueBlock INSTANCE = new RenderStatueBlock();

        @Override
        public BlockEntityWithoutLevelRenderer getCustomRenderer() {

            return new RenderItemStatue(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels(), block);
        }
    }
}
