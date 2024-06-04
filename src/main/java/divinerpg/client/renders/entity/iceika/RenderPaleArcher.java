package divinerpg.client.renders.entity.iceika;

import divinerpg.DivineRPG;
import divinerpg.client.models.iceika.ModelPaleArcher;
import divinerpg.entities.iceika.EntityPaleArcher;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderPaleArcher extends HumanoidMobRenderer<EntityPaleArcher, ModelPaleArcher> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/pale_archer.png");
    public RenderPaleArcher(EntityRendererProvider.Context context) {
        super(context, new ModelPaleArcher(context.bakeLayer(ModelPaleArcher.LAYER_LOCATION)), .5F);
    }
    @Override public ResourceLocation getTextureLocation(EntityPaleArcher entity) {return TEXTURE;}
}