package divinerpg.items.base.block;

import divinerpg.client.renders.item.RenderDramixAltarItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class ItemDramixAltar extends BlockItem {
    public ItemDramixAltar(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        super.initializeClient(consumer);
        consumer.accept(RenderDramixAltar.INSTANCE);
    }

    static class RenderDramixAltar implements IClientItemExtensions {

        public static RenderDramixAltar INSTANCE = new RenderDramixAltar();

        @Override
        public BlockEntityWithoutLevelRenderer getCustomRenderer() {

            return new RenderDramixAltarItem(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }
    }
}
