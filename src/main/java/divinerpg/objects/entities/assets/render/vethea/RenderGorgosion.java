package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelGorgosion;
import divinerpg.objects.entities.entity.vethea.EntityGorgosion;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderGorgosion extends RenderLiving<EntityGorgosion> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/gorgosion.png");

    public RenderGorgosion(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelGorgosion(), 1F);

    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityGorgosion entity) {
        return texture;
    }


	}