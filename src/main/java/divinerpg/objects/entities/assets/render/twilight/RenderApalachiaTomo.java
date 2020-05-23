package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelTomo;
import divinerpg.objects.entities.entity.twilight.EntityApalachiaTomo;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderApalachiaTomo extends RenderLiving<EntityApalachiaTomo> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/apalachia_tomo.png");

    public RenderApalachiaTomo(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelTomo(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityApalachiaTomo entity) {
        return texture;
    }

}