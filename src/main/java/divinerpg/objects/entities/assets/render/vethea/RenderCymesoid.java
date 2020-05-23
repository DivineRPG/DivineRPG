package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelCymesoid;
import divinerpg.objects.entities.entity.vethea.EntityCymesoid;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderCymesoid extends RenderLiving<EntityCymesoid> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/cymesoid.png");

    public RenderCymesoid(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCymesoid(), 1F);

    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCymesoid entity) {
        return texture;
    }


	}