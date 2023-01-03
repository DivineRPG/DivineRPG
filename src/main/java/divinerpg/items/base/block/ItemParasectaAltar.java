package divinerpg.items.base.block;

import divinerpg.client.renders.item.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class ItemParasectaAltar extends BlockItem {
    public ItemParasectaAltar(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        super.initializeClient(consumer);
        consumer.accept(RenderParasectaAltar.INSTANCE);
    }

    static class RenderParasectaAltar implements IClientItemExtensions {

        public static RenderParasectaAltar INSTANCE = new RenderParasectaAltar();

        @Override
        public BlockEntityWithoutLevelRenderer getCustomRenderer() {

            return new RenderParasectaAltarItem(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }
    }
}
