package divinerpg.client.models.vanilla;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

import static divinerpg.utils.Utils.createLocation;


public class ModelWatcher extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("watcher");

    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart tentacle11;
    private final ModelPart tentacle12;
    private final ModelPart tentacle21;
    private final ModelPart tentacle22;
    private final ModelPart tentacle31;
    private final ModelPart tentacle32;

    public ModelWatcher(ModelPart root) {
        super(root);
        this.head = root.getChild("Head");
        this.jaw = root.getChild("Jaw");
        this.tentacle11 = root.getChild("Tentacle11");
        this.tentacle12 = root.getChild("Tentacle12");
        this.tentacle21 = root.getChild("Tentacle21");
        this.tentacle22 = root.getChild("Tentacle22");
        this.tentacle31 = root.getChild("Tentacle31");
        this.tentacle32 = root.getChild("Tentacle32");
    }

    public ModelWatcher(EntityRendererProvider.Context context) {
        this(context.bakeLayer(LAYER_LOCATION));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 0.0F));
        head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0F, -13.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition jaw = partdefinition.addOrReplaceChild("Jaw", CubeListBuilder.create(), PartPose.offset(5.0F, 21.0F, 5.0F));
        jaw.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 3.1416F, 0.0F));

        PartDefinition tentacle11 = partdefinition.addOrReplaceChild("Tentacle11", CubeListBuilder.create(), PartPose.offset(5.0F, 16.0F, 0.0F));
        tentacle11.addOrReplaceChild("Tentacle11_r1", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -9.0F, 1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 8.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition tentacle12 = partdefinition.addOrReplaceChild("Tentacle12", CubeListBuilder.create(), PartPose.offset(9.0F, 16.0F, 0.0F));
        tentacle12.addOrReplaceChild("Tentacle12_r1", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-1.0F, -9.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-18.0F, 8.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition tentacle21 = partdefinition.addOrReplaceChild("Tentacle21", CubeListBuilder.create(), PartPose.offset(-5.0F, 16.0F, 0.0F));
        tentacle21.addOrReplaceChild("Tentacle21_r1", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-1.0F, -9.0F, 1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 8.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition tentacle22 = partdefinition.addOrReplaceChild("Tentacle22", CubeListBuilder.create(), PartPose.offset(-9.0F, 16.0F, 0.0F));
        tentacle22.addOrReplaceChild("Tentacle22_r1", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-1.0F, -9.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(18.0F, 8.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition tentacle31 = partdefinition.addOrReplaceChild("Tentacle31", CubeListBuilder.create(), PartPose.offset(0.0F, 11.0F, 0.0F));
        tentacle31.addOrReplaceChild("Tentacle31_r1", CubeListBuilder.create().texOffs(52, 0).mirror().addBox(-1.0F, -16.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 13.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition tentacle32 = partdefinition.addOrReplaceChild("Tentacle32", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, 0.0F));
        tentacle32.addOrReplaceChild("Tentacle32_r1", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -18.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 17.0F, -3.0F, 0.0F, 1.5708F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(LivingEntityRenderState state) {
        super.setupAnim(state);
        this.jaw.xRot = Mth.cos(state.ageInTicks * 0.3F) * Mth.PI * 0.0417F;
    }
}