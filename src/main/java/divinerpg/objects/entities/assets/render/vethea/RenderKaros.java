package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelKaros;
import divinerpg.objects.entities.entity.vethea.EntityKaros;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderKaros extends RenderLiving<EntityKaros> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/karos.png");

    public RenderKaros(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelKaros(), 1F);

    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityKaros entity) {
        return texture;
    }


	}