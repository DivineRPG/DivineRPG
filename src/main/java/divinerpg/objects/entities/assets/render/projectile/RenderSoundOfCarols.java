package divinerpg.objects.entities.assets.render.projectile;

import divinerpg.objects.entities.entity.projectiles.EntitySoundOfCarols;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSoundOfCarols extends RenderProjectile<EntitySoundOfCarols> {
    private ResourceLocation TEXTURE = new ResourceLocation("divinerpg:textures/projectiles/music.png");

    public RenderSoundOfCarols(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.bindTexture(TEXTURE);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySoundOfCarols entity) {
        return TEXTURE;
    }
}
