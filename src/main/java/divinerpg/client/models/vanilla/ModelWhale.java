package divinerpg.client.models.vanilla;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

import static divinerpg.utils.Utils.createLocation;

public class ModelWhale<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("whale");
    private final ModelPart body, flipperL, flipperR, tail;

    public ModelWhale(ModelPart root) {
        super(root);
        this.body = root.getChild("body");
        this.flipperL = root.getChild("flipperL");
        this.flipperR = root.getChild("flipperR");
        this.tail = root.getChild("tail");
    }

    public ModelWhale(Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 6.0F, 24.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-4.0F, 18.0F, -9.0F));

        partdefinition.addOrReplaceChild("flipperL", CubeListBuilder.create().texOffs(0, 42).mirror().addBox(0.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(3.0F, 21.0F, 0.0F));

        partdefinition.addOrReplaceChild("flipperR", CubeListBuilder.create().texOffs(0, 42).mirror().addBox(-6.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-3.0F, 21.0F, 0.0F));

        partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 58).mirror().addBox(-6.0F, 0.0F, 6.0F, 12.0F, 2.0F, 4.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 42).mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(0.0F, 19.0F, 15.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;

        this.flipperR.zRot = (float) (-Math.sin((10 * ageInTicks / (180f / Math.PI))) * 0.3f);
        this.flipperL.zRot = (float) (Math.sin((10 * ageInTicks / (180f / Math.PI))) * 0.3f);
        this.tail.xRot = (float) (Math.cos(limbSwing * 0.6662F) * limbSwingAmount / 4);
    }
}