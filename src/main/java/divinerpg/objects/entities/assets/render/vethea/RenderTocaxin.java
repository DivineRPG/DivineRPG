package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelTocaxin;
import divinerpg.objects.entities.entity.vethea.EntityTocaxin;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderTocaxin extends RenderLiving<EntityTocaxin> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/tocaxin.png");

    public RenderTocaxin(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelTocaxin(), 1F);

    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityTocaxin entity) {
        return texture;
    }


	}