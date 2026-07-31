package divinerpg.client.models.boss;

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

public class ModelHiveQueen<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("hive_queen");

    private final ModelPart shape1;
    private final ModelPart shape2;
    private final ModelPart shape3;
    private final ModelPart shape4;
    private final ModelPart shape5;
    private final ModelPart shape6;
    private final ModelPart shape7;
    private final ModelPart shape8;
    private final ModelPart shape9;
    private final ModelPart shape10;
    private final ModelPart shape11;
    private final ModelPart shape12;
    private final ModelPart shape13;
    private final ModelPart shape14;
    private final ModelPart shape15;
    private final ModelPart shape16;
    private final ModelPart shape17;
    private final ModelPart shape18;
    private final ModelPart shape19;
    private final ModelPart shape30;
    private final ModelPart shape31;
    private final ModelPart shape32;
    private final ModelPart shape33;

    public ModelHiveQueen(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelHiveQueen(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.shape1 = rootPart.getChild("Shape1");
        this.shape2 = rootPart.getChild("Shape2");
        this.shape3 = rootPart.getChild("Shape3");
        this.shape4 = rootPart.getChild("Shape4");
        this.shape5 = rootPart.getChild("Shape5");
        this.shape6 = rootPart.getChild("Shape6");
        this.shape7 = rootPart.getChild("Shape7");
        this.shape8 = rootPart.getChild("Shape8");
        this.shape9 = rootPart.getChild("Shape9");
        this.shape10 = rootPart.getChild("Shape10");
        this.shape11 = rootPart.getChild("Shape11");
        this.shape12 = rootPart.getChild("Shape12");
        this.shape13 = rootPart.getChild("Shape13");
        this.shape14 = rootPart.getChild("Shape14");
        this.shape15 = rootPart.getChild("Shape15");
        this.shape16 = rootPart.getChild("Shape16");
        this.shape17 = rootPart.getChild("Shape17");
        this.shape18 = rootPart.getChild("Shape18");
        this.shape19 = rootPart.getChild("Shape19");
        this.shape30 = rootPart.getChild("Shape30");
        this.shape31 = rootPart.getChild("Shape31");
        this.shape32 = rootPart.getChild("Shape32");
        this.shape33 = rootPart.getChild("Shape33");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);
        CubeDeformation cubedef = new CubeDeformation(0.0F);

        root.addOrReplaceChild("Shape1", CubeListBuilder.create().texOffs(24, 12).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, 10.0F, cubedef).mirror(false), PartPose.offset(-5.0F, 14.0F, -5.0F));

        root.addOrReplaceChild("Shape2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(5.0F, 19.0F, -2.0F, 0.0F, 0.0F, -2.2689F));

        root.addOrReplaceChild("Shape3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, 19.0F, 1.0F, 4.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 19.0F, -2.0F, 0.0F, 0.0F, -1.9199F));

        root.addOrReplaceChild("Shape4", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(6.0F, 22.0F, 2.0F, 2.0F, 6.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 17.0F, -2.0F, 0.0F, 0.0F, -1.5708F));

        root.addOrReplaceChild("Shape5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(1.0F, -4.0F, 1.0F, 4.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 14.0F, -2.0F, 0.0F, 0.0F, -1.1345F));

        root.addOrReplaceChild("Shape6", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 14.0F, -2.0F, 0.0F, 0.0F, -0.7854F));

        root.addOrReplaceChild("Shape7", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(3.0F, -8.0F, 2.0F, 2.0F, 6.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 14.0F, -2.0F, 0.0F, 0.0F, -1.4835F));

        root.addOrReplaceChild("Shape8", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(3.0F, -8.0F, 2.0F, 2.0F, 6.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 21.0F, 10.0F, 0.0F, 2.0944F, -2.2689F));

        root.addOrReplaceChild("Shape9", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(1.0F, -4.0F, 1.0F, 2.0F, 6.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(6.0F, 21.0F, -1.0F, 0.0F, -2.618F, -2.618F));

        root.addOrReplaceChild("Shape10", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(6.0F, 21.0F, -1.0F, 0.0F, -2.618F, -2.2689F));

        root.addOrReplaceChild("Shape11", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(16.0F, 16.0F, 2.0F, 2.0F, 6.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 21.0F, -3.0F, 0.0F, 0.0F, -0.8727F));

        root.addOrReplaceChild("Shape12", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(8.0F, 17.0F, 1.0F, 4.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 21.0F, -3.0F, 0.0F, 0.0F, -1.2217F));

        root.addOrReplaceChild("Shape13", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(5.0F, 21.0F, -3.0F, 0.0F, 0.0F, -1.5708F));

        root.addOrReplaceChild("Shape14", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 21.0F, 10.0F, 0.0F, 2.0944F, -1.5708F));

        root.addOrReplaceChild("Shape15", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(1.0F, -4.0F, 1.0F, 4.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(2.0F, 21.0F, 10.0F, 0.0F, 2.0944F, -1.9199F));

        root.addOrReplaceChild("Shape16", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-4.0F, 21.0F, -4.0F, 0.0F, -0.5236F, -2.2689F));

        root.addOrReplaceChild("Shape17", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(1.0F, -4.0F, 1.0F, 2.0F, 6.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-4.0F, 21.0F, -4.0F, 0.0F, -0.5236F, -2.618F));

        root.addOrReplaceChild("Shape18", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 21.0F, -3.0F, 0.0F, 0.0F, -1.5708F));

        root.addOrReplaceChild("Shape19", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(1.0F, -4.0F, 1.0F, 4.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 21.0F, -3.0F, 0.0F, 0.0F, -1.9199F));

        root.addOrReplaceChild("Shape30", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(3.0F, -8.0F, 2.0F, 2.0F, 6.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-11.0F, 21.0F, -3.0F, 0.0F, 0.0F, -2.2689F));

        root.addOrReplaceChild("Shape31", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-9.0F, 21.0F, 7.0F, 0.0F, 1.0472F, -1.5708F));

        root.addOrReplaceChild("Shape32", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(1.0F, -4.0F, 1.0F, 4.0F, 6.0F, 4.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-9.0F, 21.0F, 7.0F, 0.0F, 1.0472F, -1.9199F));

        root.addOrReplaceChild("Shape33", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(3.0F, -8.0F, 2.0F, 2.0F, 6.0F, 2.0F, cubedef).mirror(false), PartPose.offsetAndRotation(-9.0F, 21.0F, 7.0F, 0.0F, 1.0472F, -2.2689F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
    }
}