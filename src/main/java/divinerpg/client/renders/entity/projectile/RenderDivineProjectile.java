package divinerpg.client.renders.entity.projectile;

import com.mojang.blaze3d.vertex.*;
import divinerpg.DivineRPG;
import divinerpg.items.ranged.ItemRangedWeapon;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.projectile.Projectile;
import net.neoforged.api.distmarker.*;
import org.joml.Matrix4f;

@OnlyIn(Dist.CLIENT)
public class RenderDivineProjectile<T extends Projectile> extends EntityRenderer<T> {
    protected final ResourceLocation TEXTURE;
    protected final RenderType renderType;
    
    public RenderDivineProjectile(final EntityRendererProvider.Context context, final String name) {
    	this(context, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/projectiles/" + name + ".png"));
    }
    public RenderDivineProjectile(final EntityRendererProvider.Context context) {
    	this(context, ItemRangedWeapon.GENERIC);
    }
    public RenderDivineProjectile(final EntityRendererProvider.Context context, final ResourceLocation texture) {
    	super(context);
    	TEXTURE = texture;
    	renderType = RenderType.entityCutoutNoCull(texture);
    }
    @Override public void render(T entity, float yaw, float partialTicks, PoseStack matrix, MultiBufferSource buffer, int packedLight) {
        if(entity.tickCount > 2 || !(entityRenderDispatcher.camera.getEntity().distanceToSqr(entity) < 12.25)) {
            super.render(entity, yaw, partialTicks, matrix, buffer, packedLight);
            matrix.pushPose();
            matrix.scale(.5F, .5F, .5F);
            matrix.mulPose(entityRenderDispatcher.cameraOrientation());
            PoseStack.Pose matrixEntry = matrix.last();
            Matrix4f matrix4f = matrixEntry.pose();
            VertexConsumer vertexBuilder = buffer.getBuffer(renderType);

            pos(vertexBuilder, matrix4f, packedLight, 0, 0, 0, 1);
            pos(vertexBuilder, matrix4f, packedLight, 1, 0, 1, 1);
            pos(vertexBuilder, matrix4f, packedLight, 1, 1, 1, 0);
            pos(vertexBuilder, matrix4f, packedLight, 0, 1, 0, 0);
            matrix.popPose();
        }
    }
    private static void pos(VertexConsumer vertexBuilder, Matrix4f matrix4f, int lightmapUV, float x, float y, float u, float v) {
        vertexBuilder.addVertex(matrix4f, x - .5F, y - .25F, 0).setColor(255, 255, 255, 255).setUv(u, v).setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmapUV).setNormal(0, 1, 0);
    }
    @Override public ResourceLocation getTextureLocation(T entity) {return TEXTURE;}
}