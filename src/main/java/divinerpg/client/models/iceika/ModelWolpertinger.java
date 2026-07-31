package divinerpg.client.models.iceika;

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


public class ModelWolpertinger<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("wolpertinger");
    public final ModelPart head;
    public final ModelPart body;
    public final ModelPart backRightFoot;
    public final ModelPart backLeftFoot;
    public final ModelPart leftLeg;
    public final ModelPart rightLeg;

    public ModelWolpertinger(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.head = rootPart.getChild("Head");
        this.body = rootPart.getChild("Body");
        this.backRightFoot = rootPart.getChild("BackRightFoot");
        this.backLeftFoot = rootPart.getChild("BackLeftFoot");
        this.leftLeg = rootPart.getChild("LeftLeg");
        this.rightLeg = rootPart.getChild("RightLeg");
    }

    public ModelWolpertinger(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);

        PartDefinition Head = root.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(20, 47).addBox(-2.5F, -4.0F, -5.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(8, 0).addBox(-0.5F, -1.5F, -5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 21).addBox(-3.0F, -4.5F, -5.5F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(104, 35).addBox(-8.0F, -10.3333F, -8.8333F, 7.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(104, 19).addBox(1.0F, -10.3333F, -8.8333F, 7.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, -4.0F));

        Head.addOrReplaceChild("LeftEar", CubeListBuilder.create().texOffs(44, 47).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -1.5F, -3.0F));
        Head.addOrReplaceChild("RightEar", CubeListBuilder.create().texOffs(38, 47).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -1.5F, -3.0F));

        root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(32, 34).addBox(1.0F, -1.6667F, -3.1667F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(29, 0).addBox(-4.0F, -1.6667F, -3.1667F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 21).addBox(-3.0F, -4.6667F, -10.1667F, 6.0F, 6.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.5F, -5.1667F, -10.6667F, 7.0F, 6.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(0, 56).addBox(-2.0F, -4.0F, 3.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 18.6667F, 4.1667F, -0.2618F, 0.0F, 0.0F));

        root.addOrReplaceChild("BackRightFoot", CubeListBuilder.create().texOffs(0, 41).addBox(-1.5F, -0.5F, -8.5F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 23.5F, 7.5F));
        root.addOrReplaceChild("BackLeftFoot", CubeListBuilder.create().texOffs(42, 4).addBox(-1.5F, -0.5F, -8.5F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 23.5F, 7.5F));
        root.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, 0.0F, -1.0F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, -5.0F));
        root.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 21).addBox(-4.0F, 0.0F, -1.0F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, -5.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        this.head.yRot = state.yRot * ((float)Math.PI / 180F);
        this.head.xRot = state.xRot * ((float)Math.PI / 180F);

        float jumpRotation = 0.0F;

        this.backLeftFoot.xRot = jumpRotation * 50.0F * ((float)Math.PI / 180F);
        this.backRightFoot.xRot = jumpRotation * 50.0F * ((float)Math.PI / 180F);
        this.leftLeg.xRot = (jumpRotation * -40.0F - 11.0F) * ((float)Math.PI / 180F);
        this.rightLeg.xRot = (jumpRotation * -40.0F - 11.0F) * ((float)Math.PI / 180F);
    }
}