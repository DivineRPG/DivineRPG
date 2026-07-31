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
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

import static divinerpg.utils.Utils.createLocation;

public class ModelSeimer<S extends LivingEntityRenderState> extends EntityModel<S> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("seimer");
    private final ModelPart body;
    private final ModelPart headtop;
    private final ModelPart headbottom;
    private final ModelPart headright;
    private final ModelPart headleft;
    private final ModelPart hornright;
    private final ModelPart hornright2;
    private final ModelPart sensorright2;
    private final ModelPart sensorleft;
    private final ModelPart wingright;
    private final ModelPart wingleft;
    private final ModelPart wingleft1;
    private final ModelPart wingright2;
    private final ModelPart hornleft;
    private final ModelPart sensorright;
    private final ModelPart hornleft2;
    private final ModelPart sensorleft2;

    public ModelSeimer(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public ModelSeimer(ModelPart root) {
        super(root);
        ModelPart rootPart = root.getChild("root");
        this.body = rootPart.getChild("body");
        this.headtop = rootPart.getChild("headtop");
        this.headbottom = rootPart.getChild("headbottom");
        this.headright = rootPart.getChild("headright");
        this.headleft = rootPart.getChild("headleft");
        this.hornright = rootPart.getChild("hornright");
        this.hornright2 = rootPart.getChild("hornright2");
        this.sensorright2 = rootPart.getChild("sensorright2");
        this.sensorleft = rootPart.getChild("sensorleft");
        this.wingright = rootPart.getChild("wingright");
        this.wingleft = rootPart.getChild("wingleft");
        this.wingleft1 = rootPart.getChild("wingleft1");
        this.wingright2 = rootPart.getChild("wingright2");
        this.hornleft = rootPart.getChild("hornleft");
        this.sensorright = rootPart.getChild("sensorright");
        this.hornleft2 = rootPart.getChild("hornleft2");
        this.sensorleft2 = rootPart.getChild("sensorleft2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);

        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(0.0F, 0.0F, 0.0F, 16.0F, 9.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, 10.0F, -8.0F, 0.0F, -1.5708F, 0.0F));

        root.addOrReplaceChild("headtop", CubeListBuilder.create().texOffs(15, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, 10.0F, -10.0F, 0.0F, -1.5708F, 0.0F));

        root.addOrReplaceChild("headbottom", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 16.0F, -10.0F, 0.0F, -1.5708F, 0.0F));

        root.addOrReplaceChild("headright", CubeListBuilder.create().texOffs(54, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 12.0F, -10.0F, 0.0F, -1.5708F, 0.0F));

        root.addOrReplaceChild("headleft", CubeListBuilder.create().texOffs(54, 0).mirror().addBox(0.0F, -1.0F, 0.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 13.0F, -10.0F, 0.0F, -1.5708F, 0.0F));

        root.addOrReplaceChild("hornright", CubeListBuilder.create().texOffs(0, 12).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 4.0F, -3.0F, 0.0F, -1.5708F, 0.0F));

        root.addOrReplaceChild("hornright2", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 4.0F, -3.0F, 0.0F, -1.5708F, 0.0F));

        root.addOrReplaceChild("sensorright2", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 4.0F, -9.0F, 0.0F, -1.5708F, 0.0F));

        root.addOrReplaceChild("sensorleft", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 4.0F, -9.0F, 0.0F, -1.5708F, 0.0F));

        root.addOrReplaceChild("wingright", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 16.0F, -6.0F, 0.0F, -1.5708F, 0.0F));

        root.addOrReplaceChild("wingleft", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(16.0F, 16.0F, -6.0F, 0.0F, -1.5708F, 0.0F));

        root.addOrReplaceChild("wingleft1", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(16.0F, 12.0F, -6.0F, 0.0F, -1.5708F, 0.0F));

        root.addOrReplaceChild("wingright2", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 12.0F, -6.0F, 0.0F, -1.5708F, 0.0F));

        root.addOrReplaceChild("hornleft", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 4.0F, -3.0F, 0.0F, -1.5708F, 0.0F));

        root.addOrReplaceChild("sensorright", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 4.0F, -9.0F, 0.0F, -1.5708F, 0.0F));

        root.addOrReplaceChild("hornleft2", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 4.0F, -3.0F, 0.0F, -1.5708F, 0.0F));

        root.addOrReplaceChild("sensorleft2", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 4.0F, -9.0F, 0.0F, -1.5708F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(S state) {
        super.setupAnim(state);
    }
}