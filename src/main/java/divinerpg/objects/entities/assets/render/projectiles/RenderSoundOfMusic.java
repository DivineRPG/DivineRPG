package divinerpg.objects.entities.assets.render.projectiles;

import divinerpg.objects.entities.entity.projectiles.EntitySoundOfMusic;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSoundOfMusic extends RenderProjectile<EntitySoundOfMusic> {
    private ResourceLocation TEXTURE = new ResourceLocation("divinerpg:textures/projectiles/music.png");

    public RenderSoundOfMusic(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.bindTexture(TEXTURE);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySoundOfMusic entity) {
        return TEXTURE;
    }
}
