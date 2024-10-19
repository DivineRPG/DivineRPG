package divinerpg.items.base.block;

import divinerpg.client.renders.item.RenderBoneChestItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class ItemBoneChest extends BlockItem {
    public ItemBoneChest(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(RenderBoneChest.INSTANCE);
    }

    static class RenderBoneChest implements IClientItemExtensions {

        public static RenderBoneChest INSTANCE = new RenderBoneChest();

        @Override
        public BlockEntityWithoutLevelRenderer getCustomRenderer() {
            return new RenderBoneChestItem(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }
    }
}
