package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelBiphron;
import divinerpg.objects.entities.entity.vethea.EntityBiphron;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderBiphron extends RenderLiving<EntityBiphron> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/biphron.png");

    public RenderBiphron(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBiphron(), 1F);

    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBiphron entity) {
        return texture;
    }


	}