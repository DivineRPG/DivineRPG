package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelCryptKeeper;
import divinerpg.objects.entities.entity.vethea.EntityCryptKeeper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderCryptKeeper extends RenderLiving<EntityCryptKeeper> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/crypt_keeper.png");

    public RenderCryptKeeper(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCryptKeeper(), 1F);
    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCryptKeeper entity) {
        return texture;
    }

	}