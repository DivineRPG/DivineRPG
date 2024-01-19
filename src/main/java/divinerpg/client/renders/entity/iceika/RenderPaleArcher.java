package divinerpg.client.renders.entity.iceika;

import divinerpg.DivineRPG;
import divinerpg.client.models.iceika.ModelPaleArcher;
import divinerpg.client.renders.layer.PaleArcherBowLayer;
import divinerpg.entities.iceika.EntityPaleArcher;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderPaleArcher extends MobRenderer<EntityPaleArcher, ModelPaleArcher<EntityPaleArcher>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/pale_archer.png");

    public RenderPaleArcher(EntityRendererProvider.Context context) {
        super(context, new ModelPaleArcher<>(context), 0.5F);
        this.addLayer(new PaleArcherBowLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntityPaleArcher entity) {
        return TEXTURE;
    }

}