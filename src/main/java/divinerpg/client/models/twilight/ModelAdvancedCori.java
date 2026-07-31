package divinerpg.client.models.twilight;

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

public class ModelAdvancedCori<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("advanced_cori");
    public final ModelPart head;
    public final ModelPart tentacle1;
    public final ModelPart tentacle2;
    public final ModelPart tentacle3;
    public final ModelPart tentacle4;
    public final ModelPart tentacle5;
    public final ModelPart tentacle6;
    public final ModelPart tentacle7;
    public final ModelPart tentacle8;
    public final ModelPart tentacle9;
    public final ModelPart tentacle10;
    public final ModelPart tentacle11;
    public final ModelPart tentacle12;
    public final ModelPart tentacle13;
    public final ModelPart tentacle14;
    public final ModelPart tentacle15;
    public final ModelPart tentacle16;
    public final ModelPart tentacle17;
    public final ModelPart tentacle18;
    public final ModelPart tentacle19;
    public final ModelPart tentacle20;

    public ModelAdvancedCori(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.head = rootPart.getChild("Head");
        this.tentacle1 = rootPart.getChild("Tentacle1");
        this.tentacle2 = rootPart.getChild("Tentacle2");
        this.tentacle3 = rootPart.getChild("Tentacle3");
        this.tentacle4 = rootPart.getChild("Tentacle4");
        this.tentacle5 = rootPart.getChild("Tentacle5");
        this.tentacle6 = rootPart.getChild("Tentacle6");
        this.tentacle7 = rootPart.getChild("Tentacle7");
        this.tentacle8 = rootPart.getChild("Tentacle8");
        this.tentacle9 = rootPart.getChild("Tentacle9");
        this.tentacle10 = rootPart.getChild("Tentacle10");
        this.tentacle11 = rootPart.getChild("Tentacle11");
        this.tentacle12 = rootPart.getChild("Tentacle12");
        this.tentacle13 = rootPart.getChild("Tentacle13");
        this.tentacle14 = rootPart.getChild("Tentacle14");
        this.tentacle15 = rootPart.getChild("Tentacle15");
        this.tentacle16 = rootPart.getChild("Tentacle16");
        this.tentacle17 = rootPart.getChild("Tentacle17");
        this.tentacle18 = rootPart.getChild("Tentacle18");
        this.tentacle19 = rootPart.getChild("Tentacle19");
        this.tentacle20 = rootPart.getChild("Tentacle20");
    }

    public ModelAdvancedCori(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);

        root.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Tentacle1", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 2.0F, 5.0F, 0.0F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Tentacle2", CubeListBuilder.create().texOffs(52, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 19.0F, 0.0F));

        root.addOrReplaceChild("Tentacle3", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 20.0F, -3.0F, 0.0F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Tentacle4", CubeListBuilder.create().texOffs(11, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 17.0F, 5.0F));

        root.addOrReplaceChild("Tentacle5", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.0F, -3.0F, 0.0F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Tentacle6", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 11.0F, -3.0F, 0.0F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Tentacle7", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, 11.0F, -3.0F, 0.0F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Tentacle8", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 2.0F, 5.0F, 0.0F, 4.7124F, 0.0F));

        root.addOrReplaceChild("Tentacle9", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, 2.0F, 2.0F, 0.0F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Tentacle10", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, 20.0F, 2.0F, 0.0F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Tentacle11", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 20.0F, 2.0F, 0.0F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Tentacle12", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 2.0F, 2.0F, 0.0F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Tentacle13", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 11.0F, 0.0F, 0.0F, 4.7124F, 0.0F));

        root.addOrReplaceChild("Tentacle14", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 11.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Tentacle15", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 20.0F, 5.0F, 0.0F, 4.7124F, 0.0F));

        root.addOrReplaceChild("Tentacle16", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 20.0F, 5.0F, 0.0F, 1.5708F, 0.0F));

        root.addOrReplaceChild("Tentacle17", CubeListBuilder.create().texOffs(52, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 6.0F, 0.0F));

        root.addOrReplaceChild("Tentacle18", CubeListBuilder.create().texOffs(11, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 17.0F, 5.0F));

        root.addOrReplaceChild("Tentacle19", CubeListBuilder.create().texOffs(11, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 6.0F, 5.0F));

        root.addOrReplaceChild("Tentacle20", CubeListBuilder.create().texOffs(11, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 6.0F, 5.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
    }
}