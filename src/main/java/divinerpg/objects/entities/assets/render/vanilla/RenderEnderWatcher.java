package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelEnderWatcher;
import divinerpg.objects.entities.entity.vanilla.EntityEnderWatcher;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderEnderWatcher extends RenderLiving<EntityEnderWatcher> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/ender_watcher.png");

    public RenderEnderWatcher(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelEnderWatcher(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityEnderWatcher entity) {
        return texture;
    }
}