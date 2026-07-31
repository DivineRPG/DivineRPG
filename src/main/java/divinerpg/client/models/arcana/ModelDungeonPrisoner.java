package divinerpg.client.models.arcana;

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

public class ModelDungeonPrisoner extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("dungeon_prisoner");
    private final ModelPart head, body, rightarm, leftarm, rightleg, leftleg;

    public ModelDungeonPrisoner(Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelDungeonPrisoner(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.rightarm = root.getChild("rightarm");
        this.leftarm = root.getChild("leftarm");
        this.rightleg = root.getChild("rightleg");
        this.leftleg = root.getChild("leftleg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-4.0F, -14.0F, -4.0F, 8.0F, 10.0F, 8.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(0.0F, 4.0F, 0.0F));

        head.addOrReplaceChild("headtop", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0F, 14.0F, -4.0F, 10.0F, 5.0F, 8.0F, CubeDeformation.NONE).mirror(false), PartPose.rotation(3.1416F, 0.0F, 0.0F));

        head.addOrReplaceChild("headbottom", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0F, -4.0F, -4.0F, 10.0F, 5.0F, 8.0F, CubeDeformation.NONE).mirror(false), PartPose.rotation(0.0F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

        partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-5.0F, 7.0F, 0.0F));

        partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(5.0F, 7.0F, 0.0F));

        partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-2.0F, 17.0F, 0.0F));

        partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(2.0F, 17.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(LivingEntityRenderState state) {
        super.setupAnim(state);
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;

        this.head.yRot = state.yRot * (float) (Math.PI / 180.0);
        this.head.xRot = state.xRot * (float) (Math.PI / 180.0);
        this.rightarm.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 2.0F * limbSwingAmount * 0.5F);
        this.leftarm.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F);
        this.rightleg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.leftleg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
    }
}