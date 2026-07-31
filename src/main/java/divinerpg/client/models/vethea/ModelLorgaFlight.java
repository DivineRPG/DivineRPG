package divinerpg.client.models.vethea;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

import static divinerpg.utils.Utils.createLocation;

public class ModelLorgaFlight<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("lorga_flight");
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart rightarm;
    private final ModelPart leftarm;
    private final ModelPart body2;
    private final ModelPart body3;
    private final ModelPart body4;
    private final ModelPart body5;
    private final ModelPart body6;
    private final ModelPart body7;
    private final ModelPart body8;

    public ModelLorgaFlight(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.rightarm = root.getChild("rightarm");
        this.leftarm = root.getChild("leftarm");
        this.body2 = root.getChild("body2");
        this.body3 = root.getChild("body3");
        this.body4 = root.getChild("body4");
        this.body5 = root.getChild("body5");
        this.body6 = root.getChild("body6");
        this.body7 = root.getChild("body7");
        this.body8 = root.getChild("body8");
    }

    public ModelLorgaFlight(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 13.0F, 0.0F));

        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(21, 16).mirror().addBox(-1.0F, 3.0F, 5.0F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 23.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 2.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 17.0F, 3.0F, 0.0F, 0.0F, 1.0472F));

        partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 2.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 15.0F, 3.0F, 0.0F, 0.0F, -1.0472F));

        partdefinition.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(26, 0).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 13.0F, 1.0F, 0.6981F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(55, 0).mirror().addBox(-1.0F, 0.0F, -2.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 1.0F, 0.6981F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(26, 0).mirror().addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 13.0F, 1.0F, 0.6981F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("body5", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-1.0F, 0.0F, 1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 17.0F, 1.0F, 0.6981F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("body6", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-1.0F, 0.0F, 1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 17.0F, 1.0F, 0.6981F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("body7", CubeListBuilder.create().texOffs(26, 0).mirror().addBox(-1.0F, 0.0F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 21.0F, 1.0F, 0.6981F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("body8", CubeListBuilder.create().texOffs(26, 0).addBox(-1.0F, 0.0F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 21.0F, 1.0F, 0.6981F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

}