package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelCadillion;
import divinerpg.objects.entities.entity.twilight.EntityApalachiaCadillion;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderApalachiaCadillion extends RenderLiving<EntityApalachiaCadillion> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/apalachia_cadillion.png");

    public RenderApalachiaCadillion(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCadillion(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityApalachiaCadillion entity) {
        return texture;
    }

}