package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.client.renders.layer.*;
import divinerpg.entities.vanilla.overworld.EntityJackOMan;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderJackOMan extends MobRenderer<EntityJackOMan, HumanoidModel<EntityJackOMan>> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/jack_o_man.png");

    public RenderJackOMan(Context context) {
        super(context, new HumanoidModel<EntityJackOMan>(context.bakeLayer(ModelLayers.PLAYER)), 0.8F);
        this.addLayer(new JackOManHeadLayer(this));
        this.addLayer(new JackOManScytheLayer(this));
    }
    public ResourceLocation getTextureLocation(EntityJackOMan entity) {
        return TEXTURE;
    }
}
