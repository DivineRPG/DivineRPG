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
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

import static divinerpg.utils.Utils.createLocation;

public class ModelHusk<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("husk");
    public final ModelPart root;
    public final ModelPart head;
    public final ModelPart leg0;
    public final ModelPart leg1;
    public final ModelPart leg2;
    public final ModelPart leg3;

    public ModelHusk(ModelPart r) {
        super(r);
        root = r.getChild("root");
        head = root.getChild("head");
        leg0 = root.getChild("leg0");
        leg1 = root.getChild("leg1");
        leg2 = root.getChild("leg2");
        leg3 = root.getChild("leg3");
    }

    public ModelHusk(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation pointone = new CubeDeformation(0.1F), minuspointone = new CubeDeformation(-0.1F);

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0F, 24F, -1F));

        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 28).addBox(-4F, -1.9F, -3.8F, 8F, 8F, 6F, CubeDeformation.NONE)
                .texOffs(36, 52).addBox(-2F, -1.9F, -3.8F, 4F, 2F, 6F, pointone)
                .texOffs(35, 5).addBox(-5F, 4.1F, -1.8F, 1F, 3F, 1F, CubeDeformation.NONE)
                .texOffs(35, 0).addBox(-3F, 4.1F, -4.8F, 1F, 4F, 1F, CubeDeformation.NONE)
                .texOffs(35, 5).addBox(4F, 4.1F, -1.8F, 1F, 3F, 1F, CubeDeformation.NONE)
                .texOffs(35, 0).addBox(2F, 4.1F, -4.8F, 1F, 4F, 1F, CubeDeformation.NONE), PartPose.offset(0F, -20F, -8F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0F, -19F, 2F));

        body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(34, 43).addBox(-2F, 15F, -6F, 4F, 3F, 6F, new CubeDeformation(0.11F))
                .texOffs(0, 52).addBox(-6F, 10F, -6F, 12F, 5F, 6F, pointone)
                .texOffs(0, 42).addBox(-6F, 3F, -5F, 12F, 5F, 5F, pointone)
                .texOffs(0, 0).addBox(-6F, 0F, -10F, 12F, 18F, 10F, CubeDeformation.NONE), PartPose.offsetAndRotation(0F, -0.9F, -7.8F, 1.309F, 0F, 0F));

        root.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(28, 28).mirror().addBox(-2F, 2.1F, -2F, 4F, 10F, 4F, minuspointone).mirror(false), PartPose.offset(-4F, -12F, 7F));

        root.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(28, 28).addBox(-2F, 2.1F, -2F, 4F, 10F, 4F, minuspointone), PartPose.offset(4F, -12F, 7F));

        root.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(44, 28).mirror().addBox(-2F, 2.1F, -1F, 4F, 10F, 4F, minuspointone).mirror(false)
                .texOffs(48, 42).mirror().addBox(-2F, 3.1F, -1F, 4F, 3F, 4F, CubeDeformation.NONE).mirror(false), PartPose.offset(-4F, -12F, -6F));

        root.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(44, 28).addBox(-2F, 2.1F, -1F, 4F, 10F, 4F, minuspointone)
                .texOffs(48, 42).addBox(-2F, 3.1F, -1F, 4F, 3F, 4F, CubeDeformation.NONE), PartPose.offset(4F, -12F, -6F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float headPitch = state.xRot * ((float) Math.PI / 180F);
        float netHeadYaw = state.yRot * ((float) Math.PI / 180F);
        //TODO - has passenger
        if (state.isDiscrete) {
            leg1.yRot = -0.2F;
            leg0.yRot = 0.2F;
            leg1.y = leg0.y = -7F;
            leg1.z = leg0.z = 9F;
            root.y = 29F;
            leg1.xRot = leg0.xRot = (float) Math.PI / -2F;
            leg3.xRot = leg2.xRot = (float) Math.PI / -4F;
        } else {
            leg1.yRot = leg0.yRot = 0F;
            leg1.y = leg0.y = -12F;
            leg1.z = leg0.z = 7F;
            root.y = 24F;
            leg0.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
            leg1.xRot = -leg0.xRot;
            leg2.xRot = -leg0.xRot;
            leg3.xRot = leg0.xRot;
        }

        head.yRot = netHeadYaw;
        head.xRot = headPitch;
    }
}