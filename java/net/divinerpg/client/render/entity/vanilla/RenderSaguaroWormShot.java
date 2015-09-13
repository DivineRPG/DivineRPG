package net.divinerpg.client.render.entity.vanilla;

import net.divinerpg.client.render.entity.vanilla.model.ModelSaguaroWormShot;
import net.divinerpg.entities.vanilla.projectile.EntityShooterBullet;
import net.divinerpg.libs.Reference;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class RenderSaguaroWormShot extends Render {

    private ModelSaguaroWormShot model = new ModelSaguaroWormShot();

    @Override
    public void doRender(Entity projectile, double x, double y, double z, float par8, float par9) {
        GL11.glPushMatrix();
        this.bindEntityTexture(projectile);
        GL11.glTranslatef((float) x, (float) y, (float) z);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        model.renderAll();
        GL11.glPopMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return new ResourceLocation(Reference.PREFIX+"textures/projectiles/saguaroWorm.png");
    }
}