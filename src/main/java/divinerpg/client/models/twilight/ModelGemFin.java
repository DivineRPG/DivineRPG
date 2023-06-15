package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.eden.EntityGemFin;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelGemFin extends EntityModel<EntityGemFin> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("gem_fin");
    private final ModelPart Body;
    private final ModelPart Head;

    public ModelGemFin(EntityRendererProvider.Context context) {
        ModelPart root = context.bakeLayer(LAYER_LOCATION);
        this.Body = root.getChild("Body");
        this.Head = root.getChild("Head");
        }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(8, 15).addBox(0.0F, -6.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
        .texOffs(0, 0).addBox(-2.5F, -4.0F, -2.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, -2.0F));

        PartDefinition RightFin = Body.addOrReplaceChild("RightFin", CubeListBuilder.create(), PartPose.offset(-2.0F, -1.0F, 1.0F));

        PartDefinition RightFin_r1 = RightFin.addOrReplaceChild("RightFin_r1", CubeListBuilder.create().texOffs(16, 16).addBox(0.5F, 0.0F, -1.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.3491F));

        PartDefinition LeftFin = Body.addOrReplaceChild("LeftFin", CubeListBuilder.create(), PartPose.offset(2.0F, -1.0F, 1.0F));

        PartDefinition LeftFin_r1 = LeftFin.addOrReplaceChild("LeftFin_r1", CubeListBuilder.create().texOffs(8, 18).addBox(-0.5F, 0.0F, -1.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.3491F));

        PartDefinition Hip = Body.addOrReplaceChild("Hip", CubeListBuilder.create().texOffs(16, 11).addBox(-1.0F, -6.0F, 1.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 2.0F));

        PartDefinition TailFin = Hip.addOrReplaceChild("TailFin", CubeListBuilder.create().texOffs(0, 15).addBox(0.0F, -4.0F, 0.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 3.0F));

        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 11).addBox(-2.0F, -3.0F, -3.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, -4.0F));

        PartDefinition LeftWhisker_r1 = Head.addOrReplaceChild("LeftWhisker_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.3682F, 0.2875F, -1.0513F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -1.0F, -3.0F, 0.2942F, -0.1321F, -0.4202F));

        PartDefinition RightWhisker_r1 = Head.addOrReplaceChild("RightWhisker_r1", CubeListBuilder.create().texOffs(0, 11).addBox(-0.6567F, 0.361F, -1.0807F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -1.0F, -3.0F, 0.3742F, 0.1574F, 0.3633F));

        return LayerDefinition.create(meshdefinition, 32, 32);
        }

    @Override
    public void setupAnim(EntityGemFin entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
            Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            }
}