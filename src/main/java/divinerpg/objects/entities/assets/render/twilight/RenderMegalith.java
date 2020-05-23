package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelMegalith;
import divinerpg.objects.entities.entity.twilight.EntityMegalith;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderMegalith extends RenderLiving<EntityMegalith> {
    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/megalith.png");

    public RenderMegalith(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelMegalith(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMegalith entity) {
        return texture;
    }
}