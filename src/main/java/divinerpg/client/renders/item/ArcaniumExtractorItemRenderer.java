package divinerpg.client.renders.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mojang.serialization.MapCodec;
import divinerpg.DivineRPG;
import divinerpg.client.models.block.ModelArcaniumExtractor;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Unit;
import net.minecraft.world.item.ItemStack;
import org.joml.Vector3fc;
import org.jspecify.annotations.Nullable;

import java.util.function.Consumer;

public class ArcaniumExtractorItemRenderer implements SpecialModelRenderer<Void> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/model/arcanium_extractor.png");
    private final ModelArcaniumExtractor model;

    public ArcaniumExtractorItemRenderer(EntityModelSet entityModelSet) {
        this.model = new ModelArcaniumExtractor(entityModelSet.bakeLayer(ModelArcaniumExtractor.LAYER_LOCATION));
    }

    @Override
    public void submit(@Nullable Void unused, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int packedLight, int packedOverlay, boolean glint, int i2) {
        poseStack.pushPose();
        poseStack.translate(0.5D, 0D, 0.5D);
        poseStack.rotate(Axis.YP.rotationDegrees(270.0F));
        submitNodeCollector.submitModel(model, Unit.INSTANCE, poseStack, TEXTURE, packedLight, packedOverlay, -1);
        poseStack.popPose();
    }

    @Override
    public void getExtents(Consumer<Vector3fc> consumer) {
    }

    @Override
    public @Nullable Void extractArgument(ItemStack stack) {
        return null;
    }

    public static class Unbaked implements SpecialModelRenderer.Unbaked<Void> {
        public static final MapCodec<Unbaked> MAP_CODEC = MapCodec.unit(Unbaked::new);

        @Override
        public MapCodec<? extends SpecialModelRenderer.Unbaked<Void>> type() {
            return MAP_CODEC;
        }

        @Override
        public SpecialModelRenderer<Void> bake(SpecialModelRenderer.BakingContext context) {
            return new ArcaniumExtractorItemRenderer(context.entityModelSet());
        }
    }
}