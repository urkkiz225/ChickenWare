package me.ionar.salhack.util.render;

import me.ionar.salhack.managers.ImageManager;
import me.ionar.salhack.util.MathUtil;
import me.ionar.salhack.util.Timer;
import me.ionar.salhack.util.imgs.SalDynamicTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.lwjgl.opengl.GL11.*;

//Warning, this is the result of late-night pasting. Good luck reading the code.

/**
 * Renders particles
 *
 * @author brudin
 * @version 1.0
 * @since 1/5/14
 * https://github.com/XxlunimexX/Huzuni-1.11
 */

public class ParticleRenderer {

    private static SalDynamicTexture particlesImage = ImageManager.Get().GetDynamicTexture("particles");
    private static SalDynamicTexture texture;

    private static final Random random = new Random();

    private static int width, height;

    private static final Timer timer = new Timer();

    private static final List<Particle> particles = new ArrayList<>();

    public ParticleRenderer(int width, int height){
        this.width = width;
        this.height = height;
    }

    /**
     * Renders the skybox in the main menu
     */
    public static void renderParticles() {
        RenderUtil.drawRect(0, 0, width, height, 0x6F000000);
        if (timer.passed(15)) {
            spawnParticles(0, 0, width, height, 55F, 15F);
            timer.reset();
        }
    }

    public void updateSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static void updateParticles() {
        for (int i = 0; i < particles.size(); i++) {
            Particle particle = particles.get(i);
            particle.update();
            if (particle.life <= 0)
                particles.remove(particle);
        }
    }

    public static void spawnParticles(int spawnX, int spawnY, int dispurseX, int dispurseY, float velocity, float gravity) {
        int startX = spawnX + random.nextInt(dispurseX),
                startY = spawnY + random.nextInt(dispurseY);
        Particle particle = new Particle(startX, startY, velocity, gravity);
        particles.add(particle);
    }

    public static void render() {
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        for (Particle particle : particles) {
            particle.applyPhysics();
            new GlStateManager().pushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(particlesImage.GetResourceLocation());
            float scale = ((particle.life) / (getMaxLife())) / 5;
            glScalef(scale, scale, scale);
            GlStateManager.color(1F, 1F, 1F, ((particle.life) / (getMaxLife())) / 5);
            renderTexture(320, 32, particle.x * (1F / scale), particle.y * (1F / scale), 32, 32, (320 - (MathUtil.ceil(particle.life / (getMaxLife() / 10F)) * 32)), 0, 32, 32);
            new GlStateManager().popMatrix();
        }
    }

    public static void bindTexture(SalDynamicTexture textureName, float x, float y, float width, float height, float u, float v, float t, float s) {
        Minecraft.getMinecraft().renderEngine.bindTexture(textureName.GetResourceLocation());
        GlStateManager.enableTexture2D();
        renderMenu(x, y,width, height, u, v, t, s);
    }

    private static void renderMenu(float x, float y, float width, float height, float u, float v, float t, float s) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder renderer = tessellator.getBuffer();
        renderer.begin(GL_TRIANGLES, DefaultVertexFormats.POSITION_TEX);
        renderer.pos(x + width, y, 0F).tex(t, v).endVertex();
        renderer.pos(x, y, 0F).tex(u, v).endVertex();
        renderer.pos(x, y + height, 0F).tex(u, s).endVertex();
        renderer.pos(x, y + height, 0F).tex(u, s).endVertex();
        renderer.pos(x + width, y + height, 0F).tex(t, s).endVertex();
        renderer.pos(x + width, y, 0F).tex(t, v).endVertex();
        tessellator.draw();
    }

    private static void renderTexture(int textureWidth, int textureHeight, float x, float y, float width, float height, float srcX, float srcY, float srcWidth, float srcHeight) {
        float renderSRCX = srcX / textureWidth,
                renderSRCY = srcY / textureHeight,
                renderSRCWidth = (srcWidth) / textureWidth,
                renderSRCHeight = (srcHeight) / textureHeight;
        glBegin(GL_TRIANGLES);
        glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY);
        glVertex2d(x + width, y);
        glTexCoord2f(renderSRCX, renderSRCY);
        glVertex2d(x, y);
        glTexCoord2f(renderSRCX, renderSRCY + renderSRCHeight);
        glVertex2d(x, y + height);
        glTexCoord2f(renderSRCX, renderSRCY + renderSRCHeight);
        glVertex2d(x, y + height);
        glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY + renderSRCHeight);
        glVertex2d(x + width, y + height);
        glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY);
        glVertex2d(x + width, y);
        glEnd();
    }

    private static class Particle {
        float life, x, y,
                motionX, motionY, gravity;

        private Particle(float x, float y, float velocity, float gravity) {
            this.x = x;
            this.y = y;
            this.motionX = random.nextFloat() * velocity;
            this.motionY = random.nextFloat() * velocity;
            if (random.nextBoolean()) motionX = -motionX;
            if (random.nextBoolean()) motionY = -motionY;
            this.life = getMaxLife();
            this.gravity = gravity;
        }

        private void applyPhysics() {
            x += motionX * 0.1F;
            y += motionY * 0.1F;
            motionX *= 0.99F;
            motionY *= 0.99F;
            y += gravity * 0.1F;
        }

        private void update() {
            life -= random.nextFloat() * 2;
        }
    }

    private static int getMaxLife() {
        return 50;
    }

}
