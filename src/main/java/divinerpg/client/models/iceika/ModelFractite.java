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
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;

public class ModelFractite<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("fractite");
    private final ModelPart frostBody;
    private final ModelPart shard1;
    private final ModelPart shard2;
    private final ModelPart shard7;
    private final ModelPart shard8;
    private final ModelPart shard4;
    private final ModelPart shard3;
    private final ModelPart shard5;
    private final ModelPart shard6;

    public ModelFractite(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.frostBody = rootPart.getChild("frostBody");
        this.shard1 = rootPart.getChild("shard1");
        this.shard2 = rootPart.getChild("shard2");
        this.shard7 = rootPart.getChild("shard7");
        this.shard8 = rootPart.getChild("shard8");
        this.shard4 = rootPart.getChild("shard4");
        this.shard3 = rootPart.getChild("shard3");
        this.shard5 = rootPart.getChild("shard5");
        this.shard6 = rootPart.getChild("shard6");
    }

    public ModelFractite(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);

        root.addOrReplaceChild("frostBody", CubeListBuilder.create().texOffs(0, 11).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 5.0F, -4.0F));

        root.addOrReplaceChild("shard1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(8.0F, 0.0F, 0.0F, 9.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 8.0F, -2.0F, 0.0F, 0.0F, -0.7854F));

        root.addOrReplaceChild("shard2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-19.0F, 0.0F, 0.0F, 9.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 9.0F, -2.0F, 0.0F, 0.0F, -0.7854F));

        root.addOrReplaceChild("shard7", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(10.0F, 0.0F, 0.0F, 10.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 9.0F, -2.0F, 0.0F, 0.0F, 0.7854F));

        root.addOrReplaceChild("shard8", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-19.0F, 0.0F, 0.0F, 10.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 9.0F, -2.0F, 0.0F, 0.0F, 0.7854F));

        root.addOrReplaceChild("shard4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-6.0F, -8.0F, 0.0F, 15.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, -2.0F, 0.0F, 0.0F, 1.5708F));

        root.addOrReplaceChild("shard3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-7.0F, 7.0F, 0.0F, 15.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 9.0F, -2.0F, 0.0F, 0.0F, 1.5708F));

        root.addOrReplaceChild("shard5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, -7.0F, 0.0F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 9.0F, -2.0F));

        root.addOrReplaceChild("shard6", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-7.0F, 7.0F, 0.0F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 9.0F, -2.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);

        float ageInTicks = state.ageInTicks;

        this.shard1.xRot = Mth.cos(ageInTicks * 0.1F) * (float) Math.PI;
        this.shard2.xRot = Mth.cos(ageInTicks * 0.1F) * (float) Math.PI;
        this.shard3.xRot = Mth.cos(ageInTicks * 0.1F) * (float) Math.PI;
        this.shard4.xRot = Mth.cos(ageInTicks * 0.1F) * (float) Math.PI;
        this.shard5.xRot = Mth.cos(ageInTicks * 0.1F) * (float) Math.PI;
        this.shard6.xRot = Mth.cos(ageInTicks * 0.1F) * (float) Math.PI;
        this.shard7.xRot = Mth.cos(ageInTicks * 0.1F) * (float) Math.PI;
        this.shard8.xRot = Mth.cos(ageInTicks * 0.1F) * (float) Math.PI;
    }
}