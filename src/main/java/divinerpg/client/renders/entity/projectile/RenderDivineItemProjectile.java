package divinerpg.client.renders.entity.projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import java.util.function.Supplier;

public class RenderDivineItemProjectile<T extends Projectile> extends EntityRenderer<T, RenderDivineItemProjectile.ItemProjectileRenderState> {
    private final Supplier<Item> itemSupplier;
    private final ItemModelResolver itemModelResolver;

    public RenderDivineItemProjectile(EntityRendererProvider.Context context, Supplier<Item> itemSupplier) {
        super(context);
        this.itemSupplier = itemSupplier;
        this.itemModelResolver = context.getItemModelResolver();
    }

    @Override
    public ItemProjectileRenderState createRenderState() {
        return new ItemProjectileRenderState();
    }

    @Override
    public void extractRenderState(T entity, ItemProjectileRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);

        double cameraDistSqr = entity.level().isClientSide()
                ? this.entityRenderDispatcher.camera.entity().distanceToSqr(entity) : 0;

        boolean shouldRender = entity.tickCount > 2 || cameraDistSqr >= 12.25;
        state.visible = shouldRender;

        if (shouldRender) {
            this.itemModelResolver.updateForNonLiving(state.itemState, this.itemSupplier.get().getDefaultInstance(), ItemDisplayContext.GROUND, entity);
        }
    }

    @Override
    public void submit(ItemProjectileRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        if (!state.visible) {
            return;
        }

        super.submit(state, poseStack, submitNodeCollector, camera);

        poseStack.pushPose();
        poseStack.mulPose(camera.orientation);
        state.itemState.submit(poseStack, submitNodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, state.outlineColor);
        poseStack.popPose();
    }

    public static class ItemProjectileRenderState extends EntityRenderState {
        public boolean visible = true;
        public final ItemStackRenderState itemState = new ItemStackRenderState();
    }
}