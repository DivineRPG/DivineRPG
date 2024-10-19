package divinerpg.items.base.block;

import divinerpg.client.renders.item.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class ItemDemonFurnace extends BlockItem {
    public ItemDemonFurnace(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(RenderDemonFurnace.INSTANCE);
    }

    static class RenderDemonFurnace implements IClientItemExtensions {

        public static RenderDemonFurnace INSTANCE = new RenderDemonFurnace();

        @Override
        public BlockEntityWithoutLevelRenderer getCustomRenderer() {

            return new RenderDemonFurnaceItem(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }
    }
}
