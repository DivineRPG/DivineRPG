package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelBehemoth;
import divinerpg.objects.entities.entity.twilight.EntityBehemoth;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderBehemoth extends RenderLiving<EntityBehemoth> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/behemoth.png");

    public RenderBehemoth(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBehemoth(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBehemoth entity) {
        return texture;
    }
}